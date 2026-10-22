package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemAttentionWorksVideoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f37003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkDetailBean f14460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksItemAttentionWorksBottomBinding f14461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WorksItemAttentionWorksHeaderBinding f14462a;

    public WorksItemAttentionWorksVideoBinding(Object _bindingComponent, View _root, int _localFieldCount, WorksItemAttentionWorksBottomBinding attentionWorksBottom, WorksItemAttentionWorksHeaderBinding attentionWorksHeader, LinearLayout flImageContainer, FrameLayout flWorksContainer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14461a = attentionWorksBottom;
        this.f14462a = attentionWorksHeader;
        this.f14459a = flImageContainer;
        this.f37003a = flWorksContainer;
    }

    public static WorksItemAttentionWorksVideoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemAttentionWorksVideoBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemAttentionWorksVideoBinding) ViewDataBinding.bind(component, view, R.layout.works_item_attention_works_video);
    }

    @NonNull
    public static WorksItemAttentionWorksVideoBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemAttentionWorksVideoBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksVideoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemAttentionWorksVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_video, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemAttentionWorksVideoBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemAttentionWorksVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_attention_works_video, null, false, component);
    }

    @Nullable
    public WorkDetailBean f() {
        return this.f14460a;
    }

    public abstract void k(@Nullable WorkDetailBean vm);
}
