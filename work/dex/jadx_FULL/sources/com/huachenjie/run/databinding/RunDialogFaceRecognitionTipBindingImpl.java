package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.FaceRecognitionTipDialog;
import com.huachenjie.run.dialog.FaceRecognitionTipViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDialogFaceRecognitionTipBindingImpl extends RunDialogFaceRecognitionTipBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11697a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f11699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11701a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FaceRecognitionTipDialog.a f35529a;

        public a a(FaceRecognitionTipDialog.a value) {
            this.f35529a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35529a.a(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35528a = sparseIntArray;
        sparseIntArray.put(R.id.tvDesc, 3);
    }

    public RunDialogFaceRecognitionTipBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11697a, f35528a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String strValueOf;
        a aVarA;
        synchronized (this) {
            j = this.f11698a;
            this.f11698a = 0L;
        }
        FaceRecognitionTipViewModel faceRecognitionTipViewModel = ((RunDialogFaceRecognitionTipBinding) this).f11696a;
        FaceRecognitionTipDialog.a aVar = ((RunDialogFaceRecognitionTipBinding) this).f11695a;
        long j2 = 11 & j;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveDataI = faceRecognitionTipViewModel != null ? faceRecognitionTipViewModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            strValueOf = String.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null));
        } else {
            strValueOf = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11700a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11700a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.b, strValueOf);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f11701a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11698a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11698a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogFaceRecognitionTipBinding
    public void l(@Nullable FaceRecognitionTipDialog.a Click) {
        ((RunDialogFaceRecognitionTipBinding) this).f11695a = Click;
        synchronized (this) {
            this.f11698a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunDialogFaceRecognitionTipBinding
    public void m(@Nullable FaceRecognitionTipViewModel Vm) {
        ((RunDialogFaceRecognitionTipBinding) this).f11696a = Vm;
        synchronized (this) {
            this.f11698a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> VmLeftTime, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11698a |= 1;
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
            m((FaceRecognitionTipViewModel) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((FaceRecognitionTipDialog.a) variable);
        }
        return true;
    }

    public RunDialogFaceRecognitionTipBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (TextView) bindings[3]);
        this.f11698a = -1L;
        CardView cardView = (CardView) bindings[0];
        this.f11699a = cardView;
        cardView.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.b = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[2];
        this.f11701a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
