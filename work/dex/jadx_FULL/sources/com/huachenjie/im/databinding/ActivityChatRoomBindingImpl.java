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
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.R;
import com.noober.background.view.BLTextView;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ActivityChatRoomBindingImpl extends ActivityChatRoomBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9645a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9646a;

    @NonNull
    public final LinearLayout b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34404a = sparseIntArray;
        sparseIntArray.put(R.id.ivBack, 1);
        sparseIntArray.put(R.id.ivAvatar, 2);
        sparseIntArray.put(R.id.llTitleContainer, 3);
        sparseIntArray.put(R.id.tvChatRoomName, 4);
        sparseIntArray.put(R.id.tv_count, 5);
        sparseIntArray.put(R.id.flContainer, 6);
    }

    public ActivityChatRoomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9645a, f34404a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9646a;
            this.f9646a = 0L;
        }
        BaseVM baseVM = ((ActivityChatRoomBinding) this).f9643a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveData = baseVM != null ? baseVM.f33644a : null;
            updateLiveDataRegistration(0, mutableLiveData);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
        }
        int i = iSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.O(this.b, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9646a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9646a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ActivityChatRoomBinding
    public void k(@Nullable BaseVM baseVM) {
        ((ActivityChatRoomBinding) this).f9643a = baseVM;
        synchronized (this) {
            this.f9646a |= 2;
        }
        notifyPropertyChanged(yk0.L);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9646a |= 1;
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

    public ActivityChatRoomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[6], (AvatarView) objArr[2], (ImageView) objArr[1], (LinearLayout) objArr[3], (TextView) objArr[4], (BLTextView) objArr[5]);
        this.f9646a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
