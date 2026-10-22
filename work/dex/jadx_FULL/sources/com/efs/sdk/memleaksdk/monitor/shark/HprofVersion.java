package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bd, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/HprofVersion;", "", "", "versionString", "Ljava/lang/String;", "getVersionString", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public enum HprofVersion {
    JDK1_2_BETA3("JAVA PROFILE 1.0"),
    JDK1_2_BETA4("JAVA PROFILE 1.0.1"),
    JDK_6("JAVA PROFILE 1.0.2"),
    ANDROID("JAVA PROFILE 1.0.3");


    @NotNull
    final String e;

    HprofVersion(String str) {
        this.e = str;
    }
}
