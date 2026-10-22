package com.byazt.mp;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byakv.z.TTEncryptUtils;
import com.byazt.ds.x;
import com.byazt.nr.m;
import com.byazt.yv.da;
import com.byazt.yv.u;
import com.byazt.yv.uj;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2108, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f28796a;
    public static JSONObject c;
    public static volatile boolean i;
    public static volatile int x;
    public static final String[] uj = {"GET", "POST"};
    public static final String[] n = {"aid", AlibcCommonConstant.APP_VERSION, "tt_data"};
    public static final String[] tt = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] ve = {"tt_data", "device_platform"};
    public static Object sp = new Object();

    private static String c(String str) {
        if (TextUtils.isEmpty(str) || !com.byazt.gj.c.x()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : n) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(uj.c(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static boolean c(int i2) {
        return i2 >= 500 && i2 < 600;
    }

    private static void tt(Context context) {
        if (i || context == null) {
            return;
        }
        synchronized (sp) {
            try {
                SharedPreferences.Editor editorEdit = u.tt(context).edit();
                if (x > 2) {
                    x -= 2;
                } else {
                    x = 0;
                }
                editorEdit.putInt("app_log_encrypt_faild_count", x);
                editorEdit.apply();
                i = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static JSONObject ve(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        ve veVarC = c(1, str, null, uj.c(jSONObject.toString()));
        if (veVarC == null || veVarC.c() == null) {
            jSONObject2 = null;
        } else {
            try {
                jSONObject2 = new JSONObject(veVarC.c());
            } catch (JSONException e) {
                m.c(e);
                jSONObject2 = null;
            }
        }
        if (jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""))) {
            return jSONObject2.optJSONObject("data");
        }
        return null;
    }

    public static JSONObject tt(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (com.byazt.gj.c.x()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        ve veVarC = c(1, str, map, uj.c(jSONObject.toString()));
        if (veVarC == null || veVarC.c() == null) {
            jSONObject2 = null;
        } else {
            try {
                jSONObject2 = new JSONObject(veVarC.c());
            } catch (JSONException e) {
                m.c(e);
                jSONObject2 = null;
            }
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            return jSONObject2.optJSONObject("config");
        }
        return null;
    }

    public static String c(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    /* JADX WARN: Code duplicated, block: B:117:0x01d0 A[EXC_TOP_SPLITTER, PHI: r0 r12
      0x01d0: PHI (r0v3 java.io.BufferedReader) = (r0v2 java.io.BufferedReader), (r0v11 java.io.BufferedReader) binds: [B:87:0x0201, B:74:0x01ce] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r12v3 java.lang.String) = (r12v2 java.lang.String), (r12v12 java.lang.String) binds: [B:87:0x0201, B:74:0x01ce] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0208  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0208, please report this as an issue */
    public static ve c(int i2, String str, HashMap<String, String> map, byte[] bArr) {
        DataOutputStream dataOutputStream;
        String string;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream2;
        ve veVar = new ve(null, null);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i2 == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i2 == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                da.tt((Throwable) null);
            }
            httpURLConnection.setRequestMethod(uj[i2]);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    } else {
                        da.tt((Throwable) null);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream2 = null;
            } else {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    string = null;
                    bufferedReader = null;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (str != null) {
                try {
                    if (str.contains("device_register_only")) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (key != null) {
                                jSONObject.put(key, c(value));
                            }
                        }
                        veVar.c(jSONObject);
                    }
                } catch (Exception e) {
                    m.uj("csj_log", "error:" + e.getMessage());
                }
            }
            if (responseCode == 200) {
                if (httpURLConnection.getContentLength() < 10240) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    }
                    try {
                        StringBuilder sb = new StringBuilder(inputStream.available());
                        try {
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                                Throwable th2 = th;
                                dataOutputStream = dataOutputStream2;
                                th = th2;
                                try {
                                    com.byazt.tf.c.ve("__kite", "error:" + th.getMessage());
                                    da.tt(th);
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (da.tt) {
                                        da.c("http response: " + string, null);
                                    }
                                    veVar.c(string);
                                    return veVar;
                                } catch (Throwable th3) {
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                            throw th3;
                                        } catch (IOException unused4) {
                                            throw th3;
                                        }
                                    }
                                    throw th3;
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject(string);
                            jSONObject2.put("http_code", 200);
                            string = jSONObject2.toString();
                            if (com.byazt.tf.c.tt()) {
                                com.byazt.tf.c.c("__kite", "response:" + string + " X-Tt-Logid:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            Throwable th5 = th;
                            dataOutputStream = dataOutputStream2;
                            th = th5;
                            com.byazt.tf.c.ve("__kite", "error:" + th.getMessage());
                            da.tt(th);
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                        string = sb.toString();
                    } catch (Throwable th6) {
                        th = th6;
                        string = null;
                    }
                } else {
                    da.tt((Throwable) null);
                    string = null;
                    bufferedReader = null;
                }
            } else {
                if (com.byazt.tf.c.tt()) {
                    com.byazt.tf.c.c("__kite", "error code:" + responseCode + " id:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                }
                String string2 = new JSONObject().put("http_code", responseCode).toString();
                try {
                    m.c(new RuntimeException("HttpCode:" + responseCode));
                    string = string2;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    bufferedReader = null;
                    dataOutputStream = dataOutputStream2;
                    th = th7;
                    string = string2;
                    com.byazt.tf.c.ve("__kite", "error:" + th.getMessage());
                    da.tt(th);
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
            }
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Throwable th8) {
            th = th8;
            dataOutputStream = null;
            string = null;
            bufferedReader = null;
        }
        if (da.tt) {
            da.c("http response: " + string, null);
        }
        veVar.c(string);
        return veVar;
    }

    private static String c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            if (str == null) {
                str = "null";
            }
            if (i2 == 0) {
                sb.append(str);
            } else {
                sb.append(", ");
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static ve c(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (com.byazt.gj.c.x()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        return c(1, c(str), map, uj.c(jSONObject.toString()));
    }

    public static String c(Context context, String str, byte[] bArr, String str2, boolean z, boolean z2) {
        byte[] bArrC;
        try {
            try {
                HashMap map = new HashMap();
                if (z) {
                    try {
                        bArrC = c(bArr);
                        map.put("Content-Encoding", "gzip");
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    bArrC = c(context, bArr);
                    map.put("log-encode-type", "gzip");
                    str = str + "&tt_data=a";
                    if (z2) {
                        str = str + "&config_retry=b";
                    }
                    map.remove("Content-Encoding");
                    map.put("Content-Type", "application/octet-stream;tt-data=a");
                }
                if (!TextUtils.isEmpty(str2)) {
                    map.put("Content-Type", str2);
                }
                ve veVarC = c(1, str, map, bArrC);
                if (veVarC != null) {
                    return veVarC.c();
                }
                return null;
            } catch (RuntimeException e) {
                com.byazt.tf.c.ve("__kite", e.getMessage());
                return "";
            }
        } catch (Exception e2) {
            com.byazt.tf.c.ve("__kite", e2.getMessage());
        }
        com.byazt.tf.c.ve("__kite", e2.getMessage());
        return "";
    }

    public static byte[] c(byte[] bArr) throws Exception {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] c(Context context, byte[] bArr) throws Exception {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (context != null) {
                c(context);
                if (x >= 3) {
                    return null;
                }
                byte[] bArrC = TTEncryptUtils.c(byteArray, byteArray.length);
                tt(context);
                return bArrC;
            }
            return TTEncryptUtils.c(byteArray, byteArray.length);
        } catch (Throwable th) {
            try {
                com.byazt.tf.c.ve("__kite", "gzip " + th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void c(Context context) {
        if (f28796a || context == null) {
            return;
        }
        synchronized (sp) {
            try {
                SharedPreferences sharedPreferencesTt = u.tt(context);
                x = sharedPreferencesTt.getInt("app_log_encrypt_faild_count", 0);
                SharedPreferences.Editor editorEdit = sharedPreferencesTt.edit();
                editorEdit.putInt("app_log_encrypt_faild_count", x + 1);
                editorEdit.apply();
                f28796a = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static int c(String[] strArr, byte[] bArr, x xVar) {
        JSONObject jSONObject;
        int iOptInt;
        HashMap map = new HashMap(2);
        if (com.byazt.gj.c.x()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strC = null;
        for (String str : strArr) {
            ve veVarC = c(1, str, map, bArr);
            strC = veVarC != null ? veVarC.c() : null;
            if (!TextUtils.isEmpty(strC)) {
                break;
            }
        }
        try {
            if (TextUtils.isEmpty(strC)) {
                jSONObject = null;
                iOptInt = 0;
            } else {
                jSONObject = new JSONObject(strC);
                try {
                    iOptInt = jSONObject.optInt("http_code");
                    if (iOptInt == 200) {
                        if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                            iOptInt = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                        } else {
                            iOptInt = Integer.valueOf("102").intValue();
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    da.tt(e);
                    iOptInt = 0;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (iOptInt == 200) {
            try {
                long jOptLong = jSONObject.optLong("server_time");
                if (jOptLong > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("server_time", jOptLong);
                    jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                    c = jSONObject2;
                }
            } catch (Exception e3) {
                da.tt(e3);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("blacklist");
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(com.alipay.sdk.m.c0.c.c);
                int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
                HashSet hashSet = new HashSet(length);
                for (int i2 = 0; i2 < length; i2++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i2, null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        hashSet.add(strOptString);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("v3");
                int length2 = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
                HashSet hashSet2 = new HashSet(length2);
                for (int i3 = 0; i3 < length2; i3++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i3, null);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        hashSet2.add(strOptString2);
                    }
                }
            }
        }
        return iOptInt;
    }
}
