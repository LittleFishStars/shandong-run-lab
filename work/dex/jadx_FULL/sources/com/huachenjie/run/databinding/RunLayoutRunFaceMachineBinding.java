package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunFaceMachineBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12138a;

    public RunLayoutRunFaceMachineBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvFaceMachine) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35688a = rvFaceMachine;
    }

    public static RunLayoutRunFaceMachineBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunFaceMachineBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunFaceMachineBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_face_machine);
    }

    @NonNull
    public static RunLayoutRunFaceMachineBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunFaceMachineBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunFaceMachineBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunFaceMachineBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_face_machine, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunFaceMachineBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunFaceMachineBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_face_machine, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f12138a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
