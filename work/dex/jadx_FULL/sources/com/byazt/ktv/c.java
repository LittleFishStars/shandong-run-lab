package com.byazt.ktv;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.aas.nb;
import com.byazt.aas.sv;
import com.byazt.bwm.sp;
import com.byazt.hy.n;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.va.uj;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 154, 20})
public class c implements com.byazt.aas.c.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet f28755a;
    public static volatile c c = null;
    public static HashMap<String, Long> n = null;
    public static final String uj = "com.byazt.ktv.c";
    public CopyOnWriteArrayList<JSONObject> tt = new CopyOnWriteArrayList<>();
    public com.byazt.aas.c ve;

    static {
        String name = c.class.getName();
        n = new HashMap<>();
        f28755a = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    private c() {
        com.byazt.aas.c cVarVe = x.m().ve();
        this.ve = cVarVe;
        if (cVarVe != null) {
            cVarVe.ve(this);
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
        if (x.m().d()) {
            return;
        }
        tt();
    }

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.tt;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.tt.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e) {
            m.c(e);
        }
        this.tt.clear();
        String strT = nb.t("/api/ad/union/sdk/callstack/batch/");
        sv svVar = new sv(n.c().tt().a());
        svVar.c(strT);
        svVar.ve(jSONObject, "callstack");
        svVar.c(new com.byazt.mh.c() { // from class: com.byazt.ktv.c.2
            @Override // com.byazt.mh.c
            public void c(uj ujVar, com.byazt.hm.tt ttVar) {
                if (ttVar != null) {
                    m.c("CallChainStatistic", Boolean.valueOf(ttVar.i()), ttVar.n());
                } else {
                    m.c("CallChainStatistic", "NetResponse is null");
                }
            }

            @Override // com.byazt.mh.c
            public void c(uj ujVar, IOException iOException) {
                m.c("CallChainStatistic", iOException.getMessage());
            }
        });
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public void c(int i, com.byazt.dj.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        c(i, ttVar.uj());
    }

    private boolean c(Long l) {
        return !c(new Date(), new Date(l.longValue()));
    }

    private boolean c(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l = n.get(str);
            if (l != null && l.longValue() != 0) {
                if (!c(l)) {
                    return false;
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > 0) {
                    n.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            m.ve("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void c(final int i, final String str) {
        if (tt.c() && c(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            com.byazt.bwm.n.c(new sp("callChainStatistic") { // from class: com.byazt.ktv.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.tt.add(c.this.c(i, str, stackTrace));
                    if (c.this.tt.size() < 3) {
                        return;
                    }
                    try {
                        c.this.tt();
                    } catch (OutOfMemoryError e) {
                        m.c(e);
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put("appid", x.m().rl());
            jSONObject.put(AlibcCommonConstant.APP_VERSION, nb.da());
            jSONObject.put("ad_sdk_version", p.n);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            jSONObject.put("adtype", i);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("callstack", c(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.byazt.by.c.c(gt.getContext(), i));
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    private JSONArray c(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
            if (stackTraceElement != null) {
                if (!f28755a.contains(stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                } else {
                    continue;
                }
            }
        }
        return jSONArray;
    }
}
