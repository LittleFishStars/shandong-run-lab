package com.alibaba.ariver.websocket.core;

import android.util.Base64;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends a implements com.alipay.android.phone.mobilesdk.socketcraft.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24535a = "AriverWebSocket:NXWebSocketClientAdapter";
    private static boolean c = false;
    private com.alipay.android.phone.mobilesdk.socketcraft.a.b b;

    public b(String str, URI uri, Map<String, String> map, c cVar) {
        super(str, uri.toString(), map, cVar);
        com.alipay.android.phone.mobilesdk.socketcraft.a.a aVar = new com.alipay.android.phone.mobilesdk.socketcraft.a.a();
        aVar.a(com.alipay.android.phone.mobilesdk.socketcraft.a.c.f25284a, str);
        this.b = new com.alipay.android.phone.mobilesdk.socketcraft.a.b(uri, map, this, aVar);
    }

    @Override // com.alibaba.ariver.websocket.core.a
    public void a() {
        if (c) {
            return;
        }
        com.alipay.android.phone.mobilesdk.socketcraft.f.b.c.a(new com.alipay.android.phone.mobilesdk.socketcraft.f.b.a());
        c = true;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.d
    public void b(String str) {
        if (e() != null) {
            e().a(str);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.d
    public void c(String str) {
        if (e() != null) {
            e().a(WebSocketResultEnum.getResultEnumByWsMsg(str).getErrCode(), str);
        }
    }

    @Override // com.alibaba.ariver.websocket.core.d
    public void f() {
        this.b.p();
    }

    @Override // com.alibaba.ariver.websocket.core.d
    public void g() {
        this.b.o();
    }

    @Override // com.alibaba.ariver.websocket.core.d
    public void h() {
        if (this.b.g() || this.b.i()) {
            RVLogger.w(f24535a, "close but already closed!");
        } else {
            this.b.a();
        }
    }

    @Override // com.alibaba.ariver.websocket.core.d
    public boolean i() {
        return this.b.f();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.d
    public void j() {
        if (e() != null) {
            e().a();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.d
    public void k() {
        if (e() != null) {
            e().b();
        }
    }

    @Override // com.alibaba.ariver.websocket.core.d
    public void a(byte[] bArr) {
        RVLogger.d(f24535a, "send bytes: " + bArr);
        this.b.a(ByteBuffer.wrap(Base64.decode(bArr, 2)));
    }

    @Override // com.alibaba.ariver.websocket.core.d
    public void a(String str) {
        RVLogger.d(f24535a, "send msg: " + str);
        this.b.a(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.a.d
    public void a(ByteBuffer byteBuffer) {
        if (e() != null) {
            e().a(byteBuffer.array());
        }
    }
}
