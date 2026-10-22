package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.inspiration_record.InspirationRecordFVM;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeFragmentInsporationRecordBindingImpl extends HomeFragmentInsporationRecordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9406a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9409a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34250a = sparseIntArray;
        sparseIntArray.put(R.id.state_layout, 2);
    }

    public HomeFragmentInsporationRecordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f9406a, f34250a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9407a;
            this.f9407a = 0L;
        }
        InspirationRecordFVM inspirationRecordFVM = ((HomeFragmentInsporationRecordBinding) this).f9405a;
        long j2 = j & 7;
        BaseQuickAdapter<?, ?> value = null;
        if (j2 != 0) {
            MutableLiveData<BaseQuickAdapter<?, ?>> mutableLiveDataB = inspirationRecordFVM != null ? inspirationRecordFVM.B() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            if (mutableLiveDataB != null) {
                value = mutableLiveDataB.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f9409a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9407a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9407a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentInsporationRecordBinding
    public void k(@Nullable InspirationRecordFVM inspirationRecordFVM) {
        ((HomeFragmentInsporationRecordBinding) this).f9405a = inspirationRecordFVM;
        synchronized (this) {
            this.f9407a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9407a |= 1;
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
        if (xk0.p0 != i) {
            return false;
        }
        k((InspirationRecordFVM) obj);
        return true;
    }

    public HomeFragmentInsporationRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (StateLayout) objArr[2]);
        this.f9407a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9408a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f9409a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
