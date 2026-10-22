package com.huachenjie.base.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.lottery.LotteryVM;
import com.huachenjie.base.widget.stroke.StrokeTextView;
import com.zj.adlib.sk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DialogLotteryBindingImpl extends DialogLotteryBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f32826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7021a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StrokeTextView f7024a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f32826a = sparseIntArray;
        sparseIntArray.put(R.id.iv_lottery, 2);
    }

    public DialogLotteryBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f7021a, f32826a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7022a;
            this.f7022a = 0L;
        }
        LotteryVM lotteryVM = ((DialogLotteryBinding) this).f7020a;
        long j2 = j & 7;
        String value = null;
        if (j2 != 0) {
            MutableLiveData<String> mutableLiveDataL = lotteryVM != null ? lotteryVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            if (mutableLiveDataL != null) {
                value = mutableLiveDataL.getValue();
            }
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f7024a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7022a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7022a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.base.databinding.DialogLotteryBinding
    public void k(@Nullable LotteryVM Vm) {
        ((DialogLotteryBinding) this).f7020a = Vm;
        synchronized (this) {
            this.f7022a |= 2;
        }
        notifyPropertyChanged(sk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<String> VmTitle, int fieldId) {
        if (fieldId != sk0.f44705a) {
            return false;
        }
        synchronized (this) {
            this.f7022a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (sk0.p0 != variableId) {
            return false;
        }
        k((LotteryVM) variable);
        return true;
    }

    public DialogLotteryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[2]);
        this.f7022a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.f7023a = frameLayout;
        frameLayout.setTag(null);
        StrokeTextView strokeTextView = (StrokeTextView) bindings[1];
        this.f7024a = strokeTextView;
        strokeTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
