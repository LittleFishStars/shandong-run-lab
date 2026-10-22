package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksAdapter;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityHuodongRunRanksBindingImpl extends ActivityHuodongRunRanksBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13285a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f13283a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f36412a = null;
    }

    public ActivityHuodongRunRanksBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13283a, f36412a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f13284a;
            this.f13284a = 0L;
        }
        HuodongRunRanksVM huodongRunRanksVM = ((ActivityHuodongRunRanksBinding) this).f13282a;
        HuodongRunRanksAdapter value2 = null;
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData = huodongRunRanksVM != null ? huodongRunRanksVM.i : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value = mutableLiveData.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 26) != 0) {
                MutableLiveData<HuodongRunRanksAdapter> mutableLiveDataK = huodongRunRanksVM != null ? huodongRunRanksVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((26 & j) != 0) {
            CommonBindingAdapter.g(((ActivityHuodongRunRanksBinding) this).f36411a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((ActivityHuodongRunRanksBinding) this).f13281a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((ActivityHuodongRunRanksBinding) this).f13281a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13284a != 0) {
                return true;
            }
            return ((ActivityHuodongRunRanksBinding) this).f13281a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13284a = 16L;
        }
        ((ActivityHuodongRunRanksBinding) this).f13281a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityHuodongRunRanksBinding
    public void k(@Nullable HuodongRunRanksVM huodongRunRanksVM) {
        ((ActivityHuodongRunRanksBinding) this).f13282a = huodongRunRanksVM;
        synchronized (this) {
            this.f13284a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13284a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<HuodongRunRanksAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13284a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13284a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ActivityHuodongRunRanksBinding) this).f13281a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((HuodongRunRanksVM) obj);
        return true;
    }

    public ActivityHuodongRunRanksBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[1], (LayoutToolbarBindingBinding) objArr[2]);
        this.f13284a = -1L;
        ((ActivityHuodongRunRanksBinding) this).f36411a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13285a = frameLayout;
        frameLayout.setTag(null);
        setContainedBinding(((ActivityHuodongRunRanksBinding) this).f13281a);
        setRootTag(view);
        invalidateAll();
    }
}
