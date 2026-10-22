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
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemEmojiStickerCreateBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerImageBean f12958a;

    @NonNull
    public final ImageView b;

    public ItemEmojiStickerCreateBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.f36177a = imageView;
        this.b = imageView2;
    }

    public static ItemEmojiStickerCreateBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmojiStickerCreateBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemEmojiStickerCreateBinding) ViewDataBinding.bind(obj, view, R.layout.item_emoji_sticker_create);
    }

    @NonNull
    public static ItemEmojiStickerCreateBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemEmojiStickerCreateBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerCreateBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemEmojiStickerCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_create, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerCreateBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemEmojiStickerCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker_create, null, false, obj);
    }

    @Nullable
    public EmojiStickerImageBean f() {
        return this.f12958a;
    }

    public abstract void k(@Nullable EmojiStickerImageBean emojiStickerImageBean);
}
