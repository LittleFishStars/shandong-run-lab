package com.huachenjie.run.utils;

import android.taobao.windvane.b.d;
import androidx.annotation.Nullable;
import androidx.room.migration.Migration;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.CollectionUtils;
import com.huachenjie.common.bean.InvalidReason;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.bean.SunshineRunServiceData;
import com.huachenjie.run.database.SunshineRunDataBase;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.run.service.SunshineRunService;
import com.huachenjie.run.utils.StopRunUtils;
import com.zj.adlib.aw8;
import com.zj.adlib.d60;
import com.zj.adlib.fj7;
import com.zj.adlib.fv5;
import com.zj.adlib.ud7;
import com.zj.adlib.wv8;
import com.zj.adlib.xv8;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class StopRunUtils {

    public interface StopCallback {
        default void onFailed(int code, String message) {
        }

        default void onFinish() {
        }

        default void onSuccess(JSONObject data) {
        }
    }

    public class a extends BizSubscriber<JSONObject> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StopCallback f36009a;

        public a(final int val$sportType, final StopCallback val$callback) {
            this.K = val$sportType;
            this.f36009a = val$callback;
        }

        public void onFailed(int code, String message) {
            StopRunUtils.i(code, message);
            StopCallback stopCallback = this.f36009a;
            if (stopCallback != null) {
                stopCallback.onFailed(code, message);
            }
        }

        public void onFinish() {
            super.onFinish();
            StopCallback stopCallback = this.f36009a;
            if (stopCallback != null) {
                stopCallback.onFinish();
            }
        }

        public void onCCSuccess(JSONObject data) {
            StopRunUtils.j();
            if (this.K == 1) {
                ud7.b();
            }
            StopCallback stopCallback = this.f36009a;
            if (stopCallback != null) {
                stopCallback.onSuccess(data);
            }
        }
    }

    public class b extends BizSubscriber<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StopCallback f36010a;

        public b(final StopCallback val$callback) {
            this.f36010a = val$callback;
        }

        public void onFailed(int code, String message) {
            StopRunUtils.i(code, message);
            StopCallback stopCallback = this.f36010a;
            if (stopCallback != null) {
                stopCallback.onFailed(code, message);
            }
        }

        public void onFinish() {
            super.onFinish();
            StopCallback stopCallback = this.f36010a;
            if (stopCallback != null) {
                stopCallback.onFinish();
            }
        }

        public void onCCSuccess(JSONObject data) {
            StopRunUtils.j();
            StopCallback stopCallback = this.f36010a;
            if (stopCallback != null) {
                stopCallback.onSuccess(data);
            }
        }
    }

    public static void g(String runRecordCode, Map<String, Object> params) {
        SunshineRunDataBase sunshineRunDataBase = (SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        List<RunLatLng> listB = sunshineRunDataBase.c().b(arrayList, true, runRecordCode);
        if (listB != null && !listB.isEmpty()) {
            params.put("pois", listB);
        }
        List<IntervalStep> listB2 = sunshineRunDataBase.e().b(false, runRecordCode);
        if (listB2 != null && !listB2.isEmpty()) {
            params.put("stepList", listB2);
        }
        List<IntervalPace> listB3 = sunshineRunDataBase.d().b(false, runRecordCode);
        IntervalPace intervalPaceC = sunshineRunDataBase.d().c(runRecordCode);
        if (intervalPaceC != null && !intervalPaceC.isValid()) {
            listB3.add(intervalPaceC);
        }
        if (listB3 == null || listB3.isEmpty()) {
            return;
        }
        params.put("paceList", listB3);
    }

    public static int h(String runRecordCode) {
        SunshineRunServiceData sunshineRunServiceDataB = xv8.b();
        if (sunshineRunServiceDataB == null || sunshineRunServiceDataB.getRunData() == null || !runRecordCode.equals(sunshineRunServiceDataB.getRunData().getRunRecordCode())) {
            return d.aa;
        }
        return sunshineRunServiceDataB.getIsFinish() ? 7003 : 0;
    }

    public static void i(int code, String message) {
        fv5.a(R.string.finish_run_failed_warn);
    }

    public static void j() {
        SunshineRunService.stopService(ActivityLifecycleManager.l().m());
        xv8.f();
        Observable.h1(new Observable.OnSubscribe() { // from class: com.zj.adlib.tr8
            public final void call(Object obj) {
                StopRunUtils.k((Subscriber) obj);
            }
        }).u5(Schedulers.io()).n5();
    }

    public static /* synthetic */ void k(Subscriber subscriber) {
        ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).clearAllTables();
    }

    public static /* synthetic */ Observable l(aw8 aw8Var, Map map, Object obj) {
        return aw8Var.b(map);
    }

    public static /* synthetic */ Observable m(aw8 aw8Var, Map map, Object obj) {
        return aw8Var.a(map);
    }

    public static /* synthetic */ void n(int i, String str, Map map, Subscriber subscriber) {
        if (i == 0 || i == 7003) {
            g(str, map);
        }
        subscriber.onNext((Object) null);
        subscriber.onCompleted();
    }

    public static void o(UnfinishedRun unfinishedRun, int checkData, @Nullable StopCallback callback) {
        if (unfinishedRun.getSportType() == 1) {
            q(unfinishedRun.getRunRecordCode(), checkData, 1, callback);
            return;
        }
        if (unfinishedRun.getSportType() == 6) {
            q(unfinishedRun.getRunRecordCode(), checkData, 6, callback);
        } else if (unfinishedRun.getSportType() == 2) {
            HashMap map = new HashMap();
            map.put("runRecordCode", unfinishedRun.getRunRecordCode());
            p(map, callback);
        }
    }

    public static void p(Map<String, Object> params, @Nullable StopCallback callback) {
        new aw8().d(params).u5(Schedulers.io()).G3(d60.c()).p5(new b(callback));
    }

    public static void q(final String runRecordCode, final int checkData, int sportType, @Nullable StopCallback callback) {
        final HashMap map = new HashMap();
        map.put("runRecordCode", runRecordCode);
        if (checkData == 0 || checkData == 7003) {
            SunshineRunServiceData sunshineRunServiceDataB = xv8.b();
            map.put("duration", String.valueOf((sunshineRunServiceDataB.getCurrentTime() + sunshineRunServiceDataB.getSaveCurrentTime()) / 1000));
            map.put(SchoolActivitySuccessActivity.x, String.valueOf(sunshineRunServiceDataB.getRunData().getDistance()));
            map.put("totalStep", String.valueOf(Math.max(0, sunshineRunServiceDataB.getRunData().getTotalStep())));
            map.put("stepInterval", Integer.valueOf(sunshineRunServiceDataB.getCommonConfig().getStepInterval()));
            map.put("paceInterval", Long.valueOf(sunshineRunServiceDataB.getCommonConfig().getPaceInterval()));
            if (sunshineRunServiceDataB.getStartRunEntity() != null && CollectionUtils.t(sunshineRunServiceDataB.getStartRunEntity().getTargetPoints())) {
                map.put("targetPoints", sunshineRunServiceDataB.getStartRunEntity().getTargetPoints());
            }
            map.put("alignType", Integer.valueOf(sunshineRunServiceDataB.getAmapGPSLevel()));
            map.put("pauseCount", Integer.valueOf(sunshineRunServiceDataB.getPauseCount()));
            map.put("pauseTimes", Long.valueOf((sunshineRunServiceDataB.getSavePauseTime() + sunshineRunServiceDataB.getPauseTime()) / 1000));
            if (!sunshineRunServiceDataB.getCheatResult().isEmpty()) {
                map.put("cheatList", sunshineRunServiceDataB.getCheatResult().values());
            }
            if (sunshineRunServiceDataB.getStopStatus() >= 0) {
                map.put("status", Integer.valueOf(sunshineRunServiceDataB.getStopStatus()));
            }
            List<InvalidReason> listE = new wv8(sunshineRunServiceDataB).e(0);
            if (listE != null && !listE.isEmpty()) {
                map.put("invalidReasons", listE);
            }
            if (sunshineRunServiceDataB.getRunScene() == 20 && sunshineRunServiceDataB.getFaceCheckData().getFaceAuth()) {
                map.put("faceCheckRecordList", sunshineRunServiceDataB.getFaceCheckData().getFaceCheckRecordList());
            }
        }
        if (checkData != 0) {
            map.put("abnormalCodes", new int[]{checkData});
        }
        final aw8 aw8Var = new aw8();
        Observable.h1(new Observable.OnSubscribe() { // from class: com.zj.adlib.wr8
            public final void call(Object obj) {
                StopRunUtils.n(checkData, runRecordCode, map, (Subscriber) obj);
            }
        }).Z1(sportType == 1 ? new Func1() { // from class: com.zj.adlib.ur8
            public final Object call(Object obj) {
                return StopRunUtils.l(aw8Var, map, obj);
            }
        } : new Func1() { // from class: com.zj.adlib.vr8
            public final Object call(Object obj) {
                return StopRunUtils.m(aw8Var, map, obj);
            }
        }).u5(Schedulers.io()).G3(d60.c()).p5(new a(sportType, callback));
    }
}
