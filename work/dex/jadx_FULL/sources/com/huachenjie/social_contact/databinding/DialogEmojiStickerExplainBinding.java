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
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerExplainDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogEmojiStickerExplainBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public EmojiStickerExplainDialog.a f36130a;

    public DialogEmojiStickerExplainBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static DialogEmojiStickerExplainBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEmojiStickerExplainBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogEmojiStickerExplainBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_emoji_sticker_explain);
    }

    @NonNull
    public static DialogEmojiStickerExplainBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogEmojiStickerExplainBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogEmojiStickerExplainBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogEmojiStickerExplainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_emoji_sticker_explain, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogEmojiStickerExplainBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogEmojiStickerExplainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_emoji_sticker_explain, null, false, obj);
    }

    @Nullable
    public EmojiStickerExplainDialog.a f() {
        return this.f36130a;
    }

    public abstract void k(@Nullable EmojiStickerExplainDialog.a aVar);
}
