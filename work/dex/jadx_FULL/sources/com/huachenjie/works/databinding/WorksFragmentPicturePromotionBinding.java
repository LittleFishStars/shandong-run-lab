package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.picture.PicturePromotionFragment;
import com.huachenjie.works.page.details.picture.PicturePromotionModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentPicturePromotionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonBanner f14238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PicturePromotionFragment.a f14239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PicturePromotionModel f14240a;

    public WorksFragmentPicturePromotionBinding(Object _bindingComponent, View _root, int _localFieldCount, CommonBanner banner, TextView tvContent) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14238a = banner;
        this.f36924a = tvContent;
    }

    public static WorksFragmentPicturePromotionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentPicturePromotionBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentPicturePromotionBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_picture_promotion);
    }

    @NonNull
    public static WorksFragmentPicturePromotionBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentPicturePromotionBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPicturePromotionBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentPicturePromotionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_picture_promotion, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentPicturePromotionBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentPicturePromotionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_picture_promotion, null, false, component);
    }

    @Nullable
    public PicturePromotionFragment.a f() {
        return this.f14239a;
    }

    @Nullable
    public PicturePromotionModel g() {
        return this.f14240a;
    }

    public abstract void l(@Nullable PicturePromotionFragment.a click);

    public abstract void m(@Nullable PicturePromotionModel vm);
}
