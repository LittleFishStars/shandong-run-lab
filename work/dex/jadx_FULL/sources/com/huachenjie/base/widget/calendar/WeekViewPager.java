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
public final class WeekViewPager extends ViewPager {
    private boolean isUpdateWeekView;
    private boolean isUsingScrollToCalendar;
    private CalendarViewDelegate mDelegate;
    CalendarLayout mParentLayout;
    private int mWeekCount;

    public class WeekViewPagerAdapter extends PagerAdapter {
        private WeekViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            BaseWeekView baseWeekView = (BaseWeekView) object;
            baseWeekView.onDestroy();
            container.removeView(baseWeekView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return WeekViewPager.this.mWeekCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object object) {
            if (WeekViewPager.this.isUpdateWeekView) {
                return -2;
            }
            return super.getItemPosition(object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            Calendar firstCalendarStartWithMinCalendar = CalendarUtil.getFirstCalendarStartWithMinCalendar(WeekViewPager.this.mDelegate.getMinYear(), WeekViewPager.this.mDelegate.getMinYearMonth(), WeekViewPager.this.mDelegate.getMinYearDay(), position + 1, WeekViewPager.this.mDelegate.getWeekStart());
            try {
                BaseWeekView baseWeekView = (BaseWeekView) WeekViewPager.this.mDelegate.getWeekViewClass().getConstructor(Context.class).newInstance(WeekViewPager.this.getContext());
                WeekViewPager weekViewPager = WeekViewPager.this;
                baseWeekView.mParentLayout = weekViewPager.mParentLayout;
                baseWeekView.setup(weekViewPager.mDelegate);
                baseWeekView.setup(firstCalendarStartWithMinCalendar);
                baseWeekView.setTag(Integer.valueOf(position));
                baseWeekView.setSelectedCalendar(WeekViewPager.this.mDelegate.mSelectedCalendar);
                container.addView(baseWeekView);
                return baseWeekView;
            } catch (Exception e) {
                e.printStackTrace();
                return new DefaultWeekView(WeekViewPager.this.getContext());
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view.equals(object);
        }
    }

    public WeekViewPager(Context context) {
        this(context, null);
    }

    private void init() {
        this.mWeekCount = CalendarUtil.getWeekCountBetweenBothCalendar(this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth(), this.mDelegate.getMinYearDay(), this.mDelegate.getMaxYear(), this.mDelegate.getMaxYearMonth(), this.mDelegate.getMaxYearDay(), this.mDelegate.getWeekStart());
        setAdapter(new WeekViewPagerAdapter());
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.huachenjie.base.widget.calendar.WeekViewPager.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                if (WeekViewPager.this.getVisibility() != 0) {
                    WeekViewPager.this.isUsingScrollToCalendar = false;
                    return;
                }
                if (WeekViewPager.this.isUsingScrollToCalendar) {
                    WeekViewPager.this.isUsingScrollToCalendar = false;
                    return;
                }
                BaseWeekView baseWeekView = (BaseWeekView) WeekViewPager.this.findViewWithTag(Integer.valueOf(position));
                if (baseWeekView != null) {
                    baseWeekView.performClickCalendar(WeekViewPager.this.mDelegate.getSelectMode() != 0 ? WeekViewPager.this.mDelegate.mIndexCalendar : WeekViewPager.this.mDelegate.mSelectedCalendar, !WeekViewPager.this.isUsingScrollToCalendar);
                    if (WeekViewPager.this.mDelegate.mWeekChangeListener != null) {
                        WeekViewPager.this.mDelegate.mWeekChangeListener.onWeekChange(WeekViewPager.this.getCurrentWeekCalendars());
                    }
                }
                WeekViewPager.this.isUsingScrollToCalendar = false;
            }
        });
    }

    private void notifyAdapterDataSetChanged() {
        if (getAdapter() == null) {
            return;
        }
        getAdapter().notifyDataSetChanged();
    }

    public final void clearMultiSelect() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseWeekView baseWeekView = (BaseWeekView) getChildAt(i);
            baseWeekView.mCurrentItem = -1;
            baseWeekView.invalidate();
        }
    }

    public final void clearSelectRange() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseWeekView) getChildAt(i)).invalidate();
        }
    }

    public final void clearSingleSelect() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseWeekView baseWeekView = (BaseWeekView) getChildAt(i);
            baseWeekView.mCurrentItem = -1;
            baseWeekView.invalidate();
        }
    }

    public List<Calendar> getCurrentWeekCalendars() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        List<Calendar> weekCalendars = CalendarUtil.getWeekCalendars(calendarViewDelegate.mIndexCalendar, calendarViewDelegate);
        this.mDelegate.addSchemesFromMap(weekCalendars);
        return weekCalendars;
    }

    public void notifyDataSetChanged() {
        this.mWeekCount = CalendarUtil.getWeekCountBetweenBothCalendar(this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth(), this.mDelegate.getMinYearDay(), this.mDelegate.getMaxYear(), this.mDelegate.getMaxYearMonth(), this.mDelegate.getMaxYearDay(), this.mDelegate.getWeekStart());
        notifyAdapterDataSetChanged();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.mDelegate.isWeekViewScrollable() && super.onInterceptTouchEvent(ev);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.mDelegate.getCalendarItemHeight(), 1073741824));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent ev) {
        return this.mDelegate.isWeekViewScrollable() && super.onTouchEvent(ev);
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
        updateSelected(calendar, smoothScroll);
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
        if (onInnerDateSelectedListener != null) {
            onInnerDateSelectedListener.onWeekDateSelected(calendar, false);
        }
        CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.mCalendarSelectListener;
        if (onCalendarSelectListener != null && invokeListener) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendar, this.mDelegate.getWeekStart()));
    }

    public void scrollToCurrent(boolean smoothScroll) {
        this.isUsingScrollToCalendar = true;
        int weekFromCalendarStartWithMinCalendar = CalendarUtil.getWeekFromCalendarStartWithMinCalendar(this.mDelegate.getCurrentDay(), this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth(), this.mDelegate.getMinYearDay(), this.mDelegate.getWeekStart()) - 1;
        if (getCurrentItem() == weekFromCalendarStartWithMinCalendar) {
            this.isUsingScrollToCalendar = false;
        }
        setCurrentItem(weekFromCalendarStartWithMinCalendar, smoothScroll);
        BaseWeekView baseWeekView = (BaseWeekView) findViewWithTag(Integer.valueOf(weekFromCalendarStartWithMinCalendar));
        if (baseWeekView != null) {
            baseWeekView.performClickCalendar(this.mDelegate.getCurrentDay(), false);
            baseWeekView.setSelectedCalendar(this.mDelegate.getCurrentDay());
            baseWeekView.invalidate();
        }
        if (this.mDelegate.mCalendarSelectListener != null && getVisibility() == 0) {
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mCalendarSelectListener.onCalendarSelect(calendarViewDelegate.mSelectedCalendar, false);
        }
        if (getVisibility() == 0) {
            CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
            calendarViewDelegate2.mInnerListener.onWeekDateSelected(calendarViewDelegate2.getCurrentDay(), false);
        }
        this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(this.mDelegate.getCurrentDay(), this.mDelegate.getWeekStart()));
    }

    public void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        init();
    }

    public void updateCurrentDate() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseWeekView) getChildAt(i)).updateCurrentDate();
        }
    }

    public void updateDefaultSelect() {
        BaseWeekView baseWeekView = (BaseWeekView) findViewWithTag(Integer.valueOf(getCurrentItem()));
        if (baseWeekView != null) {
            baseWeekView.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
            baseWeekView.invalidate();
        }
    }

    public final void updateItemHeight() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseWeekView baseWeekView = (BaseWeekView) getChildAt(i);
            baseWeekView.updateItemHeight();
            baseWeekView.requestLayout();
        }
    }

    public void updateRange() {
        this.isUpdateWeekView = true;
        notifyDataSetChanged();
        this.isUpdateWeekView = false;
        if (getVisibility() != 0) {
            return;
        }
        this.isUsingScrollToCalendar = true;
        Calendar calendar = this.mDelegate.mSelectedCalendar;
        updateSelected(calendar, false);
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.mInnerListener;
        if (onInnerDateSelectedListener != null) {
            onInnerDateSelectedListener.onWeekDateSelected(calendar, false);
        }
        CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.mCalendarSelectListener;
        if (onCalendarSelectListener != null) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendar, this.mDelegate.getWeekStart()));
    }

    public void updateScheme() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseWeekView) getChildAt(i)).update();
        }
    }

    public void updateSelected(Calendar calendar, boolean smoothScroll) {
        int weekFromCalendarStartWithMinCalendar = CalendarUtil.getWeekFromCalendarStartWithMinCalendar(calendar, this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth(), this.mDelegate.getMinYearDay(), this.mDelegate.getWeekStart()) - 1;
        this.isUsingScrollToCalendar = getCurrentItem() != weekFromCalendarStartWithMinCalendar;
        setCurrentItem(weekFromCalendarStartWithMinCalendar, smoothScroll);
        BaseWeekView baseWeekView = (BaseWeekView) findViewWithTag(Integer.valueOf(weekFromCalendarStartWithMinCalendar));
        if (baseWeekView != null) {
            baseWeekView.setSelectedCalendar(calendar);
            baseWeekView.invalidate();
        }
    }

    public void updateShowMode() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseWeekView) getChildAt(i)).updateShowMode();
        }
    }

    public void updateSingleSelect() {
        if (this.mDelegate.getSelectMode() == 0) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseWeekView) getChildAt(i)).updateSingleSelect();
        }
    }

    public final void updateStyle() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseWeekView baseWeekView = (BaseWeekView) getChildAt(i);
            baseWeekView.updateStyle();
            baseWeekView.invalidate();
        }
    }

    public void updateWeekStart() {
        if (getAdapter() == null) {
            return;
        }
        int count = getAdapter().getCount();
        int weekCountBetweenBothCalendar = CalendarUtil.getWeekCountBetweenBothCalendar(this.mDelegate.getMinYear(), this.mDelegate.getMinYearMonth(), this.mDelegate.getMinYearDay(), this.mDelegate.getMaxYear(), this.mDelegate.getMaxYearMonth(), this.mDelegate.getMaxYearDay(), this.mDelegate.getWeekStart());
        this.mWeekCount = weekCountBetweenBothCalendar;
        if (count != weekCountBetweenBothCalendar) {
            this.isUpdateWeekView = true;
            getAdapter().notifyDataSetChanged();
        }
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseWeekView) getChildAt(i)).updateWeekStart();
        }
        this.isUpdateWeekView = false;
        updateSelected(this.mDelegate.mSelectedCalendar, false);
    }

    public void updateWeekViewClass() {
        this.isUpdateWeekView = true;
        notifyAdapterDataSetChanged();
        this.isUpdateWeekView = false;
    }

    public WeekViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isUsingScrollToCalendar = false;
    }

    public void updateSelected() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseWeekView baseWeekView = (BaseWeekView) getChildAt(i);
            baseWeekView.setSelectedCalendar(this.mDelegate.mSelectedCalendar);
            baseWeekView.invalidate();
        }
    }
}
