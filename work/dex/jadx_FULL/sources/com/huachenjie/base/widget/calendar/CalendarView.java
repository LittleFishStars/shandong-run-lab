package com.huachenjie.base.widget.calendar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.huachenjie.base.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CalendarView extends FrameLayout {
    private final CalendarViewDelegate mDelegate;
    private MonthViewPager mMonthPager;
    CalendarLayout mParentLayout;
    private WeekBar mWeekBar;
    private View mWeekLine;
    private WeekViewPager mWeekPager;
    private YearViewPager mYearViewPager;

    public interface OnCalendarInterceptListener {
        boolean onCalendarIntercept(Calendar calendar);

        void onCalendarInterceptClick(Calendar calendar, boolean isClick);
    }

    public interface OnCalendarLongClickListener {
        void onCalendarLongClick(Calendar calendar);

        void onCalendarLongClickOutOfRange(Calendar calendar);
    }

    public interface OnCalendarMultiSelectListener {
        void onCalendarMultiSelect(Calendar calendar, int curSize, int maxSize);

        void onCalendarMultiSelectOutOfRange(Calendar calendar);

        void onMultiSelectOutOfSize(Calendar calendar, int maxSize);
    }

    public interface OnCalendarRangeSelectListener {
        void onCalendarRangeSelect(Calendar calendar, boolean isEnd);

        void onCalendarSelectOutOfRange(Calendar calendar);

        void onSelectOutOfRange(Calendar calendar, boolean isOutOfMinRange);
    }

    public interface OnCalendarSelectListener {
        void onCalendarOutOfRange(Calendar calendar);

        void onCalendarSelect(Calendar calendar, boolean isClick);
    }

    public interface OnClickCalendarPaddingListener {
        void onClickCalendarPadding(float x, float y, boolean isMonthView, Calendar adjacentCalendar, Object obj);
    }

    public interface OnInnerDateSelectedListener {
        void onMonthDateSelected(Calendar calendar, boolean isClick);

        void onWeekDateSelected(Calendar calendar, boolean isClick);
    }

    public interface OnMonthChangeListener {
        void onMonthChange(int year, int month);
    }

    public interface OnViewChangeListener {
        void onViewChange(boolean isMonthView);
    }

    public interface OnWeekChangeListener {
        void onWeekChange(List<Calendar> weekCalendars);
    }

    public interface OnYearChangeListener {
        void onYearChange(int year);
    }

    public interface OnYearViewChangeListener {
        void onYearViewChange(boolean isClose);
    }

    public CalendarView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSelectLayout(final int position) {
        this.mYearViewPager.setVisibility(8);
        this.mWeekBar.setVisibility(0);
        if (position == this.mMonthPager.getCurrentItem()) {
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            if (calendarViewDelegate.mCalendarSelectListener != null && calendarViewDelegate.getSelectMode() != 1) {
                CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
                calendarViewDelegate2.mCalendarSelectListener.onCalendarSelect(calendarViewDelegate2.mSelectedCalendar, false);
            }
        } else {
            this.mMonthPager.setCurrentItem(position, false);
        }
        this.mWeekBar.animate().translationY(0.0f).setInterpolator(new LinearInterpolator()).setDuration(280L).setListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                CalendarView.this.mWeekBar.setVisibility(0);
            }
        });
        this.mMonthPager.animate().scaleX(1.0f).scaleY(1.0f).setDuration(180L).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (CalendarView.this.mDelegate.mYearViewChangeListener != null) {
                    CalendarView.this.mDelegate.mYearViewChangeListener.onYearViewChange(true);
                }
                CalendarView calendarView = CalendarView.this;
                CalendarLayout calendarLayout = calendarView.mParentLayout;
                if (calendarLayout != null) {
                    calendarLayout.showContentView();
                    if (CalendarView.this.mParentLayout.isExpand()) {
                        CalendarView.this.mMonthPager.setVisibility(0);
                    } else {
                        CalendarView.this.mWeekPager.setVisibility(0);
                        CalendarView.this.mParentLayout.shrink();
                    }
                } else {
                    calendarView.mMonthPager.setVisibility(0);
                }
                CalendarView.this.mMonthPager.clearAnimation();
            }
        });
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cv_layout_calendar_view, (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameContent);
        WeekViewPager weekViewPager = (WeekViewPager) findViewById(R.id.vp_week);
        this.mWeekPager = weekViewPager;
        weekViewPager.setup(this.mDelegate);
        try {
            this.mWeekBar = (WeekBar) this.mDelegate.getWeekBarClass().getConstructor(Context.class).newInstance(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frameLayout.addView(this.mWeekBar, 2);
        this.mWeekBar.setup(this.mDelegate);
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
        View viewFindViewById = findViewById(R.id.line);
        this.mWeekLine = viewFindViewById;
        viewFindViewById.setBackgroundColor(this.mDelegate.getWeekLineBackground());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWeekLine.getLayoutParams();
        layoutParams.setMargins(this.mDelegate.getWeekLineMargin(), this.mDelegate.getWeekBarHeight(), this.mDelegate.getWeekLineMargin(), 0);
        this.mWeekLine.setLayoutParams(layoutParams);
        MonthViewPager monthViewPager = (MonthViewPager) findViewById(R.id.vp_month);
        this.mMonthPager = monthViewPager;
        monthViewPager.mWeekPager = this.mWeekPager;
        monthViewPager.mWeekBar = this.mWeekBar;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) monthViewPager.getLayoutParams();
        layoutParams2.setMargins(0, this.mDelegate.getWeekBarHeight() + CalendarUtil.dipToPx(context, 1.0f), 0, 0);
        this.mWeekPager.setLayoutParams(layoutParams2);
        YearViewPager yearViewPager = (YearViewPager) findViewById(R.id.selectLayout);
        this.mYearViewPager = yearViewPager;
        yearViewPager.setPadding(this.mDelegate.getYearViewPaddingLeft(), 0, this.mDelegate.getYearViewPaddingRight(), 0);
        this.mYearViewPager.setBackgroundColor(this.mDelegate.getYearViewBackground());
        this.mYearViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.huachenjie.base.widget.calendar.CalendarView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                if (CalendarView.this.mWeekPager.getVisibility() == 0 || CalendarView.this.mDelegate.mYearChangeListener == null) {
                    return;
                }
                CalendarView.this.mDelegate.mYearChangeListener.onYearChange(position + CalendarView.this.mDelegate.getMinYear());
            }
        });
        this.mDelegate.mInnerListener = new OnInnerDateSelectedListener() { // from class: com.huachenjie.base.widget.calendar.CalendarView.2
            @Override // com.huachenjie.base.widget.calendar.CalendarView.OnInnerDateSelectedListener
            public void onMonthDateSelected(Calendar calendar, boolean isClick) {
                if (calendar.getYear() == CalendarView.this.mDelegate.getCurrentDay().getYear() && calendar.getMonth() == CalendarView.this.mDelegate.getCurrentDay().getMonth() && CalendarView.this.mMonthPager.getCurrentItem() != CalendarView.this.mDelegate.mCurrentMonthViewItem) {
                    return;
                }
                CalendarView.this.mDelegate.mIndexCalendar = calendar;
                if (CalendarView.this.mDelegate.getSelectMode() == 0 || isClick) {
                    CalendarView.this.mDelegate.mSelectedCalendar = calendar;
                }
                CalendarView.this.mWeekPager.updateSelected(CalendarView.this.mDelegate.mIndexCalendar, false);
                CalendarView.this.mMonthPager.updateSelected();
                if (CalendarView.this.mWeekBar != null) {
                    if (CalendarView.this.mDelegate.getSelectMode() == 0 || isClick) {
                        CalendarView.this.mWeekBar.onDateSelected(calendar, CalendarView.this.mDelegate.getWeekStart(), isClick);
                    }
                }
            }

            @Override // com.huachenjie.base.widget.calendar.CalendarView.OnInnerDateSelectedListener
            public void onWeekDateSelected(Calendar calendar, boolean isClick) {
                CalendarView.this.mDelegate.mIndexCalendar = calendar;
                if (CalendarView.this.mDelegate.getSelectMode() == 0 || isClick || CalendarView.this.mDelegate.mIndexCalendar.equals(CalendarView.this.mDelegate.mSelectedCalendar)) {
                    CalendarView.this.mDelegate.mSelectedCalendar = calendar;
                }
                int year = (((calendar.getYear() - CalendarView.this.mDelegate.getMinYear()) * 12) + CalendarView.this.mDelegate.mIndexCalendar.getMonth()) - CalendarView.this.mDelegate.getMinYearMonth();
                CalendarView.this.mWeekPager.updateSingleSelect();
                CalendarView.this.mMonthPager.setCurrentItem(year, false);
                CalendarView.this.mMonthPager.updateSelected();
                if (CalendarView.this.mWeekBar != null) {
                    if (CalendarView.this.mDelegate.getSelectMode() == 0 || isClick || CalendarView.this.mDelegate.mIndexCalendar.equals(CalendarView.this.mDelegate.mSelectedCalendar)) {
                        CalendarView.this.mWeekBar.onDateSelected(calendar, CalendarView.this.mDelegate.getWeekStart(), isClick);
                    }
                }
            }
        };
        if (this.mDelegate.getSelectMode() != 0) {
            this.mDelegate.mSelectedCalendar = new Calendar();
        } else if (isInRange(this.mDelegate.getCurrentDay())) {
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mSelectedCalendar = calendarViewDelegate.createCurrentDate();
        } else {
            CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
            calendarViewDelegate2.mSelectedCalendar = calendarViewDelegate2.getMinRangeCalendar();
        }
        CalendarViewDelegate calendarViewDelegate3 = this.mDelegate;
        Calendar calendar = calendarViewDelegate3.mSelectedCalendar;
        calendarViewDelegate3.mIndexCalendar = calendar;
        this.mWeekBar.onDateSelected(calendar, calendarViewDelegate3.getWeekStart(), false);
        this.mMonthPager.setup(this.mDelegate);
        this.mMonthPager.setCurrentItem(this.mDelegate.mCurrentMonthViewItem);
        this.mYearViewPager.setOnMonthSelectedListener(new YearRecyclerView.OnMonthSelectedListener() { // from class: com.huachenjie.base.widget.calendar.CalendarView.3
            @Override // com.huachenjie.base.widget.calendar.YearRecyclerView.OnMonthSelectedListener
            public void onMonthSelected(int year, int month) {
                CalendarView.this.closeSelectLayout((((year - CalendarView.this.mDelegate.getMinYear()) * 12) + month) - CalendarView.this.mDelegate.getMinYearMonth());
                CalendarView.this.mDelegate.isShowYearSelectedLayout = false;
            }
        });
        this.mYearViewPager.setup(this.mDelegate);
        this.mWeekPager.updateSelected(this.mDelegate.createCurrentDate(), false);
    }

    private void setShowMode(int mode) {
        if ((mode == 0 || mode == 1 || mode == 2) && this.mDelegate.getMonthViewShowMode() != mode) {
            this.mDelegate.setMonthViewShowMode(mode);
            this.mWeekPager.updateShowMode();
            this.mMonthPager.updateShowMode();
            this.mWeekPager.notifyDataSetChanged();
        }
    }

    private void setWeekStart(int weekStart) {
        if ((weekStart == 1 || weekStart == 2 || weekStart == 7) && weekStart != this.mDelegate.getWeekStart()) {
            this.mDelegate.setWeekStart(weekStart);
            this.mWeekBar.onWeekStartChange(weekStart);
            this.mWeekBar.onDateSelected(this.mDelegate.mSelectedCalendar, weekStart, false);
            this.mWeekPager.updateWeekStart();
            this.mMonthPager.updateWeekStart();
            this.mYearViewPager.updateWeekStart();
        }
    }

    private void showSelectLayout(final int year) {
        CalendarLayout calendarLayout = this.mParentLayout;
        if (calendarLayout != null && calendarLayout.mContentView != null && !calendarLayout.isExpand()) {
            this.mParentLayout.expand();
        }
        this.mWeekPager.setVisibility(8);
        this.mDelegate.isShowYearSelectedLayout = true;
        CalendarLayout calendarLayout2 = this.mParentLayout;
        if (calendarLayout2 != null) {
            calendarLayout2.hideContentView();
        }
        this.mWeekBar.animate().translationY(-this.mWeekBar.getHeight()).setInterpolator(new LinearInterpolator()).setDuration(260L).setListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                CalendarView.this.mWeekBar.setVisibility(8);
                CalendarView.this.mYearViewPager.setVisibility(0);
                CalendarView.this.mYearViewPager.scrollToYear(year, false);
                CalendarLayout calendarLayout3 = CalendarView.this.mParentLayout;
                if (calendarLayout3 == null || calendarLayout3.mContentView == null) {
                    return;
                }
                calendarLayout3.expand();
            }
        });
        this.mMonthPager.animate().scaleX(0.0f).scaleY(0.0f).setDuration(260L).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (CalendarView.this.mDelegate.mYearViewChangeListener != null) {
                    CalendarView.this.mDelegate.mYearViewChangeListener.onYearViewChange(false);
                }
            }
        });
    }

    public final void addSchemeDate(Calendar calendar) {
        if (calendar == null || !calendar.isAvailable()) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate.mSchemeDatesMap == null) {
            calendarViewDelegate.mSchemeDatesMap = new HashMap();
        }
        this.mDelegate.mSchemeDatesMap.remove(calendar.toString());
        this.mDelegate.mSchemeDatesMap.put(calendar.toString(), calendar);
        this.mDelegate.updateSelectCalendarScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void clearMultiSelect() {
        this.mDelegate.mSelectedCalendars.clear();
        this.mMonthPager.clearMultiSelect();
        this.mWeekPager.clearMultiSelect();
    }

    public final void clearSchemeDate() {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mSchemeDatesMap = null;
        calendarViewDelegate.clearSelectedScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void clearSelectRange() {
        this.mDelegate.clearSelectRange();
        this.mMonthPager.clearSelectRange();
        this.mWeekPager.clearSelectRange();
    }

    public final void clearSingleSelect() {
        this.mDelegate.mSelectedCalendar = new Calendar();
        this.mMonthPager.clearSingleSelect();
        this.mWeekPager.clearSingleSelect();
    }

    public void closeYearSelectLayout() {
        if (this.mYearViewPager.getVisibility() == 8) {
            return;
        }
        closeSelectLayout((((this.mDelegate.mSelectedCalendar.getYear() - this.mDelegate.getMinYear()) * 12) + this.mDelegate.mSelectedCalendar.getMonth()) - this.mDelegate.getMinYearMonth());
        this.mDelegate.isShowYearSelectedLayout = false;
    }

    public int getCurDay() {
        return this.mDelegate.getCurrentDay().getDay();
    }

    public int getCurMonth() {
        return this.mDelegate.getCurrentDay().getMonth();
    }

    public int getCurYear() {
        return this.mDelegate.getCurrentDay().getYear();
    }

    public Calendar getCurrentDay() {
        return this.mDelegate.getCurrentDay();
    }

    public List<Calendar> getCurrentMonthCalendars() {
        return this.mMonthPager.getCurrentMonthCalendars();
    }

    public List<Calendar> getCurrentWeekCalendars() {
        return this.mWeekPager.getCurrentWeekCalendars();
    }

    public final int getMaxMultiSelectSize() {
        return this.mDelegate.getMaxMultiSelectSize();
    }

    public Calendar getMaxRangeCalendar() {
        return this.mDelegate.getMaxRangeCalendar();
    }

    public final int getMaxSelectRange() {
        return this.mDelegate.getMaxSelectRange();
    }

    public Calendar getMinRangeCalendar() {
        return this.mDelegate.getMinRangeCalendar();
    }

    public final int getMinSelectRange() {
        return this.mDelegate.getMinSelectRange();
    }

    public MonthViewPager getMonthViewPager() {
        return this.mMonthPager;
    }

    public final List<Calendar> getMultiSelectCalendars() {
        ArrayList arrayList = new ArrayList();
        if (this.mDelegate.mSelectedCalendars.size() == 0) {
            return arrayList;
        }
        arrayList.addAll(this.mDelegate.mSelectedCalendars.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    public final List<Calendar> getSelectCalendarRange() {
        return this.mDelegate.getSelectCalendarRange();
    }

    public Calendar getSelectedCalendar() {
        return this.mDelegate.mSelectedCalendar;
    }

    public WeekViewPager getWeekViewPager() {
        return this.mWeekPager;
    }

    public final boolean isInRange(Calendar calendar) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        return calendarViewDelegate != null && CalendarUtil.isCalendarInRange(calendar, calendarViewDelegate);
    }

    public boolean isSingleSelectMode() {
        return this.mDelegate.getSelectMode() == 1;
    }

    public boolean isYearSelectLayoutVisible() {
        return this.mYearViewPager.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() == null || !(getParent() instanceof CalendarLayout)) {
            return;
        }
        CalendarLayout calendarLayout = (CalendarLayout) getParent();
        this.mParentLayout = calendarLayout;
        this.mMonthPager.mParentLayout = calendarLayout;
        this.mWeekPager.mParentLayout = calendarLayout;
        calendarLayout.mWeekBar = this.mWeekBar;
        calendarLayout.setup(this.mDelegate);
        this.mParentLayout.initStatus();
    }

    public final boolean onCalendarIntercept(Calendar calendar) {
        OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.mCalendarInterceptListener;
        return onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendar);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null || !calendarViewDelegate.isFullScreenCalendar()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setCalendarItemHeight((size - this.mDelegate.getWeekBarHeight()) / 6);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        Parcelable parcelable = bundle.getParcelable("super");
        this.mDelegate.mSelectedCalendar = (Calendar) bundle.getSerializable("selected_calendar");
        this.mDelegate.mIndexCalendar = (Calendar) bundle.getSerializable("index_calendar");
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        OnCalendarSelectListener onCalendarSelectListener = calendarViewDelegate.mCalendarSelectListener;
        if (onCalendarSelectListener != null) {
            onCalendarSelectListener.onCalendarSelect(calendarViewDelegate.mSelectedCalendar, false);
        }
        Calendar calendar = this.mDelegate.mIndexCalendar;
        if (calendar != null) {
            scrollToCalendar(calendar.getYear(), this.mDelegate.mIndexCalendar.getMonth(), this.mDelegate.mIndexCalendar.getDay());
        }
        update();
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        if (this.mDelegate == null) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putSerializable("selected_calendar", this.mDelegate.mSelectedCalendar);
        bundle.putSerializable("index_calendar", this.mDelegate.mIndexCalendar);
        return bundle;
    }

    public final void putMultiSelect(Calendar... calendars) {
        if (calendars == null || calendars.length == 0) {
            return;
        }
        for (Calendar calendar : calendars) {
            if (calendar != null && !this.mDelegate.mSelectedCalendars.containsKey(calendar.toString())) {
                this.mDelegate.mSelectedCalendars.put(calendar.toString(), calendar);
            }
        }
        update();
    }

    public final void removeMultiSelect(Calendar... calendars) {
        if (calendars == null || calendars.length == 0) {
            return;
        }
        for (Calendar calendar : calendars) {
            if (calendar != null && this.mDelegate.mSelectedCalendars.containsKey(calendar.toString())) {
                this.mDelegate.mSelectedCalendars.remove(calendar.toString());
            }
        }
        update();
    }

    public final void removeSchemeDate(Calendar calendar) {
        Map<String, Calendar> map;
        if (calendar == null || (map = this.mDelegate.mSchemeDatesMap) == null || map.size() == 0) {
            return;
        }
        this.mDelegate.mSchemeDatesMap.remove(calendar.toString());
        if (this.mDelegate.mSelectedCalendar.equals(calendar)) {
            this.mDelegate.clearSelectedScheme();
        }
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public void scrollToCalendar(int year, int month, int day) {
        scrollToCalendar(year, month, day, false, true);
    }

    public void scrollToCurrent() {
        scrollToCurrent(false);
    }

    public void scrollToNext() {
        scrollToNext(false);
    }

    public void scrollToPre() {
        scrollToPre(false);
    }

    public void scrollToSelectCalendar() {
        if (this.mDelegate.mSelectedCalendar.isAvailable()) {
            scrollToCalendar(this.mDelegate.mSelectedCalendar.getYear(), this.mDelegate.mSelectedCalendar.getMonth(), this.mDelegate.mSelectedCalendar.getDay(), false, true);
        }
    }

    public void scrollToYear(int year) {
        scrollToYear(year, false);
    }

    public void setAllMode() {
        setShowMode(0);
    }

    public void setBackground(int yearViewBackground, int weekBackground, int lineBg) {
        this.mWeekBar.setBackgroundColor(weekBackground);
        this.mYearViewPager.setBackgroundColor(yearViewBackground);
        this.mWeekLine.setBackgroundColor(lineBg);
    }

    public final void setCalendarItemHeight(int calendarItemHeight) {
        if (this.mDelegate.getCalendarItemHeight() == calendarItemHeight) {
            return;
        }
        this.mDelegate.setCalendarItemHeight(calendarItemHeight);
        this.mMonthPager.updateItemHeight();
        this.mWeekPager.updateItemHeight();
        CalendarLayout calendarLayout = this.mParentLayout;
        if (calendarLayout == null) {
            return;
        }
        calendarLayout.updateCalendarItemHeight();
    }

    public void setCalendarPadding(int mCalendarPadding) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        calendarViewDelegate.setCalendarPadding(mCalendarPadding);
        update();
    }

    public void setCalendarPaddingLeft(int mCalendarPaddingLeft) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        calendarViewDelegate.setCalendarPaddingLeft(mCalendarPaddingLeft);
        update();
    }

    public void setCalendarPaddingRight(int mCalendarPaddingRight) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null) {
            return;
        }
        calendarViewDelegate.setCalendarPaddingRight(mCalendarPaddingRight);
        update();
    }

    public void setCurrentDay(Calendar calendar) {
        this.mDelegate.setCurrentDay(calendar);
    }

    public final void setDefaultMonthViewSelectDay() {
        this.mDelegate.setDefaultCalendarSelectDay(0);
    }

    public void setFixMode() {
        setShowMode(2);
    }

    public final void setLastMonthViewSelectDay() {
        this.mDelegate.setDefaultCalendarSelectDay(1);
    }

    public final void setLastMonthViewSelectDayIgnoreCurrent() {
        this.mDelegate.setDefaultCalendarSelectDay(2);
    }

    public final void setMaxMultiSelectSize(int maxMultiSelectSize) {
        this.mDelegate.setMaxMultiSelectSize(maxMultiSelectSize);
    }

    public final void setMonthView(Class<?> cls) {
        if (cls == null || this.mDelegate.getMonthViewClass().equals(cls)) {
            return;
        }
        this.mDelegate.setMonthViewClass(cls);
        this.mMonthPager.updateMonthViewClass();
    }

    public final void setMonthViewScrollable(boolean monthViewScrollable) {
        this.mDelegate.setMonthViewScrollable(monthViewScrollable);
    }

    public final void setOnCalendarInterceptListener(OnCalendarInterceptListener listener) {
        if (listener == null) {
            this.mDelegate.mCalendarInterceptListener = null;
        }
        if (listener == null || this.mDelegate.getSelectMode() == 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mCalendarInterceptListener = listener;
        if (listener.onCalendarIntercept(calendarViewDelegate.mSelectedCalendar)) {
            this.mDelegate.mSelectedCalendar = new Calendar();
        }
    }

    public void setOnCalendarLongClickListener(OnCalendarLongClickListener listener) {
        this.mDelegate.mCalendarLongClickListener = listener;
    }

    public final void setOnCalendarMultiSelectListener(OnCalendarMultiSelectListener listener) {
        this.mDelegate.mCalendarMultiSelectListener = listener;
    }

    public final void setOnCalendarRangeSelectListener(OnCalendarRangeSelectListener listener) {
        this.mDelegate.mCalendarRangeSelectListener = listener;
    }

    public void setOnCalendarSelectListener(OnCalendarSelectListener listener) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mCalendarSelectListener = listener;
        if (listener != null && calendarViewDelegate.getSelectMode() == 0 && isInRange(this.mDelegate.mSelectedCalendar)) {
            this.mDelegate.updateSelectCalendarScheme();
        }
    }

    public final void setOnClickCalendarPaddingListener(OnClickCalendarPaddingListener listener) {
        if (listener == null) {
            this.mDelegate.mClickCalendarPaddingListener = null;
        }
        if (listener == null) {
            return;
        }
        this.mDelegate.mClickCalendarPaddingListener = listener;
    }

    public void setOnMonthChangeListener(OnMonthChangeListener listener) {
        this.mDelegate.mMonthChangeListener = listener;
    }

    public void setOnViewChangeListener(OnViewChangeListener listener) {
        this.mDelegate.mViewChangeListener = listener;
    }

    public void setOnWeekChangeListener(OnWeekChangeListener listener) {
        this.mDelegate.mWeekChangeListener = listener;
    }

    public void setOnYearChangeListener(OnYearChangeListener listener) {
        this.mDelegate.mYearChangeListener = listener;
    }

    public void setOnYearViewChangeListener(OnYearViewChangeListener listener) {
        this.mDelegate.mYearViewChangeListener = listener;
    }

    public void setOnlyCurrentMode() {
        setShowMode(1);
    }

    public void setRange(int minYear, int minYearMonth, int minYearDay, int maxYear, int maxYearMonth, int maxYearDay) {
        if (CalendarUtil.compareTo(minYear, minYearMonth, minYearDay, maxYear, maxYearMonth, maxYearDay) > 0) {
            return;
        }
        this.mDelegate.setRange(minYear, minYearMonth, minYearDay, maxYear, maxYearMonth, maxYearDay);
        this.mWeekPager.notifyDataSetChanged();
        this.mYearViewPager.notifyDataSetChanged();
        this.mMonthPager.notifyDataSetChanged();
        if (!isInRange(this.mDelegate.mSelectedCalendar)) {
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mSelectedCalendar = calendarViewDelegate.getMinRangeCalendar();
            this.mDelegate.updateSelectCalendarScheme();
            CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
            calendarViewDelegate2.mIndexCalendar = calendarViewDelegate2.mSelectedCalendar;
        }
        this.mWeekPager.updateRange();
        this.mMonthPager.updateRange();
        this.mYearViewPager.updateRange();
    }

    public void setSchemeColor(int schemeColor, int schemeTextColor, int schemeLunarTextColor) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null || this.mMonthPager == null || this.mWeekPager == null) {
            return;
        }
        calendarViewDelegate.setSchemeColor(schemeColor, schemeTextColor, schemeLunarTextColor);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public final void setSchemeDate(Map<String, Calendar> mSchemeDates) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mSchemeDatesMap = mSchemeDates;
        calendarViewDelegate.updateSelectCalendarScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void setSelectCalendarRange(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        Calendar calendar = new Calendar();
        calendar.setYear(startYear);
        calendar.setMonth(startMonth);
        calendar.setDay(startDay);
        Calendar calendar2 = new Calendar();
        calendar2.setYear(endYear);
        calendar2.setMonth(endMonth);
        calendar2.setDay(endDay);
        setSelectCalendarRange(calendar, calendar2);
    }

    public final void setSelectDefaultMode() {
        if (this.mDelegate.getSelectMode() == 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mSelectedCalendar = calendarViewDelegate.mIndexCalendar;
        calendarViewDelegate.setSelectMode(0);
        WeekBar weekBar = this.mWeekBar;
        CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
        weekBar.onDateSelected(calendarViewDelegate2.mSelectedCalendar, calendarViewDelegate2.getWeekStart(), false);
        this.mMonthPager.updateDefaultSelect();
        this.mWeekPager.updateDefaultSelect();
    }

    public final void setSelectEndCalendar(int endYear, int endMonth, int endDay) {
        if (this.mDelegate.getSelectMode() == 2 && this.mDelegate.mSelectedStartRangeCalendar != null) {
            Calendar calendar = new Calendar();
            calendar.setYear(endYear);
            calendar.setMonth(endMonth);
            calendar.setDay(endDay);
            setSelectEndCalendar(calendar);
        }
    }

    public void setSelectMultiMode() {
        if (this.mDelegate.getSelectMode() == 3) {
            return;
        }
        this.mDelegate.setSelectMode(3);
        clearMultiSelect();
    }

    public final void setSelectRange(int minRange, int maxRange) {
        if (minRange > maxRange) {
            return;
        }
        this.mDelegate.setSelectRange(minRange, maxRange);
    }

    public void setSelectRangeMode() {
        if (this.mDelegate.getSelectMode() == 2) {
            return;
        }
        this.mDelegate.setSelectMode(2);
        clearSelectRange();
    }

    public void setSelectSingleMode() {
        if (this.mDelegate.getSelectMode() == 1) {
            return;
        }
        this.mDelegate.setSelectMode(1);
        this.mWeekPager.updateSelected();
        this.mMonthPager.updateSelected();
    }

    public final void setSelectStartCalendar(int startYear, int startMonth, int startDay) {
        if (this.mDelegate.getSelectMode() != 2) {
            return;
        }
        Calendar calendar = new Calendar();
        calendar.setYear(startYear);
        calendar.setMonth(startMonth);
        calendar.setDay(startDay);
        setSelectStartCalendar(calendar);
    }

    public void setSelectedColor(int selectedThemeColor, int selectedTextColor, int selectedLunarTextColor) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null || this.mMonthPager == null || this.mWeekPager == null) {
            return;
        }
        calendarViewDelegate.setSelectColor(selectedThemeColor, selectedTextColor, selectedLunarTextColor);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public final void setSingleSelect(Calendar calendar) {
        this.mDelegate.mSelectedCalendar = calendar;
        this.mMonthPager.updateSelected();
        this.mWeekPager.updateSelected();
    }

    public void setTextColor(int currentDayTextColor, int curMonthTextColor, int otherMonthColor, int curMonthLunarTextColor, int otherMonthLunarTextColor) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null || this.mMonthPager == null || this.mWeekPager == null) {
            return;
        }
        calendarViewDelegate.setTextColor(currentDayTextColor, curMonthTextColor, otherMonthColor, curMonthLunarTextColor, otherMonthLunarTextColor);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public void setThemeColor(int selectedThemeColor, int schemeColor) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null || this.mMonthPager == null || this.mWeekPager == null) {
            return;
        }
        calendarViewDelegate.setThemeColor(selectedThemeColor, schemeColor);
        this.mMonthPager.updateStyle();
        this.mWeekPager.updateStyle();
    }

    public void setWeeColor(int weekBackground, int weekTextColor) {
        WeekBar weekBar = this.mWeekBar;
        if (weekBar == null) {
            return;
        }
        weekBar.setBackgroundColor(weekBackground);
        this.mWeekBar.setTextColor(weekTextColor);
    }

    public final void setWeekBar(Class<?> cls) {
        if (cls == null || this.mDelegate.getWeekBarClass().equals(cls)) {
            return;
        }
        this.mDelegate.setWeekBarClass(cls);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameContent);
        frameLayout.removeView(this.mWeekBar);
        try {
            this.mWeekBar = (WeekBar) cls.getConstructor(Context.class).newInstance(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frameLayout.addView(this.mWeekBar, 2);
        this.mWeekBar.setup(this.mDelegate);
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
        MonthViewPager monthViewPager = this.mMonthPager;
        WeekBar weekBar = this.mWeekBar;
        monthViewPager.mWeekBar = weekBar;
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        weekBar.onDateSelected(calendarViewDelegate.mSelectedCalendar, calendarViewDelegate.getWeekStart(), false);
    }

    public void setWeekStarWithMon() {
        setWeekStart(2);
    }

    public void setWeekStarWithSat() {
        setWeekStart(7);
    }

    public void setWeekStarWithSun() {
        setWeekStart(1);
    }

    public final void setWeekView(Class<?> cls) {
        if (cls == null || this.mDelegate.getWeekBarClass().equals(cls)) {
            return;
        }
        this.mDelegate.setWeekViewClass(cls);
        this.mWeekPager.updateWeekViewClass();
    }

    public final void setWeekViewScrollable(boolean weekViewScrollable) {
        this.mDelegate.setWeekViewScrollable(weekViewScrollable);
    }

    public final void setYearViewScrollable(boolean yearViewScrollable) {
        this.mDelegate.setYearViewScrollable(yearViewScrollable);
    }

    public void setYearViewTextColor(int yearViewMonthTextColor, int yearViewDayTextColor, int yarViewSchemeTextColor) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate == null || this.mYearViewPager == null) {
            return;
        }
        calendarViewDelegate.setYearViewTextColor(yearViewMonthTextColor, yearViewDayTextColor, yarViewSchemeTextColor);
        this.mYearViewPager.updateStyle();
    }

    public void showYearSelectLayout(final int year) {
        showSelectLayout(year);
    }

    public final void update() {
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void updateCurrentDate() {
        if (this.mDelegate == null || this.mMonthPager == null || this.mWeekPager == null) {
            return;
        }
        if (getCurDay() == java.util.Calendar.getInstance().get(5)) {
            return;
        }
        this.mDelegate.updateCurrentDay();
        this.mMonthPager.updateCurrentDate();
        this.mWeekPager.updateCurrentDate();
    }

    public void updateWeekBar() {
        this.mWeekBar.onWeekStartChange(this.mDelegate.getWeekStart());
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mDelegate = new CalendarViewDelegate(context, attrs);
        init(context);
    }

    public void scrollToCalendar(int year, int month, int day, boolean smoothScroll) {
        scrollToCalendar(year, month, day, smoothScroll, true);
    }

    public void scrollToCurrent(boolean smoothScroll) {
        if (isInRange(this.mDelegate.getCurrentDay())) {
            Calendar calendarCreateCurrentDate = this.mDelegate.createCurrentDate();
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.mCalendarInterceptListener;
            if (onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendarCreateCurrentDate)) {
                this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendarCreateCurrentDate, false);
                return;
            }
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mSelectedCalendar = calendarViewDelegate.createCurrentDate();
            CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
            calendarViewDelegate2.mIndexCalendar = calendarViewDelegate2.mSelectedCalendar;
            calendarViewDelegate2.updateSelectCalendarScheme();
            WeekBar weekBar = this.mWeekBar;
            CalendarViewDelegate calendarViewDelegate3 = this.mDelegate;
            weekBar.onDateSelected(calendarViewDelegate3.mSelectedCalendar, calendarViewDelegate3.getWeekStart(), false);
            if (this.mMonthPager.getVisibility() == 0) {
                this.mMonthPager.scrollToCurrent(smoothScroll);
                this.mWeekPager.updateSelected(this.mDelegate.mIndexCalendar, false);
            } else {
                this.mWeekPager.scrollToCurrent(smoothScroll);
            }
            this.mYearViewPager.scrollToYear(this.mDelegate.getCurrentDay().getYear(), smoothScroll);
        }
    }

    public void scrollToNext(boolean smoothScroll) {
        if (isYearSelectLayoutVisible()) {
            YearViewPager yearViewPager = this.mYearViewPager;
            yearViewPager.setCurrentItem(yearViewPager.getCurrentItem() + 1, smoothScroll);
        } else if (this.mWeekPager.getVisibility() == 0) {
            WeekViewPager weekViewPager = this.mWeekPager;
            weekViewPager.setCurrentItem(weekViewPager.getCurrentItem() + 1, smoothScroll);
        } else {
            MonthViewPager monthViewPager = this.mMonthPager;
            monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() + 1, smoothScroll);
        }
    }

    public void scrollToPre(boolean smoothScroll) {
        if (isYearSelectLayoutVisible()) {
            YearViewPager yearViewPager = this.mYearViewPager;
            yearViewPager.setCurrentItem(yearViewPager.getCurrentItem() - 1, smoothScroll);
        } else if (this.mWeekPager.getVisibility() == 0) {
            WeekViewPager weekViewPager = this.mWeekPager;
            weekViewPager.setCurrentItem(weekViewPager.getCurrentItem() - 1, smoothScroll);
        } else {
            MonthViewPager monthViewPager = this.mMonthPager;
            monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() - 1, smoothScroll);
        }
    }

    public void scrollToYear(int year, boolean smoothScroll) {
        if (this.mYearViewPager.getVisibility() != 0) {
            return;
        }
        this.mYearViewPager.scrollToYear(year, smoothScroll);
    }

    public void setOnCalendarLongClickListener(OnCalendarLongClickListener listener, boolean preventLongPressedSelect) {
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        calendarViewDelegate.mCalendarLongClickListener = listener;
        calendarViewDelegate.setPreventLongPressedSelected(preventLongPressedSelect);
    }

    public void scrollToCalendar(int year, int month, int day, boolean smoothScroll, boolean invokeListener) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        if (calendar.isAvailable() && isInRange(calendar)) {
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.mCalendarInterceptListener;
            if (onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendar)) {
                this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(calendar, false);
            } else if (this.mWeekPager.getVisibility() == 0) {
                this.mWeekPager.scrollToCalendar(year, month, day, smoothScroll, invokeListener);
            } else {
                this.mMonthPager.scrollToCalendar(year, month, day, smoothScroll, invokeListener);
            }
        }
    }

    public final void setSelectStartCalendar(Calendar startCalendar) {
        if (this.mDelegate.getSelectMode() == 2 && startCalendar != null) {
            if (!isInRange(startCalendar)) {
                OnCalendarRangeSelectListener onCalendarRangeSelectListener = this.mDelegate.mCalendarRangeSelectListener;
                if (onCalendarRangeSelectListener != null) {
                    onCalendarRangeSelectListener.onSelectOutOfRange(startCalendar, true);
                    return;
                }
                return;
            }
            if (onCalendarIntercept(startCalendar)) {
                OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.mCalendarInterceptListener;
                if (onCalendarInterceptListener != null) {
                    onCalendarInterceptListener.onCalendarInterceptClick(startCalendar, false);
                    return;
                }
                return;
            }
            CalendarViewDelegate calendarViewDelegate = this.mDelegate;
            calendarViewDelegate.mSelectedEndRangeCalendar = null;
            calendarViewDelegate.mSelectedStartRangeCalendar = startCalendar;
            scrollToCalendar(startCalendar.getYear(), startCalendar.getMonth(), startCalendar.getDay());
        }
    }

    public final void setSelectEndCalendar(Calendar endCalendar) {
        Calendar calendar;
        if (this.mDelegate.getSelectMode() == 2 && (calendar = this.mDelegate.mSelectedStartRangeCalendar) != null) {
            setSelectCalendarRange(calendar, endCalendar);
        }
    }

    public final void addSchemeDate(Map<String, Calendar> mSchemeDates) {
        if (this.mDelegate == null || mSchemeDates == null || mSchemeDates.size() == 0) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate.mSchemeDatesMap == null) {
            calendarViewDelegate.mSchemeDatesMap = new HashMap();
        }
        this.mDelegate.addSchemes(mSchemeDates);
        this.mDelegate.updateSelectCalendarScheme();
        this.mYearViewPager.update();
        this.mMonthPager.updateScheme();
        this.mWeekPager.updateScheme();
    }

    public final void setSelectCalendarRange(Calendar startCalendar, Calendar endCalendar) {
        if (this.mDelegate.getSelectMode() != 2 || startCalendar == null || endCalendar == null) {
            return;
        }
        if (onCalendarIntercept(startCalendar)) {
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.mCalendarInterceptListener;
            if (onCalendarInterceptListener != null) {
                onCalendarInterceptListener.onCalendarInterceptClick(startCalendar, false);
                return;
            }
            return;
        }
        if (onCalendarIntercept(endCalendar)) {
            OnCalendarInterceptListener onCalendarInterceptListener2 = this.mDelegate.mCalendarInterceptListener;
            if (onCalendarInterceptListener2 != null) {
                onCalendarInterceptListener2.onCalendarInterceptClick(endCalendar, false);
                return;
            }
            return;
        }
        int iDiffer = endCalendar.differ(startCalendar);
        if (iDiffer >= 0 && isInRange(startCalendar) && isInRange(endCalendar)) {
            if (this.mDelegate.getMinSelectRange() != -1 && this.mDelegate.getMinSelectRange() > iDiffer + 1) {
                OnCalendarRangeSelectListener onCalendarRangeSelectListener = this.mDelegate.mCalendarRangeSelectListener;
                if (onCalendarRangeSelectListener != null) {
                    onCalendarRangeSelectListener.onSelectOutOfRange(endCalendar, true);
                    return;
                }
                return;
            }
            if (this.mDelegate.getMaxSelectRange() != -1 && this.mDelegate.getMaxSelectRange() < iDiffer + 1) {
                OnCalendarRangeSelectListener onCalendarRangeSelectListener2 = this.mDelegate.mCalendarRangeSelectListener;
                if (onCalendarRangeSelectListener2 != null) {
                    onCalendarRangeSelectListener2.onSelectOutOfRange(endCalendar, false);
                    return;
                }
                return;
            }
            if (this.mDelegate.getMinSelectRange() == -1 && iDiffer == 0) {
                CalendarViewDelegate calendarViewDelegate = this.mDelegate;
                calendarViewDelegate.mSelectedStartRangeCalendar = startCalendar;
                calendarViewDelegate.mSelectedEndRangeCalendar = null;
                OnCalendarRangeSelectListener onCalendarRangeSelectListener3 = calendarViewDelegate.mCalendarRangeSelectListener;
                if (onCalendarRangeSelectListener3 != null) {
                    onCalendarRangeSelectListener3.onCalendarRangeSelect(startCalendar, false);
                }
                scrollToCalendar(startCalendar.getYear(), startCalendar.getMonth(), startCalendar.getDay());
                return;
            }
            CalendarViewDelegate calendarViewDelegate2 = this.mDelegate;
            calendarViewDelegate2.mSelectedStartRangeCalendar = startCalendar;
            calendarViewDelegate2.mSelectedEndRangeCalendar = endCalendar;
            OnCalendarRangeSelectListener onCalendarRangeSelectListener4 = calendarViewDelegate2.mCalendarRangeSelectListener;
            if (onCalendarRangeSelectListener4 != null) {
                onCalendarRangeSelectListener4.onCalendarRangeSelect(startCalendar, false);
                this.mDelegate.mCalendarRangeSelectListener.onCalendarRangeSelect(endCalendar, true);
            }
            scrollToCalendar(startCalendar.getYear(), startCalendar.getMonth(), startCalendar.getDay());
        }
    }
}
