package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.c.i;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface g {
    i a(WebSocket webSocket, Draft draft, com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar);

    String a(WebSocket webSocket);

    void a(WebSocket webSocket, int i, String str);

    void a(WebSocket webSocket, int i, String str, boolean z);

    void a(WebSocket webSocket, com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar);

    void a(WebSocket webSocket, com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, com.alipay.android.phone.mobilesdk.socketcraft.c.h hVar);

    void a(WebSocket webSocket, com.alipay.android.phone.mobilesdk.socketcraft.c.f fVar);

    void a(WebSocket webSocket, Framedata framedata);

    void a(WebSocket webSocket, Exception exc);

    void a(WebSocket webSocket, String str);

    void a(WebSocket webSocket, ByteBuffer byteBuffer);

    void b(WebSocket webSocket);

    void b(WebSocket webSocket, int i, String str, boolean z);

    void b(WebSocket webSocket, Framedata framedata);

    InetSocketAddress c(WebSocket webSocket);

    void c(WebSocket webSocket, Framedata framedata);

    InetSocketAddress d(WebSocket webSocket);
}
