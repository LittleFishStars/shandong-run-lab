package com.huachenjie.run.service;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.room.migration.Migration;
import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.CollectionUtils;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.huachenjie.base.aliyun.detect_face.DetectResultBean;
import com.huachenjie.base.aliyun.detect_face.analyzer.FaceTool;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.base.util.HTProtectUtil;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.InvalidReason;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.common.run_component.PauseTimerType;
import com.huachenjie.common.run_interface.RunStateChangeListener;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.CheatResult;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.bean.RunDataV2;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.bean.SunshineRunFaceRecord;
import com.huachenjie.run.bean.SunshineRunServiceData;
import com.huachenjie.run.callback.ValueCallBack;
import com.huachenjie.run.database.SunshineRunDataBase;
import com.huachenjie.run.helper.SunshineRunNotificationHelper;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.run.utils.time_factory.IPauseTimeChangeListener;
import com.zj.adlib.fj7;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.in6;
import com.zj.adlib.kl7;
import com.zj.adlib.nl8;
import com.zj.adlib.r90;
import com.zj.adlib.s72;
import com.zj.adlib.xv8;
import com.zj.adlib.ys8;
import huachenjie.sdk.map.adapter.location.model.HCJGeoFence;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class DataComponent extends ApiDataComponent {
    public static final int Q = 6;
    public static final String h = "school_";
    public static final String i = "valid_";
    public static final String j = "sensitive_";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f35997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RunLatLng f12585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BaseRunService.DataChangeCallBack f12588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InnerDataChangeCallback f12589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final in6 f12590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJAddressInfo f12592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJAddressInfo[] f12595a;
    public RunLatLng b;
    public long c;
    public long d;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f12600g;
    public final String g = getClass().getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, List<HCJGeoFence>> f12594a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Object f12596c = new Object();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f12597c = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f12598d = false;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f12599e = false;
    public int K = -1;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    public int O = 0;
    public int P = 0;
    public boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<RunLatLng> f12593a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ValueCallBack f12587a = new a();
    public long e = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HCJMapUtils f12591a = HCJMapEntry.getInstance().createMapUtils();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SunshineRunServiceData f12586a = new SunshineRunServiceData();

    public interface InnerDataChangeCallback {
        void a();

        void b();
    }

    public class a implements ValueCallBack {
        public a() {
        }

        @Override // com.huachenjie.run.callback.ValueCallBack
        public void a(@Nullable Object any) {
            if (DataComponent.this.f12586a == null || DataComponent.this.f12586a.getRunData() == null || !(any instanceof Integer)) {
                return;
            }
            Integer num = (Integer) any;
            if (num.intValue() > 0) {
                DataComponent.this.f12586a.getRunData().setLastRecordStep(num.intValue());
            }
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35999a;

        static {
            int[] iArr = new int[PauseTimerType.values().length];
            f35999a = iArr;
            try {
                iArr[PauseTimerType.REST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35999a[PauseTimerType.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35999a[PauseTimerType.SPEED_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35999a[PauseTimerType.FACE_RECOGNITION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35999a[PauseTimerType.NFC_CHECK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public DataComponent(Context context) {
        this.f35997a = context;
        RunDataV2 runDataV2 = new RunDataV2();
        runDataV2.setSportType(1);
        runDataV2.setLastRecordStep(0);
        this.f12586a.setRunData(runDataV2);
        this.f12590a = in6.f42394a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R1(long j2, double d, ValueCallBack valueCallBack, Object obj) {
        if (j2 >= 200 && d > this.f12586a.getSegmentStrideAvg()) {
            this.f12586a.getRunData().setLastSegmentStepExceptionNum(this.f12586a.getRunData().getLastSegmentStepExceptionNum() + 1);
        }
        if (!L1() || valueCallBack == null) {
            return;
        }
        valueCallBack.a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S1(ObservableEmitter observableEmitter) throws Exception {
        FaceTool.l(this.f12586a.getFaceCheckData().getFaceImg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(ObservableEmitter observableEmitter) throws Exception {
        this.f12593a = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).c().e(true, E());
        this.f12597c = true;
        this.c = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(Object obj) {
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        if (sunshineRunServiceData == null || sunshineRunServiceData.getRunData() == null || !(obj instanceof Integer)) {
            return;
        }
        Integer num = (Integer) obj;
        if (num.intValue() <= 0 || this.f12586a.getRunData() == null || num.intValue() == this.f12586a.getRunData().getLastRecordStep()) {
            return;
        }
        this.f12586a.getRunData().setLastRecordStep(num.intValue());
    }

    public boolean A0(boolean locationEnabled) {
        if (this.f12586a.getRunData() == null || C() == null || locationEnabled == this.f) {
            return false;
        }
        this.f = locationEnabled;
        if (!locationEnabled) {
            this.f12586a.getRunData().setGpsAbnormalTimes(this.f12586a.getRunData().getGpsAbnormalTimes() + 1);
        }
        return this.f12586a.getRunData().getGpsAbnormalTimes() >= C().getGpsAbnormalMaxTimes();
    }

    public boolean A1() {
        return ((float) S0()) >= ((float) f1()) * 0.2f && !P1(J0());
    }

    public final boolean B0() {
        int size;
        if (this.f12586a.getRunScene() == 20 && this.f12586a.getFaceCheckData().getFaceAuth() && !CollectionUtils.r(this.f12586a.getFaceCheckData().getFaceCheckRecordList())) {
            return !this.f12600g && this.f12586a.getFaceCheckData().getCurrentFaceCheckIndex() == (size = this.f12586a.getFaceCheckData().getFaceCheckRecordList().size() - 1) && this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(size).getHasChecked();
        }
        return true;
    }

    public boolean B1() {
        HCJAddressInfo[] hCJAddressInfoArr = this.f12595a;
        return hCJAddressInfoArr != null && hCJAddressInfoArr.length == 2 && hCJAddressInfoArr[1] == null && hCJAddressInfoArr[0] != null;
    }

    @Override // com.huachenjie.run.service.ApiDataComponent
    public CommonConfig C() {
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        if (sunshineRunServiceData == null) {
            return null;
        }
        return sunshineRunServiceData.getCommonConfig();
    }

    public boolean C0() {
        if (this.f12586a.getRunScene() != 20 || !this.f12586a.getFaceCheckData().getFaceAuth() || CollectionUtils.r(this.f12586a.getFaceCheckData().getFaceCheckRecordList()) || this.f12600g) {
            return false;
        }
        int size = this.f12586a.getFaceCheckData().getFaceCheckRecordList().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            }
            if (!this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(i2).getHasChecked()) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            return false;
        }
        if (i2 != this.f12586a.getFaceCheckData().getCurrentFaceCheckIndex()) {
            this.f12586a.getFaceCheckData().setFaceLeftTime(((long) this.f12586a.getFaceCheckData().getFaceTime()) * 1000);
            this.f12586a.getFaceCheckData().setFaceUseTime(0L);
            this.f12586a.getFaceCheckData().setFaceUseSaveTime(0L);
            PauseTimerType pauseTimerType = PauseTimerType.FACE_RECOGNITION;
            o2(0L, pauseTimerType);
            p2(0L, pauseTimerType);
            InnerDataChangeCallback innerDataChangeCallback = this.f12589a;
            if (innerDataChangeCallback != null) {
                innerDataChangeCallback.b();
            }
            this.f12586a.getFaceCheckData().setCurrentFaceCheckIndex(i2);
        }
        SunshineRunFaceRecord sunshineRunFaceRecord = this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(i2);
        if (!sunshineRunFaceRecord.getHasChecked() && S0() >= sunshineRunFaceRecord.getRandomDistance()) {
            this.f12600g = true;
            return true;
        }
        return false;
    }

    public boolean C1() {
        HCJAddressInfo[] hCJAddressInfoArr = this.f12595a;
        if (hCJAddressInfoArr == null) {
            return true;
        }
        return hCJAddressInfoArr.length == 2 && hCJAddressInfoArr[0] == null;
    }

    public final boolean D0() {
        if (w1()) {
            return H1();
        }
        return true;
    }

    public boolean D1() {
        return p1() != null && p1().isGpsWhiteFlag();
    }

    @Override // com.huachenjie.run.service.ApiDataComponent
    public String E() {
        return this.f12586a.getStartRunEntity() == null ? "" : this.f12586a.getStartRunEntity().getRunRecordCode();
    }

    public void E0(final ValueCallBack callBack) {
        if (this.f12586a.getRunData() == null || this.f12586a.getCommonConfig() == null) {
            return;
        }
        if (this.f12586a.getRunData().getLastSegmentStrideDistance() == 0) {
            this.f12586a.getRunData().setLastSegmentStepIndex(0);
            this.f12586a.getRunData().setLastSegmentStrideDistance(S0());
            this.f12586a.getRunData().setLastSegmentStep(L0());
            this.f12586a.getRunData().setLastSegmentStepTime(System.currentTimeMillis());
            return;
        }
        if (S0() - this.f12586a.getRunData().getLastSegmentStrideDistance() >= this.f12586a.getCommonConfig().getStrideStatisticsInterval()) {
            int lastSegmentStepIndex = this.f12586a.getRunData().getLastSegmentStepIndex();
            long jS0 = S0() - this.f12586a.getRunData().getLastSegmentStrideDistance();
            int iL0 = L0() - this.f12586a.getRunData().getLastSegmentStep();
            long jCurrentTimeMillis = (System.currentTimeMillis() - this.f12586a.getRunData().getLastSegmentStepTime()) / 1000;
            if (iL0 > 0) {
                final double dFloor = Math.floor(((jS0 * 100.0f) / iL0) * 10.0f) / 10.0d;
                HashMap map = new HashMap();
                map.put("time", Long.valueOf(jCurrentTimeMillis));
                map.put("stride", Double.valueOf(dFloor));
                map.put(SchoolActivitySuccessActivity.x, Long.valueOf(jS0));
                map.put("stepCount", Integer.valueOf(iL0));
                map.put("index", Integer.valueOf(lastSegmentStepIndex));
                final long lastSegmentStrideDistance = this.f12586a.getRunData().getLastSegmentStrideDistance();
                n0(map, this.f12586a.getCommonConfig().getStrideStatisticsInterval(), E(), new ValueCallBack() { // from class: com.zj.adlib.s62
                    @Override // com.huachenjie.run.callback.ValueCallBack
                    public final void a(Object obj) {
                        this.f19521a.R1(lastSegmentStrideDistance, dFloor, callBack, obj);
                    }
                });
            }
            this.f12586a.getRunData().setLastSegmentStepIndex(lastSegmentStepIndex + 1);
            this.f12586a.getRunData().setLastSegmentStrideDistance(S0());
            this.f12586a.getRunData().setLastSegmentStep(L0());
            this.f12586a.getRunData().setLastSegmentStepTime(System.currentTimeMillis());
        }
    }

    public boolean E1() {
        return this.f12597c;
    }

    public final boolean F0() {
        List<TargetPoints> targetPoints = getTargetPoints();
        if (targetPoints == null) {
            return false;
        }
        for (int i2 = 0; i2 < targetPoints.size(); i2++) {
            TargetPoints targetPoints2 = targetPoints.get(i2);
            if (!targetPoints2.getPassStatus() && targetPoints2.isInFence()) {
                if (!I1()) {
                    targetPoints2.setPassStatus(true);
                    targetPoints2.setClockTime(System.currentTimeMillis());
                    return true;
                }
                if (this.f12586a.getNextPointIndex() == i2) {
                    this.f12586a.setLastPointIndex(i2);
                    this.f12586a.setNextPointIndex(i2 + 1);
                    targetPoints2.setPassStatus(true);
                    targetPoints2.setClockTime(System.currentTimeMillis());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean F1() {
        return this.f12599e;
    }

    public boolean G0() {
        if (this.f12586a.getSchoolRule() == null || q1() == null) {
            return false;
        }
        if (this.f12586a.getRunScene() != 30 && !Q1()) {
            if (this.f12586a.getClockMode() == 1) {
                int iJ1 = j1();
                int iH1 = h1();
                if (iJ1 < q1().getRequiredPointCounts() || iH1 < q1().getOptionalPointGoalCounts()) {
                    return false;
                }
            } else if (I1()) {
                if (i1() < ((s1() == null || s1().getTargetPoints() == null) ? 0 : s1().getTargetPoints().size())) {
                    return false;
                }
            } else if (this.f12586a.getClockMode() != 10) {
                return false;
            }
        }
        return true;
    }

    public boolean G1() {
        if (this.f12586a.getRunScene() == 30) {
            return false;
        }
        if (1 == this.f12586a.getRunDistanceMode() && this.f12586a.getMoreTargetDistance() <= 0) {
            return S0() >= 50000;
        }
        int i2 = S0() >= f1() ? 1 : 0;
        if (G0()) {
            i2++;
        }
        if (P1(J0())) {
            i2++;
        }
        if (1 != this.f12586a.getRunDistanceMode() || this.f12586a.getMoreTargetDistance() <= 0 || S0() >= this.f12586a.getMoreTargetDistance()) {
            i2++;
        }
        if (B0()) {
            i2++;
        }
        if (D0()) {
            i2++;
        }
        return i2 == 6;
    }

    public final RunLatLng H0(RunLatLng addressInfo, long subDistance) {
        RunLatLng runLatLng;
        if (D1()) {
            if (addressInfo.getAccuracy() > this.f12586a.getCommonConfig().getGpsFilterAccuracy()) {
                return null;
            }
        } else {
            if (addressInfo.getAccuracy() > this.f12586a.getCommonConfig().getRunFilterAccuracy()) {
                return null;
            }
            if (addressInfo.getSpeed() < 0.0f && (runLatLng = this.b) != null && runLatLng.getSpeed() < 0.0f) {
                return null;
            }
            if (this.b != null && addressInfo.getTimestamp() - this.b.getTimestamp() > 0 && (subDistance * 1000.0f) / (addressInfo.getTimestamp() - this.b.getTimestamp()) > 10.438d) {
                return null;
            }
        }
        addressInfo.setValid(true);
        return addressInfo;
    }

    public boolean H1() {
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        return sunshineRunServiceData != null && sunshineRunServiceData.getNfcVerified();
    }

    public int I0() {
        return this.f12586a.getAmapGPSLevel();
    }

    public final boolean I1() {
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        if (sunshineRunServiceData == null) {
            return false;
        }
        return 2 == sunshineRunServiceData.getClockMode() || 3 == this.f12586a.getClockMode();
    }

    public long J0() {
        if (Q0() <= 0) {
            return 0L;
        }
        return BigDecimal.valueOf(Q0()).divide(BigDecimal.valueOf(Math.max(0.01d, (S0() * 1.0f) / 1000.0f)), 0, RoundingMode.HALF_UP).longValue();
    }

    public boolean J1() {
        return (this.O & 1) > 0;
    }

    public Map<Integer, CheatResult> K0() {
        return this.f12586a.getCheatResult();
    }

    public boolean K1(HCJAddressInfo addressInfo) {
        if (addressInfo == null || q1() == null || q1().getFenceList() == null || q1().getFenceList().size() <= 0) {
            return false;
        }
        return this.f12591a.containsLocation(new HCJLatLng(addressInfo.getLat(), addressInfo.getLng()), q1().getFenceList(), false);
    }

    public int L0() {
        if (this.f12586a.getRunData() == null) {
            return 0;
        }
        return this.f12586a.getRunData().getTotalStep();
    }

    public boolean L1() {
        return (this.f12586a.getRunData() == null || s1() == null || (s1().getCheatLevel() != 3 && s1().getCheatLevel() != 4) || this.f12586a.getRunData().getLastSegmentStepExceptionNum() <= this.f12586a.getSegmentStrideExceptionNum() || s1().isWhiteFlag() || D1()) ? false : true;
    }

    public int M0() {
        if (this.f12586a.getRunData() == null || this.f12586a.getRunData().getLastRecordStep() < 0) {
            return 0;
        }
        return this.f12586a.getRunData().getLastRecordStep();
    }

    public final void M1(TargetPoints targetPoints, int index, boolean isClosing) {
        if (targetPoints == null || targetPoints.getPassStatus() || targetPoints.isClosingStatus() == isClosing) {
            return;
        }
        if (!I1() || this.f12586a.getNextPointIndex() == index) {
            targetPoints.setClosingStatus(isClosing);
            if (!isClosing) {
                if (o1() != 30) {
                    V1(R.raw.run_leaving_target);
                }
                this.L = index;
                BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
                if (dataChangeCallBack != null) {
                    dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.FarAwayTargetPoint, this);
                    return;
                }
                return;
            }
            if (o1() == 30) {
                V1(R.raw.run_closing_clock_machine);
            } else {
                V1(R.raw.run_closing_target);
            }
            this.K = index;
            BaseRunService.DataChangeCallBack dataChangeCallBack2 = this.f12588a;
            if (dataChangeCallBack2 != null) {
                dataChangeCallBack2.a(BaseRunService.DataChangeCallBack.DataType.ClosingTargetPoint, this);
            }
        }
    }

    public TargetPoints N0() {
        int i2;
        List<TargetPoints> targetPoints = getTargetPoints();
        if (targetPoints == null || targetPoints.size() <= 0 || (i2 = this.M) < 0 || i2 >= targetPoints.size()) {
            return null;
        }
        return targetPoints.get(this.M);
    }

    public boolean N1() {
        return this.f12598d;
    }

    public RunLatLng O0() {
        return this.f12585a;
    }

    public boolean O1() {
        if (g1() != 0 && e1() != 0 && in6.f42394a.b(PauseTimerType.SPEED_ERROR).a(this.f12586a) <= 0) {
            return true;
        }
        in6 in6Var = in6.f42394a;
        return in6Var.b(PauseTimerType.AUTO).a(this.f12586a) <= 0 || in6Var.b(PauseTimerType.REST).a(this.f12586a) <= 0;
    }

    public long P0() {
        return this.f12586a.getCurrentTime() + this.f12586a.getSaveCurrentTime();
    }

    public boolean P1(long pace) {
        if (this.f12586a.getSchoolRule() == null || D1() || e1() == 0 || g1() == 0) {
            return true;
        }
        return pace >= e1() && pace <= g1();
    }

    public long Q0() {
        return (this.f12586a.getCurrentTime() + this.f12586a.getSaveCurrentTime()) / 1000;
    }

    public boolean Q1() {
        return this.f12586a.getUseCreditSword();
    }

    public BaseRunService.DataChangeCallBack R0() {
        return this.f12588a;
    }

    public long S0() {
        if (this.f12586a.getRunData() == null) {
            return 0L;
        }
        return this.f12586a.getRunData().getDistance();
    }

    public List<RunLatLng> T0() {
        return this.f12593a;
    }

    public List<HCJGeoFence> U0(String customerId) {
        return this.f12594a.get(customerId);
    }

    public int V0() {
        return this.P;
    }

    public void V1(int... rawIds) {
        if (N1()) {
            return;
        }
        nl8.e(this.f35997a).q(rawIds);
    }

    public final List<InvalidReason> W0(int cheatType) {
        String strE;
        ArrayList arrayList = new ArrayList();
        if (this.f12586a.getSchoolRule() == null) {
            return arrayList;
        }
        if (cheatType == 6) {
            InvalidReason invalidReason = new InvalidReason();
            invalidReason.setInvalidType(25);
            invalidReason.setInvalidDetail(ys8.e(R.string.valid_reason_disable_gps));
            arrayList.add(invalidReason);
        }
        if (L1()) {
            InvalidReason invalidReason2 = new InvalidReason();
            invalidReason2.setInvalidType(58);
            invalidReason2.setInvalidDetail(ys8.e(R.string.reason_section_step_distance_err));
            arrayList.add(invalidReason2);
        }
        if (S0() < f1()) {
            InvalidReason invalidReason3 = new InvalidReason();
            invalidReason3.setInvalidType(2);
            invalidReason3.setInvalidDetail(ys8.f(R.string.distance_not_completed, BigDecimal.valueOf(f1()).divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP).toString()));
            arrayList.add(invalidReason3);
        }
        if (this.f12586a.getClockMode() == 1) {
            int iJ1 = j1();
            int iH1 = h1();
            if (iJ1 < q1().getRequiredPointCounts()) {
                InvalidReason invalidReason4 = new InvalidReason();
                invalidReason4.setInvalidType(1);
                invalidReason4.setInvalidDetail(ys8.e(R.string.required_point_not_passed));
                arrayList.add(invalidReason4);
            } else if (iH1 < q1().getOptionalPointGoalCounts()) {
                InvalidReason invalidReason5 = new InvalidReason();
                invalidReason5.setInvalidType(1);
                invalidReason5.setInvalidDetail(String.format(ys8.e(R.string.some_point_not_completed), Integer.valueOf(iJ1 + iH1), Integer.valueOf((q1().getTotalGoalCounts() - iJ1) - iH1)));
                arrayList.add(invalidReason5);
            }
        } else if (I1()) {
            int iI1 = i1();
            int size = (s1() == null || s1().getTargetPoints() == null) ? 0 : s1().getTargetPoints().size();
            if (size <= 0) {
                size = 3;
            }
            int i2 = size - iI1;
            if (i2 > 0 && iI1 < size) {
                InvalidReason invalidReason6 = new InvalidReason();
                invalidReason6.setInvalidType(1);
                invalidReason6.setInvalidDetail(String.format(ys8.e(R.string.some_point_not_completed), Integer.valueOf(iI1), Integer.valueOf(i2)));
                arrayList.add(invalidReason6);
            }
        }
        long jJ0 = J0();
        if (P0() > 0 && !P1(jJ0)) {
            InvalidReason invalidReason7 = new InvalidReason();
            invalidReason7.setInvalidType(3);
            boolean zIsRunActivityFlag = s1().isRunActivityFlag();
            if (g1() == 0 || jJ0 >= g1()) {
                strE = null;
            } else {
                strE = ys8.e(zIsRunActivityFlag ? R.string.invalid_reason_pace_too_fast_activity : R.string.invalid_reason_pace_too_fast_normal);
            }
            if (e1() != 0 && jJ0 > e1()) {
                strE = ys8.e(zIsRunActivityFlag ? R.string.invalid_reason_pace_too_slow_activity : R.string.invalid_reason_pace_too_slow_normal);
            }
            if (strE != null) {
                invalidReason7.setInvalidDetail(ys8.c(strE, s72.e(e1()), s72.e(g1())));
            }
            arrayList.add(invalidReason7);
            if (k1(PauseTimerType.SPEED_ERROR) <= 0) {
                InvalidReason invalidReason8 = new InvalidReason();
                invalidReason8.setInvalidType(53);
                if (this.f12586a.getCommonConfig() != null) {
                    invalidReason8.setInvalidDetail("跑步过程中，配速持续异常超过" + this.f12586a.getCommonConfig().getPaceAbnormalTime() + "秒");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x007f  */
    public void W1(HCJAddressInfo currentAddressInfo, long outFenceDisM, boolean firstBack2Stop) {
        long jLongValue;
        RunLatLng runLatLng = new RunLatLng(E(), (int) Q0(), currentAddressInfo, outFenceDisM, currentAddressInfo.getTime());
        if (CollectionUtils.t(this.f12593a)) {
            List<RunLatLng> list = this.f12593a;
            RunLatLng runLatLng2 = list.get(list.size() - 1);
            HCJLatLng hCJLatLng = new HCJLatLng(runLatLng2.getLat(), runLatLng2.getLng());
            jLongValue = BigDecimal.valueOf(HCJMapEntry.getInstance().createMapUtils().calculateLineDistance(new HCJLatLng(hCJLatLng.lat, hCJLatLng.lng), new HCJLatLng(currentAddressInfo.getLat(), currentAddressInfo.getLng()))).setScale(0, RoundingMode.HALF_UP).longValue();
            if (outFenceDisM >= 0) {
                jLongValue -= outFenceDisM;
                i4a.b(this.g, "离开围栏的距离已删减~~~~");
            }
            if (jLongValue <= 0) {
                jLongValue = 0;
            }
        } else {
            jLongValue = 0;
        }
        RunLatLng runLatLngH0 = H0(runLatLng, jLongValue);
        if (runLatLngH0 != null) {
            this.b = runLatLngH0;
            this.f12593a.add(runLatLngH0);
            if (jLongValue > 0 && !firstBack2Stop) {
                long distance = this.f12586a.getRunData().getDistance();
                long j2 = jLongValue + distance;
                this.f12586a.getRunData().setDistance(j2);
                int i2 = (int) (j2 / 1000);
                if (i2 > distance / 1000 && i2 <= 10) {
                    int identifier = this.f35997a.getResources().getIdentifier("run_run_distance_" + i2, "raw", this.f35997a.getPackageName());
                    if (identifier != 0) {
                        V1(identifier);
                    }
                }
            }
            if (this.f12586a.getRunData() != null && this.f12586a.getRunData().getDistance() >= f1()) {
                this.f12586a.getRunData().setStartCheckPace(true);
            }
            if (S0() >= this.f12586a.getProtectDistance() && !this.f12586a.getHasProtect()) {
                this.f12586a.setHasProtect(true);
                HTProtectUtil.b(E());
            }
        }
        i0(runLatLng);
        y2(S0());
    }

    public long X0() {
        return this.c;
    }

    public final void X1(long distance) {
        h0(Q0(), distance, L0());
        if (this.f12586a.getRunData().getDistance() < 50000) {
            l0(this.f12586a.getCommonConfig().getPaceInterval(), E());
        }
    }

    public TargetPoints Y0() {
        int i2;
        List<TargetPoints> targetPoints = getTargetPoints();
        if (targetPoints == null || targetPoints.size() <= 0 || (i2 = this.K) < 0 || i2 >= targetPoints.size()) {
            return null;
        }
        return targetPoints.get(this.K);
    }

    public void Y1() {
        long jQ0 = Q0();
        int stepInterval = this.f12586a.getCommonConfig().getStepInterval();
        if (stepInterval != 0 && jQ0 % ((long) stepInterval) == 0) {
            synchronized (this.f12596c) {
                j0(jQ0, stepInterval, M0(), L0(), this.f12587a);
            }
        }
        if ((jQ0 - 1) % 60 == 0) {
            o0(this.f12586a.getCommonConfig().getStepInterval(), E());
        }
    }

    public TargetPoints Z0() {
        int i2;
        List<TargetPoints> targetPoints = getTargetPoints();
        if (targetPoints == null || targetPoints.size() <= 0 || (i2 = this.N) < 0 || i2 >= targetPoints.size()) {
            return null;
        }
        return targetPoints.get(this.N);
    }

    public void Z1(int reason) {
        this.O = (~reason) & this.O;
    }

    public TargetPoints a1() {
        int i2;
        List<TargetPoints> targetPoints = getTargetPoints();
        if (targetPoints == null || targetPoints.size() <= 0 || (i2 = this.L) < 0 || i2 >= targetPoints.size()) {
            return null;
        }
        return targetPoints.get(this.L);
    }

    public void a2() {
        PauseTimerType pauseTimerType = PauseTimerType.NFC_CHECK;
        o2(0L, pauseTimerType);
        p2(0L, pauseTimerType);
        InnerDataChangeCallback innerDataChangeCallback = this.f12589a;
        if (innerDataChangeCallback != null) {
            innerDataChangeCallback.a();
        }
    }

    public HCJAddressInfo b1() {
        return this.f12592a;
    }

    public void b2() {
        this.f12600g = false;
    }

    public TargetPoints c1() {
        List<TargetPoints> targetPoints = getTargetPoints();
        if (targetPoints == null || targetPoints.size() <= 0 || this.f12586a.getLastPointIndex() < 0 || this.f12586a.getLastPointIndex() >= targetPoints.size()) {
            return null;
        }
        return targetPoints.get(this.f12586a.getLastPointIndex());
    }

    public final void c2(DetectResultBean resultBean, SunshineRunFaceRecord record) {
        record.setFinishFaceCheck(resultBean.getSuccess());
        if (!TextUtils.isEmpty(resultBean.getCompareFaceUrl())) {
            record.setRunFaceImg(resultBean.getCompareFaceUrl());
        }
        if (resultBean.getConfidence() != null) {
            record.setConfidence(resultBean.getConfidence());
        }
        if (!TextUtils.isEmpty(resultBean.getLabel())) {
            record.setLabel(resultBean.getLabel());
        }
        if (resultBean.getRate() != null) {
            record.setRate(resultBean.getRate());
        }
        if (!TextUtils.isEmpty(resultBean.getFaceRequestId())) {
            record.setFaceRequestId(resultBean.getFaceRequestId());
        }
        if (!TextUtils.isEmpty(resultBean.getFaceCheckErrorCode())) {
            record.setFaceCheckErrorCode(resultBean.getFaceCheckErrorCode());
        }
        if (!TextUtils.isEmpty(resultBean.getBodyRequestId())) {
            record.setBodyRequestId(resultBean.getBodyRequestId());
        }
        if (TextUtils.isEmpty(resultBean.getBodyCheckErrorCode())) {
            return;
        }
        record.setBodyCheckErrorCode(resultBean.getBodyCheckErrorCode());
    }

    public int d1() {
        return this.f12586a.getLastPointIndex();
    }

    public void d2() {
        xv8.i(this.f12586a);
    }

    public long e1() {
        if (this.f12586a.getStartRunEntity() != null && this.f12586a.getStartRunEntity().isRunActivityFlag()) {
            return this.f12586a.getStartRunEntity().getActivityInfo().getActivityMaxPace();
        }
        if (p1() != null) {
            return p1().getMaxPace();
        }
        return 0L;
    }

    public void e2(RunFaceCheckExtendBean extendBean, int faceCheckIndex) {
        if (extendBean != null && faceCheckIndex >= 0 && faceCheckIndex < this.f12586a.getFaceCheckData().getFaceCheckRecordList().size()) {
            SunshineRunFaceRecord sunshineRunFaceRecord = this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(faceCheckIndex);
            if (sunshineRunFaceRecord.getFinishFaceCheck()) {
                return;
            }
            sunshineRunFaceRecord.setExtendParam(extendBean.getProgress());
            sunshineRunFaceRecord.setRunFaceUpload(!TextUtils.isEmpty(extendBean.getFilePath()));
            if (!TextUtils.isEmpty(sunshineRunFaceRecord.getRunFaceImg()) || TextUtils.isEmpty(extendBean.getFileUrl())) {
                return;
            }
            sunshineRunFaceRecord.setRunFaceImg(extendBean.getFileUrl());
        }
    }

    public long f1() {
        if (this.f12586a.getSportType() == 6) {
            return this.f12586a.getMoreTargetDistance();
        }
        if (this.f12586a.getStartRunEntity() != null && this.f12586a.getStartRunEntity().isRunActivityFlag()) {
            return this.f12586a.getStartRunEntity().getActivityInfo().getSingleMinDistance();
        }
        if (p1() != null) {
            return p1().getSingleMinDistance();
        }
        return 0L;
    }

    public void f2() {
        int currentFaceCheckIndex = this.f12586a.getFaceCheckData().getCurrentFaceCheckIndex();
        if (currentFaceCheckIndex < 0 || currentFaceCheckIndex >= this.f12586a.getFaceCheckData().getFaceCheckRecordList().size()) {
            return;
        }
        SunshineRunFaceRecord sunshineRunFaceRecord = this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(currentFaceCheckIndex);
        sunshineRunFaceRecord.setPopTime(Long.valueOf(System.currentTimeMillis()));
        sunshineRunFaceRecord.setCheckDistance(Long.valueOf(S0()));
        RunLatLng runLatLng = this.f12585a;
        if (runLatLng != null) {
            sunshineRunFaceRecord.setCheckLat(Double.valueOf(runLatLng.getLat()));
            sunshineRunFaceRecord.setCheckLng(Double.valueOf(this.f12585a.getLng()));
        }
    }

    public long g1() {
        if (this.f12586a.getStartRunEntity() != null && this.f12586a.getStartRunEntity().isRunActivityFlag()) {
            return this.f12586a.getStartRunEntity().getActivityInfo().getActivityMinPace();
        }
        if (p1() != null) {
            return p1().getMinPace();
        }
        return 0L;
    }

    public void g2(@Nullable DetectResultBean resultBean) {
        if (resultBean != null && resultBean.getFaceCheckIndex() >= 0 && resultBean.getFaceCheckIndex() < this.f12586a.getFaceCheckData().getFaceCheckRecordList().size()) {
            SunshineRunFaceRecord sunshineRunFaceRecord = this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(resultBean.getFaceCheckIndex());
            if (sunshineRunFaceRecord.getFinishFaceCheck()) {
                return;
            }
            c2(resultBean, sunshineRunFaceRecord);
        }
    }

    @Override // com.huachenjie.run.service.ApiDataComponent
    public IntervalStep getTailSectionStepData(int nextId) {
        long jQ0 = Q0();
        long stepInterval = jQ0 % ((long) this.f12586a.getCommonConfig().getStepInterval());
        if (stepInterval == 0) {
            return null;
        }
        IntervalStep intervalStep = new IntervalStep();
        intervalStep.setId(nextId);
        intervalStep.setStartStep(M0());
        intervalStep.setEndStep(L0());
        intervalStep.setStartTime(jQ0 - stepInterval);
        intervalStep.setEndTime(jQ0);
        long jL0 = L0() - M0();
        intervalStep.setStep((int) (jL0 >= 0 ? jL0 : 0L));
        return intervalStep;
    }

    @Override // com.huachenjie.run.service.ApiDataComponent
    public List<TargetPoints> getTargetPoints() {
        if (this.f12586a.getStartRunEntity() == null) {
            return null;
        }
        return this.f12586a.getStartRunEntity().getTargetPoints();
    }

    public int h1() {
        int i2 = 0;
        if (this.f12586a.getStartRunEntity() == null) {
            return 0;
        }
        List<TargetPoints> targetPoints = this.f12586a.getStartRunEntity().getTargetPoints();
        if (targetPoints != null && !targetPoints.isEmpty()) {
            for (TargetPoints targetPoints2 : targetPoints) {
                if (targetPoints2.getPassStatus() && targetPoints2.getType() == 1) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public long h2(long currentTime) {
        this.f12586a.setCurrentTime(currentTime);
        return this.f12586a.getSaveCurrentTime() + this.f12586a.getCurrentTime();
    }

    public int i1() {
        int i2 = 0;
        if (this.f12586a.getStartRunEntity() == null) {
            return 0;
        }
        List<TargetPoints> targetPoints = this.f12586a.getStartRunEntity().getTargetPoints();
        if (targetPoints != null && !targetPoints.isEmpty()) {
            Iterator<TargetPoints> it = targetPoints.iterator();
            while (it.hasNext()) {
                if (it.next().getPassStatus()) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public void i2(BaseRunService.DataChangeCallBack dataChangeCallBack) {
        this.f12588a = dataChangeCallBack;
    }

    public int j1() {
        int i2 = 0;
        if (this.f12586a.getStartRunEntity() == null) {
            return 0;
        }
        List<TargetPoints> targetPoints = this.f12586a.getStartRunEntity().getTargetPoints();
        if (targetPoints != null && !targetPoints.isEmpty()) {
            for (TargetPoints targetPoints2 : targetPoints) {
                if (targetPoints2.getPassStatus() && targetPoints2.getType() == 2) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public DataComponent j2(int gpsSignal) {
        this.P = gpsSignal;
        BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
        if (dataChangeCallBack != null) {
            dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.GpsSignal, this);
        }
        return this;
    }

    public long k1(@Nullable PauseTimerType type) {
        if (type == null) {
            return Math.min(Math.min(this.f12586a.getPauseLeftTime(), this.f12586a.getAutoPauseLeftTime()), this.f12586a.getSpeedErrPauseLeftTime());
        }
        int i2 = b.f35999a[type.ordinal()];
        if (i2 == 1) {
            return this.f12586a.getPauseLeftTime();
        }
        if (i2 == 2) {
            return this.f12586a.getAutoPauseLeftTime();
        }
        if (i2 == 3) {
            return this.f12586a.getSpeedErrPauseLeftTime();
        }
        if (i2 == 4) {
            return this.f12586a.getFaceCheckData().getFaceLeftTime();
        }
        if (i2 != 5) {
            return 0L;
        }
        return this.f12586a.getNfcCheckLeftTime();
    }

    public void k2(InnerDataChangeCallback innerDataChangeCallback) {
        this.f12589a = innerDataChangeCallback;
    }

    public long l1() {
        return this.f12586a.getPauseLeftTime();
    }

    public void l2(HCJAddressInfo lastOriginAddress) {
        this.f12592a = lastOriginAddress;
    }

    public int m1() {
        return this.O;
    }

    public void m2(boolean isLock) {
        this.f12599e = isLock;
        BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
        if (dataChangeCallBack != null) {
            dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.LOCK_SCREEN, this);
        }
    }

    public HashMap<String, Boolean> n1() {
        HashMap<String, Boolean> map = new HashMap<>(4);
        map.put("dis", Boolean.valueOf(S0() >= f1()));
        map.put(SQLiteMTAHelper.TABLE_POINT, Boolean.valueOf(G0()));
        map.put("speed", Boolean.valueOf(P1(J0())));
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        map.put("nfc", Boolean.valueOf(sunshineRunServiceData != null && sunshineRunServiceData.getNfcVerified()));
        return map;
    }

    public void n2(boolean nfcVerified) {
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        if (sunshineRunServiceData != null) {
            sunshineRunServiceData.setNfcVerified(nfcVerified);
        }
    }

    public int o1() {
        return this.f12586a.getRunScene();
    }

    public void o2(long pauseTime, PauseTimerType type) {
        this.f12590a.b(type).d(this.f12586a);
        this.f12590a.b(type).c(this.f12586a, pauseTime);
    }

    public SchoolRule p1() {
        return this.f12586a.getSchoolRule();
    }

    public void p2(long saveTime, PauseTimerType type) {
        this.f12590a.b(type).b(this.f12586a, saveTime);
        this.f12590a.b(type).d(this.f12586a);
    }

    public GeoFenceDetail q1() {
        return this.f12586a.getSchoolGeoFenceDetail();
    }

    public void q2(boolean silence) {
        this.f12598d = silence;
        fv5.a(silence ? R.string.run_slience_on_prompt : R.string.run_slience_off_prompt);
        SunshineRunNotificationHelper.d().m(silence);
        BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
        if (dataChangeCallBack != null) {
            dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.VolumeChange, this);
        }
    }

    public List<HCJGeoFence> r1() {
        if (!this.f12594a.containsKey(h + this.f12586a.getSchoolGeoFenceDetail().getFenceCode())) {
            return new ArrayList();
        }
        return this.f12594a.get(h + this.f12586a.getSchoolGeoFenceDetail().getFenceCode());
    }

    public final void r2() {
        BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
        if (dataChangeCallBack != null) {
            dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.PassedPoint, this);
        }
        p0(getTargetPoints(), E());
        if (i1() >= 2) {
            this.f12586a.getRunData().setStartCheckPace(true);
            y2(S0());
            BaseRunService.DataChangeCallBack dataChangeCallBack2 = this.f12588a;
            if (dataChangeCallBack2 != null) {
                dataChangeCallBack2.a(BaseRunService.DataChangeCallBack.DataType.LocationChange, this);
            }
        }
    }

    @Nullable
    public StartRunEntity s1() {
        return this.f12586a.getStartRunEntity();
    }

    public void s2(long time, int stepCount) {
        if (stepCount > this.f12586a.getRunData().getTotalStep() && time > this.d) {
            this.d = time;
            this.f12586a.getRunData().setTotalStep(stepCount);
            BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
            if (dataChangeCallBack != null) {
                dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.StepChanged, this);
            }
        }
    }

    public Map<String, Object> t1(boolean isValid, int cheatType) {
        HashMap map = new HashMap();
        int i2 = (cheatType <= 0 && isValid) ? 1 : 0;
        map.put("runRecordCode", E());
        map.put("duration", String.valueOf(Q0()));
        map.put(SchoolActivitySuccessActivity.x, String.valueOf(S0()));
        map.put("totalStep", String.valueOf(Math.max(0, L0())));
        map.put("status", Integer.valueOf(i2));
        map.put("stepInterval", Integer.valueOf(this.f12586a.getCommonConfig().getStepInterval()));
        map.put("paceInterval", Long.valueOf(this.f12586a.getCommonConfig().getPaceInterval()));
        map.put("targetPoints", getTargetPoints());
        map.put("alignType", Integer.valueOf(this.f12586a.getAmapGPSLevel()));
        map.put("pauseCount", Integer.valueOf(this.f12586a.getPauseCount()));
        map.put("pauseTimes", Long.valueOf((this.f12586a.getSavePauseTime() + this.f12586a.getPauseTime()) / 1000));
        if (K0() != null && !K0().isEmpty()) {
            map.put("cheatList", K0().values());
        }
        List<InvalidReason> listW0 = W0(cheatType);
        if (listW0 != null && !listW0.isEmpty()) {
            map.put("invalidReasons", listW0);
        }
        if (this.f12586a.getRunScene() == 20 && this.f12586a.getFaceCheckData().getFaceAuth()) {
            map.put("faceCheckRecordList", this.f12586a.getFaceCheckData().getFaceCheckRecordList());
        }
        map.put("sportType", Integer.valueOf(this.f12586a.getSportType()));
        this.f12586a.setFinish(true);
        this.f12586a.setStopStatus(i2);
        xv8.i(this.f12586a);
        return map;
    }

    public void t2(HCJAddressInfo addressInfo, RunStateChangeListener.State mRunState) {
        if (mRunState != RunStateChangeListener.State.normal) {
            this.f12585a = null;
        } else {
            this.f12585a = new RunLatLng(E(), (int) Q0(), addressInfo, -1L, addressInfo.getTime());
        }
    }

    public SunshineRunServiceData u1() {
        return this.f12586a;
    }

    public void u2() {
        int currentFaceCheckIndex = this.f12586a.getFaceCheckData().getCurrentFaceCheckIndex();
        if (currentFaceCheckIndex < 0 || currentFaceCheckIndex >= this.f12586a.getFaceCheckData().getFaceCheckRecordList().size()) {
            return;
        }
        this.f12586a.getFaceCheckData().getFaceCheckRecordList().get(currentFaceCheckIndex).setHasChecked(true);
    }

    public long v1() {
        if (p1() == null) {
            return 0L;
        }
        return p1().getSuspendTime();
    }

    public long v2(HCJAddressInfo offFirstP, HCJAddressInfo enterFirstP, long firstPoint2LastDis) {
        if (this.f12595a == null) {
            this.f12595a = new HCJAddressInfo[2];
        }
        HCJAddressInfo[] hCJAddressInfoArr = this.f12595a;
        if (hCJAddressInfoArr[0] == null && offFirstP != null) {
            hCJAddressInfoArr[0] = offFirstP;
            this.e = firstPoint2LastDis;
        }
        if (hCJAddressInfoArr[1] == null && enterFirstP != null) {
            hCJAddressInfoArr[1] = enterFirstP;
        }
        if (hCJAddressInfoArr[0] == null || hCJAddressInfoArr[1] == null || enterFirstP == null) {
            return -1L;
        }
        i4a.b(this.g, "开始计算进出围栏的总距离");
        long jLongValue = BigDecimal.valueOf(HCJMapEntry.getInstance().createMapUtils().calculateLineDistance(new HCJLatLng(this.f12595a[0].getLat(), this.f12595a[0].getLng()), new HCJLatLng(this.f12595a[1].getLat(), this.f12595a[1].getLng()))).setScale(0, RoundingMode.HALF_UP).longValue();
        long j2 = this.e;
        if (j2 <= 20) {
            jLongValue += j2;
        }
        i4a.b(this.g, "离开围栏的总距离：mOffFenceDisM=" + jLongValue);
        HCJAddressInfo[] hCJAddressInfoArr2 = this.f12595a;
        hCJAddressInfoArr2[0] = null;
        hCJAddressInfoArr2[1] = null;
        this.e = 0L;
        return jLongValue;
    }

    public void w0(List<HCJGeoFence> geoFenceList, String customerId) {
        this.f12594a.put(customerId, geoFenceList);
        BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
        if (dataChangeCallBack != null) {
            dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.GeoFenceLoaded, this);
        }
    }

    public boolean w1() {
        List<TargetPoints> targetPoints = getTargetPoints();
        if (CollectionUtils.r(targetPoints)) {
            return false;
        }
        Iterator<TargetPoints> it = targetPoints.iterator();
        while (it.hasNext()) {
            if (it.next().getNfcEnable()) {
                return true;
            }
        }
        return false;
    }

    public void w2(String customerId, boolean isClosing) {
        int i2;
        i4a.c("updateSensitiveTargetPoint:" + customerId);
        i4a.c("updateSensitiveTargetPoint:" + isClosing);
        try {
            List<TargetPoints> targetPoints = getTargetPoints();
            if (!CollectionUtils.r(targetPoints) && (i2 = Integer.parseInt(customerId.substring(10))) >= 0 && i2 < targetPoints.size()) {
                if (isClosing) {
                    this.M = i2;
                    this.N = -1;
                    BaseRunService.DataChangeCallBack dataChangeCallBack = this.f12588a;
                    if (dataChangeCallBack != null) {
                        dataChangeCallBack.a(BaseRunService.DataChangeCallBack.DataType.ClosingClockPoint, this);
                    }
                } else {
                    this.N = i2;
                    this.M = -1;
                    BaseRunService.DataChangeCallBack dataChangeCallBack2 = this.f12588a;
                    if (dataChangeCallBack2 != null) {
                        dataChangeCallBack2.a(BaseRunService.DataChangeCallBack.DataType.FarAwayClockPoint, this);
                    }
                    this.N = -1;
                }
                TargetPoints targetPoints2 = targetPoints.get(i2);
                if (targetPoints2.isSensitiveFenceAdded()) {
                    M1(targetPoints2, i2, isClosing);
                } else {
                    targetPoints2.setSensitiveFenceAdded(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x0(int reason) {
        this.O = reason | this.O;
    }

    public boolean x1(boolean needCleanData, StartRunPageParam startRunPageParam) {
        xv8.e();
        SunshineRunServiceData sunshineRunServiceDataB = xv8.b();
        if (needCleanData) {
            clearData();
            this.f12586a.setStartRunEntity(startRunPageParam.getStartRunEntity());
            this.f12586a.setSchoolGeoFenceDetail(startRunPageParam.getGeoFenceDetail());
            this.f12586a.setSegmentStrideAvg(startRunPageParam.getSegmentStrideAvg());
            this.f12586a.setSegmentStrideExceptionNum(startRunPageParam.getSegmentStrideExceptionNum());
            this.f12586a.setUseCreditSword(startRunPageParam.getUseCreditSword());
            this.f12586a.setAmapGPSLevel(startRunPageParam.getAmapGPSLevel());
            this.f12586a.setSchoolRule(startRunPageParam.getSchoolRule());
            this.f12586a.setRunDistanceMode(startRunPageParam.getRunDistanceMode());
            this.f12586a.setMoreTargetDistance(startRunPageParam.getMoreTargetDistance());
            this.f12586a.setCommonConfig(r90.g());
            this.f12586a.setClockMode(kl7.f42851a.a(startRunPageParam.getStartRunEntity(), startRunPageParam.getGeoFenceDetail()));
            this.f12586a.setCheatResult(startRunPageParam.getCheatResult());
            this.f12586a.setRunScene(startRunPageParam.getRunScene());
            this.f12586a.setNfcPauseDuration(startRunPageParam.getNfcPauseDuration() > 0 ? startRunPageParam.getNfcPauseDuration() : 30);
            this.f12586a.setFaceCheckData(startRunPageParam.getFaceCheckData());
            this.f12586a.setSportType(startRunPageParam.getSportType());
            y1(false);
            if (this.f12586a.getStartRunEntity() == null || this.f12586a.getSchoolGeoFenceDetail() == null || this.f12586a.getSchoolRule() == null || this.f12586a.getCommonConfig() == null) {
                return false;
            }
            if (CollectionUtils.t(this.f12586a.getStartRunEntity().getTargetPoints())) {
                Collections.sort(this.f12586a.getStartRunEntity().getTargetPoints());
            }
            if (I1()) {
                this.f12586a.setNextPointIndex(0);
            }
            this.f12586a.getRunData().setRunRecordCode(startRunPageParam.getStartRunEntity().getRunRecordCode());
            xv8.i(this.f12586a);
            if (this.f12586a.getRunScene() == 20 && this.f12586a.getFaceCheckData().getFaceAuth() && this.f12586a.getFaceCheckData().getFaceModelType() == 2 && !TextUtils.isEmpty(this.f12586a.getFaceCheckData().getFaceImg())) {
                Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.q62
                    public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                        this.f44134a.S1(observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).subscribe();
            }
            long jF1 = f1();
            this.f12586a.setProtectDistance(jF1 > 200 ? 100 + ((long) (Math.random() * (jF1 - 200))) : 100L);
            this.f12597c = true;
            this.c = System.currentTimeMillis();
        } else {
            if (sunshineRunServiceDataB == null) {
                return false;
            }
            this.f12586a = sunshineRunServiceDataB;
            i4a.d(this.g, "数据恢复后的打卡模式:data.clickMode==" + sunshineRunServiceDataB.getClockMode());
            if (sunshineRunServiceDataB.getRunData() != null) {
                i4a.d(this.g, "数据恢复后的打卡模式:data.LastRecordStep==" + sunshineRunServiceDataB.getRunData().getLastRecordStep());
            }
            z1();
            SunshineRunServiceData sunshineRunServiceData = this.f12586a;
            sunshineRunServiceData.setSaveCurrentTime(sunshineRunServiceData.getCurrentTime() + this.f12586a.getSaveCurrentTime());
            this.f12586a.setCurrentTime(0L);
            y1(true);
            Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.r62
                public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                    this.f44381a.T1(observableEmitter);
                }
            }).subscribeOn(Schedulers.io()).subscribe();
        }
        return true;
    }

    public void x2(RunStateChangeListener.State state) {
        try {
            List<TargetPoints> targetPoints = getTargetPoints();
            if (targetPoints == null) {
                return;
            }
            for (TargetPoints targetPoints2 : targetPoints) {
                targetPoints2.setInFence(HCJMapEntry.getInstance().createMapUtils().calculateLineDistance(new HCJLatLng(targetPoints2.getLat(), targetPoints2.getLng()), new HCJLatLng(this.f12592a.getLat(), this.f12592a.getLng())) <= ((float) C().getValidDistance()));
            }
            z0(state);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void y0() {
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        if (sunshineRunServiceData != null) {
            sunshineRunServiceData.setPauseCount(sunshineRunServiceData.getPauseCount() + 1);
        }
    }

    public final void y1(boolean isRecovery) {
        in6 in6Var = this.f12590a;
        PauseTimerType pauseTimerType = PauseTimerType.REST;
        IPauseTimeChangeListener iPauseTimeChangeListenerB = in6Var.b(pauseTimerType);
        SunshineRunServiceData sunshineRunServiceData = this.f12586a;
        iPauseTimeChangeListenerB.b(sunshineRunServiceData, sunshineRunServiceData.getPauseTime() + (isRecovery ? this.f12586a.getSavePauseTime() : 0L));
        this.f12590a.b(pauseTimerType).c(this.f12586a, 0L);
        in6 in6Var2 = this.f12590a;
        PauseTimerType pauseTimerType2 = PauseTimerType.AUTO;
        IPauseTimeChangeListener iPauseTimeChangeListenerB2 = in6Var2.b(pauseTimerType2);
        SunshineRunServiceData sunshineRunServiceData2 = this.f12586a;
        iPauseTimeChangeListenerB2.b(sunshineRunServiceData2, sunshineRunServiceData2.getAutoPauseTime() + (isRecovery ? this.f12586a.getAutoSavePauseTime() : 0L));
        this.f12590a.b(pauseTimerType2).c(this.f12586a, 0L);
        in6 in6Var3 = this.f12590a;
        PauseTimerType pauseTimerType3 = PauseTimerType.SPEED_ERROR;
        in6Var3.b(pauseTimerType3).b(this.f12586a, 0L);
        this.f12590a.b(pauseTimerType3).c(this.f12586a, 0L);
        in6 in6Var4 = this.f12590a;
        PauseTimerType pauseTimerType4 = PauseTimerType.FACE_RECOGNITION;
        IPauseTimeChangeListener iPauseTimeChangeListenerB3 = in6Var4.b(pauseTimerType4);
        SunshineRunServiceData sunshineRunServiceData3 = this.f12586a;
        iPauseTimeChangeListenerB3.b(sunshineRunServiceData3, sunshineRunServiceData3.getFaceCheckData().getFaceUseTime() + (isRecovery ? this.f12586a.getFaceCheckData().getFaceUseSaveTime() : 0L));
        this.f12590a.b(pauseTimerType4).c(this.f12586a, 0L);
        in6 in6Var5 = this.f12590a;
        PauseTimerType pauseTimerType5 = PauseTimerType.NFC_CHECK;
        in6Var5.b(pauseTimerType5).b(this.f12586a, 0L);
        this.f12590a.b(pauseTimerType5).c(this.f12586a, 0L);
    }

    public final void y2(long distanceMeter) {
        X1(distanceMeter);
        if (distanceMeter <= 0) {
            return;
        }
        this.f12586a.getRunData();
    }

    public void z0(RunStateChangeListener.State state) {
        if (state != RunStateChangeListener.State.normal) {
            return;
        }
        boolean z = false;
        while (F0()) {
            z = true;
        }
        if (z) {
            r2();
        }
    }

    public final void z1() {
        e0(new ValueCallBack() { // from class: com.zj.adlib.t62
            @Override // com.huachenjie.run.callback.ValueCallBack
            public final void a(Object obj) {
                this.f44853a.U1(obj);
            }
        });
    }
}
