package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.external.bean.SelectGoodsBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemSelectGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f35034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SelectGoodsBean f10906a;

    public MallItemSelectGoodsBinding(Object obj, View view, int i, CheckBox checkBox, ImageView imageView) {
        super(obj, view, i);
        this.f35034a = checkBox;
        this.f10905a = imageView;
    }

    public static MallItemSelectGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemSelectGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemSelectGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_select_goods);
    }

    @NonNull
    public static MallItemSelectGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemSelectGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemSelectGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemSelectGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_select_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemSelectGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemSelectGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_select_goods, null, false, obj);
    }

    @Nullable
    public SelectGoodsBean f() {
        return this.f10906a;
    }

    public abstract void k(@Nullable SelectGoodsBean selectGoodsBean);
}
