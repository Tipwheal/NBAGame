package com.tipwheal.obscurephoton.util

class RandomUtil {

    static Random random = new Random(seed: 2333)

    static int randomInt(int start, int end) {
        random.nextInt(end - start) + start
    }
}
