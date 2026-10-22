package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerAddBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemEmojiStickerAddBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerAddBean f12941a;

    public ItemEmojiStickerAddBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f36173a = imageView;
    }

    public static ItemEmojiStickerAddBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmojiStickerAddBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemEmojiStickerAddBinding) ViewDataBinding.bind(obj, view, R.layout.item_emoji_sticker_add);
    }

    @NonNull
    public static ItemEmojiStickerAddBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemEmojiStickerAddBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerAddBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemEmojiStickerAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_add, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerAddBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemEmojiStickerAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_add, null, false, obj);
    }

    @Nullable
    public EmojiStickerAddBean f() {
        return this.f12941a;
    }

    public abstract void k(@Nullable EmojiStickerAddBean emojiStickerAddBean);
}
