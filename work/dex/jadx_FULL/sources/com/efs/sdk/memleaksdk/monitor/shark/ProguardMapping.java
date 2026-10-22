package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bs, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ProguardMapping;", "", "()V", "obfuscatedToClearNamesMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "addMapping", "", "obfuscatedName", "clearName", "deobfuscateClassName", "obfuscatedClassName", "deobfuscateFieldName", "obfuscatedClass", "obfuscatedField", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class ProguardMapping {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, String> f29814a;

    @NotNull
    public final String a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "obfuscatedClassName");
        String str2 = this.f29814a.get(str);
        return str2 != null ? str2 : str;
    }

    @NotNull
    public final String a(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "obfuscatedClass");
        Intrinsics.checkNotNullParameter(str2, "obfuscatedField");
        String str3 = this.f29814a.get(str + '.' + str2);
        return str3 != null ? str3 : str2;
    }
}
