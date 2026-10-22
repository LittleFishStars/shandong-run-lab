package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.RecommendItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeItemTownRecommendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RecommendItemBean f8415a;

    public CollegeItemTownRecommendBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f33579a = imageView;
    }

    public static CollegeItemTownRecommendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeItemTownRecommendBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeItemTownRecommendBinding) ViewDataBinding.bind(obj, view, R.layout.college_item_town_recommend);
    }

    @NonNull
    public static CollegeItemTownRecommendBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeItemTownRecommendBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeItemTownRecommendBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeItemTownRecommendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_town_recommend, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeItemTownRecommendBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeItemTownRecommendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_town_recommend, null, false, obj);
    }

    @Nullable
    public RecommendItemBean f() {
        return this.f8415a;
    }

    public abstract void k(@Nullable RecommendItemBean recommendItemBean);
}
