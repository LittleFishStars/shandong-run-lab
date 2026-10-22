package com.google.android.exoplayer2.source.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.zj.adlib.sb0;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RtspMessageChannel implements Closeable {
    public static final int K = 554;
    public static final Charset b = com.google.common.base.b.c;
    public static final String f = "RtspMessageChannel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageListener f30962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f4375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Socket f4377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile boolean f4379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Loader f4376a = new Loader("ExoPlayer:RtspMessageChannel:ReceiverLoader");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<Integer, InterleavedBinaryDataListener> f4378a = Collections.synchronizedMap(new HashMap());

    public interface InterleavedBinaryDataListener {
        void d(byte[] bArr);
    }

    public interface MessageListener {
        default void a(Exception exc) {
        }

        void b(List<String> list);

        default void c(List<String> list, Exception exc) {
        }
    }

    public final class b implements Loader.Callback<d> {
        public b() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void M(d dVar, long j, long j2, boolean z) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void K(d dVar, long j, long j2) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Callback
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.b A(d dVar, long j, long j2, IOException iOException, int i) {
            if (!RtspMessageChannel.this.f4379a) {
                RtspMessageChannel.this.f30962a.a(iOException);
            }
            return Loader.f5050c;
        }
    }

    public static final class c {
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f4380a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<String> f4381a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30964a = 1;

        public static byte[] d(byte b2, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b2, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte b3 = dataInputStream.readByte();
                bArr[1] = b3;
                byteArrayOutputStream.write(b3);
            }
        }

        public final ImmutableList<String> a(byte[] bArr) {
            sb0.i(this.f30964a == 3);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                throw new IllegalArgumentException("Message body is empty or does not end with a LF.");
            }
            this.f4381a.add((bArr.length <= 1 || bArr[bArr.length + (-2)] != 13) ? new String(bArr, 0, bArr.length - 1, RtspMessageChannel.b) : new String(bArr, 0, bArr.length - 2, RtspMessageChannel.b));
            ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) this.f4381a);
            e();
            return immutableListCopyOf;
        }

        @Nullable
        public final ImmutableList<String> b(byte[] bArr) throws ParserException {
            sb0.a(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, RtspMessageChannel.b);
            this.f4381a.add(str);
            int i = this.f30964a;
            if (i == 1) {
                if (!g.f(str)) {
                    return null;
                }
                this.f30964a = 2;
                return null;
            }
            if (i != 2) {
                throw new IllegalStateException();
            }
            long jG = g.g(str);
            if (jG != -1) {
                this.f4380a = jG;
            }
            if (!str.isEmpty()) {
                return null;
            }
            if (this.f4380a > 0) {
                this.f30964a = 3;
                return null;
            }
            ImmutableList<String> immutableListCopyOf = ImmutableList.copyOf((Collection) this.f4381a);
            e();
            return immutableListCopyOf;
        }

        public ImmutableList<String> c(byte b2, DataInputStream dataInputStream) throws IOException {
            ImmutableList<String> immutableListB = b(d(b2, dataInputStream));
            while (immutableListB == null) {
                if (this.f30964a == 3) {
                    long j = this.f4380a;
                    if (j <= 0) {
                        throw new IllegalStateException("Expects a greater than zero Content-Length.");
                    }
                    int iD = Ints.d(j);
                    sb0.i(iD != -1);
                    byte[] bArr = new byte[iD];
                    dataInputStream.readFully(bArr, 0, iD);
                    immutableListB = a(bArr);
                } else {
                    immutableListB = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return immutableListB;
        }

        public final void e() {
            this.f4381a.clear();
            this.f30964a = 1;
            this.f4380a = 0L;
        }
    }

    public final class d implements Loader.Loadable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f30965a = 36;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f4382a = new c();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DataInputStream f4384a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile boolean f4385a;

        public d(InputStream inputStream) {
            this.f4384a = new DataInputStream(inputStream);
        }

        public final void a() throws IOException {
            int unsignedByte = this.f4384a.readUnsignedByte();
            int unsignedShort = this.f4384a.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            this.f4384a.readFully(bArr, 0, unsignedShort);
            InterleavedBinaryDataListener interleavedBinaryDataListener = (InterleavedBinaryDataListener) RtspMessageChannel.this.f4378a.get(Integer.valueOf(unsignedByte));
            if (interleavedBinaryDataListener == null || RtspMessageChannel.this.f4379a) {
                return;
            }
            interleavedBinaryDataListener.d(bArr);
        }

        public final void b(byte b) throws IOException {
            if (RtspMessageChannel.this.f4379a) {
                return;
            }
            RtspMessageChannel.this.f30962a.b(this.f4382a.c(b, this.f4384a));
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.f4385a = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException {
            while (!this.f4385a) {
                byte b = this.f4384a.readByte();
                if (b == 36) {
                    a();
                } else {
                    b(b);
                }
            }
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f30966a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HandlerThread f4386a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final OutputStream f4388a;

        public e(OutputStream outputStream) {
            this.f4388a = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.f4386a = handlerThread;
            handlerThread.start();
            this.f30966a = new Handler(handlerThread.getLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(byte[] bArr, List list) {
            try {
                this.f4388a.write(bArr);
            } catch (Exception e) {
                if (RtspMessageChannel.this.f4379a) {
                    return;
                }
                RtspMessageChannel.this.f30962a.c(list, e);
            }
        }

        public void c(final List<String> list) {
            final byte[] bArrB = g.b(list);
            this.f30966a.post(new Runnable() { // from class: com.zj.adlib.vk7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45375a.b(bArrB, list);
                }
            });
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.f30966a;
            final HandlerThread handlerThread = this.f4386a;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: com.zj.adlib.wk7
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.f4386a.join();
            } catch (InterruptedException unused) {
                this.f4386a.interrupt();
            }
        }
    }

    public RtspMessageChannel(MessageListener messageListener) {
        this.f30962a = messageListener;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4379a) {
            return;
        }
        try {
            e eVar = this.f4375a;
            if (eVar != null) {
                eVar.close();
            }
            this.f4376a.j();
            Socket socket = this.f4377a;
            if (socket != null) {
                socket.close();
            }
        } finally {
            this.f4379a = true;
        }
    }

    public void e(Socket socket) throws IOException {
        this.f4377a = socket;
        this.f4375a = new e(socket.getOutputStream());
        this.f4376a.l(new d(socket.getInputStream()), new b(), 0);
    }

    public void f(int i, InterleavedBinaryDataListener interleavedBinaryDataListener) {
        this.f4378a.put(Integer.valueOf(i), interleavedBinaryDataListener);
    }

    public void g(List<String> list) {
        sb0.k(this.f4375a);
        this.f4375a.c(list);
    }
}
