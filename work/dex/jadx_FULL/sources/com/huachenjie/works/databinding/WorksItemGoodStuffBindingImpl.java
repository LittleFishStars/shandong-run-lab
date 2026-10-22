package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodStuffBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemGoodStuffBindingImpl extends WorksItemGoodStuffBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14581a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14584a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37035a = sparseIntArray;
        sparseIntArray.put(R.id.tv_name, 6);
    }

    public WorksItemGoodStuffBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14581a, f37035a));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        CharSequence charSequence;
        CharSequence saleCount;
        CharSequence charSequenceFindTag;
        synchronized (this) {
            j = this.f14582a;
            this.f14582a = 0L;
        }
        GoodStuffBean goodStuffBean = ((WorksItemGoodStuffBinding) this).f14580a;
        long j2 = j & 3;
        boolean zShowTag = false;
        String str = null;
        if (j2 != 0) {
            requestOptions = ju3.s;
            if (goodStuffBean != null) {
                CharSequence price = goodStuffBean.formatPrice();
                zShowTag = goodStuffBean.showTag();
                saleCount = goodStuffBean.formatSaleCount();
                charSequenceFindTag = goodStuffBean.findTag();
                String strFindGoodsCover = goodStuffBean.findGoodsCover();
                charSequence = price;
                str = strFindGoodsCover;
            } else {
                charSequence = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.b0(((WorksItemGoodStuffBinding) this).f37034a, str, requestOptions, false);
                CommonBindingAdapter.l0(((WorksItemGoodStuffBinding) this).f14578a, zShowTag);
                TextViewBindingAdapter.setText(this.f14584a, charSequenceFindTag);
                TextViewBindingAdapter.setText(this.b, saleCount);
                TextViewBindingAdapter.setText(this.c, charSequence);
            }
        }
        requestOptions = null;
        charSequence = null;
        saleCount = charSequence;
        charSequenceFindTag = saleCount;
        if (j2 != 0) {
            CommonBindingAdapter.b0(((WorksItemGoodStuffBinding) this).f37034a, str, requestOptions, false);
            CommonBindingAdapter.l0(((WorksItemGoodStuffBinding) this).f14578a, zShowTag);
            TextViewBindingAdapter.setText(this.f14584a, charSequenceFindTag);
            TextViewBindingAdapter.setText(this.b, saleCount);
            TextViewBindingAdapter.setText(this.c, charSequence);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14582a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14582a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemGoodStuffBinding
    public void k(@Nullable GoodStuffBean Bean) {
        ((WorksItemGoodStuffBinding) this).f14580a = Bean;
        synchronized (this) {
            this.f14582a |= 1;
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
        k((GoodStuffBean) variable);
        return true;
    }

    public WorksItemGoodStuffBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (LinearLayout) bindings[2], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[4]);
        this.f14582a = -1L;
        ((WorksItemGoodStuffBinding) this).f37034a.setTag(null);
        ((WorksItemGoodStuffBinding) this).f14578a.setTag(null);
        CardView cardView = (CardView) bindings[0];
        this.f14583a = cardView;
        cardView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[3];
        this.f14584a = bLTextView;
        bLTextView.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
