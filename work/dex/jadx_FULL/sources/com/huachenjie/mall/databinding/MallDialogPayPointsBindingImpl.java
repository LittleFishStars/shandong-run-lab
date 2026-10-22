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
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.pay_points.PayPointsDialog;
import com.huachenjie.mall.dialog.pay_points.PayPointsVM;
import com.noober.background.view.BLButton;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogPayPointsBindingImpl extends MallDialogPayPointsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10616a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10622a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayPointsDialog.a f34933a;

        public a a(PayPointsDialog.a aVar) {
            this.f34933a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34933a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayPointsDialog.a f34934a;

        public b a(PayPointsDialog.a aVar) {
            this.f34934a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34934a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34932a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
    }

    public MallDialogPayPointsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10616a, f34932a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f10617a;
            this.f10617a = 0L;
        }
        PayPointsVM payPointsVM = ((MallDialogPayPointsBinding) this).f10615a;
        PayPointsDialog.a aVar = ((MallDialogPayPointsBinding) this).f10614a;
        long j2 = 11 & j;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveDataI = payPointsVM != null ? payPointsVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            str = String.format(TimeModel.NUMBER_FORMAT, mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
        } else {
            str = null;
        }
        long j3 = 12 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10621a;
            if (bVar == null) {
                bVar = new b();
                this.f10621a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10620a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10620a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10618a, aVarA, null);
            CommonBindingAdapter.q(this.f10622a, bVarA, null);
        }
        if ((j & 8) != 0) {
            CommonBindingAdapter.C(((MallDialogPayPointsBinding) this).f34931a, true);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((MallDialogPayPointsBinding) this).f34931a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10617a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10617a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogPayPointsBinding
    public void l(@Nullable PayPointsDialog.a aVar) {
        ((MallDialogPayPointsBinding) this).f10614a = aVar;
        synchronized (this) {
            this.f10617a |= 4;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogPayPointsBinding
    public void m(@Nullable PayPointsVM payPointsVM) {
        ((MallDialogPayPointsBinding) this).f10615a = payPointsVM;
        synchronized (this) {
            this.f10617a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10617a |= 1;
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
            m((PayPointsVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((PayPointsDialog.a) obj);
        }
        return true;
    }

    public MallDialogPayPointsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[2], (TextView) objArr[4]);
        this.f10617a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10619a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10618a = imageView;
        imageView.setTag(null);
        BLButton bLButton = (BLButton) objArr[3];
        this.f10622a = bLButton;
        bLButton.setTag(null);
        ((MallDialogPayPointsBinding) this).f34931a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
