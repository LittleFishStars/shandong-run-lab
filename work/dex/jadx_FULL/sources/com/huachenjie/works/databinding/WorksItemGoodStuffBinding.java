package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodStuffBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemGoodStuffBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodStuffBean f14580a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public WorksItemGoodStuffBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivImage, LinearLayout llTag, TextView tvName, TextView tvPayNum, TextView tvPrice) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37034a = ivImage;
        this.f14578a = llTag;
        this.f14579a = tvName;
        this.b = tvPayNum;
        this.c = tvPrice;
    }

    public static WorksItemGoodStuffBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemGoodStuffBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemGoodStuffBinding) ViewDataBinding.bind(component, view, R.layout.works_item_good_stuff);
    }

    @NonNull
    public static WorksItemGoodStuffBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemGoodStuffBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemGoodStuffBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemGoodStuffBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_good_stuff, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemGoodStuffBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemGoodStuffBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_good_stuff, null, false, component);
    }

    @Nullable
    public GoodStuffBean f() {
        return this.f14580a;
    }

    public abstract void k(@Nullable GoodStuffBean bean);
}
