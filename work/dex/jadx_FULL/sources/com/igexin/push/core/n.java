package com.igexin.push.core;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.main.FeedbackImpl;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class n {
    private static final String b = "PushMessageExecutor";
    private static Set<String> d;
    private static volatile n f;
    private final Map<String, PushMessageInterface> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<String, String> f38079a = new HashMap<>();
    private final Map<String, String> e = new ConcurrentHashMap();

    private n() {
        d = new HashSet();
        this.c = new HashMap();
        d.add(b.s);
        d.add("notification");
        d.add(b.o);
        d.add(b.p);
        d.add(b.q);
        d.add(b.r);
        d.add("null");
        d.add(b.u);
        d.add(b.v);
        d.add(b.w);
        d.add(b.x);
        d.add(b.y);
        d.add(b.t);
        d.add(b.z);
    }

    public static n a() {
        if (f == null) {
            synchronized (n.class) {
                if (f == null) {
                    f = new n();
                }
            }
        }
        return f;
    }

    private PushMessageInterface a(String str) {
        PushMessageInterface pushMessageInterface;
        n nVar;
        ClassLoader classLoaderB;
        Class<?> clsLoadClass;
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        PushMessageInterface pushMessageInterface2 = null;
        try {
            if (!this.f38079a.containsKey(str) || (classLoaderB = e.b(str)) == null || (clsLoadClass = classLoaderB.loadClass(this.f38079a.get(str))) == null) {
                pushMessageInterface = null;
            } else {
                pushMessageInterface = (PushMessageInterface) clsLoadClass.newInstance();
                try {
                    this.c.put(str, pushMessageInterface);
                } catch (Throwable th) {
                    th = th;
                    com.igexin.c.a.c.a.a(th);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            pushMessageInterface = null;
        }
        if (pushMessageInterface != null) {
            return pushMessageInterface;
        }
        if (!TextUtils.isEmpty(str) && d.contains(str) && (pushMessageInterface2 = this.c.get(str)) == null) {
            str.hashCode();
            switch (str) {
                case "updatedconfig":
                    nVar = this;
                    nVar.c.put(b.t, new com.igexin.push.core.a.c.n());
                    break;
                case "disablelog":
                    nVar = this;
                    nVar.c.put(b.y, new com.igexin.push.core.a.c.c());
                    break;
                case "startmyactivity":
                    nVar = this;
                    nVar.c.put(b.p, new com.igexin.push.core.a.c.k());
                    break;
                case "terminatetask":
                    nVar = this;
                    nVar.c.put(b.o, new com.igexin.push.core.a.c.m());
                    break;
                case "enablelog":
                    nVar = this;
                    nVar.c.put(b.x, new com.igexin.push.core.a.c.d());
                    break;
                case "goto":
                    nVar = this;
                    nVar.c.put(b.s, new com.igexin.push.core.a.c.f());
                    break;
                case "null":
                    nVar = this;
                    nVar.c.put("null", new com.igexin.push.core.a.c.e());
                    break;
                case "popup":
                    nVar = this;
                    nVar.c.put(b.r, new com.igexin.push.core.a.c.i());
                    break;
                case "notification":
                    nVar = this;
                    nVar.c.put("notification", new com.igexin.push.core.a.c.h());
                    break;
                case "cleanext":
                    nVar = this;
                    nVar.c.put(b.w, new com.igexin.push.core.a.c.b());
                    break;
                case "gdoption":
                    nVar = this;
                    nVar.c.put(b.z, new com.igexin.push.core.a.c.g());
                    break;
                case "startapp":
                    nVar = this;
                    nVar.c.put(b.q, new com.igexin.push.core.a.c.j());
                    break;
                case "startweb":
                    nVar = this;
                    nVar.c.put(b.u, new com.igexin.push.core.a.c.l());
                    break;
                case "checkapp":
                    nVar = this;
                    nVar.c.put(b.v, new com.igexin.push.core.a.c.a());
                    break;
                default:
                    nVar = this;
                    break;
            }
            pushMessageInterface2 = nVar.c.get(str);
        }
        return pushMessageInterface2;
    }

    private PushMessageInterface b(String str) {
        n nVar;
        if (TextUtils.isEmpty(str) || !d.contains(str)) {
            return null;
        }
        PushMessageInterface pushMessageInterface = this.c.get(str);
        if (pushMessageInterface != null) {
            return pushMessageInterface;
        }
        str.hashCode();
        switch (str) {
            case "updatedconfig":
                nVar = this;
                nVar.c.put(b.t, new com.igexin.push.core.a.c.n());
                break;
            case "disablelog":
                nVar = this;
                nVar.c.put(b.y, new com.igexin.push.core.a.c.c());
                break;
            case "startmyactivity":
                nVar = this;
                nVar.c.put(b.p, new com.igexin.push.core.a.c.k());
                break;
            case "terminatetask":
                nVar = this;
                nVar.c.put(b.o, new com.igexin.push.core.a.c.m());
                break;
            case "enablelog":
                nVar = this;
                nVar.c.put(b.x, new com.igexin.push.core.a.c.d());
                break;
            case "goto":
                nVar = this;
                nVar.c.put(b.s, new com.igexin.push.core.a.c.f());
                break;
            case "null":
                nVar = this;
                nVar.c.put("null", new com.igexin.push.core.a.c.e());
                break;
            case "popup":
                nVar = this;
                nVar.c.put(b.r, new com.igexin.push.core.a.c.i());
                break;
            case "notification":
                nVar = this;
                nVar.c.put("notification", new com.igexin.push.core.a.c.h());
                break;
            case "cleanext":
                nVar = this;
                nVar.c.put(b.w, new com.igexin.push.core.a.c.b());
                break;
            case "gdoption":
                nVar = this;
                nVar.c.put(b.z, new com.igexin.push.core.a.c.g());
                break;
            case "startapp":
                nVar = this;
                nVar.c.put(b.q, new com.igexin.push.core.a.c.j());
                break;
            case "startweb":
                nVar = this;
                nVar.c.put(b.u, new com.igexin.push.core.a.c.l());
                break;
            case "checkapp":
                nVar = this;
                nVar.c.put(b.v, new com.igexin.push.core.a.c.a());
                break;
            default:
                nVar = this;
                break;
        }
        return nVar.c.get(str);
    }

    public static void b() {
        try {
            if (!TextUtils.isEmpty(com.igexin.push.config.d.C) && !"none".equals(com.igexin.push.config.d.C)) {
                List<String> listAsList = Arrays.asList(com.igexin.push.config.d.C.split(","));
                if (listAsList.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, PushTaskBean>> it = e.ah.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, PushTaskBean> next = it.next();
                    String key = next.getKey();
                    PushTaskBean value = next.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        for (String str : listAsList) {
                            if (!TextUtils.isEmpty(str) && key.startsWith(str)) {
                                arrayList.add(value.getTaskId());
                                it.remove();
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                String[] strArr = new String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strArr[i] = (String) arrayList.get(i);
                }
                d.a.f37984a.i.a("message", new String[]{"taskid"}, strArr);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        Message messageObtain = Message.obtain();
        messageObtain.what = b.V;
        messageObtain.obj = bundle;
        d.a.f37984a.a(messageObtain);
    }

    private static void b(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            HashMap map = new HashMap();
            if (jSONObject2.has("wifi")) {
                map.put("wifi", jSONObject2.getString("wifi"));
            }
            if (jSONObject2.has("screenOn")) {
                map.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("ssid")) {
                map.put("ssid", jSONObject2.getString("ssid"));
                if (jSONObject2.has("bssid")) {
                    map.put("bssid", jSONObject2.getString("bssid"));
                }
            }
            if (jSONObject2.has("duration")) {
                String string = jSONObject2.getString("duration");
                if (string.contains(c49.f40900a)) {
                    int iIndexOf = string.indexOf(c49.f40900a);
                    String strSubstring = string.substring(0, iIndexOf);
                    String strSubstring2 = string.substring(iIndexOf + 1, string.length());
                    map.put("startTime", strSubstring);
                    map.put("endTime", strSubstring2);
                }
            }
            if (jSONObject2.has("netConnected")) {
                map.put("netConnected", jSONObject2.getString("netConnected"));
            }
            if (jSONObject2.has(AdvertCacheDBModel.COLUMN_EXPIRE_TIME)) {
                String string2 = jSONObject2.getString(AdvertCacheDBModel.COLUMN_EXPIRE_TIME);
                if (!TextUtils.isEmpty(string2) && TextUtils.isDigitsOnly(string2)) {
                    map.put(AdvertCacheDBModel.COLUMN_EXPIRE_TIME, string2);
                }
            }
            pushTaskBean.setConditionMap(map);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private void c(String str, String str2) {
        if (str2 == null || str == null) {
            return;
        }
        try {
            com.igexin.push.core.a.b.d();
            String strA = com.igexin.push.core.a.b.a(str, str2);
            PushTaskBean pushTaskBean = e.ah.get(strA);
            if (pushTaskBean == null) {
                return;
            }
            int status = pushTaskBean.getStatus();
            int i = b.ah;
            if (status == i) {
                com.igexin.c.a.c.a.b(b, " has execute ".concat(String.valueOf(strA)));
                return;
            }
            pushTaskBean.setStatus(i);
            com.igexin.c.a.c.a.b(b, " do processActionExecute ".concat(String.valueOf(strA)));
            if (a(str, str2) != PushMessageInterface.ActionPrepareState.success) {
                pushTaskBean.setStatus(b.ag);
                return;
            }
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(b.ah, str);
            pushTaskBean.setStatus(b.ah);
            if (a(str, str2, "1")) {
                return;
            }
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(b.ag, str);
            pushTaskBean.setStatus(b.ag);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private boolean e() {
        if (e.ah.isEmpty() && e.w.getAndSet(false)) {
            Cursor cursorA = null;
            try {
                cursorA = d.a.f37984a.i.a("message", new String[]{"status"}, new String[]{"0"}, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        byte[] blob = cursorA.getBlob(cursorA.getColumnIndex("msgextra"));
                        try {
                            JSONObject jSONObject = new JSONObject(new String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndex(AliyunLogCommon.LogLevel.INFO)))));
                            String string = jSONObject.getString("id");
                            String string2 = jSONObject.getString("appid");
                            String string3 = jSONObject.getString("messageid");
                            String string4 = jSONObject.getString("taskid");
                            String string5 = jSONObject.getString("appkey");
                            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                            com.igexin.push.core.a.b.d();
                            String strA = com.igexin.push.core.a.b.a(string4, string3);
                            PushTaskBean pushTaskBean = new PushTaskBean();
                            pushTaskBean.setAppid(string2);
                            pushTaskBean.setMessageId(string3);
                            pushTaskBean.setTaskId(string4);
                            pushTaskBean.setId(string);
                            pushTaskBean.setAppKey(string5);
                            pushTaskBean.setCurrentActionid(1);
                            pushTaskBean.setStatus(cursorA.getInt(cursorA.getColumnIndex("status")));
                            if (blob != null) {
                                pushTaskBean.setMsgExtra(blob);
                            }
                            if (jSONObject.has("condition")) {
                                b(jSONObject, pushTaskBean);
                            }
                            if (jSONArray.length() > 0) {
                                if (a(jSONObject, pushTaskBean)) {
                                    e.ah.put(strA, pushTaskBean);
                                } else {
                                    com.igexin.c.a.c.a.a(b, "load task from db parseActionChains error, " + jSONObject.toString());
                                    com.igexin.c.a.c.a.a("PushMessageExecutor|load task from db parseActionChains error, " + jSONObject.toString(), new Object[0]);
                                }
                            }
                        } catch (JSONException e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                    }
                }
                if (cursorA != null) {
                }
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        }
        return e.ah.isEmpty();
    }

    private boolean f() {
        Cursor cursorA = null;
        try {
            cursorA = d.a.f37984a.i.a("message", new String[]{"status"}, new String[]{"0"}, null, null);
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    byte[] blob = cursorA.getBlob(cursorA.getColumnIndex("msgextra"));
                    try {
                        JSONObject jSONObject = new JSONObject(new String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndex(AliyunLogCommon.LogLevel.INFO)))));
                        String string = jSONObject.getString("id");
                        String string2 = jSONObject.getString("appid");
                        String string3 = jSONObject.getString("messageid");
                        String string4 = jSONObject.getString("taskid");
                        String string5 = jSONObject.getString("appkey");
                        JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                        com.igexin.push.core.a.b.d();
                        String strA = com.igexin.push.core.a.b.a(string4, string3);
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setAppid(string2);
                        pushTaskBean.setMessageId(string3);
                        pushTaskBean.setTaskId(string4);
                        pushTaskBean.setId(string);
                        pushTaskBean.setAppKey(string5);
                        pushTaskBean.setCurrentActionid(1);
                        pushTaskBean.setStatus(cursorA.getInt(cursorA.getColumnIndex("status")));
                        if (blob != null) {
                            pushTaskBean.setMsgExtra(blob);
                        }
                        if (jSONObject.has("condition")) {
                            b(jSONObject, pushTaskBean);
                        }
                        if (jSONArray.length() > 0) {
                            if (!a(jSONObject, pushTaskBean)) {
                                com.igexin.c.a.c.a.a(b, "load task from db parseActionChains error because load gkt, " + jSONObject.toString());
                                com.igexin.c.a.c.a.a("PushMessageExecutor|load task from db parseActionChains error because load gkt, " + jSONObject.toString(), new Object[0]);
                            } else if (!e.ah.containsKey(strA)) {
                                e.ah.put(strA, pushTaskBean);
                            }
                        }
                    } catch (JSONException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
            }
            if (cursorA != null) {
            }
        } catch (Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        return e.ah.isEmpty();
    }

    private void g() {
        try {
            List<ScanResult> listJ = com.igexin.push.g.n.j();
            this.e.clear();
            if (listJ == null || listJ.isEmpty()) {
                return;
            }
            for (int i = 0; i < listJ.size(); i++) {
                this.e.put(listJ.get(i).BSSID, listJ.get(i).SSID);
                String str = listJ.get(i).BSSID;
                String str2 = listJ.get(i).SSID;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final PushMessageInterface.ActionPrepareState a(String str, String str2) {
        PushMessageInterface.ActionPrepareState actionPrepareState = PushMessageInterface.ActionPrepareState.success;
        com.igexin.push.core.a.b.d();
        PushTaskBean pushTaskBean = e.ah.get(com.igexin.push.core.a.b.a(str, str2));
        if (pushTaskBean == null) {
            return PushMessageInterface.ActionPrepareState.stop;
        }
        int i = 0;
        boolean z = false;
        for (BaseActionBean baseActionBean : pushTaskBean.getActionChains()) {
            PushMessageInterface.ActionPrepareState actionPrepareStatePrepareExecuteAction = PushMessageInterface.ActionPrepareState.stop;
            if (baseActionBean == null) {
                return actionPrepareStatePrepareExecuteAction;
            }
            if (!z && b.r.equals(baseActionBean.getType())) {
                z = true;
            }
            PushMessageInterface pushMessageInterfaceA = a(baseActionBean.getType());
            if (pushMessageInterfaceA != null) {
                actionPrepareStatePrepareExecuteAction = pushMessageInterfaceA.prepareExecuteAction(pushTaskBean, baseActionBean);
            } else {
                baseActionBean.getType();
            }
            if (actionPrepareState == PushMessageInterface.ActionPrepareState.success) {
                actionPrepareState = actionPrepareStatePrepareExecuteAction;
            }
            if (actionPrepareStatePrepareExecuteAction == PushMessageInterface.ActionPrepareState.wait) {
                i++;
            }
        }
        return (i == 0 || z || e.a(str, Integer.valueOf(i))) ? actionPrepareState : PushMessageInterface.ActionPrepareState.success;
    }

    public final void a(Intent intent) {
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("messageid");
        String stringExtra3 = intent.getStringExtra("actionid");
        String stringExtra4 = intent.getStringExtra("accesstoken");
        String stringExtra5 = intent.getStringExtra("url");
        String stringExtra6 = intent.getStringExtra(RemoteMessageConst.Notification.INTENT_URI);
        String stringExtra7 = intent.getStringExtra(AssistPushConsts.MSG_TYPE_PAYLOAD);
        String stringExtra8 = intent.hasExtra("title") ? intent.getStringExtra("title") : "";
        String stringExtra9 = intent.hasExtra("content") ? intent.getStringExtra("content") : "";
        int intExtra = intent.getIntExtra("notifID", 0);
        NotificationManager notificationManager = (NotificationManager) e.l.getSystemService("notification");
        if (intExtra != 0) {
            notificationManager.cancel(intExtra);
        } else if (e.ai.containsKey(stringExtra)) {
            intExtra = e.ai.get(stringExtra).intValue();
            notificationManager.cancel(intExtra);
        }
        e.ai.remove(stringExtra);
        if (stringExtra4.equals(e.an)) {
            l.a().b(stringExtra, stringExtra2, stringExtra8, stringExtra9, stringExtra5, stringExtra6, stringExtra7);
            b(stringExtra, stringExtra2, stringExtra3);
        }
    }

    public final boolean a(String str, String str2, String str3) {
        if (Thread.currentThread().getId() == d.a.f37984a.a()) {
            return b(str, str2, str3);
        }
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message messageObtain = Message.obtain();
        messageObtain.what = b.S;
        messageObtain.obj = bundle;
        return d.a.f37984a.a(messageObtain);
    }

    public final boolean a(Map<String, String> map, String str, PushTaskBean pushTaskBean) {
        String str2;
        if (!com.igexin.push.g.c.b(str)) {
            if (map != null && map.size() != 0) {
                if ((!map.containsKey(AdvertCacheDBModel.COLUMN_EXPIRE_TIME) || Long.parseLong(map.get(AdvertCacheDBModel.COLUMN_EXPIRE_TIME)) >= System.currentTimeMillis()) && (!map.containsKey("endTime") || Long.parseLong(map.get("endTime")) >= System.currentTimeMillis())) {
                    if (map.containsKey("wifi")) {
                        int i = Integer.parseInt(map.get("wifi"));
                        com.igexin.push.g.c.c();
                        if (i != e.x) {
                            return false;
                        }
                    }
                    if (map.containsKey("screenOn")) {
                        int i2 = Integer.parseInt(map.get("screenOn"));
                        com.igexin.push.g.c.d();
                        if (i2 != e.y) {
                            return false;
                        }
                    }
                    if (map.containsKey("ssid")) {
                        str2 = map.get("ssid");
                        try {
                            List<ScanResult> listJ = com.igexin.push.g.n.j();
                            this.e.clear();
                            if (listJ != null && !listJ.isEmpty()) {
                                for (int i3 = 0; i3 < listJ.size(); i3++) {
                                    this.e.put(listJ.get(i3).BSSID, listJ.get(i3).SSID);
                                    String str3 = listJ.get(i3).BSSID;
                                    String str4 = listJ.get(i3).SSID;
                                }
                            }
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                        if (!this.e.containsValue(str2)) {
                            return false;
                        }
                    } else {
                        str2 = "";
                    }
                    if (map.containsKey("bssid")) {
                        String str5 = map.get("bssid");
                        if (!this.e.containsKey(str5)) {
                            return false;
                        }
                        String str6 = this.e.get(str5);
                        if (str6 != null && !str6.equals(str2)) {
                            return false;
                        }
                    }
                    if (map.containsKey("startTime") && Long.parseLong(map.get("startTime")) > System.currentTimeMillis()) {
                        return false;
                    }
                    if (map.containsKey("netConnected")) {
                        try {
                            if (Integer.parseInt(map.get("netConnected")) != com.igexin.push.g.c.e()) {
                                return false;
                            }
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(b.ai, str);
        pushTaskBean.setStatus(b.ah);
        return false;
    }

    public final boolean a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        com.igexin.c.a.c.a.a("PushMessageExecutor------parse pushmessage actionchain json start-------", new Object[0]);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = ((JSONObject) jSONArray.get(i)).getString("type");
                if (!this.f38079a.containsKey(string) && !d.contains(string)) {
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + string + " not support~", new Object[0]);
                    return false;
                }
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                String string2 = jSONObject2.getString("type");
                com.igexin.c.a.c.a.a("PushMessageExecutor|start parse type = ".concat(String.valueOf(string2)), new Object[0]);
                PushMessageInterface pushMessageInterfaceA = a(string2);
                if (pushMessageInterfaceA != null) {
                    arrayList.add(pushMessageInterfaceA.parseAction(jSONObject2));
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        pushTaskBean.setActionChains(arrayList);
        com.igexin.c.a.c.a.b(b, "------parse pushmessage actionchain json end-------");
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x01ba A[Catch: all -> 0x023a, LOOP:0: B:40:0x0172->B:53:0x01ba, LOOP_END, TryCatch #1 {all -> 0x023a, blocks: (B:29:0x00f0, B:31:0x00f9, B:33:0x0112, B:35:0x014f, B:36:0x0157, B:38:0x015d, B:39:0x0160, B:40:0x0172, B:42:0x0178, B:44:0x018d, B:46:0x0193, B:52:0x01a1, B:53:0x01ba, B:54:0x01bd, B:73:0x0236, B:55:0x01c1, B:57:0x01c6, B:58:0x01cc, B:61:0x01d6, B:63:0x01e4, B:64:0x01e7, B:65:0x01eb, B:67:0x0200, B:68:0x0223, B:70:0x0231), top: B:104:0x00f0, outer: #2, inners: #0 }] */
    public final boolean a(JSONObject jSONObject, byte[] bArr, boolean z) {
        int i;
        int i2;
        BaseActionBean action;
        boolean z2;
        PushMessageInterface pushMessageInterfaceA;
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals(b.E)) {
                return true;
            }
            if (jSONObject.has("appid") && jSONObject.has("messageid") && jSONObject.has("taskid") && (!jSONObject.has("appid") || jSONObject.getString("appid").equals(e.f38001a))) {
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString("appid");
                String string3 = jSONObject.getString("messageid");
                String string4 = jSONObject.getString("taskid");
                String string5 = jSONObject.getString("appkey");
                JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                com.igexin.c.a.c.a.a("pushmessage|" + string4 + "|" + string3 + "|" + string2 + "|" + z, new Object[0]);
                final PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setAppid(string2);
                pushTaskBean.setMessageId(string3);
                pushTaskBean.setTaskId(string4);
                pushTaskBean.setId(string);
                pushTaskBean.setAppKey(string5);
                pushTaskBean.setCurrentActionid(1);
                com.igexin.push.core.a.b.d();
                String strA = com.igexin.push.core.a.b.a(string4, string3);
                if (z) {
                    FeedbackImpl.getInstance().asyncFeedback(new Runnable() { // from class: com.igexin.push.core.n.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, "0");
                        }
                    });
                    if (com.igexin.push.g.c.b(string4)) {
                        com.igexin.c.a.c.a.a("PushMessageExecutor|" + string4 + " in blacklist ###", new Object[0]);
                        return false;
                    }
                    if (com.igexin.push.g.c.a(jSONObject)) {
                        com.igexin.c.a.c.a.a("PushMessageExecutor|message have loop", new Object[0]);
                        return false;
                    }
                    try {
                        com.igexin.push.core.e.c.a();
                        if (com.igexin.push.core.e.c.a(string4)) {
                            com.igexin.c.a.c.a.a(b, "taskid = " + string4 + ", has already process @@####");
                            return false;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("messageid", string3);
                        contentValues.put("taskid", string4);
                        contentValues.put("appid", string2);
                        contentValues.put(CachedContentIndex.a.e, b.k.concat(String.valueOf(strA)));
                        contentValues.put(AliyunLogCommon.LogLevel.INFO, com.igexin.c.b.a.b(jSONObject.toString().getBytes()));
                        contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
                        if (bArr != null) {
                            contentValues.put("msgextra", bArr);
                            pushTaskBean.setMsgExtra(bArr);
                        }
                        if (jSONObject.has("condition")) {
                            b(jSONObject, pushTaskBean);
                        }
                        pushTaskBean.setStatus(b.ag);
                        contentValues.put("status", Integer.valueOf(b.ag));
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                            String string6 = jSONObject2.getString("type");
                            if (!"notification".equals(string6) || (pushMessageInterfaceA = a(string6)) == null) {
                                action = null;
                            } else {
                                action = pushMessageInterfaceA.parseAction(jSONObject2);
                                z2 = action instanceof com.igexin.push.core.b.l;
                                if (z2) {
                                    com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) action;
                                    contentValues.put("redisplay_freq", Integer.valueOf(lVar.r));
                                    contentValues.put("redisplay_duration", Long.valueOf(lVar.s));
                                    break;
                                }
                            }
                            if (z2) {
                                com.igexin.push.core.b.l lVar2 = (com.igexin.push.core.b.l) action;
                                contentValues.put("redisplay_freq", Integer.valueOf(lVar2.r));
                                contentValues.put("redisplay_duration", Long.valueOf(lVar2.s));
                                break;
                            }
                        }
                        com.igexin.push.core.e.c cVarA = com.igexin.push.core.e.c.a();
                        try {
                            if (cVarA.f38003a == -1) {
                                cVarA.f38003a = com.igexin.push.core.e.c.b();
                            }
                            if (cVarA.f38003a >= 1000) {
                                int iA = d.a.f37984a.i.a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
                                cVarA.f38003a -= iA;
                                if (iA < 250) {
                                    cVarA.f38003a -= d.a.f37984a.i.a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - iA) + ")");
                                }
                                if (d.a.f37984a.i.a("message", contentValues) != -1) {
                                    i = cVarA.f38003a;
                                    i2 = 1;
                                    cVarA.f38003a = i + i2;
                                }
                            } else if (d.a.f37984a.i.a("message", contentValues) != -1) {
                                i = cVarA.f38003a;
                                i2 = 1;
                                cVarA.f38003a = i + i2;
                            }
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    } catch (Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                    }
                }
                if (jSONArray.length() > 0 && !a(jSONObject, pushTaskBean)) {
                    com.igexin.c.a.c.a.a(b, "parseActionChains result = false #######");
                    com.igexin.c.a.c.a.a("PushMessageExecutor parseActionChains result = false #######", new Object[0]);
                    return false;
                }
                if (!z) {
                    if (jSONObject.has("condition")) {
                        b(jSONObject, pushTaskBean);
                    }
                    e.ah.put(strA, pushTaskBean);
                    return true;
                }
                e.ah.put(strA, pushTaskBean);
                if (com.igexin.push.g.c.a(System.currentTimeMillis())) {
                    com.igexin.c.a.c.a.b(b, "message in silent time, ignored...");
                    return false;
                }
                if (jSONObject.has("condition")) {
                    c();
                    return true;
                }
                b(string4, string3);
                return true;
            }
            com.igexin.c.a.c.a.a("PushMessageExecutor receive error pushmessage", new Object[0]);
            return false;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PushMessageExecutor " + e.toString(), new Object[0]);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean b(String str, String str2, final String str3) {
        int executeTimes;
        BaseActionBean baseAction;
        PushMessageInterface pushMessageInterfaceA;
        com.igexin.push.core.a.b.d();
        String strA = com.igexin.push.core.a.b.a(str, str2);
        com.igexin.c.a.c.a.b(b, "executePushMessageAction taskid:" + str + ", actionid:" + str3);
        final PushTaskBean pushTaskBean = e.ah.get(strA);
        if (pushTaskBean == null) {
            Cursor cursorA = null;
            try {
                cursorA = d.a.f37984a.i.a("message", new String[]{"taskid", "messageid"}, new String[]{str, str2}, null, null);
                if (cursorA != null && cursorA.getCount() > 0) {
                    while (cursorA.moveToNext()) {
                        a().a(new JSONObject(new String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndexOrThrow(AliyunLogCommon.LogLevel.INFO))))), cursorA.getBlob(cursorA.getColumnIndexOrThrow("msgextra")), false);
                        PushTaskBean pushTaskBean2 = e.ah.get(str + u15.f19942b + str2);
                        if (pushTaskBean2 == null) {
                            cursorA.close();
                            return false;
                        }
                        pushTaskBean = pushTaskBean2;
                    }
                    cursorA.close();
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return false;
            } catch (Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    if (cursorA != null) {
                    }
                    executeTimes = pushTaskBean.getExecuteTimes();
                    if (executeTimes >= 50) {
                        try {
                            e.ah.remove(strA);
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                        }
                        return true;
                    }
                    pushTaskBean.setExecuteTimes(executeTimes + 1);
                    FeedbackImpl.getInstance().asyncFeedback(new Runnable() { // from class: com.igexin.push.core.n.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, str3);
                        }
                    });
                    try {
                        baseAction = pushTaskBean.getBaseAction(str3);
                        if (baseAction == null) {
                            return false;
                        }
                        return pushMessageInterfaceA.executeAction(pushTaskBean, baseAction);
                    } catch (Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                    }
                } catch (Throwable th3) {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    throw th3;
                }
            }
        }
        executeTimes = pushTaskBean.getExecuteTimes();
        if (executeTimes >= 50) {
            e.ah.remove(strA);
            return true;
        }
        pushTaskBean.setExecuteTimes(executeTimes + 1);
        FeedbackImpl.getInstance().asyncFeedback(new Runnable() { // from class: com.igexin.push.core.n.2
            @Override // java.lang.Runnable
            public final void run() {
                FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, str3);
            }
        });
        baseAction = pushTaskBean.getBaseAction(str3);
        if (baseAction == null && (pushMessageInterfaceA = a(baseAction.getType())) != null) {
            return pushMessageInterfaceA.executeAction(pushTaskBean, baseAction);
        }
        return false;
    }

    public final void c() {
        try {
            if (com.igexin.push.g.c.a(System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b(b, "message in silent time , ignored...");
                return;
            }
            if (e()) {
                return;
            }
            for (Map.Entry<String, PushTaskBean> entry : e.ah.entrySet()) {
                try {
                    entry.getKey();
                    PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == b.ag) {
                        String taskId = value.getTaskId();
                        Map<String, String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            b(taskId, value.getMessageId());
                        }
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new Object[0]);
        }
    }

    public final void d() {
        com.igexin.c.a.c.a.a("PushMessageExecutor|--------checkConditionStatus the pushMessageMap from db because log gkt...", new Object[0]);
        try {
            if (com.igexin.push.g.c.a(System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b(b, "message in silent time , ignored...");
                return;
            }
            if (f()) {
                return;
            }
            for (Map.Entry<String, PushTaskBean> entry : e.ah.entrySet()) {
                try {
                    entry.getKey();
                    PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == b.ag) {
                        String taskId = value.getTaskId();
                        Map<String, String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            b(taskId, value.getMessageId());
                        }
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new Object[0]);
        }
    }
}
