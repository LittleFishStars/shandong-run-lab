package com.huachenjie.works.databinding;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.page.alumni.school.ThisSchoolFragment;
import com.huachenjie.works.page.alumni.school.ThisSchoolVM;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentThisSchoolBindingImpl extends WorksFragmentThisSchoolBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36963a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14345a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14350a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36964a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36964a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36964a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThisSchoolFragment.ClickProxy f36965a;

        public a a(ThisSchoolFragment.ClickProxy value) {
            this.f36965a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36965a.d(arg0);
        }
    }

    public WorksFragmentThisSchoolBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14345a, f36963a));
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:76:0x010a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0116  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code duplicated, block: B:85:0x0130  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        int iSafeUnbox2;
        boolean zSafeUnbox;
        PostAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        long j3;
        a aVarA;
        synchronized (this) {
            j = this.f14346a;
            this.f14346a = 0L;
        }
        ThisSchoolVM thisSchoolVM = ((WorksFragmentThisSchoolBinding) this).f14344a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentThisSchoolBinding) this).f14341a;
        ThisSchoolFragment.ClickProxy clickProxy = ((WorksFragmentThisSchoolBinding) this).f14343a;
        if ((159 & j) != 0) {
            if ((j & 146) != 0) {
                BaseViewModel.b bVarE = thisSchoolVM != null ? thisSchoolVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                updateLiveDataRegistration(1, mutableLiveDataC);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 145) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = thisSchoolVM != null ? thisSchoolVM.v() : null;
                updateLiveDataRegistration(0, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 148) != 0) {
                MutableLiveData<Integer> mutableLiveDataL = thisSchoolVM != null ? thisSchoolVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 152) != 0) {
                MutableLiveData<PostAdapter> mutableLiveDataK = thisSchoolVM != null ? thisSchoolVM.k() : null;
                updateLiveDataRegistration(3, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                }
            }
            j2 = j & 160;
            if (j2 != 0 || onRefreshListener == null) {
                onRefreshListenerImplA = null;
            } else {
                OnRefreshListenerImpl onRefreshListenerImpl = this.f14349a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f14349a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            j3 = j & 192;
            if (j3 != 0 || clickProxy == null) {
                aVarA = null;
            } else {
                a aVar = this.f14350a;
                if (aVar == null) {
                    aVar = new a();
                    this.f14350a = aVar;
                }
                aVarA = aVar.a(clickProxy);
            }
            if (j3 != 0) {
                CommonBindingAdapter.q(this.f14348a, aVarA, null);
            }
            if (j2 != 0) {
                ((WorksFragmentThisSchoolBinding) this).f14342a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((j & 145) != 0) {
                ((WorksFragmentThisSchoolBinding) this).f14342a.setRefreshing(zSafeUnbox);
            }
            if ((152 & j) != 0) {
                CommonBindingAdapter.g(((WorksFragmentThisSchoolBinding) this).f14340a, value, false, false);
            }
            if ((146 & j) != 0) {
                CommonBindingAdapter.G(((WorksFragmentThisSchoolBinding) this).f36962a, iSafeUnbox);
            }
            if ((j & 148) != 0) {
                ((WorksFragmentThisSchoolBinding) this).f36962a.setBackgroundColor(iSafeUnbox2);
            }
        }
        iSafeUnbox = 0;
        iSafeUnbox2 = 0;
        zSafeUnbox = false;
        value = null;
        j2 = j & 160;
        if (j2 != 0) {
            onRefreshListenerImplA = null;
        } else {
            onRefreshListenerImplA = null;
        }
        j3 = j & 192;
        if (j3 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f14348a, aVarA, null);
        }
        if (j2 != 0) {
            ((WorksFragmentThisSchoolBinding) this).f14342a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 145) != 0) {
            ((WorksFragmentThisSchoolBinding) this).f14342a.setRefreshing(zSafeUnbox);
        }
        if ((152 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentThisSchoolBinding) this).f14340a, value, false, false);
        }
        if ((146 & j) != 0) {
            CommonBindingAdapter.G(((WorksFragmentThisSchoolBinding) this).f36962a, iSafeUnbox);
        }
        if ((j & 148) != 0) {
            ((WorksFragmentThisSchoolBinding) this).f36962a.setBackgroundColor(iSafeUnbox2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14346a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14346a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentThisSchoolBinding
    public void m(@Nullable ThisSchoolFragment.ClickProxy Click) {
        ((WorksFragmentThisSchoolBinding) this).f14343a = Click;
        synchronized (this) {
            this.f14346a |= 64;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentThisSchoolBinding
    public void n(@Nullable ThisSchoolVM Vm) {
        ((WorksFragmentThisSchoolBinding) this).f14344a = Vm;
        synchronized (this) {
            this.f14346a |= 16;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<PostAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14346a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return q((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return r((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmBackgroundColor, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14346a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14346a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> VmUiLiveDataStatusBarHeightPx, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14346a |= 2;
        }
        return true;
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentThisSchoolBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentThisSchoolBinding) this).f14341a = Refresh;
        synchronized (this) {
            this.f14346a |= 32;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            n((ThisSchoolVM) variable);
        } else if (qk0.R == variableId) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            m((ThisSchoolFragment.ClickProxy) variable);
        }
        return true;
    }

    public WorksFragmentThisSchoolBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (SwipeRefreshLayout) bindings[1], (RecyclerView) bindings[2], (View) bindings[3]);
        this.f14346a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14347a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.f14348a = imageView;
        imageView.setTag(null);
        ((WorksFragmentThisSchoolBinding) this).f14342a.setTag(null);
        ((WorksFragmentThisSchoolBinding) this).f14340a.setTag(null);
        ((WorksFragmentThisSchoolBinding) this).f36962a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
