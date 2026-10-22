package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends a {
    public c(Context context, boolean z) {
        this.d = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.c = true;
        }
    }

    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add((String) jSONArray.get(i));
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return new ArrayList();
        }
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        this.f37520a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString("name");
            long j = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f37520a.b(string);
            this.f37520a.a(j);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int c(String str) {
        JSONObject jSONObject;
        this.b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                this.b.addAll(a(jSONObject));
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00a5 A[Catch: JSONException -> 0x0124, TryCatch #0 {JSONException -> 0x0124, blocks: (B:3:0x000c, B:4:0x001e, B:6:0x0024, B:8:0x003a, B:10:0x0043, B:11:0x0059, B:13:0x005f, B:15:0x0070, B:22:0x0089, B:23:0x009f, B:25:0x00a5, B:27:0x00b9, B:29:0x00bf, B:31:0x00d0, B:16:0x0075, B:18:0x007b, B:20:0x0082, B:32:0x00e4, B:34:0x00ef, B:38:0x00fe, B:40:0x0109, B:42:0x0110, B:43:0x0117, B:35:0x00f4, B:37:0x00fa, B:39:0x0103), top: B:50:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0110 A[Catch: JSONException -> 0x0124, TryCatch #0 {JSONException -> 0x0124, blocks: (B:3:0x000c, B:4:0x001e, B:6:0x0024, B:8:0x003a, B:10:0x0043, B:11:0x0059, B:13:0x005f, B:15:0x0070, B:22:0x0089, B:23:0x009f, B:25:0x00a5, B:27:0x00b9, B:29:0x00bf, B:31:0x00d0, B:16:0x0075, B:18:0x007b, B:20:0x0082, B:32:0x00e4, B:34:0x00ef, B:38:0x00fe, B:40:0x0109, B:42:0x0110, B:43:0x0117, B:35:0x00f4, B:37:0x00fa, B:39:0x0103), top: B:50:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    public int f(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        JSONObject jSONObject2;
        Iterator<String> itKeys;
        String next;
        String str3 = "countryGroup";
        String str4 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject3 = new JSONObject(str).getJSONObject("services");
            Iterator<String> itKeys2 = jSONObject3.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next2);
                if (!this.e.contains(next2)) {
                    this.e.add(next2);
                    if (this.d) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(next2);
                        cVar.c(jSONObject4.getString("routeBy"));
                        JSONArray jSONArray = jSONObject4.getJSONArray("servings");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject5 = (JSONObject) jSONArray.get(i);
                            com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                            if (jSONObject5.has(str4)) {
                                string = jSONObject5.getString(str4);
                            } else {
                                if (jSONObject5.has(str3)) {
                                    string = jSONObject5.getString(str3);
                                } else {
                                    Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                    str2 = "no-country";
                                }
                                dVar.a(str2);
                                jSONObject2 = jSONObject5.getJSONObject("addresses");
                                String str5 = str3;
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                itKeys = jSONObject2.keys();
                                while (itKeys.hasNext()) {
                                    itKeys = itKeys;
                                    next = itKeys.next();
                                    String string2 = jSONObject2.getString(next);
                                    if (TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                                        concurrentHashMap.put(next, jSONObject2.getString(next));
                                        str4 = str4;
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                                i++;
                                str3 = str5;
                                str4 = str4;
                            }
                            str2 = string;
                            dVar.a(str2);
                            jSONObject2 = jSONObject5.getJSONObject("addresses");
                            String str6 = str3;
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                            itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                itKeys = itKeys;
                                next = itKeys.next();
                                String string3 = jSONObject2.getString(next);
                                if (TextUtils.isEmpty(next)) {
                                }
                            }
                            dVar.a(concurrentHashMap2);
                            cVar.a(dVar.b(), dVar);
                            i++;
                            str3 = str6;
                            str4 = str4;
                        }
                        String str7 = str3;
                        String str8 = str4;
                        List<com.huawei.hms.framework.network.grs.local.model.b> listA = null;
                        if (jSONObject4.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject4.getJSONObject("countryOrAreaGroups");
                        } else {
                            if (jSONObject4.has("countryGroups")) {
                                jSONObject = jSONObject4.getJSONObject("countryGroups");
                            } else {
                                Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            }
                            cVar.a(listA);
                            if (this.f37520a == null) {
                                this.f37520a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.f37520a.a(next2, cVar);
                            str3 = str7;
                            str4 = str8;
                        }
                        listA = a((JSONArray) null, jSONObject);
                        cVar.a(listA);
                        if (this.f37520a == null) {
                            this.f37520a = new com.huawei.hms.framework.network.grs.local.model.a();
                        }
                        this.f37520a.a(next2, cVar);
                        str3 = str7;
                        str4 = str8;
                    }
                }
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }
}
