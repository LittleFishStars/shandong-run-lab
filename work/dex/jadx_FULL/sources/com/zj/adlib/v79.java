package com.zj.adlib;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class v79 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Map<String, SimpleDateFormat>> f45300a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f20191a = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f20190a = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};
    public static final String[] b = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};

    public class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        @Override // java.lang.ThreadLocal
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap();
        }
    }

    public v79() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(Date date, int i) {
        return w(date, K(), i);
    }

    public static boolean A0(long j) {
        return D0(N0(j));
    }

    public static String B(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jCurrentTimeMillis < 0) {
            return String.format("%tc", Long.valueOf(j));
        }
        if (jCurrentTimeMillis < 1000) {
            return "刚刚";
        }
        if (jCurrentTimeMillis < 60000) {
            return String.format(Locale.getDefault(), "%d秒前", Long.valueOf(jCurrentTimeMillis / 1000));
        }
        if (jCurrentTimeMillis < 3600000) {
            return String.format(Locale.getDefault(), "%d分钟前", Long.valueOf(jCurrentTimeMillis / 60000));
        }
        long jO0 = o0();
        if (j >= jO0) {
            return String.format("今天%tR", Long.valueOf(j));
        }
        return j >= jO0 - 86400000 ? String.format("昨天%tR", Long.valueOf(j)) : String.format("%tF", Long.valueOf(j));
    }

    public static boolean B0(String str) {
        return D0(V0(str, s()));
    }

    public static String C(String str) {
        return D(str, s());
    }

    public static boolean C0(String str, @NonNull DateFormat dateFormat) {
        return D0(V0(str, dateFormat));
    }

    public static String D(String str, @NonNull DateFormat dateFormat) {
        return B(Y0(str, dateFormat));
    }

    public static boolean D0(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return z0(calendar.get(1));
    }

    public static String E(Date date) {
        return B(date.getTime());
    }

    public static boolean E0() {
        return !u0();
    }

    public static long F(long j, long j2, int i) {
        return j + Z0(j2, i);
    }

    public static boolean F0(long j) {
        return !v0(j);
    }

    public static long G(String str, long j, int i) {
        return H(str, s(), j, i);
    }

    public static boolean G0(String str) {
        return !w0(str);
    }

    public static long H(String str, @NonNull DateFormat dateFormat, long j, int i) {
        return Y0(str, dateFormat) + Z0(j, i);
    }

    public static boolean H0(String str, @NonNull DateFormat dateFormat) {
        return !x0(str, dateFormat);
    }

    public static long I(Date date, long j, int i) {
        return a(date) + Z0(j, i);
    }

    public static boolean I0(Date date) {
        return !y0(date);
    }

    public static long J(long j, int i) {
        return F(L(), j, i);
    }

    public static boolean J0(long j) {
        long jO0 = o0();
        return j >= jO0 && j < jO0 + 86400000;
    }

    public static Date K() {
        return new Date();
    }

    public static boolean K0(String str) {
        return J0(Y0(str, s()));
    }

    public static long L() {
        return System.currentTimeMillis();
    }

    public static boolean L0(String str, @NonNull DateFormat dateFormat) {
        return J0(Y0(str, dateFormat));
    }

    public static String M() {
        return R0(System.currentTimeMillis(), s());
    }

    public static boolean M0(Date date) {
        return J0(date.getTime());
    }

    public static String N(@NonNull DateFormat dateFormat) {
        return R0(System.currentTimeMillis(), dateFormat);
    }

    public static Date N0(long j) {
        return new Date(j);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static SimpleDateFormat O(String str) {
        Map<String, SimpleDateFormat> map = f45300a.get();
        SimpleDateFormat simpleDateFormat = map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String O0(long j, int i) {
        if (i <= 0) {
            return null;
        }
        int iMin = Math.min(i, 5);
        String[] strArr = {"天", "小时", "分钟", "秒", "毫秒"};
        if (j == 0) {
            return 0 + strArr[iMin - 1];
        }
        StringBuilder sb = new StringBuilder();
        if (j < 0) {
            sb.append(c49.f40900a);
            j = -j;
        }
        int[] iArr = {86400000, 3600000, 60000, 1000, 1};
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = iArr[i2];
            if (j >= i3) {
                long j2 = j / ((long) i3);
                j -= ((long) i3) * j2;
                sb.append(j2);
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }

    public static String P(long j, long j2, int i) {
        return Q(j, s(), j2, i);
    }

    public static String P0(long j) {
        return R0(j, s());
    }

    public static String Q(long j, @NonNull DateFormat dateFormat, long j2, int i) {
        return R0(j + Z0(j2, i), dateFormat);
    }

    public static String Q0(long j, @NonNull String str) {
        return R0(j, O(str));
    }

    public static String R(String str, long j, int i) {
        return S(str, s(), j, i);
    }

    public static String R0(long j, @NonNull DateFormat dateFormat) {
        return dateFormat.format(new Date(j));
    }

    public static String S(String str, @NonNull DateFormat dateFormat, long j, int i) {
        return R0(Y0(str, dateFormat) + Z0(j, i), dateFormat);
    }

    public static long S0(long j, int i) {
        return j / ((long) i);
    }

    public static String T(Date date, long j, int i) {
        return U(date, s(), j, i);
    }

    public static Date T0(String str) {
        return V0(str, s());
    }

    public static String U(Date date, @NonNull DateFormat dateFormat, long j, int i) {
        return R0(a(date) + Z0(j, i), dateFormat);
    }

    public static Date U0(String str, @NonNull String str2) {
        return V0(str, O(str2));
    }

    public static String V(long j, int i) {
        return W(j, s(), i);
    }

    public static Date V0(String str, @NonNull DateFormat dateFormat) {
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String W(long j, @NonNull DateFormat dateFormat, int i) {
        return Q(L(), dateFormat, j, i);
    }

    public static long W0(String str) {
        return Y0(str, s());
    }

    public static long X(long j, long j2, int i) {
        return S0(j - j2, i);
    }

    public static long X0(String str, @NonNull String str2) {
        return Y0(str, O(str2));
    }

    public static long Y(String str, String str2, int i) {
        return Z(str, str2, s(), i);
    }

    public static long Y0(String str, @NonNull DateFormat dateFormat) {
        try {
            return dateFormat.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static long Z(String str, String str2, @NonNull DateFormat dateFormat, int i) {
        return S0(Y0(str, dateFormat) - Y0(str2, dateFormat), i);
    }

    public static long Z0(long j, int i) {
        return j * ((long) i);
    }

    public static long a(Date date) {
        return date.getTime();
    }

    public static long a0(Date date, Date date2, int i) {
        return S0(a(date) - a(date2), i);
    }

    public static String b(Date date) {
        return d(date, s());
    }

    public static long b0(long j, int i) {
        return X(j, System.currentTimeMillis(), i);
    }

    public static String c(Date date, @NonNull String str) {
        return O(str).format(date);
    }

    public static long c0(String str, int i) {
        return Z(str, M(), s(), i);
    }

    public static String d(Date date, @NonNull DateFormat dateFormat) {
        return dateFormat.format(date);
    }

    public static long d0(String str, @NonNull DateFormat dateFormat, int i) {
        return Z(str, N(dateFormat), dateFormat, i);
    }

    public static String e(long j) {
        return h(new Date(j));
    }

    public static long e0(Date date, int i) {
        return a0(date, new Date(), i);
    }

    public static String f(String str) {
        return h(V0(str, s()));
    }

    public static String f0(long j) {
        return i0(new Date(j));
    }

    public static String g(String str, @NonNull DateFormat dateFormat) {
        return h(V0(str, dateFormat));
    }

    public static String g0(String str) {
        return i0(V0(str, s()));
    }

    public static String h(Date date) {
        return new SimpleDateFormat("E", Locale.CHINA).format(date);
    }

    public static String h0(String str, @NonNull DateFormat dateFormat) {
        return i0(V0(str, dateFormat));
    }

    public static String i(int i) {
        return f20191a[i % 12];
    }

    public static String i0(Date date) {
        return new SimpleDateFormat("EEEE", Locale.US).format(date);
    }

    public static String j(long j) {
        return m(N0(j));
    }

    public static int j0(int i) {
        return Calendar.getInstance().get(i);
    }

    public static String k(String str) {
        return m(V0(str, s()));
    }

    public static int k0(long j, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(i);
    }

    public static String l(String str, @NonNull DateFormat dateFormat) {
        return m(V0(str, dateFormat));
    }

    public static int l0(String str, int i) {
        return n0(V0(str, s()), i);
    }

    public static String m(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return f20191a[calendar.get(1) % 12];
    }

    public static int m0(String str, @NonNull DateFormat dateFormat, int i) {
        return n0(V0(str, dateFormat), i);
    }

    public static Date n(long j, long j2, int i) {
        return N0(j + Z0(j2, i));
    }

    public static int n0(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(i);
    }

    public static Date o(String str, long j, int i) {
        return p(str, s(), j, i);
    }

    public static long o0() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static Date p(String str, @NonNull DateFormat dateFormat, long j, int i) {
        return N0(Y0(str, dateFormat) + Z0(j, i));
    }

    public static String p0(int i, int i2) {
        String[] strArr = b;
        int i3 = i - 1;
        if (i2 < f20190a[i3]) {
            i3 = (i + 10) % 12;
        }
        return strArr[i3];
    }

    public static Date q(Date date, long j, int i) {
        return N0(a(date) + Z0(j, i));
    }

    public static String q0(long j) {
        return t0(N0(j));
    }

    public static Date r(long j, int i) {
        return n(L(), j, i);
    }

    public static String r0(String str) {
        return t0(V0(str, s()));
    }

    public static SimpleDateFormat s() {
        return O("yyyy-MM-dd HH:mm:ss");
    }

    public static String s0(String str, @NonNull DateFormat dateFormat) {
        return t0(V0(str, dateFormat));
    }

    public static String t(long j, long j2, int i) {
        return O0(j - j2, i);
    }

    public static String t0(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return p0(calendar.get(2) + 1, calendar.get(5));
    }

    public static String u(String str, String str2, int i) {
        return O0(Y0(str, s()) - Y0(str2, s()), i);
    }

    public static boolean u0() {
        return Calendar.getInstance().get(9) == 0;
    }

    public static String v(String str, String str2, @NonNull DateFormat dateFormat, int i) {
        return O0(Y0(str, dateFormat) - Y0(str2, dateFormat), i);
    }

    public static boolean v0(long j) {
        return k0(j, 9) == 0;
    }

    public static String w(Date date, Date date2, int i) {
        return O0(a(date) - a(date2), i);
    }

    public static boolean w0(String str) {
        return m0(str, s(), 9) == 0;
    }

    public static String x(long j, int i) {
        return t(j, System.currentTimeMillis(), i);
    }

    public static boolean x0(String str, @NonNull DateFormat dateFormat) {
        return m0(str, dateFormat, 9) == 0;
    }

    public static String y(String str, int i) {
        return v(str, M(), s(), i);
    }

    public static boolean y0(Date date) {
        return n0(date, 9) == 0;
    }

    public static String z(String str, @NonNull DateFormat dateFormat, int i) {
        return v(str, N(dateFormat), dateFormat, i);
    }

    public static boolean z0(int i) {
        return (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
    }
}
