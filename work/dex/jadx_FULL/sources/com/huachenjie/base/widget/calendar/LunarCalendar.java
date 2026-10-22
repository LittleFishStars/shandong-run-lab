package com.huachenjie.base.widget.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.huachenjie.base.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class LunarCalendar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static String[] DAY_STR;
    private static String[] MONTH_STR;
    private static String[] SPECIAL_FESTIVAL_STR;
    private static String[] TRADITION_FESTIVAL_STR;

    @SuppressLint({"UseSparseArrays"})
    private static final Map<Integer, String[]> SPECIAL_FESTIVAL = new HashMap();
    private static String[] SOLAR_CALENDAR = null;

    @SuppressLint({"UseSparseArrays"})
    private static final Map<Integer, String[]> SOLAR_TERMS = new HashMap();
    private static final int[] LUNAR_INFO = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, MatroskaExtractor.e1, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, MatroskaExtractor.l1, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, MatroskaExtractor.g1, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};

    private static String dateToString(int year, int month, int day) {
        return year + getString(month, day);
    }

    public static int daysInLunarMonth(int year, int month) {
        return (LUNAR_INFO[year + (-1900)] & (65536 >> month)) == 0 ? 29 : 30;
    }

    public static String getLunarText(int year, int month, int day) {
        String solarTerm = getSolarTerm(year, month, day);
        String strGregorianFestival = gregorianFestival(month, day);
        if (!TextUtils.isEmpty(strGregorianFestival)) {
            return strGregorianFestival;
        }
        if (!TextUtils.isEmpty(solarTerm)) {
            return solarTerm;
        }
        int[] iArrSolarToLunar = LunarUtil.solarToLunar(year, month, day);
        String traditionFestival = getTraditionFestival(iArrSolarToLunar[0], iArrSolarToLunar[1], iArrSolarToLunar[2]);
        return !TextUtils.isEmpty(traditionFestival) ? traditionFestival : numToChinese(iArrSolarToLunar[1], iArrSolarToLunar[2], iArrSolarToLunar[3]);
    }

    private static String getSolarTerm(int year, int month, int day) {
        Map<Integer, String[]> map = SOLAR_TERMS;
        if (!map.containsKey(Integer.valueOf(year))) {
            map.put(Integer.valueOf(year), SolarTermUtil.getSolarTerms(year));
        }
        String[] strArr = map.get(Integer.valueOf(year));
        String str = year + getString(month, day);
        for (String str2 : strArr) {
            if (str2.contains(str)) {
                return str2.replace(str, "");
            }
        }
        return "";
    }

    private static String getSpecialFestival(int year, int month, int day) {
        Map<Integer, String[]> map = SPECIAL_FESTIVAL;
        if (!map.containsKey(Integer.valueOf(year))) {
            map.put(Integer.valueOf(year), getSpecialFestivals(year));
        }
        String[] strArr = map.get(Integer.valueOf(year));
        String str = year + getString(month, day);
        for (String str2 : strArr) {
            if (str2.contains(str)) {
                return str2.replace(str, "");
            }
        }
        return "";
    }

    private static String[] getSpecialFestivals(int year) {
        String[] strArr = new String[3];
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, 4, 1);
        int i = (7 - calendar.get(7)) + 1;
        if (i == 7) {
            strArr[0] = dateToString(year, 5, i + 1) + SPECIAL_FESTIVAL_STR[0];
        } else {
            strArr[0] = dateToString(year, 5, i + 7 + 1) + SPECIAL_FESTIVAL_STR[0];
        }
        calendar.set(year, 5, 1);
        int i2 = (7 - calendar.get(7)) + 1;
        if (i2 == 7) {
            strArr[1] = dateToString(year, 6, i2 + 7 + 1) + SPECIAL_FESTIVAL_STR[1];
        } else {
            strArr[1] = dateToString(year, 6, i2 + 7 + 7 + 1) + SPECIAL_FESTIVAL_STR[1];
        }
        calendar.set(year, 10, 1);
        int i3 = (7 - calendar.get(7)) + 1;
        if (i3 <= 2) {
            strArr[2] = dateToString(year, 11, i3 + 21 + 5) + SPECIAL_FESTIVAL_STR[2];
        } else {
            strArr[2] = dateToString(year, 11, i3 + 14 + 5) + SPECIAL_FESTIVAL_STR[2];
        }
        return strArr;
    }

    private static String getString(int month, int day) {
        String strValueOf;
        Object objValueOf;
        StringBuilder sb = new StringBuilder();
        if (month >= 10) {
            strValueOf = String.valueOf(month);
        } else {
            strValueOf = "0" + month;
        }
        sb.append(strValueOf);
        if (day >= 10) {
            objValueOf = Integer.valueOf(day);
        } else {
            objValueOf = "0" + day;
        }
        sb.append(objValueOf);
        return sb.toString();
    }

    private static String getTraditionFestival(int year, int month, int day) {
        if (month == 12 && day == daysInLunarMonth(year, month)) {
            return TRADITION_FESTIVAL_STR[0];
        }
        String string = getString(month, day);
        for (String str : TRADITION_FESTIVAL_STR) {
            if (str.contains(string)) {
                return str.replace(string, "");
            }
        }
        return "";
    }

    private static String gregorianFestival(int month, int day) {
        String string = getString(month, day);
        for (String str : SOLAR_CALENDAR) {
            if (str.contains(string)) {
                return str.replace(string, "");
            }
        }
        return "";
    }

    public static void init(Context context) {
        if (MONTH_STR != null) {
            return;
        }
        TrunkBranchAnnals.init(context);
        SolarTermUtil.init(context);
        MONTH_STR = context.getResources().getStringArray(R.array.lunar_first_of_month);
        TRADITION_FESTIVAL_STR = context.getResources().getStringArray(R.array.tradition_festival);
        DAY_STR = context.getResources().getStringArray(R.array.lunar_str);
        SPECIAL_FESTIVAL_STR = context.getResources().getStringArray(R.array.special_festivals);
        SOLAR_CALENDAR = context.getResources().getStringArray(R.array.solar_festival);
    }

    private static String numToChinese(int month, int day, int leap) {
        return day == 1 ? numToChineseMonth(month, leap) : DAY_STR[day - 1];
    }

    private static String numToChineseMonth(int month, int leap) {
        if (leap != 1) {
            return MONTH_STR[month - 1];
        }
        return "闰" + MONTH_STR[month - 1];
    }

    public static void setupLunarCalendar(Calendar calendar) {
        int year = calendar.getYear();
        int month = calendar.getMonth();
        int day = calendar.getDay();
        calendar.setWeekend(CalendarUtil.isWeekend(calendar));
        calendar.setWeek(CalendarUtil.getWeekFormCalendar(calendar));
        Calendar calendar2 = new Calendar();
        calendar.setLunarCalendar(calendar2);
        int[] iArrSolarToLunar = LunarUtil.solarToLunar(year, month, day);
        calendar2.setYear(iArrSolarToLunar[0]);
        calendar2.setMonth(iArrSolarToLunar[1]);
        calendar2.setDay(iArrSolarToLunar[2]);
        calendar.setLeapYear(CalendarUtil.isLeapYear(year));
        if (iArrSolarToLunar[3] == 1) {
            calendar.setLeapMonth(iArrSolarToLunar[1]);
            calendar2.setLeapMonth(iArrSolarToLunar[1]);
        }
        String solarTerm = getSolarTerm(year, month, day);
        String strGregorianFestival = gregorianFestival(month, day);
        String traditionFestival = getTraditionFestival(iArrSolarToLunar[0], iArrSolarToLunar[1], iArrSolarToLunar[2]);
        String strNumToChinese = numToChinese(iArrSolarToLunar[1], iArrSolarToLunar[2], iArrSolarToLunar[3]);
        if (TextUtils.isEmpty(strGregorianFestival)) {
            strGregorianFestival = getSpecialFestival(year, month, day);
        }
        calendar.setSolarTerm(solarTerm);
        calendar.setGregorianFestival(strGregorianFestival);
        calendar.setTraditionFestival(traditionFestival);
        calendar2.setTraditionFestival(traditionFestival);
        calendar2.setSolarTerm(solarTerm);
        if (!TextUtils.isEmpty(solarTerm)) {
            calendar.setLunar(solarTerm);
        } else if (!TextUtils.isEmpty(strGregorianFestival)) {
            calendar.setLunar(strGregorianFestival);
        } else if (TextUtils.isEmpty(traditionFestival)) {
            calendar.setLunar(strNumToChinese);
        } else {
            calendar.setLunar(traditionFestival);
        }
        calendar2.setLunar(strNumToChinese);
    }

    public static String getLunarText(Calendar calendar) {
        return getLunarText(calendar.getYear(), calendar.getMonth(), calendar.getDay());
    }
}
