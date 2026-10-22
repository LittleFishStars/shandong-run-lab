package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001:\u0003ABCBQ\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0011HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015Jj\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u00022\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J1\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u0002H\u0000¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010)R\u0011\u0010+\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b*\u0010)R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u001b\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u00101R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010'\u001a\u0004\b2\u0010)\"\u0004\b3\u00104R\u0017\u0010\u0017\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0017\u00105\u001a\u0004\b6\u00107R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u0015R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b:\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010;\u001a\u0004\b<\u0010=R\u0011\u0010$\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b>\u0010)¨\u0006D"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "Ljava/io/Serializable;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "component1", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "component2", "component3", "", "component4", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "component5", "component6", "component7", "()Ljava/lang/Integer;", "component8", "objectId", "type", "className", "labels", "leakingStatus", "leakingStatusReason", "retainedHeapByteSize", "retainedObjectCount", OperatePopupWindow.g, "(JLcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject;", "firstLinePrefix", "additionalLinesPrefix", "showLeakingStatus", "typeName", "toString$memleaksdk_release", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Ljava/lang/String;", "Ljava/lang/String;", "getClassName", "()Ljava/lang/String;", "getClassSimpleName", "classSimpleName", "Ljava/util/Set;", "getLabels", "()Ljava/util/Set;", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "getLeakingStatus", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "getLeakingStatusReason", "setLeakingStatusReason", "(Ljava/lang/String;)V", "J", "getObjectId", "()J", "Ljava/lang/Integer;", "getRetainedHeapByteSize", "getRetainedObjectCount", "Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "getType", "()Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "getTypeName", "<init>", "(JLcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;Ljava/lang/String;Ljava/util/Set;Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "LeakingStatus", "ObjectType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LeakTraceObject implements Serializable {

    @NotNull
    public static final a h = new a(0);
    private static final long serialVersionUID = -3616216391305196341L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29798a;

    @NotNull
    public final String b;

    @NotNull
    public final Set<String> c;

    @NotNull
    final b d;

    @NotNull
    public String e;

    @Nullable
    public final Integer f;

    @Nullable
    public final Integer g;

    @NotNull
    private final c i;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$Companion;", "", "()V", "serialVersionUID", "", "humanReadableByteCount", "", "bytes", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public final String a(long j) {
            if (j < 1000) {
                return j + " B";
            }
            double d = j;
            double d2 = 1000;
            int iLog = (int) (Math.log(d) / Math.log(d2));
            char cCharAt = "kMGTPE".charAt(iLog - 1);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%.1f %sB", Arrays.copyOf(new Object[]{Double.valueOf(d / Math.pow(d2, iLog)), Character.valueOf(cCharAt)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            return str;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi$b */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$LeakingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum b {
        NOT_LEAKING,
        LEAKING,
        UNKNOWN
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.bi$c */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/LeakTraceObject$ObjectType;", "", "<init>", "(Ljava/lang/String;I)V", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public enum c {
        CLASS,
        ARRAY,
        INSTANCE
    }

    public LeakTraceObject(long j, @NotNull c cVar, @NotNull String str, @NotNull Set<String> set, @NotNull b bVar, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(cVar, "type");
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(set, "labels");
        Intrinsics.checkNotNullParameter(bVar, "leakingStatus");
        Intrinsics.checkNotNullParameter(str2, "leakingStatusReason");
        this.f29798a = j;
        this.i = cVar;
        this.b = str;
        this.c = set;
        this.d = bVar;
        this.e = str2;
        this.f = num;
        this.g = num2;
    }

    public final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    @NotNull
    public final String b() {
        String strName = this.i.name();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
        if (strName == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeakTraceObject)) {
            return false;
        }
        LeakTraceObject leakTraceObject = (LeakTraceObject) other;
        return this.f29798a == leakTraceObject.f29798a && Intrinsics.areEqual(this.i, leakTraceObject.i) && Intrinsics.areEqual(this.b, leakTraceObject.b) && Intrinsics.areEqual(this.c, leakTraceObject.c) && Intrinsics.areEqual(this.d, leakTraceObject.d) && Intrinsics.areEqual(this.e, leakTraceObject.e) && Intrinsics.areEqual(this.f, leakTraceObject.f) && Intrinsics.areEqual(this.g, leakTraceObject.g);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f29798a) * 31;
        c cVar = this.i;
        int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
        String str = this.b;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Set<String> set = this.c;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        b bVar = this.d;
        int iHashCode5 = (iHashCode4 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        String str2 = this.e;
        int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.f;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.g;
        return iHashCode7 + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return a(this, "", "\u200b  ", true, null, 8);
    }

    @NotNull
    public final String a() {
        return ct.a(this.b, '.');
    }

    public static /* synthetic */ String a(LeakTraceObject leakTraceObject, String str, String str2, boolean z, String str3, int i) {
        if ((i & 8) != 0) {
            str3 = leakTraceObject.b();
        }
        return leakTraceObject.a(str, str2, z, str3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @NotNull
    public final String a(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) throws NoWhenBranchMatchedException {
        String str4;
        Intrinsics.checkNotNullParameter(str, "firstLinePrefix");
        Intrinsics.checkNotNullParameter(str2, "additionalLinesPrefix");
        Intrinsics.checkNotNullParameter(str3, "typeName");
        int i = bj.f29801a[this.d.ordinal()];
        if (i == 1) {
            str4 = "UNKNOWN";
        } else if (i == 2) {
            str4 = "NO (" + this.e + ')';
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str4 = "YES (" + this.e + ')';
        }
        String str5 = "" + str + this.b + ' ' + str3;
        if (z) {
            str5 = str5 + '\n' + str2 + "Leaking: " + str4;
        }
        Integer num = this.f;
        if (num != null) {
            str5 = str5 + '\n' + str2 + "Retaining " + h.a(num.intValue()) + " in " + this.g + " objects";
        }
        Iterator<String> it = this.c.iterator();
        while (it.hasNext()) {
            str5 = str5 + '\n' + str2 + it.next();
        }
        return str5;
    }
}
