package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestResultBean;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultAddScoreAdapter;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreAdapter;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class LayoutSportTestResultDetailBindingImpl extends LayoutSportTestResultDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13680a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f13682a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36544a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title_all, 7);
        sparseIntArray.put(R.id.dash1, 8);
        sparseIntArray.put(R.id.tv_score, 9);
        sparseIntArray.put(R.id.dash2, 10);
        sparseIntArray.put(R.id.tv_add_score, 11);
        sparseIntArray.put(R.id.dash3, 12);
    }

    public LayoutSportTestResultDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, f13680a, f36544a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f2  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        double dSafeUnbox;
        SportTestResultScoreAdapter value;
        MutableLiveData<SportTestResultBean> mutableLiveDataJ;
        SportTestResultAddScoreAdapter value2;
        SportTestResultBean value3;
        Integer totalLevel;
        boolean z;
        boolean z2;
        int iSafeUnbox;
        boolean z3;
        boolean z4;
        boolean z5;
        int colorFromResource;
        String str;
        boolean z6;
        long j2;
        boolean z7;
        Double totalScore;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f13681a;
            this.f13681a = 0L;
        }
        SportTestResultScoreVM sportTestResultScoreVM = ((LayoutSportTestResultDetailBinding) this).f13676a;
        String str2 = null;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<SportTestResultScoreAdapter> mutableLiveDataM = sportTestResultScoreVM != null ? sportTestResultScoreVM.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value = mutableLiveDataM.getValue();
                } else {
                    value = null;
                }
            }
            long j5 = j & 42;
            if (j5 != 0) {
                mutableLiveDataJ = sportTestResultScoreVM != null ? sportTestResultScoreVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                value3 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                if (value3 != null) {
                    totalLevel = value3.getTotalLevel();
                    totalScore = value3.getTotalScore();
                } else {
                    totalLevel = null;
                    totalScore = null;
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(totalLevel);
                dSafeUnbox = ViewDataBinding.safeUnbox(totalScore);
                z3 = totalScore == null;
                z7 = totalScore != null;
                if (j5 != 0) {
                    j = z7 ? j | 8192 : j | 4096;
                }
                z = iSafeUnbox == 1;
                z4 = dSafeUnbox == AudioStats.AUDIO_AMPLITUDE_NONE;
                if ((j & 42) != 0) {
                    if (z) {
                        j3 = j | 512;
                        j4 = 131072;
                    } else {
                        j3 = j | 256;
                        j4 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    }
                    j = j3 | j4;
                }
                if ((j & 42) != 0) {
                    j = z4 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : j | PlaybackStateCompat.ACTION_PREPARE;
                }
                j2 = 44;
            } else {
                dSafeUnbox = 0.0d;
                mutableLiveDataJ = null;
                value3 = null;
                totalLevel = null;
                z = false;
                iSafeUnbox = 0;
                z3 = false;
                j2 = 44;
                z7 = false;
                z4 = false;
            }
            if ((j & j2) == 0) {
                value2 = null;
            } else {
                MutableLiveData<SportTestResultAddScoreAdapter> mutableLiveDataH = sportTestResultScoreVM != null ? sportTestResultScoreVM.h() : null;
                updateLiveDataRegistration(2, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value2 = mutableLiveDataH.getValue();
                } else {
                    value2 = null;
                }
            }
            z2 = z7;
        } else {
            dSafeUnbox = 0.0d;
            value = null;
            mutableLiveDataJ = null;
            value2 = null;
            value3 = null;
            totalLevel = null;
            z = false;
            z2 = false;
            iSafeUnbox = 0;
            z3 = false;
            z4 = false;
        }
        String strValueOf = (PlaybackStateCompat.ACTION_PREPARE & j) != 0 ? String.valueOf(dSafeUnbox) : null;
        if ((j & 65792) != 0) {
            if (sportTestResultScoreVM != null) {
                mutableLiveDataJ = sportTestResultScoreVM.j();
            }
            updateLiveDataRegistration(1, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value3 = mutableLiveDataJ.getValue();
            }
            if (value3 != null) {
                totalLevel = value3.getTotalLevel();
            }
            iSafeUnbox = ViewDataBinding.safeUnbox(totalLevel);
            z5 = iSafeUnbox == 2;
            if ((j & 256) != 0) {
                j = z5 ? j | 128 : j | 64;
            }
        } else {
            z5 = false;
        }
        boolean z8 = ((j & 8192) == 0 || dSafeUnbox == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
        long j6 = j & 42;
        if (j6 != 0) {
            if (!z2) {
                z8 = false;
            }
            if (z4) {
                strValueOf = "0";
            }
            boolean z9 = z ? true : z5;
            if (j6 != 0) {
                j |= z9 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 262144L;
            }
            colorFromResource = z9 ? ViewDataBinding.getColorFromResource(this.d, R.color.color_999999) : ViewDataBinding.getColorFromResource(this.d, R.color.color_main_v2);
        } else {
            strValueOf = null;
            colorFromResource = 0;
            z8 = false;
        }
        long j7 = j & 64;
        if (j7 != 0) {
            boolean z10 = iSafeUnbox == 3;
            if (j7 != 0) {
                j |= z10 ? 2048L : 1024L;
            }
            str = z10 ? "良好" : "优秀";
        } else {
            str = null;
        }
        if ((j & 256) == 0) {
            str = null;
        } else if (z5) {
            str = "及格";
        }
        long j8 = j & 42;
        if (j8 != 0) {
            if (z) {
                str = "不及格";
            }
            str2 = str;
        }
        String str3 = str2;
        if ((41 & j) != 0) {
            z6 = false;
            CommonBindingAdapter.g(((LayoutSportTestResultDetailBinding) this).f13674a, value, false, false);
        } else {
            z6 = false;
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.g(((LayoutSportTestResultDetailBinding) this).f13678b, value2, z6, z6);
        }
        if (j8 != 0) {
            CommonBindingAdapter.l0(((LayoutSportTestResultDetailBinding) this).f13677b, z2);
            TextViewBindingAdapter.setText(((LayoutSportTestResultDetailBinding) this).f13677b, strValueOf);
            CommonBindingAdapter.l0(((LayoutSportTestResultDetailBinding) this).f13679c, z2);
            CommonBindingAdapter.l0(this.d, z8);
            TextViewBindingAdapter.setText(this.d, str3);
            this.d.setTextColor(colorFromResource);
            CommonBindingAdapter.l0(this.g, z3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13681a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13681a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.LayoutSportTestResultDetailBinding
    public void l(@Nullable SportTestResultScoreActivity.a aVar) {
        ((LayoutSportTestResultDetailBinding) this).f13675a = aVar;
    }

    @Override // com.huachenjie.sport.databinding.LayoutSportTestResultDetailBinding
    public void m(@Nullable SportTestResultScoreVM sportTestResultScoreVM) {
        ((LayoutSportTestResultDetailBinding) this).f13676a = sportTestResultScoreVM;
        synchronized (this) {
            this.f13681a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SportTestResultAddScoreAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13681a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<SportTestResultBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13681a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<SportTestResultScoreAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13681a |= 1;
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

    public LayoutSportTestResultDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (View) objArr[8], (View) objArr[10], (View) objArr[12], (RecyclerView) objArr[5], (RecyclerView) objArr[6], (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[1]);
        this.f13681a = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.f13682a = nestedScrollView;
        nestedScrollView.setTag(null);
        ((LayoutSportTestResultDetailBinding) this).f13674a.setTag(null);
        ((LayoutSportTestResultDetailBinding) this).f13678b.setTag(null);
        ((LayoutSportTestResultDetailBinding) this).f13677b.setTag(null);
        ((LayoutSportTestResultDetailBinding) this).f13679c.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
