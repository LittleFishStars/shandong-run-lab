package com.alibaba.analytics.core.selfmonitor;

import android.text.TextUtils;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import com.alibaba.analytics.core.a.n;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.baichuan.log.TLogInitializer;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements com.alibaba.analytics.core.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f23784a = new d();

    public static d a() {
        return f23784a;
    }

    public void E() {
        com.alibaba.analytics.core.a.d.a().a("selfcheck", this);
    }

    public void J(String str) {
        File externalFilesDir = com.alibaba.analytics.core.d.a().getContext().getExternalFilesDir(TLogInitializer.DEFAULT_DIR);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "analytics.log");
            if (file.exists()) {
                file.delete();
            } else {
                try {
                    if (!externalFilesDir.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable unused) {
                j.e();
            }
        }
    }

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(final String str, final String str2) {
        j.e("SelfChecker", CachedContentIndex.a.e, str, "value", str2);
        x.a().schedule(null, new Runnable() { // from class: com.alibaba.analytics.core.selfmonitor.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.a(str, str2);
            }
        }, 5000L);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("current_time", "" + System.currentTimeMillis());
            jSONObject.put("is_init", "" + com.alibaba.analytics.core.d.a().m127n());
            jSONObject.put("sdk_version", "" + com.alibaba.analytics.b.a.a().E());
            jSONObject.put("appkey", "" + com.alibaba.analytics.core.d.a().getAppkey());
            jSONObject.put("secret", "" + com.alibaba.analytics.core.d.a().f());
            IUTRequestAuthentication iUTRequestAuthenticationM113a = com.alibaba.analytics.core.d.a().m113a();
            if (iUTRequestAuthenticationM113a == null) {
                jSONObject.put("security_mode", "-1");
            } else if (iUTRequestAuthenticationM113a instanceof UTBaseRequestAuthentication) {
                jSONObject.put("security_mode", "1");
            } else if (iUTRequestAuthenticationM113a instanceof UTSecuritySDKRequestAuthentication) {
                jSONObject.put("security_mode", "2");
            } else if (iUTRequestAuthenticationM113a instanceof UTSecurityThridRequestAuthentication) {
                jSONObject.put("security_mode", "3");
            }
            jSONObject.put("run_process", com.alibaba.analytics.a.a.getCurProcessName(com.alibaba.analytics.core.d.a().getContext()));
            jSONObject.put("ut_realtime_debug_switch", com.alibaba.analytics.core.d.a().m122k());
            jSONObject.put("ap_realtime_debug_switch", com.alibaba.analytics.core.d.a().m124l());
            jSONObject.put("ap_sampling_seed", com.alibaba.appmonitor.c.b.a().e());
            jSONObject.put("upload_interval", com.alibaba.analytics.core.sync.f.a().h());
            a(jSONObject, str2);
            boolean zU = com.alibaba.analytics.core.sync.e.a().u();
            jSONObject.put("upload_success", zU);
            jSONObject.put("upload_mode", com.alibaba.analytics.core.sync.f.a().m138a() + "");
            jSONObject.put("tnet_degrade", com.alibaba.analytics.core.d.a().m116h());
            if (!zU) {
                jSONObject.put("http_error_code", com.alibaba.analytics.core.sync.i.G);
            }
            List<? extends com.alibaba.analytics.core.b.b> listFind = com.alibaba.analytics.core.d.a().m112a().find(com.alibaba.analytics.core.a.j.class, null, null, -1);
            if (listFind != null) {
                for (int i = 0; i < listFind.size(); i++) {
                    com.alibaba.analytics.core.a.j jVar = (com.alibaba.analytics.core.a.j) listFind.get(i);
                    jSONObject.put("entity.getGroupname()" + jVar.p(), jVar.q());
                }
            }
        } catch (Throwable th) {
            try {
                jSONObject.put("resport_error", th.getLocalizedMessage() + "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        String string = jSONObject.toString();
        J(string);
        return string;
    }

    private void a(JSONObject jSONObject, String str) {
        String str2;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.alipay.sdk.m.m.b.m);
            String str3 = null;
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(RVParams.ANTI_PHISHING);
                if (jSONObjectOptJSONObject2 != null) {
                    strOptString4 = jSONObjectOptJSONObject2.optString("type");
                    strOptString3 = jSONObjectOptJSONObject2.optString("module");
                    strOptString = jSONObjectOptJSONObject2.optString(SQLiteMTAHelper.TABLE_POINT);
                } else {
                    strOptString = null;
                    strOptString4 = null;
                    strOptString3 = null;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("ut");
                if (jSONObjectOptJSONObject3 != null) {
                    String strOptString5 = jSONObjectOptJSONObject3.optString(com.heytap.mcssdk.constant.b.k);
                    String str4 = strOptString4;
                    strOptString2 = jSONObjectOptJSONObject3.optString("arg1");
                    str2 = strOptString5;
                    str3 = str4;
                } else {
                    str2 = null;
                    str3 = strOptString4;
                    strOptString2 = null;
                }
            } else {
                str2 = null;
                strOptString = null;
                strOptString2 = null;
                strOptString3 = null;
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString)) {
                jSONObject.put("ap_sampling_result", com.alibaba.appmonitor.c.b.a().b(EventType.getEventTypeByNameSpace(str3), strOptString3, strOptString));
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            HashMap map = new HashMap();
            map.put(LogField.EVENTID.toString(), str2);
            if (!TextUtils.isEmpty(strOptString2)) {
                map.put(LogField.ARG1.toString(), strOptString2);
            }
            jSONObject.put("ut_sampling_result", n.a().b(map));
        } catch (Throwable unused) {
        }
    }
}
