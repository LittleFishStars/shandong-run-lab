package com.zj.adlib;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.huachenjie.common.bean.SportStatics;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.common.bean.UnfinishedRun;
import com.huachenjie.run.api.IFreeApi;
import huachenjie.sdk.http.BaseEntity;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class in3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IFreeApi f42393a;

    public static IFreeApi c() {
        if (f42393a == null) {
            synchronized (IFreeApi.class) {
                if (f42393a == null) {
                    f42393a = (IFreeApi) lo7.e().d(IFreeApi.class);
                }
            }
        }
        return f42393a;
    }

    public Observable<BaseEntity<UnfinishedRun>> a(int sportType) {
        HashMap map = new HashMap();
        map.put("sportType", String.valueOf(sportType));
        return c().b(map);
    }

    public Observable<BaseEntity<JSONObject>> b(Map<String, Object> params) {
        return c().a(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(params)));
    }

    public Observable<BaseEntity<SunshineRecordListEntity>> d(int timeType, int pageNum) {
        return c().d(10, pageNum, timeType);
    }

    public Observable<BaseEntity<SportStatics>> e(int timeType, int sportType) {
        return c().e(timeType, sportType);
    }

    public Observable<BaseEntity<JSONObject>> f(double lat, double lng, long aimDistance, long aimDuration, int aimCalorie) {
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
        return c().c(map);
    }
}
