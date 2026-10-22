package com.huachenjie.social_contact.databinding;

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
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemEmojiStickerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f12947a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerBean f12948a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f12949b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12950b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ImageView f12951c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f12952c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    public ItemEmojiStickerBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, AvatarView avatarView, TextView textView, TextView textView2, TextView textView3, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f12945a = imageView;
        this.f12949b = imageView2;
        this.f12951c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.h = imageView8;
        this.f12947a = avatarView;
        this.f12946a = textView;
        this.f12950b = textView2;
        this.f12952c = textView3;
        this.f36175a = view2;
        this.b = view3;
        this.c = view4;
    }

    public static ItemEmojiStickerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemEmojiStickerBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemEmojiStickerBinding) ViewDataBinding.bind(obj, view, R.layout.item_emoji_sticker);
    }

    @NonNull
    public static ItemEmojiStickerBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemEmojiStickerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemEmojiStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemEmojiStickerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemEmojiStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_emoji_sticker, null, false, obj);
    }

    @Nullable
    public EmojiStickerBean f() {
        return this.f12948a;
    }

    public abstract void k(@Nullable EmojiStickerBean emojiStickerBean);
}
