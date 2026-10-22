package com.huachenjie.run.service;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.blankj.utilcode.util.CollectionUtils;
import com.huachenjie.base.aliyun.detect_face.DetectResultBean;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.common.callback.ValueCallback;
import com.huachenjie.common.run_component.PauseTimerType;
import com.huachenjie.common.run_interface.RunStateChangeListener;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.CheatResult;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.StartRunPageParam;
import com.huachenjie.run.bean.SunshineRunFinishData;
import com.huachenjie.run.callback.ValueCallBack;
import com.huachenjie.run.dialog.OnActionListener;
import com.huachenjie.run.helper.SunshineRunNotificationHelper;
import com.huachenjie.run.service.SunshineRunService;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.iy5;
import com.zj.adlib.r90;
import com.zj.adlib.t26;
import com.zj.adlib.ud7;
import com.zj.adlib.v05;
import com.zj.adlib.vl2;
import com.zj.adlib.xv8;
import com.zj.adlib.ys8;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class SunshineRunService extends BaseRunService {
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 4;
    public static final int N = 8;
    public static final int O = 16;
    public static final int P = 32;
    public static final int Q = 64;
    public static final int R = 128;
    public static final long b = 3000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ScheduledExecutorService f12601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f12602a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f12603b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f36000a = System.currentTimeMillis() - 50000;

    public static class SunshineRunBinder extends Binder {
        private final WeakReference<SunshineRunService> weakReference;

        public SunshineRunBinder(SunshineRunService service) {
            this.weakReference = new WeakReference<>(service);
        }

        @Nullable
        public SunshineRunService getService() {
            return this.weakReference.get();
        }
    }

    public class a implements SunshineRunNotificationHelper.NotificationCallback {
        public a() {
        }

        @Override // com.huachenjie.run.helper.SunshineRunNotificationHelper.NotificationCallback
        public void a() {
            DataComponent dataComponent = ((BaseRunService) SunshineRunService.this).f12580a;
            if (dataComponent != null) {
                dataComponent.q2(!dataComponent.N1());
            }
        }

        @Override // com.huachenjie.run.helper.SunshineRunNotificationHelper.NotificationCallback
        public void b() {
            SunshineRunService sunshineRunService = SunshineRunService.this;
            if (((BaseRunService) sunshineRunService).f12574a == RunStateChangeListener.State.normal) {
                sunshineRunService.pauseRun();
                OnActionListener onActionListener = ((BaseRunService) SunshineRunService.this).f12577a;
                if (onActionListener != null) {
                    onActionListener.a();
                    return;
                }
                return;
            }
            sunshineRunService.resumeRun();
            OnActionListener onActionListener2 = ((BaseRunService) SunshineRunService.this).f12577a;
            if (onActionListener2 != null) {
                onActionListener2.onCancel();
            }
        }
    }

    public class b extends BizSubscriber<FinishRunResult> {
        public final /* synthetic */ int K;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean showErrorToast, final int val$cheatType, final boolean val$isDataError, final boolean val$isAuto) {
            super(showErrorToast);
            this.K = val$cheatType;
            this.b = val$isDataError;
            this.c = val$isAuto;
        }

        public boolean onBizError(BaseEntity baseEntity) {
            ApiDataComponent.HandleRunError handleRunErrorD = ((BaseRunService) SunshineRunService.this).f12580a.D();
            if (handleRunErrorD == null || !handleRunErrorD.a(baseEntity.code, baseEntity.message)) {
                return super.onBizError(baseEntity);
            }
            return true;
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            SunshineRunService.this.H(this.c, new SunshineRunFinishData(false));
            SunshineRunService.this.f12602a = false;
        }

        public void onFinish() {
            super.onFinish();
            SunshineRunService.this.f12602a = false;
        }

        public void onCCSuccess(FinishRunResult data) {
            ud7.f();
            SunshineRunService.this.H(this.c, new SunshineRunFinishData(this.K, this.b, this.c, true, data));
            ((BaseRunService) SunshineRunService.this).f12580a.clearData();
            SunshineRunService.this.f12602a = false;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36003a;

        static {
            int[] iArr = new int[RunStateChangeListener.State.values().length];
            f36003a = iArr;
            try {
                iArr[RunStateChangeListener.State.finish.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36003a[RunStateChangeListener.State.autoPause.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36003a[RunStateChangeListener.State.preStart.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36003a[RunStateChangeListener.State.faceRecognition.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36003a[RunStateChangeListener.State.nfcCheck.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36003a[RunStateChangeListener.State.userPause.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36003a[RunStateChangeListener.State.normal.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static /* synthetic */ Thread A(Runnable runnable) {
        Thread thread = new Thread(runnable, "nfc-verify-poll");
        thread.setDaemon(true);
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent == null || dataComponent.H1()) {
            J();
        } else {
            queryNfcVerificationNow();
        }
    }

    public static void bindService(Activity activity, ServiceConnection serviceConnection) {
        activity.bindService(new Intent(activity, (Class<?>) SunshineRunService.class), serviceConnection, 1);
    }

    public static void newInstance(Activity activity, ServiceConnection serviceConnection) {
        Intent intent = new Intent(activity, (Class<?>) SunshineRunService.class);
        activity.startForegroundService(intent);
        activity.bindService(intent, serviceConnection, 1);
    }

    public static void stopService(Activity activity) {
        i4a.a("服务已暂停!!");
        activity.stopService(new Intent(activity, (Class<?>) SunshineRunService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x(int i, String str) {
        switch (i) {
            case 2072:
            case 2075:
                H(true, new SunshineRunFinishData(0, false, true, true, null));
                return true;
            case 2073:
            case 2074:
                if (!TextUtils.isEmpty(str)) {
                    fv5.b(str);
                }
                H(true, new SunshineRunFinishData(0, true, true, true, null));
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(Object obj) {
        if (obj == null || !obj.equals(1)) {
            return;
        }
        t(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(Boolean bool) {
        if (((BaseRunService) this).f12580a == null) {
            return;
        }
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool) || !((BaseRunService) this).f12580a.H1()) {
            ((BaseRunService) this).f12580a.n2(bool2.equals(bool));
            ((BaseRunService) this).f12580a.d2();
        }
        if (((BaseRunService) this).f12580a.H1()) {
            J();
        }
        if (((BaseRunService) this).f12580a.R0() != null) {
            ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.NfcVerification, ((BaseRunService) this).f12580a);
        }
    }

    public final void C() {
        TargetPoints targetPointsN0;
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent == null || dataComponent.H1() || (targetPointsN0 = ((BaseRunService) this).f12580a.N0()) == null || !targetPointsN0.getNfcEnable()) {
            return;
        }
        I();
    }

    public final void D(HCJAddressInfo addressInfo) {
        long jV2;
        boolean z = false;
        if (((BaseRunService) this).f12574a == RunStateChangeListener.State.normal) {
            if (!((BaseRunService) this).f12580a.K1(addressInfo)) {
                return;
            }
            if (((BaseRunService) this).f12580a.B1()) {
                jV2 = ((BaseRunService) this).f12580a.v2(null, addressInfo, 0L);
                i4a.b(this.f, "您已进入围栏");
            } else {
                jV2 = -1;
            }
            ((BaseRunService) this).f12580a.W1(addressInfo, jV2, v());
            DataComponent dataComponent = ((BaseRunService) this).f12580a;
            dataComponent.m0(dataComponent.E());
            SunshineRunNotificationHelper.d().j((int) ((BaseRunService) this).f12580a.S0(), (int) ((BaseRunService) this).f12580a.f1());
            SunshineRunNotificationHelper.d().h(((BaseRunService) this).f12580a.J0());
            if (((BaseRunService) this).f12580a.G1()) {
                t(0);
            }
            ((BaseRunService) this).f12580a.E0(new ValueCallBack() { // from class: com.zj.adlib.fw8
                @Override // com.huachenjie.run.callback.ValueCallBack
                public final void a(Object obj) {
                    this.f41772a.y(obj);
                }
            });
            if (((BaseRunService) this).f12580a.C0()) {
                z = true;
            }
        }
        if (((BaseRunService) this).f12580a.R0() != null) {
            ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.LocationChange, ((BaseRunService) this).f12580a);
        }
        if (z) {
            ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.FaceRecognitionTip, ((BaseRunService) this).f12580a);
        }
    }

    public final void E(HCJAddressInfo addressInfo) {
        if (addressInfo == null || addressInfo.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        if (!((BaseRunService) this).f12580a.D1()) {
            if (addressInfo.getAccuracy() > r90.g().getRunFilterAccuracy()) {
                return;
            }
            if (vl2.e() && addressInfo.getSatellites() < 4 && ((BaseRunService) this).f12580a.I0() == 2) {
                return;
            }
        }
        if (((BaseRunService) this).f12574a != RunStateChangeListener.State.preStart || System.currentTimeMillis() - ((BaseRunService) this).f12580a.X0() < 3000) {
            return;
        }
        setRunState(RunStateChangeListener.State.normal, false, null);
    }

    public final void F(HCJAddressInfo addressInfo) {
        long jLongValue;
        if (addressInfo != null && RunStateChangeListener.State.autoPause == ((BaseRunService) this).f12574a && !((BaseRunService) this).f12580a.K1(addressInfo) && (((BaseRunService) this).f12580a.m1() & 1) > 0 && ((BaseRunService) this).f12580a.C1()) {
            RunLatLng runLatLngO0 = ((BaseRunService) this).f12580a.O0();
            if (runLatLngO0 != null) {
                jLongValue = BigDecimal.valueOf(HCJMapEntry.getInstance().createMapUtils().calculateLineDistance(new HCJLatLng(runLatLngO0.getLat(), runLatLngO0.getLng()), new HCJLatLng(addressInfo.getLat(), addressInfo.getLng()))).setScale(0, RoundingMode.HALF_UP).longValue();
                i4a.b(this.f, "firstOffDisM=" + jLongValue);
            } else {
                jLongValue = 0;
            }
            ((BaseRunService) this).f12580a.v2(addressInfo, null, jLongValue);
        }
    }

    public final void G(boolean force) {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent == null) {
            return;
        }
        if (dataComponent.H1()) {
            this.f12603b = false;
            J();
        } else if (force || this.f12603b) {
            this.f12603b = false;
            ((BaseRunService) this).f12580a.f0(new ValueCallback() { // from class: com.zj.adlib.iw8
                @Override // com.huachenjie.common.callback.ValueCallback
                public final void onCallback(Object obj) {
                    this.f42457a.z((Boolean) obj);
                }
            });
        }
    }

    public final void H(boolean isAuto, SunshineRunFinishData sunshineRunFinishData) {
        HashMap map = new HashMap();
        map.put("finishData", sunshineRunFinishData);
        xv8.h(sunshineRunFinishData);
        setRunState(RunStateChangeListener.State.finish, !isAuto, map);
    }

    public final synchronized void I() {
        ScheduledExecutorService scheduledExecutorService = this.f12601a;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.zj.adlib.gw8
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return SunshineRunService.A(runnable);
                }
            });
            this.f12601a = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new Runnable() { // from class: com.zj.adlib.hw8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42221a.B();
                }
            }, 3000L, 3000L, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void J() {
        ScheduledExecutorService scheduledExecutorService = this.f12601a;
        this.f12601a = null;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public final void K(HCJAddressInfo addressInfo) {
        i4a.b(this.f, "updateLocation 绘制点为开始，下一步开始上传操作");
        if (addressInfo == null || addressInfo.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        E(addressInfo);
        ((BaseRunService) this).f12580a.t2(addressInfo, ((BaseRunService) this).f12574a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ((BaseRunService) this).f12580a.x2(((BaseRunService) this).f12574a);
        i4a.f(ys8.c("updateTargetPointState用时：%d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        D(addressInfo);
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public boolean checkStateChange(RunStateChangeListener.State state, boolean fromUser) {
        if (fromUser) {
            switch (c.f36003a[((BaseRunService) this).f12574a.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return state == RunStateChangeListener.State.finish;
                case 4:
                case 5:
                    return state == RunStateChangeListener.State.normal || state == RunStateChangeListener.State.finish || state == RunStateChangeListener.State.autoPause;
                case 6:
                    return state == RunStateChangeListener.State.normal || state == RunStateChangeListener.State.finish;
                case 7:
                    return state == RunStateChangeListener.State.userPause || state == RunStateChangeListener.State.faceRecognition || state == RunStateChangeListener.State.nfcCheck || state == RunStateChangeListener.State.finish;
            }
        }
        switch (c.f36003a[((BaseRunService) this).f12574a.ordinal()]) {
            case 1:
            case 6:
                return state == RunStateChangeListener.State.finish;
            case 2:
                if (((BaseRunService) this).f12580a.m1() == 0) {
                    return state == RunStateChangeListener.State.normal || state == RunStateChangeListener.State.finish;
                }
                return state == RunStateChangeListener.State.finish;
            case 3:
                return state == RunStateChangeListener.State.autoPause || state == RunStateChangeListener.State.normal || state == RunStateChangeListener.State.finish;
            case 4:
            case 5:
                return state == RunStateChangeListener.State.normal || state == RunStateChangeListener.State.finish || state == RunStateChangeListener.State.autoPause;
            case 7:
                return state == RunStateChangeListener.State.autoPause || state == RunStateChangeListener.State.faceRecognition || state == RunStateChangeListener.State.nfcCheck || state == RunStateChangeListener.State.finish;
        }
        return false;
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void enterFence(String customerId) {
        if (!(DataComponent.h + ((BaseRunService) this).f12580a.q1().getFenceCode()).equals(customerId)) {
            if (customerId.contains(DataComponent.j)) {
                ((BaseRunService) this).f12580a.w2(customerId, true);
                C();
                return;
            }
            return;
        }
        if (((BaseRunService) this).f12580a.J1()) {
            ((BaseRunService) this).f12580a.Z1(1);
            if (((BaseRunService) this).f12574a != RunStateChangeListener.State.preStart || ((BaseRunService) this).f12580a.S0() > 0 || ((BaseRunService) this).f12580a.P0() > 0) {
                setRunState(RunStateChangeListener.State.normal, false, null);
            }
            ((BaseRunService) this).f12580a.V1(R.raw.run_back_to_fence);
        }
        if (((BaseRunService) this).f12580a.R0() != null) {
            ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.EnterSchoolFence, ((BaseRunService) this).f12580a);
        }
    }

    public int finishRun(boolean isForce) {
        if (((BaseRunService) this).f12580a.O1()) {
            u(true, false, false, 0);
            return 0;
        }
        if (((BaseRunService) this).f12580a.S0() < 100) {
            if (!isForce) {
                return 1;
            }
            u(false, true, false, 0);
            return 0;
        }
        if (((BaseRunService) this).f12580a.Q0() < 30) {
            if (!isForce) {
                return 2;
            }
            u(false, true, false, 0);
            return 0;
        }
        if (((BaseRunService) this).f12580a.p1() != null && ((BaseRunService) this).f12580a.S0() < ((BaseRunService) this).f12580a.f1()) {
            if (!isForce) {
                return 16;
            }
            u(false, false, false, 0);
            return 0;
        }
        if (!((BaseRunService) this).f12580a.G0()) {
            if (!isForce) {
                return 32;
            }
            u(false, false, false, 0);
            return 0;
        }
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent.P1(dataComponent.J0())) {
            u(false, false, true, 0);
            return 0;
        }
        if (!isForce) {
            return ((BaseRunService) this).f12580a.s1().isRunActivityFlag() ? 128 : 64;
        }
        u(false, false, false, 0);
        return 0;
    }

    public boolean initServiceData(boolean needCleanData, StartRunPageParam startRunPageParam) {
        boolean zX1 = ((BaseRunService) this).f12580a.x1(needCleanData, startRunPageParam);
        if (!zX1) {
            return false;
        }
        ((BaseRunService) this).f12567a.m(((BaseRunService) this).f12580a.I0());
        if (((BaseRunService) this).f12580a.p1() != null && ((BaseRunService) this).f12580a.p1().getSwingAmplitudeThreshold() > 0) {
            ((BaseRunService) this).f12571a.m(((BaseRunService) this).f12580a.p1().getSwingAmplitudeThreshold());
        }
        ((BaseRunService) this).f12571a.l(((BaseRunService) this).f12580a.L0());
        GeoFenceDetail geoFenceDetailQ1 = ((BaseRunService) this).f12580a.q1();
        HashMap map = new HashMap();
        map.put(DataComponent.h + geoFenceDetailQ1.getFenceCode(), geoFenceDetailQ1);
        List<TargetPoints> targetPoints = ((BaseRunService) this).f12580a.getTargetPoints();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        if (CollectionUtils.t(targetPoints)) {
            for (int i = 0; i < targetPoints.size(); i++) {
                map2.put(DataComponent.i + i, new HCJLatLng(targetPoints.get(i).getLat(), targetPoints.get(i).getLng()));
                map3.put(DataComponent.j + i, new HCJLatLng(targetPoints.get(i).getLat(), targetPoints.get(i).getLng()));
            }
        }
        loadGeoFence(map, map2, map3, ((BaseRunService) this).f12580a.C());
        ((BaseRunService) this).f12580a.k0(new ApiDataComponent.HandleRunError() { // from class: com.zj.adlib.ew8
            @Override // com.huachenjie.run.service.ApiDataComponent.HandleRunError
            public final boolean a(int i2, String str) {
                return this.f41539a.x(i2, str);
            }
        });
        return true;
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void leaveFence(String customerId) {
        if (!(DataComponent.h + ((BaseRunService) this).f12580a.q1().getFenceCode()).equals(customerId)) {
            if (customerId.contains(DataComponent.j)) {
                ((BaseRunService) this).f12580a.w2(customerId, false);
                J();
                return;
            }
            return;
        }
        if (!((BaseRunService) this).f12580a.J1()) {
            ((BaseRunService) this).f12580a.x0(1);
            if (((BaseRunService) this).f12574a != RunStateChangeListener.State.preStart || ((BaseRunService) this).f12580a.S0() > 0 || ((BaseRunService) this).f12580a.P0() > 0) {
                setRunState(RunStateChangeListener.State.autoPause, false, null);
            }
            ((BaseRunService) this).f12580a.V1(R.raw.run_out_of_fence);
        }
        if (((BaseRunService) this).f12580a.R0() != null) {
            ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.LeaveSchoolFence, ((BaseRunService) this).f12580a);
        }
    }

    public void markPendingNfcVerificationQuery() {
        this.f12603b = true;
    }

    @Override // com.huachenjie.run.service.BaseRunService, android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return new SunshineRunBinder(this);
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onCheatChange(Map<Integer, CheatResult> cheatResult) {
        if (cheatResult == null || cheatResult.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, CheatResult> entry : cheatResult.entrySet()) {
            ((BaseRunService) this).f12580a.K0().put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onCountSensorStepChange(int stepCount) {
        if (((BaseRunService) this).f12574a == RunStateChangeListener.State.normal) {
            DataComponent dataComponent = ((BaseRunService) this).f12580a;
            dataComponent.s2(dataComponent.Q0(), stepCount);
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService, android.app.Service
    public void onDestroy() {
        J();
        super.onDestroy();
        SunshineRunNotificationHelper.d().q();
        SunshineRunNotificationHelper.d().a(this);
        stopForeground(true);
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onDurationChange(PauseTimerType type, long elapsedTime) {
        SunshineRunNotificationHelper.d().l(this, elapsedTime);
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null && dataComponent.A0(v05.a(getApplicationContext()))) {
            t(6);
        }
        DataComponent dataComponent2 = ((BaseRunService) this).f12580a;
        if (dataComponent2 != null) {
            dataComponent2.Y1();
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onGpsSignal(int signalIntensity, int satellites) {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.j2(signalIntensity);
            if (((BaseRunService) this).f12574a != RunStateChangeListener.State.normal || ((BaseRunService) this).f12580a.D1()) {
                return;
            }
            if (signalIntensity <= 1 || !vl2.e() || satellites < 4) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = this.f36000a;
                if (j == 0 || jCurrentTimeMillis - j >= 60000) {
                    ((BaseRunService) this).f12580a.V1(R.raw.run_gps_weak);
                    this.f36000a = jCurrentTimeMillis;
                }
            }
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onLocation(HCJAddressInfo addressInfo, boolean locationEnable) {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null && dataComponent.E1()) {
            ((BaseRunService) this).f12580a.l2(addressInfo);
            if (((BaseRunService) this).f12580a.A0(locationEnable)) {
                t(6);
            }
            if (RunStateChangeListener.State.autoPause == ((BaseRunService) this).f12574a && !((BaseRunService) this).f12580a.K1(addressInfo) && ((BaseRunService) this).f12580a.P0() > 0) {
                F(addressInfo);
            }
            if (((BaseRunService) this).f12574a != RunStateChangeListener.State.finish && ((BaseRunService) this).f12580a.K1(addressInfo) && (((BaseRunService) this).f12580a.D1() || !vl2.e() || addressInfo.getSatellites() > 0 || ((BaseRunService) this).f12580a.I0() != 2)) {
                K(addressInfo);
                ((BaseRunService) this).f12580a.d2();
            } else if (((BaseRunService) this).f12580a.R0() != null) {
                ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.LocationChange, ((BaseRunService) this).f12580a);
            }
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onNetworkStateChange(int state) {
        if (((BaseRunService) this).f12580a.p1() != null && ((BaseRunService) this).f12580a.p1().isForbiddenWiFi()) {
            if (iy5.a(this) == 1) {
                ((BaseRunService) this).f12580a.x0(2);
                if (((BaseRunService) this).f12580a.R0() != null) {
                    ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.NetworkState, ((BaseRunService) this).f12580a);
                }
                setRunState(RunStateChangeListener.State.autoPause, false, null);
                return;
            }
            ((BaseRunService) this).f12580a.Z1(2);
            if (((BaseRunService) this).f12580a.R0() != null) {
                ((BaseRunService) this).f12580a.R0().a(BaseRunService.DataChangeCallBack.DataType.NetworkState, ((BaseRunService) this).f12580a);
            }
            setRunState(RunStateChangeListener.State.normal, false, null);
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onPauseDurationChange(long elapsedTime, PauseTimerType type) {
        SunshineRunNotificationHelper.d().i(this, ((BaseRunService) this).f12580a.l1());
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null && dataComponent.A0(v05.a(getApplicationContext()))) {
            t(6);
        }
        DataComponent dataComponent2 = ((BaseRunService) this).f12580a;
        if (dataComponent2 != null) {
            dataComponent2.o2(elapsedTime, type);
            if (((BaseRunService) this).f12580a.k1(type) > 0 || type == PauseTimerType.FACE_RECOGNITION) {
                return;
            }
            if (type == PauseTimerType.NFC_CHECK) {
                stopNFCCheck();
            } else {
                t26.f44833a.e(this, 1236, ys8.e(R.string.hcj_app_name), ys8.e(R.string.run_auto_stop_notification_content), null);
                t(0);
            }
        }
    }

    @Override // com.huachenjie.run.service.BaseRunService
    public void onRunStateChange(RunStateChangeListener.State state) {
        if (state == RunStateChangeListener.State.finish) {
            SunshineRunNotificationHelper.d().a(this);
        } else {
            ((BaseRunService) this).f12580a.z0(state);
            SunshineRunNotificationHelper.d().k(state != RunStateChangeListener.State.normal);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        w();
        return 3;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        SunshineRunNotificationHelper.d().c(getApplicationContext());
        stopForeground(true);
        stopSelf();
        super.onTaskRemoved(rootIntent);
    }

    public boolean pauseRun() {
        DataComponent dataComponent;
        try {
            boolean runState = setRunState(RunStateChangeListener.State.userPause, true, null);
            if (!runState || (dataComponent = ((BaseRunService) this).f12580a) == null) {
                return runState;
            }
            dataComponent.y0();
            return runState;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public void queryNfcVerificationIfNeeded() {
        G(false);
    }

    public void queryNfcVerificationNow() {
        G(true);
    }

    public void restoreShowFaceRecognitionTip() {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.b2();
        }
    }

    public boolean resumeRun() {
        if (getRunState() == RunStateChangeListener.State.preStart) {
            DataComponent dataComponent = ((BaseRunService) this).f12580a;
            if (dataComponent.K1(dataComponent.b1())) {
                fv5.b("GPS信号弱，请移至开阔地带");
                return true;
            }
            fv5.b("请回到跑步围栏内再继续跑步");
            return false;
        }
        if (((BaseRunService) this).f12580a.k1(null) <= 0) {
            fv5.b("暂停时间已用尽，不能继续！");
            return false;
        }
        int iM1 = ((BaseRunService) this).f12580a.m1();
        if (iM1 == 0) {
            if (((BaseRunService) this).f12574a == RunStateChangeListener.State.finish) {
                fv5.b("跑步已经结束，请长按结束");
                return false;
            }
            setRunState(RunStateChangeListener.State.normal, true, null);
            return true;
        }
        if ((iM1 & 1) > 0) {
            fv5.a(R.string.run_out_of_geofence_warn);
            return false;
        }
        if ((iM1 & 2) > 0) {
            fv5.a(R.string.use_wifi_warn);
        }
        return false;
    }

    public void saveFaceExtend(RunFaceCheckExtendBean extendBean, int faceCheckIndex) {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.e2(extendBean, faceCheckIndex);
        }
    }

    public void saveFacePopData() {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.f2();
        }
    }

    public void startFaceRecognition() {
        setRunState(RunStateChangeListener.State.faceRecognition, true, null);
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.u2();
        }
    }

    public void startNFCCheck() {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.a2();
        }
        setRunState(RunStateChangeListener.State.nfcCheck, true, null);
    }

    public void stopFaceRecognition(@NonNull DetectResultBean resultBean) {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent != null) {
            dataComponent.g2(resultBean);
        }
    }

    public void stopNFCCheck() {
        setRunState(RunStateChangeListener.State.normal, true, null);
        queryNfcVerificationNow();
    }

    public final void t(int cheatType) {
        boolean z;
        boolean z2;
        if (((BaseRunService) this).f12574a == RunStateChangeListener.State.finish) {
            return;
        }
        boolean z3 = false;
        if (((BaseRunService) this).f12580a.S0() < 100) {
            z2 = true;
            z = false;
        } else {
            z = true;
            z2 = false;
        }
        if (((BaseRunService) this).f12580a.Q0() < 30) {
            z2 = true;
            z = false;
        }
        if (((BaseRunService) this).f12580a.L1()) {
            z = false;
        }
        if (((BaseRunService) this).f12580a.p1() != null && ((BaseRunService) this).f12580a.S0() < ((BaseRunService) this).f12580a.f1()) {
            z = false;
        }
        if (!((BaseRunService) this).f12580a.G0()) {
            z = false;
        }
        if (((BaseRunService) this).f12580a.P0() > 0) {
            DataComponent dataComponent = ((BaseRunService) this).f12580a;
            if (dataComponent.P1(dataComponent.J0())) {
                z3 = z;
            }
        }
        u(true, z2, z3, cheatType);
    }

    public final void u(boolean isAuto, boolean isDataError, boolean isValid, int cheatType) {
        if (this.f12602a) {
            return;
        }
        this.f12602a = true;
        setRunState(RunStateChangeListener.State.finish, !isAuto, null);
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        dataComponent.B(dataComponent.t1(isValid, cheatType), new b(true, cheatType, isDataError, isAuto));
    }

    public void updateRecognitionPauseLeftTime(int useTime) {
        DataComponent dataComponent = ((BaseRunService) this).f12580a;
        if (dataComponent == null) {
            return;
        }
        dataComponent.p2(dataComponent.u1().getFaceCheckData().getFaceUseSaveTime() + (((long) useTime) * 1000), PauseTimerType.FACE_RECOGNITION);
        if (((BaseRunService) this).f12580a.u1().getFaceCheckData().getFaceLeftTime() <= 0) {
            ((BaseRunService) this).f12580a.u2();
            restoreShowFaceRecognitionTip();
        }
    }

    public final boolean v() {
        RunStateChangeListener.State state;
        RunStateChangeListener.State state2 = ((BaseRunService) this).f12574a;
        boolean z = state2 == RunStateChangeListener.State.normal && ((state = ((BaseRunService) this).f12583b) == RunStateChangeListener.State.userPause || state == RunStateChangeListener.State.autoPause || state == RunStateChangeListener.State.faceRecognition || state == RunStateChangeListener.State.nfcCheck);
        if (z) {
            ((BaseRunService) this).f12583b = state2;
        }
        return z;
    }

    public final void w() {
        SunshineRunNotificationHelper.d().b(this);
        SunshineRunNotificationHelper.d().o(new a());
    }
}
