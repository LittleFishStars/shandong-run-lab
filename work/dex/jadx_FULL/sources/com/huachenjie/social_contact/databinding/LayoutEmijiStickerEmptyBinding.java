package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.social_contact.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class LayoutEmijiStickerEmptyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f13036a;

    public LayoutEmijiStickerEmptyBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.f13036a = lottieAnimationView;
        this.f13035a = constraintLayout;
        this.f36200a = textView;
    }

    public static LayoutEmijiStickerEmptyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmijiStickerEmptyBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutEmijiStickerEmptyBinding) ViewDataBinding.bind(obj, view, R.layout.layout_emiji_sticker_empty);
    }

    @NonNull
    public static LayoutEmijiStickerEmptyBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmijiStickerEmptyBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmijiStickerEmptyBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutEmijiStickerEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_emiji_sticker_empty, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutEmijiStickerEmptyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutEmijiStickerEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_emiji_sticker_empty, null, false, obj);
    }
}
