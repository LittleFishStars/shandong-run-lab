package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.pay.PayDialog;
import com.huachenjie.mall.dialog.pay.PayVM;
import com.noober.background.view.BLButton;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogPayBindingImpl extends MallDialogPayBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10607a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10613a;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayDialog.a f34929a;

        public a a(PayDialog.a aVar) {
            this.f34929a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34929a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayDialog.a f34930a;

        public b a(PayDialog.a aVar) {
            this.f34930a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34930a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34928a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 7);
        sparseIntArray.put(R.id.rg_menu, 8);
    }

    public MallDialogPayBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f10607a, f34928a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    /* JADX WARN: Code duplicated, block: B:47:0x009b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CharSequence value;
        String value2;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean zSafeUnbox3;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f10608a;
            this.f10608a = 0L;
        }
        PayVM payVM = ((MallDialogPayBinding) this).f10605a;
        PayDialog.a aVar = ((MallDialogPayBinding) this).f10604a;
        if ((191 & j) != 0) {
            if ((j & 161) == 0) {
                value = null;
            } else {
                MutableLiveData<CharSequence> mutableLiveDataL = payVM != null ? payVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 162) != 0) {
                MutableLiveData<Boolean> mutableLiveDataQ = payVM != null ? payVM.q() : null;
                updateLiveDataRegistration(1, mutableLiveDataQ);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 164) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = payVM != null ? payVM.p() : null;
                updateLiveDataRegistration(2, mutableLiveDataP);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox3 = false;
            }
            if ((j & 168) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = payVM != null ? payVM.o() : null;
                updateLiveDataRegistration(3, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 176) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = payVM != null ? payVM.m() : null;
                updateLiveDataRegistration(4, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null)));
            } else {
                zSafeUnbox = false;
            }
        } else {
            value = null;
            value2 = null;
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            zSafeUnbox3 = false;
        }
        long j2 = j & 192;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10612a;
            if (bVar == null) {
                bVar = new b();
                this.f10612a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10611a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10611a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10609a, aVarA, null);
            CommonBindingAdapter.q(this.f10613a, bVarA, null);
        }
        if ((j & 161) != 0) {
            TextViewBindingAdapter.setText(this.c, value);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.e0(this.f10613a, zSafeUnbox);
        }
        if ((164 & j) != 0) {
            CommonBindingAdapter.l0(((MallDialogPayBinding) this).f34927a, zSafeUnbox3);
        }
        if ((162 & j) != 0) {
            CommonBindingAdapter.l0(((MallDialogPayBinding) this).b, zSafeUnbox2);
        }
        if ((128 & j) != 0) {
            CommonBindingAdapter.C(((MallDialogPayBinding) this).f10603a, true);
        }
        if ((j & 168) != 0) {
            TextViewBindingAdapter.setText(((MallDialogPayBinding) this).f10603a, value2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10608a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10608a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogPayBinding
    public void l(@Nullable PayDialog.a aVar) {
        ((MallDialogPayBinding) this).f10604a = aVar;
        synchronized (this) {
            this.f10608a |= 64;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogPayBinding
    public void m(@Nullable PayVM payVM) {
        ((MallDialogPayBinding) this).f10605a = payVM;
        synchronized (this) {
            this.f10608a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<CharSequence> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10608a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10608a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10608a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10608a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10608a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((PayVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((PayDialog.a) obj);
        }
        return true;
    }

    public MallDialogPayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RadioButton) objArr[4], (RadioButton) objArr[5], (RadioGroup) objArr[8], (TextView) objArr[2], (TextView) objArr[7]);
        this.f10608a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10610a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10609a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.c = textView;
        textView.setTag(null);
        BLButton bLButton = (BLButton) objArr[6];
        this.f10613a = bLButton;
        bLButton.setTag(null);
        ((MallDialogPayBinding) this).f34927a.setTag(null);
        ((MallDialogPayBinding) this).b.setTag(null);
        ((MallDialogPayBinding) this).f10603a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
