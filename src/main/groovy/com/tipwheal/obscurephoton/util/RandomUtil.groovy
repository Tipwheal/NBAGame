package com.tipwheal.obscurephoton.util

class RandomUtil {

    static Random random = new Random(seed: 2333)

    static int randomInt(int start, int end) {
        random.nextInt(end - start) + start
    }

    static int gaussianRandomInt(int start, int end) {
        def gaussian = Math.abs random.nextGaussian()
        def gap = end - start
        (start + gap * gaussian) as int
    }

    static String randomName() {
        randomChar() + randomChar() + randomChar()
    }

    static String randomChar() {
        def highPos = 176 + Math.abs(random.nextInt(71))
        def lowPos = 161 + Math.abs(random.nextInt(94))

        byte[] byteArray = new byte[2]
        byteArray[0] = highPos.byteValue()
        byteArray[1] = lowPos.byteValue()

        new String(byteArray, 'GB2312')
    }
}
