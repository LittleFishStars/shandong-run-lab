package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class MultiWeekView extends BaseWeekView {
    public MultiWeekView(Context context) {
        super(context);
    }

    public boolean isCalendarSelected(Calendar calendar) {
        return !onCalendarIntercept(calendar) && this.mDelegate.mSelectedCalendars.containsKey(calendar.toString());
    }

    public final boolean isSelectNextCalendar(Calendar calendar, int calendarIndex) {
        Calendar nextCalendar;
        if (calendarIndex == this.mItems.size() - 1) {
            nextCalendar = CalendarUtil.getNextCalendar(calendar);
            this.mDelegate.updateCalendarScheme(nextCalendar);
        } else {
            nextCalendar = this.mItems.get(calendarIndex + 1);
        }
        return isCalendarSelected(nextCalendar);
    }

    public final boolean isSelectPreCalendar(Calendar calendar, int calendarIndex) {
        Calendar preCalendar;
        if (calendarIndex == 0) {
            preCalendar = CalendarUtil.getPreCalendar(calendar);
            this.mDelegate.updateCalendarScheme(preCalendar);
        } else {
            preCalendar = this.mItems.get(calendarIndex - 1);
        }
        return isCalendarSelected(preCalendar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Calendar index;
        if (this.isClick && (index = getIndex()) != null) {
            if (onCalendarIntercept(index)) {
                this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(index, true);
                return;
            }
            if (!isInRange(index)) {
                CalendarView.OnCalendarMultiSelectListener onCalendarMultiSelectListener = this.mDelegate.mCalendarMultiSelectListener;
                if (onCalendarMultiSelectListener != null) {
                    onCalendarMultiSelectListener.onCalendarMultiSelectOutOfRange(index);
                    return;
                }
                return;
            }
            String string = index.toString();
            if (this.mDelegate.mSelectedCalendars.containsKey(string)) {
                this.mDelegate.mSelectedCalendars.remove(string);
            } else {
                if (this.mDelegate.mSelectedCalendars.size() >= this.mDelegate.getMaxMultiSelectSize()) {
                    CalendarViewDelegate calendarViewDelegate = this.mDelegate;
                    CalendarView.OnCalendarMultiSelectListener onCalendarMultiSelectListener2 = calendarViewDelegate.mCalendarMultiSelectListener;
                    if (onCalendarMultiSelectListener2 != null) {
                        onCalendarMultiSelectListener2.onMultiSelectOutOfSize(index, calendarViewDelegate.getMaxMultiSelectSize());
                        return;
                    }
                    return;
                }
                this.mDelegate.mSelectedCalendars.put(string, index);
            }
            this.mCurrentItem = this.mItems.indexOf(index);
            CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
            if (onInnerDateSelectedListener != null) {
                onInnerDateSelectedListener.onWeekDateSelected(index, true);
            }
            if (this.mParentLayout != null) {
                this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(index, this.mDelegate.getWeekStart()));
            }
            CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
            CalendarView.OnCalendarMultiSelectListener onCalendarMultiSelectListener3 = calendarViewDelegate2.mCalendarMultiSelectListener;
            if (onCalendarMultiSelectListener3 != null) {
                onCalendarMultiSelectListener3.onCalendarMultiSelect(index, calendarViewDelegate2.mSelectedCalendars.size(), this.mDelegate.getMaxMultiSelectSize());
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mItems.size() == 0) {
            return;
        }
        this.mItemWidth = ((getWidth() - this.mDelegate.getCalendarPaddingLeft()) - this.mDelegate.getCalendarPaddingRight()) / 7;
        onPreviewHook();
        for (int i = 0; i < 7; i++) {
            int calendarPaddingLeft = (this.mItemWidth * i) + this.mDelegate.getCalendarPaddingLeft();
            onLoopStart(calendarPaddingLeft);
            Calendar calendar = this.mItems.get(i);
            boolean zIsCalendarSelected = isCalendarSelected(calendar);
            boolean zIsSelectPreCalendar = isSelectPreCalendar(calendar, i);
            boolean zIsSelectNextCalendar = isSelectNextCalendar(calendar, i);
            boolean zHasScheme = calendar.hasScheme();
            if (zHasScheme) {
                if ((zIsCalendarSelected ? onDrawSelected(canvas, calendar, calendarPaddingLeft, true, zIsSelectPreCalendar, zIsSelectNextCalendar) : false) || !zIsCalendarSelected) {
                    this.mSchemePaint.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor());
                    onDrawScheme(canvas, calendar, calendarPaddingLeft, zIsCalendarSelected);
                }
            } else if (zIsCalendarSelected) {
                onDrawSelected(canvas, calendar, calendarPaddingLeft, false, zIsSelectPreCalendar, zIsSelectNextCalendar);
            }
            onDrawText(canvas, calendar, calendarPaddingLeft, zHasScheme, zIsCalendarSelected);
        }
    }

    public abstract void onDrawScheme(Canvas canvas, Calendar calendar, int x, boolean isSelected);

    public abstract boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelectedPre, boolean isSelectedNext);

    public abstract void onDrawText(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelected);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        return false;
    }
}
