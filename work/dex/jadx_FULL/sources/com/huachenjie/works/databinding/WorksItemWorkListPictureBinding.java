package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorkListPictureBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14716a;

    public WorksItemWorkListPictureBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout imageContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37077a = imageContainer;
    }

    public static WorksItemWorkListPictureBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorkListPictureBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorkListPictureBinding) ViewDataBinding.bind(component, view, R.layout.works_item_work_list_picture);
    }

    @NonNull
    public static WorksItemWorkListPictureBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorkListPictureBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorkListPictureBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorkListPictureBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_work_list_picture, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorkListPictureBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorkListPictureBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_work_list_picture, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14716a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
