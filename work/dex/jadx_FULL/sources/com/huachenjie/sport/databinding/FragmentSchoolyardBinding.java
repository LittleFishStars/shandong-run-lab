package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.SchoolyardFragment;
import com.huachenjie.sport.page.mine.huodong.SchoolyardVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentSchoolyardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final StateLayout f36481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f13500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolyardFragment.b f13501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolyardVM f13502a;

    public FragmentSchoolyardBinding(Object obj, View view, int i, CommonSearchView commonSearchView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f13500a = commonSearchView;
        this.f36481a = stateLayout;
    }

    public static FragmentSchoolyardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSchoolyardBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentSchoolyardBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_schoolyard);
    }

    @NonNull
    public static FragmentSchoolyardBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentSchoolyardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSchoolyardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSchoolyardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_schoolyard, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentSchoolyardBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSchoolyardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_schoolyard, null, false, obj);
    }

    @Nullable
    public SchoolyardFragment.b f() {
        return this.f13501a;
    }

    @Nullable
    public SchoolyardVM g() {
        return this.f13502a;
    }

    public abstract void l(@Nullable SchoolyardFragment.b bVar);

    public abstract void m(@Nullable SchoolyardVM schoolyardVM);
}
