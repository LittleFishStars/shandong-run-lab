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
import com.huachenjie.works.bean.publish.PubWorkTopicBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPubWorkMenuTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PubWorkTopicBean f37053a;

    public WorksItemPubWorkMenuTopicBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemPubWorkMenuTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPubWorkMenuTopicBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPubWorkMenuTopicBinding) ViewDataBinding.bind(component, view, R.layout.works_item_pub_work_menu_topic);
    }

    @NonNull
    public static WorksItemPubWorkMenuTopicBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPubWorkMenuTopicBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkMenuTopicBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPubWorkMenuTopicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_menu_topic, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkMenuTopicBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPubWorkMenuTopicBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_menu_topic, null, false, component);
    }

    @Nullable
    public PubWorkTopicBean f() {
        return this.f37053a;
    }

    public abstract void k(@Nullable PubWorkTopicBean bean);
}
