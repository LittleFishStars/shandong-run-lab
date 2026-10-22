package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.c.i;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class d implements g {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public i a(WebSocket webSocket, Draft draft, com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar) {
        return new com.alipay.android.phone.mobilesdk.socketcraft.c.e();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void a(WebSocket webSocket, com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void a(WebSocket webSocket, com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, com.alipay.android.phone.mobilesdk.socketcraft.c.h hVar) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void a(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void b(WebSocket webSocket, Framedata framedata) {
        com.alipay.android.phone.mobilesdk.socketcraft.framing.d dVar = new com.alipay.android.phone.mobilesdk.socketcraft.framing.d(framedata);
        dVar.a(Framedata.Opcode.PONG);
        webSocket.a(dVar);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public void c(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.g
    public String a(WebSocket webSocket) throws InvalidHandshakeException {
        InetSocketAddress inetSocketAddressD = webSocket.d();
        if (inetSocketAddressD == null) {
            throw new InvalidHandshakeException("socket not bound");
        }
        StringBuffer stringBuffer = new StringBuffer(90);
        stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
        stringBuffer.append(inetSocketAddressD.getPort());
        stringBuffer.append("\" /></cross-domain-policy>\u0000");
        return stringBuffer.toString();
    }
}
