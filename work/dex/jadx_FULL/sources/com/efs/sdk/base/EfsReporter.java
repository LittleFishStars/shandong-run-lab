package com.efs.sdk.base;

import android.app.Application;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.b.e;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.a;
import com.efs.sdk.base.custommapping.IUMPerfCallback;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class EfsReporter {
    private static ControllerCenter sControllerCenter;
    private static IUMPerfCallback sUMPerfCallback;
    private final String TAG;

    public static class Builder {
        private static Map<String, EfsReporter> sInstanceMap = new ConcurrentHashMap();
        private static boolean sUseAppContext = true;
        private final String TAG;
        private GlobalEnvStruct mGlobalEnvStruct;

        public interface IPublicParams {
            Map<String, String> getRecordHeaders();
        }

        public Builder(@NonNull Application application, @NonNull String str, @NonNull String str2) {
            this(application.getApplicationContext(), str, str2);
        }

        private static Context checkContext(Context context) {
            if (context == null) {
                Log.e("context can not be null!");
                throw null;
            }
            if (!sUseAppContext || (context instanceof Application) || ((context = context.getApplicationContext()) != null && (context instanceof Application))) {
                return context;
            }
            Log.e("Can not get Application context from given context!");
            throw new IllegalArgumentException("Can not get Application context from given context!");
        }

        private void checkParam(String str) {
            GlobalEnvStruct globalEnvStruct = sInstanceMap.get(str).getGlobalEnvStruct();
            if (!globalEnvStruct.mAppContext.equals(getGlobalEnvStruct().mAppContext)) {
                throw new RuntimeException("efs-core: duplicate init, but application context is different");
            }
            if (!TextUtils.isEmpty(globalEnvStruct.getSecret()) && !globalEnvStruct.getSecret().equals(getGlobalEnvStruct().getSecret())) {
                throw new RuntimeException("efs-core: duplicate init, but secret is different");
            }
            if (globalEnvStruct.isIntl() != getGlobalEnvStruct().isIntl()) {
                throw new RuntimeException("efs-core: duplicate init, but intl setting is different");
            }
            if (!TextUtils.isEmpty(getGlobalEnvStruct().getUid()) && !getGlobalEnvStruct().getUid().equals(globalEnvStruct.getUid())) {
                Log.w("efs.reporter.builder", "efs-core: duplicate init, but  uid is different");
            }
            if (getGlobalEnvStruct().getPublicParamMap() == null || getGlobalEnvStruct().getPublicParamMap().size() <= 0) {
                return;
            }
            globalEnvStruct.addPublicParams(getGlobalEnvStruct().getPublicParamMap());
        }

        public Builder addEfsReporterObserver(IEfsReporterObserver iEfsReporterObserver) {
            this.mGlobalEnvStruct.addConfigObserver(iEfsReporterObserver);
            return this;
        }

        public EfsReporter build() {
            String appid = getGlobalEnvStruct().getAppid();
            if (!sInstanceMap.containsKey(appid)) {
                synchronized (EfsReporter.class) {
                    if (!sInstanceMap.containsKey(appid)) {
                        EfsReporter efsReporter = new EfsReporter(this);
                        sInstanceMap.put(appid, efsReporter);
                        return efsReporter;
                    }
                }
            }
            Log.w("efs.reporter.builder", "efs-core: duplicate init");
            checkParam(appid);
            return sInstanceMap.get(appid);
        }

        public Builder configRefreshAction(@NonNull IConfigRefreshAction iConfigRefreshAction) {
            b.a().b = iConfigRefreshAction;
            return this;
        }

        public Builder configRefreshDelayMills(long j) {
            this.mGlobalEnvStruct.configRefreshDelayMills = j;
            return this;
        }

        public Builder debug(boolean z) {
            this.mGlobalEnvStruct.setDebug(z);
            return this;
        }

        public Builder efsDirRootName(String str) {
            a.a(str);
            return this;
        }

        public Builder enablePaBackup(boolean z) {
            this.mGlobalEnvStruct.setEnablePaBackup(z);
            return this;
        }

        public Builder enableSendLog(boolean z) {
            this.mGlobalEnvStruct.setEnableSendLog(z);
            return this;
        }

        public Builder enableWaStat(boolean z) {
            this.mGlobalEnvStruct.setEnableWaStat(z);
            return this;
        }

        public GlobalEnvStruct getGlobalEnvStruct() {
            return this.mGlobalEnvStruct;
        }

        public Builder intl(boolean z) {
            this.mGlobalEnvStruct.setIsIntl(z);
            return this;
        }

        public Builder logDid(String str) {
            this.mGlobalEnvStruct.setLogDid(str);
            return this;
        }

        public Builder logEncryptAction(ILogEncryptAction iLogEncryptAction) {
            this.mGlobalEnvStruct.setLogEncryptAction(iLogEncryptAction);
            return this;
        }

        public Builder logUid(String str) {
            this.mGlobalEnvStruct.setLogUid(str);
            return this;
        }

        public Builder maxConcurrentUploadCnt(int i) {
            e.a().f29566a = i;
            return this;
        }

        public Builder maxConcurrentUploadCntCodeLog(int i) {
            e.a().b = i;
            return this;
        }

        public Builder printLogDetail(boolean z) {
            this.mGlobalEnvStruct.setPrintLogDetail(z);
            return this;
        }

        public Builder publicParams(@NonNull IPublicParams iPublicParams) {
            if (iPublicParams.getRecordHeaders() != null && iPublicParams.getRecordHeaders().size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(iPublicParams.getRecordHeaders());
            }
            return this;
        }

        public Builder setOpenCodeLog(boolean z) {
            this.mGlobalEnvStruct.setOpenCodeLog(z);
            return this;
        }

        public Builder uid(String str) {
            this.mGlobalEnvStruct.setUid(str);
            return this;
        }

        public Builder(@NonNull Context context, @NonNull String str, @NonNull String str2) {
            this.TAG = "efs.reporter.builder";
            Context contextCheckContext = checkContext(context);
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("EfsReporter init, appid is empty");
            }
            if (TextUtils.isEmpty(str2)) {
                throw new RuntimeException("EfsReporter init, secret is empty");
            }
            GlobalEnvStruct globalEnvStruct = new GlobalEnvStruct();
            this.mGlobalEnvStruct = globalEnvStruct;
            globalEnvStruct.mAppContext = contextCheckContext;
            globalEnvStruct.setAppid(str);
            this.mGlobalEnvStruct.setSecret(str2);
        }

        public Builder publicParams(@NonNull Map<String, String> map) {
            if (map.size() > 0) {
                this.mGlobalEnvStruct.addPublicParams(map);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public GlobalEnvStruct getGlobalEnvStruct() {
        return ControllerCenter.getGlobalEnvStruct();
    }

    public static void registerPerfCallback(IUMPerfCallback iUMPerfCallback) {
        sUMPerfCallback = iUMPerfCallback;
    }

    public void addPublicParams(@NonNull Map<String, String> map) {
        if (map.size() > 0) {
            getGlobalEnvStruct().addPublicParams(map);
        }
    }

    public void flushRecordLogImmediately(String str) {
        CacheManager.getInstance().flushImmediately((byte) 1, str);
    }

    public Map<String, String> getAllConfig() {
        return b.a().c();
    }

    public void getAllSdkConfig(String[] strArr, IConfigCallback iConfigCallback) {
        b bVarA = b.a();
        bVarA.e.put(iConfigCallback, strArr);
        if (bVarA.d.mSDKConfigMap.isEmpty()) {
            return;
        }
        bVarA.d();
    }

    public void getAllSdkConfigFromServer(String[] strArr, IConfigCallback iConfigCallback) {
        b.a().f.put(iConfigCallback, strArr);
    }

    public Map<String, Object> getStrategyMap() {
        return new HashMap(b.a().d.mStrategyMap);
    }

    public void refreshConfig(String str) {
        b.a().a(str);
    }

    public void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        getGlobalEnvStruct().registerCallback(i, valueCallback);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    public void send(ILogProtocol iLogProtocol) {
        byte b;
        try {
            if (iLogProtocol instanceof EfsJSONLog) {
                String logType = iLogProtocol.getLogType();
                int iHashCode = logType.hashCode();
                if (iHashCode != -2128464309) {
                    if (iHashCode == 846000494 && logType.equals("powerperf")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (logType.equals(Constants.LOG_TYPE_STARTPERF)) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    IUMPerfCallback iUMPerfCallback = sUMPerfCallback;
                    if (iUMPerfCallback != null) {
                        iUMPerfCallback.onCallback(IUMPerfCallback.PerfType.PERF_TYPE_POWER);
                    }
                    ((EfsJSONLog) iLogProtocol).put("um_custom_mapping", InnerCustomMappingManager.getCustomMappingJsonStr());
                } else if (b == 1) {
                    IUMPerfCallback iUMPerfCallback2 = sUMPerfCallback;
                    if (iUMPerfCallback2 != null) {
                        iUMPerfCallback2.onCallback(IUMPerfCallback.PerfType.PERF_TYPE_START);
                    }
                    ((EfsJSONLog) iLogProtocol).put("um_custom_mapping", InnerCustomMappingManager.getCustomMappingJsonStr());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sControllerCenter.send(iLogProtocol);
    }

    public HttpResponse sendSyncImediatelly(String str, int i, String str2, File file) {
        return sendSyncImediatelly(str, i, str2, true, file);
    }

    public void setEnableRefreshConfigFromRemote(boolean z) {
        b.a().c = z;
    }

    public void setFileFilterCodeLog(IFileFilter iFileFilter) {
        e.a().d = iFileFilter;
    }

    private EfsReporter(Builder builder) {
        this.TAG = "efs.reporter";
        sControllerCenter = new ControllerCenter(builder);
    }

    public HttpResponse sendSyncImediatelly(String str, int i, String str2, boolean z, File file) {
        return sControllerCenter.sendSyncImmediately(str, i, str2, z, file);
    }

    public Map<String, Object> getAllSdkConfig() {
        return new HashMap(b.a().d.mSDKConfigMap);
    }
}
