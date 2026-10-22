package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    private final BufferedOutputStream aDm;
    private final RandomAccessFile aDn;
    private final FileDescriptor fd;

    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }

    public b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.aDn = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.aDm = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void Du() throws IOException {
        this.aDm.flush();
        this.fd.sync();
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.aDm.close();
        this.aDn.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j) throws IOException {
        this.aDn.seek(j);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j) throws IOException {
        this.aDn.setLength(j);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.aDm.write(bArr, 0, i2);
    }
}
