package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.BuySuccessDialog;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DialogBuySuccessBindingImpl extends DialogBuySuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12845a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12848a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BuySuccessDialog.a f36129a;

        public a a(BuySuccessDialog.a aVar) {
            this.f36129a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36129a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36128a = sparseIntArray;
        sparseIntArray.put(R.id.tvStarDrill, 1);
    }

    public DialogBuySuccessBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f12845a, f36128a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f12846a;
            this.f12846a = 0L;
        }
        BuySuccessDialog.a aVar = ((DialogBuySuccessBinding) this).f12844a;
        long j2 = j & 3;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f12848a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12848a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f12847a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12846a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12846a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.DialogBuySuccessBinding
    public void k(@Nullable BuySuccessDialog.a aVar) {
        ((DialogBuySuccessBinding) this).f12844a = aVar;
        synchronized (this) {
            this.f12846a |= 1;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.k != i) {
            return false;
        }
        k((BuySuccessDialog.a) obj);
        return true;
    }

    public DialogBuySuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[1]);
        this.f12846a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12847a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
