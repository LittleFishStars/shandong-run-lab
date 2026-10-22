package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksActivity;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityHuodongRunRanksHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f13289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuodongRunRanksActivity.a f13290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuodongRunRanksVM f13291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f13292a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13293b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13294b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13295c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13296c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13297d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f13298e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f13299f;

    @NonNull
    public final ImageView g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f13300g;

    @NonNull
    public final TextView h;

    public ActivityHuodongRunRanksHeaderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AvatarView avatarView, ImageView imageView5, ImageView imageView6, ImageView imageView7, TextView textView, TextView textView2, TextView textView3, BLLinearLayout bLLinearLayout, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2) {
        super(obj, view, i);
        this.f13288a = constraintLayout;
        this.f13294b = constraintLayout2;
        this.f13296c = constraintLayout3;
        this.f13286a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.f13289a = avatarView;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.f13287a = textView;
        this.f13293b = textView2;
        this.f13295c = textView3;
        this.f13292a = bLLinearLayout;
        this.f13297d = textView4;
        this.f13298e = textView5;
        this.f13299f = textView6;
        this.f13300g = textView7;
        this.h = textView8;
        this.f36413a = view2;
    }

    public static ActivityHuodongRunRanksHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHuodongRunRanksHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityHuodongRunRanksHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.activity_huodong_run_ranks_header);
    }

    @NonNull
    public static ActivityHuodongRunRanksHeaderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityHuodongRunRanksHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityHuodongRunRanksHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityHuodongRunRanksHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_huodong_run_ranks_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityHuodongRunRanksHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityHuodongRunRanksHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_huodong_run_ranks_header, null, false, obj);
    }

    @Nullable
    public HuodongRunRanksActivity.a f() {
        return this.f13290a;
    }

    @Nullable
    public HuodongRunRanksVM g() {
        return this.f13291a;
    }

    public abstract void l(@Nullable HuodongRunRanksActivity.a aVar);

    public abstract void m(@Nullable HuodongRunRanksVM huodongRunRanksVM);
}
