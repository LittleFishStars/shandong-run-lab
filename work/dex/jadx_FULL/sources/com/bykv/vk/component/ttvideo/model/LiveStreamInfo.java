package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.log.MyLog;
import com.bykv.vk.component.ttvideo.network.DnsHelper;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.zj.adlib.u15;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LiveStreamInfo {
    public static final int LIVE_STREAM_INFO_CMAF_INVALID = 1;
    public static final int LIVE_STREAM_INFO_LLS_INVALID = 2;
    public static final String MPD_VERSION = "1.0";
    private JSONObject mCommonInfo;
    private String mDefaultResolution;
    private int mFlag;
    private String mHost;
    private String mIp;
    private boolean mIsABRListMatch;
    private String mRequestParams;
    private JSONObject mStreamInfo;
    private boolean mEnableOriginResolution = false;
    private long mAdjustedOriginBitRate = -1;
    private int mIsCodecSame = -1;
    private String mTransportProtocol = "";
    private String mPortNum = "";
    private int mRtcFallback = 0;
    private final String TAG = "LiveStreamInfo";
    public int mSRShorterSideUpperBound = 0;
    public int mSRLongerSideUpperBound = 0;
    private int mSRFrameRateUpperBound = 0;
    public int mSharpenLongerSideUpperBound = 0;
    public int mSharpenLongerSideLowerBound = 0;
    public int mSharpenShorterSideUpperBound = 0;
    public int mSharpenShorterSideLowerBound = 0;

    public LiveStreamInfo(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        this.mIsABRListMatch = false;
        if (jSONObject == null) {
            return;
        }
        try {
            this.mStreamInfo = jSONObject.getJSONObject("data");
            if (jSONObject.has("common")) {
                this.mCommonInfo = jSONObject.getJSONObject("common");
            }
            JSONObject jSONObject2 = this.mCommonInfo;
            if (jSONObject2 != null) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("auto");
                if (jSONObject3 != null && jSONObject3.has("default")) {
                    this.mDefaultResolution = jSONObject3.getString("default");
                    MyLog.i("LiveStreamInfo", "mDefaultResolution: " + this.mDefaultResolution);
                }
                this.mIsABRListMatch = true;
                if (jSONObject3 != null && jSONObject3.has(GoodsSpecificationPreviewActivity.z) && (jSONArrayOptJSONArray = jSONObject3.optJSONArray(GoodsSpecificationPreviewActivity.z)) != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        if (!isSupport(jSONArrayOptJSONArray.getString(i))) {
                            this.mIsABRListMatch = false;
                            break;
                        }
                    }
                }
            }
        } catch (JSONException e) {
            m.c(e);
        }
        this.mFlag = 0;
    }

    private boolean isNeedUseDefaultResolution(String str) {
        return (TextUtils.isEmpty(str) || !str.equals("auto") || TextUtils.isEmpty(this.mDefaultResolution)) ? false : true;
    }

    private String set_url_port_scheme(String str) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf(".com");
        int iIndexOf3 = str.indexOf(".com:");
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.mPortNum)) {
            if (iIndexOf3 != -1) {
                int i = iIndexOf3 + 5;
                int i2 = i + 1;
                while (i2 < sb.length() && sb.charAt(i2) - '0' >= 0 && sb.charAt(i2) - '0' <= 9) {
                    i2++;
                }
                sb.replace(i, i2, this.mPortNum);
            } else if (iIndexOf2 != -1 && ((iIndexOf = str.indexOf("vhost")) == -1 || iIndexOf > iIndexOf2)) {
                sb.insert(iIndexOf2 + 4, u15.f19942b + this.mPortNum);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        int iIndexOf4 = sb2.indexOf("://");
        if (!TextUtils.isEmpty(this.mTransportProtocol)) {
            if (this.mTransportProtocol.equals(LiveConfigKey.KCP)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpk");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.QUIC) || this.mTransportProtocol.equals(LiveConfigKey.QUICU)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "httpq");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TLS)) {
                if (iIndexOf4 != -1) {
                    sb2.replace(0, iIndexOf4, "https");
                }
            } else if (this.mTransportProtocol.equals(LiveConfigKey.TCP) && iIndexOf4 != -1) {
                sb2.replace(0, iIndexOf4, "http");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean adjustOriginBitRate(String str, String str2, long j) {
        byte b;
        if (this.mAdjustedOriginBitRate > 0) {
            return true;
        }
        long j2 = -1;
        String str3 = LiveConfigKey.LOW;
        while (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(getStreamUrlForResolution(str3, str, str2))) {
                long bitrate = getBitrate(str3, str2);
                if (str3.equals("origin") && bitrate <= j2 && j > 0) {
                    this.mAdjustedOriginBitRate = j;
                    bitrate = j;
                }
                j2 = bitrate;
            }
            str3.hashCode();
            byte b2 = -1;
            switch (str3.hashCode()) {
                case -1008619738:
                    if (str3.equals("origin")) {
                        b2 = 0;
                    }
                    break;
                case 3324:
                    if (str3.equals(LiveConfigKey.HIGH)) {
                        b2 = 1;
                    }
                    break;
                case 3448:
                    if (str3.equals(LiveConfigKey.LOW)) {
                        b = 2;
                        b2 = b;
                    }
                    break;
                case 3665:
                    if (str3.equals("sd")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 115761:
                    if (str3.equals(LiveConfigKey.UHD)) {
                        b = 4;
                        b2 = b;
                    }
                    break;
            }
            str3 = null;
            switch (b2) {
                case 1:
                    str3 = LiveConfigKey.UHD;
                    break;
                case 2:
                    str3 = "sd";
                    break;
                case 3:
                    str3 = LiveConfigKey.HIGH;
                    break;
                case 4:
                    str3 = "origin";
                    break;
            }
        }
        return this.mAdjustedOriginBitRate > 0;
    }

    public JSONObject getAbrInfo() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject("auto");
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public String getAvLinesParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optString("AvLines");
            }
            return null;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public long getBitrate(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("vbitrate");
        } catch (JSONException e) {
            m.c(e);
            return 0L;
        }
    }

    public int getCheckSilenceInterval(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return -1;
        }
        try {
            String sDKParams = getSDKParams(str, str2);
            if (sDKParams != null) {
                return new JSONObject(sDKParams).optInt("CheckSilenceInterval");
            }
            return -1;
        } catch (JSONException e) {
            m.c(e);
            return -1;
        }
    }

    public String getDefaultResolution() {
        return this.mDefaultResolution;
    }

    public long getGopDuration(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return 0L;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optLong("gop");
        } catch (JSONException e) {
            m.c(e);
            return 0L;
        }
    }

    public Map<String, String> getHTTPHeaders() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("header")) {
            HashMap map = new HashMap();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("header");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.getString(next));
                }
                return map;
            } catch (JSONException e) {
                m.c(e);
            }
        }
        return null;
    }

    public String getLabelfromBitrate(long j, String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        Iterator<String> itKeys = this.mStreamInfo.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (isEnableAdaptive(next) && j == getBitrate(next, str) / 1000) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009f  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ae A[Catch: JSONException -> 0x014a, TryCatch #0 {JSONException -> 0x014a, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00ca, B:36:0x00d2, B:40:0x00ee, B:42:0x00f8, B:44:0x0107, B:46:0x0112, B:47:0x0116, B:43:0x0104, B:24:0x0081, B:54:0x012e), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5 A[Catch: JSONException -> 0x014a, TryCatch #0 {JSONException -> 0x014a, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00ca, B:36:0x00d2, B:40:0x00ee, B:42:0x00f8, B:44:0x0107, B:46:0x0112, B:47:0x0116, B:43:0x0104, B:24:0x0081, B:54:0x012e), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[Catch: JSONException -> 0x014a, TryCatch #0 {JSONException -> 0x014a, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00ca, B:36:0x00d2, B:40:0x00ee, B:42:0x00f8, B:44:0x0107, B:46:0x0112, B:47:0x0116, B:43:0x0104, B:24:0x0081, B:54:0x012e), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00d2 A[Catch: JSONException -> 0x014a, TRY_LEAVE, TryCatch #0 {JSONException -> 0x014a, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00ca, B:36:0x00d2, B:40:0x00ee, B:42:0x00f8, B:44:0x0107, B:46:0x0112, B:47:0x0116, B:43:0x0104, B:24:0x0081, B:54:0x012e), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0104 A[Catch: JSONException -> 0x014a, TryCatch #0 {JSONException -> 0x014a, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00ca, B:36:0x00d2, B:40:0x00ee, B:42:0x00f8, B:44:0x0107, B:46:0x0112, B:47:0x0116, B:43:0x0104, B:24:0x0081, B:54:0x012e), top: B:65:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0112 A[Catch: JSONException -> 0x014a, TryCatch #0 {JSONException -> 0x014a, blocks: (B:9:0x0024, B:10:0x0031, B:12:0x0037, B:14:0x0045, B:16:0x004b, B:20:0x0072, B:22:0x007a, B:25:0x0088, B:29:0x00a3, B:31:0x00ae, B:33:0x00b5, B:34:0x00ca, B:36:0x00d2, B:40:0x00ee, B:42:0x00f8, B:44:0x0107, B:46:0x0112, B:47:0x0116, B:43:0x0104, B:24:0x0081, B:54:0x012e), top: B:65:0x0024 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x00b5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x00d2, please report this as an issue */
    public String getMPDForFormat(String str, String str2, String str3, String str4) {
        long gopDuration;
        String streamUrlForResolution;
        int i;
        long j;
        int i2;
        int iIndexOf;
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject3 = new JSONObject();
            int i3 = 0;
            long j2 = 0;
            for (Iterator<String> itKeys = this.mStreamInfo.keys(); itKeys.hasNext(); itKeys = itKeys) {
                String next = itKeys.next();
                if (!isEnableAdaptive(next) || (streamUrlForResolution = getStreamUrlForResolution(next, str, str2)) == null) {
                    gopDuration = j2;
                    i3 = i3;
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("id", i3);
                    jSONObject4.put("codec", getVCodec(next, str2));
                    jSONObject4.put("format", str);
                    if (next.equals("origin")) {
                        i = i3;
                        j = j2;
                        long j3 = this.mAdjustedOriginBitRate;
                        if (j3 > 0) {
                            jSONObject4.put(MediaFormat.KEY_BIT_RATE, j3);
                        }
                        jSONObject4.put("qualityType", next);
                        jSONObject4.put("hidden", 0);
                        if (this.mDefaultResolution.equals(next)) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        jSONObject4.put("defaultSelect", i2);
                        if (!this.mRequestParams.isEmpty()) {
                            iIndexOf = streamUrlForResolution.indexOf("?");
                            if (iIndexOf == -1) {
                                streamUrlForResolution = streamUrlForResolution + "?" + this.mRequestParams;
                            } else if (iIndexOf != streamUrlForResolution.length() - 1) {
                                streamUrlForResolution = streamUrlForResolution + "&" + this.mRequestParams;
                            }
                        }
                        if (str3 == null && str4 != null && DnsHelper.getUrlHost(streamUrlForResolution).equals(str4)) {
                            jSONObject4.put("url", DnsHelper.hostToIPUrl(set_url_port_scheme(streamUrlForResolution), str3));
                        } else {
                            jSONObject4.put("url", streamUrlForResolution);
                        }
                        arrayList.add(jSONObject4);
                        gopDuration = j;
                        if (gopDuration == 0) {
                            gopDuration = getGopDuration(next, str2);
                        }
                        i3 = i + 1;
                    } else {
                        i = i3;
                        j = j2;
                    }
                    jSONObject4.put(MediaFormat.KEY_BIT_RATE, getBitrate(next, str2));
                    jSONObject4.put("qualityType", next);
                    jSONObject4.put("hidden", 0);
                    if (this.mDefaultResolution.equals(next)) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    jSONObject4.put("defaultSelect", i2);
                    if (!this.mRequestParams.isEmpty()) {
                        iIndexOf = streamUrlForResolution.indexOf("?");
                        if (iIndexOf == -1) {
                            streamUrlForResolution = streamUrlForResolution + "?" + this.mRequestParams;
                        } else if (iIndexOf != streamUrlForResolution.length() - 1) {
                            streamUrlForResolution = streamUrlForResolution + "&" + this.mRequestParams;
                        }
                    }
                    if (str3 == null) {
                        jSONObject4.put("url", streamUrlForResolution);
                    } else {
                        jSONObject4.put("url", streamUrlForResolution);
                    }
                    arrayList.add(jSONObject4);
                    gopDuration = j;
                    if (gopDuration == 0) {
                        gopDuration = getGopDuration(next, str2);
                    }
                    i3 = i + 1;
                }
                j2 = gopDuration;
            }
            long j4 = j2;
            if (i3 == 0) {
                return null;
            }
            jSONObject3.put("gopDuration", j4);
            jSONObject3.put("representation", new JSONArray((Collection) arrayList));
            jSONObject2.put("version", "1.0");
            jSONObject2.put("adaptationSet", jSONObject3);
        } catch (JSONException e) {
            m.c(e);
            jSONObject2 = null;
        }
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            return null;
        }
        return jSONObject2.toString();
    }

    public String getPortNum(String str, String str2, String str3) {
        String strOptString;
        if (this.mCommonInfo == null) {
            return null;
        }
        try {
            strOptString = new JSONObject(this.mCommonInfo.getJSONObject(str.equals("rtmp") ? "rtmp_ports" : "http_ports").optString(str2)).optString(str3);
        } catch (JSONException e) {
            m.c(e);
            strOptString = null;
        }
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    public String getQueryItems() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject != null && jSONObject.has("query")) {
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject2 = this.mCommonInfo.getJSONObject("query");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject2.getString(next);
                    String strEncode = URLEncoder.encode(next, "UTF-8");
                    String strEncode2 = URLEncoder.encode(string, "UTF-8");
                    sb.append("&");
                    sb.append(strEncode);
                    sb.append("=");
                    sb.append(strEncode2);
                }
                return sb.toString();
            } catch (UnsupportedEncodingException | JSONException e) {
                m.c(e);
            }
        }
        return null;
    }

    public String getRuleIds() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("rule_ids")) {
            return null;
        }
        return this.mCommonInfo.optString("rule_ids");
    }

    public String getSDKParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params");
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public boolean getSREnabled(String str, String str2, int i) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params"));
            long jOptLong = jSONObject.optLong("vbitrate");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("NNSR"));
            int iOptInt = i == 1 ? jSONObject2.optInt("Enabled") : 0;
            long jOptLong2 = jSONObject2.optLong("VBitrateLowerBoundInKbps");
            this.mSRShorterSideUpperBound = jSONObject2.optInt("ShorterSideUpperBound");
            this.mSRLongerSideUpperBound = jSONObject2.optInt("LongerSideUpperBound");
            int iOptInt2 = jSONObject2.optInt("FrameRateUpperBound");
            this.mSRFrameRateUpperBound = iOptInt2;
            return iOptInt == 1 && jOptLong >= jOptLong2 * 1000 && this.mSRShorterSideUpperBound > 0 && this.mSRLongerSideUpperBound > 0 && iOptInt2 > 0;
        } catch (JSONException e) {
            m.c(e);
            return false;
        }
    }

    public int getSRLongerSideUpperBound() {
        return this.mSRLongerSideUpperBound;
    }

    public int getSRShorterSideUpperBound() {
        return this.mSRShorterSideUpperBound;
    }

    public String getSessionID() {
        JSONObject jSONObject = this.mCommonInfo;
        if (jSONObject == null || !jSONObject.has("session_id")) {
            return null;
        }
        return this.mCommonInfo.optString("session_id");
    }

    public JSONObject getSharpenParams(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("ASF"));
            this.mSharpenLongerSideUpperBound = jSONObject.optInt("LongerSideUpperBound");
            this.mSharpenLongerSideLowerBound = jSONObject.optInt("LongerSideLowerBound");
            this.mSharpenShorterSideUpperBound = jSONObject.optInt("ShorterSideUpperBound");
            this.mSharpenShorterSideLowerBound = jSONObject.optInt("ShorterSideLowerBound");
            return jSONObject;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public String getStreamUrlForResolution(String str, String str2, String str3) {
        JSONObject jSONObject;
        String strOptString;
        String queryItems;
        String strOptString2 = null;
        if (!TextUtils.isEmpty(str) && str.equals("auto")) {
            if (TextUtils.isEmpty(this.mDefaultResolution)) {
                return null;
            }
            return getMPDForFormat(str2, str3, this.mIp, this.mHost);
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(this.mStreamInfo.optString(str));
            if (jSONObject2.has(str3)) {
                jSONObject = new JSONObject(jSONObject2.optString(str3));
                try {
                    JSONObject jSONObject3 = new JSONObject(jSONObject.optString("sdk_params"));
                    strOptString = jSONObject3.has("SuggestFormat") ? jSONObject3.optString("SuggestFormat") : null;
                } catch (JSONException e) {
                    e = e;
                    m.c(e);
                }
            } else {
                strOptString = null;
                jSONObject = null;
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        boolean zEquals = LiveConfigKey.AVPH.equals(str2);
        String str4 = LiveConfigKey.FLV;
        if (zEquals) {
            str2 = LiveConfigKey.FLV;
        }
        if (strOptString == null || strOptString.equals("") || strOptString.equals(LiveConfigKey.AVPH)) {
            strOptString = str2;
        }
        if ((this.mFlag & 1) <= 0 || !strOptString.equals(LiveConfigKey.CMAF)) {
            str2 = strOptString;
        }
        if (this.mRtcFallback == 1 || (this.mFlag & 2) > 0) {
            str2 = LiveConfigKey.FLV;
        }
        if (jSONObject != null) {
            if (str2 == null || !str2.equals(LiveConfigKey.AVPH)) {
                str4 = str2;
            }
            strOptString2 = jSONObject.optString(str4);
        }
        if (strOptString2 == null || (queryItems = getQueryItems()) == null || queryItems.equals("")) {
            return strOptString2;
        }
        int iIndexOf = strOptString2.indexOf("?");
        if (iIndexOf == -1) {
            queryItems = "?" + queryItems.substring(1);
        } else if (iIndexOf == strOptString2.length() - 1) {
            queryItems = queryItems.substring(1);
        }
        return strOptString2 + queryItems;
    }

    public String getSuggestFormat(String str, String str2) {
        String strOptString;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            strOptString = new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestFormat");
        } catch (JSONException e) {
            m.c(e);
            strOptString = null;
        }
        if (strOptString == null || strOptString.isEmpty()) {
            return null;
        }
        return strOptString;
    }

    public String getSuggestProtocol(String str, String str2) {
        String str3;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("SuggestProtocol");
            str3 = LiveConfigKey.TCP;
        } catch (JSONException e) {
            m.c(e);
            str3 = null;
        }
        if (str3 == null || str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public String getVCodec(String str, String str2) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return null;
        }
        try {
            return new JSONObject(this.mStreamInfo.getJSONObject(str).getJSONObject(str2).optString("sdk_params")).optString("VCodec");
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public boolean isABRListMatch() {
        return this.mIsABRListMatch;
    }

    public boolean isCodecSame(String str) {
        JSONObject jSONObject = this.mStreamInfo;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return false;
        }
        int i = this.mIsCodecSame;
        if (i >= 0) {
            return i == 1;
        }
        this.mIsCodecSame = 1;
        Iterator<String> itKeys = this.mStreamInfo.keys();
        String str2 = null;
        String vCodec = null;
        while (itKeys.hasNext()) {
            vCodec = getVCodec(itKeys.next(), str);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(vCodec) && !vCodec.equals(str2)) {
                this.mIsCodecSame = 0;
                break;
            }
            if (!TextUtils.isEmpty(vCodec)) {
                str2 = vCodec;
            }
        }
        if (TextUtils.isEmpty(vCodec) && TextUtils.isEmpty(str2)) {
            this.mIsCodecSame = 0;
        }
        return this.mIsCodecSame == 1;
    }

    public boolean isEnableAdaptive(String str) {
        JSONArray jSONArrayOptJSONArray;
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (!isSupport(str)) {
            return false;
        }
        try {
            JSONObject abrInfo = getAbrInfo();
            if (abrInfo != null && abrInfo.has(GoodsSpecificationPreviewActivity.z) && (jSONArrayOptJSONArray = abrInfo.optJSONArray(GoodsSpecificationPreviewActivity.z)) != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String string = jSONArrayOptJSONArray.getString(i);
                    if (string != null && string.equals(str) && (!string.equals("origin") || this.mEnableOriginResolution)) {
                        return true;
                    }
                }
            }
        } catch (JSONException e) {
            m.c(e);
        }
        return false;
    }

    public boolean isSupport(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.mStreamInfo;
        if (jSONObject2 == null) {
            return false;
        }
        try {
            jSONObject = jSONObject2.getJSONObject(str);
        } catch (JSONException e) {
            m.c(e);
            jSONObject = null;
        }
        return jSONObject != null;
    }

    public boolean isSupportSR(int i, int i2, float f) {
        return Math.max(i, i2) <= this.mSRLongerSideUpperBound && Math.min(i, i2) <= this.mSRShorterSideUpperBound && f <= ((float) this.mSRFrameRateUpperBound) && i < i2;
    }

    public boolean isSupportSharpen(int i, int i2) {
        int iMax = Math.max(i, i2);
        int iMin = Math.min(i, i2);
        return iMax >= this.mSharpenLongerSideLowerBound && iMax <= this.mSharpenLongerSideUpperBound && iMin >= this.mSharpenShorterSideLowerBound && iMin <= this.mSharpenShorterSideUpperBound;
    }

    public void setDefaultResolution(String str) {
        if (isNeedUseDefaultResolution(str)) {
            str = this.mDefaultResolution;
        }
        if (isSupport(str)) {
            this.mDefaultResolution = str;
        }
    }

    public void setEnableOriginResolution(boolean z) {
        this.mEnableOriginResolution = z;
    }

    public boolean setFlag(int i) {
        this.mFlag = i | this.mFlag;
        return true;
    }

    public void setRequestParams(String str) {
        this.mRequestParams = str;
    }

    public void setRequestParamsWithDNSIp(String str, String str2, String str3) {
        this.mRequestParams = str;
        this.mIp = str2;
        this.mHost = str3;
    }

    public void setRtcFallback(int i) {
        this.mRtcFallback = i;
    }

    public void setTransportProtocol(String str, String str2) {
        this.mTransportProtocol = str;
        this.mPortNum = str2;
    }
}
