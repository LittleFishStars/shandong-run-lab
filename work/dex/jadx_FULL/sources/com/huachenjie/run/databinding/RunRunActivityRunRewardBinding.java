package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_reward.RunRewardVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunRunActivityRunRewardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Toolbar f12289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f12290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonTabLayout f12291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f12292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f12293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunRewardVM f12294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12295a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12296b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12297b;

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

    public RunRunActivityRunRewardBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarLayout appBar, RelativeLayout clStats, ImageView ivMask, ImageView ivStar, BLLinearLayout llContent, LinearLayout llTabHeader, LinearLayout llTabSticky, CommonTabLayout tabLayout, Toolbar toolBar, LayoutToolbarBindingBinding toolbar, TextView tvDistance, TextView tvDistanceLabel, TextView tvDistanceUnit, TextView tvPageTitle, TextView tvTimes, TextView tvTimesLabel, TextView tvTimesUnit, View vStatsDivider, ViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12292a = appBar;
        this.f12287a = clStats;
        this.f12285a = ivMask;
        this.b = ivStar;
        this.f12295a = llContent;
        this.f12286a = llTabHeader;
        this.f12296b = llTabSticky;
        this.f12291a = tabLayout;
        this.f12289a = toolBar;
        this.f12293a = toolbar;
        this.f12288a = tvDistance;
        this.f12297b = tvDistanceLabel;
        this.c = tvDistanceUnit;
        this.d = tvPageTitle;
        this.e = tvTimes;
        this.f = tvTimesLabel;
        this.g = tvTimesUnit;
        this.f35741a = vStatsDivider;
        this.f12290a = viewPager;
    }

    public static RunRunActivityRunRewardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunRunActivityRunRewardBinding d(@NonNull View view, @Nullable Object component) {
        return (RunRunActivityRunRewardBinding) ViewDataBinding.bind(component, view, R.layout.run_run_activity_run_reward);
    }

    @NonNull
    public static RunRunActivityRunRewardBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunRunActivityRunRewardBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunRunActivityRunRewardBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunRunActivityRunRewardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_activity_run_reward, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunRunActivityRunRewardBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunRunActivityRunRewardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_activity_run_reward, null, false, component);
    }

    @Nullable
    public RunRewardVM f() {
        return this.f12294a;
    }

    public abstract void k(@Nullable RunRewardVM vm);
}
