package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.HuaweiHealthSportRecordBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeItemHwHealthBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuaweiHealthSportRecordBean f8401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8402a;

    @NonNull
    public final TextView b;

    public CollegeItemHwHealthBinding(Object obj, View view, int i, ImageView imageView, BLTextView bLTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f33574a = imageView;
        this.f8402a = bLTextView;
        this.f8400a = textView;
        this.b = textView2;
    }

    public static CollegeItemHwHealthBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeItemHwHealthBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeItemHwHealthBinding) ViewDataBinding.bind(obj, view, R.layout.college_item_hw_health);
    }

    @NonNull
    public static CollegeItemHwHealthBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeItemHwHealthBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeItemHwHealthBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeItemHwHealthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_hw_health, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeItemHwHealthBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeItemHwHealthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_item_hw_health, null, false, obj);
    }

    @Nullable
    public HuaweiHealthSportRecordBean f() {
        return this.f8401a;
    }

    public abstract void k(@Nullable HuaweiHealthSportRecordBean huaweiHealthSportRecordBean);
}
