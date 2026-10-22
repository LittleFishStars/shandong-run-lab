package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.ChannelBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemAllChannelListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f14427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f14428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelBean f14429a;

    @NonNull
    public final TextView b;

    public WorksItemAllChannelListBinding(Object _bindingComponent, View _root, int _localFieldCount, AvatarView ivAvatar, RoundImageView ivChannelImage, TextView tvChannelName, TextView tvFollowedCount) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14428a = ivAvatar;
        this.f14427a = ivChannelImage;
        this.f36995a = tvChannelName;
        this.b = tvFollowedCount;
    }

    public static WorksItemAllChannelListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemAllChannelListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemAllChannelListBinding) ViewDataBinding.bind(component, view, R.layout.works_item_all_channel_list);
    }

    @NonNull
    public static WorksItemAllChannelListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemAllChannelListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemAllChannelListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemAllChannelListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_all_channel_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemAllChannelListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemAllChannelListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_all_channel_list, null, false, component);
    }

    @Nullable
    public ChannelBean f() {
        return this.f14429a;
    }

    public abstract void k(@Nullable ChannelBean vm);
}
