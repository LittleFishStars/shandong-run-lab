package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.task.TaskListFragmentVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeFragmentTaskListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public TaskListFragmentVM f34262a;

    public HomeFragmentTaskListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static HomeFragmentTaskListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeFragmentTaskListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeFragmentTaskListBinding) ViewDataBinding.bind(obj, view, R.layout.home_fragment_task_list);
    }

    @NonNull
    public static HomeFragmentTaskListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeFragmentTaskListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeFragmentTaskListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeFragmentTaskListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_task_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeFragmentTaskListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeFragmentTaskListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_task_list, null, false, obj);
    }

    @Nullable
    public TaskListFragmentVM f() {
        return this.f34262a;
    }

    public abstract void k(@Nullable TaskListFragmentVM taskListFragmentVM);
}
