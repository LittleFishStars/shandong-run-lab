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
import com.huachenjie.social_contact.page.suit.UserWearGameAdapter;
import com.huachenjie.social_contact.page.suit.UserWearGameVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentUserWearGameBindingImpl extends FragmentUserWearGameBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36164a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12925a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12927a;

    public FragmentUserWearGameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f12925a, f36164a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12926a;
            this.f12926a = 0L;
        }
        UserWearGameVM userWearGameVM = ((FragmentUserWearGameBinding) this).f36163a;
        long j2 = j & 7;
        UserWearGameAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<UserWearGameAdapter> mutableLiveDataH = userWearGameVM != null ? userWearGameVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            if (mutableLiveDataH != null) {
                value = mutableLiveDataH.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f12927a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12926a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12926a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.FragmentUserWearGameBinding
    public void k(@Nullable UserWearGameVM userWearGameVM) {
        ((FragmentUserWearGameBinding) this).f36163a = userWearGameVM;
        synchronized (this) {
            this.f12926a |= 2;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<UserWearGameAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12926a |= 1;
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
        k((UserWearGameVM) obj);
        return true;
    }

    public FragmentUserWearGameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f12926a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f12927a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
