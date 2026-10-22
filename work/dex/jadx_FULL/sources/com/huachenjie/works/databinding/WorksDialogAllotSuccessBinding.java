package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogAllotSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseViewModel f13971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13972a;

    @NonNull
    public final BLTextView b;

    public WorksDialogAllotSuccessBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivDormitoryImage, LinearLayout llContainer, BLTextView tvDormitoryBt, TextView tvDormitoryName, BLTextView tvDormitoryUser) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36817a = ivDormitoryImage;
        this.f13969a = llContainer;
        this.f13972a = tvDormitoryBt;
        this.f13970a = tvDormitoryName;
        this.b = tvDormitoryUser;
    }

    public static WorksDialogAllotSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogAllotSuccessBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogAllotSuccessBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_allot_success);
    }

    @NonNull
    public static WorksDialogAllotSuccessBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogAllotSuccessBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogAllotSuccessBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogAllotSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_allot_success, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogAllotSuccessBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogAllotSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_allot_success, null, false, component);
    }

    @Nullable
    public BaseViewModel f() {
        return this.f13971a;
    }

    public abstract void k(@Nullable BaseViewModel vm);
}
