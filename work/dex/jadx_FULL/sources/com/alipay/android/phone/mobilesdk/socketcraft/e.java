package com.alipay.android.phone.mobilesdk.socketcraft;

import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import java.net.Socket;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface e {
    WebSocket a(d dVar, Draft draft, Socket socket);

    WebSocket a(d dVar, List<Draft> list, Socket socket);
}
