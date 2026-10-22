package com.huachenjie.home.databinding;

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
import com.huachenjie.home.HomeFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.PromoSlotBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeLayoutGoodStuffPickBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeFragment.ClickProxy f9588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PromoSlotBean f9589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f9590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f9591a;

    @NonNull
    public final ImageView b;

    public HomeLayoutGoodStuffPickBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.f34307a = imageView;
        this.b = imageView2;
        this.f9587a = textView;
    }

    public static HomeLayoutGoodStuffPickBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeLayoutGoodStuffPickBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeLayoutGoodStuffPickBinding) ViewDataBinding.bind(obj, view, R.layout.home_layout_good_stuff_pick);
    }

    @NonNull
    public static HomeLayoutGoodStuffPickBinding k(@NonNull LayoutInflater layoutInflater) {
        return n(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeLayoutGoodStuffPickBinding l(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeLayoutGoodStuffPickBinding m(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeLayoutGoodStuffPickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_layout_good_stuff_pick, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeLayoutGoodStuffPickBinding n(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeLayoutGoodStuffPickBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_layout_good_stuff_pick, null, false, obj);
    }

    @Nullable
    public PromoSlotBean f() {
        return this.f9589a;
    }

    @Nullable
    public HomeFragment.ClickProxy g() {
        return this.f9588a;
    }

    @Nullable
    public Integer h() {
        return this.f9591a;
    }

    @Nullable
    public Boolean j() {
        return this.f9590a;
    }

    public abstract void o(@Nullable PromoSlotBean promoSlotBean);

    public abstract void p(@Nullable HomeFragment.ClickProxy clickProxy);

    public abstract void q(@Nullable Integer num);

    public abstract void r(@Nullable Boolean bool);
}
