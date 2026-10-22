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
public abstract class LayoutEmptyChannelListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7107a;

    public LayoutEmptyChannelListBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView emptyView, TextView tvEmpty) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32857a = emptyView;
        this.f7107a = tvEmpty;
    }

    public static LayoutEmptyChannelListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyChannelListBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutEmptyChannelListBinding) ViewDataBinding.bind(component, view, R.layout.layout_empty_channel_list);
    }

    @NonNull
    public static LayoutEmptyChannelListBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmptyChannelListBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyChannelListBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutEmptyChannelListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_channel_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyChannelListBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutEmptyChannelListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_channel_list, null, false, component);
    }
}
