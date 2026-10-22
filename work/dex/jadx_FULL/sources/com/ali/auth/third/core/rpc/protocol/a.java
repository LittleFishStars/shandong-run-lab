package com.ali.auth.third.core.rpc.protocol;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(int i) {
        double dRandom;
        double d;
        String strValueOf;
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = random.nextInt(3);
            if (iNextInt != 0) {
                if (iNextInt == 1) {
                    dRandom = Math.random() * 25.0d;
                    d = 97.0d;
                } else if (iNextInt == 2) {
                    strValueOf = String.valueOf(new Random().nextInt(10));
                    stringBuffer.append(strValueOf);
                }
            } else {
                dRandom = Math.random() * 25.0d;
                d = 65.0d;
            }
            strValueOf = String.valueOf((char) Math.round(dRandom + d));
            stringBuffer.append(strValueOf);
        }
        return stringBuffer.toString();
    }
}
