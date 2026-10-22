package com.huachenjie.base.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
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
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM;
import com.huachenjie.base.aliyun.detect_face.DetectFaceCheckFragment;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectFaceCheckBindingImpl extends FragmentDetectFaceCheckBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7065a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetectFaceCheckFragment.a f32841a;

        public a a(DetectFaceCheckFragment.a value) {
            this.f32841a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32841a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f7062a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32840a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.base.R.id.tv_tips, 4);
        sparseIntArray.put(com.huachenjie.base.R.id.m_preview_view, 5);
        sparseIntArray.put(com.huachenjie.base.R.id.round_rect, 6);
        sparseIntArray.put(com.huachenjie.base.R.id.tv_bottom_tip, 7);
        sparseIntArray.put(com.huachenjie.base.R.id.iv_face_check_tip, 8);
    }

    public FragmentDetectFaceCheckBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, f7062a, f32840a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        BindingTitleBean value3;
        boolean zIsEmpty;
        long j2;
        a aVarA;
        synchronized (this) {
            j = this.f7063a;
            this.f7063a = 0L;
        }
        DetectFaceAuthVM detectFaceAuthVM = ((FragmentDetectFaceCheckBinding) this).f7058a;
        DetectFaceCheckFragment.a aVar = ((FragmentDetectFaceCheckBinding) this).f7059a;
        if ((87 & j) != 0) {
            if ((j & 81) == 0) {
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
            if ((j & 82) == 0) {
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
            if ((j & 84) != 0) {
                MutableLiveData<String> mutableLiveDataL = detectFaceAuthVM != null ? detectFaceAuthVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                zIsEmpty = true ^ TextUtils.isEmpty(value);
            } else {
                value = null;
            }
            j2 = j & 96;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f7065a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f7065a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((j & 81) != 0) {
                TextViewBindingAdapter.setText(((FragmentDetectFaceCheckBinding) this).f7061a, value2);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(((FragmentDetectFaceCheckBinding) this).f7061a, aVarA, null);
            }
            if ((82 & j) != 0) {
                ((FragmentDetectFaceCheckBinding) this).f7060a.k(value3);
            }
            if ((j & 84) != 0) {
                CommonBindingAdapter.l0(this.b, zIsEmpty);
                TextViewBindingAdapter.setText(this.b, value);
            }
            ViewDataBinding.executeBindingsOn(((FragmentDetectFaceCheckBinding) this).f7060a);
        }
        value = null;
        value2 = null;
        value3 = null;
        zIsEmpty = false;
        j2 = j & 96;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((j & 81) != 0) {
            TextViewBindingAdapter.setText(((FragmentDetectFaceCheckBinding) this).f7061a, value2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((FragmentDetectFaceCheckBinding) this).f7061a, aVarA, null);
        }
        if ((82 & j) != 0) {
            ((FragmentDetectFaceCheckBinding) this).f7060a.k(value3);
        }
        if ((j & 84) != 0) {
            CommonBindingAdapter.l0(this.b, zIsEmpty);
            TextViewBindingAdapter.setText(this.b, value);
        }
        ViewDataBinding.executeBindingsOn(((FragmentDetectFaceCheckBinding) this).f7060a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7063a != 0) {
                return true;
            }
            return ((FragmentDetectFaceCheckBinding) this).f7060a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7063a = 64L;
        }
        ((FragmentDetectFaceCheckBinding) this).f7060a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceCheckBinding
    public void l(@Nullable DetectFaceCheckFragment.a Click) {
        ((FragmentDetectFaceCheckBinding) this).f7059a = Click;
        synchronized (this) {
            this.f7063a |= 32;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceCheckBinding
    public void m(@Nullable DetectFaceAuthVM Vm) {
        ((FragmentDetectFaceCheckBinding) this).f7058a = Vm;
        synchronized (this) {
            this.f7063a |= 16;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7063a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmCountdownText, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7063a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return n((LayoutToolbarBindingBinding) object, fieldId);
    }

    public final boolean p(MutableLiveData<String> VmDetectText, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7063a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7063a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((FragmentDetectFaceCheckBinding) this).f7060a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((DetectFaceAuthVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((DetectFaceCheckFragment.a) variable);
        }
        return true;
    }

    public FragmentDetectFaceCheckBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (BLTextView) bindings[2], (ImageView) bindings[8], (PreviewView) bindings[5], (View) bindings[6], (LayoutToolbarBindingBinding) bindings[3], (TextView) bindings[7], (TextView) bindings[1], (TextView) bindings[4]);
        this.f7063a = -1L;
        ((FragmentDetectFaceCheckBinding) this).f7061a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f7064a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((FragmentDetectFaceCheckBinding) this).f7060a);
        this.b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
