package cj.mobile.wm.okhttp.model;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpHeaders implements Serializable {
    public static String acceptLanguage = null;
    public static final long serialVersionUID = 8458647755751403873L;
    public static String userAgent;
    public ConcurrentHashMap<String, String> headersMap;
    public static final String TAG = dexc.dexa("XN`IuuqIfbefst");
    public static final String FORMAT_HTTP_DATA = dexc.dexa("FFF-!ee!NNN!z!II;nn;tt!(HNU(");
    public static final String HEAD_KEY_RESPONSE_CODE = dexc.dexa("SftqpotfDpef");
    public static final String HEAD_KEY_RESPONSE_MESSAGE = dexc.dexa("SftqpotfNfttbhf");
    public static final String HEAD_KEY_ACCEPT = dexc.dexa("Bddfqu");
    public static final String HEAD_KEY_ACCEPT_ENCODING = dexc.dexa("Bddfqu.Fodpejoh");
    public static final String HEAD_VALUE_ACCEPT_ENCODING = dexc.dexa("h{jq-!efgmbuf");
    public static final String HEAD_KEY_ACCEPT_LANGUAGE = dexc.dexa("Bddfqu.Mbohvbhf");
    public static final String HEAD_KEY_CONTENT_TYPE = dexc.dexa("Dpoufou.Uzqf");
    public static final String HEAD_KEY_CONTENT_LENGTH = dexc.dexa("Dpoufou.Mfohui");
    public static final String HEAD_KEY_CONTENT_ENCODING = dexc.dexa("Dpoufou.Fodpejoh");
    public static final String HEAD_KEY_CONTENT_DISPOSITION = dexc.dexa("Dpoufou.Ejtqptjujpo");
    public static final String HEAD_KEY_CONTENT_RANGE = dexc.dexa("Dpoufou.Sbohf");
    public static final String HEAD_KEY_RANGE = dexc.dexa("Sbohf");
    public static final String HEAD_KEY_CACHE_CONTROL = dexc.dexa("Dbdif.Dpouspm");
    public static final String HEAD_KEY_CONNECTION = dexc.dexa("Dpoofdujpo");
    public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = dexc.dexa("lffq.bmjwf");
    public static final String HEAD_VALUE_CONNECTION_CLOSE = dexc.dexa("dmptf");
    public static final String HEAD_KEY_DATE = dexc.dexa("Ebuf");
    public static final String HEAD_KEY_EXPIRES = dexc.dexa("Fyqjsft");
    public static final String HEAD_KEY_E_TAG = dexc.dexa("FUbh");
    public static final String HEAD_KEY_PRAGMA = dexc.dexa("Qsbhnb");
    public static final String HEAD_KEY_IF_MODIFIED_SINCE = dexc.dexa("Jg.Npejgjfe.Tjodf");
    public static final String HEAD_KEY_IF_NONE_MATCH = dexc.dexa("Jg.Opof.Nbudi");
    public static final String HEAD_KEY_LAST_MODIFIED = dexc.dexa("Mbtu.Npejgjfe");
    public static final String HEAD_KEY_LOCATION = dexc.dexa("Mpdbujpo");
    public static final String HEAD_KEY_USER_AGENT = dexc.dexa("Vtfs.Bhfou");
    public static final String HEAD_KEY_X_USER_AGENT = dexc.dexa("Y.Vtfs.Bhfou");
    public static final String HEAD_KEY_X_REQUESTED_WITH = dexc.dexa("Y.Sfrvftufe.Xjui");
    public static final String HEAD_KEY_COOKIE = dexc.dexa("Dppljf");
    public static final String HEAD_KEY_COOKIE2 = dexc.dexa("Dppljf3");
    public static final String HEAD_KEY_SET_COOKIE = dexc.dexa("Tfu.Dppljf");
    public static final String HEAD_KEY_SET_COOKIE2 = dexc.dexa("Tfu.Dppljf3");
    public static final String HEAD_VALUE_CONTENT_TYPE = dexc.dexa("bqqmjdbujpo0pdufu.tusfbn");
    public static final String HEAD_KEY_REFERER = dexc.dexa("Sfgfsfs");
    public static final String HEAD_KEY_USER_APP_TOKEN = dexc.dexa("Vtfs.BqqUplfo");
    public static final String HEAD_KEY_SDK_VERSION = dexc.dexa("Vtfs.Wfstjpo");
    public static final String HEAD_KEY_PLUGIN_VERSION = dexc.dexa("Vtfs.KbsWfstjpo");
    public static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone(dexc.dexa("HNU"));

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
            sb.append(dexc.dexa("<r>1/9"));
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
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) OkHttp.getInstance().getContext().getApplicationContext().getSystemService(dexc.dexa("bdujwjuz"))).getRunningAppProcesses()) {
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
        String str2 = dexc.dexa("証ꚥ獈毛蛅ifbefs.?") + str;
        String str3 = TAG;
        Log.w(str3, str2);
        if (this.headersMap == null || TextUtils.isEmpty(str) || !this.headersMap.containsKey(str)) {
            return "";
        }
        String strRemove = this.headersMap.remove(str);
        Log.w(str3, dexc.dexa("証ꚥ輔矝sftvmu.?") + strRemove);
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
        return dexc.dexa("IuuqIfbefst|ifbefstNbq>") + this.headersMap + '}';
    }
}
