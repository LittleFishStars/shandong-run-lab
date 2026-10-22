package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.view.slide.LetterSideBarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.friend_list.FriendListViewModel;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityFriendListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f33082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LetterSideBarView f7552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FriendListViewModel f7553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f7555a;

    public ChannelActivityFriendListBinding(Object obj, View view, int i, LinearLayout linearLayout, RecyclerView recyclerView, CommonSearchView commonSearchView, LetterSideBarView letterSideBarView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33082a = linearLayout;
        this.f7551a = recyclerView;
        this.f7555a = commonSearchView;
        this.f7552a = letterSideBarView;
        this.f7554a = stateLayout;
    }

    public static ChannelActivityFriendListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityFriendListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityFriendListBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_friend_list);
    }

    @NonNull
    public static ChannelActivityFriendListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityFriendListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityFriendListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityFriendListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_friend_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityFriendListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityFriendListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_friend_list, null, false, obj);
    }

    @Nullable
    public FriendListViewModel f() {
        return this.f7553a;
    }

    public abstract void k(@Nullable FriendListViewModel friendListViewModel);
}
