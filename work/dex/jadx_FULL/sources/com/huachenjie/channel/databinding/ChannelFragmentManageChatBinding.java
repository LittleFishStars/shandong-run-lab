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
import com.huachenjie.channel.page.manage_channel.chat.ManageChatVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentManageChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ManageChatVM f33182a;

    public ChannelFragmentManageChatBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentManageChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentManageChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentManageChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_manage_chat);
    }

    @NonNull
    public static ChannelFragmentManageChatBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentManageChatBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentManageChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentManageChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_chat, null, false, obj);
    }

    @Nullable
    public ManageChatVM f() {
        return this.f33182a;
    }

    public abstract void k(@Nullable ManageChatVM manageChatVM);
}
