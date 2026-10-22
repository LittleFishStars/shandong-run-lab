package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.recommend.RecommendFragment;
import com.huachenjie.works.page.alumni.recommend.RecommendVM;
import com.zj.adlib.lu3;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentAlumniRecommendBindingImpl extends WorksFragmentAlumniRecommendBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14171a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14175a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecommendFragment.a f36899a;

        public a a(RecommendFragment.a value) {
            this.f36899a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36899a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36898a = sparseIntArray;
        sparseIntArray.put(R.id.tabLayout, 3);
        sparseIntArray.put(R.id.viewPager, 4);
    }

    public WorksFragmentAlumniRecommendBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14171a, f36898a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        int iSafeUnbox;
        long j2;
        a aVarA;
        synchronized (this) {
            j = this.f14172a;
            this.f14172a = 0L;
        }
        RecommendVM recommendVM = ((WorksFragmentAlumniRecommendBinding) this).f14170a;
        RecommendFragment.a aVar = ((WorksFragmentAlumniRecommendBinding) this).f14169a;
        long j3 = 21 & j;
        RequestOptions requestOptions = j3 != 0 ? lu3.f43149a : null;
        if ((23 & j) != 0) {
            if (j3 == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = recommendVM != null ? recommendVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                BaseViewModel.b bVarE = recommendVM != null ? recommendVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            }
            j2 = 24 & j;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f14175a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f14175a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if (j3 != 0) {
                CommonBindingAdapter.b0(this.f14173a, value, requestOptions, false);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f14173a, aVarA, null);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.I(((WorksFragmentAlumniRecommendBinding) this).f36897a, 0, iSafeUnbox, 0, 0, null);
            }
        }
        value = null;
        iSafeUnbox = 0;
        j2 = 24 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(this.f14173a, value, requestOptions, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14173a, aVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.I(((WorksFragmentAlumniRecommendBinding) this).f36897a, 0, iSafeUnbox, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14172a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14172a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniRecommendBinding
    public void l(@Nullable RecommendFragment.a Click) {
        ((WorksFragmentAlumniRecommendBinding) this).f14169a = Click;
        synchronized (this) {
            this.f14172a |= 8;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniRecommendBinding
    public void m(@Nullable RecommendVM Vm) {
        ((WorksFragmentAlumniRecommendBinding) this).f14170a = Vm;
        synchronized (this) {
            this.f14172a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmSelectedLogo, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14172a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14172a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((RecommendVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((RecommendFragment.a) variable);
        }
        return true;
    }

    public WorksFragmentAlumniRecommendBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (SlidingTabLayout) bindings[3], (View) bindings[1], (ViewPager) bindings[4]);
        this.f14172a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14174a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[2];
        this.f14173a = imageView;
        imageView.setTag(null);
        ((WorksFragmentAlumniRecommendBinding) this).f36897a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
