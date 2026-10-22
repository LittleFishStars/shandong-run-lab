package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.BottomIconView;
import com.huachenjie.common.widget.CheckImageView;
import com.huachenjie.common.widget.CheckTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class LayoutBottomIconViewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public BottomIconView.BottomIconBean f33764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckImageView f8646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckTextView f8647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8649a;

    @NonNull
    public final BLView b;

    public LayoutBottomIconViewBinding(Object _bindingComponent, View _root, int _localFieldCount, CheckImageView ivBottomIcon, BLView ivIconRedDot, BLView ivTextRedDot, CheckTextView tvBottomTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f8646a = ivBottomIcon;
        this.f8648a = ivIconRedDot;
        this.b = ivTextRedDot;
        this.f8647a = tvBottomTitle;
    }

    public static LayoutBottomIconViewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutBottomIconViewBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutBottomIconViewBinding) ViewDataBinding.bind(component, view, R.layout.layout_bottom_icon_view);
    }

    @NonNull
    public static LayoutBottomIconViewBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutBottomIconViewBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutBottomIconViewBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutBottomIconViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_bottom_icon_view, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutBottomIconViewBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutBottomIconViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_bottom_icon_view, null, false, component);
    }

    @Nullable
    public Boolean f() {
        return this.f8649a;
    }

    @Nullable
    public BottomIconView.BottomIconBean g() {
        return this.f33764a;
    }

    public abstract void l(@Nullable BottomIconView.BottomIconBean data);

    public abstract void setChecked(@Nullable Boolean checked);
}
