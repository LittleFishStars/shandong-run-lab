package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallLayoutEmptyDataBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10966a;

    public MallLayoutEmptyDataBinding(Object obj, View view, int i, BLTextView bLTextView, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f10966a = bLTextView;
        this.f10965a = constraintLayout;
        this.f35053a = imageView;
        this.f10964a = textView;
    }

    public static MallLayoutEmptyDataBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallLayoutEmptyDataBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallLayoutEmptyDataBinding) ViewDataBinding.bind(obj, view, R.layout.mall_layout_empty_data);
    }

    @NonNull
    public static MallLayoutEmptyDataBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallLayoutEmptyDataBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallLayoutEmptyDataBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallLayoutEmptyDataBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_empty_data, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallLayoutEmptyDataBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallLayoutEmptyDataBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_empty_data, null, false, obj);
    }
}
