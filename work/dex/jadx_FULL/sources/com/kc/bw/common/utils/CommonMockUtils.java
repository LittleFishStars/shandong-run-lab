package com.kc.bw.common.utils;

import com.kc.bw.common.bean.AppConfigRespBean;
import com.kc.bw.common.bean.CheckDPObj;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CommonMockUtils {
    public static final boolean ISMOCK = false;
    public static final boolean IS_MOCK_CLICK_OPTIMIZE = false;
    public static final boolean IS_MOCK_IQIYI = false;
    public static final String TAG = "CommonMockUtils";

    public static AppConfigRespBean mockAppConfigData() {
        return null;
    }

    public static String mockBlackListUrl() {
        return null;
    }

    public static List<String> mockBlackListWorlds() {
        return null;
    }

    public static CheckDPObj mockCheckDpObj() {
        return null;
    }
}
