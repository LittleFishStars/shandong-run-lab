package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import com.huachenjie.mine.page.dressing_table.signature.SignatureVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentDressingTableSignatureBindingImpl extends MineFragmentDressingTableSignatureBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35314a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11242a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f11244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f11247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11249a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(MineFragmentDressingTableSignatureBindingImpl.this.f11244a);
            SignatureVM signatureVM = ((MineFragmentDressingTableSignatureBinding) MineFragmentDressingTableSignatureBindingImpl.this).f11241a;
            if (signatureVM != null) {
                MutableLiveData<String> mutableLiveDataJ = signatureVM.j();
                if (mutableLiveDataJ != null) {
                    mutableLiveDataJ.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SignatureFragment.a f35316a;

        public b a(SignatureFragment.a aVar) {
            this.f35316a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35316a.a(view);
        }
    }

    public MineFragmentDressingTableSignatureBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f11242a, f35314a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        b bVarA;
        synchronized (this) {
            j = this.f11243a;
            this.f11243a = 0L;
        }
        SignatureVM signatureVM = ((MineFragmentDressingTableSignatureBinding) this).f11241a;
        SignatureFragment.a aVar = ((MineFragmentDressingTableSignatureBinding) this).f35313a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = signatureVM != null ? signatureVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataK = signatureVM != null ? signatureVM.k() : null;
                updateLiveDataRegistration(1, mediatorLiveDataK);
                if (mediatorLiveDataK != null) {
                    value = mediatorLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f11248a;
            if (bVar == null) {
                bVar = new b();
                this.f11248a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(this.f11244a, value2);
        }
        if ((16 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.f11244a, null, null, null, this.f11247a);
        }
        if ((j & 22) != 0) {
            TextViewBindingAdapter.setText(this.f11246a, value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11249a, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11243a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11243a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentDressingTableSignatureBinding
    public void l(@Nullable SignatureFragment.a aVar) {
        ((MineFragmentDressingTableSignatureBinding) this).f35313a = aVar;
        synchronized (this) {
            this.f11243a |= 8;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentDressingTableSignatureBinding
    public void m(@Nullable SignatureVM signatureVM) {
        ((MineFragmentDressingTableSignatureBinding) this).f11241a = signatureVM;
        synchronized (this) {
            this.f11243a |= 4;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11243a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return p((MediatorLiveData) obj, i2);
    }

    public final boolean p(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11243a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((SignatureVM) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((SignatureFragment.a) obj);
        }
        return true;
    }

    public MineFragmentDressingTableSignatureBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f11247a = new a();
        this.f11243a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f11245a = relativeLayout;
        relativeLayout.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.f11244a = editText;
        editText.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f11246a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f11249a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
