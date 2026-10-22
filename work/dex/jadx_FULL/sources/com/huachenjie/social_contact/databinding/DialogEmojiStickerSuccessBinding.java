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
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerSuccessDialog;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerSuccessVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogEmojiStickerSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerSuccessDialog.a f12866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerSuccessVM f12867a;

    @NonNull
    public final ImageView b;

    public DialogEmojiStickerSuccessBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.f36139a = imageView;
        this.b = imageView2;
    }

    public static DialogEmojiStickerSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEmojiStickerSuccessBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogEmojiStickerSuccessBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_emoji_sticker_success);
    }

    @NonNull
    public static DialogEmojiStickerSuccessBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogEmojiStickerSuccessBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogEmojiStickerSuccessBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogEmojiStickerSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_emoji_sticker_success, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogEmojiStickerSuccessBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogEmojiStickerSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_emoji_sticker_success, null, false, obj);
    }

    @Nullable
    public EmojiStickerSuccessDialog.a f() {
        return this.f12866a;
    }

    @Nullable
    public EmojiStickerSuccessVM g() {
        return this.f12867a;
    }

    public abstract void l(@Nullable EmojiStickerSuccessDialog.a aVar);

    public abstract void m(@Nullable EmojiStickerSuccessVM emojiStickerSuccessVM);
}
