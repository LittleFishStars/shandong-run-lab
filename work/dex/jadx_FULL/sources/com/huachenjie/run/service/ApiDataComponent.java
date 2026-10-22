package com.huachenjie.run.service;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.text.TextUtils;
import androidx.room.migration.Migration;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.ThreadUtils;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.common.callback.ValueCallback;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.bean.UploadData;
import com.huachenjie.run.callback.ValueCallBack;
import com.huachenjie.run.database.SunshineRunDataBase;
import com.huachenjie.run.database.dao.PaceDao;
import com.huachenjie.run.database.dao.StepDao;
import com.huachenjie.run.service.ApiDataComponent;
import com.zj.adlib.c25;
import com.zj.adlib.d60;
import com.zj.adlib.dx4;
import com.zj.adlib.fj7;
import com.zj.adlib.gq1;
import com.zj.adlib.i4a;
import com.zj.adlib.km7;
import com.zj.adlib.n76;
import com.zj.adlib.xv8;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.lifecycle.ILifeCycle;
import huachenjie.sdk.http.subscriber.BaseSubscriber;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class ApiDataComponent extends BaseSimpleComponent implements ILifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HandleRunError f12551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dx4 f12552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gq1 f12553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public km7 f12554a;
    public final String f = getClass().getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f12555a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Object f12557b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f35979a = 0;
    public long b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f12556a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f12558b = false;

    public interface HandleRunError {
        boolean a(int code, String message);
    }

    public class a extends Subscriber<List<RunLatLng>> {
        public final /* synthetic */ String f;

        /* JADX INFO: renamed from: com.huachenjie.run.service.ApiDataComponent$a$a, reason: collision with other inner class name */
        public class C0822a extends BizSubscriber<UploadData> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ List f12559a;

            public C0822a(final List val$localIDs) {
                this.f12559a = val$localIDs;
            }

            public static /* synthetic */ void M(UploadData uploadData, ObservableEmitter observableEmitter) throws Exception {
                List<Integer> indexList = uploadData.getIndexList();
                int i = 0;
                while (i < indexList.size()) {
                    int i2 = i + 200;
                    ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).c().d(indexList.subList(i, Math.min(indexList.size(), i2)), 8);
                    i = i2;
                }
            }

            public static /* synthetic */ void R(Object obj) throws Exception {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void S(List list, ObservableEmitter observableEmitter) throws Exception {
                int i = 0;
                while (i < list.size()) {
                    int i2 = i + 200;
                    ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).c().d(list.subList(i, Math.min(list.size(), i2)), 4);
                    i = i2;
                }
                i4a.b(ApiDataComponent.this.f, "上传失败的记录已修改为失败的状态");
            }

            public static /* synthetic */ void T(Object obj) throws Exception {
            }

            public void onFailed(int code, String message) {
                final List list = this.f12559a;
                Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.u80
                    public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                        this.f45083a.S(list, observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.v80
                    public final void accept(Object obj) throws Exception {
                        ApiDataComponent.a.C0822a.T(obj);
                    }
                });
            }

            public void onCCSuccess(final UploadData data) {
                if (data == null || data.getIndexList() == null || data.getIndexList().isEmpty()) {
                    return;
                }
                Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.s80
                    public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                        ApiDataComponent.a.C0822a.M(data, observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.t80
                    public final void accept(Object obj) throws Exception {
                        ApiDataComponent.a.C0822a.R(obj);
                    }
                });
            }
        }

        public a(final String val$runRecordCode) {
            this.f = val$runRecordCode;
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(List<RunLatLng> runLatLngs) {
            if (runLatLngs == null || runLatLngs.size() == 0 || TextUtils.isEmpty(this.f)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<RunLatLng> it = runLatLngs.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf((int) it.next().getId()));
            }
            ApiDataComponent apiDataComponent = ApiDataComponent.this;
            n76.e(apiDataComponent, apiDataComponent.f12554a.j(runLatLngs, this.f)).p5(new C0822a(arrayList));
        }

        public void onCompleted() {
        }

        public void onError(Throwable e) {
        }
    }

    public class b extends Subscriber<List<IntervalPace>> {
        public final /* synthetic */ long c;
        public final /* synthetic */ String f;

        public class a extends BizSubscriber<UploadData> {
            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void I(Object obj) throws Exception {
                ApiDataComponent.this.f12558b = false;
            }

            public static /* synthetic */ void w(UploadData uploadData, ObservableEmitter observableEmitter) throws Exception {
                List<Integer> indexList = uploadData.getIndexList();
                int i = 0;
                while (i < indexList.size()) {
                    int i2 = i + 200;
                    ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).d().a(indexList.subList(i, Math.min(indexList.size(), i2)));
                    i = i2;
                }
            }

            public void onFinish() {
                super.onFinish();
                ApiDataComponent.this.f12558b = false;
            }

            public void onCCSuccess(final UploadData data) {
                if (data == null || data.getIndexList() == null || data.getIndexList().isEmpty()) {
                    return;
                }
                Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.w80
                    public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                        ApiDataComponent.b.a.w(data, observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.x80
                    public final void accept(Object obj) throws Exception {
                        this.f45763a.I(obj);
                    }
                });
            }
        }

        public b(final String val$runRecordCode, final long val$paceInterval) {
            this.f = val$runRecordCode;
            this.c = val$paceInterval;
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(List<IntervalPace> paceList) {
            if (paceList == null || paceList.size() <= 0 || TextUtils.isEmpty(this.f)) {
                ApiDataComponent.this.f12558b = false;
            } else {
                ApiDataComponent apiDataComponent = ApiDataComponent.this;
                n76.e(apiDataComponent, apiDataComponent.f12554a.h(paceList, this.c, this.f)).p5(new a());
            }
        }

        public void onCompleted() {
            ApiDataComponent.this.f12558b = false;
        }

        public void onError(Throwable e) {
            ApiDataComponent.this.f12558b = false;
        }
    }

    public class c extends Subscriber<List<IntervalStep>> {
        public final /* synthetic */ long c;
        public final /* synthetic */ String f;

        public class a extends BizSubscriber<UploadData> {
            public a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void I(Object obj) throws Exception {
                ApiDataComponent.this.f12556a = false;
            }

            public static /* synthetic */ void w(UploadData uploadData, ObservableEmitter observableEmitter) throws Exception {
                if (uploadData == null || uploadData.getIndexList() == null || uploadData.getIndexList().isEmpty()) {
                    return;
                }
                List<Integer> indexList = uploadData.getIndexList();
                int i = 0;
                while (i < indexList.size()) {
                    int i2 = i + 200;
                    ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).e().a(indexList.subList(i, Math.min(indexList.size(), i2)));
                    i = i2;
                }
            }

            public boolean onBizError(BaseEntity baseEntity) {
                if (ApiDataComponent.this.F(baseEntity.code, baseEntity.message)) {
                    return true;
                }
                return super.onBizError(baseEntity);
            }

            public void onFinish() {
                super.onFinish();
                ApiDataComponent.this.f12556a = false;
            }

            public void onCCSuccess(final UploadData data) {
                Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.y80
                    public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                        ApiDataComponent.c.a.w(data, observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.z80
                    public final void accept(Object obj) throws Exception {
                        this.f46207a.I(obj);
                    }
                });
            }
        }

        public c(final String val$runRecordCode, final long val$stepInterval) {
            this.f = val$runRecordCode;
            this.c = val$stepInterval;
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(List<IntervalStep> stepList) {
            if (stepList == null || stepList.size() <= 0 || TextUtils.isEmpty(this.f)) {
                ApiDataComponent.this.f12556a = false;
            } else {
                ApiDataComponent apiDataComponent = ApiDataComponent.this;
                n76.e(apiDataComponent, apiDataComponent.f12554a.k(stepList, this.c, this.f)).p5(new a());
            }
        }

        public void onCompleted() {
            ApiDataComponent.this.f12556a = false;
        }

        public void onError(Throwable e) {
            ApiDataComponent.this.f12556a = false;
        }
    }

    public class d extends BizSubscriber<UploadData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallBack f35986a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f12561a;

        public d(final ValueCallBack val$callBack, final Map val$strideList) {
            this.f35986a = val$callBack;
            this.f12561a = val$strideList;
        }

        public void onCCSuccess(UploadData data) {
            ValueCallBack valueCallBack = this.f35986a;
            if (valueCallBack != null) {
                valueCallBack.a(this.f12561a);
            }
            i4a.b(ApiDataComponent.this.f, "上传分段步频成功，上传参数" + this.f12561a.toString());
        }
    }

    public class e extends BizSubscriber<JSONObject> {
        public e() {
        }

        public boolean onBizError(BaseEntity baseEntity) {
            if (ApiDataComponent.this.F(baseEntity.code, baseEntity.message)) {
                return true;
            }
            return super.onBizError(baseEntity);
        }

        public void onCCSuccess(JSONObject data) {
        }
    }

    public class f extends BizSubscriber<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f35988a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean showErrorToast, final ValueCallback val$callBack) {
            super(showErrorToast);
            this.f35988a = val$callBack;
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            ValueCallback valueCallback = this.f35988a;
            if (valueCallback != null) {
                valueCallback.onCallback(Boolean.FALSE);
            }
        }

        public void onCCSuccess(JSONObject data) {
            boolean z = data != null && Boolean.TRUE.equals(data.getBoolean("nfcVerified"));
            ValueCallback valueCallback = this.f35988a;
            if (valueCallback != null) {
                valueCallback.onCallback(Boolean.valueOf(z));
            }
        }
    }

    public static /* synthetic */ void G(ObservableEmitter observableEmitter) throws Exception {
        ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).clearAllTables();
    }

    public static /* synthetic */ void H(Object obj) throws Exception {
    }

    public static /* synthetic */ void I(Dialog[] dialogArr) {
        Dialog dialog = dialogArr[0];
        dialogArr[0] = null;
        if (dialog == null) {
            return;
        }
        try {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(Map map, Subscriber subscriber) {
        String strE = E();
        SunshineRunDataBase sunshineRunDataBase = (SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0]);
        List<IntervalPace> listB = sunshineRunDataBase.d().b(false, strE);
        IntervalPace intervalPaceC = sunshineRunDataBase.d().c(strE);
        if (intervalPaceC != null && !intervalPaceC.isValid()) {
            listB.add(intervalPaceC);
        }
        List<IntervalStep> listB2 = sunshineRunDataBase.e().b(false, strE);
        IntervalStep intervalStepE = sunshineRunDataBase.e().e(strE);
        int id = intervalStepE != null ? intervalStepE.getId() + 1 : Integer.MAX_VALUE;
        if (getTailSectionStepData(id) != null) {
            listB2.add(getTailSectionStepData(id));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        List<RunLatLng> listB3 = sunshineRunDataBase.c().b(arrayList, true, strE);
        if (listB3 != null && !listB3.isEmpty()) {
            map.put("pois", listB3);
        }
        if (listB2 != null && !listB2.isEmpty()) {
            map.put("stepList", listB2);
        }
        if (listB != null && !listB.isEmpty()) {
            map.put("paceList", listB);
        }
        subscriber.onNext((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ rx.Observable K(Map map, Object obj) {
        return this.f12554a.c(map);
    }

    public static /* synthetic */ void L(Dialog[] dialogArr) {
        Dialog dialogP = DialogUtil.p(ActivityLifecycleManager.l().m(), false);
        if (dialogP == null) {
            return;
        }
        dialogArr[0] = dialogP;
        try {
            dialogP.show();
        } catch (Exception unused) {
            dialogArr[0] = null;
        }
    }

    public static /* synthetic */ void M(final Dialog[] dialogArr) {
        ThreadUtils.s0(new Runnable() { // from class: com.zj.adlib.f80
            @Override // java.lang.Runnable
            public final void run() {
                ApiDataComponent.L(dialogArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(ObservableEmitter observableEmitter) throws Exception {
        try {
            IntervalStep intervalStepE = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).e().e(E());
            if (intervalStepE == null || intervalStepE.getEndStep() <= 0) {
                return;
            }
            observableEmitter.onNext(Integer.valueOf(intervalStepE.getEndStep()));
        } catch (Exception e2) {
            e2.printStackTrace();
            observableEmitter.onNext(-1);
        }
    }

    public static /* synthetic */ void S(ValueCallBack valueCallBack, Integer num) throws Exception {
        if (valueCallBack == null || num.intValue() <= -1) {
            return;
        }
        valueCallBack.a(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(long j, long j2, int i, ObservableEmitter observableEmitter) throws Exception {
        synchronized (this.f12557b) {
            String strE = E();
            PaceDao paceDaoD = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).d();
            IntervalPace intervalPaceC = paceDaoD.c(strE);
            if (intervalPaceC == null) {
                IntervalPace intervalPace = new IntervalPace();
                intervalPace.setRunCode(strE);
                intervalPace.setStartTime(j);
                intervalPace.setEndTime(j);
                intervalPace.setStartDistance(j2);
                intervalPace.setEndDistance(j2);
                intervalPace.setStartStepCount(i);
                intervalPace.setEndStepCount(i);
                paceDaoD.e(intervalPace);
            } else {
                intervalPaceC.getEndTime();
                intervalPaceC.getEndStepCount();
                if ((j2 - intervalPaceC.getEndDistance()) + intervalPaceC.getDistance() > C().getPaceInterval() || intervalPaceC.isValid()) {
                    intervalPaceC.setValid(true);
                    paceDaoD.d(intervalPaceC);
                    IntervalPace intervalPace2 = new IntervalPace();
                    intervalPace2.setRunCode(strE);
                    intervalPace2.setStartTime(intervalPaceC.getEndTime());
                    intervalPace2.setEndTime(j);
                    intervalPace2.setStartDistance(intervalPaceC.getEndDistance());
                    intervalPace2.setEndDistance(j2);
                    intervalPace2.setStartStepCount(intervalPaceC.getEndStepCount());
                    intervalPace2.setEndStepCount(i);
                    paceDaoD.e(intervalPace2);
                } else {
                    intervalPaceC.setEndTime(j);
                    intervalPaceC.setEndDistance(j2);
                    intervalPaceC.setEndStepCount(i);
                    paceDaoD.d(intervalPaceC);
                }
            }
        }
    }

    public static /* synthetic */ void V(Object obj) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(RunLatLng[] runLatLngArr, ObservableEmitter observableEmitter) throws Exception {
        synchronized (this.f12555a) {
            ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).c().c(runLatLngArr);
        }
    }

    public static /* synthetic */ void X(Object obj) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(long j, int i, int i2, int i3, ObservableEmitter observableEmitter) throws Exception {
        i4a.b(this.f, "****分段步频数据开始保存****");
        String strE = E();
        StepDao stepDaoE = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).e();
        IntervalStep intervalStep = new IntervalStep();
        intervalStep.setRunCode(strE);
        intervalStep.setStartTime(j - ((long) i));
        intervalStep.setEndTime(j);
        intervalStep.setStartStep(i2);
        intervalStep.setEndStep(i3);
        stepDaoE.d(intervalStep);
        observableEmitter.onNext(Integer.valueOf(i3));
        c25.m(this.f, "入库步数信息:currentTime=" + j + "|fromStep-to >>" + i2 + "~" + i3);
        i4a.b(this.f, "保存步数分段操作完成!!!");
    }

    public static /* synthetic */ void Z(ValueCallBack valueCallBack, Integer num) throws Exception {
        if (valueCallBack != null) {
            valueCallBack.a(num);
        }
    }

    public static /* synthetic */ void b0(String str, Subscriber subscriber) {
        List<IntervalPace> listB = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).d().b(false, str);
        if (listB == null || listB.size() < 3) {
            subscriber.onCompleted();
        } else {
            subscriber.onNext(listB);
        }
    }

    public static /* synthetic */ void c0(String str, Subscriber subscriber) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(4);
        List<RunLatLng> listB = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).c().b(arrayList, true, str);
        if (listB == null || listB.size() <= 3) {
            subscriber.onCompleted();
            return;
        }
        subscriber.onNext(listB);
        ArrayList arrayList2 = new ArrayList();
        Iterator<RunLatLng> it = listB.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf((int) it.next().getId()));
        }
        int i = 0;
        while (i < arrayList2.size()) {
            int i2 = i + 200;
            ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).c().d(arrayList2.subList(i, Math.min(arrayList2.size(), i2)), 2);
            i = i2;
        }
        i4a.b("ApiDataComponent", ThreadUtils.r0() + "| 记录状态已更新为上传中;");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(String str, Subscriber subscriber) {
        List<IntervalStep> listB = ((SunshineRunDataBase) fj7.b().a(SunshineRunDataBase.class, new Migration[0])).e().b(false, str);
        if (listB != null && listB.size() >= 3) {
            subscriber.onNext(listB);
        } else {
            subscriber.onCompleted();
            this.f12556a = false;
        }
    }

    public <T extends BaseSubscriber<BaseEntity<FinishRunResult>>> void B(final Map<String, Object> params, T t) {
        final Dialog[] dialogArr = new Dialog[1];
        final Runnable runnable = new Runnable() { // from class: com.zj.adlib.y70
            @Override // java.lang.Runnable
            public final void run() {
                ApiDataComponent.I(dialogArr);
            }
        };
        rx.Observable.h1(new rx.Observable.OnSubscribe() { // from class: com.zj.adlib.z70
            public final void call(Object obj) {
                this.f46199a.J(params, (Subscriber) obj);
            }
        }).Z1(new Func1() { // from class: com.zj.adlib.a80
            public final Object call(Object obj) {
                return this.f40473a.K(params, obj);
            }
        }).u5(rx.schedulers.Schedulers.io()).G3(d60.c()).L1(new Action0() { // from class: com.zj.adlib.b80
            public final void call() {
                ApiDataComponent.M(dialogArr);
            }
        }).J1(new Action1() { // from class: com.zj.adlib.c80
            public final void call(Object obj) {
                runnable.run();
            }
        }).I1(new Action1() { // from class: com.zj.adlib.d80
            public final void call(Object obj) {
                runnable.run();
            }
        }).M1(new Action0() { // from class: com.zj.adlib.e80
            public final void call() {
                runnable.run();
            }
        }).p5(t);
    }

    public abstract CommonConfig C();

    public HandleRunError D() {
        return this.f12551a;
    }

    public abstract String E();

    public final boolean F(int code, String message) {
        HandleRunError handleRunError = this.f12551a;
        if (handleRunError != null) {
            return handleRunError.a(code, message);
        }
        return false;
    }

    public void clearData() {
        xv8.f();
        Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.m80
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                ApiDataComponent.G(observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.n80
            public final void accept(Object obj) throws Exception {
                ApiDataComponent.H(obj);
            }
        });
    }

    public void e0(final ValueCallBack callBack) {
        Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.q80
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.f44147a.R(observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.r80
            public final void accept(Object obj) throws Exception {
                ApiDataComponent.S(callBack, (Integer) obj);
            }
        });
    }

    public void f0(ValueCallback<Boolean> callBack) {
        String strE = E();
        if (!TextUtils.isEmpty(strE)) {
            n76.e(this, this.f12554a.e(strE)).p5(new f(false, callBack));
        } else if (callBack != null) {
            callBack.onCallback(Boolean.FALSE);
        }
    }

    public dx4 getLifeCycleObservable() {
        if (this.f12552a == null) {
            this.f12552a = dx4.a();
        }
        return this.f12552a;
    }

    public abstract IntervalStep getTailSectionStepData(int tailRecordIndex);

    public abstract List<TargetPoints> getTargetPoints();

    public void h0(final long currentTime, final long currentDistance, final int currentAccelerateStep) {
        Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.g80
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.f16718a.T(currentTime, currentDistance, currentAccelerateStep, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.h80
            public final void accept(Object obj) throws Exception {
                ApiDataComponent.V(obj);
            }
        });
    }

    public void i0(final RunLatLng... runLatLngList) {
        Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.k80
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.f42759a.W(runLatLngList, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.l80
            public final void accept(Object obj) throws Exception {
                ApiDataComponent.X(obj);
            }
        });
    }

    @SuppressLint({"CheckResult"})
    public void j0(final long currentTime, final int stepInterval, final int fromStep, final int toStep, final ValueCallBack callBack) {
        if (fromStep > toStep) {
            return;
        }
        i4a.b(this.f, "fromStep=" + fromStep + "|toStep=" + toStep + "|currentTime=" + currentTime + "秒");
        Observable.create(new ObservableOnSubscribe() { // from class: com.zj.adlib.x70
            public final void subscribe(ObservableEmitter observableEmitter) throws Exception {
                this.f20612a.Y(currentTime, stepInterval, fromStep, toStep, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Consumer() { // from class: com.zj.adlib.i80
            public final void accept(Object obj) throws Exception {
                ApiDataComponent.Z(callBack, (Integer) obj);
            }
        });
    }

    public void k0(HandleRunError handleRunError) {
        this.f12551a = handleRunError;
    }

    public void l0(long paceInterval, final String runRecordCode) {
        if (!TextUtils.isEmpty(runRecordCode) && System.currentTimeMillis() - this.b > 15000) {
            this.b = System.currentTimeMillis();
            if (this.f12558b) {
                return;
            }
            this.f12558b = true;
            rx.Observable.h1(new rx.Observable.OnSubscribe() { // from class: com.zj.adlib.p80
                public final void call(Object obj) {
                    ApiDataComponent.b0(runRecordCode, (Subscriber) obj);
                }
            }).u5(rx.schedulers.Schedulers.io()).G3(d60.c()).p5(new b(runRecordCode, paceInterval));
        }
    }

    public void m0(final String runRecordCode) {
        if (!TextUtils.isEmpty(runRecordCode) && System.currentTimeMillis() - this.f35979a > ((long) C().getPoiInterval()) * 1000) {
            this.f35979a = System.currentTimeMillis();
            rx.Observable.h1(new rx.Observable.OnSubscribe() { // from class: com.zj.adlib.o80
                public final void call(Object obj) {
                    ApiDataComponent.c0(runRecordCode, (Subscriber) obj);
                }
            }).u5(rx.schedulers.Schedulers.io()).G3(d60.c()).p5(new a(runRecordCode));
        }
    }

    public void n0(Map<String, Object> strideList, int strideInterval, String runRecordCode, ValueCallBack callBack) {
        if (TextUtils.isEmpty(runRecordCode)) {
            return;
        }
        n76.e(this, this.f12554a.l(strideList, strideInterval, runRecordCode)).p5(new d(callBack, strideList));
    }

    public void o0(long stepInterval, final String runRecordCode) {
        if (TextUtils.isEmpty(runRecordCode) || this.f12556a) {
            return;
        }
        this.f12556a = true;
        rx.Observable.h1(new rx.Observable.OnSubscribe() { // from class: com.zj.adlib.j80
            public final void call(Object obj) {
                this.f42525a.d0(runRecordCode, (Subscriber) obj);
            }
        }).u5(rx.schedulers.Schedulers.io()).G3(d60.c()).p5(new c(runRecordCode, stepInterval));
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onCreate() {
        this.f12554a = new km7();
        this.f12553a = new gq1();
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        dx4 dx4Var = this.f12552a;
        if (dx4Var != null) {
            dx4Var.b();
            this.f12552a = null;
        }
    }

    public void p0(List<TargetPoints> targetPoints, String runRecordCode) {
        n76.e(this, this.f12554a.m(targetPoints, runRecordCode)).p5(new e());
    }
}
