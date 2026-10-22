package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class RangeMonthView extends BaseMonthView {
    public RangeMonthView(Context context) {
        super(context);
    }

    private void draw(Canvas canvas, Calendar calendar, int calendarIndex, int i, int j) {
        int calendarPaddingLeft = (j * this.mItemWidth) + this.mDelegate.getCalendarPaddingLeft();
        int i2 = i * this.mItemHeight;
        onLoopStart(calendarPaddingLeft, i2);
        boolean zIsCalendarSelected = isCalendarSelected(calendar);
        boolean zHasScheme = calendar.hasScheme();
        boolean zIsSelectPreCalendar = isSelectPreCalendar(calendar, calendarIndex);
        boolean zIsSelectNextCalendar = isSelectNextCalendar(calendar, calendarIndex);
        if (zHasScheme) {
            if ((zIsCalendarSelected ? onDrawSelected(canvas, calendar, calendarPaddingLeft, i2, true, zIsSelectPreCalendar, zIsSelectNextCalendar) : false) || !zIsCalendarSelected) {
                this.mSchemePaint.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor());
                onDrawScheme(canvas, calendar, calendarPaddingLeft, i2, true);
            }
        } else if (zIsCalendarSelected) {
            onDrawSelected(canvas, calendar, calendarPaddingLeft, i2, false, zIsSelectPreCalendar, zIsSelectNextCalendar);
        }
        onDrawText(canvas, calendar, calendarPaddingLeft, i2, zHasScheme, zIsCalendarSelected);
    }

    public boolean isCalendarSelected(Calendar calendar) {
        if (this.mDelegate.mSelectedStartRangeCalendar == null || onCalendarIntercept(calendar)) {
            return false;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate.mSelectedEndRangeCalendar == null) {
            return calendar.compareTo(calendarViewDelegate.mSelectedStartRangeCalendar) == 0;
        }
        return calendar.compareTo(calendarViewDelegate.mSelectedStartRangeCalendar) >= 0 && calendar.compareTo(this.mDelegate.mSelectedEndRangeCalendar) <= 0;
    }

    public final boolean isSelectNextCalendar(Calendar calendar, int calendarIndex) {
        Calendar nextCalendar;
        if (calendarIndex == this.mItems.size() - 1) {
            nextCalendar = CalendarUtil.getNextCalendar(calendar);
            this.mDelegate.updateCalendarScheme(nextCalendar);
        } else {
            nextCalendar = this.mItems.get(calendarIndex + 1);
        }
        return this.mDelegate.mSelectedStartRangeCalendar != null && isCalendarSelected(nextCalendar);
    }

    public final boolean isSelectPreCalendar(Calendar calendar, int calendarIndex) {
        Calendar preCalendar;
        if (calendarIndex == 0) {
            preCalendar = CalendarUtil.getPreCalendar(calendar);
            this.mDelegate.updateCalendarScheme(preCalendar);
        } else {
            preCalendar = this.mItems.get(calendarIndex - 1);
        }
        return this.mDelegate.mSelectedStartRangeCalendar != null && isCalendarSelected(preCalendar);
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
                    CalendarView.OnCalendarRangeSelectListener onCalendarRangeSelectListener = this.mDelegate.mCalendarRangeSelectListener;
                    if (onCalendarRangeSelectListener != null) {
                        onCalendarRangeSelectListener.onCalendarSelectOutOfRange(index);
                        return;
                    }
                    return;
                }
                CalendarViewDelegate calendarViewDelegate = this.mDelegate;
                Calendar calendar = calendarViewDelegate.mSelectedStartRangeCalendar;
                if (calendar != null && calendarViewDelegate.mSelectedEndRangeCalendar == null) {
                    int iDiffer = CalendarUtil.differ(index, calendar);
                    if (iDiffer >= 0 && this.mDelegate.getMinSelectRange() != -1 && this.mDelegate.getMinSelectRange() > iDiffer + 1) {
                        CalendarView.OnCalendarRangeSelectListener onCalendarRangeSelectListener2 = this.mDelegate.mCalendarRangeSelectListener;
                        if (onCalendarRangeSelectListener2 != null) {
                            onCalendarRangeSelectListener2.onSelectOutOfRange(index, true);
                            return;
                        }
                        return;
                    }
                    if (this.mDelegate.getMaxSelectRange() != -1 && this.mDelegate.getMaxSelectRange() < CalendarUtil.differ(index, this.mDelegate.mSelectedStartRangeCalendar) + 1) {
                        CalendarView.OnCalendarRangeSelectListener onCalendarRangeSelectListener3 = this.mDelegate.mCalendarRangeSelectListener;
                        if (onCalendarRangeSelectListener3 != null) {
                            onCalendarRangeSelectListener3.onSelectOutOfRange(index, false);
                            return;
                        }
                        return;
                    }
                }
                CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
                Calendar calendar2 = calendarViewDelegate2.mSelectedStartRangeCalendar;
                if (calendar2 == null || calendarViewDelegate2.mSelectedEndRangeCalendar != null) {
                    calendarViewDelegate2.mSelectedStartRangeCalendar = index;
                    calendarViewDelegate2.mSelectedEndRangeCalendar = null;
                } else {
                    int iCompareTo = index.compareTo(calendar2);
                    if (this.mDelegate.getMinSelectRange() == -1 && iCompareTo <= 0) {
                        CalendarViewDelegate calendarViewDelegate3 = this.mDelegate;
                        calendarViewDelegate3.mSelectedStartRangeCalendar = index;
                        calendarViewDelegate3.mSelectedEndRangeCalendar = null;
                    } else if (iCompareTo < 0) {
                        CalendarViewDelegate calendarViewDelegate4 = this.mDelegate;
                        calendarViewDelegate4.mSelectedStartRangeCalendar = index;
                        calendarViewDelegate4.mSelectedEndRangeCalendar = null;
                    } else if (iCompareTo != 0 || this.mDelegate.getMinSelectRange() == 1) {
                        this.mDelegate.mSelectedEndRangeCalendar = index;
                    } else {
                        this.mDelegate.mSelectedEndRangeCalendar = index;
                    }
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
                CalendarViewDelegate calendarViewDelegate5 = this.mDelegate;
                CalendarView.OnCalendarRangeSelectListener onCalendarRangeSelectListener4 = calendarViewDelegate5.mCalendarRangeSelectListener;
                if (onCalendarRangeSelectListener4 != null) {
                    onCalendarRangeSelectListener4.onCalendarRangeSelect(index, calendarViewDelegate5.mSelectedEndRangeCalendar != null);
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
                draw(canvas, calendar, i4, i3, i5);
                i4++;
            }
            i3++;
            i2 = i4;
        }
    }

    public abstract void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y, boolean isSelected);

    public abstract boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelectedPre, boolean isSelectedNext);

    public abstract void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        return false;
    }
}
