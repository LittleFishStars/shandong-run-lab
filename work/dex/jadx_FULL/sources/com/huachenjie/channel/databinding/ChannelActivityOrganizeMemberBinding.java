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
import com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberModel;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityOrganizeMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeMemberModel f7654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f7656a;

    public ChannelActivityOrganizeMemberBinding(Object obj, View view, int i, RecyclerView recyclerView, CommonSearchView commonSearchView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33116a = recyclerView;
        this.f7656a = commonSearchView;
        this.f7655a = stateLayout;
    }

    public static ChannelActivityOrganizeMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityOrganizeMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityOrganizeMemberBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_organize_member);
    }

    @NonNull
    public static ChannelActivityOrganizeMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityOrganizeMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityOrganizeMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityOrganizeMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_member, null, false, obj);
    }

    @Nullable
    public OrganizeMemberModel f() {
        return this.f7654a;
    }

    public abstract void k(@Nullable OrganizeMemberModel organizeMemberModel);
}
