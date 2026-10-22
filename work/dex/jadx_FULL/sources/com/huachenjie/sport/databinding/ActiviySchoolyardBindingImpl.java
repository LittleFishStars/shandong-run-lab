package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.SchoolyardActivity;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActiviySchoolyardBindingImpl extends ActiviySchoolyardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13380a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f13382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13385a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SchoolyardActivity.a f36442a;

        public a a(SchoolyardActivity.a aVar) {
            this.f36442a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36442a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36441a = sparseIntArray;
        sparseIntArray.put(R.id.tabLayout, 3);
        sparseIntArray.put(R.id.viewPager, 4);
    }

    public ActiviySchoolyardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13380a, f36441a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f13381a;
            this.f13381a = 0L;
        }
        BaseVM baseVM = ((ActiviySchoolyardBinding) this).f13378a;
        SchoolyardActivity.a aVar = ((ActiviySchoolyardBinding) this).f13379a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveData = baseVM != null ? baseVM.f33644a : null;
            updateLiveDataRegistration(0, mutableLiveData);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13385a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13385a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.O(this.f13382a, 0, i, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f13383a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13381a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13381a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActiviySchoolyardBinding
    public void l(@Nullable SchoolyardActivity.a aVar) {
        ((ActiviySchoolyardBinding) this).f13379a = aVar;
        synchronized (this) {
            this.f13381a |= 4;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActiviySchoolyardBinding
    public void m(@Nullable BaseVM baseVM) {
        ((ActiviySchoolyardBinding) this).f13378a = baseVM;
        synchronized (this) {
            this.f13381a |= 2;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13381a |= 1;
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
        if (ok0.p0 == i) {
            m((BaseVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((SchoolyardActivity.a) obj);
        }
        return true;
    }

    public ActiviySchoolyardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TabLayout) objArr[3], (ViewPager2) objArr[4]);
        this.f13381a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13384a = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.f13382a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f13383a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
