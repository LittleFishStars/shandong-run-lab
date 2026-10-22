package com.alibaba.baichuan.log;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TLogController implements ITLogController {
    private static final String TAG = "TLogController";
    private LogLevel logLevel;
    private Map<String, LogLevel> moduleFilter;

    public static class SingletonHolder {
        private static final TLogController INSTANCE = new TLogController();

        private SingletonHolder() {
        }
    }

    public static final TLogController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addModuleFilter(Map<String, LogLevel> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (String str : map.keySet()) {
            getInstance().addModuleFilter(str, map.get(str));
        }
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public boolean checkLogLength(String str) {
        return false;
    }

    public void cleanModuleFilter() {
        this.moduleFilter.clear();
    }

    public void closeLog() {
        if (TLogInitializer.getInstance().getInitState() == 2 && TLogNative.isSoOpen()) {
            try {
                TLogNative.setLogLevel(LogLevel.L.getIndex());
                TLogNative.appenderClose();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public String compress(String str) {
        return null;
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public void destroyLog(boolean z) {
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public byte[] ecrypted(byte[] bArr) {
        return new byte[0];
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public byte[] ecrypted(byte[] bArr, int i, int i2) {
        return new byte[0];
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public LogLevel getLogLevel(String str) {
        if (!TextUtils.isEmpty(str) && this.moduleFilter.get(str) != null) {
            return this.moduleFilter.get(str);
        }
        return this.logLevel;
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public boolean isFilter(LogLevel logLevel, String str) {
        LogLevel logLevel2 = this.logLevel;
        if (logLevel2 != null && logLevel != null && str != null) {
            if (logLevel2.getIndex() <= logLevel.getIndex()) {
                return true;
            }
            int iIndexOf = str.indexOf(Consts.DOT);
            if (iIndexOf >= 0 && iIndexOf < str.length()) {
                String strSubstring = str.substring(0, iIndexOf);
                if (!TextUtils.isEmpty(strSubstring) && this.moduleFilter.size() > 0 && this.moduleFilter.get(strSubstring) != null && this.moduleFilter.get(strSubstring).getIndex() <= logLevel.getIndex()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public boolean isOpenLog() {
        return true;
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public void openLog(boolean z) {
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    @Deprecated
    public void setEndTime(long j) {
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
        if (TLogInitializer.getInstance().getInitState() == 2 && TLogNative.isSoOpen()) {
            try {
                TLogNative.setLogLevel(logLevel.getIndex());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public void setModuleFilter(Map<String, LogLevel> map) {
        addModuleFilter(map);
    }

    public void updateAsyncConfig() {
        if (this.moduleFilter == null || this.logLevel == null || !TLogNative.isSoOpen()) {
            return;
        }
        try {
            for (Map.Entry<String, LogLevel> entry : this.moduleFilter.entrySet()) {
                TLogNative.addModuleFilter(entry.getKey(), entry.getValue().getIndex());
            }
            TLogNative.setLogLevel(this.logLevel.getIndex());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    private TLogController() {
        this.logLevel = LogLevel.E;
        this.moduleFilter = new ConcurrentHashMap();
    }

    @Override // com.alibaba.baichuan.log.ITLogController
    public void setLogLevel(String str) {
        updateLogLevel(TLogUtils.convertLogLevel(str));
    }

    public void addModuleFilter(String str, LogLevel logLevel) {
        if (str == null) {
            return;
        }
        this.moduleFilter.put(str, logLevel);
        if (TLogInitializer.getInstance().getInitState() == 2 && TLogNative.isSoOpen()) {
            try {
                TLogNative.addModuleFilter(str, logLevel.getIndex());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
