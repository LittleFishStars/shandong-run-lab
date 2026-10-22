package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class u implements Dns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile List<InetAddress> f39408a = new ArrayList();

    public u(String str) {
    }

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        return (!"sdk.1rtb.net".equals(str) || f39408a == null || f39408a.isEmpty()) ? Dns.SYSTEM.lookup(str) : f39408a;
    }
}
