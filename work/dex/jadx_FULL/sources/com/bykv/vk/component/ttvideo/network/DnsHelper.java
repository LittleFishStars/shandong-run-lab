package com.bykv.vk.component.ttvideo.network;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alipay.sdk.m.n.c;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class DnsHelper {
    private static final String TAG = "DnsHelper";
    private static final int UPDATE_PEROID = 300000;
    private static volatile long mServerIPTime;
    private volatile OnParseCompletionListener mCompletionListener;
    private Context mContext;
    private final ExecutorService mExecutor;
    private Future mFuture;
    private final INetworkClient mNetworkClient;
    public volatile String mServerIP;
    private volatile boolean mIsForceHttp = false;
    private String mHttpDNSServerHost = null;
    private volatile boolean mIsTTNetHttp = false;
    private int mExpiredTime = 600000;

    public interface OnParseCompletionListener {
        void onParseComplete(String str, String str2, LiveError liveError, boolean z);
    }

    public static final class URLHostIndex {
        int authEnd;
        int hostEnd;
        int hostStart;

        public URLHostIndex(int i, int i2, int i3) {
            this.hostStart = i;
            this.hostEnd = i2;
            this.authEnd = i3;
        }
    }

    public DnsHelper(Context context, ExecutorService executorService, INetworkClient iNetworkClient) {
        this.mContext = context;
        this.mExecutor = executorService;
        this.mNetworkClient = iNetworkClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doHttpDns(final String str) {
        NetworkManager.doRequest(this.mNetworkClient, getURL(str), this.mHttpDNSServerHost, new NetworkManager.OnCompletionListener() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.2
            @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
            public void onCompletion(JSONObject jSONObject) {
                String string;
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    HashMap map = new HashMap();
                    map.put(c.f, str);
                    DnsHelper.this.notifyParseComplete(true, str, null, new LiveError(LiveError.EMPTY, "http dns response ip empty", map), true);
                    return;
                }
                try {
                    string = jSONArrayOptJSONArray.getString(0);
                } catch (Exception unused) {
                    string = null;
                }
                DnsHelper.this.notifyParseComplete(true, str, string, null, true);
            }

            @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
            public void onError(LiveError liveError) {
                DnsHelper.this.notifyParseComplete(true, str, null, liveError, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doLocalDns(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null) {
                notifyParseComplete(false, str, null, new LiveError(LiveError.DNS_PARSE_ERROR, "", null), true);
                return;
            }
            String hostAddress = byName.getHostAddress();
            if (byName instanceof Inet6Address) {
                hostAddress = String.format("[%s]", hostAddress);
            }
            notifyParseComplete(false, str, hostAddress, null, true);
        } catch (UnknownHostException e) {
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_REASON, "Unknown host name");
            map.put(c.f, str);
            map.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
            notifyParseComplete(false, str, null, new LiveError(LiveError.DNS_PARSE_ERROR, "Unknown Host", map), true);
        }
    }

    private String getURL(String str) {
        return String.format("https://%s/q?host=%s", this.mHttpDNSServerHost, str);
    }

    private static URLHostIndex getURLHostIndex(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int iIndexOf = str.indexOf("://") + 3;
        int length = str.length();
        int i = iIndexOf;
        int i2 = -1;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (cCharAt == '#' || cCharAt == '/') {
                break;
            }
            if (cCharAt == ':') {
                i2 = iIndexOf;
            } else {
                if (cCharAt == '?') {
                    break;
                }
                if (cCharAt == '@') {
                    i = iIndexOf + 1;
                }
            }
            iIndexOf++;
        }
        if (i2 == -1) {
            i2 = iIndexOf;
        }
        return new URLHostIndex(i, i2, iIndexOf);
    }

    public static String getUrlHost(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        URLHostIndex uRLHostIndex = getURLHostIndex(str);
        return str.substring(uRLHostIndex.hostStart, uRLHostIndex.hostEnd);
    }

    public static String hostToIPUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        URLHostIndex uRLHostIndex = getURLHostIndex(str);
        boolean zStartsWith = str.startsWith("http");
        String str3 = str.substring(0, uRLHostIndex.hostStart) + str2;
        int i = uRLHostIndex.hostEnd;
        if (uRLHostIndex.authEnd != -1) {
            str3 = str3 + str.substring(uRLHostIndex.hostEnd, uRLHostIndex.authEnd);
            i = uRLHostIndex.authEnd;
        }
        if (!zStartsWith) {
            str3 = str3 + WVNativeCallbackUtil.SEPERATER + getUrlHost(str);
        }
        return str3 + str.substring(i);
    }

    public static boolean isIP(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || "".equals(str)) {
            return false;
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParseComplete(boolean z, String str, String str2, LiveError liveError, boolean z2) {
        OnParseCompletionListener onParseCompletionListener;
        if (this.mIsForceHttp != z || (onParseCompletionListener = this.mCompletionListener) == null) {
            return;
        }
        if (z2 && str2 != null) {
            IPCache.IpInfo ipInfo = new IPCache.IpInfo();
            ipInfo.iptime = System.currentTimeMillis();
            ipInfo.ipaddr = str2;
            ipInfo.needUpdate = false;
            IPCache.getInstance().put(str, ipInfo);
        }
        onParseCompletionListener.onParseComplete(str, str2, liveError, z2);
    }

    public void cancel() {
        this.mCompletionListener = null;
        Future future = this.mFuture;
        if (future == null || future.isDone()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public void configure(boolean z, String str) {
        this.mIsForceHttp = (!z || this.mNetworkClient == null || TextUtils.isEmpty(str) || str.equals("null")) ? false : true;
        this.mHttpDNSServerHost = str;
        m.c(TAG, this.mIsForceHttp + this.mHttpDNSServerHost);
    }

    public String getDNSServerIP() {
        updateDNSServerIP();
        return this.mServerIP;
    }

    public void parseDns(final String str, OnParseCompletionListener onParseCompletionListener) {
        if (TextUtils.isEmpty(str) || onParseCompletionListener == null) {
            return;
        }
        if (this.mExecutor == null) {
            throw new IllegalStateException("mExecutor should not be null");
        }
        final boolean z = this.mIsForceHttp;
        cancel();
        this.mCompletionListener = onParseCompletionListener;
        NetworkInfo networkInfo = NetUtils.getNetworkInfo(this.mContext);
        int type = (networkInfo == null || !networkInfo.isAvailable()) ? -1 : networkInfo.getType();
        if (type == -1 || type != IPCache.getInstance().getCurNetType()) {
            IPCache.getInstance().clear();
            IPCache.getInstance().setCurNetType(type);
        }
        IPCache.IpInfo ipInfo = IPCache.getInstance().get(str);
        if (ipInfo != null && System.currentTimeMillis() - ipInfo.iptime <= this.mExpiredTime && !ipInfo.needUpdate) {
            notifyParseComplete(this.mIsForceHttp, str, ipInfo.ipaddr, null, false);
        } else if (this.mExecutor.isShutdown()) {
            notifyParseComplete(false, str, null, null, false);
        } else {
            this.mFuture = this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        DnsHelper.this.doHttpDns(str);
                    } else {
                        DnsHelper.this.doLocalDns(str);
                    }
                }
            });
        }
    }

    public void updateDNSServerIP() {
        if (SystemClock.elapsedRealtime() - mServerIPTime >= 300000 && !this.mExecutor.isShutdown()) {
            this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.network.DnsHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                        if (byName != null) {
                            DnsHelper.this.mServerIP = byName.getHostAddress();
                            long unused = DnsHelper.mServerIPTime = SystemClock.elapsedRealtime();
                            String str = DnsHelper.this.mServerIP;
                        }
                    } catch (UnknownHostException unused2) {
                    }
                }
            });
        }
    }
}
