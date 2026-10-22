package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksLocaleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkItemBean f14770a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14771b;

    @NonNull
    public final ImageView c;

    public WorksItemWorksLocaleBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivImage, ImageView ivVideoIcon, ImageView ivWorkDelete, TextView tvTag, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37095a = ivImage;
        this.b = ivVideoIcon;
        this.c = ivWorkDelete;
        this.f14769a = tvTag;
        this.f14771b = tvTitle;
    }

    public static WorksItemWorksLocaleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksLocaleBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksLocaleBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_locale);
    }

    @NonNull
    public static WorksItemWorksLocaleBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksLocaleBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksLocaleBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksLocaleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_locale, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksLocaleBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksLocaleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_locale, null, false, component);
    }

    @Nullable
    public WorkItemBean f() {
        return this.f14770a;
    }

    public abstract void k(@Nullable WorkItemBean bean);
}
