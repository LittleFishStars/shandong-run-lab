package com.czhj.wire.okio;

import com.alipay.sdk.m.o.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Okio {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f29536a = Logger.getLogger(Okio.class.getName());

    private Okio() {
    }

    private static AsyncTimeout a(final Socket socket) {
        return new AsyncTimeout() { // from class: com.czhj.wire.okio.Okio.4
            @Override // com.czhj.wire.okio.AsyncTimeout
            public IOException newTimeoutException(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(b.r0);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // com.czhj.wire.okio.AsyncTimeout
            public void timedOut() {
                Level level;
                StringBuilder sb;
                Logger logger;
                Throwable th;
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!Okio.a(e)) {
                        throw e;
                    }
                    Logger logger2 = Okio.f29536a;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    th = e;
                    logger = logger2;
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger.log(level, sb.toString(), th);
                } catch (Exception e2) {
                    Logger logger3 = Okio.f29536a;
                    level = Level.WARNING;
                    sb = new StringBuilder();
                    th = e2;
                    logger = logger3;
                    sb.append("Failed to close timed out socket ");
                    sb.append(socket);
                    logger.log(level, sb.toString(), th);
                }
            }
        };
    }

    private static Sink a(final OutputStream outputStream, final Timeout timeout) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new Sink() { // from class: com.czhj.wire.okio.Okio.1
                @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.czhj.wire.okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                @Override // com.czhj.wire.okio.Sink
                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                @Override // com.czhj.wire.okio.Sink
                public void write(Buffer buffer, long j) throws IOException {
                    Util.checkOffsetAndCount(buffer.c, 0L, j);
                    while (j > 0) {
                        timeout.throwIfReached();
                        Segment segment = buffer.b;
                        int iMin = (int) Math.min(j, segment.e - segment.d);
                        outputStream.write(segment.c, segment.d, iMin);
                        int i = segment.d + iMin;
                        segment.d = i;
                        long j2 = iMin;
                        j -= j2;
                        buffer.c -= j2;
                        if (i == segment.e) {
                            buffer.b = segment.pop();
                            SegmentPool.a(segment);
                        }
                    }
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    private static Source a(final InputStream inputStream, final Timeout timeout) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new Source() { // from class: com.czhj.wire.okio.Okio.2
                @Override // com.czhj.wire.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                @Override // com.czhj.wire.okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        timeout.throwIfReached();
                        Segment segmentA = buffer.a(1);
                        int i = inputStream.read(segmentA.c, segmentA.e, (int) Math.min(j, 8192 - segmentA.e));
                        if (i != -1) {
                            segmentA.e += i;
                            long j2 = i;
                            buffer.c += j2;
                            return j2;
                        }
                        if (segmentA.d != segmentA.e) {
                            return -1L;
                        }
                        buffer.b = segmentA.pop();
                        SegmentPool.a(segmentA);
                        return -1L;
                    } catch (AssertionError e) {
                        if (Okio.a(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    }
                }

                @Override // com.czhj.wire.okio.Source
                public Timeout timeout() {
                    return timeout;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink blackhole() {
        return new Sink() { // from class: com.czhj.wire.okio.Okio.3
            @Override // com.czhj.wire.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.czhj.wire.okio.Sink, java.io.Flushable
            public void flush() throws IOException {
            }

            @Override // com.czhj.wire.okio.Sink
            public Timeout timeout() {
                return Timeout.NONE;
            }

            @Override // com.czhj.wire.okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                buffer.skip(j);
            }
        };
    }

    public static BufferedSink buffer(Sink sink) {
        return new RealBufferedSink(sink);
    }

    public static BufferedSource buffer(Source source) {
        return new RealBufferedSource(source);
    }

    public static Sink sink(File file) throws FileNotFoundException {
        if (file != null) {
            return sink(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(OutputStream outputStream) {
        return a(outputStream, new Timeout());
    }

    public static Sink sink(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        AsyncTimeout asyncTimeoutA = a(socket);
        return asyncTimeoutA.sink(a(socket.getOutputStream(), asyncTimeoutA));
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        try {
            return sink(Files.newOutputStream(path, openOptionArr));
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    public static Source source(File file) throws FileNotFoundException {
        if (file != null) {
            return source(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(InputStream inputStream) {
        return a(inputStream, new Timeout());
    }

    public static Source source(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        AsyncTimeout asyncTimeoutA = a(socket);
        return asyncTimeoutA.source(a(socket.getInputStream(), asyncTimeoutA));
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        try {
            return source(Files.newInputStream(path, openOptionArr));
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }
}
