package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.page.suit.UserWearSuitAdapter;
import com.huachenjie.social_contact.page.suit.UserWearSuitListVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentUserWearSuitListBindingImpl extends FragmentUserWearSuitListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36170a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12936a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12937a;

    public FragmentUserWearSuitListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12936a, f36170a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12937a;
            this.f12937a = 0L;
        }
        UserWearSuitListVM userWearSuitListVM = ((FragmentUserWearSuitListBinding) this).f12935a;
        long j2 = j & 7;
        UserWearSuitAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<UserWearSuitAdapter> mutableLiveDataJ = userWearSuitListVM != null ? userWearSuitListVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((FragmentUserWearSuitListBinding) this).f36169a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12937a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12937a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.FragmentUserWearSuitListBinding
    public void k(@Nullable UserWearSuitListVM userWearSuitListVM) {
        ((FragmentUserWearSuitListBinding) this).f12935a = userWearSuitListVM;
        synchronized (this) {
            this.f12937a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<UserWearSuitAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12937a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 != i) {
            return false;
        }
        k((UserWearSuitListVM) obj);
        return true;
    }

    public FragmentUserWearSuitListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[0]);
        this.f12937a = -1L;
        ((FragmentUserWearSuitListBinding) this).f36169a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
