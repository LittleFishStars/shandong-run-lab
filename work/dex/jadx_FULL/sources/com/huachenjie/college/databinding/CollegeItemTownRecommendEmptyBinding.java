package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.RecommendItemBean;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeItemTownRecommendEmptyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RecommendItemBean f33581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f8420a;

    public CollegeItemTownRecommendEmptyBinding(Object obj, View view, int i, BLImageView bLImageView) {
        super(obj, view, i);
        this.f8420a = bLImageView;
    }

    public static CollegeItemTownRecommendEmptyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeItemTownRecommendEmptyBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeItemTownRecommendEmptyBinding) ViewDataBinding.bind(obj, view, R.layout.college_item_town_recommend_empty);
    }

    @NonNull
    public static CollegeItemTownRecommendEmptyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeItemTownRecommendEmptyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeItemTownRecommendEmptyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeItemTownRecommendEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_town_recommend_empty, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeItemTownRecommendEmptyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeItemTownRecommendEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_town_recommend_empty, null, false, obj);
    }

    @Nullable
    public RecommendItemBean f() {
        return this.f33581a;
    }

    public abstract void k(@Nullable RecommendItemBean recommendItemBean);
}
