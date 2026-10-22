package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.login.R;
import com.huachenjie.login.page.info.sex.ChooseSexActivity;
import com.huachenjie.login.page.info.sex.ChooseSexVM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityChooseSexBindingImpl extends LoginActivityChooseSexBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9953a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f9958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f9963a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9964b;

    @NonNull
    public final FrameLayout c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseSexActivity.a f34629a;

        public a a(ChooseSexActivity.a aVar) {
            this.f34629a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34629a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseSexActivity.a f34630a;

        public b a(ChooseSexActivity.a aVar) {
            this.f34630a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34630a.c(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseSexActivity.a f34631a;

        public c a(ChooseSexActivity.a aVar) {
            this.f34631a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34631a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseSexActivity.a f34632a;

        public d a(ChooseSexActivity.a aVar) {
            this.f34632a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34632a.e(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseSexActivity.a f34633a;

        public e a(ChooseSexActivity.a aVar) {
            this.f34633a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34633a.d(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34628a = sparseIntArray;
        sparseIntArray.put(R.id.rb_sex_group, 9);
    }

    public LoginActivityChooseSexBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9953a, f34628a));
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00c3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        int i;
        int i2;
        String value;
        String str;
        b bVarA;
        c cVarA;
        d dVarA;
        e eVarA;
        a aVarA;
        boolean z3;
        boolean z4;
        int i3;
        synchronized (this) {
            j = this.f9954a;
            this.f9954a = 0L;
        }
        ChooseSexVM chooseSexVM = ((LoginActivityChooseSexBinding) this).f9952a;
        ChooseSexActivity.a aVar = ((LoginActivityChooseSexBinding) this).f9951a;
        boolean z5 = false;
        int iSafeUnbox = 0;
        if ((47 & j) != 0) {
            long j2 = j & 41;
            if (j2 != 0) {
                MutableLiveData<Integer> mutableLiveDataK = chooseSexVM != null ? chooseSexVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
                z3 = iSafeUnbox2 == 2;
                z4 = iSafeUnbox2 > 0;
                z2 = iSafeUnbox2 == 1;
                if (j2 != 0) {
                    j |= z4 ? 128L : 64L;
                }
                str = z4 ? "#0BD3FF" : "#FFFFFF";
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                str = null;
            }
            if ((j & 44) != 0) {
                BaseViewModel.b bVarE = chooseSexVM != null ? chooseSexVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                i3 = iSafeUnbox3;
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox3 + 16));
            } else {
                i3 = 0;
            }
            if ((j & 42) == 0) {
                i = iSafeUnbox;
                i2 = i3;
                z5 = z3;
                z = z4;
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataI = chooseSexVM != null ? chooseSexVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    i = iSafeUnbox;
                    i2 = i3;
                    z5 = z3;
                    z = z4;
                } else {
                    i = iSafeUnbox;
                    i2 = i3;
                    z5 = z3;
                    z = z4;
                    value = null;
                }
            }
        } else {
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
            value = null;
            str = null;
        }
        long j3 = j & 48;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
            dVarA = null;
            eVarA = null;
            aVarA = null;
        } else {
            e eVar = this.f9963a;
            if (eVar == null) {
                eVar = new e();
                this.f9963a = eVar;
            }
            eVarA = eVar.a(aVar);
            a aVar2 = this.f9959a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9959a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f9960a;
            if (bVar == null) {
                bVar = new b();
                this.f9960a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f9961a;
            if (cVar == null) {
                cVar = new c();
                this.f9961a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f9962a;
            if (dVar == null) {
                dVar = new d();
                this.f9962a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.I(this.f9964b, 0, i2, 0, 0, null);
            CommonBindingAdapter.I(this.f9956a, 0, i, 0, 0, null);
        }
        if ((41 & j) != 0) {
            this.b.setSelected(z5);
            this.c.setSelected(z2);
            CommonBindingAdapter.e0(this.f9957a, z);
            CommonBindingAdapter.W(this.f9957a, str);
            CompoundButtonBindingAdapter.setChecked(((LoginActivityChooseSexBinding) this).f34627a, z5);
            CompoundButtonBindingAdapter.setChecked(((LoginActivityChooseSexBinding) this).b, z2);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(this.c, eVarA, null);
            CommonBindingAdapter.q(this.f9958a, cVarA, null);
            CommonBindingAdapter.q(this.f9957a, dVarA, null);
            CommonBindingAdapter.q(this.f9956a, aVarA, null);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(this.f9958a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9954a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9954a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityChooseSexBinding
    public void l(@Nullable ChooseSexActivity.a aVar) {
        ((LoginActivityChooseSexBinding) this).f9951a = aVar;
        synchronized (this) {
            this.f9954a |= 16;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityChooseSexBinding
    public void m(@Nullable ChooseSexVM chooseSexVM) {
        ((LoginActivityChooseSexBinding) this).f9952a = chooseSexVM;
        synchronized (this) {
            this.f9954a |= 8;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9954a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9954a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9954a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((ChooseSexVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((ChooseSexActivity.a) obj);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r8v15, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    public LoginActivityChooseSexBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CheckBox) objArr[3], (LinearLayout) objArr[9], (CheckBox) objArr[5]);
        this.f9954a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9955a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f9964b = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[2];
        this.b = frameLayout2;
        frameLayout2.setTag(null);
        FrameLayout frameLayout3 = (FrameLayout) objArr[4];
        this.c = frameLayout3;
        frameLayout3.setTag(null);
        ?? r8 = (DrawableCenterButton) objArr[6];
        this.f9958a = r8;
        r8.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.f9957a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[8];
        this.f9956a = imageView;
        imageView.setTag(null);
        ((LoginActivityChooseSexBinding) this).f34627a.setTag(null);
        ((LoginActivityChooseSexBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
