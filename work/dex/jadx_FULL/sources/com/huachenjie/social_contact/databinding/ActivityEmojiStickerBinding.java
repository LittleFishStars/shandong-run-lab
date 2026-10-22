package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityEmojiStickerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f36071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerActivity.a f12687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiStickerVM f12688a;

    public ActivityEmojiStickerBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f12686a = recyclerView;
        this.f36071a = linearLayout;
    }

    public static ActivityEmojiStickerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEmojiStickerBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityEmojiStickerBinding) ViewDataBinding.bind(obj, view, R.layout.activity_emoji_sticker);
    }

    @NonNull
    public static ActivityEmojiStickerBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityEmojiStickerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityEmojiStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityEmojiStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker, null, false, obj);
    }

    @Nullable
    public EmojiStickerActivity.a f() {
        return this.f12687a;
    }

    @Nullable
    public EmojiStickerVM g() {
        return this.f12688a;
    }

    public abstract void l(@Nullable EmojiStickerActivity.a aVar);

    public abstract void m(@Nullable EmojiStickerVM emojiStickerVM);
}
