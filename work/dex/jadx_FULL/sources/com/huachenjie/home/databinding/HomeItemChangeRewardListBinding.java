package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.reward.AwardListBean;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemChangeRewardListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AwardListBean f9453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f9454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f9455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f9457a;

    public HomeItemChangeRewardListBinding(Object obj, View view, int i, BLImageView bLImageView, PriceView priceView, BLTextView bLTextView, TextView textView) {
        super(obj, view, i);
        this.f9455a = bLImageView;
        this.f9454a = priceView;
        this.f9456a = bLTextView;
        this.f34265a = textView;
    }

    public static HomeItemChangeRewardListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemChangeRewardListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemChangeRewardListBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_change_reward_list);
    }

    @NonNull
    public static HomeItemChangeRewardListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemChangeRewardListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemChangeRewardListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemChangeRewardListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_change_reward_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemChangeRewardListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemChangeRewardListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_change_reward_list, null, false, obj);
    }

    @Nullable
    public AwardListBean f() {
        return this.f9453a;
    }

    @Nullable
    public Integer g() {
        return this.f9457a;
    }

    public abstract void l(@Nullable AwardListBean awardListBean);

    public abstract void m(@Nullable Integer num);
}
