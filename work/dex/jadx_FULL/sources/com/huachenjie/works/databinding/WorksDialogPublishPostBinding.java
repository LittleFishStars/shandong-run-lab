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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.campus_wall.dialog.PublishPostDialog;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogPublishPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PublishPostDialog.a f14107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14108a;

    public WorksDialogPublishPostBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivClose, BLLinearLayout llContent, RecyclerView recyclerView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36877a = ivClose;
        this.f14108a = llContent;
        this.f14106a = recyclerView;
    }

    public static WorksDialogPublishPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogPublishPostBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogPublishPostBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_publish_post);
    }

    @NonNull
    public static WorksDialogPublishPostBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogPublishPostBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogPublishPostBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_publish_post, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogPublishPostBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogPublishPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_publish_post, null, false, component);
    }

    @Nullable
    public PublishPostDialog.a f() {
        return this.f14107a;
    }

    public abstract void k(@Nullable PublishPostDialog.a click);
}
