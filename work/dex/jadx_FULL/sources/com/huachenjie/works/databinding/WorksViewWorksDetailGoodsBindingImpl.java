package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.bean.GoodsRecommendData;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksViewWorksDetailGoodsBindingImpl extends WorksViewWorksDetailGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37123a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14821a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f14823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14824a;

    @NonNull
    public final TextView b;

    public WorksViewWorksDetailGoodsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14821a, f37123a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String recommendGoodName;
        boolean z;
        boolean z2;
        String recommendGoodUrl;
        int goodRecommendNum;
        synchronized (this) {
            j = this.f14822a;
            this.f14822a = 0L;
        }
        GoodsRecommendData goodsRecommendData = ((WorksViewWorksDetailGoodsBinding) this).f14820a;
        long j2 = j & 3;
        String str = null;
        if (j2 != 0) {
            requestOptions = ju3.t;
            if (goodsRecommendData != null) {
                goodRecommendNum = goodsRecommendData.formatGoodRecommendNum();
                recommendGoodUrl = goodsRecommendData.getRecommendGoodUrl();
                recommendGoodName = goodsRecommendData.getRecommendGoodName();
            } else {
                recommendGoodName = null;
                recommendGoodUrl = null;
                goodRecommendNum = 0;
            }
            z2 = goodRecommendNum > 1;
            z = goodRecommendNum == 1;
            str = recommendGoodUrl;
        } else {
            requestOptions = null;
            recommendGoodName = null;
            z = false;
            z2 = false;
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(((WorksViewWorksDetailGoodsBinding) this).f37122a, z2);
            CommonBindingAdapter.b0(this.f14823a, str, requestOptions, false);
            CommonBindingAdapter.l0(this.b, z);
            TextViewBindingAdapter.setText(((WorksViewWorksDetailGoodsBinding) this).f14819a, recommendGoodName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14822a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14822a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksViewWorksDetailGoodsBinding
    public void k(@Nullable GoodsRecommendData Bean) {
        ((WorksViewWorksDetailGoodsBinding) this).f14820a = Bean;
        synchronized (this) {
            this.f14822a |= 1;
        }
        notifyPropertyChanged(qk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.g != variableId) {
            return false;
        }
        k((GoodsRecommendData) variable);
        return true;
    }

    public WorksViewWorksDetailGoodsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[4], (TextView) bindings[2]);
        this.f14822a = -1L;
        ((WorksViewWorksDetailGoodsBinding) this).f37122a.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f14824a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLImageView bLImageView = (BLImageView) bindings[1];
        this.f14823a = bLImageView;
        bLImageView.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.b = textView;
        textView.setTag(null);
        ((WorksViewWorksDetailGoodsBinding) this).f14819a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
