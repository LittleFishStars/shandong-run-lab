package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewActivity;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityBannerPreviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public BaseViewModel f34771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ImagePreviewActivity.a f10143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImagePreviewView f10144a;

    public MallActivityBannerPreviewBinding(Object obj, View view, int i, ImagePreviewView imagePreviewView) {
        super(obj, view, i);
        this.f10144a = imagePreviewView;
    }

    public static MallActivityBannerPreviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityBannerPreviewBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityBannerPreviewBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_banner_preview);
    }

    @NonNull
    public static MallActivityBannerPreviewBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityBannerPreviewBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityBannerPreviewBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityBannerPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_banner_preview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityBannerPreviewBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityBannerPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_banner_preview, null, false, obj);
    }

    @Nullable
    public ImagePreviewActivity.a f() {
        return this.f10143a;
    }

    @Nullable
    public BaseViewModel g() {
        return this.f34771a;
    }

    public abstract void l(@Nullable ImagePreviewActivity.a aVar);

    public abstract void m(@Nullable BaseViewModel baseViewModel);
}
