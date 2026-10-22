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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.college.R;
import com.huachenjie.college.page.sport.CollegeActivity;
import com.huachenjie.college.page.sport.CollegeVM;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeLayoutHomeHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RequestOptions f8426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CollegeActivity.a f8427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CollegeVM f8428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Banner f8429a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f8430b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public RequestOptions f8431b;

    @NonNull
    public final ImageView c;

    public CollegeLayoutHomeHeaderBinding(Object obj, View view, int i, Banner banner, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, View view2, View view3) {
        super(obj, view, i);
        this.f8429a = banner;
        this.f8424a = imageView;
        this.f8430b = imageView2;
        this.c = imageView3;
        this.f8425a = textView;
        this.f33583a = view2;
        this.b = view3;
    }

    public static CollegeLayoutHomeHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeLayoutHomeHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeLayoutHomeHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.college_layout_home_header);
    }

    @NonNull
    public static CollegeLayoutHomeHeaderBinding k(@NonNull LayoutInflater layoutInflater) {
        return n(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeLayoutHomeHeaderBinding l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeLayoutHomeHeaderBinding m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeLayoutHomeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_layout_home_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeLayoutHomeHeaderBinding n(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeLayoutHomeHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_layout_home_header, null, false, obj);
    }

    @Nullable
    public RequestOptions f() {
        return this.f8431b;
    }

    @Nullable
    public RequestOptions g() {
        return this.f8426a;
    }

    @Nullable
    public CollegeActivity.a h() {
        return this.f8427a;
    }

    @Nullable
    public CollegeVM j() {
        return this.f8428a;
    }

    public abstract void o(@Nullable RequestOptions requestOptions);

    public abstract void p(@Nullable RequestOptions requestOptions);

    public abstract void q(@Nullable CollegeActivity.a aVar);

    public abstract void r(@Nullable CollegeVM collegeVM);
}
