package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.CommonSearchViewV2;
import com.huachenjie.login.R;
import com.huachenjie.login.page.school.SearchSchoolActivity;
import com.huachenjie.login.page.school.SearchSchoolAdapter;
import com.huachenjie.login.page.school.SearchSchoolVM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivitySearchSchoolBindingImpl extends LoginActivitySearchSchoolBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10043a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10047a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34669a = sparseIntArray;
        sparseIntArray.put(R.id.search_view, 3);
    }

    public LoginActivitySearchSchoolBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10043a, f34669a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f10044a;
            this.f10044a = 0L;
        }
        SearchSchoolVM searchSchoolVM = ((LoginActivitySearchSchoolBinding) this).f10042a;
        SearchSchoolAdapter value = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = searchSchoolVM != null ? searchSchoolVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 22) != 0) {
                MutableLiveData<SearchSchoolAdapter> mutableLiveDataJ = searchSchoolVM != null ? searchSchoolVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                }
            }
            i = iSafeUnbox;
        } else {
            i = 0;
        }
        if ((21 & j) != 0) {
            CommonBindingAdapter.I(this.f10046a, 0, i, 0, 0, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f10047a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10044a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10044a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivitySearchSchoolBinding
    public void l(@Nullable SearchSchoolActivity.a aVar) {
        ((LoginActivitySearchSchoolBinding) this).f10041a = aVar;
    }

    @Override // com.huachenjie.login.databinding.LoginActivitySearchSchoolBinding
    public void m(@Nullable SearchSchoolVM searchSchoolVM) {
        ((LoginActivitySearchSchoolBinding) this).f10042a = searchSchoolVM;
        synchronized (this) {
            this.f10044a |= 4;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SearchSchoolAdapter> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10044a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10044a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((SearchSchoolVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((SearchSchoolActivity.a) obj);
        }
        return true;
    }

    public LoginActivitySearchSchoolBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CommonSearchViewV2) objArr[3]);
        this.f10044a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10045a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f10046a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f10047a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
