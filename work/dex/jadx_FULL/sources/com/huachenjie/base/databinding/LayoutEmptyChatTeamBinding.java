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
public abstract class LayoutEmptyChatTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7111a;

    public LayoutEmptyChatTeamBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView emptyView, TextView tvEmpty) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f32859a = emptyView;
        this.f7111a = tvEmpty;
    }

    public static LayoutEmptyChatTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutEmptyChatTeamBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutEmptyChatTeamBinding) ViewDataBinding.bind(component, view, R.layout.layout_empty_chat_team);
    }

    @NonNull
    public static LayoutEmptyChatTeamBinding e(@NonNull LayoutInflater inflater) {
        return h(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutEmptyChatTeamBinding f(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return g(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyChatTeamBinding g(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutEmptyChatTeamBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_chat_team, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutEmptyChatTeamBinding h(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutEmptyChatTeamBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_empty_chat_team, null, false, component);
    }
}
