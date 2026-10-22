package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemCourseDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f34986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f10756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EpisodeItemBean f10757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f10759a;

    public MallItemCourseDetailBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, CustomerTextView customerTextView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f34986a = lottieAnimationView;
        this.f10756a = customerTextView;
        this.f10758a = bLTextView;
    }

    public static MallItemCourseDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemCourseDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemCourseDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_course_detail);
    }

    @NonNull
    public static MallItemCourseDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemCourseDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemCourseDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemCourseDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_course_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemCourseDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemCourseDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_course_detail, null, false, obj);
    }

    @Nullable
    public EpisodeItemBean f() {
        return this.f10757a;
    }

    @Nullable
    public Boolean g() {
        return this.f10759a;
    }

    public abstract void l(@Nullable EpisodeItemBean episodeItemBean);

    public abstract void m(@Nullable Boolean bool);
}
