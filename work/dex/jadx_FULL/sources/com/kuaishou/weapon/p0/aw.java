package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.zj.adlib.u15;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f40047a;

    public aw(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ci.h).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f40047a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f40047a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("AudioTrack");
            hashSet.add("processrea");
            hashSet.add("RemitDatab");
            hashSet.add("BrowserBlo");
            hashSet.add("game_push");
            hashSet.add("Godzilla:I");
            hashSet.add("IndexedDB");
            hashSet.add("ScopeRetry");
            hashSet.add("RobustPatc");
            hashSet.add("FrescoIoBo");
            hashSet.add("key_config");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i) {
        JSONObject jSONObject = this.f40047a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set setA = a(i);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string2 = jSONArray.getString(i2);
                if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                    int i3 = 0;
                    while (string2.contains(" ")) {
                        string2 = string2.replace(" ", "");
                        i3++;
                        if (i3 > 200) {
                            break;
                        }
                    }
                    String strReplace = string2.replace("\n", "").replace("\t", "").replace("\u200b", "");
                    boolean zStartsWith = strReplace.startsWith(u15.f19942b);
                    String strSubstring = strReplace;
                    if (zStartsWith) {
                        strSubstring = strReplace.substring(1);
                    }
                    Object objSubstring = strSubstring.length() > 10 ? strSubstring.substring(0, 10) : strSubstring;
                    if (strSubstring.contains("ridge")) {
                        hashSet.add(strSubstring);
                    }
                    String packageName = context.getPackageName();
                    if (!strSubstring.contains(packageName) && !packageName.contains(strSubstring) && !setA.contains(objSubstring) && !b(i).contains(objSubstring)) {
                        hashSet.add(strSubstring);
                    }
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Set a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("HeapTaskDa");
            hashSet.add("queued-wor");
            hashSet.add("JDWP");
            hashSet.add("dTi");
            hashSet.add("MessageHan");
            hashSet.add("MediaPrefe");
            hashSet.add("CleanupRef");
            hashSet.add("GeoLocatio");
            hashSet.add("securityai");
            hashSet.add("Connectivi");
            hashSet.add("PatchManag");
            hashSet.add("CronetInte");
            hashSet.add("AegonLogge");
            hashSet.add("Countly");
            hashSet.add("DownloadSt");
            hashSet.add("GoogleApiH");
            hashSet.add("PlatformSe");
            hashSet.add("MemoryInfr");
            hashSet.add("CronetLibr");
            hashSet.add("Dex2OatIni");
            hashSet.add("EncodeApiH");
            hashSet.add("CookieMons");
        }
        return hashSet;
    }
}
