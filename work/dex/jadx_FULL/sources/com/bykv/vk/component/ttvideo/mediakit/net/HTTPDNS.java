package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i, Handler handler) {
        super(str, aVMDLNetClient, handler);
        this.mHttpDNSType = i;
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1) {
            sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i == 3) {
            sb.append("https://" + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i2 = this.mHttpDNSType;
        if (i2 == 2 || i2 == 1) {
            sb.append("&source=vod");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        String.format("****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname);
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId);
        if (error != null) {
            String str = error.errStr;
            aVMDLDNSInfo2.mErrorStr = str;
            String.format("handle response receive err:%s", str);
        } else if (jSONObject == null || jSONObject.length() == 0) {
            int i = this.mHttpDNSType;
            new Error(i, this.mHostname, this.mId, String.format("HTTP dns empty, type:%d", Integer.valueOf(i)));
            String.format("json null err", new Object[0]);
        } else {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                String.format("handle response exception:%s", th.toString());
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo != null) {
                String.format("****parse suc for host:%s iplist:%s", this.mHostname, aVMDLDNSInfo.mIpList);
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
            String.format("info null err", new Object[0]);
        }
        String.format("****parse failed for host:%s", this.mHostname);
        notifyError(aVMDLDNSInfo2);
    }

    private AVMDLDNSInfo parserResult(JSONObject jSONObject) {
        long jCurrentTimeMillis;
        String string;
        int i = this.mHttpDNSType;
        String str = "";
        int iOptInt = 60;
        if (i == 2 || i == 1) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            iOptInt = jSONObject.has(RemoteMessageConst.TTL) ? jSONObject.optInt(RemoteMessageConst.TTL) : 60;
            String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(iOptInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
            int i2 = AVMDLDNSParser.mGlobalForceExpiredTime;
            if (i2 > 0) {
                iOptInt = i2;
            }
            int i3 = iOptInt;
            jCurrentTimeMillis = System.currentTimeMillis() + ((long) (iOptInt * 1000));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return null;
            }
            string = null;
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                try {
                    string = jSONArrayOptJSONArray.getString(i4);
                } catch (Exception e) {
                    m.c(e);
                    string = null;
                }
                if (!TextUtils.isEmpty(string)) {
                    str = TextUtils.isEmpty(str) ? str + string : str + "," + string;
                }
            }
            iOptInt = i3;
        } else {
            jCurrentTimeMillis = 0;
            string = null;
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                    if (jSONObject2.has("type") && jSONObject2.getInt("type") == 1) {
                        if (jSONObject2.has("TTL")) {
                            iOptInt = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has("data")) {
                            string = jSONObject2.optString("data");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            str = TextUtils.isEmpty(str) ? str + string : str + "," + string;
                        }
                    }
                }
                String.format("receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(iOptInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime));
                int i6 = AVMDLDNSParser.mGlobalForceExpiredTime;
                if (i6 > 0) {
                    iOptInt = i6;
                }
                jCurrentTimeMillis = System.currentTimeMillis() + ((long) (iOptInt * 1000));
            } catch (Exception e2) {
                m.c(e2);
                return null;
            }
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str, jCurrentTimeMillis, this.mId);
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.BaseDNS
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
            this.mNetClient.startTask(str_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.1
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(str_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.HTTPDNS.2
                @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        }
    }
}
