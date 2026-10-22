package com.igexin.sdk.main;

import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a;
import com.igexin.push.core.b.n;
import com.igexin.push.core.d;
import com.igexin.push.core.e;
import com.igexin.push.d.c.b;
import com.igexin.push.extension.mod.PushTaskBean;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class FeedbackImpl {
    private static final String TAG = "FeedbackImpl";
    public static volatile FeedbackImpl instance;

    private FeedbackImpl() {
    }

    public static FeedbackImpl getInstance() {
        if (instance == null) {
            synchronized (FeedbackImpl.class) {
                if (instance == null) {
                    instance = new FeedbackImpl();
                }
            }
        }
        return instance;
    }

    public void asyncFeedback(Runnable runnable) {
        a.a().a(TAG).execute(runnable);
    }

    public void clearFeedbackMessage() {
        int i = e.am - 100;
        if (i < 0) {
            i = 0;
        }
        e.am = i;
        int i2 = e.am;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> it = e.al.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            next.getKey();
            if (jCurrentTimeMillis - next.getValue().longValue() > 3600000) {
                it.remove();
            }
        }
    }

    public void feedbackMessageAction(PushTaskBean pushTaskBean, String str) {
        feedbackMessageAction(pushTaskBean, str, "ok");
    }

    public void feedbackMessageAction(PushTaskBean pushTaskBean, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "pushmessage_feedback");
            jSONObject.put("appid", pushTaskBean.getAppid());
            jSONObject.put("id", String.valueOf(jCurrentTimeMillis));
            jSONObject.put("appkey", pushTaskBean.getAppKey());
            jSONObject.put("messageid", pushTaskBean.getMessageId());
            jSONObject.put("taskid", pushTaskBean.getTaskId());
            jSONObject.put("actionid", str);
            jSONObject.put("result", str2);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        String string = jSONObject.toString();
        b bVar = new b();
        bVar.c = 128;
        bVar.b = (int) jCurrentTimeMillis;
        bVar.e = com.igexin.push.core.b.O;
        bVar.f = string;
        bVar.h = e.A;
        com.igexin.push.core.e.e.a().b(new n(jCurrentTimeMillis, string, (byte) 3, e.u ? jCurrentTimeMillis : 0L));
        if (d.a.f37984a.h != null) {
            d.a.f37984a.h.a("C-" + e.A, bVar, false);
        }
        com.igexin.c.a.c.a.a("feedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str, new Object[0]);
    }

    public void feedbackMultiBrandMessageAction(PushTaskBean pushTaskBean, String str) {
        feedbackMessageAction(pushTaskBean, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE.concat(String.valueOf(str)), "ok");
    }

    public void feedbackMultiBrandMessageAction(JSONObject jSONObject, String str) {
        try {
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.parse(jSONObject);
            feedbackMultiBrandMessageAction(pushTaskBean, str);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
