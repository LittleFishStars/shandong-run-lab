package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.post.PublishPostVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemFooterPublishPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f37031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishPostVM f14573a;

    public WorksItemFooterPublishPostBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText etRedpack) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37031a = etRedpack;
    }

    public static WorksItemFooterPublishPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemFooterPublishPostBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemFooterPublishPostBinding) ViewDataBinding.bind(component, view, R.layout.works_item_footer_publish_post);
    }

    @NonNull
    public static WorksItemFooterPublishPostBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemFooterPublishPostBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemFooterPublishPostBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemFooterPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_footer_publish_post, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemFooterPublishPostBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemFooterPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_footer_publish_post, null, false, component);
    }

    @Nullable
    public PublishPostVM f() {
        return this.f14573a;
    }

    public abstract void k(@Nullable PublishPostVM vm);
}
