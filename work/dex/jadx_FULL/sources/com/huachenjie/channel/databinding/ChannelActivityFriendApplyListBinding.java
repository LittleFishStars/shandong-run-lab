package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.notify.friend_apply.FriendApplyListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityFriendApplyListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f33079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FriendApplyListVM f7543a;

    public ChannelActivityFriendApplyListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelActivityFriendApplyListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityFriendApplyListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityFriendApplyListBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_friend_apply_list);
    }

    @NonNull
    public static ChannelActivityFriendApplyListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityFriendApplyListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityFriendApplyListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityFriendApplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_friend_apply_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityFriendApplyListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityFriendApplyListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_friend_apply_list, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f33079a;
    }

    @Nullable
    public FriendApplyListVM g() {
        return this.f7543a;
    }

    public abstract void l(@Nullable FriendApplyListVM friendApplyListVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
