package com.alibaba.baichuan.trade.common.security;

import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcSecurityGuard {
    private static com.alibaba.baichuan.trade.common.security.a b;
    private static volatile AlibcSecurityGuard c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24561a;

    private AlibcSecurityGuard() {
        if (AlibcCommonUtils.verifySdkExist("com.alibaba.wireless.security.open.SecurityGuardManager", AlibcCommonConstant.SECURITY_SDK_TAG)) {
            b = new b();
        }
    }

    public static AlibcSecurityGuard getInstance() {
        if (c == null) {
            synchronized (AlibcSecurityGuard.class) {
                if (c == null) {
                    c = new AlibcSecurityGuard();
                }
            }
        }
        return c;
    }

    @Deprecated
    public Long analyseItemId(String str) {
        if (this.f24561a) {
            return b.c(str);
        }
        return 0L;
    }

    public String dynamicDecrypt(String str) {
        return this.f24561a ? b.b(str) : "";
    }

    public String dynamicEncrypt(String str) {
        return this.f24561a ? b.a(str) : "";
    }

    public String getAppKey() {
        return this.f24561a ? b.b() : "";
    }

    public synchronized a init() {
        a aVar = new a();
        if (this.f24561a) {
            return new a(2);
        }
        com.alibaba.baichuan.trade.common.security.a aVar2 = b;
        if (aVar2 == null) {
            AlibcLogger.e("AlibcSecurityGuard", "securityGuard instance is null");
            return aVar;
        }
        a aVarA = aVar2.a();
        int i = aVarA.f24562a;
        if (i == 0 || 2 == i) {
            this.f24561a = true;
        }
        return aVarA;
    }

    public boolean isInitialized() {
        return this.f24561a;
    }

    public boolean selfCheck() {
        return (AlibcTradeCommon.checkCommon() && this.f24561a) ? false : true;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24562a;
        public int b;
        public String c;

        public a() {
            this.f24562a = 1;
        }

        public a(int i) {
            this.f24562a = i;
        }

        public a(String str) {
            this.f24562a = 1;
            this.b = 100;
            this.c = str;
        }

        public a(int i, String str) {
            this.f24562a = 1;
            this.b = i;
            this.c = str;
        }
    }
}
