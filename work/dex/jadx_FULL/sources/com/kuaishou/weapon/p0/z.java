package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class z {
    private Set<String> e = new HashSet();
    private Set<String> f = new HashSet();
    private Set<String> g = new HashSet();
    private Set<String> h = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f40160a = i.a("f118f1f9431de3a626df48d7302911", "0820");
    private String b = i.a("f118f1ef4616f3fc27d1", "0820");
    private String c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");
    private String d = i.a("fc03e7a44510", "0820");

    public JSONArray a(Context context) throws Throwable {
        BufferedReader bufferedReader;
        int iIndexOf;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            try {
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                hashSet2.add("/system/fr");
                hashSet2.add("/system/em");
                hashSet2.add("/apex/com.");
                hashSet2.add("/data/dalv");
                hashSet2.add("/system/li");
                hashSet2.add("/vendor/li");
                hashSet2.add("/system/ve");
                String packageName = context.getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                this.e.clear();
                this.f.clear();
                this.g.clear();
                this.h.clear();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if ((line.endsWith(".apk") || line.endsWith(".jar") || line.endsWith(".dex") || line.endsWith(".odex") || line.endsWith(".so")) && !line.contains("gson.jar") && !line.contains("volley.jar") && !line.contains("FwkPlugin") && (iIndexOf = line.indexOf(47)) >= 0) {
                        String strSubstring = line.substring(iIndexOf);
                        if (strSubstring.contains(this.f40160a) || strSubstring.contains(this.b) || strSubstring.contains(this.c)) {
                            this.e.add(strSubstring);
                        } else {
                            if (strSubstring.contains(this.d) && !strSubstring.contains("libart.so") && !strSubstring.contains("libart64.so")) {
                                this.h.add(strSubstring);
                            }
                            if (!strSubstring.contains("es/.0/") && !strSubstring.contains("app_DvaPlugin") && !strSubstring.contains("/system_ext/") && (!strSubstring.contains(packageName) || strSubstring.contains("odex_cache") || strSubstring.contains("app_"))) {
                                String strSubstring2 = strSubstring.length() > 10 ? strSubstring.substring(0, 10) : strSubstring;
                                if (!strSubstring.contains("FeatureFramework") && !strSubstring.contains("GmsConfigOverlay") && !strSubstring.contains("/system/app/") && !strSubstring.contains("/system/vendor/lib/") && !strSubstring.contains("/hw_") && !strSubstring.contains("/system/product/lib")) {
                                    if (strSubstring.contains("mokee-") || strSubstring.contains("mokee.")) {
                                        this.f.add(strSubstring);
                                    } else if (strSubstring.contains("lineageos-") || strSubstring.contains("lineageos.") || strSubstring.contains("Hook") || strSubstring.contains("hook")) {
                                        this.g.add(strSubstring);
                                    } else if (strSubstring.contains("posedBridge") || !hashSet2.contains(strSubstring2)) {
                                        hashSet.add(strSubstring);
                                        if (hashSet.size() > 15 || this.e.size() > 10 || this.f.size() > 10 || this.g.size() > 10) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    JSONArray jSONArray = new JSONArray((Collection) hashSet);
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    return jSONArray;
                }
            } catch (Exception unused3) {
                if (bufferedReader != null) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused6) {
        }
        return null;
    }

    public Set<String> b() {
        try {
            Set<String> set = this.g;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.g;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            Set<String> set = this.h;
            if (set == null || set.size() <= 0) {
                return null;
            }
            return this.h;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            Set<String> set = this.e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str : this.e) {
                if (str.contains(this.f40160a)) {
                    jSONObject.put("0", 1);
                } else if (str.contains(this.b)) {
                    jSONObject.put("1", 1);
                } else if (str.contains(this.c)) {
                    jSONObject.put("2", 1);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set e() {
        try {
            HashSet hashSet = new HashSet();
            Set<String> set = this.e;
            if (set == null || set.size() <= 0) {
                return null;
            }
            for (String str : this.e) {
                if (str.endsWith("dex")) {
                    hashSet.add(str);
                }
                if (hashSet.size() > 5) {
                    break;
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int a() {
        try {
            Set<String> set = this.f;
            if (set == null || set.size() <= 0) {
                return 0;
            }
            return this.f.size();
        } catch (Exception unused) {
            return 0;
        }
    }
}
