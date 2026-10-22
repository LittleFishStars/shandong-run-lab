package com.huachenjie.im.databinding;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.huachenjie.im.page.TeamChatFragment;
import com.huachenjie.im.vm.TeamChatVM;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentChatTeamBindingImpl extends FragmentChatTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9680a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f9683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9684a;

    @NonNull
    public final FrameLayout b;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34417a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34417a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34417a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TeamChatFragment.e f34418a;

        public a a(TeamChatFragment.e eVar) {
            this.f34418a = eVar;
            if (eVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34418a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34416a = sparseIntArray;
        sparseIntArray.put(R.id.input_panel_container, 4);
    }

    public FragmentChatTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9680a, f34416a));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        BaseQuickAdapter baseQuickAdapterH;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        long j3;
        a aVarA;
        synchronized (this) {
            j = this.f9681a;
            this.f9681a = 0L;
        }
        TeamChatVM teamChatVM = ((FragmentChatTeamBinding) this).f9679a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((FragmentChatTeamBinding) this).f9676a;
        TeamChatFragment.e eVar = ((FragmentChatTeamBinding) this).f9678a;
        long j4 = 19 & j;
        if (j4 != 0) {
            MutableLiveData<Boolean> mutableLiveData = teamChatVM != null ? teamChatVM.m : null;
            updateLiveDataRegistration(0, mutableLiveData);
            zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            if ((j & 18) != 0 && teamChatVM != null) {
                baseQuickAdapterH = teamChatVM.h();
            }
            j2 = 20 & j;
            if (j2 != 0 || onRefreshListener == null) {
                onRefreshListenerImplA = null;
            } else {
                OnRefreshListenerImpl onRefreshListenerImpl = this.f9683a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f9683a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            j3 = 24 & j;
            if (j3 != 0 || eVar == null) {
                aVarA = null;
            } else {
                a aVar = this.f9684a;
                if (aVar == null) {
                    aVar = new a();
                    this.f9684a = aVar;
                }
                aVarA = aVar.a(eVar);
            }
            if (j3 != 0) {
                CommonBindingAdapter.q(this.b, aVarA, null);
                CommonBindingAdapter.q(((FragmentChatTeamBinding) this).f9677a, aVarA, null);
            }
            if ((j & 18) != 0) {
                CommonBindingAdapter.g(((FragmentChatTeamBinding) this).f9675a, baseQuickAdapterH, false, false);
            }
            if (j2 != 0) {
                ((FragmentChatTeamBinding) this).f9677a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if (j4 != 0) {
                ((FragmentChatTeamBinding) this).f9677a.setRefreshing(zSafeUnbox);
            }
        }
        zSafeUnbox = false;
        baseQuickAdapterH = null;
        j2 = 20 & j;
        if (j2 != 0) {
            onRefreshListenerImplA = null;
        } else {
            onRefreshListenerImplA = null;
        }
        j3 = 24 & j;
        if (j3 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(((FragmentChatTeamBinding) this).f9677a, aVarA, null);
        }
        if ((j & 18) != 0) {
            CommonBindingAdapter.g(((FragmentChatTeamBinding) this).f9675a, baseQuickAdapterH, false, false);
        }
        if (j2 != 0) {
            ((FragmentChatTeamBinding) this).f9677a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if (j4 != 0) {
            ((FragmentChatTeamBinding) this).f9677a.setRefreshing(zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9681a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9681a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentChatTeamBinding
    public void m(@Nullable TeamChatFragment.e eVar) {
        ((FragmentChatTeamBinding) this).f9678a = eVar;
        synchronized (this) {
            this.f9681a |= 8;
        }
        notifyPropertyChanged(yk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentChatTeamBinding
    public void n(@Nullable TeamChatVM teamChatVM) {
        ((FragmentChatTeamBinding) this).f9679a = teamChatVM;
        synchronized (this) {
            this.f9681a |= 2;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9681a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.im.databinding.FragmentChatTeamBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((FragmentChatTeamBinding) this).f9676a = onRefreshListener;
        synchronized (this) {
            this.f9681a |= 4;
        }
        notifyPropertyChanged(yk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.p0 == i) {
            n((TeamChatVM) obj);
        } else if (yk0.R == i) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        } else {
            if (yk0.k != i) {
                return false;
            }
            m((TeamChatFragment.e) obj);
        }
        return true;
    }

    public FragmentChatTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[4], (RecyclerView) objArr[3], (SwipeRefreshLayout) objArr[2]);
        this.f9681a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9682a = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.b = frameLayout;
        frameLayout.setTag(null);
        ((FragmentChatTeamBinding) this).f9675a.setTag(null);
        ((FragmentChatTeamBinding) this).f9677a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
