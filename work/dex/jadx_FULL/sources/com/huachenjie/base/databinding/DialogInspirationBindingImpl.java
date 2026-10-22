package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.inspiration.InspirationDialog;
import com.huachenjie.base.dialog.inspiration.InspirationVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DialogInspirationBindingImpl extends DialogInspirationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7001a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f7004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f7008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7009a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InspirationDialog.a f32819a;

        public a a(InspirationDialog.a value) {
            this.f32819a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32819a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InspirationDialog.a f32820a;

        public b a(InspirationDialog.a value) {
            this.f32820a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32820a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InspirationDialog.a f32821a;

        public c a(InspirationDialog.a value) {
            this.f32821a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f32821a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32818a = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 6);
        sparseIntArray.put(R.id.ll_content, 7);
    }

    public DialogInspirationBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, f7001a, f32818a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String value;
        b bVarA;
        c cVarA;
        a aVarA;
        synchronized (this) {
            j = this.f7002a;
            this.f7002a = 0L;
        }
        InspirationVM inspirationVM = ((DialogInspirationBinding) this).f7000a;
        InspirationDialog.a aVar = ((DialogInspirationBinding) this).f6999a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataI = inspirationVM != null ? inspirationVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<Integer> mutableLiveDataH = inspirationVM != null ? inspirationVM.h() : null;
                updateLiveDataRegistration(1, mutableLiveDataH);
                str = String.format("闪金币x%d", mutableLiveDataH != null ? mutableLiveDataH.getValue() : null);
            } else {
                str = null;
            }
        } else {
            str = null;
            value = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        } else {
            c cVar = this.f7008a;
            if (cVar == null) {
                cVar = new c();
                this.f7008a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f7006a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7006a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f7007a;
            if (bVar == null) {
                bVar = new b();
                this.f7007a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(super.b, cVarA, null);
            CommonBindingAdapter.q(this.f7003a, cVarA, null);
            CommonBindingAdapter.q(this.f7005a, bVarA, null);
            CommonBindingAdapter.q(this.f7009a, aVarA, null);
        }
        if ((j & 21) != 0) {
            TextViewBindingAdapter.setText(this.f7004a, value);
        }
        if ((j & 22) != 0) {
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7002a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7002a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogInspirationBinding
    public void l(@Nullable InspirationDialog.a Click) {
        ((DialogInspirationBinding) this).f6999a = Click;
        synchronized (this) {
            this.f7002a |= 8;
        }
        notifyPropertyChanged(sk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogInspirationBinding
    public void m(@Nullable InspirationVM Vm) {
        ((DialogInspirationBinding) this).f7000a = Vm;
        synchronized (this) {
            this.f7002a |= 4;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmInspirationValue, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7002a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmTitle, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7002a |= 1;
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
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 == variableId) {
            m((InspirationVM) variable);
        } else {
            if (sk0.k != variableId) {
                return false;
            }
            l((InspirationDialog.a) variable);
        }
        return true;
    }

    public DialogInspirationBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ImageView) bindings[6], (ImageView) bindings[5], (LinearLayout) bindings[7]);
        this.f7002a = -1L;
        super.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f7003a = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.f7005a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[2];
        this.f7004a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[3];
        this.b = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[4];
        this.f7009a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
