package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.MayKnowFriendBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemAddFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MayKnowFriendBean f7896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7897a;

    public ChannelItemAddFriendBinding(Object obj, View view, int i, BLTextView bLTextView, AvatarView avatarView, TextView textView) {
        super(obj, view, i);
        this.f7897a = bLTextView;
        this.f7895a = avatarView;
        this.f33216a = textView;
    }

    public static ChannelItemAddFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemAddFriendBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemAddFriendBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_add_friend);
    }

    @NonNull
    public static ChannelItemAddFriendBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemAddFriendBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemAddFriendBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemAddFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_add_friend, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemAddFriendBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemAddFriendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_add_friend, null, false, obj);
    }

    @Nullable
    public MayKnowFriendBean f() {
        return this.f7896a;
    }

    public abstract void k(@Nullable MayKnowFriendBean mayKnowFriendBean);
}
