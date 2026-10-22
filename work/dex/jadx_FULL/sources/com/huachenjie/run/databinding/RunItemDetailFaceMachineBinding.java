package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailFaceClockBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemDetailFaceMachineBinding extends ViewDataBinding {

    @Bindable
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RunDetailFaceClockBean f35612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11926a;

    public RunItemDetailFaceMachineBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView tvWarnReason) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11926a = tvWarnReason;
    }

    public static RunItemDetailFaceMachineBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemDetailFaceMachineBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemDetailFaceMachineBinding) ViewDataBinding.bind(component, view, R.layout.run_item_detail_face_machine);
    }

    @NonNull
    public static RunItemDetailFaceMachineBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemDetailFaceMachineBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemDetailFaceMachineBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemDetailFaceMachineBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_detail_face_machine, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemDetailFaceMachineBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemDetailFaceMachineBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_detail_face_machine, null, false, component);
    }

    @Nullable
    public RunDetailFaceClockBean f() {
        return this.f35612a;
    }

    public int g() {
        return this.K;
    }

    public abstract void l(@Nullable RunDetailFaceClockBean bean);

    public abstract void m(int index);
}
