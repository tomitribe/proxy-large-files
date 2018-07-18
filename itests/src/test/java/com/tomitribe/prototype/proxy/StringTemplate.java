/*
 * Tomitribe Confidential
 *
 * Copyright Tomitribe Corporation. 2018
 *
 * The source code for this program is not published or otherwise divested
 * of its trade secrets, irrespective of what has been deposited with the
 * U.S. Copyright Office.
 */
package com.tomitribe.prototype.proxy;

import org.tomitribe.util.Join;
import org.tomitribe.util.Strings;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Forked from tomitribe-util because I was too lazy
 * to address that I needed:
 *
 * `apply(Map<String, String> map)`
 *
 * Not what is in tomitribe-util, which is:
 *
 * `apply(Map<String, Object> map)`
 *
 * This should probably fixed in tomitribe-util in some way.
 */
public class StringTemplate {

    public static final Pattern PATTERN = Pattern.compile("(\\{)((\\.|\\w)+)(})");
    private final String template;

    public StringTemplate(String template) {
        this.template = template;
    }

    public static StringTemplate of(final String template) {
        return new StringTemplate(template);
    }
    public String apply(final Map<String, String> map) {
        final Matcher matcher = PATTERN.matcher(this.template);
        final StringBuffer buf = new StringBuffer();

        while (matcher.find()) {
            final String key = matcher.group(2);
            if (key == null) {
                throw new IllegalStateException("Key is null. Template \'" + this.template + "\'");
            }

            String value = this.value(map, key);
            if (key.toLowerCase().endsWith(".lc")) {
                value = this.value(map, key.substring(0, key.length() - 3)).toLowerCase();
            } else if (key.toLowerCase().endsWith(".uc")) {
                value = this.value(map, key.substring(0, key.length() - 3)).toUpperCase();
            } else if (key.toLowerCase().endsWith(".cc")) {
                value = Strings.camelCase(this.value(map, key.substring(0, key.length() - 3)));
            }

            if (value == null) {
                throw new IllegalStateException("Value is null for key \'" + key + "\'. Template \'" + this.template + "\'. " + "Keys: " + Join.join(", ", map.keySet()));
            }

            matcher.appendReplacement(buf, value);
        }

        matcher.appendTail(buf);
        return buf.toString();
    }

    private String value(final Map<String, String> map, final String key) {
        final Object o = map.get(key);
        if (o == null) {
            throw new IllegalStateException("Missing entry " + key);
        } else {
            return o.toString();
        }
    }

    public Set<String> keys() {
        final TreeSet keys = new TreeSet();

        String key;
        for (Matcher matcher = PATTERN.matcher(this.template); matcher.find(); keys.add(key)) {
            key = matcher.group(2);
            String op = key.toLowerCase();
            if (op.endsWith(".lc") || op.endsWith(".uc") || op.endsWith(".cc")) {
                key = key.substring(0, key.length() - 3);
            }
        }

        return keys;
    }
}
