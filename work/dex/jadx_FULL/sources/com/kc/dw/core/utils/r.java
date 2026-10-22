package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class r {
    public static volatile r d;
    public static long e;
    public static long f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f39400a;
    public final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap<>();
    public final r1 c = new r1();

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f39401a;

        public a(r rVar) {
            this.f39401a = rVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39401a.b();
        }
    }

    public r() {
        try {
            e = System.currentTimeMillis();
            this.f39400a = new File(com.kc.dw.base.a.getContext().getFilesDir(), "file_preferences.json");
            c();
            f = System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static r a() {
        if (d == null) {
            synchronized (r.class) {
                try {
                    if (d == null) {
                        com.kc.dw.base.a.getContext();
                        d = new r();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public int a(String str, int i) {
        try {
            Object obj = this.b.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public long a(String str, long j) {
        try {
            Object obj = this.b.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return j;
    }

    public String a(String str, String str2) {
        try {
            Object obj = this.b.get(str);
            return obj instanceof String ? (String) obj : str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public boolean a(String str) {
        try {
            return this.b.containsKey(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void b() {
        synchronized (this) {
            try {
                FileWriter fileWriter = new FileWriter(this.f39400a);
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    fileWriter.write(jSONObject.toString());
                    fileWriter.close();
                } catch (Throwable th) {
                    try {
                        fileWriter.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public void b(String str, int i) {
        try {
            this.b.put(str, Integer.valueOf(i));
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, long j) {
        try {
            this.b.put(str, Long.valueOf(j));
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, String str2) {
        try {
            this.b.put(str, str2);
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        synchronized (this) {
            try {
                if (!this.f39400a.exists()) {
                    try {
                        this.f39400a.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f39400a));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                sb.append(line);
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    bufferedReader.close();
                    if (sb.length() > 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(sb.toString());
                            Iterator<String> itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                this.b.put(next, jSONObject.get(next));
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            th3.printStackTrace();
        }
    }

    public final void d() {
        int size;
        if (b.c != 0) {
            b();
            return;
        }
        r1 r1Var = this.c;
        a aVar = new a(this);
        r1Var.getClass();
        try {
            size = r1Var.f39403a.size();
        } catch (Exception unused) {
            size = 0;
        }
        if (size >= r1Var.c) {
            return;
        }
        r1Var.f39403a.add(aVar);
        if (r1Var.d) {
            return;
        }
        r1Var.d = true;
        ExecutorService executorService = f0.f39362a;
        if (f0.b.f39363a.a(new q1(r1Var))) {
            return;
        }
        r1Var.d = false;
        r1Var.a();
    }
}
