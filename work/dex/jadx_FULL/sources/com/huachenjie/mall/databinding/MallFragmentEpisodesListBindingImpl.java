package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.page.episodes_detail.EpisodesListAdapter;
import com.huachenjie.mall.page.episodes_detail.EpisodesListVM;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallFragmentEpisodesListBindingImpl extends MallFragmentEpisodesListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34953a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10674a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10675a;

    public MallFragmentEpisodesListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f10674a, f34953a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10675a;
            this.f10675a = 0L;
        }
        EpisodesListVM episodesListVM = ((MallFragmentEpisodesListBinding) this).f10673a;
        long j2 = j & 7;
        EpisodesListAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<EpisodesListAdapter> mutableLiveDataI = episodesListVM != null ? episodesListVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((MallFragmentEpisodesListBinding) this).f34952a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10675a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10675a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFragmentEpisodesListBinding
    public void k(@Nullable EpisodesListVM episodesListVM) {
        ((MallFragmentEpisodesListBinding) this).f10673a = episodesListVM;
        synchronized (this) {
            this.f10675a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<EpisodesListAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10675a |= 1;
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
        if (hk0.p0 != i) {
            return false;
        }
        k((EpisodesListVM) obj);
        return true;
    }

    public MallFragmentEpisodesListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[0]);
        this.f10675a = -1L;
        ((MallFragmentEpisodesListBinding) this).f34952a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
