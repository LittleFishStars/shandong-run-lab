package com.huachenjie.base.widget.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class CalendarUtil {
    private static final long ONE_DAY = 86400000;

    public static int compareTo(int minYear, int minYearMonth, int minYearDay, int maxYear, int maxYearMonth, int maxYearDay) {
        Calendar calendar = new Calendar();
        calendar.setYear(minYear);
        calendar.setMonth(minYearMonth);
        calendar.setDay(minYearDay);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(maxYear);
        calendar2.setMonth(maxYearMonth);
        calendar2.setDay(maxYearDay);
        return calendar.compareTo(calendar2);
    }

    public static int differ(Calendar calendar1, Calendar calendar2) {
        if (calendar1 == null) {
            return Integer.MIN_VALUE;
        }
        if (calendar2 == null) {
            return Integer.MAX_VALUE;
        }
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(calendar1.getYear(), calendar1.getMonth() - 1, calendar1.getDay(), 12, 0, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(calendar2.getYear(), calendar2.getMonth() - 1, calendar2.getDay(), 12, 0, 0);
        return (int) ((timeInMillis - calendar.getTimeInMillis()) / 86400000);
    }

    public static int dipToPx(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static int getDate(String formatStr, Date date) {
        return Integer.parseInt(new SimpleDateFormat(formatStr).format(date));
    }

    public static Calendar getFirstCalendarFromMonthViewPager(int position, CalendarViewDelegate delegate) {
        Calendar calendar = new Calendar();
        calendar.setYear((((delegate.getMinYearMonth() + position) - 1) / 12) + delegate.getMinYear());
        calendar.setMonth((((position + delegate.getMinYearMonth()) - 1) % 12) + 1);
        if (delegate.getDefaultCalendarSelectDay() != 0) {
            int monthDaysCount = getMonthDaysCount(calendar.getYear(), calendar.getMonth());
            Calendar calendar2 = delegate.mIndexCalendar;
            if (calendar2 == null || calendar2.getDay() == 0) {
                monthDaysCount = 1;
            } else if (monthDaysCount >= calendar2.getDay()) {
                monthDaysCount = calendar2.getDay();
            }
            calendar.setDay(monthDaysCount);
        } else {
            calendar.setDay(1);
        }
        if (!isCalendarInRange(calendar, delegate)) {
            calendar = isMinRangeEdge(calendar, delegate) ? delegate.getMinRangeCalendar() : delegate.getMaxRangeCalendar();
        }
        calendar.setCurrentMonth(calendar.getYear() == delegate.getCurrentDay().getYear() && calendar.getMonth() == delegate.getCurrentDay().getMonth());
        calendar.setCurrentDay(calendar.equals(delegate.getCurrentDay()));
        LunarCalendar.setupLunarCalendar(calendar);
        return calendar;
    }

    public static Calendar getFirstCalendarStartWithMinCalendar(int minYear, int minYearMonth, int minYearDay, int week, int weekStart) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(minYear, minYearMonth - 1, minYearDay, 12, 0);
        long timeInMillis = (((long) ((week - 1) * 7)) * 86400000) + calendar.getTimeInMillis();
        calendar.setTimeInMillis(timeInMillis);
        calendar.setTimeInMillis(timeInMillis - (((long) getWeekViewStartDiff(calendar.get(1), calendar.get(2) + 1, calendar.get(5), weekStart)) * 86400000));
        Calendar calendar2 = new Calendar();
        calendar2.setYear(calendar.get(1));
        calendar2.setMonth(calendar.get(2) + 1);
        calendar2.setDay(calendar.get(5));
        return calendar2;
    }

    public static int getMonthDaysCount(int year, int month) {
        int i = (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) ? 31 : 0;
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            i = 30;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return i;
    }

    public static int getMonthEndDiff(int year, int month, int weekStart) {
        return getMonthEndDiff(year, month, getMonthDaysCount(year, month), weekStart);
    }

    public static int getMonthViewHeight(int year, int month, int itemHeight, int weekStartWith) {
        java.util.Calendar.getInstance().set(year, month - 1, 1, 12, 0, 0);
        int monthViewStartDiff = getMonthViewStartDiff(year, month, weekStartWith);
        int monthDaysCount = getMonthDaysCount(year, month);
        return (((monthViewStartDiff + monthDaysCount) + getMonthEndDiff(year, month, monthDaysCount, weekStartWith)) / 7) * itemHeight;
    }

    public static int getMonthViewLineCount(int year, int month, int weekStartWith, int mode) {
        if (mode == 0) {
            return 6;
        }
        return ((getMonthViewStartDiff(year, month, weekStartWith) + getMonthDaysCount(year, month)) + getMonthEndDiff(year, month, weekStartWith)) / 7;
    }

    public static int getMonthViewStartDiff(Calendar calendar, int weekStart) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, 1, 12, 0, 0);
        int i = calendar2.get(7);
        if (weekStart == 1) {
            return i - 1;
        }
        if (weekStart == 2) {
            if (i == 1) {
                return 6;
            }
            return i - weekStart;
        }
        if (i == 7) {
            return 0;
        }
        return i;
    }

    public static Calendar getNextCalendar(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() + 86400000);
        Calendar calendar3 = new Calendar();
        calendar3.setYear(calendar2.get(1));
        calendar3.setMonth(calendar2.get(2) + 1);
        calendar3.setDay(calendar2.get(5));
        return calendar3;
    }

    public static Calendar getPreCalendar(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0, 0);
        calendar2.setTimeInMillis(calendar2.getTimeInMillis() - 86400000);
        Calendar calendar3 = new Calendar();
        calendar3.setYear(calendar2.get(1));
        calendar3.setMonth(calendar2.get(2) + 1);
        calendar3.setDay(calendar2.get(5));
        return calendar3;
    }

    public static Calendar getRangeEdgeCalendar(Calendar calendar, CalendarViewDelegate delegate) {
        if (isCalendarInRange(delegate.getCurrentDay(), delegate) && delegate.getDefaultCalendarSelectDay() != 2) {
            return delegate.createCurrentDate();
        }
        if (isCalendarInRange(calendar, delegate)) {
            return calendar;
        }
        return delegate.getMinRangeCalendar().isSameMonth(calendar) ? delegate.getMinRangeCalendar() : delegate.getMaxRangeCalendar();
    }

    public static List<Calendar> getWeekCalendars(Calendar calendar, CalendarViewDelegate mDelegate) {
        long timeInMillis = calendar.getTimeInMillis();
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        int weekStart = calendar2.get(7);
        if (mDelegate.getWeekStart() == 1) {
            weekStart--;
        } else if (mDelegate.getWeekStart() == 2) {
            weekStart = weekStart == 1 ? 6 : weekStart - mDelegate.getWeekStart();
        } else if (weekStart == 7) {
            weekStart = 0;
        }
        java.util.Calendar calendar3 = java.util.Calendar.getInstance();
        calendar3.setTimeInMillis(timeInMillis - (((long) weekStart) * 86400000));
        Calendar calendar4 = new Calendar();
        calendar4.setYear(calendar3.get(1));
        calendar4.setMonth(calendar3.get(2) + 1);
        calendar4.setDay(calendar3.get(5));
        return initCalendarForWeekView(calendar4, mDelegate, mDelegate.getWeekStart());
    }

    public static int getWeekCountBetweenBothCalendar(int minYear, int minYearMonth, int minYearDay, int maxYear, int maxYearMonth, int maxYearDay, int weekStart) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(minYear, minYearMonth - 1, minYearDay);
        long timeInMillis = calendar.getTimeInMillis();
        int weekViewStartDiff = getWeekViewStartDiff(minYear, minYearMonth, minYearDay, weekStart);
        calendar.set(maxYear, maxYearMonth - 1, maxYearDay);
        return ((weekViewStartDiff + getWeekViewEndDiff(maxYear, maxYearMonth, maxYearDay, weekStart)) + (((int) ((calendar.getTimeInMillis() - timeInMillis) / 86400000)) + 1)) / 7;
    }

    public static int getWeekFormCalendar(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        return calendar2.get(7) - 1;
    }

    public static int getWeekFromCalendarStartWithMinCalendar(Calendar calendar, int minYear, int minYearMonth, int minYearDay, int weekStart) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(minYear, minYearMonth - 1, minYearDay);
        long timeInMillis = calendar2.getTimeInMillis();
        int weekViewStartDiff = getWeekViewStartDiff(minYear, minYearMonth, minYearDay, weekStart);
        int weekViewStartDiff2 = getWeekViewStartDiff(calendar.getYear(), calendar.getMonth(), calendar.getDay(), weekStart);
        int year = calendar.getYear();
        int month = calendar.getMonth() - 1;
        int day = calendar.getDay();
        if (weekViewStartDiff2 == 0) {
            day++;
        }
        calendar2.set(year, month, day);
        return ((weekViewStartDiff + ((int) ((calendar2.getTimeInMillis() - timeInMillis) / 86400000))) / 7) + 1;
    }

    public static int getWeekFromDayInMonth(Calendar calendar, int weekStart) {
        java.util.Calendar.getInstance().set(calendar.getYear(), calendar.getMonth() - 1, 1, 12, 0, 0);
        return (((calendar.getDay() + getMonthViewStartDiff(calendar, weekStart)) - 1) / 7) + 1;
    }

    public static int getWeekViewEndDiff(int year, int month, int day, int weekStart) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day, 12, 0);
        int i = calendar.get(7);
        if (weekStart == 1) {
            return 7 - i;
        }
        if (weekStart == 2) {
            if (i == 1) {
                return 0;
            }
            return (7 - i) + 1;
        }
        if (i == 7) {
            return 6;
        }
        return (7 - i) - 1;
    }

    public static int getWeekViewIndexFromCalendar(Calendar calendar, int weekStart) {
        return getWeekViewStartDiff(calendar.getYear(), calendar.getMonth(), calendar.getDay(), weekStart);
    }

    private static int getWeekViewStartDiff(int year, int month, int day, int weekStart) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day, 12, 0);
        int i = calendar.get(7);
        if (weekStart == 1) {
            return i - 1;
        }
        if (weekStart == 2) {
            if (i == 1) {
                return 6;
            }
            return i - weekStart;
        }
        if (i == 7) {
            return 0;
        }
        return i;
    }

    public static List<Calendar> initCalendarForMonthView(int year, int month, Calendar currentDate, int weekStar) {
        int monthDaysCount;
        int i;
        int i2;
        int i3;
        int i4 = month - 1;
        java.util.Calendar.getInstance().set(year, i4, 1);
        int monthViewStartDiff = getMonthViewStartDiff(year, month, weekStar);
        int monthDaysCount2 = getMonthDaysCount(year, month);
        ArrayList arrayList = new ArrayList();
        int i5 = 12;
        if (month == 1) {
            i = year - 1;
            int i6 = month + 1;
            monthDaysCount = monthViewStartDiff == 0 ? 0 : getMonthDaysCount(i, 12);
            i2 = i6;
            i3 = year;
        } else if (month == 12) {
            i3 = year + 1;
            monthDaysCount = monthViewStartDiff == 0 ? 0 : getMonthDaysCount(year, i4);
            i5 = i4;
            i2 = 1;
            i = year;
        } else {
            int i7 = month + 1;
            i5 = i4;
            monthDaysCount = monthViewStartDiff == 0 ? 0 : getMonthDaysCount(year, i4);
            i = year;
            i2 = i7;
            i3 = i;
        }
        int i8 = 1;
        for (int i9 = 0; i9 < 42; i9++) {
            Calendar calendar = new Calendar();
            if (i9 < monthViewStartDiff) {
                calendar.setYear(i);
                calendar.setMonth(i5);
                calendar.setDay((monthDaysCount - monthViewStartDiff) + i9 + 1);
            } else if (i9 >= monthDaysCount2 + monthViewStartDiff) {
                calendar.setYear(i3);
                calendar.setMonth(i2);
                calendar.setDay(i8);
                i8++;
            } else {
                calendar.setYear(year);
                calendar.setMonth(month);
                calendar.setCurrentMonth(true);
                calendar.setDay((i9 - monthViewStartDiff) + 1);
            }
            if (calendar.equals(currentDate)) {
                calendar.setCurrentDay(true);
            }
            LunarCalendar.setupLunarCalendar(calendar);
            arrayList.add(calendar);
        }
        return arrayList;
    }

    public static List<Calendar> initCalendarForWeekView(Calendar calendar, CalendarViewDelegate mDelegate, int weekStart) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        long timeInMillis = calendar2.getTimeInMillis();
        ArrayList arrayList = new ArrayList();
        calendar2.setTimeInMillis(timeInMillis);
        Calendar calendar3 = new Calendar();
        calendar3.setYear(calendar.getYear());
        calendar3.setMonth(calendar.getMonth());
        calendar3.setDay(calendar.getDay());
        if (calendar3.equals(mDelegate.getCurrentDay())) {
            calendar3.setCurrentDay(true);
        }
        LunarCalendar.setupLunarCalendar(calendar3);
        calendar3.setCurrentMonth(true);
        arrayList.add(calendar3);
        for (int i = 1; i <= 6; i++) {
            calendar2.setTimeInMillis((((long) i) * 86400000) + timeInMillis);
            Calendar calendar4 = new Calendar();
            calendar4.setYear(calendar2.get(1));
            calendar4.setMonth(calendar2.get(2) + 1);
            calendar4.setDay(calendar2.get(5));
            if (calendar4.equals(mDelegate.getCurrentDay())) {
                calendar4.setCurrentDay(true);
            }
            LunarCalendar.setupLunarCalendar(calendar4);
            calendar4.setCurrentMonth(true);
            arrayList.add(calendar4);
        }
        return arrayList;
    }

    public static boolean isCalendarInRange(Calendar calendar, int minYear, int minYearMonth, int minYearDay, int maxYear, int maxYearMonth, int maxYearDay) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(minYear, minYearMonth - 1, minYearDay);
        long timeInMillis = calendar2.getTimeInMillis();
        calendar2.set(maxYear, maxYearMonth - 1, maxYearDay);
        long timeInMillis2 = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        long timeInMillis3 = calendar2.getTimeInMillis();
        return timeInMillis3 >= timeInMillis && timeInMillis3 <= timeInMillis2;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private static boolean isMinRangeEdge(Calendar calendar, CalendarViewDelegate delegate) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(delegate.getMinYear(), delegate.getMinYearMonth() - 1, delegate.getMinYearDay(), 12, 0);
        long timeInMillis = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay(), 12, 0);
        return calendar2.getTimeInMillis() < timeInMillis;
    }

    public static boolean isMonthInRange(int year, int month, int minYear, int minYearMonth, int maxYear, int maxYearMonth) {
        return year >= minYear && year <= maxYear && (year != minYear || month >= minYearMonth) && (year != maxYear || month <= maxYearMonth);
    }

    public static boolean isWeekend(Calendar calendar) {
        int weekFormCalendar = getWeekFormCalendar(calendar);
        return weekFormCalendar == 0 || weekFormCalendar == 6;
    }

    private static int getMonthEndDiff(int year, int month, int day, int weekStart) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int i = calendar.get(7);
        if (weekStart == 1) {
            return 7 - i;
        }
        if (weekStart == 2) {
            if (i == 1) {
                return 0;
            }
            return (7 - i) + 1;
        }
        if (i == 7) {
            return 6;
        }
        return (7 - i) - 1;
    }

    public static int getMonthViewStartDiff(int year, int month, int weekStart) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, 1, 12, 0, 0);
        int i = calendar.get(7);
        if (weekStart == 1) {
            return i - 1;
        }
        if (weekStart == 2) {
            if (i == 1) {
                return 6;
            }
            return i - weekStart;
        }
        if (i == 7) {
            return 0;
        }
        return i;
    }

    public static int getMonthViewHeight(int year, int month, int itemHeight, int weekStartWith, int mode) {
        return mode == 0 ? itemHeight * 6 : getMonthViewHeight(year, month, itemHeight, weekStartWith);
    }

    public static boolean isCalendarInRange(Calendar calendar, CalendarViewDelegate delegate) {
        return isCalendarInRange(calendar, delegate.getMinYear(), delegate.getMinYearMonth(), delegate.getMinYearDay(), delegate.getMaxYear(), delegate.getMaxYearMonth(), delegate.getMaxYearDay());
    }
}
