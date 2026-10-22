package com.zj.adlib;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.upstream.DataReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(30)
@SuppressLint({"Override"})
public final class ta4 implements MediaParser.SeekableInputReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f44880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DataReader f19764a;
    public long b;
    public long c;

    public long a() {
        long j = this.c;
        this.c = -1L;
        return j;
    }

    public void b(long j) {
        this.b = j;
    }

    public void c(DataReader dataReader, long j) {
        this.f19764a = dataReader;
        this.f44880a = j;
        this.c = -1L;
    }

    @Override // android.media.MediaParser.InputReader
    public long getLength() {
        return this.f44880a;
    }

    @Override // android.media.MediaParser.InputReader
    public long getPosition() {
        return this.b;
    }

    @Override // android.media.MediaParser.InputReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((DataReader) gj9.k(this.f19764a)).read(bArr, i, i2);
        this.b += (long) i3;
        return i3;
    }

    @Override // android.media.MediaParser.SeekableInputReader
    public void seekToPosition(long j) {
        this.c = j;
    }
}
