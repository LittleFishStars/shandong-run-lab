package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.SuperPackActivity;
import com.huachenjie.social_contact.vm.SuperPackVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivitySuperPackBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f12802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f12803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SpineWebView f12804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SuperPackActivity.a f12805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SuperPackVM f12806a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12807b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12808b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12809b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12810c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f12811c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f12812d;

    @NonNull
    public final ImageView e;

    public ActivitySuperPackBinding(Object obj, View view, int i, FrameLayout frameLayout, CardView cardView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout, SpineWebView spineWebView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f36112a = frameLayout;
        this.f12802a = cardView;
        this.f12798a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f12803a = lottieAnimationView;
        this.f12800a = relativeLayout;
        this.f12804a = spineWebView;
        this.f12799a = linearLayout;
        this.f12807b = linearLayout2;
        this.f12810c = linearLayout3;
        this.f12808b = relativeLayout2;
        this.f12801a = textView;
        this.f12809b = textView2;
        this.f12811c = textView3;
        this.f12812d = textView4;
    }

    public static ActivitySuperPackBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySuperPackBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySuperPackBinding) ViewDataBinding.bind(obj, view, R.layout.activity_super_pack);
    }

    @NonNull
    public static ActivitySuperPackBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySuperPackBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySuperPackBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySuperPackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_pack, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySuperPackBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySuperPackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_super_pack, null, false, obj);
    }

    @Nullable
    public SuperPackActivity.a f() {
        return this.f12805a;
    }

    @Nullable
    public SuperPackVM g() {
        return this.f12806a;
    }

    public abstract void l(@Nullable SuperPackActivity.a aVar);

    public abstract void m(@Nullable SuperPackVM superPackVM);
}
