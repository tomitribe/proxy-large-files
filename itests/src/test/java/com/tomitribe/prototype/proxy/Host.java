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


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Poor man's Arquillian
 */
public class Host {

    private static final Map<String, String> config = getConfig();

    public static URI get() {
        final String address = config.getOrDefault("proxy.url", "http://localhost:7000");
        return URI.create(address);
    }

    private static Map<String, String> getConfig() {
        final Map<String, String> config = new HashMap<>();
        config.putAll(System.getenv());
        for (final Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            config.put("" + entry.getKey(), "" + entry.getValue());
        }
        return config;
    }
}
