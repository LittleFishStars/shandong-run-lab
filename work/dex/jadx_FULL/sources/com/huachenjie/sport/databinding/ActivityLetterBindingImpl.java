package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.LetterBean;
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.campus_letter.LetterDetailVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityLetterBindingImpl extends ActivityLetterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13310a;

    @NonNull
    public final TextView b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13307a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36417a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.web_html, 4);
    }

    public ActivityLetterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13307a, f36417a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:44:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0097  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String letterTime;
        BindingTitleBean bindingTitleBean;
        String schoolLetterTitle;
        int iSafeUnbox;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f13308a;
            this.f13308a = 0L;
        }
        LetterDetailVM letterDetailVM = ((ActivityLetterBinding) this).f13306a;
        if ((31 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = letterDetailVM != null ? letterDetailVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 26) == 0) {
                letterTime = null;
                schoolLetterTitle = null;
            } else {
                MutableLiveData<LetterBean> mutableLiveDataI = letterDetailVM != null ? letterDetailVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                LetterBean value2 = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                if (value2 != null) {
                    schoolLetterTitle = value2.getSchoolLetterTitle();
                    letterTime = value2.formatLetterTime();
                } else {
                    letterTime = null;
                    schoolLetterTitle = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<Integer> mutableLiveData = letterDetailVM != null ? ((BaseVM) letterDetailVM).f33644a : null;
                updateLiveDataRegistration(2, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
                bindingTitleBean = value;
            } else {
                bindingTitleBean = value;
            }
            if ((25 & j) != 0) {
                this.f13310a.k(bindingTitleBean);
            }
            if ((28 & j) != 0) {
                CommonBindingAdapter.O(this.f13309a, 0, iSafeUnbox, 0, 0, null);
            }
            if ((j & 26) != 0) {
                TextViewBindingAdapter.setText(this.b, letterTime);
                TextViewBindingAdapter.setText(((ActivityLetterBinding) this).f13305a, schoolLetterTitle);
            }
            ViewDataBinding.executeBindingsOn(this.f13310a);
        }
        letterTime = null;
        bindingTitleBean = null;
        schoolLetterTitle = null;
        iSafeUnbox = 0;
        if ((25 & j) != 0) {
            this.f13310a.k(bindingTitleBean);
        }
        if ((28 & j) != 0) {
            CommonBindingAdapter.O(this.f13309a, 0, iSafeUnbox, 0, 0, null);
        }
        if ((j & 26) != 0) {
            TextViewBindingAdapter.setText(this.b, letterTime);
            TextViewBindingAdapter.setText(((ActivityLetterBinding) this).f13305a, schoolLetterTitle);
        }
        ViewDataBinding.executeBindingsOn(this.f13310a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13308a != 0) {
                return true;
            }
            return this.f13310a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13308a = 16L;
        }
        this.f13310a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityLetterBinding
    public void k(@Nullable LetterDetailVM letterDetailVM) {
        ((ActivityLetterBinding) this).f13306a = letterDetailVM;
        synchronized (this) {
            this.f13308a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<LetterBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13308a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13308a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13308a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13310a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((LetterDetailVM) obj);
        return true;
    }

    public ActivityLetterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[1], (WebView) objArr[4]);
        this.f13308a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f13310a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13309a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.b = textView;
        textView.setTag(null);
        ((ActivityLetterBinding) this).f13305a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
