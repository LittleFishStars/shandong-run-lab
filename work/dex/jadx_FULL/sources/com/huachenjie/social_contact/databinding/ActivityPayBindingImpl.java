package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.PayBean;
import com.huachenjie.social_contact.page.PayActivity;
import com.huachenjie.social_contact.vm.PayVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityPayBindingImpl extends ActivityPayBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12739a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12745a;

    @NonNull
    public final ImageView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayActivity.a f36091a;

        public a a(PayActivity.a aVar) {
            this.f36091a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36091a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayActivity.a f36092a;

        public b a(PayActivity.a aVar) {
            this.f36092a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36092a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayActivity.a f36093a;

        public c a(PayActivity.a aVar) {
            this.f36093a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36093a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PayActivity.a f36094a;

        public d a(PayActivity.a aVar) {
            this.f36094a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36094a.d(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36090a = sparseIntArray;
        sparseIntArray.put(R.id.pay_container, 7);
        sparseIntArray.put(R.id.tv_title, 8);
        sparseIntArray.put(R.id.ll_pay_success, 9);
        sparseIntArray.put(R.id.pay_lottie, 10);
    }

    public ActivityPayBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f12739a, f36090a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        d dVarA;
        a aVarA;
        b bVarA;
        c cVarA;
        String payDes;
        String patNumStr;
        synchronized (this) {
            j = this.f12740a;
            this.f12740a = 0L;
        }
        PayVM payVM = ((ActivityPayBinding) this).f12735a;
        PayActivity.a aVar = ((ActivityPayBinding) this).f12734a;
        long j2 = 11 & j;
        if (j2 != 0) {
            MutableLiveData<PayBean> mutableLiveDataQ = payVM != null ? payVM.q() : null;
            updateLiveDataRegistration(0, mutableLiveDataQ);
            PayBean value = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
            if (value != null) {
                patNumStr = value.getPatNumStr();
                payDes = value.getPayDes();
            } else {
                payDes = null;
                patNumStr = null;
            }
            str2 = String.format("%s", patNumStr);
            str = String.format("%s", payDes);
        } else {
            str = null;
            str2 = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            dVarA = null;
            aVarA = null;
            bVarA = null;
            cVarA = null;
        } else {
            d dVar = this.f12745a;
            if (dVar == null) {
                dVar = new d();
                this.f12745a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f12742a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12742a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f12743a;
            if (bVar == null) {
                bVar = new b();
                this.f12743a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f12744a;
            if (cVar == null) {
                cVar = new c();
                this.f12744a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ActivityPayBinding) this).f12731a, cVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(((ActivityPayBinding) this).f12737a, bVarA, null);
            CommonBindingAdapter.q(((ActivityPayBinding) this).f12738b, dVarA, null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((ActivityPayBinding) this).f12732a, str);
            TextViewBindingAdapter.setText(((ActivityPayBinding) this).b, str2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12740a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12740a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityPayBinding
    public void l(@Nullable PayActivity.a aVar) {
        ((ActivityPayBinding) this).f12734a = aVar;
        synchronized (this) {
            this.f12740a |= 4;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityPayBinding
    public void m(@Nullable PayVM payVM) {
        ((ActivityPayBinding) this).f12735a = payVM;
        synchronized (this) {
            this.f12740a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<PayBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12740a |= 1;
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
            m((PayVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((PayActivity.a) obj);
        }
        return true;
    }

    public ActivityPayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (FrameLayout) objArr[9], (BLConstraintLayout) objArr[7], (LottieAnimationView) objArr[10], (TextView) objArr[4], (BLTextView) objArr[6], (TextView) objArr[3], (BLTextView) objArr[5], (TextView) objArr[8]);
        this.f12740a = -1L;
        ((ActivityPayBinding) this).f12731a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f12741a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.b = imageView;
        imageView.setTag(null);
        ((ActivityPayBinding) this).f12732a.setTag(null);
        ((ActivityPayBinding) this).f12737a.setTag(null);
        ((ActivityPayBinding) this).b.setTag(null);
        ((ActivityPayBinding) this).f12738b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
