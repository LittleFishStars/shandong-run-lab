package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.widget.FriendFollowButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemNotifyFansBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f8108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FansBean f8109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FriendFollowButton f8110a;

    public ChannelItemNotifyFansBinding(Object obj, View view, int i, FriendFollowButton friendFollowButton, AvatarView avatarView, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f8110a = friendFollowButton;
        this.f8108a = avatarView;
        this.f33294a = imageView;
        this.f8107a = textView;
    }

    public static ChannelItemNotifyFansBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemNotifyFansBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemNotifyFansBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_notify_fans);
    }

    @NonNull
    public static ChannelItemNotifyFansBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemNotifyFansBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyFansBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemNotifyFansBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify_fans, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyFansBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemNotifyFansBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify_fans, null, false, obj);
    }

    @Nullable
    public FansBean f() {
        return this.f8109a;
    }

    public abstract void k(@Nullable FansBean fansBean);
}
