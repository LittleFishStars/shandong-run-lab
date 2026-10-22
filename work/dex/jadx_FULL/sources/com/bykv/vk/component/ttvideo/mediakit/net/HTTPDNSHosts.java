package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.m.n.c;
import com.byazt.nr.m;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class HTTPDNSHosts {
    private static final String TAG = "BatchParseHTTPDNSHosts";
    private static String mTTDNSServer = "/q?host=";
    protected boolean mCancelled = false;
    protected Handler mHandler;
    public String[] mHostnames;
    private int mHttpDNSType;
    public String mId;
    protected AVMDLNetClient mNetClient;

    public HTTPDNSHosts(String[] strArr, AVMDLNetClient aVMDLNetClient, int i, Handler handler) throws Exception {
        this.mHttpDNSType = 2;
        this.mNetClient = null;
        if (i != 2) {
            throw new Exception("type is not own");
        }
        if (strArr == null || strArr.length == 0) {
            throw new Exception("host array is valid");
        }
        this.mHttpDNSType = i;
        this.mHostnames = strArr;
        this.mNetClient = aVMDLNetClient;
        if (aVMDLNetClient == null) {
            this.mNetClient = new AVMDLHTTPNetwork();
        }
        this.mHttpDNSType = i;
        this.mHandler = handler;
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.mHostnames;
            if (i >= strArr.length) {
                return sb.toString();
            }
            if (!TextUtils.isEmpty(strArr[i])) {
                if (i2 == 0) {
                    sb.append(this.mHostnames[i]);
                } else {
                    sb.append("," + this.mHostnames[i]);
                }
                i2++;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        String.format("****http dns id:%s type:%d", this.mId, Integer.valueOf(this.mHttpDNSType));
        if (error != null) {
            String.format("handle response receive err:%s", error.errStr);
            return;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            String.format("json null err", new Object[0]);
            return;
        }
        try {
            parseResult(jSONObject);
        } catch (Throwable th) {
            String.format("handle response exception:%s", th.toString());
        }
        String.format("****parse end", new Object[0]);
    }

    private void parseResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dns");
            for (int i = 0; i < jSONArray.length(); i++) {
                AVMDLDNSInfo aVMDLDNSInfo = parserResultForSingleHost(jSONArray.getJSONObject(i));
                if (aVMDLDNSInfo != null) {
                    IPCache.getInstance().put(aVMDLDNSInfo.mHost, aVMDLDNSInfo);
                }
            }
        } catch (Exception unused) {
        }
    }

    private AVMDLDNSInfo parserResultForSingleHost(JSONObject jSONObject) {
        String str;
        String str2;
        long j;
        String string;
        int i = this.mHttpDNSType;
        String str3 = "";
        if (i == 2 || i == 1) {
            if (jSONObject != null && jSONObject.length() != 0) {
                int iOptInt = jSONObject.has(RemoteMessageConst.TTL) ? jSONObject.optInt(RemoteMessageConst.TTL) : 60;
                String strOptString = jSONObject.has(c.f) ? jSONObject.optString(c.f) : null;
                long jCurrentTimeMillis = System.currentTimeMillis() + ((long) (iOptInt * 1000));
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        try {
                            string = jSONArrayOptJSONArray.getString(i2);
                        } catch (Exception e) {
                            m.c(e);
                            string = null;
                        }
                        if (!TextUtils.isEmpty(string)) {
                            str3 = TextUtils.isEmpty(str3) ? str3 + string : str3 + "," + string;
                        }
                    }
                    str = str3;
                    str2 = strOptString;
                    j = jCurrentTimeMillis;
                }
            }
            return null;
        }
        str = "";
        str2 = null;
        j = 0;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String.format("parse result host:%s ips:%s expiredT:%d", str2, str, Long.valueOf(j));
            return new AVMDLDNSInfo(this.mHttpDNSType, str2, str, j, this.mId);
        }
        return null;
    }

    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    public void start() {
        String str_getURL = _getURL();
        boolean z = false;
        for (Method method : this.mNetClient.getClass().getDeclaredMethods()) {
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                z = true;
                break;
            }
        }
        if (z) {
            this.mNetClient.startTask(str_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.1
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(str_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNSHosts.2
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        }
    }
}
