package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import com.huachenjie.home.dialog.HomeRewardDialog;
import com.huachenjie.home.dialog.HomeRewardVM;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeDialogHomeRewardBindingImpl extends HomeDialogHomeRewardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9361a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9362a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9366a;

    @NonNull
    public final BLView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeRewardDialog.ClickProxy f34230a;

        public a a(HomeRewardDialog.ClickProxy clickProxy) {
            this.f34230a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34230a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeRewardDialog.ClickProxy f34231a;

        public b a(HomeRewardDialog.ClickProxy clickProxy) {
            this.f34231a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34231a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeRewardDialog.ClickProxy f34232a;

        public c a(HomeRewardDialog.ClickProxy clickProxy) {
            this.f34232a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34232a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34229a = sparseIntArray;
        sparseIntArray.put(R.id.v_center_point, 5);
        sparseIntArray.put(R.id.v_icon_container, 6);
    }

    public HomeDialogHomeRewardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9361a, f34229a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String inspirationName;
        c cVarA;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f9362a;
            this.f9362a = 0L;
        }
        HomeRewardVM homeRewardVM = ((HomeDialogHomeRewardBinding) this).f9358a;
        HomeRewardDialog.ClickProxy clickProxy = ((HomeDialogHomeRewardBinding) this).f9357a;
        long j2 = 11 & j;
        if (j2 == 0) {
            inspirationName = null;
        } else {
            MutableLiveData<HomeRewardBean> mutableLiveDataJ = homeRewardVM != null ? homeRewardVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            HomeRewardBean value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
            if (value != null) {
                inspirationName = value.getInspirationName();
            } else {
                inspirationName = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || clickProxy == null) {
            cVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            c cVar = this.f9366a;
            if (cVar == null) {
                cVar = new c();
                this.f9366a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            a aVar = this.f9364a;
            if (aVar == null) {
                aVar = new a();
                this.f9364a = aVar;
            }
            aVarA = aVar.a(clickProxy);
            b bVar = this.f9365a;
            if (bVar == null) {
                bVar = new b();
                this.f9365a = bVar;
            }
            bVarA = bVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((HomeDialogHomeRewardBinding) this).f9355a, bVarA, null);
            CommonBindingAdapter.q(this.f9363a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(((HomeDialogHomeRewardBinding) this).f9359a, cVarA, null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((HomeDialogHomeRewardBinding) this).f9356a, inspirationName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9362a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9362a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogHomeRewardBinding
    public void l(@Nullable HomeRewardDialog.ClickProxy clickProxy) {
        ((HomeDialogHomeRewardBinding) this).f9357a = clickProxy;
        synchronized (this) {
            this.f9362a |= 4;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogHomeRewardBinding
    public void m(@Nullable HomeRewardVM homeRewardVM) {
        ((HomeDialogHomeRewardBinding) this).f9358a = homeRewardVM;
        synchronized (this) {
            this.f9362a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<HomeRewardBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9362a |= 1;
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
        if (xk0.p0 == i) {
            m((HomeRewardVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((HomeRewardDialog.ClickProxy) obj);
        }
        return true;
    }

    public HomeDialogHomeRewardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (TextView) objArr[3], (BLTextView) objArr[4], (View) objArr[5], (BLView) objArr[6]);
        this.f9362a = -1L;
        ((HomeDialogHomeRewardBinding) this).f9355a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9363a = constraintLayout;
        constraintLayout.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.b = bLView;
        bLView.setTag(null);
        ((HomeDialogHomeRewardBinding) this).f9356a.setTag(null);
        ((HomeDialogHomeRewardBinding) this).f9359a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
