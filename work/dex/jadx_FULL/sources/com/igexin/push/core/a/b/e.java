package com.igexin.push.core.a.b;

import com.igexin.assist.action.MessageManger;
import com.igexin.push.d.c.n;
import com.igexin.sdk.main.FeedbackImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37930a = "PushMessageAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        byte[] bArr;
        try {
            n nVar = (n) obj;
            if (jSONObject.has("action") && jSONObject.getString("action").equals(com.igexin.push.core.b.E)) {
                Object obj2 = nVar.g;
                if (obj2 instanceof byte[]) {
                    try {
                        new String((byte[]) obj2, "UTF-8");
                    } catch (Exception e) {
                        com.igexin.c.a.c.a.a(f37930a + e.toString(), new Object[0]);
                    }
                    bArr = (byte[]) nVar.g;
                } else {
                    bArr = null;
                }
                String string = jSONObject.getString("taskid");
                com.igexin.c.a.c.a.a("getui receive message : %s", jSONObject);
                if (bArr == null || !com.igexin.assist.sdk.a.a().c()) {
                    com.igexin.push.core.n.a().a(jSONObject, bArr, true);
                } else {
                    com.igexin.push.core.e.d dVarA = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                    if (dVarA.a(string)) {
                        String str = string + "4051" + MessageManger.getInstance().getBrandCode();
                        if (!dVarA.a(str)) {
                            FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, "1" + MessageManger.getInstance().getBrandCode());
                            dVarA.b(str);
                        }
                    } else {
                        dVarA.b(string);
                        com.igexin.push.core.n.a().a(jSONObject, bArr, true);
                        FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, "10");
                    }
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageAction|" + e2.toString(), new Object[0]);
        }
        return true;
    }
}
