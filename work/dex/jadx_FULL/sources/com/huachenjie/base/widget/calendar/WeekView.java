package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class WeekView extends BaseWeekView {
    public WeekView(Context context) {
        super(context);
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
                CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.mCalendarSelectListener;
                if (onCalendarSelectListener != null) {
                    onCalendarSelectListener.onCalendarOutOfRange(index);
                    return;
                }
                return;
            }
            this.mCurrentItem = this.mItems.indexOf(index);
            CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
            if (onInnerDateSelectedListener != null) {
                onInnerDateSelectedListener.onWeekDateSelected(index, true);
            }
            if (this.mParentLayout != null) {
                this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(index, this.mDelegate.getWeekStart()));
            }
            CalendarView.OnCalendarSelectListener onCalendarSelectListener2 = this.mDelegate.mCalendarSelectListener;
            if (onCalendarSelectListener2 != null) {
                onCalendarSelectListener2.onCalendarSelect(index, true);
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
        int i = 0;
        while (i < this.mItems.size()) {
            int calendarPaddingLeft = (this.mItemWidth * i) + this.mDelegate.getCalendarPaddingLeft();
            onLoopStart(calendarPaddingLeft);
            Calendar calendar = this.mItems.get(i);
            boolean z = i == this.mCurrentItem;
            boolean zHasScheme = calendar.hasScheme();
            if (zHasScheme) {
                if ((z ? onDrawSelected(canvas, calendar, calendarPaddingLeft, true) : false) || !z) {
                    this.mSchemePaint.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor());
                    onDrawScheme(canvas, calendar, calendarPaddingLeft);
                }
            } else if (z) {
                onDrawSelected(canvas, calendar, calendarPaddingLeft, false);
            }
            onDrawText(canvas, calendar, calendarPaddingLeft, zHasScheme, z);
            i++;
        }
    }

    public abstract void onDrawScheme(Canvas canvas, Calendar calendar, int x);

    public abstract boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, boolean hasScheme);

    public abstract void onDrawText(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelected);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        Calendar index;
        if (this.mDelegate.mCalendarLongClickListener == null || !this.isClick || (index = getIndex()) == null) {
            return false;
        }
        if (onCalendarIntercept(index)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(index, true);
            return true;
        }
        if (!isInRange(index)) {
            CalendarView.OnCalendarLongClickListener onCalendarLongClickListener = this.mDelegate.mCalendarLongClickListener;
            if (onCalendarLongClickListener != null) {
                onCalendarLongClickListener.onCalendarLongClickOutOfRange(index);
            }
            return true;
        }
        if (this.mDelegate.isPreventLongPressedSelected()) {
            CalendarView.OnCalendarLongClickListener onCalendarLongClickListener2 = this.mDelegate.mCalendarLongClickListener;
            if (onCalendarLongClickListener2 != null) {
                onCalendarLongClickListener2.onCalendarLongClick(index);
            }
            return true;
        }
        this.mCurrentItem = this.mItems.indexOf(index);
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mIndexCalendar = calendarViewDelegate.mSelectedCalendar;
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = calendarViewDelegate.mInnerListener;
        if (onInnerDateSelectedListener != null) {
            onInnerDateSelectedListener.onWeekDateSelected(index, true);
        }
        if (this.mParentLayout != null) {
            this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(index, this.mDelegate.getWeekStart()));
        }
        CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.mCalendarSelectListener;
        if (onCalendarSelectListener != null) {
            onCalendarSelectListener.onCalendarSelect(index, true);
        }
        CalendarView.OnCalendarLongClickListener onCalendarLongClickListener3 = this.mDelegate.mCalendarLongClickListener;
        if (onCalendarLongClickListener3 != null) {
            onCalendarLongClickListener3.onCalendarLongClick(index);
        }
        invalidate();
        return true;
    }
}
