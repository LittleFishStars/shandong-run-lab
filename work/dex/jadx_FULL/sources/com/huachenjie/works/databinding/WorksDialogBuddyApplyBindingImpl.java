package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.page.buddy.BuddyApplyDialog;
import com.huachenjie.works.page.buddy.BuddyApplyVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksDialogBuddyApplyBindingImpl extends WorksDialogBuddyApplyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14021a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f14023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f14024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f14025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14026a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BuddyApplyDialog.a f36839a;

        public a a(BuddyApplyDialog.a value) {
            this.f36839a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36839a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BuddyApplyDialog.a f36840a;

        public b a(BuddyApplyDialog.a value) {
            this.f36840a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36840a.b(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36838a = sparseIntArray;
        sparseIntArray.put(R.id.ll_content, 6);
        sparseIntArray.put(R.id.hsv_buddy_tags, 7);
        sparseIntArray.put(R.id.ll_buddy_tags, 8);
        sparseIntArray.put(R.id.et_apply_message, 9);
        sparseIntArray.put(R.id.tv_message_count, 10);
    }

    public WorksDialogBuddyApplyBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 11, f14021a, f36838a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        int i;
        String value;
        String value2;
        a aVarA;
        b bVarA;
        int iSafeUnbox2;
        synchronized (this) {
            j = this.f14022a;
            this.f14022a = 0L;
        }
        BuddyApplyVM buddyApplyVM = ((WorksDialogBuddyApplyBinding) this).f14019a;
        BuddyApplyDialog.a aVar = ((WorksDialogBuddyApplyBinding) this).f14018a;
        if ((95 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataN = buddyApplyVM != null ? buddyApplyVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value2 = mutableLiveDataN.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 82) != 0) {
                MutableLiveData<Integer> mutableLiveDataM = buddyApplyVM != null ? buddyApplyVM.m() : null;
                updateLiveDataRegistration(1, mutableLiveDataM);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 88) != 0) {
                BaseViewModel.b bVarE = buddyApplyVM != null ? buddyApplyVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(3, mutableLiveDataA);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 84) == 0) {
                i = iSafeUnbox2;
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = buddyApplyVM != null ? buddyApplyVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                    i = iSafeUnbox2;
                } else {
                    i = iSafeUnbox2;
                    value = null;
                }
            }
        } else {
            iSafeUnbox = 0;
            i = 0;
            value = null;
            value2 = null;
        }
        long j2 = 96 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f14025a;
            if (bVar == null) {
                bVar = new b();
                this.f14025a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f14024a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f14024a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 84) != 0) {
            aw9.d(((WorksDialogBuddyApplyBinding) this).f14017a, value, false, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f14023a, aVarA, null);
            CommonBindingAdapter.q(this.f14026a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        if ((j & 81) != 0) {
            TextViewBindingAdapter.setText(((WorksDialogBuddyApplyBinding) this).f14016a, value2);
        }
        if ((82 & j) != 0) {
            CommonBindingAdapter.G(((WorksDialogBuddyApplyBinding) this).f36837a, iSafeUnbox);
        }
        if ((j & 88) != 0) {
            CommonBindingAdapter.I(((WorksDialogBuddyApplyBinding) this).f36837a, 0, 0, 0, i, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14022a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14022a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogBuddyApplyBinding
    public void l(@Nullable BuddyApplyDialog.a Click) {
        ((WorksDialogBuddyApplyBinding) this).f14018a = Click;
        synchronized (this) {
            this.f14022a |= 32;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksDialogBuddyApplyBinding
    public void m(@Nullable BuddyApplyVM Vm) {
        ((WorksDialogBuddyApplyBinding) this).f14019a = Vm;
        synchronized (this) {
            this.f14022a |= 16;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmAvatarUrl, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14022a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmKeyboardHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14022a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return q((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<String> VmTitle, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14022a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> VmUiLiveDataNavigationBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14022a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((BuddyApplyVM) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((BuddyApplyDialog.a) variable);
        }
        return true;
    }

    public WorksDialogBuddyApplyBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (EditText) bindings[9], (HorizontalScrollView) bindings[7], (AvatarView) bindings[1], (LinearLayout) bindings[8], (BLLinearLayout) bindings[6], (TextView) bindings[2], (TextView) bindings[10], (View) bindings[5]);
        this.f14022a = -1L;
        ((WorksDialogBuddyApplyBinding) this).f14017a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f14023a = frameLayout;
        frameLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[3];
        this.f14026a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) bindings[4];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        ((WorksDialogBuddyApplyBinding) this).f14016a.setTag(null);
        ((WorksDialogBuddyApplyBinding) this).f36837a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
