package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.dialog.task.DoubleRewardDialog;
import com.huachenjie.home.dialog.task.DoubleRewardVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeDialogDoubleRewardBindingImpl extends HomeDialogDoubleRewardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34224a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9346a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckBox f9348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9354a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = HomeDialogDoubleRewardBindingImpl.this.f9348a.isChecked();
            DoubleRewardVM doubleRewardVM = ((HomeDialogDoubleRewardBinding) HomeDialogDoubleRewardBindingImpl.this).f9345a;
            if (doubleRewardVM != null) {
                MutableLiveData<Boolean> mutableLiveDataI = doubleRewardVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DoubleRewardDialog.a f34226a;

        public b a(DoubleRewardDialog.a aVar) {
            this.f34226a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34226a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DoubleRewardDialog.a f34227a;

        public c a(DoubleRewardDialog.a aVar) {
            this.f34227a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34227a.b(view);
        }
    }

    public HomeDialogDoubleRewardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9346a, f34224a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f9347a;
            this.f9347a = 0L;
        }
        DoubleRewardVM doubleRewardVM = ((HomeDialogDoubleRewardBinding) this).f9345a;
        DoubleRewardDialog.a aVar = ((HomeDialogDoubleRewardBinding) this).f34223a;
        long j2 = 11 & j;
        boolean zSafeUnbox = false;
        if (j2 != 0) {
            MutableLiveData<Boolean> mutableLiveDataI = doubleRewardVM != null ? doubleRewardVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
        }
        long j3 = 12 & j;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f9353a;
            if (cVar == null) {
                cVar = new c();
                this.f9353a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f9352a;
            if (bVar == null) {
                bVar = new b();
                this.f9352a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f9348a, zSafeUnbox);
        }
        if ((j & 8) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.f9348a, null, this.f9351a);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f9354a, cVarA, null);
            CommonBindingAdapter.q(this.f9350a, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9347a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9347a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogDoubleRewardBinding
    public void l(@Nullable DoubleRewardDialog.a aVar) {
        ((HomeDialogDoubleRewardBinding) this).f34223a = aVar;
        synchronized (this) {
            this.f9347a |= 4;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogDoubleRewardBinding
    public void m(@Nullable DoubleRewardVM doubleRewardVM) {
        ((HomeDialogDoubleRewardBinding) this).f9345a = doubleRewardVM;
        synchronized (this) {
            this.f9347a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9347a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((DoubleRewardVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((DoubleRewardDialog.a) obj);
        }
        return true;
    }

    public HomeDialogDoubleRewardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f9351a = new a();
        this.f9347a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9349a = linearLayout;
        linearLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[1];
        this.f9348a = checkBox;
        checkBox.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f9354a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f9350a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
