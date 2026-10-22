package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeLayoutEmptyDataBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9563a;

    public HomeLayoutEmptyDataBinding(Object obj, View view, int i, BLTextView bLTextView, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f9563a = bLTextView;
        this.f9562a = constraintLayout;
        this.f34299a = imageView;
        this.f9561a = textView;
    }

    public static HomeLayoutEmptyDataBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeLayoutEmptyDataBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeLayoutEmptyDataBinding) ViewDataBinding.bind(obj, view, R.layout.home_layout_empty_data);
    }

    @NonNull
    public static HomeLayoutEmptyDataBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeLayoutEmptyDataBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeLayoutEmptyDataBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeLayoutEmptyDataBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_layout_empty_data, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeLayoutEmptyDataBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeLayoutEmptyDataBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_layout_empty_data, null, false, obj);
    }
}
