package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.external.adapter.CommodityAdapter;
import com.huachenjie.mall.page.home_tab.search.MallSearchActivity;
import com.huachenjie.mall.page.home_tab.search.MallSearchVM;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityMallSearchBindingImpl extends MallActivityMallSearchBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10272a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10277a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallSearchActivity.a f34813a;

        public a a(MallSearchActivity.a aVar) {
            this.f34813a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34813a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallSearchActivity.a f34814a;

        public b a(MallSearchActivity.a aVar) {
            this.f34814a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34814a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallSearchActivity.a f34815a;

        public c a(MallSearchActivity.a aVar) {
            this.f34815a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34815a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34812a = sparseIntArray;
        sparseIntArray.put(R.id.search_view, 7);
        sparseIntArray.put(R.id.tv_search_history, 8);
        sparseIntArray.put(R.id.flowLevel, 9);
    }

    public MallActivityMallSearchBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f10272a, f34812a));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean z;
        CommodityAdapter value;
        boolean zSafeUnbox3;
        int i;
        b bVarA;
        c cVarA;
        a aVarA;
        boolean zSafeUnbox4;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f10273a;
            this.f10273a = 0L;
        }
        MallSearchVM mallSearchVM = ((MallActivityMallSearchBinding) this).f10271a;
        MallSearchActivity.a aVar = ((MallActivityMallSearchBinding) this).f10270a;
        if ((95 & j) != 0) {
            if ((j & 81) != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = mallSearchVM != null ? mallSearchVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                zSafeUnbox4 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox2));
            } else {
                zSafeUnbox2 = false;
                zSafeUnbox4 = false;
            }
            if ((j & 82) != 0) {
                BaseViewModel.b bVarE = mallSearchVM != null ? mallSearchVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 84) == 0) {
                value = null;
            } else {
                MutableLiveData<CommodityAdapter> mutableLiveDataI = mallSearchVM != null ? mallSearchVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 88) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = mallSearchVM != null ? mallSearchVM.m() : null;
                updateLiveDataRegistration(3, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
                i = iSafeUnbox;
                z = zSafeUnbox4;
            } else {
                i = iSafeUnbox;
                z = zSafeUnbox4;
                zSafeUnbox = false;
                zSafeUnbox3 = false;
            }
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            z = false;
            value = null;
            zSafeUnbox3 = false;
            i = 0;
        }
        long j2 = j & 96;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        } else {
            c cVar = this.f10277a;
            if (cVar == null) {
                cVar = new c();
                this.f10277a = cVar;
            }
            cVarA = cVar.a(aVar);
            a aVar2 = this.f10275a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10275a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f10276a;
            if (bVar == null) {
                bVar = new b();
                this.f10276a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 82) != 0) {
            CommonBindingAdapter.O(this.f10274a, 0, i, 0, 0, null);
        }
        if ((81 & j) != 0) {
            CommonBindingAdapter.l0(this.c, z);
            CommonBindingAdapter.l0(this.d, zSafeUnbox2);
            CommonBindingAdapter.l0(((MallActivityMallSearchBinding) this).f10265a, zSafeUnbox2);
            CommonBindingAdapter.l0(((MallActivityMallSearchBinding) this).f34811a, zSafeUnbox2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.c, cVarA, null);
            CommonBindingAdapter.q(this.d, bVarA, null);
            CommonBindingAdapter.q(((MallActivityMallSearchBinding) this).f10265a, aVarA, null);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.l0(((MallActivityMallSearchBinding) this).f10268a, zSafeUnbox3);
            CommonBindingAdapter.l0(((MallActivityMallSearchBinding) this).f10267a, zSafeUnbox);
        }
        if ((j & 84) != 0) {
            CommonBindingAdapter.g(((MallActivityMallSearchBinding) this).f10268a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10273a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10273a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMallSearchBinding
    public void l(@Nullable MallSearchActivity.a aVar) {
        ((MallActivityMallSearchBinding) this).f10270a = aVar;
        synchronized (this) {
            this.f10273a |= 32;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMallSearchBinding
    public void m(@Nullable MallSearchVM mallSearchVM) {
        ((MallActivityMallSearchBinding) this).f10271a = mallSearchVM;
        synchronized (this) {
            this.f10273a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<CommodityAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10273a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10273a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10273a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10273a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((MallSearchVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((MallSearchActivity.a) obj);
        }
        return true;
    }

    public MallActivityMallSearchBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Flow) objArr[9], (RecyclerView) objArr[1], (ConstraintLayout) objArr[2], (CommonSearchView) objArr[7], (TextView) objArr[4], (TextView) objArr[8], (View) objArr[5]);
        this.f10273a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10274a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.d = textView2;
        textView2.setTag(null);
        ((MallActivityMallSearchBinding) this).f10268a.setTag(null);
        ((MallActivityMallSearchBinding) this).f10267a.setTag(null);
        ((MallActivityMallSearchBinding) this).f10265a.setTag(null);
        ((MallActivityMallSearchBinding) this).f34811a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
