package com.kc.bw.okhttp.model;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public enum HttpMethod {
    GET(dexg.dexa("HFU")),
    POST(dexg.dexa("QPTU")),
    PUT(dexg.dexa("QVU")),
    DELETE(dexg.dexa("EFMFUF")),
    HEAD(dexg.dexa("IFBE")),
    PATCH(dexg.dexa("QBUDI")),
    OPTIONS(dexg.dexa("PQUJPOT")),
    TRACE(dexg.dexa("USBDF"));

    public final String value;

    /* JADX INFO: renamed from: com.kc.bw.okhttp.model.HttpMethod$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {
        public static final int[] $SwitchMap$com$kc$bw$okhttp$model$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$com$kc$bw$okhttp$model$HttpMethod = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$model$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$model$HttpMethod[HttpMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$model$HttpMethod[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kc$bw$okhttp$model$HttpMethod[HttpMethod.OPTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    HttpMethod(String str) {
        this.value = str;
    }

    public boolean hasBody() {
        int i = AnonymousClass1.$SwitchMap$com$kc$bw$okhttp$model$HttpMethod[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
