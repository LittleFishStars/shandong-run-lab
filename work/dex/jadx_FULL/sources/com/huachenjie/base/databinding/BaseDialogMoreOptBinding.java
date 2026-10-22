package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseDialogMoreOptBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f32807a;

    public BaseDialogMoreOptBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32807a = recyclerView;
    }

    public static BaseDialogMoreOptBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BaseDialogMoreOptBinding d(@NonNull View view, @Nullable Object component) {
        return (BaseDialogMoreOptBinding) ViewDataBinding.bind(component, view, R.layout.base_dialog_more_opt);
    }

    @NonNull
    public static BaseDialogMoreOptBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static BaseDialogMoreOptBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static BaseDialogMoreOptBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (BaseDialogMoreOptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.base_dialog_more_opt, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static BaseDialogMoreOptBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (BaseDialogMoreOptBinding) ViewDataBinding.inflateInternal(inflater, R.layout.base_dialog_more_opt, null, false, component);
    }
}
