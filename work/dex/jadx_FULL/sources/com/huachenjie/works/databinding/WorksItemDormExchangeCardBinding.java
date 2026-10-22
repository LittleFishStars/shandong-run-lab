package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.dorm.DormExchangeCardBean;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemDormExchangeCardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f37025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DormExchangeCardBean f14555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14556a;

    @NonNull
    public final TextView b;

    public WorksItemDormExchangeCardBinding(Object _bindingComponent, View _root, int _localFieldCount, BLLinearLayout llCard, TextView tvTitle, TextView tvValue) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14556a = llCard;
        this.f37025a = tvTitle;
        this.b = tvValue;
    }

    public static WorksItemDormExchangeCardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemDormExchangeCardBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemDormExchangeCardBinding) ViewDataBinding.bind(component, view, R.layout.works_item_dorm_exchange_card);
    }

    @NonNull
    public static WorksItemDormExchangeCardBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemDormExchangeCardBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemDormExchangeCardBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemDormExchangeCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_dorm_exchange_card, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemDormExchangeCardBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemDormExchangeCardBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_dorm_exchange_card, null, false, component);
    }

    @Nullable
    public DormExchangeCardBean f() {
        return this.f14555a;
    }

    public abstract void k(@Nullable DormExchangeCardBean bean);
}
