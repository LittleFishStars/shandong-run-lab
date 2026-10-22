package com.bykv.vk.component.ttvideo.mediakit.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class DNSServerIP {
    private static final String TAG = "DNSServerIP";
    private static final int UPDATE_PEROID = 300000;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;

    public static String getDNSServerIP() {
        updateDNSServerIP();
        return mServerIP;
    }

    public static void updateDNSServerIP() {
        if (System.currentTimeMillis() - mServerIPTime < 300000) {
            return;
        }
        AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.DNSServerIP.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                    if (byName != null) {
                        String unused = DNSServerIP.mServerIP = byName.getHostAddress();
                        long unused2 = DNSServerIP.mServerIPTime = System.currentTimeMillis();
                    }
                } catch (UnknownHostException unused3) {
                }
            }
        });
    }
}
