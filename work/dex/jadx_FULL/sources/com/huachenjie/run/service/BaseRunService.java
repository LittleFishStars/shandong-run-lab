package com.huachenjie.run.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.run_component.GeoFenceComponentV2;
import com.huachenjie.common.run_component.LocationComponent;
import com.huachenjie.common.run_component.NetworkStateComponent;
import com.huachenjie.common.run_component.PauseTimerType;
import com.huachenjie.common.run_component.StepComponent;
import com.huachenjie.common.run_component.TimeComponent;
import com.huachenjie.common.run_interface.RunStateChangeListener;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.CheatResult;
import com.huachenjie.run.component.CheatingDetectionComponent;
import com.huachenjie.run.dialog.OnActionListener;
import com.huachenjie.run.service.BaseRunService;
import com.zj.adlib.c25;
import com.zj.adlib.i4a;
import huachenjie.sdk.map.adapter.location.model.HCJGeoFence;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class BaseRunService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GeoFenceComponentV2 f12564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationComponent f12567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NetworkStateComponent f12569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StepComponent f12571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TimeComponent f12573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CheatingDetectionComponent f12576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DurationCallBack f12578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DataComponent f12580a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TimeComponent f12582b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public DurationCallBack f12584b;
    public TimeComponent c;
    public TimeComponent d;
    public TimeComponent e;
    public final String f = getClass().getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<RunStateChangeListener> f12581a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NetworkStateComponent.NetworkChangeListener f12568a = new NetworkStateComponent.NetworkChangeListener() { // from class: com.zj.adlib.hr0
        @Override // com.huachenjie.common.run_component.NetworkStateComponent.NetworkChangeListener
        public final void a(int i) {
            this.f42184a.onNetworkStateChange(i);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LocationComponent.LocationCallbackListener f12566a = new LocationComponent.LocationCallbackListener() { // from class: com.zj.adlib.ir0
        @Override // com.huachenjie.common.run_component.LocationComponent.LocationCallbackListener
        public final void a(HCJAddressInfo hCJAddressInfo, boolean z) {
            this.f42425a.onLocation(hCJAddressInfo, z);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LocationComponent.GPSSignalListener f12565a = new LocationComponent.GPSSignalListener() { // from class: com.zj.adlib.jr0
        @Override // com.huachenjie.common.run_component.LocationComponent.GPSSignalListener
        public final void a(int i, int i2) {
            this.f42650a.onGpsSignal(i, i2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CheatingDetectionComponent.DetectionCallback f12575a = new CheatingDetectionComponent.DetectionCallback() { // from class: com.zj.adlib.kr0
        @Override // com.huachenjie.run.component.CheatingDetectionComponent.DetectionCallback
        public final void a(Map map) {
            this.f42891a.onCheatChange(map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeoFenceComponentV2.GeoFenceActionListener f35989a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StepComponent.StepChangeCallBack f12570a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RunStateChangeListener.State f12574a = RunStateChangeListener.State.preStart;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RunStateChangeListener.State f12583b = RunStateChangeListener.State.normal;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GeoFenceComponentV2.GeoFenceCreateListener f12563a = new c();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataComponent.InnerDataChangeCallback f12579a = new d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TimeComponent.TimeChangeListener f12572a = new e();
    public final TimeComponent.TimeChangeListener b = new f();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnActionListener f12577a = null;

    public interface DataChangeCallBack {

        public enum DataType {
            LocationChange,
            PassedPoint,
            ClosingTargetPoint,
            FarAwayTargetPoint,
            GpsSignal,
            VolumeChange,
            LOCK_SCREEN,
            GeoFenceLoaded,
            EnterSchoolFence,
            LeaveSchoolFence,
            NetworkState,
            StepChanged,
            ClosingClockPoint,
            FarAwayClockPoint,
            FaceRecognitionTip,
            NfcVerification
        }

        void a(DataType type, DataComponent dataComponent);
    }

    public interface DurationCallBack {
        void a(PauseTimerType type, long duration);
    }

    public class a implements GeoFenceComponentV2.GeoFenceActionListener {
        public a() {
        }

        @Override // com.huachenjie.common.run_component.GeoFenceComponentV2.GeoFenceActionListener
        public void a(String customerId) {
            BaseRunService.this.leaveFence(customerId);
        }

        @Override // com.huachenjie.common.run_component.GeoFenceComponentV2.GeoFenceActionListener
        public void b(String customerId) {
            BaseRunService.this.enterFence(customerId);
        }
    }

    public class b implements StepComponent.StepChangeCallBack {
        public b() {
        }

        @Override // com.huachenjie.common.run_component.StepComponent.StepChangeCallBack
        public void a(int stepCount) {
            BaseRunService.this.onCountSensorStepChange(stepCount);
        }
    }

    public class c implements GeoFenceComponentV2.GeoFenceCreateListener {
        public c() {
        }

        @Override // com.huachenjie.common.run_component.GeoFenceComponentV2.GeoFenceCreateListener
        public void a(String customerId, List<HCJGeoFence> geoFenceList) {
            DataComponent dataComponent = BaseRunService.this.f12580a;
            if (dataComponent != null) {
                dataComponent.w0(geoFenceList, customerId);
            }
        }

        @Override // com.huachenjie.common.run_component.GeoFenceComponentV2.GeoFenceCreateListener
        public void fail(String customerId) {
        }
    }

    public class d implements DataComponent.InnerDataChangeCallback {
        public d() {
        }

        @Override // com.huachenjie.run.service.DataComponent.InnerDataChangeCallback
        public void a() {
            TimeComponent timeComponent = BaseRunService.this.e;
            if (timeComponent != null) {
                timeComponent.i();
            }
        }

        @Override // com.huachenjie.run.service.DataComponent.InnerDataChangeCallback
        public void b() {
            TimeComponent timeComponent = BaseRunService.this.d;
            if (timeComponent != null) {
                timeComponent.i();
            }
        }
    }

    public class e implements TimeComponent.TimeChangeListener {
        public e() {
        }

        @Override // com.huachenjie.common.run_component.TimeComponent.TimeChangeListener
        public void a(long elapsedTime, PauseTimerType type) {
            i4a.b(BaseRunService.this.f, "onTimeChange 时间计时器正在工作");
            DataComponent dataComponent = BaseRunService.this.f12580a;
            if (dataComponent != null) {
                elapsedTime = dataComponent.h2(elapsedTime);
            }
            BaseRunService.this.onDurationChange(type, elapsedTime);
            DurationCallBack durationCallBack = BaseRunService.this.f12578a;
            if (durationCallBack != null) {
                durationCallBack.a(type, elapsedTime);
            }
        }
    }

    public class f implements TimeComponent.TimeChangeListener {
        public f() {
        }

        @Override // com.huachenjie.common.run_component.TimeComponent.TimeChangeListener
        public void a(long elapsedTime, PauseTimerType type) {
            DataComponent dataComponent;
            BaseRunService baseRunService = BaseRunService.this;
            if (baseRunService.f12580a != null) {
                i4a.b(baseRunService.f, "开始保存暂停时间：" + type + "|" + elapsedTime);
                BaseRunService.this.f12580a.o2(elapsedTime, type);
            }
            BaseRunService.this.onPauseDurationChange(elapsedTime, type);
            BaseRunService baseRunService2 = BaseRunService.this;
            DurationCallBack durationCallBack = baseRunService2.f12584b;
            if (durationCallBack == null || (dataComponent = baseRunService2.f12580a) == null) {
                return;
            }
            durationCallBack.a(type, dataComponent.k1(type));
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35996a;

        static {
            int[] iArr = new int[RunStateChangeListener.State.values().length];
            f35996a = iArr;
            try {
                iArr[RunStateChangeListener.State.normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35996a[RunStateChangeListener.State.userPause.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static /* synthetic */ Thread g(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        return thread;
    }

    public static /* synthetic */ Thread h(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        return thread;
    }

    public static /* synthetic */ Thread i(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        return thread;
    }

    public static /* synthetic */ Thread j(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        return thread;
    }

    public static /* synthetic */ Thread k(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        return thread;
    }

    public abstract boolean checkStateChange(RunStateChangeListener.State state, boolean fromUser);

    public abstract void enterFence(String customerId);

    public final void f() {
        TimeComponent timeComponent = new TimeComponent(new ThreadFactory() { // from class: com.zj.adlib.lr0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BaseRunService.g(runnable);
            }
        }, PauseTimerType.NONE);
        this.f12573a = timeComponent;
        timeComponent.j(this.f12572a);
        TimeComponent timeComponent2 = new TimeComponent(new ThreadFactory() { // from class: com.zj.adlib.mr0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BaseRunService.h(runnable);
            }
        }, PauseTimerType.REST);
        this.f12582b = timeComponent2;
        timeComponent2.j(this.b);
        TimeComponent timeComponent3 = new TimeComponent(new ThreadFactory() { // from class: com.zj.adlib.nr0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BaseRunService.i(runnable);
            }
        }, PauseTimerType.AUTO);
        this.c = timeComponent3;
        timeComponent3.j(this.b);
        TimeComponent timeComponent4 = new TimeComponent(new ThreadFactory() { // from class: com.zj.adlib.or0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BaseRunService.j(runnable);
            }
        }, PauseTimerType.FACE_RECOGNITION);
        this.d = timeComponent4;
        timeComponent4.j(this.b);
        TimeComponent timeComponent5 = new TimeComponent(new ThreadFactory() { // from class: com.zj.adlib.pr0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return BaseRunService.k(runnable);
            }
        }, PauseTimerType.NFC_CHECK);
        this.e = timeComponent5;
        timeComponent5.j(this.b);
    }

    public DataComponent getDataComponent() {
        return this.f12580a;
    }

    public RunStateChangeListener.State getRunState() {
        return this.f12574a;
    }

    public final void l(RunStateChangeListener.State state, Map<String, Object> map) {
        if (RunStateChangeListener.State.autoPause == state) {
            TimeComponent timeComponent = this.c;
            if (timeComponent != null) {
                timeComponent.a(PauseTimerType.AUTO, state, map);
                return;
            }
            return;
        }
        if (RunStateChangeListener.State.userPause == state) {
            TimeComponent timeComponent2 = this.f12582b;
            if (timeComponent2 != null) {
                timeComponent2.a(PauseTimerType.REST, state, map);
                return;
            }
            return;
        }
        if (RunStateChangeListener.State.faceRecognition == state) {
            TimeComponent timeComponent3 = this.d;
            if (timeComponent3 != null) {
                timeComponent3.a(PauseTimerType.FACE_RECOGNITION, state, map);
                return;
            }
            return;
        }
        if (RunStateChangeListener.State.nfcCheck == state) {
            TimeComponent timeComponent4 = this.e;
            if (timeComponent4 != null) {
                timeComponent4.a(PauseTimerType.NFC_CHECK, state, map);
                return;
            }
            return;
        }
        i4a.b(this.f, "准备通知两个暂停倒计时器 state==" + state);
        TimeComponent timeComponent5 = this.c;
        if (timeComponent5 != null) {
            timeComponent5.a(PauseTimerType.AUTO, state, map);
        }
        TimeComponent timeComponent6 = this.f12582b;
        if (timeComponent6 != null) {
            timeComponent6.a(PauseTimerType.REST, state, map);
        }
        TimeComponent timeComponent7 = this.d;
        if (timeComponent7 != null) {
            timeComponent7.a(PauseTimerType.FACE_RECOGNITION, state, map);
        }
        TimeComponent timeComponent8 = this.e;
        if (timeComponent8 != null) {
            timeComponent8.a(PauseTimerType.NFC_CHECK, state, map);
        }
    }

    public abstract void leaveFence(String customerId);

    public void loadGeoFence(Map<String, GeoFenceDetail> fenceDetailMap, Map<String, HCJLatLng> validPointMap, Map<String, HCJLatLng> sensitivePointMap, CommonConfig config) {
        GeoFenceComponentV2 geoFenceComponentV2 = this.f12564a;
        if (geoFenceComponentV2 != null) {
            geoFenceComponentV2.e(fenceDetailMap, validPointMap, sensitivePointMap, config);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public abstract void onCheatChange(Map<Integer, CheatResult> cheatResult);

    public abstract void onCountSensorStepChange(int stepCount);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c25.y("onCreate");
        DataComponent dataComponent = new DataComponent(this);
        this.f12580a = dataComponent;
        dataComponent.onCreate();
        this.f12580a.k2(this.f12579a);
        NetworkStateComponent networkStateComponent = new NetworkStateComponent(this);
        this.f12569a = networkStateComponent;
        networkStateComponent.h(this.f12568a);
        LocationComponent locationComponent = new LocationComponent(this);
        this.f12567a = locationComponent;
        locationComponent.l(this.f12566a);
        this.f12567a.k(this.f12565a);
        GeoFenceComponentV2 geoFenceComponentV2 = new GeoFenceComponentV2(this);
        this.f12564a = geoFenceComponentV2;
        geoFenceComponentV2.i(this.f35989a);
        this.f12564a.j(this.f12563a);
        f();
        StepComponent stepComponent = new StepComponent(this);
        this.f12571a = stepComponent;
        stepComponent.i(this.f12570a);
        CheatingDetectionComponent cheatingDetectionComponent = new CheatingDetectionComponent();
        this.f12576a = cheatingDetectionComponent;
        cheatingDetectionComponent.h(this.f12575a);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterCallBack();
        DataComponent dataComponent = this.f12580a;
        if (dataComponent != null) {
            dataComponent.onDestroy();
        }
    }

    public abstract void onDurationChange(PauseTimerType type, long elapsedTime);

    public abstract void onGpsSignal(int signalIntensity, int satellites);

    public abstract void onLocation(HCJAddressInfo addressInfo, boolean locationEnable);

    public abstract void onNetworkStateChange(int networkState);

    public abstract void onPauseDurationChange(long elapsedTime, PauseTimerType type);

    public abstract void onRunStateChange(RunStateChangeListener.State state);

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        this.f12578a = null;
        this.f12584b = null;
        return super.onUnbind(intent);
    }

    public void setDataCallBack(DataChangeCallBack dataCallBack) {
        DataComponent dataComponent = this.f12580a;
        if (dataComponent != null) {
            dataComponent.i2(dataCallBack);
        }
    }

    public void setDurationCallBack(DurationCallBack durationCallBack) {
        this.f12578a = durationCallBack;
    }

    public void setOnNotificationModStateCB(OnActionListener onNotificationPauseListener) {
        this.f12577a = onNotificationPauseListener;
    }

    public void setPauseDurationCallBack(DurationCallBack pauseDurationCallBack) {
        this.f12584b = pauseDurationCallBack;
    }

    public boolean setRunState(RunStateChangeListener.State state, boolean fromUser, Map<String, Object> map) {
        if (!checkStateChange(state, fromUser)) {
            return false;
        }
        this.f12583b = this.f12574a;
        this.f12574a = state;
        if (fromUser) {
            int i = g.f35996a[state.ordinal()];
            if (i == 1) {
                this.f12580a.V1(R.raw.run_resume);
            } else if (i == 2) {
                this.f12580a.V1(R.raw.run_pause);
            }
        }
        StepComponent stepComponent = this.f12571a;
        if (stepComponent != null) {
            stepComponent.b(state, map);
        }
        TimeComponent timeComponent = this.f12573a;
        if (timeComponent != null) {
            timeComponent.a(PauseTimerType.NONE, state, map);
        }
        l(state, map);
        if (this.f12574a == RunStateChangeListener.State.finish) {
            unregisterCallBack();
        }
        onRunStateChange(state);
        Iterator<RunStateChangeListener> it = this.f12581a.iterator();
        while (it.hasNext()) {
            it.next().b(state, map);
        }
        return true;
    }

    public void setRunStateChangeListeners(RunStateChangeListener... listeners) {
        this.f12581a.clear();
        if (listeners == null || listeners.length == 0) {
            return;
        }
        this.f12581a.addAll(Arrays.asList(listeners));
    }

    public void unregisterCallBack() {
        NetworkStateComponent networkStateComponent = this.f12569a;
        if (networkStateComponent != null) {
            networkStateComponent.onDestroy();
        }
        LocationComponent locationComponent = this.f12567a;
        if (locationComponent != null) {
            locationComponent.onDestroy();
        }
        GeoFenceComponentV2 geoFenceComponentV2 = this.f12564a;
        if (geoFenceComponentV2 != null) {
            geoFenceComponentV2.onDestroy();
        }
        TimeComponent timeComponent = this.f12573a;
        if (timeComponent != null) {
            timeComponent.onDestroy();
        }
        TimeComponent timeComponent2 = this.f12582b;
        if (timeComponent2 != null) {
            timeComponent2.onDestroy();
        }
        TimeComponent timeComponent3 = this.c;
        if (timeComponent3 != null) {
            timeComponent3.onDestroy();
        }
        TimeComponent timeComponent4 = this.d;
        if (timeComponent4 != null) {
            timeComponent4.onDestroy();
        }
        TimeComponent timeComponent5 = this.e;
        if (timeComponent5 != null) {
            timeComponent5.onDestroy();
        }
        StepComponent stepComponent = this.f12571a;
        if (stepComponent != null) {
            stepComponent.onDestroy();
        }
        CheatingDetectionComponent cheatingDetectionComponent = this.f12576a;
        if (cheatingDetectionComponent != null) {
            cheatingDetectionComponent.onDestroy();
        }
    }
}
