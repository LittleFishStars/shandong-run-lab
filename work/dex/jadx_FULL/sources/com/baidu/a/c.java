package com.baidu.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends BroadcastReceiver {
    private static boolean f = true;
    private static boolean g = true;
    private boolean b = false;
    private boolean c = true;
    private boolean d = true;
    private String e = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ExecutorService f26240a = Executors.newFixedThreadPool(1);

    public class a implements Callable<Object> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            DatagramSocket datagramSocket;
            DatagramSocket datagramSocket2;
            InetSocketAddress inetSocketAddress = new InetSocketAddress("2001:4860:4860::8888", 443);
            InetSocketAddress inetSocketAddress2 = new InetSocketAddress("180.76.76.76", 80);
            try {
                datagramSocket = new DatagramSocket();
                try {
                    datagramSocket.connect(inetSocketAddress2);
                    boolean unused = c.g = true;
                } catch (SocketException unused2) {
                    boolean unused3 = c.g = false;
                }
            } catch (SocketException unused4) {
                datagramSocket = null;
            }
            if (datagramSocket != null) {
                try {
                    datagramSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                datagramSocket2 = new DatagramSocket();
                try {
                    datagramSocket2.connect(inetSocketAddress);
                    boolean unused5 = c.f = true;
                } catch (SocketException unused6) {
                    datagramSocket = datagramSocket2;
                    boolean unused7 = c.f = false;
                    datagramSocket2 = datagramSocket;
                }
            } catch (SocketException unused8) {
            }
            if (datagramSocket2 != null) {
                try {
                    datagramSocket2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            j.a("isIPv4Reachable(%s), isIPv6Reachable(%s)", Boolean.valueOf(c.g), Boolean.valueOf(c.f));
            return null;
        }
    }

    private void a(Context context) {
        j.a("Network change, clearCache(%b) httpDnsPrefetch(%b)", Boolean.valueOf(this.c), Boolean.valueOf(this.d));
        g gVarA = g.a();
        gVarA.b();
        com.baidu.a.a aVarA = com.baidu.a.a.a(context);
        a();
        ArrayList<String> arrayListB = aVarA.a().b();
        if (this.c) {
            aVarA.a().a();
            aVarA.b().a();
        }
        if (!this.d || arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        gVarA.a(arrayListB, new i(context));
    }

    public static boolean b() {
        return g;
    }

    public static boolean c() {
        return f;
    }

    public void a() {
        this.f26240a.submit(new a());
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.d = z;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        String extraInfo;
        String str = "";
        if (!this.b) {
            this.b = true;
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(context);
                return;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            try {
                if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                    if (networkInfo2 == null || networkInfo2.getState() != NetworkInfo.State.CONNECTED) {
                        string = "";
                    } else {
                        extraInfo = networkInfo2.getExtraInfo();
                    }
                    if (!this.e.equals(string) && string != "") {
                        j.a("Current net type: %s.", string);
                        a(context);
                    }
                    this.e = string;
                }
                extraInfo = networkInfo.getExtraInfo();
                if (!this.e.equals(string)) {
                    j.a("Current net type: %s.", string);
                    a(context);
                }
            } catch (RuntimeException e) {
                String str2 = string;
                e = e;
                str = str2;
                e.printStackTrace();
                try {
                    a(context);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                string = str;
            }
            string = extraInfo.toString();
            this.e = string;
        } catch (RuntimeException e3) {
            e = e3;
        }
    }
}
