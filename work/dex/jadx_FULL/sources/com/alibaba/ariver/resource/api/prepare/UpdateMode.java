package com.alibaba.ariver.resource.api.prepare;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum UpdateMode {
    SYNC_FORCE(2),
    SYNC_TRY(1),
    ASYNC(0);

    public int value;

    /* JADX INFO: renamed from: com.alibaba.ariver.resource.api.prepare.UpdateMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode;

        static {
            int[] iArr = new int[UpdateMode.values().length];
            $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode = iArr;
            try {
                iArr[UpdateMode.SYNC_FORCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode[UpdateMode.SYNC_TRY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode[UpdateMode.ASYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    UpdateMode(int i) {
        this.value = i;
    }

    public static UpdateMode fromString(String str) {
        str.hashCode();
        if (str.equals("synctry")) {
            return SYNC_TRY;
        }
        return !str.equals("syncforce") ? ASYNC : SYNC_FORCE;
    }

    public boolean isSync() {
        return this.value > 0;
    }

    public String toReqMode() {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$resource$api$prepare$UpdateMode[ordinal()];
        if (i != 1) {
            return i != 2 ? "async" : "synctry";
        }
        return "syncforce";
    }
}
