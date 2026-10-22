package com.alipay.android.phone.mobilesdk.socketcraft.d.c;

import com.alipay.mobile.common.transport.utils.SSLSocketUtil;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.alipay.android.phone.mobilesdk.socketcraft.f.c.a {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.c.a, com.alipay.android.phone.mobilesdk.socketcraft.f.c.b
    public void a(SSLSocket sSLSocket, String str) {
        SSLSocketUtil.enableTlsExtensions(sSLSocket, str);
    }
}
