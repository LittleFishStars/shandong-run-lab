package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.page.draw.LotteryDrawFragment;
import com.huachenjie.home.page.draw.LotteryDrawVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeLayoutFlashCoinsHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LotteryDrawFragment.a f9568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LotteryDrawVM f9569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Banner f9572a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f9573b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final Banner f9574b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public HomeLayoutFlashCoinsHeaderBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, BLLinearLayout bLLinearLayout, BLTextView bLTextView, BLTextView bLTextView2, Banner banner, Banner banner2) {
        super(obj, view, i);
        this.f34301a = frameLayout;
        this.f9566a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.f9567a = linearLayout;
        this.f9570a = bLLinearLayout;
        this.f9571a = bLTextView;
        this.f9573b = bLTextView2;
        this.f9572a = banner;
        this.f9574b = banner2;
    }

    public static HomeLayoutFlashCoinsHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeLayoutFlashCoinsHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeLayoutFlashCoinsHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.home_layout_flash_coins_header);
    }

    @NonNull
    public static HomeLayoutFlashCoinsHeaderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeLayoutFlashCoinsHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeLayoutFlashCoinsHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeLayoutFlashCoinsHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_layout_flash_coins_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeLayoutFlashCoinsHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeLayoutFlashCoinsHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_layout_flash_coins_header, null, false, obj);
    }

    @Nullable
    public LotteryDrawFragment.a f() {
        return this.f9568a;
    }

    @Nullable
    public LotteryDrawVM g() {
        return this.f9569a;
    }

    public abstract void l(@Nullable LotteryDrawFragment.a aVar);

    public abstract void m(@Nullable LotteryDrawVM lotteryDrawVM);
}
