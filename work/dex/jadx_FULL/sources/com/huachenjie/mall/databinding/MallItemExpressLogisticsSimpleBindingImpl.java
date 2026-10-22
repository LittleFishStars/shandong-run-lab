package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemExpressLogisticsSimpleBindingImpl extends MallItemExpressLogisticsSimpleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10798a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10800a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35000a = sparseIntArray;
        sparseIntArray.put(R.id.v_status, 3);
    }

    public MallItemExpressLogisticsSimpleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10798a, f35000a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CharSequence contentSpan;
        String time;
        synchronized (this) {
            j = this.f10799a;
            this.f10799a = 0L;
        }
        ExpressLogisticsBean expressLogisticsBean = ((MallItemExpressLogisticsSimpleBinding) this).f10796a;
        long j2 = j & 3;
        if (j2 == 0 || expressLogisticsBean == null) {
            contentSpan = null;
            time = null;
        } else {
            contentSpan = expressLogisticsBean.getContentSpan();
            time = expressLogisticsBean.getTime();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((MallItemExpressLogisticsSimpleBinding) this).f34999a, contentSpan);
            TextViewBindingAdapter.setText(this.b, time);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10799a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10799a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemExpressLogisticsSimpleBinding
    public void k(@Nullable ExpressLogisticsBean expressLogisticsBean) {
        ((MallItemExpressLogisticsSimpleBinding) this).f10796a = expressLogisticsBean;
        synchronized (this) {
            this.f10799a |= 1;
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
        k((ExpressLogisticsBean) obj);
        return true;
    }

    public MallItemExpressLogisticsSimpleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1], (TextView) objArr[2], (BLView) objArr[3]);
        this.f10799a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f10800a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((MallItemExpressLogisticsSimpleBinding) this).f34999a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
