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
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemAddSubAdminBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMemberBean f7902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7903a;

    @NonNull
    public final TextView b;

    public ChannelItemAddSubAdminBinding(Object obj, View view, int i, AvatarView avatarView, BLTextView bLTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7901a = avatarView;
        this.f7903a = bLTextView;
        this.f33218a = textView;
        this.b = textView2;
    }

    public static ChannelItemAddSubAdminBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemAddSubAdminBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemAddSubAdminBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_add_sub_admin);
    }

    @NonNull
    public static ChannelItemAddSubAdminBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemAddSubAdminBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemAddSubAdminBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemAddSubAdminBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_add_sub_admin, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemAddSubAdminBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemAddSubAdminBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_add_sub_admin, null, false, obj);
    }

    @Nullable
    public ChannelMemberBean f() {
        return this.f7902a;
    }

    public abstract void k(@Nullable ChannelMemberBean channelMemberBean);
}
