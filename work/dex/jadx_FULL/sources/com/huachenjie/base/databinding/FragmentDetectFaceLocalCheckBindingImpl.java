package com.huachenjie.base.databinding;

import android.text.Spanned;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.core.text.HtmlCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.aliyun.detect_face.DetectFaceAuthVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FragmentDetectFaceLocalCheckBindingImpl extends FragmentDetectFaceLocalCheckBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7073a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f7071a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32843a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.base.R.id.m_preview_view, 4);
        sparseIntArray.put(com.huachenjie.base.R.id.tv_action_tips, 5);
        sparseIntArray.put(com.huachenjie.base.R.id.round_rect, 6);
    }

    public FragmentDetectFaceLocalCheckBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f7071a, f32843a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:31:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ?? r6;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f7072a;
            this.f7072a = 0L;
        }
        DetectFaceAuthVM detectFaceAuthVM = ((FragmentDetectFaceLocalCheckBinding) this).f7068a;
        boolean z = false;
        BindingTitleBean bindingTitleBean = null;
        Spanned spannedFromHtml = null;
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = detectFaceAuthVM != null ? detectFaceAuthVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 26) != 0) {
                MutableLiveData<String> mutableLiveDataL = detectFaceAuthVM != null ? detectFaceAuthVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                String value2 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                String string = this.b.getResources().getString(com.huachenjie.base.R.string.detect_face_local_check_warm_tip_html, value2);
                boolean zIsEmpty = TextUtils.isEmpty(value2);
                spannedFromHtml = HtmlCompat.fromHtml(string, 0);
                z = !zIsEmpty;
                String str = value2;
                bindingTitleBean = value;
                r6 = str;
            } else {
                bindingTitleBean = value;
            }
            if ((25 & j) != 0) {
                ((FragmentDetectFaceLocalCheckBinding) this).f7069a.k(bindingTitleBean);
            }
            if ((j & 26) != 0) {
                TextViewBindingAdapter.setText(this.b, spannedFromHtml);
                CommonBindingAdapter.l0(((FragmentDetectFaceLocalCheckBinding) this).f7070a, z);
                TextViewBindingAdapter.setText(((FragmentDetectFaceLocalCheckBinding) this).f7070a, r6);
            }
            ViewDataBinding.executeBindingsOn(((FragmentDetectFaceLocalCheckBinding) this).f7069a);
        }
        r6 = bindingTitleBean;
        if ((25 & j) != 0) {
            ((FragmentDetectFaceLocalCheckBinding) this).f7069a.k(bindingTitleBean);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.b, spannedFromHtml);
            CommonBindingAdapter.l0(((FragmentDetectFaceLocalCheckBinding) this).f7070a, z);
            TextViewBindingAdapter.setText(((FragmentDetectFaceLocalCheckBinding) this).f7070a, r6);
        }
        ViewDataBinding.executeBindingsOn(((FragmentDetectFaceLocalCheckBinding) this).f7069a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7072a != 0) {
                return true;
            }
            return ((FragmentDetectFaceLocalCheckBinding) this).f7069a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7072a = 16L;
        }
        ((FragmentDetectFaceLocalCheckBinding) this).f7069a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.FragmentDetectFaceLocalCheckBinding
    public void k(@Nullable DetectFaceAuthVM Vm) {
        ((FragmentDetectFaceLocalCheckBinding) this).f7068a = Vm;
        synchronized (this) {
            this.f7072a |= 8;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding TitleBar, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7072a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> VmCountdownText, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7072a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7072a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((FragmentDetectFaceLocalCheckBinding) this).f7069a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 != variableId) {
            return false;
        }
        k((DetectFaceAuthVM) variable);
        return true;
    }

    public FragmentDetectFaceLocalCheckBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (PreviewView) bindings[4], (View) bindings[6], (LayoutToolbarBindingBinding) bindings[3], (TextView) bindings[5], (TextView) bindings[2], (BLTextView) bindings[1]);
        this.f7072a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f7073a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((FragmentDetectFaceLocalCheckBinding) this).f7069a);
        this.b.setTag(null);
        ((FragmentDetectFaceLocalCheckBinding) this).f7070a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
