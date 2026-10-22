package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.post.PublishPostActivity;
import com.huachenjie.works.page.post.PublishPostVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityPublishPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f36792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishPostActivity.a f13903a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishPostVM f13904a;

    public WorksActivityPublishPostBinding(Object _bindingComponent, View _root, int _localFieldCount, CheckBox cbAnonymity, RecyclerView rvList) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36792a = cbAnonymity;
        this.f13902a = rvList;
    }

    public static WorksActivityPublishPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityPublishPostBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityPublishPostBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_publish_post);
    }

    @NonNull
    public static WorksActivityPublishPostBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityPublishPostBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityPublishPostBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_publish_post, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityPublishPostBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_publish_post, null, false, component);
    }

    @Nullable
    public PublishPostActivity.a f() {
        return this.f13903a;
    }

    @Nullable
    public PublishPostVM g() {
        return this.f13904a;
    }

    public abstract void l(@Nullable PublishPostActivity.a click);

    public abstract void m(@Nullable PublishPostVM vm);
}
