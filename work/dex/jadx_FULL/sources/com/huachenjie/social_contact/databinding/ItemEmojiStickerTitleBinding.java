package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerTitleBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemEmojiStickerTitleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerTitleBean f12967a;

    public ItemEmojiStickerTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36182a = textView;
    }

    public static ItemEmojiStickerTitleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmojiStickerTitleBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemEmojiStickerTitleBinding) ViewDataBinding.bind(obj, view, R.layout.item_emoji_sticker_title);
    }

    @NonNull
    public static ItemEmojiStickerTitleBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemEmojiStickerTitleBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerTitleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemEmojiStickerTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_title, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerTitleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemEmojiStickerTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_title, null, false, obj);
    }

    @Nullable
    public EmojiStickerTitleBean f() {
        return this.f12967a;
    }

    public abstract void k(@Nullable EmojiStickerTitleBean emojiStickerTitleBean);
}
