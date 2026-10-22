package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.br, reason: from Kotlin metadata */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "", "", "byteSize", "I", "getByteSize", "()I", "hprofType", "getHprofType", "<init>", "(Ljava/lang/String;III)V", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public enum PrimitiveType {
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);


    @NotNull
    public static final a k = new a(0 == true ? 1 : 0);

    @NotNull
    private static final Map<Integer, Integer> m;

    @NotNull
    private static final Map<Integer, PrimitiveType> n;
    public final int i;
    public final int j;

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.br$a */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType$Companion;", "", "()V", "REFERENCE_HPROF_TYPE", "", "byteSizeByHprofType", "", "getByteSizeByHprofType", "()Ljava/util/Map;", "primitiveTypeByHprofType", "Lcom/efs/sdk/memleaksdk/monitor/shark/PrimitiveType;", "getPrimitiveTypeByHprofType", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PrimitiveType[] primitiveTypeArrValues = values();
        ArrayList arrayList = new ArrayList(primitiveTypeArrValues.length);
        for (PrimitiveType primitiveType : primitiveTypeArrValues) {
            arrayList.add(TuplesKt.to(Integer.valueOf(primitiveType.i), Integer.valueOf(primitiveType.j)));
        }
        m = MapsKt.toMap(arrayList);
        PrimitiveType[] primitiveTypeArrValues2 = values();
        ArrayList arrayList2 = new ArrayList(primitiveTypeArrValues2.length);
        for (PrimitiveType primitiveType2 : primitiveTypeArrValues2) {
            arrayList2.add(TuplesKt.to(Integer.valueOf(primitiveType2.i), primitiveType2));
        }
        n = MapsKt.toMap(arrayList2);
    }

    PrimitiveType(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
