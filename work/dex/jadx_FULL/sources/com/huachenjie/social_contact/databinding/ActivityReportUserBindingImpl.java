package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.social_contact.page.report.ReportImageEvidenceAdapter;
import com.huachenjie.social_contact.page.report.ReportUserActivity;
import com.huachenjie.social_contact.page.report.ReportUserAdapter;
import com.huachenjie.social_contact.page.report.ReportUserVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityReportUserBindingImpl extends ActivityReportUserBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f12779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f12780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12781a;

    @NonNull
    public final LinearLayout c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityReportUserBinding) ActivityReportUserBindingImpl.this).f36102a);
            ReportUserVM reportUserVM = ((ActivityReportUserBinding) ActivityReportUserBindingImpl.this).f12774a;
            if (reportUserVM != null) {
                MutableLiveData<String> mutableLiveDataM = reportUserVM.m();
                if (mutableLiveDataM != null) {
                    mutableLiveDataM.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ReportUserActivity.a f36105a;

        public b a(ReportUserActivity.a aVar) {
            this.f36105a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36105a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f12777a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36103a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.social_contact.R.id.tvReportReason, 8);
        sparseIntArray.put(com.huachenjie.social_contact.R.id.ll_report_image_tip, 9);
        sparseIntArray.put(com.huachenjie.social_contact.R.id.report_text_tip, 10);
    }

    public ActivityReportUserBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f12777a, f36103a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d6  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ReportUserAdapter value;
        String value2;
        String str;
        ReportImageEvidenceAdapter value3;
        String value4;
        BindingTitleBean value5;
        b bVarA;
        synchronized (this) {
            j = this.f12778a;
            this.f12778a = 0L;
        }
        ReportUserVM reportUserVM = ((ActivityReportUserBinding) this).f12774a;
        ReportUserActivity.a aVar = ((ActivityReportUserBinding) this).f12773a;
        if ((383 & j) != 0) {
            if ((j & 321) == 0) {
                value2 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataN = reportUserVM != null ? reportUserVM.n() : null;
                updateLiveDataRegistration(0, mediatorLiveDataN);
                if (mediatorLiveDataN != null) {
                    value2 = mediatorLiveDataN.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 322) != 0) {
                MutableLiveData<Integer> mutableLiveDataL = reportUserVM != null ? reportUserVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                str = String.format("%d/3", mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
            } else {
                str = null;
            }
            if ((j & 324) == 0) {
                value5 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataQ = reportUserVM != null ? reportUserVM.q() : null;
                updateLiveDataRegistration(2, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value5 = mutableLiveDataQ.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 328) == 0) {
                value3 = null;
            } else {
                MutableLiveData<ReportImageEvidenceAdapter> mutableLiveDataK = reportUserVM != null ? reportUserVM.k() : null;
                updateLiveDataRegistration(3, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value3 = mutableLiveDataK.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 336) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataM = reportUserVM != null ? reportUserVM.m() : null;
                updateLiveDataRegistration(4, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value4 = mutableLiveDataM.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 352) == 0) {
                value = null;
            } else {
                MutableLiveData<ReportUserAdapter> mutableLiveDataH = reportUserVM != null ? reportUserVM.h() : null;
                updateLiveDataRegistration(5, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value = mutableLiveDataH.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            str = null;
            value3 = null;
            value4 = null;
            value5 = null;
        }
        long j2 = j & 384;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f12781a;
            if (bVar == null) {
                bVar = new b();
                this.f12781a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 336) != 0) {
            TextViewBindingAdapter.setText(((ActivityReportUserBinding) this).f36102a, value4);
        }
        if ((j & 256) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityReportUserBinding) this).f36102a, null, null, null, this.f12779a);
        }
        if ((j & 328) != 0) {
            CommonBindingAdapter.g(((ActivityReportUserBinding) this).f12772a, value3, false, false);
        }
        if ((324 & j) != 0) {
            this.f12780a.k(value5);
        }
        if ((352 & j) != 0) {
            CommonBindingAdapter.g(((ActivityReportUserBinding) this).f12776b, value, false, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityReportUserBinding) this).f12771a, bVarA, null);
        }
        if ((322 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityReportUserBinding) this).f12775b, str);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(this.d, value2);
        }
        ViewDataBinding.executeBindingsOn(this.f12780a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12778a != 0) {
                return true;
            }
            return this.f12780a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12778a = 256L;
        }
        this.f12780a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityReportUserBinding
    public void l(@Nullable ReportUserActivity.a aVar) {
        ((ActivityReportUserBinding) this).f12773a = aVar;
        synchronized (this) {
            this.f12778a |= 128;
        }
        notifyPropertyChanged(nk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityReportUserBinding
    public void m(@Nullable ReportUserVM reportUserVM) {
        ((ActivityReportUserBinding) this).f12774a = reportUserVM;
        synchronized (this) {
            this.f12778a |= 64;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ReportUserAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12778a |= 32;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ReportImageEvidenceAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12778a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MediatorLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 4) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12778a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12778a |= 16;
        }
        return true;
    }

    public final boolean r(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12778a |= 1;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12778a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f12780a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            m((ReportUserVM) obj);
        } else {
            if (nk0.k != i) {
                return false;
            }
            l((ReportUserActivity.a) obj);
        }
        return true;
    }

    public ActivityReportUserBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (EditText) objArr[4], (RecyclerView) objArr[3], (LinearLayout) objArr[9], (LinearLayout) objArr[10], (RecyclerView) objArr[1], (TextView) objArr[6], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[5]);
        this.f12779a = new a();
        this.f12778a = -1L;
        ((ActivityReportUserBinding) this).f36102a.setTag(null);
        ((ActivityReportUserBinding) this).f12772a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[7];
        this.f12780a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.c = linearLayout;
        linearLayout.setTag(null);
        ((ActivityReportUserBinding) this).f12776b.setTag(null);
        ((ActivityReportUserBinding) this).f12771a.setTag(null);
        ((ActivityReportUserBinding) this).f12775b.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
