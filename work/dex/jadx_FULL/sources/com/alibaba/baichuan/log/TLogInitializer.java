package com.alibaba.baichuan.log;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.aliyun.tea.logging.DefaultLogger;
import com.zj.adlib.c49;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TLogInitializer {
    public static final String DEFAULT_DIR = "logs";
    public static final int INIT_END = 2;
    public static final int INIT_ING = 1;
    public static final int INIT_NO = 0;
    private static final String NAMEPREFIX = "TAOBAO";
    private static final String TAG = "TLOG.TLogInitializer";
    private String appId;
    private String appVersion;
    private String appkey;
    private Application application;
    private String authCode;
    private Context context;
    private boolean debugByUsr;
    private boolean isVersionUpdate;
    public File logDir;
    private LogLevel logLevel;
    private volatile int mInitState;
    private boolean mInitSync;
    private String mRandomSecret;
    private String namePrefix;
    private String packageName;
    private String processName;
    private boolean storeLogOnInternal;
    private String ttid;
    private String userNick;
    private String utdid;

    public static class SingletonHolder {
        private static final TLogInitializer INSTANCE = new TLogInitializer();

        private SingletonHolder() {
        }
    }

    public static TLogInitializer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static ITLogController getTLogControler() {
        return TLogController.getInstance();
    }

    public static String getUTDID() {
        return getInstance().utdid;
    }

    @TargetApi(8)
    public TLogInitializer builder(Context context, LogLevel logLevel, String str, String str2, String str3, String str4) {
        File dir;
        if (this.mInitState != 0) {
            return this;
        }
        this.logLevel = logLevel;
        this.context = context;
        this.appkey = str3;
        this.appVersion = str4;
        if (TextUtils.isEmpty(str2)) {
            str2 = NAMEPREFIX;
        }
        this.namePrefix = str2;
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_DIR;
        }
        if (this.storeLogOnInternal) {
            this.logDir = context.getDir(str, 0);
        } else {
            try {
                dir = context.getExternalFilesDir(str);
            } catch (Exception e) {
                e.printStackTrace();
                dir = null;
            }
            if (dir == null) {
                dir = context.getDir(str, 0);
            }
            this.logDir = dir;
        }
        return this;
    }

    public TLogInitializer changeRsaPublishKey(String str) {
        if (str != null) {
            TLogSecret.getInstance().setRsapublickey(str);
        }
        return this;
    }

    public String getAppId() {
        if (this.appId == null) {
            this.appId = this.appkey + "@android";
        }
        return this.appId;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public Application getApplication() {
        return this.application;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public Context getContext() {
        return this.context;
    }

    public String getFileDir() {
        return this.logDir.getAbsolutePath();
    }

    public int getInitState() {
        return this.mInitState;
    }

    public String getNameprefix() {
        return this.namePrefix;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getSecurityKey() {
        return this.mRandomSecret;
    }

    public String getTtid() {
        return this.ttid;
    }

    public String getUserNick() {
        return this.userNick;
    }

    public TLogInitializer init() {
        String string;
        if (this.mInitState != 0) {
            return this;
        }
        this.mInitState = 1;
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            if (defaultSharedPreferences.contains(TLogConstant.REMOTE_DEBUGER_LOG_VERSION) && (string = defaultSharedPreferences.getString(TLogConstant.REMOTE_DEBUGER_LOG_VERSION, null)) != null && string.equals(this.appVersion)) {
                this.isVersionUpdate = false;
            } else {
                this.isVersionUpdate = true;
            }
            if (defaultSharedPreferences.contains(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL) && !this.isVersionUpdate) {
                this.logLevel = TLogUtils.convertLogLevel(defaultSharedPreferences.getString(TLogConstant.REMOTE_DEBUGER_LOG_LEVEL, DefaultLogger.ERROR));
                TLogController.getInstance().updateLogLevel(this.logLevel);
            }
            if (defaultSharedPreferences.contains(TLogConstant.REMOTE_DEBUGER_LOG_MODULE) && !this.isVersionUpdate) {
                TLogController.getInstance().addModuleFilter(TLogUtils.makeModule(defaultSharedPreferences.getString(TLogConstant.REMOTE_DEBUGER_LOG_MODULE, null)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TLogNative.appenderOpen(this.logLevel.getIndex(), this.context.getFilesDir().getAbsolutePath() + File.separator + DEFAULT_DIR, this.logDir.getAbsolutePath(), this.namePrefix, this.appkey);
        if (TLogNative.isSoOpen()) {
            try {
                TLogNative.setConsoleLogOpen(false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        TLogController.getInstance().updateLogLevel(this.logLevel);
        this.mInitState = 2;
        TLog.loge("tlog", "init", "tlog init end !" + this.logLevel);
        if (!this.mInitSync) {
            TLogController.getInstance().updateAsyncConfig();
        }
        return this;
    }

    public boolean isInitSync() {
        return this.mInitSync;
    }

    public TLogInitializer setAppId(String str) {
        this.appId = str;
        return this;
    }

    public TLogInitializer setAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public TLogInitializer setApplication(Application application) {
        this.application = application;
        return this;
    }

    public TLogInitializer setAuthCode(String str) {
        this.authCode = str;
        return this;
    }

    public TLogInitializer setInitSync(boolean z) {
        this.mInitSync = z;
        return this;
    }

    public TLogInitializer setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public TLogInitializer setProcessName(String str) {
        this.processName = str;
        return this;
    }

    public TLogInitializer setSecurityKey(String str) {
        this.mRandomSecret = str;
        return this;
    }

    public TLogInitializer setTTid(String str) {
        this.ttid = str;
        return this;
    }

    public TLogInitializer setUserNick(String str) {
        this.userNick = str;
        return this;
    }

    public TLogInitializer setUtdid(String str) {
        this.utdid = str;
        return this;
    }

    public void updateLogLevel(String str) {
        try {
            this.logLevel = TLogUtils.convertLogLevel(str);
            TLogController.getInstance().setLogLevel(this.logLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TLogInitializer useDataStoreLog(boolean z) {
        this.storeLogOnInternal = z;
        return this;
    }

    private TLogInitializer() {
        this.packageName = "";
        this.appVersion = "";
        this.utdid = "bbbbbbbbbbbbbbbbb";
        this.ttid = c49.f40900a;
        this.userNick = "";
        this.logLevel = LogLevel.E;
        this.debugByUsr = false;
        this.mInitSync = false;
        this.mInitState = 0;
        this.isVersionUpdate = false;
        this.authCode = "";
        this.storeLogOnInternal = false;
    }
}
