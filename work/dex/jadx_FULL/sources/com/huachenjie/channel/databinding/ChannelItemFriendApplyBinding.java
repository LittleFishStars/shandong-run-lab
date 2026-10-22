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
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.FriendApplyBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemFriendApplyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f7968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FriendApplyBean f7970a;

    @NonNull
    public final ImageView b;

    public ChannelItemFriendApplyBinding(Object obj, View view, int i, AvatarView avatarView, ImageView imageView, ImageView imageView2, TextView textView, ExpandableTextView expandableTextView) {
        super(obj, view, i);
        this.f7969a = avatarView;
        this.f33243a = imageView;
        this.b = imageView2;
        this.f7967a = textView;
        this.f7968a = expandableTextView;
    }

    public static ChannelItemFriendApplyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemFriendApplyBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemFriendApplyBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_friend_apply);
    }

    @NonNull
    public static ChannelItemFriendApplyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemFriendApplyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemFriendApplyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemFriendApplyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_friend_apply, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemFriendApplyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemFriendApplyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_friend_apply, null, false, obj);
    }

    @Nullable
    public FriendApplyBean f() {
        return this.f7970a;
    }

    public abstract void k(@Nullable FriendApplyBean friendApplyBean);
}
