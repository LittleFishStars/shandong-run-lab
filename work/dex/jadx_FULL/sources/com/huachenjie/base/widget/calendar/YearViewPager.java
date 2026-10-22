package com.huachenjie.base.widget.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class YearViewPager extends ViewPager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean isUpdateYearView;
    private CalendarViewDelegate mDelegate;
    private YearRecyclerView.OnMonthSelectedListener mListener;
    private int mYearCount;

    public YearViewPager(Context context) {
        this(context, null);
    }

    private static int getHeight(Context context, View view) {
        int height = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        view.getLocationOnScreen(iArr);
        return height - iArr[1];
    }

    public void notifyDataSetChanged() {
        this.mYearCount = (this.mDelegate.getMaxYear() - this.mDelegate.getMinYear()) + 1;
        if (getAdapter() != null) {
            getAdapter().notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.mDelegate.isYearViewScrollable() && super.onInterceptTouchEvent(ev);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent ev) {
        return this.mDelegate.isYearViewScrollable() && super.onTouchEvent(ev);
    }

    public void scrollToYear(int year, boolean smoothScroll) {
        setCurrentItem(year - this.mDelegate.getMinYear(), smoothScroll);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }

    public final void setOnMonthSelectedListener(YearRecyclerView.OnMonthSelectedListener listener) {
        this.mListener = listener;
    }

    public void setup(CalendarViewDelegate delegate) {
        this.mDelegate = delegate;
        this.mYearCount = (delegate.getMaxYear() - this.mDelegate.getMinYear()) + 1;
        setAdapter(new PagerAdapter() { // from class: com.huachenjie.base.widget.calendar.YearViewPager.1
            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return YearViewPager.this.mYearCount;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getItemPosition(@NonNull Object object) {
                if (YearViewPager.this.isUpdateYearView) {
                    return -2;
                }
                return super.getItemPosition(object);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            @NonNull
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                YearRecyclerView yearRecyclerView = new YearRecyclerView(YearViewPager.this.getContext());
                container.addView(yearRecyclerView);
                yearRecyclerView.setup(YearViewPager.this.mDelegate);
                yearRecyclerView.setOnMonthSelectedListener(YearViewPager.this.mListener);
                yearRecyclerView.init(position + YearViewPager.this.mDelegate.getMinYear());
                return yearRecyclerView;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }
        });
        setCurrentItem(this.mDelegate.getCurrentDay().getYear() - this.mDelegate.getMinYear());
    }

    public final void update() {
        for (int i = 0; i < getChildCount(); i++) {
            ((YearRecyclerView) getChildAt(i)).notifyAdapterDataSetChanged();
        }
    }

    public final void updateRange() {
        this.isUpdateYearView = true;
        notifyDataSetChanged();
        this.isUpdateYearView = false;
    }

    public final void updateStyle() {
        for (int i = 0; i < getChildCount(); i++) {
            ((YearRecyclerView) getChildAt(i)).updateStyle();
        }
    }

    public final void updateWeekStart() {
        for (int i = 0; i < getChildCount(); i++) {
            YearRecyclerView yearRecyclerView = (YearRecyclerView) getChildAt(i);
            yearRecyclerView.updateWeekStart();
            yearRecyclerView.notifyAdapterDataSetChanged();
        }
    }

    public YearViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (Math.abs(getCurrentItem() - item) > 1) {
            super.setCurrentItem(item, false);
        } else {
            super.setCurrentItem(item, false);
        }
    }
}
