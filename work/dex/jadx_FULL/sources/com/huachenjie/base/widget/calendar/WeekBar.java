package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class WeekBar extends LinearLayout {
    private CalendarViewDelegate mDelegate;

    public WeekBar(Context context) {
        super(context);
        if ("com.huachenjie.base.widget.calendar.WeekBar".equals(getClass().getName())) {
            LayoutInflater.from(context).inflate(R.layout.cv_week_bar, (ViewGroup) this, true);
        }
    }

    private String getWeekString(int index, int weekStart) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.week_string_array);
        if (weekStart == 1) {
            return stringArray[index];
        }
        if (weekStart == 2) {
            return stringArray[index == 6 ? 0 : index + 1];
        }
        return stringArray[index != 0 ? index - 1 : 6];
    }

    public int getViewIndexByCalendar(Calendar calendar, int weekStart) {
        int week = calendar.getWeek() + 1;
        if (weekStart == 1) {
            return week - 1;
        }
        if (weekStart == 2) {
            if (week == 1) {
                return 6;
            }
            return week - 2;
        }
        if (week == 7) {
            return 0;
        }
        return week;
    }

    public void onDateSelected(Calendar calendar, int weekStart, boolean isClick) {
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        super.onMeasure(widthMeasureSpec, calendarViewDelegate != null ? View.MeasureSpec.makeMeasureSpec(calendarViewDelegate.getWeekBarHeight(), 1073741824) : View.MeasureSpec.makeMeasureSpec(CalendarUtil.dipToPx(getContext(), 40.0f), 1073741824));
    }

    public void onWeekStartChange(int weekStart) {
        if ("com.huachenjie.base.widget.calendar.WeekBar".equalsIgnoreCase(getClass().getName())) {
            for (int i = 0; i < getChildCount(); i++) {
                ((TextView) getChildAt(i)).setText(getWeekString(i, weekStart));
            }
        }
    }

    public void setTextColor(int color) {
        for (int i = 0; i < getChildCount(); i++) {
            ((TextView) getChildAt(i)).setTextColor(color);
        }
    }

    public void setTextSize(int size) {
        for (int i = 0; i < getChildCount(); i++) {
            ((TextView) getChildAt(i)).setTextSize(0, size);
        }
    }

    public void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        if ("com.huachenjie.base.widget.calendar.WeekBar".equalsIgnoreCase(getClass().getName())) {
            setTextSize(this.mDelegate.getWeekTextSize());
            setTextColor(delegate.getWeekTextColor());
            setBackgroundColor(delegate.getWeekBackground());
            setPadding(delegate.getCalendarPaddingLeft(), 0, delegate.getCalendarPaddingRight(), 0);
        }
    }
}
