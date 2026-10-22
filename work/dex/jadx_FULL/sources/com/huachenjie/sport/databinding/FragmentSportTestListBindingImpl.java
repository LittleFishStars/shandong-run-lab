package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.page.statelayout.ConvertInterface;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListVM;
import com.zj.adlib.ok0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentSportTestListBindingImpl extends FragmentSportTestListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13517a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13518a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36487a = sparseIntArray;
        sparseIntArray.put(R.id.rv, 1);
    }

    public FragmentSportTestListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13517a, f36487a));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        ConvertInterface convertInterface;
        Integer value;
        Integer value2;
        synchronized (this) {
            j = this.f13518a;
            this.f13518a = 0L;
        }
        SportTestListVM sportTestListVM = ((FragmentSportTestListBinding) this).f13515a;
        Integer num = ((FragmentSportTestListBinding) this).f13516a;
        long j2 = j & 31;
        Integer num2 = null;
        if (j2 != 0) {
            convertInterface = sportTestListVM != null ? ((BaseVM) sportTestListVM).f8503a : null;
            z = ViewDataBinding.safeUnbox(num) == 1;
            if (j2 != 0) {
                j = z ? j | 64 : j | 32;
            }
        } else {
            z = false;
            convertInterface = null;
        }
        if ((j & 32) == 0) {
            value = null;
        } else {
            MutableLiveData<Integer> mutableLiveDataH = sportTestListVM != null ? sportTestListVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            if (mutableLiveDataH != null) {
                value = mutableLiveDataH.getValue();
            } else {
                value = null;
            }
        }
        if ((j & 64) == 0) {
            value2 = null;
        } else {
            MutableLiveData<Integer> mutableLiveDataL = sportTestListVM != null ? sportTestListVM.l() : null;
            updateLiveDataRegistration(1, mutableLiveDataL);
            if (mutableLiveDataL != null) {
                value2 = mutableLiveDataL.getValue();
            } else {
                value2 = null;
            }
        }
        long j3 = j & 31;
        if (j3 != 0) {
            num2 = z ? value2 : value;
        }
        Integer num3 = num2;
        if (j3 != 0) {
            xq8.a(((FragmentSportTestListBinding) this).f13514a, num3, convertInterface);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13518a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13518a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentSportTestListBinding
    public void k(@Nullable Integer num) {
        ((FragmentSportTestListBinding) this).f13516a = num;
        synchronized (this) {
            this.f13518a |= 8;
        }
        notifyPropertyChanged(ok0.o0);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentSportTestListBinding
    public void l(@Nullable SportTestListVM sportTestListVM) {
        ((FragmentSportTestListBinding) this).f13515a = sportTestListVM;
        synchronized (this) {
            this.f13518a |= 4;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13518a |= 1;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13518a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            l((SportTestListVM) obj);
        } else {
            if (ok0.o0 != i) {
                return false;
            }
            k((Integer) obj);
        }
        return true;
    }

    public FragmentSportTestListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[1], (StateLayout) objArr[0]);
        this.f13518a = -1L;
        ((FragmentSportTestListBinding) this).f13514a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
