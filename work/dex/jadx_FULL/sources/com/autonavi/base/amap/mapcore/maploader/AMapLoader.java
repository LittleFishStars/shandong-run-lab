package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.amap.api.col.p0003l.db;
import com.amap.api.col.p0003l.fo;
import com.amap.api.col.p0003l.hn;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.a7b;
import com.zj.adlib.axa;
import com.zj.adlib.bxa;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.r4b;
import com.zj.adlib.xwa;
import com.zj.adlib.zwa;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMapLoader implements hn.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private hn downloadManager;
    ADataRequestParam mDataRequestParam;
    private int mEngineID;
    GLMapEngine mGLMapEngine;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;
    private boolean mRequestCancel = false;

    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    public static class AMapGridDownloadRequest extends db {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        @Override // com.amap.api.col.p0003l.hs
        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        @Override // com.amap.api.col.p0003l.hs
        public String getIPV6URL() {
            return zwa.y(getURL());
        }

        @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
        public Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.hs
        public Map<String, String> getRequestHead() {
            r4b r4bVarT = zwa.t();
            String strE = r4bVarT != null ? r4bVarT.e() : null;
            String strJ = j4b.j(this.mContext);
            try {
                strJ = URLEncoder.encode(strJ, "UTF-8");
            } catch (Throwable unused) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", strE, "3dmap"));
            hashtable.put("x-INFO", l4b.b(this.mContext));
            hashtable.put(CachedContentIndex.a.e, strJ);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        @Override // com.amap.api.col.p0003l.hs
        public String getURL() {
            return this.sUrl;
        }

        @Override // com.amap.api.col.p0003l.hs
        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(int i, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mEngineID = 0;
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i;
        this.mGLMapEngine = gLMapEngine;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String strJ = j4b.j(this.mGLMapEngine.getContext());
        try {
            strJ = URLEncoder.encode(strJ, "UTF-8");
        } catch (Throwable unused) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(strJ);
        String strSortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String strA = l4b.a();
        stringBuffer.append("&ts=".concat(String.valueOf(strA)));
        stringBuffer.append("&scode=" + l4b.c(context, strA, strSortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        return !this.mGLMapEngine.isNetworkConnected() ? "无网络" : str;
    }

    private void onCancel() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.netCancel(this.mEngineID, aDataRequestParam.handler, -1);
    }

    private String sortReEncoderParams(String str) {
        String[] strArrSplit = str.split("&");
        Arrays.sort(strArrSplit);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : strArrSplit) {
            stringBuffer.append(strReEncoder(str2));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.length() > 1 ? (String) string.subSequence(0, string.length() - 1) : str;
    }

    private void staticNetworkPerformance() {
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null) {
            xwa.f(gLMapEngine.getContext(), this.mGLMapEngine.hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
        }
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            a7b.m(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            a7b.m(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
                this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
            } catch (Throwable th) {
                a7b.m(th, "AMapLoader", "doCancel");
            }
        }
    }

    public void doCancelAndNotify() {
        doCancel();
        onCancel();
    }

    public void doRequest() {
        if (fo.a(this.mGLMapEngine.getContext(), zwa.t()).f26036a == fo.c.SuccessCode && !this.mRequestCancel) {
            ADataRequestParam aDataRequestParam = this.mDataRequestParam;
            String str = aDataRequestParam.requestBaseUrl;
            String str2 = aDataRequestParam.requestUrl;
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            String requestParams = getRequestParams(str2.replaceAll(l.b, getEncodeRequestParams(l.b).toString()), str != null && str.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                stringBuffer.append("&csid=" + UUID.randomUUID().toString());
            } else {
                stringBuffer.append("csid=" + UUID.randomUUID().toString());
            }
            try {
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(30000);
                aMapGridDownloadRequest.setSoTimeout(30000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.requestMapDataTimestamp = System.currentTimeMillis();
                this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0L : aMapGridDownloadRequest.getEntityBytes().length;
                hn hnVar = new hn(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
                this.downloadManager = hnVar;
                hnVar.b(this);
                doCancel();
            } catch (Throwable th) {
                try {
                    onException(th);
                } finally {
                    doCancel();
                }
            }
        }
    }

    public String getRequestParams(String str, boolean z, int i) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.3l.hn.a
    public void onDownload(byte[] bArr, long j) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        if (bArr == null || (gLMapEngine = this.mGLMapEngine) == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
    }

    @Override // com.amap.api.col.3l.hn.a
    public void onException(Throwable th) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        ADataRequestParam aDataRequestParam2;
        int iIndexOf;
        int i = -1;
        try {
            String str = new String(th.getMessage().getBytes("UTF-8"), "UTF-8");
            if (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf(NETWORK_RESPONSE_CODE_STRING)) != -1) {
                i = Integer.parseInt(str.substring(iIndexOf + 8));
            }
            int i2 = i;
            GLMapEngine gLMapEngine2 = this.mGLMapEngine;
            if (gLMapEngine2 != null && (aDataRequestParam2 = this.mDataRequestParam) != null) {
                gLMapEngine2.netError(this.mEngineID, aDataRequestParam2.handler, -1, i2);
            }
            gLMapEngine = this.mGLMapEngine;
            if (gLMapEngine != null) {
                xwa.e(gLMapEngine.getContext(), this.mGLMapEngine.hashCode(), !this.mGLMapEngine.isNetworkConnected() ? 1 : 0, getNetworkFailedReason(th.getMessage()));
            }
        } catch (Throwable unused) {
            GLMapEngine gLMapEngine3 = this.mGLMapEngine;
            if (gLMapEngine3 != null && (aDataRequestParam = this.mDataRequestParam) != null) {
                gLMapEngine3.netError(this.mEngineID, aDataRequestParam.handler, -1, -1);
            }
            gLMapEngine = this.mGLMapEngine;
            if (gLMapEngine != null) {
            }
        }
        a7b.m(th, "AMapLoader", "download onException");
        bxa.l(axa.c, "map loader exception " + th.getMessage());
    }

    @Override // com.amap.api.col.3l.hn.a
    public void onFinish() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    @Override // com.amap.api.col.3l.hn.a
    public void onStop() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.netStop(this.mEngineID, aDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
