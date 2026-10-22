package com.google.common.math;

import androidx.camera.video.AudioStats;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Doubles;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j, double d, double d2, double d3, double d4) {
        this.count = j;
        this.mean = d;
        this.sumOfSquaresOfDeltas = d2;
        this.min = d3;
        this.max = d4;
    }

    public static Stats fromByteArray(byte[] bArr) {
        com.google.common.base.i.E(bArr);
        com.google.common.base.i.m(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        i iVar = new i();
        iVar.d(iterable);
        return iVar.s();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        com.google.common.base.i.E(byteBuffer);
        com.google.common.base.i.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return com.google.common.base.g.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        com.google.common.base.i.g0(this.count != 0);
        return this.max;
    }

    public double mean() {
        com.google.common.base.i.g0(this.count != 0);
        return this.mean;
    }

    public double min() {
        com.google.common.base.i.g0(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        com.google.common.base.i.g0(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return this.count == 1 ? AudioStats.AUDIO_AMPLITUDE_NONE : d.b(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        com.google.common.base.i.g0(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return d.b(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(byteBufferOrder);
        return byteBufferOrder.array();
    }

    public String toString() {
        return count() > 0 ? com.google.common.base.e.c(this).e("count", this.count).b("mean", this.mean).b("populationStandardDeviation", populationStandardDeviation()).b(MoreDistanceDialog.VALUE_MIN, this.min).b("max", this.max).toString() : com.google.common.base.e.c(this).e("count", this.count).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        com.google.common.base.i.E(byteBuffer);
        com.google.common.base.i.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        com.google.common.base.i.d(it.hasNext());
        double dDoubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double dDoubleValue2 = it.next().doubleValue();
            j++;
            dDoubleValue = (Doubles.n(dDoubleValue2) && Doubles.n(dDoubleValue)) ? dDoubleValue + ((dDoubleValue2 - dDoubleValue) / j) : i.i(dDoubleValue, dDoubleValue2);
        }
        return dDoubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        i iVar = new i();
        iVar.e(it);
        return iVar.s();
    }

    public static Stats of(double... dArr) {
        i iVar = new i();
        iVar.f(dArr);
        return iVar.s();
    }

    public static double meanOf(double... dArr) {
        com.google.common.base.i.d(dArr.length > 0);
        double dI = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d = dArr[i];
            dI = (Doubles.n(d) && Doubles.n(dI)) ? dI + ((d - dI) / ((double) (i + 1))) : i.i(dI, d);
        }
        return dI;
    }

    public static Stats of(int... iArr) {
        i iVar = new i();
        iVar.g(iArr);
        return iVar.s();
    }

    public static Stats of(long... jArr) {
        i iVar = new i();
        iVar.h(jArr);
        return iVar.s();
    }

    public static double meanOf(int... iArr) {
        com.google.common.base.i.d(iArr.length > 0);
        double dI = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d = iArr[i];
            dI = (Doubles.n(d) && Doubles.n(dI)) ? dI + ((d - dI) / ((double) (i + 1))) : i.i(dI, d);
        }
        return dI;
    }

    public static double meanOf(long... jArr) {
        com.google.common.base.i.d(jArr.length > 0);
        double dI = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d = jArr[i];
            dI = (Doubles.n(d) && Doubles.n(dI)) ? dI + ((d - dI) / ((double) (i + 1))) : i.i(dI, d);
        }
        return dI;
    }
}
