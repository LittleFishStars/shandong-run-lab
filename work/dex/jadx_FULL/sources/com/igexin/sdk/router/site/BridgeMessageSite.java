package com.igexin.sdk.router.site;

import android.text.TextUtils;
import com.igexin.c.a.c.a;
import com.igexin.push.core.b;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.main.FeedbackImpl;
import com.igexin.sdk.router.boatman.receive.IBoatResult;
import com.igexin.sdk.router.boatman.receive.Site;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class BridgeMessageSite extends Site<JSONObject, JSONObject> {
    private static final String TAG = "BridgeMessageSite";

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public String getTag() {
        return "tag_feedback";
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public JSONObject onArrived(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a.a("BridgeMessageSiteboatman_feedback |" + jSONObject.toString(), new Object[0]);
        if (jSONObject.has("active")) {
            try {
                String string = jSONObject.getString("active");
                if (b.ay.equals(string)) {
                    String string2 = jSONObject.getString("doAction");
                    String string3 = jSONObject.getString("taskid");
                    String string4 = jSONObject.getString("messageid");
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(string3, string4, string2);
                } else if (b.az.equals(string)) {
                    PushTaskBean pushTaskBean = new PushTaskBean();
                    pushTaskBean.parse(jSONObject);
                    if (jSONObject.has("actionid") && !TextUtils.isEmpty(jSONObject.getString("actionid"))) {
                        if (jSONObject.has("result")) {
                            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, jSONObject.getString("actionid"), jSONObject.getString("result"));
                        } else {
                            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, jSONObject.getString("actionid"));
                        }
                    }
                }
            } catch (JSONException e) {
                a.a(e);
            }
        }
        return jSONObject;
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public void onArrived(JSONObject jSONObject, IBoatResult<JSONObject> iBoatResult) {
    }
}
