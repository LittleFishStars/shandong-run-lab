package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogBottomSportTestDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36445a;

    @NonNull
    public final TextView b;

    public DialogBottomSportTestDetailBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f36445a = textView;
        this.b = textView2;
    }

    public static DialogBottomSportTestDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBottomSportTestDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogBottomSportTestDetailBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_bottom_sport_test_detail);
    }

    @NonNull
    public static DialogBottomSportTestDetailBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogBottomSportTestDetailBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogBottomSportTestDetailBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogBottomSportTestDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bottom_sport_test_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogBottomSportTestDetailBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogBottomSportTestDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bottom_sport_test_detail, null, false, obj);
    }
}
