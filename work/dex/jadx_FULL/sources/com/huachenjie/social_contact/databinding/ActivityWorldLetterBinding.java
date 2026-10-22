package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.vm.WorldLetterVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityWorldLetterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36124a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f12836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorldLetterVM f12837a;

    public ActivityWorldLetterBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36124a = textView;
    }

    public static ActivityWorldLetterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityWorldLetterBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityWorldLetterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_world_letter);
    }

    @NonNull
    public static ActivityWorldLetterBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityWorldLetterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityWorldLetterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityWorldLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_world_letter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityWorldLetterBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityWorldLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_world_letter, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f12836a;
    }

    @Nullable
    public WorldLetterVM g() {
        return this.f12837a;
    }

    public abstract void l(@Nullable WorldLetterVM worldLetterVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
