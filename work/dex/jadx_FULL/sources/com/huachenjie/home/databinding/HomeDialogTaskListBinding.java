package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.task.TaskListDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeDialogTaskListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseViewModel f9390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TaskListDialog.a f9391a;

    public HomeDialogTaskListBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f34241a = frameLayout;
    }

    public static HomeDialogTaskListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeDialogTaskListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeDialogTaskListBinding) ViewDataBinding.bind(obj, view, R.layout.home_dialog_task_list);
    }

    @NonNull
    public static HomeDialogTaskListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeDialogTaskListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeDialogTaskListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeDialogTaskListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_task_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeDialogTaskListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeDialogTaskListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_task_list, null, false, obj);
    }

    @Nullable
    public TaskListDialog.a f() {
        return this.f9391a;
    }

    @Nullable
    public BaseViewModel g() {
        return this.f9390a;
    }

    public abstract void l(@Nullable TaskListDialog.a aVar);

    public abstract void m(@Nullable BaseViewModel baseViewModel);
}
