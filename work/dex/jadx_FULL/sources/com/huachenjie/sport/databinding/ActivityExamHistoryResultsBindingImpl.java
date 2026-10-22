package com.huachenjie.sport.databinding;

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
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsAdapter;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityExamHistoryResultsBindingImpl extends ActivityExamHistoryResultsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f13229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f13231a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36398a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f36398a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36398a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f13226a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f36397a = null;
    }

    public ActivityExamHistoryResultsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13226a, f36397a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ExamHistoryResultsAdapter value;
        BindingTitleBean value2;
        boolean zSafeUnbox;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f13227a;
            this.f13227a = 0L;
        }
        ExamHistoryResultsVM examHistoryResultsVM = ((ActivityExamHistoryResultsBinding) this).f13225a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ActivityExamHistoryResultsBinding) this).f13224a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData = examHistoryResultsVM != null ? examHistoryResultsVM.i : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value2 = mutableLiveData.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataL = examHistoryResultsVM != null ? examHistoryResultsVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<ExamHistoryResultsAdapter> mutableLiveDataH = examHistoryResultsVM != null ? examHistoryResultsVM.h() : null;
                updateLiveDataRegistration(2, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value = mutableLiveDataH.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            zSafeUnbox = false;
        }
        long j2 = j & 48;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f13231a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f13231a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((j & 41) != 0) {
            this.f13230a.k(value2);
        }
        if (j2 != 0) {
            this.f13229a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 42) != 0) {
            this.f13229a.setRefreshing(zSafeUnbox);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.g(((ActivityExamHistoryResultsBinding) this).f36396a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13230a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13227a != 0) {
                return true;
            }
            return this.f13230a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13227a = 32L;
        }
        this.f13230a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamHistoryResultsBinding
    public void l(@Nullable ExamHistoryResultsVM examHistoryResultsVM) {
        ((ActivityExamHistoryResultsBinding) this).f13225a = examHistoryResultsVM;
        synchronized (this) {
            this.f13227a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<ExamHistoryResultsAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13227a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13227a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13227a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13230a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamHistoryResultsBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ActivityExamHistoryResultsBinding) this).f13224a = onRefreshListener;
        synchronized (this) {
            this.f13227a |= 16;
        }
        notifyPropertyChanged(ok0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            l((ExamHistoryResultsVM) obj);
        } else {
            if (ok0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public ActivityExamHistoryResultsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[2]);
        this.f13227a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f13230a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13228a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f13229a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        ((ActivityExamHistoryResultsBinding) this).f36396a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
