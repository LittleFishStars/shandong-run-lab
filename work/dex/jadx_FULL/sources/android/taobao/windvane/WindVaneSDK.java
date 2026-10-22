package android.taobao.windvane;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.taobao.windvane.base.IBridgeDelegateService;
import android.taobao.windvane.base.IUCService;
import android.taobao.windvane.base.l;
import android.taobao.windvane.base.m;
import android.taobao.windvane.config.EnvEnum;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVAppParams;
import android.taobao.windvane.jsbridge.service.WVBridgeDelegateImpl;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WindVaneSDK {
    private static final String SPNAME_ENV = "wv_evn";
    private static final String VALUE_NAME = "evn_value";
    private static boolean initialized = false;

    public static class ServiceBuilder {
        public void init(Context context, WVAppParams wVAppParams) {
            WindVaneSDK.init(context, wVAppParams);
        }

        public ServiceBuilder register(Class cls, Class cls2) {
            m.a().a(cls, cls2);
            return this;
        }

        public ServiceBuilder registerObj(Class cls, Object obj) {
            m.a().a((Class<?>) cls, obj);
            return this;
        }

        public ServiceBuilder setEnvMode(EnvEnum envEnum) {
            WindVaneSDK.setEnvMode(envEnum);
            return this;
        }
    }

    @Deprecated
    public static void init(Context context, WVAppParams wVAppParams) {
        init(context, null, 0, wVAppParams);
    }

    private static void initService() {
        m.a().a(IBridgeDelegateService.class, WVBridgeDelegateImpl.class);
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static void openLog(boolean z) {
        TaoLog.setLogSwitcher(z);
    }

    public static void setEnvMode(EnvEnum envEnum) {
        if (envEnum != null) {
            try {
                TaoLog.i(SPNAME_ENV, "setEnvMode : " + envEnum.getValue());
                GlobalConfig.env = envEnum;
                if (ConfigStorage.getLongVal(SPNAME_ENV, VALUE_NAME) == envEnum.getKey()) {
                    return;
                }
                android.taobao.windvane.base.b bVar = (android.taobao.windvane.base.b) m.a().b(android.taobao.windvane.base.b.class);
                if (bVar != null) {
                    bVar.a();
                    bVar.a(1);
                }
                ConfigStorage.putLongVal(SPNAME_ENV, VALUE_NAME, envEnum.getKey());
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public static void init(Context context, String str, int i, WVAppParams wVAppParams) {
        init(context, str, wVAppParams);
    }

    @Deprecated
    public static void init(Context context, String str, WVAppParams wVAppParams) {
        if (initialized) {
            TaoLog.i("WindVaneSDK", "WindVaneSDK has already initialized");
            return;
        }
        TaoLog.i("WindVaneSDK", "WindVaneSDK initApi");
        if (context != null) {
            Application application = (Application) (context instanceof Application ? context : context.getApplicationContext());
            GlobalConfig.context = application;
            if (application != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        String processName = CommonUtils.getProcessName();
                        if (!TextUtils.isEmpty(processName)) {
                            WebView.setDataDirectorySuffix(processName);
                        }
                    }
                } catch (Throwable unused) {
                }
                initService();
                if (EnvUtil.isAppDebug()) {
                    TaoLog.setLogSwitcher(true);
                }
                b.a(context);
                IUCService iUCService = (IUCService) m.a().b(IUCService.class);
                if (iUCService != null) {
                    String strUnZipCore = iUCService.unZipCore();
                    if (!TextUtils.isEmpty(strUnZipCore)) {
                        wVAppParams.ucLibDir = strUnZipCore;
                    }
                }
                GlobalConfig.getInstance().initParams(wVAppParams);
                ConfigStorage.initDirs();
                if (iUCService != null) {
                    iUCService.initUCCore();
                }
                l lVar = (l) m.a().b(l.class);
                if (lVar != null) {
                    lVar.a(context);
                }
                android.taobao.windvane.base.a aVar = (android.taobao.windvane.base.a) m.a().b(android.taobao.windvane.base.a.class);
                if (aVar != null) {
                    aVar.a();
                }
                initialized = true;
                return;
            }
            throw new IllegalArgumentException("initApi error, context should be Application or its subclass");
        }
        throw new NullPointerException("initApi error, context is null");
    }
}
