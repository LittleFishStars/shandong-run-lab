package com.huachenjie.college.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
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
import com.google.android.material.timepicker.TimeModel;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.HuaweiHealthTodayDataBean;
import com.huachenjie.college.page.hw_health.HWHealthActivity;
import com.huachenjie.college.page.hw_health.HWHealthVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.c49;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeViewHwHealthHeaderBindingImpl extends CollegeViewHwHealthHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8449a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8453a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HWHealthActivity.a f33593a;

        public a a(HWHealthActivity.a aVar) {
            this.f33593a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33593a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33592a = sparseIntArray;
        sparseIntArray.put(R.id.iv_today_step, 7);
        sparseIntArray.put(R.id.iv_today_distance, 8);
        sparseIntArray.put(R.id.iv_today_kll, 9);
        sparseIntArray.put(R.id.rl_heart_rate, 10);
        sparseIntArray.put(R.id.iv_heart_rate, 11);
        sparseIntArray.put(R.id.rl_sleep, 12);
        sparseIntArray.put(R.id.iv_sleep, 13);
    }

    public CollegeViewHwHealthHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f8449a, f33592a));
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00b1  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        HuaweiHealthTodayDataBean value;
        a aVarA;
        boolean z2;
        int heartRateBpm;
        boolean z3;
        int steps;
        boolean z4;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (this) {
            j = this.f8450a;
            this.f8450a = 0L;
        }
        HWHealthVM hWHealthVM = ((CollegeViewHwHealthHeaderBinding) this).f8446a;
        HWHealthActivity.a aVar = ((CollegeViewHwHealthHeaderBinding) this).f8445a;
        long j2 = j & 11;
        if (j2 != 0) {
            MutableLiveData<HuaweiHealthTodayDataBean> mutableLiveDataN = hWHealthVM != null ? hWHealthVM.n() : null;
            updateLiveDataRegistration(0, mutableLiveDataN);
            value = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
            z = value == null;
            if (j2 != 0) {
                j = z ? j | 32 | 2048 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | 131072 | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : j | 16 | 1024 | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH | 262144;
            }
        } else {
            z = false;
            value = null;
        }
        if ((j & 12) == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f8453a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8453a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        String activeCalories = ((j & 262144) == 0 || value == null) ? null : value.getActiveCalories();
        String distanceKm = ((j & PlaybackStateCompat.ACTION_PREPARE) == 0 || value == null) ? null : value.getDistanceKm();
        if ((16 & j) == 0) {
            z2 = false;
        } else {
            if ((value != null ? value.getSleepMinutes() : 0) == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if ((PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH & j) != 0) {
            heartRateBpm = value != null ? value.getHeartRateBpm() : 0;
            z3 = heartRateBpm == -1;
        } else {
            heartRateBpm = 0;
            z3 = false;
        }
        if ((1024 & j) != 0) {
            steps = value != null ? value.getSteps() : 0;
            z4 = steps == -1;
        } else {
            steps = 0;
            z4 = false;
        }
        long j3 = j & 11;
        if (j3 != 0) {
            if (z) {
                z2 = true;
            }
            if (z) {
                z4 = true;
            }
            if (z) {
                distanceKm = c49.f40900a;
            }
            if (z) {
                z3 = true;
            }
            if (z) {
                activeCalories = c49.f40900a;
            }
            if (j3 != 0) {
                j = z2 ? j | 8192 : j | 4096;
            }
            if ((j & 11) != 0) {
                j = z4 ? j | 512 : j | 256;
            }
            if ((j & 11) != 0) {
                j = z3 ? j | 128 : j | 64;
            }
            str = distanceKm;
        } else {
            z4 = false;
            z3 = false;
            z2 = false;
            activeCalories = null;
            str = null;
        }
        String sleepMinutesStr = ((j & 4096) == 0 || value == null) ? null : value.getSleepMinutesStr();
        if ((j & 64) != 0) {
            if (value != null) {
                heartRateBpm = value.getHeartRateBpm();
            }
            str2 = String.format("%dbpm", Integer.valueOf(heartRateBpm));
        } else {
            str2 = null;
        }
        if ((j & 256) != 0) {
            if (value != null) {
                steps = value.getSteps();
            }
            str3 = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(steps));
        } else {
            str3 = null;
        }
        long j4 = 11 & j;
        if (j4 != 0) {
            if (z3) {
                str2 = c49.f40900a;
            }
            if (z4) {
                str3 = c49.f40900a;
            }
            if (z2) {
                sleepMinutesStr = c49.f40900a;
            }
            str4 = sleepMinutesStr;
        } else {
            str3 = null;
            str2 = null;
            str4 = null;
        }
        if (j4 != 0) {
            TextViewBindingAdapter.setText(this.f8451a, str3);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.c, activeCalories);
            TextViewBindingAdapter.setText(this.d, str2);
            TextViewBindingAdapter.setText(this.e, str4);
        }
        if ((j & 12) != 0) {
            CommonBindingAdapter.q(this.f, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8450a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8450a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeViewHwHealthHeaderBinding
    public void l(@Nullable HWHealthActivity.a aVar) {
        ((CollegeViewHwHealthHeaderBinding) this).f8445a = aVar;
        synchronized (this) {
            this.f8450a |= 4;
        }
        notifyPropertyChanged(uk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeViewHwHealthHeaderBinding
    public void m(@Nullable HWHealthVM hWHealthVM) {
        ((CollegeViewHwHealthHeaderBinding) this).f8446a = hWHealthVM;
        synchronized (this) {
            this.f8450a |= 2;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<HuaweiHealthTodayDataBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8450a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 == i) {
            m((HWHealthVM) obj);
        } else {
            if (uk0.k != i) {
                return false;
            }
            l((HWHealthActivity.a) obj);
        }
        return true;
    }

    public CollegeViewHwHealthHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[11], (ImageView) objArr[13], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[7], (BLRelativeLayout) objArr[10], (BLRelativeLayout) objArr[12]);
        this.f8450a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f8452a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f8451a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.c = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.d = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.e = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[6];
        this.f = textView6;
        textView6.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
