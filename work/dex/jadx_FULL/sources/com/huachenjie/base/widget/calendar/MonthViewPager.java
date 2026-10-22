package com.huachenjie.base.widget.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class MonthViewPager extends ViewPager {
    private boolean isUpdateMonthView;
    private boolean isUsingScrollToCalendar;
    private int mCurrentViewHeight;
    private CalendarViewDelegate mDelegate;
    private int mMonthCount;
    private int mNextViewHeight;
    CalendarLayout mParentLayout;
    private int mPreViewHeight;
    WeekBar mWeekBar;
    WeekViewPager mWeekPager;

    public final class MonthViewPagerAdapter extends PagerAdapter {
        private MonthViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            BaseView baseView = (BaseView) object;
            baseView.onDestroy();
            container.removeView(baseView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MonthViewPager.this.mMonthCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object object) {
            if (MonthViewPager.this.isUpdateMonthView) {
                return -2;
            }
            return super.getItemPosition(object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            int minYearMonth = (((MonthViewPager.this.mDelegate.getMinYearMonth() + position) - 1) / 12) + MonthViewPager.this.mDelegate.getMinYear();
            int minYearMonth2 = (((MonthViewPager.this.mDelegate.getMinYearMonth() + position) - 1) % 12) + 1;
            try {
                BaseMonthView baseMonthView = (BaseMonthView) MonthViewPager.this.mDelegate.getMonthViewClass().getConstructor(Context.class).newInstance(MonthViewPager.this.getContext());
                MonthViewPager monthViewPager = MonthViewPager.this;
                baseMonthView.mMonthViewPager = monthViewPager;
                baseMonthView.mParentLayout = monthViewPager.mParentLayout;
                baseMonthView.setup(monthViewPager.mDelegate);
                baseMonthView.setTag(Integer.valueOf(position));
                baseMonthView.initMonthWithDate(minYearMonth, minYearMonth2);
                baseMonthView.setSelectedCalendar(MonthViewPager.this.mDelegate.mSelectedCalendar);
                container.addView(baseMonthView);
                return baseMonthView;
            } catch (Exception e) {
                e.printStackTrace();
                return new DefaultMonthView(MonthViewPager.this.getContext());
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, @NonNull Object object) {
            return view.equals(object);
        }
    }

    public MonthViewPager(Context context) {
        this(context, null);
    }

    private void init() {
        this.mMonthCount = (((this.mDelegate.getMaxYear() - this.mDelegate.getMinYear()) * 12) - this.mDelegate.getMinYearMonth()) + 1 + this.mDelegate.getMaxYearMonth();
        setAdapter(new MonthViewPagerAdapter());
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.huachenjie.base.widget.calendar.MonthViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                float f;
                int i;
                if (MonthViewPager.this.mDelegate.getMonthViewShowMode() == 0) {
                    return;
                }
                if (position < MonthViewPager.this.getCurrentItem()) {
                    f = MonthViewPager.this.mPreViewHeight * (1.0f - positionOffset);
                    i = MonthViewPager.this.mCurrentViewHeight;
                } else {
                    f = MonthViewPager.this.mCurrentViewHeight * (1.0f - positionOffset);
                    i = MonthViewPager.this.mNextViewHeight;
                }
                int i2 = (int) (f + (i * positionOffset));
                ViewGroup.LayoutParams layoutParams = MonthViewPager.this.getLayoutParams();
                layoutParams.height = i2;
                MonthViewPager.this.setLayoutParams(layoutParams);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                CalendarLayout calendarLayout;
                Calendar firstCalendarFromMonthViewPager = CalendarUtil.getFirstCalendarFromMonthViewPager(position, MonthViewPager.this.mDelegate);
                if (MonthViewPager.this.getVisibility() == 0) {
                    if (!MonthViewPager.this.mDelegate.isShowYearSelectedLayout && MonthViewPager.this.mDelegate.mIndexCalendar != null && firstCalendarFromMonthViewPager.getYear() != MonthViewPager.this.mDelegate.mIndexCalendar.getYear() && MonthViewPager.this.mDelegate.mYearChangeListener != null) {
                        MonthViewPager.this.mDelegate.mYearChangeListener.onYearChange(firstCalendarFromMonthViewPager.getYear());
                    }
                    MonthViewPager.this.mDelegate.mIndexCalendar = firstCalendarFromMonthViewPager;
                }
                if (MonthViewPager.this.mDelegate.mMonthChangeListener != null) {
                    MonthViewPager.this.mDelegate.mMonthChangeListener.onMonthChange(firstCalendarFromMonthViewPager.getYear(), firstCalendarFromMonthViewPager.getMonth());
                }
                if (MonthViewPager.this.mWeekPager.getVisibility() == 0) {
                    MonthViewPager.this.updateMonthViewHeight(firstCalendarFromMonthViewPager.getYear(), firstCalendarFromMonthViewPager.getMonth());
                    return;
                }
                if (MonthViewPager.this.mDelegate.getSelectMode() == 0) {
                    if (firstCalendarFromMonthViewPager.isCurrentMonth()) {
                        MonthViewPager.this.mDelegate.mSelectedCalendar = CalendarUtil.getRangeEdgeCalendar(firstCalendarFromMonthViewPager, MonthViewPager.this.mDelegate);
                    } else {
                        MonthViewPager.this.mDelegate.mSelectedCalendar = firstCalendarFromMonthViewPager;
                    }
                    MonthViewPager.this.mDelegate.mIndexCalendar = MonthViewPager.this.mDelegate.mSelectedCalendar;
                } else if (MonthViewPager.this.mDelegate.mSelectedStartRangeCalendar != null && MonthViewPager.this.mDelegate.mSelectedStartRangeCalendar.isSameMonth(MonthViewPager.this.mDelegate.mIndexCalendar)) {
                    MonthViewPager.this.mDelegate.mIndexCalendar = MonthViewPager.this.mDelegate.mSelectedStartRangeCalendar;
                } else if (firstCalendarFromMonthViewPager.isSameMonth(MonthViewPager.this.mDelegate.mSelectedCalendar)) {
                    MonthViewPager.this.mDelegate.mIndexCalendar = MonthViewPager.this.mDelegate.mSelectedCalendar;
                }
                MonthViewPager.this.mDelegate.updateSelectCalendarScheme();
                if (!MonthViewPager.this.isUsingScrollToCalendar && MonthViewPager.this.mDelegate.getSelectMode() == 0) {
                    MonthViewPager monthViewPager = MonthViewPager.this;
                    monthViewPager.mWeekBar.onDateSelected(monthViewPager.mDelegate.mSelectedCalendar, MonthViewPager.this.mDelegate.getWeekStart(), false);
                    if (MonthViewPager.this.mDelegate.mCalendarSelectListener != null) {
                        MonthViewPager.this.mDelegate.mCalendarSelectListener.onCalendarSelect(MonthViewPager.this.mDelegate.mSelectedCalendar, false);
                    }
                }
                BaseMonthView baseMonthView = (BaseMonthView) MonthViewPager.this.findViewWithTag(Integer.valueOf(position));
                if (baseMonthView != null) {
                    int selectedIndex = baseMonthView.getSelectedIndex(MonthViewPager.this.mDelegate.mIndexCalendar);
                    if (MonthViewPager.this.mDelegate.getSelectMode() == 0) {
                        baseMonthView.mCurrentItem = selectedIndex;
                    }
                    if (selectedIndex >= 0 && (calendarLayout = MonthViewPager.this.mParentLayout) != null) {
                        calendarLayout.updateSelectPosition(selectedIndex);
                    }
                    baseMonthView.invalidate();
                }
                MonthViewPager monthViewPager2 = MonthViewPager.this;
                monthViewPager2.mWeekPager.updateSelected(monthViewPager2.mDelegate.mIndexCalendar, false);
                MonthViewPager.this.updateMonthViewHeight(firstCalendarFromMonthViewPager.getYear(), firstCalendarFromMonthViewPager.getMonth());
                MonthViewPager.this.isUsingScrollToCalendar = false;
            }
        });
    }

    private void notifyAdapterDataSetChanged() {
        if (getAdapter() == null) {
            return;
        }
        getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMonthViewHeight(int year, int month) {
        if (this.mDelegate.getMonthViewShowMode() == 0) {
            this.mCurrentViewHeight = this.mDelegate.getCalendarItemHeight() * 6;
            getLayoutParams().height = this.mCurrentViewHeight;
            return;
        }
        if (this.mParentLayout != null) {
            if (getVisibility() != 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = CalendarUtil.getMonthViewHeight(year, month, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
                setLayoutParams(layoutParams);
            }
            this.mParentLayout.updateContentViewTranslateY();
        }
        this.mCurrentViewHeight = CalendarUtil.getMonthViewHeight(year, month, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        if (month == 1) {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight(year - 1, 12, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
            this.mNextViewHeight = CalendarUtil.getMonthViewHeight(year, 2, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
            return;
        }
        this.mPreViewHeight = CalendarUtil.getMonthViewHeight(year, month - 1, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        if (month == 12) {
            this.mNextViewHeight = CalendarUtil.getMonthViewHeight(year + 1, 1, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        } else {
            this.mNextViewHeight = CalendarUtil.getMonthViewHeight(year, month + 1, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        }
    }

    public final void clearMultiSelect() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.mCurrentItem = -1;
            baseMonthView.invalidate();
        }
    }

    public final void clearSelectRange() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseMonthView) getChildAt(i)).invalidate();
        }
    }

    public final void clearSingleSelect() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.mCurrentItem = -1;
            baseMonthView.invalidate();
        }
    }

    public List<Calendar> getCurrentMonthCalendars() {
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (baseMonthView == null) {
            return null;
        }
        return baseMonthView.mItems;
    }

    public void notifyDataSetChanged() {
        this.mMonthCount = (((this.mDelegate.getMaxYear() - this.mDelegate.getMinYear()) * 12) - this.mDelegate.getMinYearMonth()) + 1 + this.mDelegate.getMaxYearMonth();
        notifyAdapterDataSetChanged();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.mDelegate.isMonthViewScrollable() && super.onInterceptTouchEvent(ev);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent ev) {
        return this.mDelegate.isMonthViewScrollable() && super.onTouchEvent(ev);
    }

    public void scrollToCalendar(int year, int month, int day, boolean smoothScroll, boolean invokeListener) {
        this.isUsingScrollToCalendar = true;
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setCurrentDay(calendar.equals(this.mDelegate.getCurrentDay()));
        LunarCalendar.setupLunarCalendar(calendar);
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mIndexCalendar = calendar;
        calendarViewDelegate.mSelectedCalendar = calendar;
        calendarViewDelegate.updateSelectCalendarScheme();
        int year2 = (((calendar.getYear() - this.mDelegate.getMinYear()) * 12) + calendar.getMonth()) - this.mDelegate.getMinYearMonth();
        if (getCurrentItem() == year2) {
            this.isUsingScrollToCalendar = false;
        }
        setCurrentItem(year2, smoothScroll);
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(year2));
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.mIndexCalendar);
            baseMonthView.invalidate();
            CalendarLayout calendarLayout = this.mParentLayout;
            if (calendarLayout != null) {
                calendarLayout.updateSelectPosition(baseMonthView.getSelectedIndex(this.mDelegate.mIndexCalendar));
            }
        }
        if (this.mParentLayout != null) {
            this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendar, this.mDelegate.getWeekStart()));
        }
        CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.mCalendarSelectListener;
        if (onCalendarSelectListener != null && invokeListener) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
        if (onInnerDateSelectedListener != null) {
            onInnerDateSelectedListener.onMonthDateSelected(calendar, false);
        }
        updateSelected();
    }

    public void scrollToCurrent(boolean smoothScroll) {
        this.isUsingScrollToCalendar = true;
        int year = (((this.mDelegate.getCurrentDay().getYear() - this.mDelegate.getMinYear()) * 12) + this.mDelegate.getCurrentDay().getMonth()) - this.mDelegate.getMinYearMonth();
        if (getCurrentItem() == year) {
            this.isUsingScrollToCalendar = false;
        }
        setCurrentItem(year, smoothScroll);
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(year));
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.getCurrentDay());
            baseMonthView.invalidate();
            CalendarLayout calendarLayout = this.mParentLayout;
            if (calendarLayout != null) {
                calendarLayout.updateSelectPosition(baseMonthView.getSelectedIndex(this.mDelegate.getCurrentDay()));
            }
        }
        if (this.mDelegate.mCalendarSelectListener == null || getVisibility() != 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mCalendarSelectListener.onCalendarSelect(calendarViewDelegate.mSelectedCalendar, false);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item) {
        setCurrentItem(item, true);
    }

    public void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        updateMonthViewHeight(delegate.getCurrentDay().getYear(), this.mDelegate.getCurrentDay().getMonth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.mCurrentViewHeight;
        setLayoutParams(layoutParams);
        init();
    }

    public void updateCurrentDate() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseMonthView) getChildAt(i)).updateCurrentDate();
        }
    }

    public void updateDefaultSelect() {
        CalendarLayout calendarLayout;
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (baseMonthView != null) {
            int selectedIndex = baseMonthView.getSelectedIndex(this.mDelegate.mSelectedCalendar);
            baseMonthView.mCurrentItem = selectedIndex;
            if (selectedIndex >= 0 && (calendarLayout = this.mParentLayout) != null) {
                calendarLayout.updateSelectPosition(selectedIndex);
            }
            baseMonthView.invalidate();
        }
    }

    public final void updateItemHeight() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.updateItemHeight();
            baseMonthView.requestLayout();
        }
        int year = this.mDelegate.mIndexCalendar.getYear();
        int month = this.mDelegate.mIndexCalendar.getMonth();
        this.mCurrentViewHeight = CalendarUtil.getMonthViewHeight(year, month, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        if (month == 1) {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight(year - 1, 12, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
            this.mNextViewHeight = CalendarUtil.getMonthViewHeight(year, 2, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        } else {
            this.mPreViewHeight = CalendarUtil.getMonthViewHeight(year, month - 1, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
            if (month == 12) {
                this.mNextViewHeight = CalendarUtil.getMonthViewHeight(year + 1, 1, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
            } else {
                this.mNextViewHeight = CalendarUtil.getMonthViewHeight(year, month + 1, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.mCurrentViewHeight;
        setLayoutParams(layoutParams);
    }

    public void updateMonthViewClass() {
        this.isUpdateMonthView = true;
        notifyAdapterDataSetChanged();
        this.isUpdateMonthView = false;
    }

    public final void updateRange() {
        this.isUpdateMonthView = true;
        notifyDataSetChanged();
        this.isUpdateMonthView = false;
        if (getVisibility() != 0) {
            return;
        }
        this.isUsingScrollToCalendar = false;
        Calendar calendar = this.mDelegate.mSelectedCalendar;
        int year = (((calendar.getYear() - this.mDelegate.getMinYear()) * 12) + calendar.getMonth()) - this.mDelegate.getMinYearMonth();
        setCurrentItem(year, false);
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(year));
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.mIndexCalendar);
            baseMonthView.invalidate();
            CalendarLayout calendarLayout = this.mParentLayout;
            if (calendarLayout != null) {
                calendarLayout.updateSelectPosition(baseMonthView.getSelectedIndex(this.mDelegate.mIndexCalendar));
            }
        }
        if (this.mParentLayout != null) {
            this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendar, this.mDelegate.getWeekStart()));
        }
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
        if (onInnerDateSelectedListener != null) {
            onInnerDateSelectedListener.onMonthDateSelected(calendar, false);
        }
        CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.mCalendarSelectListener;
        if (onCalendarSelectListener != null) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        updateSelected();
    }

    public void updateScheme() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseMonthView) getChildAt(i)).update();
        }
    }

    public void updateSelected() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
            baseMonthView.invalidate();
        }
    }

    public void updateShowMode() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.updateShowMode();
            baseMonthView.requestLayout();
        }
        if (this.mDelegate.getMonthViewShowMode() == 0) {
            int calendarItemHeight = this.mDelegate.getCalendarItemHeight() * 6;
            this.mCurrentViewHeight = calendarItemHeight;
            this.mNextViewHeight = calendarItemHeight;
            this.mPreViewHeight = calendarItemHeight;
        } else {
            updateMonthViewHeight(this.mDelegate.mSelectedCalendar.getYear(), this.mDelegate.mSelectedCalendar.getMonth());
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.mCurrentViewHeight;
        setLayoutParams(layoutParams);
        CalendarLayout calendarLayout = this.mParentLayout;
        if (calendarLayout != null) {
            calendarLayout.updateContentViewTranslateY();
        }
    }

    public final void updateStyle() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.updateStyle();
            baseMonthView.invalidate();
        }
    }

    public void updateWeekStart() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.updateWeekStart();
            baseMonthView.requestLayout();
        }
        updateMonthViewHeight(this.mDelegate.mSelectedCalendar.getYear(), this.mDelegate.mSelectedCalendar.getMonth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.mCurrentViewHeight;
        setLayoutParams(layoutParams);
        if (this.mParentLayout != null) {
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendarViewDelegate.mSelectedCalendar, calendarViewDelegate.getWeekStart()));
        }
        updateSelected();
    }

    public MonthViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isUsingScrollToCalendar = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (Math.abs(getCurrentItem() - item) > 1) {
            super.setCurrentItem(item, false);
        } else {
            super.setCurrentItem(item, smoothScroll);
        }
    }
}
