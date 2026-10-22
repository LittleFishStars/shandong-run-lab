package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.dialog.task.TaskListDialog;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeDialogTaskListBindingImpl extends HomeDialogTaskListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34242a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9392a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f9395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9396a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TaskListDialog.a f34243a;

        public a a(TaskListDialog.a aVar) {
            this.f34243a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34243a.a(view);
        }
    }

    public HomeDialogTaskListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f9392a, f34242a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f9393a;
            this.f9393a = 0L;
        }
        BaseViewModel baseViewModel = ((HomeDialogTaskListBinding) this).f9390a;
        TaskListDialog.a aVar = ((HomeDialogTaskListBinding) this).f9391a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = baseViewModel != null ? baseViewModel.e() : null;
            MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
            updateLiveDataRegistration(0, mutableLiveDataA);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f9396a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9396a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.I(((HomeDialogTaskListBinding) this).f34241a, 16, 128, 16, i, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f9394a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9393a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9393a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogTaskListBinding
    public void l(@Nullable TaskListDialog.a aVar) {
        ((HomeDialogTaskListBinding) this).f9391a = aVar;
        synchronized (this) {
            this.f9393a |= 4;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeDialogTaskListBinding
    public void m(@Nullable BaseViewModel baseViewModel) {
        ((HomeDialogTaskListBinding) this).f9390a = baseViewModel;
        synchronized (this) {
            this.f9393a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9393a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((BaseViewModel) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((TaskListDialog.a) obj);
        }
        return true;
    }

    public HomeDialogTaskListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[2]);
        this.f9393a = -1L;
        ((HomeDialogTaskListBinding) this).f34241a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f9395a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f9394a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
