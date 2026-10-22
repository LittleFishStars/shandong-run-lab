package com.huachenjie.common.widget.xScrollView;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.huachenjie.common.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class XScrollViewWithNested extends XNestedScrollView implements XNestedScrollView.ScrollChangeListener {
    private static final int DEFAULT_SHRINK_DELAY_DURATION = 1000;
    public static final String TAG = "XScrollViewWithNested";
    private FrameLayout aboveTopLayout;
    private int aboveTopLayoutResId;
    private View aboveTopView;
    private int bgColorResId;
    private DisplayMetrics displayMetrics;
    private int firstShowHeight;
    private boolean ignoreStatus;
    private NestedScrollView innerScrollView;
    private LinearLayout llFlowList;
    private Handler mHandler;
    private ValueAnimator mShrinkAnimator;
    private ShrinkRunnable mShrinkRunnbale;
    private ScrollViewWithNestedListener scrollViewWithNestedListener;
    private int scrollY;
    private long shrinkDelayDuration;
    private WeakReference<View> titleBarWeakReference;
    private FrameLayout topLayout;
    private int topLayoutMargin;
    private int topLayoutResId;
    private View topView;
    private View viewPlaceHolder;

    public interface ScrollViewWithNestedListener {
        void initAboveTopLayoutView(View view);

        void initTopLayoutView(View view);

        void touchTitleBar(boolean touchTitleBar);
    }

    public static class ShrinkRunnable implements Runnable {
        private WeakReference<XScrollViewWithNested> viewWeakReference;

        public ShrinkRunnable(XScrollViewWithNested view) {
            if (view != null) {
                this.viewWeakReference = new WeakReference<>(view);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            XScrollViewWithNested xScrollViewWithNested;
            WeakReference<XScrollViewWithNested> weakReference = this.viewWeakReference;
            if (weakReference == null || (xScrollViewWithNested = weakReference.get()) == null) {
                return;
            }
            xScrollViewWithNested.startShrinkAnimator();
        }
    }

    public XScrollViewWithNested(Context context) {
        super(context);
        this.ignoreStatus = false;
        this.shrinkDelayDuration = 1000L;
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.XScrollView);
            this.topLayoutResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.XScrollView_topLayout, -1);
            this.aboveTopLayoutResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.XScrollView_aboveTopLayout, -1);
            this.bgColorResId = typedArrayObtainStyledAttributes.getColor(R.styleable.XScrollView_backgroundColor, ContextCompat.getColor(getContext(), android.R.color.transparent));
            this.ignoreStatus = typedArrayObtainStyledAttributes.getBoolean(R.styleable.XScrollView_ignore_statusBar, false);
            this.useSpringAnimation = typedArrayObtainStyledAttributes.getBoolean(R.styleable.XScrollView_use_spring_animation, true);
            this.firstShowHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.XScrollView_first_show_height, -1);
            this.shrinkDelayDuration = typedArrayObtainStyledAttributes.getInteger(R.styleable.XScrollView_shrink_delay_duration, 1000);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShrinkRunnbale = new ShrinkRunnable(this);
        setScrollChangeListener(this);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_scrollview_with_nested, this);
        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.scrollview_inner);
        this.innerScrollView = nestedScrollView;
        nestedScrollView.setFillViewport(true);
        this.innerScrollView.setNestedScrollingEnabled(false);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_flow_list);
        this.llFlowList = linearLayout;
        linearLayout.setBackgroundColor(this.bgColorResId);
        this.topLayout = (FrameLayout) findViewById(R.id.top_layout);
        if (this.topLayoutResId != -1) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.topLayoutResId, (ViewGroup) this.topLayout, false);
            this.topView = viewInflate;
            this.topLayout.addView(viewInflate);
        }
        this.aboveTopLayout = (FrameLayout) findViewById(R.id.above_top_layout);
        if (this.aboveTopLayoutResId != -1) {
            View viewInflate2 = LayoutInflater.from(getContext()).inflate(this.aboveTopLayoutResId, (ViewGroup) this.aboveTopLayout, false);
            this.aboveTopView = viewInflate2;
            this.aboveTopLayout.addView(viewInflate2);
        }
        this.displayMetrics = XScrollViewUtils.getDpi(getContext());
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithNested.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                XScrollViewWithNested.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollViewTopMargin(int showHeight) {
        int i = this.topLayoutMargin;
        if (i == 0) {
            i = 0;
        }
        if (showHeight < 0 || showHeight > this.llFlowList.getMeasuredHeight()) {
            int i2 = this.displayMetrics.heightPixels;
            FrameLayout frameLayout = this.aboveTopLayout;
            int measuredHeight = frameLayout == null ? 0 : frameLayout.getMeasuredHeight();
            FrameLayout frameLayout2 = this.topLayout;
            this.topLayoutMargin = i2 - (((measuredHeight + (frameLayout2 == null ? 0 : frameLayout2.getMeasuredHeight())) + (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()))) + XScrollViewUtils.getNavigationHeight((Activity) getContext()));
        } else {
            this.topLayoutMargin = this.displayMetrics.heightPixels - ((showHeight + (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()))) + XScrollViewUtils.getNavigationHeight((Activity) getContext()));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.llFlowList.getLayoutParams();
        layoutParams.topMargin = this.topLayoutMargin;
        this.llFlowList.setLayoutParams(layoutParams);
        int i3 = this.scrollY;
        if ((i - this.topLayoutMargin) + i3 > 0) {
            scrollChange(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShrinkAnimator() {
        ValueAnimator valueAnimator = this.mShrinkAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mShrinkAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.firstShowHeight, this.topLayout.getMeasuredHeight());
        this.mShrinkAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithNested.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                XScrollViewWithNested.this.setScrollViewTopMargin(((Integer) animation.getAnimatedValue()).intValue());
            }
        });
        this.mShrinkAnimator.setDuration(this.shrinkDelayDuration);
        this.mShrinkAnimator.start();
    }

    public void addFlowChildView(final View child, @IntRange(from = 2) final int index) {
        LinearLayout linearLayout = this.llFlowList;
        if (linearLayout == null || child == null || index < 2) {
            return;
        }
        linearLayout.post(new Runnable() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithNested.2
            @Override // java.lang.Runnable
            public void run() {
                XScrollViewWithNested.this.llFlowList.addView(child, index);
            }
        });
    }

    public View addFlowChildViewImmediately(int resource, @IntRange(from = 2) int index) {
        if (this.llFlowList == null || resource <= 0 || index < 2) {
            return null;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(resource, (ViewGroup) this.llFlowList, false);
        this.llFlowList.addView(viewInflate, index);
        return viewInflate;
    }

    @RequiresApi(api = 19)
    public void changeLayout() {
        setScrollViewTopMargin(this.firstShowHeight);
        if (this.firstShowHeight >= 0) {
            long j = this.shrinkDelayDuration;
            if (j > 0) {
                this.mHandler.postDelayed(this.mShrinkRunnbale, j);
            }
        }
        int i = this.topLayoutMargin;
        FrameLayout frameLayout = this.aboveTopLayout;
        setTopHeight(i + (frameLayout == null ? 0 : frameLayout.getMeasuredHeight()));
    }

    public LinearLayout getLlFlowList() {
        return this.llFlowList;
    }

    public View getTopView() {
        return this.topView;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(api = 23)
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mShrinkAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.huachenjie.common.widget.xScrollView.XNestedScrollView.ScrollChangeListener
    public void scrollChange(int scrollY) {
        this.scrollY = scrollY;
        int top = this.llFlowList.getTop() - scrollY;
        FrameLayout frameLayout = this.aboveTopLayout;
        setTopHeight(top + (frameLayout == null ? 0 : frameLayout.getMeasuredHeight()));
        int i = this.displayMetrics.heightPixels;
        WeakReference<View> weakReference = this.titleBarWeakReference;
        boolean z = scrollY + ((this.displayMetrics.heightPixels - this.llFlowList.getTop()) - (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()))) >= (i - ((weakReference != null && weakReference.get() != null) ? this.titleBarWeakReference.get().getMeasuredHeight() : 0)) - (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()));
        ScrollViewWithNestedListener scrollViewWithNestedListener = this.scrollViewWithNestedListener;
        if (scrollViewWithNestedListener != null) {
            scrollViewWithNestedListener.touchTitleBar(z);
        }
    }

    public void setScrollViewWithNestedListener(ScrollViewWithNestedListener listener) {
        this.scrollViewWithNestedListener = listener;
        if (listener == null) {
            return;
        }
        View view = this.aboveTopView;
        if (view != null) {
            listener.initAboveTopLayoutView(view);
        }
        View view2 = this.topView;
        if (view2 != null) {
            listener.initTopLayoutView(view2);
        }
    }

    public void setTitleBar(View titleBar) {
        if (titleBar == null) {
            return;
        }
        this.titleBarWeakReference = new WeakReference<>(titleBar);
    }

    public void setTopView(View topView) {
        this.topView = topView;
    }

    @Override // com.huachenjie.common.widget.xScrollView.XNestedScrollView
    @RequiresApi(api = 19)
    public void sizeChanged() {
        changeLayout();
    }

    public View addFlowChildView(int resource, @IntRange(from = 2) final int index) {
        if (this.llFlowList == null || resource <= 0 || index < 2) {
            return null;
        }
        final View viewInflate = LayoutInflater.from(getContext()).inflate(resource, (ViewGroup) this.llFlowList, false);
        this.llFlowList.post(new Runnable() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithNested.3
            @Override // java.lang.Runnable
            public void run() {
                XScrollViewWithNested.this.llFlowList.addView(viewInflate, index);
            }
        });
        return viewInflate;
    }

    public XScrollViewWithNested(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ignoreStatus = false;
        this.shrinkDelayDuration = 1000L;
        init(context, attrs);
    }
}
