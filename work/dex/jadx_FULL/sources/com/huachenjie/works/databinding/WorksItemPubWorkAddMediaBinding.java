package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.widget.select_media.SelectGridMediaAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPubWorkAddMediaBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SelectGridMediaAdapter f37047a;

    public WorksItemPubWorkAddMediaBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemPubWorkAddMediaBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPubWorkAddMediaBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPubWorkAddMediaBinding) ViewDataBinding.bind(component, view, R.layout.works_item_pub_work_add_media);
    }

    @NonNull
    public static WorksItemPubWorkAddMediaBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPubWorkAddMediaBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkAddMediaBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPubWorkAddMediaBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_add_media, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkAddMediaBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPubWorkAddMediaBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_add_media, null, false, component);
    }

    @Nullable
    public SelectGridMediaAdapter f() {
        return this.f37047a;
    }

    public abstract void k(@Nullable SelectGridMediaAdapter adapter);
}
