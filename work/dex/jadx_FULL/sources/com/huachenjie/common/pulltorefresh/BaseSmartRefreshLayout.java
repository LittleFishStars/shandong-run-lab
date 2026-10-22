package com.huachenjie.common.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class BaseSmartRefreshLayout extends SmartRefreshLayout implements OnRefreshListener, OnLoadMoreListener {
    public static final String f = "BaseSmartRefreshLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnDispatchTouchEvent f33852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StatusListener f8829a;

    public interface OnDispatchTouchEvent {
        void a(MotionEvent e);
    }

    public interface StatusListener {
        void onLoadMore(RefreshLayout refreshLayout);

        void onRefresh(RefreshLayout refreshLayout);
    }

    public BaseSmartRefreshLayout(Context context) {
        super(context);
    }

    @Override // com.scwang.smartrefresh.layout.SmartRefreshLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent e) {
        OnDispatchTouchEvent onDispatchTouchEvent = this.f33852a;
        if (onDispatchTouchEvent != null) {
            onDispatchTouchEvent.a(e);
        }
        return super.dispatchTouchEvent(e);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        StatusListener statusListener = this.f8829a;
        if (statusListener != null) {
            statusListener.onLoadMore(refreshLayout);
        }
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        StatusListener statusListener = this.f8829a;
        if (statusListener != null) {
            statusListener.onRefresh(refreshLayout);
        }
    }

    public void setOnDispatchTouchEvent(OnDispatchTouchEvent dispatchTouchEvent) {
        this.f33852a = dispatchTouchEvent;
    }

    public void setStatusChangeListener(StatusListener listener) {
        this.f8829a = listener;
    }

    public BaseSmartRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDragRate(0.5f);
        setReboundDuration(200);
        setHeaderMaxDragRate(3.0f);
        setFooterMaxDragRate(2.0f);
        setHeaderTriggerRate(1.0f);
        setFooterTriggerRate(1.0f);
        setHeaderHeight(0.0f);
        setFooterHeight(60.0f);
        setEnableRefresh(true);
        setEnableLoadMore(true);
        setEnableAutoLoadMore(false);
        setEnablePureScrollMode(false);
        setEnableOverScrollBounce(true);
        setEnableScrollContentWhenLoaded(true);
        setEnableHeaderTranslationContent(true);
        setEnableFooterTranslationContent(true);
        setEnableLoadMoreWhenContentNotFull(true);
        setDisableContentWhenRefresh(true);
        setDisableContentWhenLoading(false);
        setRefreshHeader(new BaseRefreshHeader(context));
        setRefreshFooter(new BaseRefreshFooter(context));
        setOnRefreshListener(this);
        setOnLoadMoreListener(this);
    }

    public BaseSmartRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
