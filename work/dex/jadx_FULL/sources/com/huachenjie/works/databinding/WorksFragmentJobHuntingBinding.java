package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.job_hunting.JobHuntingVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentJobHuntingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebContentView f36914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public JobHuntingVM f14213a;

    public WorksFragmentJobHuntingBinding(Object _bindingComponent, View _root, int _localFieldCount, WebContentView webContentView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36914a = webContentView;
    }

    public static WorksFragmentJobHuntingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentJobHuntingBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentJobHuntingBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_job_hunting);
    }

    @NonNull
    public static WorksFragmentJobHuntingBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentJobHuntingBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentJobHuntingBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentJobHuntingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_job_hunting, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentJobHuntingBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentJobHuntingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_job_hunting, null, false, component);
    }

    @Nullable
    public JobHuntingVM f() {
        return this.f14213a;
    }

    public abstract void k(@Nullable JobHuntingVM vm);
}
