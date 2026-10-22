package com.huachenjie.home.databinding;

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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignConfigBean;
import com.huachenjie.home.dialog.sign.SignAdapter;
import com.huachenjie.home.dialog.sign.SignDialog;
import com.huachenjie.home.dialog.sign.SignVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeDialogSignBindingImpl extends HomeDialogSignBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9385a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9389a;

    @NonNull
    public final ImageView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SignDialog.a f34239a;

        public a a(SignDialog.a aVar) {
            this.f34239a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34239a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SignDialog.a f34240a;

        public b a(SignDialog.a aVar) {
            this.f34240a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34240a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34238a = sparseIntArray;
        sparseIntArray.put(R.id.iv_bg, 5);
        sparseIntArray.put(R.id.tv_title, 6);
    }

    public HomeDialogSignBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9385a, f34238a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        SignAdapter value;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f9386a;
            this.f9386a = 0L;
        }
        SignVM signVM = ((HomeDialogSignBinding) this).f9383a;
        SignDialog.a aVar = ((HomeDialogSignBinding) this).f9382a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<SignAdapter> mutableLiveDataI = signVM != null ? signVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<SignConfigBean> mutableLiveDataJ = signVM != null ? signVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                SignConfigBean value2 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(value2 != null ? value2.getContinueDays() : 0));
            } else {
                str = null;
            }
        } else {
            str = null;
            value = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f9389a;
            if (bVar == null) {
                bVar = new b();
                this.f9389a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f9388a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9388a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(((HomeDialogSignBinding) this).f9381a, bVarA, null);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.g(((HomeDialogSignBinding) this).f9380a, value, false, false);
        }
        if ((j & 22) != 0) {
            TextViewBindingAdapter.setText(((HomeDialogSignBinding) this).f9384a, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9386a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9386a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogSignBinding
    public void l(@Nullable SignDialog.a aVar) {
        ((HomeDialogSignBinding) this).f9382a = aVar;
        synchronized (this) {
            this.f9386a |= 8;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogSignBinding
    public void m(@Nullable SignVM signVM) {
        ((HomeDialogSignBinding) this).f9383a = signVM;
        synchronized (this) {
            this.f9386a |= 4;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SignAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9386a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<SignConfigBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9386a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((SignVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((SignDialog.a) obj);
        }
        return true;
    }

    public HomeDialogSignBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[5], (RecyclerView) objArr[2], (StrokeTextView) objArr[3], (BLTextView) objArr[1], (TextView) objArr[6]);
        this.f9386a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9387a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.b = imageView;
        imageView.setTag(null);
        ((HomeDialogSignBinding) this).f9380a.setTag(null);
        ((HomeDialogSignBinding) this).f9381a.setTag(null);
        ((HomeDialogSignBinding) this).f9384a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
