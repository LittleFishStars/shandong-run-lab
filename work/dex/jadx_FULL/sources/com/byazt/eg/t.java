package com.byazt.eg;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.b;
import com.zj.adlib.c49;
import com.zj.adlib.dv9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 66})
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28458a;
    public final boolean da;
    public final String i;
    public final String n;
    public final boolean sl;
    public final long sp;
    public final boolean t;
    public final boolean u;
    public final String x;
    public static final Pattern c = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern tt = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern ve = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern uj = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private t(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.n = str;
        this.f28458a = str2;
        this.sp = j;
        this.x = str3;
        this.i = str4;
        this.da = z;
        this.sl = z2;
        this.u = z3;
        this.t = z4;
    }

    public String c() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return tVar.n.equals(this.n) && tVar.f28458a.equals(this.f28458a) && tVar.x.equals(this.x) && tVar.i.equals(this.i) && tVar.sp == this.sp && tVar.da == this.da && tVar.sl == this.sl && tVar.t == this.t && tVar.u == this.u;
    }

    public int hashCode() {
        int iHashCode = (((((((this.n.hashCode() + 527) * 31) + this.f28458a.hashCode()) * 31) + this.x.hashCode()) * 31) + this.i.hashCode()) * 31;
        long j = this.sp;
        return ((((((((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.da ? 1 : 0)) * 31) + (!this.sl ? 1 : 0)) * 31) + (!this.t ? 1 : 0)) * 31) + (!this.u ? 1 : 0);
    }

    public String toString() {
        return c(false);
    }

    public String tt() {
        return this.f28458a;
    }

    private static boolean c(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !com.byazt.kh.ve.ve(str);
    }

    private static String tt(String str) {
        if (str.endsWith(Consts.DOT)) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(Consts.DOT)) {
            str = str.substring(1);
        }
        String strC = com.byazt.kh.ve.c(str);
        if (strC != null) {
            return strC;
        }
        throw new IllegalArgumentException();
    }

    public static t c(my myVar, String str) {
        return c(System.currentTimeMillis(), myVar, str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c0 A[PHI: r0
      0x00c0: PHI (r0v16 long) = (r0v2 long), (r0v6 long) binds: [B:42:0x00be, B:53:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    public static t c(long j, my myVar, String str) {
        long j2;
        t tVar;
        String str2;
        String str3;
        int length = str.length();
        char c2 = dv9.e;
        int iC = com.byazt.kh.ve.c(str, 0, length, dv9.e);
        char c3 = com.alipay.sdk.m.p.a.h;
        int iC2 = com.byazt.kh.ve.c(str, 0, iC, com.alipay.sdk.m.p.a.h);
        if (iC2 == iC) {
            return null;
        }
        String strVe = com.byazt.kh.ve.ve(str, 0, iC2);
        if (strVe.isEmpty() || com.byazt.kh.ve.tt(strVe) != -1) {
            return null;
        }
        String strVe2 = com.byazt.kh.ve.ve(str, iC2 + 1, iC);
        if (com.byazt.kh.ve.tt(strVe2) != -1) {
            return null;
        }
        int i = iC + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String strTt = null;
        boolean z4 = true;
        long jC = -1;
        long jC2 = 253402300799999L;
        String str4 = null;
        while (i < length) {
            int iC3 = com.byazt.kh.ve.c(str, i, length, c2);
            int iC4 = com.byazt.kh.ve.c(str, i, iC3, c3);
            String strVe3 = com.byazt.kh.ve.ve(str, i, iC4);
            String strVe4 = iC4 < iC3 ? com.byazt.kh.ve.ve(str, iC4 + 1, iC3) : "";
            if ("expires".equalsIgnoreCase(strVe3)) {
                try {
                    jC2 = c(strVe4, 0, strVe4.length());
                    z3 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if ("max-age".equalsIgnoreCase(strVe3)) {
                jC = c(strVe4);
                z3 = true;
            } else if ("domain".equalsIgnoreCase(strVe3)) {
                strTt = tt(strVe4);
                z4 = false;
            } else if ("path".equalsIgnoreCase(strVe3)) {
                str4 = strVe4;
            } else if ("secure".equalsIgnoreCase(strVe3)) {
                z = true;
            } else if ("httponly".equalsIgnoreCase(strVe3)) {
                z2 = true;
            }
            i = iC3 + 1;
            c2 = dv9.e;
            c3 = com.alipay.sdk.m.p.a.h;
        }
        long j3 = Long.MIN_VALUE;
        if (jC == Long.MIN_VALUE) {
            j2 = j3;
        } else if (jC != -1) {
            j3 = j + (jC <= 9223372036854775L ? jC * 1000 : Long.MAX_VALUE);
            if (j3 < j || j3 > 253402300799999L) {
                j2 = 253402300799999L;
            } else {
                j2 = j3;
            }
        } else {
            j2 = jC2;
        }
        String strSp = myVar.sp();
        if (strTt == null) {
            str2 = strSp;
            tVar = null;
        } else {
            if (!c(strSp, strTt)) {
                return null;
            }
            tVar = null;
            str2 = strTt;
        }
        if (strSp.length() != str2.length() && com.byazt.nit.c.c().c(str2) == null) {
            return tVar;
        }
        String strSubstring = WVNativeCallbackUtil.SEPERATER;
        if (str4 == null || !str4.startsWith(WVNativeCallbackUtil.SEPERATER)) {
            String strI = myVar.i();
            int iLastIndexOf = strI.lastIndexOf(47);
            if (iLastIndexOf != 0) {
                strSubstring = strI.substring(0, iLastIndexOf);
            }
            str3 = strSubstring;
        } else {
            str3 = str4;
        }
        return new t(strVe, strVe2, j2, str2, str3, z, z2, z4, z3);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    private static long c(String str, int i, int i2) {
        int iC = c(str, i, i2, false);
        Matcher matcher = uj.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iIndexOf = -1;
        int i6 = -1;
        int i7 = -1;
        while (iC < i2) {
            int iC2 = c(str, iC + 1, i2, true);
            matcher.region(iC, iC2);
            if (i4 == -1 && matcher.usePattern(uj).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i6 = Integer.parseInt(matcher.group(2));
                i7 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(ve).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = tt;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i3 != -1 && matcher.usePattern(c).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            } else if (i3 != -1) {
            }
            iC = c(str, iC2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 <= 0 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException();
        }
        if (i7 >= 0 && i7 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(com.byazt.kh.ve.sp);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iIndexOf - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    private static int c(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long c(String str) {
        try {
            long j = Long.parseLong(str);
            if (j <= 0) {
                return Long.MIN_VALUE;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith(c49.f40900a) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public static List<t> c(my myVar, rh rhVar) {
        List<String> listTt = rhVar.tt(b.D0);
        int size = listTt.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            t tVarC = c(myVar, listTt.get(i));
            if (tVarC != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(tVarC);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String c(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.n);
        sb.append(com.alipay.sdk.m.p.a.h);
        sb.append(this.f28458a);
        if (this.t) {
            if (this.sp == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(com.byazt.yx.uj.c(new Date(this.sp)));
            }
        }
        if (!this.u) {
            sb.append("; domain=");
            if (z) {
                sb.append(Consts.DOT);
            }
            sb.append(this.x);
        }
        sb.append("; path=");
        sb.append(this.i);
        if (this.da) {
            sb.append("; secure");
        }
        if (this.sl) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
