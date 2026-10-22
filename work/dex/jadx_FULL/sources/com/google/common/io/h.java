package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class h extends OutputStream {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteSource f32189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    @GuardedBy("this")
    public c f6348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final File f6349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public OutputStream f6350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6351a;

    @CheckForNull
    @GuardedBy("this")
    public File b;

    public class a extends ByteSource {
        public a() {
        }

        public void finalize() {
            try {
                h.this.k();
            } catch (Throwable th) {
                th.printStackTrace(System.err);
            }
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return h.this.j();
        }
    }

    public class b extends ByteSource {
        public b() {
        }

        @Override // com.google.common.io.ByteSource
        public InputStream m() throws IOException {
            return h.this.j();
        }
    }

    public static class c extends ByteArrayOutputStream {
        public c() {
        }

        public byte[] g() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public h(int i) {
        this(i, false);
    }

    @GuardedBy("this")
    private void update(int i) throws IOException {
        c cVar = this.f6348a;
        if (cVar == null || cVar.getCount() + i <= this.K) {
            return;
        }
        File fileCreateTempFile = File.createTempFile("FileBackedOutputStream", null, this.f6349a);
        if (this.f6351a) {
            fileCreateTempFile.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(this.f6348a.g(), 0, this.f6348a.getCount());
            fileOutputStream.flush();
            this.f6350a = fileOutputStream;
            this.b = fileCreateTempFile;
            this.f6348a = null;
        } catch (IOException e) {
            fileCreateTempFile.delete();
            throw e;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f6350a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.f6350a.flush();
    }

    public ByteSource g() {
        return this.f32189a;
    }

    @VisibleForTesting
    @CheckForNull
    public synchronized File h() {
        return this.b;
    }

    public final synchronized InputStream j() throws IOException {
        if (this.b != null) {
            return new FileInputStream(this.b);
        }
        Objects.requireNonNull(this.f6348a);
        return new ByteArrayInputStream(this.f6348a.g(), 0, this.f6348a.getCount());
    }

    public synchronized void k() throws IOException {
        a aVar = null;
        try {
            close();
            c cVar = this.f6348a;
            if (cVar == null) {
                this.f6348a = new c(aVar);
            } else {
                cVar.reset();
            }
            this.f6350a = this.f6348a;
            File file = this.b;
            if (file != null) {
                this.b = null;
                if (!file.delete()) {
                    String strValueOf = String.valueOf(file);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                    sb.append("Could not delete: ");
                    sb.append(strValueOf);
                    throw new IOException(sb.toString());
                }
            }
        } catch (Throwable th) {
            if (this.f6348a == null) {
                this.f6348a = new c(aVar);
            } else {
                this.f6348a.reset();
            }
            this.f6350a = this.f6348a;
            File file2 = this.b;
            if (file2 != null) {
                this.b = null;
                if (!file2.delete()) {
                    String strValueOf2 = String.valueOf(file2);
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 18);
                    sb2.append("Could not delete: ");
                    sb2.append(strValueOf2);
                    throw new IOException(sb2.toString());
                }
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        update(1);
        this.f6350a.write(i);
    }

    public h(int i, boolean z) {
        this(i, z, null);
    }

    public h(int i, boolean z, @CheckForNull File file) {
        this.K = i;
        this.f6351a = z;
        this.f6349a = file;
        c cVar = new c(null);
        this.f6348a = cVar;
        this.f6350a = cVar;
        if (z) {
            this.f32189a = new a();
        } else {
            this.f32189a = new b();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        update(i2);
        this.f6350a.write(bArr, i, i2);
    }
}
