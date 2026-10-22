package com.zj.adlib;

import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class fa1 extends ParsedResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f41629a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long[] f16491a = {604800000, 86400000, 3600000, 60000, 1000};
    public static final Pattern b = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final double f16492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f16493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f16496a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final double f16497b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f16498b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f16499b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f16500b;
    public final String c;
    public final String d;

    public fa1(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d, double d2) {
        super(ParsedResultType.CALENDAR);
        this.f16494a = str;
        try {
            long jR = r(str2);
            this.f16493a = jR;
            if (str3 == null) {
                long jT = t(str4);
                this.f16498b = jT < 0 ? -1L : jR + jT;
            } else {
                try {
                    this.f16498b = r(str3);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e.toString());
                }
            }
            this.f16495a = str2.length() == 8;
            this.f16500b = str3 != null && str3.length() == 8;
            this.f16499b = str5;
            this.c = str6;
            this.f16496a = strArr;
            this.d = str7;
            this.f16492a = d;
            this.f16497b = d2;
        } catch (ParseException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    public static String d(boolean z, long j) {
        if (j < 0) {
            return null;
        }
        return (z ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(Long.valueOf(j));
    }

    public static long r(String str) throws ParseException {
        if (!b.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        }
        if (str.length() != 16 || str.charAt(15) != 'Z') {
            return s(str);
        }
        long jS = s(str.substring(0, 15));
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long j = jS + ((long) gregorianCalendar.get(15));
        gregorianCalendar.setTime(new Date(j));
        return j + ((long) gregorianCalendar.get(16));
    }

    public static long s(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }

    public static long t(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f41629a.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j = 0;
        int i = 0;
        while (true) {
            long[] jArr = f16491a;
            if (i >= jArr.length) {
                return j;
            }
            int i2 = i + 1;
            String strGroup = matcher.group(i2);
            if (strGroup != null) {
                j += jArr[i] * ((long) Integer.parseInt(strGroup));
            }
            i = i2;
        }
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.b(this.f16494a, sb);
        ParsedResult.b(d(this.f16495a, this.f16493a), sb);
        ParsedResult.b(d(this.f16500b, this.f16498b), sb);
        ParsedResult.b(this.f16499b, sb);
        ParsedResult.b(this.c, sb);
        ParsedResult.c(this.f16496a, sb);
        ParsedResult.b(this.d, sb);
        return sb.toString();
    }

    public String[] e() {
        return this.f16496a;
    }

    public String f() {
        return this.d;
    }

    @Deprecated
    public Date g() {
        if (this.f16498b < 0) {
            return null;
        }
        return new Date(this.f16498b);
    }

    public long h() {
        return this.f16498b;
    }

    public double i() {
        return this.f16492a;
    }

    public String j() {
        return this.f16499b;
    }

    public double k() {
        return this.f16497b;
    }

    public String l() {
        return this.c;
    }

    @Deprecated
    public Date m() {
        return new Date(this.f16493a);
    }

    public long n() {
        return this.f16493a;
    }

    public String o() {
        return this.f16494a;
    }

    public boolean p() {
        return this.f16500b;
    }

    public boolean q() {
        return this.f16495a;
    }
}
