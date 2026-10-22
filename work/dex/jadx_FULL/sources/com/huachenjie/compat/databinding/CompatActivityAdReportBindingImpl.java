package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.compat.page.ad_report.AdReportActivity;
import com.huachenjie.compat.page.ad_report.AdReportViewModel;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLTextView;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CompatActivityAdReportBindingImpl extends CompatActivityAdReportBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f9176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9180a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((CompatActivityAdReportBinding) CompatActivityAdReportBindingImpl.this).f9173a);
            AdReportViewModel adReportViewModel = ((CompatActivityAdReportBinding) CompatActivityAdReportBindingImpl.this).f9172a;
            if (adReportViewModel != null) {
                MutableLiveData<String> mutableLiveDataJ = adReportViewModel.j();
                if (mutableLiveDataJ != null) {
                    mutableLiveDataJ.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AdReportActivity.a f34057a;

        public b a(AdReportActivity.a aVar) {
            this.f34057a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34057a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f9174a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f34055a = null;
    }

    public CompatActivityAdReportBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9174a, f34055a));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String value;
        String str;
        BindingTitleBean value2;
        b bVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f9175a;
            this.f9175a = 0L;
        }
        AdReportViewModel adReportViewModel = ((CompatActivityAdReportBinding) this).f9172a;
        AdReportActivity.a aVar = ((CompatActivityAdReportBinding) this).f9171a;
        if ((94 & j) != 0) {
            if ((j & 88) != 0) {
                BaseViewModel.b bVarE = adReportViewModel != null ? adReportViewModel.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(3, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 8));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 82) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = adReportViewModel != null ? adReportViewModel.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<String> mutableLiveDataJ = adReportViewModel != null ? adReportViewModel.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                str = String.format("%d/200", Integer.valueOf(value != null ? value.length() : 0));
                i = iSafeUnbox;
            } else {
                i = iSafeUnbox;
                value = null;
                str = null;
            }
        } else {
            i = 0;
            value = null;
            str = null;
            value2 = null;
        }
        long j2 = 96 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f9179a;
            if (bVar == null) {
                bVar = new b();
                this.f9179a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 84) != 0) {
            TextViewBindingAdapter.setText(((CompatActivityAdReportBinding) this).f9173a, value);
            TextViewBindingAdapter.setText(this.f9177a, str);
        }
        if ((64 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((CompatActivityAdReportBinding) this).f9173a, null, null, null, this.f9178a);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.I(this.f9180a, 16, 8, 16, i, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9180a, bVarA, null);
        }
        if ((j & 82) != 0) {
            ((CompatActivityAdReportBinding) this).f34054a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((CompatActivityAdReportBinding) this).f34054a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9175a != 0) {
                return true;
            }
            return ((CompatActivityAdReportBinding) this).f34054a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9175a = 64L;
        }
        ((CompatActivityAdReportBinding) this).f34054a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatActivityAdReportBinding
    public void l(@Nullable AdReportActivity.a aVar) {
        ((CompatActivityAdReportBinding) this).f9171a = aVar;
        synchronized (this) {
            this.f9175a |= 32;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatActivityAdReportBinding
    public void m(@Nullable AdReportViewModel adReportViewModel) {
        ((CompatActivityAdReportBinding) this).f9172a = adReportViewModel;
        synchronized (this) {
            this.f9175a |= 16;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9175a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9175a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9175a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9175a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((CompatActivityAdReportBinding) this).f34054a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((AdReportViewModel) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((AdReportActivity.a) obj);
        }
        return true;
    }

    public CompatActivityAdReportBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (BLEditText) objArr[1], (LayoutToolbarBindingBinding) objArr[4]);
        this.f9178a = new a();
        this.f9175a = -1L;
        ((CompatActivityAdReportBinding) this).f9173a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f9176a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9177a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f9180a = bLTextView;
        bLTextView.setTag(null);
        setContainedBinding(((CompatActivityAdReportBinding) this).f34054a);
        setRootTag(view);
        invalidateAll();
    }
}
