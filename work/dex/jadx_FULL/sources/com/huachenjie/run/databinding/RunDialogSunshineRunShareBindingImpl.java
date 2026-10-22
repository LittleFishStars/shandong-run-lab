package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.share.SunshineRunShareDialog;
import com.huachenjie.run.page.share.SunshineRunShareVM;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogSunshineRunShareBindingImpl extends RunDialogSunshineRunShareBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final RunLayoutShareActionPanelBinding f11796a;

    @NonNull
    public final TextView g;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        f11793a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"run_layout_share_action_panel"}, new int[]{8}, new int[]{R.layout.run_layout_share_action_panel});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35563a = sparseIntArray;
        sparseIntArray.put(R.id.rlShareCard, 9);
        sparseIntArray.put(R.id.clShareContent, 10);
        sparseIntArray.put(R.id.ivShareBg, 11);
        sparseIntArray.put(R.id.tvShareDistanceLabel, 12);
    }

    public RunDialogSunshineRunShareBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 13, f11793a, f35563a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x0106  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        String value3;
        String value4;
        String value5;
        String value6;
        String value7;
        String value8;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f11794a;
            this.f11794a = 0L;
        }
        SunshineRunShareVM sunshineRunShareVM = ((RunDialogSunshineRunShareBinding) this).f11791a;
        SunshineRunShareDialog.a aVar = ((RunDialogSunshineRunShareBinding) this).f11790a;
        if ((1535 & j) != 0) {
            if ((j & 1281) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = sunshineRunShareVM != null ? sunshineRunShareVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 1282) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataQ = sunshineRunShareVM != null ? sunshineRunShareVM.q() : null;
                updateLiveDataRegistration(1, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value4 = mutableLiveDataQ.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 1284) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = sunshineRunShareVM != null ? sunshineRunShareVM.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 1288) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataN = sunshineRunShareVM != null ? sunshineRunShareVM.n() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value3 = mutableLiveDataN.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 1296) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = sunshineRunShareVM != null ? sunshineRunShareVM.k() : null;
                updateLiveDataRegistration(4, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value5 = mutableLiveDataK.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 1312) == 0) {
                value8 = null;
            } else {
                MutableLiveData<String> mutableLiveDataP = sunshineRunShareVM != null ? sunshineRunShareVM.p() : null;
                updateLiveDataRegistration(5, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value8 = mutableLiveDataP.getValue();
                } else {
                    value8 = null;
                }
            }
            if ((j & 1344) == 0) {
                value6 = null;
            } else {
                MutableLiveData<String> mutableLiveDataM = sunshineRunShareVM != null ? sunshineRunShareVM.m() : null;
                updateLiveDataRegistration(6, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value6 = mutableLiveDataM.getValue();
                } else {
                    value6 = null;
                }
            }
            if ((j & 1408) == 0) {
                value7 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = sunshineRunShareVM != null ? sunshineRunShareVM.l() : null;
                updateLiveDataRegistration(7, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value7 = mutableLiveDataL.getValue();
                } else {
                    value7 = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
            value4 = null;
            value5 = null;
            value6 = null;
            value7 = null;
            value8 = null;
        }
        long j2 = j & 1536;
        if ((j & 1296) != 0) {
            requestOptions = null;
            aw9.d(((RunDialogSunshineRunShareBinding) this).f11789a, value5, false, null);
        } else {
            requestOptions = null;
        }
        if ((j & 1281) != 0) {
            aw9.c(((RunDialogSunshineRunShareBinding) this).f11789a, value, requestOptions);
        }
        if (j2 != 0) {
            this.f11796a.l(aVar);
        }
        if ((1280 & j) != 0) {
            this.f11796a.m(sunshineRunShareVM);
        }
        if ((j & 1282) != 0) {
            TextViewBindingAdapter.setText(this.g, value4);
        }
        if ((1408 & j) != 0) {
            TextViewBindingAdapter.setText(((RunDialogSunshineRunShareBinding) this).f11787a, value7);
        }
        if ((1344 & j) != 0) {
            TextViewBindingAdapter.setText(this.b, value6);
        }
        if ((1288 & j) != 0) {
            TextViewBindingAdapter.setText(this.d, value3);
        }
        if ((j & 1284) != 0) {
            TextViewBindingAdapter.setText(this.e, value2);
        }
        if ((j & 1312) != 0) {
            TextViewBindingAdapter.setText(this.f, value8);
        }
        ViewDataBinding.executeBindingsOn(this.f11796a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11794a != 0) {
                return true;
            }
            return this.f11796a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11794a = 1024L;
        }
        this.f11796a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogSunshineRunShareBinding
    public void l(@Nullable SunshineRunShareDialog.a Click) {
        ((RunDialogSunshineRunShareBinding) this).f11790a = Click;
        synchronized (this) {
            this.f11794a |= 512;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogSunshineRunShareBinding
    public void m(@Nullable SunshineRunShareVM Vm) {
        ((RunDialogSunshineRunShareBinding) this).f11791a = Vm;
        synchronized (this) {
            this.f11794a |= 256;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmAvatarFrameUrl, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmAvatarUrl, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return n((MutableLiveData) object, fieldId);
            case 1:
                return u((MutableLiveData) object, fieldId);
            case 2:
                return s((MutableLiveData) object, fieldId);
            case 3:
                return r((MutableLiveData) object, fieldId);
            case 4:
                return o((MutableLiveData) object, fieldId);
            case 5:
                return t((MutableLiveData) object, fieldId);
            case 6:
                return q((MutableLiveData) object, fieldId);
            case 7:
                return p((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> VmCalorieText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 128;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> VmDistanceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 64;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> VmDurationText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> VmNickName, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11796a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRunShareVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SunshineRunShareDialog.a) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<String> VmPaceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 32;
        }
        return true;
    }

    public final boolean u(MutableLiveData<String> VmUserIdText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11794a |= 2;
        }
        return true;
    }

    public RunDialogSunshineRunShareBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (ConstraintLayout) bindings[10], (AvatarView) bindings[1], (ImageView) bindings[11], (BLRelativeLayout) bindings[9], (TextView) bindings[5], (TextView) bindings[4], (TextView) bindings[12], (TextView) bindings[6], (TextView) bindings[2], (TextView) bindings[7]);
        this.f11794a = -1L;
        ((RunDialogSunshineRunShareBinding) this).f11789a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f11795a = frameLayout;
        frameLayout.setTag(null);
        RunLayoutShareActionPanelBinding runLayoutShareActionPanelBinding = (RunLayoutShareActionPanelBinding) bindings[8];
        this.f11796a = runLayoutShareActionPanelBinding;
        setContainedBinding(runLayoutShareActionPanelBinding);
        TextView textView = (TextView) bindings[3];
        this.g = textView;
        textView.setTag(null);
        ((RunDialogSunshineRunShareBinding) this).f11787a.setTag(null);
        this.b.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
