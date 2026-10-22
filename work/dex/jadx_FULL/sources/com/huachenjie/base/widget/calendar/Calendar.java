package com.huachenjie.base.widget.calendar;

import android.text.TextUtils;
import com.zj.adlib.c49;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class Calendar implements Serializable, Comparable<Calendar> {
    private static final long serialVersionUID = 141315161718191143L;
    private int day;
    private String gregorianFestival;
    private boolean isCurrentDay;
    private boolean isCurrentMonth;
    private boolean isLeapYear;
    private boolean isWeekend;
    private int leapMonth;
    private String lunar;
    private Calendar lunarCalendar;
    private int month;
    private String scheme;
    private int schemeColor;
    private List<Scheme> schemes;
    private String solarTerm;
    private String traditionFestival;
    private int week;
    private int year;

    public static final class Scheme implements Serializable {
        private Object obj;
        private String other;
        private String scheme;
        private int shcemeColor;
        private int type;

        public Scheme() {
        }

        public Object getObj() {
            return this.obj;
        }

        public String getOther() {
            return this.other;
        }

        public String getScheme() {
            return this.scheme;
        }

        public int getShcemeColor() {
            return this.shcemeColor;
        }

        public int getType() {
            return this.type;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public void setShcemeColor(int shcemeColor) {
            this.shcemeColor = shcemeColor;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Scheme(int type, int shcemeColor, String scheme, String other) {
            this.type = type;
            this.shcemeColor = shcemeColor;
            this.scheme = scheme;
            this.other = other;
        }

        public Scheme(int type, int shcemeColor, String scheme) {
            this.type = type;
            this.shcemeColor = shcemeColor;
            this.scheme = scheme;
        }

        public Scheme(int shcemeColor, String scheme) {
            this.shcemeColor = shcemeColor;
            this.scheme = scheme;
        }

        public Scheme(int shcemeColor, String scheme, String other) {
            this.shcemeColor = shcemeColor;
            this.scheme = scheme;
            this.other = other;
        }
    }

    public void addScheme(Scheme scheme) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(scheme);
    }

    public final void clearScheme() {
        setScheme("");
        setSchemeColor(0);
        setSchemes(null);
    }

    public final int differ(Calendar calendar) {
        return CalendarUtil.differ(this, calendar);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof Calendar)) {
            Calendar calendar = (Calendar) o;
            if (calendar.getYear() == this.year && calendar.getMonth() == this.month && calendar.getDay() == this.day) {
                return true;
            }
        }
        return super.equals(o);
    }

    public String getDateString() {
        Object objValueOf;
        Object objValueOf2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.year);
        sb.append(c49.f40900a);
        int i = this.month;
        if (i < 10) {
            objValueOf = "0" + this.month;
        } else {
            objValueOf = Integer.valueOf(i);
        }
        sb.append(objValueOf);
        sb.append(c49.f40900a);
        int i2 = this.day;
        if (i2 < 10) {
            objValueOf2 = "0" + this.day;
        } else {
            objValueOf2 = Integer.valueOf(i2);
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    public int getDay() {
        return this.day;
    }

    public String getGregorianFestival() {
        return this.gregorianFestival;
    }

    public int getLeapMonth() {
        return this.leapMonth;
    }

    public String getLunar() {
        return this.lunar;
    }

    public Calendar getLunarCalendar() {
        return this.lunarCalendar;
    }

    public int getMonth() {
        return this.month;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int getSchemeColor() {
        return this.schemeColor;
    }

    public List<Scheme> getSchemes() {
        return this.schemes;
    }

    public String getSolarTerm() {
        return this.solarTerm;
    }

    public long getTimeInMillis() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        return calendar.getTimeInMillis();
    }

    public String getTraditionFestival() {
        return this.traditionFestival;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public boolean hasScheme() {
        List<Scheme> list = this.schemes;
        return ((list == null || list.size() == 0) && TextUtils.isEmpty(this.scheme)) ? false : true;
    }

    public boolean isAvailable() {
        int i = this.year;
        boolean z = i > 0;
        int i2 = this.month;
        boolean z2 = z & (i2 > 0);
        int i3 = this.day;
        return z2 & (i3 > 0) & (i3 <= 31) & (i2 <= 12) & (i >= 1900) & (i <= 2099);
    }

    public boolean isCurrentDay() {
        return this.isCurrentDay;
    }

    public boolean isCurrentMonth() {
        return this.isCurrentMonth;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    public boolean isSameMonth(Calendar calendar) {
        return this.year == calendar.getYear() && this.month == calendar.getMonth();
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public final void mergeScheme(Calendar calendar, String defaultScheme) {
        if (calendar == null) {
            return;
        }
        if (!TextUtils.isEmpty(calendar.getScheme())) {
            defaultScheme = calendar.getScheme();
        }
        setScheme(defaultScheme);
        setSchemeColor(calendar.getSchemeColor());
        setSchemes(calendar.getSchemes());
    }

    public void setCurrentDay(boolean currentDay) {
        this.isCurrentDay = currentDay;
    }

    public void setCurrentMonth(boolean currentMonth) {
        this.isCurrentMonth = currentMonth;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setGregorianFestival(String gregorianFestival) {
        this.gregorianFestival = gregorianFestival;
    }

    public void setLeapMonth(int leapMonth) {
        this.leapMonth = leapMonth;
    }

    public void setLeapYear(boolean leapYear) {
        this.isLeapYear = leapYear;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public void setLunarCalendar(Calendar lunarCakendar) {
        this.lunarCalendar = lunarCakendar;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setSchemeColor(int schemeColor) {
        this.schemeColor = schemeColor;
    }

    public void setSchemes(List<Scheme> schemes) {
        this.schemes = schemes;
    }

    public void setSolarTerm(String solarTerm) {
        this.solarTerm = solarTerm;
    }

    public void setTraditionFestival(String traditionFestival) {
        this.traditionFestival = traditionFestival;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setWeekend(boolean weekend) {
        this.isWeekend = weekend;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        Object objValueOf;
        Object objValueOf2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.year);
        sb.append("");
        int i = this.month;
        if (i < 10) {
            objValueOf = "0" + this.month;
        } else {
            objValueOf = Integer.valueOf(i);
        }
        sb.append(objValueOf);
        sb.append("");
        int i2 = this.day;
        if (i2 < 10) {
            objValueOf2 = "0" + this.day;
        } else {
            objValueOf2 = Integer.valueOf(i2);
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Calendar calendar) {
        if (calendar == null) {
            return 1;
        }
        return toString().compareTo(calendar.toString());
    }

    public void addScheme(int schemeColor, String scheme) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(schemeColor, scheme));
    }

    public void addScheme(int type, int schemeColor, String scheme) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(type, schemeColor, scheme));
    }

    public void addScheme(int type, int schemeColor, String scheme, String other) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(type, schemeColor, scheme, other));
    }

    public void addScheme(int schemeColor, String scheme, String other) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(schemeColor, scheme, other));
    }
}
