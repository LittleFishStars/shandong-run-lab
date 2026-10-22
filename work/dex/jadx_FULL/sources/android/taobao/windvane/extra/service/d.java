package android.taobao.windvane.extra.service;

import android.taobao.windvane.base.IUCService;
import android.taobao.windvane.base.m;
import android.taobao.windvane.config.GlobalConfig;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class d extends b {
    private IUCService b = (IUCService) m.a().b(IUCService.class);
    private int c;

    @Override // android.taobao.windvane.extra.service.b
    public boolean a() {
        return this.f21236a;
    }

    @Override // android.taobao.windvane.extra.service.b
    public int b() {
        this.c = 70;
        IUCService iUCService = this.b;
        if (iUCService == null || !iUCService.isUCSupport()) {
            IUCService iUCService2 = this.b;
            if (iUCService2 != null && iUCService2.useSystemCore(null)) {
                this.c = 71;
            }
        } else {
            this.c = this.f21236a ? 6 : 5;
        }
        return this.c;
    }

    @Override // android.taobao.windvane.extra.service.b
    public void a(boolean z, String str) {
        super.a(z, str);
        if (WebView.getCoreType() == 3 && z) {
            UCCore.setThirdNetwork(new android.taobao.windvane.extra.a.a(GlobalConfig.context, str), new android.taobao.windvane.extra.a.b());
        }
    }
}
