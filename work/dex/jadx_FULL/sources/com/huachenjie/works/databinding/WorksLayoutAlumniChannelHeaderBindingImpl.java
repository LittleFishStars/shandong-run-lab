package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.huachenjie.works.page.alumni.channel.AlumniChannelFragment;
import com.huachenjie.works.page.alumni.channel.AlumniChannelVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksLayoutAlumniChannelHeaderBindingImpl extends WorksLayoutAlumniChannelHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14778a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14782a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AlumniChannelFragment.a f37099a;

        public a a(AlumniChannelFragment.a value) {
            this.f37099a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f37099a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37098a = sparseIntArray;
        sparseIntArray.put(R.id.tvHotWorks, 3);
    }

    public WorksLayoutAlumniChannelHeaderBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f14778a, f37098a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        AllChannelListAdapter value;
        a aVarA;
        synchronized (this) {
            j = this.f14779a;
            this.f14779a = 0L;
        }
        AlumniChannelVM alumniChannelVM = ((WorksLayoutAlumniChannelHeaderBinding) this).f14777a;
        AlumniChannelFragment.a aVar = ((WorksLayoutAlumniChannelHeaderBinding) this).f14776a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<AllChannelListAdapter> mutableLiveDataO = alumniChannelVM != null ? alumniChannelVM.o() : null;
            updateLiveDataRegistration(0, mutableLiveDataO);
            if (mutableLiveDataO != null) {
                value = mutableLiveDataO.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f14781a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14781a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((WorksLayoutAlumniChannelHeaderBinding) this).f14775a, value, false, false);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14782a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14779a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14779a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksLayoutAlumniChannelHeaderBinding
    public void l(@Nullable AlumniChannelFragment.a Click) {
        ((WorksLayoutAlumniChannelHeaderBinding) this).f14776a = Click;
        synchronized (this) {
            this.f14779a |= 4;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksLayoutAlumniChannelHeaderBinding
    public void m(@Nullable AlumniChannelVM Vm) {
        ((WorksLayoutAlumniChannelHeaderBinding) this).f14777a = Vm;
        synchronized (this) {
            this.f14779a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<AllChannelListAdapter> VmChannelAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14779a |= 1;
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
            m((AlumniChannelVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((AlumniChannelFragment.a) variable);
        }
        return true;
    }

    public WorksLayoutAlumniChannelHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[1], (TextView) bindings[3]);
        this.f14779a = -1L;
        ((WorksLayoutAlumniChannelHeaderBinding) this).f14775a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14780a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f14782a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
