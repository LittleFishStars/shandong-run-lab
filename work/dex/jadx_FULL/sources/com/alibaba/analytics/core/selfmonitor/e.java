package com.alibaba.analytics.core.selfmonitor;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.analytics.a.j;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e implements com.alibaba.analytics.core.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f23785a = new e();
    private final String aP = "sampling_monitor_ut";
    private final String aQ = "sampling_monitor_ap";
    private final String aR = "abtest_bucket";
    private final String aS = "abtest_offline";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Set<String> f656a = Collections.synchronizedSet(new HashSet());
    private Set<String> b = Collections.synchronizedSet(new HashSet());
    private Map<String, MeasureSet> x = Collections.synchronizedMap(new HashMap());
    private Set<String> c = Collections.synchronizedSet(new HashSet());

    private e() {
        com.alibaba.analytics.core.a.d.a().a("sampling_monitor_ut", this);
        com.alibaba.analytics.core.a.d.a().a("sampling_monitor_ap", this);
        com.alibaba.analytics.core.a.d.a().a("abtest_bucket", this);
        com.alibaba.analytics.core.a.d.a().a("abtest_offline", this);
        a(this.f656a, com.alibaba.analytics.core.a.d.a().get("sampling_monitor_ut"));
        a(this.b, com.alibaba.analytics.core.a.d.a().get("sampling_monitor_ap"));
        a(this.c, com.alibaba.analytics.core.a.d.a().get("abtest_offline"));
        h("abtest_bucket", com.alibaba.analytics.core.a.d.a().get("abtest_bucket"));
        new a().start();
        d.a().E();
    }

    public static e a() {
        return f23785a;
    }

    private void h(String str, String str2) {
        Set<String> setKeySet;
        String[] strArrSplit;
        this.x.clear();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONArray array = JSON.parseArray(str2);
            if (array != null) {
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jSONObject = (JSONObject) array.get(i);
                    if (jSONObject != null) {
                        String string = jSONObject.getString("module");
                        String string2 = jSONObject.getString("mp");
                        JSONObject jSONObject2 = (JSONObject) jSONObject.get("buckets");
                        if (jSONObject2 != null && (setKeySet = jSONObject2.keySet()) != null) {
                            MeasureSet measureSetCreate = MeasureSet.create();
                            for (String str3 : setKeySet) {
                                String string3 = jSONObject2.getString(str3);
                                if (!TextUtils.isEmpty(string3) && (strArrSplit = string3.split(",")) != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str4 : strArrSplit) {
                                        try {
                                            arrayList.add(Double.valueOf(str4));
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    measureSetCreate.addMeasure(new Measure(str3, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), arrayList));
                                }
                            }
                            this.x.put(string + u15.f19942b + string2, measureSetCreate);
                            com.alibaba.appmonitor.model.a aVarA = com.alibaba.appmonitor.model.b.a().a(string, string2);
                            if (aVarA != null) {
                                com.alibaba.appmonitor.model.b.a().a(new com.alibaba.appmonitor.model.a(string + "_abtest", string2, measureSetCreate, aVarA.a(), false));
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            j.w("Parse Monitor Bucket error ", th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        Set<String> set;
        if ("sampling_monitor_ut".equalsIgnoreCase(str)) {
            set = this.f656a;
        } else if ("sampling_monitor_ap".equalsIgnoreCase(str)) {
            set = this.b;
        } else {
            set = "abtest_offline".equalsIgnoreCase(str) ? this.c : null;
        }
        if (set != null) {
            a(set, str2);
        }
        if ("abtest_bucket".equalsIgnoreCase(str)) {
            h("abtest_bucket", str2);
        }
    }

    public boolean e(String str, String str2) {
        return a(str, str2) != null;
    }

    private void a(Set<String> set, String str) {
        String[] strArrSplit;
        if (set != null) {
            set.clear();
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split(",")) == null || strArrSplit.length <= 0) {
                return;
            }
            set.addAll(Arrays.asList(strArrSplit));
        }
    }

    public MeasureSet a(String str, String str2) {
        return this.x.get(str + u15.f19942b + str2);
    }

    public boolean a(EventType eventType, String str, String str2) {
        Set<String> set = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append(eventType);
        sb.append(u15.f19942b);
        sb.append(str);
        sb.append(u15.f19942b);
        sb.append(str2);
        return set.contains(sb.toString());
    }
}
