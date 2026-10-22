package com.huachenjie.run.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.common.utils.FileUtils;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.progress.GradientRoundProgress;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.g89;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutPauseHeaderBindingImpl extends RunLayoutPauseHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12121a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12122a;

    @NonNull
    public final ConstraintLayout b;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35683a = sparseIntArray;
        sparseIntArray.put(R.id.vHandle, 13);
        sparseIntArray.put(R.id.tvDistanceLabel, 14);
        sparseIntArray.put(R.id.vMoreTargetBg, 15);
        sparseIntArray.put(R.id.ivMoreTarget, 16);
        sparseIntArray.put(R.id.tvMoreTargetLabel, 17);
        sparseIntArray.put(R.id.clMetrics, 18);
        sparseIntArray.put(R.id.tvMinKmLabel, 19);
        sparseIntArray.put(R.id.tvDurationLabel, 20);
        sparseIntArray.put(R.id.tvPaceLabel, 21);
        sparseIntArray.put(R.id.llConditions, 22);
        sparseIntArray.put(R.id.tvCondTitle, 23);
    }

    public RunLayoutPauseHeaderBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 24, f12121a, f35683a));
    }

    public final boolean A(MutableLiveData<Boolean> VmSpeedConditionVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 1024;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x0243  */
    /* JADX WARN: Code duplicated, block: B:162:0x0277 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:163:0x0279  */
    /* JADX WARN: Code duplicated, block: B:164:0x0280  */
    /* JADX WARN: Code duplicated, block: B:167:0x028a  */
    /* JADX WARN: Code duplicated, block: B:168:0x0291  */
    /* JADX WARN: Code duplicated, block: B:172:0x029f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:173:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:174:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:177:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:178:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:31:0x009c  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        String str;
        boolean zSafeUnbox;
        String str2;
        String value3;
        boolean z;
        boolean zSafeUnbox2;
        boolean z2;
        boolean zSafeUnbox3;
        boolean z3;
        int iSafeUnbox;
        boolean zSafeUnbox4;
        boolean zSafeUnbox5;
        String value4;
        Drawable drawable;
        Drawable drawable2;
        int i;
        Drawable drawable3;
        Drawable drawable4;
        int i2;
        int i3;
        Drawable drawable5;
        int i4;
        Drawable drawable6;
        int i5;
        Drawable drawable7;
        Context context;
        int i6;
        Context context2;
        int i7;
        boolean zSafeUnbox6;
        String value5;
        boolean zSafeUnbox7;
        boolean zSafeUnbox8;
        String value6;
        MutableLiveData<String> mutableLiveDataN;
        MutableLiveData<String> mutableLiveDataA;
        synchronized (this) {
            j = this.f12122a;
            this.f12122a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunLayoutPauseHeaderBinding) this).f12115a;
        if ((262143 & j) != 0) {
            long j2 = j & 196617;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataE = sunshineRunVM != null ? sunshineRunVM.E() : null;
                updateLiveDataRegistration(0, mutableLiveDataE);
                zSafeUnbox6 = ViewDataBinding.safeUnbox(mutableLiveDataE != null ? mutableLiveDataE.getValue() : null);
                if (j2 != 0) {
                    j = zSafeUnbox6 ? j | 549755813888L | 8796093022208L : j | 274877906944L | 4398046511104L;
                }
            } else {
                zSafeUnbox6 = false;
            }
            if ((j & 196610) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataU = sunshineRunVM != null ? sunshineRunVM.u() : null;
                updateLiveDataRegistration(1, mutableLiveDataU);
                if (mutableLiveDataU != null) {
                    value5 = mutableLiveDataU.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 196612) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataT = sunshineRunVM != null ? sunshineRunVM.t() : null;
                updateLiveDataRegistration(2, mutableLiveDataT);
                if (mutableLiveDataT != null) {
                    value3 = mutableLiveDataT.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 196624) != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = sunshineRunVM != null ? sunshineRunVM.K() : null;
                updateLiveDataRegistration(4, mutableLiveDataK);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 196640) != 0) {
                MutableLiveData<Boolean> mutableLiveDataF = sunshineRunVM != null ? sunshineRunVM.F() : null;
                updateLiveDataRegistration(5, mutableLiveDataF);
                zSafeUnbox7 = ViewDataBinding.safeUnbox(mutableLiveDataF != null ? mutableLiveDataF.getValue() : null);
            } else {
                zSafeUnbox7 = false;
            }
            long j3 = j & 196680;
            if (j3 != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = sunshineRunVM != null ? sunshineRunVM.v() : null;
                updateLiveDataRegistration(6, mutableLiveDataV);
                zSafeUnbox8 = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
                if (j3 != 0) {
                    j = zSafeUnbox8 ? j | 536870912 | 2199023255552L : j | 268435456 | FileUtils.ONE_TB;
                }
            } else {
                zSafeUnbox8 = false;
            }
            if ((j & 196736) != 0) {
                MutableLiveData<Boolean> mutableLiveDataW = sunshineRunVM != null ? sunshineRunVM.w() : null;
                updateLiveDataRegistration(7, mutableLiveDataW);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(mutableLiveDataW != null ? mutableLiveDataW.getValue() : null);
            } else {
                zSafeUnbox3 = false;
            }
            if ((j & 196864) != 0) {
                MutableLiveData<Integer> mutableLiveDataG = sunshineRunVM != null ? sunshineRunVM.G() : null;
                updateLiveDataRegistration(8, mutableLiveDataG);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataG != null ? mutableLiveDataG.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j4 = j & 197128;
            if (j4 != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = sunshineRunVM != null ? sunshineRunVM.O() : null;
                updateLiveDataRegistration(9, mutableLiveDataO);
                zSafeUnbox4 = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                if (j4 != 0) {
                    j = zSafeUnbox4 ? j | 34359738368L | 137438953472L : j | 17179869184L | 68719476736L;
                }
            } else {
                zSafeUnbox4 = false;
            }
            if ((j & 197632) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = sunshineRunVM != null ? sunshineRunVM.P() : null;
                updateLiveDataRegistration(10, mutableLiveDataP);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            long j5 = j & 198664;
            if (j5 != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = sunshineRunVM != null ? sunshineRunVM.m() : null;
                updateLiveDataRegistration(11, mutableLiveDataM);
                zSafeUnbox5 = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
                if (j5 != 0) {
                    j = zSafeUnbox5 ? j | 8388608 | 2147483648L : j | PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED | FileUtils.ONE_GB;
                }
            } else {
                zSafeUnbox4 = zSafeUnbox4;
                zSafeUnbox5 = false;
            }
            if ((j & 200704) == 0) {
                value6 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO2 = sunshineRunVM != null ? sunshineRunVM.o() : null;
                updateLiveDataRegistration(12, mutableLiveDataO2);
                if (mutableLiveDataO2 != null) {
                    value6 = mutableLiveDataO2.getValue();
                } else {
                    value6 = null;
                }
            }
            if ((j & 204800) != 0) {
                LiveData<String> liveDataH = sunshineRunVM != null ? sunshineRunVM.H() : null;
                updateLiveDataRegistration(13, liveDataH);
                value4 = liveDataH != null ? liveDataH.getValue() : null;
                if ((j & 212992) != 0) {
                    if (sunshineRunVM != null) {
                        mutableLiveDataA = sunshineRunVM.A();
                    } else {
                        mutableLiveDataA = null;
                    }
                    updateLiveDataRegistration(14, mutableLiveDataA);
                    value2 = mutableLiveDataA != null ? mutableLiveDataA.getValue() : null;
                    if ((j & 229376) != 0) {
                        if (sunshineRunVM != null) {
                            mutableLiveDataN = sunshineRunVM.n();
                        } else {
                            mutableLiveDataN = null;
                        }
                        updateLiveDataRegistration(15, mutableLiveDataN);
                        if (mutableLiveDataN != null) {
                            value = mutableLiveDataN.getValue();
                            j = j;
                        }
                        boolean z4 = zSafeUnbox6;
                        str2 = value5;
                        str = value6;
                        z3 = zSafeUnbox8;
                        z2 = zSafeUnbox7;
                        z = z4;
                    } else {
                        j = j;
                    }
                    j = j;
                    value = null;
                    boolean z5 = zSafeUnbox6;
                    str2 = value5;
                    str = value6;
                    z3 = zSafeUnbox8;
                    z2 = zSafeUnbox7;
                    z = z5;
                } else {
                    value4 = value4;
                }
                if ((j & 229376) != 0) {
                    if (sunshineRunVM != null) {
                        mutableLiveDataN = sunshineRunVM.n();
                    } else {
                        mutableLiveDataN = null;
                    }
                    updateLiveDataRegistration(15, mutableLiveDataN);
                    if (mutableLiveDataN != null) {
                        value = mutableLiveDataN.getValue();
                        j = j;
                    }
                    boolean z6 = zSafeUnbox6;
                    str2 = value5;
                    str = value6;
                    z3 = zSafeUnbox8;
                    z2 = zSafeUnbox7;
                    z = z6;
                } else {
                    j = j;
                }
                j = j;
                value = null;
                boolean z7 = zSafeUnbox6;
                str2 = value5;
                str = value6;
                z3 = zSafeUnbox8;
                z2 = zSafeUnbox7;
                z = z7;
            } else {
                zSafeUnbox5 = zSafeUnbox5;
            }
            if ((j & 212992) != 0) {
                if (sunshineRunVM != null) {
                    mutableLiveDataA = sunshineRunVM.A();
                } else {
                    mutableLiveDataA = null;
                }
                updateLiveDataRegistration(14, mutableLiveDataA);
                if (mutableLiveDataA != null) {
                }
                if ((j & 229376) != 0) {
                    if (sunshineRunVM != null) {
                        mutableLiveDataN = sunshineRunVM.n();
                    } else {
                        mutableLiveDataN = null;
                    }
                    updateLiveDataRegistration(15, mutableLiveDataN);
                    if (mutableLiveDataN != null) {
                        value = mutableLiveDataN.getValue();
                        j = j;
                    }
                    boolean z8 = zSafeUnbox6;
                    str2 = value5;
                    str = value6;
                    z3 = zSafeUnbox8;
                    z2 = zSafeUnbox7;
                    z = z8;
                } else {
                    j = j;
                }
                j = j;
                value = null;
                boolean z9 = zSafeUnbox6;
                str2 = value5;
                str = value6;
                z3 = zSafeUnbox8;
                z2 = zSafeUnbox7;
                z = z9;
            } else {
                value4 = value4;
            }
            if ((j & 229376) != 0) {
                if (sunshineRunVM != null) {
                    mutableLiveDataN = sunshineRunVM.n();
                } else {
                    mutableLiveDataN = null;
                }
                updateLiveDataRegistration(15, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value = mutableLiveDataN.getValue();
                    j = j;
                }
                boolean z10 = zSafeUnbox6;
                str2 = value5;
                str = value6;
                z3 = zSafeUnbox8;
                z2 = zSafeUnbox7;
                z = z10;
            } else {
                j = j;
            }
            j = j;
            value = null;
            boolean z11 = zSafeUnbox6;
            str2 = value5;
            str = value6;
            z3 = zSafeUnbox8;
            z2 = zSafeUnbox7;
            z = z11;
        } else {
            value = null;
            value2 = null;
            str = null;
            zSafeUnbox = false;
            str2 = null;
            value3 = null;
            z = false;
            zSafeUnbox2 = false;
            z2 = false;
            zSafeUnbox3 = false;
            z3 = false;
            iSafeUnbox = 0;
            zSafeUnbox4 = false;
            zSafeUnbox5 = false;
            value4 = null;
        }
        if ((j & 5859681763328L) != 0) {
            MutableLiveData<Boolean> mutableLiveDataP2 = sunshineRunVM != null ? sunshineRunVM.p() : null;
            updateLiveDataRegistration(3, mutableLiveDataP2);
            boolean zSafeUnbox9 = ViewDataBinding.safeUnbox(mutableLiveDataP2 != null ? mutableLiveDataP2.getValue() : null);
            if ((j & 4398046511104L) != 0) {
                j |= zSafeUnbox9 ? PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 262144L;
            }
            if ((j & FileUtils.ONE_TB) != 0) {
                j |= zSafeUnbox9 ? 2097152L : 1048576L;
            }
            if ((j & FileUtils.ONE_GB) != 0) {
                j |= zSafeUnbox9 ? 33554432L : 16777216L;
            }
            if ((j & 292330405888L) != 0) {
                j |= zSafeUnbox9 ? 134217728L : 67108864L;
            }
            if ((j & 68719476736L) != 0) {
                j |= zSafeUnbox9 ? g89.f : 4294967296L;
            }
            if ((j & 4398046511104L) != 0) {
                if (zSafeUnbox9) {
                    context2 = this.n.getContext();
                    i7 = R.drawable.run_ic_run_pause_cond_fail;
                } else {
                    context2 = this.n.getContext();
                    i7 = R.drawable.run_ic_run_pause_cond_todo;
                }
                drawable4 = AppCompatResources.getDrawable(context2, i7);
            } else {
                str2 = str2;
                drawable4 = null;
            }
            if ((j & FileUtils.ONE_TB) != 0) {
                drawable3 = zSafeUnbox9 ? AppCompatResources.getDrawable(this.o.getContext(), R.drawable.run_ic_run_pause_cond_fail) : AppCompatResources.getDrawable(this.o.getContext(), R.drawable.run_ic_run_pause_cond_todo);
            } else {
                drawable3 = null;
            }
            if ((j & FileUtils.ONE_GB) != 0) {
                drawable2 = zSafeUnbox9 ? AppCompatResources.getDrawable(((RunLayoutPauseHeaderBinding) this).f12112a.getContext(), R.drawable.run_ic_run_pause_cond_fail) : AppCompatResources.getDrawable(((RunLayoutPauseHeaderBinding) this).f12112a.getContext(), R.drawable.run_ic_run_pause_cond_todo);
            } else {
                drawable2 = null;
            }
            if ((j & 292330405888L) != 0) {
                i = zSafeUnbox9 ? RunIndexRecordAdapter.L : RunIndexRecordAdapter.K;
            } else {
                i = 0;
            }
            if ((j & 68719476736L) != 0) {
                if (zSafeUnbox9) {
                    context = ((RunLayoutPauseHeaderBinding) this).b.getContext();
                    i6 = R.drawable.run_ic_run_pause_cond_fail;
                } else {
                    context = ((RunLayoutPauseHeaderBinding) this).b.getContext();
                    i6 = R.drawable.run_ic_run_pause_cond_todo;
                }
                drawable = AppCompatResources.getDrawable(context, i6);
                j = j;
            } else {
                drawable = null;
            }
        } else {
            value2 = value2;
            str2 = str2;
            drawable = null;
            drawable2 = null;
            i = 0;
            drawable3 = null;
            drawable4 = null;
        }
        long j6 = j & 198664;
        if (j6 != 0) {
            int i8 = zSafeUnbox5 ? -16730402 : i;
            if (zSafeUnbox5) {
                drawable2 = AppCompatResources.getDrawable(((RunLayoutPauseHeaderBinding) this).f12112a.getContext(), R.drawable.run_ic_run_pause_cond_done);
            }
            i2 = i8;
        } else {
            drawable = drawable;
            i2 = 0;
            drawable2 = null;
        }
        long j7 = j & 196680;
        if (j7 != 0) {
            int i9 = z3 ? -16730402 : i;
            if (z3) {
                drawable3 = AppCompatResources.getDrawable(this.o.getContext(), R.drawable.run_ic_run_pause_cond_done);
            }
            i3 = i9;
            drawable5 = drawable3;
        } else {
            i = i;
            i3 = 0;
            drawable5 = null;
        }
        long j8 = j & 197128;
        if (j8 != 0) {
            int i10 = zSafeUnbox4 ? -16730402 : i;
            if (zSafeUnbox4) {
                drawable = AppCompatResources.getDrawable(((RunLayoutPauseHeaderBinding) this).b.getContext(), R.drawable.run_ic_run_pause_cond_done);
            }
            i4 = i10;
            drawable6 = drawable;
        } else {
            str = str;
            value3 = value3;
            i4 = 0;
            drawable6 = null;
        }
        long j9 = j & 196617;
        if (j9 != 0) {
            if (z) {
                i = -16730402;
            }
            drawable7 = z ? AppCompatResources.getDrawable(this.n.getContext(), R.drawable.run_ic_run_pause_cond_done) : drawable4;
            i5 = i;
        } else {
            value = value;
            i5 = 0;
            drawable7 = null;
        }
        if ((j & 196624) != 0) {
            CommonBindingAdapter.l0(((RunLayoutPauseHeaderBinding) this).f12113a, zSafeUnbox2);
        }
        if (j9 != 0) {
            TextViewBindingAdapter.setDrawableStart(this.n, drawable7);
            this.n.setTextColor(i5);
        }
        if ((j & 196640) != 0) {
            CommonBindingAdapter.l0(this.n, z2);
        }
        if (j7 != 0) {
            TextViewBindingAdapter.setDrawableStart(this.o, drawable5);
            this.o.setTextColor(i3);
        }
        if ((196736 & j) != 0) {
            CommonBindingAdapter.l0(this.o, zSafeUnbox3);
        }
        if ((196864 & j) != 0) {
            ((RunLayoutPauseHeaderBinding) this).f12114a.setProgress(iSafeUnbox);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setDrawableStart(((RunLayoutPauseHeaderBinding) this).f12112a, drawable2);
            ((RunLayoutPauseHeaderBinding) this).f12112a.setTextColor(i2);
        }
        if (j8 != 0) {
            TextViewBindingAdapter.setDrawableStart(((RunLayoutPauseHeaderBinding) this).b, drawable6);
            ((RunLayoutPauseHeaderBinding) this).b.setTextColor(i4);
        }
        if ((197632 & j) != 0) {
            CommonBindingAdapter.l0(((RunLayoutPauseHeaderBinding) this).b, zSafeUnbox);
        }
        if ((229376 & j) != 0) {
            TextViewBindingAdapter.setText(this.d, value);
        }
        if ((200704 & j) != 0) {
            TextViewBindingAdapter.setText(this.g, str);
        }
        if ((j & 196612) != 0) {
            TextViewBindingAdapter.setText(this.i, value3);
        }
        if ((j & 196610) != 0) {
            TextViewBindingAdapter.setText(this.j, str2);
        }
        if ((212992 & j) != 0) {
            TextViewBindingAdapter.setText(this.m, value2);
        }
        if ((j & 204800) != 0) {
            TextViewBindingAdapter.setText(((RunLayoutPauseHeaderBinding) this).f12117a, value4);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12122a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12122a = 131072L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutPauseHeaderBinding
    public void k(@Nullable SunshineRunVM Vm) {
        ((RunLayoutPauseHeaderBinding) this).f12115a = Vm;
        synchronized (this) {
            this.f12122a |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Boolean> VmDisConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 2048;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> VmDistanceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> VmDurationText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 4096;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> VmFailStyle, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return u((MutableLiveData) object, fieldId);
            case 1:
                return q((MutableLiveData) object, fieldId);
            case 2:
                return p((MutableLiveData) object, fieldId);
            case 3:
                return o((MutableLiveData) object, fieldId);
            case 4:
                return y((MutableLiveData) object, fieldId);
            case 5:
                return v((MutableLiveData) object, fieldId);
            case 6:
                return r((MutableLiveData) object, fieldId);
            case 7:
                return s((MutableLiveData) object, fieldId);
            case 8:
                return w((MutableLiveData) object, fieldId);
            case 9:
                return z((MutableLiveData) object, fieldId);
            case 10:
                return A((MutableLiveData) object, fieldId);
            case 11:
                return l((MutableLiveData) object, fieldId);
            case 12:
                return n((MutableLiveData) object, fieldId);
            case 13:
                return x((LiveData) object, fieldId);
            case 14:
                return t((MutableLiveData) object, fieldId);
            case 15:
                return m((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> VmMinKmText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> VmMoreTargetKmText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> VmNfcConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 64;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Boolean> VmNfcConditionVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 128;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRunVM) variable);
        return true;
    }

    public final boolean t(MutableLiveData<String> VmPaceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Boolean> VmPointConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 1;
        }
        return true;
    }

    public final boolean v(MutableLiveData<Boolean> VmPointConditionVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 32;
        }
        return true;
    }

    public final boolean w(MutableLiveData<Integer> VmProgressPercent, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 256;
        }
        return true;
    }

    public final boolean x(LiveData<String> VmProgressText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 8192;
        }
        return true;
    }

    public final boolean y(MutableLiveData<Boolean> VmShowMoreTarget, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 16;
        }
        return true;
    }

    public final boolean z(MutableLiveData<Boolean> VmSpeedConditionDone, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12122a |= 512;
        }
        return true;
    }

    public RunLayoutPauseHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 16, (BLConstraintLayout) bindings[18], (ImageView) bindings[16], (BLConstraintLayout) bindings[22], (ConstraintLayout) bindings[2], (GradientRoundProgress) bindings[4], (TextView) bindings[9], (TextView) bindings[11], (TextView) bindings[23], (TextView) bindings[1], (TextView) bindings[14], (TextView) bindings[20], (TextView) bindings[7], (TextView) bindings[19], (TextView) bindings[6], (TextView) bindings[3], (TextView) bindings[17], (TextView) bindings[21], (TextView) bindings[8], (BLTextView) bindings[5], (BLView) bindings[13], (BLView) bindings[15]);
        this.f12122a = -1L;
        ((RunLayoutPauseHeaderBinding) this).f12113a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.n = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[12];
        this.o = textView2;
        textView2.setTag(null);
        ((RunLayoutPauseHeaderBinding) this).f12114a.setTag(null);
        ((RunLayoutPauseHeaderBinding) this).f12112a.setTag(null);
        ((RunLayoutPauseHeaderBinding) this).b.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.m.setTag(null);
        ((RunLayoutPauseHeaderBinding) this).f12117a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
