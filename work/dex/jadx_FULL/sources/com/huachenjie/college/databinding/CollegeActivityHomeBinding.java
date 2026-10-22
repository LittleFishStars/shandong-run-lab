package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.college.R;
import com.huachenjie.college.page.sport.CollegeActivity;
import com.huachenjie.college.page.sport.CollegeVM;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeActivityHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f8324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RequestOptions f8325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CollegeActivity.a f8326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CollegeVM f8327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8328a;

    @Bindable
    public RequestOptions b;

    public CollegeActivityHomeBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, BLView bLView) {
        super(obj, view, i);
        this.f33550a = frameLayout;
        this.f8322a = imageView;
        this.f8323a = linearLayout;
        this.f8324a = recyclerView;
        this.f8328a = bLView;
    }

    public static CollegeActivityHomeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeActivityHomeBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeActivityHomeBinding) ViewDataBinding.bind(obj, view, R.layout.college_activity_home);
    }

    @NonNull
    public static CollegeActivityHomeBinding k(@NonNull LayoutInflater layoutInflater) {
        return n(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeActivityHomeBinding l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeActivityHomeBinding m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_home, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeActivityHomeBinding n(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeActivityHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_home, null, false, obj);
    }

    @Nullable
    public RequestOptions f() {
        return this.b;
    }

    @Nullable
    public RequestOptions g() {
        return this.f8325a;
    }

    @Nullable
    public CollegeActivity.a h() {
        return this.f8326a;
    }

    @Nullable
    public CollegeVM j() {
        return this.f8327a;
    }

    public abstract void o(@Nullable RequestOptions requestOptions);

    public abstract void p(@Nullable RequestOptions requestOptions);

    public abstract void q(@Nullable CollegeActivity.a aVar);

    public abstract void r(@Nullable CollegeVM collegeVM);
}
