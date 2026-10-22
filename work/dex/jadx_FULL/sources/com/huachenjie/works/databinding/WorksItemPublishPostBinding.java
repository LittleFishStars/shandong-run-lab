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
import com.huachenjie.works.bean.PostCategoryBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPublishPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostCategoryBean f14654a;

    public WorksItemPublishPostBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView icPublishHelpPost) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37056a = icPublishHelpPost;
    }

    public static WorksItemPublishPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPublishPostBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPublishPostBinding) ViewDataBinding.bind(component, view, R.layout.works_item_publish_post);
    }

    @NonNull
    public static WorksItemPublishPostBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPublishPostBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPublishPostBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_publish_post, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPublishPostBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_publish_post, null, false, component);
    }

    @Nullable
    public PostCategoryBean f() {
        return this.f14654a;
    }

    public abstract void k(@Nullable PostCategoryBean bean);
}
