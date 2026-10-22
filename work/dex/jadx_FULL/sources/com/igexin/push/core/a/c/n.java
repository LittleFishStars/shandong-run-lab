package com.igexin.push.core.a.c;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.b.v;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class n implements PushMessageInterface {
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        String str = ((v) baseActionBean).f37974a;
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("\\|");
            Intent intent = new Intent();
            intent.setPackage(com.igexin.push.core.e.g);
            for (String str2 : strArrSplit) {
                if (com.igexin.push.core.b.j.equals(str2)) {
                    com.igexin.push.core.d.b.d().b();
                } else {
                    intent.setAction("com.igexin.sdk.action.updatedconfig." + str2);
                    com.igexin.push.core.e.l.sendBroadcast(intent, com.igexin.push.core.e.ac);
                }
            }
        }
        if (baseActionBean.getDoActionId().equals("")) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            v vVar = new v();
            vVar.setType(com.igexin.push.core.b.t);
            vVar.setActionId(jSONObject.getString("actionid"));
            vVar.setDoActionId(jSONObject.getString("do"));
            vVar.f37974a = jSONObject.getString("module");
            return vVar;
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
