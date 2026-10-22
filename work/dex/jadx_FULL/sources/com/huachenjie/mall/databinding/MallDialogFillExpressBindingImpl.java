package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.huachenjie.mall.dialog.express.FillExpressDialog;
import com.huachenjie.mall.dialog.express.FillExpressVM;
import com.noober.background.view.BLButton;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogFillExpressBindingImpl extends MallDialogFillExpressBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10547a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10550a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10555a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10556b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallDialogFillExpressBinding) MallDialogFillExpressBindingImpl.this).f10542a);
            FillExpressVM fillExpressVM = ((MallDialogFillExpressBinding) MallDialogFillExpressBindingImpl.this).f10546a;
            if (fillExpressVM != null) {
                MutableLiveData<String> mutableLiveDataK = fillExpressVM.k();
                if (mutableLiveDataK != null) {
                    mutableLiveDataK.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FillExpressDialog.a f34910a;

        public b a(FillExpressDialog.a aVar) {
            this.f34910a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34910a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FillExpressDialog.a f34911a;

        public c a(FillExpressDialog.a aVar) {
            this.f34911a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34911a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FillExpressDialog.a f34912a;

        public d a(FillExpressDialog.a aVar) {
            this.f34912a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34912a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34908a = sparseIntArray;
        sparseIntArray.put(R.id.ll_content, 7);
        sparseIntArray.put(R.id.tv_title, 8);
    }

    public MallDialogFillExpressBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f10547a, f34908a));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x017d  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:84:0x011a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0122  */
    /* JADX WARN: Code duplicated, block: B:90:0x012e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0137  */
    /* JADX WARN: Code duplicated, block: B:93:0x013a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0150  */
    /* JADX WARN: Code duplicated, block: B:99:0x0170  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        int iSafeUnbox;
        String value;
        String shipperName;
        int i;
        int iSafeUnbox2;
        long j2;
        c cVarA;
        d dVarA;
        b bVarA;
        Long l;
        int i2;
        boolean z2;
        synchronized (this) {
            j = this.f10548a;
            this.f10548a = 0L;
        }
        FillExpressVM fillExpressVM = ((MallDialogFillExpressBinding) this).f10546a;
        FillExpressDialog.a aVar = ((MallDialogFillExpressBinding) this).f10545a;
        if ((95 & j) != 0) {
            long j3 = j & 81;
            if (j3 != 0) {
                MutableLiveData<ExpressCompanyBean> mutableLiveDataJ = fillExpressVM != null ? fillExpressVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                ExpressCompanyBean value2 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                z2 = value2 != null;
                shipperName = value2 != null ? value2.getShipperName() : null;
                boolean z3 = shipperName == null;
                if (j3 != 0) {
                    j |= z3 ? 256L : 128L;
                }
                i2 = z3 ? 16 : 48;
            } else {
                i2 = 0;
                z2 = false;
                shipperName = null;
            }
            if ((j & 82) != 0) {
                MutableLiveData<Integer> mutableLiveDataM = fillExpressVM != null ? fillExpressVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 84) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = fillExpressVM != null ? fillExpressVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 88) != 0) {
                BaseViewModel.b bVarE = fillExpressVM != null ? fillExpressVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(3, mutableLiveDataA);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
                i = i2;
                z = z2;
            } else {
                i = i2;
                z = z2;
            }
            j2 = j & 96;
            if (j2 != 0 || aVar == null) {
                cVarA = null;
                dVarA = null;
                bVarA = null;
            } else {
                d dVar = this.f10554a;
                if (dVar == null) {
                    dVar = new d();
                    this.f10554a = dVar;
                }
                dVarA = dVar.a(aVar);
                b bVar = this.f10552a;
                if (bVar == null) {
                    bVar = new b();
                    this.f10552a = bVar;
                }
                bVarA = bVar.a(aVar);
                c cVar = this.f10553a;
                if (cVar == null) {
                    cVar = new c();
                    this.f10553a = cVar;
                }
                cVarA = cVar.a(aVar);
            }
            if ((84 & j) != 0) {
                TextViewBindingAdapter.setText(((MallDialogFillExpressBinding) this).f10542a, value);
            }
            if ((64 & j) != 0) {
                l = null;
                TextViewBindingAdapter.setTextWatcher(((MallDialogFillExpressBinding) this).f10542a, null, null, null, this.f10551a);
            } else {
                l = null;
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f10550a, bVarA, l);
                CommonBindingAdapter.q(this.f10556b, cVarA, l);
                CommonBindingAdapter.q(this.f10555a, dVarA, l);
            }
            if ((81 & j) != 0) {
                TextViewBindingAdapter.setText(this.f10556b, shipperName);
                CommonBindingAdapter.O(this.f10556b, i, 11, 16, 11, null);
                CommonBindingAdapter.l0(this.b, z);
            }
            if ((82 & j) != 0) {
                CommonBindingAdapter.G(((MallDialogFillExpressBinding) this).f34907a, iSafeUnbox);
            }
            if ((j & 88) != 0) {
                CommonBindingAdapter.I(((MallDialogFillExpressBinding) this).f34907a, 0, 0, 0, iSafeUnbox2, null);
            }
        }
        z = false;
        iSafeUnbox = 0;
        value = null;
        shipperName = null;
        i = 0;
        iSafeUnbox2 = 0;
        j2 = j & 96;
        if (j2 != 0) {
            cVarA = null;
            dVarA = null;
            bVarA = null;
        } else {
            cVarA = null;
            dVarA = null;
            bVarA = null;
        }
        if ((84 & j) != 0) {
            TextViewBindingAdapter.setText(((MallDialogFillExpressBinding) this).f10542a, value);
        }
        if ((64 & j) != 0) {
            l = null;
            TextViewBindingAdapter.setTextWatcher(((MallDialogFillExpressBinding) this).f10542a, null, null, null, this.f10551a);
        } else {
            l = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10550a, bVarA, l);
            CommonBindingAdapter.q(this.f10556b, cVarA, l);
            CommonBindingAdapter.q(this.f10555a, dVarA, l);
        }
        if ((81 & j) != 0) {
            TextViewBindingAdapter.setText(this.f10556b, shipperName);
            CommonBindingAdapter.O(this.f10556b, i, 11, 16, 11, null);
            CommonBindingAdapter.l0(this.b, z);
        }
        if ((82 & j) != 0) {
            CommonBindingAdapter.G(((MallDialogFillExpressBinding) this).f34907a, iSafeUnbox);
        }
        if ((j & 88) != 0) {
            CommonBindingAdapter.I(((MallDialogFillExpressBinding) this).f34907a, 0, 0, 0, iSafeUnbox2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10548a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10548a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogFillExpressBinding
    public void l(@Nullable FillExpressDialog.a aVar) {
        ((MallDialogFillExpressBinding) this).f10545a = aVar;
        synchronized (this) {
            this.f10548a |= 32;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogFillExpressBinding
    public void m(@Nullable FillExpressVM fillExpressVM) {
        ((MallDialogFillExpressBinding) this).f10546a = fillExpressVM;
        synchronized (this) {
            this.f10548a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ExpressCompanyBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10548a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10548a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10548a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10548a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((FillExpressVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((FillExpressDialog.a) obj);
        }
        return true;
    }

    public MallDialogFillExpressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (EditText) objArr[4], (LinearLayout) objArr[7], (TextView) objArr[8], (View) objArr[6]);
        this.f10551a = new a();
        this.f10548a = -1L;
        ((MallDialogFillExpressBinding) this).f10542a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10549a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10550a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10556b = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[3];
        this.b = imageView2;
        imageView2.setTag(null);
        BLButton bLButton = (BLButton) objArr[5];
        this.f10555a = bLButton;
        bLButton.setTag(null);
        ((MallDialogFillExpressBinding) this).f34907a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
