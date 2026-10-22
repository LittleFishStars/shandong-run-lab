package com.efs.sdk.memleaksdk.monitor.shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0080\u0004¢\u0006\u0002\u0010\u0005\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\u00020\u00072\u0006\u0010\u0004\u001a\u0002H\u0002H\u0080\u0004¢\u0006\u0002\u0010\b\u001a\u0015\u0010\u0000\u001a\u00020\t*\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0080\u0004¨\u0006\n"}, d2 = {"to", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/IntObjectPair;", "B", "", "that", "(ILjava/lang/Object;)Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/IntObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "", "(JLjava/lang/Object;)Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongObjectPair;", "Lcom/efs/sdk/memleaksdk/monitor/shark/internal/hppc/LongLongPair;", "memleaksdk_release"}, k = 2, mv = {1, 4, 1})
public final class de {
    @NotNull
    public static final <B> LongObjectPair<B> a(long j, B b) {
        return new LongObjectPair<>(j, b);
    }

    @NotNull
    public static final <B> IntObjectPair<B> a(int i, B b) {
        return new IntObjectPair<>(i, b);
    }

    @NotNull
    public static final LongLongPair a(long j, long j2) {
        return new LongLongPair(j, j2);
    }
}
