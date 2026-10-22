package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameAdapter;
import com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameVM;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentAvatarFrameBindingImpl extends MineFragmentAvatarFrameBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35304a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11220a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11222a;

    public MineFragmentAvatarFrameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f11220a, f35304a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11221a;
            this.f11221a = 0L;
        }
        AvatarFrameVM avatarFrameVM = ((MineFragmentAvatarFrameBinding) this).f35303a;
        long j2 = j & 7;
        AvatarFrameAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<AvatarFrameAdapter> mutableLiveDataK = avatarFrameVM != null ? avatarFrameVM.k() : null;
            updateLiveDataRegistration(0, mutableLiveDataK);
            if (mutableLiveDataK != null) {
                value = mutableLiveDataK.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f11222a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11221a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11221a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentAvatarFrameBinding
    public void k(@Nullable AvatarFrameVM avatarFrameVM) {
        ((MineFragmentAvatarFrameBinding) this).f35303a = avatarFrameVM;
        synchronized (this) {
            this.f11221a |= 2;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<AvatarFrameAdapter> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11221a |= 1;
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
        if (ik0.p0 != i) {
            return false;
        }
        k((AvatarFrameVM) obj);
        return true;
    }

    public MineFragmentAvatarFrameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f11221a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f11222a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
