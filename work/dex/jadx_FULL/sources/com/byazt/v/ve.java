package com.byazt.v;

import com.alipay.sdk.m.y.l;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.u15;
import com.zj.adlib.y6b;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 54})
public class ve {
    public static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 24})
    public static class c {
        public int c;
        public String n;
        public int tt;
        public long uj;
        public int ve;

        private c() {
        }
    }

    public static String c(File file) {
        return c(file, 9, 8192L);
    }

    private static String tt(File file, int i, long j) throws Exception {
        return c(new com.byazt.v.c(file), i, j);
    }

    public static String c(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return tt(file, i, j);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return "";
    }

    private static long tt(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable unused) {
            throw new RuntimeException("ttmd5 decryptNum error, num = ".concat(String.valueOf(str)));
        }
    }

    public static int c(String str, File file) {
        return c(str, file, (tt) null);
    }

    public static int c(String str, File file, tt ttVar) {
        int i;
        long j;
        String strTt;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (ttVar != null) {
                if (ttVar.c() <= 0) {
                    try {
                        ttVar.tt();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                c cVarC = c(str);
                if (cVarC == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (cVarC.c > 1) {
                        return 3;
                    }
                    i = cVarC.ve;
                    j = cVarC.uj;
                }
                c cVarC2 = null;
                try {
                    if (ttVar != null) {
                        strTt = c(ttVar, i, j);
                    } else {
                        strTt = tt(file, i, j);
                    }
                } catch (Throwable th) {
                    m.c(th);
                    strTt = null;
                }
                if (strTt != null && strTt.length() != 0) {
                    if (cVarC != null && (cVarC.c != 1 || cVarC.tt != 1)) {
                        if (cVarC.n != null) {
                            try {
                                cVarC2 = c(strTt);
                            } catch (Throwable unused2) {
                            }
                            if (cVarC2 != null && cVarC.ve == cVarC2.ve && cVarC.uj == cVarC2.uj && cVarC.n.equals(cVarC2.n)) {
                                return 0;
                            }
                        }
                    } else if (strTt.equals(str)) {
                        return 0;
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static String c(tt ttVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jC = ttVar.c();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jC) / 10) {
                j2 = jC;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            c(ttVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jC - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    c(ttVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                c(ttVar, messageDigest, bArr, jC - j2, j2);
            }
            String strC = c(messageDigest.digest());
            if (i2 == 1 && j2 == jC) {
                return strC;
            }
            return c(i2, j2) + l.b + strC;
        } finally {
            try {
                ttVar.tt();
            } catch (Throwable unused) {
            }
        }
    }

    private static void c(tt ttVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        ttVar.c(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iC = ttVar.c(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iC > 0) {
                messageDigest.update(bArr, 0, iC);
                j3 += (long) iC;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iC + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    private static String c(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & 255;
                int i5 = i2 + 1;
                char[] cArr2 = c;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String c(int i, long j) {
        return "ttmd5:1:1:" + c(i) + y6b.f + c(j);
    }

    private static c c(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(l.b);
        String[] strArrSplit2 = strArrSplit[0].split(u15.f19942b);
        c cVar = new c();
        cVar.c = Integer.parseInt(strArrSplit2[1]);
        if (cVar.c > 1) {
            return cVar;
        }
        cVar.tt = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split(y6b.f);
        cVar.ve = (int) tt(strArrSplit3[0]);
        cVar.uj = tt(strArrSplit3[1]);
        cVar.n = strArrSplit[1];
        return cVar;
    }

    private static String c(long j) {
        return Long.toHexString((j << 4) + 31);
    }
}
