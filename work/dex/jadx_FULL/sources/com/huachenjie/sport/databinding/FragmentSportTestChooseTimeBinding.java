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
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentSportTestChooseTimeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestChooseTimeVM f13510a;

    @NonNull
    public final RecyclerView b;

    public FragmentSportTestChooseTimeBinding(Object obj, View view, int i, RecyclerView recyclerView, RecyclerView recyclerView2, View view2) {
        super(obj, view, i);
        this.f13509a = recyclerView;
        this.b = recyclerView2;
        this.f36484a = view2;
    }

    public static FragmentSportTestChooseTimeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSportTestChooseTimeBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentSportTestChooseTimeBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_sport_test_choose_time);
    }

    @NonNull
    public static FragmentSportTestChooseTimeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentSportTestChooseTimeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSportTestChooseTimeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSportTestChooseTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sport_test_choose_time, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentSportTestChooseTimeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSportTestChooseTimeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_sport_test_choose_time, null, false, obj);
    }

    @Nullable
    public SportTestChooseTimeVM f() {
        return this.f13510a;
    }

    public abstract void k(@Nullable SportTestChooseTimeVM sportTestChooseTimeVM);
}
