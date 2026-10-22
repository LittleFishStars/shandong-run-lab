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
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class XScrollViewWithRecycler extends XNestedScrollView implements XNestedScrollView.ScrollChangeListener, XScrollViewAdapter.AdapterItemViewListener {
    private static final int DEFAULT_SHRINK_DELAY_DURATION = 1000;
    public static final String TAG = "XScrollView";
    private int bgColorResId;
    private DisplayMetrics displayMetrics;
    private int firstShowHeight;
    private boolean ignoreStatus;
    private RecyclerView innerRecyclerView;
    private LinearLayout llFlowList;
    private Handler mHandler;
    private ValueAnimator mShrinkAnimator;
    private ShrinkRunnable mShrinkRunnbale;
    private ScrollViewRecyclerListener scrollViewRecyclerListener;
    private int scrollY;
    private long shrinkDelayDuration;
    private WeakReference<View> titleBarWeakReference;
    private FrameLayout topLayout;
    private int topLayoutMargin;
    private int topLayoutResId;
    private View topView;
    private XScrollViewAdapter xScrollViewAdapter;

    public interface ScrollViewRecyclerListener {
        void initTopLayoutView(View view);

        void onBindViewHolder(XScrollViewHolder holder, int position, XScrollItemData data);

        void touchTitleBar(boolean touchTitleBar);
    }

    public static class ShrinkRunnable implements Runnable {
        private WeakReference<XScrollViewWithRecycler> viewWeakReference;

        public ShrinkRunnable(XScrollViewWithRecycler view) {
            if (view != null) {
                this.viewWeakReference = new WeakReference<>(view);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            XScrollViewWithRecycler xScrollViewWithRecycler;
            WeakReference<XScrollViewWithRecycler> weakReference = this.viewWeakReference;
            if (weakReference == null || (xScrollViewWithRecycler = weakReference.get()) == null) {
                return;
            }
            xScrollViewWithRecycler.startShrinkAnimator();
        }
    }

    public XScrollViewWithRecycler(Context context) {
        super(context);
        this.ignoreStatus = false;
        this.shrinkDelayDuration = 1000L;
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.XScrollView);
            this.topLayoutResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.XScrollView_topLayout, -1);
            this.bgColorResId = typedArrayObtainStyledAttributes.getColor(R.styleable.XScrollView_backgroundColor, ContextCompat.getColor(getContext(), android.R.color.transparent));
            this.ignoreStatus = typedArrayObtainStyledAttributes.getBoolean(R.styleable.XScrollView_ignore_statusBar, false);
            this.firstShowHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.XScrollView_first_show_height, -1);
            this.shrinkDelayDuration = typedArrayObtainStyledAttributes.getInteger(R.styleable.XScrollView_shrink_delay_duration, 1000);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mShrinkRunnbale = new ShrinkRunnable(this);
        setScrollChangeListener(this);
        LayoutInflater.from(getContext()).inflate(R.layout.layout_scrollview_with_recycler, this);
        this.innerRecyclerView = (RecyclerView) findViewById(R.id.recycler_flow);
        this.topLayout = (FrameLayout) findViewById(R.id.top_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_flow_list);
        this.llFlowList = linearLayout;
        linearLayout.setBackgroundColor(this.bgColorResId);
        View viewInflate = LayoutInflater.from(getContext()).inflate(this.topLayoutResId, (ViewGroup) this.topLayout, false);
        this.topView = viewInflate;
        this.topLayout.addView(viewInflate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()) { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithRecycler.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        };
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        this.innerRecyclerView.setLayoutManager(linearLayoutManager);
        this.innerRecyclerView.setHasFixedSize(true);
        this.innerRecyclerView.setNestedScrollingEnabled(false);
        this.innerRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.innerRecyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithRecycler.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            }
        });
        this.displayMetrics = XScrollViewUtils.getDpi(getContext());
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithRecycler.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                XScrollViewWithRecycler.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTopLayoutTopMargin(int showHeight) {
        int i = this.topLayoutMargin;
        if (i == 0) {
            i = 0;
        }
        if (showHeight < 0 || showHeight > this.llFlowList.getMeasuredHeight()) {
            this.topLayoutMargin = this.displayMetrics.heightPixels - ((this.topLayout.getMeasuredHeight() + (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()))) + XScrollViewUtils.getNavigationHeight((Activity) getContext()));
        } else {
            this.topLayoutMargin = this.displayMetrics.heightPixels - ((showHeight + (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()))) + XScrollViewUtils.getNavigationHeight((Activity) getContext()));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.topLayoutMargin;
        this.topLayout.setLayoutParams(layoutParams);
        int i2 = this.scrollY;
        if ((i - this.topLayoutMargin) + i2 > 0) {
            scrollChange(i2);
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
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.xScrollView.XScrollViewWithRecycler.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                XScrollViewWithRecycler.this.setTopLayoutTopMargin(((Integer) animation.getAnimatedValue()).intValue());
            }
        });
        this.mShrinkAnimator.setDuration(this.shrinkDelayDuration);
        this.mShrinkAnimator.start();
    }

    @Override // com.huachenjie.common.widget.xScrollView.XScrollViewAdapter.AdapterItemViewListener
    public void changeLayout(int value) {
        setTopLayoutTopMargin(this.firstShowHeight);
        if (this.firstShowHeight >= 0) {
            long j = this.shrinkDelayDuration;
            if (j > 0) {
                this.mHandler.postDelayed(this.mShrinkRunnbale, j);
            }
        }
        setTopHeight(this.topLayoutMargin);
    }

    public View getTopLayout() {
        return this.topLayout;
    }

    public void initAdapter(List<XScrollItemTypeInfo> itemTypeInfoList) {
        XScrollViewAdapter xScrollViewAdapter = new XScrollViewAdapter(itemTypeInfoList);
        this.xScrollViewAdapter = xScrollViewAdapter;
        xScrollViewAdapter.setAdapterItemViewListener(this);
        this.innerRecyclerView.setAdapter(this.xScrollViewAdapter);
    }

    @Override // com.huachenjie.common.widget.xScrollView.XScrollViewAdapter.AdapterItemViewListener
    public void onBindViewHolder(XScrollViewHolder holder, int position, XScrollItemData data) {
        ScrollViewRecyclerListener scrollViewRecyclerListener = this.scrollViewRecyclerListener;
        if (scrollViewRecyclerListener != null) {
            scrollViewRecyclerListener.onBindViewHolder(holder, position, data);
        }
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
        setTopHeight(this.topLayout.getTop() - scrollY);
        int i = this.displayMetrics.heightPixels;
        WeakReference<View> weakReference = this.titleBarWeakReference;
        boolean z = scrollY + ((this.displayMetrics.heightPixels - this.topLayout.getTop()) - (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()))) >= (i - ((weakReference != null && weakReference.get() != null) ? this.titleBarWeakReference.get().getMeasuredHeight() : 0)) - (this.ignoreStatus ? 0 : XScrollViewUtils.getStatusBarHeight((Activity) getContext()));
        ScrollViewRecyclerListener scrollViewRecyclerListener = this.scrollViewRecyclerListener;
        if (scrollViewRecyclerListener != null) {
            scrollViewRecyclerListener.touchTitleBar(z);
        }
    }

    public void setFlowData(List<?> dataList) {
        this.xScrollViewAdapter.setData(dataList);
    }

    public void setScrollViewRecyclerListener(ScrollViewRecyclerListener listener) {
        this.scrollViewRecyclerListener = listener;
        if (listener != null) {
            listener.initTopLayoutView(this.topView);
        }
    }

    public void setTitleBar(View titleBar) {
        if (titleBar == null) {
            return;
        }
        this.titleBarWeakReference = new WeakReference<>(titleBar);
    }

    @Override // com.huachenjie.common.widget.xScrollView.XNestedScrollView
    public void sizeChanged() {
        changeLayout(0);
    }

    public XScrollViewWithRecycler(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ignoreStatus = false;
        this.shrinkDelayDuration = 1000L;
        init(context, attrs);
    }
}
