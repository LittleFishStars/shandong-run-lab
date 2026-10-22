package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.ConvertInterface;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesAdapter;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesVM;
import com.zj.adlib.ok0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentChooseClassesBindingImpl extends FragmentChooseClassesBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36472a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13466a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f13469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f13470a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChooseClassesVM f36473a;

        public OnRefreshListenerImpl a(ChooseClassesVM chooseClassesVM) {
            this.f36473a = chooseClassesVM;
            if (chooseClassesVM == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36473a.E();
        }
    }

    public FragmentChooseClassesBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13466a, f36472a));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        Integer value;
        ChooseClassesAdapter value2;
        ConvertInterface convertInterface;
        OnRefreshListenerImpl onRefreshListenerImplA;
        boolean zSafeUnbox;
        MutableLiveData<Integer> mutableLiveDataN;
        synchronized (this) {
            j = this.f13467a;
            this.f13467a = 0L;
        }
        ChooseClassesVM chooseClassesVM = ((FragmentChooseClassesBinding) this).f13465a;
        if ((31 & j) != 0) {
            if ((j & 25) != 0) {
                if (chooseClassesVM != null) {
                    mutableLiveDataN = chooseClassesVM.n();
                    convertInterface = ((BaseVM) chooseClassesVM).f8503a;
                } else {
                    mutableLiveDataN = null;
                    convertInterface = null;
                }
                updateLiveDataRegistration(0, mutableLiveDataN);
                value = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
            } else {
                value = null;
                convertInterface = null;
            }
            if ((j & 24) == 0 || chooseClassesVM == null) {
                onRefreshListenerImplA = null;
            } else {
                OnRefreshListenerImpl onRefreshListenerImpl = this.f13470a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f13470a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(chooseClassesVM);
            }
            if ((j & 26) == 0) {
                value2 = null;
            } else {
                MutableLiveData<ChooseClassesAdapter> mutableLiveDataJ = chooseClassesVM != null ? chooseClassesVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<Boolean> mutableLiveDataD = chooseClassesVM != null ? chooseClassesVM.D() : null;
                updateLiveDataRegistration(2, mutableLiveDataD);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataD != null ? mutableLiveDataD.getValue() : null);
            }
            if ((24 & j) != 0) {
                this.f13469a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((j & 28) != 0) {
                this.f13469a.setRefreshing(zSafeUnbox);
            }
            if ((26 & j) != 0) {
                CommonBindingAdapter.g(this.f13468a, value2, false, false);
            }
            if ((j & 25) != 0) {
                xq8.a(((FragmentChooseClassesBinding) this).f36471a, value, convertInterface);
            }
        }
        value = null;
        value2 = null;
        convertInterface = null;
        onRefreshListenerImplA = null;
        zSafeUnbox = false;
        if ((24 & j) != 0) {
            this.f13469a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 28) != 0) {
            this.f13469a.setRefreshing(zSafeUnbox);
        }
        if ((26 & j) != 0) {
            CommonBindingAdapter.g(this.f13468a, value2, false, false);
        }
        if ((j & 25) != 0) {
            xq8.a(((FragmentChooseClassesBinding) this).f36471a, value, convertInterface);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13467a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13467a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentChooseClassesBinding
    public void k(@Nullable ChooseClassesVM chooseClassesVM) {
        ((FragmentChooseClassesBinding) this).f13465a = chooseClassesVM;
        synchronized (this) {
            this.f13467a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ChooseClassesAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13467a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13467a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13467a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((ChooseClassesVM) obj);
        return true;
    }

    public FragmentChooseClassesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (StateLayout) objArr[1]);
        this.f13467a = -1L;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[0];
        this.f13469a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f13468a = recyclerView;
        recyclerView.setTag(null);
        ((FragmentChooseClassesBinding) this).f36471a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
