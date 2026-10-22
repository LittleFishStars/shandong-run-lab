package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.adapter.ReceiveSysGiftAdapter;
import com.huachenjie.social_contact.dialog.ReceiveSysGiftDialog;
import com.huachenjie.social_contact.vm.ReceiveSysGiftVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogReceiveSysGiftBindingImpl extends DialogReceiveSysGiftBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12907a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12910a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12911a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReceiveSysGiftDialog.a f36156a;

        public a a(ReceiveSysGiftDialog.a aVar) {
            this.f36156a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36156a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36155a = sparseIntArray;
        sparseIntArray.put(R.id.rlBg, 3);
        sparseIntArray.put(R.id.tvTitle, 4);
    }

    public DialogReceiveSysGiftBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12907a, f36155a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ReceiveSysGiftAdapter value;
        a aVarA;
        synchronized (this) {
            j = this.f12908a;
            this.f12908a = 0L;
        }
        ReceiveSysGiftVM receiveSysGiftVM = ((DialogReceiveSysGiftBinding) this).f12906a;
        ReceiveSysGiftDialog.a aVar = ((DialogReceiveSysGiftBinding) this).f12905a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<ReceiveSysGiftAdapter> mutableLiveDataH = receiveSysGiftVM != null ? receiveSysGiftVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            if (mutableLiveDataH != null) {
                value = mutableLiveDataH.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f12911a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12911a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f12909a, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((DialogReceiveSysGiftBinding) this).f12903a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12908a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12908a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogReceiveSysGiftBinding
    public void l(@Nullable ReceiveSysGiftDialog.a aVar) {
        ((DialogReceiveSysGiftBinding) this).f12905a = aVar;
        synchronized (this) {
            this.f12908a |= 4;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogReceiveSysGiftBinding
    public void m(@Nullable ReceiveSysGiftVM receiveSysGiftVM) {
        ((DialogReceiveSysGiftBinding) this).f12906a = receiveSysGiftVM;
        synchronized (this) {
            this.f12908a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ReceiveSysGiftAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12908a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((ReceiveSysGiftVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((ReceiveSysGiftDialog.a) obj);
        }
        return true;
    }

    public DialogReceiveSysGiftBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[2], (ShadowConstraintLayout) objArr[3], (TextView) objArr[4]);
        this.f12908a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12910a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f12909a = imageView;
        imageView.setTag(null);
        ((DialogReceiveSysGiftBinding) this).f12903a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
