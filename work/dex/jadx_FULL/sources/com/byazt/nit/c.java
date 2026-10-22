package com.byazt.nit;

import com.byazt.kh.ve;
import com.byazt.mk.da;
import com.byazt.mk.t;
import com.byazt.xb.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 510, 20})
public final class c {
    public byte[] sp;
    public byte[] x;
    public static final byte[] c = {42};
    public static final String[] tt = new String[0];
    public static final String[] ve = {"*"};
    public static final c uj = new c();
    public final AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f28831a = new CountDownLatch(1);

    public static c c() {
        return uj;
    }

    private void tt() {
        boolean z = false;
        while (true) {
            try {
                try {
                    ve();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    n.tt().c(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void ve() throws IOException {
        InputStream resourceAsStream = c.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.byazt.mk.n nVarC = t.c(new da(t.c(resourceAsStream)));
        try {
            byte[] bArr = new byte[nVarC.da()];
            nVarC.c(bArr);
            byte[] bArr2 = new byte[nVarC.da()];
            nVarC.c(bArr2);
            ve.c(nVarC);
            synchronized (this) {
                this.sp = bArr;
                this.x = bArr2;
            }
            this.f28831a.countDown();
        } catch (Throwable th) {
            ve.c(nVarC);
            throw th;
        }
    }

    public String c(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrC = c(strArrSplit);
        if (strArrSplit.length == strArrC.length && strArrC[0].charAt(0) != '!') {
            return null;
        }
        if (strArrC[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrC.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrC.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] c(String[] strArr) {
        String str;
        String strC;
        String strC2;
        if (!this.n.get() && this.n.compareAndSet(false, true)) {
            tt();
        } else {
            try {
                this.f28831a.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.sp == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(ve.n);
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= length) {
                strC = null;
                break;
            }
            strC = c(this.sp, bArr, i2);
            if (strC != null) {
                break;
            }
            i2++;
        }
        if (length <= 1) {
            strC2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i3 = 0;
        while (true) {
            if (i3 >= bArr2.length - 1) {
                strC2 = null;
                break;
            }
            bArr2[i3] = c;
            strC2 = c(this.sp, bArr2, i3);
            if (strC2 != null) {
                break;
            }
            i3++;
        }
        if (strC2 != null) {
            for (int i4 = 0; i4 < length - 1; i4++) {
                String strC3 = c(this.x, bArr, i4);
                if (strC3 != null) {
                    str = strC3;
                    break;
                }
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strC == null && strC2 == null) {
            return ve;
        }
        String[] strArrSplit = strC != null ? strC.split("\\.") : tt;
        String[] strArrSplit2 = strC2 != null ? strC2.split("\\.") : tt;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String c(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (bArr2[i10].length != i11) {
                    z2 = z;
                } else {
                    if (i10 == bArr2.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z2 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, ve.n);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }
}
