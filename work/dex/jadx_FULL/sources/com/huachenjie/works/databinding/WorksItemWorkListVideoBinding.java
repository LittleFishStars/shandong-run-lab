package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorkListVideoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksItemWorkDetailListBinding f14722a;

    public WorksItemWorkListVideoBinding(Object _bindingComponent, View _root, int _localFieldCount, WorksItemWorkDetailListBinding layoutWorksDetail, ImageView videoCover, FrameLayout worksVideoContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14722a = layoutWorksDetail;
        this.f14720a = videoCover;
        this.f37079a = worksVideoContainer;
    }

    public static WorksItemWorkListVideoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorkListVideoBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorkListVideoBinding) ViewDataBinding.bind(component, view, R.layout.works_item_work_list_video);
    }

    @NonNull
    public static WorksItemWorkListVideoBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorkListVideoBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorkListVideoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorkListVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_work_list_video, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorkListVideoBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorkListVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_work_list_video, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14721a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
