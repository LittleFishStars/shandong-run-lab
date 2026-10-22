package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.home.R;
import com.huachenjie.home.page.good_stuff.GoodStuffAdapter;
import com.huachenjie.home.page.union_search.UnionGoodsSearchVM;
import com.zj.adlib.xk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityUnionGoodsSearchBindingImpl extends HomeActivityUnionGoodsSearchBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9341a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9343a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34221a = sparseIntArray;
        sparseIntArray.put(R.id.search_view, 3);
    }

    public HomeActivityUnionGoodsSearchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9341a, f34221a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        GoodStuffAdapter value;
        Integer value2;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f9342a;
            this.f9342a = 0L;
        }
        UnionGoodsSearchVM unionGoodsSearchVM = ((HomeActivityUnionGoodsSearchBinding) this).f9340a;
        if ((31 & j) != 0) {
            if ((j & 25) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = unionGoodsSearchVM != null ? unionGoodsSearchVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 26) != 0) {
                BaseViewModel.b bVarE = unionGoodsSearchVM != null ? unionGoodsSearchVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 28) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<GoodStuffAdapter> mutableLiveDataB2 = unionGoodsSearchVM != null ? unionGoodsSearchVM.B() : null;
                updateLiveDataRegistration(2, mutableLiveDataB2);
                if (mutableLiveDataB2 != null) {
                    value = mutableLiveDataB2.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            i = 0;
            value = null;
            value2 = null;
        }
        if ((26 & j) != 0) {
            CommonBindingAdapter.O(this.f9343a, 0, i, 0, 0, null);
        }
        if ((28 & j) != 0) {
            CommonBindingAdapter.g(((HomeActivityUnionGoodsSearchBinding) this).f34220a, value, false, false);
        }
        if ((j & 25) != 0) {
            xq8.a(((HomeActivityUnionGoodsSearchBinding) this).f9338a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9342a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9342a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityUnionGoodsSearchBinding
    public void k(@Nullable UnionGoodsSearchVM unionGoodsSearchVM) {
        ((HomeActivityUnionGoodsSearchBinding) this).f9340a = unionGoodsSearchVM;
        synchronized (this) {
            this.f9342a |= 8;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<GoodStuffAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9342a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9342a |= 1;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9342a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 != i) {
            return false;
        }
        k((UnionGoodsSearchVM) obj);
        return true;
    }

    public HomeActivityUnionGoodsSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[2], (CommonSearchView) objArr[3], (StateLayout) objArr[1]);
        this.f9342a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9343a = linearLayout;
        linearLayout.setTag(null);
        ((HomeActivityUnionGoodsSearchBinding) this).f34220a.setTag(null);
        ((HomeActivityUnionGoodsSearchBinding) this).f9338a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
