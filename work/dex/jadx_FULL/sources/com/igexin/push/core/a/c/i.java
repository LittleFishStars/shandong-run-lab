package com.igexin.push.core.a.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.base.util.CommonUtil;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PopupActivity;
import com.igexin.sdk.message.GTPopupMessage;
import com.igexin.sdk.router.TransferGtcProcess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37944a = "PopupAction";
    private long b = 0;

    public static HashMap<String, Object> a(Context context) {
        try {
            return CommonUtil.isMainProcess() ? com.igexin.push.g.d.a() : (HashMap) TransferGtcProcess.getInstance().transferGtcProcess(context, new Intent(), TransferGtcProcess.POPUACTION_METHODNAME).getSerializable("map");
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new HashMap<>();
        }
    }

    private void a(com.igexin.push.core.b.m.b bVar, ConcurrentHashMap<String, Object> concurrentHashMap) {
        String str = bVar.h;
        if (!TextUtils.isEmpty(str) && !com.igexin.push.a.e.a(str)) {
            concurrentHashMap.put(str, new Object());
        }
        String str2 = bVar.j;
        if (!TextUtils.isEmpty(str2) && !com.igexin.push.a.e.a(str2)) {
            concurrentHashMap.put(str2, new Object());
        }
        ArrayList<com.igexin.push.core.b.m.b> arrayList = bVar.g;
        if (arrayList != null) {
            Iterator<com.igexin.push.core.b.m.b> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next(), concurrentHashMap);
            }
        }
    }

    public static /* synthetic */ void a(PushTaskBean pushTaskBean) {
        boolean zIsAppForeground = CommonUtil.isAppForeground();
        boolean z = !com.igexin.push.a.g.f37866a && zIsAppForeground;
        HashMap<String, Object> mapA = a(com.igexin.push.core.e.l);
        boolean zBooleanValue = ((Boolean) mapA.get("isPause")).booleanValue();
        boolean z2 = ((Boolean) mapA.get("isTranslucent")).booleanValue() && ((Integer) ServiceManager.getInstance().initType.first).equals(0);
        if (!z || zBooleanValue || z2) {
            com.igexin.c.a.c.a.b(f37944a, "has one popup = " + com.igexin.push.a.g.f37866a + " , appForeground = " + zIsAppForeground + " , is guardAndTranslucent = " + z2 + " , has Translucent popu " + zBooleanValue);
            return;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(com.igexin.push.core.b.ah, pushTaskBean.getTaskId());
        Map<String, PushTaskBean> map = com.igexin.push.core.e.ah;
        com.igexin.push.core.a.b.d();
        PushTaskBean pushTaskBean2 = map.get(com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId()));
        if (pushTaskBean2 != null) {
            pushTaskBean2.setStatus(com.igexin.push.core.b.ah);
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), "1");
    }

    private void a(final ConcurrentHashMap<String, Object> concurrentHashMap, final PushTaskBean pushTaskBean) {
        for (final String str : concurrentHashMap.keySet()) {
            com.igexin.push.a.e.a(str, new com.igexin.push.a.e.a<byte[]>() { // from class: com.igexin.push.core.a.c.i.1
                private void a() {
                    concurrentHashMap.remove(str);
                    if (concurrentHashMap.isEmpty()) {
                        i.a(pushTaskBean);
                    }
                }

                @Override // com.igexin.push.a.e.a
                public final /* synthetic */ void a(byte[] bArr) {
                    concurrentHashMap.remove(str);
                    if (concurrentHashMap.isEmpty()) {
                        i.a(pushTaskBean);
                    }
                }

                @Override // com.igexin.push.a.e.a
                public final void a(Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            });
        }
    }

    private static void b(PushTaskBean pushTaskBean) {
        boolean zIsAppForeground = CommonUtil.isAppForeground();
        boolean z = !com.igexin.push.a.g.f37866a && zIsAppForeground;
        HashMap<String, Object> mapA = a(com.igexin.push.core.e.l);
        boolean zBooleanValue = ((Boolean) mapA.get("isPause")).booleanValue();
        boolean z2 = ((Boolean) mapA.get("isTranslucent")).booleanValue() && ((Integer) ServiceManager.getInstance().initType.first).equals(0);
        if (!z || zBooleanValue || z2) {
            com.igexin.c.a.c.a.b(f37944a, "has one popup = " + com.igexin.push.a.g.f37866a + " , appForeground = " + zIsAppForeground + " , is guardAndTranslucent = " + z2 + " , has Translucent popu " + zBooleanValue);
            return;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(com.igexin.push.core.b.ah, pushTaskBean.getTaskId());
        Map<String, PushTaskBean> map = com.igexin.push.core.e.ah;
        com.igexin.push.core.a.b.d();
        PushTaskBean pushTaskBean2 = map.get(com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId()));
        if (pushTaskBean2 != null) {
            pushTaskBean2.setStatus(com.igexin.push.core.b.ah);
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), "1");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        if (pushTaskBean == null || baseActionBean == null) {
            return false;
        }
        com.igexin.push.core.b.m mVar = (com.igexin.push.core.b.m) baseActionBean;
        mVar.e = pushTaskBean.getAppid();
        mVar.f = pushTaskBean.getMessageId();
        mVar.g = pushTaskBean.getTaskId();
        mVar.h = pushTaskBean.getAppKey();
        Intent intent = new Intent(com.igexin.push.core.e.l, (Class<?>) PopupActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, mVar);
        intent.putExtras(bundle);
        intent.setFlags(343932928);
        intent.putExtra("action", com.igexin.push.core.b.r);
        com.igexin.push.core.e.l.startActivity(intent);
        com.igexin.c.a.c.a.b(f37944a, "startActivity PopuAction");
        if (mVar.getDoActionId() == null) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), mVar.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        float f;
        float f2;
        try {
            com.igexin.push.core.b.m mVar = new com.igexin.push.core.b.m();
            mVar.setType(com.igexin.push.core.b.r);
            mVar.setActionId(jSONObject.optString("actionid"));
            mVar.setDoActionId(jSONObject.optString("do"));
            JSONObject jSONObject2 = new JSONObject(com.igexin.push.config.f.a(jSONObject.optString("body")));
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("statisticsInfo");
            if (jSONObjectOptJSONObject != null) {
                mVar.c = jSONObjectOptJSONObject.optString("planName", "");
                mVar.d = jSONObjectOptJSONObject.optString("nodeName", "");
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("properties");
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("baseWidth");
                String strOptString2 = jSONObjectOptJSONObject2.optString("baseHeight");
                f = Float.parseFloat(strOptString.substring(0, strOptString.length() - 2));
                f2 = Float.parseFloat(strOptString2.substring(0, strOptString2.length() - 2));
            } else {
                f = 1.0f;
                f2 = 1.0f;
            }
            mVar.i = jSONObject2.optString("showActionId", "");
            mVar.f37963a = new com.igexin.push.core.b.m.b(jSONObject2.optJSONObject("mask"), mVar.c, mVar.d, f, f2);
            mVar.b = new com.igexin.push.core.b.m.b(jSONObject2.optJSONObject("template"), mVar.c, mVar.d, f, f2);
            GTPopupMessage.EventProperties eventProperties = new GTPopupMessage.EventProperties(mVar.c, mVar.d, "", "");
            GTPopupMessage gTPopupMessage = new GTPopupMessage();
            gTPopupMessage.setEventProperties(eventProperties);
            mVar.j = gTPopupMessage;
            return mVar;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        boolean zIsAppForeground = CommonUtil.isAppForeground();
        boolean z = (baseActionBean instanceof com.igexin.push.core.b.m) && !com.igexin.push.a.g.f37866a && zIsAppForeground;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = jCurrentTimeMillis - this.b > 1000;
        HashMap<String, Object> mapA = a(com.igexin.push.core.e.l);
        boolean zBooleanValue = ((Boolean) mapA.get("isPause")).booleanValue();
        boolean z3 = ((Boolean) mapA.get("isTranslucent")).booleanValue() && ((Integer) ServiceManager.getInstance().initType.first).equals(0);
        if (z && z2 && !zBooleanValue && !z3) {
            this.b = jCurrentTimeMillis;
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            a(((com.igexin.push.core.b.m) baseActionBean).b, concurrentHashMap);
            if (concurrentHashMap.size() <= 0) {
                return PushMessageInterface.ActionPrepareState.success;
            }
            a(concurrentHashMap, pushTaskBean);
            return PushMessageInterface.ActionPrepareState.wait;
        }
        com.igexin.c.a.c.a.b(f37944a, "has one popup = " + com.igexin.push.a.g.f37866a + " , appForeground = " + zIsAppForeground + " , is guardAndTranslucent = " + z3 + " ,overLimitTime = " + z2 + " , has Translucent popu " + zBooleanValue);
        return PushMessageInterface.ActionPrepareState.stop;
    }
}
