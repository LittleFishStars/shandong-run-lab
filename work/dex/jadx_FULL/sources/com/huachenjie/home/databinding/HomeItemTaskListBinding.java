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
import com.huachenjie.home.bean.DailyTasksBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemTaskListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DailyTasksBean f9545a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9546b;

    public HomeItemTaskListBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34294a = imageView;
        this.b = imageView2;
        this.f9544a = textView;
        this.f9546b = textView2;
    }

    public static HomeItemTaskListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemTaskListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemTaskListBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_task_list);
    }

    @NonNull
    public static HomeItemTaskListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemTaskListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemTaskListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemTaskListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_task_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemTaskListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemTaskListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_task_list, null, false, obj);
    }

    @Nullable
    public DailyTasksBean f() {
        return this.f9545a;
    }

    public abstract void k(@Nullable DailyTasksBean dailyTasksBean);
}
