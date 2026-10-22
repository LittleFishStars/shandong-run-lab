package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ActivityChatTeamBindingImpl extends ActivityChatTeamBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9650a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9652a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34406a = sparseIntArray;
        sparseIntArray.put(R.id.ivBack, 1);
        sparseIntArray.put(R.id.tvChatTeamName, 2);
        sparseIntArray.put(R.id.ivTeamUsers, 3);
        sparseIntArray.put(R.id.flContainer, 4);
    }

    public ActivityChatTeamBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9650a, f34406a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9651a;
            this.f9651a = 0L;
        }
        BaseVM baseVM = ((ActivityChatTeamBinding) this).f9649a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveData = baseVM != null ? baseVM.f33644a : null;
            updateLiveDataRegistration(0, mutableLiveData);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
        }
        int i = iSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.O(this.f9652a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9651a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9651a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ActivityChatTeamBinding
    public void k(@Nullable BaseVM baseVM) {
        ((ActivityChatTeamBinding) this).f9649a = baseVM;
        synchronized (this) {
            this.f9651a |= 2;
        }
        notifyPropertyChanged(yk0.L);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9651a |= 1;
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
        if (yk0.L != i) {
            return false;
        }
        k((BaseVM) obj);
        return true;
    }

    public ActivityChatTeamBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[4], (ImageView) objArr[1], (ImageView) objArr[3], (TextView) objArr[2]);
        this.f9651a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9652a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
