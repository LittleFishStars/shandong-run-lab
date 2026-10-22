package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.adapter.ReplenishEnergyListAdapter;
import com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentReplenishEnergyListBindingImpl extends FragmentReplenishEnergyListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36162a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12922a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12924a;

    public FragmentReplenishEnergyListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12922a, f36162a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12923a;
            this.f12923a = 0L;
        }
        ReplenishEnergyListVM replenishEnergyListVM = ((FragmentReplenishEnergyListBinding) this).f36161a;
        long j2 = j & 7;
        ReplenishEnergyListAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ReplenishEnergyListAdapter> mutableLiveDataM = replenishEnergyListVM != null ? replenishEnergyListVM.m() : null;
            updateLiveDataRegistration(0, mutableLiveDataM);
            if (mutableLiveDataM != null) {
                value = mutableLiveDataM.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f12924a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12923a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12923a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.FragmentReplenishEnergyListBinding
    public void k(@Nullable ReplenishEnergyListVM replenishEnergyListVM) {
        ((FragmentReplenishEnergyListBinding) this).f36161a = replenishEnergyListVM;
        synchronized (this) {
            this.f12923a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ReplenishEnergyListAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12923a |= 1;
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
        if (nk0.p0 != i) {
            return false;
        }
        k((ReplenishEnergyListVM) obj);
        return true;
    }

    public FragmentReplenishEnergyListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f12923a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f12924a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
