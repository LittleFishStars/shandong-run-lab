package com.aliyun.svideosdk.conan.event;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Range;
import com.aliyun.credentials.utils.AuthConstant;
import com.aliyun.svideosdk.conan.DoNotProguard;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@DoNotProguard
public class AlivcEventReporter {
    private static final Map<Long, AlivcEventReporter> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25694a;
    private String b;
    private c c;

    @DoNotProguard
    private String mAccessKey;

    @DoNotProguard
    private int mBussinessType;

    @DoNotProguard
    private String mClientID;

    @DoNotProguard
    private String mDeviceModel;

    @DoNotProguard
    private String mEndPoint;

    @DoNotProguard
    private String mExpireTime;

    @DoNotProguard
    private String mLogStore;

    @DoNotProguard
    private String mProjectName;

    @DoNotProguard
    private String mSecretKey;

    @DoNotProguard
    private String mSecurityToken;

    @DoNotProguard
    private String mTerminalType;

    @DoNotProguard
    private boolean mUseExternalAuth;

    @DoNotProguard
    private long mNativeHandler = 0;

    @DoNotProguard
    private long mNativeCallback = 0;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f25695a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o = "true";
        private String p;

        public a(AlivcEventReporter alivcEventReporter) {
        }

        public String a() {
            return this.e;
        }

        public void a(String str) {
            this.e = str;
        }

        public String b() {
            return this.d;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.h;
        }

        public void c(String str) {
            this.h = str;
        }

        public String d() {
            return this.k;
        }

        public void d(String str) {
            this.k = str;
        }

        public String e() {
            return this.j;
        }

        public void e(String str) {
            this.j = str;
        }

        public String f() {
            return this.l;
        }

        public void f(String str) {
            this.l = str;
        }

        public String g() {
            return this.o;
        }

        public void g(String str) {
            this.o = str;
        }

        public String h() {
            return this.p;
        }

        public void h(String str) {
            this.p = str;
        }

        public String i() {
            return this.i;
        }

        public void i(String str) {
            this.i = str;
        }

        public String j() {
            return this.g;
        }

        public void j(String str) {
            this.g = str;
        }

        public String k() {
            return this.n;
        }

        public void k(String str) {
            this.n = str;
        }

        public String l() {
            return this.c;
        }

        public void l(String str) {
            this.c = str;
        }

        public String m() {
            return this.f25695a;
        }

        public void m(String str) {
            this.f25695a = str;
        }

        public String n() {
            return this.b;
        }

        public void n(String str) {
            this.b = str;
        }

        public String o() {
            return this.m;
        }

        public void o(String str) {
            this.m = str;
        }

        public String p() {
            return this.f;
        }

        public void p(String str) {
            this.f = str;
        }
    }

    public AlivcEventReporter(b bVar) throws IllegalArgumentException {
        if (com.aliyun.svideosdk.conan.b.l() == null) {
            throw new IllegalArgumentException("Context must NOT null, check setSDKContext");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("Unable to initialize the AlivcEventReporter with empty configuration!");
        }
        try {
            this.mClientID = com.aliyun.svideosdk.conan.b.h();
            this.mTerminalType = com.aliyun.svideosdk.conan.b.m();
            this.mDeviceModel = com.aliyun.svideosdk.conan.b.g();
            this.mBussinessType = bVar.d().a();
            this.mUseExternalAuth = bVar.l();
            this.mEndPoint = bVar.e();
            this.mProjectName = bVar.h();
            this.mLogStore = bVar.g();
            this.mAccessKey = bVar.a();
            this.mSecretKey = bVar.j();
            this.mSecurityToken = bVar.k();
            this.mExpireTime = bVar.f();
            initNative(com.aliyun.svideosdk.conan.b.l());
            com.aliyun.svideosdk.conan.event.a.b().a(bVar.b());
            com.aliyun.svideosdk.conan.event.a.b().b(bVar.c());
            com.aliyun.svideosdk.conan.event.a.b().a(bVar.i());
            if (this.mNativeHandler != 0) {
                long idNative = getIdNative();
                if (idNative != -1) {
                    this.f25694a = idNative;
                    d.put(Long.valueOf(idNative), this);
                }
                setPublicParamNative(a(com.aliyun.svideosdk.conan.event.a.b().a()));
            }
        } catch (Throwable unused) {
        }
    }

    private String a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            boolean z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!z) {
                    sb.append(" *||* ");
                }
                sb.append(entry.getKey());
                sb.append(" * ");
                sb.append(entry.getValue());
                z = false;
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    @DoNotProguard
    private native void destoryNative();

    @DoNotProguard
    private native int flushEventNative(int i, String str);

    @DoNotProguard
    private native long getIdNative();

    @DoNotProguard
    private native void initNative(Context context);

    @DoNotProguard
    private void onEventReport(Map<String, String> map) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this, map);
        }
    }

    @DoNotProguard
    private void onEventReportErrorOccur(int i) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this, i);
        }
    }

    @DoNotProguard
    private void onStsExpired() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @DoNotProguard
    private void onStsWillExpireSoon(long j) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this, j);
        }
    }

    @DoNotProguard
    private native int resetAcessTokenInfoNative();

    @DoNotProguard
    private native int sendEventNative(int i, String str);

    @DoNotProguard
    private native int setPublicParamNative(String str);

    @DoNotProguard
    private native int updatePublicParamNative(String str, String str2);

    public int a(int i, Map<String, String> map) {
        if (this.mNativeHandler != 0) {
            return sendEventNative(i, a(map));
        }
        return -1;
    }

    public synchronized long a() {
        return this.mNativeHandler != 0 ? getIdNative() : -1L;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
    }

    public void b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        MediaCodecInfo mediaCodecInfo;
        String str;
        String[] strArr;
        int i6;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities;
        JSONArray jSONArray = new JSONArray();
        try {
            int codecCount = MediaCodecList.getCodecCount();
            int i7 = 0;
            i5 = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            while (i7 < codecCount) {
                try {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i7);
                    String name = codecInfoAt.getName();
                    boolean zIsEncoder = codecInfoAt.isEncoder();
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int i8 = 0;
                    for (int length = supportedTypes.length; i8 < length; length = i6) {
                        String str2 = supportedTypes[i8];
                        a aVar = new a(this);
                        int i9 = codecCount;
                        try {
                            boolean zContains = str2.contains("avc");
                            strArr = supportedTypes;
                            try {
                                boolean zContains2 = str2.contains("hevc");
                                if (zContains || zContains2) {
                                    aVar.m(name);
                                    str = name;
                                    try {
                                        aVar.n(zIsEncoder ? "enc" : "dec");
                                        aVar.l(str2);
                                        MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                                        if (!zIsEncoder) {
                                            aVar.h(String.valueOf(capabilitiesForType.isFeatureSupported("adaptive-playback")));
                                        }
                                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                        mediaCodecInfo = codecInfoAt;
                                        if (videoCapabilities != null) {
                                            try {
                                                int widthAlignment = videoCapabilities.getWidthAlignment();
                                                int heightAlignment = videoCapabilities.getHeightAlignment();
                                                i6 = length;
                                                try {
                                                    aVar.b(String.valueOf(widthAlignment));
                                                    aVar.a(String.valueOf(heightAlignment));
                                                    Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                                                    StringBuilder sb = new StringBuilder();
                                                    i7 = i7;
                                                    try {
                                                        sb.append(supportedWidths.getLower());
                                                        sb.append(c49.f40900a);
                                                        sb.append(supportedWidths.getUpper());
                                                        aVar.p(sb.toString());
                                                        Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                                                        aVar.j(supportedHeights.getLower() + c49.f40900a + supportedHeights.getUpper());
                                                        Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
                                                        aVar.c(bitrateRange.getLower() + c49.f40900a + bitrateRange.getUpper());
                                                        Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                                                        aVar.i(supportedFrameRates.getLower() + c49.f40900a + supportedFrameRates.getUpper());
                                                    } catch (Exception e) {
                                                        e = e;
                                                        e.printStackTrace();
                                                        aVar.g(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                                        JSONObject jSONObject = new JSONObject();
                                                        jSONObject.put("name", aVar.m());
                                                        jSONObject.put("type", aVar.n());
                                                        jSONObject.put("feat1", aVar.h());
                                                        jSONObject.put("mime", aVar.l());
                                                        jSONObject.put("alignW", aVar.b());
                                                        jSONObject.put("alignH", aVar.a());
                                                        jSONObject.put("width", aVar.p());
                                                        jSONObject.put("height", aVar.j());
                                                        jSONObject.put(MediaFormat.KEY_BIT_RATE, aVar.c());
                                                        jSONObject.put("frameRate", aVar.i());
                                                        jSONObject.put("complexity", aVar.e());
                                                        jSONObject.put("cbr", aVar.d());
                                                        jSONObject.put("cq", aVar.f());
                                                        jSONObject.put("vbr", aVar.o());
                                                        jSONObject.put("maxInst", aVar.k());
                                                        jSONObject.put(AuthConstant.INI_ENABLE, aVar.g());
                                                        jSONArray.put(jSONObject);
                                                        i8++;
                                                        this = this;
                                                        codecCount = i9;
                                                        supportedTypes = strArr;
                                                        codecInfoAt = mediaCodecInfo;
                                                        name = str;
                                                        i7 = i7;
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    i7 = i7;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                i6 = length;
                                                e.printStackTrace();
                                                aVar.g(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("name", aVar.m());
                                                jSONObject2.put("type", aVar.n());
                                                jSONObject2.put("feat1", aVar.h());
                                                jSONObject2.put("mime", aVar.l());
                                                jSONObject2.put("alignW", aVar.b());
                                                jSONObject2.put("alignH", aVar.a());
                                                jSONObject2.put("width", aVar.p());
                                                jSONObject2.put("height", aVar.j());
                                                jSONObject2.put(MediaFormat.KEY_BIT_RATE, aVar.c());
                                                jSONObject2.put("frameRate", aVar.i());
                                                jSONObject2.put("complexity", aVar.e());
                                                jSONObject2.put("cbr", aVar.d());
                                                jSONObject2.put("cq", aVar.f());
                                                jSONObject2.put("vbr", aVar.o());
                                                jSONObject2.put("maxInst", aVar.k());
                                                jSONObject2.put(AuthConstant.INI_ENABLE, aVar.g());
                                                jSONArray.put(jSONObject2);
                                                i8++;
                                                this = this;
                                                codecCount = i9;
                                                supportedTypes = strArr;
                                                codecInfoAt = mediaCodecInfo;
                                                name = str;
                                                i7 = i7;
                                            }
                                        } else {
                                            i7 = i7;
                                            i6 = length;
                                        }
                                        if (zIsEncoder && (encoderCapabilities = capabilitiesForType.getEncoderCapabilities()) != null) {
                                            Range<Integer> complexityRange = encoderCapabilities.getComplexityRange();
                                            aVar.e(complexityRange.getLower() + c49.f40900a + complexityRange.getUpper());
                                            aVar.d(String.valueOf(encoderCapabilities.isBitrateModeSupported(2)));
                                            try {
                                                aVar.f(String.valueOf(encoderCapabilities.isBitrateModeSupported(0)));
                                                aVar.o(String.valueOf(encoderCapabilities.isBitrateModeSupported(1)));
                                            } catch (Exception e4) {
                                                e = e4;
                                                e.printStackTrace();
                                                aVar.g(AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                            }
                                        }
                                        aVar.k(String.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                                        if (zIsEncoder) {
                                            if (zContains2) {
                                                i5++;
                                            } else if (zContains) {
                                                i2++;
                                            }
                                        } else if (zContains2) {
                                            i3++;
                                        } else if (zContains) {
                                            i4++;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        mediaCodecInfo = codecInfoAt;
                                    }
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("name", aVar.m());
                                        jSONObject3.put("type", aVar.n());
                                        jSONObject3.put("feat1", aVar.h());
                                        jSONObject3.put("mime", aVar.l());
                                        jSONObject3.put("alignW", aVar.b());
                                        jSONObject3.put("alignH", aVar.a());
                                        jSONObject3.put("width", aVar.p());
                                        jSONObject3.put("height", aVar.j());
                                        jSONObject3.put(MediaFormat.KEY_BIT_RATE, aVar.c());
                                        jSONObject3.put("frameRate", aVar.i());
                                        jSONObject3.put("complexity", aVar.e());
                                        jSONObject3.put("cbr", aVar.d());
                                        jSONObject3.put("cq", aVar.f());
                                        jSONObject3.put("vbr", aVar.o());
                                        jSONObject3.put("maxInst", aVar.k());
                                        jSONObject3.put(AuthConstant.INI_ENABLE, aVar.g());
                                    } catch (JSONException e6) {
                                        e6.printStackTrace();
                                    }
                                    jSONArray.put(jSONObject3);
                                } else {
                                    i7 = i7;
                                    mediaCodecInfo = codecInfoAt;
                                    str = name;
                                    i6 = length;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                mediaCodecInfo = codecInfoAt;
                                str = name;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            mediaCodecInfo = codecInfoAt;
                            str = name;
                            strArr = supportedTypes;
                        }
                        i8++;
                        this = this;
                        codecCount = i9;
                        supportedTypes = strArr;
                        codecInfoAt = mediaCodecInfo;
                        name = str;
                        i7 = i7;
                    }
                    i7++;
                } catch (Exception e9) {
                    e = e9;
                    i = i5;
                    e.printStackTrace();
                    i5 = i;
                    HashMap map = new HashMap();
                    map.put("_hevc_enc_count", String.valueOf(i5));
                    map.put("_avc_enc_count", String.valueOf(i2));
                    map.put("_hevc_dec_count", String.valueOf(i3));
                    map.put("_avc_dec_count", String.valueOf(i4));
                    map.put("codec_info", jSONArray.toString());
                    sendEventNative(6003, a(map));
                }
            }
        } catch (Exception e10) {
            e = e10;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        HashMap map2 = new HashMap();
        map2.put("_hevc_enc_count", String.valueOf(i5));
        map2.put("_avc_enc_count", String.valueOf(i2));
        map2.put("_hevc_dec_count", String.valueOf(i3));
        map2.put("_avc_dec_count", String.valueOf(i4));
        map2.put("codec_info", jSONArray.toString());
        sendEventNative(6003, a(map2));
    }

    public void b(String str) {
        if (this.mNativeHandler == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("av", str);
    }

    public int c() {
        if (this.mNativeHandler == 0) {
            return -1;
        }
        Map<String, String> mapC = com.aliyun.svideosdk.conan.event.a.b().c();
        if (!TextUtils.isEmpty(this.b)) {
            mapC.put("bcid", this.b);
        }
        return sendEventNative(6001, a(mapC));
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("ri", str);
    }

    public void d(String str) {
        if (this.mNativeHandler == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        updatePublicParamNative("md", str);
    }

    @DoNotProguard
    public synchronized void destory() {
        destoryNative();
        d.remove(Long.valueOf(this.f25694a));
        this.mNativeHandler = 0L;
        this.mNativeCallback = 0L;
    }
}
