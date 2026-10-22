package com.huachenjie.base.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthFragment;
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectFaceAuthBindingImpl extends FragmentDetectFaceAuthBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7047a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7048a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7049a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7051a;

    @NonNull
    public final LinearLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetectFaceAuthFragment.a f32836a;

        public a a(DetectFaceAuthFragment.a value) {
            this.f32836a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32836a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f7046a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32835a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.base.R.id.tv_tips, 7);
        sparseIntArray.put(com.huachenjie.base.R.id.m_preview_view, 8);
        sparseIntArray.put(com.huachenjie.base.R.id.round_rect, 9);
    }

    public FragmentDetectFaceAuthBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f7046a, f32835a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fa  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        BindingTitleBean value3;
        boolean z;
        boolean zIsEmpty;
        long j2;
        a aVarA;
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.f7047a;
            this.f7047a = 0L;
        }
        DetectFaceAuthVM detectFaceAuthVM = ((FragmentDetectFaceAuthBinding) this).f7043a;
        DetectFaceAuthFragment.a aVar = ((FragmentDetectFaceAuthBinding) this).f7042a;
        if ((175 & j) != 0) {
            if ((j & 161) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataM = detectFaceAuthVM != null ? detectFaceAuthVM.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value2 = mutableLiveDataM.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 162) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = detectFaceAuthVM != null ? detectFaceAuthVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 164) != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = detectFaceAuthVM != null ? detectFaceAuthVM.n() : null;
                updateLiveDataRegistration(2, mutableLiveDataN);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 168) != 0) {
                MutableLiveData<String> mutableLiveDataL = detectFaceAuthVM != null ? detectFaceAuthVM.l() : null;
                updateLiveDataRegistration(3, mutableLiveDataL);
                value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                boolean z2 = zSafeUnbox;
                zIsEmpty = true ^ TextUtils.isEmpty(value);
                z = z2;
            } else {
                value = null;
                z = zSafeUnbox;
            }
            j2 = j & 192;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f7050a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f7050a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((j & 161) != 0) {
                TextViewBindingAdapter.setText(((FragmentDetectFaceAuthBinding) this).f7045a, value2);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((FragmentDetectFaceAuthBinding) this).f7045a, aVarA, null);
            }
            if ((164 & j) != 0) {
                CommonBindingAdapter.l0(this.f7051a, z);
                CommonBindingAdapter.l0(this.b, z);
            }
            if ((162 & j) != 0) {
                ((FragmentDetectFaceAuthBinding) this).f7044a.k(value3);
            }
            if ((j & 168) != 0) {
                CommonBindingAdapter.l0(((FragmentDetectFaceAuthBinding) this).f7040a, zIsEmpty);
                TextViewBindingAdapter.setText(((FragmentDetectFaceAuthBinding) this).f7040a, value);
            }
            ViewDataBinding.executeBindingsOn(((FragmentDetectFaceAuthBinding) this).f7044a);
        }
        value = null;
        value2 = null;
        value3 = null;
        z = false;
        zIsEmpty = false;
        j2 = j & 192;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((j & 161) != 0) {
            TextViewBindingAdapter.setText(((FragmentDetectFaceAuthBinding) this).f7045a, value2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((FragmentDetectFaceAuthBinding) this).f7045a, aVarA, null);
        }
        if ((164 & j) != 0) {
            CommonBindingAdapter.l0(this.f7051a, z);
            CommonBindingAdapter.l0(this.b, z);
        }
        if ((162 & j) != 0) {
            ((FragmentDetectFaceAuthBinding) this).f7044a.k(value3);
        }
        if ((j & 168) != 0) {
            CommonBindingAdapter.l0(((FragmentDetectFaceAuthBinding) this).f7040a, zIsEmpty);
            TextViewBindingAdapter.setText(((FragmentDetectFaceAuthBinding) this).f7040a, value);
        }
        ViewDataBinding.executeBindingsOn(((FragmentDetectFaceAuthBinding) this).f7044a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7047a != 0) {
                return true;
            }
            return ((FragmentDetectFaceAuthBinding) this).f7044a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7047a = 128L;
        }
        ((FragmentDetectFaceAuthBinding) this).f7044a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceAuthBinding
    public void l(@Nullable DetectFaceAuthFragment.a Click) {
        ((FragmentDetectFaceAuthBinding) this).f7042a = Click;
        synchronized (this) {
            this.f7047a |= 64;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceAuthBinding
    public void m(@Nullable DetectFaceAuthVM Vm) {
        ((FragmentDetectFaceAuthBinding) this).f7043a = Vm;
        synchronized (this) {
            this.f7047a |= 32;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7047a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmCountdownText, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7047a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return n((LayoutToolbarBindingBinding) object, fieldId);
    }

    public final boolean p(MutableLiveData<String> VmDetectText, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7047a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmShowButton, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7047a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7047a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((FragmentDetectFaceAuthBinding) this).f7044a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((DetectFaceAuthVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((DetectFaceAuthFragment.a) variable);
        }
        return true;
    }

    public FragmentDetectFaceAuthBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (BLTextView) bindings[5], (PreviewView) bindings[8], (View) bindings[9], (LayoutToolbarBindingBinding) bindings[6], (TextView) bindings[2], (TextView) bindings[7]);
        this.f7047a = -1L;
        ((FragmentDetectFaceAuthBinding) this).f7045a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f7048a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.f7049a = linearLayout;
        linearLayout.setTag(null);
        BLView bLView = (BLView) bindings[3];
        this.f7051a = bLView;
        bLView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[4];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        setContainedBinding(((FragmentDetectFaceAuthBinding) this).f7044a);
        ((FragmentDetectFaceAuthBinding) this).f7040a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
