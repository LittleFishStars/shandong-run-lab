package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.page.mine.helpercenter.CustomerServiceCenterActivity;
import com.huachenjie.sport.page.mine.helpercenter.CustomerServiceCenterVM;
import com.huachenjie.sport.page.mine.helpercenter.problem_tree.CustomerServiceAdapter;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityCustomerServiceCenterBindingImpl extends ActivityCustomerServiceCenterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13201a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CustomerServiceCenterActivity.a f36388a;

        public a a(CustomerServiceCenterActivity.a aVar) {
            this.f36388a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36388a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CustomerServiceCenterActivity.a f36389a;

        public b a(CustomerServiceCenterActivity.a aVar) {
            this.f36389a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36389a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f13195a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36387a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_bg, 5);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_problem_title, 6);
        sparseIntArray.put(com.huachenjie.sport.R.id.flFd, 7);
    }

    public ActivityCustomerServiceCenterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13195a, f36387a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CustomerServiceAdapter value;
        BindingTitleBean value2;
        RecyclerView.ItemDecoration value3;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f13196a;
            this.f13196a = 0L;
        }
        CustomerServiceCenterVM customerServiceCenterVM = ((ActivityCustomerServiceCenterBinding) this).f13194a;
        CustomerServiceCenterActivity.a aVar = ((ActivityCustomerServiceCenterBinding) this).f13193a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataL = customerServiceCenterVM != null ? customerServiceCenterVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) == 0) {
                value3 = null;
            } else {
                MutableLiveData<RecyclerView.ItemDecoration> mutableLiveDataK = customerServiceCenterVM != null ? customerServiceCenterVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<CustomerServiceAdapter> mutableLiveDataI = customerServiceCenterVM != null ? customerServiceCenterVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f13201a;
            if (bVar == null) {
                bVar = new b();
                this.f13201a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f13200a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13200a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityCustomerServiceCenterBinding) this).f13192a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        if ((j & 41) != 0) {
            this.f13199a.k(value2);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.d(this.f13198a, value3);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.g(this.f13198a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13199a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13196a != 0) {
                return true;
            }
            return this.f13199a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13196a = 32L;
        }
        this.f13199a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityCustomerServiceCenterBinding
    public void l(@Nullable CustomerServiceCenterActivity.a aVar) {
        ((ActivityCustomerServiceCenterBinding) this).f13193a = aVar;
        synchronized (this) {
            this.f13196a |= 16;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityCustomerServiceCenterBinding
    public void m(@Nullable CustomerServiceCenterVM customerServiceCenterVM) {
        ((ActivityCustomerServiceCenterBinding) this).f13194a = customerServiceCenterVM;
        synchronized (this) {
            this.f13196a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<CustomerServiceAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13196a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<RecyclerView.ItemDecoration> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13196a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13196a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13199a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((CustomerServiceCenterVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((CustomerServiceCenterActivity.a) obj);
        }
        return true;
    }

    public ActivityCustomerServiceCenterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ShadowConstraintLayout) objArr[2], (ShadowConstraintLayout) objArr[1], (FrameLayout) objArr[7], (ImageView) objArr[5], (TextView) objArr[6]);
        this.f13196a = -1L;
        ((ActivityCustomerServiceCenterBinding) this).f13192a.setTag(null);
        this.b.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f13199a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13197a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        this.f13198a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
