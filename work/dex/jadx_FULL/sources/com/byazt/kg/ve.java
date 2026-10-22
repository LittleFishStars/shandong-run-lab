package com.byazt.kg;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.mg.da;
import com.byazt.nr.m;
import com.byazt.uy.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 54})
public class ve {
    public static volatile boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f28729a = false;
    public volatile long n;
    public final SharedPreferences sp;
    public c tt;
    public final Context uj;
    public uj ve;

    public ve(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.uj = context;
        SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(context, "anr_monitor_table", 0);
        this.sp = sharedPreferencesTt;
        this.n = sharedPreferencesTt.getLong("trace_anr_happen_time", 0L);
    }

    public void c() {
        if (this.f28729a) {
            return;
        }
        this.ve = new uj(this);
        this.f28729a = true;
    }

    public boolean c(int i, String str, int i2) {
        JSONObject jSONObjectC;
        JSONObject jSONObjectC2;
        try {
            jSONObjectC = n.c(c);
        } catch (Throwable th) {
            m.c(th);
            jSONObjectC = null;
        }
        String strC = n.c(this.uj, i2);
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        try {
            com.byazt.uy.a aVarUj = x.tt().uj();
            if (aVarUj != null && aVarUj.c()) {
                if (i == 200 && (jSONObjectC2 = c(str, Process.myPid(), this.uj.getPackageName())) != null && jSONObjectC2.length() > 0) {
                    jSONObjectC = jSONObjectC2;
                }
                if (jSONObjectC != null && jSONObjectC.length() > 0) {
                    try {
                        jSONObjectC.put("pid", Process.myPid());
                        jSONObjectC.put("package", this.uj.getPackageName());
                        jSONObjectC.put("is_remote_process", 0);
                        com.byazt.xz.c cVar = new com.byazt.xz.c(new JSONObject());
                        cVar.c("data", jSONObjectC.toString());
                        cVar.c("is_anr", (Object) 1);
                        cVar.c("timestamp", Long.valueOf(System.currentTimeMillis()));
                        cVar.c("event_type", "anr");
                        cVar.c("anr_time", Long.valueOf(System.currentTimeMillis()));
                        cVar.c("crash_time", Long.valueOf(System.currentTimeMillis()));
                        cVar.c("anr_info", strC);
                        com.byazt.ia.n nVarC = com.byazt.ia.n.c();
                        com.byazt.uy.ve veVar = com.byazt.uy.ve.ANR;
                        com.byazt.xz.c cVarC = nVarC.c(veVar, cVar);
                        com.byazt.mg.uj.c(this.uj, veVar.c(), (String) null);
                        com.byazt.jz.c.c().tt(cVarC.c());
                        c(strC);
                    } catch (Throwable th2) {
                        da.tt(th2);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void c(String str) {
        Iterator<Object> it = x.tt().ve().iterator();
        while (it.hasNext()) {
            it.next();
            com.byazt.uy.ve veVar = com.byazt.uy.ve.ANR;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    public JSONObject c(String str, int i, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i2;
        ?? r3 = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            ?? CanRead = file.canRead();
            try {
                if (CanRead != 0) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                            Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                            Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                            Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                            boolean z = false;
                            Object[] objArrC = c(bufferedReader, patternCompile);
                            if (objArrC == null) {
                                com.byazt.mg.a.c(bufferedReader);
                                return null;
                            }
                            long j = Long.parseLong(objArrC[1].toString().split("\\s")[2]);
                            long time = simpleDateFormat.parse(objArrC[1].toString().split("\\s")[4] + " " + objArrC[1].toString().split("\\s")[5]).getTime();
                            Object[] objArrC2 = c(bufferedReader, patternCompile3);
                            if (objArrC2 == null) {
                                com.byazt.mg.a.c(bufferedReader);
                                return null;
                            }
                            String str3 = objArrC2[1].toString().split("\\s")[2];
                            if (j == i && str3.equalsIgnoreCase(str2)) {
                                if (this.n != 0 && Math.abs(this.n - time) < 20000) {
                                    com.byazt.mg.a.c(bufferedReader);
                                    return null;
                                }
                                this.n = time;
                                SharedPreferences sharedPreferences = this.sp;
                                if (sharedPreferences != null) {
                                    sharedPreferences.edit().putLong("trace_anr_happen_time", this.n).apply();
                                }
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("anrTime", time);
                                while (true) {
                                    Object[] objArrC3 = c(bufferedReader, patternCompile2, patternCompile4);
                                    if (objArrC3 != null && objArrC3[0] == patternCompile4) {
                                        Matcher matcher = Pattern.compile("\".+\"").matcher(objArrC3[1].toString());
                                        String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                                        Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrC3[1].toString());
                                        if (matcher2.find()) {
                                            String strGroup = matcher2.group();
                                            i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                                        } else {
                                            i2 = -1;
                                        }
                                        String strC = c(bufferedReader);
                                        if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strC) && strSubstring.equalsIgnoreCase("main")) {
                                            jSONObject.put("mainStackFromTrace", strC);
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (!z) {
                                    com.byazt.mg.a.c(bufferedReader);
                                    return null;
                                }
                                jSONObject.put("thread_number", 1);
                                com.byazt.mg.a.c(bufferedReader);
                                return jSONObject;
                            }
                            com.byazt.mg.a.c(bufferedReader);
                            return null;
                        } catch (Exception e) {
                            e = e;
                            m.c(e);
                            com.byazt.mg.a.c(bufferedReader);
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        com.byazt.mg.a.c(r3);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r3 = CanRead;
            }
        }
        return null;
    }

    private Object[] c(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    for (Pattern pattern : patternArr) {
                        if (pattern.matcher(line).matches()) {
                            return new Object[]{pattern, line};
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    private String c(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
    }
}
