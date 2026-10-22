package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CommonBanner;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemAttentionWorksPictureBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CommonBanner f37001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksItemAttentionWorksBottomBinding f14454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksItemAttentionWorksHeaderBinding f14455a;

    public WorksItemAttentionWorksPictureBinding(Object _bindingComponent, View _root, int _localFieldCount, WorksItemAttentionWorksBottomBinding attentionWorksBottom, WorksItemAttentionWorksHeaderBinding attentionWorksHeader, CommonBanner worksBanner) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14454a = attentionWorksBottom;
        this.f14455a = attentionWorksHeader;
        this.f37001a = worksBanner;
    }

    public static WorksItemAttentionWorksPictureBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemAttentionWorksPictureBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemAttentionWorksPictureBinding) ViewDataBinding.bind(component, view, R.layout.works_item_attention_works_picture);
    }

    @NonNull
    public static WorksItemAttentionWorksPictureBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemAttentionWorksPictureBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksPictureBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemAttentionWorksPictureBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_picture, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksPictureBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemAttentionWorksPictureBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_picture, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14453a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
