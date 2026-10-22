package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.comment.write.WriteReviewSuccessActivity;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityWriteReviewSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f10499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WriteReviewSuccessActivity.a f10500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10501a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f10502b;

    public MallActivityWriteReviewSuccessBinding(Object obj, View view, int i, ImageView imageView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLTextView bLTextView, BLTextView bLTextView2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f10496a = imageView;
        this.f10498a = layoutToolbarBindingBinding;
        this.f10501a = bLTextView;
        this.f10502b = bLTextView2;
        this.f10497a = textView;
        this.b = textView2;
        this.f34892a = view2;
    }

    public static MallActivityWriteReviewSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityWriteReviewSuccessBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityWriteReviewSuccessBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_write_review_success);
    }

    @NonNull
    public static MallActivityWriteReviewSuccessBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityWriteReviewSuccessBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityWriteReviewSuccessBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityWriteReviewSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_write_review_success, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityWriteReviewSuccessBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityWriteReviewSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_write_review_success, null, false, obj);
    }

    @Nullable
    public WriteReviewSuccessActivity.a f() {
        return this.f10500a;
    }

    @Nullable
    public BaseTitleViewModel g() {
        return this.f10499a;
    }

    public abstract void l(@Nullable WriteReviewSuccessActivity.a aVar);

    public abstract void m(@Nullable BaseTitleViewModel baseTitleViewModel);
}
