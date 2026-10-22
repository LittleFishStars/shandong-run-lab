package com.huachenjie.login.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.R;
import com.huachenjie.login.page.account.LoginAccountActivity;
import com.huachenjie.login.page.account.LoginAccountVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityAccountBindingImpl extends LoginActivityAccountBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9926a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9927b;

    @NonNull
    public final TextView c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityAccountBinding) LoginActivityAccountBindingImpl.this).f34612a);
            LoginAccountVM loginAccountVM = ((LoginActivityAccountBinding) LoginActivityAccountBindingImpl.this).f9917a;
            if (loginAccountVM != null) {
                MutableLiveData<String> mutableLiveDataO = loginAccountVM.o();
                if (mutableLiveDataO != null) {
                    mutableLiveDataO.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LoginAccountActivity.a f34615a;

        public b a(LoginAccountActivity.a aVar) {
            this.f34615a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34615a.n(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LoginAccountActivity.a f34616a;

        public c a(LoginAccountActivity.a aVar) {
            this.f34616a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34616a.m(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f9918a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"login_layout_protocol_checkbox"}, new int[]{8}, new int[]{R.layout.login_layout_protocol_checkbox});
        f34613a = null;
    }

    public LoginActivityAccountBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9918a, f34613a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String string;
        String string2;
        int iSafeUnbox;
        Drawable drawable;
        boolean z;
        String value;
        int i;
        b bVarA;
        long j2;
        c cVarA;
        boolean z2;
        int iSafeUnbox2;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f9919a;
            this.f9919a = 0L;
        }
        LoginAccountVM loginAccountVM = ((LoginActivityAccountBinding) this).f9917a;
        LoginAccountActivity.a aVar = ((LoginActivityAccountBinding) this).f9916a;
        if ((94 & j) != 0) {
            long j5 = j & 82;
            if (j5 != 0) {
                MutableLiveData<String> mutableLiveDataO = loginAccountVM != null ? loginAccountVM.o() : null;
                updateLiveDataRegistration(1, mutableLiveDataO);
                value = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                z2 = (value != null ? value.length() : 0) > 4;
                if (j5 != 0) {
                    j |= z2 ? 4096L : 2048L;
                }
                str = z2 ? "#0BD3FF" : "#FFFFFF";
            } else {
                str = null;
                z2 = false;
                value = null;
            }
            if ((j & 84) != 0) {
                BaseViewModel.b bVarE = loginAccountVM != null ? loginAccountVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 + 16));
            } else {
                iSafeUnbox2 = 0;
                iSafeUnbox = 0;
            }
            long j6 = j & 88;
            if (j6 != 0) {
                MutableLiveData<Integer> mutableLiveDataQ = loginAccountVM != null ? loginAccountVM.q() : null;
                updateLiveDataRegistration(3, mutableLiveDataQ);
                boolean z3 = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null) == 1;
                if (j6 != 0) {
                    if (z3) {
                        j3 = j | 256 | 1024;
                        j4 = PlaybackStateCompat.ACTION_PREPARE;
                    } else {
                        j3 = j | 128 | 512;
                        j4 = 8192;
                    }
                    j = j3 | j4;
                }
                string = this.f9922a.getResources().getString(z3 ? R.string.login_account_password_title : R.string.login_account_code_title);
                string2 = this.f9927b.getResources().getString(z3 ? R.string.login_account_password_content : R.string.login_account_code_content);
                drawable = AppCompatResources.getDrawable(this.f9921a.getContext(), z3 ? R.drawable.login_ic_title_password : R.drawable.login_ic_title_code);
                i = iSafeUnbox2;
                z = z2;
            } else {
                i = iSafeUnbox2;
                z = z2;
                string = null;
                string2 = null;
                drawable = null;
            }
        } else {
            str = null;
            string = null;
            string2 = null;
            iSafeUnbox = 0;
            drawable = null;
            z = false;
            value = null;
            i = 0;
        }
        long j7 = j & 96;
        if (j7 == 0 || aVar == null) {
            bVarA = null;
            j2 = 82;
            cVarA = null;
        } else {
            c cVar = this.f9925a;
            if (cVar == null) {
                cVar = new c();
                this.f9925a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f9924a;
            if (bVar == null) {
                bVar = new b();
                this.f9924a = bVar;
            }
            bVarA = bVar.a(aVar);
            j2 = 82;
        }
        if ((j2 & j) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityAccountBinding) this).f34612a, value);
            CommonBindingAdapter.e0(this.c, z);
            CommonBindingAdapter.W(this.c, str);
        }
        if ((64 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((LoginActivityAccountBinding) this).f34612a, null, null, null, this.f9923a);
        }
        if ((80 & j) != 0) {
            ((LoginActivityAccountBinding) this).f9915a.k(loginAccountVM);
        }
        if ((84 & j) != 0) {
            CommonBindingAdapter.I(this.f9926a, 0, i, 0, 0, null);
            CommonBindingAdapter.I(this.b, 0, iSafeUnbox, 0, 0, null);
        }
        if ((j & 88) != 0) {
            TextViewBindingAdapter.setText(this.f9922a, string);
            ImageViewBindingAdapter.setImageDrawable(this.f9921a, drawable);
            TextViewBindingAdapter.setText(this.f9927b, string2);
        }
        if (j7 != 0) {
            CommonBindingAdapter.q(this.c, bVarA, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
        }
        ViewDataBinding.executeBindingsOn(((LoginActivityAccountBinding) this).f9915a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9919a != 0) {
                return true;
            }
            return ((LoginActivityAccountBinding) this).f9915a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9919a = 64L;
        }
        ((LoginActivityAccountBinding) this).f9915a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityAccountBinding
    public void l(@Nullable LoginAccountActivity.a aVar) {
        ((LoginActivityAccountBinding) this).f9916a = aVar;
        synchronized (this) {
            this.f9919a |= 32;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityAccountBinding
    public void m(@Nullable LoginAccountVM loginAccountVM) {
        ((LoginActivityAccountBinding) this).f9917a = loginAccountVM;
        synchronized (this) {
            this.f9919a |= 16;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(LoginLayoutProtocolCheckboxBinding loginLayoutProtocolCheckboxBinding, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9919a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9919a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((LoginLayoutProtocolCheckboxBinding) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9919a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9919a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((LoginActivityAccountBinding) this).f9915a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((LoginAccountVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((LoginAccountActivity.a) obj);
        }
        return true;
    }

    public LoginActivityAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (EditText) objArr[5], (LoginLayoutProtocolCheckboxBinding) objArr[8]);
        this.f9923a = new a();
        this.f9919a = -1L;
        ((LoginActivityAccountBinding) this).f34612a.setTag(null);
        setContainedBinding(((LoginActivityAccountBinding) this).f9915a);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9920a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f9926a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9922a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f9921a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f9927b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.c = textView3;
        textView3.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.b = imageView2;
        imageView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
