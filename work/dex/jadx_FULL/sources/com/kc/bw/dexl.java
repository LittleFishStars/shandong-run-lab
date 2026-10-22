package com.kc.bw;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.common.utils.SharedPreferencesHelper;
import com.kc.bw.common.utils.ThreadUtils;
import com.kc.bw.common.utils.Utils;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.callback.FileCallback;
import com.kc.bw.okhttp.callback.StringCallback;
import com.kc.bw.okhttp.model.Response;
import com.kc.bw.okhttp.utils.AesUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class dexl {
    public static final String dexa = dexg.dexa("cmbdlmjtu");
    public static final int dexb = 4096;

    @Keep
    public class dexa extends FileCallback {
        public final Context dexa;
        public final String dexb;
        public final String dexc;
        public final long dexd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public dexa(String str, String str2, Context context, String str3, String str4, long j) {
            super(str, str2);
            this.dexa = context;
            this.dexb = str3;
            this.dexc = str4;
            this.dexd = j;
        }

        @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
        public void onError(Response<File> response) {
            String string = (response == null || response.getException() == null) ? "" : response.getException().toString();
            DebugLog.loadPlugin_e(dexg.dexa("qvmm!iusft!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("epxompbeQmvhjo!poFssps-") + string);
        }

        @Override // com.kc.bw.okhttp.callback.Callback
        public void onSuccess(final Response<File> response) {
            if (response != null && response.isSuccessful()) {
                if (!ThreadUtils.isUIThread(dexg.dexa("epxompbeQmvhjo.poTvddftt"))) {
                    dexl.dexa(this.dexa, response, this.dexb, this.dexc, this.dexd);
                    return;
                }
                final Context context = this.dexa;
                final String str = this.dexb;
                final String str2 = this.dexc;
                final long j = this.dexd;
                ThreadUtils.runOnThreadPool(new Runnable(context, response, str, str2, j) { // from class: com.kc.bw.dexl$dexa$$ExternalSyntheticLambda0
                    public final Context f$0;
                    public final Response f$1;
                    public final String f$2;
                    public final String f$3;
                    public final long f$4;

                    {
                        this.f$0 = context;
                        this.f$1 = response;
                        this.f$2 = str;
                        this.f$3 = str2;
                        this.f$4 = j;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        dexl.dexa(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
                return;
            }
            String string = response != null ? response.toString() : "";
            DebugLog.loadPlugin_e(dexg.dexa("qvmm!iusft!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("epxompbeQmvhjo!sftqpotf!gbjm-") + string);
        }
    }

    @Keep
    public class dexb extends StringCallback {
        public final Context dexa;
        public final String dexb;

        @Keep
        public class dexa implements Runnable {
            public final Response dexa;
            public final dexb dexb;

            public dexa(dexb dexbVar, Response response) {
                this.dexb = dexbVar;
                this.dexa = response;
            }

            @Override // java.lang.Runnable
            public void run() {
                dexb dexbVar = this.dexb;
                dexl.dexa(dexbVar.dexa, (Response<String>) this.dexa, dexbVar.dexb);
            }
        }

        public dexb(Context context, String str) {
            this.dexa = context;
            this.dexb = str;
        }

        @Override // com.kc.bw.okhttp.callback.AbsCallback, com.kc.bw.okhttp.callback.Callback
        public void onError(Response<String> response) {
            String string = (response == null || response.getException() == null) ? "" : response.getException().toString();
            DebugLog.loadPlugin_e(dexg.dexa("igsft!bqqmz!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("difdlQmvhjoWfstjpo!poFssps-") + string);
        }

        @Override // com.kc.bw.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            if (response != null && response.isSuccessful()) {
                if (ThreadUtils.isUIThread(dexg.dexa("difdlQmvhjoWfstjpo.poTvddftt"))) {
                    ThreadUtils.runOnThreadPool(new dexa(this, response));
                    return;
                } else {
                    dexl.dexa(this.dexa, response, this.dexb);
                    return;
                }
            }
            String string = response != null ? response.toString() : "";
            DebugLog.loadPlugin_e(dexg.dexa("igsft!bqqmz!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("difdlQmvhjoWfstjpo!sftqpotf!gbjm-") + string);
        }
    }

    @Keep
    public interface dexc {
        void dexa(boolean z);
    }

    @Keep
    public interface dexd {
        void onFailed(String str);

        void onSuccess(String str);
    }

    public static String dexa(Context context) {
        try {
            File file = new File(context.getFilesDir(), ConstantInfo.Config.CONFIG_DIR_PATH);
            if (file.exists() || file.mkdirs()) {
                return file.getAbsolutePath();
            }
            DebugLog.common_e(dexg.dexa("gbjmfe!up!dsfbuf!nvmujtubhf!tvcejsfdupsjft"));
            return "";
        } catch (Throwable th) {
            String str = dexg.dexa("hfuDpogjhGjmfQbui!gbjm!") + Log.getStackTraceString(th);
            DebugLog.common_w(str);
            ReportUtils.exReport(context, 999967, dexg.dexa("痈強鰼懚楲鵦"), str);
            return "";
        }
    }

    public static String dexa(String str, String str2) {
        try {
            String[] strArrSplit = str.split(dexg.dexa("]/"));
            String[] strArrSplit2 = str2.split(dexg.dexa("]/"));
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            int i = 0;
            while (i < iMax) {
                int i2 = i < strArrSplit.length ? Integer.parseInt(strArrSplit[i]) : 0;
                int i3 = i < strArrSplit2.length ? Integer.parseInt(strArrSplit2[i]) : 0;
                if (i2 > i3) {
                    return str;
                }
                if (i2 < i3) {
                    return str2;
                }
                i++;
            }
            return str;
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(dexg.dexa("hfuNbyWfstjpo!gbjm-") + Log.getStackTraceString(th));
            return str;
        }
    }

    public static void dexa(final Context context, final dexc dexcVar) {
        ThreadUtils.runOnThreadPool(new Runnable(context, dexcVar) { // from class: com.kc.bw.dexl$$ExternalSyntheticLambda0
            public final Context f$0;
            public final dexl.dexc f$1;

            {
                this.f$0 = context;
                this.f$1 = dexcVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                dexl.dexb(this.f$0, this.f$1);
            }
        });
    }

    public static void dexa(Context context, Response<String> response, String str) {
        try {
            String strBody = response.body();
            if (!TextUtils.isEmpty(strBody)) {
                JSONObject jSONObject = new JSONObject(strBody);
                int i = jSONObject.getInt(dexg.dexa("sfu"));
                DebugLog.loadPlugin(dexg.dexa("igsft!sftq!") + i);
                if (i == 0) {
                    String string = jSONObject.getString(dexg.dexa("wfstjpo"));
                    DebugLog.loadPlugin(dexg.dexa("igsft!sftq!") + string);
                    String string2 = jSONObject.getString(dexg.dexa("epxompbeVsm"));
                    long j = jSONObject.getLong(dexg.dexa("difdlTvn"));
                    if (!TextUtils.isEmpty(string)) {
                        if (dexa(context, string, str)) {
                            dexa(context, string2, string, j);
                        } else {
                            DebugLog.loadPlugin(dexg.dexa("igsft!sftq!op!ebub"));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(dexg.dexa("igsft!bqqmz!gbjm!") + th);
            ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("epDifdlQmvhjoWfstjpoSftqpotf!gbjm-") + Log.getStackTraceString(th));
        }
    }

    public static void dexa(Context context, Response<File> response, String str, String str2, long j) {
        try {
            File fileBody = response.body();
            DebugLog.loadPlugin(dexg.dexa("qvmm!iusft!epof!"));
            if (!dexa(context, fileBody.getAbsolutePath(), j)) {
                Utils.setFileWrite(fileBody, context);
                fileBody.delete();
                return;
            }
            File file = new File(str2, dexg.dexa("xnefw`8/8/25/21"));
            if (file.exists()) {
                DebugLog.loadPlugin(dexg.dexa("pwfsxsjuf!iusft"));
                Utils.setFileWrite(file, context);
                file.delete();
                Utils.setFileReadOnly(file, context);
            }
            fileBody.renameTo(file);
            Utils.setFileReadOnly(file, context);
            SharedPreferencesHelper.getInstance(context).savePreferencesString(dexg.dexa("nn`tq`l24"), str);
            dexe.dexa();
        } catch (Throwable th) {
            String str3 = dexg.dexa("gbjmfe!up!qspdftt!vqebuf!") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str3);
            ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), str3);
        }
    }

    public static void dexa(Context context, String str, dexd dexdVar) {
        BufferedReader bufferedReader;
        synchronized (dexl.class) {
            try {
                try {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(dexa(context) + File.separator + str));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    sb.append(line);
                                }
                            }
                            if (dexdVar != null) {
                                dexdVar.onSuccess(sb.toString());
                            }
                        } catch (Throwable unused) {
                            if (bufferedReader != null) {
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
    }

    public static void dexa(Context context, String str, String str2, long j) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DebugLog.loadPlugin(dexg.dexa("qvmm!iusft!"));
            String strDexc = dexc(context);
            OkHttp.get(str).execute(new dexa(strDexc, dexg.dexa("xnefwmpbe`8/8/25/21"), context, str2, strDexc, j));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(dexg.dexa("qvmm!iusft!gbjm!") + stackTraceString);
            ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("epxompbeQmvhjo!gbjm-") + stackTraceString);
        }
    }

    public static boolean dexa(Context context, String str, long j) {
        FileInputStream fileInputStream;
        CheckedInputStream checkedInputStream = null;
        try {
            DebugLog.loadPlugin(dexg.dexa("iusft!wfsjgz"));
            fileInputStream = new FileInputStream(str);
            try {
                CRC32 crc32 = new CRC32();
                CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream, crc32);
                try {
                    while (checkedInputStream2.read(new byte[4096]) != -1) {
                    }
                    if (crc32.getValue() == j) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        try {
                            checkedInputStream2.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    }
                    DebugLog.loadPlugin_e(dexg.dexa("iusft!wfsjgz!gbjm"));
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                } catch (Throwable th) {
                    th = th;
                    checkedInputStream = checkedInputStream2;
                    try {
                        String stackTraceString = Log.getStackTraceString(th);
                        DebugLog.loadPlugin_e(dexg.dexa("iusft!wfsjgz!gbjm") + stackTraceString);
                        ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("difdlQmvhjoDsdWbmvf!gbjm-") + stackTraceString);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (checkedInputStream == null) {
                            return false;
                        }
                        checkedInputStream2 = checkedInputStream;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (checkedInputStream != null) {
                            try {
                                checkedInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        try {
            return false;
        } catch (IOException unused7) {
            return false;
        }
    }

    public static boolean dexa(Context context, String str, String str2) {
        try {
            return !dexa(str, str2).equals(str2);
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(dexg.dexa("qspcfEfmub!gbjm") + th);
            ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("difdlJtOffeEpxompbeQmvhjo!gbjm-") + Log.getStackTraceString(th));
            return false;
        }
    }

    public static String dexb(Context context) {
        try {
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(context);
            String preferencesString = sharedPreferencesHelper.getPreferencesString(dexg.dexa("nn`tq`l23"));
            if (!TextUtils.isEmpty(preferencesString) && preferencesString.contains(dexg.dexa("ldcx"))) {
                preferencesString = preferencesString.replace(dexg.dexa("ldcx"), "");
            }
            if (TextUtils.isEmpty(preferencesString)) {
                DebugLog.loadPlugin(dexg.dexa("msft!wfstjpo!jowbmje!"));
                return "";
            }
            String preferencesString2 = sharedPreferencesHelper.getPreferencesString(dexg.dexa("nn`tq`l24"));
            if (!TextUtils.isEmpty(preferencesString2)) {
                return dexa(preferencesString, preferencesString2);
            }
            DebugLog.loadPlugin(dexg.dexa("igsft!wfstjpo!jowbmje!"));
            return preferencesString;
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(dexg.dexa("gfudi!dsft!wfstjpo!gbjm!") + Log.getStackTraceString(th));
            ReportUtils.exReport(context, 999967, dexg.dexa("痈強鰼懚楲鵦"), dexg.dexa("hfuDvssfouQmvhjoWfstjpo!gbjm-") + Log.getStackTraceString(th));
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0061 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0007, B:5:0x0016, B:16:0x0061, B:18:0x0072, B:6:0x002d, B:8:0x0033, B:9:0x0039, B:10:0x003e, B:12:0x004c, B:14:0x0058), top: B:23:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0072 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x0007, B:5:0x0016, B:16:0x0061, B:18:0x0072, B:6:0x002d, B:8:0x0033, B:9:0x0039, B:10:0x003e, B:12:0x004c, B:14:0x0058), top: B:23:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public static /* synthetic */ void dexb(Context context, dexc dexcVar) {
        String strDexa;
        boolean z;
        boolean zExportDexFile;
        try {
            String strDexb = dexb(context);
            if (!TextUtils.isEmpty(dexg.dexa("8/25/21"))) {
                if (TextUtils.isEmpty(strDexb)) {
                    strDexa = dexg.dexa("dsft!wfstjpo!jowbmje");
                } else if (dexa(dexg.dexa("8/25/21"), strDexb).equals(strDexb)) {
                    DebugLog.loadPlugin(dexg.dexa("tbnf!wfstjpo"));
                } else {
                    strDexa = dexg.dexa("ejggfsfou!wfstjpo");
                }
                DebugLog.loadPlugin(strDexa);
                z = true;
                zExportDexFile = z ? Utils.exportDexFile(context, dexc(context), dexg.dexa("xnefwdbm`8/8/25/21")) : true;
                if (dexcVar != null) {
                    dexcVar.dexa(zExportDexFile);
                }
            }
            DebugLog.loadPlugin_e(dexg.dexa("qsfsft!wfstjpo!jowbmje"));
            ReportUtils.exReport(context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), dexg.dexa("fyqpsuQmvhjo!gbjm-CvjmeDpogjh/TEL`QMVHJO`WFSTJPO!jt!ovmm"));
            z = false;
            if (z) {
            }
            if (dexcVar != null) {
                dexcVar.dexa(zExportDexFile);
            }
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(dexg.dexa("sft!gbjm!") + stackTraceString);
            ReportUtils.exReport(context, 200006, dexg.dexa("TEL扞樌捗楲鵦"), dexg.dexa("fyqpsuQmvhjo!gbjm-") + stackTraceString);
        }
    }

    public static void dexb(Context context, String str, String str2) {
        try {
            DebugLog.loadPlugin(dexg.dexa("igsft!bqqmz!"));
            String strDexb = dexb(context);
            if (TextUtils.isEmpty(strDexb)) {
                DebugLog.loadPlugin_e(dexg.dexa("dsft!wfstjpo!jowbmje"));
                ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("difdlQmvhjoWfstjpo!gbjm-dvssfouQmvhjoWfstjpo!jt!ovmm"));
                return;
            }
            OkHttp.get(Uri.parse(ConstantInfo.getRealNameUrl() + dexg.dexa("tel0hfuBqlJogp/bqj")).buildUpon().appendQueryParameter(dexg.dexa("telWfstjpo"), dexg.dexa("8/8/25/21")).appendQueryParameter(dexg.dexa("bqlWfstjpo"), strDexb).appendQueryParameter(dexg.dexa("uplfo"), str).appendQueryParameter(dexg.dexa("tjho"), AesUtil.md5Decode(str2 + str)).build().toString()).execute(new dexb(context, strDexb));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(dexg.dexa("igsft!bqqmz!gbjm!") + stackTraceString);
            ReportUtils.exReport(context, 200015, dexg.dexa("TEL扞樌捗琓強眵痱楲鵦"), dexg.dexa("difdlQmvhjoWfstjpo!gbjm-") + stackTraceString);
        }
    }

    public static String dexc(Context context) {
        try {
            File file = new File(context.getFilesDir(), ConstantInfo.Config.PATCH_DIR_PATH);
            if (file.exists() || file.mkdirs()) {
                return file.getAbsolutePath();
            }
            DebugLog.loadPlugin_e(dexg.dexa("gbjmfe!up!dsfbuf!nvmujtubhf!tvcejsfdupsjft\""));
            return "";
        } catch (Throwable th) {
            String str = dexg.dexa("hfuQmvhjoGjmfQbui!gbjm!") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str);
            ReportUtils.exReport(context, 999967, dexg.dexa("痈強鰼懚楲鵦"), str);
            return "";
        }
    }

    public static void dexc(Context context, String str, String str2) {
        BufferedWriter bufferedWriter;
        synchronized (dexl.class) {
            try {
                String strDexa = dexa(context);
                File file = new File(strDexa);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedWriter = new BufferedWriter(new FileWriter(strDexa + File.separator + str));
                try {
                    try {
                        bufferedWriter.write(str2, 0, str2.length());
                    } catch (Throwable th) {
                        th = th;
                        try {
                            try {
                                DebugLog.common_w(dexg.dexa("dpogjh!xsjuf!gbjmfe!") + th);
                                if (bufferedWriter != null) {
                                }
                            } catch (Throwable th2) {
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    bufferedWriter.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = null;
            }
        }
    }
}
