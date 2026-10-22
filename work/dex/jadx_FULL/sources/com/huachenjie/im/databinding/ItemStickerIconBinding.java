package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.EmojiItemData;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ItemStickerIconBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EmojiItemData f9876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f9877a;

    public ItemStickerIconBinding(Object obj, View view, int i, BLView bLView, ImageView imageView) {
        super(obj, view, i);
        this.f9877a = bLView;
        this.f34498a = imageView;
    }

    public static ItemStickerIconBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemStickerIconBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemStickerIconBinding) ViewDataBinding.bind(obj, view, R.layout.item_sticker_icon);
    }

    @NonNull
    public static ItemStickerIconBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemStickerIconBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemStickerIconBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemStickerIconBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sticker_icon, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemStickerIconBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemStickerIconBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sticker_icon, null, false, obj);
    }

    @Nullable
    public EmojiItemData f() {
        return this.f9876a;
    }

    public abstract void k(@Nullable EmojiItemData emojiItemData);
}
