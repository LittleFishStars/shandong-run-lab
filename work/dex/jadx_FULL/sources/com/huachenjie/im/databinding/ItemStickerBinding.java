package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.EmojiBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ItemStickerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public EmojiBean f34496a;

    public ItemStickerBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemStickerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemStickerBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemStickerBinding) ViewDataBinding.bind(obj, view, R.layout.item_sticker);
    }

    @NonNull
    public static ItemStickerBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemStickerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemStickerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sticker, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemStickerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sticker, null, false, obj);
    }

    @Nullable
    public EmojiBean f() {
        return this.f34496a;
    }

    public abstract void k(@Nullable EmojiBean emojiBean);
}
