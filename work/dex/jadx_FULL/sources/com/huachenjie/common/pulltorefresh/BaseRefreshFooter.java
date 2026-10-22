package com.huachenjie.common.pulltorefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.CircleLoadingView;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class BaseRefreshFooter extends InternalAbstract implements RefreshFooter {
    public static final int L = 60;
    public static final int M = 500;
    public static final String g = "BaseRefreshFooter";
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f33848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CircleLoadingView f8826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8827a;
    public String f;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33849a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33849a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33849a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33849a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33849a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33849a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33849a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BaseRefreshFooter(Context context) {
        this(context, null);
    }

    public int getDefaultHeight() {
        return this.K;
    }

    public String getNoMoreDataDesc() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8826a.cancelAnimation();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        Context context;
        int i;
        if (this.f8827a) {
            this.f33848a.setVisibility(8);
            this.f33848a.setText(TextUtils.isEmpty(this.f) ? "" : this.f);
            return 0;
        }
        this.f33848a.setVisibility(8);
        TextView textView = this.f33848a;
        if (success) {
            context = getContext();
            i = R.string.finish_load_more;
        } else {
            context = getContext();
            i = R.string.load_more_failed;
        }
        textView.setText(context.getString(i));
        CircleLoadingView circleLoadingView = this.f8826a;
        circleLoadingView.cancelAnimation();
        circleLoadingView.setVisibility(8);
        return 500;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.K, 1073741824));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        if (this.f8827a) {
            return;
        }
        CircleLoadingView circleLoadingView = this.f8826a;
        circleLoadingView.setVisibility(0);
        this.f33848a.setVisibility(8);
        circleLoadingView.playAnimation();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        if (this.f8827a) {
            this.f8826a.setVisibility(8);
            this.f33848a.setVisibility(0);
            this.f33848a.setText(TextUtils.isEmpty(this.f) ? "" : this.f);
        } else {
            CircleLoadingView circleLoadingView = this.f8826a;
            circleLoadingView.setVisibility(0);
            this.f33848a.setVisibility(8);
            circleLoadingView.playAnimation();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        if (!this.f8827a) {
            switch (a.f33849a[newState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    this.f33848a.setVisibility(8);
                    this.f8826a.setVisibility(0);
                    break;
            }
        }
        if (newState != RefreshState.ReleaseToLoad) {
            this.f33848a.setText(TextUtils.isEmpty(this.f) ? "" : this.f);
            this.f33848a.setVisibility(0);
            this.f8826a.setVisibility(8);
        }
    }

    public BaseRefreshFooter setDefaultHeight(int defaultHeight) {
        this.K = defaultHeight;
        requestLayout();
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean setNoMoreData(boolean noMoreData) {
        if (this.f8827a == noMoreData) {
            return true;
        }
        this.f8827a = noMoreData;
        if (!noMoreData) {
            return true;
        }
        this.f33848a.setText(TextUtils.isEmpty(this.f) ? "" : this.f);
        return true;
    }

    public BaseRefreshFooter setNoMoreDataDesc(String desc) {
        this.f = desc;
        return this;
    }

    public BaseRefreshFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRefreshFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8827a = false;
        this.K = jj8.a(60.0f);
        this.f = context.getString(R.string.no_more_desc);
        TextView textView = new TextView(context);
        this.f33848a = textView;
        textView.setTextSize(1, 14.0f);
        this.f33848a.setTextColor(ResourcesCompat.getColor(getResources(), R.color.color_9aacbe, null));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f33848a, layoutParams);
        this.f8826a = new CircleLoadingView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(jj8.a(22.0f), jj8.a(22.0f));
        layoutParams2.addRule(13);
        addView(this.f8826a, layoutParams2);
    }
}
