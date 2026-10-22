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
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.NotifyMailBoxBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemNotifyMailboxBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyMailBoxBean f8125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8126a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8127b;

    public ChannelItemNotifyMailboxBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, BLTextView bLTextView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f8123a = imageView;
        this.b = imageView2;
        this.f8124a = textView;
        this.f8126a = bLTextView;
        this.f8127b = textView2;
        this.f33298a = view2;
    }

    public static ChannelItemNotifyMailboxBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemNotifyMailboxBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemNotifyMailboxBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_notify_mailbox);
    }

    @NonNull
    public static ChannelItemNotifyMailboxBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemNotifyMailboxBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyMailboxBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemNotifyMailboxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify_mailbox, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemNotifyMailboxBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemNotifyMailboxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_notify_mailbox, null, false, obj);
    }

    @Nullable
    public NotifyMailBoxBean f() {
        return this.f8125a;
    }

    public abstract void k(@Nullable NotifyMailBoxBean notifyMailBoxBean);
}
