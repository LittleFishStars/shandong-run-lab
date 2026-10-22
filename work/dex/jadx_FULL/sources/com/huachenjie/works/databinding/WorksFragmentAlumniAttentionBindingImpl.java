package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.page.alumni.attention.AttentionVM;
import com.huachenjie.works.page.alumni.attention.AttentionWorksAdapter;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentAlumniAttentionBindingImpl extends WorksFragmentAlumniAttentionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36890a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14145a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f14148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14150a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36891a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36891a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36891a.onRefresh();
        }
    }

    public WorksFragmentAlumniAttentionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, f14145a, f36890a));
    }

    /* JADX WARN: Code duplicated, block: B:80:0x012d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean zSafeUnbox;
        int i;
        int iSafeUnbox;
        float fSafeUnbox;
        AttentionWorksAdapter value;
        String str;
        int iSafeUnbox2;
        synchronized (this) {
            j = this.f14146a;
            this.f14146a = 0L;
        }
        AttentionVM attentionVM = ((WorksFragmentAlumniAttentionBinding) this).f14144a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentAlumniAttentionBinding) this).f14142a;
        float fSafeUnbox2 = 0.0f;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((383 & j) != 0) {
            if ((j & 321) != 0) {
                MutableLiveData<Float> mutableLiveDataT = attentionVM != null ? attentionVM.t() : null;
                updateLiveDataRegistration(0, mutableLiveDataT);
                fSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataT != null ? mutableLiveDataT.getValue() : null);
            } else {
                fSafeUnbox = 0.0f;
            }
            if ((j & 328) != 0) {
                BaseViewModel.b bVarE = attentionVM != null ? attentionVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j2 = j & 322;
            if (j2 != 0) {
                MutableLiveData<Integer> mutableLiveDataP = attentionVM != null ? attentionVM.p() : null;
                updateLiveDataRegistration(1, mutableLiveDataP);
                Integer value2 = mutableLiveDataP != null ? mutableLiveDataP.getValue() : null;
                iSafeUnbox2 = ViewDataBinding.safeUnbox(value2);
                str = String.format("%d%s", value2, "%");
                z = iSafeUnbox2 >= 0;
                if (j2 != 0) {
                    j = z ? j | 1024 : j | 512;
                }
            } else {
                z = false;
                iSafeUnbox2 = 0;
                str = null;
            }
            if ((j & 324) != 0) {
                MutableLiveData<Float> mutableLiveDataS = attentionVM != null ? attentionVM.s() : null;
                updateLiveDataRegistration(2, mutableLiveDataS);
                fSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataS != null ? mutableLiveDataS.getValue() : null);
            }
            if ((j & 336) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = attentionVM != null ? attentionVM.v() : null;
                updateLiveDataRegistration(4, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 352) == 0) {
                value = null;
            } else {
                MutableLiveData<AttentionWorksAdapter> mutableLiveDataO = attentionVM != null ? attentionVM.o() : null;
                updateLiveDataRegistration(5, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value = mutableLiveDataO.getValue();
                } else {
                    value = null;
                }
            }
            i = iSafeUnbox2;
        } else {
            z = false;
            zSafeUnbox = false;
            i = 0;
            iSafeUnbox = 0;
            fSafeUnbox = 0.0f;
            fSafeUnbox2 = 0.0f;
            value = null;
            str = null;
        }
        long j3 = j & 384;
        if (j3 != 0 && onRefreshListener != null) {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f14150a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f14150a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        OnRefreshListenerImpl onRefreshListenerImpl2 = onRefreshListenerImplA;
        boolean z2 = (j & 1024) != 0 && i < 100;
        long j4 = j & 322;
        if (j4 == 0 || !z) {
            z2 = false;
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.f14148a, z2);
            TextViewBindingAdapter.setText(this.f14147a, str);
            CommonBindingAdapter.l0(((WorksFragmentAlumniAttentionBinding) this).f14140a, z2);
            CommonBindingAdapter.R(((WorksFragmentAlumniAttentionBinding) this).f14140a, i);
            CommonBindingAdapter.l0(((WorksFragmentAlumniAttentionBinding) this).f14139a, z2);
        }
        if ((j & 321) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
            this.f14148a.setTranslationX(fSafeUnbox);
        }
        if ((352 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentAlumniAttentionBinding) this).f14141a, value, false, false);
        }
        if (j3 != 0) {
            ((WorksFragmentAlumniAttentionBinding) this).f14143a.setOnRefreshListener(onRefreshListenerImpl2);
        }
        if ((336 & j) != 0) {
            ((WorksFragmentAlumniAttentionBinding) this).f14143a.setRefreshing(zSafeUnbox);
        }
        if ((j & 324) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
            ((WorksFragmentAlumniAttentionBinding) this).f14139a.setTranslationX(fSafeUnbox2);
        }
        if ((j & 328) != 0) {
            CommonBindingAdapter.I(((WorksFragmentAlumniAttentionBinding) this).f36889a, 0, iSafeUnbox, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14146a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14146a = 256L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniAttentionBinding
    public void l(@Nullable AttentionVM Vm) {
        ((WorksFragmentAlumniAttentionBinding) this).f14144a = Vm;
        synchronized (this) {
            this.f14146a |= 64;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<AttentionWorksAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14146a |= 32;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14146a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmPublishProgress, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14146a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 4) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 5) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Float> VmThumbProgress, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14146a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Float> VmThumbTextProgress, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14146a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14146a |= 8;
        }
        return true;
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniAttentionBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentAlumniAttentionBinding) this).f14142a = Refresh;
        synchronized (this) {
            this.f14146a |= 128;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((AttentionVM) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentAlumniAttentionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (ProgressBar) bindings[2], (RecyclerView) bindings[4], (SwipeRefreshLayout) bindings[3], (ImageView) bindings[5], (View) bindings[1]);
        this.f14146a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14149a = constraintLayout;
        constraintLayout.setTag(null);
        CardView cardView = (CardView) bindings[6];
        this.f14148a = cardView;
        cardView.setTag(null);
        TextView textView = (TextView) bindings[7];
        this.f14147a = textView;
        textView.setTag(null);
        ((WorksFragmentAlumniAttentionBinding) this).f14140a.setTag(null);
        ((WorksFragmentAlumniAttentionBinding) this).f14141a.setTag(null);
        ((WorksFragmentAlumniAttentionBinding) this).f14143a.setTag(null);
        ((WorksFragmentAlumniAttentionBinding) this).f14139a.setTag(null);
        ((WorksFragmentAlumniAttentionBinding) this).f36889a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
