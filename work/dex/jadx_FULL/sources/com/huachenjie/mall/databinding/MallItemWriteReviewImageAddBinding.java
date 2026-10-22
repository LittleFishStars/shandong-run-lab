package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.WriteReviewAddImageBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemWriteReviewImageAddBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public WriteReviewAddImageBean f35049a;

    public MallItemWriteReviewImageAddBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemWriteReviewImageAddBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemWriteReviewImageAddBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemWriteReviewImageAddBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_write_review_image_add);
    }

    @NonNull
    public static MallItemWriteReviewImageAddBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemWriteReviewImageAddBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemWriteReviewImageAddBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemWriteReviewImageAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_write_review_image_add, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemWriteReviewImageAddBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemWriteReviewImageAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_write_review_image_add, null, false, obj);
    }

    @Nullable
    public WriteReviewAddImageBean f() {
        return this.f35049a;
    }

    public abstract void k(@Nullable WriteReviewAddImageBean writeReviewAddImageBean);
}
