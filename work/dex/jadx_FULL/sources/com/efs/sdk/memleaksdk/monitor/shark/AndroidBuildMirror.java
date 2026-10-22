package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.zj.adlib.ze1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aj, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "", "", ze1.p, "Ljava/lang/String;", "getManufacturer", "()Ljava/lang/String;", "", "sdkInt", "I", "getSdkInt", "()I", "<init>", "(Ljava/lang/String;I)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final class AndroidBuildMirror {

    @NotNull
    public static final a c = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    final String f29651a;
    final int b;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aj$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror$Companion;", "", "()V", "fromHeapGraph", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.aj$a$a, reason: from Kotlin metadata and collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", BridgeDSL.INVOKE, "()Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        public static final class C0622a extends Lambda implements Function0<AndroidBuildMirror> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ HeapGraph f29652a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0622a(HeapGraph heapGraph) {
                super(0);
                this.f29652a = heapGraph;
            }

            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AndroidBuildMirror invoke() {
                HeapObject.b bVarA = this.f29652a.a("android.os.Build");
                Intrinsics.checkNotNull(bVarA);
                HeapObject.b bVarA2 = this.f29652a.a("android.os.Build$VERSION");
                Intrinsics.checkNotNull(bVarA2);
                HeapField heapFieldB = bVarA.b("MANUFACTURER");
                Intrinsics.checkNotNull(heapFieldB);
                String strG = heapFieldB.c.g();
                Intrinsics.checkNotNull(strG);
                HeapField heapFieldB2 = bVarA2.b("SDK_INT");
                Intrinsics.checkNotNull(heapFieldB2);
                Integer numB = heapFieldB2.c.b();
                Intrinsics.checkNotNull(numB);
                return new AndroidBuildMirror(strG, numB.intValue());
            }
        }

        private a() {
        }

        @NotNull
        public final AndroidBuildMirror a(@NotNull HeapGraph heapGraph) {
            Intrinsics.checkNotNullParameter(heapGraph, "graph");
            GraphContext b = heapGraph.getB();
            String name = AndroidBuildMirror.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "AndroidBuildMirror::class.java.name");
            return (AndroidBuildMirror) b.a(name, new C0622a(heapGraph));
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public AndroidBuildMirror(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, ze1.p);
        this.f29651a = str;
        this.b = i;
    }
}
