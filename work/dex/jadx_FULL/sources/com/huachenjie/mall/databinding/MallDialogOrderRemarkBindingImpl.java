package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.huachenjie.mall.page.check_order.OrderRemarkDialog;
import com.huachenjie.mall.page.check_order.OrderRemarkVM;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallDialogOrderRemarkBindingImpl extends MallDialogOrderRemarkBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10595a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10601a;

    @NonNull
    public final TextView b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MallDialogOrderRemarkBinding) MallDialogOrderRemarkBindingImpl.this).f10592a);
            OrderRemarkVM orderRemarkVM = ((MallDialogOrderRemarkBinding) MallDialogOrderRemarkBindingImpl.this).f10591a;
            if (orderRemarkVM != null) {
                MutableLiveData<String> mutableLiveDataJ = orderRemarkVM.j();
                if (mutableLiveDataJ != null) {
                    mutableLiveDataJ.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderRemarkDialog.a f34925a;

        public b a(OrderRemarkDialog.a aVar) {
            this.f34925a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34925a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderRemarkDialog.a f34926a;

        public c a(OrderRemarkDialog.a aVar) {
            this.f34926a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34926a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34923a = sparseIntArray;
        sparseIntArray.put(R.id.rl_content, 6);
        sparseIntArray.put(R.id.tv_title, 7);
    }

    public MallDialogOrderRemarkBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10595a, f34923a));
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:70:0x0100  */
    /* JADX WARN: Code duplicated, block: B:73:0x010d  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String value;
        String str;
        long j2;
        b bVarA;
        c cVarA;
        int iSafeUnbox;
        int iSafeUnbox2;
        synchronized (this) {
            j = this.f10596a;
            this.f10596a = 0L;
        }
        OrderRemarkVM orderRemarkVM = ((MallDialogOrderRemarkBinding) this).f10591a;
        OrderRemarkDialog.a aVar = ((MallDialogOrderRemarkBinding) this).f10590a;
        int i2 = 0;
        if ((47 & j) != 0) {
            if ((j & 41) != 0) {
                MutableLiveData<Integer> mutableLiveDataI = orderRemarkVM != null ? orderRemarkVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 42) != 0) {
                BaseViewModel.b bVarE = orderRemarkVM != null ? orderRemarkVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(1, mutableLiveDataA);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 44) != 0) {
                MutableLiveData<String> mutableLiveDataJ = orderRemarkVM != null ? orderRemarkVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                str = String.format("%d/150", Integer.valueOf(value != null ? value.length() : 0));
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
            } else {
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
            }
            j2 = 48 & j;
            if (j2 != 0 || aVar == null) {
                bVarA = null;
                cVarA = null;
            } else {
                c cVar = this.f10601a;
                if (cVar == null) {
                    cVar = new c();
                    this.f10601a = cVar;
                }
                cVarA = cVar.a(aVar);
                b bVar = this.f10600a;
                if (bVar == null) {
                    bVar = new b();
                    this.f10600a = bVar;
                }
                bVarA = bVar.a(aVar);
            }
            if ((44 & j) != 0) {
                TextViewBindingAdapter.setText(((MallDialogOrderRemarkBinding) this).f10592a, value);
                TextViewBindingAdapter.setText(this.b, str);
            }
            if ((32 & j) != 0) {
                TextViewBindingAdapter.setTextWatcher(((MallDialogOrderRemarkBinding) this).f10592a, null, null, null, this.f10599a);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f10598a, bVarA, null);
                CommonBindingAdapter.q(((MallDialogOrderRemarkBinding) this).f10594a, cVarA, null);
            }
            if ((41 & j) != 0) {
                CommonBindingAdapter.G(((MallDialogOrderRemarkBinding) this).f34922a, i2);
            }
            if ((j & 42) != 0) {
                CommonBindingAdapter.I(((MallDialogOrderRemarkBinding) this).f34922a, 0, 0, 0, i, null);
            }
        }
        i = 0;
        value = null;
        str = null;
        j2 = 48 & j;
        if (j2 != 0) {
            bVarA = null;
            cVarA = null;
        } else {
            bVarA = null;
            cVarA = null;
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(((MallDialogOrderRemarkBinding) this).f10592a, value);
            TextViewBindingAdapter.setText(this.b, str);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((MallDialogOrderRemarkBinding) this).f10592a, null, null, null, this.f10599a);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10598a, bVarA, null);
            CommonBindingAdapter.q(((MallDialogOrderRemarkBinding) this).f10594a, cVarA, null);
        }
        if ((41 & j) != 0) {
            CommonBindingAdapter.G(((MallDialogOrderRemarkBinding) this).f34922a, i2);
        }
        if ((j & 42) != 0) {
            CommonBindingAdapter.I(((MallDialogOrderRemarkBinding) this).f34922a, 0, 0, 0, i, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10596a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10596a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogOrderRemarkBinding
    public void l(@Nullable OrderRemarkDialog.a aVar) {
        ((MallDialogOrderRemarkBinding) this).f10590a = aVar;
        synchronized (this) {
            this.f10596a |= 16;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallDialogOrderRemarkBinding
    public void m(@Nullable OrderRemarkVM orderRemarkVM) {
        ((MallDialogOrderRemarkBinding) this).f10591a = orderRemarkVM;
        synchronized (this) {
            this.f10596a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10596a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10596a |= 4;
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
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10596a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((OrderRemarkVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((OrderRemarkDialog.a) obj);
        }
        return true;
    }

    public MallDialogOrderRemarkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BLEditText) objArr[2], (BLRelativeLayout) objArr[6], (BLTextView) objArr[4], (TextView) objArr[7], (View) objArr[5]);
        this.f10599a = new a();
        this.f10596a = -1L;
        ((MallDialogOrderRemarkBinding) this).f10592a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10597a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10598a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.b = textView;
        textView.setTag(null);
        ((MallDialogOrderRemarkBinding) this).f10594a.setTag(null);
        ((MallDialogOrderRemarkBinding) this).f34922a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
