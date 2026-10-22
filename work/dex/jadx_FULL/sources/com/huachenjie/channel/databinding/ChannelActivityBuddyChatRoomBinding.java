package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.notify.buddy.BuddyChatRoomActivity;
import com.huachenjie.channel.page.notify.buddy.BuddyChatRoomVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityBuddyChatRoomBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyChatRoomActivity.a f7421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuddyChatRoomVM f7422a;

    public ChannelActivityBuddyChatRoomBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f33038a = frameLayout;
    }

    public static ChannelActivityBuddyChatRoomBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityBuddyChatRoomBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityBuddyChatRoomBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_buddy_chat_room);
    }

    @NonNull
    public static ChannelActivityBuddyChatRoomBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityBuddyChatRoomBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityBuddyChatRoomBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityBuddyChatRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_buddy_chat_room, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityBuddyChatRoomBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityBuddyChatRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_buddy_chat_room, null, false, obj);
    }

    @Nullable
    public BuddyChatRoomActivity.a f() {
        return this.f7421a;
    }

    @Nullable
    public BuddyChatRoomVM g() {
        return this.f7422a;
    }

    public abstract void l(@Nullable BuddyChatRoomActivity.a aVar);

    public abstract void m(@Nullable BuddyChatRoomVM buddyChatRoomVM);
}
