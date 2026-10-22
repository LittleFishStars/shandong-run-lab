package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class InternalAbstract extends RelativeLayout implements RefreshInternal {
    protected xm8 mSpinnerStyle;
    protected RefreshInternal mWrappedInternal;
    protected View mWrappedView;

    /* JADX WARN: Multi-variable type inference failed */
    public InternalAbstract(@NonNull View view) {
        this(view, view instanceof RefreshInternal ? (RefreshInternal) view : null);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof RefreshInternal) && getView() == ((RefreshInternal) obj).getView();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public xm8 getSpinnerStyle() {
        int i;
        xm8 xm8Var = this.mSpinnerStyle;
        if (xm8Var != null) {
            return xm8Var;
        }
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            return refreshInternal.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                xm8 xm8Var2 = ((SmartRefreshLayout.LayoutParams) layoutParams).f15121a;
                this.mSpinnerStyle = xm8Var2;
                if (xm8Var2 != null) {
                    return xm8Var2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                xm8 xm8Var3 = xm8.b;
                this.mSpinnerStyle = xm8Var3;
                return xm8Var3;
            }
        }
        xm8 xm8Var4 = xm8.f45853a;
        this.mSpinnerStyle = xm8Var4;
        return xm8Var4;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public View getView() {
        View view = this.mWrappedView;
        return view == null ? this : view;
    }

    public boolean isSupportHorizontalDrag() {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        return (refreshInternal == null || refreshInternal == this || !refreshInternal.isSupportHorizontalDrag()) ? false : true;
    }

    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return 0;
        }
        return refreshInternal.onFinish(refreshLayout, z);
    }

    public void onHorizontalDrag(float f, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onHorizontalDrag(f, i, i2);
    }

    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal != null && refreshInternal != this) {
            refreshInternal.onInitialized(refreshKernel, i, i2);
            return;
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                refreshKernel.f(this, ((SmartRefreshLayout.LayoutParams) layoutParams).f40395a);
            }
        }
    }

    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onMoving(z, f, i, i2, i3);
    }

    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onReleased(refreshLayout, i, i2);
    }

    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.onStartAnimator(refreshLayout, i, i2);
    }

    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof RefreshHeaderWrapper) && (refreshInternal instanceof RefreshFooter)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        RefreshInternal refreshInternal2 = this.mWrappedInternal;
        if (refreshInternal2 != null) {
            refreshInternal2.onStateChanged(refreshLayout, refreshState, refreshState2);
        }
    }

    public boolean setNoMoreData(boolean z) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        return (refreshInternal instanceof RefreshFooter) && ((RefreshFooter) refreshInternal).setNoMoreData(z);
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        RefreshInternal refreshInternal = this.mWrappedInternal;
        if (refreshInternal == null || refreshInternal == this) {
            return;
        }
        refreshInternal.setPrimaryColors(iArr);
    }

    public InternalAbstract(@NonNull View view, @Nullable RefreshInternal refreshInternal) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = refreshInternal;
        if ((this instanceof RefreshFooterWrapper) && (refreshInternal instanceof RefreshHeader) && refreshInternal.getSpinnerStyle() == xm8.e) {
            refreshInternal.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof RefreshHeaderWrapper) {
            RefreshInternal refreshInternal2 = this.mWrappedInternal;
            if ((refreshInternal2 instanceof RefreshFooter) && refreshInternal2.getSpinnerStyle() == xm8.e) {
                refreshInternal.getView().setScaleY(-1.0f);
            }
        }
    }

    public InternalAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
