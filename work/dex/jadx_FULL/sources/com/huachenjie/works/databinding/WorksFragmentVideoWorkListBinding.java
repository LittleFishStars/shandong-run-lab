package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.widget.TouchGestureView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.video.VideoWorkListVM;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentVideoWorkListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f36966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TouchGestureView f14351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VideoWorkListVM f14352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SmartRefreshLayout f14353a;

    public WorksFragmentVideoWorkListBinding(Object _bindingComponent, View _root, int _localFieldCount, TouchGestureView gestureView, SmartRefreshLayout refreshLayout, ViewPager2 videoViewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14351a = gestureView;
        this.f14353a = refreshLayout;
        this.f36966a = videoViewPager;
    }

    public static WorksFragmentVideoWorkListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentVideoWorkListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentVideoWorkListBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_video_work_list);
    }

    @NonNull
    public static WorksFragmentVideoWorkListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentVideoWorkListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentVideoWorkListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentVideoWorkListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_video_work_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentVideoWorkListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentVideoWorkListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_video_work_list, null, false, component);
    }

    @Nullable
    public VideoWorkListVM f() {
        return this.f14352a;
    }

    public abstract void k(@Nullable VideoWorkListVM vm);
}
