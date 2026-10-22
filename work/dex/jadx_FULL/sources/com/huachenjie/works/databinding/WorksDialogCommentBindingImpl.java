package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogCommentBindingImpl extends WorksDialogCommentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14048a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14049a;

    @NonNull
    public final FrameLayout b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36848a = sparseIntArray;
        sparseIntArray.put(R.id.rl_content, 2);
        sparseIntArray.put(R.id.fl_comment, 3);
        sparseIntArray.put(R.id.iv_close, 4);
        sparseIntArray.put(R.id.card_view, 5);
        sparseIntArray.put(R.id.iv_goods, 6);
        sparseIntArray.put(R.id.iv_pic, 7);
        sparseIntArray.put(R.id.iv_at, 8);
        sparseIntArray.put(R.id.iv_emoji, 9);
    }

    public WorksDialogCommentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 10, f14048a, f36848a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14049a;
            this.f14049a = 0L;
        }
        BaseViewModel baseViewModel = ((WorksDialogCommentBinding) this).f14045a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = baseViewModel != null ? baseViewModel.e() : null;
            MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
            updateLiveDataRegistration(0, mutableLiveDataA);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 12));
        }
        int i = iSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.I(((WorksDialogCommentBinding) this).f14046a, 16, 12, 16, i, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14049a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14049a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogCommentBinding
    public void k(@Nullable BaseViewModel Vm) {
        ((WorksDialogCommentBinding) this).f14045a = Vm;
        synchronized (this) {
            this.f14049a |= 2;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14049a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((BaseViewModel) variable);
        return true;
    }

    public WorksDialogCommentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (CardView) bindings[5], (FrameLayout) bindings[3], (ImageView) bindings[8], (ImageView) bindings[4], (ImageView) bindings[9], (ImageView) bindings[6], (ImageView) bindings[7], (BLLinearLayout) bindings[1], (BLRelativeLayout) bindings[2]);
        this.f14049a = -1L;
        ((WorksDialogCommentBinding) this).f14046a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
