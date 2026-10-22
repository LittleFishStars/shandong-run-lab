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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.bean.TrySeeVideoBean;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemTrySeeListBindingImpl extends MallItemTrySeeListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35047a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10947a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10952a;

    public MallItemTrySeeListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10947a, f35047a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        boolean z;
        String goodsImage;
        int trySee;
        synchronized (this) {
            j = this.f10948a;
            this.f10948a = 0L;
        }
        TrySeeVideoBean trySeeVideoBean = ((MallItemTrySeeListBinding) this).f35046a;
        long j2 = j & 3;
        String goodsName = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (trySeeVideoBean != null) {
                goodsName = trySeeVideoBean.getGoodsName();
                trySee = trySeeVideoBean.getTrySee();
                goodsImage = trySeeVideoBean.getGoodsImage();
            } else {
                goodsImage = null;
                trySee = 0;
            }
            z = trySee == 1;
            String str2 = goodsImage;
            str = goodsName;
            goodsName = str2;
        } else {
            requestOptions = null;
            str = null;
            z = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f10951a, goodsName, requestOptions, false);
            TextViewBindingAdapter.setText(this.f10950a, str);
            CommonBindingAdapter.l0(this.f10949a, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10948a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10948a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemTrySeeListBinding
    public void k(@Nullable TrySeeVideoBean trySeeVideoBean) {
        ((MallItemTrySeeListBinding) this).f35046a = trySeeVideoBean;
        synchronized (this) {
            this.f10948a |= 1;
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
        k((TrySeeVideoBean) obj);
        return true;
    }

    public MallItemTrySeeListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10948a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f10952a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) objArr[1];
        this.f10951a = bLImageView;
        bLImageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10950a = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[3];
        this.f10949a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
