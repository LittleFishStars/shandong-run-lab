package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.mine.page.dressing_table.signature.SignatureFragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u000267B%\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010\u0010\u001a\u00020\u000fHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\n2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0013\u001a\u00020\u000fHÆ\u0001J\u0019\u0010\u0018\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0002R\u001c\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b'\u0010(R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010,\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0011\u0010/\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\r008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "Ljava/io/Serializable;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "component1", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "component2", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "component3", "gcRootType", "referencePath", "leakingObject", OperatePopupWindow.g, "retainedHeapByteSize", "fromV20$memleaksdk_release", "(Ljava/lang/Integer;)Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "fromV20", "showLeakingStatus", "leakTraceAsString", "index", "referencePathElementIsSuspect", "toSimplePathString", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceElement;", "elements", "Ljava/util/List;", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "getGcRootType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "getLeakingObject", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "getReferencePath", "()Ljava/util/List;", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "getRetainedObjectCount", "retainedObjectCount", "getSignature", "()Ljava/lang/String;", SignatureFragment.SIGNATURE, "Lkotlin/sequences/Sequence;", "getSuspectReferenceSubpath", "()Lkotlin/sequences/Sequence;", "suspectReferenceSubpath", "<init>", "(Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;Ljava/util/List;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;)V", "Companion", "GcRootType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LeakTrace implements Serializable {

    @NotNull
    public static final a d = new a(0);
    private static final long serialVersionUID = -6315725584154386429L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final b f29793a;

    @NotNull
    public final List<com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference> b;

    @NotNull
    public final LeakTraceObject c;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$Companion;", "", "()V", "ZERO_WIDTH_SPACE", "", "serialVersionUID", "", "getNextElementString", "", "leakTrace", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace;", "reference", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "index", "", "showLeakingStatus", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String a(LeakTrace leakTrace, com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference leakTraceReference, int i, boolean z) {
            String str = "    ↓" + (leakTraceReference.referenceType == com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference.b.STATIC_FIELD ? " static" : "") + ' ' + leakTraceReference.a() + '.' + leakTraceReference.b();
            if (!z || !leakTrace.a(i)) {
                return "\n│" + str;
            }
            int iLastIndexOf$default = StringsKt.lastIndexOf$default(str, '.', 0, false, 6, (Object) null) + 1;
            int length = str.length() - iLastIndexOf$default;
            return "\n│" + str + "\n│" + StringsKt.repeat(" ", iLastIndexOf$default) + StringsKt.repeat("~", length);
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$b */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        JNI_GLOBAL("Global variable in native code"),
        JNI_LOCAL("Local variable in native code"),
        JAVA_FRAME("Java local variable"),
        NATIVE_STACK("Input or output parameters in native code"),
        STICKY_CLASS("System class"),
        THREAD_BLOCK("Thread block"),
        MONITOR_USED("Monitor (anything that called the wait() or notify() methods, or that is synchronized.)"),
        THREAD_OBJECT("Thread object"),
        JNI_MONITOR("Root JNI monitor");


        @NotNull
        public static final a k = new a(0);

        @NotNull
        public final String j;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$b$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType$Companion;", "", "()V", "fromGcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTrace$GcRootType;", "gcRoot", "Lcom/efs/sdk/memleaksdk/monitor/shark/GcRoot;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            @NotNull
            public final b a(@NotNull GcRoot gcRoot) {
                Intrinsics.checkNotNullParameter(gcRoot, "gcRoot");
                if (gcRoot instanceof GcRoot.e) {
                    return b.JNI_GLOBAL;
                }
                if (gcRoot instanceof GcRoot.f) {
                    return b.JNI_LOCAL;
                }
                if (gcRoot instanceof GcRoot.d) {
                    return b.JAVA_FRAME;
                }
                if (gcRoot instanceof GcRoot.i) {
                    return b.NATIVE_STACK;
                }
                if (gcRoot instanceof GcRoot.k) {
                    return b.STICKY_CLASS;
                }
                if (gcRoot instanceof GcRoot.l) {
                    return b.THREAD_BLOCK;
                }
                if (gcRoot instanceof GcRoot.h) {
                    return b.MONITOR_USED;
                }
                if (gcRoot instanceof GcRoot.m) {
                    return b.THREAD_OBJECT;
                }
                if (gcRoot instanceof GcRoot.g) {
                    return b.JNI_MONITOR;
                }
                throw new IllegalStateException("Unexpected gc root " + gcRoot);
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        b(String str) {
            this.j = str;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$c, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "element", "", BridgeDSL.INVOKE, "(Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class LeakTraceReference extends Lambda implements Function1<com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LeakTraceReference f29795a = new LeakTraceReference();

        public LeakTraceReference() {
            super(1);
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(@NotNull com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference leakTraceReference) {
            Intrinsics.checkNotNullParameter(leakTraceReference, "element");
            return leakTraceReference.originObject.b + leakTraceReference.c();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bg$d */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "index", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(ILcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceReference;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    public static final class d extends Lambda implements Function2<Integer, com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference, Boolean> {
        public d() {
            super(2);
        }

        public final boolean a(int i, @NotNull com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference leakTraceReference) {
            Intrinsics.checkNotNullParameter(leakTraceReference, "<anonymous parameter 1>");
            return LeakTrace.this.a(i);
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a(((Number) obj).intValue(), (com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference) obj2));
        }
    }

    public LeakTrace(@NotNull b bVar, @NotNull List<com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference> list, @NotNull LeakTraceObject leakTraceObject) {
        Intrinsics.checkNotNullParameter(bVar, "gcRootType");
        Intrinsics.checkNotNullParameter(list, "referencePath");
        Intrinsics.checkNotNullParameter(leakTraceObject, "leakingObject");
        this.f29793a = bVar;
        this.b = list;
        this.c = leakTraceObject;
    }

    @Nullable
    public final Integer a() {
        List listListOf = CollectionsKt.listOf(this.c);
        List<com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference> list = this.b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference) it.next()).originObject);
        }
        List listPlus = CollectionsKt.plus(listListOf, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listPlus) {
            if (((LeakTraceObject) obj).d == LeakTraceObject.b.LEAKING) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Integer num = ((LeakTraceObject) it2.next()).f;
            if (num != null) {
                arrayList3.add(num);
            }
        }
        return (Integer) CollectionsKt.max(arrayList3);
    }

    @NotNull
    public final Sequence<com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference> b() {
        return SequencesKt.filterIndexed(CollectionsKt.asSequence(this.b), new d());
    }

    @NotNull
    public final String c() {
        return ct.a(SequencesKt.joinToString$default(b(), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, LeakTraceReference.f29795a, 30, (Object) null));
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeakTrace)) {
            return false;
        }
        LeakTrace leakTrace = (LeakTrace) other;
        return Intrinsics.areEqual(this.f29793a, leakTrace.f29793a) && Intrinsics.areEqual(this.b, leakTrace.b) && Intrinsics.areEqual(this.c, leakTrace.c);
    }

    public int hashCode() {
        b bVar = this.f29793a;
        int iHashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        List<com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference> list = this.b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        LeakTraceObject leakTraceObject = this.c;
        return iHashCode2 + (leakTraceObject != null ? leakTraceObject.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return a(true);
    }

    public final boolean a(int i) {
        int i2 = bh.f29797a[this.b.get(i).originObject.d.ordinal()];
        if (i2 != 1) {
            return i2 == 2 && (i == CollectionsKt.getLastIndex(this.b) || this.b.get(i + 1).originObject.d != LeakTraceObject.b.NOT_LEAKING);
        }
        return true;
    }

    private final String a(boolean z) {
        String strTrimIndent = StringsKt.trimIndent("\n        ┬───\n        │ GC Root: " + this.f29793a.j + "\n        │\n      ");
        int i = 0;
        for (Object obj : this.b) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference leakTraceReference = (com.efs.sdk.memleaksdk.monitor.shark.LeakTraceReference) obj;
            LeakTraceObject leakTraceObject = leakTraceReference.originObject;
            StringBuilder sb = new StringBuilder();
            sb.append(strTrimIndent + "\n");
            sb.append(leakTraceObject.a("├─ ", "│    ", z, (i == 0 && this.f29793a == b.JAVA_FRAME) ? "thread" : leakTraceObject.b()));
            strTrimIndent = sb.toString() + d.a(this, leakTraceReference, i, z);
            i = i2;
        }
        return (strTrimIndent + "\n") + LeakTraceObject.a(this.c, "╰→ ", "\u200b     ", z, null, 8);
    }
}
