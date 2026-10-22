package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
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
import com.huachenjie.base.widget.input_panel.audio.AudioPanelView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.vm.InputPanelVM;
import com.vanniktech.emoji.EmojiEditText;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentInputPanelBindingImpl extends FragmentInputPanelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9720a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f9726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f9727a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((FragmentInputPanelBinding) FragmentInputPanelBindingImpl.this).f9719a);
            InputPanelVM inputPanelVM = ((FragmentInputPanelBinding) FragmentInputPanelBindingImpl.this).f9718a;
            if (inputPanelVM != null) {
                MutableLiveData<String> mutableLiveDataR = inputPanelVM.r();
                if (mutableLiveDataR != null) {
                    mutableLiveDataR.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputPanelFragment.a f34430a;

        public b a(InputPanelFragment.a aVar) {
            this.f34430a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34430a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputPanelFragment.a f34431a;

        public c a(InputPanelFragment.a aVar) {
            this.f34431a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34431a.f(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputPanelFragment.a f34432a;

        public d a(InputPanelFragment.a aVar) {
            this.f34432a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34432a.d(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputPanelFragment.a f34433a;

        public e a(InputPanelFragment.a aVar) {
            this.f34433a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34433a.g(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputPanelFragment.a f34434a;

        public f a(InputPanelFragment.a aVar) {
            this.f34434a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34434a.e(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34428a = sparseIntArray;
        sparseIntArray.put(R.id.llEditBox, 10);
        sparseIntArray.put(R.id.vKeyboardSpace, 11);
    }

    public FragmentInputPanelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f9720a, f34428a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean zSafeUnbox3;
        boolean zSafeUnbox4;
        boolean zSafeUnbox5;
        boolean zSafeUnbox6;
        MutableLiveData<String> mutableLiveDataR;
        boolean zSafeUnbox7;
        boolean z;
        String value;
        int length;
        d dVar;
        f fVar;
        c cVar;
        b bVar;
        e eVar;
        String str;
        boolean z2;
        long j2;
        boolean z3;
        synchronized (this) {
            j = this.f9721a;
            this.f9721a = 0L;
        }
        InputPanelVM inputPanelVM = ((FragmentInputPanelBinding) this).f9718a;
        InputPanelFragment.a aVar = ((FragmentInputPanelBinding) this).f9717a;
        if ((383 & j) != 0) {
            if ((j & 321) != 0) {
                MutableLiveData<Boolean> mutableLiveDataL = inputPanelVM != null ? inputPanelVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
            } else {
                zSafeUnbox = false;
                zSafeUnbox3 = false;
            }
            long j3 = j & 330;
            if (j3 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = inputPanelVM != null ? inputPanelVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                zSafeUnbox7 = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j3 != 0) {
                    j = zSafeUnbox7 ? j | 1024 : j | 512;
                }
            } else {
                zSafeUnbox7 = false;
            }
            if ((j & 324) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = inputPanelVM != null ? inputPanelVM.p() : null;
                updateLiveDataRegistration(2, mutableLiveDataP);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 328) != 0) {
                mutableLiveDataR = inputPanelVM != null ? inputPanelVM.r() : null;
                updateLiveDataRegistration(3, mutableLiveDataR);
                value = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                length = value != null ? value.length() : 0;
                z3 = length > 0;
                j2 = 336;
            } else {
                mutableLiveDataR = null;
                j2 = 336;
                value = null;
                length = 0;
                z3 = false;
            }
            if ((j & j2) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = inputPanelVM != null ? inputPanelVM.o() : null;
                updateLiveDataRegistration(4, mutableLiveDataO);
                zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                zSafeUnbox5 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
            } else {
                zSafeUnbox4 = false;
                zSafeUnbox5 = false;
            }
            if ((j & 352) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = inputPanelVM != null ? inputPanelVM.m() : null;
                updateLiveDataRegistration(5, mutableLiveDataM);
                zSafeUnbox6 = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                z = z3;
            } else {
                z = z3;
                zSafeUnbox6 = false;
            }
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            zSafeUnbox3 = false;
            zSafeUnbox4 = false;
            zSafeUnbox5 = false;
            zSafeUnbox6 = false;
            mutableLiveDataR = null;
            zSafeUnbox7 = false;
            z = false;
            value = null;
            length = 0;
        }
        long j4 = j & 384;
        if (j4 == 0 || aVar == null) {
            dVar = null;
            fVar = null;
            cVar = null;
            bVar = null;
            eVar = null;
        } else {
            f fVar2 = this.f9727a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f9727a = fVar2;
            }
            f fVarA = fVar2.a(aVar);
            b bVar2 = this.f9723a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9723a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            c cVar2 = this.f9724a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f9724a = cVar2;
            }
            c cVarA = cVar2.a(aVar);
            d dVar2 = this.f9725a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f9725a = dVar2;
            }
            d dVarA = dVar2.a(aVar);
            e eVar2 = this.f9726a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f9726a = eVar2;
            }
            e eVarA = eVar2.a(aVar);
            cVar = cVarA;
            bVar = bVarA;
            fVar = fVarA;
            eVar = eVarA;
            dVar = dVarA;
        }
        if ((j & 1024) != 0) {
            MutableLiveData<String> mutableLiveDataR2 = inputPanelVM != null ? inputPanelVM.r() : mutableLiveDataR;
            updateLiveDataRegistration(3, mutableLiveDataR2);
            if (mutableLiveDataR2 != null) {
                value = mutableLiveDataR2.getValue();
            }
            if (value != null) {
                length = value.length();
            }
            z2 = length == 0;
            str = value;
        } else {
            zSafeUnbox4 = zSafeUnbox4;
            str = value;
            z2 = false;
        }
        long j5 = j & 330;
        boolean z4 = (j5 == 0 || !zSafeUnbox7) ? false : z2;
        if ((j & 352) != 0) {
            CommonBindingAdapter.l0(((FragmentInputPanelBinding) this).f9716a, zSafeUnbox6);
        }
        if ((j & 324) != 0) {
            CommonBindingAdapter.l0(((FragmentInputPanelBinding) this).f9712a, zSafeUnbox2);
        }
        if ((j & 328) != 0) {
            TextViewBindingAdapter.setText(((FragmentInputPanelBinding) this).f9719a, str);
            CommonBindingAdapter.l0(((FragmentInputPanelBinding) this).f9715a, z);
        }
        if ((256 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((FragmentInputPanelBinding) this).f9719a, null, null, null, this.f9722a);
        }
        if ((j & 321) != 0) {
            CommonBindingAdapter.l0(((FragmentInputPanelBinding) this).f9713a, zSafeUnbox);
            CommonBindingAdapter.l0(this.d, zSafeUnbox3);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(((FragmentInputPanelBinding) this).f9713a, bVar, null);
            CommonBindingAdapter.q(super.b, dVar, null);
            CommonBindingAdapter.q(this.c, fVar, null);
            CommonBindingAdapter.q(this.d, cVar, null);
            CommonBindingAdapter.q(this.e, cVar, null);
            CommonBindingAdapter.q(((FragmentInputPanelBinding) this).f9715a, eVar, null);
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(super.b, z4);
        }
        if ((j & 336) != 0) {
            CommonBindingAdapter.l0(this.c, zSafeUnbox4);
            CommonBindingAdapter.l0(this.e, zSafeUnbox5);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9721a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9721a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentInputPanelBinding
    public void l(@Nullable InputPanelFragment.a aVar) {
        ((FragmentInputPanelBinding) this).f9717a = aVar;
        synchronized (this) {
            this.f9721a |= 128;
        }
        notifyPropertyChanged(yk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentInputPanelBinding
    public void m(@Nullable InputPanelVM inputPanelVM) {
        ((FragmentInputPanelBinding) this).f9718a = inputPanelVM;
        synchronized (this) {
            this.f9721a |= 64;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9721a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9721a |= 32;
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
            return r((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9721a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9721a |= 16;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9721a |= 4;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9721a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 == i) {
            m((InputPanelVM) obj);
        } else {
            if (yk0.k != i) {
                return false;
            }
            l((InputPanelFragment.a) obj);
        }
        return true;
    }

    public FragmentInputPanelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (AudioPanelView) objArr[9], (FrameLayout) objArr[8], (EmojiEditText) objArr[3], (ImageView) objArr[1], (ImageView) objArr[6], (ImageView) objArr[4], (LinearLayout) objArr[10], (TextView) objArr[7], (View) objArr[11]);
        this.f9722a = new a();
        this.f9721a = -1L;
        ((FragmentInputPanelBinding) this).f9716a.setTag(null);
        ((FragmentInputPanelBinding) this).f9712a.setTag(null);
        ((FragmentInputPanelBinding) this).f9719a.setTag(null);
        ((FragmentInputPanelBinding) this).f9713a.setTag(null);
        super.b.setTag(null);
        this.c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.d = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[5];
        this.e = imageView2;
        imageView2.setTag(null);
        ((FragmentInputPanelBinding) this).f9715a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
