package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.college.R;
import com.huachenjie.college.page.home.CollegeTownItemVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeFragmentCollegiateTownItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CollegeTownItemVM f8389a;

    public CollegeFragmentCollegiateTownItemBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f33568a = recyclerView;
    }

    public static CollegeFragmentCollegiateTownItemBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeFragmentCollegiateTownItemBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeFragmentCollegiateTownItemBinding) ViewDataBinding.bind(obj, view, R.layout.college_fragment_collegiate_town_item);
    }

    @NonNull
    public static CollegeFragmentCollegiateTownItemBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeFragmentCollegiateTownItemBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeFragmentCollegiateTownItemBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeFragmentCollegiateTownItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_fragment_collegiate_town_item, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeFragmentCollegiateTownItemBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeFragmentCollegiateTownItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_fragment_collegiate_town_item, null, false, obj);
    }

    @Nullable
    public CollegeTownItemVM f() {
        return this.f8389a;
    }

    public abstract void k(@Nullable CollegeTownItemVM collegeTownItemVM);
}
