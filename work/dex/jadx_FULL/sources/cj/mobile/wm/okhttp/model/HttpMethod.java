package cj.mobile.wm.okhttp.model;

import cj.mobile.wm.dexc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum HttpMethod {
    GET(dexc.dexa("HFU")),
    POST(dexc.dexa("QPTU")),
    PUT(dexc.dexa("QVU")),
    DELETE(dexc.dexa("EFMFUF")),
    HEAD(dexc.dexa("IFBE")),
    PATCH(dexc.dexa("QBUDI")),
    OPTIONS(dexc.dexa("PQUJPOT")),
    TRACE(dexc.dexa("USBDF"));

    public final String value;

    /* JADX INFO: renamed from: cj.mobile.wm.okhttp.model.HttpMethod$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod[HttpMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod[HttpMethod.OPTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    HttpMethod(String str) {
        this.value = str;
    }

    public boolean hasBody() {
        int i = AnonymousClass1.$SwitchMap$cj$mobile$wm$okhttp$model$HttpMethod[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
