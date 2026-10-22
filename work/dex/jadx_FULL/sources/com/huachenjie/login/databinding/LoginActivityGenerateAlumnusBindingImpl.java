package com.huachenjie.login.databinding;

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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.GradeBean;
import com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity;
import com.huachenjie.login.page.info.alumnus.GenerateAlumnusModel;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.zj.adlib.ju3;
import com.zj.adlib.pg3;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityGenerateAlumnusBindingImpl extends LoginActivityGenerateAlumnusBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9995a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9998a;

    @NonNull
    public final TextView e;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GenerateAlumnusActivity.a f34646a;

        public a a(GenerateAlumnusActivity.a aVar) {
            this.f34646a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34646a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34645a = sparseIntArray;
        sparseIntArray.put(R.id.iv_head, 7);
        sparseIntArray.put(R.id.iv_bottom, 8);
        sparseIntArray.put(R.id.ll_school, 9);
        sparseIntArray.put(R.id.ll_year, 10);
        sparseIntArray.put(R.id.ll_id, 11);
    }

    public LoginActivityGenerateAlumnusBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f9995a, f34645a));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        String schoolName;
        String str;
        String str2;
        String name;
        String str3;
        boolean zSafeUnbox;
        String value;
        String str4;
        long j2;
        a aVarA;
        synchronized (this) {
            j = this.f9996a;
            this.f9996a = 0L;
        }
        GenerateAlumnusModel generateAlumnusModel = ((LoginActivityGenerateAlumnusBinding) this).f9990a;
        GenerateAlumnusActivity.a aVar = ((LoginActivityGenerateAlumnusBinding) this).f9989a;
        if ((j & 16) != 0) {
            requestOptions = ju3.b;
            SchoolInfo schoolInfo = pg3.com.huachenjie.common.constants.UserConstants.LOGIN_PARAMS.c java.lang.String;
            str = pg3.alumnusId;
            str2 = pg3.com.huachenjie.common.constants.UserConstants.USER_PARAMS.b java.lang.String;
            GradeBean gradeBean = pg3.gradeInfo;
            str3 = pg3.portraitUrl;
            schoolName = schoolInfo != null ? schoolInfo.getSchoolName() : null;
            name = gradeBean != null ? gradeBean.getName() : null;
        } else {
            requestOptions = null;
            schoolName = null;
            str = null;
            str2 = null;
            name = null;
            str3 = null;
        }
        if ((j & 23) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = generateAlumnusModel != null ? generateAlumnusModel.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            long j3 = j & 22;
            if (j3 != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = generateAlumnusModel != null ? generateAlumnusModel.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox ? 64L : 32L;
                }
                str4 = zSafeUnbox ? "#0BD3FF" : "#FFFFFF";
            } else {
                zSafeUnbox = false;
            }
            j2 = j & 24;
            if (j2 != 0 || aVar == null) {
                aVarA = null;
            } else {
                a aVar2 = this.f9997a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f9997a = aVar2;
                }
                aVarA = aVar2.a(aVar);
            }
            if ((16 & j) != 0) {
                CommonBindingAdapter.b0(((LoginActivityGenerateAlumnusBinding) this).f9991a, str3, requestOptions, false);
                TextViewBindingAdapter.setText(((LoginActivityGenerateAlumnusBinding) this).f9988a, str);
                TextViewBindingAdapter.setText(((LoginActivityGenerateAlumnusBinding) this).f9993b, str2);
                TextViewBindingAdapter.setText(((LoginActivityGenerateAlumnusBinding) this).f9994c, schoolName);
                TextViewBindingAdapter.setText(this.d, name);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.e0(this.e, zSafeUnbox);
                CommonBindingAdapter.W(this.e, str4);
            }
            if ((j & 21) != 0) {
                TextViewBindingAdapter.setText(this.e, value);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.e, aVarA, null);
            }
        }
        zSafeUnbox = false;
        value = null;
        str4 = null;
        j2 = j & 24;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((16 & j) != 0) {
            CommonBindingAdapter.b0(((LoginActivityGenerateAlumnusBinding) this).f9991a, str3, requestOptions, false);
            TextViewBindingAdapter.setText(((LoginActivityGenerateAlumnusBinding) this).f9988a, str);
            TextViewBindingAdapter.setText(((LoginActivityGenerateAlumnusBinding) this).f9993b, str2);
            TextViewBindingAdapter.setText(((LoginActivityGenerateAlumnusBinding) this).f9994c, schoolName);
            TextViewBindingAdapter.setText(this.d, name);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.e0(this.e, zSafeUnbox);
            CommonBindingAdapter.W(this.e, str4);
        }
        if ((j & 21) != 0) {
            TextViewBindingAdapter.setText(this.e, value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.e, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9996a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9996a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityGenerateAlumnusBinding
    public void l(@Nullable GenerateAlumnusActivity.a aVar) {
        ((LoginActivityGenerateAlumnusBinding) this).f9989a = aVar;
        synchronized (this) {
            this.f9996a |= 8;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityGenerateAlumnusBinding
    public void m(@Nullable GenerateAlumnusModel generateAlumnusModel) {
        ((LoginActivityGenerateAlumnusBinding) this).f9990a = generateAlumnusModel;
        synchronized (this) {
            this.f9996a |= 4;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9996a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9996a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((GenerateAlumnusModel) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((GenerateAlumnusActivity.a) obj);
        }
        return true;
    }

    public LoginActivityGenerateAlumnusBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[8], (ImageView) objArr[7], (BLImageView) objArr[1], (LinearLayout) objArr[11], (LinearLayout) objArr[9], (LinearLayout) objArr[10], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[4]);
        this.f9996a = -1L;
        ((LoginActivityGenerateAlumnusBinding) this).f9991a.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[0];
        this.f9998a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.e = textView;
        textView.setTag(null);
        ((LoginActivityGenerateAlumnusBinding) this).f9988a.setTag(null);
        ((LoginActivityGenerateAlumnusBinding) this).f9993b.setTag(null);
        ((LoginActivityGenerateAlumnusBinding) this).f9994c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
