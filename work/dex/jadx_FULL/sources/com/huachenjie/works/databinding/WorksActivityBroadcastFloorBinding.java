package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorVM;
import com.noober.background.view.BLLinearLayout;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityBroadcastFloorBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Toolbar f13820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f13822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f13823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f13824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BroadcastFloorActivity.ClickProxy f13825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BroadcastFloorVM f13826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f13827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Banner f13828a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13829b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13830c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13831d;

    @NonNull
    public final TextView e;

    public WorksActivityBroadcastFloorBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBar, FrameLayout bgContainer, BLLinearLayout blLinearLayout, ConstraintLayout clHeaderContainer, ImageView curImage, ImageView ivBack, ImageView ivBroadcastFloorIcon, ImageView preImage, SlidingTabLayout tabLayout, Toolbar toolBar, TextView tvDescription, TextView tvLeftBt, TextView tvName, TextView tvTitle, TextView tvTopic, View vStatusSpace, ViewPager viewPager, Banner vpBroadcastFloorBanner) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13824a = appBar;
        this.f13817a = bgContainer;
        this.f13827a = blLinearLayout;
        this.f13821a = clHeaderContainer;
        this.f13818a = curImage;
        this.b = ivBack;
        this.c = ivBroadcastFloorIcon;
        this.d = preImage;
        this.f13823a = tabLayout;
        this.f13820a = toolBar;
        this.f13819a = tvDescription;
        this.f13829b = tvLeftBt;
        this.f13830c = tvName;
        this.f13831d = tvTitle;
        this.e = tvTopic;
        this.f36769a = vStatusSpace;
        this.f13822a = viewPager;
        this.f13828a = vpBroadcastFloorBanner;
    }

    public static WorksActivityBroadcastFloorBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityBroadcastFloorBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityBroadcastFloorBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_broadcast_floor);
    }

    @NonNull
    public static WorksActivityBroadcastFloorBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityBroadcastFloorBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityBroadcastFloorBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_broadcast_floor, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityBroadcastFloorBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_broadcast_floor, null, false, component);
    }

    @Nullable
    public BroadcastFloorActivity.ClickProxy f() {
        return this.f13825a;
    }

    @Nullable
    public BroadcastFloorVM g() {
        return this.f13826a;
    }

    public abstract void l(@Nullable BroadcastFloorActivity.ClickProxy click);

    public abstract void m(@Nullable BroadcastFloorVM vm);
}
