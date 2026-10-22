package com.kc.dw.core.loader;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.openapiutil.Client;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import com.kc.dw.core.SsdAdConfig;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.IAdEventListener;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoCommonAdLoader;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.ad.paster.PasterCommonAdLoader;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.domain.AppendInfo;
import com.kc.dw.core.domain.ClickIdResponse;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SdkMonitor;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.serverbidding.S2SBManager;
import com.kc.dw.core.loader.serverbidding.S2sbCacheEntity;
import com.kc.dw.core.router.log.bean.CodeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.PackageBean;
import com.kc.dw.core.utils.SdkClsUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.d1;
import com.kc.dw.core.utils.e1;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.l;
import com.kc.dw.core.utils.n0;
import com.kc.dw.core.utils.n1;
import com.kc.dw.core.utils.o1;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.r;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.u;
import com.kc.dw.core.utils.v;
import com.kc.dw.core.utils.w0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.y;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.ADPlatformHelper;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.xh9;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class a<T extends IAdEventListener> implements IAdLoader {
    public static final String KEY_TOKEN = "KEY_TOKEN";
    private static final String TAG = "AdLoader";
    private static final AtomicLong adCounter;
    private static final Map<AdType, AtomicLong> adTypeCounter;
    private static String checkSupport;
    private static Cipher cryptCipher;
    private static byte[] cryptKey;
    private static String cryptKeyStr;
    private static final Map<String, String> hashParams;
    private static final String[] queryParams;
    private long T1;
    private long T10;
    private long T2;
    private long T3;
    private long T8;
    private long T9;
    public Integer accept_ad_height;
    public Integer accept_ad_width;
    private SsdAdSlot adSlot;
    public String channel;
    public Context context;
    private volatile boolean isLoadSucc;
    private volatile boolean isLoadTimeout;
    public T loaderListener;
    private com.kc.dw.core.loader.concurrent.a loaderManager;
    public String posId;
    public long startLoadTime;

    /* JADX INFO: renamed from: com.kc.dw.core.loader.a$a, reason: collision with other inner class name */
    @Keep
    public class C1024a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39259a;
        public final a b;

        public C1024a(a aVar, String str) {
            this.b = aVar;
            this.f39259a = str;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            T t = this.b.loaderListener;
            if (t != null) {
                t.onLoadFail(new AdError(com.kc.dw.core.exception.b.i.intValue(), this.f39259a));
            }
        }
    }

    @Keep
    public class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f39260a;
        public final Map b;
        public final Map c;
        public final Map d;
        public final AppendInfo e;
        public final a f;

        public b(a aVar, Map map, Map map2, Map map3, Map map4, AppendInfo appendInfo) {
            this.f = aVar;
            this.f39260a = map;
            this.b = map2;
            this.c = map3;
            this.d = map4;
            this.e = appendInfo;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            LogUtil.e(a.TAG, "onFailure: " + iOException);
            if (this.f.isLoadTimeout) {
                return;
            }
            this.f.isLoadSucc = true;
            try {
                if (iOException.getMessage().contains("CLEARTEXT")) {
                    a aVar = this.f;
                    aVar.retryNet(aVar.getRequestBody("https://sdk.1rtb.net/sdk/req_ad", this.f39260a, this.b, this.c), this.d, this.e);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f.handleNoAd(this.e, 1, iOException.toString());
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0049  */
        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            String strDecode;
            if (this.f.isLoadTimeout) {
                return;
            }
            this.f.isLoadSucc = true;
            this.f.T9 = System.currentTimeMillis();
            if (httpResponse.getErrorCode() == 200) {
                this.f.onLoadSuccess(httpResponse.getResponseBody(), this.d, this.e);
                return;
            }
            Headers header = httpResponse.getHeader();
            if (header != null) {
                String str = header.get("Err_msg");
                if (TextUtils.isEmpty(str)) {
                    strDecode = "";
                } else {
                    strDecode = URLDecoder.decode(str, "UTF-8");
                }
            } else {
                strDecode = "";
            }
            StringBuilder sbA = com.kc.dw.activity.a.a("http code: ");
            sbA.append(httpResponse.getErrorCode());
            sbA.append(",errMsg=");
            sbA.append(strDecode);
            LogUtil.d(a.TAG, sbA.toString());
            a aVar = this.f;
            AppendInfo appendInfo = this.e;
            StringBuilder sbA2 = com.kc.dw.activity.a.a("错误码为：");
            sbA2.append(httpResponse.getErrorCode());
            sbA2.append(",msg=");
            sbA2.append(strDecode);
            aVar.handleNoAd(appendInfo, 2, sbA2.toString());
            Integer num = com.kc.dw.core.exception.b.f39252a;
        }
    }

    @Keep
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39261a;

        public c(a aVar) {
            this.f39261a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f39261a.isLoadSucc) {
                    return;
                }
                this.f39261a.isLoadTimeout = true;
                this.f39261a.handleNoAd(new AppendInfo(), com.kc.dw.core.exception.b.i.intValue(), "load ad timeout");
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public class d implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppendInfo f39262a;
        public final Map b;
        public final a c;

        public d(a aVar, AppendInfo appendInfo, Map map) {
            this.c = aVar;
            this.f39262a = appendInfo;
            this.b = map;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            LogUtil.e(a.TAG, "onFailure: " + iOException);
            this.c.handleNoAd(this.f39262a, 1, iOException.toString());
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0031  */
        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            String strDecode;
            if (httpResponse.getErrorCode() == 200) {
                this.c.onLoadSuccess(httpResponse.getResponseBody(), this.b, this.f39262a);
                return;
            }
            Headers header = httpResponse.getHeader();
            if (header != null) {
                String str = header.get("Err_msg");
                if (TextUtils.isEmpty(str)) {
                    strDecode = "";
                } else {
                    strDecode = URLDecoder.decode(str, "UTF-8");
                }
            } else {
                strDecode = "";
            }
            StringBuilder sbA = com.kc.dw.activity.a.a("http code: ");
            sbA.append(httpResponse.getErrorCode());
            sbA.append(",errMsg=");
            sbA.append(strDecode);
            LogUtil.d(a.TAG, sbA.toString());
            a aVar = this.c;
            AppendInfo appendInfo = this.f39262a;
            StringBuilder sbA2 = com.kc.dw.activity.a.a("错误码为：");
            sbA2.append(httpResponse.getErrorCode());
            sbA2.append(",msg=");
            sbA2.append(strDecode);
            aVar.handleNoAd(appendInfo, 2, sbA2.toString());
            Integer num = com.kc.dw.core.exception.b.f39252a;
        }
    }

    @Keep
    public class e extends com.kc.dw.core.safe.j {
        public e(a aVar) {
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName("sdk.1rtb.net"));
                synchronized (u.class) {
                    try {
                        u.f39408a = listAsList;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Keep
    public class f extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39263a;

        public f(a aVar, String str) {
            this.f39263a = str;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            t0.a(this.f39263a, 1);
        }
    }

    @Keep
    public class g extends TypeToken<HashMap<String, String>> {
        public g(a aVar) {
        }
    }

    @Keep
    public class h extends TypeAdapter<HashMap<String, String>> {
        public h(a aVar) {
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public HashMap<String, String> read2(JsonReader jsonReader) throws IOException {
            HashMap<String, String> map = new HashMap<>();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                try {
                    map.put(jsonReader.nextName(), jsonReader.nextString());
                } catch (Exception unused) {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return map;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, HashMap<String, String> map) throws IOException {
            throw new UnsupportedOperationException("Unimplemented method 'write'");
        }
    }

    @Keep
    public class i implements y<n0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdAdInfo f39264a;
        public final Map b;
        public final a c;

        public i(a aVar, SsdAdInfo ssdAdInfo, Map map) {
            this.c = aVar;
            this.f39264a = ssdAdInfo;
            this.b = map;
        }

        @Override // com.kc.dw.core.utils.y
        public void a(n0 n0Var) throws IOException {
            n0 n0Var2 = n0Var;
            try {
                if (!n0Var2.f39389a) {
                    LogUtil.d(a.TAG, "onResponse: 从dUrl请求clickId失败");
                    this.c.handleNoAd(this.f39264a.getAppendInfo(), 3, "onResponse: 从dUrl请求clickId失败");
                    return;
                }
                ClickIdResponse clickIdResponse = (ClickIdResponse) v.f39411a.fromJson(n0Var2.b, ClickIdResponse.class);
                if (clickIdResponse != null) {
                    this.f39264a.setClickid(clickIdResponse.getData().getClickid());
                    this.f39264a.setdUrl(new String[]{clickIdResponse.getData().getDstlink()});
                }
                this.c.loadAd(this.f39264a, this.b);
            } catch (Exception e) {
                LogUtil.e(a.TAG, "onResponse: ", e);
                this.c.handleNoAd(this.f39264a.getAppendInfo(), 9, e.toString());
            }
        }

        @Override // com.kc.dw.core.utils.y
        public void onFailure(IOException iOException) {
            LogUtil.e(a.TAG, "onFailure: " + iOException);
            this.c.handleNoAd(this.f39264a.getAppendInfo(), 1, iOException.toString());
        }
    }

    @Keep
    public class j extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdAdInfo f39265a;
        public final Map b;
        public final a c;

        public j(a aVar, SsdAdInfo ssdAdInfo, Map map) {
            this.c = aVar;
            this.f39265a = ssdAdInfo;
            this.b = map;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0389 A[Catch: all -> 0x0439, TryCatch #6 {all -> 0x0439, blocks: (B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc), top: B:188:0x037d, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:131:0x0482  */
        /* JADX WARN: Code duplicated, block: B:132:0x0484 A[Catch: all -> 0x04f4, TryCatch #4 {all -> 0x04f4, blocks: (B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf), top: B:184:0x046e, outer: #5, inners: #1, #8 }] */
        /* JADX WARN: Code duplicated, block: B:134:0x048c A[Catch: all -> 0x04f4, TryCatch #4 {all -> 0x04f4, blocks: (B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf), top: B:184:0x046e, outer: #5, inners: #1, #8 }] */
        /* JADX WARN: Code duplicated, block: B:139:0x04a7 A[Catch: all -> 0x04f4, TryCatch #4 {all -> 0x04f4, blocks: (B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf), top: B:184:0x046e, outer: #5, inners: #1, #8 }] */
        /* JADX WARN: Code duplicated, block: B:141:0x04b1  */
        /* JADX WARN: Code duplicated, block: B:142:0x04b3 A[Catch: all -> 0x04f4, TryCatch #4 {all -> 0x04f4, blocks: (B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf), top: B:184:0x046e, outer: #5, inners: #1, #8 }] */
        /* JADX WARN: Code duplicated, block: B:146:0x04c7 A[Catch: Exception -> 0x04ce, all -> 0x04f4, TRY_LEAVE, TryCatch #1 {Exception -> 0x04ce, blocks: (B:144:0x04bb, B:146:0x04c7), top: B:178:0x04bb, outer: #4 }] */
        /* JADX WARN: Code duplicated, block: B:157:0x04ee A[Catch: all -> 0x04f4, TRY_LEAVE, TryCatch #4 {all -> 0x04f4, blocks: (B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf), top: B:184:0x046e, outer: #5, inners: #1, #8 }] */
        /* JADX WARN: Code duplicated, block: B:186:0x045b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:194:0x01c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:201:0x043d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:42:0x0146 A[Catch: all -> 0x0509, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0155 A[Catch: all -> 0x0509, TRY_LEAVE, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x0166 A[Catch: all -> 0x0181, TryCatch #0 {all -> 0x0181, blocks: (B:46:0x015c, B:48:0x0166, B:50:0x0179), top: B:176:0x015c, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0185 A[Catch: all -> 0x0509, TRY_LEAVE, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x01e3 A[Catch: all -> 0x02ed, TryCatch #10 {all -> 0x02ed, blocks: (B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:194:0x01c1, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x0222 A[Catch: all -> 0x02ed, TryCatch #10 {all -> 0x02ed, blocks: (B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:194:0x01c1, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x022e A[Catch: all -> 0x02ed, TryCatch #10 {all -> 0x02ed, blocks: (B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:194:0x01c1, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:77:0x0291 A[Catch: all -> 0x02ed, TryCatch #10 {all -> 0x02ed, blocks: (B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:194:0x01c1, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:79:0x029d A[Catch: all -> 0x02ed, TryCatch #10 {all -> 0x02ed, blocks: (B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:194:0x01c1, outer: #7 }] */
        /* JADX WARN: Code duplicated, block: B:85:0x02f1 A[Catch: all -> 0x0509, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x02f7 A[Catch: all -> 0x0509, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x02fd A[Catch: all -> 0x0509, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:90:0x0305 A[Catch: all -> 0x0509, TryCatch #7 {, blocks: (B:26:0x0115, B:42:0x0146, B:43:0x014f, B:45:0x0155, B:54:0x0185, B:85:0x02f1, B:87:0x02f7, B:89:0x02fd, B:90:0x0305, B:92:0x030b, B:97:0x0376, B:126:0x043d, B:125:0x043a, B:96:0x0373, B:84:0x02ee, B:53:0x0182, B:127:0x045a, B:162:0x0503, B:166:0x0507, B:167:0x0508, B:41:0x0143, B:46:0x015c, B:48:0x0166, B:50:0x0179, B:93:0x0312, B:27:0x011b, B:33:0x012a, B:35:0x0130, B:37:0x0138, B:39:0x013d, B:32:0x0125, B:128:0x045b, B:161:0x04f6, B:129:0x046e, B:132:0x0484, B:134:0x048c, B:136:0x0494, B:137:0x0497, B:139:0x04a7, B:143:0x04b9, B:142:0x04b3, B:144:0x04bb, B:146:0x04c7, B:150:0x04d2, B:155:0x04ea, B:157:0x04ee, B:153:0x04e6, B:149:0x04cf, B:98:0x037d, B:100:0x0389, B:102:0x038f, B:104:0x039d, B:106:0x03a3, B:107:0x03a8, B:108:0x03ac, B:110:0x03b2, B:112:0x03c6, B:114:0x03d4, B:115:0x03d8, B:117:0x03e6, B:118:0x03f8, B:121:0x0404, B:122:0x0409, B:119:0x03fc, B:56:0x01c1, B:58:0x01e3, B:60:0x01ef, B:61:0x021a, B:63:0x0222, B:65:0x022e, B:67:0x023a, B:69:0x0246, B:71:0x0252, B:73:0x025e, B:76:0x0269, B:80:0x02c4, B:77:0x0291, B:79:0x029d, B:81:0x02c9), top: B:190:0x0115, inners: #0, #2, #3, #5, #6, #10 }] */
        /* JADX WARN: Code duplicated, block: B:91:0x030a  */
        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            boolean z;
            long all_timeout;
            List listAsList;
            SdkMonitor sdk_monitor;
            int i;
            com.kc.dw.core.loader.strategy.e eVar;
            List<com.kc.dw.core.loader.loadbean.a> list;
            long j;
            SsdAdInfo ssdAdInfo;
            long all_timeout2;
            int i2;
            long all_timeout3;
            SdkAdInfo sdkAdInfo;
            String imp;
            String str;
            String string;
            List<S2sbCacheEntity.S2SBDataBean> arrayList;
            Context context;
            String pid;
            SdkAdInfo.GeneralExt generalExt;
            int fetchDelay;
            t0.a(this.c.posId, 2);
            LinkedHashMap<String, Long> baseEventTimes = this.f39265a.getAppendInfo().getBaseEventTimes();
            a aVar = this.c;
            com.kc.dw.core.service.logrecord.a.a(baseEventTimes, 5, "s1", null, aVar.posId, aVar.getAdType(), this.f39265a.getAppendInfo().getCurAllTimes(), this.f39265a.getAppendInfo().getCurReqId());
            String[] rstUrl = this.f39265a.getRstUrl();
            if (rstUrl != null) {
                for (String str2 : rstUrl) {
                    z.a(this.c.getContext(), g0.a(str2.replace("__MS_STAT__", this.c.T8 + Consts.DOT + this.c.T9 + Consts.DOT + this.c.T10)), new com.kc.dw.core.utils.j());
                }
            }
            if (this.f39265a.getMonitorUrl() == null || this.f39265a.getMonitorUrl().length <= 0) {
                z = false;
            } else {
                this.f39265a.setHasOwnAd(true);
                z = true;
            }
            this.c.handleDynamicClick(this.f39265a);
            this.c.handleCsj(this.f39265a);
            SdkAdInfo[] sdkAdInfoArrFilterValidSdk = ADPlatformHelper.filterValidSdk(this.c.getContext(), this.f39265a.getSdk(), this.c);
            a aVar2 = this.c;
            aVar2.loaderManager = new com.kc.dw.core.loader.concurrent.a(aVar2.getContext(), this.c, this.f39265a, this.b);
            if (z) {
                SsdAdInfo ssdAdInfo2 = this.f39265a;
                try {
                    ssdAdInfo2.setEventUrl(g0.a(ssdAdInfo2.getSourceEventUrl(), ssdAdInfo2.getFrom_id()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a aVar3 = this.c;
                this.c.loaderManager.f = aVar3.createOwnAdDelegate(aVar3.context, this.f39265a);
            }
            if (sdkAdInfoArrFilterValidSdk == null || sdkAdInfoArrFilterValidSdk.length <= 0) {
                a aVar4 = this.c;
                if (z) {
                    aVar4.loaderManager.a();
                    return;
                } else {
                    aVar4.handleNoAd(this.f39265a.getAppendInfo(), 3, "加载平台为空");
                    return;
                }
            }
            com.kc.dw.core.loader.concurrent.a aVar5 = this.c.loaderManager;
            SsdAdInfo ssdAdInfo3 = this.f39265a;
            synchronized (aVar5) {
                aVar5.h = SystemClock.uptimeMillis();
                try {
                    try {
                        all_timeout = aVar5.b.getAll_timeout();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    all_timeout = 0;
                }
                a aVar6 = aVar5.e;
                if (!(aVar6 instanceof SplashCommonAdLoader) || (fetchDelay = ((SplashCommonAdLoader) aVar6).getFetchDelay()) < 0) {
                    listAsList = Arrays.asList(sdkAdInfoArrFilterValidSdk);
                    sdk_monitor = ssdAdInfo3.getSdk_monitor();
                    for (i = 0; i < listAsList.size(); i++) {
                        sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                        try {
                            if (!TextUtils.isEmpty(sdkAdInfo.getGeneral_ext()) || (generalExt = (SdkAdInfo.GeneralExt) new Gson().fromJson(sdkAdInfo.getGeneral_ext(), SdkAdInfo.GeneralExt.class)) == null) {
                                SdkClsUtil.handleSdkCls(sdkAdInfo, aVar5.e.getAdType());
                                sdkAdInfo.setEventUrl(g0.a(ssdAdInfo3.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                                sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                                sdkAdInfo.setReq_id(ssdAdInfo3.getReq_id());
                                sdkAdInfo.setAppendInfo(ssdAdInfo3.getAppendInfo());
                                if (sdk_monitor != null) {
                                    try {
                                        sdkAdInfo.getAccept_id();
                                        sdkAdInfo.getStrategy_dealid();
                                        String clk = sdk_monitor.getClk();
                                        String err = sdk_monitor.getErr();
                                        imp = sdk_monitor.getImp();
                                        String req = sdk_monitor.getReq();
                                        String rsp = sdk_monitor.getRsp();
                                        if (imp.contains("__PRE__") && !"bidding".equals(sdkAdInfo.getOtype())) {
                                            imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                        }
                                        if (imp.contains("__PRICE__")) {
                                            if ("BAIDU".equals(sdkAdInfo.getSdk()) && !"JD".equals(sdkAdInfo.getSdk()) && !"GDT".equals(sdkAdInfo.getSdk()) && !"KS".equals(sdkAdInfo.getSdk()) && !"HW".equals(sdkAdInfo.getSdk()) && TextUtils.isEmpty(sdkAdInfo.getCls())) {
                                                int price = sdkAdInfo.getPrice();
                                                StringBuilder sb = new StringBuilder();
                                                str = "__PRICE__";
                                                sb.append("ssp");
                                                sb.append(Base64.encodeToString(String.valueOf(price * 10).getBytes(), 2));
                                                string = sb.toString();
                                            } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                                int price2 = sdkAdInfo.getPrice();
                                                StringBuilder sb2 = new StringBuilder();
                                                str = "__PRICE__";
                                                sb2.append("ssp");
                                                sb2.append(Base64.encodeToString(String.valueOf(price2 * 10).getBytes(), 2));
                                                string = sb2.toString();
                                            }
                                            imp = imp.replace(str, string);
                                        }
                                        sdkAdInfo.setClk(aVar5.a(sdkAdInfo, clk));
                                        sdkAdInfo.setErr(aVar5.a(sdkAdInfo, err));
                                        sdkAdInfo.setImp(aVar5.a(sdkAdInfo, imp));
                                        sdkAdInfo.setReq(aVar5.a(sdkAdInfo, req));
                                        sdkAdInfo.setRsp(aVar5.a(sdkAdInfo, rsp));
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                    if (sdkAdInfo.getAct_type() != 0) {
                                        if (ssdAdInfo3.getAct_type() > 0) {
                                            sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                        } else {
                                            sdkAdInfo.setAct_type(2);
                                        }
                                    }
                                    sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                    try {
                                        sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                        sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                        sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                        sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                        sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                    }
                                    sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                    try {
                                        if (!"GDT".equals(sdkAdInfo.getSdk()) && sdkAdInfo.getS2sb() != null) {
                                            S2sbCacheEntity adByPid = S2SBManager.getAdByPid(aVar5.f39266a, aVar5.b.getPid());
                                            if (adByPid != null) {
                                                arrayList = adByPid.getS2sbList();
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList<>();
                                                }
                                                Iterator<S2sbCacheEntity.S2SBDataBean> it = arrayList.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        S2sbCacheEntity.S2SBDataBean next = it.next();
                                                        if (sdkAdInfo.getSdk().equals(next.getPlatform()) && !sdkAdInfo.getApp_id().equals(next.getAppId())) {
                                                            it.remove();
                                                        } else if (next.getPid().equals(sdkAdInfo.getPid())) {
                                                            next.setUpdateTime(System.currentTimeMillis());
                                                            adByPid.setS2sbList(arrayList);
                                                            context = aVar5.f39266a;
                                                            pid = aVar5.b.getPid();
                                                        }
                                                    }
                                                    S2SBManager.putAdByPid(context, pid, adByPid);
                                                }
                                            } else {
                                                adByPid = new S2sbCacheEntity();
                                                arrayList = null;
                                            }
                                            if (arrayList == null) {
                                                arrayList = new ArrayList<>();
                                            }
                                            S2sbCacheEntity.S2SBDataBean s2SBDataBean = new S2sbCacheEntity.S2SBDataBean();
                                            s2SBDataBean.setAppId(sdkAdInfo.getApp_id());
                                            s2SBDataBean.setPid(sdkAdInfo.getPid());
                                            s2SBDataBean.setPlatform(sdkAdInfo.getSdk());
                                            s2SBDataBean.setUpdateTime(System.currentTimeMillis());
                                            arrayList.add(s2SBDataBean);
                                            adByPid.setS2sbList(arrayList);
                                            context = aVar5.f39266a;
                                            pid = aVar5.b.getPid();
                                            S2SBManager.putAdByPid(context, pid, adByPid);
                                        }
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                    com.kc.dw.core.loader.loadbean.a aVar7 = new com.kc.dw.core.loader.loadbean.a();
                                    aVar7.f39268a = sdkAdInfo;
                                    aVar7.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                    aVar5.i.add(aVar7);
                                } else {
                                    if (sdkAdInfo.getAct_type() != 0) {
                                        if (ssdAdInfo3.getAct_type() > 0) {
                                            sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                        } else {
                                            sdkAdInfo.setAct_type(2);
                                        }
                                    }
                                    sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                    sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                    if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                    }
                                    com.kc.dw.core.loader.loadbean.a aVar8 = new com.kc.dw.core.loader.loadbean.a();
                                    aVar8.f39268a = sdkAdInfo;
                                    aVar8.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                    aVar5.i.add(aVar8);
                                }
                            } else {
                                sdkAdInfo.setApp_key(generalExt.getApp_key());
                                SdkClsUtil.handleSdkCls(sdkAdInfo, aVar5.e.getAdType());
                                sdkAdInfo.setEventUrl(g0.a(ssdAdInfo3.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                                sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                                sdkAdInfo.setReq_id(ssdAdInfo3.getReq_id());
                                sdkAdInfo.setAppendInfo(ssdAdInfo3.getAppendInfo());
                                if (sdk_monitor != null) {
                                    sdkAdInfo.getAccept_id();
                                    sdkAdInfo.getStrategy_dealid();
                                    String clk2 = sdk_monitor.getClk();
                                    String err2 = sdk_monitor.getErr();
                                    imp = sdk_monitor.getImp();
                                    String req2 = sdk_monitor.getReq();
                                    String rsp2 = sdk_monitor.getRsp();
                                    if (imp.contains("__PRE__")) {
                                        imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                    }
                                    if (imp.contains("__PRICE__")) {
                                        if ("BAIDU".equals(sdkAdInfo.getSdk())) {
                                            if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                                int price3 = sdkAdInfo.getPrice();
                                                StringBuilder sb3 = new StringBuilder();
                                                str = "__PRICE__";
                                                sb3.append("ssp");
                                                sb3.append(Base64.encodeToString(String.valueOf(price3 * 10).getBytes(), 2));
                                                string = sb3.toString();
                                                imp = imp.replace(str, string);
                                            }
                                        } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            int price4 = sdkAdInfo.getPrice();
                                            StringBuilder sb4 = new StringBuilder();
                                            str = "__PRICE__";
                                            sb4.append("ssp");
                                            sb4.append(Base64.encodeToString(String.valueOf(price4 * 10).getBytes(), 2));
                                            string = sb4.toString();
                                            imp = imp.replace(str, string);
                                        }
                                    }
                                    sdkAdInfo.setClk(aVar5.a(sdkAdInfo, clk2));
                                    sdkAdInfo.setErr(aVar5.a(sdkAdInfo, err2));
                                    sdkAdInfo.setImp(aVar5.a(sdkAdInfo, imp));
                                    sdkAdInfo.setReq(aVar5.a(sdkAdInfo, req2));
                                    sdkAdInfo.setRsp(aVar5.a(sdkAdInfo, rsp2));
                                    if (sdkAdInfo.getAct_type() != 0) {
                                        if (ssdAdInfo3.getAct_type() > 0) {
                                            sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                        } else {
                                            sdkAdInfo.setAct_type(2);
                                        }
                                    }
                                    sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                    sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                    if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                    }
                                    com.kc.dw.core.loader.loadbean.a aVar9 = new com.kc.dw.core.loader.loadbean.a();
                                    aVar9.f39268a = sdkAdInfo;
                                    aVar9.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                    aVar5.i.add(aVar9);
                                } else {
                                    if (sdkAdInfo.getAct_type() != 0) {
                                        if (ssdAdInfo3.getAct_type() > 0) {
                                            sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                        } else {
                                            sdkAdInfo.setAct_type(2);
                                        }
                                    }
                                    sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                    sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                    sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                    if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                    }
                                    com.kc.dw.core.loader.loadbean.a aVar10 = new com.kc.dw.core.loader.loadbean.a();
                                    aVar10.f39268a = sdkAdInfo;
                                    aVar10.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                    aVar5.i.add(aVar10);
                                }
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    synchronized (aVar5) {
                        eVar = new com.kc.dw.core.loader.strategy.e(aVar5.e, aVar5.b);
                        aVar5.d = eVar;
                        eVar.i = aVar5;
                        list = aVar5.i;
                        Map<String, Object> map = aVar5.c;
                        j = aVar5.h;
                        try {
                            eVar.e = list;
                            eVar.f.clear();
                            eVar.f.addAll(list);
                            eVar.g = map;
                            if (list.size() != 0) {
                                if (eVar.b.isHasOwnAd() && !eVar.b.isUsed()) {
                                    eVar.b();
                                }
                                eVar.v = eVar.b.getBf_num();
                                eVar.k = j;
                                ssdAdInfo = eVar.b;
                                all_timeout2 = 10000;
                                if (ssdAdInfo != null) {
                                    if (ssdAdInfo.getAll_timeout() <= 0) {
                                        all_timeout3 = 10000;
                                    } else {
                                        all_timeout3 = eVar.b.getAll_timeout();
                                    }
                                    eVar.p = all_timeout3;
                                }
                                try {
                                    if (eVar.b.getAll_timeout() > 0) {
                                        all_timeout2 = eVar.b.getAll_timeout();
                                    }
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                                try {
                                    eVar.j.postDelayed(new com.kc.dw.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.k));
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                                for (i2 = 0; i2 < eVar.v; i2++) {
                                    eVar.g();
                                }
                            }
                        } catch (Throwable th6) {
                            eVar.h = true;
                            eVar.n.clear();
                            eVar.d();
                            th6.printStackTrace();
                        }
                    }
                }
                long j2 = fetchDelay;
                if (j2 < all_timeout) {
                    aVar5.b.setAll_timeout(j2);
                    listAsList = Arrays.asList(sdkAdInfoArrFilterValidSdk);
                    sdk_monitor = ssdAdInfo3.getSdk_monitor();
                    while (i < listAsList.size()) {
                        sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                        if (TextUtils.isEmpty(sdkAdInfo.getGeneral_ext())) {
                            SdkClsUtil.handleSdkCls(sdkAdInfo, aVar5.e.getAdType());
                            sdkAdInfo.setEventUrl(g0.a(ssdAdInfo3.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(ssdAdInfo3.getReq_id());
                            sdkAdInfo.setAppendInfo(ssdAdInfo3.getAppendInfo());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk3 = sdk_monitor.getClk();
                                String err3 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req3 = sdk_monitor.getReq();
                                String rsp3 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains("__PRICE__")) {
                                    if ("BAIDU".equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            int price5 = sdkAdInfo.getPrice();
                                            StringBuilder sb5 = new StringBuilder();
                                            str = "__PRICE__";
                                            sb5.append("ssp");
                                            sb5.append(Base64.encodeToString(String.valueOf(price5 * 10).getBytes(), 2));
                                            string = sb5.toString();
                                            imp = imp.replace(str, string);
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        int price6 = sdkAdInfo.getPrice();
                                        StringBuilder sb6 = new StringBuilder();
                                        str = "__PRICE__";
                                        sb6.append("ssp");
                                        sb6.append(Base64.encodeToString(String.valueOf(price6 * 10).getBytes(), 2));
                                        string = sb6.toString();
                                        imp = imp.replace(str, string);
                                    }
                                }
                                sdkAdInfo.setClk(aVar5.a(sdkAdInfo, clk3));
                                sdkAdInfo.setErr(aVar5.a(sdkAdInfo, err3));
                                sdkAdInfo.setImp(aVar5.a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(aVar5.a(sdkAdInfo, req3));
                                sdkAdInfo.setRsp(aVar5.a(sdkAdInfo, rsp3));
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar11 = new com.kc.dw.core.loader.loadbean.a();
                                aVar11.f39268a = sdkAdInfo;
                                aVar11.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar11);
                            } else {
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar12 = new com.kc.dw.core.loader.loadbean.a();
                                aVar12.f39268a = sdkAdInfo;
                                aVar12.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar12);
                            }
                        } else {
                            SdkClsUtil.handleSdkCls(sdkAdInfo, aVar5.e.getAdType());
                            sdkAdInfo.setEventUrl(g0.a(ssdAdInfo3.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(ssdAdInfo3.getReq_id());
                            sdkAdInfo.setAppendInfo(ssdAdInfo3.getAppendInfo());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk4 = sdk_monitor.getClk();
                                String err4 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req4 = sdk_monitor.getReq();
                                String rsp4 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains("__PRICE__")) {
                                    if ("BAIDU".equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            int price7 = sdkAdInfo.getPrice();
                                            StringBuilder sb7 = new StringBuilder();
                                            str = "__PRICE__";
                                            sb7.append("ssp");
                                            sb7.append(Base64.encodeToString(String.valueOf(price7 * 10).getBytes(), 2));
                                            string = sb7.toString();
                                            imp = imp.replace(str, string);
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        int price8 = sdkAdInfo.getPrice();
                                        StringBuilder sb8 = new StringBuilder();
                                        str = "__PRICE__";
                                        sb8.append("ssp");
                                        sb8.append(Base64.encodeToString(String.valueOf(price8 * 10).getBytes(), 2));
                                        string = sb8.toString();
                                        imp = imp.replace(str, string);
                                    }
                                }
                                sdkAdInfo.setClk(aVar5.a(sdkAdInfo, clk4));
                                sdkAdInfo.setErr(aVar5.a(sdkAdInfo, err4));
                                sdkAdInfo.setImp(aVar5.a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(aVar5.a(sdkAdInfo, req4));
                                sdkAdInfo.setRsp(aVar5.a(sdkAdInfo, rsp4));
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar13 = new com.kc.dw.core.loader.loadbean.a();
                                aVar13.f39268a = sdkAdInfo;
                                aVar13.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar13);
                            } else {
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar14 = new com.kc.dw.core.loader.loadbean.a();
                                aVar14.f39268a = sdkAdInfo;
                                aVar14.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar14);
                            }
                        }
                    }
                    synchronized (aVar5) {
                        eVar = new com.kc.dw.core.loader.strategy.e(aVar5.e, aVar5.b);
                        aVar5.d = eVar;
                        eVar.i = aVar5;
                        list = aVar5.i;
                        Map<String, Object> map2 = aVar5.c;
                        j = aVar5.h;
                        eVar.e = list;
                        eVar.f.clear();
                        eVar.f.addAll(list);
                        eVar.g = map2;
                        if (list.size() != 0) {
                            if (eVar.b.isHasOwnAd()) {
                                eVar.b();
                            }
                            eVar.v = eVar.b.getBf_num();
                            eVar.k = j;
                            ssdAdInfo = eVar.b;
                            all_timeout2 = 10000;
                            if (ssdAdInfo != null) {
                                if (ssdAdInfo.getAll_timeout() <= 0) {
                                    all_timeout3 = 10000;
                                } else {
                                    all_timeout3 = eVar.b.getAll_timeout();
                                }
                                eVar.p = all_timeout3;
                            }
                            if (eVar.b.getAll_timeout() > 0) {
                                all_timeout2 = eVar.b.getAll_timeout();
                            }
                            eVar.j.postDelayed(new com.kc.dw.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.k));
                            while (i2 < eVar.v) {
                                eVar.g();
                            }
                        }
                    }
                } else {
                    listAsList = Arrays.asList(sdkAdInfoArrFilterValidSdk);
                    sdk_monitor = ssdAdInfo3.getSdk_monitor();
                    while (i < listAsList.size()) {
                        sdkAdInfo = (SdkAdInfo) listAsList.get(i);
                        if (TextUtils.isEmpty(sdkAdInfo.getGeneral_ext())) {
                            SdkClsUtil.handleSdkCls(sdkAdInfo, aVar5.e.getAdType());
                            sdkAdInfo.setEventUrl(g0.a(ssdAdInfo3.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(ssdAdInfo3.getReq_id());
                            sdkAdInfo.setAppendInfo(ssdAdInfo3.getAppendInfo());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk5 = sdk_monitor.getClk();
                                String err5 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req5 = sdk_monitor.getReq();
                                String rsp5 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains("__PRICE__")) {
                                    if ("BAIDU".equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            int price9 = sdkAdInfo.getPrice();
                                            StringBuilder sb9 = new StringBuilder();
                                            str = "__PRICE__";
                                            sb9.append("ssp");
                                            sb9.append(Base64.encodeToString(String.valueOf(price9 * 10).getBytes(), 2));
                                            string = sb9.toString();
                                            imp = imp.replace(str, string);
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        int price10 = sdkAdInfo.getPrice();
                                        StringBuilder sb10 = new StringBuilder();
                                        str = "__PRICE__";
                                        sb10.append("ssp");
                                        sb10.append(Base64.encodeToString(String.valueOf(price10 * 10).getBytes(), 2));
                                        string = sb10.toString();
                                        imp = imp.replace(str, string);
                                    }
                                }
                                sdkAdInfo.setClk(aVar5.a(sdkAdInfo, clk5));
                                sdkAdInfo.setErr(aVar5.a(sdkAdInfo, err5));
                                sdkAdInfo.setImp(aVar5.a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(aVar5.a(sdkAdInfo, req5));
                                sdkAdInfo.setRsp(aVar5.a(sdkAdInfo, rsp5));
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar15 = new com.kc.dw.core.loader.loadbean.a();
                                aVar15.f39268a = sdkAdInfo;
                                aVar15.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar15);
                            } else {
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar16 = new com.kc.dw.core.loader.loadbean.a();
                                aVar16.f39268a = sdkAdInfo;
                                aVar16.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar16);
                            }
                        } else {
                            SdkClsUtil.handleSdkCls(sdkAdInfo, aVar5.e.getAdType());
                            sdkAdInfo.setEventUrl(g0.a(ssdAdInfo3.getSourceEventUrl(), sdkAdInfo.getAccept_id()));
                            sdkAdInfo.setReq_uid((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d));
                            sdkAdInfo.setReq_id(ssdAdInfo3.getReq_id());
                            sdkAdInfo.setAppendInfo(ssdAdInfo3.getAppendInfo());
                            if (sdk_monitor != null) {
                                sdkAdInfo.getAccept_id();
                                sdkAdInfo.getStrategy_dealid();
                                String clk6 = sdk_monitor.getClk();
                                String err6 = sdk_monitor.getErr();
                                imp = sdk_monitor.getImp();
                                String req6 = sdk_monitor.getReq();
                                String rsp6 = sdk_monitor.getRsp();
                                if (imp.contains("__PRE__")) {
                                    imp = imp.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(sdkAdInfo.getCodPrice() * 10).getBytes(), 2));
                                }
                                if (imp.contains("__PRICE__")) {
                                    if ("BAIDU".equals(sdkAdInfo.getSdk())) {
                                        if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                            int price11 = sdkAdInfo.getPrice();
                                            StringBuilder sb11 = new StringBuilder();
                                            str = "__PRICE__";
                                            sb11.append("ssp");
                                            sb11.append(Base64.encodeToString(String.valueOf(price11 * 10).getBytes(), 2));
                                            string = sb11.toString();
                                            imp = imp.replace(str, string);
                                        }
                                    } else if (!"bidding".equals(sdkAdInfo.getOtype())) {
                                        int price12 = sdkAdInfo.getPrice();
                                        StringBuilder sb12 = new StringBuilder();
                                        str = "__PRICE__";
                                        sb12.append("ssp");
                                        sb12.append(Base64.encodeToString(String.valueOf(price12 * 10).getBytes(), 2));
                                        string = sb12.toString();
                                        imp = imp.replace(str, string);
                                    }
                                }
                                sdkAdInfo.setClk(aVar5.a(sdkAdInfo, clk6));
                                sdkAdInfo.setErr(aVar5.a(sdkAdInfo, err6));
                                sdkAdInfo.setImp(aVar5.a(sdkAdInfo, imp));
                                sdkAdInfo.setReq(aVar5.a(sdkAdInfo, req6));
                                sdkAdInfo.setRsp(aVar5.a(sdkAdInfo, rsp6));
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar17 = new com.kc.dw.core.loader.loadbean.a();
                                aVar17.f39268a = sdkAdInfo;
                                aVar17.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar17);
                            } else {
                                if (sdkAdInfo.getAct_type() != 0) {
                                    if (ssdAdInfo3.getAct_type() > 0) {
                                        sdkAdInfo.setAct_type(ssdAdInfo3.getAct_type());
                                    } else {
                                        sdkAdInfo.setAct_type(2);
                                    }
                                }
                                sdkAdInfo.setMsLoadedTime(ssdAdInfo3.getLoadedTime());
                                sdkAdInfo.setReq(sdkAdInfo.getReq().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setRsp(sdkAdInfo.getRsp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setClk(sdkAdInfo.getClk().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setErr(sdkAdInfo.getErr().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setImp(sdkAdInfo.getImp().replace("__UUID__", aVar5.b.getReq_id()));
                                sdkAdInfo.setFinalRsp(sdkAdInfo.getRsp());
                                if (!"GDT".equals(sdkAdInfo.getSdk())) {
                                }
                                com.kc.dw.core.loader.loadbean.a aVar18 = new com.kc.dw.core.loader.loadbean.a();
                                aVar18.f39268a = sdkAdInfo;
                                aVar18.e = (1000 - sdkAdInfo.getPriority()) * 1000000;
                                aVar5.i.add(aVar18);
                            }
                        }
                    }
                    synchronized (aVar5) {
                        eVar = new com.kc.dw.core.loader.strategy.e(aVar5.e, aVar5.b);
                        aVar5.d = eVar;
                        eVar.i = aVar5;
                        list = aVar5.i;
                        Map<String, Object> map3 = aVar5.c;
                        j = aVar5.h;
                        eVar.e = list;
                        eVar.f.clear();
                        eVar.f.addAll(list);
                        eVar.g = map3;
                        if (list.size() != 0) {
                            if (eVar.b.isHasOwnAd()) {
                                eVar.b();
                            }
                            eVar.v = eVar.b.getBf_num();
                            eVar.k = j;
                            ssdAdInfo = eVar.b;
                            all_timeout2 = 10000;
                            if (ssdAdInfo != null) {
                                if (ssdAdInfo.getAll_timeout() <= 0) {
                                    all_timeout3 = 10000;
                                } else {
                                    all_timeout3 = eVar.b.getAll_timeout();
                                }
                                eVar.p = all_timeout3;
                            }
                            if (eVar.b.getAll_timeout() > 0) {
                                all_timeout2 = eVar.b.getAll_timeout();
                            }
                            eVar.j.postDelayed(new com.kc.dw.core.loader.strategy.b(eVar), all_timeout2 - (SystemClock.uptimeMillis() - eVar.k));
                            while (i2 < eVar.v) {
                                eVar.g();
                            }
                        }
                    }
                }
                throw th;
            }
        }
    }

    static {
        HashMap map = new HashMap();
        hashParams = map;
        map.put("device_imei", "");
        adCounter = new AtomicLong();
        adTypeCounter = new HashMap();
        for (AdType adType : AdType.values()) {
            adTypeCounter.put(adType, new AtomicLong());
        }
        queryParams = new String[]{"app_id", "pid", "accept_ad_type", "sdk_version", "sdk_version_code", "device_os"};
        try {
            cryptKey = new byte[16];
            new SecureRandom().nextBytes(cryptKey);
            cryptKeyStr = o1.a(cryptKey).toLowerCase();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cryptCipher = cipher;
            cipher.init(2, new SecretKeySpec(cryptKey, "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest((cryptKeyStr + SsdAdConfig.initUUID()).getBytes())));
        } catch (Exception e2) {
            cryptKeyStr = null;
            cryptCipher = null;
            e2.printStackTrace();
        }
    }

    private void asynGetDns() {
        ExecutorService executorService = f0.f39362a;
        f0.b.f39363a.a(new e(this));
    }

    /* JADX WARN: Code duplicated, block: B:103:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[Catch: all -> 0x00ea, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00ea, blocks: (B:6:0x0007, B:19:0x0033, B:20:0x0036, B:21:0x0039, B:52:0x006e, B:54:0x0073, B:56:0x0078, B:57:0x007b, B:42:0x005d, B:44:0x0062, B:64:0x00d6, B:66:0x00dc, B:69:0x00e6, B:63:0x00d3, B:58:0x007c, B:60:0x0082), top: B:96:0x0007, inners: #12, #14 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0082 A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #12 {all -> 0x00d2, blocks: (B:58:0x007c, B:60:0x0082), top: B:97:0x007c, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00dc A[Catch: Exception -> 0x00e5, all -> 0x00ea, TRY_LEAVE, TryCatch #14 {Exception -> 0x00e5, blocks: (B:64:0x00d6, B:66:0x00dc), top: B:101:0x00d6, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x0082, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static String decryptBody(byte[] bArr) {
        String str;
        ?? byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Exception e2;
        synchronized (a.class) {
            str = "";
            if (bArr != null) {
                try {
                    Cipher cipher = cryptCipher;
                    if (cipher != null) {
                        ByteArrayInputStream byteArrayInputStream2 = null;
                        ?? r3 = 0;
                        try {
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(cipher.doFinal(bArr));
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                        try {
                                            byte[] bArr2 = new byte[1024];
                                            while (true) {
                                                int i2 = gZIPInputStream.read(bArr2);
                                                if (i2 == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(bArr2, 0, i2);
                                            }
                                            str = byteArrayOutputStream.toString();
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (IOException unused) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (IOException unused2) {
                                            }
                                        } catch (Exception e3) {
                                            e2 = e3;
                                            try {
                                                e2.printStackTrace();
                                                if (byteArrayOutputStream != 0) {
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (IOException unused3) {
                                                    }
                                                }
                                                if (gZIPInputStream != null) {
                                                    try {
                                                        gZIPInputStream.close();
                                                    } catch (IOException unused4) {
                                                    }
                                                }
                                                if (byteArrayInputStream != null) {
                                                }
                                                if (TextUtils.isEmpty(str)) {
                                                    Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                                                    cryptCipher = cipher2;
                                                    cipher2.init(2, new SecretKeySpec(cryptKey, "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest((cryptKeyStr + SsdAdConfig.initUUID()).getBytes())));
                                                    str = new String(cryptCipher.doFinal(Base64.decode(bArr, 0)), "UTF-8");
                                                }
                                                if (TextUtils.isEmpty(str)) {
                                                    str = new String(bArr, "UTF-8");
                                                }
                                                return str;
                                            } catch (Throwable th) {
                                                th = th;
                                                byteArrayInputStream2 = byteArrayInputStream;
                                                byteArrayOutputStream = byteArrayOutputStream;
                                                byteArrayInputStream = byteArrayInputStream2;
                                                r3 = byteArrayOutputStream;
                                                if (r3 != 0) {
                                                    try {
                                                        r3.close();
                                                    } catch (IOException unused5) {
                                                    }
                                                }
                                                if (gZIPInputStream != null) {
                                                    try {
                                                        gZIPInputStream.close();
                                                    } catch (IOException unused6) {
                                                    }
                                                }
                                                if (byteArrayInputStream != null) {
                                                    throw th;
                                                }
                                                try {
                                                    byteArrayInputStream.close();
                                                    throw th;
                                                } catch (IOException unused7) {
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r3 = byteArrayOutputStream;
                                            if (r3 != 0) {
                                                r3.close();
                                            }
                                            if (gZIPInputStream != null) {
                                                gZIPInputStream.close();
                                            }
                                            if (byteArrayInputStream != null) {
                                                throw th;
                                            }
                                            byteArrayInputStream.close();
                                            throw th;
                                        }
                                    } catch (Exception e4) {
                                        gZIPInputStream = null;
                                        e2 = e4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        gZIPInputStream = null;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    gZIPInputStream = null;
                                    e2 = e;
                                    byteArrayOutputStream = gZIPInputStream;
                                    e2.printStackTrace();
                                    if (byteArrayOutputStream != 0) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (gZIPInputStream != null) {
                                        gZIPInputStream.close();
                                    }
                                    if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        Cipher cipher3 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                                        cryptCipher = cipher3;
                                        cipher3.init(2, new SecretKeySpec(cryptKey, "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest((cryptKeyStr + SsdAdConfig.initUUID()).getBytes())));
                                        str = new String(cryptCipher.doFinal(Base64.decode(bArr, 0)), "UTF-8");
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        str = new String(bArr, "UTF-8");
                                    }
                                    return str;
                                } catch (Throwable th4) {
                                    th = th4;
                                    gZIPInputStream = null;
                                    if (r3 != 0) {
                                        r3.close();
                                    }
                                    if (gZIPInputStream != null) {
                                        gZIPInputStream.close();
                                    }
                                    if (byteArrayInputStream != null) {
                                        throw th;
                                    }
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                byteArrayInputStream = null;
                                gZIPInputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = 0;
                                gZIPInputStream = null;
                                byteArrayInputStream = byteArrayInputStream2;
                                r3 = byteArrayOutputStream;
                                if (r3 != 0) {
                                    r3.close();
                                }
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                if (byteArrayInputStream != null) {
                                    throw th;
                                }
                                byteArrayInputStream.close();
                                throw th;
                            }
                            byteArrayInputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    try {
                        if (TextUtils.isEmpty(str)) {
                            Cipher cipher4 = Cipher.getInstance("AES/CBC/PKCS7Padding");
                            cryptCipher = cipher4;
                            cipher4.init(2, new SecretKeySpec(cryptKey, "AES"), new IvParameterSpec(MessageDigest.getInstance("MD5").digest((cryptKeyStr + SsdAdConfig.initUUID()).getBytes())));
                            str = new String(cryptCipher.doFinal(Base64.decode(bArr, 0)), "UTF-8");
                        }
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = new String(bArr, "UTF-8");
                        }
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                } catch (Throwable th7) {
                    throw th7;
                }
            }
        }
        return str;
    }

    private Map<String, String> generateParams(Map<String, String> map) {
        Integer num = this.accept_ad_width;
        if (num != null && num.intValue() >= 0) {
            map.put("accept_ad_width", String.valueOf(this.accept_ad_width));
        }
        Integer num2 = this.accept_ad_height;
        if (num2 != null && num2.intValue() >= 0) {
            map.put("accept_ad_height", String.valueOf(this.accept_ad_height));
        }
        return map;
    }

    public static String getCryptKeyStr() {
        return cryptKeyStr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Request getRequestBody(String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        String str2 = "message=" + map2.get("message") + "&nonce=" + map2.get("nonce") + "&" + SignatureFragment.SIGNATURE + "=" + map2.get(SignatureFragment.SIGNATURE) + "&enc=" + map2.get("enc") + "&s0=" + this.T1 + Consts.DOT + this.T2 + Consts.DOT + this.T3 + "&s1=" + r.e + Consts.DOT + r.f + Consts.DOT + z.d + Consts.DOT + z.e;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if ("app_id".equals(key)) {
                    value = URLEncoder.encode(value);
                }
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    if (sb.toString().contains("?")) {
                        sb.append("&");
                    } else {
                        sb.append("?");
                    }
                    sb.append(key);
                    sb.append("=");
                    sb.append(value);
                }
            }
        }
        Request.Builder builderUrl = new Request.Builder().url(sb.toString());
        builderUrl.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), str2));
        if (map3 != null) {
            Headers.Builder builder = new Headers.Builder();
            for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                builder.add(entry2.getKey(), entry2.getValue());
            }
            builderUrl.headers(builder.build());
        }
        return builderUrl.build();
    }

    private e1 getUrlFromToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = str.split("\\|")[1];
            Charset charset = d1.f39359a;
            return (e1) new Gson().fromJson(new String(Base64.decode(str2, 0)), e1.class);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCsj(SsdAdInfo ssdAdInfo) {
        SdkAdInfo[] sdk = ssdAdInfo.getSdk();
        if (sdk != null) {
            for (SdkAdInfo sdkAdInfo : sdk) {
                if ("CSJ-GM".equals(sdkAdInfo.getSdk())) {
                    sdkAdInfo.setCsjGM(true);
                    n1.b = true;
                    sdkAdInfo.setSdk("CSJ");
                    if ("bidding".equals(sdkAdInfo.getOtype())) {
                        sdkAdInfo.setOtype("price");
                        sdkAdInfo.setCsjGMBidding(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDynamicClick(SsdAdInfo ssdAdInfo) {
        StringBuilder sbA = com.kc.dw.activity.a.a("act_type=");
        sbA.append(ssdAdInfo.getAct_type());
        LogUtil.d(TAG, sbA.toString());
        SsdAdInfo.DClickData dclk = ssdAdInfo.getDclk();
        if (dclk != null) {
            int power = dclk.getPower();
            if (dclk.getPtime() <= 0 || power >= ssdAdInfo.getPower_index()) {
                return;
            }
            HashMap<String, t0.a> map = t0.f39405a;
            t0.a(ssdAdInfo.getPid(), 6);
        }
    }

    private void handleTimeout() {
        int to;
        this.isLoadTimeout = false;
        this.isLoadSucc = false;
        if (getAdType() != AdType.SPLASH || getFetchDelay() <= 0) {
            return;
        }
        try {
            PackageBean.AdBean adBean = com.kc.dw.core.utils.b.b;
            if (adBean == null || adBean.getSplash() == null || (to = com.kc.dw.core.utils.b.b.getSplash().getTo()) < 0) {
                to = 500;
            }
        } catch (Throwable unused) {
        }
        SdkHandler.getInstance().postDelay(new c(this), getFetchDelay() + to);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(SsdAdInfo ssdAdInfo, Map<String, Object> map) {
        SdkHandler.runOnMainThread(new j(this, ssdAdInfo, map));
    }

    private void loadGDTAD(SsdAdInfo ssdAdInfo, Map<String, Object> map) {
        z.a(ssdAdInfo.getdUrl()[0], (Map<String, String>) null, new i(this, ssdAdInfo, map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadSuccess(byte[] bArr, Map<String, Object> map, AppendInfo appendInfo) {
        try {
            String strDecryptBody = decryptBody(bArr);
            SsdAdInfo ssdAdInfoFromJson = SsdAdInfo.fromJson(strDecryptBody, getAdType());
            this.T10 = System.currentTimeMillis();
            if (ssdAdInfoFromJson == null) {
                handleNoAd(appendInfo, 4, "meishuAdInfo is null");
                return;
            }
            appendInfo.setCurReqId(ssdAdInfoFromJson.getReq_id());
            appendInfo.setFromId(ssdAdInfoFromJson.getFrom_id());
            setDynamicData(ssdAdInfoFromJson, strDecryptBody);
            com.kc.dw.core.utils.i.a(ssdAdInfoFromJson.getDefImage(), false, null);
            ssdAdInfoFromJson.setPid(this.posId);
            ssdAdInfoFromJson.setAllTimes(appendInfo.getCurAllTimes());
            ssdAdInfoFromJson.setLoadedTime(SystemClock.uptimeMillis());
            ssdAdInfoFromJson.setAppendInfo(appendInfo);
            saveWxAppid(ssdAdInfoFromJson.getWx_appid());
            if (ssdAdInfoFromJson.getTarget_type() == 1 && "GDT".equalsIgnoreCase(ssdAdInfoFromJson.getFrom())) {
                loadGDTAD(ssdAdInfoFromJson, map);
            } else {
                loadAd(ssdAdInfoFromJson, map);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            handleNoAd(appendInfo, 9, e2.toString());
        }
    }

    private void preLoadRes(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            getUrlFromToken(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryNet(Request request, Map<String, Object> map, AppendInfo appendInfo) {
        z.a(request, new d(this, appendInfo, map));
    }

    private void saveLoadRecord(String str, int i2) {
        ExecutorService executorService = f0.f39362a;
        f0.b.f39363a.a(new f(this, str));
    }

    private void saveWxAppid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kc.dw.base.a.getSharedPreferences().edit().putString("wx_appid", str).apply();
    }

    private void setDynamicData(SsdAdInfo ssdAdInfo, String str) {
        try {
            Type type = new g(this).getType();
            ssdAdInfo.setDynamicMap((HashMap) new GsonBuilder().registerTypeAdapter(type, new h(this)).create().fromJson(str, type));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Map<String, String> wrapParams(Map<String, String> map) {
        try {
            try {
                Map<String, String> mapWrapParams = AdParallelLoader.wrapParams(map);
                this.T3 = System.currentTimeMillis();
                if (mapWrapParams != null) {
                    return mapWrapParams;
                }
                return null;
            } catch (Exception unused) {
                String hexString = Long.toHexString(((System.currentTimeMillis() / 3) * 3) + 1);
                JSONObject jSONObject = new JSONObject();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if (hashParams.containsKey(entry.getKey())) {
                        try {
                            value = o1.a(MessageDigest.getInstance("MD5").digest(value.getBytes())).toLowerCase();
                        } catch (Exception unused2) {
                        }
                    }
                    if (!"pid".equals(entry.getKey())) {
                        jSONObject.put(entry.getKey(), value);
                        arrayList.add(entry.getKey() + "=" + value);
                    }
                }
                arrayList.add("5317f4377245bfb8efdc42c45d71bd43");
                arrayList.add(hexString);
                Collections.sort(arrayList);
                HashMap map2 = new HashMap();
                map2.put("message", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                map2.put("nonce", hexString);
                map2.put(SignatureFragment.SIGNATURE, Base64.encodeToString(MessageDigest.getInstance(Client.HASH_SHA256).digest(TextUtils.join("&", arrayList).getBytes()), 2));
                return map2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public abstract com.kc.dw.core.loader.b createDelegate(SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo);

    public abstract com.kc.dw.core.loader.b createOwnAdDelegate(Context context, SsdAdInfo ssdAdInfo);

    @Override // com.kc.dw.core.loader.IAdLoader
    public void destroy() {
        com.kc.dw.core.loader.strategy.a aVar;
        com.kc.dw.core.loader.concurrent.a aVar2 = this.loaderManager;
        if (aVar2 == null || (aVar = aVar2.d) == null) {
            return;
        }
        com.kc.dw.core.loader.strategy.e eVar = (com.kc.dw.core.loader.strategy.e) aVar;
        Handler handler = eVar.j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        try {
            List<com.kc.dw.core.loader.b> list = eVar.q;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.kc.dw.core.loader.b bVar : eVar.q) {
                if (bVar != null) {
                    try {
                        bVar.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            eVar.q.clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public Integer getAccept_ad_height() {
        return this.accept_ad_height;
    }

    public Integer getAccept_ad_width() {
        return this.accept_ad_width;
    }

    public SsdAdSlot getAdSlot() {
        return this.adSlot;
    }

    public AdType getAdType() {
        if (this instanceof RecyclerMixCommonAdLoader) {
            return AdType.FEED_MIX;
        }
        if (this instanceof BannerCommonAdLoader) {
            return AdType.BANNER;
        }
        if (this instanceof SplashCommonAdLoader) {
            return AdType.SPLASH;
        }
        if (this instanceof InterstitialCommonAdLoader) {
            return AdType.INTERSTITIAL;
        }
        if (this instanceof PasterCommonAdLoader) {
            return AdType.PASTER;
        }
        if (this instanceof RewardVideoCommonLoader) {
            return AdType.REWARD;
        }
        if (this instanceof DrawCommonAdLoader) {
            return AdType.DRAW;
        }
        if (this instanceof FullScreenVideoCommonAdLoader) {
            return AdType.FULL_SCREEN_VIDEO;
        }
        return null;
    }

    @Override // com.kc.dw.core.loader.IAdLoader
    public Context getContext() {
        return this.context;
    }

    public int getFetchDelay() {
        return 0;
    }

    @Override // com.kc.dw.core.loader.IAdLoader
    public T getLoaderListener() {
        return this.loaderListener;
    }

    public String getPosId() {
        return this.posId;
    }

    public long getT1() {
        return this.T1;
    }

    public void handleNoAd(AppendInfo appendInfo, int i2, String str) {
        com.kc.dw.core.service.logrecord.a.a(appendInfo.getBaseEventTimes(), 5, "f1", null, this.posId, getAdType(), appendInfo.getCurAllTimes(), appendInfo.getCurReqId(), new CodeMsg().init("f1", appendInfo.getBaseEventTimes()).setData(i2, str));
        try {
            if (this.loaderListener != null) {
                SdkHandler.getInstance().runOnUiThread(new C1024a(this, str));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void init(Context context, SsdAdSlot ssdAdSlot, T t) {
        this.context = context;
        this.adSlot = ssdAdSlot;
        this.posId = ssdAdSlot.getPid();
        this.accept_ad_width = Integer.valueOf(ssdAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(ssdAdSlot.getHeight());
        this.channel = ssdAdSlot.getChannel();
        this.loaderListener = t;
    }

    @Override // com.kc.dw.core.loader.IAdLoader
    public void loadAd() {
        loadAd(new HashMap());
    }

    public void loadAd(Map<String, Object> map) {
        AppendInfo appendInfo = new AppendInfo();
        try {
            AdType adType = getAdType();
            long jIncrementAndGet = adCounter.incrementAndGet();
            appendInfo.setCurAllTimes(jIncrementAndGet);
            com.kc.dw.core.service.logrecord.a.a(appendInfo.getBaseEventTimes(), 5, "e1", null, this.posId, adType, jIncrementAndGet, null);
            if (com.kc.dw.base.a.adConfig() == null) {
                Log.e("sdk", "SDK IS NOT INITED ！");
                handleNoAd(appendInfo, 9, "SDK IS NOT INITED！");
                return;
            }
            this.startLoadTime = System.currentTimeMillis();
            asynGetDns();
            boolean z = l.b;
            l.b(com.kc.dw.base.a.getContext());
            if (TextUtils.isEmpty(this.posId)) {
                LogUtil.e(TAG, "pid不能为空！");
                handleNoAd(appendInfo, 9, "pid不能为空！");
                return;
            }
            if (adType == null) {
                LogUtil.e(TAG, "AdType is null！");
                handleNoAd(appendInfo, 9, "AdType is null！");
                return;
            }
            handleTimeout();
            this.T1 = System.currentTimeMillis();
            Map<String, String> mapGenerateParams = generateParams(w0.b(this.context, this.posId, adType, jIncrementAndGet, adTypeCounter.get(adType).incrementAndGet()));
            mapGenerateParams.put("msec", this.startLoadTime + "");
            try {
                SsdAdSlot ssdAdSlot = this.adSlot;
                if (ssdAdSlot != null && ssdAdSlot.getIsClickToClose()) {
                    mapGenerateParams.put("close_on_click", "1");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (map.containsKey(KEY_TOKEN)) {
                    String str = (String) map.get(KEY_TOKEN);
                    mapGenerateParams.put("token", str);
                    preLoadRes(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                com.kc.dw.core.utils.d.b.f39357a.a(true, false);
            }
            if (!TextUtils.isEmpty(this.channel)) {
                mapGenerateParams.put(xh9.WEBSITE_PARAMS_CHANNEL, this.channel);
            }
            mapGenerateParams.put("impersonal", com.kc.dw.base.a.adConfig().getCanUseSdkPersonalRecommend() ? "0" : "1");
            this.T2 = System.currentTimeMillis();
            if (cryptCipher != null) {
                mapGenerateParams.put("gzip_crypt_key", cryptKeyStr);
            }
            mapGenerateParams.put("commit", "a0b7cd6f");
            mapGenerateParams.put("oem", "1005");
            HashMap map2 = new HashMap();
            map2.put("MS-SDK-Version", "Android-" + mapGenerateParams.get("sdk_version"));
            map2.put("Content-Type", "application/x-www-form-urlencoded");
            Map<String, String> mapWrapParams = wrapParams(mapGenerateParams);
            HashMap map3 = new HashMap();
            for (String str2 : queryParams) {
                String str3 = mapGenerateParams.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    map3.put(str2, str3);
                }
            }
            saveLoadRecord(this.posId, 1);
            Request requestBody = getRequestBody((com.kc.dw.base.a.adConfig().secure() == 1 || p0.n == 1) ? "https://sdk.1rtb.net/sdk/req_ad" : "http://sdk.1rtb.net/sdk/req_ad", map3, mapWrapParams, map2);
            this.T8 = System.currentTimeMillis();
            z.a(requestBody, new b(this, map3, mapWrapParams, map2, map, appendInfo));
            Context context = com.kc.dw.base.a.getContext();
            boolean zIsTest = com.kc.dw.base.a.adConfig().isTest();
            if (com.kc.dw.core.exception.c.b) {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                if (defaultUncaughtExceptionHandler instanceof com.kc.dw.core.exception.c.b) {
                    return;
                }
                Thread.setDefaultUncaughtExceptionHandler(new com.kc.dw.core.exception.c.b(context, zIsTest, defaultUncaughtExceptionHandler));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            handleNoAd(appendInfo, 9, e3.toString());
        }
    }
}
