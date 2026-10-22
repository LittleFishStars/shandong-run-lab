package com.byazt.mk;

import com.alipay.sdk.m.o.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 66})
public final class t {
    public static final Logger c = Logger.getLogger(t.class.getName());

    private t() {
    }

    public static n c(my myVar) {
        return new yp(myVar);
    }

    public static rh tt(File file) throws FileNotFoundException {
        if (file != null) {
            return c(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static rh ve(File file) throws FileNotFoundException {
        if (file != null) {
            return c(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static uj c(rh rhVar) {
        return new u(rhVar);
    }

    public static rh c(OutputStream outputStream) {
        return c(outputStream, new gt());
    }

    public static my tt(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                c cVarVe = ve(socket);
                return cVarVe.c(c(socket.getInputStream(), cVarVe));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static c ve(final Socket socket) {
        return new c() { // from class: com.byazt.mk.t.4
            @Override // com.byazt.mk.c
            public void m_() {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (!t.c(e)) {
                        throw e;
                    }
                    t.c.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                } catch (Exception e2) {
                    t.c.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }

            @Override // com.byazt.mk.c
            public IOException tt(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException(b.r0);
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
        };
    }

    private static rh c(final OutputStream outputStream, final gt gtVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (gtVar != null) {
            return new rh() { // from class: com.byazt.mk.t.1
                @Override // com.byazt.mk.rh
                public void a_(ve veVar, long j) throws IOException {
                    try {
                        rl.c(veVar.tt, 0L, j);
                        while (j > 0) {
                            gtVar.sp();
                            z zVar = veVar.c;
                            int iMin = (int) Math.min(j, zVar.ve - zVar.tt);
                            outputStream.write(zVar.c, zVar.tt, iMin);
                            int i = zVar.tt + iMin;
                            zVar.tt = i;
                            long j2 = iMin;
                            j -= j2;
                            veVar.tt -= j2;
                            if (i == zVar.ve) {
                                veVar.c = zVar.tt();
                                m.c(zVar);
                            }
                        }
                    } catch (IOException | Exception unused) {
                    }
                }

                @Override // com.byazt.mk.rh
                public gt c() {
                    return gtVar;
                }

                @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.byazt.mk.rh, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static rh c(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                c cVarVe = ve(socket);
                return cVarVe.c(c(socket.getOutputStream(), cVarVe));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static my c(InputStream inputStream) {
        return c(inputStream, new gt());
    }

    private static my c(final InputStream inputStream, final gt gtVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (gtVar != null) {
            return new my() { // from class: com.byazt.mk.t.2
                @Override // com.byazt.mk.my
                public long c(ve veVar, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        gtVar.sp();
                        z zVarN = veVar.n(1);
                        int i = inputStream.read(zVarN.c, zVarN.ve, (int) Math.min(j, 8192 - zVarN.ve));
                        if (i == -1) {
                            return -1L;
                        }
                        zVarN.ve += i;
                        long j2 = i;
                        veVar.tt += j2;
                        return j2;
                    } catch (AssertionError e) {
                        if (t.c(e)) {
                            throw new IOException(e);
                        }
                        throw e;
                    } catch (Throwable th) {
                        throw new IOException(th.getMessage());
                    }
                }

                @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }

                @Override // com.byazt.mk.my
                public gt c() {
                    return gtVar;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static my c(File file) throws FileNotFoundException {
        if (file != null) {
            return c(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static rh c() {
        return new rh() { // from class: com.byazt.mk.t.3
            @Override // com.byazt.mk.rh
            public void a_(ve veVar, long j) throws IOException {
                veVar.x(j);
            }

            @Override // com.byazt.mk.rh
            public gt c() {
                return gt.ve;
            }

            @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
            }

            @Override // com.byazt.mk.rh, java.io.Flushable
            public void flush() throws IOException {
            }
        };
    }

    public static boolean c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
