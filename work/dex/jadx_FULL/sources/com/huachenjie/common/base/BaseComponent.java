package com.huachenjie.common.base;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseComponent<T> implements ILifecycleCallback {
    public static final int K = -1;
    public static final int L = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f33636a;

    public BaseComponent(T context) {
        this.f33636a = context;
        findViews();
        initListeners();
        bindData();
    }

    public <V extends View> V a(int i) {
        T t = this.f33636a;
        if (t instanceof Activity) {
            return (V) ((Activity) t).findViewById(i);
        }
        if (t instanceof Fragment) {
            return (V) ((Fragment) t).getView().findViewById(i);
        }
        if (t instanceof androidx.fragment.app.Fragment) {
            return (V) ((androidx.fragment.app.Fragment) t).getView().findViewById(i);
        }
        if (t instanceof View) {
            return (V) ((View) t).findViewById(i);
        }
        if (t instanceof Dialog) {
            return (V) ((Dialog) t).getWindow().getDecorView().findViewById(i);
        }
        throw new RuntimeException("Context can just be activities_run(In Activity) / view(In fragment) / Dialog(In Dialog)!");
    }

    public Context b() {
        T t = this.f33636a;
        if (t instanceof Activity) {
            return (Activity) t;
        }
        if (t instanceof Fragment) {
            return ((Fragment) t).getActivity();
        }
        if (t instanceof androidx.fragment.app.Fragment) {
            return ((androidx.fragment.app.Fragment) t).getActivity();
        }
        if (t instanceof View) {
            return ((View) t).getContext();
        }
        if (t instanceof Dialog) {
            return ((Dialog) t).getContext();
        }
        throw new RuntimeException("Context can just be activities_run(In Activity) / view(In fragment) / Dialog(In Dialog)!");
    }

    public abstract void bindData();

    public void c(int requestCode, int resultCode, Intent data) {
    }

    public abstract void findViews();

    public Activity getActivity() {
        T t = this.f33636a;
        if (t instanceof Activity) {
            return (Activity) t;
        }
        if (t instanceof Fragment) {
            return ((Fragment) t).getActivity();
        }
        if (t instanceof androidx.fragment.app.Fragment) {
            return ((androidx.fragment.app.Fragment) t).getActivity();
        }
        if (t instanceof View) {
            return (Activity) ((View) t).getContext();
        }
        if (t instanceof Dialog) {
            return ((Dialog) t).getOwnerActivity();
        }
        throw new RuntimeException("Context can just be activities_run(In Activity) / view(In fragment) / Dialog(In Dialog)!");
    }

    public T getContext() {
        return this.f33636a;
    }

    public abstract void initListeners();

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onCreate() {
    }

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
    }

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onLifecycleChanged() {
    }

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onPause() {
    }

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onResume() {
    }

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onStart() {
    }

    @Override // com.huachenjie.common.base.ILifecycleCallback
    public void onStop() {
    }
}
