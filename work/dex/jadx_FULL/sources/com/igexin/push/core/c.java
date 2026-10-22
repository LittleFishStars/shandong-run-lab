package com.igexin.push.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f37978a = "com.igexin.push.core.c";
    private boolean b;

    public c(Looper looper) {
        super(looper);
        this.b = false;
    }

    private static void a() {
        if (e.u || e.O <= 10000) {
            return;
        }
        int iRandom = (int) ((Math.random() * 100.0d) + 150.0d);
        long j = e.O;
        com.igexin.c.a.c.a.a(f37978a + "|userPresent, rdelay = " + e.O + ", reset = " + iRandom, new Object[0]);
        e.b((long) iRandom);
        com.igexin.push.f.b.e.g().a(e.O);
    }

    private static void a(Intent intent) throws Throwable {
        String stringExtra = intent.getStringExtra("action");
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(intent);
            return;
        }
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_ONRESUME)) {
            com.igexin.c.a.c.a.a(f37978a + "|handle onresume ~~~", new Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.b("on fg");
            return;
        }
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.b(intent);
            AssistPushManager.getInstance().turnOnPush(e.l);
            return;
        }
        if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
            String stringExtra2 = intent.getStringExtra("sc");
            if (TextUtils.isEmpty(e.i) || e.i.equals(stringExtra2)) {
                Bundle bundleExtra = intent.getBundleExtra("bundle");
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.a(bundleExtra);
                return;
            }
            com.igexin.c.a.c.a.a("safeCode not match!!" + e.i + "," + stringExtra2, new Object[0]);
            com.igexin.c.a.c.a.d.a().a("safeCode not match!!" + e.i + "," + stringExtra2);
            return;
        }
        if (stringExtra.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
            if (e.u || e.O <= 10000) {
                return;
            }
            int iRandom = (int) ((Math.random() * 100.0d) + 150.0d);
            long j = e.O;
            com.igexin.c.a.c.a.a(f37978a + "|userPresent, rdelay = " + e.O + ", reset = " + iRandom, new Object[0]);
            e.b((long) iRandom);
            com.igexin.push.f.b.e.g().a(e.O);
            return;
        }
        if (stringExtra.equals("com.igexin.action.notification.click")) {
            Intent intent2 = (Intent) intent.getParcelableExtra("broadcast_intent");
            if (intent2 != null) {
                com.igexin.push.core.f.a.a();
                com.igexin.push.core.f.a.a(intent2);
                return;
            }
            return;
        }
        if (stringExtra.equals(b.M)) {
            HashMap map = (HashMap) intent.getSerializableExtra("push_action");
            com.igexin.c.a.c.a.a(f37978a + "| handle other push action broadcast", new Object[0]);
            n.a().f38079a.putAll(map);
            n.a().d();
            return;
        }
        if (!stringExtra.equals("com.igexin.action.notification.delete")) {
            if (stringExtra.equals(PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253)) {
                String stringExtra3 = intent.getStringExtra("id");
                String stringExtra4 = intent.getStringExtra("aid");
                com.igexin.push.core.c.a.a();
                com.igexin.push.core.c.a.a(stringExtra3, stringExtra4);
                return;
            }
            return;
        }
        if (intent.getBooleanExtra("isSummary", false)) {
            String stringExtra5 = intent.getStringExtra("groupId");
            e.aj.remove(stringExtra5);
            e.ak.remove(stringExtra5);
            return;
        }
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(intent.getStringExtra("appid"));
        pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
        String stringExtra6 = intent.getStringExtra("taskid");
        pushTaskBean.setTaskId(stringExtra6);
        pushTaskBean.setId(intent.getStringExtra("id"));
        pushTaskBean.setAppKey(intent.getStringExtra("appkey"));
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(stringExtra6, b.al, intent.getIntExtra("redisplayFreq", 0));
        int i = Integer.parseInt(intent.getStringExtra("feedbackid")) + 30040;
        pushTaskBean.setCurrentActionid(i);
        FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, String.valueOf(i), "notifyStyle:" + intent.getStringExtra("notifyStyle"));
        com.igexin.push.core.a.b.d();
        String strA = com.igexin.push.core.a.b.a(intent.getStringExtra("taskid"), intent.getStringExtra("messageid"));
        com.igexin.c.a.c.a.a(f37978a + "|notification delete = " + strA, new Object[0]);
        try {
            e.ah.remove(strA);
            com.igexin.c.a.c.a.a(f37978a + "|del notification, pushMessageMap remove = " + strA, new Object[0]);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new Object[0]);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        int i = message.what;
        if (i == b.T) {
            n.a().c();
            return;
        }
        Object obj = message.obj;
        if (obj == null) {
            return;
        }
        try {
            if (i != b.Q) {
                if (i == b.R) {
                    com.igexin.push.core.a.b.d();
                    Intent intent = (Intent) message.obj;
                    if (intent == null || intent.getAction() == null) {
                        return;
                    }
                    try {
                        String action = intent.getAction();
                        if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                            com.igexin.push.core.a.b.e();
                            return;
                        }
                        if (b.L.equals(action)) {
                            n.a().a(intent);
                            return;
                        }
                        if (b.N.equals(action)) {
                            if (com.igexin.push.config.d.c != 0) {
                                com.igexin.push.f.f.a().d();
                                return;
                            }
                            return;
                        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                            e.y = 1;
                            com.igexin.push.f.a.a().a(true);
                            com.igexin.push.core.a.b.b("screen on");
                            return;
                        } else {
                            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                                e.y = 0;
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                        return;
                    }
                }
                if (i != b.V) {
                    if (i == b.S) {
                        Bundle bundle = (Bundle) obj;
                        n.a().b(bundle.getString("taskid"), bundle.getString("messageid"), bundle.getString("actionid"));
                        return;
                    }
                    if (i == b.W) {
                        if (this.b) {
                            return;
                        }
                        d unused = d.a.f37984a;
                        d.c();
                        this.b = true;
                        return;
                    }
                    if (i != b.U || AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(e.I)) {
                        return;
                    }
                    com.igexin.push.d.c.n nVar = new com.igexin.push.d.c.n();
                    nVar.c = 128;
                    nVar.f = message.obj;
                    nVar.g = message.getData().getByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD);
                    new com.igexin.push.core.a.b.d().a(nVar);
                    return;
                }
                Bundle bundle2 = (Bundle) obj;
                String string = bundle2.getString("taskid");
                String string2 = bundle2.getString("messageid");
                n nVarA = n.a();
                if (string2 == null || string == null) {
                    return;
                }
                try {
                    com.igexin.push.core.a.b.d();
                    String strA = com.igexin.push.core.a.b.a(string, string2);
                    PushTaskBean pushTaskBean = e.ah.get(strA);
                    if (pushTaskBean == null) {
                        return;
                    }
                    int status = pushTaskBean.getStatus();
                    int i2 = b.ah;
                    if (status == i2) {
                        com.igexin.c.a.c.a.b("PushMessageExecutor", " has execute ".concat(String.valueOf(strA)));
                        return;
                    }
                    pushTaskBean.setStatus(i2);
                    com.igexin.c.a.c.a.b("PushMessageExecutor", " do processActionExecute ".concat(String.valueOf(strA)));
                    if (nVarA.a(string, string2) != PushMessageInterface.ActionPrepareState.success) {
                        pushTaskBean.setStatus(b.ag);
                        return;
                    }
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(b.ah, string);
                    pushTaskBean.setStatus(b.ah);
                    if (nVarA.a(string, string2, "1")) {
                        return;
                    }
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(b.ag, string);
                    pushTaskBean.setStatus(b.ag);
                    return;
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                    return;
                }
            }
            Intent intent2 = (Intent) obj;
            if (intent2.hasExtra("action")) {
                String stringExtra = intent2.getStringExtra("action");
                if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(intent2);
                    return;
                }
                if (stringExtra.equals(PushConsts.ACTION_SERVICE_ONRESUME)) {
                    com.igexin.c.a.c.a.a(f37978a + "|handle onresume ~~~", new Object[0]);
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.b("on fg");
                    return;
                }
                if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.b(intent2);
                    AssistPushManager.getInstance().turnOnPush(e.l);
                    return;
                }
                if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
                    String stringExtra2 = intent2.getStringExtra("sc");
                    if (TextUtils.isEmpty(e.i) || e.i.equals(stringExtra2)) {
                        Bundle bundleExtra = intent2.getBundleExtra("bundle");
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.a(bundleExtra);
                        return;
                    }
                    com.igexin.c.a.c.a.a("safeCode not match!!" + e.i + "," + stringExtra2, new Object[0]);
                    com.igexin.c.a.c.a.d.a().a("safeCode not match!!" + e.i + "," + stringExtra2);
                    return;
                }
                if (stringExtra.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                    if (e.u || e.O <= 10000) {
                        return;
                    }
                    int iRandom = (int) ((Math.random() * 100.0d) + 150.0d);
                    long j = e.O;
                    com.igexin.c.a.c.a.a(f37978a + "|userPresent, rdelay = " + e.O + ", reset = " + iRandom, new Object[0]);
                    e.b((long) iRandom);
                    com.igexin.push.f.b.e.g().a(e.O);
                    return;
                }
                if (stringExtra.equals("com.igexin.action.notification.click")) {
                    Intent intent3 = (Intent) intent2.getParcelableExtra("broadcast_intent");
                    if (intent3 != null) {
                        com.igexin.push.core.f.a.a();
                        com.igexin.push.core.f.a.a(intent3);
                        return;
                    }
                    return;
                }
                if (stringExtra.equals(b.M)) {
                    HashMap map = (HashMap) intent2.getSerializableExtra("push_action");
                    com.igexin.c.a.c.a.a(f37978a + "| handle other push action broadcast", new Object[0]);
                    n.a().f38079a.putAll(map);
                    n.a().d();
                    return;
                }
                if (!stringExtra.equals("com.igexin.action.notification.delete")) {
                    if (stringExtra.equals(PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253)) {
                        String stringExtra3 = intent2.getStringExtra("id");
                        String stringExtra4 = intent2.getStringExtra("aid");
                        com.igexin.push.core.c.a.a();
                        com.igexin.push.core.c.a.a(stringExtra3, stringExtra4);
                        return;
                    }
                    return;
                }
                if (intent2.getBooleanExtra("isSummary", false)) {
                    String stringExtra5 = intent2.getStringExtra("groupId");
                    e.aj.remove(stringExtra5);
                    e.ak.remove(stringExtra5);
                    return;
                }
                PushTaskBean pushTaskBean2 = new PushTaskBean();
                pushTaskBean2.setAppid(intent2.getStringExtra("appid"));
                pushTaskBean2.setMessageId(intent2.getStringExtra("messageid"));
                String stringExtra6 = intent2.getStringExtra("taskid");
                pushTaskBean2.setTaskId(stringExtra6);
                pushTaskBean2.setId(intent2.getStringExtra("id"));
                pushTaskBean2.setAppKey(intent2.getStringExtra("appkey"));
                com.igexin.push.core.e.c.a();
                com.igexin.push.core.e.c.a(stringExtra6, b.al, intent2.getIntExtra("redisplayFreq", 0));
                int i3 = Integer.parseInt(intent2.getStringExtra("feedbackid")) + 30040;
                pushTaskBean2.setCurrentActionid(i3);
                FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, String.valueOf(i3), "notifyStyle:" + intent2.getStringExtra("notifyStyle"));
                com.igexin.push.core.a.b.d();
                String strA2 = com.igexin.push.core.a.b.a(intent2.getStringExtra("taskid"), intent2.getStringExtra("messageid"));
                com.igexin.c.a.c.a.a(f37978a + "|notification delete = " + strA2, new Object[0]);
                try {
                    e.ah.remove(strA2);
                    com.igexin.c.a.c.a.a(f37978a + "|del notification, pushMessageMap remove = " + strA2, new Object[0]);
                    return;
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("EndAction|" + e.toString(), new Object[0]);
                    return;
                }
            }
            return;
        } catch (Throwable th3) {
            com.igexin.c.a.c.a.a(th3);
        }
        com.igexin.c.a.c.a.a(th3);
    }
}
