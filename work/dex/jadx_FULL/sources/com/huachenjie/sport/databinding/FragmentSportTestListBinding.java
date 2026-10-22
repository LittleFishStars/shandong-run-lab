package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentSportTestListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f13514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestListVM f13515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f13516a;

    public FragmentSportTestListBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f36486a = recyclerView;
        this.f13514a = stateLayout;
    }

    public static FragmentSportTestListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSportTestListBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentSportTestListBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_sport_test_list);
    }

    @NonNull
    public static FragmentSportTestListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentSportTestListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSportTestListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSportTestListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sport_test_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentSportTestListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSportTestListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sport_test_list, null, false, obj);
    }

    @Nullable
    public SportTestListVM f() {
        return this.f13515a;
    }

    @Nullable
    public Integer getType() {
        return this.f13516a;
    }

    public abstract void k(@Nullable Integer num);

    public abstract void l(@Nullable SportTestListVM sportTestListVM);
}
