package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.home.page.inspiration_record.InspirationRecordVM;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityInspirationRecordBindingImpl extends HomeActivityInspirationRecordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9284a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f9280a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34204a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.home.R.id.tab_layout, 4);
        sparseIntArray.put(com.huachenjie.home.R.id.view_pager, 5);
    }

    public HomeActivityInspirationRecordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9280a, f34204a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f9281a;
            this.f9281a = 0L;
        }
        InspirationRecordVM inspirationRecordVM = ((HomeActivityInspirationRecordBinding) this).f9279a;
        String value2 = null;
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = inspirationRecordVM != null ? inspirationRecordVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 26) != 0) {
                MutableLiveData<String> mutableLiveDataJ = inspirationRecordVM != null ? inspirationRecordVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((26 & j) != 0) {
            TextViewBindingAdapter.setText(this.f9284a, value2);
        }
        if ((j & 25) != 0) {
            ((HomeActivityInspirationRecordBinding) this).f9277a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((HomeActivityInspirationRecordBinding) this).f9277a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9281a != 0) {
                return true;
            }
            return ((HomeActivityInspirationRecordBinding) this).f9277a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9281a = 16L;
        }
        ((HomeActivityInspirationRecordBinding) this).f9277a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityInspirationRecordBinding
    public void k(@Nullable InspirationRecordVM inspirationRecordVM) {
        ((HomeActivityInspirationRecordBinding) this).f9279a = inspirationRecordVM;
        synchronized (this) {
            this.f9281a |= 8;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9281a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9281a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9281a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((HomeActivityInspirationRecordBinding) this).f9277a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 != i) {
            return false;
        }
        k((InspirationRecordVM) obj);
        return true;
    }

    public HomeActivityInspirationRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (SelectBoldTabLayout) objArr[4], (LayoutToolbarBindingBinding) objArr[3], (ViewPager2) objArr[5]);
        this.f9281a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9282a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f9283a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9284a = textView;
        textView.setTag(null);
        setContainedBinding(((HomeActivityInspirationRecordBinding) this).f9277a);
        setRootTag(view);
        invalidateAll();
    }
}
