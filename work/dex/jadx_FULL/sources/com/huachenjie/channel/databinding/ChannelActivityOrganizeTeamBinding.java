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
import com.huachenjie.channel.page.organize.team.OrganizeTeamActivity;
import com.huachenjie.channel.page.organize.team.OrganizeTeamVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityOrganizeTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeTeamActivity.a f7670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeTeamVM f7671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7674a;

    public ChannelActivityOrganizeTeamBinding(Object obj, View view, int i, BLTextView bLTextView, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLView bLView) {
        super(obj, view, i);
        this.f7673a = bLTextView;
        this.f33121a = recyclerView;
        this.f7672a = layoutToolbarBindingBinding;
        this.f7674a = bLView;
    }

    public static ChannelActivityOrganizeTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityOrganizeTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityOrganizeTeamBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_organize_team);
    }

    @NonNull
    public static ChannelActivityOrganizeTeamBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityOrganizeTeamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeTeamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityOrganizeTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeTeamBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityOrganizeTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_team, null, false, obj);
    }

    @Nullable
    public OrganizeTeamActivity.a f() {
        return this.f7670a;
    }

    @Nullable
    public OrganizeTeamVM g() {
        return this.f7671a;
    }

    public abstract void l(@Nullable OrganizeTeamActivity.a aVar);

    public abstract void m(@Nullable OrganizeTeamVM organizeTeamVM);
}
