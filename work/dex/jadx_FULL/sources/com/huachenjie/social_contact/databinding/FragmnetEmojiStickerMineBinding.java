package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerSubVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmnetEmojiStickerMineBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineEmojiStickerSubVM f12938a;

    public FragmnetEmojiStickerMineBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f36171a = recyclerView;
    }

    public static FragmnetEmojiStickerMineBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmnetEmojiStickerMineBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmnetEmojiStickerMineBinding) ViewDataBinding.bind(obj, view, R.layout.fragmnet_emoji_sticker_mine);
    }

    @NonNull
    public static FragmnetEmojiStickerMineBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmnetEmojiStickerMineBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmnetEmojiStickerMineBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmnetEmojiStickerMineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragmnet_emoji_sticker_mine, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmnetEmojiStickerMineBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmnetEmojiStickerMineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragmnet_emoji_sticker_mine, null, false, obj);
    }

    @Nullable
    public MineEmojiStickerSubVM f() {
        return this.f12938a;
    }

    public abstract void k(@Nullable MineEmojiStickerSubVM mineEmojiStickerSubVM);
}
