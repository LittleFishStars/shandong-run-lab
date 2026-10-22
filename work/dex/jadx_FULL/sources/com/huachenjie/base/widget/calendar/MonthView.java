package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class MonthView extends BaseMonthView {
    public MonthView(Context context) {
        super(context);
    }

    private void draw(Canvas canvas, Calendar calendar, int i, int j, int d) {
        int calendarPaddingLeft = (j * this.mItemWidth) + this.mDelegate.getCalendarPaddingLeft();
        int i2 = i * this.mItemHeight;
        onLoopStart(calendarPaddingLeft, i2);
        boolean z = d == this.mCurrentItem;
        boolean zHasScheme = calendar.hasScheme();
        if (zHasScheme) {
            if ((z ? onDrawSelected(canvas, calendar, calendarPaddingLeft, i2, true) : false) || !z) {
                this.mSchemePaint.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor());
                onDrawScheme(canvas, calendar, calendarPaddingLeft, i2);
            }
        } else if (z) {
            onDrawSelected(canvas, calendar, calendarPaddingLeft, i2, false);
        }
        onDrawText(canvas, calendar, calendarPaddingLeft, i2, zHasScheme, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Calendar index;
        MonthViewPager monthViewPager;
        if (this.isClick && (index = getIndex()) != null) {
            if (this.mDelegate.getMonthViewShowMode() != 1 || index.isCurrentMonth()) {
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
                if (!index.isCurrentMonth() && (monthViewPager = this.mMonthViewPager) != null) {
                    int currentItem = monthViewPager.getCurrentItem();
                    this.mMonthViewPager.setCurrentItem(this.mCurrentItem < 7 ? currentItem - 1 : currentItem + 1);
                }
                CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
                if (onInnerDateSelectedListener != null) {
                    onInnerDateSelectedListener.onMonthDateSelected(index, true);
                }
                if (this.mParentLayout != null) {
                    if (index.isCurrentMonth()) {
                        this.mParentLayout.updateSelectPosition(this.mItems.indexOf(index));
                    } else {
                        this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(index, this.mDelegate.getWeekStart()));
                    }
                }
                CalendarView.OnCalendarSelectListener onCalendarSelectListener2 = this.mDelegate.mCalendarSelectListener;
                if (onCalendarSelectListener2 != null) {
                    onCalendarSelectListener2.onCalendarSelect(index, true);
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mLineCount == 0) {
            return;
        }
        this.mItemWidth = ((getWidth() - this.mDelegate.getCalendarPaddingLeft()) - this.mDelegate.getCalendarPaddingRight()) / 7;
        onPreviewHook();
        int i = this.mLineCount * 7;
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.mLineCount) {
            int i4 = i2;
            for (int i5 = 0; i5 < 7; i5++) {
                Calendar calendar = this.mItems.get(i4);
                if (this.mDelegate.getMonthViewShowMode() == 1) {
                    if (i4 > this.mItems.size() - this.mNextDiff) {
                        return;
                    }
                    if (!calendar.isCurrentMonth()) {
                    }
                    i4++;
                } else if (this.mDelegate.getMonthViewShowMode() == 2 && i4 >= i) {
                    return;
                }
                draw(canvas, calendar, i3, i5, i4);
                i4++;
            }
            i3++;
            i2 = i4;
        }
    }

    public abstract void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y);

    public abstract boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme);

    public abstract void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        Calendar index;
        MonthViewPager monthViewPager;
        if (this.mDelegate.mCalendarLongClickListener == null || !this.isClick || (index = getIndex()) == null) {
            return false;
        }
        if (this.mDelegate.getMonthViewShowMode() == 1 && !index.isCurrentMonth()) {
            return false;
        }
        if (onCalendarIntercept(index)) {
            this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(index, true);
            return false;
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
        if (!index.isCurrentMonth() && (monthViewPager = this.mMonthViewPager) != null) {
            int currentItem = monthViewPager.getCurrentItem();
            this.mMonthViewPager.setCurrentItem(this.mCurrentItem < 7 ? currentItem - 1 : currentItem + 1);
        }
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
        if (onInnerDateSelectedListener != null) {
            onInnerDateSelectedListener.onMonthDateSelected(index, true);
        }
        if (this.mParentLayout != null) {
            if (index.isCurrentMonth()) {
                this.mParentLayout.updateSelectPosition(this.mItems.indexOf(index));
            } else {
                this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(index, this.mDelegate.getWeekStart()));
            }
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
