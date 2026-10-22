package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.BackgroundChronometer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class s72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f44623a = TimeZone.getDefault().getRawOffset();
    public static final long b = 3600;
    public static final long c = 3600000;
    public static final long d = 1800000;
    public static final long e = 1000;
    public static final long f = 86400000;

    public static boolean A(long time) {
        return s(time) == 0;
    }

    public static boolean B(long time) {
        return s(time) == -1;
    }

    public static String a(long time) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Long.valueOf(time));
    }

    @NonNull
    public static String b(String strTime) {
        Long lValueOf;
        if (TextUtils.isEmpty(strTime)) {
            return "";
        }
        try {
            lValueOf = Long.valueOf(Long.parseLong(strTime));
        } catch (Exception unused) {
            lValueOf = null;
        }
        return lValueOf == null ? "" : g(lValueOf);
    }

    public static String c(long time, String format) {
        return new SimpleDateFormat(format, Locale.getDefault()).format(Long.valueOf(time));
    }

    public static String d(long time) {
        return new SimpleDateFormat(!z(time) ? "yyyy/MM/dd HH:mm" : "MM/dd HH:mm", Locale.getDefault()).format(Long.valueOf(time));
    }

    public static String e(long time) {
        return f(time, false);
    }

    public static String f(long time, boolean isKeepHour) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j = 3600;
        long j2 = time / j;
        long j3 = time - (j * j2);
        long j4 = 60;
        long j5 = j3 / j4;
        long j6 = j3 - (j4 * j5);
        if (!isKeepHour) {
            j5 += 60 * j2;
        }
        if (j2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j2);
        String string = sb.toString();
        if (j5 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j5);
        String string2 = sb2.toString();
        if (j6 < 10) {
            sb3 = new StringBuilder();
            sb3.append("0");
        } else {
            sb3 = new StringBuilder();
            sb3.append("");
        }
        sb3.append(j6);
        String string3 = sb3.toString();
        if (!isKeepHour || j2 == 0) {
            return string2 + "'" + string3 + "\"";
        }
        return string + "'" + string2 + "'" + string3 + "\"";
    }

    @NonNull
    public static String g(Long time) {
        if (time == null) {
            return "";
        }
        if (time.longValue() <= 60000) {
            return "刚刚";
        }
        long jLongValue = time.longValue() / 3600000;
        if (jLongValue == 0) {
            return ((time.longValue() % 3600000) / 60000) + "分钟前";
        }
        if (jLongValue < 24) {
            return jLongValue + "小时前";
        }
        long jLongValue2 = time.longValue() / 86400000;
        if (jLongValue2 < 30) {
            return jLongValue2 + "天前";
        }
        if (jLongValue2 < 360) {
            return (jLongValue2 / 30) + "月前";
        }
        return (jLongValue2 / 360) + "年前";
    }

    public static String h(long time) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j = 3600;
        long j2 = time / j;
        long j3 = time - (j * j2);
        long j4 = 60;
        long j5 = j3 / j4;
        long j6 = j3 - (j4 * j5);
        if (j2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j2);
        String string = sb.toString();
        if (j5 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j5);
        String string2 = sb2.toString();
        if (j6 < 10) {
            sb3 = new StringBuilder();
            sb3.append("0");
        } else {
            sb3 = new StringBuilder();
            sb3.append("");
        }
        sb3.append(j6);
        return string + u15.f19942b + string2 + u15.f19942b + sb3.toString();
    }

    public static Date i(String strTime, String format) {
        if (TextUtils.isEmpty(strTime)) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(strTime);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j(long time) {
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Long.valueOf(time));
    }

    public static String k(long mills) {
        return l(mills, true);
    }

    public static String l(long mills, boolean keepSecs) {
        String str;
        String str2;
        long jLongValue = BigDecimal.valueOf(mills).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).longValue();
        long j = 3600;
        long j2 = jLongValue / j;
        long j3 = jLongValue - (j * j2);
        long j4 = 60;
        long j5 = j3 / j4;
        long j6 = j3 - (j4 * j5);
        String str3 = "";
        if (j2 == 0) {
            str = "";
        } else {
            str = " " + j2 + " 小时";
        }
        if (j5 == 0) {
            str2 = "";
        } else {
            str2 = " " + j5 + " 分钟";
        }
        if (j6 != 0) {
            str3 = " " + j6 + " 秒";
        }
        if (!keepSecs) {
            return str + str2;
        }
        return str + str2 + str3;
    }

    public static String m(long time) {
        StringBuilder sb;
        StringBuilder sb2;
        long j = 60000;
        if (time < j) {
            return (time / 1000) + "秒";
        }
        long j2 = 3600000;
        long j3 = time / j2;
        long j4 = time - (j2 * j3);
        long j5 = j4 / j;
        long j6 = j4 - (j * j5);
        long j7 = 0;
        if (j6 > 0) {
            j5++;
        }
        if (j5 == 60) {
            j3++;
        } else {
            j7 = j5;
        }
        if (j3 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j3);
        String string = sb.toString();
        if (j7 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j7);
        return string + u15.f19942b + sb2.toString();
    }

    public static String n(long time) {
        return o(time, true);
    }

    public static String o(long time, boolean isKeepHourUnit) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j = 3600;
        long j2 = time / j;
        long j3 = time - (j * j2);
        long j4 = 60;
        long j5 = j3 / j4;
        if (!isKeepHourUnit) {
            j5 += 60 * j2;
        }
        long j6 = j3 - (j4 * j5);
        if (j2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
        } else {
            sb = new StringBuilder();
            sb.append("");
        }
        sb.append(j2);
        String string = sb.toString();
        if (j5 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
        } else {
            sb2 = new StringBuilder();
            sb2.append("");
        }
        sb2.append(j5);
        String string2 = sb2.toString();
        if (j6 < 10) {
            sb3 = new StringBuilder();
            sb3.append("0");
        } else {
            sb3 = new StringBuilder();
            sb3.append("");
        }
        sb3.append(j6);
        String string3 = sb3.toString();
        if (!isKeepHourUnit) {
            return string2 + u15.f19942b + string3;
        }
        return string + u15.f19942b + string2 + u15.f19942b + string3;
    }

    @NonNull
    public static String p(String strTime) {
        Long lValueOf;
        if (TextUtils.isEmpty(strTime)) {
            return "";
        }
        try {
            lValueOf = Long.valueOf(Long.parseLong(strTime));
        } catch (Exception unused) {
            lValueOf = null;
        }
        return lValueOf == null ? "" : g(Long.valueOf(System.currentTimeMillis() - lValueOf.longValue()));
    }

    public static long q(BackgroundChronometer cmt) {
        String string = cmt.getText().toString();
        if (TextUtils.isEmpty(string)) {
            return 0L;
        }
        if (string.length() >= 7) {
            try {
                String[] strArrSplit = string.split(u15.f19942b);
                return (Integer.parseInt(strArrSplit[0]) * 3600) + (Integer.parseInt(strArrSplit[1]) * 60) + Integer.parseInt(strArrSplit[2]);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        if (string.length() <= 3 || string.length() > 5) {
            return 0L;
        }
        try {
            String[] strArrSplit2 = string.split(u15.f19942b);
            return (Integer.parseInt(strArrSplit2[0]) * 60) + Integer.parseInt(strArrSplit2[1]);
        } catch (NumberFormatException e3) {
            e3.printStackTrace();
            return 0L;
        }
    }

    public static String r(Context context, long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        switch (calendar.get(7)) {
            case 1:
                return context.getString(R.string.sunday);
            case 2:
                return context.getString(R.string.monday);
            case 3:
                return context.getString(R.string.tuesday);
            case 4:
                return context.getString(R.string.wednesday);
            case 5:
                return context.getString(R.string.thursday);
            case 6:
                return context.getString(R.string.friday);
            case 7:
                return context.getString(R.string.saturday);
            default:
                return "";
        }
    }

    public static int s(long millsecond) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = f44623a;
        return (int) (((millsecond + j) / 86400000) - ((jCurrentTimeMillis + j) / 86400000));
    }

    public static String t(long timestamp) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - timestamp) / 1000;
        if (jCurrentTimeMillis < 3600) {
            long j = 60;
            long j2 = jCurrentTimeMillis / j;
            if (j2 < 1) {
                return "刚刚";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(j2 + ((long) (jCurrentTimeMillis % j > 0 ? 1 : 0)));
            sb.append("分钟前");
            return sb.toString();
        }
        if (jCurrentTimeMillis < 86400) {
            return (jCurrentTimeMillis / ((long) 3600)) + "小时前";
        }
        if (jCurrentTimeMillis >= 2592000) {
            return "1月前";
        }
        return (jCurrentTimeMillis / ((long) 86400)) + "天前";
    }

    public static boolean u(Long dayTimeMillis1, Long dayTimeMillis2) {
        if (dayTimeMillis1 == null || dayTimeMillis2 == null || dayTimeMillis1.longValue() == 0 || dayTimeMillis2.longValue() == 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(dayTimeMillis1.longValue()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(dayTimeMillis2.longValue()));
        return v(calendar, calendar2);
    }

    public static boolean v(Calendar day1, Calendar day2) {
        return day1 != null && day2 != null && day1.get(1) == day2.get(1) && day1.get(2) == day2.get(2) && day1.get(5) == day2.get(5);
    }

    public static boolean w(long time) {
        return s(time) == 1;
    }

    public static boolean x(long time) {
        return s(time) == -2;
    }

    public static boolean y(long time) {
        return s(time) == 2;
    }

    public static boolean z(long time) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        calendar.setTimeInMillis(time);
        return i == calendar.get(1);
    }
}
