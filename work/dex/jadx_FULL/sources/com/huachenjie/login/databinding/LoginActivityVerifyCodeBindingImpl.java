package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.view.VerifyCodeEditText;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.R;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.huachenjie.login.page.verify_code.VerifyCodeVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityVerifyCodeBindingImpl extends LoginActivityVerifyCodeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10050a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10057a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10058a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VerifyCodeActivity.ClickProxy f34672a;

        public a a(VerifyCodeActivity.ClickProxy clickProxy) {
            this.f34672a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34672a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VerifyCodeActivity.ClickProxy f34673a;

        public b a(VerifyCodeActivity.ClickProxy clickProxy) {
            this.f34673a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34673a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VerifyCodeActivity.ClickProxy f34674a;

        public c a(VerifyCodeActivity.ClickProxy clickProxy) {
            this.f34674a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34674a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34671a = sparseIntArray;
        sparseIntArray.put(R.id.et_verity_code, 6);
    }

    public LoginActivityVerifyCodeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10050a, f34671a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    /* JADX WARN: Code duplicated, block: B:78:0x0113  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CharSequence value;
        CharSequence value2;
        boolean z;
        boolean z2;
        String str;
        String value3;
        int i;
        int i2;
        b bVarA;
        c cVarA;
        a aVarA;
        int iSafeUnbox;
        int iSafeUnbox2;
        boolean zSafeUnbox;
        long j2;
        boolean zSafeUnbox2;
        synchronized (this) {
            j = this.f10051a;
            this.f10051a = 0L;
        }
        VerifyCodeVM verifyCodeVM = ((LoginActivityVerifyCodeBinding) this).f10049a;
        VerifyCodeActivity.ClickProxy clickProxy = ((LoginActivityVerifyCodeBinding) this).f10048a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value2 = null;
            } else {
                MutableLiveData<CharSequence> mutableLiveDataR = verifyCodeVM != null ? verifyCodeVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 336) != 0) {
                BaseViewModel.b bVarE = verifyCodeVM != null ? verifyCodeVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(4, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox + 16));
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            if ((j & 322) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = verifyCodeVM != null ? verifyCodeVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                } else {
                    value3 = null;
                }
            }
            long j3 = j & 324;
            if (j3 != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = verifyCodeVM != null ? verifyCodeVM.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox ? 1024L : 512L;
                }
                str = zSafeUnbox ? "#0BD3FF" : "#FFFFFF";
            } else {
                zSafeUnbox = false;
                str = null;
            }
            if ((j & 328) != 0) {
                MutableLiveData<Boolean> mutableLiveDataQ = verifyCodeVM != null ? verifyCodeVM.q() : null;
                updateLiveDataRegistration(3, mutableLiveDataQ);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null);
                j2 = 352;
            } else {
                j2 = 352;
                zSafeUnbox2 = false;
            }
            if ((j & j2) == 0) {
                i2 = iSafeUnbox;
                i = iSafeUnbox2;
                z2 = zSafeUnbox;
                z = zSafeUnbox2;
                value = null;
            } else {
                MutableLiveData<CharSequence> mutableLiveDataP = verifyCodeVM != null ? verifyCodeVM.p() : null;
                updateLiveDataRegistration(5, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value = mutableLiveDataP.getValue();
                    i2 = iSafeUnbox;
                    i = iSafeUnbox2;
                    z2 = zSafeUnbox;
                    z = zSafeUnbox2;
                } else {
                    i2 = iSafeUnbox;
                    i = iSafeUnbox2;
                    z2 = zSafeUnbox;
                    z = zSafeUnbox2;
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            z = false;
            z2 = false;
            str = null;
            value3 = null;
            i = 0;
            i2 = 0;
        }
        long j4 = 384 & j;
        if (j4 == 0 || clickProxy == null) {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        } else {
            c cVar = this.f10057a;
            if (cVar == null) {
                cVar = new c();
                this.f10057a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            a aVar = this.f10055a;
            if (aVar == null) {
                aVar = new a();
                this.f10055a = aVar;
            }
            aVarA = aVar.a(clickProxy);
            b bVar = this.f10056a;
            if (bVar == null) {
                bVar = new b();
                this.f10056a = bVar;
            }
            bVarA = bVar.a(clickProxy);
        }
        if ((j & 336) != 0) {
            CommonBindingAdapter.I(this.f10058a, 0, i2, 0, 0, null);
            CommonBindingAdapter.I(this.f10053a, 0, i, 0, 0, null);
        }
        if ((322 & j) != 0) {
            TextView textView = this.f10054a;
            CommonBindingAdapter.P(textView, value3, textView.getResources().getString(R.string.login_sms_send));
        }
        if ((324 & j) != 0) {
            CommonBindingAdapter.e0(this.b, z2);
            CommonBindingAdapter.W(this.b, str);
        }
        if ((352 & j) != 0) {
            TextViewBindingAdapter.setText(this.b, value);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(this.b, cVarA, null);
            CommonBindingAdapter.q(this.c, aVarA, null);
            CommonBindingAdapter.q(this.f10053a, bVarA, null);
        }
        if ((328 & j) != 0) {
            CommonBindingAdapter.e0(this.c, z);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.c, value2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10051a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10051a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityVerifyCodeBinding
    public void l(@Nullable VerifyCodeActivity.ClickProxy clickProxy) {
        ((LoginActivityVerifyCodeBinding) this).f10048a = clickProxy;
        synchronized (this) {
            this.f10051a |= 128;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityVerifyCodeBinding
    public void m(@Nullable VerifyCodeVM verifyCodeVM) {
        ((LoginActivityVerifyCodeBinding) this).f10049a = verifyCodeVM;
        synchronized (this) {
            this.f10051a |= 64;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10051a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10051a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return s((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<CharSequence> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10051a |= 32;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10051a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<CharSequence> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10051a |= 1;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10051a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((VerifyCodeVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((VerifyCodeActivity.ClickProxy) obj);
        }
        return true;
    }

    public LoginActivityVerifyCodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (VerifyCodeEditText) objArr[6]);
        this.f10051a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10052a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f10058a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10054a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.c = textView3;
        textView3.setTag(null);
        ImageView imageView = (ImageView) objArr[5];
        this.f10053a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
