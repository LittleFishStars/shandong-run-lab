package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsUnionVM;
import com.zj.adlib.xk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeFragmentRebateGoodsListBindingImpl extends HomeFragmentRebateGoodsListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9448a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9449a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34261a = sparseIntArray;
        sparseIntArray.put(R.id.rv_list, 1);
    }

    public HomeFragmentRebateGoodsListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f9448a, f34261a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Integer value;
        synchronized (this) {
            j = this.f9449a;
            this.f9449a = 0L;
        }
        RebateGoodsUnionVM rebateGoodsUnionVM = ((HomeFragmentRebateGoodsListBinding) this).f9447a;
        long j2 = j & 7;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<Integer> mutableLiveDataR = rebateGoodsUnionVM != null ? rebateGoodsUnionVM.r() : null;
            updateLiveDataRegistration(0, mutableLiveDataR);
            if (mutableLiveDataR != null) {
                value = mutableLiveDataR.getValue();
            } else {
                value = null;
            }
        }
        if (j2 != 0) {
            xq8.a(((HomeFragmentRebateGoodsListBinding) this).f9446a, value, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9449a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9449a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentRebateGoodsListBinding
    public void k(@Nullable RebateGoodsUnionVM rebateGoodsUnionVM) {
        ((HomeFragmentRebateGoodsListBinding) this).f9447a = rebateGoodsUnionVM;
        synchronized (this) {
            this.f9449a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9449a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 != i) {
            return false;
        }
        k((RebateGoodsUnionVM) obj);
        return true;
    }

    public HomeFragmentRebateGoodsListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[1], (StateLayout) objArr[0]);
        this.f9449a = -1L;
        ((HomeFragmentRebateGoodsListBinding) this).f9446a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
