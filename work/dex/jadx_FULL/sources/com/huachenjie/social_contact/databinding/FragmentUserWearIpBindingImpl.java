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
import com.huachenjie.social_contact.page.suit.UserWearIPAdapter;
import com.huachenjie.social_contact.page.suit.UserWearIPVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentUserWearIpBindingImpl extends FragmentUserWearIpBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36166a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12928a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12930a;

    public FragmentUserWearIpBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12928a, f36166a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12929a;
            this.f12929a = 0L;
        }
        UserWearIPVM userWearIPVM = ((FragmentUserWearIpBinding) this).f36165a;
        long j2 = j & 7;
        UserWearIPAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<UserWearIPAdapter> mutableLiveDataI = userWearIPVM != null ? userWearIPVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f12930a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12929a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12929a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.FragmentUserWearIpBinding
    public void k(@Nullable UserWearIPVM userWearIPVM) {
        ((FragmentUserWearIpBinding) this).f36165a = userWearIPVM;
        synchronized (this) {
            this.f12929a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<UserWearIPAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12929a |= 1;
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
        k((UserWearIPVM) obj);
        return true;
    }

    public FragmentUserWearIpBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f12929a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f12930a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
