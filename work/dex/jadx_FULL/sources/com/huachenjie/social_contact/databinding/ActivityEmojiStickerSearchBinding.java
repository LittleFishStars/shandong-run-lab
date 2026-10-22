package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityEmojiStickerSearchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f36083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchEmojiStickerActivity.a f12721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchEmojiStickerVM f12722a;

    @NonNull
    public final ImageView b;

    public ActivityEmojiStickerSearchBinding(Object obj, View view, int i, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, EditText editText, TextView textView) {
        super(obj, view, i);
        this.f12720a = recyclerView;
        this.f12718a = imageView;
        this.b = imageView2;
        this.f36083a = editText;
        this.f12719a = textView;
    }

    public static ActivityEmojiStickerSearchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEmojiStickerSearchBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityEmojiStickerSearchBinding) ViewDataBinding.bind(obj, view, R.layout.activity_emoji_sticker_search);
    }

    @NonNull
    public static ActivityEmojiStickerSearchBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityEmojiStickerSearchBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerSearchBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityEmojiStickerSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_search, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityEmojiStickerSearchBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityEmojiStickerSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_emoji_sticker_search, null, false, obj);
    }

    @Nullable
    public SearchEmojiStickerActivity.a f() {
        return this.f12721a;
    }

    @Nullable
    public SearchEmojiStickerVM g() {
        return this.f12722a;
    }

    public abstract void l(@Nullable SearchEmojiStickerActivity.a aVar);

    public abstract void m(@Nullable SearchEmojiStickerVM searchEmojiStickerVM);
}
