package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class LayoutEmptyCommonBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7115a;

    public LayoutEmptyCommonBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView emptyView, TextView tvEmpty) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32861a = emptyView;
        this.f7115a = tvEmpty;
    }

    public static LayoutEmptyCommonBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyCommonBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutEmptyCommonBinding) ViewDataBinding.bind(component, view, R.layout.layout_empty_common);
    }

    @NonNull
    public static LayoutEmptyCommonBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmptyCommonBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyCommonBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutEmptyCommonBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_common, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyCommonBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutEmptyCommonBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_common, null, false, component);
    }
}
