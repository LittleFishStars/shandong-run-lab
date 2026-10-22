package com.huachenjie.run.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import com.google.android.flexbox.FlexboxLayoutManager;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.rule.RuleV3Activity;
import com.huachenjie.run.page.rule.RuleV3VM;
import com.huachenjie.run.page.rule.RunTimePeriodAdapter;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;
import com.zj.adlib.s72;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivitySchoolRuleV3BindingImpl extends RunActivitySchoolRuleV3Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11565a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11573a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11574b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11575b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f11576b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11577c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final LinearLayout g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f11578g;

    @NonNull
    public final LinearLayout h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NonNull
    public final TextView f11579h;

    @NonNull
    public final LinearLayout i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @NonNull
    public final TextView f11580i;

    @NonNull
    public final LinearLayout j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    @NonNull
    public final TextView f11581j;

    @NonNull
    public final LinearLayout k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    @NonNull
    public final TextView f11582k;

    @NonNull
    public final LinearLayout l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    @NonNull
    public final TextView f11583l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RuleV3Activity.a f35496a;

        public a a(RuleV3Activity.a value) {
            this.f35496a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) throws UnsupportedEncodingException {
            this.f35496a.c(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RuleV3Activity.a f35497a;

        public b a(RuleV3Activity.a value) {
            this.f35497a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35497a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RuleV3Activity.a f35498a;

        public c a(RuleV3Activity.a value) {
            this.f35498a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35498a.b(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35495a = sparseIntArray;
        sparseIntArray.put(R.id.tvSchoolRuleHeaderTitle, 30);
        sparseIntArray.put(R.id.tvSchoolRuleHeaderTip, 31);
        sparseIntArray.put(R.id.tvDisAndTimesLabel, 32);
        sparseIntArray.put(R.id.tvDisAndTimes, 33);
        sparseIntArray.put(R.id.tvDisMin, 34);
        sparseIntArray.put(R.id.tvDayMaxDistance, 35);
        sparseIntArray.put(R.id.tvWeekMaxDistance, 36);
    }

    public RunActivitySchoolRuleV3BindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 37, f11565a, f35495a));
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0262 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0264  */
    /* JADX WARN: Code duplicated, block: B:106:0x026b  */
    /* JADX WARN: Code duplicated, block: B:109:0x0274  */
    /* JADX WARN: Code duplicated, block: B:110:0x027b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0288 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x028a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0291  */
    /* JADX WARN: Code duplicated, block: B:119:0x029a  */
    /* JADX WARN: Code duplicated, block: B:120:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:124:0x02ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:126:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:129:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:130:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:134:0x02d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:136:0x02db  */
    /* JADX WARN: Code duplicated, block: B:139:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:140:0x031a  */
    /* JADX WARN: Code duplicated, block: B:164:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:16:0x003f  */
    /* JADX WARN: Code duplicated, block: B:173:0x03fe  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        boolean z4;
        boolean z5;
        String str3;
        boolean z6;
        boolean z7;
        SchoolRule value;
        boolean z8;
        RunTimePeriodAdapter value2;
        boolean z9;
        FlexboxLayoutManager value3;
        boolean z10;
        RunTimePeriodAdapter value4;
        FlexboxLayoutManager flexboxLayoutManager;
        int iSafeUnbox;
        RunTimePeriodAdapter value5;
        FlexboxLayoutManager value6;
        boolean z11;
        String str4;
        String str5;
        String str6;
        boolean z12;
        String str7;
        boolean z13;
        String str8;
        String str9;
        b bVarA;
        c cVar;
        a aVar;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        String str10;
        String str11;
        FlexboxLayoutManager value7;
        MutableLiveData<FlexboxLayoutManager> mutableLiveDataI;
        MutableLiveData<RunTimePeriodAdapter> mutableLiveDataM;
        MutableLiveData<FlexboxLayoutManager> mutableLiveDataJ;
        MutableLiveData<RunTimePeriodAdapter> mutableLiveDataO;
        long maxPace;
        long j2;
        long minPace;
        int i;
        int i2;
        int iTimeTypeEveryDaySize;
        int weekMaxDistance;
        int disKM;
        int iTimeTypeWorkdaySize;
        int iTimeTypeWeekendSize;
        int i3;
        int i4;
        float fMinLimitSpeedMs;
        float fMaxLimitSpeedMs;
        float fMinLimitSpeedMs2;
        String endDate;
        String startDate;
        synchronized (this) {
            j = this.f11566a;
            this.f11566a = 0L;
        }
        RuleV3VM ruleV3VM = ((RunActivitySchoolRuleV3Binding) this).f11563a;
        RuleV3Activity.a aVar2 = ((RunActivitySchoolRuleV3Binding) this).f11562a;
        if ((1535 & j) != 0) {
            if ((j & 1281) == 0) {
                value3 = null;
            } else {
                MutableLiveData<FlexboxLayoutManager> mutableLiveDataH = ruleV3VM != null ? ruleV3VM.h() : null;
                updateLiveDataRegistration(0, mutableLiveDataH);
                if (mutableLiveDataH != null) {
                    value3 = mutableLiveDataH.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 1282) != 0) {
                MutableLiveData<Integer> mutableLiveData = ruleV3VM != null ? ((BaseVM) ruleV3VM).f33644a : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null) + 8));
            } else {
                iSafeUnbox = 0;
            }
            long j3 = j & 1284;
            if (j3 != 0) {
                MutableLiveData<SchoolRule> mutableLiveDataL = ruleV3VM != null ? ruleV3VM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value != null) {
                    iTimeTypeEveryDaySize = value.timeTypeEveryDaySize();
                    maxPace = value.getMaxPace();
                    fMinLimitSpeedMs = value.minLimitSpeedMs();
                    weekMaxDistance = value.getWeekMaxDistance();
                    disKM = value.getDisKM();
                    fMaxLimitSpeedMs = value.maxLimitSpeedMs();
                    fMinLimitSpeedMs2 = value.minLimitSpeedMs();
                    int weekMaxTimes = value.getWeekMaxTimes();
                    long suspendTime = value.getSuspendTime();
                    int dayMaxDistance = value.getDayMaxDistance();
                    iTimeTypeWorkdaySize = value.timeTypeWorkdaySize();
                    minPace = value.getMinPace();
                    int dayMaxTimes = value.getDayMaxTimes();
                    iTimeTypeWeekendSize = value.timeTypeWeekendSize();
                    endDate = value.getEndDate();
                    int weekMinTimes = value.getWeekMinTimes();
                    str6 = value.fileName;
                    str7 = value.remark;
                    startDate = value.getStartDate();
                    i = weekMaxTimes;
                    i2 = dayMaxDistance;
                    i3 = dayMaxTimes;
                    i4 = weekMinTimes;
                    j2 = suspendTime;
                } else {
                    maxPace = 0;
                    j2 = 0;
                    minPace = 0;
                    i = 0;
                    i2 = 0;
                    iTimeTypeEveryDaySize = 0;
                    weekMaxDistance = 0;
                    disKM = 0;
                    iTimeTypeWorkdaySize = 0;
                    iTimeTypeWeekendSize = 0;
                    i3 = 0;
                    i4 = 0;
                    fMinLimitSpeedMs = 0.0f;
                    fMaxLimitSpeedMs = 0.0f;
                    fMinLimitSpeedMs2 = 0.0f;
                    str6 = null;
                    str7 = null;
                    endDate = null;
                    startDate = null;
                }
                z11 = iTimeTypeEveryDaySize > 0;
                String strE = s72.e(maxPace);
                z6 = weekMaxDistance > 0;
                z10 = disKM != 0;
                String str12 = String.format("(每秒配速 %.0fm~%.0fm)", Float.valueOf(fMinLimitSpeedMs), Float.valueOf(fMaxLimitSpeedMs));
                z9 = fMinLimitSpeedMs2 == 0.0f;
                String str13 = i + "次";
                boolean z18 = i > 0;
                long j4 = j2 / 1000;
                z3 = j2 > 0;
                boolean z19 = i2 > 0;
                z4 = iTimeTypeWorkdaySize > 0;
                String strE2 = s72.e(minPace);
                z7 = z18;
                int i5 = i3;
                z = z19;
                z8 = i5 > 0;
                str11 = i5 + "次";
                boolean z20 = iTimeTypeWeekendSize > 0;
                StringBuilder sb = new StringBuilder();
                z2 = z20;
                int i6 = i4;
                sb.append(i6);
                str9 = str12;
                sb.append("次");
                String string = sb.toString();
                boolean z21 = i6 > 0;
                boolean zIsEmpty = TextUtils.isEmpty(str6);
                boolean zIsEmpty2 = TextUtils.isEmpty(str7);
                z5 = z21;
                str = str13;
                String str14 = String.format("%1s-%2s", startDate, endDate);
                if (j3 != 0) {
                    j = z10 ? j | PlaybackStateCompat.ACTION_PREPARE : j | 8192;
                }
                if ((j & 1284) != 0) {
                    j = z9 ? j | 4096 : j | 2048;
                }
                String strE3 = s72.e(j4);
                str4 = String.format("%1s-%2s", strE, strE2);
                z13 = !zIsEmpty2;
                z12 = !zIsEmpty;
                str3 = strE3;
                str10 = str14;
                str8 = string;
            } else {
                str8 = null;
                str10 = null;
                str3 = null;
                z9 = false;
                str4 = null;
                z12 = false;
                value = null;
                z3 = false;
                str6 = null;
                str7 = null;
                z11 = false;
                z13 = false;
                z6 = false;
                z10 = false;
                z4 = false;
                z7 = false;
                z8 = false;
                z = false;
                str11 = null;
                z2 = false;
                str9 = null;
                z5 = false;
                str = null;
            }
            if ((j & 1288) != 0) {
                MutableLiveData<RunTimePeriodAdapter> mutableLiveDataN = ruleV3VM != null ? ruleV3VM.n() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                value4 = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
                if ((j & 1296) != 0) {
                    if (ruleV3VM != null) {
                        mutableLiveDataO = ruleV3VM.o();
                    } else {
                        mutableLiveDataO = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataO);
                    value5 = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                    if ((j & 1312) != 0) {
                        if (ruleV3VM != null) {
                            mutableLiveDataJ = ruleV3VM.j();
                        } else {
                            mutableLiveDataJ = null;
                        }
                        updateLiveDataRegistration(5, mutableLiveDataJ);
                        value7 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                        if ((j & 1344) != 0) {
                            if (ruleV3VM != null) {
                                mutableLiveDataM = ruleV3VM.m();
                            } else {
                                mutableLiveDataM = null;
                            }
                            updateLiveDataRegistration(6, mutableLiveDataM);
                            value2 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                            if ((j & 1408) == 0) {
                                value6 = null;
                            } else {
                                if (ruleV3VM != null) {
                                    mutableLiveDataI = ruleV3VM.i();
                                } else {
                                    mutableLiveDataI = null;
                                }
                                updateLiveDataRegistration(7, mutableLiveDataI);
                                if (mutableLiveDataI != null) {
                                    value6 = mutableLiveDataI.getValue();
                                } else {
                                    value6 = null;
                                }
                            }
                            str2 = str11;
                            flexboxLayoutManager = value7;
                            str5 = str10;
                        } else {
                            value7 = value7;
                        }
                        if ((j & 1408) == 0) {
                            value6 = null;
                        } else {
                            if (ruleV3VM != null) {
                                mutableLiveDataI = ruleV3VM.i();
                            } else {
                                mutableLiveDataI = null;
                            }
                            updateLiveDataRegistration(7, mutableLiveDataI);
                            if (mutableLiveDataI != null) {
                                value6 = mutableLiveDataI.getValue();
                            } else {
                                value6 = null;
                            }
                        }
                        str2 = str11;
                        flexboxLayoutManager = value7;
                        str5 = str10;
                    } else {
                        value5 = value5;
                    }
                    if ((j & 1344) != 0) {
                        if (ruleV3VM != null) {
                            mutableLiveDataM = ruleV3VM.m();
                        } else {
                            mutableLiveDataM = null;
                        }
                        updateLiveDataRegistration(6, mutableLiveDataM);
                        if (mutableLiveDataM != null) {
                        }
                        if ((j & 1408) == 0) {
                            value6 = null;
                        } else {
                            if (ruleV3VM != null) {
                                mutableLiveDataI = ruleV3VM.i();
                            } else {
                                mutableLiveDataI = null;
                            }
                            updateLiveDataRegistration(7, mutableLiveDataI);
                            if (mutableLiveDataI != null) {
                                value6 = mutableLiveDataI.getValue();
                            } else {
                                value6 = null;
                            }
                        }
                        str2 = str11;
                        flexboxLayoutManager = value7;
                        str5 = str10;
                    } else {
                        value7 = value7;
                    }
                    if ((j & 1408) == 0) {
                        value6 = null;
                    } else {
                        if (ruleV3VM != null) {
                            mutableLiveDataI = ruleV3VM.i();
                        } else {
                            mutableLiveDataI = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveDataI);
                        if (mutableLiveDataI != null) {
                            value6 = mutableLiveDataI.getValue();
                        } else {
                            value6 = null;
                        }
                    }
                    str2 = str11;
                    flexboxLayoutManager = value7;
                    str5 = str10;
                } else {
                    value4 = value4;
                }
                if ((j & 1312) != 0) {
                    if (ruleV3VM != null) {
                        mutableLiveDataJ = ruleV3VM.j();
                    } else {
                        mutableLiveDataJ = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveDataJ);
                    if (mutableLiveDataJ != null) {
                    }
                    if ((j & 1344) != 0) {
                        if (ruleV3VM != null) {
                            mutableLiveDataM = ruleV3VM.m();
                        } else {
                            mutableLiveDataM = null;
                        }
                        updateLiveDataRegistration(6, mutableLiveDataM);
                        if (mutableLiveDataM != null) {
                        }
                        if ((j & 1408) == 0) {
                            value6 = null;
                        } else {
                            if (ruleV3VM != null) {
                                mutableLiveDataI = ruleV3VM.i();
                            } else {
                                mutableLiveDataI = null;
                            }
                            updateLiveDataRegistration(7, mutableLiveDataI);
                            if (mutableLiveDataI != null) {
                                value6 = mutableLiveDataI.getValue();
                            } else {
                                value6 = null;
                            }
                        }
                        str2 = str11;
                        flexboxLayoutManager = value7;
                        str5 = str10;
                    } else {
                        value7 = value7;
                    }
                    if ((j & 1408) == 0) {
                        value6 = null;
                    } else {
                        if (ruleV3VM != null) {
                            mutableLiveDataI = ruleV3VM.i();
                        } else {
                            mutableLiveDataI = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveDataI);
                        if (mutableLiveDataI != null) {
                            value6 = mutableLiveDataI.getValue();
                        } else {
                            value6 = null;
                        }
                    }
                    str2 = str11;
                    flexboxLayoutManager = value7;
                    str5 = str10;
                } else {
                    value5 = value5;
                }
                if ((j & 1344) != 0) {
                    if (ruleV3VM != null) {
                        mutableLiveDataM = ruleV3VM.m();
                    } else {
                        mutableLiveDataM = null;
                    }
                    updateLiveDataRegistration(6, mutableLiveDataM);
                    if (mutableLiveDataM != null) {
                    }
                    if ((j & 1408) == 0) {
                        value6 = null;
                    } else {
                        if (ruleV3VM != null) {
                            mutableLiveDataI = ruleV3VM.i();
                        } else {
                            mutableLiveDataI = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveDataI);
                        if (mutableLiveDataI != null) {
                            value6 = mutableLiveDataI.getValue();
                        } else {
                            value6 = null;
                        }
                    }
                    str2 = str11;
                    flexboxLayoutManager = value7;
                    str5 = str10;
                } else {
                    value7 = value7;
                }
                if ((j & 1408) == 0) {
                    value6 = null;
                } else {
                    if (ruleV3VM != null) {
                        mutableLiveDataI = ruleV3VM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value6 = mutableLiveDataI.getValue();
                    } else {
                        value6 = null;
                    }
                }
                str2 = str11;
                flexboxLayoutManager = value7;
                str5 = str10;
            } else {
                str8 = str8;
                str10 = str10;
            }
            if ((j & 1296) != 0) {
                if (ruleV3VM != null) {
                    mutableLiveDataO = ruleV3VM.o();
                } else {
                    mutableLiveDataO = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                }
                if ((j & 1312) != 0) {
                    if (ruleV3VM != null) {
                        mutableLiveDataJ = ruleV3VM.j();
                    } else {
                        mutableLiveDataJ = null;
                    }
                    updateLiveDataRegistration(5, mutableLiveDataJ);
                    if (mutableLiveDataJ != null) {
                    }
                    if ((j & 1344) != 0) {
                        if (ruleV3VM != null) {
                            mutableLiveDataM = ruleV3VM.m();
                        } else {
                            mutableLiveDataM = null;
                        }
                        updateLiveDataRegistration(6, mutableLiveDataM);
                        if (mutableLiveDataM != null) {
                        }
                        if ((j & 1408) == 0) {
                            value6 = null;
                        } else {
                            if (ruleV3VM != null) {
                                mutableLiveDataI = ruleV3VM.i();
                            } else {
                                mutableLiveDataI = null;
                            }
                            updateLiveDataRegistration(7, mutableLiveDataI);
                            if (mutableLiveDataI != null) {
                                value6 = mutableLiveDataI.getValue();
                            } else {
                                value6 = null;
                            }
                        }
                        str2 = str11;
                        flexboxLayoutManager = value7;
                        str5 = str10;
                    } else {
                        value7 = value7;
                    }
                    if ((j & 1408) == 0) {
                        value6 = null;
                    } else {
                        if (ruleV3VM != null) {
                            mutableLiveDataI = ruleV3VM.i();
                        } else {
                            mutableLiveDataI = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveDataI);
                        if (mutableLiveDataI != null) {
                            value6 = mutableLiveDataI.getValue();
                        } else {
                            value6 = null;
                        }
                    }
                    str2 = str11;
                    flexboxLayoutManager = value7;
                    str5 = str10;
                } else {
                    value5 = value5;
                }
                if ((j & 1344) != 0) {
                    if (ruleV3VM != null) {
                        mutableLiveDataM = ruleV3VM.m();
                    } else {
                        mutableLiveDataM = null;
                    }
                    updateLiveDataRegistration(6, mutableLiveDataM);
                    if (mutableLiveDataM != null) {
                    }
                    if ((j & 1408) == 0) {
                        value6 = null;
                    } else {
                        if (ruleV3VM != null) {
                            mutableLiveDataI = ruleV3VM.i();
                        } else {
                            mutableLiveDataI = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveDataI);
                        if (mutableLiveDataI != null) {
                            value6 = mutableLiveDataI.getValue();
                        } else {
                            value6 = null;
                        }
                    }
                    str2 = str11;
                    flexboxLayoutManager = value7;
                    str5 = str10;
                } else {
                    value7 = value7;
                }
                if ((j & 1408) == 0) {
                    value6 = null;
                } else {
                    if (ruleV3VM != null) {
                        mutableLiveDataI = ruleV3VM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value6 = mutableLiveDataI.getValue();
                    } else {
                        value6 = null;
                    }
                }
                str2 = str11;
                flexboxLayoutManager = value7;
                str5 = str10;
            } else {
                value4 = value4;
            }
            if ((j & 1312) != 0) {
                if (ruleV3VM != null) {
                    mutableLiveDataJ = ruleV3VM.j();
                } else {
                    mutableLiveDataJ = null;
                }
                updateLiveDataRegistration(5, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                }
                if ((j & 1344) != 0) {
                    if (ruleV3VM != null) {
                        mutableLiveDataM = ruleV3VM.m();
                    } else {
                        mutableLiveDataM = null;
                    }
                    updateLiveDataRegistration(6, mutableLiveDataM);
                    if (mutableLiveDataM != null) {
                    }
                    if ((j & 1408) == 0) {
                        value6 = null;
                    } else {
                        if (ruleV3VM != null) {
                            mutableLiveDataI = ruleV3VM.i();
                        } else {
                            mutableLiveDataI = null;
                        }
                        updateLiveDataRegistration(7, mutableLiveDataI);
                        if (mutableLiveDataI != null) {
                            value6 = mutableLiveDataI.getValue();
                        } else {
                            value6 = null;
                        }
                    }
                    str2 = str11;
                    flexboxLayoutManager = value7;
                    str5 = str10;
                } else {
                    value7 = value7;
                }
                if ((j & 1408) == 0) {
                    value6 = null;
                } else {
                    if (ruleV3VM != null) {
                        mutableLiveDataI = ruleV3VM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value6 = mutableLiveDataI.getValue();
                    } else {
                        value6 = null;
                    }
                }
                str2 = str11;
                flexboxLayoutManager = value7;
                str5 = str10;
            } else {
                value5 = value5;
            }
            if ((j & 1344) != 0) {
                if (ruleV3VM != null) {
                    mutableLiveDataM = ruleV3VM.m();
                } else {
                    mutableLiveDataM = null;
                }
                updateLiveDataRegistration(6, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                }
                if ((j & 1408) == 0) {
                    value6 = null;
                } else {
                    if (ruleV3VM != null) {
                        mutableLiveDataI = ruleV3VM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value6 = mutableLiveDataI.getValue();
                    } else {
                        value6 = null;
                    }
                }
                str2 = str11;
                flexboxLayoutManager = value7;
                str5 = str10;
            } else {
                value7 = value7;
            }
            if ((j & 1408) == 0) {
                value6 = null;
            } else {
                if (ruleV3VM != null) {
                    mutableLiveDataI = ruleV3VM.i();
                } else {
                    mutableLiveDataI = null;
                }
                updateLiveDataRegistration(7, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value6 = mutableLiveDataI.getValue();
                } else {
                    value6 = null;
                }
            }
            str2 = str11;
            flexboxLayoutManager = value7;
            str5 = str10;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            str = null;
            str2 = null;
            z4 = false;
            z5 = false;
            str3 = null;
            z6 = false;
            z7 = false;
            value = null;
            z8 = false;
            value2 = null;
            z9 = false;
            value3 = null;
            z10 = false;
            value4 = null;
            flexboxLayoutManager = null;
            iSafeUnbox = 0;
            value5 = null;
            value6 = null;
            z11 = false;
            str4 = null;
            str5 = null;
            str6 = null;
            z12 = false;
            str7 = null;
            z13 = false;
            str8 = null;
            str9 = null;
        }
        long j5 = j & 1536;
        if (j5 == 0 || aVar2 == null) {
            bVarA = null;
            cVar = null;
            aVar = null;
        } else {
            c cVar2 = this.f11572a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f11572a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            a aVar3 = this.f11570a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f11570a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar = this.f11571a;
            if (bVar == null) {
                bVar = new b();
                this.f11571a = bVar;
            }
            bVarA = bVar.a(aVar2);
            cVar = cVarA;
            aVar = aVarA;
        }
        if ((j & 8192) == 0) {
            z14 = false;
        } else {
            if ((value != null ? value.getTotalTimes() : 0) != 0) {
                z14 = true;
            } else {
                z14 = false;
            }
        }
        if ((j & 4096) == 0) {
            z15 = false;
        } else {
            if ((value != null ? value.maxLimitSpeedMs() : 0.0f) == 0.0f) {
                z15 = true;
            } else {
                z15 = false;
            }
        }
        long j6 = j & 1284;
        if (j6 != 0) {
            if (!z9) {
                z15 = false;
            }
            if (z10) {
                z14 = true;
            }
            z17 = !z15;
            z16 = z14;
        } else {
            z16 = false;
            z17 = false;
        }
        if ((j & 1282) != 0) {
            CommonBindingAdapter.I(((RunActivitySchoolRuleV3Binding) this).f35494a, 0, iSafeUnbox, 0, 0, null);
        }
        if (j5 != 0) {
            CommonBindingAdapter.q(((RunActivitySchoolRuleV3Binding) this).f35494a, bVarA, null);
            CommonBindingAdapter.q(this.f11576b, aVar, null);
            CommonBindingAdapter.q(((RunActivitySchoolRuleV3Binding) this).f11564a, cVar, null);
        }
        if (j6 != 0) {
            CommonBindingAdapter.l0(this.f11574b, z4);
            CommonBindingAdapter.l0(this.c, z2);
            CommonBindingAdapter.l0(this.d, z8);
            TextViewBindingAdapter.setText(this.f11578g, str2);
            CommonBindingAdapter.l0(this.e, z);
            CommonBindingAdapter.l0(this.f, z7);
            TextViewBindingAdapter.setText(this.f11579h, str);
            CommonBindingAdapter.l0(this.g, z6);
            CommonBindingAdapter.l0(this.h, z3);
            TextViewBindingAdapter.setText(this.f11580i, str3);
            CommonBindingAdapter.l0(this.i, z5);
            TextViewBindingAdapter.setText(this.f11581j, str8);
            boolean z22 = z13;
            CommonBindingAdapter.l0(this.j, z22);
            CommonBindingAdapter.l0(this.f11573a, z22);
            TextViewBindingAdapter.setText(this.f11582k, str7);
            CommonBindingAdapter.l0(this.f11567a, z12);
            TextViewBindingAdapter.setText(this.f11583l, str6);
            CommonBindingAdapter.l0(this.b, z16);
            TextViewBindingAdapter.setText(this.m, str5);
            CommonBindingAdapter.l0(this.k, z17);
            TextViewBindingAdapter.setText(this.n, str4);
            TextViewBindingAdapter.setText(this.o, str9);
            CommonBindingAdapter.l0(this.l, z11);
        }
        if ((j & 1408) != 0) {
            this.f11569a.setLayoutManager(value6);
        }
        if ((j & 1296) != 0) {
            CommonBindingAdapter.g(this.f11569a, value5, false, false);
        }
        if ((j & 1312) != 0) {
            this.f11575b.setLayoutManager(flexboxLayoutManager);
        }
        if ((j & 1288) != 0) {
            CommonBindingAdapter.g(this.f11575b, value4, false, false);
        }
        if ((j & 1281) != 0) {
            this.f11577c.setLayoutManager(value3);
        }
        if ((j & 1344) != 0) {
            CommonBindingAdapter.g(this.f11577c, value2, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11566a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11566a = 1024L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySchoolRuleV3Binding
    public void l(@Nullable RuleV3Activity.a Click) {
        ((RunActivitySchoolRuleV3Binding) this).f11562a = Click;
        synchronized (this) {
            this.f11566a |= 512;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySchoolRuleV3Binding
    public void m(@Nullable RuleV3VM Vm) {
        ((RunActivitySchoolRuleV3Binding) this).f11563a = Vm;
        synchronized (this) {
            this.f11566a |= 256;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<FlexboxLayoutManager> VmFlexLayoutMgr01, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<FlexboxLayoutManager> VmFlexLayoutMgr02, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 128;
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
                return q((MutableLiveData) object, fieldId);
            case 3:
                return s((MutableLiveData) object, fieldId);
            case 4:
                return t((MutableLiveData) object, fieldId);
            case 5:
                return p((MutableLiveData) object, fieldId);
            case 6:
                return r((MutableLiveData) object, fieldId);
            case 7:
                return o((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<FlexboxLayoutManager> VmFlexLayoutMgr03, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 32;
        }
        return true;
    }

    public final boolean q(MutableLiveData<SchoolRule> VmMRule, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<RunTimePeriodAdapter> VmMRunTimeEverydayAdp, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 64;
        }
        return true;
    }

    public final boolean s(MutableLiveData<RunTimePeriodAdapter> VmMRunTimeWeekendAdp, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((RuleV3VM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RuleV3Activity.a) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<RunTimePeriodAdapter> VmMRunTimeWorkdayAdp, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 16;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Integer> VmStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11566a |= 2;
        }
        return true;
    }

    public RunActivitySchoolRuleV3BindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (ImageView) bindings[1], (TextView) bindings[35], (TextView) bindings[33], (TextView) bindings[32], (TextView) bindings[34], (BLTextView) bindings[2], (TextView) bindings[31], (StrokeTextView) bindings[30], (TextView) bindings[36]);
        this.f11566a = -1L;
        ((RunActivitySchoolRuleV3Binding) this).f35494a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11568a = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[10];
        this.f11574b = linearLayout2;
        linearLayout2.setTag(null);
        RecyclerView recyclerView = (RecyclerView) bindings[11];
        this.f11569a = recyclerView;
        recyclerView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[12];
        this.c = linearLayout3;
        linearLayout3.setTag(null);
        RecyclerView recyclerView2 = (RecyclerView) bindings[13];
        this.f11575b = recyclerView2;
        recyclerView2.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) bindings[14];
        this.d = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView = (TextView) bindings[15];
        this.f11578g = textView;
        textView.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) bindings[16];
        this.e = linearLayout5;
        linearLayout5.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) bindings[17];
        this.f = linearLayout6;
        linearLayout6.setTag(null);
        TextView textView2 = (TextView) bindings[18];
        this.f11579h = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) bindings[19];
        this.g = linearLayout7;
        linearLayout7.setTag(null);
        LinearLayout linearLayout8 = (LinearLayout) bindings[20];
        this.h = linearLayout8;
        linearLayout8.setTag(null);
        TextView textView3 = (TextView) bindings[21];
        this.f11580i = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout9 = (LinearLayout) bindings[22];
        this.i = linearLayout9;
        linearLayout9.setTag(null);
        TextView textView4 = (TextView) bindings[23];
        this.f11581j = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout10 = (LinearLayout) bindings[24];
        this.j = linearLayout10;
        linearLayout10.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[25];
        this.f11573a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView5 = (TextView) bindings[26];
        this.f11582k = textView5;
        textView5.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[27];
        this.f11567a = frameLayout;
        frameLayout.setTag(null);
        TextView textView6 = (TextView) bindings[28];
        this.f11583l = textView6;
        textView6.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[29];
        this.f11576b = bLTextView;
        bLTextView.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) bindings[3];
        this.b = frameLayout2;
        frameLayout2.setTag(null);
        TextView textView7 = (TextView) bindings[4];
        this.m = textView7;
        textView7.setTag(null);
        LinearLayout linearLayout11 = (LinearLayout) bindings[5];
        this.k = linearLayout11;
        linearLayout11.setTag(null);
        TextView textView8 = (TextView) bindings[6];
        this.n = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) bindings[7];
        this.o = textView9;
        textView9.setTag(null);
        LinearLayout linearLayout12 = (LinearLayout) bindings[8];
        this.l = linearLayout12;
        linearLayout12.setTag(null);
        RecyclerView recyclerView3 = (RecyclerView) bindings[9];
        this.f11577c = recyclerView3;
        recyclerView3.setTag(null);
        ((RunActivitySchoolRuleV3Binding) this).f11564a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
