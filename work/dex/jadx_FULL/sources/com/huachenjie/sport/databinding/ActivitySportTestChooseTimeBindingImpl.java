package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeActivity;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivitySportTestChooseTimeBindingImpl extends ActivitySportTestChooseTimeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckTextView f13337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13338a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestChooseTimeActivity.a f36427a;

        public a a(SportTestChooseTimeActivity.a aVar) {
            this.f36427a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36427a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f13333a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36426a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.tab, 4);
        sparseIntArray.put(com.huachenjie.sport.R.id.vp, 5);
        sparseIntArray.put(com.huachenjie.sport.R.id.cl_bottom, 6);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_check, 7);
    }

    public ActivitySportTestChooseTimeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13333a, f36426a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:56:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:59:0x02f6  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String value2;
        boolean zSafeUnbox;
        long j2;
        a aVarA;
        synchronized (this) {
            j = this.f13334a;
            this.f13334a = 0L;
        }
        SportTestChooseTimeVM sportTestChooseTimeVM = ((ActivitySportTestChooseTimeBinding) this).f13332a;
        SportTestChooseTimeActivity.a aVar = ((ActivitySportTestChooseTimeBinding) this).f13331a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataR = sportTestChooseTimeVM != null ? sportTestChooseTimeVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value = mutableLiveDataR.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataN = sportTestChooseTimeVM != null ? sportTestChooseTimeVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value2 = mutableLiveDataN.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataH = sportTestChooseTimeVM != null ? sportTestChooseTimeVM.h() : null;
                updateLiveDataRegistration(2, mediatorLiveDataH);
                zSafeUnbox = ViewDataBinding.safeUnbox(mediatorLiveDataH != null ? mediatorLiveDataH.getValue() : null);
            }
            j2 = j & 48;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f13338a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f13338a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((j & 41) != 0) {
                this.f13336a.k(value);
            }
            if ((j & 44) != 0) {
                CommonBindingAdapter.e0(this.f13337a, zSafeUnbox);
            }
            if ((32 & j) != 0) {
                CheckTextView checkTextView = this.f13337a;
                DrawablesBindingAdapter.h(checkTextView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView, com.huachenjie.sport.R.color.color_main_v2)), 0, 0.0f, 0.0f, 0.0f, 17.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13337a, com.huachenjie.sport.R.color.color_CAD2DA)), 0, 0.0f, 0.0f, 0.0f, 17.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                CheckTextView checkTextView2 = this.f13337a;
                DrawablesBindingAdapter.g(checkTextView2, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView2, com.huachenjie.sport.R.color.white)), null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13337a, com.huachenjie.sport.R.color.color_333333)), null, null, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f13337a, aVarA, null);
            }
            if ((j & 42) != 0) {
                TextViewBindingAdapter.setText(this.b, value2);
            }
            ViewDataBinding.executeBindingsOn(this.f13336a);
        }
        value = null;
        value2 = null;
        zSafeUnbox = false;
        j2 = j & 48;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((j & 41) != 0) {
            this.f13336a.k(value);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.e0(this.f13337a, zSafeUnbox);
        }
        if ((32 & j) != 0) {
            CheckTextView checkTextView3 = this.f13337a;
            DrawablesBindingAdapter.h(checkTextView3, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView3, com.huachenjie.sport.R.color.color_main_v2)), 0, 0.0f, 0.0f, 0.0f, 17.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13337a, com.huachenjie.sport.R.color.color_CAD2DA)), 0, 0.0f, 0.0f, 0.0f, 17.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CheckTextView checkTextView4 = this.f13337a;
            DrawablesBindingAdapter.g(checkTextView4, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView4, com.huachenjie.sport.R.color.white)), null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13337a, com.huachenjie.sport.R.color.color_333333)), null, null, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f13337a, aVarA, null);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(this.b, value2);
        }
        ViewDataBinding.executeBindingsOn(this.f13336a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13334a != 0) {
                return true;
            }
            return this.f13336a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13334a = 32L;
        }
        this.f13336a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestChooseTimeBinding
    public void l(@Nullable SportTestChooseTimeActivity.a aVar) {
        ((ActivitySportTestChooseTimeBinding) this).f13331a = aVar;
        synchronized (this) {
            this.f13334a |= 16;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestChooseTimeBinding
    public void m(@Nullable SportTestChooseTimeVM sportTestChooseTimeVM) {
        ((ActivitySportTestChooseTimeBinding) this).f13332a = sportTestChooseTimeVM;
        synchronized (this) {
            this.f13334a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13334a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13334a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MediatorLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13334a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13336a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((SportTestChooseTimeVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((SportTestChooseTimeActivity.a) obj);
        }
        return true;
    }

    public ActivitySportTestChooseTimeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ShadowConstraintLayout) objArr[6], (SlidingTabLayout2) objArr[4], (TextView) objArr[7], (TextView) objArr[1], (ViewPager2) objArr[5]);
        this.f13334a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f13336a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13335a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        CheckTextView checkTextView = (CheckTextView) objArr[2];
        this.f13337a = checkTextView;
        checkTextView.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
