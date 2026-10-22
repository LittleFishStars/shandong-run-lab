package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsAdapter;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentWorksDetailGoodsBindingImpl extends WorksFragmentWorksDetailGoodsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14367a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f14372a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WorksDetailsGoodsFragment f36973a;

        public a a(WorksDetailsGoodsFragment value) {
            this.f36973a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36973a.onDismissDialog(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36972a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.state_layout, 5);
    }

    public WorksFragmentWorksDetailGoodsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f14367a, f36972a));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        WorksDetailsGoodsAdapter value;
        synchronized (this) {
            j = this.f14368a;
            this.f14368a = 0L;
        }
        WorksDetailsGoodsFragment worksDetailsGoodsFragment = ((WorksFragmentWorksDetailGoodsBinding) this).f14365a;
        WorksDetailsGoodsVM worksDetailsGoodsVM = ((WorksFragmentWorksDetailGoodsBinding) this).f14366a;
        long j2 = 10 & j;
        if (j2 == 0 || worksDetailsGoodsFragment == null) {
            aVarA = null;
        } else {
            a aVar = this.f14371a;
            if (aVar == null) {
                aVar = new a();
                this.f14371a = aVar;
            }
            aVarA = aVar.a(worksDetailsGoodsFragment);
        }
        long j3 = 13 & j;
        if (j3 == 0) {
            value = null;
        } else {
            MutableLiveData<WorksDetailsGoodsAdapter> mutableLiveDataI = worksDetailsGoodsVM != null ? worksDetailsGoodsVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14369a, aVarA, null);
            CommonBindingAdapter.q(this.f14370a, aVarA, null);
        }
        if ((j & 8) != 0) {
            CommonBindingAdapter.I(this.f14372a, 0, 44, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.g(((WorksFragmentWorksDetailGoodsBinding) this).f14363a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14368a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14368a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentWorksDetailGoodsBinding
    public void l(@Nullable WorksDetailsGoodsFragment Fragment) {
        ((WorksFragmentWorksDetailGoodsBinding) this).f14365a = Fragment;
        synchronized (this) {
            this.f14368a |= 2;
        }
        notifyPropertyChanged(qk0.s);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentWorksDetailGoodsBinding
    public void m(@Nullable WorksDetailsGoodsVM Vm) {
        ((WorksFragmentWorksDetailGoodsBinding) this).f14366a = Vm;
        synchronized (this) {
            this.f14368a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<WorksDetailsGoodsAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14368a |= 1;
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
        if (qk0.s == variableId) {
            l((WorksDetailsGoodsFragment) variable);
        } else {
            if (qk0.p0 != variableId) {
                return false;
            }
            m((WorksDetailsGoodsVM) variable);
        }
        return true;
    }

    public WorksFragmentWorksDetailGoodsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[3], (StateLayout) bindings[5], (TextView) bindings[4]);
        this.f14368a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14369a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[1];
        this.f14372a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.f14370a = imageView;
        imageView.setTag(null);
        ((WorksFragmentWorksDetailGoodsBinding) this).f14363a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
