package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.aliyun.detect_face.DetectFaceUploadFragment;
import com.huachenjie.base.aliyun.detect_face.DetectFaceUploadVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectFaceUploadBindingImpl extends FragmentDetectFaceUploadBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7091a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetectFaceUploadFragment.a f32850a;

        public a a(DetectFaceUploadFragment.a value) {
            this.f32850a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32850a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f7088a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32849a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.base.R.id.m_preview_view, 3);
        sparseIntArray.put(com.huachenjie.base.R.id.round_rect, 4);
        sparseIntArray.put(com.huachenjie.base.R.id.tv_bottom_tip, 5);
    }

    public FragmentDetectFaceUploadBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f7088a, f32849a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        a aVarA;
        synchronized (this) {
            j = this.f7089a;
            this.f7089a = 0L;
        }
        DetectFaceUploadVM detectFaceUploadVM = ((FragmentDetectFaceUploadBinding) this).f7085a;
        DetectFaceUploadFragment.a aVar = ((FragmentDetectFaceUploadBinding) this).f7084a;
        long j2 = 21 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = detectFaceUploadVM != null ? detectFaceUploadVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 24;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7091a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7091a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((FragmentDetectFaceUploadBinding) this).f7087a, aVarA, null);
        }
        if (j2 != 0) {
            ((FragmentDetectFaceUploadBinding) this).f7086a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((FragmentDetectFaceUploadBinding) this).f7086a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7089a != 0) {
                return true;
            }
            return ((FragmentDetectFaceUploadBinding) this).f7086a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7089a = 16L;
        }
        ((FragmentDetectFaceUploadBinding) this).f7086a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceUploadBinding
    public void l(@Nullable DetectFaceUploadFragment.a Click) {
        ((FragmentDetectFaceUploadBinding) this).f7084a = Click;
        synchronized (this) {
            this.f7089a |= 8;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceUploadBinding
    public void m(@Nullable DetectFaceUploadVM Vm) {
        ((FragmentDetectFaceUploadBinding) this).f7085a = Vm;
        synchronized (this) {
            this.f7089a |= 4;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7089a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7089a |= 1;
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
        return n((LayoutToolbarBindingBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((FragmentDetectFaceUploadBinding) this).f7086a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((DetectFaceUploadVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((DetectFaceUploadFragment.a) variable);
        }
        return true;
    }

    public FragmentDetectFaceUploadBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (BLTextView) bindings[1], (PreviewView) bindings[3], (View) bindings[4], (LayoutToolbarBindingBinding) bindings[2], (TextView) bindings[5]);
        this.f7089a = -1L;
        ((FragmentDetectFaceUploadBinding) this).f7087a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f7090a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((FragmentDetectFaceUploadBinding) this).f7086a);
        setRootTag(root);
        invalidateAll();
    }
}
