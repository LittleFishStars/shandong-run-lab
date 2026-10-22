package com.zj.adlib;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.huachenjie.c.HcjNative;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.run.api.IRunApi;
import com.huachenjie.run.bean.FinishFreeRunResult;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.bean.UploadData;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.interceptor.SignInterceptor;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class km7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IRunApi f42855a;

    public static IRunApi d() {
        if (f42855a == null) {
            synchronized (IRunApi.class) {
                if (f42855a == null) {
                    f42855a = (IRunApi) lo7.e().d(IRunApi.class);
                }
            }
        }
        return f42855a;
    }

    public Observable<BaseEntity<UnfinishedRun>> a(int sportType) {
        HashMap map = new HashMap();
        map.put("sportType", String.valueOf(sportType));
        return d().b(map);
    }

    public Observable<BaseEntity<FinishFreeRunResult>> b(Map<String, Object> params) {
        return d().a(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(params)));
    }

    public Observable<BaseEntity<FinishRunResult>> c(Map<String, Object> params) {
        aw8.c(params);
        return d().j(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(params)));
    }

    public Observable<BaseEntity<JSONObject>> e(String runRecordCode) {
        return d().f(runRecordCode);
    }

    public Observable<BaseEntity<SportStatics>> f(int timeType, int sportType) {
        return d().g(timeType, sportType);
    }

    public Observable<BaseEntity<JSONObject>> g(double lat, double lng, long aimDistance, long aimDuration, long aimCalorie) {
        HashMap map = new HashMap();
        map.put("lat", BigDecimal.valueOf(lat).toString());
        map.put("lng", BigDecimal.valueOf(lng).toString());
        if (aimDistance != 0) {
            map.put("aimDistance", String.valueOf(aimDistance));
        }
        if (aimDuration != 0) {
            map.put("aimDuration", String.valueOf(aimDuration));
        }
        if (aimCalorie != 0) {
            map.put("aimCalorie", String.valueOf(aimCalorie));
        }
        return d().c(map);
    }

    public Observable<BaseEntity<UploadData>> h(List<IntervalPace> paceList, long paceInterval, String runRecordCode) {
        HashMap map = new HashMap();
        map.put("paceList", paceList);
        map.put("paceInterval", Long.valueOf(paceInterval));
        map.put("runRecordCode", runRecordCode);
        return d().d(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map, SerializerFeature.WriteMapNullValue)));
    }

    public Observable<BaseEntity<UploadData>> i(List<HCJLatLng> pathList, String runRecordCode) {
        HashMap map = new HashMap();
        map.put("pois", pathList);
        map.put("runRecordCode", runRecordCode);
        return d().i(null, RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map)));
    }

    public Observable<BaseEntity<UploadData>> j(List<RunLatLng> pathList, String runRecordCode) {
        HashMap map = new HashMap();
        map.put("pois", pathList);
        map.put("runRecordCode", runRecordCode);
        i4a.b("RunModel", "上传日志：pathList>>" + vw3.u(pathList));
        SignInterceptor.m(map, lo7.e().g().n());
        String jSONString = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        return d().i(HcjNative.signRequest(jSONString, l43.b()), RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), jSONString));
    }

    public Observable<BaseEntity<UploadData>> k(List<IntervalStep> stepList, long stepInterval, String runRecordCode) {
        HashMap map = new HashMap();
        map.put("stepList", stepList);
        map.put("stepInterval", Long.valueOf(stepInterval));
        map.put("runRecordCode", runRecordCode);
        String jSONString = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        i4a.b("RunModel", "uploadStep 入参：" + jSONString);
        return d().k(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), jSONString));
    }

    public Observable<BaseEntity<UploadData>> l(Map<String, Object> strideList, int strideInterval, String runRecordCode) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(strideList);
        HashMap map = new HashMap();
        map.put("strideList", arrayList);
        map.put("strideInterval", Integer.valueOf(strideInterval));
        map.put("runRecordCode", runRecordCode);
        return d().h(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map, SerializerFeature.WriteMapNullValue)));
    }

    public Observable<BaseEntity<JSONObject>> m(List<TargetPoints> targetPoints, String runRecordCode) {
        HashMap map = new HashMap();
        map.put("runRecordCode", runRecordCode);
        map.put("targetPoints", targetPoints);
        return d().e(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map, SerializerFeature.WriteMapNullValue)));
    }
}
