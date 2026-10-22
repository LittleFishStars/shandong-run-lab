package com.alipay.android.phone.mobilesdk.socketcraft.framing;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface c extends Framedata {
    void a(Framedata.Opcode opcode);

    void a(ByteBuffer byteBuffer);

    void a(boolean z);

    void b(boolean z);
}
