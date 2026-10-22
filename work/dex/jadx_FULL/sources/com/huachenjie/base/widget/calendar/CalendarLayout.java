package com.huachenjie.base.widget.calendar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CalendarLayout extends LinearLayout {
    private static final int ACTIVE_POINTER = 1;
    private static final int CALENDAR_SHOW_MODE_BOTH_MONTH_WEEK_VIEW = 0;
    private static final int CALENDAR_SHOW_MODE_ONLY_MONTH_VIEW = 2;
    private static final int CALENDAR_SHOW_MODE_ONLY_WEEK_VIEW = 1;
    private static final int GESTURE_MODE_DEFAULT = 0;
    private static final int GESTURE_MODE_DISABLED = 2;
    private static final int INVALID_POINTER = -1;
    private static final int STATUS_EXPAND = 0;
    private static final int STATUS_SHRINK = 1;
    private float downY;
    private boolean isAnimating;
    private boolean isWeekView;
    private int mActivePointerId;
    private int mCalendarShowMode;
    CalendarView mCalendarView;
    ViewGroup mContentView;
    private int mContentViewId;
    private int mContentViewTranslateY;
    private int mDefaultStatus;
    private CalendarViewDelegate mDelegate;
    private int mGestureMode;
    private int mItemHeight;
    private float mLastX;
    private float mLastY;
    private int mMaximumVelocity;
    MonthViewPager mMonthView;
    private VelocityTracker mVelocityTracker;
    private int mViewPagerTranslateY;
    WeekBar mWeekBar;
    WeekViewPager mWeekPager;
    YearViewPager mYearView;

    public interface CalendarScrollView {
        boolean isScrollToTop();
    }

    public CalendarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mViewPagerTranslateY = 0;
        this.isAnimating = false;
        setOrientation(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CalendarLayout);
        this.mContentViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CalendarLayout_calendar_content_view_id, 0);
        this.mDefaultStatus = typedArrayObtainStyledAttributes.getInt(R.styleable.CalendarLayout_default_status, 0);
        this.mCalendarShowMode = typedArrayObtainStyledAttributes.getInt(R.styleable.CalendarLayout_calendar_show_mode, 0);
        this.mGestureMode = typedArrayObtainStyledAttributes.getInt(R.styleable.CalendarLayout_gesture_mode, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.mVelocityTracker = VelocityTracker.obtain();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private int getCalendarViewHeight() {
        int weekBarHeight;
        int calendarItemHeight;
        if (this.mMonthView.getVisibility() == 0) {
            weekBarHeight = this.mDelegate.getWeekBarHeight();
            calendarItemHeight = this.mMonthView.getHeight();
        } else {
            weekBarHeight = this.mDelegate.getWeekBarHeight();
            calendarItemHeight = this.mDelegate.getCalendarItemHeight();
        }
        return weekBarHeight + calendarItemHeight;
    }

    private int getPointerIndex(MotionEvent ev, int id) {
        int iFindPointerIndex = ev.findPointerIndex(id);
        if (iFindPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return iFindPointerIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideWeek(boolean isNotify) {
        if (isNotify) {
            onShowMonthView();
        }
        this.mWeekPager.setVisibility(8);
        this.mMonthView.setVisibility(0);
    }

    private void initCalendarPosition(Calendar cur) {
        updateSelectPosition((CalendarUtil.getMonthViewStartDiff(cur, this.mDelegate.getWeekStart()) + cur.getDay()) - 1);
    }

    private void onShowMonthView() {
        CalendarViewDelegate calendarViewDelegate;
        CalendarView.OnViewChangeListener onViewChangeListener;
        if (this.mMonthView.getVisibility() == 0 || (calendarViewDelegate = this.mDelegate) == null || (onViewChangeListener = calendarViewDelegate.mViewChangeListener) == null || !this.isWeekView) {
            return;
        }
        onViewChangeListener.onViewChange(true);
    }

    private void onShowWeekView() {
        CalendarViewDelegate calendarViewDelegate;
        CalendarView.OnViewChangeListener onViewChangeListener;
        if (this.mWeekPager.getVisibility() == 0 || (calendarViewDelegate = this.mDelegate) == null || (onViewChangeListener = calendarViewDelegate.mViewChangeListener) == null || this.isWeekView) {
            return;
        }
        onViewChangeListener.onViewChange(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWeek() {
        onShowWeekView();
        WeekViewPager weekViewPager = this.mWeekPager;
        if (weekViewPager != null && weekViewPager.getAdapter() != null) {
            this.mWeekPager.getAdapter().notifyDataSetChanged();
            this.mWeekPager.setVisibility(0);
        }
        this.mMonthView.setVisibility(4);
    }

    private void translationViewPager() {
        this.mMonthView.setTranslationY(this.mViewPagerTranslateY * ((this.mContentView.getTranslationY() * 1.0f) / this.mContentViewTranslateY));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        CalendarView calendarView;
        ViewGroup viewGroup;
        if (!this.isAnimating && this.mGestureMode != 2) {
            if (this.mYearView == null || (calendarView = this.mCalendarView) == null || calendarView.getVisibility() == 8 || (viewGroup = this.mContentView) == null || viewGroup.getVisibility() != 0) {
                return super.dispatchTouchEvent(ev);
            }
            int i = this.mCalendarShowMode;
            if (i == 2 || i == 1) {
                return super.dispatchTouchEvent(ev);
            }
            if (this.mYearView.getVisibility() == 0 || this.mDelegate.isShowYearSelectedLayout) {
                return super.dispatchTouchEvent(ev);
            }
            int action = ev.getAction();
            float y = ev.getY();
            if (action != 2 || y - this.mLastY <= 0.0f || this.mContentView.getTranslationY() != (-this.mContentViewTranslateY) || !isScrollTop()) {
                return super.dispatchTouchEvent(ev);
            }
            requestDisallowInterceptTouchEvent(false);
            return super.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean expand() {
        return expand(240);
    }

    public void hideCalendarView() {
        CalendarView calendarView = this.mCalendarView;
        if (calendarView == null) {
            return;
        }
        calendarView.setVisibility(8);
        if (!isExpand()) {
            expand(0);
        }
        requestLayout();
    }

    @SuppressLint({"NewApi"})
    public final void hideContentView() {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) {
            return;
        }
        viewGroup.animate().translationY(getHeight() - this.mMonthView.getHeight()).setDuration(220L).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                CalendarLayout.this.mContentView.setVisibility(4);
                CalendarLayout.this.mContentView.clearAnimation();
            }
        });
    }

    public final void initStatus() {
        if ((this.mDefaultStatus != 1 && this.mCalendarShowMode != 1) || this.mCalendarShowMode == 2) {
            if (this.mDelegate.mViewChangeListener == null) {
                return;
            }
            post(new Runnable() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.8
                @Override // java.lang.Runnable
                public void run() {
                    CalendarLayout.this.mDelegate.mViewChangeListener.onViewChange(true);
                }
            });
        } else if (this.mContentView != null) {
            post(new Runnable() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.7
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = CalendarLayout.this.mContentView;
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getTranslationY(), -CalendarLayout.this.mContentViewTranslateY);
                    objectAnimatorOfFloat.setDuration(0L);
                    objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.7.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float fFloatValue = (((Float) animation.getAnimatedValue()).floatValue() * 1.0f) / CalendarLayout.this.mContentViewTranslateY;
                            CalendarLayout calendarLayout = CalendarLayout.this;
                            calendarLayout.mMonthView.setTranslationY(calendarLayout.mViewPagerTranslateY * fFloatValue);
                            CalendarLayout.this.isAnimating = true;
                        }
                    });
                    objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.7.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            CalendarLayout.this.isAnimating = false;
                            CalendarLayout.this.isWeekView = true;
                            CalendarLayout.this.showWeek();
                            if (CalendarLayout.this.mDelegate == null || CalendarLayout.this.mDelegate.mViewChangeListener == null) {
                                return;
                            }
                            CalendarLayout.this.mDelegate.mViewChangeListener.onViewChange(false);
                        }
                    });
                    objectAnimatorOfFloat.start();
                }
            });
        } else {
            this.mWeekPager.setVisibility(0);
            this.mMonthView.setVisibility(8);
        }
    }

    public final boolean isExpand() {
        return this.mMonthView.getVisibility() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isScrollTop() {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup instanceof CalendarScrollView) {
            return ((CalendarScrollView) viewGroup).isScrollToTop();
        }
        if (viewGroup instanceof RecyclerView) {
            return ((RecyclerView) viewGroup).computeVerticalScrollOffset() == 0;
        }
        if (!(viewGroup instanceof AbsListView)) {
            return viewGroup.getScrollY() == 0;
        }
        AbsListView absListView = (AbsListView) viewGroup;
        if (absListView.getFirstVisiblePosition() == 0) {
            return absListView.getChildAt(0).getTop() == 0;
        }
        return false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mMonthView = (MonthViewPager) findViewById(R.id.vp_month);
        this.mWeekPager = (WeekViewPager) findViewById(R.id.vp_week);
        if (getChildCount() > 0) {
            this.mCalendarView = (CalendarView) getChildAt(0);
        }
        this.mContentView = (ViewGroup) findViewById(this.mContentViewId);
        this.mYearView = (YearViewPager) findViewById(R.id.selectLayout);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        CalendarView calendarView;
        ViewGroup viewGroup;
        if (this.isAnimating) {
            return true;
        }
        if (this.mGestureMode == 2) {
            return false;
        }
        if (this.mYearView == null || (calendarView = this.mCalendarView) == null || calendarView.getVisibility() == 8 || (viewGroup = this.mContentView) == null || viewGroup.getVisibility() != 0) {
            return super.onInterceptTouchEvent(ev);
        }
        int i = this.mCalendarShowMode;
        if (i == 2 || i == 1) {
            return false;
        }
        if (this.mYearView.getVisibility() == 0 || this.mDelegate.isShowYearSelectedLayout) {
            return super.onInterceptTouchEvent(ev);
        }
        int action = ev.getAction();
        float y = ev.getY();
        float x = ev.getX();
        if (action == 0) {
            this.mActivePointerId = ev.getPointerId(ev.getActionIndex());
            this.downY = y;
            this.mLastY = y;
            this.mLastX = x;
        } else if (action == 2) {
            float f = y - this.mLastY;
            float f2 = x - this.mLastX;
            if (f < 0.0f && this.mContentView.getTranslationY() == (-this.mContentViewTranslateY)) {
                return false;
            }
            if (f > 0.0f && this.mContentView.getTranslationY() == (-this.mContentViewTranslateY) && y >= this.mDelegate.getCalendarItemHeight() + this.mDelegate.getWeekBarHeight() && !isScrollTop()) {
                return false;
            }
            if (f > 0.0f && this.mContentView.getTranslationY() == 0.0f && y >= CalendarUtil.dipToPx(getContext(), 98.0f)) {
                return false;
            }
            if (Math.abs(f) > Math.abs(f2) && ((f > 0.0f && this.mContentView.getTranslationY() <= 0.0f) || (f < 0.0f && this.mContentView.getTranslationY() >= (-this.mContentViewTranslateY)))) {
                this.mLastY = y;
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mContentView == null || this.mCalendarView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int year = this.mDelegate.mIndexCalendar.getYear();
        int month = this.mDelegate.mIndexCalendar.getMonth();
        int iDipToPx = CalendarUtil.dipToPx(getContext(), 1.0f) + this.mDelegate.getWeekBarHeight();
        int monthViewHeight = CalendarUtil.getMonthViewHeight(year, month, this.mDelegate.getCalendarItemHeight(), this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode()) + iDipToPx;
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.mDelegate.isFullScreenCalendar()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.mContentView.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((size - iDipToPx) - this.mDelegate.getCalendarItemHeight(), 1073741824));
            ViewGroup viewGroup = this.mContentView;
            viewGroup.layout(viewGroup.getLeft(), this.mContentView.getTop(), this.mContentView.getRight(), this.mContentView.getBottom());
            return;
        }
        if (monthViewHeight >= size && this.mMonthView.getHeight() > 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(monthViewHeight + iDipToPx + this.mDelegate.getWeekBarHeight(), 1073741824);
            size = monthViewHeight;
        } else if (monthViewHeight < size && this.mMonthView.getHeight() > 0) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        if (this.mCalendarShowMode == 2 || this.mCalendarView.getVisibility() == 8) {
            monthViewHeight = this.mCalendarView.getVisibility() == 8 ? 0 : this.mCalendarView.getHeight();
        } else if (this.mGestureMode != 2 || this.isAnimating || !isExpand()) {
            size -= iDipToPx;
            monthViewHeight = this.mItemHeight;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mContentView.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size - monthViewHeight, 1073741824));
        ViewGroup viewGroup2 = this.mContentView;
        viewGroup2.layout(viewGroup2.getLeft(), this.mContentView.getTop(), this.mContentView.getRight(), this.mContentView.getBottom());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        Parcelable parcelable = bundle.getParcelable("super");
        if (bundle.getBoolean("isExpand")) {
            post(new Runnable() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    CalendarLayout.this.expand(0);
                }
            });
        } else {
            post(new Runnable() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    CalendarLayout.this.shrink(0);
                }
            });
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putBoolean("isExpand", isExpand());
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x005f  */
    /* JADX WARN: Code duplicated, block: B:41:0x006b  */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        int i;
        CalendarViewDelegate calendarViewDelegate;
        CalendarView calendarView;
        CalendarView.OnViewChangeListener onViewChangeListener;
        int pointerIndex;
        if (this.mGestureMode == 2 || (i = this.mCalendarShowMode) == 2 || i == 1 || (calendarViewDelegate = this.mDelegate) == null || calendarViewDelegate.isShowYearSelectedLayout || this.mContentView == null || (calendarView = this.mCalendarView) == null || calendarView.getVisibility() == 8) {
            return false;
        }
        int action = event.getAction();
        float y = event.getY();
        this.mVelocityTracker.addMovement(event);
        if (action == 0) {
            this.mActivePointerId = event.getPointerId(event.getActionIndex());
            this.downY = y;
            this.mLastY = y;
            return true;
        }
        if (action == 1) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            float yVelocity = velocityTracker.getYVelocity();
            if (this.mContentView.getTranslationY() == 0.0f || this.mContentView.getTranslationY() == this.mContentViewTranslateY) {
                expand();
            } else {
                if (Math.abs(yVelocity) >= 800.0f) {
                    if (yVelocity < 0.0f) {
                        shrink();
                    } else {
                        expand();
                    }
                    return super.onTouchEvent(event);
                }
                if (event.getY() - this.downY > 0.0f) {
                    expand();
                } else {
                    shrink();
                }
            }
        } else if (action == 2) {
            getPointerIndex(event, this.mActivePointerId);
            if (this.mActivePointerId == -1) {
                this.mLastY = y;
                this.mActivePointerId = 1;
            }
            float f = y - this.mLastY;
            if (f < 0.0f && this.mContentView.getTranslationY() == (-this.mContentViewTranslateY)) {
                this.mLastY = y;
                event.setAction(0);
                dispatchTouchEvent(event);
                this.mWeekPager.setVisibility(0);
                this.mMonthView.setVisibility(4);
                if (!this.isWeekView && (onViewChangeListener = this.mDelegate.mViewChangeListener) != null) {
                    onViewChangeListener.onViewChange(false);
                }
                this.isWeekView = true;
                return true;
            }
            hideWeek(false);
            if (f > 0.0f && this.mContentView.getTranslationY() + f >= 0.0f) {
                this.mContentView.setTranslationY(0.0f);
                translationViewPager();
                this.mLastY = y;
                return super.onTouchEvent(event);
            }
            if (f < 0.0f) {
                float translationY = this.mContentView.getTranslationY() + f;
                int i2 = this.mContentViewTranslateY;
                if (translationY <= (-i2)) {
                    this.mContentView.setTranslationY(-i2);
                    translationViewPager();
                    this.mLastY = y;
                    return super.onTouchEvent(event);
                }
            }
            ViewGroup viewGroup = this.mContentView;
            viewGroup.setTranslationY(viewGroup.getTranslationY() + f);
            translationViewPager();
            this.mLastY = y;
        } else if (action == 3) {
            pointerIndex = getPointerIndex(event, this.mActivePointerId);
            if (this.mActivePointerId != -1) {
                this.mLastY = event.getY(pointerIndex);
            }
        } else if (action == 5) {
            int pointerId = event.getPointerId(event.getActionIndex());
            this.mActivePointerId = pointerId;
            if (pointerId == 0) {
                this.mLastY = event.getY(pointerId);
            }
        } else if (action == 6) {
            pointerIndex = getPointerIndex(event, this.mActivePointerId);
            if (this.mActivePointerId != -1) {
                this.mLastY = event.getY(pointerIndex);
            }
        }
        return super.onTouchEvent(event);
    }

    public void setModeBothMonthWeekView() {
        this.mCalendarShowMode = 0;
        requestLayout();
    }

    public void setModeOnlyMonthView() {
        this.mCalendarShowMode = 2;
        requestLayout();
    }

    public void setModeOnlyWeekView() {
        this.mCalendarShowMode = 1;
        requestLayout();
    }

    public final void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        this.mItemHeight = delegate.getCalendarItemHeight();
        initCalendarPosition(delegate.mSelectedCalendar.isAvailable() ? delegate.mSelectedCalendar : delegate.createCurrentDate());
        updateContentViewTranslateY();
    }

    public void showCalendarView() {
        this.mCalendarView.setVisibility(0);
        requestLayout();
    }

    @SuppressLint({"NewApi"})
    public final void showContentView() {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setTranslationY(getHeight() - this.mMonthView.getHeight());
        this.mContentView.setVisibility(0);
        this.mContentView.animate().translationY(0.0f).setDuration(180L).setInterpolator(new LinearInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
    }

    public boolean shrink() {
        return shrink(240);
    }

    public final void updateCalendarItemHeight() {
        this.mItemHeight = this.mDelegate.getCalendarItemHeight();
        if (this.mContentView == null) {
            return;
        }
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        Calendar calendar = calendarViewDelegate.mIndexCalendar;
        updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(calendar, calendarViewDelegate.getWeekStart()));
        if (this.mDelegate.getMonthViewShowMode() == 0) {
            this.mContentViewTranslateY = this.mItemHeight * 5;
        } else {
            this.mContentViewTranslateY = CalendarUtil.getMonthViewHeight(calendar.getYear(), calendar.getMonth(), this.mItemHeight, this.mDelegate.getWeekStart()) - this.mItemHeight;
        }
        translationViewPager();
        if (this.mWeekPager.getVisibility() == 0) {
            this.mContentView.setTranslationY(-this.mContentViewTranslateY);
        }
    }

    public void updateContentViewTranslateY() {
        ViewGroup viewGroup;
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        Calendar calendar = calendarViewDelegate.mIndexCalendar;
        if (calendarViewDelegate.getMonthViewShowMode() == 0) {
            this.mContentViewTranslateY = this.mItemHeight * 5;
        } else {
            this.mContentViewTranslateY = CalendarUtil.getMonthViewHeight(calendar.getYear(), calendar.getMonth(), this.mItemHeight, this.mDelegate.getWeekStart()) - this.mItemHeight;
        }
        if (this.mWeekPager.getVisibility() != 0 || (viewGroup = this.mContentView) == null) {
            return;
        }
        viewGroup.setTranslationY(-this.mContentViewTranslateY);
    }

    public final void updateSelectPosition(int selectPosition) {
        this.mViewPagerTranslateY = (((selectPosition + 7) / 7) - 1) * this.mItemHeight;
    }

    public final void updateSelectWeek(int week) {
        this.mViewPagerTranslateY = (week - 1) * this.mItemHeight;
    }

    public boolean expand(int duration) {
        if (this.isAnimating || this.mCalendarShowMode == 1 || this.mContentView == null) {
            return false;
        }
        if (this.mMonthView.getVisibility() != 0) {
            this.mWeekPager.setVisibility(8);
            onShowMonthView();
            this.isWeekView = false;
            this.mMonthView.setVisibility(0);
        }
        ViewGroup viewGroup = this.mContentView;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getTranslationY(), 0.0f);
        objectAnimatorOfFloat.setDuration(duration);
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                float fFloatValue = (((Float) animation.getAnimatedValue()).floatValue() * 1.0f) / CalendarLayout.this.mContentViewTranslateY;
                CalendarLayout calendarLayout = CalendarLayout.this;
                calendarLayout.mMonthView.setTranslationY(calendarLayout.mViewPagerTranslateY * fFloatValue);
                CalendarLayout.this.isAnimating = true;
            }
        });
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                CalendarLayout.this.isAnimating = false;
                if (CalendarLayout.this.mGestureMode == 2) {
                    CalendarLayout.this.requestLayout();
                }
                CalendarLayout.this.hideWeek(true);
                if (CalendarLayout.this.mDelegate.mViewChangeListener != null && CalendarLayout.this.isWeekView) {
                    CalendarLayout.this.mDelegate.mViewChangeListener.onViewChange(true);
                }
                CalendarLayout.this.isWeekView = false;
            }
        });
        objectAnimatorOfFloat.start();
        return true;
    }

    public boolean shrink(int duration) {
        ViewGroup viewGroup;
        if (this.mGestureMode == 2) {
            requestLayout();
        }
        if (this.isAnimating || (viewGroup = this.mContentView) == null) {
            return false;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroup, "translationY", viewGroup.getTranslationY(), -this.mContentViewTranslateY);
        objectAnimatorOfFloat.setDuration(duration);
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                float fFloatValue = (((Float) animation.getAnimatedValue()).floatValue() * 1.0f) / CalendarLayout.this.mContentViewTranslateY;
                CalendarLayout calendarLayout = CalendarLayout.this;
                calendarLayout.mMonthView.setTranslationY(calendarLayout.mViewPagerTranslateY * fFloatValue);
                CalendarLayout.this.isAnimating = true;
            }
        });
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.base.widget.calendar.CalendarLayout.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                CalendarLayout.this.isAnimating = false;
                CalendarLayout.this.showWeek();
                CalendarLayout.this.isWeekView = true;
            }
        });
        objectAnimatorOfFloat.start();
        return true;
    }
}
