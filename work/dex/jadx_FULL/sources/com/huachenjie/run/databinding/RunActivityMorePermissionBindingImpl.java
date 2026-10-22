package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.page.MorePermissionActivity;
import com.huachenjie.run.page.MorePermissionVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityMorePermissionBindingImpl extends RunActivityMorePermissionBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f11524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11528a;

    @NonNull
    public final BLTextView d;

    @NonNull
    public final BLTextView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MorePermissionActivity.a f35482a;

        public a a(MorePermissionActivity.a value) {
            this.f35482a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35482a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MorePermissionActivity.a f35483a;

        public b a(MorePermissionActivity.a value) {
            this.f35483a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35483a.b(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(16);
        f11521a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{8}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35481a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.tv_not_remind, 9);
        sparseIntArray.put(com.huachenjie.run.R.id.dot_accessibility, 10);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_open_accessibility, 11);
        sparseIntArray.put(com.huachenjie.run.R.id.dot_power, 12);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_close_power_saving_mode, 13);
        sparseIntArray.put(com.huachenjie.run.R.id.dot_battery, 14);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_open_battery_white, 15);
    }

    public RunActivityMorePermissionBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 16, f11521a, f35481a));
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00b3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String str;
        String str2;
        a aVarA;
        b bVarA;
        boolean zSafeUnbox;
        String str3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f11522a;
            this.f11522a = 0L;
        }
        MorePermissionVM morePermissionVM = ((RunActivityMorePermissionBinding) this).f11515a;
        MorePermissionActivity.a aVar = ((RunActivityMorePermissionBinding) this).f11514a;
        boolean z = false;
        int iSafeUnbox = 0;
        if ((47 & j) != 0) {
            long j4 = j & 41;
            if (j4 != 0) {
                MutableLiveData<Boolean> mutableLiveDataJ = morePermissionVM != null ? morePermissionVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
                if (j4 != 0) {
                    if (zSafeUnbox2) {
                        j2 = j | 128;
                        j3 = 512;
                    } else {
                        j2 = j | 64;
                        j3 = 256;
                    }
                    j = j2 | j3;
                }
                boolean z2 = !zSafeUnbox2;
                str3 = zSafeUnbox2 ? "已开启" : "自动设置";
                str2 = zSafeUnbox2 ? "已成功开启，请开始跑步吧" : "一键自动开启";
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(z2));
            } else {
                zSafeUnbox = false;
                str2 = null;
                str3 = null;
            }
            if ((j & 44) != 0) {
                BaseViewModel.b bVarE = morePermissionVM != null ? morePermissionVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(2, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
            }
            if ((j & 42) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = morePermissionVM != null ? morePermissionVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            z = zSafeUnbox;
            str = str3;
        } else {
            iSafeUnbox = 0;
            value = null;
            str = null;
            str2 = null;
        }
        long j5 = 48 & j;
        if (j5 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f11527a;
            if (bVar == null) {
                bVar = new b();
                this.f11527a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11526a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11526a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.e0(((RunActivityMorePermissionBinding) this).f11516a, z);
            TextViewBindingAdapter.setText(((RunActivityMorePermissionBinding) this).f11516a, str);
            CommonBindingAdapter.e0(((RunActivityMorePermissionBinding) this).f11518b, z);
            TextViewBindingAdapter.setText(((RunActivityMorePermissionBinding) this).f11518b, str);
            CommonBindingAdapter.e0(((RunActivityMorePermissionBinding) this).f11520c, z);
            TextViewBindingAdapter.setText(((RunActivityMorePermissionBinding) this).f11520c, str);
            CommonBindingAdapter.e0(this.d, z);
            TextViewBindingAdapter.setText(this.d, str2);
            CommonBindingAdapter.l0(this.f11528a, z);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(((RunActivityMorePermissionBinding) this).f11516a, bVarA, null);
            CommonBindingAdapter.q(((RunActivityMorePermissionBinding) this).f11518b, bVarA, null);
            CommonBindingAdapter.q(((RunActivityMorePermissionBinding) this).f11520c, bVarA, null);
            CommonBindingAdapter.q(this.d, bVarA, null);
            CommonBindingAdapter.q(this.e, aVarA, null);
        }
        if ((42 & j) != 0) {
            this.f11525a.k(value);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.O(this.f11524a, 0, 0, 0, iSafeUnbox, null);
        }
        ViewDataBinding.executeBindingsOn(this.f11525a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11522a != 0) {
                return true;
            }
            return this.f11525a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11522a = 32L;
        }
        this.f11525a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityMorePermissionBinding
    public void l(@Nullable MorePermissionActivity.a Click) {
        ((RunActivityMorePermissionBinding) this).f11514a = Click;
        synchronized (this) {
            this.f11522a |= 16;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityMorePermissionBinding
    public void m(@Nullable MorePermissionVM Vm) {
        ((RunActivityMorePermissionBinding) this).f11515a = Vm;
        synchronized (this) {
            this.f11522a |= 8;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> VmIsOpen, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11522a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11522a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return p((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11522a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11525a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((MorePermissionVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((MorePermissionActivity.a) variable);
        }
        return true;
    }

    public RunActivityMorePermissionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (BLTextView) bindings[4], (BLTextView) bindings[3], (BLTextView) bindings[5], (ImageView) bindings[10], (ImageView) bindings[14], (ImageView) bindings[12], (TextView) bindings[13], (TextView) bindings[9], (TextView) bindings[11], (TextView) bindings[15]);
        this.f11522a = -1L;
        ((RunActivityMorePermissionBinding) this).f11516a.setTag(null);
        ((RunActivityMorePermissionBinding) this).f11518b.setTag(null);
        ((RunActivityMorePermissionBinding) this).f11520c.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[8];
        this.f11525a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11523a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[1];
        this.d = bLTextView;
        bLTextView.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[2];
        this.f11528a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        CardView cardView = (CardView) bindings[6];
        this.f11524a = cardView;
        cardView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[7];
        this.e = bLTextView2;
        bLTextView2.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
