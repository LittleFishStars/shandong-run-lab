package com.efs.sdk.base.core.config.remote;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.p3;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.kc.openset.advertisers.hl.HLADNID;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements IConfigRefreshAction {

    /* JADX INFO: renamed from: com.efs.sdk.base.core.config.remote.a$a, reason: collision with other inner class name */
    public static class C0620a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f29590a = new a();
    }

    public static a a() {
        return C0620a.f29590a;
    }

    @Override // com.efs.sdk.base.IConfigRefreshAction
    @NonNull
    public final String refresh() {
        String str = "";
        if (!NetworkUtil.isConnected(ControllerCenter.getGlobalEnvStruct().mAppContext)) {
            Log.i("efs.config", "Config refresh fail, network is disconnected.");
            return "";
        }
        String strA = b.a().a(true);
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        for (int i = 0; i < 3; i++) {
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            String strB = cVarA.b();
            if (aVarA.f29559a) {
                Log.i("efs.px.api", "get config from server, wpkHeader is ".concat(String.valueOf(strB)));
            }
            String str2 = strA + "/apm_cc";
            if (aVarA.f29559a) {
                Log.i("efs.px.api", "get config from server, url is ".concat(String.valueOf(str2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.c cVarA2 = new com.efs.sdk.base.core.util.a.d(str2).a(map).a(com.efs.sdk.base.core.a.b.a()).a();
            cVarA2.f29614a.e = p3.f;
            HttpResponse httpResponseA = cVarA2.a();
            if (httpResponseA.succ) {
                str = httpResponseA.data;
                break;
            }
            if (TextUtils.isEmpty(httpResponseA.getBizCode()) || !HLADNID.Reason.OTHER.equals(httpResponseA.getBizCode())) {
                return "";
            }
        }
        Log.i("efs.config", "config request succ, config is:\n ".concat(String.valueOf(str)));
        return str;
    }
}
