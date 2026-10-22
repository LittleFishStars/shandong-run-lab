package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.input_panel.emoji.EmojiPanelView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentEmojiBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EmojiPanelView f34419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f9685a;

    public FragmentEmojiBinding(Object obj, View view, int i, EmojiPanelView emojiPanelView) {
        super(obj, view, i);
        this.f34419a = emojiPanelView;
    }

    public static FragmentEmojiBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEmojiBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentEmojiBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_emoji);
    }

    @NonNull
    public static FragmentEmojiBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentEmojiBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentEmojiBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentEmojiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_emoji, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentEmojiBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentEmojiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_emoji, null, false, obj);
    }

    @Nullable
    public BaseVM f() {
        return this.f9685a;
    }

    public abstract void k(@Nullable BaseVM baseVM);
}
