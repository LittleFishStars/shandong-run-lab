package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.aliyun.detect_face.DetectFaceNoticeFragment;
import com.huachenjie.base.aliyun.detect_face.DetectFaceNoticeVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectFaceNoticeBindingImpl extends FragmentDetectFaceNoticeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32845a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7076a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckBox f7078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f7080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7081a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = FragmentDetectFaceNoticeBindingImpl.this.f7078a.isChecked();
            DetectFaceNoticeVM detectFaceNoticeVM = ((FragmentDetectFaceNoticeBinding) FragmentDetectFaceNoticeBindingImpl.this).f7074a;
            if (detectFaceNoticeVM != null) {
                MutableLiveData<Boolean> mutableLiveDataI = detectFaceNoticeVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetectFaceNoticeFragment.a f32847a;

        public b a(DetectFaceNoticeFragment.a value) {
            this.f32847a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32847a.a(arg0);
        }
    }

    public FragmentDetectFaceNoticeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f7076a, f32845a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        b bVarA;
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.f7077a;
            this.f7077a = 0L;
        }
        DetectFaceNoticeVM detectFaceNoticeVM = ((FragmentDetectFaceNoticeBinding) this).f7074a;
        DetectFaceNoticeFragment.a aVar = ((FragmentDetectFaceNoticeBinding) this).f32844a;
        boolean z = false;
        int iSafeUnbox = 0;
        if ((23 & j) != 0) {
            if ((j & 22) != 0) {
                MutableLiveData<Boolean> mutableLiveDataI = detectFaceNoticeVM != null ? detectFaceNoticeVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = detectFaceNoticeVM != null ? detectFaceNoticeVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            }
            i = iSafeUnbox;
            z = zSafeUnbox;
        } else {
            i = 0;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f7081a;
            if (bVar == null) {
                bVar = new b();
                this.f7081a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.e0(((FragmentDetectFaceNoticeBinding) this).f7075a, z);
            CompoundButtonBindingAdapter.setChecked(this.f7078a, z);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((FragmentDetectFaceNoticeBinding) this).f7075a, bVarA, null);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.O(this.f7079a, 0, i, 0, 0, null);
        }
        if ((j & 16) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.f7078a, null, this.f7080a);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7077a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7077a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceNoticeBinding
    public void l(@Nullable DetectFaceNoticeFragment.a Click) {
        ((FragmentDetectFaceNoticeBinding) this).f32844a = Click;
        synchronized (this) {
            this.f7077a |= 8;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceNoticeBinding
    public void m(@Nullable DetectFaceNoticeVM Vm) {
        ((FragmentDetectFaceNoticeBinding) this).f7074a = Vm;
        synchronized (this) {
            this.f7077a |= 4;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<Boolean> VmMAgreement, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7077a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7077a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((DetectFaceNoticeVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((DetectFaceNoticeFragment.a) variable);
        }
        return true;
    }

    public FragmentDetectFaceNoticeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (BLTextView) bindings[2]);
        this.f7080a = new a();
        this.f7077a = -1L;
        ((FragmentDetectFaceNoticeBinding) this).f7075a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f7079a = linearLayout;
        linearLayout.setTag(null);
        CheckBox checkBox = (CheckBox) bindings[1];
        this.f7078a = checkBox;
        checkBox.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
