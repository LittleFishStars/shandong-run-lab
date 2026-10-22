package com.beizi.fusion;

import android.content.Context;
import com.opos.mobae.base.api.MobAEManager;
import com.opos.mobae.base.api.params.ClientTokenSupportHelper;
import com.opos.mobae.base.api.params.InitConfig;
import com.opos.mobae.dp.api.DpManager;
import com.opos.mobae.dp.api.params.IOpenDpListener;
import com.opos.mobae.dp.api.params.OpenDpRequest;
import com.opos.mobae.dp.api.params.OpenDpResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class zh {

    public class a implements IOpenDpListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m1 f28105a;

        public a(m1 m1Var) {
            this.f28105a = m1Var;
        }

        public void onResult(OpenDpResult openDpResult) {
            if (openDpResult != null) {
                if (openDpResult.getCode() == 0) {
                    m1 m1Var = this.f28105a;
                    if (m1Var != null) {
                        m1Var.a();
                        return;
                    }
                    return;
                }
                m1 m1Var2 = this.f28105a;
                if (m1Var2 != null) {
                    m1Var2.b();
                }
            }
        }
    }

    public void a(Context context, boolean z) {
        MobAEManager.getInstance().init(context.getApplicationContext(), new InitConfig.Builder().build());
    }

    public boolean b() {
        try {
            Class.forName("com.opos.mobae.base.api.MobAEManager");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(String str, String str2, String str3, m1 m1Var) {
        try {
            DpManager.getInstance().openDeepLink(new OpenDpRequest.Builder().setDeepLinkUrl(str).setTokenInfo(str2).setReqId(str3).build(), new a(m1Var));
        } catch (Exception unused) {
            if (m1Var != null) {
                m1Var.b();
            }
        }
    }

    public String a() {
        try {
            return new ClientTokenSupportHelper().putClientTokenSupportInfo(DpManager.getInstance().getClientTokenSupportInfo()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
