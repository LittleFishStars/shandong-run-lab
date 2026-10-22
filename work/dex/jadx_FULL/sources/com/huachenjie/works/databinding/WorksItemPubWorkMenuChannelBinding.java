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
import com.huachenjie.works.bean.publish.PubWorkChannelBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPubWorkMenuChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37049a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PubWorkChannelBean f14639a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public WorksItemPubWorkMenuChannelBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivIcon, TextView tvContent, TextView tvHot, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37049a = ivIcon;
        this.f14638a = tvContent;
        this.b = tvHot;
        this.c = tvName;
    }

    public static WorksItemPubWorkMenuChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPubWorkMenuChannelBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPubWorkMenuChannelBinding) ViewDataBinding.bind(component, view, R.layout.works_item_pub_work_menu_channel);
    }

    @NonNull
    public static WorksItemPubWorkMenuChannelBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPubWorkMenuChannelBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkMenuChannelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPubWorkMenuChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_menu_channel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkMenuChannelBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPubWorkMenuChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_menu_channel, null, false, component);
    }

    @Nullable
    public PubWorkChannelBean f() {
        return this.f14639a;
    }

    public abstract void k(@Nullable PubWorkChannelBean bean);
}
