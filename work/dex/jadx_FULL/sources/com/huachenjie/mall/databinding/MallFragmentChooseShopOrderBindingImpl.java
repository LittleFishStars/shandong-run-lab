package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.shop_order.ChooseShopOrderAdapter;
import com.huachenjie.mall.dialog.shop_order.ChooseShopOrderFragment;
import com.huachenjie.mall.dialog.shop_order.ChooseShopOrderVm;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallFragmentChooseShopOrderBindingImpl extends MallFragmentChooseShopOrderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10654a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10658a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseShopOrderFragment f34945a;

        public a a(ChooseShopOrderFragment chooseShopOrderFragment) {
            this.f34945a = chooseShopOrderFragment;
            if (chooseShopOrderFragment == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34945a.onDismissDialog(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34944a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.state_layout, 4);
    }

    public MallFragmentChooseShopOrderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10654a, f34944a));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        ChooseShopOrderAdapter value;
        synchronized (this) {
            j = this.f10655a;
            this.f10655a = 0L;
        }
        ChooseShopOrderFragment chooseShopOrderFragment = ((MallFragmentChooseShopOrderBinding) this).f10652a;
        ChooseShopOrderVm chooseShopOrderVm = ((MallFragmentChooseShopOrderBinding) this).f10653a;
        long j2 = 10 & j;
        if (j2 == 0 || chooseShopOrderFragment == null) {
            aVarA = null;
        } else {
            a aVar = this.f10657a;
            if (aVar == null) {
                aVar = new a();
                this.f10657a = aVar;
            }
            aVarA = aVar.a(chooseShopOrderFragment);
        }
        long j3 = 13 & j;
        if (j3 == 0) {
            value = null;
        } else {
            MutableLiveData<ChooseShopOrderAdapter> mutableLiveDataB = chooseShopOrderVm != null ? chooseShopOrderVm.B() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            if (mutableLiveDataB != null) {
                value = mutableLiveDataB.getValue();
            } else {
                value = null;
            }
        }
        if ((j & 8) != 0) {
            CommonBindingAdapter.I(this.f10658a, 0, 44, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10656a, aVarA, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.g(((MallFragmentChooseShopOrderBinding) this).f10650a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10655a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10655a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentChooseShopOrderBinding
    public void l(@Nullable ChooseShopOrderFragment chooseShopOrderFragment) {
        ((MallFragmentChooseShopOrderBinding) this).f10652a = chooseShopOrderFragment;
        synchronized (this) {
            this.f10655a |= 2;
        }
        notifyPropertyChanged(hk0.s);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentChooseShopOrderBinding
    public void m(@Nullable ChooseShopOrderVm chooseShopOrderVm) {
        ((MallFragmentChooseShopOrderBinding) this).f10653a = chooseShopOrderVm;
        synchronized (this) {
            this.f10655a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ChooseShopOrderAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10655a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.s == i) {
            l((ChooseShopOrderFragment) obj);
        } else {
            if (hk0.p0 != i) {
                return false;
            }
            m((ChooseShopOrderVm) obj);
        }
        return true;
    }

    public MallFragmentChooseShopOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[2], (StateLayout) objArr[4], (TextView) objArr[3]);
        this.f10655a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f10658a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10656a = imageView;
        imageView.setTag(null);
        ((MallFragmentChooseShopOrderBinding) this).f10650a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
