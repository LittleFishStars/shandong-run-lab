package com.byazt.kh;

import com.alibaba.android.arouter.utils.Consts;
import com.byazt.eg.d;
import com.byazt.eg.p;
import com.byazt.eg.rl;
import com.byazt.mk.a;
import com.byazt.mk.my;
import com.byazt.mk.n;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.zj.adlib.u15;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_MATCH_LIKE, 54})
public final class ve {
    public static final byte[] c;
    public static final p uj;
    public static final d ve;
    public static final String[] tt = new String[0];
    public static final a i = a.tt("efbbbf");
    public static final a da = a.tt("feff");
    public static final a sl = a.tt("fffe");
    public static final a t = a.tt("0000ffff");
    public static final a u = a.tt("ffff0000");
    public static final Charset n = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f28730a = Charset.forName("ISO-8859-1");
    public static final Charset yp = Charset.forName("UTF-16BE");
    public static final Charset z = Charset.forName("UTF-16LE");
    public static final Charset m = Charset.forName("UTF-32BE");
    public static final Charset nu = Charset.forName("UTF-32LE");
    public static final TimeZone sp = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> x = new Comparator<String>() { // from class: com.byazt.kh.ve.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    public static final Pattern rh = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        ve = d.c(null, bArr);
        uj = p.c((rl) null, bArr);
    }

    public static int c(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static void c(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean tt(my myVar, int i2, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jO_ = myVar.c().ve() ? myVar.c().o_() - jNanoTime : Long.MAX_VALUE;
        myVar.c().c(Math.min(jO_, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            com.byazt.mk.ve veVar = new com.byazt.mk.ve();
            while (myVar.c(veVar, 8192L) != -1) {
                veVar.rh();
            }
            if (jO_ == Long.MAX_VALUE) {
                myVar.c().a();
                return true;
            }
            myVar.c().c(jNanoTime + jO_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jO_ == Long.MAX_VALUE) {
                myVar.c().a();
                return false;
            }
            myVar.c().c(jNanoTime + jO_);
            return false;
        } catch (Throwable th) {
            if (jO_ == Long.MAX_VALUE) {
                myVar.c().a();
            } else {
                myVar.c().c(jNanoTime + jO_);
            }
            throw th;
        }
    }

    private static boolean uj(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String ve(String str, int i2, int i3) {
        int iC = c(str, i2, i3);
        return str.substring(iC, tt(str, iC, i3));
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x004f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0059 A[LOOP:1: B:30:0x004d->B:33:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x005f A[EDGE_INSN: B:58:0x005f->B:34:0x005f BREAK  A[LOOP:1: B:30:0x004d->B:33:0x0059], SYNTHETIC] */
    private static InetAddress uj(String str, int i2, int i3) {
        int i4;
        int i5;
        int iC;
        byte[] bArr = new byte[16];
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (i2 < i3) {
            if (i6 == 16) {
                return null;
            }
            int i9 = i2 + 2;
            if (i9 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                if (i7 != -1) {
                    return null;
                }
                i6 += 2;
                i7 = i6;
                if (i9 == i3) {
                    break;
                }
                i8 = i9;
                i4 = 0;
                i2 = i8;
                while (i2 < i3) {
                    iC = c(str.charAt(i2));
                    if (iC != -1) {
                        break;
                        break;
                    }
                    i4 = (i4 << 4) + iC;
                    i2++;
                }
                i5 = i2 - i8;
                if (i5 != 0) {
                }
                return null;
            }
            if (i6 != 0) {
                if (!str.regionMatches(i2, u15.f19942b, 0, 1)) {
                    if (!str.regionMatches(i2, Consts.DOT, 0, 1) || !c(str, i8, i3, bArr, i6 - 2)) {
                        return null;
                    }
                    i6 += 2;
                    break;
                }
                i2++;
            }
            i8 = i2;
            i4 = 0;
            i2 = i8;
            while (i2 < i3) {
                iC = c(str.charAt(i2));
                if (iC != -1) {
                    break;
                }
                i4 = (i4 << 4) + iC;
                i2++;
            }
            i5 = i2 - i8;
            if (i5 != 0 || i5 > 4) {
                return null;
            }
            int i10 = i6 + 1;
            bArr[i6] = (byte) ((i4 >>> 8) & 255);
            i6 = i10 + 1;
            bArr[i10] = (byte) (i4 & 255);
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i11 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static boolean ve(String str) {
        return rh.matcher(str).matches();
    }

    public static void c(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!c(e)) {
                    throw e;
                }
            } catch (RuntimeException unused) {
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean c(my myVar, int i2, TimeUnit timeUnit) {
        try {
            return tt(myVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> c(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> c(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory c(final String str, final boolean z2) {
        return new ThreadFactory() { // from class: com.byazt.kh.ve.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(runnable, "csj_" + str);
                veVar.setDaemon(z2);
                veVar.setPriority(10);
                return veVar;
            }
        };
    }

    public static String[] c(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean tt(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String c(com.byazt.eg.my myVar, boolean z2) {
        String strSp;
        if (myVar.sp().contains(u15.f19942b)) {
            strSp = "[" + myVar.sp() + "]";
        } else {
            strSp = myVar.sp();
        }
        if (!z2 && myVar.x() == com.byazt.eg.my.c(myVar.ve())) {
            return strSp;
        }
        return strSp + u15.f19942b + myVar.x();
    }

    public static int tt(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static int tt(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int c(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] c(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int c(String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int c(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int c(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String c(String str) {
        InetAddress inetAddressUj;
        if (str.contains(u15.f19942b)) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressUj = uj(str, 1, str.length() - 1);
            } else {
                inetAddressUj = uj(str, 0, str.length());
            }
            if (inetAddressUj == null) {
                return null;
            }
            byte[] address = inetAddressUj.getAddress();
            if (address.length == 16) {
                return c(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty() || uj(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String c(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset c(n nVar, Charset charset) throws IOException {
        a aVar = i;
        if (nVar.c(0L, aVar)) {
            nVar.x(aVar.sp());
            return n;
        }
        a aVar2 = da;
        if (nVar.c(0L, aVar2)) {
            nVar.x(aVar2.sp());
            return yp;
        }
        a aVar3 = sl;
        if (nVar.c(0L, aVar3)) {
            nVar.x(aVar3.sp());
            return z;
        }
        a aVar4 = t;
        if (nVar.c(0L, aVar4)) {
            nVar.x(aVar4.sp());
            return m;
        }
        a aVar5 = u;
        if (!nVar.c(0L, aVar5)) {
            return charset;
        }
        nVar.x(aVar5.sp());
        return nu;
    }

    public static AssertionError c(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean c(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = str.charAt(i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    private static String c(byte[] bArr) {
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        com.byazt.mk.ve veVar = new com.byazt.mk.ve();
        while (i3 < bArr.length) {
            if (i3 == i2) {
                veVar.i(58);
                i3 += i5;
                if (i3 == 16) {
                    veVar.i(58);
                }
            } else {
                if (i3 > 0) {
                    veVar.i(58);
                }
                veVar.sl(((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255));
                i3 += 2;
            }
        }
        return veVar.z();
    }
}
