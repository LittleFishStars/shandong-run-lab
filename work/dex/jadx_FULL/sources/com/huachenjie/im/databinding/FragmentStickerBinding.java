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
import com.huachenjie.im.page.emoji.StickerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentStickerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public StickerVM f34443a;

    public FragmentStickerBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static FragmentStickerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentStickerBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentStickerBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_sticker);
    }

    @NonNull
    public static FragmentStickerBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentStickerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentStickerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sticker, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentStickerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentStickerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sticker, null, false, obj);
    }

    @Nullable
    public StickerVM f() {
        return this.f34443a;
    }

    public abstract void k(@Nullable StickerVM stickerVM);
}
