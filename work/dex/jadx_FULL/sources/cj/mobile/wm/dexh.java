package cj.mobile.wm;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.wm.common.utils.ConstantInfo;
import cj.mobile.wm.common.utils.DebugLog;
import cj.mobile.wm.common.utils.ReportUtils;
import cj.mobile.wm.common.utils.SharedPreferencesHelper;
import cj.mobile.wm.common.utils.Utils;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.callback.FileCallback;
import cj.mobile.wm.okhttp.callback.StringCallback;
import cj.mobile.wm.okhttp.model.Response;
import cj.mobile.wm.okhttp.utils.AesUtil;
import com.zj.adlib.c49;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dexh {
    public static final String dexa = cj.mobile.wm.dexc.dexa("cmbdlmjtu");
    public static final int dexb = 4096;

    public class dexa extends FileCallback {
        public final /* synthetic */ Context dexa;
        public final /* synthetic */ String dexb;
        public final /* synthetic */ String dexc;
        public final /* synthetic */ long dexd;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public dexa(String str, String str2, Context context, String str3, String str4, long j) {
            super(str, str2);
            this.dexa = context;
            this.dexb = str3;
            this.dexc = str4;
            this.dexd = j;
        }

        @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
        public void onError(Response<File> response) {
            String string = (response == null || response.getException() == null) ? "" : response.getException().toString();
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!epxompbe!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("epxompbeQmvhjo!poFssps-") + string);
        }

        @Override // cj.mobile.wm.okhttp.callback.Callback
        public void onSuccess(Response<File> response) {
            if (response != null && response.isSuccessful()) {
                dexh.dexa(this.dexa, response, this.dexb, this.dexc, this.dexd);
                return;
            }
            String string = response != null ? response.toString() : "";
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!epxompbe!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("epxompbeQmvhjo!sftqpotf!gbjm-") + string);
        }
    }

    public class dexb extends StringCallback {
        public final /* synthetic */ Context dexa;
        public final /* synthetic */ String dexb;

        public dexb(Context context, String str) {
            this.dexa = context;
            this.dexb = str;
        }

        @Override // cj.mobile.wm.okhttp.callback.AbsCallback, cj.mobile.wm.okhttp.callback.Callback
        public void onError(Response<String> response) {
            String string = (response == null || response.getException() == null) ? "" : response.getException().toString();
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!sftq!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("difdlQmvhjoWfstjpo!poFssps-") + string);
        }

        @Override // cj.mobile.wm.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            if (response != null && response.isSuccessful()) {
                dexh.dexa(this.dexa, response, this.dexb);
                return;
            }
            String string = response != null ? response.toString() : "";
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!sftq!gbjm!") + string);
            ReportUtils.exReport(this.dexa, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("difdlQmvhjoWfstjpo!sftqpotf!gbjm-") + string);
        }
    }

    public interface dexc {
        void dexa(boolean z);
    }

    public interface dexd {
        void onFailed(String str);

        void onSuccess(String str);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0072 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #0 {all -> 0x0084, blocks: (B:3:0x0015, B:5:0x0024, B:16:0x0072, B:7:0x003c, B:9:0x0042, B:11:0x004d, B:13:0x005b, B:14:0x0066), top: B:23:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0082  */
    public static boolean dexa(Context context) {
        boolean z;
        long elapsedRealTime = Utils.getElapsedRealTime();
        DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!fyq"));
        boolean zExportDexFile = false;
        try {
            String strDexc = dexc(context);
            if (!TextUtils.isEmpty(cj.mobile.wm.dexc.dexa("8/29/31"))) {
                if (TextUtils.isEmpty(strDexc)) {
                    DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("dqmh!wfstjpo!jowbmje"));
                } else if (dexa(cj.mobile.wm.dexc.dexa("8/29/31"), strDexc).equals(strDexc)) {
                    DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("tbnf!wfstjpo"));
                } else {
                    DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("ejggfsfou!wfstjpo"));
                }
                z = true;
                if (z) {
                    zExportDexFile = Utils.exportDexFile(context, dexd(context), cj.mobile.wm.dexc.dexa("xnefwdbm`8/:/29/31"));
                } else {
                    zExportDexFile = true;
                }
                DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!fyq!") + Utils.getCostTime(elapsedRealTime) + cj.mobile.wm.dexc.dexa(c49.f40900a) + zExportDexFile);
                return zExportDexFile;
            }
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qsfqmh!wfstjpo!jowbmje"));
            ReportUtils.exReport(context, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), cj.mobile.wm.dexc.dexa("fyqpsuQmvhjo!gbjm-CvjmeDpogjh/TEL`QMVHJO`WFSTJPO!jt!ovmm"));
            z = false;
            if (z) {
                zExportDexFile = Utils.exportDexFile(context, dexd(context), cj.mobile.wm.dexc.dexa("xnefwdbm`8/:/29/31"));
            } else {
                zExportDexFile = true;
            }
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!fyq!gbjm!") + stackTraceString);
            ReportUtils.exReport(context, 200006, cj.mobile.wm.dexc.dexa("TEL扞樌捗楲鵦"), cj.mobile.wm.dexc.dexa("fyqpsuQmvhjo!gbjm-") + stackTraceString);
        }
        DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!fyq!") + Utils.getCostTime(elapsedRealTime) + cj.mobile.wm.dexc.dexa(c49.f40900a) + zExportDexFile);
        return zExportDexFile;
    }

    public static void dexb(Context context, String str, String str2) {
        try {
            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!difdl!"));
            String strDexc = dexc(context);
            if (TextUtils.isEmpty(strDexc)) {
                DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("dqmh!wfstjpo!jowbmje"));
                ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("difdlQmvhjoWfstjpo!gbjm-dvssfouQmvhjoWfstjpo!jt!ovmm"));
                return;
            }
            OkHttp.get(Uri.parse(ConstantInfo.getRealNameUrl() + cj.mobile.wm.dexc.dexa("tel0hfuBqlJogp/bqj")).buildUpon().appendQueryParameter(cj.mobile.wm.dexc.dexa("telWfstjpo"), cj.mobile.wm.dexc.dexa("8/:/29/31")).appendQueryParameter(cj.mobile.wm.dexc.dexa("bqlWfstjpo"), strDexc).appendQueryParameter(cj.mobile.wm.dexc.dexa("uplfo"), str).appendQueryParameter(cj.mobile.wm.dexc.dexa("tjho"), AesUtil.md5Decode(str2 + str)).build().toString()).execute(new dexb(context, strDexc));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!sftq!gbjm!") + stackTraceString);
            ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("difdlQmvhjoWfstjpo!gbjm-") + stackTraceString);
        }
    }

    public static String dexc(Context context) {
        try {
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(context);
            String preferencesString = sharedPreferencesHelper.getPreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l23"));
            if (!TextUtils.isEmpty(preferencesString) && preferencesString.contains(cj.mobile.wm.dexc.dexa("mzxn"))) {
                preferencesString = preferencesString.replace(cj.mobile.wm.dexc.dexa("mzxn"), "");
            }
            if (TextUtils.isEmpty(preferencesString)) {
                DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("mqmh!wfstjpo!jowbmje!"));
                return "";
            }
            String preferencesString2 = sharedPreferencesHelper.getPreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l24"));
            if (!TextUtils.isEmpty(preferencesString2)) {
                return dexa(preferencesString, preferencesString2);
            }
            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("iqmh!wfstjpo!jowbmje!"));
            return preferencesString;
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("gfudi!dqmh!wfstjpo!gbjm!") + Log.getStackTraceString(th));
            ReportUtils.exReport(context, 999967, cj.mobile.wm.dexc.dexa("痈強鰼懚楲鵦"), cj.mobile.wm.dexc.dexa("hfuDvssfouQmvhjoWfstjpo!gbjm-") + Log.getStackTraceString(th));
            return "";
        }
    }

    public static String dexd(Context context) {
        try {
            File file = new File(context.getFilesDir(), ConstantInfo.Config.PATCH_DIR_PATH);
            if (file.exists() || file.mkdirs()) {
                return file.getAbsolutePath();
            }
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("gbjmfe!up!dsfbuf!nvmujtubhf!tvcejsfdupsjft\""));
            return "";
        } catch (Throwable th) {
            String str = cj.mobile.wm.dexc.dexa("hfuQmvhjoGjmfQbui!gbjm!") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str);
            ReportUtils.exReport(context, 999967, cj.mobile.wm.dexc.dexa("痈強鰼懚楲鵦"), str);
            return "";
        }
    }

    public static void dexc(Context context, String str, String str2) {
        BufferedWriter bufferedWriter;
        synchronized (dexh.class) {
            try {
                try {
                    String strDexb = dexb(context);
                    File file = new File(strDexb);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    bufferedWriter = new BufferedWriter(new FileWriter(strDexb + File.separator + str));
                    try {
                        bufferedWriter.write(str2, 0, str2.length());
                        bufferedWriter.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            DebugLog.common_w(cj.mobile.wm.dexc.dexa("dpogjh!xsjuf!gbjmfe!") + th);
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
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
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = null;
            }
        }
    }

    public static String dexb(Context context) {
        try {
            File file = new File(context.getFilesDir(), ConstantInfo.Config.CONFIG_DIR_PATH);
            if (!file.exists() && !file.mkdirs()) {
                DebugLog.common_e(cj.mobile.wm.dexc.dexa("gbjmfe!up!dsfbuf!nvmujtubhf!tvcejsfdupsjft"));
                return "";
            }
            return file.getAbsolutePath();
        } catch (Throwable th) {
            String str = cj.mobile.wm.dexc.dexa("hfuDpogjhGjmfQbui!gbjm!") + Log.getStackTraceString(th);
            DebugLog.common_w(str);
            ReportUtils.exReport(context, 999967, cj.mobile.wm.dexc.dexa("痈強鰼懚楲鵦"), str);
            return "";
        }
    }

    public static void dexa(Context context, String str, String str2, long j) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!epxompbe!"));
            String strDexd = dexd(context);
            OkHttp.get(str).execute(new dexa(strDexd, cj.mobile.wm.dexc.dexa("xnefwmpbe`8/:/29/31"), context, str2, strDexd, j));
        } catch (Throwable th) {
            String stackTraceString = Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!epxompbe!gbjm!") + stackTraceString);
            ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("epxompbeQmvhjo!gbjm-") + stackTraceString);
        }
    }

    public static void dexa(Context context, Response<File> response, String str, String str2, long j) {
        try {
            File fileBody = response.body();
            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!epxompbe!epof!"));
            if (!dexa(context, fileBody.getAbsolutePath(), j)) {
                Utils.setFileWrite(fileBody, context);
                fileBody.delete();
                return;
            }
            File file = new File(str2, cj.mobile.wm.dexc.dexa("xnefw`8/:/29/31"));
            if (file.exists()) {
                DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!pwfsxsjuf!"));
                Utils.setFileWrite(file, context);
                file.delete();
                Utils.setFileReadOnly(file, context);
            }
            fileBody.renameTo(file);
            Utils.setFileReadOnly(file, context);
            SharedPreferencesHelper.getInstance(context).savePreferencesString(cj.mobile.wm.dexc.dexa("nn`tq`l24"), str);
            cj.mobile.wm.dexa.dexa();
        } catch (Throwable th) {
            String str3 = cj.mobile.wm.dexc.dexa("gbjmfe!up!qspdftt!vqebuf!") + Log.getStackTraceString(th);
            DebugLog.loadPlugin_e(str3);
            ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), str3);
        }
    }

    public static boolean dexa(Context context, String str, long j) {
        CheckedInputStream checkedInputStream;
        FileInputStream fileInputStream = null;
        try {
            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!wfsjgz"));
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                CRC32 crc32 = new CRC32();
                checkedInputStream = new CheckedInputStream(fileInputStream2, crc32);
                try {
                    while (checkedInputStream.read(new byte[4096]) != -1) {
                    }
                    if (crc32.getValue() == j) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            checkedInputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    }
                    DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!wfsjgz!gbjm"));
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        String stackTraceString = Log.getStackTraceString(th);
                        DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!wfsjgz!gbjm") + stackTraceString);
                        ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("difdlQmvhjoDsdWbmvf!gbjm-") + stackTraceString);
                        if (checkedInputStream == null) {
                            return false;
                        }
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (checkedInputStream != null) {
                            try {
                                checkedInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                checkedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            checkedInputStream = null;
        }
        try {
            return false;
        } catch (IOException unused6) {
            return false;
        }
    }

    public static void dexa(Context context, Response<String> response, String str) {
        try {
            String strBody = response.body();
            if (!TextUtils.isEmpty(strBody)) {
                JSONObject jSONObject = new JSONObject(strBody);
                int i = jSONObject.getInt(cj.mobile.wm.dexc.dexa("sfu"));
                DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!sftq!") + i);
                if (i == 0) {
                    String string = jSONObject.getString(cj.mobile.wm.dexc.dexa("wfstjpo"));
                    DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!sftq!") + string);
                    String string2 = jSONObject.getString(cj.mobile.wm.dexc.dexa("epxompbeVsm"));
                    long j = jSONObject.getLong(cj.mobile.wm.dexc.dexa("difdlTvn"));
                    if (!TextUtils.isEmpty(string)) {
                        if (dexa(context, string, str)) {
                            dexa(context, string2, string, j);
                        } else {
                            DebugLog.loadPlugin(cj.mobile.wm.dexc.dexa("qmh!sftq!op!ebub"));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!sftq!gbjm!") + th);
            ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("epDifdlQmvhjoWfstjpoSftqpotf!gbjm-") + Log.getStackTraceString(th));
        }
    }

    public static boolean dexa(Context context, String str, String str2) {
        try {
            return !dexa(str, str2).equals(str2);
        } catch (Throwable th) {
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("qmh!difdl!gbjm") + th);
            ReportUtils.exReport(context, 200015, cj.mobile.wm.dexc.dexa("TEL扞樌捗琓強眵痱楲鵦"), cj.mobile.wm.dexc.dexa("difdlJtOffeEpxompbeQmvhjo!gbjm-") + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void dexa(Context context, String str, dexd dexdVar) {
        BufferedReader bufferedReader;
        synchronized (dexh.class) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(dexb(context) + File.separator + str));
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
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        }
    }

    public static String dexa(String str, String str2) {
        try {
            String[] strArrSplit = str.split(cj.mobile.wm.dexc.dexa("]/"));
            String[] strArrSplit2 = str2.split(cj.mobile.wm.dexc.dexa("]/"));
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
            DebugLog.loadPlugin_e(cj.mobile.wm.dexc.dexa("hfuNbyWfstjpo!gbjm-") + Log.getStackTraceString(th));
            return str;
        }
    }
}
