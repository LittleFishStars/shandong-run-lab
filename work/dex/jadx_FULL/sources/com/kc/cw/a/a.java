package com.kc.cw.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.d.b.d;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.d.b.h;
import com.kc.cw.ad.d.b.i;
import com.kc.cw.ad.internal.q;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f38640a;
    private Thread.UncaughtExceptionHandler b;
    private Context c;

    private a() {
    }

    public static a a() {
        if (f38640a == null) {
            f38640a = new a();
        }
        return f38640a;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0076 A[Catch: Exception -> 0x0072, TryCatch #9 {Exception -> 0x0072, blocks: (B:34:0x006e, B:38:0x0076, B:40:0x007b), top: B:66:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:40:0x007b A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #9 {Exception -> 0x0072, blocks: (B:34:0x006e, B:38:0x0076, B:40:0x007b), top: B:66:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a9 A[Catch: Exception -> 0x00a5, TryCatch #6 {Exception -> 0x00a5, blocks: (B:50:0x00a1, B:54:0x00a9, B:56:0x00ae), top: B:62:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae A[Catch: Exception -> 0x00a5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00a5, blocks: (B:50:0x00a1, B:54:0x00a9, B:56:0x00ae), top: B:62:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static String a(File file) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        Exception e;
        InputStreamReader inputStreamReader2;
        Throwable th;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        FileInputStream fileInputStream2 = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader2 = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                sb2.append(line);
                                sb2.append("\r\n");
                            } else {
                                try {
                                    break;
                                } catch (Exception e2) {
                                    e = e2;
                                    sb = new StringBuilder();
                                    sb.append("Catch An Exception: ");
                                    sb.append(e.getMessage());
                                    f.c("OctopusAd", sb.toString());
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader2 = bufferedReader;
                            try {
                                f.c("OctopusAd", "Catch An Exception: " + e.getMessage());
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        if (inputStreamReader2 != null) {
                                            inputStreamReader2.close();
                                        }
                                        if (bufferedReader2 != null) {
                                            bufferedReader2.close();
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        sb = new StringBuilder();
                                        sb.append("Catch An Exception: ");
                                        sb.append(e.getMessage());
                                        f.c("OctopusAd", sb.toString());
                                    }
                                } else {
                                    if (inputStreamReader2 != null) {
                                        inputStreamReader2.close();
                                    }
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                fileInputStream2 = fileInputStream;
                                Throwable th3 = th;
                                inputStreamReader = inputStreamReader2;
                                th = th3;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    } catch (Exception e5) {
                                        f.c("OctopusAd", "Catch An Exception: " + e5.getMessage());
                                        throw th;
                                    }
                                } else {
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream2 = fileInputStream;
                            Throwable th5 = th;
                            inputStreamReader = inputStreamReader2;
                            th = th5;
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } else {
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            }
                            throw th;
                        }
                    }
                    fileInputStream.close();
                    inputStreamReader2.close();
                    bufferedReader.close();
                } catch (Exception e6) {
                    e = e6;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = bufferedReader2;
                    fileInputStream2 = fileInputStream;
                    Throwable th7 = th;
                    inputStreamReader = inputStreamReader2;
                    th = th7;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } else {
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                e = e;
                inputStreamReader2 = null;
                f.c("OctopusAd", "Catch An Exception: " + e.getMessage());
                if (fileInputStream != null) {
                    fileInputStream.close();
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } else {
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                }
                return sb2.toString();
            } catch (Throwable th8) {
                th = th8;
                inputStreamReader2 = null;
                bufferedReader = null;
            }
        } catch (Exception e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th9) {
            th = th9;
            inputStreamReader = null;
            bufferedReader = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } else {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            throw th;
        }
        return sb2.toString();
    }

    private void a(String str) {
        String str2;
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                Log.e("CrashHandler", "sdcard unmounted,skip dump exception");
                return;
            }
            Context context = this.c;
            if (context == null) {
                return;
            }
            File fileA = h.a(context);
            f.a("OctopusAd", "CrashHandler storagePath == " + fileA);
            if (fileA != null) {
                String str3 = fileA.getPath() + "/Octopus/log/";
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str4 = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS").format(new Date(System.currentTimeMillis()));
                File file2 = new File(str3 + "crash_" + str4 + ".trace");
                file2.createNewFile();
                FileWriter fileWriter = new FileWriter(file2, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str4);
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
        } catch (Exception e) {
            e = e;
            str2 = "An Exception Caught";
            f.a("OctopusAd", str2, e);
        } catch (Throwable th) {
            e = th;
            str2 = "A Throwable Caught";
            f.a("OctopusAd", str2, e);
        }
    }

    private void a(String str, boolean z) {
        StringBuilder sb;
        try {
            if (this.c == null) {
                this.c = q.a().l();
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("appId", q.a().j());
            jSONObject.put(ALPParamConstant.PACKAGENAME, this.c.getPackageName());
            jSONObject.put("versionName", i.e(this.c));
            jSONObject.put("versionCode", i.g(this.c) + "");
            jSONObject.put("sdkVersion", "2.6.1.8");
            jSONObject.put("sdkTag", "OctopusAd");
            jSONObject2.put(DeviceIdType.OAID, SSAd.getOaid(this.c));
            jSONObject2.put("osVersion", Build.VERSION.RELEASE + LoginConstants.UNDER_LINE + Build.VERSION.SDK_INT);
            jSONObject2.put("vendor", Build.MANUFACTURER);
            jSONObject2.put(ze1.k, Build.MODEL);
            jSONObject2.put("cpu", Build.CPU_ABI);
            jSONObject.put("device", jSONObject2);
            jSONObject.put("crashType", z ? "native" : "java");
            jSONObject.put("crashMessage", str);
            String strN = q.a().n();
            if (z) {
                sb = new StringBuilder();
                sb.append(strN);
                sb.append("/sdk/soCrashReport");
            } else {
                sb = new StringBuilder();
                sb.append(strN);
                sb.append("/sdk/crashReport");
            }
            d.a(sb.toString(), jSONObject.toString().getBytes());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void a(Throwable th) {
        if (th == null) {
            return;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        do {
            th.printStackTrace(printWriter);
            th = th.getCause();
        } while (th != null);
        printWriter.close();
        b(stringWriter.toString(), false);
    }

    private void b(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new Thread(new Runnable(this, str, z) { // from class: com.kc.cw.a.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f38641a;
            final boolean b;
            final a c;

            {
                this.c = this;
                this.f38641a = str;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                this.c.c(this.f38641a, this.b);
                Looper.loop();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z) {
        if (str.contains("com.kc.cw.ad")) {
            a(str, z);
            if (z) {
                return;
            }
            a(str);
        }
    }

    public void a(Context context) {
        this.c = context.getApplicationContext();
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void b() {
        try {
            if (this.c == null) {
                this.c = q.a().l();
            }
            File filesDir = this.c.getFilesDir();
            if (filesDir != null) {
                File[] fileArrListFiles = new File(filesDir.getPath() + "/ssad-crash/").listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        if (file.exists()) {
                            b(a(file), true);
                            file.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            f.c("OctopusAd", "Catch An Exception: " + e.getMessage());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            a(th);
            Thread.sleep(1000L);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
