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
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.huachenjie.im.page.SignalTowerFragment;
import com.huachenjie.im.vm.SignalTowerVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.fe9;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentSignalTowerBindingImpl extends FragmentSignalTowerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9737a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9742a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SignalTowerFragment.h f34437a;

        public a a(SignalTowerFragment.h hVar) {
            this.f34437a = hVar;
            if (hVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34437a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SignalTowerFragment.h f34438a;

        public b a(SignalTowerFragment.h hVar) {
            this.f34438a = hVar;
            if (hVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34438a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34436a = sparseIntArray;
        sparseIntArray.put(R.id.flContainer, 6);
        sparseIntArray.put(R.id.bottomTabContainer, 7);
        sparseIntArray.put(R.id.bottomTabTeam, 8);
        sparseIntArray.put(R.id.bottomTabSplitLine, 9);
        sparseIntArray.put(R.id.bottomTabOvert, 10);
        sparseIntArray.put(R.id.input_panel_container, 11);
    }

    public FragmentSignalTowerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f9737a, f34436a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        MutableLiveData<Integer> mutableLiveData;
        boolean zSafeUnbox;
        Integer value;
        boolean z3;
        a aVarA;
        b bVarA;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j = this.f9738a;
            this.f9738a = 0L;
        }
        SignalTowerVM signalTowerVM = ((FragmentSignalTowerBinding) this).f9732a;
        SignalTowerFragment.h hVar = ((FragmentSignalTowerBinding) this).f9731a;
        if ((47 & j) != 0) {
            long j2 = j & 43;
            if (j2 != 0) {
                MutableLiveData<Integer> mutableLiveData2 = signalTowerVM != null ? signalTowerVM.m : null;
                updateLiveDataRegistration(0, mutableLiveData2);
                int iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? mutableLiveData2.getValue() : null);
                z2 = iSafeUnbox == 1;
                if (j2 != 0) {
                    j = z2 ? j | 128 | 2048 : j | 64 | 1024;
                }
                z = (j & 41) != 0 && iSafeUnbox == 0;
            } else {
                z = false;
                z2 = false;
            }
            long j3 = j & 42;
            if (j3 != 0) {
                mutableLiveData = signalTowerVM != null ? signalTowerVM.n : null;
                updateLiveDataRegistration(1, mutableLiveData);
                value = mutableLiveData != null ? mutableLiveData.getValue() : null;
                z3 = ViewDataBinding.safeUnbox(value) == 0;
                if (j3 != 0) {
                    j = z3 ? j | 512 : j | 256;
                }
                str = z3 ? "全国" : fe9.b.ALUMNI;
            } else {
                str = null;
                mutableLiveData = null;
                value = null;
                z3 = false;
            }
            if ((j & 44) != 0) {
                MutableLiveData<Boolean> mutableLiveData3 = signalTowerVM != null ? signalTowerVM.o : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(mutableLiveData3 != null ? mutableLiveData3.getValue() : null)));
            } else {
                zSafeUnbox = false;
            }
        } else {
            z = false;
            str = null;
            z2 = false;
            mutableLiveData = null;
            zSafeUnbox = false;
            value = null;
            z3 = false;
        }
        if ((j & 48) == 0 || hVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f9742a;
            if (bVar == null) {
                bVar = new b();
                this.f9742a = bVar;
            }
            bVarA = bVar.a(hVar);
            a aVar = this.f9741a;
            if (aVar == null) {
                aVar = new a();
                this.f9741a = aVar;
            }
            aVarA = aVar.a(hVar);
        }
        if ((2176 & j) != 0) {
            if (signalTowerVM != null) {
                mutableLiveData = signalTowerVM.n;
            }
            updateLiveDataRegistration(1, mutableLiveData);
            if (mutableLiveData != null) {
                value = mutableLiveData.getValue();
            }
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(value);
            z4 = (j & 2048) != 0 && iSafeUnbox2 == 1;
            if ((128 & j) != 0) {
                boolean z6 = iSafeUnbox2 == 0;
                if ((j & 42) != 0) {
                    j |= z6 ? 512L : 256L;
                }
                z3 = z6;
            }
        } else {
            z4 = false;
        }
        long j4 = j & 43;
        if (j4 != 0) {
            if (!z2) {
                z3 = false;
            }
            if (!z2) {
                z4 = false;
            }
            z5 = z3;
        } else {
            z5 = false;
            z4 = false;
        }
        if ((j & 48) != 0) {
            CommonBindingAdapter.q(this.f9739a, bVarA, null);
            CommonBindingAdapter.q(((FragmentSignalTowerBinding) this).c, aVarA, null);
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(((FragmentSignalTowerBinding) this).f9730a, z4);
            CommonBindingAdapter.l0(((FragmentSignalTowerBinding) this).f9735b, z5);
        }
        if ((41 & j) != 0) {
            CommonBindingAdapter.l0(((FragmentSignalTowerBinding) this).f9736c, z);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.l0(((FragmentSignalTowerBinding) this).c, zSafeUnbox);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((FragmentSignalTowerBinding) this).c, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9738a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9738a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentSignalTowerBinding
    public void l(@Nullable SignalTowerFragment.h hVar) {
        ((FragmentSignalTowerBinding) this).f9731a = hVar;
        synchronized (this) {
            this.f9738a |= 16;
        }
        notifyPropertyChanged(yk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentSignalTowerBinding
    public void m(@Nullable SignalTowerVM signalTowerVM) {
        ((FragmentSignalTowerBinding) this).f9732a = signalTowerVM;
        synchronized (this) {
            this.f9738a |= 8;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9738a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9738a |= 4;
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
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9738a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 == i) {
            m((SignalTowerVM) obj);
        } else {
            if (yk0.k != i) {
                return false;
            }
            l((SignalTowerFragment.h) obj);
        }
        return true;
    }

    public FragmentSignalTowerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BLLinearLayout) objArr[7], (TextView) objArr[10], (View) objArr[9], (TextView) objArr[8], (FrameLayout) objArr[6], (FrameLayout) objArr[11], (RecyclerView) objArr[5], (RecyclerView) objArr[4], (RecyclerView) objArr[3], (TextView) objArr[2]);
        this.f9738a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9740a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f9739a = imageView;
        imageView.setTag(null);
        ((FragmentSignalTowerBinding) this).f9730a.setTag(null);
        ((FragmentSignalTowerBinding) this).f9735b.setTag(null);
        ((FragmentSignalTowerBinding) this).f9736c.setTag(null);
        ((FragmentSignalTowerBinding) this).c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
