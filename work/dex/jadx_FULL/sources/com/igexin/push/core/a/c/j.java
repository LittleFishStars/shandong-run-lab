package com.igexin.push.core.a.c;

import android.content.Context;
import android.content.Intent;
import com.igexin.push.core.b.p;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37946a = "com.igexin.push.core.a.c.j";

    private static void a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(270532608);
                intent.setComponent(launchIntentForPackage.getComponent());
                context.startActivity(intent);
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0045 A[Catch: Exception -> 0x00d3, TRY_ENTER, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x005e A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x006d A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0080 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0097 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x009f A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ab A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c1 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5 A[Catch: Exception -> 0x00d3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d3, blocks: (B:15:0x0045, B:17:0x005e, B:18:0x0067, B:20:0x006d, B:21:0x007c, B:22:0x0080, B:24:0x0097, B:26:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00c1, B:34:0x00c5), top: B:39:0x0043 }] */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        boolean z;
        String taskId;
        String messageId;
        String doActionId;
        if (pushTaskBean != null && baseActionBean != null) {
            p pVar = (p) baseActionBean;
            String str = pVar.b;
            boolean z2 = false;
            try {
                if (str.equals("")) {
                    str = com.igexin.push.core.e.f38001a;
                } else {
                    if (!com.igexin.push.core.e.f38001a.equals(pVar.b)) {
                        z = false;
                    }
                    com.igexin.c.a.c.a.a("doStartApp|" + z + "|" + str, new Object[0]);
                    if (z) {
                        com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str, (String) null);
                        if (((p) baseActionBean).d.equals("true")) {
                            String str2 = com.igexin.push.core.e.g;
                            a(com.igexin.push.core.e.l, com.igexin.push.core.e.g);
                        }
                        if (pVar.getDoActionId() != null) {
                            com.igexin.push.core.a.b.d();
                            taskId = pushTaskBean.getTaskId();
                            messageId = pushTaskBean.getMessageId();
                            doActionId = pVar.getDoActionId();
                            com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                        }
                    } else {
                        com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str, (String) null);
                        if (!pVar.d.equals("true")) {
                            z2 = true;
                        } else if (com.igexin.push.g.c.a(pVar.f37968a)) {
                            a(com.igexin.push.core.e.l, ((p) baseActionBean).f37968a);
                            z2 = true;
                        }
                        if (z2) {
                            if (pVar.getDoActionId() != null) {
                                com.igexin.push.core.a.b.d();
                                taskId = pushTaskBean.getTaskId();
                                messageId = pushTaskBean.getMessageId();
                                doActionId = pVar.getDoActionId();
                                com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                            }
                        } else if (pVar.c != null) {
                            com.igexin.push.core.a.b.d();
                            taskId = pushTaskBean.getTaskId();
                            messageId = pushTaskBean.getMessageId();
                            doActionId = pVar.c;
                            com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                        }
                    }
                }
                if (z) {
                    com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str, (String) null);
                    if (((p) baseActionBean).d.equals("true")) {
                        String str3 = com.igexin.push.core.e.g;
                        a(com.igexin.push.core.e.l, com.igexin.push.core.e.g);
                    }
                    if (pVar.getDoActionId() != null) {
                        com.igexin.push.core.a.b.d();
                        taskId = pushTaskBean.getTaskId();
                        messageId = pushTaskBean.getMessageId();
                        doActionId = pVar.getDoActionId();
                        com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                    }
                } else {
                    com.igexin.push.core.l.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), str, (String) null);
                    if (!pVar.d.equals("true")) {
                        z2 = true;
                    } else if (com.igexin.push.g.c.a(pVar.f37968a)) {
                        a(com.igexin.push.core.e.l, ((p) baseActionBean).f37968a);
                        z2 = true;
                    }
                    if (z2) {
                        if (pVar.getDoActionId() != null) {
                            com.igexin.push.core.a.b.d();
                            taskId = pushTaskBean.getTaskId();
                            messageId = pushTaskBean.getMessageId();
                            doActionId = pVar.getDoActionId();
                            com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                        }
                    } else if (pVar.c != null) {
                        com.igexin.push.core.a.b.d();
                        taskId = pushTaskBean.getTaskId();
                        messageId = pushTaskBean.getMessageId();
                        doActionId = pVar.c;
                        com.igexin.push.core.a.b.a(taskId, messageId, doActionId);
                    }
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            z = true;
            com.igexin.c.a.c.a.a("doStartApp|" + z + "|" + str, new Object[0]);
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.setType(com.igexin.push.core.b.q);
            pVar.setActionId(jSONObject.getString("actionid"));
            pVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                pVar.f37968a = jSONObject.getJSONObject("appstartupid").getString("android");
            }
            if (jSONObject.has("is_autostart")) {
                pVar.d = jSONObject.getString("is_autostart");
            }
            if (jSONObject.has("appid")) {
                pVar.b = jSONObject.getString("appid");
            }
            if (jSONObject.has("noinstall_action")) {
                pVar.c = jSONObject.getString("noinstall_action");
            }
            return pVar;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}
