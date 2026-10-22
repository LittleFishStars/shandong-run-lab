package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "Ljava/io/Serializable;", "<init>", "()V", "Companion", "InstanceFieldPattern", "JavaLocalPattern", "NativeGlobalVariablePattern", "StaticFieldPattern", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$JavaLocalPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$StaticFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$InstanceFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$NativeGlobalVariablePattern;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class ReferencePattern implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f29816a = new a(0);
    private static final long serialVersionUID = -5113635523713591133L;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$b */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$InstanceFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "", "toString", "", "hashCode", "", "other", "", "equals", "component1", "component2", "className", "fieldName", OperatePopupWindow.g, "Ljava/lang/String;", "getClassName", "()Ljava/lang/String;", "getFieldName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class b extends ReferencePattern {

        @NotNull
        public static final a d = new a(0);
        private static final long serialVersionUID = 6649791455204159802L;

        @NotNull
        public final String b;

        @NotNull
        public final String c;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$b$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$InstanceFieldPattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String str, @NotNull String str2) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(str2, "fieldName");
            this.b = str;
            this.c = str2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.c;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "instance field " + this.b + '#' + this.c;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$c */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$JavaLocalPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "", "toString", "", "hashCode", "", "other", "", "equals", "component1", "threadName", OperatePopupWindow.g, "Ljava/lang/String;", "getThreadName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class c extends ReferencePattern {

        @NotNull
        public static final a c = new a(0);
        private static final long serialVersionUID = -8985446122829543654L;

        @NotNull
        public final String b;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$c$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$JavaLocalPattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String str) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(str, "threadName");
            this.b = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof c) && Intrinsics.areEqual(this.b, ((c) other).b);
            }
            return true;
        }

        public int hashCode() {
            String str = this.b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "local variable on thread " + this.b;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$d */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$NativeGlobalVariablePattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "", "toString", "", "hashCode", "", "other", "", "equals", "component1", "className", OperatePopupWindow.g, "Ljava/lang/String;", "getClassName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class d extends ReferencePattern {

        @NotNull
        public static final a c = new a(0);
        private static final long serialVersionUID = -2651328076202244933L;

        @NotNull
        public final String b;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$d$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$NativeGlobalVariablePattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull String str) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(str, "className");
            this.b = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof d) && Intrinsics.areEqual(this.b, ((d) other).b);
            }
            return true;
        }

        public int hashCode() {
            String str = this.b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "native global variable referencing " + this.b;
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$e */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$StaticFieldPattern;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "", "toString", "", "hashCode", "", "other", "", "equals", "component1", "component2", "className", "fieldName", OperatePopupWindow.g, "Ljava/lang/String;", "getClassName", "()Ljava/lang/String;", "getFieldName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class e extends ReferencePattern {

        @NotNull
        public static final a d = new a(0);
        private static final long serialVersionUID = 7656908128775899611L;

        @NotNull
        public final String b;

        @NotNull
        public final String c;

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bx$e$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern$StaticFieldPattern$Companion;", "", "()V", "serialVersionUID", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull String str, @NotNull String str2) {
            super((byte) 0);
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(str2, "fieldName");
            this.b = str;
            this.c = str2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof e)) {
                return false;
            }
            e eVar = (e) other;
            return Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c);
        }

        public int hashCode() {
            String str = this.b;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.c;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "static field " + this.b + '#' + this.c;
        }
    }

    private ReferencePattern() {
    }

    public /* synthetic */ ReferencePattern(byte b2) {
        this();
    }
}
