/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tomitribe.prototype.proxy.util;

import java.util.concurrent.ThreadLocalRandom;

public class Chance {

    public static int deviate(int average, float offset) {
        int min = (int) (average - (average * offset));
        int max = (int) (average + (average * offset));
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static long deviate(long average, float offset) {
        long min = (long) (average - (average * offset));
        long max = (long) (average + (average * offset));
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static int range(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static long range(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public boolean in(int in, int of) {
        final int result = ThreadLocalRandom.current().nextInt(of);
        return result <= in;
    }
}
