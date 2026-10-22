package com.igexin.push.core.a.c;

import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.push.core.b.t;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class m implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37949a = com.igexin.push.core.b.f + m.class.getName();

    private static void a(String str) {
        try {
            com.igexin.c.a.c.a.a(f37949a + "|del condition taskid = " + str, new Object[0]);
            com.igexin.push.core.d.a.f37984a.i.a("message", new String[]{"taskid"}, new String[]{str});
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.b(f37949a, "del condition" + th.toString());
        }
    }

    private static void a(String str, BaseActionBean baseActionBean) {
        if (baseActionBean == null) {
            return;
        }
        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean;
        String str2 = lVar.q;
        HashSet<String> hashSet = com.igexin.push.core.e.aj.get(str2);
        Integer num = com.igexin.push.core.e.ak.get(lVar.q);
        if (hashSet != null && !hashSet.isEmpty()) {
            hashSet.remove(str);
        }
        if (TextUtils.isEmpty(str2) || num == null || hashSet == null || !hashSet.isEmpty()) {
            return;
        }
        ((NotificationManager) com.igexin.push.core.e.l.getSystemService("notification")).cancel(num.intValue());
        com.igexin.push.core.e.aj.remove(str2);
        com.igexin.push.core.e.ak.remove(str2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0165  */
    /* JADX WARN: Code duplicated, block: B:56:0x0168 A[PHI: r4 r5
      0x0168: PHI (r4v3 boolean) = (r4v2 boolean), (r4v10 boolean) binds: [B:61:0x0172, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]
      0x0168: PHI (r5v4 android.database.Cursor) = (r5v3 android.database.Cursor), (r5v6 android.database.Cursor) binds: [B:61:0x0172, B:55:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x0184 A[Catch: all -> 0x0241, TryCatch #0 {all -> 0x0241, blocks: (B:70:0x0180, B:72:0x0184, B:74:0x01a9, B:76:0x01af, B:84:0x01f6, B:85:0x01fa, B:90:0x021b, B:82:0x01dc, B:92:0x0236, B:87:0x0208, B:79:0x01c5), top: B:100:0x0180, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01a9 A[Catch: all -> 0x0241, TryCatch #0 {all -> 0x0241, blocks: (B:70:0x0180, B:72:0x0184, B:74:0x01a9, B:76:0x01af, B:84:0x01f6, B:85:0x01fa, B:90:0x021b, B:82:0x01dc, B:92:0x0236, B:87:0x0208, B:79:0x01c5), top: B:100:0x0180, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01fa A[Catch: all -> 0x0241, TRY_LEAVE, TryCatch #0 {all -> 0x0241, blocks: (B:70:0x0180, B:72:0x0184, B:74:0x01a9, B:76:0x01af, B:84:0x01f6, B:85:0x01fa, B:90:0x021b, B:82:0x01dc, B:92:0x0236, B:87:0x0208, B:79:0x01c5), top: B:100:0x0180, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x024f  */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x0184, please report this as an issue */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        Cursor cursorA;
        boolean z;
        String strA;
        PushTaskBean pushTaskBean2;
        com.igexin.assist.sdk.a aVarA;
        Context context;
        AbstractPushManager abstractPushManager;
        String str;
        t tVar = (t) baseActionBean;
        String str2 = tVar.f37972a;
        NotificationManager notificationManager = (NotificationManager) com.igexin.push.core.e.l.getSystemService("notification");
        if (TextUtils.isEmpty(str2)) {
            z = false;
        } else {
            try {
                cursorA = com.igexin.push.core.d.a.f37984a.i.a("message", new String[]{"taskid"}, new String[]{str2}, null, "id ASC");
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToFirst()) {
                            String string = cursorA.getString(cursorA.getColumnIndex("messageid"));
                            com.igexin.push.core.a.b.d();
                            strA = com.igexin.push.core.a.b.a(str2, string);
                        } else {
                            strA = "";
                        }
                        if (strA.equals("") || (pushTaskBean2 = com.igexin.push.core.e.ah.get(strA)) == null) {
                            z = false;
                        } else {
                            pushTaskBean2.setStop(true);
                            try {
                                com.igexin.c.a.c.a.a(f37949a + "|del condition taskid = " + str2, new Object[0]);
                                com.igexin.push.core.d.a.f37984a.i.a("message", new String[]{"taskid"}, new String[]{str2});
                            } catch (Throwable th) {
                                com.igexin.c.a.c.a.a(th);
                                com.igexin.c.a.c.a.b(f37949a, "del condition" + th.toString());
                            }
                            String strValueOf = String.valueOf(pushTaskBean2.getPerActionid());
                            if (!strValueOf.equals("0") && pushTaskBean2.getBaseAction(strValueOf).getType().equals("notification") && com.igexin.push.core.e.ai.containsKey(str2)) {
                                notificationManager.cancel(com.igexin.push.core.e.ai.get(str2).intValue());
                                com.igexin.push.core.e.ai.remove(str2);
                                try {
                                    BaseActionBean actionByType = pushTaskBean2.getActionByType("notification");
                                    if (actionByType != null) {
                                        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) actionByType;
                                        String str3 = lVar.q;
                                        HashSet<String> hashSet = com.igexin.push.core.e.aj.get(str3);
                                        Integer num = com.igexin.push.core.e.ak.get(lVar.q);
                                        if (hashSet != null && !hashSet.isEmpty()) {
                                            hashSet.remove(str2);
                                        }
                                        if (!TextUtils.isEmpty(str3) && num != null && hashSet != null && hashSet.isEmpty()) {
                                            ((NotificationManager) com.igexin.push.core.e.l.getSystemService("notification")).cancel(num.intValue());
                                            com.igexin.push.core.e.aj.remove(str3);
                                            com.igexin.push.core.e.ak.remove(str3);
                                        }
                                    }
                                    z = true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = true;
                                    try {
                                        com.igexin.c.a.c.a.a(th);
                                        if (cursorA != null) {
                                            cursorA.close();
                                        }
                                        if (!z) {
                                            try {
                                                if (tVar.b) {
                                                    com.igexin.c.a.c.a.a(f37949a + " | cancelAll()", new Object[0]);
                                                    notificationManager.cancelAll();
                                                    aVarA = com.igexin.assist.sdk.a.a();
                                                    context = com.igexin.push.core.e.l;
                                                    abstractPushManager = aVarA.b;
                                                    if (abstractPushManager != null) {
                                                        if (aVarA.b.getBrandCode().equals("3")) {
                                                            try {
                                                                Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                                                            } catch (Throwable th3) {
                                                                com.igexin.c.a.c.a.a(th3);
                                                                com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th3.toString(), new Object[0]);
                                                            }
                                                            str = " cancelAllAssistNotification() XM ";
                                                        } else {
                                                            if (aVarA.b.getBrandCode().equals("4")) {
                                                                try {
                                                                    PushManager.class.getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                                                                } catch (Throwable th4) {
                                                                    com.igexin.c.a.c.a.a(th4);
                                                                    com.igexin.c.a.c.a.a("AssistMangerFactory | cancelAllAssistNotification() err " + th4.toString(), new Object[0]);
                                                                }
                                                                str = " cancelAllAssistNotification() MZ ";
                                                            }
                                                            com.igexin.c.a.c.a.a(th);
                                                        }
                                                        com.igexin.c.a.c.a.b(com.igexin.assist.sdk.a.f37789a, str);
                                                    }
                                                    com.igexin.push.core.e.ak.clear();
                                                    com.igexin.push.core.e.aj.clear();
                                                }
                                            } catch (Throwable th5) {
                                                com.igexin.c.a.c.a.a(th5);
                                            }
                                        }
                                        if (!baseActionBean.getDoActionId().equals("")) {
                                            com.igexin.push.core.a.b.d();
                                            com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
                                        }
                                        return true;
                                    } catch (Throwable th6) {
                                        if (cursorA == null) {
                                            throw th6;
                                        }
                                        cursorA.close();
                                        throw th6;
                                    }
                                }
                            } else {
                                z = false;
                            }
                            try {
                                com.igexin.push.core.i.a aVarA2 = com.igexin.push.core.i.b.a().a(Long.valueOf(com.igexin.push.core.g.b));
                                if (aVarA2 != null && aVarA2.b().equals(str2)) {
                                    com.igexin.push.core.i.b.a().a(aVarA2);
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                com.igexin.c.a.c.a.a(th);
                                if (cursorA != null) {
                                    cursorA.close();
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        z = false;
                        com.igexin.c.a.c.a.a(th);
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        if (!z) {
                            if (tVar.b) {
                                com.igexin.c.a.c.a.a(f37949a + " | cancelAll()", new Object[0]);
                                notificationManager.cancelAll();
                                aVarA = com.igexin.assist.sdk.a.a();
                                context = com.igexin.push.core.e.l;
                                abstractPushManager = aVarA.b;
                                if (abstractPushManager != null) {
                                    if (aVarA.b.getBrandCode().equals("3")) {
                                        Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                                        str = " cancelAllAssistNotification() XM ";
                                    } else {
                                        if (aVarA.b.getBrandCode().equals("4")) {
                                            PushManager.class.getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                                            str = " cancelAllAssistNotification() MZ ";
                                        }
                                        com.igexin.c.a.c.a.a(th5);
                                    }
                                    com.igexin.c.a.c.a.b(com.igexin.assist.sdk.a.f37789a, str);
                                }
                                com.igexin.push.core.e.ak.clear();
                                com.igexin.push.core.e.aj.clear();
                            }
                        }
                        if (!baseActionBean.getDoActionId().equals("")) {
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
                        }
                        return true;
                    }
                } else {
                    z = false;
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            } catch (Throwable th9) {
                th = th9;
                cursorA = null;
            }
        }
        if (!z) {
            if (tVar.b) {
                com.igexin.c.a.c.a.a(f37949a + " | cancelAll()", new Object[0]);
                notificationManager.cancelAll();
                aVarA = com.igexin.assist.sdk.a.a();
                context = com.igexin.push.core.e.l;
                abstractPushManager = aVarA.b;
                if (abstractPushManager != null && abstractPushManager.isSupport()) {
                    if (aVarA.b.getBrandCode().equals("3")) {
                        Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                        str = " cancelAllAssistNotification() XM ";
                    } else {
                        if (aVarA.b.getBrandCode().equals("4")) {
                            PushManager.class.getDeclaredMethod("clearNotification", Context.class).invoke(null, context);
                            str = " cancelAllAssistNotification() MZ ";
                        }
                        com.igexin.c.a.c.a.a(th5);
                    }
                    com.igexin.c.a.c.a.b(com.igexin.assist.sdk.a.f37789a, str);
                }
                com.igexin.push.core.e.ak.clear();
                com.igexin.push.core.e.aj.clear();
            }
        }
        if (!baseActionBean.getDoActionId().equals("")) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("taskid")) {
                return null;
            }
            t tVar = new t();
            tVar.setType(com.igexin.push.core.b.o);
            tVar.setActionId(jSONObject.getString("actionid"));
            tVar.setDoActionId(jSONObject.getString("do"));
            tVar.f37972a = jSONObject.getString("taskid");
            tVar.b = jSONObject.optBoolean("force");
            return tVar;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}
