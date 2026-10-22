package com.huachenjie.mall.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.PosterBackgroundBean;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemPosterBgBindingImpl extends MallItemPosterBgBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35022a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10866a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f10869a;

    public MallItemPosterBgBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10866a, f35022a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zEquals;
        String posterUrl;
        synchronized (this) {
            j = this.f10867a;
            this.f10867a = 0L;
        }
        PosterBackgroundBean posterBackgroundBean = ((MallItemPosterBgBinding) this).f10865a;
        String str = this.f;
        long j2 = 7 & j;
        if (j2 != 0) {
            posterUrl = ((j & 5) == 0 || posterBackgroundBean == null) ? null : posterBackgroundBean.getPosterUrl();
            zEquals = TextUtils.equals(str, posterBackgroundBean != null ? posterBackgroundBean.getPosterNo() : null);
        } else {
            zEquals = false;
            posterUrl = null;
        }
        long j3 = j & 5;
        RequestOptions requestOptions = j3 != 0 ? ju3.y : null;
        if (j3 != 0) {
            CommonBindingAdapter.b0(((MallItemPosterBgBinding) this).f35021a, posterUrl, requestOptions, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f10869a, zEquals);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10867a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10867a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemPosterBgBinding
    public void l(@Nullable PosterBackgroundBean posterBackgroundBean) {
        ((MallItemPosterBgBinding) this).f10865a = posterBackgroundBean;
        synchronized (this) {
            this.f10867a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemPosterBgBinding
    public void m(@Nullable String str) {
        this.f = str;
        synchronized (this) {
            this.f10867a |= 2;
        }
        notifyPropertyChanged(hk0.j0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g == i) {
            l((PosterBackgroundBean) obj);
        } else {
            if (hk0.j0 != i) {
                return false;
            }
            m((String) obj);
        }
        return true;
    }

    public MallItemPosterBgBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1]);
        this.f10867a = -1L;
        ((MallItemPosterBgBinding) this).f35021a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10868a = constraintLayout;
        constraintLayout.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[2];
        this.f10869a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
