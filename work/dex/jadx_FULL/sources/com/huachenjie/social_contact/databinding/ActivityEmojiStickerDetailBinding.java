package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailActivity;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityEmojiStickerDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AvatarView f36077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerDetailActivity.a f12701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerDetailVM f12702a;

    public ActivityEmojiStickerDetailBinding(Object obj, View view, int i, AvatarView avatarView) {
        super(obj, view, i);
        this.f36077a = avatarView;
    }

    public static ActivityEmojiStickerDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEmojiStickerDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityEmojiStickerDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_emoji_sticker_detail);
    }

    @NonNull
    public static ActivityEmojiStickerDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityEmojiStickerDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityEmojiStickerDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityEmojiStickerDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_detail, null, false, obj);
    }

    @Nullable
    public EmojiStickerDetailActivity.a f() {
        return this.f12701a;
    }

    @Nullable
    public EmojiStickerDetailVM g() {
        return this.f12702a;
    }

    public abstract void l(@Nullable EmojiStickerDetailActivity.a aVar);

    public abstract void m(@Nullable EmojiStickerDetailVM emojiStickerDetailVM);
}
