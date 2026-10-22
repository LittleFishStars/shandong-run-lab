package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.widget.select_media.SelectGridMediaAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPublishWorkPicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PubWorkMediaData f14659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SelectGridMediaAdapter f14660a;

    @NonNull
    public final ImageView b;

    public WorksItemPublishWorkPicBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivDel, ImageView ivPic) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37058a = ivDel;
        this.b = ivPic;
    }

    public static WorksItemPublishWorkPicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPublishWorkPicBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPublishWorkPicBinding) ViewDataBinding.bind(component, view, R.layout.works_item_publish_work_pic);
    }

    @NonNull
    public static WorksItemPublishWorkPicBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPublishWorkPicBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPublishWorkPicBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPublishWorkPicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_publish_work_pic, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPublishWorkPicBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPublishWorkPicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_publish_work_pic, null, false, component);
    }

    @Nullable
    public SelectGridMediaAdapter f() {
        return this.f14660a;
    }

    @Nullable
    public PubWorkMediaData g() {
        return this.f14659a;
    }

    public abstract void l(@Nullable SelectGridMediaAdapter adapter);

    public abstract void m(@Nullable PubWorkMediaData data);
}
