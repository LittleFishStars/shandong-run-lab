package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.bean.WriteReviewAddImageBean;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemWriteReviewImageAddBindingImpl extends MallItemWriteReviewImageAddBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35050a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10955a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10958a;

    public MallItemWriteReviewImageAddBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f10955a, f35050a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f10956a;
            this.f10956a = 0L;
        }
        WriteReviewAddImageBean writeReviewAddImageBean = ((MallItemWriteReviewImageAddBinding) this).f35049a;
        long j2 = j & 3;
        if (j2 != 0) {
            str = String.format("可再加%d张", Integer.valueOf(writeReviewAddImageBean != null ? writeReviewAddImageBean.getOptionalNum() : 0));
        } else {
            str = null;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f10957a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10956a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10956a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemWriteReviewImageAddBinding
    public void k(@Nullable WriteReviewAddImageBean writeReviewAddImageBean) {
        ((MallItemWriteReviewImageAddBinding) this).f35049a = writeReviewAddImageBean;
        synchronized (this) {
            this.f10956a |= 1;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((WriteReviewAddImageBean) obj);
        return true;
    }

    public MallItemWriteReviewImageAddBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10956a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10958a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f10957a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
