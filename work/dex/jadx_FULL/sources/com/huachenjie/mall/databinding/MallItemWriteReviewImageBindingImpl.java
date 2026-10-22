package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.WriteReviewImageBean;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemWriteReviewImageBindingImpl extends MallItemWriteReviewImageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10961a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10963a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35052a = sparseIntArray;
        sparseIntArray.put(R.id.iv_delete, 2);
    }

    public MallItemWriteReviewImageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10961a, f35052a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10962a;
            this.f10962a = 0L;
        }
        WriteReviewImageBean writeReviewImageBean = ((MallItemWriteReviewImageBinding) this).f10960a;
        long j2 = j & 3;
        String imagePath = (j2 == 0 || writeReviewImageBean == null) ? null : writeReviewImageBean.getImagePath();
        if (j2 != 0) {
            CommonBindingAdapter.b0(((MallItemWriteReviewImageBinding) this).f10959a, imagePath, null, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10962a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10962a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemWriteReviewImageBinding
    public void k(@Nullable WriteReviewImageBean writeReviewImageBean) {
        ((MallItemWriteReviewImageBinding) this).f10960a = writeReviewImageBean;
        synchronized (this) {
            this.f10962a |= 1;
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
        k((WriteReviewImageBean) obj);
        return true;
    }

    public MallItemWriteReviewImageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundImageView) objArr[1], (ImageView) objArr[2]);
        this.f10962a = -1L;
        ((MallItemWriteReviewImageBinding) this).f10959a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10963a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
