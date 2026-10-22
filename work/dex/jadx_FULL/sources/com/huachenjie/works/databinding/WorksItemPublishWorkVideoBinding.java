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
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.widget.select_media.SelectGridMediaAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPublishWorkVideoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f14665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PubWorkMediaData f14666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SelectGridMediaAdapter f14667a;

    @NonNull
    public final DrawableCenterButton b;

    @NonNull
    public final DrawableCenterButton c;

    public WorksItemPublishWorkVideoBinding(Object _bindingComponent, View _root, int _localFieldCount, DrawableCenterButton btCover, DrawableCenterButton btDel, DrawableCenterButton btPreview, FrameLayout flContainer, ImageView ivVideoMark) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14665a = btCover;
        this.b = btDel;
        this.c = btPreview;
        this.f37060a = flContainer;
        this.f14664a = ivVideoMark;
    }

    public static WorksItemPublishWorkVideoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPublishWorkVideoBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPublishWorkVideoBinding) ViewDataBinding.bind(component, view, R.layout.works_item_publish_work_video);
    }

    @NonNull
    public static WorksItemPublishWorkVideoBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPublishWorkVideoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPublishWorkVideoBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPublishWorkVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_publish_work_video, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPublishWorkVideoBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPublishWorkVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_publish_work_video, null, false, component);
    }

    @Nullable
    public SelectGridMediaAdapter f() {
        return this.f14667a;
    }

    @Nullable
    public PubWorkMediaData g() {
        return this.f14666a;
    }

    public abstract void l(@Nullable SelectGridMediaAdapter adapter);

    public abstract void m(@Nullable PubWorkMediaData data);
}
