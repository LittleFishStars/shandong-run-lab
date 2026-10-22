package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.FlashMessageBuddyChatBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemFlashMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FlashMessageBuddyChatBean f7954a;

    public ChannelItemFlashMessageBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f33238a = imageView;
    }

    public static ChannelItemFlashMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemFlashMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemFlashMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_flash_message);
    }

    @NonNull
    public static ChannelItemFlashMessageBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemFlashMessageBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemFlashMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemFlashMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_flash_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemFlashMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemFlashMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_flash_message, null, false, obj);
    }

    @Nullable
    public FlashMessageBuddyChatBean f() {
        return this.f7954a;
    }

    public abstract void k(@Nullable FlashMessageBuddyChatBean flashMessageBuddyChatBean);
}
