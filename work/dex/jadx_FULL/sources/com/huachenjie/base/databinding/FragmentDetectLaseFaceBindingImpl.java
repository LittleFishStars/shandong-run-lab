package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.aliyun.detect_face.DetectLastFaceFragment;
import com.huachenjie.base.aliyun.detect_face.DetectLastFaceVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectLaseFaceBindingImpl extends FragmentDetectLaseFaceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7097a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7101a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetectLastFaceFragment.a f32853a;

        public a a(DetectLastFaceFragment.a value) {
            this.f32853a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32853a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DetectLastFaceFragment.a f32854a;

        public b a(DetectLastFaceFragment.a value) {
            this.f32854a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32854a.a(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f7096a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32852a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.base.R.id.round_rect, 5);
    }

    public FragmentDetectLaseFaceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, f7096a, f32852a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        BindingTitleBean value2;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f7097a;
            this.f7097a = 0L;
        }
        DetectLastFaceVM detectLastFaceVM = ((FragmentDetectLaseFaceBinding) this).f7093a;
        DetectLastFaceFragment.a aVar = ((FragmentDetectLaseFaceBinding) this).f7092a;
        long j2 = 42 & j;
        RequestOptions requestOptions = j2 != 0 ? ju3.h : null;
        if ((43 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = detectLastFaceVM != null ? detectLastFaceVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if (j2 == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = detectLastFaceVM != null ? detectLastFaceVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j3 = 48 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f7101a;
            if (bVar == null) {
                bVar = new b();
                this.f7101a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f7100a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7100a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((FragmentDetectLaseFaceBinding) this).f7095a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f7098a, value, requestOptions, false);
        }
        if ((j & 41) != 0) {
            ((FragmentDetectLaseFaceBinding) this).f7094a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((FragmentDetectLaseFaceBinding) this).f7094a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7097a != 0) {
                return true;
            }
            return ((FragmentDetectLaseFaceBinding) this).f7094a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7097a = 32L;
        }
        ((FragmentDetectLaseFaceBinding) this).f7094a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectLaseFaceBinding
    public void l(@Nullable DetectLastFaceFragment.a Click) {
        ((FragmentDetectLaseFaceBinding) this).f7092a = Click;
        synchronized (this) {
            this.f7097a |= 16;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectLaseFaceBinding
    public void m(@Nullable DetectLastFaceVM Vm) {
        ((FragmentDetectLaseFaceBinding) this).f7093a = Vm;
        synchronized (this) {
            this.f7097a |= 8;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7097a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmLastBaseFaceUrl, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7097a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return n((LayoutToolbarBindingBinding) object, fieldId);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7097a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((FragmentDetectLaseFaceBinding) this).f7094a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((DetectLastFaceVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((DetectLastFaceFragment.a) variable);
        }
        return true;
    }

    public FragmentDetectLaseFaceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (BLTextView) bindings[3], (BLTextView) bindings[2], (View) bindings[5], (LayoutToolbarBindingBinding) bindings[4]);
        this.f7097a = -1L;
        ((FragmentDetectLaseFaceBinding) this).f7095a.setTag(null);
        this.b.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f7099a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[1];
        this.f7098a = imageView;
        imageView.setTag(null);
        setContainedBinding(((FragmentDetectLaseFaceBinding) this).f7094a);
        setRootTag(root);
        invalidateAll();
    }
}
