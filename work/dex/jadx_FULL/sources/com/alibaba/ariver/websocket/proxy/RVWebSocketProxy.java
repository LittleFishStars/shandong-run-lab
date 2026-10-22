package com.alibaba.ariver.websocket.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.websocket.core.c;
import com.alibaba.ariver.websocket.core.d;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVWebSocketProxy extends Proxiable {
    d createWebSocketClient(String str, String str2, Map<String, String> map, c cVar);
}
