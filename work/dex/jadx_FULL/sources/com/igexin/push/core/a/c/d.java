package com.igexin.push.core.a.c;

import com.igexin.push.core.e.f.AnonymousClass5;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f37939a = "BasicAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        long jCurrentTimeMillis = System.currentTimeMillis() + (((com.igexin.push.core.b.h) baseActionBean).f37958a * 1000);
        com.igexin.push.core.e.f.a().a(true);
        com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
        if (com.igexin.push.core.e.X != jCurrentTimeMillis) {
            com.igexin.push.core.e.X = jCurrentTimeMillis;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass5(), false, true);
        }
        if (!baseActionBean.getDoActionId().equals("")) {
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        }
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("duration")) {
                return null;
            }
            com.igexin.push.core.b.h hVar = new com.igexin.push.core.b.h();
            hVar.setType(jSONObject.getString("type"));
            hVar.setActionId(jSONObject.getString("actionid"));
            hVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("duration")) {
                hVar.f37958a = Long.valueOf(jSONObject.getString("duration")).longValue();
            }
            return hVar;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}
