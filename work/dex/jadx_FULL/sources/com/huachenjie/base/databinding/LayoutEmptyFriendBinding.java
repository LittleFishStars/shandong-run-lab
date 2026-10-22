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
public abstract class LayoutEmptyFriendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7127a;

    public LayoutEmptyFriendBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView emptyView, TextView tvEmpty) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32867a = emptyView;
        this.f7127a = tvEmpty;
    }

    public static LayoutEmptyFriendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyFriendBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutEmptyFriendBinding) ViewDataBinding.bind(component, view, R.layout.layout_empty_friend);
    }

    @NonNull
    public static LayoutEmptyFriendBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmptyFriendBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyFriendBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutEmptyFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_friend, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyFriendBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutEmptyFriendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_friend, null, false, component);
    }
}
