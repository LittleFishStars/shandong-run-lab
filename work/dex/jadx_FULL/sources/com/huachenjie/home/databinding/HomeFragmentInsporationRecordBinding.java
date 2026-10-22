package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.inspiration_record.InspirationRecordFVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeFragmentInsporationRecordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final StateLayout f34249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationRecordFVM f9405a;

    public HomeFragmentInsporationRecordBinding(Object obj, View view, int i, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34249a = stateLayout;
    }

    public static HomeFragmentInsporationRecordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeFragmentInsporationRecordBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeFragmentInsporationRecordBinding) ViewDataBinding.bind(obj, view, R.layout.home_fragment_insporation_record);
    }

    @NonNull
    public static HomeFragmentInsporationRecordBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeFragmentInsporationRecordBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeFragmentInsporationRecordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeFragmentInsporationRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_insporation_record, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeFragmentInsporationRecordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeFragmentInsporationRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_insporation_record, null, false, obj);
    }

    @Nullable
    public InspirationRecordFVM f() {
        return this.f9405a;
    }

    public abstract void k(@Nullable InspirationRecordFVM inspirationRecordFVM);
}
