package com.zj.adlib;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ei4 implements Handler.Callback {
    public static final int N = 1;
    public static final int O = 2;
    public static final int P = 3;
    public static final int Q = 4;
    public static final String h = "JLog";
    public static final String i = "</n>";
    public final int K;
    public final int L;
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f41441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerThread f16314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PrintWriter f16315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Socket f16316a;
    public PrintWriter b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Socket f16317b;
    public final String f;
    public final String g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f41442a;
        public String b;

        public a(String str, String str2) {
            this.f41442a = str;
            this.b = str2;
        }
    }

    public ei4(String str, int i2) {
        this(str, i2, -1, -1);
    }

    public final void a() {
        try {
            this.f16316a = new Socket(this.f, this.K);
            this.f16315a = new PrintWriter(this.f16316a.getOutputStream());
        } catch (IOException e) {
            System.err.println("init JLog error " + e.getMessage());
        }
    }

    public final void b() {
        try {
            this.f16317b = new Socket(this.f, this.L);
            this.b = new PrintWriter(this.f16317b.getOutputStream());
        } catch (IOException e) {
            System.err.println("init JLog error " + e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        try {
            if (this.f16316a != null) {
                try {
                    PrintWriter printWriter = this.f16315a;
                    if (printWriter != null) {
                        printWriter.flush();
                    }
                    this.f16316a.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.f16316a = null;
                this.f16315a = null;
            }
            try {
                if (this.f16317b != null) {
                    try {
                        PrintWriter printWriter2 = this.b;
                        if (printWriter2 != null) {
                            printWriter2.flush();
                        }
                        this.f16317b.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                this.f16317b = null;
                this.b = null;
            }
        } catch (Throwable th) {
            this.f16316a = null;
            this.f16315a = null;
            throw th;
        }
    }

    public String d() {
        return this.g;
    }

    public String e(String str) {
        return String.format(Locale.getDefault(), "http://%s:%d/string?key=%s", this.f, Integer.valueOf(this.M), str);
    }

    public final boolean f() {
        Socket socket = this.f16316a;
        return socket != null && socket.isConnected();
    }

    public final boolean g() {
        Socket socket = this.f16317b;
        return socket != null && socket.isConnected();
    }

    public final void h(a aVar) {
        if (!g()) {
            b();
        }
        PrintWriter printWriter = this.b;
        if (printWriter != null) {
            try {
                printWriter.write(aVar.f41442a + "<::>" + aVar.b + i);
                this.b.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a();
            return false;
        }
        if (i2 == 2) {
            c();
            return false;
        }
        if (i2 == 3) {
            i((String) message.obj);
            return false;
        }
        if (i2 != 4) {
            return false;
        }
        h((a) message.obj);
        return false;
    }

    public final void i(String str) {
        if (!f()) {
            a();
        }
        PrintWriter printWriter = this.f16315a;
        if (printWriter != null) {
            try {
                printWriter.write(this.g + str + i);
                this.f16315a.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void j(@NonNull String str) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 3;
        this.f41441a.sendMessage(messageObtain);
    }

    public void k() {
        this.f41441a.sendEmptyMessage(2);
    }

    public boolean l(@NonNull String str, @NonNull String str2) {
        if (this.L < 0) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = new a(str2, str);
        messageObtain.what = 4;
        this.f41441a.sendMessage(messageObtain);
        return true;
    }

    public ei4(String str, int i2, int i3, int i4) {
        this.f = str;
        this.K = i2;
        this.L = i3;
        this.M = i4;
        HandlerThread handlerThread = new HandlerThread("JLogThread");
        this.f16314a = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f41441a = handler;
        handler.sendEmptyMessage(1);
        this.g = "[" + Build.MODEL + "]";
    }
}
