package com.huachenjie.run.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LiveData;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.huachenjie.run.page.run_index.RunIndexVM;
import com.huachenjie.run.widget.GoalProgressView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutIndexHeaderBindingImpl extends RunLayoutIndexHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12073a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f12075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StrokeTextView f12077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f12078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f12079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f12080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f12081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f12082a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12083b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12084c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12085d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f12086d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12087e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f12088e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final TextView q;

    @NonNull
    public final TextView r;

    @NonNull
    public final TextView s;

    @NonNull
    public final TextView t;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35666a;

        public a a(RunIndexActivity.a value) {
            this.f35666a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35666a.a(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35667a;

        public b a(RunIndexActivity.a value) {
            this.f35667a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35667a.f(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35668a;

        public c a(RunIndexActivity.a value) {
            this.f35668a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35668a.e(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35669a;

        public d a(RunIndexActivity.a value) {
            this.f35669a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35669a.g(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RunIndexActivity.a f35670a;

        public e a(RunIndexActivity.a value) {
            this.f35670a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35670a.c(arg0);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35665a = sparseIntArray;
        sparseIntArray.put(R.id.clGoalCard, 33);
        sparseIntArray.put(R.id.ivGoalBg, 34);
        sparseIntArray.put(R.id.llGoalKm, 35);
        sparseIntArray.put(R.id.rvDeduction, 36);
        sparseIntArray.put(R.id.tvProgressLabel, 37);
        sparseIntArray.put(R.id.llMedalFreeBar, 38);
        sparseIntArray.put(R.id.llStaticsInfo, 39);
        sparseIntArray.put(R.id.ivActivityRunBg, 40);
        sparseIntArray.put(R.id.tv_activity_run_enter, 41);
        sparseIntArray.put(R.id.llPlanRow, 42);
    }

    public RunLayoutIndexHeaderBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 43, f12073a, f35665a));
    }

    public final boolean A(LiveData<Integer> VmLeftEntryIcon, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 262144;
        }
        return true;
    }

    public final boolean B(MediatorLiveData<String> VmLeftEntryTitle, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 2;
        }
        return true;
    }

    public final boolean C(LiveData<String> VmMorningValue, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 8;
        }
        return true;
    }

    public final boolean D(MediatorLiveData<String> VmRunRecordSectionTitle, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 4096;
        }
        return true;
    }

    public final boolean E(LiveData<Boolean> VmShowFreePunch, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 16777216;
        }
        return true;
    }

    public final boolean F(LiveData<Boolean> VmShowGoalKm, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 512;
        }
        return true;
    }

    public final boolean G(LiveData<Boolean> VmShowGoalProgressDoneLabel, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 8192;
        }
        return true;
    }

    public final boolean H(LiveData<Boolean> VmShowGoalTimes, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 1048576;
        }
        return true;
    }

    public final boolean I(LiveData<Boolean> VmShowLeftEntryDesc, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 33554432;
        }
        return true;
    }

    public final boolean J(MediatorLiveData<Boolean> VmShowMedalWallGoView, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= PlaybackStateCompat.ACTION_PREPARE;
        }
        return true;
    }

    public final boolean K(LiveData<Boolean> VmShowMorningCount, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 2097152;
        }
        return true;
    }

    public final boolean L(MediatorLiveData<Boolean> VmShowSwitchRunPlan, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 128;
        }
        return true;
    }

    public final boolean M(MutableLiveData<CommonUserInfo> VmUserInfo, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 64;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:121:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:135:0x0200  */
    /* JADX WARN: Code duplicated, block: B:139:0x020b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x020d  */
    /* JADX WARN: Code duplicated, block: B:141:0x0214  */
    /* JADX WARN: Code duplicated, block: B:144:0x021e  */
    /* JADX WARN: Code duplicated, block: B:145:0x0225  */
    /* JADX WARN: Code duplicated, block: B:147:0x0235  */
    /* JADX WARN: Code duplicated, block: B:150:0x0244 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x0246  */
    /* JADX WARN: Code duplicated, block: B:152:0x0253  */
    /* JADX WARN: Code duplicated, block: B:155:0x025f  */
    /* JADX WARN: Code duplicated, block: B:156:0x0266  */
    /* JADX WARN: Code duplicated, block: B:158:0x026c  */
    /* JADX WARN: Code duplicated, block: B:161:0x027c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:162:0x027e  */
    /* JADX WARN: Code duplicated, block: B:163:0x0285  */
    /* JADX WARN: Code duplicated, block: B:166:0x028f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0296  */
    /* JADX WARN: Code duplicated, block: B:169:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:16:0x005b  */
    /* JADX WARN: Code duplicated, block: B:172:0x02cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:173:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:174:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:177:0x02db  */
    /* JADX WARN: Code duplicated, block: B:178:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:181:0x02eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:182:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:183:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:186:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:187:0x0305  */
    /* JADX WARN: Code duplicated, block: B:189:0x030b  */
    /* JADX WARN: Code duplicated, block: B:192:0x0316 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0318  */
    /* JADX WARN: Code duplicated, block: B:194:0x031f  */
    /* JADX WARN: Code duplicated, block: B:197:0x0329  */
    /* JADX WARN: Code duplicated, block: B:198:0x0330  */
    /* JADX WARN: Code duplicated, block: B:200:0x0336  */
    /* JADX WARN: Code duplicated, block: B:203:0x0341 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:204:0x0343  */
    /* JADX WARN: Code duplicated, block: B:205:0x034a  */
    /* JADX WARN: Code duplicated, block: B:208:0x0354  */
    /* JADX WARN: Code duplicated, block: B:209:0x035b  */
    /* JADX WARN: Code duplicated, block: B:211:0x0361  */
    /* JADX WARN: Code duplicated, block: B:214:0x036f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:215:0x0371  */
    /* JADX WARN: Code duplicated, block: B:216:0x0378  */
    /* JADX WARN: Code duplicated, block: B:219:0x0382  */
    /* JADX WARN: Code duplicated, block: B:220:0x0389  */
    /* JADX WARN: Code duplicated, block: B:222:0x038f  */
    /* JADX WARN: Code duplicated, block: B:225:0x039d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:226:0x039f  */
    /* JADX WARN: Code duplicated, block: B:227:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:230:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:231:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:233:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:236:0x03cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:237:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:238:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:241:0x03de  */
    /* JADX WARN: Code duplicated, block: B:242:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:246:0x03f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:247:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:248:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:251:0x0403  */
    /* JADX WARN: Code duplicated, block: B:252:0x040a  */
    /* JADX WARN: Code duplicated, block: B:256:0x0415 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:257:0x0417  */
    /* JADX WARN: Code duplicated, block: B:258:0x041e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:261:0x0428  */
    /* JADX WARN: Code duplicated, block: B:262:0x042f  */
    /* JADX WARN: Code duplicated, block: B:264:0x043f  */
    /* JADX WARN: Code duplicated, block: B:267:0x044e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:268:0x0450  */
    /* JADX WARN: Code duplicated, block: B:269:0x0457  */
    /* JADX WARN: Code duplicated, block: B:272:0x0461  */
    /* JADX WARN: Code duplicated, block: B:273:0x0468  */
    /* JADX WARN: Code duplicated, block: B:275:0x049c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0095  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:95:0x0162  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        boolean zSafeUnbox;
        int i;
        boolean zSafeUnbox2;
        boolean zSafeUnbox3;
        boolean z;
        boolean zSafeUnbox4;
        boolean z2;
        int iSafeUnbox;
        boolean zSafeUnbox5;
        String str;
        String value3;
        String value4;
        String value5;
        String value6;
        SpannableStringBuilder value7;
        String value8;
        String value9;
        String value10;
        String str2;
        boolean zSafeUnbox6;
        boolean zSafeUnbox7;
        boolean zSafeUnbox8;
        boolean zSafeUnbox9;
        String value11;
        String value12;
        String str3;
        d dVar;
        a aVar;
        b bVar;
        e eVar;
        c cVar;
        String value13;
        boolean zSafeUnbox10;
        int iSafeUnbox2;
        boolean zSafeUnbox11;
        LiveData<Boolean> liveDataD0;
        Boolean value14;
        LiveData<Boolean> liveDataZ;
        Boolean value15;
        LiveData<String> liveDataK;
        MutableLiveData<String> mutableLiveDataZ;
        LiveData<Boolean> liveDataG0;
        Boolean value16;
        LiveData<Boolean> liveDataC0;
        Boolean value17;
        LiveData<Integer> liveDataL;
        Integer value18;
        LiveData<Integer> liveDataP;
        Integer value19;
        MutableLiveData<Boolean> mutableLiveDataM0;
        Boolean value20;
        LiveData<String> liveDataJ;
        LiveData<Integer> liveDataG;
        Integer value21;
        MediatorLiveData<Boolean> mediatorLiveDataF0;
        Boolean value22;
        LiveData<Boolean> liveDataB0;
        Boolean value23;
        MediatorLiveData<String> mediatorLiveDataV;
        LiveData<String> liveDataE;
        synchronized (this) {
            j = this.f12074a;
            this.f12074a = 0L;
        }
        RunIndexVM runIndexVM = ((RunLayoutIndexHeaderBinding) this).f12064a;
        RunIndexActivity.a aVar2 = ((RunLayoutIndexHeaderBinding) this).f12063a;
        if ((402653183 & j) != 0) {
            if ((j & 335544321) == 0) {
                value10 = null;
            } else {
                LiveData<String> liveDataF = runIndexVM != null ? runIndexVM.F() : null;
                updateLiveDataRegistration(0, liveDataF);
                if (liveDataF != null) {
                    value10 = liveDataF.getValue();
                } else {
                    value10 = null;
                }
            }
            if ((j & 335544322) == 0) {
                value13 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataQ = runIndexVM != null ? runIndexVM.Q() : null;
                updateLiveDataRegistration(1, mediatorLiveDataQ);
                if (mediatorLiveDataQ != null) {
                    value13 = mediatorLiveDataQ.getValue();
                } else {
                    value13 = null;
                }
            }
            if ((j & 335544324) == 0) {
                value7 = null;
            } else {
                LiveData<SpannableStringBuilder> liveDataA = runIndexVM != null ? runIndexVM.A() : null;
                updateLiveDataRegistration(2, liveDataA);
                if (liveDataA != null) {
                    value7 = liveDataA.getValue();
                } else {
                    value7 = null;
                }
            }
            if ((j & 335544328) == 0) {
                value8 = null;
            } else {
                LiveData<String> liveDataR = runIndexVM != null ? runIndexVM.R() : null;
                updateLiveDataRegistration(3, liveDataR);
                if (liveDataR != null) {
                    value8 = liveDataR.getValue();
                } else {
                    value8 = null;
                }
            }
            if ((j & 335544336) == 0) {
                value11 = null;
            } else {
                LiveData<String> liveDataI = runIndexVM != null ? runIndexVM.I() : null;
                updateLiveDataRegistration(4, liveDataI);
                if (liveDataI != null) {
                    value11 = liveDataI.getValue();
                } else {
                    value11 = null;
                }
            }
            if ((j & 335544352) == 0) {
                value12 = null;
            } else {
                LiveData<String> liveDataH = runIndexVM != null ? runIndexVM.H() : null;
                updateLiveDataRegistration(5, liveDataH);
                if (liveDataH != null) {
                    value12 = liveDataH.getValue();
                } else {
                    value12 = null;
                }
            }
            if ((j & 335544384) != 0) {
                MutableLiveData<CommonUserInfo> mutableLiveDataK0 = runIndexVM != null ? runIndexVM.k0() : null;
                updateLiveDataRegistration(6, mutableLiveDataK0);
                CommonUserInfo value24 = mutableLiveDataK0 != null ? mutableLiveDataK0.getValue() : null;
                str3 = (value24 != null ? value24.getSchoolName() : null) + "阳光跑";
            } else {
                str3 = null;
            }
            if ((j & 335544448) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataH0 = runIndexVM != null ? runIndexVM.h0() : null;
                updateLiveDataRegistration(7, mediatorLiveDataH0);
                zSafeUnbox9 = ViewDataBinding.safeUnbox(mediatorLiveDataH0 != null ? mediatorLiveDataH0.getValue() : null);
            } else {
                zSafeUnbox9 = false;
            }
            if ((j & 335544576) == 0) {
                value = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataO = runIndexVM != null ? runIndexVM.O() : null;
                updateLiveDataRegistration(8, mediatorLiveDataO);
                if (mediatorLiveDataO != null) {
                    value = mediatorLiveDataO.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 335544832) != 0) {
                LiveData<Boolean> liveDataA0 = runIndexVM != null ? runIndexVM.a0() : null;
                updateLiveDataRegistration(9, liveDataA0);
                zSafeUnbox6 = ViewDataBinding.safeUnbox(liveDataA0 != null ? liveDataA0.getValue() : null);
            } else {
                zSafeUnbox6 = false;
            }
            if ((j & 335545344) != 0) {
                LiveData<String> liveDataM = runIndexVM != null ? runIndexVM.M() : null;
                updateLiveDataRegistration(10, liveDataM);
                value5 = liveDataM != null ? liveDataM.getValue() : null;
                if ((j & 335546368) != 0) {
                    if (runIndexVM != null) {
                        liveDataE = runIndexVM.E();
                    } else {
                        liveDataE = null;
                    }
                    updateLiveDataRegistration(11, liveDataE);
                    value9 = liveDataE != null ? liveDataE.getValue() : null;
                    if ((j & 335548416) != 0) {
                        if (runIndexVM != null) {
                            mediatorLiveDataV = runIndexVM.V();
                        } else {
                            mediatorLiveDataV = null;
                        }
                        updateLiveDataRegistration(12, mediatorLiveDataV);
                        value3 = mediatorLiveDataV != null ? mediatorLiveDataV.getValue() : null;
                        if ((j & 335552512) != 0) {
                            if (runIndexVM != null) {
                                liveDataB0 = runIndexVM.b0();
                            } else {
                                liveDataB0 = null;
                            }
                            updateLiveDataRegistration(13, liveDataB0);
                            if (liveDataB0 != null) {
                                value23 = liveDataB0.getValue();
                            } else {
                                value23 = null;
                            }
                            zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                            zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                        } else {
                            value3 = value3;
                            zSafeUnbox4 = false;
                            zSafeUnbox10 = false;
                        }
                        if ((j & 335560704) != 0) {
                            if (runIndexVM != null) {
                                mediatorLiveDataF0 = runIndexVM.f0();
                            } else {
                                mediatorLiveDataF0 = null;
                            }
                            updateLiveDataRegistration(14, mediatorLiveDataF0);
                            if (mediatorLiveDataF0 != null) {
                                value22 = mediatorLiveDataF0.getValue();
                            } else {
                                value22 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                        } else {
                            zSafeUnbox4 = zSafeUnbox4;
                            zSafeUnbox6 = zSafeUnbox6;
                            zSafeUnbox = false;
                        }
                        if ((j & 335577088) != 0) {
                            if (runIndexVM != null) {
                                liveDataG = runIndexVM.G();
                            } else {
                                liveDataG = null;
                            }
                            updateLiveDataRegistration(15, liveDataG);
                            if (liveDataG != null) {
                                value21 = liveDataG.getValue();
                            } else {
                                value21 = null;
                            }
                            str2 = ("(" + value21) + ")";
                        } else {
                            zSafeUnbox = zSafeUnbox;
                            str2 = null;
                        }
                        if ((j & 335609856) == 0) {
                            value4 = null;
                        } else {
                            if (runIndexVM != null) {
                                liveDataJ = runIndexVM.J();
                            } else {
                                liveDataJ = null;
                            }
                            updateLiveDataRegistration(16, liveDataJ);
                            if (liveDataJ != null) {
                                value4 = liveDataJ.getValue();
                            } else {
                                value4 = null;
                            }
                        }
                        if ((j & 335675392) != 0) {
                            if (runIndexVM != null) {
                                mutableLiveDataM0 = runIndexVM.m0();
                            } else {
                                mutableLiveDataM0 = null;
                            }
                            updateLiveDataRegistration(17, mutableLiveDataM0);
                            if (mutableLiveDataM0 != null) {
                                value20 = mutableLiveDataM0.getValue();
                            } else {
                                value20 = null;
                            }
                            zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                        } else {
                            str2 = str2;
                            zSafeUnbox2 = false;
                        }
                        if ((j & 335806464) != 0) {
                            if (runIndexVM != null) {
                                liveDataP = runIndexVM.P();
                            } else {
                                liveDataP = null;
                            }
                            updateLiveDataRegistration(18, liveDataP);
                            if (liveDataP != null) {
                                value19 = liveDataP.getValue();
                            } else {
                                value19 = null;
                            }
                            iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                        } else {
                            zSafeUnbox2 = zSafeUnbox2;
                            iSafeUnbox2 = 0;
                        }
                        if ((j & 336068608) != 0) {
                            if (runIndexVM != null) {
                                liveDataL = runIndexVM.L();
                            } else {
                                liveDataL = null;
                            }
                            updateLiveDataRegistration(19, liveDataL);
                            if (liveDataL != null) {
                                value18 = liveDataL.getValue();
                            } else {
                                value18 = null;
                            }
                            iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                        } else {
                            iSafeUnbox2 = iSafeUnbox2;
                            iSafeUnbox = 0;
                        }
                        if ((j & 336592896) != 0) {
                            if (runIndexVM != null) {
                                liveDataC0 = runIndexVM.c0();
                            } else {
                                liveDataC0 = null;
                            }
                            updateLiveDataRegistration(20, liveDataC0);
                            if (liveDataC0 != null) {
                                value17 = liveDataC0.getValue();
                            } else {
                                value17 = null;
                            }
                            zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                        } else {
                            iSafeUnbox = iSafeUnbox;
                            zSafeUnbox8 = false;
                        }
                        if ((j & 337641472) != 0) {
                            if (runIndexVM != null) {
                                liveDataG0 = runIndexVM.g0();
                            } else {
                                liveDataG0 = null;
                            }
                            updateLiveDataRegistration(21, liveDataG0);
                            if (liveDataG0 != null) {
                                value16 = liveDataG0.getValue();
                            } else {
                                value16 = null;
                            }
                            zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                        } else {
                            zSafeUnbox8 = zSafeUnbox8;
                            zSafeUnbox7 = false;
                        }
                        if ((j & 339738624) != 0) {
                            if (runIndexVM != null) {
                                mutableLiveDataZ = runIndexVM.z();
                            } else {
                                mutableLiveDataZ = null;
                            }
                            updateLiveDataRegistration(22, mutableLiveDataZ);
                            value6 = mutableLiveDataZ != null ? mutableLiveDataZ.getValue() : null;
                            if ((j & 343932928) != 0) {
                                if (runIndexVM != null) {
                                    liveDataK = runIndexVM.K();
                                } else {
                                    liveDataK = null;
                                }
                                updateLiveDataRegistration(23, liveDataK);
                                value2 = liveDataK != null ? liveDataK.getValue() : null;
                                if ((j & 352321536) != 0) {
                                    if (runIndexVM != null) {
                                        liveDataZ = runIndexVM.Z();
                                    } else {
                                        liveDataZ = null;
                                    }
                                    updateLiveDataRegistration(24, liveDataZ);
                                    if (liveDataZ != null) {
                                        value15 = liveDataZ.getValue();
                                    } else {
                                        value15 = null;
                                    }
                                    zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                                    zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                                } else {
                                    value2 = value2;
                                    zSafeUnbox11 = false;
                                    zSafeUnbox3 = false;
                                }
                                if ((j & 369098752) != 0) {
                                    if (runIndexVM != null) {
                                        liveDataD0 = runIndexVM.d0();
                                    } else {
                                        liveDataD0 = null;
                                    }
                                    updateLiveDataRegistration(25, liveDataD0);
                                    if (liveDataD0 != null) {
                                        value14 = liveDataD0.getValue();
                                    } else {
                                        value14 = null;
                                    }
                                    z2 = zSafeUnbox11;
                                    zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                                } else {
                                    z2 = zSafeUnbox11;
                                    zSafeUnbox5 = false;
                                }
                                i = iSafeUnbox2;
                                boolean z3 = zSafeUnbox10;
                                str = value13;
                                z = z3;
                            } else {
                                value6 = value6;
                            }
                            if ((j & 352321536) != 0) {
                                if (runIndexVM != null) {
                                    liveDataZ = runIndexVM.Z();
                                } else {
                                    liveDataZ = null;
                                }
                                updateLiveDataRegistration(24, liveDataZ);
                                if (liveDataZ != null) {
                                    value15 = liveDataZ.getValue();
                                } else {
                                    value15 = null;
                                }
                                zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                            } else {
                                value2 = value2;
                                zSafeUnbox11 = false;
                                zSafeUnbox3 = false;
                            }
                            if ((j & 369098752) != 0) {
                                if (runIndexVM != null) {
                                    liveDataD0 = runIndexVM.d0();
                                } else {
                                    liveDataD0 = null;
                                }
                                updateLiveDataRegistration(25, liveDataD0);
                                if (liveDataD0 != null) {
                                    value14 = liveDataD0.getValue();
                                } else {
                                    value14 = null;
                                }
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                            } else {
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = false;
                            }
                            i = iSafeUnbox2;
                            boolean z4 = zSafeUnbox10;
                            str = value13;
                            z = z4;
                        } else {
                            zSafeUnbox7 = zSafeUnbox7;
                        }
                        if ((j & 343932928) != 0) {
                            if (runIndexVM != null) {
                                liveDataK = runIndexVM.K();
                            } else {
                                liveDataK = null;
                            }
                            updateLiveDataRegistration(23, liveDataK);
                            if (liveDataK != null) {
                            }
                            if ((j & 352321536) != 0) {
                                if (runIndexVM != null) {
                                    liveDataZ = runIndexVM.Z();
                                } else {
                                    liveDataZ = null;
                                }
                                updateLiveDataRegistration(24, liveDataZ);
                                if (liveDataZ != null) {
                                    value15 = liveDataZ.getValue();
                                } else {
                                    value15 = null;
                                }
                                zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                            } else {
                                value2 = value2;
                                zSafeUnbox11 = false;
                                zSafeUnbox3 = false;
                            }
                            if ((j & 369098752) != 0) {
                                if (runIndexVM != null) {
                                    liveDataD0 = runIndexVM.d0();
                                } else {
                                    liveDataD0 = null;
                                }
                                updateLiveDataRegistration(25, liveDataD0);
                                if (liveDataD0 != null) {
                                    value14 = liveDataD0.getValue();
                                } else {
                                    value14 = null;
                                }
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                            } else {
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = false;
                            }
                            i = iSafeUnbox2;
                            boolean z5 = zSafeUnbox10;
                            str = value13;
                            z = z5;
                        } else {
                            value6 = value6;
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z6 = zSafeUnbox10;
                        str = value13;
                        z = z6;
                    } else {
                        value9 = value9;
                    }
                    if ((j & 335552512) != 0) {
                        if (runIndexVM != null) {
                            liveDataB0 = runIndexVM.b0();
                        } else {
                            liveDataB0 = null;
                        }
                        updateLiveDataRegistration(13, liveDataB0);
                        if (liveDataB0 != null) {
                            value23 = liveDataB0.getValue();
                        } else {
                            value23 = null;
                        }
                        zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                        zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                    } else {
                        value3 = value3;
                        zSafeUnbox4 = false;
                        zSafeUnbox10 = false;
                    }
                    if ((j & 335560704) != 0) {
                        if (runIndexVM != null) {
                            mediatorLiveDataF0 = runIndexVM.f0();
                        } else {
                            mediatorLiveDataF0 = null;
                        }
                        updateLiveDataRegistration(14, mediatorLiveDataF0);
                        if (mediatorLiveDataF0 != null) {
                            value22 = mediatorLiveDataF0.getValue();
                        } else {
                            value22 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                    } else {
                        zSafeUnbox4 = zSafeUnbox4;
                        zSafeUnbox6 = zSafeUnbox6;
                        zSafeUnbox = false;
                    }
                    if ((j & 335577088) != 0) {
                        if (runIndexVM != null) {
                            liveDataG = runIndexVM.G();
                        } else {
                            liveDataG = null;
                        }
                        updateLiveDataRegistration(15, liveDataG);
                        if (liveDataG != null) {
                            value21 = liveDataG.getValue();
                        } else {
                            value21 = null;
                        }
                        str2 = ("(" + value21) + ")";
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        str2 = null;
                    }
                    if ((j & 335609856) == 0) {
                        value4 = null;
                    } else {
                        if (runIndexVM != null) {
                            liveDataJ = runIndexVM.J();
                        } else {
                            liveDataJ = null;
                        }
                        updateLiveDataRegistration(16, liveDataJ);
                        if (liveDataJ != null) {
                            value4 = liveDataJ.getValue();
                        } else {
                            value4 = null;
                        }
                    }
                    if ((j & 335675392) != 0) {
                        if (runIndexVM != null) {
                            mutableLiveDataM0 = runIndexVM.m0();
                        } else {
                            mutableLiveDataM0 = null;
                        }
                        updateLiveDataRegistration(17, mutableLiveDataM0);
                        if (mutableLiveDataM0 != null) {
                            value20 = mutableLiveDataM0.getValue();
                        } else {
                            value20 = null;
                        }
                        zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                    } else {
                        str2 = str2;
                        zSafeUnbox2 = false;
                    }
                    if ((j & 335806464) != 0) {
                        if (runIndexVM != null) {
                            liveDataP = runIndexVM.P();
                        } else {
                            liveDataP = null;
                        }
                        updateLiveDataRegistration(18, liveDataP);
                        if (liveDataP != null) {
                            value19 = liveDataP.getValue();
                        } else {
                            value19 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                    } else {
                        zSafeUnbox2 = zSafeUnbox2;
                        iSafeUnbox2 = 0;
                    }
                    if ((j & 336068608) != 0) {
                        if (runIndexVM != null) {
                            liveDataL = runIndexVM.L();
                        } else {
                            liveDataL = null;
                        }
                        updateLiveDataRegistration(19, liveDataL);
                        if (liveDataL != null) {
                            value18 = liveDataL.getValue();
                        } else {
                            value18 = null;
                        }
                        iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                    } else {
                        iSafeUnbox2 = iSafeUnbox2;
                        iSafeUnbox = 0;
                    }
                    if ((j & 336592896) != 0) {
                        if (runIndexVM != null) {
                            liveDataC0 = runIndexVM.c0();
                        } else {
                            liveDataC0 = null;
                        }
                        updateLiveDataRegistration(20, liveDataC0);
                        if (liveDataC0 != null) {
                            value17 = liveDataC0.getValue();
                        } else {
                            value17 = null;
                        }
                        zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                    } else {
                        iSafeUnbox = iSafeUnbox;
                        zSafeUnbox8 = false;
                    }
                    if ((j & 337641472) != 0) {
                        if (runIndexVM != null) {
                            liveDataG0 = runIndexVM.g0();
                        } else {
                            liveDataG0 = null;
                        }
                        updateLiveDataRegistration(21, liveDataG0);
                        if (liveDataG0 != null) {
                            value16 = liveDataG0.getValue();
                        } else {
                            value16 = null;
                        }
                        zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                    } else {
                        zSafeUnbox8 = zSafeUnbox8;
                        zSafeUnbox7 = false;
                    }
                    if ((j & 339738624) != 0) {
                        if (runIndexVM != null) {
                            mutableLiveDataZ = runIndexVM.z();
                        } else {
                            mutableLiveDataZ = null;
                        }
                        updateLiveDataRegistration(22, mutableLiveDataZ);
                        if (mutableLiveDataZ != null) {
                        }
                        if ((j & 343932928) != 0) {
                            if (runIndexVM != null) {
                                liveDataK = runIndexVM.K();
                            } else {
                                liveDataK = null;
                            }
                            updateLiveDataRegistration(23, liveDataK);
                            if (liveDataK != null) {
                            }
                            if ((j & 352321536) != 0) {
                                if (runIndexVM != null) {
                                    liveDataZ = runIndexVM.Z();
                                } else {
                                    liveDataZ = null;
                                }
                                updateLiveDataRegistration(24, liveDataZ);
                                if (liveDataZ != null) {
                                    value15 = liveDataZ.getValue();
                                } else {
                                    value15 = null;
                                }
                                zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                            } else {
                                value2 = value2;
                                zSafeUnbox11 = false;
                                zSafeUnbox3 = false;
                            }
                            if ((j & 369098752) != 0) {
                                if (runIndexVM != null) {
                                    liveDataD0 = runIndexVM.d0();
                                } else {
                                    liveDataD0 = null;
                                }
                                updateLiveDataRegistration(25, liveDataD0);
                                if (liveDataD0 != null) {
                                    value14 = liveDataD0.getValue();
                                } else {
                                    value14 = null;
                                }
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                            } else {
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = false;
                            }
                            i = iSafeUnbox2;
                            boolean z7 = zSafeUnbox10;
                            str = value13;
                            z = z7;
                        } else {
                            value6 = value6;
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z8 = zSafeUnbox10;
                        str = value13;
                        z = z8;
                    } else {
                        zSafeUnbox7 = zSafeUnbox7;
                    }
                    if ((j & 343932928) != 0) {
                        if (runIndexVM != null) {
                            liveDataK = runIndexVM.K();
                        } else {
                            liveDataK = null;
                        }
                        updateLiveDataRegistration(23, liveDataK);
                        if (liveDataK != null) {
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z9 = zSafeUnbox10;
                        str = value13;
                        z = z9;
                    } else {
                        value6 = value6;
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z10 = zSafeUnbox10;
                    str = value13;
                    z = z10;
                } else {
                    value5 = value5;
                }
                if ((j & 335548416) != 0) {
                    if (runIndexVM != null) {
                        mediatorLiveDataV = runIndexVM.V();
                    } else {
                        mediatorLiveDataV = null;
                    }
                    updateLiveDataRegistration(12, mediatorLiveDataV);
                    if (mediatorLiveDataV != null) {
                    }
                    if ((j & 335552512) != 0) {
                        if (runIndexVM != null) {
                            liveDataB0 = runIndexVM.b0();
                        } else {
                            liveDataB0 = null;
                        }
                        updateLiveDataRegistration(13, liveDataB0);
                        if (liveDataB0 != null) {
                            value23 = liveDataB0.getValue();
                        } else {
                            value23 = null;
                        }
                        zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                        zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                    } else {
                        value3 = value3;
                        zSafeUnbox4 = false;
                        zSafeUnbox10 = false;
                    }
                    if ((j & 335560704) != 0) {
                        if (runIndexVM != null) {
                            mediatorLiveDataF0 = runIndexVM.f0();
                        } else {
                            mediatorLiveDataF0 = null;
                        }
                        updateLiveDataRegistration(14, mediatorLiveDataF0);
                        if (mediatorLiveDataF0 != null) {
                            value22 = mediatorLiveDataF0.getValue();
                        } else {
                            value22 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                    } else {
                        zSafeUnbox4 = zSafeUnbox4;
                        zSafeUnbox6 = zSafeUnbox6;
                        zSafeUnbox = false;
                    }
                    if ((j & 335577088) != 0) {
                        if (runIndexVM != null) {
                            liveDataG = runIndexVM.G();
                        } else {
                            liveDataG = null;
                        }
                        updateLiveDataRegistration(15, liveDataG);
                        if (liveDataG != null) {
                            value21 = liveDataG.getValue();
                        } else {
                            value21 = null;
                        }
                        str2 = ("(" + value21) + ")";
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        str2 = null;
                    }
                    if ((j & 335609856) == 0) {
                        value4 = null;
                    } else {
                        if (runIndexVM != null) {
                            liveDataJ = runIndexVM.J();
                        } else {
                            liveDataJ = null;
                        }
                        updateLiveDataRegistration(16, liveDataJ);
                        if (liveDataJ != null) {
                            value4 = liveDataJ.getValue();
                        } else {
                            value4 = null;
                        }
                    }
                    if ((j & 335675392) != 0) {
                        if (runIndexVM != null) {
                            mutableLiveDataM0 = runIndexVM.m0();
                        } else {
                            mutableLiveDataM0 = null;
                        }
                        updateLiveDataRegistration(17, mutableLiveDataM0);
                        if (mutableLiveDataM0 != null) {
                            value20 = mutableLiveDataM0.getValue();
                        } else {
                            value20 = null;
                        }
                        zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                    } else {
                        str2 = str2;
                        zSafeUnbox2 = false;
                    }
                    if ((j & 335806464) != 0) {
                        if (runIndexVM != null) {
                            liveDataP = runIndexVM.P();
                        } else {
                            liveDataP = null;
                        }
                        updateLiveDataRegistration(18, liveDataP);
                        if (liveDataP != null) {
                            value19 = liveDataP.getValue();
                        } else {
                            value19 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                    } else {
                        zSafeUnbox2 = zSafeUnbox2;
                        iSafeUnbox2 = 0;
                    }
                    if ((j & 336068608) != 0) {
                        if (runIndexVM != null) {
                            liveDataL = runIndexVM.L();
                        } else {
                            liveDataL = null;
                        }
                        updateLiveDataRegistration(19, liveDataL);
                        if (liveDataL != null) {
                            value18 = liveDataL.getValue();
                        } else {
                            value18 = null;
                        }
                        iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                    } else {
                        iSafeUnbox2 = iSafeUnbox2;
                        iSafeUnbox = 0;
                    }
                    if ((j & 336592896) != 0) {
                        if (runIndexVM != null) {
                            liveDataC0 = runIndexVM.c0();
                        } else {
                            liveDataC0 = null;
                        }
                        updateLiveDataRegistration(20, liveDataC0);
                        if (liveDataC0 != null) {
                            value17 = liveDataC0.getValue();
                        } else {
                            value17 = null;
                        }
                        zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                    } else {
                        iSafeUnbox = iSafeUnbox;
                        zSafeUnbox8 = false;
                    }
                    if ((j & 337641472) != 0) {
                        if (runIndexVM != null) {
                            liveDataG0 = runIndexVM.g0();
                        } else {
                            liveDataG0 = null;
                        }
                        updateLiveDataRegistration(21, liveDataG0);
                        if (liveDataG0 != null) {
                            value16 = liveDataG0.getValue();
                        } else {
                            value16 = null;
                        }
                        zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                    } else {
                        zSafeUnbox8 = zSafeUnbox8;
                        zSafeUnbox7 = false;
                    }
                    if ((j & 339738624) != 0) {
                        if (runIndexVM != null) {
                            mutableLiveDataZ = runIndexVM.z();
                        } else {
                            mutableLiveDataZ = null;
                        }
                        updateLiveDataRegistration(22, mutableLiveDataZ);
                        if (mutableLiveDataZ != null) {
                        }
                        if ((j & 343932928) != 0) {
                            if (runIndexVM != null) {
                                liveDataK = runIndexVM.K();
                            } else {
                                liveDataK = null;
                            }
                            updateLiveDataRegistration(23, liveDataK);
                            if (liveDataK != null) {
                            }
                            if ((j & 352321536) != 0) {
                                if (runIndexVM != null) {
                                    liveDataZ = runIndexVM.Z();
                                } else {
                                    liveDataZ = null;
                                }
                                updateLiveDataRegistration(24, liveDataZ);
                                if (liveDataZ != null) {
                                    value15 = liveDataZ.getValue();
                                } else {
                                    value15 = null;
                                }
                                zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                            } else {
                                value2 = value2;
                                zSafeUnbox11 = false;
                                zSafeUnbox3 = false;
                            }
                            if ((j & 369098752) != 0) {
                                if (runIndexVM != null) {
                                    liveDataD0 = runIndexVM.d0();
                                } else {
                                    liveDataD0 = null;
                                }
                                updateLiveDataRegistration(25, liveDataD0);
                                if (liveDataD0 != null) {
                                    value14 = liveDataD0.getValue();
                                } else {
                                    value14 = null;
                                }
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                            } else {
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = false;
                            }
                            i = iSafeUnbox2;
                            boolean z11 = zSafeUnbox10;
                            str = value13;
                            z = z11;
                        } else {
                            value6 = value6;
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z12 = zSafeUnbox10;
                        str = value13;
                        z = z12;
                    } else {
                        zSafeUnbox7 = zSafeUnbox7;
                    }
                    if ((j & 343932928) != 0) {
                        if (runIndexVM != null) {
                            liveDataK = runIndexVM.K();
                        } else {
                            liveDataK = null;
                        }
                        updateLiveDataRegistration(23, liveDataK);
                        if (liveDataK != null) {
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z13 = zSafeUnbox10;
                        str = value13;
                        z = z13;
                    } else {
                        value6 = value6;
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z14 = zSafeUnbox10;
                    str = value13;
                    z = z14;
                } else {
                    value9 = value9;
                }
                if ((j & 335552512) != 0) {
                    if (runIndexVM != null) {
                        liveDataB0 = runIndexVM.b0();
                    } else {
                        liveDataB0 = null;
                    }
                    updateLiveDataRegistration(13, liveDataB0);
                    if (liveDataB0 != null) {
                        value23 = liveDataB0.getValue();
                    } else {
                        value23 = null;
                    }
                    zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                    zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                } else {
                    value3 = value3;
                    zSafeUnbox4 = false;
                    zSafeUnbox10 = false;
                }
                if ((j & 335560704) != 0) {
                    if (runIndexVM != null) {
                        mediatorLiveDataF0 = runIndexVM.f0();
                    } else {
                        mediatorLiveDataF0 = null;
                    }
                    updateLiveDataRegistration(14, mediatorLiveDataF0);
                    if (mediatorLiveDataF0 != null) {
                        value22 = mediatorLiveDataF0.getValue();
                    } else {
                        value22 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                } else {
                    zSafeUnbox4 = zSafeUnbox4;
                    zSafeUnbox6 = zSafeUnbox6;
                    zSafeUnbox = false;
                }
                if ((j & 335577088) != 0) {
                    if (runIndexVM != null) {
                        liveDataG = runIndexVM.G();
                    } else {
                        liveDataG = null;
                    }
                    updateLiveDataRegistration(15, liveDataG);
                    if (liveDataG != null) {
                        value21 = liveDataG.getValue();
                    } else {
                        value21 = null;
                    }
                    str2 = ("(" + value21) + ")";
                } else {
                    zSafeUnbox = zSafeUnbox;
                    str2 = null;
                }
                if ((j & 335609856) == 0) {
                    value4 = null;
                } else {
                    if (runIndexVM != null) {
                        liveDataJ = runIndexVM.J();
                    } else {
                        liveDataJ = null;
                    }
                    updateLiveDataRegistration(16, liveDataJ);
                    if (liveDataJ != null) {
                        value4 = liveDataJ.getValue();
                    } else {
                        value4 = null;
                    }
                }
                if ((j & 335675392) != 0) {
                    if (runIndexVM != null) {
                        mutableLiveDataM0 = runIndexVM.m0();
                    } else {
                        mutableLiveDataM0 = null;
                    }
                    updateLiveDataRegistration(17, mutableLiveDataM0);
                    if (mutableLiveDataM0 != null) {
                        value20 = mutableLiveDataM0.getValue();
                    } else {
                        value20 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                } else {
                    str2 = str2;
                    zSafeUnbox2 = false;
                }
                if ((j & 335806464) != 0) {
                    if (runIndexVM != null) {
                        liveDataP = runIndexVM.P();
                    } else {
                        liveDataP = null;
                    }
                    updateLiveDataRegistration(18, liveDataP);
                    if (liveDataP != null) {
                        value19 = liveDataP.getValue();
                    } else {
                        value19 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    iSafeUnbox2 = 0;
                }
                if ((j & 336068608) != 0) {
                    if (runIndexVM != null) {
                        liveDataL = runIndexVM.L();
                    } else {
                        liveDataL = null;
                    }
                    updateLiveDataRegistration(19, liveDataL);
                    if (liveDataL != null) {
                        value18 = liveDataL.getValue();
                    } else {
                        value18 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                } else {
                    iSafeUnbox2 = iSafeUnbox2;
                    iSafeUnbox = 0;
                }
                if ((j & 336592896) != 0) {
                    if (runIndexVM != null) {
                        liveDataC0 = runIndexVM.c0();
                    } else {
                        liveDataC0 = null;
                    }
                    updateLiveDataRegistration(20, liveDataC0);
                    if (liveDataC0 != null) {
                        value17 = liveDataC0.getValue();
                    } else {
                        value17 = null;
                    }
                    zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                } else {
                    iSafeUnbox = iSafeUnbox;
                    zSafeUnbox8 = false;
                }
                if ((j & 337641472) != 0) {
                    if (runIndexVM != null) {
                        liveDataG0 = runIndexVM.g0();
                    } else {
                        liveDataG0 = null;
                    }
                    updateLiveDataRegistration(21, liveDataG0);
                    if (liveDataG0 != null) {
                        value16 = liveDataG0.getValue();
                    } else {
                        value16 = null;
                    }
                    zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                } else {
                    zSafeUnbox8 = zSafeUnbox8;
                    zSafeUnbox7 = false;
                }
                if ((j & 339738624) != 0) {
                    if (runIndexVM != null) {
                        mutableLiveDataZ = runIndexVM.z();
                    } else {
                        mutableLiveDataZ = null;
                    }
                    updateLiveDataRegistration(22, mutableLiveDataZ);
                    if (mutableLiveDataZ != null) {
                    }
                    if ((j & 343932928) != 0) {
                        if (runIndexVM != null) {
                            liveDataK = runIndexVM.K();
                        } else {
                            liveDataK = null;
                        }
                        updateLiveDataRegistration(23, liveDataK);
                        if (liveDataK != null) {
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z15 = zSafeUnbox10;
                        str = value13;
                        z = z15;
                    } else {
                        value6 = value6;
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z16 = zSafeUnbox10;
                    str = value13;
                    z = z16;
                } else {
                    zSafeUnbox7 = zSafeUnbox7;
                }
                if ((j & 343932928) != 0) {
                    if (runIndexVM != null) {
                        liveDataK = runIndexVM.K();
                    } else {
                        liveDataK = null;
                    }
                    updateLiveDataRegistration(23, liveDataK);
                    if (liveDataK != null) {
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z17 = zSafeUnbox10;
                    str = value13;
                    z = z17;
                } else {
                    value6 = value6;
                }
                if ((j & 352321536) != 0) {
                    if (runIndexVM != null) {
                        liveDataZ = runIndexVM.Z();
                    } else {
                        liveDataZ = null;
                    }
                    updateLiveDataRegistration(24, liveDataZ);
                    if (liveDataZ != null) {
                        value15 = liveDataZ.getValue();
                    } else {
                        value15 = null;
                    }
                    zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                } else {
                    value2 = value2;
                    zSafeUnbox11 = false;
                    zSafeUnbox3 = false;
                }
                if ((j & 369098752) != 0) {
                    if (runIndexVM != null) {
                        liveDataD0 = runIndexVM.d0();
                    } else {
                        liveDataD0 = null;
                    }
                    updateLiveDataRegistration(25, liveDataD0);
                    if (liveDataD0 != null) {
                        value14 = liveDataD0.getValue();
                    } else {
                        value14 = null;
                    }
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                } else {
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = false;
                }
                i = iSafeUnbox2;
                boolean z18 = zSafeUnbox10;
                str = value13;
                z = z18;
            } else {
                value = value;
            }
            if ((j & 335546368) != 0) {
                if (runIndexVM != null) {
                    liveDataE = runIndexVM.E();
                } else {
                    liveDataE = null;
                }
                updateLiveDataRegistration(11, liveDataE);
                if (liveDataE != null) {
                }
                if ((j & 335548416) != 0) {
                    if (runIndexVM != null) {
                        mediatorLiveDataV = runIndexVM.V();
                    } else {
                        mediatorLiveDataV = null;
                    }
                    updateLiveDataRegistration(12, mediatorLiveDataV);
                    if (mediatorLiveDataV != null) {
                    }
                    if ((j & 335552512) != 0) {
                        if (runIndexVM != null) {
                            liveDataB0 = runIndexVM.b0();
                        } else {
                            liveDataB0 = null;
                        }
                        updateLiveDataRegistration(13, liveDataB0);
                        if (liveDataB0 != null) {
                            value23 = liveDataB0.getValue();
                        } else {
                            value23 = null;
                        }
                        zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                        zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                    } else {
                        value3 = value3;
                        zSafeUnbox4 = false;
                        zSafeUnbox10 = false;
                    }
                    if ((j & 335560704) != 0) {
                        if (runIndexVM != null) {
                            mediatorLiveDataF0 = runIndexVM.f0();
                        } else {
                            mediatorLiveDataF0 = null;
                        }
                        updateLiveDataRegistration(14, mediatorLiveDataF0);
                        if (mediatorLiveDataF0 != null) {
                            value22 = mediatorLiveDataF0.getValue();
                        } else {
                            value22 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                    } else {
                        zSafeUnbox4 = zSafeUnbox4;
                        zSafeUnbox6 = zSafeUnbox6;
                        zSafeUnbox = false;
                    }
                    if ((j & 335577088) != 0) {
                        if (runIndexVM != null) {
                            liveDataG = runIndexVM.G();
                        } else {
                            liveDataG = null;
                        }
                        updateLiveDataRegistration(15, liveDataG);
                        if (liveDataG != null) {
                            value21 = liveDataG.getValue();
                        } else {
                            value21 = null;
                        }
                        str2 = ("(" + value21) + ")";
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        str2 = null;
                    }
                    if ((j & 335609856) == 0) {
                        value4 = null;
                    } else {
                        if (runIndexVM != null) {
                            liveDataJ = runIndexVM.J();
                        } else {
                            liveDataJ = null;
                        }
                        updateLiveDataRegistration(16, liveDataJ);
                        if (liveDataJ != null) {
                            value4 = liveDataJ.getValue();
                        } else {
                            value4 = null;
                        }
                    }
                    if ((j & 335675392) != 0) {
                        if (runIndexVM != null) {
                            mutableLiveDataM0 = runIndexVM.m0();
                        } else {
                            mutableLiveDataM0 = null;
                        }
                        updateLiveDataRegistration(17, mutableLiveDataM0);
                        if (mutableLiveDataM0 != null) {
                            value20 = mutableLiveDataM0.getValue();
                        } else {
                            value20 = null;
                        }
                        zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                    } else {
                        str2 = str2;
                        zSafeUnbox2 = false;
                    }
                    if ((j & 335806464) != 0) {
                        if (runIndexVM != null) {
                            liveDataP = runIndexVM.P();
                        } else {
                            liveDataP = null;
                        }
                        updateLiveDataRegistration(18, liveDataP);
                        if (liveDataP != null) {
                            value19 = liveDataP.getValue();
                        } else {
                            value19 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                    } else {
                        zSafeUnbox2 = zSafeUnbox2;
                        iSafeUnbox2 = 0;
                    }
                    if ((j & 336068608) != 0) {
                        if (runIndexVM != null) {
                            liveDataL = runIndexVM.L();
                        } else {
                            liveDataL = null;
                        }
                        updateLiveDataRegistration(19, liveDataL);
                        if (liveDataL != null) {
                            value18 = liveDataL.getValue();
                        } else {
                            value18 = null;
                        }
                        iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                    } else {
                        iSafeUnbox2 = iSafeUnbox2;
                        iSafeUnbox = 0;
                    }
                    if ((j & 336592896) != 0) {
                        if (runIndexVM != null) {
                            liveDataC0 = runIndexVM.c0();
                        } else {
                            liveDataC0 = null;
                        }
                        updateLiveDataRegistration(20, liveDataC0);
                        if (liveDataC0 != null) {
                            value17 = liveDataC0.getValue();
                        } else {
                            value17 = null;
                        }
                        zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                    } else {
                        iSafeUnbox = iSafeUnbox;
                        zSafeUnbox8 = false;
                    }
                    if ((j & 337641472) != 0) {
                        if (runIndexVM != null) {
                            liveDataG0 = runIndexVM.g0();
                        } else {
                            liveDataG0 = null;
                        }
                        updateLiveDataRegistration(21, liveDataG0);
                        if (liveDataG0 != null) {
                            value16 = liveDataG0.getValue();
                        } else {
                            value16 = null;
                        }
                        zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                    } else {
                        zSafeUnbox8 = zSafeUnbox8;
                        zSafeUnbox7 = false;
                    }
                    if ((j & 339738624) != 0) {
                        if (runIndexVM != null) {
                            mutableLiveDataZ = runIndexVM.z();
                        } else {
                            mutableLiveDataZ = null;
                        }
                        updateLiveDataRegistration(22, mutableLiveDataZ);
                        if (mutableLiveDataZ != null) {
                        }
                        if ((j & 343932928) != 0) {
                            if (runIndexVM != null) {
                                liveDataK = runIndexVM.K();
                            } else {
                                liveDataK = null;
                            }
                            updateLiveDataRegistration(23, liveDataK);
                            if (liveDataK != null) {
                            }
                            if ((j & 352321536) != 0) {
                                if (runIndexVM != null) {
                                    liveDataZ = runIndexVM.Z();
                                } else {
                                    liveDataZ = null;
                                }
                                updateLiveDataRegistration(24, liveDataZ);
                                if (liveDataZ != null) {
                                    value15 = liveDataZ.getValue();
                                } else {
                                    value15 = null;
                                }
                                zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                            } else {
                                value2 = value2;
                                zSafeUnbox11 = false;
                                zSafeUnbox3 = false;
                            }
                            if ((j & 369098752) != 0) {
                                if (runIndexVM != null) {
                                    liveDataD0 = runIndexVM.d0();
                                } else {
                                    liveDataD0 = null;
                                }
                                updateLiveDataRegistration(25, liveDataD0);
                                if (liveDataD0 != null) {
                                    value14 = liveDataD0.getValue();
                                } else {
                                    value14 = null;
                                }
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                            } else {
                                z2 = zSafeUnbox11;
                                zSafeUnbox5 = false;
                            }
                            i = iSafeUnbox2;
                            boolean z19 = zSafeUnbox10;
                            str = value13;
                            z = z19;
                        } else {
                            value6 = value6;
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z110 = zSafeUnbox10;
                        str = value13;
                        z = z110;
                    } else {
                        zSafeUnbox7 = zSafeUnbox7;
                    }
                    if ((j & 343932928) != 0) {
                        if (runIndexVM != null) {
                            liveDataK = runIndexVM.K();
                        } else {
                            liveDataK = null;
                        }
                        updateLiveDataRegistration(23, liveDataK);
                        if (liveDataK != null) {
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z111 = zSafeUnbox10;
                        str = value13;
                        z = z111;
                    } else {
                        value6 = value6;
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z112 = zSafeUnbox10;
                    str = value13;
                    z = z112;
                } else {
                    value9 = value9;
                }
                if ((j & 335552512) != 0) {
                    if (runIndexVM != null) {
                        liveDataB0 = runIndexVM.b0();
                    } else {
                        liveDataB0 = null;
                    }
                    updateLiveDataRegistration(13, liveDataB0);
                    if (liveDataB0 != null) {
                        value23 = liveDataB0.getValue();
                    } else {
                        value23 = null;
                    }
                    zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                    zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                } else {
                    value3 = value3;
                    zSafeUnbox4 = false;
                    zSafeUnbox10 = false;
                }
                if ((j & 335560704) != 0) {
                    if (runIndexVM != null) {
                        mediatorLiveDataF0 = runIndexVM.f0();
                    } else {
                        mediatorLiveDataF0 = null;
                    }
                    updateLiveDataRegistration(14, mediatorLiveDataF0);
                    if (mediatorLiveDataF0 != null) {
                        value22 = mediatorLiveDataF0.getValue();
                    } else {
                        value22 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                } else {
                    zSafeUnbox4 = zSafeUnbox4;
                    zSafeUnbox6 = zSafeUnbox6;
                    zSafeUnbox = false;
                }
                if ((j & 335577088) != 0) {
                    if (runIndexVM != null) {
                        liveDataG = runIndexVM.G();
                    } else {
                        liveDataG = null;
                    }
                    updateLiveDataRegistration(15, liveDataG);
                    if (liveDataG != null) {
                        value21 = liveDataG.getValue();
                    } else {
                        value21 = null;
                    }
                    str2 = ("(" + value21) + ")";
                } else {
                    zSafeUnbox = zSafeUnbox;
                    str2 = null;
                }
                if ((j & 335609856) == 0) {
                    value4 = null;
                } else {
                    if (runIndexVM != null) {
                        liveDataJ = runIndexVM.J();
                    } else {
                        liveDataJ = null;
                    }
                    updateLiveDataRegistration(16, liveDataJ);
                    if (liveDataJ != null) {
                        value4 = liveDataJ.getValue();
                    } else {
                        value4 = null;
                    }
                }
                if ((j & 335675392) != 0) {
                    if (runIndexVM != null) {
                        mutableLiveDataM0 = runIndexVM.m0();
                    } else {
                        mutableLiveDataM0 = null;
                    }
                    updateLiveDataRegistration(17, mutableLiveDataM0);
                    if (mutableLiveDataM0 != null) {
                        value20 = mutableLiveDataM0.getValue();
                    } else {
                        value20 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                } else {
                    str2 = str2;
                    zSafeUnbox2 = false;
                }
                if ((j & 335806464) != 0) {
                    if (runIndexVM != null) {
                        liveDataP = runIndexVM.P();
                    } else {
                        liveDataP = null;
                    }
                    updateLiveDataRegistration(18, liveDataP);
                    if (liveDataP != null) {
                        value19 = liveDataP.getValue();
                    } else {
                        value19 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    iSafeUnbox2 = 0;
                }
                if ((j & 336068608) != 0) {
                    if (runIndexVM != null) {
                        liveDataL = runIndexVM.L();
                    } else {
                        liveDataL = null;
                    }
                    updateLiveDataRegistration(19, liveDataL);
                    if (liveDataL != null) {
                        value18 = liveDataL.getValue();
                    } else {
                        value18 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                } else {
                    iSafeUnbox2 = iSafeUnbox2;
                    iSafeUnbox = 0;
                }
                if ((j & 336592896) != 0) {
                    if (runIndexVM != null) {
                        liveDataC0 = runIndexVM.c0();
                    } else {
                        liveDataC0 = null;
                    }
                    updateLiveDataRegistration(20, liveDataC0);
                    if (liveDataC0 != null) {
                        value17 = liveDataC0.getValue();
                    } else {
                        value17 = null;
                    }
                    zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                } else {
                    iSafeUnbox = iSafeUnbox;
                    zSafeUnbox8 = false;
                }
                if ((j & 337641472) != 0) {
                    if (runIndexVM != null) {
                        liveDataG0 = runIndexVM.g0();
                    } else {
                        liveDataG0 = null;
                    }
                    updateLiveDataRegistration(21, liveDataG0);
                    if (liveDataG0 != null) {
                        value16 = liveDataG0.getValue();
                    } else {
                        value16 = null;
                    }
                    zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                } else {
                    zSafeUnbox8 = zSafeUnbox8;
                    zSafeUnbox7 = false;
                }
                if ((j & 339738624) != 0) {
                    if (runIndexVM != null) {
                        mutableLiveDataZ = runIndexVM.z();
                    } else {
                        mutableLiveDataZ = null;
                    }
                    updateLiveDataRegistration(22, mutableLiveDataZ);
                    if (mutableLiveDataZ != null) {
                    }
                    if ((j & 343932928) != 0) {
                        if (runIndexVM != null) {
                            liveDataK = runIndexVM.K();
                        } else {
                            liveDataK = null;
                        }
                        updateLiveDataRegistration(23, liveDataK);
                        if (liveDataK != null) {
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z113 = zSafeUnbox10;
                        str = value13;
                        z = z113;
                    } else {
                        value6 = value6;
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z114 = zSafeUnbox10;
                    str = value13;
                    z = z114;
                } else {
                    zSafeUnbox7 = zSafeUnbox7;
                }
                if ((j & 343932928) != 0) {
                    if (runIndexVM != null) {
                        liveDataK = runIndexVM.K();
                    } else {
                        liveDataK = null;
                    }
                    updateLiveDataRegistration(23, liveDataK);
                    if (liveDataK != null) {
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z115 = zSafeUnbox10;
                    str = value13;
                    z = z115;
                } else {
                    value6 = value6;
                }
                if ((j & 352321536) != 0) {
                    if (runIndexVM != null) {
                        liveDataZ = runIndexVM.Z();
                    } else {
                        liveDataZ = null;
                    }
                    updateLiveDataRegistration(24, liveDataZ);
                    if (liveDataZ != null) {
                        value15 = liveDataZ.getValue();
                    } else {
                        value15 = null;
                    }
                    zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                } else {
                    value2 = value2;
                    zSafeUnbox11 = false;
                    zSafeUnbox3 = false;
                }
                if ((j & 369098752) != 0) {
                    if (runIndexVM != null) {
                        liveDataD0 = runIndexVM.d0();
                    } else {
                        liveDataD0 = null;
                    }
                    updateLiveDataRegistration(25, liveDataD0);
                    if (liveDataD0 != null) {
                        value14 = liveDataD0.getValue();
                    } else {
                        value14 = null;
                    }
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                } else {
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = false;
                }
                i = iSafeUnbox2;
                boolean z116 = zSafeUnbox10;
                str = value13;
                z = z116;
            } else {
                value5 = value5;
            }
            if ((j & 335548416) != 0) {
                if (runIndexVM != null) {
                    mediatorLiveDataV = runIndexVM.V();
                } else {
                    mediatorLiveDataV = null;
                }
                updateLiveDataRegistration(12, mediatorLiveDataV);
                if (mediatorLiveDataV != null) {
                }
                if ((j & 335552512) != 0) {
                    if (runIndexVM != null) {
                        liveDataB0 = runIndexVM.b0();
                    } else {
                        liveDataB0 = null;
                    }
                    updateLiveDataRegistration(13, liveDataB0);
                    if (liveDataB0 != null) {
                        value23 = liveDataB0.getValue();
                    } else {
                        value23 = null;
                    }
                    zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                    zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                } else {
                    value3 = value3;
                    zSafeUnbox4 = false;
                    zSafeUnbox10 = false;
                }
                if ((j & 335560704) != 0) {
                    if (runIndexVM != null) {
                        mediatorLiveDataF0 = runIndexVM.f0();
                    } else {
                        mediatorLiveDataF0 = null;
                    }
                    updateLiveDataRegistration(14, mediatorLiveDataF0);
                    if (mediatorLiveDataF0 != null) {
                        value22 = mediatorLiveDataF0.getValue();
                    } else {
                        value22 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value22);
                } else {
                    zSafeUnbox4 = zSafeUnbox4;
                    zSafeUnbox6 = zSafeUnbox6;
                    zSafeUnbox = false;
                }
                if ((j & 335577088) != 0) {
                    if (runIndexVM != null) {
                        liveDataG = runIndexVM.G();
                    } else {
                        liveDataG = null;
                    }
                    updateLiveDataRegistration(15, liveDataG);
                    if (liveDataG != null) {
                        value21 = liveDataG.getValue();
                    } else {
                        value21 = null;
                    }
                    str2 = ("(" + value21) + ")";
                } else {
                    zSafeUnbox = zSafeUnbox;
                    str2 = null;
                }
                if ((j & 335609856) == 0) {
                    value4 = null;
                } else {
                    if (runIndexVM != null) {
                        liveDataJ = runIndexVM.J();
                    } else {
                        liveDataJ = null;
                    }
                    updateLiveDataRegistration(16, liveDataJ);
                    if (liveDataJ != null) {
                        value4 = liveDataJ.getValue();
                    } else {
                        value4 = null;
                    }
                }
                if ((j & 335675392) != 0) {
                    if (runIndexVM != null) {
                        mutableLiveDataM0 = runIndexVM.m0();
                    } else {
                        mutableLiveDataM0 = null;
                    }
                    updateLiveDataRegistration(17, mutableLiveDataM0);
                    if (mutableLiveDataM0 != null) {
                        value20 = mutableLiveDataM0.getValue();
                    } else {
                        value20 = null;
                    }
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
                } else {
                    str2 = str2;
                    zSafeUnbox2 = false;
                }
                if ((j & 335806464) != 0) {
                    if (runIndexVM != null) {
                        liveDataP = runIndexVM.P();
                    } else {
                        liveDataP = null;
                    }
                    updateLiveDataRegistration(18, liveDataP);
                    if (liveDataP != null) {
                        value19 = liveDataP.getValue();
                    } else {
                        value19 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
                } else {
                    zSafeUnbox2 = zSafeUnbox2;
                    iSafeUnbox2 = 0;
                }
                if ((j & 336068608) != 0) {
                    if (runIndexVM != null) {
                        liveDataL = runIndexVM.L();
                    } else {
                        liveDataL = null;
                    }
                    updateLiveDataRegistration(19, liveDataL);
                    if (liveDataL != null) {
                        value18 = liveDataL.getValue();
                    } else {
                        value18 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(value18);
                } else {
                    iSafeUnbox2 = iSafeUnbox2;
                    iSafeUnbox = 0;
                }
                if ((j & 336592896) != 0) {
                    if (runIndexVM != null) {
                        liveDataC0 = runIndexVM.c0();
                    } else {
                        liveDataC0 = null;
                    }
                    updateLiveDataRegistration(20, liveDataC0);
                    if (liveDataC0 != null) {
                        value17 = liveDataC0.getValue();
                    } else {
                        value17 = null;
                    }
                    zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
                } else {
                    iSafeUnbox = iSafeUnbox;
                    zSafeUnbox8 = false;
                }
                if ((j & 337641472) != 0) {
                    if (runIndexVM != null) {
                        liveDataG0 = runIndexVM.g0();
                    } else {
                        liveDataG0 = null;
                    }
                    updateLiveDataRegistration(21, liveDataG0);
                    if (liveDataG0 != null) {
                        value16 = liveDataG0.getValue();
                    } else {
                        value16 = null;
                    }
                    zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
                } else {
                    zSafeUnbox8 = zSafeUnbox8;
                    zSafeUnbox7 = false;
                }
                if ((j & 339738624) != 0) {
                    if (runIndexVM != null) {
                        mutableLiveDataZ = runIndexVM.z();
                    } else {
                        mutableLiveDataZ = null;
                    }
                    updateLiveDataRegistration(22, mutableLiveDataZ);
                    if (mutableLiveDataZ != null) {
                    }
                    if ((j & 343932928) != 0) {
                        if (runIndexVM != null) {
                            liveDataK = runIndexVM.K();
                        } else {
                            liveDataK = null;
                        }
                        updateLiveDataRegistration(23, liveDataK);
                        if (liveDataK != null) {
                        }
                        if ((j & 352321536) != 0) {
                            if (runIndexVM != null) {
                                liveDataZ = runIndexVM.Z();
                            } else {
                                liveDataZ = null;
                            }
                            updateLiveDataRegistration(24, liveDataZ);
                            if (liveDataZ != null) {
                                value15 = liveDataZ.getValue();
                            } else {
                                value15 = null;
                            }
                            zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                            zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                        } else {
                            value2 = value2;
                            zSafeUnbox11 = false;
                            zSafeUnbox3 = false;
                        }
                        if ((j & 369098752) != 0) {
                            if (runIndexVM != null) {
                                liveDataD0 = runIndexVM.d0();
                            } else {
                                liveDataD0 = null;
                            }
                            updateLiveDataRegistration(25, liveDataD0);
                            if (liveDataD0 != null) {
                                value14 = liveDataD0.getValue();
                            } else {
                                value14 = null;
                            }
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                        } else {
                            z2 = zSafeUnbox11;
                            zSafeUnbox5 = false;
                        }
                        i = iSafeUnbox2;
                        boolean z117 = zSafeUnbox10;
                        str = value13;
                        z = z117;
                    } else {
                        value6 = value6;
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z118 = zSafeUnbox10;
                    str = value13;
                    z = z118;
                } else {
                    zSafeUnbox7 = zSafeUnbox7;
                }
                if ((j & 343932928) != 0) {
                    if (runIndexVM != null) {
                        liveDataK = runIndexVM.K();
                    } else {
                        liveDataK = null;
                    }
                    updateLiveDataRegistration(23, liveDataK);
                    if (liveDataK != null) {
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z119 = zSafeUnbox10;
                    str = value13;
                    z = z119;
                } else {
                    value6 = value6;
                }
                if ((j & 352321536) != 0) {
                    if (runIndexVM != null) {
                        liveDataZ = runIndexVM.Z();
                    } else {
                        liveDataZ = null;
                    }
                    updateLiveDataRegistration(24, liveDataZ);
                    if (liveDataZ != null) {
                        value15 = liveDataZ.getValue();
                    } else {
                        value15 = null;
                    }
                    zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                } else {
                    value2 = value2;
                    zSafeUnbox11 = false;
                    zSafeUnbox3 = false;
                }
                if ((j & 369098752) != 0) {
                    if (runIndexVM != null) {
                        liveDataD0 = runIndexVM.d0();
                    } else {
                        liveDataD0 = null;
                    }
                    updateLiveDataRegistration(25, liveDataD0);
                    if (liveDataD0 != null) {
                        value14 = liveDataD0.getValue();
                    } else {
                        value14 = null;
                    }
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                } else {
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = false;
                }
                i = iSafeUnbox2;
                boolean z1110 = zSafeUnbox10;
                str = value13;
                z = z1110;
            } else {
                value9 = value9;
            }
            if ((j & 335552512) != 0) {
                if (runIndexVM != null) {
                    liveDataB0 = runIndexVM.b0();
                } else {
                    liveDataB0 = null;
                }
                updateLiveDataRegistration(13, liveDataB0);
                if (liveDataB0 != null) {
                    value23 = liveDataB0.getValue();
                } else {
                    value23 = null;
                }
                zSafeUnbox4 = ViewDataBinding.safeUnbox(value23);
                zSafeUnbox10 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
            } else {
                value3 = value3;
                zSafeUnbox4 = false;
                zSafeUnbox10 = false;
            }
            if ((j & 335560704) != 0) {
                if (runIndexVM != null) {
                    mediatorLiveDataF0 = runIndexVM.f0();
                } else {
                    mediatorLiveDataF0 = null;
                }
                updateLiveDataRegistration(14, mediatorLiveDataF0);
                if (mediatorLiveDataF0 != null) {
                    value22 = mediatorLiveDataF0.getValue();
                } else {
                    value22 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(value22);
            } else {
                zSafeUnbox4 = zSafeUnbox4;
                zSafeUnbox6 = zSafeUnbox6;
                zSafeUnbox = false;
            }
            if ((j & 335577088) != 0) {
                if (runIndexVM != null) {
                    liveDataG = runIndexVM.G();
                } else {
                    liveDataG = null;
                }
                updateLiveDataRegistration(15, liveDataG);
                if (liveDataG != null) {
                    value21 = liveDataG.getValue();
                } else {
                    value21 = null;
                }
                str2 = ("(" + value21) + ")";
            } else {
                zSafeUnbox = zSafeUnbox;
                str2 = null;
            }
            if ((j & 335609856) == 0) {
                value4 = null;
            } else {
                if (runIndexVM != null) {
                    liveDataJ = runIndexVM.J();
                } else {
                    liveDataJ = null;
                }
                updateLiveDataRegistration(16, liveDataJ);
                if (liveDataJ != null) {
                    value4 = liveDataJ.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 335675392) != 0) {
                if (runIndexVM != null) {
                    mutableLiveDataM0 = runIndexVM.m0();
                } else {
                    mutableLiveDataM0 = null;
                }
                updateLiveDataRegistration(17, mutableLiveDataM0);
                if (mutableLiveDataM0 != null) {
                    value20 = mutableLiveDataM0.getValue();
                } else {
                    value20 = null;
                }
                zSafeUnbox2 = ViewDataBinding.safeUnbox(value20);
            } else {
                str2 = str2;
                zSafeUnbox2 = false;
            }
            if ((j & 335806464) != 0) {
                if (runIndexVM != null) {
                    liveDataP = runIndexVM.P();
                } else {
                    liveDataP = null;
                }
                updateLiveDataRegistration(18, liveDataP);
                if (liveDataP != null) {
                    value19 = liveDataP.getValue();
                } else {
                    value19 = null;
                }
                iSafeUnbox2 = ViewDataBinding.safeUnbox(value19);
            } else {
                zSafeUnbox2 = zSafeUnbox2;
                iSafeUnbox2 = 0;
            }
            if ((j & 336068608) != 0) {
                if (runIndexVM != null) {
                    liveDataL = runIndexVM.L();
                } else {
                    liveDataL = null;
                }
                updateLiveDataRegistration(19, liveDataL);
                if (liveDataL != null) {
                    value18 = liveDataL.getValue();
                } else {
                    value18 = null;
                }
                iSafeUnbox = ViewDataBinding.safeUnbox(value18);
            } else {
                iSafeUnbox2 = iSafeUnbox2;
                iSafeUnbox = 0;
            }
            if ((j & 336592896) != 0) {
                if (runIndexVM != null) {
                    liveDataC0 = runIndexVM.c0();
                } else {
                    liveDataC0 = null;
                }
                updateLiveDataRegistration(20, liveDataC0);
                if (liveDataC0 != null) {
                    value17 = liveDataC0.getValue();
                } else {
                    value17 = null;
                }
                zSafeUnbox8 = ViewDataBinding.safeUnbox(value17);
            } else {
                iSafeUnbox = iSafeUnbox;
                zSafeUnbox8 = false;
            }
            if ((j & 337641472) != 0) {
                if (runIndexVM != null) {
                    liveDataG0 = runIndexVM.g0();
                } else {
                    liveDataG0 = null;
                }
                updateLiveDataRegistration(21, liveDataG0);
                if (liveDataG0 != null) {
                    value16 = liveDataG0.getValue();
                } else {
                    value16 = null;
                }
                zSafeUnbox7 = ViewDataBinding.safeUnbox(value16);
            } else {
                zSafeUnbox8 = zSafeUnbox8;
                zSafeUnbox7 = false;
            }
            if ((j & 339738624) != 0) {
                if (runIndexVM != null) {
                    mutableLiveDataZ = runIndexVM.z();
                } else {
                    mutableLiveDataZ = null;
                }
                updateLiveDataRegistration(22, mutableLiveDataZ);
                if (mutableLiveDataZ != null) {
                }
                if ((j & 343932928) != 0) {
                    if (runIndexVM != null) {
                        liveDataK = runIndexVM.K();
                    } else {
                        liveDataK = null;
                    }
                    updateLiveDataRegistration(23, liveDataK);
                    if (liveDataK != null) {
                    }
                    if ((j & 352321536) != 0) {
                        if (runIndexVM != null) {
                            liveDataZ = runIndexVM.Z();
                        } else {
                            liveDataZ = null;
                        }
                        updateLiveDataRegistration(24, liveDataZ);
                        if (liveDataZ != null) {
                            value15 = liveDataZ.getValue();
                        } else {
                            value15 = null;
                        }
                        zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                        zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                    } else {
                        value2 = value2;
                        zSafeUnbox11 = false;
                        zSafeUnbox3 = false;
                    }
                    if ((j & 369098752) != 0) {
                        if (runIndexVM != null) {
                            liveDataD0 = runIndexVM.d0();
                        } else {
                            liveDataD0 = null;
                        }
                        updateLiveDataRegistration(25, liveDataD0);
                        if (liveDataD0 != null) {
                            value14 = liveDataD0.getValue();
                        } else {
                            value14 = null;
                        }
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                    } else {
                        z2 = zSafeUnbox11;
                        zSafeUnbox5 = false;
                    }
                    i = iSafeUnbox2;
                    boolean z1111 = zSafeUnbox10;
                    str = value13;
                    z = z1111;
                } else {
                    value6 = value6;
                }
                if ((j & 352321536) != 0) {
                    if (runIndexVM != null) {
                        liveDataZ = runIndexVM.Z();
                    } else {
                        liveDataZ = null;
                    }
                    updateLiveDataRegistration(24, liveDataZ);
                    if (liveDataZ != null) {
                        value15 = liveDataZ.getValue();
                    } else {
                        value15 = null;
                    }
                    zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                } else {
                    value2 = value2;
                    zSafeUnbox11 = false;
                    zSafeUnbox3 = false;
                }
                if ((j & 369098752) != 0) {
                    if (runIndexVM != null) {
                        liveDataD0 = runIndexVM.d0();
                    } else {
                        liveDataD0 = null;
                    }
                    updateLiveDataRegistration(25, liveDataD0);
                    if (liveDataD0 != null) {
                        value14 = liveDataD0.getValue();
                    } else {
                        value14 = null;
                    }
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                } else {
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = false;
                }
                i = iSafeUnbox2;
                boolean z1112 = zSafeUnbox10;
                str = value13;
                z = z1112;
            } else {
                zSafeUnbox7 = zSafeUnbox7;
            }
            if ((j & 343932928) != 0) {
                if (runIndexVM != null) {
                    liveDataK = runIndexVM.K();
                } else {
                    liveDataK = null;
                }
                updateLiveDataRegistration(23, liveDataK);
                if (liveDataK != null) {
                }
                if ((j & 352321536) != 0) {
                    if (runIndexVM != null) {
                        liveDataZ = runIndexVM.Z();
                    } else {
                        liveDataZ = null;
                    }
                    updateLiveDataRegistration(24, liveDataZ);
                    if (liveDataZ != null) {
                        value15 = liveDataZ.getValue();
                    } else {
                        value15 = null;
                    }
                    zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                    zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
                } else {
                    value2 = value2;
                    zSafeUnbox11 = false;
                    zSafeUnbox3 = false;
                }
                if ((j & 369098752) != 0) {
                    if (runIndexVM != null) {
                        liveDataD0 = runIndexVM.d0();
                    } else {
                        liveDataD0 = null;
                    }
                    updateLiveDataRegistration(25, liveDataD0);
                    if (liveDataD0 != null) {
                        value14 = liveDataD0.getValue();
                    } else {
                        value14 = null;
                    }
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
                } else {
                    z2 = zSafeUnbox11;
                    zSafeUnbox5 = false;
                }
                i = iSafeUnbox2;
                boolean z1113 = zSafeUnbox10;
                str = value13;
                z = z1113;
            } else {
                value6 = value6;
            }
            if ((j & 352321536) != 0) {
                if (runIndexVM != null) {
                    liveDataZ = runIndexVM.Z();
                } else {
                    liveDataZ = null;
                }
                updateLiveDataRegistration(24, liveDataZ);
                if (liveDataZ != null) {
                    value15 = liveDataZ.getValue();
                } else {
                    value15 = null;
                }
                zSafeUnbox11 = ViewDataBinding.safeUnbox(value15);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox11));
            } else {
                value2 = value2;
                zSafeUnbox11 = false;
                zSafeUnbox3 = false;
            }
            if ((j & 369098752) != 0) {
                if (runIndexVM != null) {
                    liveDataD0 = runIndexVM.d0();
                } else {
                    liveDataD0 = null;
                }
                updateLiveDataRegistration(25, liveDataD0);
                if (liveDataD0 != null) {
                    value14 = liveDataD0.getValue();
                } else {
                    value14 = null;
                }
                z2 = zSafeUnbox11;
                zSafeUnbox5 = ViewDataBinding.safeUnbox(value14);
            } else {
                z2 = zSafeUnbox11;
                zSafeUnbox5 = false;
            }
            i = iSafeUnbox2;
            boolean z1114 = zSafeUnbox10;
            str = value13;
            z = z1114;
        } else {
            value = null;
            value2 = null;
            zSafeUnbox = false;
            i = 0;
            zSafeUnbox2 = false;
            zSafeUnbox3 = false;
            z = false;
            zSafeUnbox4 = false;
            z2 = false;
            iSafeUnbox = 0;
            zSafeUnbox5 = false;
            str = null;
            value3 = null;
            value4 = null;
            value5 = null;
            value6 = null;
            value7 = null;
            value8 = null;
            value9 = null;
            value10 = null;
            str2 = null;
            zSafeUnbox6 = false;
            zSafeUnbox7 = false;
            zSafeUnbox8 = false;
            zSafeUnbox9 = false;
            value11 = null;
            value12 = null;
            str3 = null;
        }
        long j2 = j & 402653184;
        if (j2 == 0 || aVar2 == null) {
            dVar = null;
            aVar = null;
            bVar = null;
            eVar = null;
            cVar = null;
        } else {
            e eVar2 = this.f12082a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f12082a = eVar2;
            }
            e eVarA = eVar2.a(aVar2);
            a aVar3 = this.f12078a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f12078a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f12079a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f12079a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar2 = this.f12080a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f12080a = cVar2;
            }
            c cVarA = cVar2.a(aVar2);
            d dVar2 = this.f12081a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f12081a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            bVar = bVarA;
            eVar = eVarA;
            cVar = cVarA;
            dVar = dVarA;
            aVar = aVarA;
        }
        if ((j & 335675392) != 0) {
            CommonBindingAdapter.l0(((RunLayoutIndexHeaderBinding) this).f12061a, zSafeUnbox2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((RunLayoutIndexHeaderBinding) this).f12061a, aVar, null);
            CommonBindingAdapter.q(this.f12083b, bVar, null);
            CommonBindingAdapter.q(this.f12084c, cVar, null);
            CommonBindingAdapter.q(this.f12087e, dVar, null);
            CommonBindingAdapter.q(((RunLayoutIndexHeaderBinding) this).f12071b, eVar, null);
        }
        if ((j & 336068608) != 0) {
            ((RunLayoutIndexHeaderBinding) this).f12065a.setProgress(iSafeUnbox);
        }
        if ((j & 343932928) != 0) {
            TextViewBindingAdapter.setText(this.f12086d, value2);
        }
        if ((j & 335552512) != 0) {
            CommonBindingAdapter.l0(this.f12086d, z);
            CommonBindingAdapter.l0(this.s, zSafeUnbox4);
            CommonBindingAdapter.l0(this.t, z);
        }
        if ((j & 335806464) != 0) {
            CommonBindingAdapter.a0(this.c, i);
        }
        if ((j & 335544322) != 0) {
            TextViewBindingAdapter.setText(this.f12088e, str);
        }
        if ((j & 352321536) != 0) {
            boolean z20 = z2;
            CommonBindingAdapter.l0(this.d, z20);
            CommonBindingAdapter.l0(this.e, zSafeUnbox3);
            CommonBindingAdapter.l0(this.f12075a, z20);
            CommonBindingAdapter.l0(this.f12084c, z20);
        }
        if ((335544576 & j) != 0) {
            TextViewBindingAdapter.setText(this.f, value);
        }
        if ((369098752 & j) != 0) {
            CommonBindingAdapter.l0(this.f, zSafeUnbox5);
        }
        if ((335560704 & j) != 0) {
            CommonBindingAdapter.l0(this.g, zSafeUnbox);
        }
        if ((j & 335544352) != 0) {
            TextViewBindingAdapter.setText(this.h, value12);
        }
        if ((335544832 & j) != 0) {
            boolean z21 = zSafeUnbox6;
            CommonBindingAdapter.l0(this.h, z21);
            CommonBindingAdapter.l0(this.n, z21);
        }
        if ((335577088 & j) != 0) {
            TextViewBindingAdapter.setText(this.i, str2);
        }
        if ((j & 335544321) != 0) {
            TextViewBindingAdapter.setText(this.j, value10);
        }
        if ((335546368 & j) != 0) {
            TextViewBindingAdapter.setText(this.k, value9);
        }
        if ((337641472 & j) != 0) {
            boolean z22 = zSafeUnbox7;
            CommonBindingAdapter.l0(this.b, z22);
            CommonBindingAdapter.l0(this.f12085d, z22);
        }
        if ((j & 335544328) != 0) {
            TextViewBindingAdapter.setText(this.l, value8);
        }
        if ((j & 335544324) != 0) {
            TextViewBindingAdapter.setText(this.m, value7);
        }
        if ((339738624 & j) != 0) {
            TextViewBindingAdapter.setText(this.o, value6);
        }
        if ((335545344 & j) != 0) {
            TextViewBindingAdapter.setText(this.p, value5);
        }
        if ((336592896 & j) != 0) {
            boolean z23 = zSafeUnbox8;
            CommonBindingAdapter.l0(this.p, z23);
            CommonBindingAdapter.l0(this.q, z23);
        }
        if ((335609856 & j) != 0) {
            TextViewBindingAdapter.setText(this.r, value4);
        }
        if ((j & 335544336) != 0) {
            TextViewBindingAdapter.setText(this.f12077a, value11);
        }
        if ((335548416 & j) != 0) {
            TextViewBindingAdapter.setText(((RunLayoutIndexHeaderBinding) this).f12068b, value3);
        }
        if ((j & 335544384) != 0) {
            TextViewBindingAdapter.setText(((RunLayoutIndexHeaderBinding) this).c, str3);
        }
        if ((j & 335544448) != 0) {
            CommonBindingAdapter.l0(((RunLayoutIndexHeaderBinding) this).f12071b, zSafeUnbox9);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12074a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12074a = 268435456L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutIndexHeaderBinding
    public void l(@Nullable RunIndexActivity.a Click) {
        ((RunLayoutIndexHeaderBinding) this).f12063a = Click;
        synchronized (this) {
            this.f12074a |= 134217728;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutIndexHeaderBinding
    public void m(@Nullable RunIndexVM Vm) {
        ((RunLayoutIndexHeaderBinding) this).f12064a = Vm;
        synchronized (this) {
            this.f12074a |= 67108864;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> VmActivityRunBannerText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        return true;
    }

    public final boolean o(LiveData<SpannableStringBuilder> VmAwardValue, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return q((LiveData) object, fieldId);
            case 1:
                return B((MediatorLiveData) object, fieldId);
            case 2:
                return o((LiveData) object, fieldId);
            case 3:
                return C((LiveData) object, fieldId);
            case 4:
                return t((LiveData) object, fieldId);
            case 5:
                return s((LiveData) object, fieldId);
            case 6:
                return M((MutableLiveData) object, fieldId);
            case 7:
                return L((MediatorLiveData) object, fieldId);
            case 8:
                return z((MediatorLiveData) object, fieldId);
            case 9:
                return F((LiveData) object, fieldId);
            case 10:
                return x((LiveData) object, fieldId);
            case 11:
                return p((LiveData) object, fieldId);
            case 12:
                return D((MediatorLiveData) object, fieldId);
            case 13:
                return G((LiveData) object, fieldId);
            case 14:
                return J((MediatorLiveData) object, fieldId);
            case 15:
                return r((LiveData) object, fieldId);
            case 16:
                return u((LiveData) object, fieldId);
            case 17:
                return y((MutableLiveData) object, fieldId);
            case 18:
                return A((LiveData) object, fieldId);
            case 19:
                return w((LiveData) object, fieldId);
            case 20:
                return H((LiveData) object, fieldId);
            case 21:
                return K((LiveData) object, fieldId);
            case 22:
                return n((MutableLiveData) object, fieldId);
            case 23:
                return v((LiveData) object, fieldId);
            case 24:
                return E((LiveData) object, fieldId);
            case 25:
                return I((LiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(LiveData<String> VmEffectiveLabel, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 2048;
        }
        return true;
    }

    public final boolean q(LiveData<String> VmEffectiveValue, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 1;
        }
        return true;
    }

    public final boolean r(LiveData<Integer> VmFreePunchCount, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    public final boolean s(LiveData<String> VmGoalKmValue, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((RunIndexVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((RunIndexActivity.a) variable);
        }
        return true;
    }

    public final boolean t(LiveData<String> VmGoalProgressCurrentText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 16;
        }
        return true;
    }

    public final boolean u(LiveData<String> VmGoalProgressPercentText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    public final boolean v(LiveData<String> VmGoalProgressTotalText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 8388608;
        }
        return true;
    }

    public final boolean w(LiveData<Integer> VmGoalSeekProgress, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    public final boolean x(LiveData<String> VmGoalTimesValue, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 1024;
        }
        return true;
    }

    public final boolean y(MutableLiveData<Boolean> VmIsActivity, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 131072;
        }
        return true;
    }

    public final boolean z(MediatorLiveData<String> VmLeftEntryDesc, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12074a |= 256;
        }
        return true;
    }

    public RunLayoutIndexHeaderBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 26, (ConstraintLayout) bindings[29], (ConstraintLayout) bindings[33], (GoalProgressView) bindings[11], (ImageView) bindings[40], (ImageView) bindings[34], (LinearLayout) bindings[35], (BLLinearLayout) bindings[38], (ConstraintLayout) bindings[42], (BLLinearLayout) bindings[39], (RecyclerView) bindings[36], (BLTextView) bindings[41], (TextView) bindings[37], (TextView) bindings[31], (TextView) bindings[1], (BLTextView) bindings[32]);
        this.f12074a = -1L;
        ((RunLayoutIndexHeaderBinding) this).f12061a.setTag(null);
        ((RunLayoutIndexHeaderBinding) this).f12065a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f12076a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.f12086d = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[12];
        this.f12083b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[13];
        this.c = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[14];
        this.f12088e = textView2;
        textView2.setTag(null);
        ImageView imageView2 = (ImageView) bindings[15];
        this.d = imageView2;
        imageView2.setTag(null);
        TextView textView3 = (TextView) bindings[16];
        this.f = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[17];
        this.g = textView4;
        textView4.setTag(null);
        ImageView imageView3 = (ImageView) bindings[18];
        this.e = imageView3;
        imageView3.setTag(null);
        View view = (View) bindings[19];
        this.f12075a = view;
        view.setTag(null);
        TextView textView5 = (TextView) bindings[2];
        this.h = textView5;
        textView5.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[20];
        this.f12084c = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView6 = (TextView) bindings[21];
        this.i = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) bindings[22];
        this.j = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) bindings[23];
        this.k = textView8;
        textView8.setTag(null);
        View view2 = (View) bindings[24];
        this.b = view2;
        view2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[25];
        this.f12085d = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView9 = (TextView) bindings[26];
        this.l = textView9;
        textView9.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) bindings[27];
        this.f12087e = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView10 = (TextView) bindings[28];
        this.m = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) bindings[3];
        this.n = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) bindings[30];
        this.o = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) bindings[4];
        this.p = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) bindings[5];
        this.q = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) bindings[6];
        this.r = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) bindings[7];
        this.s = textView16;
        textView16.setTag(null);
        StrokeTextView strokeTextView = (StrokeTextView) bindings[8];
        this.f12077a = strokeTextView;
        strokeTextView.setTag(null);
        TextView textView17 = (TextView) bindings[9];
        this.t = textView17;
        textView17.setTag(null);
        ((RunLayoutIndexHeaderBinding) this).f12068b.setTag(null);
        ((RunLayoutIndexHeaderBinding) this).c.setTag(null);
        ((RunLayoutIndexHeaderBinding) this).f12071b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
