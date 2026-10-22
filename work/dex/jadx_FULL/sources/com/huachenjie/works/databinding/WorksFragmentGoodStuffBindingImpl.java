package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffFragment;
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentGoodStuffBindingImpl extends WorksFragmentGoodStuffBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14201a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14205a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodStuffFragment.a f36910a;

        public a a(GoodStuffFragment.a value) {
            this.f36910a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36910a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36909a = sparseIntArray;
        sparseIntArray.put(R.id.tabLayout, 3);
        sparseIntArray.put(R.id.viewPager, 4);
    }

    public WorksFragmentGoodStuffBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14201a, f36909a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f14202a;
            this.f14202a = 0L;
        }
        GoodStuffVM goodStuffVM = ((WorksFragmentGoodStuffBinding) this).f14200a;
        GoodStuffFragment.a aVar = ((WorksFragmentGoodStuffBinding) this).f14199a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = goodStuffVM != null ? goodStuffVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
            updateLiveDataRegistration(0, mutableLiveDataC);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14204a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14204a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14205a, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.G(((WorksFragmentGoodStuffBinding) this).f36908a, iSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14202a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14202a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentGoodStuffBinding
    public void l(@Nullable GoodStuffFragment.a Click) {
        ((WorksFragmentGoodStuffBinding) this).f14199a = Click;
        synchronized (this) {
            this.f14202a |= 4;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentGoodStuffBinding
    public void m(@Nullable GoodStuffVM Vm) {
        ((WorksFragmentGoodStuffBinding) this).f14200a = Vm;
        synchronized (this) {
            this.f14202a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmUiLiveDataStatusBarHeightPx, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14202a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((GoodStuffVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((GoodStuffFragment.a) variable);
        }
        return true;
    }

    public WorksFragmentGoodStuffBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (SlidingTabLayout) bindings[3], (View) bindings[1], (ViewPager) bindings[4]);
        this.f14202a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14203a = linearLayout;
        linearLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[2];
        this.f14205a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ((WorksFragmentGoodStuffBinding) this).f36908a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
