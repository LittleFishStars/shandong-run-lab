package com.alibaba.triver.basic.b;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f24688a = 86400000;
    public static final long b = 604800000;
    private static final String e = "[0-9]*";
    private static final TimeZone d = TimeZone.getTimeZone("UTC");
    private static final DateFormat[] c = new SimpleDateFormat[3];

    static {
        String[] strArr = {"yyyy-MM-dd HH:mm:ss", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyyMMddHHmmss"};
        for (int i = 0; i < 3; i++) {
            DateFormat[] dateFormatArr = c;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i], Locale.ENGLISH);
            dateFormatArr[i] = simpleDateFormat;
            simpleDateFormat.setTimeZone(d);
        }
    }

    public static boolean a(String str) {
        return Pattern.compile(e).matcher(str).matches();
    }

    public static Date b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 14 && a(strTrim)) {
            try {
                return new SimpleDateFormat("yyyyMMddHHmmss").parse(strTrim);
            } catch (ParseException e2) {
                RVLogger.w("Bridge", Log.getStackTraceString(e2));
            }
        } else if (strTrim.length() == 19 && strTrim.indexOf(" ") == 10) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strTrim);
            } catch (ParseException e3) {
                RVLogger.w("Bridge", Log.getStackTraceString(e3));
            }
        }
        int i = 0;
        if (strTrim.length() > 10) {
            if ((strTrim.substring(strTrim.length() - 5).indexOf("+") == 0 || strTrim.substring(strTrim.length() - 5).indexOf(c49.f40900a) == 0) && strTrim.substring(strTrim.length() - 5).indexOf(u15.f19942b) == 2) {
                strTrim = strTrim.substring(0, strTrim.length() - 5) + strTrim.substring(strTrim.length() - 5, strTrim.length() - 4) + "0" + strTrim.substring(strTrim.length() - 4);
            }
            String strSubstring = strTrim.substring(strTrim.length() - 6);
            if ((strSubstring.indexOf(c49.f40900a) == 0 || strSubstring.indexOf("+") == 0) && strSubstring.indexOf(u15.f19942b) == 3 && !"GMT".equals(strTrim.substring(strTrim.length() - 9, strTrim.length() - 6))) {
                strTrim = strTrim.substring(0, strTrim.length() - 6) + (strSubstring.substring(0, 3) + strSubstring.substring(4));
            }
        }
        synchronized (b.class) {
            while (true) {
                DateFormat[] dateFormatArr = c;
                if (i >= dateFormatArr.length) {
                    return null;
                }
                try {
                    return dateFormatArr[i].parse(strTrim);
                } catch (NumberFormatException | ParseException unused) {
                    i++;
                }
            }
        }
    }
}
