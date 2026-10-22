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
public abstract class LayoutEmptyWorkBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7131a;

    public LayoutEmptyWorkBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView emptyView, TextView tvEmpty) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32869a = emptyView;
        this.f7131a = tvEmpty;
    }

    public static LayoutEmptyWorkBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyWorkBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutEmptyWorkBinding) ViewDataBinding.bind(component, view, R.layout.layout_empty_work);
    }

    @NonNull
    public static LayoutEmptyWorkBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmptyWorkBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyWorkBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutEmptyWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_work, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyWorkBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutEmptyWorkBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_work, null, false, component);
    }
}
