package com.alibaba.alibcprotocol.manager;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcSdkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23615a = "AlibcSdkManager";
    private static final CopyOnWriteArrayList<String> b = new CopyOnWriteArrayList<>();

    public static class Instance {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AlibcSdkManager f23616a = new AlibcSdkManager(0);

        private Instance() {
        }
    }

    public /* synthetic */ AlibcSdkManager(byte b2) {
        this();
    }

    public static AlibcSdkManager getInstance() {
        return Instance.f23616a;
    }

    public AlibcRegisterResult registerSDK(String str, String str2) {
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = b;
            if (!copyOnWriteArrayList.isEmpty() && copyOnWriteArrayList.contains(str)) {
                return new AlibcRegisterResult(2);
            }
            try {
                Class.forName(str2);
                copyOnWriteArrayList.add(str);
            } catch (ClassNotFoundException e) {
                AlibcLogger.e(f23615a, str + " is not exist: " + e.getMessage());
                return new AlibcRegisterResult(1, "sdk not exist");
            }
        } catch (Exception e2) {
            AlibcLogger.e(f23615a, "register sdk exception: " + e2.getMessage());
        }
        return new AlibcRegisterResult(0);
    }

    public boolean supportComp(String str) {
        for (String str2 : AlibcProtocolConstant.CLASS_LIST) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean supportComponent(String str) {
        for (String str2 : AlibcProtocolConstant.COMPONENT_LIST) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void unRegisterSdk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.remove(str);
    }

    public boolean verifySdkExist(String str) {
        return !TextUtils.isEmpty(str) && b.contains(str);
    }

    public static class AlibcRegisterResult {
        public static final int SDK_REGISTER_AD = 2;
        public static final int SDK_REGISTER_FAIL = 1;
        public static final int SDK_REGISTER_SUCCESS = 0;
        public int errorCode;
        public String errorMessage;
        public int result;

        public AlibcRegisterResult() {
            this.result = 1;
        }

        public AlibcRegisterResult(int i) {
            this.result = i;
        }

        public AlibcRegisterResult(int i, String str) {
            this.result = 1;
            this.errorCode = i;
            this.errorMessage = str;
        }
    }

    private AlibcSdkManager() {
    }
}
