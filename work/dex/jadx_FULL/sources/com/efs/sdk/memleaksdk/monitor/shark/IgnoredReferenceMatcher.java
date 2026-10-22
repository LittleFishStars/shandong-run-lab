package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.be, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/IgnoredReferenceMatcher;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "pattern", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "(Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;)V", "getPattern", "()Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class IgnoredReferenceMatcher extends ReferenceMatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ReferencePattern f29792a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnoredReferenceMatcher(@NotNull ReferencePattern referencePattern) {
        super((byte) 0);
        Intrinsics.checkNotNullParameter(referencePattern, "pattern");
        this.f29792a = referencePattern;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ReferenceMatcher
    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public ReferencePattern getF29792a() {
        return this.f29792a;
    }

    @NotNull
    public String toString() {
        return "ignored ref: " + getF29792a();
    }
}
