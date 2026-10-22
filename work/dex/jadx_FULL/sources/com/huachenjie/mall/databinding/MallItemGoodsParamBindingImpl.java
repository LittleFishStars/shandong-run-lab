package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailAttribute;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemGoodsParamBindingImpl extends MallItemGoodsParamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35010a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10825a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10828a;

    @NonNull
    public final TextView b;

    public MallItemGoodsParamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10825a, f35010a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String attributesName;
        String attributesValuesStr;
        synchronized (this) {
            j = this.f10826a;
            this.f10826a = 0L;
        }
        GoodsDetailAttribute goodsDetailAttribute = ((MallItemGoodsParamBinding) this).f35009a;
        long j2 = j & 3;
        if (j2 == 0 || goodsDetailAttribute == null) {
            attributesName = null;
            attributesValuesStr = null;
        } else {
            attributesName = goodsDetailAttribute.getAttributesName();
            attributesValuesStr = goodsDetailAttribute.getAttributesValuesStr();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f10828a, attributesName);
            TextViewBindingAdapter.setText(this.b, attributesValuesStr);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10826a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10826a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemGoodsParamBinding
    public void k(@Nullable GoodsDetailAttribute goodsDetailAttribute) {
        ((MallItemGoodsParamBinding) this).f35009a = goodsDetailAttribute;
        synchronized (this) {
            this.f10826a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((GoodsDetailAttribute) obj);
        return true;
    }

    public MallItemGoodsParamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10826a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10827a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f10828a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
