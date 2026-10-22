package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Framedata {

    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void a(Framedata framedata);

    ByteBuffer c();

    boolean d();

    boolean e();

    Opcode f();
}
