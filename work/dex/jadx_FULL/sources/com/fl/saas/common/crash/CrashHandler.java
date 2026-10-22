package com.fl.saas.common.crash;

import android.content.Context;
import android.os.Process;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.fl.saas.BuildConfig;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String FILE_NAME = "crash";
    public static final String FILE_NAME_SUFFIX = ".txt";
    private static volatile CrashHandler sInstance;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;
    private boolean isInit = false;
    private boolean isUpload = false;
    private boolean isRemoveLog = false;

    private CrashHandler() {
    }

    private void dumpExceptionToSDCard(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.toString().contains(BuildConfig.LIBRARY_PACKAGE_NAME)) {
                File file = new File(getPath(this.mContext));
                if (!file.exists()) {
                    file.mkdirs();
                }
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(file.getPath() + File.separator + "crash" + getCurrentTimeBySecond() + FILE_NAME_SUFFIX))));
                printWriter.println(jSONObject.toString());
                printWriter.close();
                LogcatUtil.i("save crash logs");
            }
        } catch (Exception e) {
            LogcatUtil.e("dump crash info failed: " + e.getMessage());
        }
    }

    public static CrashHandler getInstance() {
        if (sInstance == null) {
            synchronized (CrashHandler.class) {
                sInstance = new CrashHandler();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadCrashLog$0() {
        File[] fileArrListFiles;
        File file = new File(getPath(this.mContext));
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    StringBuilder sb = new StringBuilder();
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                    if (sb.length() > 0) {
                        requestUploadCrash(sb, file2);
                    }
                    fileInputStream.close();
                } catch (Exception e) {
                    LogcatUtil.e("request upload crash failed: " + e.getMessage());
                }
            }
        }
    }

    private void requestUploadCrash(StringBuilder sb, final File file) throws JSONException {
        JSONObject jSONObjectStrToJson = strToJson(sb.toString());
        if (jSONObjectStrToJson != null) {
            String strOptString = jSONObjectStrToJson.optString("crashTime");
            String strOptString2 = jSONObjectStrToJson.optString("crashMsg");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("crash_time", strOptString);
            jSONObject.put("crash_msg", strOptString2);
            jSONObject.put("bundle", DeviceUtil.getMyPackageName());
            jSONObject.put(AlibcCommonConstant.APP_VERSION, DeviceUtil.getVersionName() + LoginConstants.UNDER_LINE + DeviceUtil.getVersionCode());
            jSONObject.put("sdk_version", "2.9.0");
            jSONObject.put("app_id", DeviceUtil.appId);
            jSONObject.put("device_info", DeviceUtil.getDeviceInfo());
            AdHttpUtils.getInstance().doPost(CommConstant.API.UPLOAD_CRASH_URL, AesUtils.encrypt(jSONObject.toString()), new HttpCallbackStringListener() { // from class: com.fl.saas.common.crash.CrashHandler.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    File file2 = file;
                    if (file2 != null) {
                        file2.delete();
                    }
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    File file2 = file;
                    if (file2 != null) {
                        file2.delete();
                    }
                }
            });
        }
    }

    private JSONObject strToJson(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject translateJsonStr(Throwable th) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String currentTimeBySecond = getCurrentTimeBySecond();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            byteArrayOutputStream.close();
            String string = byteArrayOutputStream.toString();
            jSONObject.put("crashTime", currentTimeBySecond);
            jSONObject.putOpt("crashMsg", string);
            return jSONObject;
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            throw th2;
        }
    }

    public String getCurrentTimeBySecond() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public String getPath(Context context) {
        return context.getCacheDir().getPath() + "/ydsaas/crash/log/";
    }

    public void init(Context context) {
        if (this.isInit || context == null) {
            return;
        }
        this.mContext = context;
        this.mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.isInit = true;
    }

    public void removeCrashLog(Context context) {
        File[] fileArrListFiles;
        if (context == null || this.isRemoveLog) {
            return;
        }
        this.isRemoveLog = true;
        try {
            File file = new File(getPath(context));
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            dumpExceptionToSDCard(translateJsonStr(th));
        } catch (Exception e) {
            e.printStackTrace();
        }
        th.printStackTrace();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultCrashHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    public void uploadCrashLog() {
        if (this.isUpload) {
            return;
        }
        this.isUpload = true;
        try {
            ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.ww1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45701a.lambda$uploadCrashLog$0();
                }
            });
        } catch (Throwable th) {
            LogcatUtil.e(th.getMessage());
        }
    }
}
