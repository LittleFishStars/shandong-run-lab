package com.fl.saas.adx.base.activity.h5;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.fl.saas.B0;
import com.fl.saas.C1415j;
import com.fl.saas.E0;
import com.fl.saas.S0;
import com.fl.saas.a1;
import com.fl.saas.adx.util.DeviceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class QuickAppHelper {
    private static QuickAppHelper sInstance;
    private boolean enableQuickApp;
    private C1415j mAdxInfo;
    private List<String> whitelistHeaders;
    private final List<String> listQuickKey = new ArrayList();
    private final Map<String, String> mapQuickKey = new HashMap();
    private int collectWebviewWakeup = 0;
    private double quickAppBlockRatio = 100.0d;
    private int webviewWakeupLimit = 0;
    private int quickAppInterceptionType = 1;
    private int quickAppFreqDay = 0;
    private final Map<String, Integer> startQuickAppTimesMap = new HashMap();
    private boolean isQuickApp = false;

    private QuickAppHelper() {
    }

    private boolean checkInterceptRatio() {
        double d = this.quickAppBlockRatio;
        return d < 100.0d && d >= AudioStats.AUDIO_AMPLITUDE_NONE && new Random().nextDouble() * 100.0d > this.quickAppBlockRatio;
    }

    private boolean checkQuickAppFreqDay(boolean z, String str, int i) {
        if (this.quickAppFreqDay <= 0) {
            if (!checkInterceptRatio()) {
                return true;
            }
            if (z) {
                this.startQuickAppTimesMap.put(str, Integer.valueOf(i + 1));
            }
            return false;
        }
        String date = DeviceUtil.getDate();
        if (!date.equals(S0.a().a("lastOpenQuickAppDay", ""))) {
            if (!checkInterceptRatio()) {
                return true;
            }
            S0.a().b("lastOpenQuickAppDay", date);
            S0.a().b("lastDayOpenQuickAppDayNumber", 1);
            if (z) {
                this.startQuickAppTimesMap.put(str, Integer.valueOf(i + 1));
            }
            return false;
        }
        int iA = S0.a().a("lastDayOpenQuickAppDayNumber", 0);
        if (iA >= this.quickAppFreqDay || !checkInterceptRatio()) {
            return true;
        }
        S0.a().b("lastDayOpenQuickAppDayNumber", iA + 1);
        if (z) {
            this.startQuickAppTimesMap.put(str, Integer.valueOf(i + 1));
        }
        return false;
    }

    public static QuickAppHelper getInstance() {
        if (sInstance == null) {
            synchronized (QuickAppHelper.class) {
                sInstance = new QuickAppHelper();
            }
        }
        return sInstance;
    }

    public void addListQuickKey(List<String> list) {
        if (list != null) {
            for (String str : list) {
                if (!this.listQuickKey.contains(str)) {
                    this.listQuickKey.add(str);
                }
            }
        }
    }

    public void addListQuickMatch(List<B0> list) {
        if (list != null) {
            for (B0 b0 : list) {
                if (b0 != null && !TextUtils.isEmpty(b0.b()) && !this.mapQuickKey.containsKey(b0.b())) {
                    this.mapQuickKey.put(b0.b(), b0.a());
                }
            }
        }
    }

    public void clearHistory() {
        this.mAdxInfo = null;
        this.startQuickAppTimesMap.clear();
    }

    public boolean enableQuickApp(String str) {
        return this.enableQuickApp;
    }

    public int getQuickAppInterceptionType() {
        return this.quickAppInterceptionType;
    }

    public void reportUrl(String str) {
        if (this.collectWebviewWakeup == 0 || this.mAdxInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        E0.a().b(this.mAdxInfo, str);
    }

    public void setAdSource(C1415j c1415j) {
        this.mAdxInfo = c1415j;
    }

    public void setCollectWebviewWakeup(int i) {
        this.collectWebviewWakeup = i;
    }

    public void setEnableQuickApp(int i) {
        this.enableQuickApp = i == 0;
    }

    public void setQuickAppBlockRatio(double d) {
        this.quickAppBlockRatio = d;
    }

    public void setQuickAppFreqDay(int i) {
        this.quickAppFreqDay = i;
    }

    public void setQuickAppInterceptionType(int i) {
        this.quickAppInterceptionType = i;
    }

    public void setWebviewWakeupLimit(int i) {
        this.webviewWakeupLimit = i;
    }

    public void setWhitelistHeaders(List<String> list) {
        this.whitelistHeaders = list;
    }

    public boolean urlIntercept(String str) {
        Integer num;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> list = this.whitelistHeaders;
        if (list != null && !list.isEmpty()) {
            for (String str2 : this.whitelistHeaders) {
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    return false;
                }
            }
        }
        this.isQuickApp = false;
        if (!this.listQuickKey.isEmpty()) {
            for (String str3 : this.listQuickKey) {
                if (!TextUtils.isEmpty(str3) && str.startsWith(str3)) {
                    this.isQuickApp = true;
                    break;
                }
            }
        }
        if (!this.isQuickApp && !this.mapQuickKey.isEmpty()) {
            for (String str4 : this.mapQuickKey.keySet()) {
                if (!TextUtils.isEmpty(str4) && str.startsWith(str4)) {
                    String str5 = this.mapQuickKey.get(str4);
                    if (!TextUtils.isEmpty(str5) && a1.b(str5.split(","), str)) {
                        this.isQuickApp = true;
                    }
                }
            }
        }
        if (!this.isQuickApp) {
            return false;
        }
        if (this.webviewWakeupLimit <= 0) {
            return checkQuickAppFreqDay(false, str, 0);
        }
        if (this.startQuickAppTimesMap.containsKey(str) && (num = this.startQuickAppTimesMap.get(str)) != null) {
            if (num.intValue() < this.webviewWakeupLimit) {
                return checkQuickAppFreqDay(true, str, num.intValue());
            }
            return true;
        }
        return checkQuickAppFreqDay(true, str, 0);
    }
}
