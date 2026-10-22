package com.zj.adlib;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.huachenjie.c.HcjNative;
import com.huachenjie.common.bean.BaseListData;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.api.ISunshineApi;
import com.huachenjie.run.bean.RunPlanListBean;
import com.huachenjie.run.bean.SunshineRankingData;
import com.huachenjie.run.bean.VideoInfoData;
import huachenjie.sdk.http.BaseEntity;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class aw8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ISunshineApi f40630a;

    public static void c(Map<String, Object> params) {
        String str = (String) params.get("runRecordCode");
        if (str != null) {
            String strValueOf = String.valueOf(System.currentTimeMillis() + r90.D());
            params.put("runImgRecord", HcjNative.encodeRun(str, "26101017", "8.7.7", strValueOf, l43.b()));
            params.put("timestamp", strValueOf);
        }
    }

    public static ISunshineApi e() {
        if (f40630a == null) {
            synchronized (ISunshineApi.class) {
                if (f40630a == null) {
                    f40630a = (ISunshineApi) lo7.e().d(ISunshineApi.class);
                }
            }
        }
        return f40630a;
    }

    public Observable<BaseEntity<JSONObject>> a(Map<String, Object> params) {
        c(params);
        return e().F(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(params)));
    }

    public Observable<BaseEntity<JSONObject>> b(Map<String, Object> params) {
        c(params);
        return e().c(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(params)));
    }

    public Observable<BaseEntity<JSONObject>> d(Map<String, Object> params) {
        c(params);
        return e().a(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(params)));
    }

    public Observable<BaseEntity<BaseListData<VideoInfoData>>> f() {
        return e().M(System.currentTimeMillis());
    }

    public Observable<BaseEntity<RunPlanListBean>> g(String semesterCode) {
        return e().j(semesterCode);
    }

    public Observable<BaseEntity<List<GeoFenceDetail>>> h(String schoolCode) {
        return e().I(schoolCode);
    }

    public Observable<BaseEntity<SunshineRankingData>> i(int sex, int scope, int rankCycle, int type, String runPlanCode) {
        return e().o(sex, scope, rankCycle, type, runPlanCode);
    }

    public Observable<BaseEntity<SunshineRankingData>> j(int sex, int scope, String runPlanCode) {
        return e().x(sex, scope, runPlanCode);
    }
}
