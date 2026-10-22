package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.college.page.point_activity.PointActivityListAdapter;
import com.huachenjie.college.page.point_activity.PointActivityListVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.zj.adlib.uk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeActivityPointActivityListBindingImpl extends CollegeActivityPointActivityListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f8375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f8376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f8377a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33563a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33563a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33563a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f8372a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f33562a = null;
    }

    public CollegeActivityPointActivityListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f8372a, f33562a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        PointActivityListAdapter value;
        Integer value2;
        BindingTitleBean value3;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f8373a;
            this.f8373a = 0L;
        }
        PointActivityListVM pointActivityListVM = ((CollegeActivityPointActivityListBinding) this).f8370a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((CollegeActivityPointActivityListBinding) this).f8369a;
        if ((95 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = pointActivityListVM != null ? pointActivityListVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 82) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = pointActivityListVM != null ? pointActivityListVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = pointActivityListVM != null ? pointActivityListVM.v() : null;
                updateLiveDataRegistration(2, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<PointActivityListAdapter> mutableLiveDataB = pointActivityListVM != null ? pointActivityListVM.B() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
            value3 = null;
        }
        long j2 = j & 96;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f8376a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f8376a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((82 & j) != 0) {
            this.f8377a.k(value3);
        }
        if (j2 != 0) {
            this.f8375a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 84) != 0) {
            this.f8375a.setRefreshing(zSafeUnbox);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.g(((CollegeActivityPointActivityListBinding) this).f33561a, value, false, false);
        }
        if ((j & 81) != 0) {
            xq8.a(((CollegeActivityPointActivityListBinding) this).f8371a, value2, null);
        }
        ViewDataBinding.executeBindingsOn(this.f8377a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f8373a != 0) {
                return true;
            }
            return this.f8377a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8373a = 64L;
        }
        this.f8377a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityPointActivityListBinding
    public void l(@Nullable PointActivityListVM pointActivityListVM) {
        ((CollegeActivityPointActivityListBinding) this).f8370a = pointActivityListVM;
        synchronized (this) {
            this.f8373a |= 16;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<PointActivityListAdapter> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8373a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8373a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8373a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8373a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f8377a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityPointActivityListBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((CollegeActivityPointActivityListBinding) this).f8369a = onRefreshListener;
        synchronized (this) {
            this.f8373a |= 32;
        }
        notifyPropertyChanged(uk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 == i) {
            l((PointActivityListVM) obj);
        } else {
            if (uk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public CollegeActivityPointActivityListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RecyclerView) objArr[3], (StateLayout) objArr[2]);
        this.f8373a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f8377a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f8374a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f8375a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((CollegeActivityPointActivityListBinding) this).f33561a.setTag(null);
        ((CollegeActivityPointActivityListBinding) this).f8371a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
