package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.SchoolyardAdapter;
import com.huachenjie.sport.page.mine.huodong.SchoolyardFragment;
import com.huachenjie.sport.page.mine.huodong.SchoolyardVM;
import com.zj.adlib.ok0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentSchoolyardBindingImpl extends FragmentSchoolyardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13503a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f13507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f13508a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SchoolyardFragment.b f36483a;

        public OnRefreshListenerImpl a(SchoolyardFragment.b bVar) {
            this.f36483a = bVar;
            if (bVar == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36483a.a();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36482a = sparseIntArray;
        sparseIntArray.put(R.id.search_view, 4);
    }

    public FragmentSchoolyardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13503a, f36482a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        SchoolyardAdapter value;
        Integer value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f13504a;
            this.f13504a = 0L;
        }
        SchoolyardVM schoolyardVM = ((FragmentSchoolyardBinding) this).f13502a;
        SchoolyardFragment.b bVar = ((FragmentSchoolyardBinding) this).f13501a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataJ = schoolyardVM != null ? schoolyardVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = schoolyardVM != null ? schoolyardVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<SchoolyardAdapter> mutableLiveDataH = schoolyardVM != null ? schoolyardVM.h() : null;
                updateLiveDataRegistration(2, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value = mutableLiveDataH.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || bVar == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f13508a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f13508a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(bVar);
        }
        if (j2 != 0) {
            this.f13507a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((42 & j) != 0) {
            this.f13507a.setRefreshing(zSafeUnbox);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(this.f13506a, value, false, false);
        }
        if ((j & 41) != 0) {
            xq8.a(((FragmentSchoolyardBinding) this).f36481a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13504a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13504a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentSchoolyardBinding
    public void l(@Nullable SchoolyardFragment.b bVar) {
        ((FragmentSchoolyardBinding) this).f13501a = bVar;
        synchronized (this) {
            this.f13504a |= 16;
        }
        notifyPropertyChanged(ok0.R);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentSchoolyardBinding
    public void m(@Nullable SchoolyardVM schoolyardVM) {
        ((FragmentSchoolyardBinding) this).f13502a = schoolyardVM;
        synchronized (this) {
            this.f13504a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SchoolyardAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13504a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13504a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13504a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((SchoolyardVM) obj);
        } else {
            if (ok0.R != i) {
                return false;
            }
            l((SchoolyardFragment.b) obj);
        }
        return true;
    }

    public FragmentSchoolyardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (CommonSearchView) objArr[4], (StateLayout) objArr[2]);
        this.f13504a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13505a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f13507a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        this.f13506a = recyclerView;
        recyclerView.setTag(null);
        ((FragmentSchoolyardBinding) this).f36481a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
