package com.beizi.fusion;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.beizi.fusion.model.ResponseInfo;
import com.zj.adlib.ze1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g6 implements Thread.UncaughtExceptionHandler {
    private static g6 c = new g6();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f27338a;
    private Context b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f27339a;

        public a(Throwable th) {
            this.f27339a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            g6.this.b(this.f27339a);
            Looper.loop();
        }
    }

    private g6() {
    }

    public static g6 a() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String string = stringWriter.toString();
        a(string);
        b(string);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            a(th);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f27338a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }

    public void a(Context context) {
        this.f27338a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.b = context.getApplicationContext();
    }

    private void a(String str) {
        String strA;
        String strA2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("appId", q1.h().b());
            jSONObject.put(ALPParamConstant.PACKAGENAME, this.b.getPackageName());
            jSONObject.put("versionName", so.l(this.b));
            jSONObject.put("versionCode", String.valueOf(so.k(this.b)));
            jSONObject.put("sdkVersion", "5.5.0.2");
            jSONObject2.put("osVersion", Build.VERSION.RELEASE + LoginConstants.UNDER_LINE + Build.VERSION.SDK_INT);
            jSONObject2.put("vendor", Build.MANUFACTURER);
            jSONObject2.put(ze1.k, Build.MODEL);
            jSONObject.put("device", jSONObject2);
            jSONObject.put("crashMessage", str);
            if (!TextUtils.isEmpty(ResponseInfo.getInstance(this.b).getCrashUrl()) && ResponseInfo.getInstance(this.b).getCrashUrl().startsWith("http")) {
                strA = ResponseInfo.getInstance(this.b).getCrashUrl();
            } else {
                strA = g3.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGsvY3Jhc2gvdjE=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3Nkay9jcmFzaC92MQ==");
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
            }
            if (TextUtils.isEmpty(strA) || (strA2 = m9.a(strA, jSONObject.toString().getBytes())) == null) {
                return;
            }
            jh.a("lance", "post:" + strA2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(String str) {
        try {
            Context context = this.b;
            if (context == null) {
                return;
            }
            File fileB = j4.b(context);
            jh.a("BeiZis", "CrashHandler storagePath == " + fileB);
            if (fileB != null) {
                String str2 = fileB.getPath() + "/Beizi/log/";
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str3 = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
                File file2 = new File(str2 + "crash_" + str3 + ".trace");
                file2.createNewFile();
                FileWriter fileWriter = new FileWriter(file2, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str3);
                bufferedWriter.write("\r\n");
                bufferedWriter.write("------------------crash----------------------");
                bufferedWriter.write("\r\n");
                bufferedWriter.write(str);
                bufferedWriter.write("\r\n");
                bufferedWriter.write("-------------------end-----------------------");
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        jh.a("lance", "writeLog ok");
    }

    private boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread(new a(th)).start();
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return true;
        }
    }
}
