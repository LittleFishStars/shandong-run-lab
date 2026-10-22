package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.run.page.rankinglist.SunshineRankingAdapter;
import com.huachenjie.run.page.rankinglist.SunshineRankingFragment;
import com.huachenjie.run.page.rankinglist.SunshineRankingVM;
import com.zj.adlib.lk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunFragmentSunshineRankingBindingImpl extends RunFragmentSunshineRankingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35592a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11867a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11869a;

    public static class a implements CommonBindingAdapter.OnScroll {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingFragment.c f35593a;

        @Override // com.huachenjie.common.binding_adapter.CommonBindingAdapter.OnScroll
        public void a(RecyclerView arg0, int arg1, int arg2) {
            this.f35593a.a(arg0, arg1, arg2);
        }

        public a b(SunshineRankingFragment.c value) {
            this.f35593a = value;
            if (value == null) {
                return null;
            }
            return this;
        }
    }

    public RunFragmentSunshineRankingBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 2, f11867a, f35592a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        SunshineRankingAdapter value;
        Integer value2;
        a aVarB;
        synchronized (this) {
            j = this.f11868a;
            this.f11868a = 0L;
        }
        SunshineRankingVM sunshineRankingVM = ((RunFragmentSunshineRankingBinding) this).f11866a;
        SunshineRankingFragment.c cVar = ((RunFragmentSunshineRankingBinding) this).f11865a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataO = sunshineRankingVM != null ? sunshineRankingVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<SunshineRankingAdapter> mutableLiveDataL = sunshineRankingVM != null ? sunshineRankingVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || cVar == null) {
            aVarB = null;
        } else {
            a aVar = this.f11869a;
            if (aVar == null) {
                aVar = new a();
                this.f11869a = aVar;
            }
            aVarB = aVar.b(cVar);
        }
        if ((21 & j) != 0) {
            xq8.a(((RunFragmentSunshineRankingBinding) this).f11864a, value2, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(((RunFragmentSunshineRankingBinding) this).f35591a, value, false, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.L(((RunFragmentSunshineRankingBinding) this).f35591a, aVarB, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11868a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11868a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentSunshineRankingBinding
    public void l(@Nullable SunshineRankingFragment.c Scroll) {
        ((RunFragmentSunshineRankingBinding) this).f11865a = Scroll;
        synchronized (this) {
            this.f11868a |= 8;
        }
        notifyPropertyChanged(lk0.S);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentSunshineRankingBinding
    public void m(@Nullable SunshineRankingVM Vm) {
        ((RunFragmentSunshineRankingBinding) this).f11866a = Vm;
        synchronized (this) {
            this.f11868a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SunshineRankingAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11868a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmLayoutState, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11868a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRankingVM) variable);
        } else {
            if (lk0.S != variableId) {
                return false;
            }
            l((SunshineRankingFragment.c) variable);
        }
        return true;
    }

    public RunFragmentSunshineRankingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (StateLayout) bindings[0], (RecyclerView) bindings[1]);
        this.f11868a = -1L;
        ((RunFragmentSunshineRankingBinding) this).f11864a.setTag(null);
        ((RunFragmentSunshineRankingBinding) this).f35591a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
