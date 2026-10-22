package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.input_panel.audio.AudioPanelView;
import com.huachenjie.im.R;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.vm.InputPanelVM;
import com.vanniktech.emoji.EmojiEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class FragmentInputPanelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AudioPanelView f9716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InputPanelFragment.a f9717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InputPanelVM f9718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EmojiEditText f9719a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    public FragmentInputPanelBinding(Object obj, View view, int i, AudioPanelView audioPanelView, FrameLayout frameLayout, EmojiEditText emojiEditText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, View view2) {
        super(obj, view, i);
        this.f9716a = audioPanelView;
        this.f9712a = frameLayout;
        this.f9719a = emojiEditText;
        this.f9713a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.f9714a = linearLayout;
        this.f9715a = textView;
        this.f34427a = view2;
    }

    public static FragmentInputPanelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentInputPanelBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentInputPanelBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_input_panel);
    }

    @NonNull
    public static FragmentInputPanelBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentInputPanelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentInputPanelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentInputPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_input_panel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentInputPanelBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentInputPanelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_input_panel, null, false, obj);
    }

    @Nullable
    public InputPanelFragment.a f() {
        return this.f9717a;
    }

    @Nullable
    public InputPanelVM g() {
        return this.f9718a;
    }

    public abstract void l(@Nullable InputPanelFragment.a aVar);

    public abstract void m(@Nullable InputPanelVM inputPanelVM);
}
