package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.page.comment.write.WriteReviewSuccessActivity;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityWriteReviewSuccessBindingImpl extends MallActivityWriteReviewSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10507a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WriteReviewSuccessActivity.a f34894a;

        public a a(WriteReviewSuccessActivity.a aVar) {
            this.f34894a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34894a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WriteReviewSuccessActivity.a f34895a;

        public b a(WriteReviewSuccessActivity.a aVar) {
            this.f34895a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34895a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f10503a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34893a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.iv_write_review, 4);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_write_review, 5);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_write_review_tip, 6);
        sparseIntArray.put(com.huachenjie.mall.R.id.v_center_line, 7);
    }

    public MallActivityWriteReviewSuccessBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10503a, f34893a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f10504a;
            this.f10504a = 0L;
        }
        BaseTitleViewModel baseTitleViewModel = ((MallActivityWriteReviewSuccessBinding) this).f10499a;
        WriteReviewSuccessActivity.a aVar = ((MallActivityWriteReviewSuccessBinding) this).f10500a;
        long j2 = 21 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = baseTitleViewModel != null ? baseTitleViewModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 24;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f10507a;
            if (bVar == null) {
                bVar = new b();
                this.f10507a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10506a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10506a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            ((MallActivityWriteReviewSuccessBinding) this).f10498a.k(value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallActivityWriteReviewSuccessBinding) this).f10501a, aVarA, null);
            CommonBindingAdapter.q(((MallActivityWriteReviewSuccessBinding) this).f10502b, bVarA, null);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityWriteReviewSuccessBinding) this).f10498a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10504a != 0) {
                return true;
            }
            return ((MallActivityWriteReviewSuccessBinding) this).f10498a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10504a = 16L;
        }
        ((MallActivityWriteReviewSuccessBinding) this).f10498a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityWriteReviewSuccessBinding
    public void l(@Nullable WriteReviewSuccessActivity.a aVar) {
        ((MallActivityWriteReviewSuccessBinding) this).f10500a = aVar;
        synchronized (this) {
            this.f10504a |= 8;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityWriteReviewSuccessBinding
    public void m(@Nullable BaseTitleViewModel baseTitleViewModel) {
        ((MallActivityWriteReviewSuccessBinding) this).f10499a = baseTitleViewModel;
        synchronized (this) {
            this.f10504a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10504a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10504a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityWriteReviewSuccessBinding) this).f10498a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((BaseTitleViewModel) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((WriteReviewSuccessActivity.a) obj);
        }
        return true;
    }

    public MallActivityWriteReviewSuccessBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[4], (LayoutToolbarBindingBinding) objArr[3], (BLTextView) objArr[2], (BLTextView) objArr[1], (TextView) objArr[5], (TextView) objArr[6], (View) objArr[7]);
        this.f10504a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10505a = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(((MallActivityWriteReviewSuccessBinding) this).f10498a);
        ((MallActivityWriteReviewSuccessBinding) this).f10501a.setTag(null);
        ((MallActivityWriteReviewSuccessBinding) this).f10502b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
