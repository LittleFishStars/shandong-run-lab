package com.kc.bw.okhttp.model;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HttpHeaders implements Serializable {
    public static String acceptLanguage = null;
    public static final long serialVersionUID = 8458647755751403873L;
    public static String userAgent;
    public ConcurrentHashMap<String, String> headersMap;
    public static final String TAG = dexg.dexa("XN`IuuqIfbefst");
    public static final String FORMAT_HTTP_DATA = dexg.dexa("FFF-!ee!NNN!z!II;nn;tt!(HNU(");
    public static final String HEAD_KEY_RESPONSE_CODE = dexg.dexa("SftqpotfDpef");
    public static final String HEAD_KEY_RESPONSE_MESSAGE = dexg.dexa("SftqpotfNfttbhf");
    public static final String HEAD_KEY_ACCEPT = dexg.dexa("Bddfqu");
    public static final String HEAD_KEY_ACCEPT_ENCODING = dexg.dexa("Bddfqu.Fodpejoh");
    public static final String HEAD_VALUE_ACCEPT_ENCODING = dexg.dexa("h{jq-!efgmbuf");
    public static final String HEAD_KEY_ACCEPT_LANGUAGE = dexg.dexa("Bddfqu.Mbohvbhf");
    public static final String HEAD_KEY_CONTENT_TYPE = dexg.dexa("Dpoufou.Uzqf");
    public static final String HEAD_KEY_CONTENT_LENGTH = dexg.dexa("Dpoufou.Mfohui");
    public static final String HEAD_KEY_CONTENT_ENCODING = dexg.dexa("Dpoufou.Fodpejoh");
    public static final String HEAD_KEY_CONTENT_DISPOSITION = dexg.dexa("Dpoufou.Ejtqptjujpo");
    public static final String HEAD_KEY_CONTENT_RANGE = dexg.dexa("Dpoufou.Sbohf");
    public static final String HEAD_KEY_RANGE = dexg.dexa("Sbohf");
    public static final String HEAD_KEY_CACHE_CONTROL = dexg.dexa("Dbdif.Dpouspm");
    public static final String HEAD_KEY_CONNECTION = dexg.dexa("Dpoofdujpo");
    public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = dexg.dexa("lffq.bmjwf");
    public static final String HEAD_VALUE_CONNECTION_CLOSE = dexg.dexa("dmptf");
    public static final String HEAD_KEY_DATE = dexg.dexa("Ebuf");
    public static final String HEAD_KEY_EXPIRES = dexg.dexa("Fyqjsft");
    public static final String HEAD_KEY_E_TAG = dexg.dexa("FUbh");
    public static final String HEAD_KEY_PRAGMA = dexg.dexa("Qsbhnb");
    public static final String HEAD_KEY_IF_MODIFIED_SINCE = dexg.dexa("Jg.Npejgjfe.Tjodf");
    public static final String HEAD_KEY_IF_NONE_MATCH = dexg.dexa("Jg.Opof.Nbudi");
    public static final String HEAD_KEY_LAST_MODIFIED = dexg.dexa("Mbtu.Npejgjfe");
    public static final String HEAD_KEY_LOCATION = dexg.dexa("Mpdbujpo");
    public static final String HEAD_KEY_USER_AGENT = dexg.dexa("Vtfs.Bhfou");
    public static final String HEAD_KEY_X_USER_AGENT = dexg.dexa("Y.Vtfs.Bhfou");
    public static final String HEAD_KEY_X_REQUESTED_WITH = dexg.dexa("Y.Sfrvftufe.Xjui");
    public static final String HEAD_KEY_COOKIE = dexg.dexa("Dppljf");
    public static final String HEAD_KEY_COOKIE2 = dexg.dexa("Dppljf3");
    public static final String HEAD_KEY_SET_COOKIE = dexg.dexa("Tfu.Dppljf");
    public static final String HEAD_KEY_SET_COOKIE2 = dexg.dexa("Tfu.Dppljf3");
    public static final String HEAD_VALUE_CONTENT_TYPE = dexg.dexa("bqqmjdbujpo0pdufu.tusfbn");
    public static final String HEAD_KEY_REFERER = dexg.dexa("Sfgfsfs");
    public static final String HEAD_KEY_USER_APP_TOKEN = dexg.dexa("Vtfs.BqqUplfo");
    public static final String HEAD_KEY_SDK_VERSION = dexg.dexa("Vtfs.Wfstjpo");
    public static final String HEAD_KEY_PLUGIN_VERSION = dexg.dexa("Vtfs.KbsWfstjpo");
    public static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone(dexg.dexa("HNU"));

    public HttpHeaders() {
        init();
    }

    public HttpHeaders(String str, String str2) {
        init();
        put(str, str2);
    }

    public static String formatMillisToGMT(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        simpleDateFormat.setTimeZone(GMT_TIME_ZONE);
        return simpleDateFormat.format(date);
    }

    public static String getAcceptLanguage() {
        if (!TextUtils.isEmpty(acceptLanguage)) {
            return acceptLanguage;
        }
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
            sb.append(',');
            sb.append(language);
            sb.append(dexg.dexa("<r>1/9"));
        }
        String string = sb.toString();
        acceptLanguage = string;
        return string;
    }

    public static String getCacheControl(String str, String str2) {
        if (str != null) {
            return str;
        }
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public static long getDate(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String getDate(long j) {
        return formatMillisToGMT(j);
    }

    public static long getExpiration(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return -1L;
        }
    }

    public static long getLastModified(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String getPackageName() {
        try {
            return OkHttp.getInstance().getContext().getApplicationContext().getPackageName();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getProcessName() {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) OkHttp.getInstance().getContext().getApplicationContext().getSystemService(dexg.dexa("bdujwjuz"))).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void init() {
        this.headersMap = new ConcurrentHashMap<>();
    }

    public static long parseGMTToMillis(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        simpleDateFormat.setTimeZone(GMT_TIME_ZONE);
        return simpleDateFormat.parse(str).getTime();
    }

    public static void setAcceptLanguage(String str) {
        acceptLanguage = str;
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }

    public void clear() {
        this.headersMap.clear();
    }

    public String get(String str) {
        return this.headersMap.get(str);
    }

    public Set<String> getNames() {
        return this.headersMap.keySet();
    }

    public boolean isEmpty() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.headersMap;
        return concurrentHashMap == null || concurrentHashMap.isEmpty();
    }

    public void put(HttpHeaders httpHeaders) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (httpHeaders == null || (concurrentHashMap = httpHeaders.headersMap) == null || concurrentHashMap.isEmpty()) {
            return;
        }
        this.headersMap.putAll(httpHeaders.headersMap);
    }

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.headersMap.put(str, str2);
    }

    public String remove(String str) {
        String str2 = dexg.dexa("証ꚥ獈毛蛅ifbefs.?") + str;
        String str3 = TAG;
        Log.w(str3, str2);
        if (this.headersMap == null || TextUtils.isEmpty(str) || !this.headersMap.containsKey(str)) {
            return "";
        }
        String strRemove = this.headersMap.remove(str);
        Log.w(str3, dexg.dexa("証ꚥ輔矝sftvmu.?") + strRemove);
        return strRemove;
    }

    public final String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.headersMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return dexg.dexa("IuuqIfbefst|ifbefstNbq>") + this.headersMap + '}';
    }
}
