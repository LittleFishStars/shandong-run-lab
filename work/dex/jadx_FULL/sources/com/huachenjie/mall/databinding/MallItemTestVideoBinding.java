package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.test.TestVideoDetailBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemTestVideoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TestVideoDetailBean f10943a;

    @NonNull
    public final TextView b;

    public MallItemTestVideoBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f35044a = imageView;
        this.f10942a = textView;
        this.b = textView2;
    }

    public static MallItemTestVideoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemTestVideoBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemTestVideoBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_test_video);
    }

    @NonNull
    public static MallItemTestVideoBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemTestVideoBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemTestVideoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemTestVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_test_video, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemTestVideoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemTestVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_test_video, null, false, obj);
    }

    @Nullable
    public TestVideoDetailBean f() {
        return this.f10943a;
    }

    public abstract void k(@Nullable TestVideoDetailBean testVideoDetailBean);
}
