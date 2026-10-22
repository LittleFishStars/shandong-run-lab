package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.im.page.emoji.StickerAdapter;
import com.huachenjie.im.page.emoji.StickerVM;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FragmentStickerBindingImpl extends FragmentStickerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34444a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9754a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9755a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9756a;

    public FragmentStickerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9754a, f34444a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9755a;
            this.f9755a = 0L;
        }
        StickerVM stickerVM = ((FragmentStickerBinding) this).f34443a;
        long j2 = j & 7;
        StickerAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<StickerAdapter> mutableLiveDataH = stickerVM != null ? stickerVM.h() : null;
            updateLiveDataRegistration(0, mutableLiveDataH);
            if (mutableLiveDataH != null) {
                value = mutableLiveDataH.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f9756a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9755a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9755a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.FragmentStickerBinding
    public void k(@Nullable StickerVM stickerVM) {
        ((FragmentStickerBinding) this).f34443a = stickerVM;
        synchronized (this) {
            this.f9755a |= 2;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<StickerAdapter> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9755a |= 1;
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
        if (yk0.p0 != i) {
            return false;
        }
        k((StickerVM) obj);
        return true;
    }

    public FragmentStickerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f9755a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f9756a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
