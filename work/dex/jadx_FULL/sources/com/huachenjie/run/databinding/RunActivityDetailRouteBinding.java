package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.route.RunDetailRouteActivity;
import com.huachenjie.run.page.run_detail.route.RunDetailRouteVM;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityDetailRouteBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailRouteActivity.a f11469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailRouteVM f11470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11471a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11472b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11473b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public RunActivityDetailRouteBinding(Object _bindingComponent, View _root, int _localFieldCount, BLConstraintLayout clStaticsCard, FrameLayout flMapContainer, AvatarView imgAvatar, ImageView ivBack, ImageView ivUserInfoVisible, LinearLayout llMetrics, LinearLayout llPaceBar, TextView tvBurnedCalories, TextView tvCostedTime, TextView tvDistance, TextView tvDistanceLabel, TextView tvDistanceUnit, TextView tvNickname, TextView tvPace, TextView tvStudentNo, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11471a = clStaticsCard;
        this.f35459a = flMapContainer;
        this.f11468a = imgAvatar;
        this.f11465a = ivBack;
        this.b = ivUserInfoVisible;
        this.f11466a = llMetrics;
        this.f11472b = llPaceBar;
        this.f11467a = tvBurnedCalories;
        this.f11473b = tvCostedTime;
        this.c = tvDistance;
        this.d = tvDistanceLabel;
        this.e = tvDistanceUnit;
        this.f = tvNickname;
        this.g = tvPace;
        this.h = tvStudentNo;
        this.i = tvTime;
    }

    public static RunActivityDetailRouteBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityDetailRouteBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityDetailRouteBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_detail_route);
    }

    @NonNull
    public static RunActivityDetailRouteBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityDetailRouteBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityDetailRouteBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityDetailRouteBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_detail_route, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityDetailRouteBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityDetailRouteBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_detail_route, null, false, component);
    }

    @Nullable
    public RunDetailRouteActivity.a f() {
        return this.f11469a;
    }

    @Nullable
    public RunDetailRouteVM g() {
        return this.f11470a;
    }

    public abstract void l(@Nullable RunDetailRouteActivity.a click);

    public abstract void m(@Nullable RunDetailRouteVM vm);
}
