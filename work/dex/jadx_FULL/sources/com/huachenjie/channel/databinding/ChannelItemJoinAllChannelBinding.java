package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.JoinAllChannelBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemJoinAllChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f33252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f7995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public JoinAllChannelBean f7997a;

    @NonNull
    public final TextView b;

    public ChannelItemJoinAllChannelBinding(Object obj, View view, int i, AvatarView avatarView, RoundImageView roundImageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7996a = avatarView;
        this.f7995a = roundImageView;
        this.f33252a = linearLayout;
        this.f7994a = textView;
        this.b = textView2;
    }

    public static ChannelItemJoinAllChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemJoinAllChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemJoinAllChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_join_all_channel);
    }

    @NonNull
    public static ChannelItemJoinAllChannelBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemJoinAllChannelBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemJoinAllChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemJoinAllChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_join_all_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemJoinAllChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemJoinAllChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_join_all_channel, null, false, obj);
    }

    @Nullable
    public JoinAllChannelBean f() {
        return this.f7997a;
    }

    public abstract void k(@Nullable JoinAllChannelBean joinAllChannelBean);
}
