package com.efs.sdk.memleaksdk.monitor.shark;

import com.huachenjie.base.widget.OperatePopupWindow;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "", "<init>", "()V", "BooleanHolder", "ByteHolder", "CharHolder", "Companion", "DoubleHolder", "FloatHolder", "IntHolder", "LongHolder", "ReferenceHolder", "ShortHolder", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ReferenceHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$BooleanHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$CharHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$FloatHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$DoubleHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ByteHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ShortHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$IntHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$LongHolder;", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class ValueHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f29821a = new d(0);

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$a, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$BooleanHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(Z)V", "getValue", "()Z", "component1", OperatePopupWindow.g, "equals", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class BooleanHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        final boolean value;

        public BooleanHolder(boolean z) {
            super((byte) 0);
            this.value = z;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof BooleanHolder) && this.value == ((BooleanHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.value;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "BooleanHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$b, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ByteHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(B)V", "getValue", "()B", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class ByteHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        private final byte value;

        public ByteHolder(byte b) {
            super((byte) 0);
            this.value = b;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof ByteHolder) && this.value == ((ByteHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            return Byte.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "ByteHolder(value=" + ((int) this.value) + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$c, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$CharHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(C)V", "getValue", "()C", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class CharHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        private final char value;

        public CharHolder(char c) {
            super((byte) 0);
            this.value = c;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof CharHolder) && this.value == ((CharHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            return Character.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "CharHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$d */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$Companion;", "", "()V", "NULL_REFERENCE", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$e, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$DoubleHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(D)V", "getValue", "()D", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class DoubleHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        private final double value;

        public DoubleHolder(double d) {
            super((byte) 0);
            this.value = d;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof DoubleHolder) && Double.compare(this.value, ((DoubleHolder) other).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "DoubleHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$f, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$FloatHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(F)V", "getValue", "()F", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class FloatHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        private final float value;

        public FloatHolder(float f) {
            super((byte) 0);
            this.value = f;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof FloatHolder) && Float.compare(this.value, ((FloatHolder) other).value) == 0;
            }
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "FloatHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$g, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$IntHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(I)V", "getValue", "()I", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class IntHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        final int value;

        public IntHolder(int i) {
            super((byte) 0);
            this.value = i;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof IntHolder) && this.value == ((IntHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "IntHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$h, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$LongHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(J)V", "getValue", "()J", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class LongHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        final long value;

        public LongHolder(long j) {
            super((byte) 0);
            this.value = j;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof LongHolder) && this.value == ((LongHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "LongHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$i, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ReferenceHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(J)V", "isNull", "", "()Z", "getValue", "()J", "component1", OperatePopupWindow.g, "equals", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class ReferenceHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        public final long value;

        public ReferenceHolder(long j) {
            super((byte) 0);
            this.value = j;
        }

        public final boolean a() {
            return this.value == 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof ReferenceHolder) && this.value == ((ReferenceHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "ReferenceHolder(value=" + this.value + ")";
        }
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.cb$j, reason: from toString */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder$ShortHolder;", "Lcom/efs/sdk/memleaksdk/monitor/shark/ValueHolder;", "value", "", "(S)V", "getValue", "()S", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "", "toString", "", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final /* data */ class ShortHolder extends ValueHolder {

        /* JADX INFO: renamed from: b, reason: from toString */
        private final short value;

        public ShortHolder(short s) {
            super((byte) 0);
            this.value = s;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                return (other instanceof ShortHolder) && this.value == ((ShortHolder) other).value;
            }
            return true;
        }

        public int hashCode() {
            return Short.hashCode(this.value);
        }

        @NotNull
        public String toString() {
            return "ShortHolder(value=" + ((int) this.value) + ")";
        }
    }

    private ValueHolder() {
    }

    public /* synthetic */ ValueHolder(byte b) {
        this();
    }
}
