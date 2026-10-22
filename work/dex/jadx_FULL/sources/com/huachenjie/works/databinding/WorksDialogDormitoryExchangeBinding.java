package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.dormitory.dialog.DormitoryExchangeVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogDormitoryExchangeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DormitoryExchangeVM f14078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14079a;

    public WorksDialogDormitoryExchangeBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btnExchange, ImageView ivClose, RecyclerView rvExchangeCards) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14079a = btnExchange;
        this.f36864a = ivClose;
        this.f14077a = rvExchangeCards;
    }

    public static WorksDialogDormitoryExchangeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogDormitoryExchangeBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogDormitoryExchangeBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_dormitory_exchange);
    }

    @NonNull
    public static WorksDialogDormitoryExchangeBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogDormitoryExchangeBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogDormitoryExchangeBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogDormitoryExchangeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_dormitory_exchange, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogDormitoryExchangeBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogDormitoryExchangeBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_dormitory_exchange, null, false, component);
    }

    @Nullable
    public DormitoryExchangeVM f() {
        return this.f14078a;
    }

    public abstract void k(@Nullable DormitoryExchangeVM vm);
}
