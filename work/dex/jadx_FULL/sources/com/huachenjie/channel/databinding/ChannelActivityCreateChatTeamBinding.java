package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamActivity;
import com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityCreateChatTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f7479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateChatTeamActivity.ClickProxy f7480a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateChatTeamVM f7481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f7483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f7484a;

    @Bindable
    public String f;

    public ChannelActivityCreateChatTeamBinding(Object obj, View view, int i, EditText editText, ShadowConstraintLayout shadowConstraintLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, View view2) {
        super(obj, view, i);
        this.f7479a = editText;
        this.f7483a = shadowConstraintLayout;
        this.f7482a = layoutToolbarBindingBinding;
        this.f33057a = view2;
    }

    public static ChannelActivityCreateChatTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityCreateChatTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityCreateChatTeamBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_create_chat_team);
    }

    @NonNull
    public static ChannelActivityCreateChatTeamBinding k(@NonNull LayoutInflater layoutInflater) {
        return n(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityCreateChatTeamBinding l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityCreateChatTeamBinding m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityCreateChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_create_chat_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityCreateChatTeamBinding n(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityCreateChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_create_chat_team, null, false, obj);
    }

    @Nullable
    public CreateChatTeamActivity.ClickProxy f() {
        return this.f7480a;
    }

    @Nullable
    public Boolean g() {
        return this.f7484a;
    }

    @Nullable
    public String h() {
        return this.f;
    }

    @Nullable
    public CreateChatTeamVM j() {
        return this.f7481a;
    }

    public abstract void o(@Nullable CreateChatTeamActivity.ClickProxy clickProxy);

    public abstract void p(@Nullable Boolean bool);

    public abstract void q(@Nullable String str);

    public abstract void r(@Nullable CreateChatTeamVM createChatTeamVM);
}
