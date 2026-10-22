package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.common.widget.PointCardView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.suit.UserWearActivity;
import com.huachenjie.social_contact.page.suit.UserWearVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityUserWearBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SpineWebView f12825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PointCardView f12826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserWearActivity.a f12827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserWearVM f12828a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final PointCardView f12829b;

    @NonNull
    public final PointCardView c;

    public ActivityUserWearBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, RelativeLayout relativeLayout, ImageView imageView2, PointCardView pointCardView, PointCardView pointCardView2, PointCardView pointCardView3, SpineWebView spineWebView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f12822a = imageView;
        this.f36119a = frameLayout;
        this.f12823a = relativeLayout;
        this.b = imageView2;
        this.f12826a = pointCardView;
        this.f12829b = pointCardView2;
        this.c = pointCardView3;
        this.f12825a = spineWebView;
        this.f12824a = recyclerView;
    }

    public static ActivityUserWearBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityUserWearBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityUserWearBinding) ViewDataBinding.bind(obj, view, R.layout.activity_user_wear);
    }

    @NonNull
    public static ActivityUserWearBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityUserWearBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityUserWearBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityUserWearBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_user_wear, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityUserWearBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityUserWearBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_user_wear, null, false, obj);
    }

    @Nullable
    public UserWearActivity.a f() {
        return this.f12827a;
    }

    @Nullable
    public UserWearVM g() {
        return this.f12828a;
    }

    public abstract void l(@Nullable UserWearActivity.a aVar);

    public abstract void m(@Nullable UserWearVM userWearVM);
}
