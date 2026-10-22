package com.byazt.gf;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byakv.z.SoftDecTool;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 914, 13})
public class tt {
    public static volatile tt c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28566a;
    public LinkedList<JSONObject> n;
    public SharedPreferences tt;
    public LinkedList<JSONObject> uj;
    public LinkedList<JSONObject> ve;

    public tt() {
        this.tt = null;
        this.ve = null;
        this.uj = null;
        this.n = null;
        this.f28566a = 0L;
        this.tt = SoftDecTool.getSharedPreferences("pithar");
        this.ve = ve("sp_angle");
        this.uj = ve("sp_screen");
        this.n = ve("sp_net");
        this.f28566a = n.c().ve() / n.c().uj();
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    private LinkedList<JSONObject> ve(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.tt;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return linkedList;
    }

    public synchronized void tt(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListC = c("sp_screen");
            int i = 1;
            if (linkedListC != null && !linkedListC.isEmpty()) {
                JSONObject jSONObject = linkedListC.get(linkedListC.size() - 1);
                if (jSONObject.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                    int iOptInt = jSONObject.optInt("val", 0) + 1;
                    linkedListC.remove(linkedListC.size() - 1);
                    i = iOptInt;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("t", jCurrentTimeMillis);
                jSONObject2.put("val", i);
                c(jSONObject2, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public LinkedList<JSONObject> c(String str) {
        if ("sp_angle".equals(str)) {
            return this.ve;
        }
        if ("sp_screen".equals(str)) {
            return this.uj;
        }
        if ("sp_net".equals(str)) {
            return this.n;
        }
        return null;
    }

    public void c(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListC = c(str);
        if (linkedListC == null) {
            return;
        }
        linkedListC.add(jSONObject);
        if (linkedListC.size() > this.f28566a) {
            linkedListC.remove(0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jVe = jCurrentTimeMillis - n.c().ve();
        Iterator<JSONObject> it = linkedListC.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong("t", 0L);
            if (jOptLong < jVe) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListC.size() < 2) {
            linkedListC.add(0, jSONObject2);
        }
        c(str, linkedListC);
    }

    public synchronized void c(int i) {
        int iOptInt;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i == 4) {
            iOptInt = 1;
        } else {
            iOptInt = i > 0 ? 2 : 0;
        }
        LinkedList<JSONObject> linkedListC = c("sp_net");
        if (linkedListC != null && !linkedListC.isEmpty()) {
            JSONObject jSONObject = linkedListC.get(linkedListC.size() - 1);
            if (jSONObject.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                iOptInt |= jSONObject.optInt("val", 0);
                linkedListC.remove(linkedListC.size() - 1);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("t", jCurrentTimeMillis);
            jSONObject2.put("val", iOptInt);
            c(jSONObject2, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void c(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.tt == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.tt.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> c(long j) {
        if (j == 0) {
            return this.ve;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        for (JSONObject jSONObject2 : this.ve) {
            if (jCurrentTimeMillis - jSONObject2.optLong("t", 0L) < j) {
                linkedList.add(jSONObject2);
            } else {
                jSONObject = jSONObject2;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.add(0, jSONObject);
        }
        return linkedList;
    }
}
