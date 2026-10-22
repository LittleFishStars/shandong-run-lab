package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface WebSocket {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25281a = 80;
    public static final int b = 443;

    public enum READYSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public enum Role {
        CLIENT,
        SERVER
    }

    void a();

    void a(int i);

    void a(int i, String str);

    void a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z);

    void a(Framedata framedata);

    void a(String str);

    void a(ByteBuffer byteBuffer);

    void a(byte[] bArr);

    void b(int i, String str);

    boolean b();

    InetSocketAddress c();

    InetSocketAddress d();

    boolean e();

    boolean f();

    boolean g();

    boolean h();

    boolean i();

    Draft j();

    READYSTATE k();

    String l();
}
