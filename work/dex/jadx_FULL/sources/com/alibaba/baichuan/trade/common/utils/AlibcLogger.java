package com.alibaba.baichuan.trade.common.utils;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.baichuan.log.TLog;
import com.alibaba.baichuan.log.TLogInitializer;
import com.alibaba.baichuan.log.TLogUtils;
import com.alibaba.baichuan.log.utils.Base64;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alipay.sdk.m.j0.a;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.heytap.mcssdk.constant.b;
import com.zj.adlib.u15;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f24570a;
    private static Handler b;

    static {
        if (f24570a == null) {
            HandlerThread handlerThread = new HandlerThread("TriverLogHandlerThread-" + Process.myPid());
            f24570a = handlerThread;
            handlerThread.start();
        }
        if (b == null) {
            b = new Handler(f24570a.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(String str, String str2) {
        String className;
        String methodName;
        int lineNumber = -1;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 2) {
                className = "";
                methodName = className;
            } else {
                className = stackTrace[2].getClassName();
                try {
                    methodName = stackTrace[2].getMethodName();
                    try {
                        lineNumber = stackTrace[2].getLineNumber();
                    } catch (Exception e) {
                        e = e;
                        w("AliBC_UltimateTrade[5.0.2.5]", Log.getStackTraceString(e));
                    }
                } catch (Exception e2) {
                    e = e2;
                    methodName = "";
                }
            }
        } catch (Exception e3) {
            e = e3;
            className = "";
            methodName = className;
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(" -> [");
        sb.append(className);
        sb.append(Consts.DOT);
        sb.append(methodName);
        sb.append(u15.f19942b);
        sb.append(lineNumber);
        sb.append("] \n");
        sb.append(String.format("%92s", " "));
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static /* synthetic */ void access$200(Context context, Set set, String str) {
        try {
            File file = new File(context.getCacheDir() + File.separator + AlibcCommonUtils.md5Digest("currentApp".getBytes("UTF-8")));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file2));
            objectOutputStream.writeObject(sb.toString());
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e("AliBC_UltimateTrade[5.0.2.5]", e.getMessage());
        }
    }

    private static List<String> b(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                    if (byteArrayOutputStream.size() > 512000) {
                        arrayList.add(Base64.encodeBytes(byteArrayOutputStream.toByteArray()));
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    }
                    return null;
                }
                arrayList.add(Base64.encodeBytes(byteArrayOutputStream.toByteArray()));
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                return arrayList;
            } catch (Exception unused2) {
                return null;
            }
        } catch (Exception unused3) {
            inputStream.close();
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception unused4) {
            }
            throw th;
        }
    }

    public static void d(final String str, final String str2) {
        runOnLogThread(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.2
            @Override // java.lang.Runnable
            public final void run() {
                TLog.logd("AliBC_UltimateTrade[5.0.2.5]", AlibcLogger.a(str, str2));
            }
        });
    }

    public static void e(final String str, final String str2) {
        runOnLogThread(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.4
            @Override // java.lang.Runnable
            public final void run() {
                TLog.loge("AliBC_UltimateTrade[5.0.2.5]", AlibcLogger.a(str, str2));
            }
        });
    }

    public static void errorLog(String str, String str2, String str3, String str4, Map<String, String> map) {
        final JSONObject jSONObjectA = a(str, str2, str3, str4, map, "error");
        Log.e("errorLog", jSONObjectA.toJSONString());
        runOnLogThread(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.6
            @Override // java.lang.Runnable
            public final void run() {
                TLog.loge("errorLog", jSONObjectA.toJSONString());
            }
        });
    }

    public static void flowLog(String str, String str2, String str3, String str4, Map<String, String> map) {
        final JSONObject jSONObjectA = a(str, str2, str3, str4, map, "normal");
        Log.d("flowLog", jSONObjectA.toJSONString());
        runOnLogThread(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.5
            @Override // java.lang.Runnable
            public final void run() {
                TLog.logd("flowLog", jSONObjectA.toJSONString());
            }
        });
    }

    public static void i(final String str, final String str2) {
        runOnLogThread(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.1
            @Override // java.lang.Runnable
            public final void run() {
                TLog.logi("AliBC_UltimateTrade[5.0.2.5]", AlibcLogger.a(str, str2));
            }
        });
    }

    public static void runOnLogThread(Runnable runnable) {
        Handler handler;
        if (f24570a == null || (handler = b) == null) {
            TLog.loge(TriverLogProxyImpl.TLOG_MODULE, "TLog线程未准备好");
        } else {
            handler.post(runnable);
        }
    }

    public static synchronized void saveLog(final String str, final String str2, final String str3, final String str4, final Map<String, String> map, final String str5) {
        ExecutorManager.getTaskExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.7
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    AlibcCommonUtils.SDK_INIT_INFO.add(AlibcLogger.a(str, str2, str3, str4, map, str5).toJSONString());
                    AlibcLogger.access$200(AlibcBaseTradeCommon.context, AlibcCommonUtils.SDK_INIT_INFO, "bc_log");
                } catch (Throwable th) {
                    AlibcLogger.e("AliBC_UltimateTrade[5.0.2.5]", "data parse exception: " + th.getMessage());
                }
            }
        });
    }

    public static final void uploadLogFile(String str, String str2, int i) {
        String[] days;
        List<String> filePath;
        if (TextUtils.isEmpty(str) || (filePath = TLogUtils.getFilePath(TLogInitializer.getInstance().getNameprefix(), 0, (days = TLogUtils.getDays(Integer.valueOf(i))))) == null || filePath.isEmpty()) {
            return;
        }
        for (String str3 : filePath) {
            try {
                List<String> listA = a(str3);
                if (listA != null) {
                    String string = UUID.randomUUID().toString();
                    int size = listA.size();
                    int i2 = 0;
                    while (i2 < size) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("__topic__", TLogInitializer.getInstance().getNameprefix());
                        jSONObject.put("__source__", AlibcBaseTradeCommon.getUtdid());
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("content", (Object) listA.get(i2));
                        i2++;
                        jSONObject2.put("index", (Object) String.valueOf(i2));
                        jSONObject2.put("total", (Object) String.valueOf(size));
                        jSONObject2.put("ds", (Object) a(str3, days));
                        jSONObject2.put("uuid", (Object) string);
                        jSONArray.add(jSONObject2);
                        jSONObject.put("__logs__", (Object) jSONArray);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setConnectTimeout(a.f25451a);
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setReadTimeout(a.f25451a);
                        byte[] bytes = jSONObject.toJSONString().getBytes();
                        httpURLConnection.setRequestProperty("x-log-bodyrawsize", String.valueOf(bytes.length));
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.getOutputStream().write(bytes);
                        if (httpURLConnection.getResponseCode() != 200) {
                            JSONObject object = JSON.parseObject(a(httpURLConnection.getErrorStream()));
                            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_SDK_LOG_UPLOAD, object.getString("errorCode"), object.getString(SendToNativeCallback.KEY_MESSAGE), object);
                            return;
                        }
                    }
                }
                AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_SDK_LOG_UPLOAD, "", "", new JSONObject());
            } catch (Throwable th) {
                e("AliBC_UltimateTrade[5.0.2.5]", Log.getStackTraceString(th));
            }
        }
    }

    public static void w(final String str, final String str2) {
        runOnLogThread(new Runnable() { // from class: com.alibaba.baichuan.trade.common.utils.AlibcLogger.3
            @Override // java.lang.Runnable
            public final void run() {
                TLog.logw("AliBC_UltimateTrade[5.0.2.5]", AlibcLogger.a(str, str2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject a(String str, String str2, String str3, String str4, Map<String, String> map, String str5) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("group", (Object) str);
        jSONObject.put(b.k, (Object) str2);
        jSONObject.put("stage", (Object) str3);
        jSONObject.put(AliyunLogCommon.LogLevel.INFO, (Object) str4);
        jSONObject.put("status", (Object) str5);
        jSONObject.put(TLogInitializer.DEFAULT_DIR, (Object) new JSONObject(new HashMap(map)));
        return jSONObject;
    }

    private static String a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return strArr[0];
    }

    private static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            return byteArrayOutputStream.toString("utf-8");
        } catch (Exception unused) {
            return byteArrayOutputStream.toString();
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
        }
    }

    private static List<String> a(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        List<String> listB = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    listB = b(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    e("AliBC_UltimateTrade[5.0.2.5]", Log.getStackTraceString(e));
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) fileInputStream2);
            throw th;
        }
        a((Closeable) fileInputStream);
        return listB;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e("close stream exception", Log.getStackTraceString(e));
            }
        }
    }
}
