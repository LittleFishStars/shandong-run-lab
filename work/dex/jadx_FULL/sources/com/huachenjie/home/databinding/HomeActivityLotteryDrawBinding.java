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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.draw.LotteryDrawFragment;
import com.huachenjie.home.page.draw.LotteryDrawVM;
import com.huachenjie.home.widget.TopCropImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityLotteryDrawBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f9287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f9288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LotteryDrawFragment.a f9289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LotteryDrawVM f9290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TopCropImageView f9291a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public HomeActivityLotteryDrawBinding(Object obj, View view, int i, ImageView imageView, TopCropImageView topCropImageView, SwipeRefreshLayout swipeRefreshLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.f9285a = imageView;
        this.f9291a = topCropImageView;
        this.f9288a = swipeRefreshLayout;
        this.f9286a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.f34205a = view2;
    }

    public static HomeActivityLotteryDrawBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityLotteryDrawBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityLotteryDrawBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_lottery_draw);
    }

    @NonNull
    public static HomeActivityLotteryDrawBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityLotteryDrawBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityLotteryDrawBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityLotteryDrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_lottery_draw, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityLotteryDrawBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityLotteryDrawBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_lottery_draw, null, false, obj);
    }

    @Nullable
    public LotteryDrawFragment.a f() {
        return this.f9289a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f9287a;
    }

    @Nullable
    public LotteryDrawVM h() {
        return this.f9290a;
    }

    public abstract void m(@Nullable LotteryDrawFragment.a aVar);

    public abstract void n(@Nullable LotteryDrawVM lotteryDrawVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
