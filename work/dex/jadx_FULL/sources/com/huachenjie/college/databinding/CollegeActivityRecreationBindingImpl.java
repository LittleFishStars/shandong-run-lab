package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.college.R;
import com.huachenjie.college.page.recreation.RecreationActivity;
import com.huachenjie.college.page.recreation.RecreationVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeActivityRecreationBindingImpl extends CollegeActivityRecreationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8383a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f8385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f8388a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecreationActivity.ClickProxy f33566a;

        public a a(RecreationActivity.ClickProxy clickProxy) {
            this.f33566a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33566a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecreationActivity.ClickProxy f33567a;

        public b a(RecreationActivity.ClickProxy clickProxy) {
            this.f33567a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33567a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33565a = sparseIntArray;
        sparseIntArray.put(R.id.tab_layout, 4);
        sparseIntArray.put(R.id.viewPager, 5);
    }

    public CollegeActivityRecreationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f8383a, f33565a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f8384a;
            this.f8384a = 0L;
        }
        RecreationVM recreationVM = ((CollegeActivityRecreationBinding) this).f8380a;
        RecreationActivity.ClickProxy clickProxy = ((CollegeActivityRecreationBinding) this).f8379a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = recreationVM != null ? recreationVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || clickProxy == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f8388a;
            if (bVar == null) {
                bVar = new b();
                this.f8388a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            a aVar = this.f8387a;
            if (aVar == null) {
                aVar = new a();
                this.f8387a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((CollegeActivityRecreationBinding) this).f8382a, aVarA, null);
            CommonBindingAdapter.q(this.f8386a, bVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.O(((CollegeActivityRecreationBinding) this).f8381a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8384a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8384a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityRecreationBinding
    public void l(@Nullable RecreationActivity.ClickProxy clickProxy) {
        ((CollegeActivityRecreationBinding) this).f8379a = clickProxy;
        synchronized (this) {
            this.f8384a |= 4;
        }
        notifyPropertyChanged(uk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityRecreationBinding
    public void m(@Nullable RecreationVM recreationVM) {
        ((CollegeActivityRecreationBinding) this).f8380a = recreationVM;
        synchronized (this) {
            this.f8384a |= 2;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8384a |= 1;
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
        if (uk0.p0 == i) {
            m((RecreationVM) obj);
        } else {
            if (uk0.k != i) {
                return false;
            }
            l((RecreationActivity.ClickProxy) obj);
        }
        return true;
    }

    public CollegeActivityRecreationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (BLLinearLayout) objArr[3], (BLFrameLayout) objArr[1], (SlidingTabLayout2) objArr[4], (ViewPager2) objArr[5]);
        this.f8384a = -1L;
        ((CollegeActivityRecreationBinding) this).f8382a.setTag(null);
        ((CollegeActivityRecreationBinding) this).f8381a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f8385a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f8386a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
