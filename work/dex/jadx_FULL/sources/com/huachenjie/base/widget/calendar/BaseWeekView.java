package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseWeekView extends BaseView {
    public BaseWeekView(Context context) {
        super(context);
    }

    private void onClickCalendarPadding() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate.mClickCalendarPaddingListener == null) {
            return;
        }
        int calendarPaddingLeft = ((int) (this.mX - calendarViewDelegate.getCalendarPaddingLeft())) / this.mItemWidth;
        if (calendarPaddingLeft >= 7) {
            calendarPaddingLeft = 6;
        }
        int i = ((((int) this.mY) / this.mItemHeight) * 7) + calendarPaddingLeft;
        Calendar calendar = (i < 0 || i >= this.mItems.size()) ? null : this.mItems.get(i);
        if (calendar == null) {
            return;
        }
        CalendarView.OnClickCalendarPaddingListener onClickCalendarPaddingListener = this.mDelegate.mClickCalendarPaddingListener;
        float f = this.mX;
        float f2 = this.mY;
        onClickCalendarPaddingListener.onClickCalendarPadding(f, f2, false, calendar, getClickCalendarPaddingObject(f, f2, calendar));
    }

    public Object getClickCalendarPaddingObject(float x, float y, Calendar adjacentCalendar) {
        return null;
    }

    public final int getEdgeIndex(boolean isMinEdge) {
        for (int i = 0; i < this.mItems.size(); i++) {
            boolean zIsInRange = isInRange(this.mItems.get(i));
            if (isMinEdge && zIsInRange) {
                return i;
            }
            if (!isMinEdge && !zIsInRange) {
                return i - 1;
            }
        }
        return isMinEdge ? 6 : 0;
    }

    public Calendar getIndex() {
        if (this.mX <= this.mDelegate.getCalendarPaddingLeft() || this.mX >= getWidth() - this.mDelegate.getCalendarPaddingRight()) {
            onClickCalendarPadding();
            return null;
        }
        int calendarPaddingLeft = ((int) (this.mX - this.mDelegate.getCalendarPaddingLeft())) / this.mItemWidth;
        if (calendarPaddingLeft >= 7) {
            calendarPaddingLeft = 6;
        }
        int i = ((((int) this.mY) / this.mItemHeight) * 7) + calendarPaddingLeft;
        if (i < 0 || i >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(i);
    }

    public final boolean isMinRangeEdge(Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.set(this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth() - 1, this.mDelegate.getMinYearDay());
        long timeInMillis = calendar2.getTimeInMillis();
        calendar2.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        return calendar2.getTimeInMillis() < timeInMillis;
    }

    @Override // com.huachenjie.base.widget.calendar.BaseView
    public void onDestroy() {
    }

    public void onLoopStart(int x) {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
    }

    @Override // com.huachenjie.base.widget.calendar.BaseView
    public void onPreviewHook() {
    }

    public final void performClickCalendar(Calendar calendar, boolean isNotice) {
        List<Calendar> list;
        CalendarViewDelegate calendarViewDelegate;
        CalendarView.OnYearChangeListener onYearChangeListener;
        if (this.mParentLayout == null || this.mDelegate.mInnerListener == null || (list = this.mItems) == null || list.size() == 0) {
            return;
        }
        int weekViewIndexFromCalendar = CalendarUtil.getWeekViewIndexFromCalendar(calendar, this.mDelegate.getWeekStart());
        if (this.mItems.contains(this.mDelegate.getCurrentDay())) {
            weekViewIndexFromCalendar = CalendarUtil.getWeekViewIndexFromCalendar(this.mDelegate.getCurrentDay(), this.mDelegate.getWeekStart());
        }
        Calendar calendar2 = this.mItems.get(weekViewIndexFromCalendar);
        if (this.mDelegate.getSelectMode() != 0) {
            if (this.mItems.contains(this.mDelegate.mSelectedCalendar)) {
                calendar2 = this.mDelegate.mSelectedCalendar;
            } else {
                this.mCurrentItem = -1;
            }
        }
        if (!isInRange(calendar2)) {
            weekViewIndexFromCalendar = getEdgeIndex(isMinRangeEdge(calendar2));
            calendar2 = this.mItems.get(weekViewIndexFromCalendar);
        }
        calendar2.setCurrentDay(calendar2.equals(this.mDelegate.getCurrentDay()));
        this.mDelegate.mInnerListener.onWeekDateSelected(calendar2, false);
        this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendar2, this.mDelegate.getWeekStart()));
        CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
        if (calendarViewDelegate2.mCalendarSelectListener != null && isNotice && calendarViewDelegate2.getSelectMode() == 0) {
            this.mDelegate.mCalendarSelectListener.onCalendarSelect(calendar2, false);
        }
        this.mParentLayout.updateContentViewTranslateY();
        if (this.mDelegate.getSelectMode() == 0) {
            this.mCurrentItem = weekViewIndexFromCalendar;
        }
        CalendarViewDelegate calendarViewDelegate3 = this.mDelegate;
        if (!calendarViewDelegate3.isShowYearSelectedLayout && calendarViewDelegate3.mIndexCalendar != null && calendar.getYear() != this.mDelegate.mIndexCalendar.getYear() && (onYearChangeListener = (calendarViewDelegate = this.mDelegate).mYearChangeListener) != null) {
            onYearChangeListener.onYearChange(calendarViewDelegate.mIndexCalendar.getYear());
        }
        this.mDelegate.mIndexCalendar = calendar2;
        invalidate();
    }

    public final void setSelectedCalendar(Calendar calendar) {
        if (this.mDelegate.getSelectMode() != 1 || calendar.equals(this.mDelegate.mSelectedCalendar)) {
            this.mCurrentItem = this.mItems.indexOf(calendar);
        }
    }

    public final void setup(Calendar calendar) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        this.mItems = CalendarUtil.initCalendarForWeekView(calendar, calendarViewDelegate, calendarViewDelegate.getWeekStart());
        addSchemesFromMap();
        invalidate();
    }

    @Override // com.huachenjie.base.widget.calendar.BaseView
    public void updateCurrentDate() {
        List<Calendar> list = this.mItems;
        if (list == null) {
            return;
        }
        if (list.contains(this.mDelegate.getCurrentDay())) {
            Iterator<Calendar> it = this.mItems.iterator();
            while (it.hasNext()) {
                it.next().setCurrentDay(false);
            }
            this.mItems.get(this.mItems.indexOf(this.mDelegate.getCurrentDay())).setCurrentDay(true);
        }
        invalidate();
    }

    public final void updateShowMode() {
        invalidate();
    }

    public final void updateSingleSelect() {
        if (this.mItems.contains(this.mDelegate.mSelectedCalendar)) {
            return;
        }
        this.mCurrentItem = -1;
        invalidate();
    }

    public final void updateWeekStart() {
        Calendar firstCalendarStartWithMinCalendar = CalendarUtil.getFirstCalendarStartWithMinCalendar(this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth(), this.mDelegate.getMinYearDay(), ((Integer) getTag()).intValue() + 1, this.mDelegate.getWeekStart());
        setSelectedCalendar(this.mDelegate.mSelectedCalendar);
        setup(firstCalendarStartWithMinCalendar);
    }
}
