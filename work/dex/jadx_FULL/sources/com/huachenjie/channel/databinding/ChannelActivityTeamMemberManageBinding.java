package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageVM;
import com.huachenjie.common.widget.CommonSearchView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityTeamMemberManageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public TeamMemberManageActivity.a f33130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TeamMemberManageVM f7694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f7695a;

    public ChannelActivityTeamMemberManageBinding(Object obj, View view, int i, CommonSearchView commonSearchView) {
        super(obj, view, i);
        this.f7695a = commonSearchView;
    }

    public static ChannelActivityTeamMemberManageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityTeamMemberManageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityTeamMemberManageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_team_member_manage);
    }

    @NonNull
    public static ChannelActivityTeamMemberManageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityTeamMemberManageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityTeamMemberManageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityTeamMemberManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_team_member_manage, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityTeamMemberManageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityTeamMemberManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_team_member_manage, null, false, obj);
    }

    @Nullable
    public TeamMemberManageActivity.a f() {
        return this.f33130a;
    }

    @Nullable
    public TeamMemberManageVM g() {
        return this.f7694a;
    }

    public abstract void l(@Nullable TeamMemberManageActivity.a aVar);

    public abstract void m(@Nullable TeamMemberManageVM teamMemberManageVM);
}
