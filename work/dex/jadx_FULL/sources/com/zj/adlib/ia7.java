package com.zj.adlib;

import java.util.HashSet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/zj/adlib/ia7;", "", "", "a", "Ljava/util/HashSet;", "Ljava/util/HashSet;", "randomUUIDSet", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class ia7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ia7 f42314a = new ia7();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final HashSet<String> randomUUIDSet = new HashSet<>();

    @Nullable
    public final String a() {
        int size = randomUUIDSet.size();
        String strReplace = null;
        while (true) {
            HashSet<String> hashSet = randomUUIDSet;
            if (hashSet.size() != size) {
                return strReplace;
            }
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            strReplace = new Regex(c49.f40900a).replace(string, "");
            hashSet.add(strReplace);
        }
    }
}
