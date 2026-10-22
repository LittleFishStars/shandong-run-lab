package com.acse.ottn;

import java.io.ObjectStreamException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s0 f23180a;

    public static s0 d() {
        if (f23180a == null) {
            synchronized (s0.class) {
                if (f23180a == null) {
                    f23180a = new s0();
                }
            }
        }
        return f23180a;
    }

    public static String[] g(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(((long) Integer.parseInt(str)) * 1000)).split("[年月日时分秒]");
    }

    public static String i(String str) {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(Long.valueOf(str).longValue()));
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public int b() {
        return Integer.parseInt(new SimpleDateFormat("HHmm", Locale.CHINA).format(new Date(System.currentTimeMillis())));
    }

    public long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public final Object e() throws ObjectStreamException {
        return f23180a;
    }

    public String f(String str) {
        return new SimpleDateFormat("HH-mm-ss").format(new Date(Long.valueOf(str).longValue()));
    }

    public String h(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(((long) Integer.parseInt(str)) * 1000));
    }

    public String j(String str) {
        int i;
        try {
            Date date = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    public String k(String str) {
        int i;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    public String e(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).longValue();
        return simpleDateFormat.format(new Date(((long) Integer.parseInt(str)) * 1000));
    }

    public static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        int i = calendar.get(7);
        if (i == 1) {
            return "周日";
        }
        if (i == 2) {
            return "周一";
        }
        if (i == 3) {
            return "周二";
        }
        if (i == 4) {
            return "周三";
        }
        if (i == 5) {
            return "周四";
        }
        if (i == 6) {
            return "周五";
        }
        if (i == 7) {
            return "周六";
        }
        return null;
    }

    public String b(long j) {
        return new SimpleDateFormat("MM月dd日  #  HH:mm").format(new Date(j)).replaceAll("#", a(j));
    }

    public static String c(String str, String str2) {
        try {
            return String.valueOf(new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime()).substring(0, 10);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).longValue();
        try {
            Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date(((long) Integer.parseInt(str)) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    public String[] d(String str) {
        return str.split("[年月日时分秒]");
    }

    public static String b(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.valueOf(str).longValue()));
    }

    public static String b(String str) {
        int i;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Long.valueOf(str).longValue();
        try {
            Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date(((long) Integer.parseInt(str)) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            i = calendar.get(7);
        } catch (ParseException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i == 1) {
            return "星期日";
        }
        if (i == 2) {
            return "星期一";
        }
        if (i == 3) {
            return "星期二";
        }
        if (i == 4) {
            return "星期三";
        }
        if (i == 5) {
            return "星期四";
        }
        if (i == 6) {
            return "星期五";
        }
        if (i == 7) {
            return "星期六";
        }
        return null;
    }

    public static String c() {
        return new SimpleDateFormat("yyyy年MM月dd日  HH时mm分").format(new Date());
    }

    public static String a(String str, String str2) {
        return b(str + "000", str2) + com.ipd.dsp.internal.i.q.a.i + b(str);
    }
}
