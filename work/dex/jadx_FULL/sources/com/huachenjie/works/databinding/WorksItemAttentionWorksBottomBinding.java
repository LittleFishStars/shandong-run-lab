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
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.external.widget.BLOperateAnimView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemAttentionWorksBottomBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14436a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14437b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f14438b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLOperateAnimView f14439b;

    @NonNull
    public final TextView c;

    public WorksItemAttentionWorksBottomBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivComment, ImageView ivShare, BLOperateAnimView llCollection, LinearLayout llComment, BLOperateAnimView llLike, LinearLayout llShare, TextView tvCollection, TextView tvComment, TextView tvShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36997a = ivComment;
        this.b = ivShare;
        this.f14436a = llCollection;
        this.f14433a = llComment;
        this.f14439b = llLike;
        this.f14437b = llShare;
        this.f14434a = tvCollection;
        this.f14438b = tvComment;
        this.c = tvShare;
    }

    public static WorksItemAttentionWorksBottomBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemAttentionWorksBottomBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemAttentionWorksBottomBinding) ViewDataBinding.bind(component, view, R.layout.works_item_attention_works_bottom);
    }

    @NonNull
    public static WorksItemAttentionWorksBottomBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemAttentionWorksBottomBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksBottomBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemAttentionWorksBottomBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_bottom, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksBottomBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemAttentionWorksBottomBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_bottom, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14435a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
