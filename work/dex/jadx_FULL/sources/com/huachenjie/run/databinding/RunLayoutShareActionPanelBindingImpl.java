package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.page.share.ShareActionClick;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutShareActionPanelBindingImpl extends RunLayoutShareActionPanelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35702a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12170a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12178a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final LinearLayout c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareActionClick f35703a;

        public a a(ShareActionClick value) {
            this.f35703a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35703a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareActionClick f35704a;

        public b a(ShareActionClick value) {
            this.f35704a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35704a.c(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareActionClick f35705a;

        public c a(ShareActionClick value) {
            this.f35705a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35705a.b(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShareActionClick f35706a;

        public d a(ShareActionClick value) {
            this.f35706a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35706a.d(arg0);
        }
    }

    public RunLayoutShareActionPanelBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f12170a, f35702a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        d dVarA;
        a aVarA;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f12171a;
            this.f12171a = 0L;
        }
        BaseViewModel baseViewModel = ((RunLayoutShareActionPanelBinding) this).f35701a;
        ShareActionClick shareActionClick = ((RunLayoutShareActionPanelBinding) this).f12169a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = baseViewModel != null ? baseViewModel.e() : null;
            MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
            updateLiveDataRegistration(0, mutableLiveDataA);
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 12));
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || shareActionClick == null) {
            dVarA = null;
            aVarA = null;
            bVarA = null;
            cVarA = null;
        } else {
            d dVar = this.f12176a;
            if (dVar == null) {
                dVar = new d();
                this.f12176a = dVar;
            }
            dVarA = dVar.a(shareActionClick);
            a aVar = this.f12173a;
            if (aVar == null) {
                aVar = new a();
                this.f12173a = aVar;
            }
            aVarA = aVar.a(shareActionClick);
            b bVar = this.f12174a;
            if (bVar == null) {
                bVar = new b();
                this.f12174a = bVar;
            }
            bVarA = bVar.a(shareActionClick);
            c cVar = this.f12175a;
            if (cVar == null) {
                cVar = new c();
                this.f12175a = cVar;
            }
            cVarA = cVar.a(shareActionClick);
        }
        if (j2 != 0) {
            CommonBindingAdapter.O(this.f12177a, 0, 0, 0, i, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f12172a, dVarA, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
            CommonBindingAdapter.q(this.c, aVarA, null);
            CommonBindingAdapter.q(this.f12178a, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12171a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12171a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutShareActionPanelBinding
    public void l(@Nullable ShareActionClick Click) {
        ((RunLayoutShareActionPanelBinding) this).f12169a = Click;
        synchronized (this) {
            this.f12171a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutShareActionPanelBinding
    public void m(@Nullable BaseViewModel Vm) {
        ((RunLayoutShareActionPanelBinding) this).f35701a = Vm;
        synchronized (this) {
            this.f12171a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12171a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((BaseViewModel) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((ShareActionClick) variable);
        }
        return true;
    }

    public RunLayoutShareActionPanelBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f12171a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f12177a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.f12172a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[2];
        this.b = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[3];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[4];
        this.f12178a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
