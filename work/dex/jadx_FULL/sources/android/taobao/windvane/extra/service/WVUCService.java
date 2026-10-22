package android.taobao.windvane.extra.service;

import android.content.Context;
import android.taobao.windvane.base.IUCService;
import android.taobao.windvane.base.m;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.uc.UCCoreStartup;
import android.taobao.windvane.extra.uc.UCSoInjectManager;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.uc.UCSoSettings;
import com.uc.webview.export.extension.UCCore;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVUCService implements IUCService<android.taobao.windvane.extra.core.b> {
    private android.taobao.windvane.base.b configService;
    protected Context context;
    private android.taobao.windvane.extra.core.b paramData;
    protected boolean useSystemCore = false;

    public WVUCService(Context context) {
        this.context = context;
    }

    @Override // android.taobao.windvane.base.IUCService
    public int getCorePolicy() {
        if (this.configService == null) {
            this.configService = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
        }
        android.taobao.windvane.base.b bVar = this.configService;
        if (bVar != null) {
            return bVar.c().initUCCorePolicy;
        }
        return 1;
    }

    @Override // android.taobao.windvane.base.IUCService
    public int gpuMultiType() {
        return 0;
    }

    @Override // android.taobao.windvane.base.IUCService
    public void initSW() {
    }

    @Override // android.taobao.windvane.base.IUCService
    public void initUCCore() {
        UCCoreStartup.getInstance().initPreprocess();
        if (TextUtils.equals("true", UCSoSettings.getInstance().UC_CORE_THICK)) {
            TaoLog.i("WVCore", "厚集成先注入so路径");
            if (UCSoInjectManager.getInstance().inject(this.context)) {
                GlobalConfig.getInstance().setInjectCode(1);
            }
        }
        WVCore.c().initUCCore();
    }

    @Override // android.taobao.windvane.base.IUCService
    public boolean isUCSupport() {
        return WVCore.c().e();
    }

    @Override // android.taobao.windvane.base.IUCService
    public boolean open4GDownload() {
        return false;
    }

    @Override // android.taobao.windvane.base.IUCService
    public int renderMultiType() {
        return 0;
    }

    @Override // android.taobao.windvane.base.IUCService
    public void setCoreType(boolean z) {
        TaoLog.i("WVCore", Log.getStackTraceString(new Throwable("set core type")));
        this.useSystemCore = z;
    }

    @Override // android.taobao.windvane.base.IUCService
    @Deprecated
    public String unZipCore() {
        return "";
    }

    @Override // android.taobao.windvane.base.IUCService
    public void updateConfig(android.taobao.windvane.extra.core.b bVar) {
    }

    @Override // android.taobao.windvane.base.IUCService
    public void updateCore(Context context, String str) {
        if (WVCore.c().b().equals(str)) {
            return;
        }
        UCCore.update(GlobalConfig.context, str, new WVCore.c());
    }

    @Override // android.taobao.windvane.base.IUCService
    public boolean useSystemCore(Context context) {
        return this.useSystemCore;
    }
}
