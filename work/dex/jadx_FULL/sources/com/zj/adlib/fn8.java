package com.zj.adlib;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fn8 extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41714a = 0;
    public static final int b = 4;
    public static final int c = 5;
    public static final int d = 6;
    public static final int e = 255;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g89 f16583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16585a = new om6();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nm6 f16584a = new nm6();

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(xn5 xn5Var, ByteBuffer byteBuffer) {
        Metadata.Entry spliceNullCommand;
        g89 g89Var = this.f16583a;
        if (g89Var == null || xn5Var.b != g89Var.e()) {
            g89 g89Var2 = new g89(((DecoderInputBuffer) xn5Var).f30576a);
            this.f16583a = g89Var2;
            g89Var2.a(((DecoderInputBuffer) xn5Var).f30576a - xn5Var.b);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f16585a.Q(bArrArray, iLimit);
        this.f16584a.p(bArrArray, iLimit);
        this.f16584a.s(39);
        long jH = (((long) this.f16584a.h(1)) << 32) | ((long) this.f16584a.h(32));
        this.f16584a.s(20);
        int iH = this.f16584a.h(12);
        int iH2 = this.f16584a.h(8);
        this.f16585a.T(14);
        if (iH2 == 0) {
            spliceNullCommand = new SpliceNullCommand();
        } else if (iH2 == 255) {
            spliceNullCommand = PrivateCommand.parseFromSection(this.f16585a, iH, jH);
        } else if (iH2 == 4) {
            spliceNullCommand = SpliceScheduleCommand.parseFromSection(this.f16585a);
        } else if (iH2 != 5) {
            spliceNullCommand = iH2 != 6 ? null : TimeSignalCommand.parseFromSection(this.f16585a, jH, this.f16583a);
        } else {
            spliceNullCommand = SpliceInsertCommand.parseFromSection(this.f16585a, jH, this.f16583a);
        }
        return spliceNullCommand == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(spliceNullCommand);
    }
}
