package com.kc.dw.core.webview.jsbridge;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.m0;
import com.kc.dw.core.utils.v;
import com.kc.dw.core.utils.z0;
import com.kc.dw.core.webview.jsbridge.bean.InvokeDeepLinkParam;
import com.kc.dw.platform.ad_adapter.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.core.webview.jsbridge.bean.a f39441a;
    public final c b;

    /* JADX INFO: renamed from: com.kc.dw.core.webview.jsbridge.a$a, reason: collision with other inner class name */
    @Keep
    public interface InterfaceC1052a {
        void a(int i, String str);
    }

    public a(c cVar) {
        this.b = cVar;
        if (cVar != null) {
            try {
                if (cVar.a() != null) {
                    Gson gson = v.f39411a;
                    this.f39441a = (com.kc.dw.core.webview.jsbridge.bean.a) gson.fromJson(gson.toJson(cVar.a()), com.kc.dw.core.webview.jsbridge.bean.a.class);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC1052a interfaceC1052a, boolean z) {
        int i;
        String str;
        if (z) {
            z0.a(this.f39441a, 23, 0, "js_dp_success");
            if (interfaceC1052a == null) {
                return;
            }
            i = 1000;
            str = "唤起成功";
        } else {
            if (interfaceC1052a == null) {
                return;
            }
            i = 1001;
            str = "唤起失败";
        }
        interfaceC1052a.a(i, str);
    }

    public void a(InvokeDeepLinkParam invokeDeepLinkParam, final InterfaceC1052a interfaceC1052a) {
        String string;
        try {
            if (TextUtils.isEmpty(invokeDeepLinkParam.getDeep_link())) {
                if (interfaceC1052a != null) {
                    interfaceC1052a.a(1002, "depp_link为空");
                    return;
                }
                return;
            }
            z0.a(this.f39441a, 22, 0, "js_dp_start");
            if (f.a(invokeDeepLinkParam.getDeep_link())) {
                this.f39441a.deep_link = invokeDeepLinkParam.getDeep_link();
                f.a(com.kc.dw.base.a.getContext(), this.f39441a, this.b, false, true, new m0.a(this, interfaceC1052a) { // from class: com.kc.dw.core.webview.jsbridge.a$$ExternalSyntheticLambda0
                    public final a f$0;
                    public final a.InterfaceC1052a f$1;

                    {
                        this.f$0 = this;
                        this.f$1 = interfaceC1052a;
                    }

                    @Override // com.kc.dw.core.utils.m0.a
                    public final void a(boolean z) {
                        this.f$0.a(this.f$1, z);
                    }
                });
            } else if (interfaceC1052a != null) {
                interfaceC1052a.a(1001, "唤起失败. 未安装");
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringBuilder sb = new StringBuilder();
            sb.append("未知错误:");
            try {
                string = e.toString();
            } catch (Exception unused) {
                string = "";
            }
            sb.append(string);
            String string2 = sb.toString();
            if (interfaceC1052a != null) {
                interfaceC1052a.a(1002, string2);
            }
        }
    }
}
