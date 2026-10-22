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
import com.huachenjie.works.page.post.PublishPostActivity;
import com.huachenjie.works.page.post.PublishPostVM;
import com.huachenjie.works.widget.select_media.SelectGridMediaView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemHeaderPublishPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f37036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishPostActivity.a f14585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishPostVM f14586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectGridMediaView f14587a;

    public WorksItemHeaderPublishPostBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText etContent, SelectGridMediaView viewSelectMedia) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37036a = etContent;
        this.f14587a = viewSelectMedia;
    }

    public static WorksItemHeaderPublishPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemHeaderPublishPostBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemHeaderPublishPostBinding) ViewDataBinding.bind(component, view, R.layout.works_item_header_publish_post);
    }

    @NonNull
    public static WorksItemHeaderPublishPostBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemHeaderPublishPostBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemHeaderPublishPostBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemHeaderPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_header_publish_post, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemHeaderPublishPostBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemHeaderPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_header_publish_post, null, false, component);
    }

    @Nullable
    public PublishPostActivity.a f() {
        return this.f14585a;
    }

    @Nullable
    public PublishPostVM g() {
        return this.f14586a;
    }

    public abstract void l(@Nullable PublishPostActivity.a click);

    public abstract void m(@Nullable PublishPostVM vm);
}
