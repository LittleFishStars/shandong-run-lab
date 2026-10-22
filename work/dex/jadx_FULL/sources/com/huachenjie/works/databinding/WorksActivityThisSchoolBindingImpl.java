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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.page.this_school.ThisSchoolActivity;
import com.huachenjie.works.page.this_school.ThisSchoolVM;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityThisSchoolBindingImpl extends WorksActivityThisSchoolBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13958a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13961a;

    @NonNull
    public final FrameLayout b;

    @NonNull
    public final FrameLayout c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThisSchoolActivity.a f36813a;

        public a a(ThisSchoolActivity.a value) {
            this.f36813a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36813a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36812a = sparseIntArray;
        sparseIntArray.put(R.id.fl_container, 4);
    }

    public WorksActivityThisSchoolBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f13958a, f36812a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Integer value;
        Integer value2;
        int iSafeUnbox;
        long j2;
        a aVarA;
        synchronized (this) {
            j = this.f13959a;
            this.f13959a = 0L;
        }
        ThisSchoolVM thisSchoolVM = ((WorksActivityThisSchoolBinding) this).f13957a;
        ThisSchoolActivity.a aVar = ((WorksActivityThisSchoolBinding) this).f13956a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataI = thisSchoolVM != null ? thisSchoolVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataJ = thisSchoolVM != null ? thisSchoolVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) != 0) {
                BaseViewModel.b bVarE = thisSchoolVM != null ? thisSchoolVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            }
            j2 = 48 & j;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f13961a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f13961a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((44 & j) != 0) {
                CommonBindingAdapter.O(this.c, 0, iSafeUnbox, 0, 0, null);
            }
            if ((42 & j) != 0) {
                CommonBindingAdapter.V(this.f13960a, value2);
            }
            if ((j & 41) != 0) {
                CommonBindingAdapter.Y(((WorksActivityThisSchoolBinding) this).f13955a, value);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((WorksActivityThisSchoolBinding) this).f13955a, aVarA, null);
            }
        }
        value = null;
        value2 = null;
        iSafeUnbox = 0;
        j2 = 48 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.O(this.c, 0, iSafeUnbox, 0, 0, null);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.V(this.f13960a, value2);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.Y(((WorksActivityThisSchoolBinding) this).f13955a, value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((WorksActivityThisSchoolBinding) this).f13955a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13959a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13959a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityThisSchoolBinding
    public void l(@Nullable ThisSchoolActivity.a Click) {
        ((WorksActivityThisSchoolBinding) this).f13956a = Click;
        synchronized (this) {
            this.f13959a |= 16;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityThisSchoolBinding
    public void m(@Nullable ThisSchoolVM Vm) {
        ((WorksActivityThisSchoolBinding) this).f13957a = Vm;
        synchronized (this) {
            this.f13959a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmBackTint, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13959a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmTitleColor, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13959a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return p((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13959a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((ThisSchoolVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((ThisSchoolActivity.a) variable);
        }
        return true;
    }

    public WorksActivityThisSchoolBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (FrameLayout) bindings[4], (ImageView) bindings[2]);
        this.f13959a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) bindings[1];
        this.c = frameLayout2;
        frameLayout2.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.f13960a = textView;
        textView.setTag(null);
        ((WorksActivityThisSchoolBinding) this).f13955a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
