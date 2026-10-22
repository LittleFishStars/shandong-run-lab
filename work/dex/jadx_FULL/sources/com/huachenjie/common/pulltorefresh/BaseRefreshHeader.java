package com.huachenjie.common.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.CircleLoadingView;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.zj.adlib.jj8;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class BaseRefreshHeader extends LinearLayout implements RefreshHeader {
    public static final String f = "BaseRefreshHeader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f33850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CircleLoadingView f8828a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33851a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33851a = iArr;
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33851a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33851a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BaseRefreshHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public xm8 getSpinnerStyle() {
        return xm8.f45853a;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    public final void i(Context context) {
        setGravity(81);
        setPadding(0, 0, 0, jj8.a(16.0f));
        setOrientation(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f33850a = new TextView(context);
        CircleLoadingView circleLoadingView = new CircleLoadingView(context);
        this.f8828a = circleLoadingView;
        circleLoadingView.setSize(11, 11);
        this.f33850a.setTextSize(1, 14.0f);
        this.f33850a.setTextColor(ResourcesCompat.getColor(getResources(), R.color.color_9aacbe, null));
        addView(this.f8828a);
        addView(this.f33850a);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        Context context;
        int i;
        Log.i(f, "onFinish:success=" + success);
        this.f8828a.cancelAnimation();
        this.f33850a.setVisibility(0);
        this.f8828a.setVisibility(8);
        TextView textView = this.f33850a;
        if (success) {
            context = getContext();
            i = R.string.refresh_succeed;
        } else {
            context = getContext();
            i = R.string.refresh_failed;
        }
        textView.setText(context.getString(i));
        return 500;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int maxDragHeight) {
        Log.i(f, "onInitialized:height=" + height + ",maxDragHeight=" + maxDragHeight);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        Log.i(f, "onReleased:" + height + "," + maxDragHeight);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        Log.i(f, "onStartAnimator:" + height + "," + maxDragHeight);
        this.f8828a.setVisibility(0);
        this.f8828a.playAnimation();
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        Log.i(f, "onStateChanged,oldState=" + oldState + ",newState=" + newState);
        int i = a.f33851a[newState.ordinal()];
        if (i == 1) {
            this.f8828a.setVisibility(8);
            this.f33850a.setVisibility(0);
            this.f33850a.setText(getContext().getString(R.string.pull_to_refresh));
        } else if (i == 2) {
            this.f8828a.setVisibility(8);
            this.f33850a.setVisibility(0);
            this.f33850a.setText(getContext().getString(R.string.release_to_refresh));
        } else {
            if (i != 3) {
                return;
            }
            this.f8828a.setVisibility(0);
            this.f33850a.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void setPrimaryColors(int... colors) {
    }

    public BaseRefreshHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseRefreshHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        i(context);
    }
}
