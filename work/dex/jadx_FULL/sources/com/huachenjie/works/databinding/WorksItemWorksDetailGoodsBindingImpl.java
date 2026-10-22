package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.RecommendGoodsBean;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorksDetailGoodsBindingImpl extends WorksItemWorksDetailGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14756a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14758a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37090a = sparseIntArray;
        sparseIntArray.put(R.id.tv_see, 4);
    }

    public WorksItemWorksDetailGoodsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14756a, f37090a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String str;
        CharSequence charSequence;
        synchronized (this) {
            j = this.f14757a;
            this.f14757a = 0L;
        }
        RecommendGoodsBean recommendGoodsBean = ((WorksItemWorksDetailGoodsBinding) this).f14755a;
        long j2 = j & 3;
        String imageUrl = null;
        if (j2 != 0) {
            requestOptions = ju3.m;
            if (recommendGoodsBean != null) {
                String goodsName = recommendGoodsBean.getGoodsName();
                CharSequence price = recommendGoodsBean.formatPrice();
                str = goodsName;
                imageUrl = recommendGoodsBean.formatImageUrl();
                charSequence = price;
            } else {
                str = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((WorksItemWorksDetailGoodsBinding) this).f37089a, imageUrl, requestOptions, false);
                TextViewBindingAdapter.setText(((WorksItemWorksDetailGoodsBinding) this).f14754a, str);
                TextViewBindingAdapter.setText(this.b, charSequence);
            }
        }
        requestOptions = null;
        str = null;
        charSequence = str;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((WorksItemWorksDetailGoodsBinding) this).f37089a, imageUrl, requestOptions, false);
            TextViewBindingAdapter.setText(((WorksItemWorksDetailGoodsBinding) this).f14754a, str);
            TextViewBindingAdapter.setText(this.b, charSequence);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14757a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14757a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorksDetailGoodsBinding
    public void k(@Nullable RecommendGoodsBean Bean) {
        ((WorksItemWorksDetailGoodsBinding) this).f14755a = Bean;
        synchronized (this) {
            this.f14757a |= 1;
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
        k((RecommendGoodsBean) variable);
        return true;
    }

    public WorksItemWorksDetailGoodsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[4]);
        this.f14757a = -1L;
        ((WorksItemWorksDetailGoodsBinding) this).f37089a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14758a = constraintLayout;
        constraintLayout.setTag(null);
        ((WorksItemWorksDetailGoodsBinding) this).f14754a.setTag(null);
        this.b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
