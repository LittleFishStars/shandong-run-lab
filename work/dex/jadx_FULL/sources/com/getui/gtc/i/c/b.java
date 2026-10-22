package com.getui.gtc.i.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.getui.gtc.BuildConfig;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.MultipartBody;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.e.c;
import com.getui.gtc.h.d;
import com.igexin.sdk.PushManager;
import com.ipd.dsp.internal.l0.g;
import com.zj.adlib.c25;
import com.zj.adlib.c49;
import com.zj.adlib.ze1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f30381a = new AtomicBoolean(false);

    private static File a() {
        return new File(CommonUtil.getExternalFilesDir(GtcProvider.context()), GtcProvider.context().getPackageName() + "-online.properties");
    }

    private static JSONObject a(String str) {
        try {
            a.a("update file log config:".concat(String.valueOf(str)));
            JSONObject jSONObjectA = c.a.f30351a.f30350a.a();
            boolean z = jSONObjectA != null && jSONObjectA.length() > 0;
            if (TextUtils.isEmpty(str)) {
                if (z) {
                    a().delete();
                    c.a.f30351a.f30350a.a((JSONObject) null);
                    a.a("file log clear old config and properties");
                }
                return null;
            }
            if (z && jSONObjectA.optString("dycConfig").equals(str)) {
                a.a("file log same config");
                return jSONObjectA;
            }
            c.a.f30351a.f30350a.a((JSONObject) null);
            a().delete();
            a.a("file log clear old config and properties");
            String[] strArrSplit = str.split("\\|");
            if (strArrSplit.length < 8) {
                throw new IllegalStateException("file log dyc error");
            }
            JSONObject jSONObject = new JSONObject();
            String[] strArrSplit2 = strArrSplit[0].split(",");
            String str2 = com.getui.gtc.c.b.d;
            for (String str3 : strArrSplit2) {
                if (!TextUtils.isEmpty(str3) && str3.equals(str2)) {
                    jSONObject.put("gtcid", str2);
                    break;
                }
            }
            String[] strArrSplit3 = strArrSplit[1].split(",");
            String strB = b(GtcProvider.context());
            for (String str4 : strArrSplit3) {
                if (!TextUtils.isEmpty(str4) && str4.equals(strB)) {
                    jSONObject.put("cid", strB);
                    break;
                }
            }
            if (!jSONObject.has("gtcid") && !jSONObject.has("cid")) {
                a.a("file upload not match cur user");
                return null;
            }
            long time = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(strArrSplit[2]).getTime();
            long j = Long.parseLong(strArrSplit[3]);
            if (j <= 0) {
                a.a("file upload interval=" + j + " not valid");
            }
            jSONObject.put("allowMobile", "1".equals(strArrSplit[6]));
            jSONObject.put("startTime", time);
            jSONObject.put("interval", j);
            jSONObject.put("suffixes", strArrSplit[4]);
            jSONObject.put("enableKeys", strArrSplit[5]);
            jSONObject.put("url", strArrSplit[7]);
            if (a(jSONObject)) {
                jSONObject.put("lastModified", a().lastModified());
            }
            jSONObject.put("dycConfig", str);
            c.a.f30351a.f30350a.a(jSONObject);
            a.a("save file log dyc to db: " + jSONObject.toString());
            return jSONObject;
        } catch (Throwable th) {
            a.c(th);
        }
    }

    public static void a(Map<String, String> map) {
        try {
            if (f30381a.getAndSet(true)) {
                return;
            }
            final JSONObject jSONObjectA = a(map != null ? map.get("sdk.gtc.fileLog.upload") : null);
            if (jSONObjectA != null && jSONObjectA.length() != 0) {
                final long jOptLong = jSONObjectA.optLong("startTime");
                String strOptString = jSONObjectA.optString("gtcid");
                String strOptString2 = jSONObjectA.optString("cid");
                final long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis >= jOptLong && jCurrentTimeMillis <= 604800000 + jOptLong) {
                    if ((!TextUtils.isEmpty(strOptString) && strOptString.equals(com.getui.gtc.c.b.d)) || (!TextUtils.isEmpty(strOptString2) && strOptString2.equals(b(GtcProvider.context())))) {
                        if (CommonUtil.isAppDebugEnable()) {
                            a.b("file log upload is debug, disallow");
                            return;
                        }
                        boolean zOptBoolean = jSONObjectA.optBoolean("allowMobile");
                        if (!a(zOptBoolean)) {
                            a.b("file log upload network is not allowed, allowMobile:".concat(String.valueOf(zOptBoolean)));
                            return;
                        }
                        File fileA = a();
                        long jOptLong2 = jSONObjectA.optLong("lastModified");
                        if (jOptLong2 == 0 || jOptLong2 != fileA.lastModified()) {
                            if (!a(jSONObjectA)) {
                                return;
                            }
                            jSONObjectA.put("lastModified", fileA.lastModified());
                            c.a.f30351a.f30350a.a(jSONObjectA);
                        }
                        if (jCurrentTimeMillis - jSONObjectA.optLong("reportTime") < jSONObjectA.optLong("interval") * 1000) {
                            a.c("file log report time not expired");
                            return;
                        }
                        Thread thread = new Thread(new Runnable() { // from class: com.getui.gtc.i.c.b.1
                            /* JADX WARN: Code duplicated, block: B:111:0x02ea A[Catch: all -> 0x0306, TryCatch #3 {all -> 0x0306, blocks: (B:110:0x02e7, B:111:0x02ea, B:113:0x02f0, B:114:0x0303, B:69:0x0250, B:71:0x0259, B:91:0x02a3, B:93:0x02a9), top: B:137:0x02e7 }] */
                            /* JADX WARN: Code duplicated, block: B:113:0x02f0 A[Catch: all -> 0x0306, TryCatch #3 {all -> 0x0306, blocks: (B:110:0x02e7, B:111:0x02ea, B:113:0x02f0, B:114:0x0303, B:69:0x0250, B:71:0x0259, B:91:0x02a3, B:93:0x02a9), top: B:137:0x02e7 }] */
                            /* JADX WARN: Code duplicated, block: B:121:0x0322 A[Catch: all -> 0x0338, TRY_LEAVE, TryCatch #17 {all -> 0x0338, blocks: (B:118:0x0319, B:119:0x031c, B:121:0x0322), top: B:165:0x0319 }] */
                            /* JADX WARN: Code duplicated, block: B:137:0x02e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Instruction removed from duplicated block: B:113:0x02f0, please report this as an issue */
                            /* JADX WARN: Instruction removed from duplicated block: B:121:0x0322, please report this as an issue */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                String str;
                                String[] strArr;
                                File file;
                                SimpleDateFormat simpleDateFormat;
                                File file2;
                                File file3;
                                String str2;
                                File file4;
                                String str3;
                                String str4 = c49.f40900a;
                                try {
                                    String[] strArrSplit = jSONObjectA.optString("suffixes").split(",");
                                    File externalFilesDir = CommonUtil.getExternalFilesDir(GtcProvider.context());
                                    String packageName = GtcProvider.context().getPackageName();
                                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                    SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                                    String str5 = "";
                                    try {
                                        str5 = com.getui.gtc.i.d.a.a(packageName).versionName;
                                    } catch (Throwable th) {
                                        a.b(th);
                                    }
                                    int length = strArrSplit.length;
                                    boolean z = false;
                                    int i = 0;
                                    while (i < length) {
                                        String str6 = strArrSplit[i];
                                        boolean z2 = z;
                                        int i2 = length;
                                        int i3 = 7;
                                        int i4 = i;
                                        long j = jCurrentTimeMillis;
                                        while (j > jOptLong && i3 > 0) {
                                            i3--;
                                            try {
                                                String str7 = simpleDateFormat2.format(new Date(j));
                                                strArr = strArrSplit;
                                                try {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(packageName);
                                                    sb.append(str4);
                                                    sb.append(str6);
                                                    sb.append(str4);
                                                    sb.append(str7);
                                                    str = str4;
                                                    try {
                                                        sb.append(c25.n);
                                                        file3 = new File(externalFilesDir, sb.toString());
                                                        try {
                                                            if (file3.exists() && file3.isFile()) {
                                                                if (file3.length() > g.f) {
                                                                    try {
                                                                        StringBuilder sb2 = new StringBuilder("file log is too large,length=");
                                                                        file4 = externalFilesDir;
                                                                        try {
                                                                            sb2.append(file3.length());
                                                                            a.b(sb2.toString());
                                                                            try {
                                                                                if (j != jCurrentTimeMillis) {
                                                                                    file3.delete();
                                                                                    str3 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                    a.a(str3);
                                                                                }
                                                                            } catch (Throwable unused) {
                                                                            }
                                                                        } catch (Throwable th2) {
                                                                            th = th2;
                                                                            file = file4;
                                                                            file2 = null;
                                                                            simpleDateFormat = simpleDateFormat3;
                                                                            a.a("file log upload http error", th);
                                                                            if (file2 != null) {
                                                                                file2.delete();
                                                                                if (j != jCurrentTimeMillis) {
                                                                                    file3.delete();
                                                                                    str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                    a.a(str2);
                                                                                }
                                                                            } else if (j != jCurrentTimeMillis) {
                                                                                file3.delete();
                                                                                str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                a.a(str2);
                                                                            }
                                                                            j -= 86400000;
                                                                            simpleDateFormat3 = simpleDateFormat;
                                                                            strArrSplit = strArr;
                                                                            str4 = str;
                                                                            externalFilesDir = file;
                                                                            simpleDateFormat2 = simpleDateFormat2;
                                                                            str6 = str6;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        file = externalFilesDir;
                                                                    }
                                                                } else {
                                                                    file4 = externalFilesDir;
                                                                    try {
                                                                        File fileB = b.b(file3);
                                                                        if (fileB == null) {
                                                                            try {
                                                                                a.b("file log to zip error,fileName:" + file3.getName());
                                                                                if (fileB != null) {
                                                                                    fileB.delete();
                                                                                }
                                                                                if (j != jCurrentTimeMillis) {
                                                                                    file3.delete();
                                                                                    str3 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                    a.a(str3);
                                                                                }
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                file = file4;
                                                                                file2 = fileB;
                                                                                simpleDateFormat = simpleDateFormat3;
                                                                                a.a("file log upload http error", th);
                                                                                if (file2 != null) {
                                                                                    file2.delete();
                                                                                    if (j != jCurrentTimeMillis) {
                                                                                        file3.delete();
                                                                                        str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                        a.a(str2);
                                                                                    }
                                                                                } else if (j != jCurrentTimeMillis) {
                                                                                    file3.delete();
                                                                                    str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                    a.a(str2);
                                                                                }
                                                                                j -= 86400000;
                                                                                simpleDateFormat3 = simpleDateFormat;
                                                                                strArrSplit = strArr;
                                                                                str4 = str;
                                                                                externalFilesDir = file;
                                                                                simpleDateFormat2 = simpleDateFormat2;
                                                                                str6 = str6;
                                                                            }
                                                                        } else {
                                                                            try {
                                                                                MultipartBody.Builder builder = new MultipartBody.Builder();
                                                                                file = file4;
                                                                                try {
                                                                                    builder.setType(MultipartBody.FORM);
                                                                                    JSONObject jSONObject = new JSONObject();
                                                                                    simpleDateFormat2 = simpleDateFormat2;
                                                                                    str6 = str6;
                                                                                    try {
                                                                                        jSONObject.put("gtcid", com.getui.gtc.c.b.d);
                                                                                        jSONObject.put("cid", b.b(GtcProvider.context()));
                                                                                        jSONObject.put("gtcVersion", BuildConfig.VERSION_NAME);
                                                                                        jSONObject.put("date", simpleDateFormat3.format(new Date()));
                                                                                        jSONObject.put("createDate", str7);
                                                                                        simpleDateFormat = simpleDateFormat3;
                                                                                        try {
                                                                                            jSONObject.put("lastModified", file3.lastModified());
                                                                                            jSONObject.put("versionName", str5);
                                                                                            jSONObject.put(ALPParamConstant.PACKAGENAME, packageName);
                                                                                            jSONObject.put("brand", Build.BRAND);
                                                                                            jSONObject.put(ze1.k, Build.MODEL);
                                                                                            int i5 = Build.VERSION.SDK_INT;
                                                                                            jSONObject.put("abi", Arrays.toString(Build.SUPPORTED_ABIS));
                                                                                            jSONObject.put("androidVersion", i5);
                                                                                            builder.addFormDataPart("content", jSONObject.toString());
                                                                                            builder.addFormDataPart(ALPParamConstant.PACKAGENAME, packageName);
                                                                                            builder.addFormDataPart("logFile", fileB.getName(), RequestBody.create(MediaType.get(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE), fileB));
                                                                                            a.a("file log upload result:" + d.f30374a.newCall(new Request.Builder().url(jSONObjectA.getString("url")).method("POST").logFlags(1).body(builder.build()).build()).execute().body().string() + ", logFile:" + file3.getName());
                                                                                            if (!z2) {
                                                                                                try {
                                                                                                    jSONObjectA.put("reportTime", jCurrentTimeMillis);
                                                                                                    c.a.f30351a.f30350a.a(jSONObjectA);
                                                                                                    a.a("file log update report time");
                                                                                                    z2 = true;
                                                                                                } catch (Throwable th5) {
                                                                                                    th = th5;
                                                                                                    z2 = true;
                                                                                                    file3 = file3;
                                                                                                    file2 = fileB;
                                                                                                    a.a("file log upload http error", th);
                                                                                                    if (file2 != null) {
                                                                                                        file2.delete();
                                                                                                        if (j != jCurrentTimeMillis) {
                                                                                                            file3.delete();
                                                                                                            str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                                        }
                                                                                                    } else if (j != jCurrentTimeMillis) {
                                                                                                        file3.delete();
                                                                                                        str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                                    }
                                                                                                    j -= 86400000;
                                                                                                    simpleDateFormat3 = simpleDateFormat;
                                                                                                    strArrSplit = strArr;
                                                                                                    str4 = str;
                                                                                                    externalFilesDir = file;
                                                                                                    simpleDateFormat2 = simpleDateFormat2;
                                                                                                    str6 = str6;
                                                                                                }
                                                                                            }
                                                                                            fileB.delete();
                                                                                            if (j != jCurrentTimeMillis) {
                                                                                                file3.delete();
                                                                                                str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                                a.a(str2);
                                                                                            }
                                                                                        } catch (Throwable th6) {
                                                                                            th = th6;
                                                                                        }
                                                                                    } catch (Throwable th7) {
                                                                                        th = th7;
                                                                                        simpleDateFormat = simpleDateFormat3;
                                                                                        file3 = file3;
                                                                                        file2 = fileB;
                                                                                        a.a("file log upload http error", th);
                                                                                        if (file2 != null) {
                                                                                            file2.delete();
                                                                                            if (j != jCurrentTimeMillis) {
                                                                                                file3.delete();
                                                                                                str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                                a.a(str2);
                                                                                            }
                                                                                        } else if (j != jCurrentTimeMillis) {
                                                                                            file3.delete();
                                                                                            str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                            a.a(str2);
                                                                                        }
                                                                                        j -= 86400000;
                                                                                        simpleDateFormat3 = simpleDateFormat;
                                                                                        strArrSplit = strArr;
                                                                                        str4 = str;
                                                                                        externalFilesDir = file;
                                                                                        simpleDateFormat2 = simpleDateFormat2;
                                                                                        str6 = str6;
                                                                                    }
                                                                                } catch (Throwable th8) {
                                                                                    th = th8;
                                                                                    simpleDateFormat2 = simpleDateFormat2;
                                                                                    str6 = str6;
                                                                                    simpleDateFormat = simpleDateFormat3;
                                                                                    file3 = file3;
                                                                                    file2 = fileB;
                                                                                    a.a("file log upload http error", th);
                                                                                    if (file2 != null) {
                                                                                        file2.delete();
                                                                                        if (j != jCurrentTimeMillis) {
                                                                                            file3.delete();
                                                                                            str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                            a.a(str2);
                                                                                        }
                                                                                    } else if (j != jCurrentTimeMillis) {
                                                                                        file3.delete();
                                                                                        str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                        a.a(str2);
                                                                                    }
                                                                                    j -= 86400000;
                                                                                    simpleDateFormat3 = simpleDateFormat;
                                                                                    strArrSplit = strArr;
                                                                                    str4 = str;
                                                                                    externalFilesDir = file;
                                                                                    simpleDateFormat2 = simpleDateFormat2;
                                                                                    str6 = str6;
                                                                                }
                                                                            } catch (Throwable th9) {
                                                                                th = th9;
                                                                                file = file4;
                                                                            }
                                                                            j -= 86400000;
                                                                            simpleDateFormat3 = simpleDateFormat;
                                                                            strArrSplit = strArr;
                                                                            str4 = str;
                                                                            externalFilesDir = file;
                                                                            simpleDateFormat2 = simpleDateFormat2;
                                                                            str6 = str6;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                        file = file4;
                                                                        simpleDateFormat2 = simpleDateFormat2;
                                                                        str6 = str6;
                                                                        simpleDateFormat = simpleDateFormat3;
                                                                        file3 = file3;
                                                                        file2 = null;
                                                                        a.a("file log upload http error", th);
                                                                        if (file2 != null) {
                                                                            file2.delete();
                                                                            if (j != jCurrentTimeMillis) {
                                                                                file3.delete();
                                                                                str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                a.a(str2);
                                                                            }
                                                                        } else if (j != jCurrentTimeMillis) {
                                                                            file3.delete();
                                                                            str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                            a.a(str2);
                                                                        }
                                                                        j -= 86400000;
                                                                        simpleDateFormat3 = simpleDateFormat;
                                                                        strArrSplit = strArr;
                                                                        str4 = str;
                                                                        externalFilesDir = file;
                                                                        simpleDateFormat2 = simpleDateFormat2;
                                                                        str6 = str6;
                                                                    }
                                                                }
                                                                j -= 86400000;
                                                                externalFilesDir = file4;
                                                                strArrSplit = strArr;
                                                                str4 = str;
                                                            } else {
                                                                file = externalFilesDir;
                                                                simpleDateFormat2 = simpleDateFormat2;
                                                                str6 = str6;
                                                                simpleDateFormat = simpleDateFormat3;
                                                                try {
                                                                    a.a("file log not exists :" + file3.getName());
                                                                    if (j != jCurrentTimeMillis) {
                                                                        file3.delete();
                                                                        str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                        a.a(str2);
                                                                    }
                                                                } catch (Throwable th11) {
                                                                    th = th11;
                                                                    file3 = file3;
                                                                    file2 = null;
                                                                    try {
                                                                        a.a("file log upload http error", th);
                                                                        if (file2 != null) {
                                                                            try {
                                                                                file2.delete();
                                                                                if (j != jCurrentTimeMillis) {
                                                                                    file3.delete();
                                                                                    str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                                }
                                                                            } catch (Throwable unused2) {
                                                                            }
                                                                        } else if (j != jCurrentTimeMillis) {
                                                                            file3.delete();
                                                                            str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                        }
                                                                        j -= 86400000;
                                                                        simpleDateFormat3 = simpleDateFormat;
                                                                        strArrSplit = strArr;
                                                                        str4 = str;
                                                                        externalFilesDir = file;
                                                                        simpleDateFormat2 = simpleDateFormat2;
                                                                        str6 = str6;
                                                                    } catch (Throwable th12) {
                                                                        if (file2 != null) {
                                                                            try {
                                                                                file2.delete();
                                                                                if (j != jCurrentTimeMillis) {
                                                                                    file3.delete();
                                                                                    a.a("file log upload delete old log file, fileName:" + file3.getName());
                                                                                }
                                                                            } catch (Throwable unused3) {
                                                                                throw th12;
                                                                            }
                                                                        } else if (j != jCurrentTimeMillis) {
                                                                            file3.delete();
                                                                            a.a("file log upload delete old log file, fileName:" + file3.getName());
                                                                        }
                                                                        throw th12;
                                                                    }
                                                                }
                                                                j -= 86400000;
                                                                simpleDateFormat3 = simpleDateFormat;
                                                                strArrSplit = strArr;
                                                                str4 = str;
                                                                externalFilesDir = file;
                                                                simpleDateFormat2 = simpleDateFormat2;
                                                                str6 = str6;
                                                            }
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            file = externalFilesDir;
                                                        }
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                        file = externalFilesDir;
                                                        simpleDateFormat2 = simpleDateFormat2;
                                                        str6 = str6;
                                                        simpleDateFormat = simpleDateFormat3;
                                                        file2 = null;
                                                        file3 = null;
                                                        a.a("file log upload http error", th);
                                                        if (file2 != null) {
                                                            file2.delete();
                                                            if (j != jCurrentTimeMillis) {
                                                                file3.delete();
                                                                str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                                a.a(str2);
                                                            }
                                                        } else if (j != jCurrentTimeMillis) {
                                                            file3.delete();
                                                            str2 = "file log upload delete old log file, fileName:" + file3.getName();
                                                            a.a(str2);
                                                        }
                                                        j -= 86400000;
                                                        simpleDateFormat3 = simpleDateFormat;
                                                        strArrSplit = strArr;
                                                        str4 = str;
                                                        externalFilesDir = file;
                                                        simpleDateFormat2 = simpleDateFormat2;
                                                        str6 = str6;
                                                    }
                                                } catch (Throwable th15) {
                                                    th = th15;
                                                    str = str4;
                                                }
                                            } catch (Throwable th16) {
                                                th = th16;
                                                str = str4;
                                                strArr = strArrSplit;
                                            }
                                        }
                                        i = i4 + 1;
                                        simpleDateFormat3 = simpleDateFormat3;
                                        z = z2;
                                        length = i2;
                                        strArrSplit = strArrSplit;
                                        str4 = str4;
                                        externalFilesDir = externalFilesDir;
                                        simpleDateFormat2 = simpleDateFormat2;
                                    }
                                } catch (Throwable th17) {
                                    a.a("file log upload unknown error", th17);
                                }
                            }
                        });
                        thread.setName("GTC_fileLogUploadThread");
                        thread.start();
                        return;
                    }
                    a().delete();
                    a.a("file log upload gtcid or cid changed");
                    return;
                }
                a.a("current time is not in file log upload time range");
                a().delete();
                return;
            }
            a.a("file log upload no dyc config in db");
        } catch (Throwable th) {
            a.c(th);
        }
    }

    private static boolean a(JSONObject jSONObject) {
        FileOutputStream fileOutputStream = null;
        try {
            long jOptLong = jSONObject.optLong("startTime");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= jOptLong && jCurrentTimeMillis <= jOptLong + 604800000) {
                String[] strArrSplit = jSONObject.optString("enableKeys").split(",");
                StringBuilder sb = new StringBuilder();
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(str);
                        sb.append(com.alipay.sdk.m.p.a.h);
                        sb.append("true\n");
                    }
                }
                if (sb.length() == 0) {
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a(), false);
                try {
                    fileOutputStream2.write(sb.toString().getBytes());
                    fileOutputStream2.flush();
                    a.a("file log write enableKeys success.");
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Throwable th) {
                        a.c(th);
                        return true;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        a.c(th);
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                a.c(th3);
                            }
                        }
                    }
                }
            }
            a.a("current time is not in file log upload time range");
            return false;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static boolean a(boolean z) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) GtcProvider.context().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return z || activeNetworkInfo.getType() == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x0066 A[Catch: all -> 0x0062, DONT_GENERATE, TryCatch #1 {all -> 0x0062, blocks: (B:30:0x005e, B:34:0x0066, B:36:0x006b), top: B:54:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:36:0x006b A[Catch: all -> 0x0062, DONT_GENERATE, TRY_LEAVE, TryCatch #1 {all -> 0x0062, blocks: (B:30:0x005e, B:34:0x0066, B:36:0x006b), top: B:54:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:46:0x007e A[Catch: all -> 0x007a, FINALLY_INSNS, TryCatch #5 {all -> 0x007a, blocks: (B:42:0x0076, B:46:0x007e, B:48:0x0083), top: B:62:0x0076 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0083 A[Catch: all -> 0x007a, FINALLY_INSNS, TRY_LEAVE, TryCatch #5 {all -> 0x007a, blocks: (B:42:0x0076, B:46:0x007e, B:48:0x0083), top: B:62:0x0076 }] */
    public static File b(File file) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        GZIPOutputStream gZIPOutputStream;
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file + ".zip");
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i != -1) {
                                gZIPOutputStream.write(bArr, 0, i);
                            } else {
                                try {
                                    break;
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                        gZIPOutputStream.close();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return file2;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (gZIPOutputStream != null) {
                                try {
                                } catch (Throwable th3) {
                                    return null;
                                }
                            }
                            return null;
                        } finally {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            } else {
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                gZIPOutputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            fileInputStream = null;
            gZIPOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context) {
        String str = "";
        try {
            Object objInvoke = PushManager.class.getDeclaredMethod("getClientid", Context.class).invoke(PushManager.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), context);
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Throwable th) {
            a.a("reflect cid", th);
        }
        a.a("reflect cid:".concat(str));
        return str;
    }
}
