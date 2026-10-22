package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.bean.RunDetailFaceCheckInfoBean;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutRunFaceDetectBindingImpl extends RunLayoutRunFaceDetectBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12131a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12136a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12137b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunDetailActivity.a f35687a;

        public a a(RunDetailActivity.a value) {
            this.f35687a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35687a.e(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35686a = sparseIntArray;
        sparseIntArray.put(R.id.rv_face_img, 6);
    }

    public RunLayoutRunFaceDetectBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f12131a, f35686a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int faceCheckResultIcon;
        int faceCheckResultBg;
        boolean zIsRunFaceFlag;
        int faceCheckResultColor;
        String faceCheckResultText;
        RequestOptions requestOptions;
        String userFaceImg;
        a aVarA;
        synchronized (this) {
            j = this.f12132a;
            this.f12132a = 0L;
        }
        RunDetailVM runDetailVM = ((RunLayoutRunFaceDetectBinding) this).f12130a;
        RunDetailActivity.a aVar = ((RunLayoutRunFaceDetectBinding) this).f12129a;
        long j2 = 11 & j;
        if (j2 != 0) {
            requestOptions = RunDetailFaceCheckInfoBean.rounded12;
            MutableLiveData<RunDetailEntity> mutableLiveDataL = runDetailVM != null ? runDetailVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            RunDetailEntity value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            if (value != null) {
                userFaceImg = value.getUserFaceImg();
                faceCheckResultIcon = value.getFaceCheckResultIcon();
                faceCheckResultBg = value.getFaceCheckResultBg();
                zIsRunFaceFlag = value.isRunFaceFlag();
                faceCheckResultColor = value.getFaceCheckResultColor();
                faceCheckResultText = value.getFaceCheckResultText();
            } else {
                faceCheckResultIcon = 0;
                faceCheckResultBg = 0;
                zIsRunFaceFlag = false;
                faceCheckResultColor = 0;
                faceCheckResultText = null;
                userFaceImg = null;
            }
        } else {
            faceCheckResultIcon = 0;
            faceCheckResultBg = 0;
            zIsRunFaceFlag = false;
            faceCheckResultColor = 0;
            faceCheckResultText = null;
            requestOptions = null;
            userFaceImg = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f12135a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f12135a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f12136a, zIsRunFaceFlag);
            CommonBindingAdapter.x(this.f12134a, faceCheckResultBg);
            CommonBindingAdapter.a0(this.f12133a, faceCheckResultIcon);
            TextViewBindingAdapter.setText(this.f12137b, faceCheckResultText);
            this.f12137b.setTextColor(faceCheckResultColor);
            CommonBindingAdapter.b0(this.b, userFaceImg, requestOptions, false);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((RunLayoutRunFaceDetectBinding) this).f35685a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12132a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12132a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutRunFaceDetectBinding
    public void l(@Nullable RunDetailActivity.a Click) {
        ((RunLayoutRunFaceDetectBinding) this).f12129a = Click;
        synchronized (this) {
            this.f12132a |= 4;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutRunFaceDetectBinding
    public void m(@Nullable RunDetailVM Vm) {
        ((RunLayoutRunFaceDetectBinding) this).f12130a = Vm;
        synchronized (this) {
            this.f12132a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<RunDetailEntity> VmDetailLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12132a |= 1;
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
            m((RunDetailVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunDetailActivity.a) variable);
        }
        return true;
    }

    public RunLayoutRunFaceDetectBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (RecyclerView) bindings[6], (TextView) bindings[1]);
        this.f12132a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[0];
        this.f12136a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[2];
        this.f12134a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[3];
        this.f12133a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) bindings[4];
        this.f12137b = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[5];
        this.b = imageView2;
        imageView2.setTag(null);
        ((RunLayoutRunFaceDetectBinding) this).f35685a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
