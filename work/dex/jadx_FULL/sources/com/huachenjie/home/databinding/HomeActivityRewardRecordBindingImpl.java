package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.huachenjie.home.page.reward_record.RewardRecordAdapter;
import com.huachenjie.home.page.reward_record.RewardRecordVM;
import com.zj.adlib.xk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityRewardRecordBindingImpl extends HomeActivityRewardRecordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34218a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9333a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9337a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardRecordActivity.a f34219a;

        public a a(RewardRecordActivity.a aVar) {
            this.f34219a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34219a.a(view);
        }
    }

    public HomeActivityRewardRecordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9333a, f34218a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:39:0x008c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        RewardRecordAdapter value;
        Integer value2;
        a aVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f9334a;
            this.f9334a = 0L;
        }
        RewardRecordVM rewardRecordVM = ((HomeActivityRewardRecordBinding) this).f9332a;
        RewardRecordActivity.a aVar = ((HomeActivityRewardRecordBinding) this).f9331a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = rewardRecordVM != null ? rewardRecordVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                BaseViewModel.b bVarE = rewardRecordVM != null ? rewardRecordVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 4));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 44) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<RewardRecordAdapter> mutableLiveDataC = rewardRecordVM != null ? rewardRecordVM.C() : null;
                updateLiveDataRegistration(2, mutableLiveDataC);
                if (mutableLiveDataC != null) {
                    value = mutableLiveDataC.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            i = 0;
            value = null;
            value2 = null;
        }
        long j2 = 48 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f9337a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9337a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.I(this.f9336a, 16, i, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9336a, aVarA, null);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((HomeActivityRewardRecordBinding) this).f34217a, value, false, false);
        }
        if ((j & 41) != 0) {
            xq8.a(((HomeActivityRewardRecordBinding) this).f9330a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9334a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9334a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityRewardRecordBinding
    public void l(@Nullable RewardRecordActivity.a aVar) {
        ((HomeActivityRewardRecordBinding) this).f9331a = aVar;
        synchronized (this) {
            this.f9334a |= 16;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityRewardRecordBinding
    public void m(@Nullable RewardRecordVM rewardRecordVM) {
        ((HomeActivityRewardRecordBinding) this).f9332a = rewardRecordVM;
        synchronized (this) {
            this.f9334a |= 8;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<RewardRecordAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9334a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9334a |= 1;
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
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9334a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((RewardRecordVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((RewardRecordActivity.a) obj);
        }
        return true;
    }

    public HomeActivityRewardRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RecyclerView) objArr[2], (StateLayout) objArr[1]);
        this.f9334a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9335a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f9336a = imageView;
        imageView.setTag(null);
        ((HomeActivityRewardRecordBinding) this).f34217a.setTag(null);
        ((HomeActivityRewardRecordBinding) this).f9330a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
