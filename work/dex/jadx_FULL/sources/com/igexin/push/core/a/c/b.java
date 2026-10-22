package com.igexin.push.core.a.c;

import com.getui.gtc.api.GtcManager;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37937a = "CleanExtAction";

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        com.igexin.push.core.b.g gVar;
        int[] iArr;
        if (pushTaskBean != null && baseActionBean != null && (iArr = (gVar = (com.igexin.push.core.b.g) baseActionBean).f37957a) != null && iArr.length > 0) {
            Arrays.toString(iArr);
            GtcManager.getInstance().removeExt(com.igexin.push.core.b.j, gVar.f37957a);
        }
        if ("".equals(baseActionBean.getDoActionId())) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        if (!jSONObject.has("ids")) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.getString("ids"));
            if (jSONArray.length() <= 0) {
                return null;
            }
            int[] iArr = new int[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                iArr[i] = jSONArray.getInt(i);
            }
            com.igexin.push.core.b.g gVar = new com.igexin.push.core.b.g();
            gVar.setType(com.igexin.push.core.b.w);
            gVar.f37957a = iArr;
            gVar.setActionId(jSONObject.getString("actionid"));
            gVar.setDoActionId(jSONObject.getString("do"));
            return gVar;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }
}
