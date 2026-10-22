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
import com.huachenjie.channel.bean.notify.NotifyFavoritesBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemNotifyFavoritesBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f8115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyFavoritesBean f8116a;

    public ChannelItemNotifyFavoritesBinding(Object obj, View view, int i, AvatarView avatarView, TextView textView) {
        super(obj, view, i);
        this.f8115a = avatarView;
        this.f33296a = textView;
    }

    public static ChannelItemNotifyFavoritesBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemNotifyFavoritesBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemNotifyFavoritesBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_notify_favorites);
    }

    @NonNull
    public static ChannelItemNotifyFavoritesBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemNotifyFavoritesBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyFavoritesBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemNotifyFavoritesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify_favorites, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyFavoritesBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemNotifyFavoritesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify_favorites, null, false, obj);
    }

    @Nullable
    public NotifyFavoritesBean f() {
        return this.f8116a;
    }

    public abstract void k(@Nullable NotifyFavoritesBean notifyFavoritesBean);
}
