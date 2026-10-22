package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonAdapter;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonVM;
import com.noober.background.view.BLButton;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogCancelReasonBindingImpl extends MallDialogCancelReasonBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10513a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10520a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CancelReasonDialog.a f34899a;

        public a a(CancelReasonDialog.a aVar) {
            this.f34899a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34899a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CancelReasonDialog.a f34900a;

        public b a(CancelReasonDialog.a aVar) {
            this.f34900a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34900a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34898a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
    }

    public MallDialogCancelReasonBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10513a, f34898a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CancelReasonAdapter value;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f10514a;
            this.f10514a = 0L;
        }
        CancelReasonVM cancelReasonVM = ((MallDialogCancelReasonBinding) this).f10512a;
        CancelReasonDialog.a aVar = ((MallDialogCancelReasonBinding) this).f10511a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<CancelReasonAdapter> mutableLiveDataI = cancelReasonVM != null ? cancelReasonVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f10519a;
            if (bVar == null) {
                bVar = new b();
                this.f10519a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10518a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10518a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10515a, aVarA, null);
            CommonBindingAdapter.q(this.f10520a, bVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f10517a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10514a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10514a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogCancelReasonBinding
    public void l(@Nullable CancelReasonDialog.a aVar) {
        ((MallDialogCancelReasonBinding) this).f10511a = aVar;
        synchronized (this) {
            this.f10514a |= 4;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogCancelReasonBinding
    public void m(@Nullable CancelReasonVM cancelReasonVM) {
        ((MallDialogCancelReasonBinding) this).f10512a = cancelReasonVM;
        synchronized (this) {
            this.f10514a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<CancelReasonAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10514a |= 1;
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
        if (hk0.p0 == i) {
            m((CancelReasonVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((CancelReasonDialog.a) obj);
        }
        return true;
    }

    public MallDialogCancelReasonBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[4]);
        this.f10514a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10516a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10515a = imageView;
        imageView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f10517a = recyclerView;
        recyclerView.setTag(null);
        BLButton bLButton = (BLButton) objArr[3];
        this.f10520a = bLButton;
        bLButton.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
