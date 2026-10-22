package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
import com.huachenjie.works.bean.dorm.DormUserInfoBean;
import com.huachenjie.works.page.dormitory.DormitoryAdapter;
import com.huachenjie.works.page.dormitory.DormitoryVM;
import com.huachenjie.works.widget.EnergyCircleView;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityDormitoryBindingImpl extends WorksActivityDormitoryBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13864a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13865a;

    @NonNull
    public final ConstraintLayout b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36779a = sparseIntArray;
        sparseIntArray.put(R.id.fl_title, 7);
        sparseIntArray.put(R.id.tv_title, 8);
        sparseIntArray.put(R.id.ll_top_info, 9);
        sparseIntArray.put(R.id.iv_add_gold, 10);
        sparseIntArray.put(R.id.cl_charm_card, 11);
        sparseIntArray.put(R.id.view_charm_bg, 12);
        sparseIntArray.put(R.id.tv_charm_label, 13);
        sparseIntArray.put(R.id.v_charm_bottom, 14);
        sparseIntArray.put(R.id.iv_charm_icon, 15);
        sparseIntArray.put(R.id.iv_rule, 16);
        sparseIntArray.put(R.id.sp_character, 17);
        sparseIntArray.put(R.id.view_energy, 18);
        sparseIntArray.put(R.id.ll_bottom_menu, 19);
    }

    public WorksActivityDormitoryBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 20, f13864a, f36779a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d8  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        DormitoryAdapter value;
        boolean showSupplementBtn;
        int iSafeUnbox;
        String str;
        String inspirationValue;
        String value2;
        String starStone;
        synchronized (this) {
            j = this.f13865a;
            this.f13865a = 0L;
        }
        DormitoryVM dormitoryVM = ((WorksActivityDormitoryBinding) this).f13853a;
        if ((127 & j) != 0) {
            if ((j & 97) == 0) {
                showSupplementBtn = false;
            } else {
                MutableLiveData<DormEnergyBean> mutableLiveDataJ = dormitoryVM != null ? dormitoryVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                DormEnergyBean value3 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                if (value3 != null) {
                    showSupplementBtn = value3.getShowSupplementBtn();
                } else {
                    showSupplementBtn = false;
                }
            }
            if ((j & 98) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataI = dormitoryVM != null ? dormitoryVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 104) != 0) {
                BaseViewModel.b bVarE = dormitoryVM != null ? dormitoryVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 4));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 100) == 0) {
                inspirationValue = null;
                starStone = null;
            } else {
                MutableLiveData<DormUserInfoBean> mutableLiveDataL = dormitoryVM != null ? dormitoryVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                DormUserInfoBean value4 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value4 != null) {
                    starStone = value4.getStarStone();
                    inspirationValue = value4.getInspirationValue();
                } else {
                    inspirationValue = null;
                    starStone = null;
                }
            }
            if ((j & 112) == 0) {
                value = null;
            } else {
                MutableLiveData<DormitoryAdapter> mutableLiveDataK = dormitoryVM != null ? dormitoryVM.k() : null;
                updateLiveDataRegistration(4, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
            str = starStone;
        } else {
            value = null;
            showSupplementBtn = false;
            iSafeUnbox = 0;
            str = null;
            inspirationValue = null;
            value2 = null;
        }
        if ((j & 97) != 0) {
            CommonBindingAdapter.l0(((WorksActivityDormitoryBinding) this).f36778a, showSupplementBtn);
        }
        if ((j & 104) != 0) {
            CommonBindingAdapter.I(((WorksActivityDormitoryBinding) this).c, 0, iSafeUnbox, 0, 0, null);
        }
        if ((112 & j) != 0) {
            CommonBindingAdapter.g(((WorksActivityDormitoryBinding) this).f13851a, value, false, false);
        }
        if ((98 & j) != 0) {
            TextViewBindingAdapter.setText(((WorksActivityDormitoryBinding) this).f13858b, value2);
        }
        if ((j & 100) != 0) {
            TextViewBindingAdapter.setText(((WorksActivityDormitoryBinding) this).f13861c, inspirationValue);
            TextViewBindingAdapter.setText(((WorksActivityDormitoryBinding) this).f13862d, str);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13865a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13865a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityDormitoryBinding
    public void k(@Nullable DormitoryVM Vm) {
        ((WorksActivityDormitoryBinding) this).f13853a = Vm;
        synchronized (this) {
            this.f13865a |= 32;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<String> VmCharmValue, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13865a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<DormEnergyBean> VmEnergyBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13865a |= 1;
        }
        return true;
    }

    public final boolean n(MutableLiveData<DormitoryAdapter> VmMenuAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13865a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13865a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return l((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<DormUserInfoBean> VmUserBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13865a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((DormitoryVM) variable);
        return true;
    }

    public WorksActivityDormitoryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (ConstraintLayout) bindings[11], (BLFrameLayout) bindings[7], (ImageView) bindings[5], (ImageView) bindings[10], (ImageView) bindings[1], (ImageView) bindings[15], (ImageView) bindings[16], (BLFrameLayout) bindings[19], (BLLinearLayout) bindings[9], (RecyclerView) bindings[6], (SpineWebView) bindings[17], (TextView) bindings[13], (TextView) bindings[4], (TextView) bindings[2], (TextView) bindings[3], (TextView) bindings[8], (BLView) bindings[14], (BLView) bindings[12], (EnergyCircleView) bindings[18]);
        this.f13865a = -1L;
        ((WorksActivityDormitoryBinding) this).f36778a.setTag(null);
        ((WorksActivityDormitoryBinding) this).c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        ((WorksActivityDormitoryBinding) this).f13851a.setTag(null);
        ((WorksActivityDormitoryBinding) this).f13858b.setTag(null);
        ((WorksActivityDormitoryBinding) this).f13861c.setTag(null);
        ((WorksActivityDormitoryBinding) this).f13862d.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
