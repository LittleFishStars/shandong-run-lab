package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.huachenjie.im.vm.BaseSignalTowerVM;
import com.noober.background.view.BLView;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentFloatingSignalTowerBindingImpl extends FragmentFloatingSignalTowerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9710a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9711a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34426a = sparseIntArray;
        sparseIntArray.put(R.id.llChatBox, 4);
        sparseIntArray.put(R.id.tabContainer, 5);
        sparseIntArray.put(R.id.llTabContainer, 6);
        sparseIntArray.put(R.id.tabTeam, 7);
        sparseIntArray.put(R.id.tabOvert, 8);
        sparseIntArray.put(R.id.tabIndex, 9);
        sparseIntArray.put(R.id.normal_line, 10);
        sparseIntArray.put(R.id.centerLine, 11);
        sparseIntArray.put(R.id.ivHideChatBox, 12);
        sparseIntArray.put(R.id.ivDrag, 13);
        sparseIntArray.put(R.id.ivExpand, 14);
        sparseIntArray.put(R.id.ivShowChatBox, 15);
    }

    public FragmentFloatingSignalTowerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, f9710a, f34426a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.f9711a;
            this.f9711a = 0L;
        }
        BaseSignalTowerVM baseSignalTowerVM = ((FragmentFloatingSignalTowerBinding) this).f9703a;
        long j2 = j & 15;
        boolean z4 = true;
        boolean z5 = false;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveData = baseSignalTowerVM != null ? baseSignalTowerVM.m : null;
            updateLiveDataRegistration(0, mutableLiveData);
            int iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            z2 = iSafeUnbox == 1;
            if (j2 != 0) {
                j = z2 ? j | 32 | 128 : j | 16 | 64;
            }
            z = (j & 13) != 0 && iSafeUnbox == 0;
        } else {
            z = false;
            z2 = false;
        }
        if ((j & 160) != 0) {
            MutableLiveData<Integer> mutableLiveData2 = baseSignalTowerVM != null ? baseSignalTowerVM.n : null;
            updateLiveDataRegistration(1, mutableLiveData2);
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveData2 != null ? mutableLiveData2.getValue() : null);
            z3 = (128 & j) != 0 && iSafeUnbox2 == 1;
            if ((32 & j) == 0 || iSafeUnbox2 != 0) {
                z4 = false;
            }
        } else {
            z3 = false;
            z4 = false;
        }
        long j3 = 15 & j;
        if (j3 != 0) {
            if (!z2) {
                z4 = false;
            }
            if (z2) {
                z5 = z3;
            }
        } else {
            z4 = false;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(((FragmentFloatingSignalTowerBinding) this).f9702a, z5);
            CommonBindingAdapter.l0(((FragmentFloatingSignalTowerBinding) this).f9708b, z4);
        }
        if ((j & 13) != 0) {
            CommonBindingAdapter.l0(((FragmentFloatingSignalTowerBinding) this).f9709c, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9711a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9711a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentFloatingSignalTowerBinding
    public void k(@Nullable BaseSignalTowerVM baseSignalTowerVM) {
        ((FragmentFloatingSignalTowerBinding) this).f9703a = baseSignalTowerVM;
        synchronized (this) {
            this.f9711a |= 4;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9711a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9711a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 != i) {
            return false;
        }
        k((BaseSignalTowerVM) obj);
        return true;
    }

    public FragmentFloatingSignalTowerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[11], (ImageView) objArr[13], (ImageView) objArr[14], (ImageView) objArr[12], (ImageView) objArr[15], (LinearLayout) objArr[4], (LinearLayout) objArr[6], (RecyclerView) objArr[3], (View) objArr[10], (RecyclerView) objArr[2], (FrameLayout) objArr[0], (RelativeLayout) objArr[5], (BLView) objArr[9], (TextView) objArr[8], (TextView) objArr[7], (RecyclerView) objArr[1]);
        this.f9711a = -1L;
        ((FragmentFloatingSignalTowerBinding) this).f9702a.setTag(null);
        ((FragmentFloatingSignalTowerBinding) this).f9708b.setTag(null);
        ((FragmentFloatingSignalTowerBinding) this).f9697a.setTag(null);
        ((FragmentFloatingSignalTowerBinding) this).f9709c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
