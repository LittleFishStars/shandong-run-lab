package com.igexin.push.core.a.a;

import android.os.Message;
import android.text.TextUtils;
import com.igexin.push.core.e.f.AnonymousClass1;
import com.igexin.push.core.e.f.AnonymousClass17;
import com.igexin.push.core.k;
import com.igexin.push.core.l;
import com.igexin.push.g.j;
import com.igexin.sdk.main.FeedbackImpl;
import com.igexin.sdk.router.GTBoater;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends com.igexin.push.core.a.a {
    private static final String b = "LoginResult";

    /* JADX INFO: renamed from: com.igexin.push.core.a.a.c$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.f.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.f.d
        public final void b() {
            try {
                com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                JSONObject jSONObjectA = dVarA.a();
                if (jSONObjectA == null) {
                    return;
                }
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject = jSONObjectA.getJSONObject(next);
                    com.igexin.c.a.c.a.a("LoginResult|send unFeedback taskid = ".concat(String.valueOf(next)), new Object[0]);
                    jSONObject.put("appid", com.igexin.push.core.e.f38001a);
                    FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, jSONObject.getString("multaid"));
                    itKeys.remove();
                }
                dVarA.b();
            } catch (Throwable th) {
                com.igexin.c.a.c.a.b(c.b, "feedbackMultiBrandPushMessage exception :" + th.toString());
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private void d() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
        com.igexin.push.d.c cVar = com.igexin.push.d.c.b.f38095a;
        cVar.c = System.currentTimeMillis();
        if (cVar.b) {
            com.igexin.c.a.c.a.a(com.igexin.push.d.c.f38093a, "loginRsp| enter polling");
            cVar.e = new com.igexin.push.d.e();
            com.igexin.push.f.b.d.a.f38124a.g();
            cVar.d = 0;
        } else {
            cVar.b();
        }
        String str = com.igexin.push.core.e.A;
        boolean z = com.igexin.push.core.e.v;
        com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new Object[0]);
        StringBuilder sb = new StringBuilder("isCidBroadcasted|");
        sb.append(com.igexin.push.core.e.v);
        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
        if (!com.igexin.push.core.e.v) {
            l.a().c();
            com.igexin.push.core.e.v = true;
        }
        com.igexin.push.core.e.u = true;
        j.g();
        l.a().b();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.g();
        if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.h();
        }
        com.igexin.push.core.c.a.a().a(true);
        long jCurrentTimeMillis = System.currentTimeMillis() - com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new Object[0]);
        boolean z2 = jCurrentTimeMillis - 86400000 > 0;
        boolean z3 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z4 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        boolean zB = com.igexin.push.g.c.b(com.igexin.push.core.e.l);
        boolean z5 = com.igexin.push.core.e.J != zB;
        if (z5) {
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.J != zB) {
                com.igexin.push.core.e.J = zB ? 1 : 0;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass17(), false, true);
            }
        }
        boolean z6 = com.igexin.push.core.e.aM;
        com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z2 + ", isDeviceTokenDiff = " + z3 + ", isCidDiff = " + z4 + ", isNotificationEnableDiff= " + z5, new Object[0]);
        if (com.igexin.push.core.e.aM || z2 || z3 || z4 || z5) {
            com.igexin.push.core.a.b.d().i();
        }
        com.igexin.push.core.c.a.a();
        com.igexin.push.core.c.a.b();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass1(), false, true);
        if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = com.igexin.push.core.b.W;
        messageObtain.obj = new Object();
        com.igexin.push.core.d.a.f37984a.a(messageObtain);
        GTBoater.getInstance().initialize();
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
        }
    }

    private static void e() {
        long jCurrentTimeMillis = System.currentTimeMillis() - com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new Object[0]);
        boolean z = jCurrentTimeMillis - 86400000 > 0;
        boolean z2 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z3 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        boolean zB = com.igexin.push.g.c.b(com.igexin.push.core.e.l);
        boolean z4 = com.igexin.push.core.e.J != zB;
        if (z4) {
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.J != zB) {
                com.igexin.push.core.e.J = zB ? 1 : 0;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass17(), false, true);
            }
        }
        boolean z5 = com.igexin.push.core.e.aM;
        com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + z3 + ", isNotificationEnableDiff= " + z4, new Object[0]);
        if (com.igexin.push.core.e.aM || z || z2 || z3 || z4) {
            com.igexin.push.core.a.b.d().i();
        }
    }

    private static void f() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
        com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
        com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new Object[0]);
        com.igexin.push.core.e.f.a().b();
        k.a();
        k.c();
    }

    private static void g() {
        if (com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            return;
        }
        com.igexin.push.core.e.B = com.igexin.push.core.e.A;
    }

    private void h() {
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (obj instanceof com.igexin.push.d.c.k) {
            com.igexin.push.core.e.b(0L);
            if (!com.igexin.push.core.e.u) {
                com.igexin.push.c.c.a().d().e();
                if (((com.igexin.push.d.c.k) obj).b) {
                    com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
                    com.igexin.push.d.c cVar = com.igexin.push.d.c.b.f38095a;
                    cVar.c = System.currentTimeMillis();
                    if (cVar.b) {
                        com.igexin.c.a.c.a.a(com.igexin.push.d.c.f38093a, "loginRsp| enter polling");
                        cVar.e = new com.igexin.push.d.e();
                        com.igexin.push.f.b.d.a.f38124a.g();
                        cVar.d = 0;
                    } else {
                        cVar.b();
                    }
                    String str = com.igexin.push.core.e.A;
                    boolean z = com.igexin.push.core.e.v;
                    com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new Object[0]);
                    StringBuilder sb = new StringBuilder("isCidBroadcasted|");
                    sb.append(com.igexin.push.core.e.v);
                    com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                    if (!com.igexin.push.core.e.v) {
                        l.a().c();
                        com.igexin.push.core.e.v = true;
                    }
                    com.igexin.push.core.e.u = true;
                    j.g();
                    l.a().b();
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.g();
                    if (TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                        com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new Object[0]);
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.h();
                    }
                    com.igexin.push.core.c.a.a().a(true);
                    long jCurrentTimeMillis = System.currentTimeMillis() - com.igexin.push.core.e.Q;
                    com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new Object[0]);
                    boolean z2 = jCurrentTimeMillis - 86400000 > 0;
                    boolean z3 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
                    boolean z4 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
                    boolean zB = com.igexin.push.g.c.b(com.igexin.push.core.e.l);
                    boolean z5 = com.igexin.push.core.e.J != zB;
                    if (z5) {
                        com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                        if (com.igexin.push.core.e.J != zB) {
                            com.igexin.push.core.e.J = zB ? 1 : 0;
                            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass17(), false, true);
                        }
                    }
                    boolean z6 = com.igexin.push.core.e.aM;
                    com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z2 + ", isDeviceTokenDiff = " + z3 + ", isCidDiff = " + z4 + ", isNotificationEnableDiff= " + z5, new Object[0]);
                    if (com.igexin.push.core.e.aM || z2 || z3 || z4 || z5) {
                        com.igexin.push.core.a.b.d().i();
                    }
                    com.igexin.push.core.c.a.a();
                    com.igexin.push.core.c.a.b();
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass1(), false, true);
                    if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
                        com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                    }
                    Message messageObtain = Message.obtain();
                    messageObtain.what = com.igexin.push.core.b.W;
                    messageObtain.obj = new Object();
                    com.igexin.push.core.d.a.f37984a.a(messageObtain);
                    GTBoater.getInstance().initialize();
                    if (com.igexin.assist.sdk.a.a().c()) {
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), false, true);
                    }
                } else {
                    com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
                    com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
                    com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new Object[0]);
                    com.igexin.push.core.e.f.a().b();
                    k.a();
                    k.c();
                }
            }
        }
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
