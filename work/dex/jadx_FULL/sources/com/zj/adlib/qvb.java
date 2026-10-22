package com.zj.adlib;

import android.text.TextUtils;
import cn.hzjizhun.admin.base.t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class qvb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19185a;
    public int b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList f19186a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList f19187b = new ArrayList();

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f19186a = new ArrayList();
        String[] strArrSplit = str.split("#");
        if (strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    String[] strArrSplit2 = str2.split(c49.f40900a);
                    if (strArrSplit2.length > 1) {
                        int i = Integer.parseInt(strArrSplit2[0]);
                        this.f19186a.add(Integer.valueOf((int) Math.round((Math.random() * ((double) (Integer.parseInt(strArrSplit2[1]) - i))) + ((double) i))));
                    }
                }
            }
        }
    }

    public final void b(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("timer");
            jSONObject.optInt("limit");
            this.f44311a = jSONObject.optInt("webviewNum");
            this.b = jSONObject.optInt("userControl");
            String strOptString2 = jSONObject.optString("js");
            String strOptString3 = jSONObject.optString("ua");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("domains");
            if (!wtb.b) {
                wtb.b = true;
                if (TextUtils.isEmpty(strOptString3)) {
                    m3b.c().getClass();
                    wtb.i = m3b.g();
                } else {
                    wtb.i = strOptString3;
                }
            }
            a(strOptString);
            if (jSONArrayOptJSONArray != null) {
                try {
                    if (jSONArrayOptJSONArray.length() > 0) {
                        this.f19187b.clear();
                        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                            String strOptString4 = jSONArrayOptJSONArray.optString(i);
                            if (!TextUtils.isEmpty(strOptString4)) {
                                this.f19187b.add(strOptString4);
                            }
                        }
                        if (!this.f19187b.isEmpty()) {
                            hrb.a().f17058a = this.f19187b;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.f19185a = strOptString2;
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            t.f22705a.b(strOptString2);
        } catch (Throwable unused2) {
        }
    }
}
