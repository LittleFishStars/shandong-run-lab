package com.huachenjie.common.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/huachenjie/common/bean/CheatType;", "", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface CheatType {
    public static final int ADB = 107;
    public static final int BD_MOCK = 109;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int EMULATOR = 101;
    public static final int HOOK = 103;
    public static final int MAGISK = 104;
    public static final int MULTI_APP = 102;
    public static final int PROXY = 105;
    public static final int ROOT = 100;
    public static final int SIGN = 106;
    public static final int THIRD_ROM = 108;
    public static final int VIRTUAL_LOCATION = 110;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/common/bean/CheatType$Companion;", "", "()V", "ADB", "", "BD_MOCK", "EMULATOR", "HOOK", "MAGISK", "MULTI_APP", "PROXY", "ROOT", "SIGN", "THIRD_ROM", "VIRTUAL_LOCATION", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ADB = 107;
        public static final int BD_MOCK = 109;
        public static final int EMULATOR = 101;
        public static final int HOOK = 103;
        public static final int MAGISK = 104;
        public static final int MULTI_APP = 102;
        public static final int PROXY = 105;
        public static final int ROOT = 100;
        public static final int SIGN = 106;
        public static final int THIRD_ROM = 108;
        public static final int VIRTUAL_LOCATION = 110;

        private Companion() {
        }
    }
}
