package com.kc.dw.core.loader.concurrent;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.router.log.bean.CodeErrorNoMsg;
import com.kc.dw.core.router.log.bean.CodeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39266a;
    public SsdAdInfo b;
    public Map<String, Object> c;
    public com.kc.dw.core.loader.strategy.a d;
    public com.kc.dw.core.loader.a e;
    public com.kc.dw.core.loader.b f;
    public boolean g;
    public long h;
    public List<com.kc.dw.core.loader.loadbean.a> i;

    /* JADX INFO: renamed from: com.kc.dw.core.loader.concurrent.a$a, reason: collision with other inner class name */
    @Keep
    public class C1025a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39267a;

        public C1025a(a aVar) {
            this.f39267a = aVar;
        }

        @Override // com.kc.dw.core.loader.concurrent.b
        public void a(Object obj, int i, String str) {
            if (this.f39267a.e.getLoaderListener() != null) {
                this.f39267a.e.getLoaderListener().onAdFail(obj, new AdError(i, str), 0);
            }
        }

        @Override // com.kc.dw.core.loader.concurrent.b
        public void onLoadedError(int i, String str) {
            if (this.f39267a.e.getLoaderListener() != null) {
                LogUtil.e("ConCurrentManager", "___onAdError");
                this.f39267a.e.getLoaderListener().onLoadFail(new AdError(i, str));
            }
            com.kc.dw.core.service.logrecord.a.a(5, "f2", this.f39267a.f, new CodeErrorNoMsg().setData(2, i, str));
            com.kc.dw.core.service.logrecord.a.a(5, "f3", this.f39267a.f, new CodeMsg().setData(0, str));
        }

        @Override // com.kc.dw.core.loader.concurrent.b
        public void onLoadedSuccess(Object obj) {
            com.kc.dw.core.service.logrecord.a.a(5, "s2", this.f39267a.f);
            com.kc.dw.core.service.logrecord.a.a(5, "s3", this.f39267a.f);
            if (this.f39267a.e.getLoaderListener() != null) {
                this.f39267a.e.getLoaderListener().onLoadSuccess(obj);
            }
        }

        @Override // com.kc.dw.core.loader.concurrent.b
        public void onRenderSuccess(Object obj) {
            if (this.f39267a.e.getLoaderListener() != null) {
                this.f39267a.e.getLoaderListener().onRenderSuccess(obj);
            }
        }
    }

    public a(Context context, com.kc.dw.core.loader.a aVar, SsdAdInfo ssdAdInfo, Map<String, Object> map) {
        new Handler(Looper.getMainLooper());
        this.i = new ArrayList();
        this.f39266a = context;
        this.b = ssdAdInfo;
        this.c = map;
        this.e = aVar;
    }

    public final String a(SdkAdInfo sdkAdInfo, String str) {
        try {
            return TextUtils.replace(str, new String[]{"__ACCEPT_ID__", "__STRATEGY_DEALID__", "__ACCEPT_APPID__", "__ACCEPT_PID__", "__SDK__", "__GROUP_ID__", "__P__"}, new String[]{sdkAdInfo.getAccept_id() == null ? "" : sdkAdInfo.getAccept_id(), sdkAdInfo.getStrategy_dealid() == null ? "" : sdkAdInfo.getStrategy_dealid(), sdkAdInfo.getApp_id() == null ? "" : sdkAdInfo.getApp_id(), sdkAdInfo.getPid() == null ? "" : sdkAdInfo.getPid(), sdkAdInfo.getSdk() == null ? "" : sdkAdInfo.getSdk(), sdkAdInfo.getGroup_id() == null ? "" : sdkAdInfo.getGroup_id(), String.valueOf(sdkAdInfo.getPrice())}).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final void a() {
        long curAllTimes;
        LinkedHashMap<String, Long> linkedHashMap;
        String curReqId;
        if (this.f != null) {
            String[] responUrl = this.b.getResponUrl();
            if (responUrl != null && responUrl.length > 0) {
                LogUtil.d("ConCurrentManager", "send onAdLoaded");
                for (String str : responUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        com.kc.dw.ad.interstitial.c.a(this.f39266a, g0.a(g0.a(str, System.currentTimeMillis() - this.e.startLoadTime)));
                    }
                }
            }
            this.f.setLocalParams(this.c);
            this.f.setConCurrentLoadListener(new C1025a(this));
            this.f.loadAd();
            return;
        }
        if (this.e.getLoaderListener() != null) {
            LogUtil.e("ConCurrentManager", "___onAdError");
            this.e.getLoaderListener().onLoadFail(new AdError(com.kc.dw.core.exception.b.i.intValue(), "meishuAdDelegate is null"));
        }
        com.kc.dw.core.exception.b.i.intValue();
        try {
            SsdAdInfo ssdAdInfo = this.b;
            if (ssdAdInfo == null || ssdAdInfo.getAppendInfo() == null) {
                curAllTimes = 0;
                linkedHashMap = null;
                curReqId = null;
            } else {
                LinkedHashMap<String, Long> baseEventTimes = this.b.getAppendInfo().getBaseEventTimes();
                curAllTimes = this.b.getAppendInfo().getCurAllTimes();
                linkedHashMap = baseEventTimes;
                curReqId = this.b.getAppendInfo().getCurReqId();
            }
            com.kc.dw.core.service.logrecord.a.a(linkedHashMap, 5, "f3", null, this.e.getPosId(), this.e.getAdType(), curAllTimes, curReqId, new CodeMsg().setData(0, "msAdDelegate is null"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
