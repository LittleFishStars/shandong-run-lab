package com.ipd.dsp.internal.n0;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements com.ipd.dsp.internal.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FileChannel f38460a;

    @NonNull
    public final ParcelFileDescriptor b;

    @NonNull
    public final BufferedOutputStream c;

    @NonNull
    public final FileOutputStream d;

    public static class a implements com.ipd.dsp.internal.n0.a.InterfaceC0905a {
        @Override // com.ipd.dsp.internal.n0.a.InterfaceC0905a
        public com.ipd.dsp.internal.n0.a a(Context context, File file, int i) throws FileNotFoundException {
            return new b(context, Uri.fromFile(file), i);
        }

        @Override // com.ipd.dsp.internal.n0.a.InterfaceC0905a
        public boolean a() {
            return true;
        }

        @Override // com.ipd.dsp.internal.n0.a.InterfaceC0905a
        public com.ipd.dsp.internal.n0.a a(Context context, Uri uri, int i) throws FileNotFoundException {
            return new b(context, uri, i);
        }
    }

    public b(Context context, Uri uri, int i) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            throw new FileNotFoundException("result of " + uri + " is null!");
        }
        this.b = parcelFileDescriptorOpenFileDescriptor;
        FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
        this.d = fileOutputStream;
        this.f38460a = fileOutputStream.getChannel();
        this.c = new BufferedOutputStream(fileOutputStream, i);
    }

    @Override // com.ipd.dsp.internal.n0.a
    public void a() throws IOException {
        this.c.flush();
        this.b.getFileDescriptor().sync();
    }

    @Override // com.ipd.dsp.internal.n0.a
    public void b(long j) throws IOException {
        this.f38460a.position(j);
    }

    @Override // com.ipd.dsp.internal.n0.a
    public void close() throws IOException {
        this.c.close();
        this.d.close();
        this.b.close();
    }

    @Override // com.ipd.dsp.internal.n0.a
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.c.write(bArr, i, i2);
    }

    @Override // com.ipd.dsp.internal.n0.a
    public void a(long j) {
        try {
            Os.posix_fallocate(this.b.getFileDescriptor(), 0L, j);
        } catch (Throwable th) {
            if (th instanceof ErrnoException) {
                int i = th.errno;
                if (i == OsConstants.ENOSYS || i == OsConstants.ENOTSUP) {
                    com.ipd.dsp.internal.g0.c.c("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                    try {
                        Os.ftruncate(this.b.getFileDescriptor(), j);
                        return;
                    } catch (Throwable th2) {
                        com.ipd.dsp.internal.g0.c.c("DownloadUriOutputStream", "It can't pre-allocate length(" + j + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + th2);
                        return;
                    }
                }
                return;
            }
            com.ipd.dsp.internal.g0.c.c("DownloadUriOutputStream", "It can't pre-allocate length(" + j + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + th);
        }
    }

    public b(@NonNull FileChannel fileChannel, @NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull FileOutputStream fileOutputStream, @NonNull BufferedOutputStream bufferedOutputStream) {
        this.f38460a = fileChannel;
        this.b = parcelFileDescriptor;
        this.d = fileOutputStream;
        this.c = bufferedOutputStream;
    }
}
