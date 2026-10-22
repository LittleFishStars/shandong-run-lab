package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemEmojiStickerDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public EmojiStickerImageBean f36179a;

    public ItemEmojiStickerDetailBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemEmojiStickerDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmojiStickerDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemEmojiStickerDetailBinding) ViewDataBinding.bind(obj, view, R.layout.item_emoji_sticker_detail);
    }

    @NonNull
    public static ItemEmojiStickerDetailBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemEmojiStickerDetailBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemEmojiStickerDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemEmojiStickerDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_detail, null, false, obj);
    }

    @Nullable
    public EmojiStickerImageBean f() {
        return this.f36179a;
    }

    public abstract void k(@Nullable EmojiStickerImageBean emojiStickerImageBean);
}
