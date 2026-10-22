package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.WriteReviewImageBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemWriteReviewImageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f10959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WriteReviewImageBean f10960a;

    public MallItemWriteReviewImageBinding(Object obj, View view, int i, RoundImageView roundImageView, ImageView imageView) {
        super(obj, view, i);
        this.f10959a = roundImageView;
        this.f35051a = imageView;
    }

    public static MallItemWriteReviewImageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemWriteReviewImageBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemWriteReviewImageBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_write_review_image);
    }

    @NonNull
    public static MallItemWriteReviewImageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemWriteReviewImageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemWriteReviewImageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemWriteReviewImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_write_review_image, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemWriteReviewImageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemWriteReviewImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_write_review_image, null, false, obj);
    }

    @Nullable
    public WriteReviewImageBean f() {
        return this.f10960a;
    }

    public abstract void k(@Nullable WriteReviewImageBean writeReviewImageBean);
}
