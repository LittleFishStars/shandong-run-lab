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
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestResultBean;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class LayoutSportTestResultSimpleBindingImpl extends LayoutSportTestResultSimpleBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13685a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f13687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13688a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36546a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title_all_simple, 4);
        sparseIntArray.put(R.id.dash_simple, 5);
        sparseIntArray.put(R.id.tv_total_label_simple, 6);
    }

    public LayoutSportTestResultSimpleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13685a, f36546a));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x013b  */
    /* JADX WARN: Code duplicated, block: B:104:0x013e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0141  */
    /* JADX WARN: Code duplicated, block: B:107:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x0147  */
    /* JADX WARN: Code duplicated, block: B:109:0x014a  */
    /* JADX WARN: Code duplicated, block: B:112:0x014f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0152  */
    /* JADX WARN: Code duplicated, block: B:114:0x0155  */
    /* JADX WARN: Code duplicated, block: B:117:0x015f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x0161  */
    /* JADX WARN: Code duplicated, block: B:119:0x0164  */
    /* JADX WARN: Code duplicated, block: B:122:0x016b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x016d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0170  */
    /* JADX WARN: Code duplicated, block: B:127:0x0179 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x017b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0180  */
    /* JADX WARN: Code duplicated, block: B:131:0x0184  */
    /* JADX WARN: Code duplicated, block: B:132:0x0187  */
    /* JADX WARN: Code duplicated, block: B:134:0x018b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0190  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0120  */
    /* JADX WARN: Code duplicated, block: B:94:0x0125  */
    /* JADX WARN: Code duplicated, block: B:98:0x012e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0133  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        MutableLiveData<SportTestResultBean> mutableLiveDataJ;
        SportTestResultBean value;
        Integer totalLevel;
        Double totalScore;
        boolean z;
        int iSafeUnbox;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        String strValueOf;
        long j2;
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        boolean z8;
        long j4;
        synchronized (this) {
            j = this.f13686a;
            this.f13686a = 0L;
        }
        SportTestResultScoreVM sportTestResultScoreVM = ((LayoutSportTestResultSimpleBinding) this).f13684a;
        long j5 = j & 7;
        if (j5 != 0) {
            mutableLiveDataJ = sportTestResultScoreVM != null ? sportTestResultScoreVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            value = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
            if (value != null) {
                totalLevel = value.getTotalLevel();
                totalScore = value.getTotalScore();
            } else {
                totalLevel = null;
                totalScore = null;
            }
            iSafeUnbox = ViewDataBinding.safeUnbox(totalLevel);
            boolean z9 = totalScore == null;
            boolean z10 = totalScore != null;
            if (j5 != 0) {
                j = z9 ? j | 16 : j | 8;
            }
            if ((j & 7) != 0) {
                j = z10 ? j | 4096 : j | 2048;
            }
            z = iSafeUnbox == 1;
            if ((j & 7) != 0) {
                j = z ? j | 256 : j | 128;
            }
            z2 = z9;
            z3 = z10;
        } else {
            mutableLiveDataJ = null;
            value = null;
            totalLevel = null;
            totalScore = null;
            z = false;
            iSafeUnbox = 0;
            z2 = false;
            z3 = false;
        }
        long j6 = j & 4232;
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (j6 != 0) {
            if (sportTestResultScoreVM != null) {
                mutableLiveDataJ = sportTestResultScoreVM.j();
            }
            updateLiveDataRegistration(0, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            }
            long j7 = j & 128;
            if (j7 != 0) {
                if (value != null) {
                    totalLevel = value.getTotalLevel();
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(totalLevel);
                z4 = iSafeUnbox == 2;
                if (j7 != 0) {
                    j = z4 ? j | 64 : j | 32;
                }
            } else {
                z4 = false;
            }
            if ((j & 4104) != 0) {
                if (value != null) {
                    totalScore = value.getTotalScore();
                }
                double dSafeUnbox = ViewDataBinding.safeUnbox(totalScore);
                z5 = ((4096 & j) == 0 || dSafeUnbox == AudioStats.AUDIO_AMPLITUDE_NONE) ? false : true;
                long j8 = j & 8;
                if (j8 != 0) {
                    z6 = dSafeUnbox == AudioStats.AUDIO_AMPLITUDE_NONE;
                    if (j8 != 0) {
                        j = z6 ? j | PlaybackStateCompat.ACTION_PREPARE : j | 8192;
                    }
                    d = dSafeUnbox;
                } else {
                    d = dSafeUnbox;
                }
                if ((j & 7) != 0) {
                    z7 = z3;
                    if (!z7) {
                    }
                    if ((j & 8192) != 0) {
                        strValueOf = String.valueOf(d);
                    } else {
                        strValueOf = null;
                    }
                    j2 = j & 32;
                    if (j2 != 0) {
                        if (iSafeUnbox == 3) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (j2 != 0) {
                            if (z8) {
                                j4 = 1024;
                            } else {
                                j4 = 512;
                            }
                            j |= j4;
                        }
                        if (z8) {
                            str = "良好";
                        } else {
                            str = "优秀";
                        }
                    } else {
                        str = null;
                    }
                    if ((j & 128) != 0) {
                        str = null;
                    } else if (z4) {
                        str = "及格";
                    }
                    if ((8 & j) != 0) {
                        strValueOf = null;
                    } else if (z6) {
                        strValueOf = "0";
                    }
                    j3 = j & 7;
                    if (j3 != 0) {
                        if (z2) {
                            str4 = "";
                        } else {
                            str4 = strValueOf;
                        }
                        if (z) {
                            str2 = "不及格";
                        } else {
                            str2 = str;
                        }
                        str3 = str4;
                    } else {
                        str2 = null;
                        str3 = null;
                    }
                    if (j3 != 0) {
                        CommonBindingAdapter.l0(this.f13688a, z5);
                        TextViewBindingAdapter.setText(this.f13688a, str2);
                        CommonBindingAdapter.l0(((LayoutSportTestResultSimpleBinding) this).f13683a, z2);
                        CommonBindingAdapter.l0(this.d, z7);
                        TextViewBindingAdapter.setText(this.d, str3);
                    }
                }
                z7 = z3;
                z5 = false;
                if ((j & 8192) != 0) {
                    strValueOf = String.valueOf(d);
                } else {
                    strValueOf = null;
                }
                j2 = j & 32;
                if (j2 != 0) {
                    if (iSafeUnbox == 3) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (j2 != 0) {
                        if (z8) {
                            j4 = 1024;
                        } else {
                            j4 = 512;
                        }
                        j |= j4;
                    }
                    if (z8) {
                        str = "良好";
                    } else {
                        str = "优秀";
                    }
                } else {
                    str = null;
                }
                if ((j & 128) != 0) {
                    str = null;
                } else if (z4) {
                    str = "及格";
                }
                if ((8 & j) != 0) {
                    strValueOf = null;
                } else if (z6) {
                    strValueOf = "0";
                }
                j3 = j & 7;
                if (j3 != 0) {
                    if (z2) {
                        str4 = "";
                    } else {
                        str4 = strValueOf;
                    }
                    if (z) {
                        str2 = "不及格";
                    } else {
                        str2 = str;
                    }
                    str3 = str4;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (j3 != 0) {
                    CommonBindingAdapter.l0(this.f13688a, z5);
                    TextViewBindingAdapter.setText(this.f13688a, str2);
                    CommonBindingAdapter.l0(((LayoutSportTestResultSimpleBinding) this).f13683a, z2);
                    CommonBindingAdapter.l0(this.d, z7);
                    TextViewBindingAdapter.setText(this.d, str3);
                }
            }
            z6 = false;
            if ((j & 7) != 0) {
                z7 = z3;
                if (!z7) {
                }
                if ((j & 8192) != 0) {
                    strValueOf = String.valueOf(d);
                } else {
                    strValueOf = null;
                }
                j2 = j & 32;
                if (j2 != 0) {
                    if (iSafeUnbox == 3) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (j2 != 0) {
                        if (z8) {
                            j4 = 1024;
                        } else {
                            j4 = 512;
                        }
                        j |= j4;
                    }
                    if (z8) {
                        str = "良好";
                    } else {
                        str = "优秀";
                    }
                } else {
                    str = null;
                }
                if ((j & 128) != 0) {
                    str = null;
                } else if (z4) {
                    str = "及格";
                }
                if ((8 & j) != 0) {
                    strValueOf = null;
                } else if (z6) {
                    strValueOf = "0";
                }
                j3 = j & 7;
                if (j3 != 0) {
                    if (z2) {
                        str4 = "";
                    } else {
                        str4 = strValueOf;
                    }
                    if (z) {
                        str2 = "不及格";
                    } else {
                        str2 = str;
                    }
                    str3 = str4;
                } else {
                    str2 = null;
                    str3 = null;
                }
                if (j3 != 0) {
                    CommonBindingAdapter.l0(this.f13688a, z5);
                    TextViewBindingAdapter.setText(this.f13688a, str2);
                    CommonBindingAdapter.l0(((LayoutSportTestResultSimpleBinding) this).f13683a, z2);
                    CommonBindingAdapter.l0(this.d, z7);
                    TextViewBindingAdapter.setText(this.d, str3);
                }
            }
            z7 = z3;
            z5 = false;
            if ((j & 8192) != 0) {
                strValueOf = String.valueOf(d);
            } else {
                strValueOf = null;
            }
            j2 = j & 32;
            if (j2 != 0) {
                if (iSafeUnbox == 3) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (j2 != 0) {
                    if (z8) {
                        j4 = 1024;
                    } else {
                        j4 = 512;
                    }
                    j |= j4;
                }
                if (z8) {
                    str = "良好";
                } else {
                    str = "优秀";
                }
            } else {
                str = null;
            }
            if ((j & 128) != 0) {
                str = null;
            } else if (z4) {
                str = "及格";
            }
            if ((8 & j) != 0) {
                strValueOf = null;
            } else if (z6) {
                strValueOf = "0";
            }
            j3 = j & 7;
            if (j3 != 0) {
                if (z2) {
                    str4 = "";
                } else {
                    str4 = strValueOf;
                }
                if (z) {
                    str2 = "不及格";
                } else {
                    str2 = str;
                }
                str3 = str4;
            } else {
                str2 = null;
                str3 = null;
            }
            if (j3 != 0) {
                CommonBindingAdapter.l0(this.f13688a, z5);
                TextViewBindingAdapter.setText(this.f13688a, str2);
                CommonBindingAdapter.l0(((LayoutSportTestResultSimpleBinding) this).f13683a, z2);
                CommonBindingAdapter.l0(this.d, z7);
                TextViewBindingAdapter.setText(this.d, str3);
            }
        }
        z4 = false;
        z5 = false;
        z6 = false;
        if ((j & 7) != 0) {
            z7 = z3;
            if (!z7) {
            }
            if ((j & 8192) != 0) {
                strValueOf = String.valueOf(d);
            } else {
                strValueOf = null;
            }
            j2 = j & 32;
            if (j2 != 0) {
                if (iSafeUnbox == 3) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (j2 != 0) {
                    if (z8) {
                        j4 = 1024;
                    } else {
                        j4 = 512;
                    }
                    j |= j4;
                }
                if (z8) {
                    str = "良好";
                } else {
                    str = "优秀";
                }
            } else {
                str = null;
            }
            if ((j & 128) != 0) {
                str = null;
            } else if (z4) {
                str = "及格";
            }
            if ((8 & j) != 0) {
                strValueOf = null;
            } else if (z6) {
                strValueOf = "0";
            }
            j3 = j & 7;
            if (j3 != 0) {
                if (z2) {
                    str4 = "";
                } else {
                    str4 = strValueOf;
                }
                if (z) {
                    str2 = "不及格";
                } else {
                    str2 = str;
                }
                str3 = str4;
            } else {
                str2 = null;
                str3 = null;
            }
            if (j3 != 0) {
                CommonBindingAdapter.l0(this.f13688a, z5);
                TextViewBindingAdapter.setText(this.f13688a, str2);
                CommonBindingAdapter.l0(((LayoutSportTestResultSimpleBinding) this).f13683a, z2);
                CommonBindingAdapter.l0(this.d, z7);
                TextViewBindingAdapter.setText(this.d, str3);
            }
        }
        z7 = z3;
        z5 = false;
        if ((j & 8192) != 0) {
            strValueOf = String.valueOf(d);
        } else {
            strValueOf = null;
        }
        j2 = j & 32;
        if (j2 != 0) {
            if (iSafeUnbox == 3) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (j2 != 0) {
                if (z8) {
                    j4 = 1024;
                } else {
                    j4 = 512;
                }
                j |= j4;
            }
            if (z8) {
                str = "良好";
            } else {
                str = "优秀";
            }
        } else {
            str = null;
        }
        if ((j & 128) != 0) {
            str = null;
        } else if (z4) {
            str = "及格";
        }
        if ((8 & j) != 0) {
            strValueOf = null;
        } else if (z6) {
            strValueOf = "0";
        }
        j3 = j & 7;
        if (j3 != 0) {
            if (z2) {
                str4 = "";
            } else {
                str4 = strValueOf;
            }
            if (z) {
                str2 = "不及格";
            } else {
                str2 = str;
            }
            str3 = str4;
        } else {
            str2 = null;
            str3 = null;
        }
        if (j3 != 0) {
            CommonBindingAdapter.l0(this.f13688a, z5);
            TextViewBindingAdapter.setText(this.f13688a, str2);
            CommonBindingAdapter.l0(((LayoutSportTestResultSimpleBinding) this).f13683a, z2);
            CommonBindingAdapter.l0(this.d, z7);
            TextViewBindingAdapter.setText(this.d, str3);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13686a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13686a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.LayoutSportTestResultSimpleBinding
    public void k(@Nullable SportTestResultScoreVM sportTestResultScoreVM) {
        ((LayoutSportTestResultSimpleBinding) this).f13684a = sportTestResultScoreVM;
        synchronized (this) {
            this.f13686a |= 2;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<SportTestResultBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13686a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((SportTestResultScoreVM) obj);
        return true;
    }

    public LayoutSportTestResultSimpleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (View) objArr[5], (TextView) objArr[1], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[2]);
        this.f13686a = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.f13687a = nestedScrollView;
        nestedScrollView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f13688a = bLTextView;
        bLTextView.setTag(null);
        ((LayoutSportTestResultSimpleBinding) this).f13683a.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
