package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.flyco.tablayout.SegmentTabLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.rankinglist.SunshineRankingFragment;
import com.huachenjie.run.page.rankinglist.SunshineRankingVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunHeadSunshineRankBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SegmentTabLayout f11881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRankingFragment.a f11883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRankingVM f11884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11885a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11886b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11887b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11888b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f11889c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11890c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11891c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f11892d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11893d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f11894e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11895e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f11896f;

    @NonNull
    public final ImageView g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f11897g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    public RunHeadSunshineRankBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clTop1, ConstraintLayout clTop2, ConstraintLayout clTop3, ImageView ivBg, ImageView ivHead1, ImageView ivHead2, ImageView ivHead3, AvatarView ivMyAvatar, BLLinearLayout llLikeNum, BLLinearLayout llRankingLevel1, BLLinearLayout llRankingLevel2, BLLinearLayout llRankingLevel3, BLLinearLayout llRankingTip, LinearLayout llStageName, ImageView llTop2Shadow, ImageView llTop3Shadow, ImageView mIvHeadView, TextView progressTop1, TextView progressTop2, TextView progressTop3, SegmentTabLayout tab, TextView tvMine, TextView tvMyUpdateMs, TextView tvName, TextView tvStageName, TextView tvTop1Name, TextView tvTop2Name, TextView tvTop3Name, View vStatusSpace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11880a = clTop1;
        this.f11887b = clTop2;
        this.f11890c = clTop3;
        this.f11877a = ivBg;
        this.b = ivHead1;
        this.c = ivHead2;
        this.d = ivHead3;
        this.f11882a = ivMyAvatar;
        this.f11885a = llLikeNum;
        this.f11888b = llRankingLevel1;
        this.f11891c = llRankingLevel2;
        this.f11893d = llRankingLevel3;
        this.f11895e = llRankingTip;
        this.f11878a = llStageName;
        this.e = llTop2Shadow;
        this.f = llTop3Shadow;
        this.g = mIvHeadView;
        this.f11879a = progressTop1;
        this.f11886b = progressTop2;
        this.f11889c = progressTop3;
        this.f11881a = tab;
        this.f11892d = tvMine;
        this.f11894e = tvMyUpdateMs;
        this.f11896f = tvName;
        this.f11897g = tvStageName;
        this.h = tvTop1Name;
        this.i = tvTop2Name;
        this.j = tvTop3Name;
        this.f35596a = vStatusSpace;
    }

    public static RunHeadSunshineRankBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunHeadSunshineRankBinding d(@NonNull View view, @Nullable Object component) {
        return (RunHeadSunshineRankBinding) ViewDataBinding.bind(component, view, R.layout.run_head_sunshine_rank);
    }

    @NonNull
    public static RunHeadSunshineRankBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunHeadSunshineRankBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunHeadSunshineRankBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunHeadSunshineRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_head_sunshine_rank, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunHeadSunshineRankBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunHeadSunshineRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_head_sunshine_rank, null, false, component);
    }

    @Nullable
    public SunshineRankingFragment.a f() {
        return this.f11883a;
    }

    @Nullable
    public SunshineRankingVM g() {
        return this.f11884a;
    }

    public abstract void l(@Nullable SunshineRankingFragment.a click);

    public abstract void m(@Nullable SunshineRankingVM vm);
}
