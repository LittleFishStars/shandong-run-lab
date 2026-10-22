package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.college.R;
import com.huachenjie.college.page.sport.CollegeActivity;
import com.huachenjie.college.page.sport.CollegeAdapter;
import com.huachenjie.college.page.sport.CollegeVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLView;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeActivityHomeBindingImpl extends CollegeActivityHomeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8329a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8333a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f8334b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f8335b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33552a;

        public a a(CollegeActivity.a aVar) {
            this.f33552a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33552a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CollegeActivity.a f33553a;

        public b a(CollegeActivity.a aVar) {
            this.f33553a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33553a.d(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33551a = sparseIntArray;
        sparseIntArray.put(R.id.flAd, 6);
        sparseIntArray.put(R.id.v_title_bar, 7);
        sparseIntArray.put(R.id.iv_campus_letter, 8);
    }

    public CollegeActivityHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f8329a, f33551a));
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CollegeAdapter value;
        boolean zSafeUnbox;
        int i;
        a aVarA;
        b bVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f8330a;
            this.f8330a = 0L;
        }
        CollegeVM collegeVM = ((CollegeActivityHomeBinding) this).f8327a;
        CollegeActivity.a aVar = ((CollegeActivityHomeBinding) this).f8326a;
        if ((143 & j) != 0) {
            if ((j & 137) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = collegeVM != null ? collegeVM.p() : null;
                updateLiveDataRegistration(0, mutableLiveDataP);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 138) != 0) {
                BaseViewModel.b bVarE = collegeVM != null ? collegeVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 140) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<CollegeAdapter> mutableLiveDataI = collegeVM != null ? collegeVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            value = null;
            zSafeUnbox = false;
            i = 0;
        }
        long j2 = 192 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f8333a;
            if (bVar == null) {
                bVar = new b();
                this.f8333a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f8332a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8332a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((138 & j) != 0) {
            CommonBindingAdapter.O(((CollegeActivityHomeBinding) this).f8323a, 0, i, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f8334b, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        if ((137 & j) != 0) {
            CommonBindingAdapter.l0(this.f8335b, zSafeUnbox);
        }
        if ((j & 140) != 0) {
            CommonBindingAdapter.g(((CollegeActivityHomeBinding) this).f8324a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8330a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8330a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHomeBinding
    public void o(@Nullable RequestOptions requestOptions) {
        ((CollegeActivityHomeBinding) this).b = requestOptions;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return t((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return u((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return s((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHomeBinding
    public void p(@Nullable RequestOptions requestOptions) {
        ((CollegeActivityHomeBinding) this).f8325a = requestOptions;
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHomeBinding
    public void q(@Nullable CollegeActivity.a aVar) {
        ((CollegeActivityHomeBinding) this).f8326a = aVar;
        synchronized (this) {
            this.f8330a |= 64;
        }
        notifyPropertyChanged(uk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHomeBinding
    public void r(@Nullable CollegeVM collegeVM) {
        ((CollegeActivityHomeBinding) this).f8327a = collegeVM;
        synchronized (this) {
            this.f8330a |= 8;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean s(MutableLiveData<CollegeAdapter> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8330a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 == i) {
            r((CollegeVM) obj);
        } else if (uk0.e == i) {
            o((RequestOptions) obj);
        } else if (uk0.h == i) {
            p((RequestOptions) obj);
        } else {
            if (uk0.k != i) {
                return false;
            }
            q((CollegeActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8330a |= 1;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8330a |= 2;
        }
        return true;
    }

    public CollegeActivityHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (FrameLayout) objArr[6], (ImageView) objArr[8], (LinearLayout) objArr[2], (RecyclerView) objArr[1], (BLView) objArr[7]);
        this.f8330a = -1L;
        ((CollegeActivityHomeBinding) this).f8323a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8331a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f8334b = imageView;
        imageView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[4];
        this.b = frameLayout;
        frameLayout.setTag(null);
        BLView bLView = (BLView) objArr[5];
        this.f8335b = bLView;
        bLView.setTag(null);
        ((CollegeActivityHomeBinding) this).f8324a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
