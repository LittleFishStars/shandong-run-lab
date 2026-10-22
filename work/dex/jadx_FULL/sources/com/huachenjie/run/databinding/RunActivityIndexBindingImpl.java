package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.huachenjie.run.page.run_index.RunIndexVM;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityIndexBindingImpl extends RunActivityIndexBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f11510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f11511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f11512a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35474a;

        public a a(RunIndexActivity.a value) {
            this.f35474a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35474a.d(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35475a;

        public b a(RunIndexActivity.a value) {
            this.f35475a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35475a.i(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35476a;

        public c a(RunIndexActivity.a value) {
            this.f35476a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35476a.h(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35477a;

        public d a(RunIndexActivity.a value) {
            this.f35477a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35477a.b(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35478a;

        public e a(RunIndexActivity.a value) {
            this.f35478a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35478a.k(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35479a;

        public f a(RunIndexActivity.a value) {
            this.f35479a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35479a.j(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f11503a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35473a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.bottomActionBar, 9);
        sparseIntArray.put(com.huachenjie.run.R.id.flFd, 10);
    }

    public RunActivityIndexBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 11, f11503a, f35473a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        boolean zSafeUnbox;
        RunIndexRecordAdapter value2;
        d dVarA;
        e eVarA;
        a aVarA;
        b bVarA;
        f fVarA;
        c cVarA;
        synchronized (this) {
            j = this.f11504a;
            this.f11504a = 0L;
        }
        RunIndexVM runIndexVM = ((RunActivityIndexBinding) this).f11500a;
        RunIndexActivity.a aVar = ((RunActivityIndexBinding) this).f11499a;
        if ((91 & j) != 0) {
            if ((j & 81) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataY = runIndexVM != null ? runIndexVM.Y() : null;
                updateLiveDataRegistration(0, mediatorLiveDataY);
                zSafeUnbox = ViewDataBinding.safeUnbox(mediatorLiveDataY != null ? mediatorLiveDataY.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 82) == 0) {
                value2 = null;
            } else {
                MutableLiveData<RunIndexRecordAdapter> mutableLiveDataU = runIndexVM != null ? runIndexVM.U() : null;
                updateLiveDataRegistration(1, mutableLiveDataU);
                if (mutableLiveDataU != null) {
                    value2 = mutableLiveDataU.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ0 = runIndexVM != null ? runIndexVM.j0() : null;
                updateLiveDataRegistration(3, mutableLiveDataJ0);
                if (mutableLiveDataJ0 != null) {
                    value = mutableLiveDataJ0.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            zSafeUnbox = false;
            value2 = null;
        }
        long j2 = j & 96;
        if (j2 == 0 || aVar == null) {
            dVarA = null;
            eVarA = null;
            aVarA = null;
            bVarA = null;
            fVarA = null;
            cVarA = null;
        } else {
            f fVar = this.f11512a;
            if (fVar == null) {
                fVar = new f();
                this.f11512a = fVar;
            }
            fVarA = fVar.a(aVar);
            a aVar2 = this.f11507a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11507a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f11508a;
            if (bVar == null) {
                bVar = new b();
                this.f11508a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f11509a;
            if (cVar == null) {
                cVar = new c();
                this.f11509a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f11510a;
            if (dVar == null) {
                dVar = new d();
                this.f11510a = dVar;
            }
            dVarA = dVar.a(aVar);
            e eVar = this.f11511a;
            if (eVar == null) {
                eVar = new e();
                this.f11511a = eVar;
            }
            eVarA = eVar.a(aVar);
        }
        if ((81 & j) != 0) {
            CommonBindingAdapter.l0(((RunActivityIndexBinding) this).f11496a, zSafeUnbox);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunActivityIndexBinding) this).f11496a, dVarA, null);
            CommonBindingAdapter.q(((RunActivityIndexBinding) this).b, fVarA, null);
            CommonBindingAdapter.q(((RunActivityIndexBinding) this).f11497a, cVarA, null);
            CommonBindingAdapter.q(((RunActivityIndexBinding) this).f11502b, bVarA, null);
            CommonBindingAdapter.q(this.c, aVarA, null);
            CommonBindingAdapter.q(this.d, eVarA, null);
        }
        if ((82 & j) != 0) {
            CommonBindingAdapter.g(this.f11506a, value2, false, false);
        }
        if ((j & 88) != 0) {
            ((RunActivityIndexBinding) this).f11498a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((RunActivityIndexBinding) this).f11498a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11504a != 0) {
                return true;
            }
            return ((RunActivityIndexBinding) this).f11498a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11504a = 64L;
        }
        ((RunActivityIndexBinding) this).f11498a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityIndexBinding
    public void l(@Nullable RunIndexActivity.a Click) {
        ((RunActivityIndexBinding) this).f11499a = Click;
        synchronized (this) {
            this.f11504a |= 32;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityIndexBinding
    public void m(@Nullable RunIndexVM Vm) {
        ((RunActivityIndexBinding) this).f11500a = Vm;
        synchronized (this) {
            this.f11504a |= 16;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding ToolBar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11504a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<RunIndexRecordAdapter> VmRunRecordAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11504a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MediatorLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return n((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return q((MutableLiveData) object, fieldId);
    }

    public final boolean p(MediatorLiveData<Boolean> VmShowAlipayBind, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11504a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11504a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunActivityIndexBinding) this).f11498a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((RunIndexVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunIndexActivity.a) variable);
        }
        return true;
    }

    public RunActivityIndexBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (BLConstraintLayout) bindings[9], (FrameLayout) bindings[10], (ImageView) bindings[7], (ImageView) bindings[4], (LayoutToolbarBindingBinding) bindings[8], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[6], (TextView) bindings[5]);
        this.f11504a = -1L;
        ((RunActivityIndexBinding) this).f11496a.setTag(null);
        ((RunActivityIndexBinding) this).b.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f11505a = relativeLayout;
        relativeLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) bindings[1];
        this.f11506a = recyclerView;
        recyclerView.setTag(null);
        setContainedBinding(((RunActivityIndexBinding) this).f11498a);
        ((RunActivityIndexBinding) this).f11497a.setTag(null);
        ((RunActivityIndexBinding) this).f11502b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
