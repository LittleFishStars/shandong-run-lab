package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.HomeRewardDialog;
import com.huachenjie.home.dialog.HomeRewardVM;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeDialogHomeRewardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeRewardDialog.ClickProxy f9357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeRewardVM f9358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f9360a;

    public HomeDialogHomeRewardBinding(Object obj, View view, int i, ImageView imageView, TextView textView, BLTextView bLTextView, View view2, BLView bLView) {
        super(obj, view, i);
        this.f9355a = imageView;
        this.f9356a = textView;
        this.f9359a = bLTextView;
        this.f34228a = view2;
        this.f9360a = bLView;
    }

    public static HomeDialogHomeRewardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeDialogHomeRewardBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeDialogHomeRewardBinding) ViewDataBinding.bind(obj, view, R.layout.home_dialog_home_reward);
    }

    @NonNull
    public static HomeDialogHomeRewardBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeDialogHomeRewardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeDialogHomeRewardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeDialogHomeRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_home_reward, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeDialogHomeRewardBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeDialogHomeRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_home_reward, null, false, obj);
    }

    @Nullable
    public HomeRewardDialog.ClickProxy f() {
        return this.f9357a;
    }

    @Nullable
    public HomeRewardVM g() {
        return this.f9358a;
    }

    public abstract void l(@Nullable HomeRewardDialog.ClickProxy clickProxy);

    public abstract void m(@Nullable HomeRewardVM homeRewardVM);
}
