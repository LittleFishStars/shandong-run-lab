package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemApplyRefundPicAddBindingImpl extends MallItemApplyRefundPicAddBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34975a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10722a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f10725a;

    public MallItemApplyRefundPicAddBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f10722a, f34975a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10723a;
            this.f10723a = 0L;
        }
        ApplyRefundFileBean applyRefundFileBean = ((MallItemApplyRefundPicAddBinding) this).f34974a;
        long j2 = j & 3;
        String name = (j2 == 0 || applyRefundFileBean == null) ? null : applyRefundFileBean.getName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f10724a, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10723a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10723a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemApplyRefundPicAddBinding
    public void k(@Nullable ApplyRefundFileBean applyRefundFileBean) {
        ((MallItemApplyRefundPicAddBinding) this).f34974a = applyRefundFileBean;
        synchronized (this) {
            this.f10723a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((ApplyRefundFileBean) obj);
        return true;
    }

    public MallItemApplyRefundPicAddBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10723a = -1L;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[0];
        this.f10725a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f10724a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
