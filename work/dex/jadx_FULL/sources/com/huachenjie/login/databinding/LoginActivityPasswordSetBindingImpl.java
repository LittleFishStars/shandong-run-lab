package com.huachenjie.login.databinding;

import android.content.res.Resources;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.R;
import com.huachenjie.login.page.password.SetPasswordActivity;
import com.huachenjie.login.page.password.SetPasswordVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityPasswordSetBindingImpl extends LoginActivityPasswordSetBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34655a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10015a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckBox f10017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f10022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f10023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f10024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10025a;

    @NonNull
    public final CheckBox b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10026b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public InverseBindingListener f10027b;

    @NonNull
    public final EditText c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f10028c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public InverseBindingListener f10029c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public InverseBindingListener f10030d;
    public InverseBindingListener e;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).f34654a);
            SetPasswordVM setPasswordVM = ((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).f10014a;
            if (setPasswordVM != null) {
                MutableLiveData<String> mutableLiveDataL = setPasswordVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).b);
            SetPasswordVM setPasswordVM = ((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).f10014a;
            if (setPasswordVM != null) {
                MutableLiveData<String> mutableLiveDataQ = setPasswordVM.q();
                if (mutableLiveDataQ != null) {
                    mutableLiveDataQ.setValue(textString);
                }
            }
        }
    }

    public class c implements InverseBindingListener {
        public c() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = LoginActivityPasswordSetBindingImpl.this.f10017a.isChecked();
            SetPasswordVM setPasswordVM = ((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).f10014a;
            if (setPasswordVM != null) {
                MutableLiveData<Boolean> mutableLiveDataU = setPasswordVM.u();
                if (mutableLiveDataU != null) {
                    mutableLiveDataU.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public class d implements InverseBindingListener {
        public d() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = LoginActivityPasswordSetBindingImpl.this.b.isChecked();
            SetPasswordVM setPasswordVM = ((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).f10014a;
            if (setPasswordVM != null) {
                MutableLiveData<Boolean> mutableLiveDataT = setPasswordVM.t();
                if (mutableLiveDataT != null) {
                    mutableLiveDataT.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public class e implements InverseBindingListener {
        public e() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(LoginActivityPasswordSetBindingImpl.this.c);
            SetPasswordVM setPasswordVM = ((LoginActivityPasswordSetBinding) LoginActivityPasswordSetBindingImpl.this).f10014a;
            if (setPasswordVM != null) {
                MutableLiveData<String> mutableLiveDataW = setPasswordVM.w();
                if (mutableLiveDataW != null) {
                    mutableLiveDataW.setValue(textString);
                }
            }
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SetPasswordActivity.a f34661a;

        public f a(SetPasswordActivity.a aVar) {
            this.f34661a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34661a.a(view);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SetPasswordActivity.a f34662a;

        public g a(SetPasswordActivity.a aVar) {
            this.f34662a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34662a.b(view);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SetPasswordActivity.a f34663a;

        public h a(SetPasswordActivity.a aVar) {
            this.f34663a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34663a.c(view);
        }
    }

    public LoginActivityPasswordSetBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f10015a, f34655a));
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x011a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0136  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String str;
        String string;
        boolean zSafeUnbox;
        boolean z;
        String str2;
        String value2;
        int iSafeUnbox;
        String value3;
        String str3;
        boolean z2;
        boolean zSafeUnbox2;
        int i;
        g gVarA;
        f fVar;
        h hVar;
        String string2;
        int iSafeUnbox2;
        String value4;
        boolean zSafeUnbox3;
        long j2;
        int i2;
        int length;
        Resources resources;
        int i3;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f10016a;
            this.f10016a = 0L;
        }
        SetPasswordVM setPasswordVM = ((LoginActivityPasswordSetBinding) this).f10014a;
        SetPasswordActivity.a aVar = ((LoginActivityPasswordSetBinding) this).f10013a;
        if ((3071 & j) != 0) {
            if ((j & 2561) != 0) {
                MutableLiveData<Boolean> mutableLiveDataT = setPasswordVM != null ? setPasswordVM.t() : null;
                updateLiveDataRegistration(0, mutableLiveDataT);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataT != null ? mutableLiveDataT.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            long j5 = j & 2562;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = setPasswordVM != null ? setPasswordVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j5 != 0) {
                    if (zSafeUnbox4) {
                        j3 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        j4 = 131072;
                    } else {
                        j3 = j | PlaybackStateCompat.ACTION_PREPARE;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                    j = j3 | j4;
                }
                string = this.f10026b.getResources().getString(zSafeUnbox4 ? R.string.login_password_forget_title : R.string.login_password_set_title);
                if (zSafeUnbox4) {
                    resources = this.f10028c.getResources();
                    i3 = R.string.login_password_forget_content;
                } else {
                    resources = this.f10028c.getResources();
                    i3 = R.string.login_password_set_content;
                }
                string2 = resources.getString(i3);
            } else {
                string = null;
                string2 = null;
            }
            if ((j & 2564) != 0) {
                MutableLiveData<Boolean> mutableLiveDataU = setPasswordVM != null ? setPasswordVM.u() : null;
                updateLiveDataRegistration(2, mutableLiveDataU);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataU != null ? mutableLiveDataU.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 2568) != 0) {
                BaseViewModel.b bVarE = setPasswordVM != null ? setPasswordVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox + 16));
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            if ((j & 2576) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataW = setPasswordVM != null ? setPasswordVM.w() : null;
                updateLiveDataRegistration(4, mutableLiveDataW);
                if (mutableLiveDataW != null) {
                    value3 = mutableLiveDataW.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 2592) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = setPasswordVM != null ? setPasswordVM.l() : null;
                updateLiveDataRegistration(5, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value4 = mutableLiveDataL.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 2624) != 0) {
                MutableLiveData<Boolean> mutableLiveDataR = setPasswordVM != null ? setPasswordVM.r() : null;
                updateLiveDataRegistration(6, mutableLiveDataR);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataR != null ? mutableLiveDataR.getValue() : null);
            } else {
                zSafeUnbox3 = false;
            }
            long j6 = j & 2688;
            if (j6 != 0) {
                MutableLiveData<String> mutableLiveDataQ = setPasswordVM != null ? setPasswordVM.q() : null;
                updateLiveDataRegistration(7, mutableLiveDataQ);
                value2 = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
                if (value2 != null) {
                    length = value2.length();
                    i2 = 8;
                } else {
                    i2 = 8;
                    length = 0;
                }
                z = length >= i2;
                if (j6 != 0) {
                    j |= z ? 8192L : 4096L;
                }
                str = z ? "#0BD3FF" : "#FFFFFF";
                j2 = 2816;
            } else {
                zSafeUnbox3 = zSafeUnbox3;
                str = null;
                j2 = 2816;
                z = false;
                value2 = null;
            }
            if ((j & j2) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataS = setPasswordVM != null ? setPasswordVM.s() : null;
                updateLiveDataRegistration(8, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value = mutableLiveDataS.getValue();
                } else {
                    value = null;
                }
            }
            i = iSafeUnbox2;
            z2 = zSafeUnbox3;
            String str4 = value4;
            str3 = string2;
            str2 = str4;
        } else {
            value = null;
            str = null;
            string = null;
            zSafeUnbox = false;
            z = false;
            str2 = null;
            value2 = null;
            iSafeUnbox = 0;
            value3 = null;
            str3 = null;
            z2 = false;
            zSafeUnbox2 = false;
            i = 0;
        }
        long j7 = j & 3072;
        if (j7 == 0 || aVar == null) {
            gVarA = null;
            fVar = null;
            hVar = null;
        } else {
            h hVar2 = this.f10024a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f10024a = hVar2;
            }
            h hVarA = hVar2.a(aVar);
            f fVar2 = this.f10022a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f10022a = fVar2;
            }
            f fVarA = fVar2.a(aVar);
            g gVar = this.f10023a;
            if (gVar == null) {
                gVar = new g();
                this.f10023a = gVar;
            }
            gVarA = gVar.a(aVar);
            hVar = hVarA;
            fVar = fVarA;
        }
        if ((j & 2592) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityPasswordSetBinding) this).f34654a, str2);
        }
        if ((j & 2048) != 0) {
            TextViewBindingAdapter.setTextWatcher(((LoginActivityPasswordSetBinding) this).f34654a, null, null, null, this.f10021a);
            TextViewBindingAdapter.setTextWatcher(((LoginActivityPasswordSetBinding) this).b, null, null, null, this.f10027b);
            CompoundButtonBindingAdapter.setListeners(this.f10017a, null, this.f10029c);
            CompoundButtonBindingAdapter.setListeners(this.b, null, this.f10030d);
            TextViewBindingAdapter.setTextWatcher(this.c, null, null, null, this.e);
        }
        if ((j & 2688) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityPasswordSetBinding) this).b, value2);
            CommonBindingAdapter.e0(this.f10020a, z);
            CommonBindingAdapter.W(this.f10020a, str);
        }
        if ((2568 & j) != 0) {
            CommonBindingAdapter.I(this.f10025a, 0, iSafeUnbox, 0, 0, null);
            CommonBindingAdapter.I(this.f10019a, 0, i, 0, 0, null);
        }
        if (j7 != 0) {
            CommonBindingAdapter.q(this.f10020a, gVarA, null);
            CommonBindingAdapter.q(this.f10019a, fVar, null);
            CommonBindingAdapter.q(this.d, hVar, null);
        }
        if ((j & 2562) != 0) {
            TextViewBindingAdapter.setText(this.f10026b, string);
            TextViewBindingAdapter.setText(this.f10028c, str3);
        }
        if ((j & 2564) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f10017a, zSafeUnbox);
        }
        if ((j & 2561) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.b, zSafeUnbox2);
        }
        if ((2576 & j) != 0) {
            TextViewBindingAdapter.setText(this.c, value3);
        }
        if ((2624 & j) != 0) {
            CommonBindingAdapter.e0(this.d, z2);
        }
        if ((j & 2816) != 0) {
            TextViewBindingAdapter.setText(this.d, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10016a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10016a = 2048L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityPasswordSetBinding
    public void l(@Nullable SetPasswordActivity.a aVar) {
        ((LoginActivityPasswordSetBinding) this).f10013a = aVar;
        synchronized (this) {
            this.f10016a |= 1024;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityPasswordSetBinding
    public void m(@Nullable SetPasswordVM setPasswordVM) {
        ((LoginActivityPasswordSetBinding) this).f10014a = setPasswordVM;
        synchronized (this) {
            this.f10016a |= 512;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return v((MutableLiveData) obj, i2);
            case 1:
                return r((MutableLiveData) obj, i2);
            case 2:
                return w((MutableLiveData) obj, i2);
            case 3:
                return x((MutableLiveData) obj, i2);
            case 4:
                return y((MutableLiveData) obj, i2);
            case 5:
                return q((MutableLiveData) obj, i2);
            case 6:
                return t((MutableLiveData) obj, i2);
            case 7:
                return s((MutableLiveData) obj, i2);
            case 8:
                return u((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 32;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 2;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 128;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((SetPasswordVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((SetPasswordActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 64;
        }
        return true;
    }

    public final boolean u(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 256;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 1;
        }
        return true;
    }

    public final boolean w(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 4;
        }
        return true;
    }

    public final boolean x(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 8;
        }
        return true;
    }

    public final boolean y(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10016a |= 16;
        }
        return true;
    }

    public LoginActivityPasswordSetBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (EditText) objArr[6], (EditText) objArr[4]);
        this.f10021a = new a();
        this.f10027b = new b();
        this.f10029c = new c();
        this.f10030d = new d();
        this.e = new e();
        this.f10016a = -1L;
        ((LoginActivityPasswordSetBinding) this).f34654a.setTag(null);
        ((LoginActivityPasswordSetBinding) this).b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10018a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f10025a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.f10020a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[11];
        this.f10019a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f10026b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f10028c = textView3;
        textView3.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[5];
        this.f10017a = checkBox;
        checkBox.setTag(null);
        CheckBox checkBox2 = (CheckBox) objArr[7];
        this.b = checkBox2;
        checkBox2.setTag(null);
        EditText editText = (EditText) objArr[8];
        this.c = editText;
        editText.setTag(null);
        TextView textView4 = (TextView) objArr[9];
        this.d = textView4;
        textView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
