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
import com.huachenjie.channel.page.manage_channel.chat.SelectChatTeamLogoVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelDialogSelectChatTeamLogoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SelectChatTeamLogoVM f7754a;

    public ChannelDialogSelectChatTeamLogoBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f33153a = recyclerView;
    }

    public static ChannelDialogSelectChatTeamLogoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelDialogSelectChatTeamLogoBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelDialogSelectChatTeamLogoBinding) ViewDataBinding.bind(obj, view, R.layout.channel_dialog_select_chat_team_logo);
    }

    @NonNull
    public static ChannelDialogSelectChatTeamLogoBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelDialogSelectChatTeamLogoBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelDialogSelectChatTeamLogoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelDialogSelectChatTeamLogoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_select_chat_team_logo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelDialogSelectChatTeamLogoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelDialogSelectChatTeamLogoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_select_chat_team_logo, null, false, obj);
    }

    @Nullable
    public SelectChatTeamLogoVM f() {
        return this.f7754a;
    }

    public abstract void k(@Nullable SelectChatTeamLogoVM selectChatTeamLogoVM);
}
