package com.alibaba.baichuan.trade.common.mtop;

import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcCommonUtils;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcMtop implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AlibcMtop f24548a;
    private com.alibaba.baichuan.trade.common.mtop.a b;
    private boolean c;

    private AlibcMtop() {
        if (AlibcCommonUtils.verifySdkExist("mtopsdk.mtop.intf.Mtop", AlibcCommonConstant.MTOP_SDK_TAG)) {
            this.b = new b();
        }
    }

    public static AlibcMtop getInstance() {
        if (f24548a == null) {
            synchronized (AlibcMtop.class) {
                if (f24548a == null) {
                    f24548a = new AlibcMtop();
                }
            }
        }
        return f24548a;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    public synchronized a init(Map<String, Object> map) {
        int iIntValue;
        a aVar = new a();
        if (this.c) {
            return new a(2);
        }
        if (map != null) {
            Object obj = map.get(com.alipay.sdk.m.o.b.r0);
            if (!(obj instanceof Integer) || ((Integer) obj).intValue() <= 0) {
                iIntValue = -1;
            } else {
                iIntValue = ((Integer) obj).intValue();
            }
        } else {
            iIntValue = -1;
        }
        com.alibaba.baichuan.trade.common.mtop.a aVar2 = this.b;
        if (aVar2 != null && aVar2.a(iIntValue)) {
            AlibcLogger.i("AlibcMtop", "mtop sdk init success");
            this.c = true;
            aVar = new a(0);
            if (AlibcBaseTradeCommon.isDebug()) {
                this.b.a();
            }
        }
        return aVar;
    }

    public boolean isInitialized() {
        return this.c;
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.c
    public boolean sendRequest(NetworkRequestListener networkRequestListener, NetworkRequest networkRequest) {
        if (this.c) {
            return this.b.sendRequest(networkRequestListener, networkRequest);
        }
        return false;
    }

    public void setTTID(String str) {
        com.alibaba.baichuan.trade.common.mtop.a aVar;
        if (!this.c || (aVar = this.b) == null) {
            return;
        }
        aVar.a(str);
    }

    public void turnOffDebug() {
        if (this.c) {
            this.b.b();
        }
    }

    public void turnOnDebug() {
        if (this.c) {
            this.b.a();
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24549a;

        public a() {
            this.f24549a = 1;
        }

        public a(int i) {
            this.f24549a = i;
        }
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.c
    public NetworkResponse sendRequest(NetworkRequest networkRequest) {
        if (this.c) {
            return this.b.sendRequest(networkRequest);
        }
        return null;
    }
}
