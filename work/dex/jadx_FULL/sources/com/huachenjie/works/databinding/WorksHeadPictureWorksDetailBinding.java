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
import com.huachenjie.works.page.details.picture.PictureWorksDetailFragment;
import com.huachenjie.works.page.details.picture.PictureWorksDetailModel;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksHeadPictureWorksDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonBanner f14376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PictureWorksDetailFragment.a f14377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PictureWorksDetailModel f14378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14379a;

    @NonNull
    public final BLTextView b;

    public WorksHeadPictureWorksDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, CommonBanner banner, TextView tvContent, BLTextView tvLevel, BLTextView tvTag) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14376a = banner;
        this.f36976a = tvContent;
        this.f14379a = tvLevel;
        this.b = tvTag;
    }

    public static WorksHeadPictureWorksDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksHeadPictureWorksDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksHeadPictureWorksDetailBinding) ViewDataBinding.bind(component, view, R.layout.works_head_picture_works_detail);
    }

    @NonNull
    public static WorksHeadPictureWorksDetailBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksHeadPictureWorksDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksHeadPictureWorksDetailBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksHeadPictureWorksDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_head_picture_works_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksHeadPictureWorksDetailBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksHeadPictureWorksDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_head_picture_works_detail, null, false, component);
    }

    @Nullable
    public PictureWorksDetailFragment.a f() {
        return this.f14377a;
    }

    @Nullable
    public PictureWorksDetailModel g() {
        return this.f14378a;
    }

    public abstract void l(@Nullable PictureWorksDetailFragment.a click);

    public abstract void m(@Nullable PictureWorksDetailModel vm);
}
