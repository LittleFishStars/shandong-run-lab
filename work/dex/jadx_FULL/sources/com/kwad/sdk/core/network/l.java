package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.by;
import com.zj.adlib.u15;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    public static String HTTP_CODE_ERROR_MSG = "网络错误";
    private static final String TAG = "Networking";

    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.MD();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.ey(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.Mf() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !aq.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.Rs();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(@NonNull R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.aSW, cVar.aSX);
        com.kwad.sdk.core.network.idc.a.Mo().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener(r, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.Mo().Mq()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.Mo().eN(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.MC();
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.Mw();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.Mj().X(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.eX(str);
        }
    }

    public void afterParseData(T t) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableCrashReport() {
        return true;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void fetchImpl() {
        R r = null;
        c cVarDoPost = null;
        try {
            this.mMonitorRecorder.MA();
            R rCreateRequest = createRequest();
            try {
                notifyOnStartRequest(rCreateRequest);
                this.mMonitorRecorder.eT(rCreateRequest.getUrl()).eU(rCreateRequest.getUrl());
                setMonitorRequestId(rCreateRequest);
                if (aq.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                    try {
                        String url = rCreateRequest.getUrl();
                        AdHttpProxy adHttpProxyEG = com.kwad.sdk.h.EG();
                        if (adHttpProxyEG instanceof com.kwad.sdk.core.network.c.b) {
                            this.mMonitorRecorder.eW("ok_http").Mz();
                        } else {
                            this.mMonitorRecorder.eW("http").Mz();
                        }
                        cVarDoPost = isPostByJson() ? adHttpProxyEG.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBody()) : adHttpProxyEG.doPost(url, rCreateRequest.getHeader(), rCreateRequest.getBodyMap());
                        com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVarDoPost);
                    } catch (Exception e) {
                        notifyOnErrorListener(rCreateRequest, e.aTj.errorCode, by.y(e));
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        this.mMonitorRecorder.eV("requestError:" + e.getMessage());
                    }
                    this.mMonitorRecorder.Mx().My().eA(com.kwad.sdk.ip.direct.a.getType());
                    try {
                        onResponse(rCreateRequest, cVarDoPost);
                    } catch (Exception e2) {
                        notifyOnErrorListener(rCreateRequest, e.aTj.errorCode, by.y(e2));
                        this.mMonitorRecorder.eV("onResponseError:" + e2.getMessage());
                        com.kwad.sdk.core.d.c.w(TAG, "jky onResponseError: " + rCreateRequest.getUrl());
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
                    }
                } else {
                    e eVar = e.aTc;
                    notifyOnErrorListener(rCreateRequest, eVar.errorCode, eVar.msg);
                    this.mMonitorRecorder.ex(e.aTc.errorCode).eV(e.aTc.msg);
                }
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.report();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                r = rCreateRequest;
                try {
                    try {
                        this.mMonitorRecorder.eV("requestError:" + th.getMessage());
                    } catch (Exception unused2) {
                    }
                    notifyOnErrorListener(r, e.aTj.errorCode, by.y(th));
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    try {
                        if (enableMonitorReport()) {
                        }
                    } catch (Exception unused3) {
                    }
                } finally {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused4) {
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (cVar == null) {
            e eVar = e.aTc;
            notifyOnErrorListener(r, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.eV("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.ex(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.aSY) || !cVar.Mf()) {
            notifyOnErrorListener(r, cVar, HTTP_CODE_ERROR_MSG);
            this.mMonitorRecorder.eV("httpCodeError:" + cVar.code + u15.f19942b + cVar.aSY);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.d.c.w(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.aSY);
            BaseResultData data = parseData(cVar.aSY);
            afterParseData(data);
            String str = cVar.aSY;
            if (str != null) {
                this.mMonitorRecorder.aE(str.length()).MB().ez(data.result);
            }
            if (!data.isResultOk()) {
                this.mMonitorRecorder.eV("serverCodeError:" + data.result + u15.f19942b + data.errorMsg);
                if (data.notifyFailOnResultError()) {
                    notifyOnErrorListener(r, data.result, data.errorMsg);
                    return;
                }
            }
            if (data.isDataEmpty()) {
                notifyOnErrorListener(r, e.aTe.errorCode, !TextUtils.isEmpty(data.testErrorMsg) ? data.testErrorMsg : e.aTe.msg);
            } else {
                checkAndSetHasData(data);
                notifyOnSuccess(r, data);
            }
        } catch (Exception e) {
            e eVar2 = e.aTd;
            notifyOnErrorListener(r, eVar2.errorCode, eVar2.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            this.mMonitorRecorder.eV("parseDataError:" + e.getMessage());
        }
    }

    @NonNull
    public abstract T parseData(String str);

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((f) null, e.aTj.errorCode, by.y(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r, int i, String str) {
        try {
            h.Mg().b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.MC();
    }
}
