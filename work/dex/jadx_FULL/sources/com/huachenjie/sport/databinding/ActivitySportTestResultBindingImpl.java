package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestResultBean;
import com.huachenjie.sport.bean.TestResultYearBean;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivitySportTestResultBindingImpl extends ActivitySportTestResultBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13368a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f13370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13375a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13376b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestResultScoreActivity.a f36438a;

        public a a(SportTestResultScoreActivity.a aVar) {
            this.f36438a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36438a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SportTestResultScoreActivity.a f36439a;

        public b a(SportTestResultScoreActivity.a aVar) {
            this.f36439a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36439a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36437a = sparseIntArray;
        sparseIntArray.put(R.id.vs_content, 6);
    }

    public ActivitySportTestResultBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13368a, f36437a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        int colorFromResource;
        int iSafeUnbox2;
        boolean z;
        TestResultYearBean value;
        boolean z2;
        a aVarA;
        b bVarA;
        String str;
        String str2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.f13369a;
            this.f13369a = 0L;
        }
        SportTestResultScoreVM sportTestResultScoreVM = ((ActivitySportTestResultBinding) this).f13367a;
        SportTestResultScoreActivity.a aVar = ((ActivitySportTestResultBinding) this).f13366a;
        if ((47 & j) != 0) {
            long j4 = j & 41;
            if (j4 != 0) {
                MutableLiveData<TestResultYearBean> mutableLiveDataK = sportTestResultScoreVM != null ? sportTestResultScoreVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                z2 = value == null;
                if (j4 != 0) {
                    j = z2 ? j | 8192 : j | 4096;
                }
            } else {
                z2 = false;
                value = null;
            }
            long j5 = j & 42;
            if (j5 != 0) {
                MutableLiveData<SportTestResultBean> mutableLiveDataJ = sportTestResultScoreVM != null ? sportTestResultScoreVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                SportTestResultBean value2 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                iSafeUnbox2 = ViewDataBinding.safeUnbox(value2 != null ? value2.getTestStatus() : null);
                z = iSafeUnbox2 == 2;
                if (j5 != 0) {
                    if (z) {
                        j2 = j | 128;
                        j3 = 2048;
                    } else {
                        j2 = j | 64;
                        j3 = 1024;
                    }
                    j = j2 | j3;
                }
                colorFromResource = ViewDataBinding.getColorFromResource(this.f13376b, z ? R.color.color_main_v2 : R.color.color_FF762F);
            } else {
                colorFromResource = 0;
                iSafeUnbox2 = 0;
                z = false;
            }
            if ((j & 44) != 0) {
                MutableLiveData<Integer> mutableLiveData = sportTestResultScoreVM != null ? sportTestResultScoreVM.b : null;
                updateLiveDataRegistration(2, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
        } else {
            iSafeUnbox = 0;
            colorFromResource = 0;
            iSafeUnbox2 = 0;
            z = false;
            value = null;
            z2 = false;
        }
        if ((j & 48) == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f13375a;
            if (bVar == null) {
                bVar = new b();
                this.f13375a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f13374a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13374a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        long j6 = j & 64;
        if (j6 != 0) {
            boolean z3 = iSafeUnbox2 == 1;
            if (j6 != 0) {
                j |= z3 ? 512L : 256L;
            }
            str = z3 ? "免测" : "";
        } else {
            str = null;
        }
        if ((4096 & j) != 0) {
            str2 = String.format("%s-体测", value != null ? value.getYearName() : null);
        } else {
            str2 = null;
        }
        long j7 = 42 & j;
        if (j7 == 0) {
            str = null;
        } else if (z) {
            str = "正常测试";
        }
        long j8 = j & 41;
        if (j8 == 0) {
            str2 = null;
        } else if (z2) {
            str2 = "";
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.G(this.f13370a, iSafeUnbox);
        }
        if ((j & 48) != 0) {
            CommonBindingAdapter.q(this.f13371a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if (j8 != 0) {
            TextViewBindingAdapter.setText(this.f13372a, str2);
        }
        if (j7 != 0) {
            TextViewBindingAdapter.setText(this.f13376b, str);
            this.f13376b.setTextColor(colorFromResource);
        }
        if (((ActivitySportTestResultBinding) this).f36436a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((ActivitySportTestResultBinding) this).f36436a.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13369a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13369a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestResultBinding
    public void l(@Nullable SportTestResultScoreActivity.a aVar) {
        ((ActivitySportTestResultBinding) this).f13366a = aVar;
        synchronized (this) {
            this.f13369a |= 16;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivitySportTestResultBinding
    public void m(@Nullable SportTestResultScoreVM sportTestResultScoreVM) {
        ((ActivitySportTestResultBinding) this).f13367a = sportTestResultScoreVM;
        synchronized (this) {
            this.f13369a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SportTestResultBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13369a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<TestResultYearBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13369a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13369a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((SportTestResultScoreVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((SportTestResultScoreActivity.a) obj);
        }
        return true;
    }

    public ActivitySportTestResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, new ViewStubProxy((ViewStub) objArr[6]));
        this.f13369a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13373a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        View view2 = (View) objArr[1];
        this.f13370a = view2;
        view2.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f13371a = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[3];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13372a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.f13376b = textView2;
        textView2.setTag(null);
        ((ActivitySportTestResultBinding) this).f36436a.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }
}
