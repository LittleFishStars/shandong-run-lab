package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.Converters;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.page.rankinglist.SunshineRankingActivity;
import com.huachenjie.run.page.rankinglist.SunshineRankingActivityVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivitySunshineRankingBindingImpl extends RunActivitySunshineRankingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11609a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11614a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingActivity.a f35502a;

        public a a(SunshineRankingActivity.a value) {
            this.f35502a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35502a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRankingActivity.a f35503a;

        public b a(SunshineRankingActivity.a value) {
            this.f35503a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35503a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35501a = sparseIntArray;
        sparseIntArray.put(R.id.sunshine_ranking_vp, 4);
        sparseIntArray.put(R.id.sunshine_ranking_tab, 5);
    }

    public RunActivitySunshineRankingBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f11609a, f35501a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        a aVarA;
        b bVarA;
        int iIntValue;
        synchronized (this) {
            j = this.f11610a;
            this.f11610a = 0L;
        }
        SunshineRankingActivityVM sunshineRankingActivityVM = ((RunActivitySunshineRankingBinding) this).f11608a;
        SunshineRankingActivity.a aVar = ((RunActivitySunshineRankingBinding) this).f11607a;
        int iSafeUnbox = 0;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                iIntValue = 0;
            } else {
                MutableLiveData<Integer> mutableLiveDataK = sunshineRankingActivityVM != null ? sunshineRankingActivityVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                Integer value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                if (value != null) {
                    iIntValue = value.intValue();
                } else {
                    iIntValue = 0;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<Integer> mutableLiveData = sunshineRankingActivityVM != null ? ((BaseVM) sunshineRankingActivityVM).f33644a : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            }
            i = iSafeUnbox;
            iSafeUnbox = iIntValue;
        } else {
            i = 0;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f11614a;
            if (bVar == null) {
                bVar = new b();
                this.f11614a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11613a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11613a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((21 & j) != 0) {
            ViewBindingAdapter.setBackground(this.f11611a, Converters.convertColorToDrawable(iSafeUnbox));
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.O(this.f11611a, 0, i, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunActivitySunshineRankingBinding) this).f35500a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11610a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11610a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySunshineRankingBinding
    public void l(@Nullable SunshineRankingActivity.a Click) {
        ((RunActivitySunshineRankingBinding) this).f11607a = Click;
        synchronized (this) {
            this.f11610a |= 8;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySunshineRankingBinding
    public void m(@Nullable SunshineRankingActivityVM Vm) {
        ((RunActivitySunshineRankingBinding) this).f11608a = Vm;
        synchronized (this) {
            this.f11610a |= 4;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11610a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmTitleBackground, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11610a |= 1;
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
            m((SunshineRankingActivityVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SunshineRankingActivity.a) variable);
        }
        return true;
    }

    public RunActivitySunshineRankingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (SlidingTabLayout2) bindings[5], (ViewPager2) bindings[4], (ImageView) bindings[2], (ImageView) bindings[3]);
        this.f11610a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f11612a = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.f11611a = linearLayout;
        linearLayout.setTag(null);
        ((RunActivitySunshineRankingBinding) this).f35500a.setTag(null);
        this.b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
