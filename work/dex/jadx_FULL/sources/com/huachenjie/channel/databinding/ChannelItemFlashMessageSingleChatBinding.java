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
import com.huachenjie.im.bean.ContactUserBean;
import com.vanniktech.emoji.EmojiTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemFlashMessageSingleChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f7960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ContactUserBean f7961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiTextView f7962a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public ChannelItemFlashMessageSingleChatBinding(Object obj, View view, int i, AvatarView avatarView, TextView textView, TextView textView2, EmojiTextView emojiTextView, TextView textView3) {
        super(obj, view, i);
        this.f7960a = avatarView;
        this.f33241a = textView;
        this.b = textView2;
        this.f7962a = emojiTextView;
        this.c = textView3;
    }

    public static ChannelItemFlashMessageSingleChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemFlashMessageSingleChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemFlashMessageSingleChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_flash_message_single_chat);
    }

    @NonNull
    public static ChannelItemFlashMessageSingleChatBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemFlashMessageSingleChatBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemFlashMessageSingleChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemFlashMessageSingleChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_flash_message_single_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemFlashMessageSingleChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemFlashMessageSingleChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_flash_message_single_chat, null, false, obj);
    }

    @Nullable
    public ContactUserBean f() {
        return this.f7961a;
    }

    public abstract void k(@Nullable ContactUserBean contactUserBean);
}
