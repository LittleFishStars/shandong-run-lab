package cj.mobile.p;

import android.content.Context;
import cj.mobile.CJMobileAd;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class f extends cj.mobile.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, ArrayList<Map<String, Object>>> f22639a = new HashMap();
    public static OkHttpClient b;

    public class a implements Callback {
        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) throws IOException {
            response.close();
        }
    }

    public class b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.p.d f22640a;

        public b(cj.mobile.p.d dVar) {
            this.f22640a = dVar;
        }

        public void onFailure(Call call, IOException iOException) {
            this.f22640a.a(iOException);
        }

        public void onResponse(Call call, Response response) throws IOException {
            this.f22640a.a(response.body().string());
            response.close();
        }
    }

    public class c implements Callback {
        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) throws IOException {
            response.close();
        }
    }

    public class d implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.p.d f22641a;

        public d(cj.mobile.p.d dVar) {
        }

        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) throws IOException {
        }
    }

    public class e implements Callback {
        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) throws IOException {
        }
    }

    /* JADX INFO: renamed from: cj.mobile.p.f$f, reason: collision with other inner class name */
    public class C0079f implements cj.mobile.p.d {
        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class g implements Callback {
        public g(f fVar) {
        }

        public void onFailure(Call call, IOException iOException) {
        }

        public void onResponse(Call call, Response response) throws IOException {
        }
    }

    public class h implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return "api.wxcjgg.cn".equals(str) || "user.wxcjgg.cn".equals(str) || "api.shanghailingye.cn".equals(str);
        }
    }

    public class i implements Interceptor {
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().build());
        }
    }

    static {
        new HashMap();
    }

    public static void a(Context context, String str, Map<String, Object> map, cj.mobile.p.d dVar) {
        OkHttpClient okHttpClientB = b();
        map.put("deviceId", cj.mobile.p.i.d(context));
        map.put("aId", cj.mobile.p.i.a(context));
        map.put("oId", cj.mobile.p.i.f(context));
        map.put("brand", cj.mobile.p.i.b());
        map.put(ze1.k, cj.mobile.p.i.c());
        map.put("osVer", cj.mobile.p.i.d());
        map.put("appV", cj.mobile.p.i.c(context));
        map.put("appNum", Integer.valueOf(cj.mobile.p.i.b(context)));
        map.put("sdkV", CJMobileAd.getSdkVersion());
        map.put("sdkNum", Integer.valueOf(CJMobileAd.getSdkCode()));
        okHttpClientB.newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse(ze1.g), new JSONObject(map).toString())).addHeader("token", cj.mobile.p.b.d()).build()).enqueue(new b(dVar));
    }

    public static OkHttpClient b() {
        if (b == null) {
            cj.mobile.p.b.d();
            OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(new i());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            b = builderAddInterceptor.connectionPool(new ConnectionPool(20, 15L, timeUnit)).connectTimeout(5L, timeUnit).hostnameVerifier(new h()).proxy(Proxy.NO_PROXY).build();
        }
        return b;
    }

    public static List<Map<String, String>> c() {
        HashMap map = new HashMap();
        map.put("gdt", k.d());
        map.put("csj", k.b());
        map.put(MediationConstant.ADN_KS, k.i());
        map.put("bd", k.a());
        map.put("qm", k.j());
        map.put("sig", k.l());
        map.put("zy", k.q());
        map.put("tk", k.n());
        map.put("jy", k.h());
        map.put("wm", k.o());
        map.put("hx", k.e());
        map.put(AliyunLogKey.KEY_FILE_WIDTH, k.c());
        map.put("jd", k.f());
        map.put("jt", k.g());
        map.put("zf", k.p());
        map.put("tb", k.m());
        map.put("qx", k.k());
        ArrayList arrayList = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            HashMap map2 = new HashMap();
            map2.put("plat", str);
            map2.put("ver", (String) map.get(str));
            arrayList.add(map2);
        }
        return arrayList;
    }

    public static void a(String str) {
        OkHttpClient okHttpClientB = b();
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject(map);
        map.put("vid", str);
        okHttpClientB.newCall(new Request.Builder().url(cj.mobile.p.e.v).post(RequestBody.create(MediaType.parse(ze1.g), jSONObject.toString())).build()).enqueue(new c());
    }

    public static void a(String str, cj.mobile.p.d dVar) {
        b().newCall(new Request.Builder().url(str).get().build()).enqueue(new d(dVar));
    }

    public static void a(String str, String str2, String str3) {
        ArrayList<Map<String, Object>> arrayList = f22639a.get("request" + str3);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(a(0, 0, str, str2, "", ""));
        f22639a.put("request" + str3, arrayList);
    }

    public static void a(String str, int i2, int i3, String str2, String str3, String str4, String str5) {
        ArrayList<Map<String, Object>> arrayList = f22639a.get(TrackLoadSettingsAtom.TYPE + str3);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(a(i2, i3, str, str2, str5, str4));
        f22639a.put(TrackLoadSettingsAtom.TYPE + str3, arrayList);
    }

    public static void a(String str, Map<String, Object> map) {
        b().newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse(ze1.g), new JSONObject(map).toString())).addHeader("token", cj.mobile.p.b.d()).build()).enqueue(new e());
    }

    public static void a(Context context, String str, int i2, String str2, long j) {
        HashMap map = new HashMap();
        map.put("app_id", cj.mobile.p.b.N);
        map.put(MediationConstant.EXTRA_ADID, str);
        map.put("dev_id", cj.mobile.p.i.d(context));
        map.put("a_id", cj.mobile.p.i.a(context));
        map.put(DeviceIdType.OAID, cj.mobile.p.i.f(context));
        map.put("brand", cj.mobile.p.i.b());
        map.put(ze1.k, cj.mobile.p.i.c());
        map.put("os_ver", cj.mobile.p.i.d());
        map.put("load_complete_time", Long.valueOf(j));
        map.put("app_v", cj.mobile.p.i.c(context));
        map.put("sdk_v", CJMobileAd.getSdkVersion());
        map.put("r_id", str2);
        if (f22639a.get("request" + str2) != null) {
            ArrayList<Map<String, Object>> arrayList = f22639a.get("request" + str2);
            f22639a.remove("request" + str2);
            map.put(GoodsSpecificationPreviewActivity.z, arrayList);
            a(cj.mobile.p.e.f, map);
        }
        if (f22639a.get(TrackLoadSettingsAtom.TYPE + str2) != null) {
            ArrayList<Map<String, Object>> arrayList2 = f22639a.get(TrackLoadSettingsAtom.TYPE + str2);
            f22639a.remove(TrackLoadSettingsAtom.TYPE + str2);
            map.put(GoodsSpecificationPreviewActivity.z, arrayList2);
            map.put("m_id", Integer.valueOf(i2));
            a(cj.mobile.p.e.g, map);
        }
        if (f22639a.get("error" + str2) != null) {
            ArrayList<Map<String, Object>> arrayList3 = f22639a.get("error" + str2);
            f22639a.remove("error" + str2);
            map.put(GoodsSpecificationPreviewActivity.z, arrayList3);
            a(cj.mobile.p.e.j, map);
        }
    }

    public static Map<String, Object> a(int i2, int i3, String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        map.put("cpm", i2 + "");
        map.put("plat", str);
        map.put("p_id", str2);
        map.put("mat", str4);
        map.put("mat_id", str3);
        return map;
    }

    public static void a(Context context, String str, String str2, String str3, int i2, int i3, String str4, String str5, String str6, String str7, String str8) {
        String str9;
        HashMap map = new HashMap();
        map.put("app_id", cj.mobile.p.b.N);
        map.put(MediationConstant.EXTRA_ADID, str);
        map.put("dev_id", cj.mobile.p.i.d(context));
        map.put("a_id", cj.mobile.p.i.a(context));
        map.put(DeviceIdType.OAID, cj.mobile.p.i.f(context));
        map.put("brand", cj.mobile.p.i.b());
        map.put(ze1.k, cj.mobile.p.i.c());
        map.put("os_ver", cj.mobile.p.i.d());
        map.put("cpm", i2 + "");
        map.put("plat", str2);
        map.put("p_id", str3);
        map.put("m_id", Integer.valueOf(i3));
        if ((str4 == null || str4.equals("")) && (str9 = cj.mobile.p.b.U) != null && !str9.equals("")) {
            str4 = cj.mobile.p.b.U;
        }
        map.put("u_id", str4);
        map.put("r_id", str5);
        map.put("p_r_id", str6);
        map.put("app_v", cj.mobile.p.i.c(context));
        map.put("sdk_v", CJMobileAd.getSdkVersion());
        map.put("mat", str7);
        map.put("mat_id", str8);
        a(cj.mobile.p.e.h, map);
    }

    public static void a(Context context, String str, String str2, String str3, int i2, int i3, String str4, String str5) {
        String str6;
        HashMap map = new HashMap();
        map.put("app_id", cj.mobile.p.b.N);
        map.put(MediationConstant.EXTRA_ADID, str);
        map.put("dev_id", cj.mobile.p.i.d(context));
        map.put("a_id", cj.mobile.p.i.a(context));
        map.put(DeviceIdType.OAID, cj.mobile.p.i.f(context));
        map.put("brand", cj.mobile.p.i.b());
        map.put(ze1.k, cj.mobile.p.i.c());
        map.put("os_ver", cj.mobile.p.i.d());
        map.put("r_id", str5);
        map.put("cpm", i2 + "");
        map.put("plat", str2);
        map.put("p_id", str3);
        map.put("m_id", Integer.valueOf(i3));
        if ((str4 == null || str4.equals("")) && (str6 = cj.mobile.p.b.U) != null && !str6.equals("")) {
            str4 = cj.mobile.p.b.U;
        }
        map.put("u_id", str4);
        map.put("app_v", cj.mobile.p.i.c(context));
        map.put("sdk_v", CJMobileAd.getSdkVersion());
        a(cj.mobile.p.e.i, map);
    }

    public static void a(Context context) {
        String string;
        HashMap map = new HashMap();
        map.put("app_id", cj.mobile.p.b.N);
        try {
            if (context.getApplicationInfo().labelRes != 0) {
                string = context.getString(context.getApplicationInfo().labelRes);
            } else {
                string = context.getApplicationInfo().nonLocalizedLabel.toString();
            }
        } catch (Exception unused) {
            string = "";
        }
        map.put("app_name", string);
        map.put("package_name", context.getApplicationInfo().packageName);
        map.put("dev_id", cj.mobile.p.i.d(context));
        map.put("a_id", cj.mobile.p.i.a(context));
        map.put(DeviceIdType.OAID, cj.mobile.p.i.f(context));
        map.put("brand", cj.mobile.p.i.b());
        map.put(ze1.k, cj.mobile.p.i.c());
        map.put("sdk_v", CJMobileAd.getSdkVersion());
        map.put("sdk_code", Integer.valueOf(CJMobileAd.getSdkCode()));
        map.put("os_ver", cj.mobile.p.i.d());
        map.put("hasSim", Integer.valueOf(cj.mobile.p.b.Q));
        map.put("app_v", cj.mobile.p.i.c(context));
        map.put("plat", c());
        a(context, cj.mobile.p.e.k, map, new C0079f());
    }

    public static void a(String str, String str2, String str3, Object obj) {
        ArrayList<Map<String, Object>> arrayList = f22639a.get("error" + str3);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Map<String, Object> mapA = a(0, 0, str, str2, "", "");
        mapA.put(AliyunLogCommon.LogLevel.INFO, obj.toString());
        arrayList.add(mapA);
        f22639a.put("error" + str3, arrayList);
    }

    public void a(Context context, long j, String str, String str2, String str3, String str4, String str5) {
        OkHttpClient okHttpClientB = b();
        HashMap map = new HashMap();
        map.put("adv_id", str);
        map.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, str2);
        map.put("request_id", str4);
        map.put("deviceId", cj.mobile.p.i.d(context));
        map.put("aId", cj.mobile.p.i.a(context));
        map.put("oId", cj.mobile.p.i.f(context));
        map.put("extend", str3);
        map.put("timestamp", Long.valueOf(j));
        map.put(UserTrackConstant.SIGN, str5);
        okHttpClientB.newCall(new Request.Builder().url(cj.mobile.p.e.e).post(RequestBody.create(MediaType.parse(ze1.g), new JSONObject(map).toString())).build()).enqueue(new g(this));
    }

    @Override // cj.mobile.h.a
    public String a() {
        return cj.mobile.p.b.d();
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        OkHttpClient okHttpClientB = b();
        map.put("appId", cj.mobile.p.b.N);
        map.put("eid", cj.mobile.p.i.d(context));
        okHttpClientB.newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse(ze1.g), new JSONObject(map).toString())).addHeader("token", cj.mobile.p.b.d()).build()).enqueue(new a());
    }
}
