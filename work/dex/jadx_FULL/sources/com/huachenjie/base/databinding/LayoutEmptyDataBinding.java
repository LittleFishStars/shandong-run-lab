package com.huachenjie.base.databinding;

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
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class LayoutEmptyDataBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f32865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f7124a;

    public LayoutEmptyDataBinding(Object _bindingComponent, View _root, int _localFieldCount, LottieAnimationView jsEmptyView, ConstraintLayout stateLayout, TextView tvEmpty) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f7124a = jsEmptyView;
        this.f7123a = stateLayout;
        this.f32865a = tvEmpty;
    }

    public static LayoutEmptyDataBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyDataBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutEmptyDataBinding) ViewDataBinding.bind(component, view, R.layout.layout_empty_data);
    }

    @NonNull
    public static LayoutEmptyDataBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmptyDataBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyDataBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutEmptyDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_data, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyDataBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutEmptyDataBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_data, null, false, component);
    }
}
