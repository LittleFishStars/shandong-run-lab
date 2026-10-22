package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.all_member.AllMemberModel;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAllMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AllMemberModel f7404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f7406a;

    public ChannelActivityAllMemberBinding(Object obj, View view, int i, RecyclerView recyclerView, CommonSearchView commonSearchView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33032a = recyclerView;
        this.f7406a = commonSearchView;
        this.f7405a = stateLayout;
    }

    public static ChannelActivityAllMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAllMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAllMemberBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_all_member);
    }

    @NonNull
    public static ChannelActivityAllMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAllMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAllMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAllMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_all_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAllMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAllMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_all_member, null, false, obj);
    }

    @Nullable
    public AllMemberModel f() {
        return this.f7404a;
    }

    public abstract void k(@Nullable AllMemberModel allMemberModel);
}
