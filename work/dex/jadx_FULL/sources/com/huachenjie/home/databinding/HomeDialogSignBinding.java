package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.sign.SignDialog;
import com.huachenjie.home.dialog.sign.SignVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeDialogSignBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StrokeTextView f9381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignDialog.a f9382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignVM f9383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9384a;

    public HomeDialogSignBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, StrokeTextView strokeTextView, BLTextView bLTextView, TextView textView) {
        super(obj, view, i);
        this.f34237a = imageView;
        this.f9380a = recyclerView;
        this.f9381a = strokeTextView;
        this.f9384a = bLTextView;
        this.f9379a = textView;
    }

    public static HomeDialogSignBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeDialogSignBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeDialogSignBinding) ViewDataBinding.bind(obj, view, R.layout.home_dialog_sign);
    }

    @NonNull
    public static HomeDialogSignBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeDialogSignBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeDialogSignBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeDialogSignBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_sign, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeDialogSignBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeDialogSignBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_sign, null, false, obj);
    }

    @Nullable
    public SignDialog.a f() {
        return this.f9382a;
    }

    @Nullable
    public SignVM g() {
        return this.f9383a;
    }

    public abstract void l(@Nullable SignDialog.a aVar);

    public abstract void m(@Nullable SignVM signVM);
}
