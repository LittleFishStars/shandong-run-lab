package com.byazt.gy;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 34})
public class a {
    public int[] c;
    public int[] tt;

    private a() {
    }

    public static a c(tt ttVar) throws IOException {
        ttVar.tt(1835009);
        int iTt = ttVar.tt();
        int iTt2 = ttVar.tt();
        int iTt3 = ttVar.tt();
        ttVar.tt();
        int iTt4 = ttVar.tt();
        int iTt5 = ttVar.tt();
        a aVar = new a();
        aVar.c = ttVar.c(iTt2);
        if (iTt3 != 0) {
            ttVar.c(iTt3);
        }
        int i = (iTt5 == 0 ? iTt : iTt5) - iTt4;
        if (i % 4 != 0) {
            throw new IOException();
        }
        aVar.tt = ttVar.c(i / 4);
        if (iTt5 != 0) {
            int i2 = iTt - iTt5;
            if (i2 % 4 != 0) {
                throw new IOException();
            }
            ttVar.c(i2 / 4);
        }
        return aVar;
    }

    public String c(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.c) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iC = c(this.tt, i2);
        StringBuilder sb = new StringBuilder(iC);
        while (iC != 0) {
            i2 += 2;
            sb.append((char) c(this.tt, i2));
            iC--;
        }
        return sb.toString();
    }

    private static final int c(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
