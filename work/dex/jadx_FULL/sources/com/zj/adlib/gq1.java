package com.zj.adlib;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.huachenjie.common.api.CommonApi;
import com.huachenjie.common.bean.AdConfig;
import com.huachenjie.common.bean.AdPositionConfig;
import com.huachenjie.common.bean.CheatConfig;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.CurrentActivityData;
import com.huachenjie.common.bean.CustomerServerStatusData;
import com.huachenjie.common.bean.OrderBean;
import com.huachenjie.common.bean.OssTokenInfo;
import com.huachenjie.common.bean.OutsideAttendanceRule;
import com.huachenjie.common.bean.PayResult;
import com.huachenjie.common.bean.StudentSchoolAuthBean;
import com.huachenjie.common.bean.VersionUpgrade;
import com.huachenjie.common.bean.VodTokenInfo;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CommonApi f41967a;
    public static CommonApi b;

    public static CommonApi n() {
        if (f41967a == null) {
            synchronized (CommonApi.class) {
                if (f41967a == null) {
                    f41967a = (CommonApi) lo7.e().d(CommonApi.class);
                }
            }
        }
        return f41967a;
    }

    public static CommonApi p() {
        if (b == null) {
            synchronized (CommonApi.class) {
                if (b == null) {
                    b = (CommonApi) sj8.a.a(CommonApi.class);
                }
            }
        }
        return b;
    }

    public Observable<BaseEntity<OssTokenInfo>> A(String tokenType) {
        return n().i(tokenType);
    }

    public Observable<BaseEntity<VodTokenInfo>> B() {
        return n().j();
    }

    public Observable<BaseEntity<JSONObject>> C() {
        return n().u();
    }

    public Observable<BaseEntity<Object>> D(double weight, double height, String nickName, String slogan, String avatarUrl) {
        HashMap map = new HashMap();
        if (weight > AudioStats.AUDIO_AMPLITUDE_NONE) {
            map.put("weight", c82.a(weight, 1));
        }
        if (height > AudioStats.AUDIO_AMPLITUDE_NONE) {
            map.put("height", c82.a(height, 0));
        }
        if (!TextUtils.isEmpty(nickName)) {
            map.put(UserConstants.USER_PARAMS.b, nickName);
        }
        if (!TextUtils.isEmpty(slogan)) {
            map.put("slogan", slogan);
        }
        if (!TextUtils.isEmpty(avatarUrl)) {
            map.put(AvatarFragment.AVATAR_URL, avatarUrl);
        }
        return n().b(map);
    }

    public Observable<BaseEntity<Object>> a(@Field("outsideConfigCode") String outsideConfigCode, @Field("lng") String lng, @Field("lat") String lat) {
        return n().d(outsideConfigCode, lng, lat);
    }

    public Observable<BaseEntity<Object>> b(String emojiBagCode) {
        return n().q(emojiBagCode);
    }

    public Observable<BaseEntity<PayResult>> c(int payType, String orderCode) {
        return n().l(payType, orderCode);
    }

    public Observable<BaseEntity<StudentSchoolAuthBean>> d(String schoolCode) {
        return n().k(schoolCode);
    }

    public Observable<BaseEntity<VersionUpgrade>> e() {
        return n().v(new HashMap());
    }

    public Observable<BaseEntity<OrderBean>> f(int payType, int type, int goodsSubType, String goodsCode) {
        return n().p(payType, type, goodsSubType, goodsCode);
    }

    public Observable<BaseEntity<AdConfig>> g() {
        return n().e();
    }

    public Observable<BaseEntity<CheatConfig>> h() {
        return n().t();
    }

    public Observable<BaseEntity<ClockTimeData>> i(String outsideConfigCode) {
        return n().y(outsideConfigCode);
    }

    public Observable<BaseEntity<CommonConfig>> j() {
        return n().a();
    }

    public Observable<BaseEntity<CurrentActivityData>> k() {
        return n().w();
    }

    public Observable<BaseEntity<CustomerServerStatusData>> l() {
        return n().n();
    }

    public Observable<BaseEntity<JSONObject>> m() {
        return n().r();
    }

    @FormUrlEncoded
    @POST("run-front/outside/outsideRule")
    public Observable<BaseEntity<OutsideAttendanceRule>> o(String outsideConfigCode) {
        return n().c(outsideConfigCode);
    }

    public Observable<BaseEntity<Object>> q() {
        return n().z(new HashMap());
    }

    public Observable<BaseEntity<JSONObject>> r(String number, double lng, double lat) {
        HashMap map = new HashMap();
        map.put("digitCode", number);
        map.put("lng", ys8.c("%.6f", Double.valueOf(lng)));
        map.put("lat", ys8.c("%.6f", Double.valueOf(lat)));
        return n().h(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map)));
    }

    public Observable<BaseEntity<JSONObject>> s(String number, HCJAddressInfo hcjAddressInfo) {
        return r(number, hcjAddressInfo.getLng(), hcjAddressInfo.getLat());
    }

    public Observable<BaseEntity<Object>> t(String outsideConfigCode, String timeFrameCode, String img, String lng, String lat) {
        return u(outsideConfigCode, timeFrameCode, img, lng, lat, null);
    }

    public Observable<BaseEntity<Object>> u(String outsideConfigCode, String timeFrameCode, String img, String lng, String lat, Integer clockType) {
        HashMap map = new HashMap();
        map.put("outsideConfigCode", outsideConfigCode);
        map.put("timeFrameCode", timeFrameCode);
        if (!TextUtils.isEmpty(img)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(img);
            map.put("imgUrlList", arrayList);
        }
        map.put("lng", lng);
        map.put("lat", lat);
        if (clockType != null) {
            map.put("clockType", clockType);
        }
        return n().s(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map)));
    }

    public Observable<BaseEntity<Object>> v(String qrCode, String lng, String lat) {
        return n().f(qrCode, lng, lat);
    }

    public Observable<BaseEntity<JSONObject>> w(String qrcode, double lng, double lat) {
        HashMap map = new HashMap();
        map.put("qrCode", qrcode);
        if (lng > AudioStats.AUDIO_AMPLITUDE_NONE) {
            map.put("lng", ys8.c("%.6f", Double.valueOf(lng)));
        }
        if (lat > AudioStats.AUDIO_AMPLITUDE_NONE) {
            map.put("lat", ys8.c("%.6f", Double.valueOf(lat)));
        }
        return n().o(RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), JSON.toJSONString(map)));
    }

    public Observable<BaseEntity<AdPositionConfig>> x() {
        return n().x();
    }

    public Observable<BaseEntity<JSONObject>> y() {
        return n().g();
    }

    public Observable<BaseEntity<Object>> z(String friendCode, String remark) {
        return n().m(friendCode, remark);
    }
}
