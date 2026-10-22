package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportDialog;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerReportVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogEmojiStickerReportBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RadioButton f36134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerReportDialog.a f12856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerReportVM f12857a;

    @NonNull
    public final RadioButton b;

    @NonNull
    public final RadioButton c;

    public DialogEmojiStickerReportBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3) {
        super(obj, view, i);
        this.f36134a = radioButton;
        this.b = radioButton2;
        this.c = radioButton3;
    }

    public static DialogEmojiStickerReportBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogEmojiStickerReportBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogEmojiStickerReportBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_emoji_sticker_report);
    }

    @NonNull
    public static DialogEmojiStickerReportBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogEmojiStickerReportBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogEmojiStickerReportBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogEmojiStickerReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_emoji_sticker_report, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogEmojiStickerReportBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogEmojiStickerReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_emoji_sticker_report, null, false, obj);
    }

    @Nullable
    public EmojiStickerReportDialog.a f() {
        return this.f12856a;
    }

    @Nullable
    public EmojiStickerReportVM g() {
        return this.f12857a;
    }

    public abstract void l(@Nullable EmojiStickerReportDialog.a aVar);

    public abstract void m(@Nullable EmojiStickerReportVM emojiStickerReportVM);
}
