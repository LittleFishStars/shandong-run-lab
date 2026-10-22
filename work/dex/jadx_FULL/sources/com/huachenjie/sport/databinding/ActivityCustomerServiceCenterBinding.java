package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.helpercenter.CustomerServiceCenterActivity;
import com.huachenjie.sport.page.mine.helpercenter.CustomerServiceCenterVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityCustomerServiceCenterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CustomerServiceCenterActivity.a f13193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CustomerServiceCenterVM f13194a;

    @NonNull
    public final ShadowConstraintLayout b;

    public ActivityCustomerServiceCenterBinding(Object obj, View view, int i, ShadowConstraintLayout shadowConstraintLayout, ShadowConstraintLayout shadowConstraintLayout2, FrameLayout frameLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f13192a = shadowConstraintLayout;
        this.b = shadowConstraintLayout2;
        this.f36386a = frameLayout;
        this.f13190a = imageView;
        this.f13191a = textView;
    }

    public static ActivityCustomerServiceCenterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCustomerServiceCenterBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityCustomerServiceCenterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_customer_service_center);
    }

    @NonNull
    public static ActivityCustomerServiceCenterBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityCustomerServiceCenterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityCustomerServiceCenterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCustomerServiceCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_customer_service_center, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityCustomerServiceCenterBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCustomerServiceCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_customer_service_center, null, false, obj);
    }

    @Nullable
    public CustomerServiceCenterActivity.a f() {
        return this.f13193a;
    }

    @Nullable
    public CustomerServiceCenterVM g() {
        return this.f13194a;
    }

    public abstract void l(@Nullable CustomerServiceCenterActivity.a aVar);

    public abstract void m(@Nullable CustomerServiceCenterVM customerServiceCenterVM);
}
