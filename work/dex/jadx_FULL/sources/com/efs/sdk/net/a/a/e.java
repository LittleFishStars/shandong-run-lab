package com.efs.sdk.net.a.a;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends FilterOutputStream {
    private static final ExecutorService b = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Future<Void> f29910a;

    public static class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f29911a;
        private final OutputStream b;

        public a(InputStream inputStream, OutputStream outputStream) {
            this.f29911a = inputStream;
            this.b = outputStream;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws IOException {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f29911a);
            try {
                i.a(gZIPInputStream, this.b, new byte[1024]);
                return null;
            } finally {
                gZIPInputStream.close();
                this.b.close();
            }
        }
    }

    private e(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.f29910a = future;
    }

    public static e a(OutputStream outputStream) {
        PipedInputStream pipedInputStream = new PipedInputStream();
        return new e(new PipedOutputStream(pipedInputStream), b.submit(new a(pipedInputStream, outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        try {
            super.close();
            try {
            } catch (IOException e) {
                throw e;
            }
        } finally {
            try {
                a(this.f29910a);
            } catch (IOException unused) {
            }
        }
    }

    private static <T> T a(Future<T> future) throws Throwable {
        while (true) {
            try {
                return future.get();
            } catch (InterruptedException unused) {
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                d.a(cause, IOException.class);
                d.a(cause, Error.class);
                d.a(cause, RuntimeException.class);
                throw new RuntimeException(cause);
            }
        }
    }
}
