package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentDressingTableNicknameBindingImpl extends MineFragmentDressingTableNicknameBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35309a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11234a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11235a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f11237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11240a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((MineFragmentDressingTableNicknameBinding) MineFragmentDressingTableNicknameBindingImpl.this).f35308a);
            NicknameVM nicknameVM = ((MineFragmentDressingTableNicknameBinding) MineFragmentDressingTableNicknameBindingImpl.this).f11233a;
            if (nicknameVM != null) {
                MutableLiveData<String> mutableLiveDataI = nicknameVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NicknameFragment.a f35311a;

        public b a(NicknameFragment.a aVar) {
            this.f35311a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35311a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NicknameFragment.a f35312a;

        public c a(NicknameFragment.a aVar) {
            this.f35312a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35312a.a(view);
        }
    }

    public MineFragmentDressingTableNicknameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f11234a, f35309a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f11235a;
            this.f11235a = 0L;
        }
        NicknameVM nicknameVM = ((MineFragmentDressingTableNicknameBinding) this).f11233a;
        NicknameFragment.a aVar = ((MineFragmentDressingTableNicknameBinding) this).f11232a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<String> mutableLiveDataI = nicknameVM != null ? nicknameVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = 12 & j;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f11239a;
            if (cVar == null) {
                cVar = new c();
                this.f11239a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f11238a;
            if (bVar == null) {
                bVar = new b();
                this.f11238a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((MineFragmentDressingTableNicknameBinding) this).f35308a, value);
        }
        if ((j & 8) != 0) {
            TextViewBindingAdapter.setTextWatcher(((MineFragmentDressingTableNicknameBinding) this).f35308a, null, null, null, this.f11237a);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MineFragmentDressingTableNicknameBinding) this).f11231a, cVarA, null);
            CommonBindingAdapter.q(this.f11240a, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11235a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11235a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentDressingTableNicknameBinding
    public void l(@Nullable NicknameFragment.a aVar) {
        ((MineFragmentDressingTableNicknameBinding) this).f11232a = aVar;
        synchronized (this) {
            this.f11235a |= 4;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentDressingTableNicknameBinding
    public void m(@Nullable NicknameVM nicknameVM) {
        ((MineFragmentDressingTableNicknameBinding) this).f11233a = nicknameVM;
        synchronized (this) {
            this.f11235a |= 2;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11235a |= 1;
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
        if (ik0.p0 == i) {
            m((NicknameVM) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((NicknameFragment.a) obj);
        }
        return true;
    }

    public MineFragmentDressingTableNicknameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[1], (ImageView) objArr[2]);
        this.f11237a = new a();
        this.f11235a = -1L;
        ((MineFragmentDressingTableNicknameBinding) this).f35308a.setTag(null);
        ((MineFragmentDressingTableNicknameBinding) this).f11231a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f11236a = relativeLayout;
        relativeLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f11240a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
