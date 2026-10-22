package com.blankj.utilcode.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.igexin.sdk.PushConsts;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f28155a = 3000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static j f1318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Set<Utils.Consumer<j>> f1319a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f1320a;

    public static final class NetworkChangedReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkType f28156a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Set<OnNetworkStatusChangedListener> f1321a = new HashSet();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ OnNetworkStatusChangedListener f1322a;

            public a(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
                this.f1322a = onNetworkStatusChangedListener;
            }

            @Override // java.lang.Runnable
            @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
            public void run() {
                int size = NetworkChangedReceiver.this.f1321a.size();
                NetworkChangedReceiver.this.f1321a.add(this.f1322a);
                if (size == 0 && NetworkChangedReceiver.this.f1321a.size() == 1) {
                    NetworkChangedReceiver.this.f28156a = NetworkUtils.t();
                    Utils.a().registerReceiver(NetworkChangedReceiver.e(), new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ OnNetworkStatusChangedListener f1323a;

            public b(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
                this.f1323a = onNetworkStatusChangedListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = NetworkChangedReceiver.this.f1321a.size();
                NetworkChangedReceiver.this.f1321a.remove(this.f1323a);
                if (size == 1 && NetworkChangedReceiver.this.f1321a.size() == 0) {
                    Utils.a().unregisterReceiver(NetworkChangedReceiver.e());
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
            public void run() {
                NetworkType networkTypeT = NetworkUtils.t();
                if (NetworkChangedReceiver.this.f28156a == networkTypeT) {
                    return;
                }
                NetworkChangedReceiver.this.f28156a = networkTypeT;
                if (networkTypeT == NetworkType.NETWORK_NO) {
                    Iterator it = NetworkChangedReceiver.this.f1321a.iterator();
                    while (it.hasNext()) {
                        ((OnNetworkStatusChangedListener) it.next()).onDisconnected();
                    }
                } else {
                    Iterator it2 = NetworkChangedReceiver.this.f1321a.iterator();
                    while (it2.hasNext()) {
                        ((OnNetworkStatusChangedListener) it2.next()).a(networkTypeT);
                    }
                }
            }
        }

        public static class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NetworkChangedReceiver f28160a = new NetworkChangedReceiver();
        }

        public static NetworkChangedReceiver e() {
            return d.f28160a;
        }

        public boolean f(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return false;
            }
            return this.f1321a.contains(onNetworkStatusChangedListener);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
                com.blankj.utilcode.util.i.U0(new c(), 1000L);
            }
        }

        @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
        public void registerListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return;
            }
            com.blankj.utilcode.util.i.T0(new a(onNetworkStatusChangedListener));
        }

        public void unregisterListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
            if (onNetworkStatusChangedListener == null) {
                return;
            }
            com.blankj.utilcode.util.i.T0(new b(onNetworkStatusChangedListener));
        }
    }

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    public interface OnNetworkStatusChangedListener {
        void a(NetworkType networkType);

        void onDisconnected();
    }

    public class a extends Utils.Task<Boolean> {
        public a(Utils.Consumer consumer) {
            super(consumer);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean f() {
            return Boolean.valueOf(NetworkUtils.A());
        }
    }

    public class b extends Utils.Task<Boolean> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Utils.Consumer consumer, String str) {
            super(consumer);
            this.f = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean f() {
            return Boolean.valueOf(NetworkUtils.H(this.f));
        }
    }

    public class c extends Utils.Task<Boolean> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Utils.Consumer consumer, String str) {
            super(consumer);
            this.f = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean f() {
            return Boolean.valueOf(NetworkUtils.D(this.f));
        }
    }

    public class d extends Utils.Task<Boolean> {
        public d(Utils.Consumer consumer) {
            super(consumer);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f40125a})
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean f() {
            return Boolean.valueOf(NetworkUtils.Q());
        }
    }

    public class e extends Utils.Task<String> {
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Utils.Consumer consumer, boolean z) {
            super(consumer);
            this.b = z;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public String f() {
            return NetworkUtils.n(this.b);
        }
    }

    public class f extends Utils.Task<String> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Utils.Consumer consumer, String str) {
            super(consumer);
            this.f = str;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public String f() {
            return NetworkUtils.k(this.f);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Utils.Consumer f28161a;

        public g(Utils.Consumer consumer) {
            this.f28161a = consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkUtils.f1319a.isEmpty()) {
                NetworkUtils.f1319a.add(this.f28161a);
                NetworkUtils.W();
            } else {
                this.f28161a.accept(NetworkUtils.f1318a);
                NetworkUtils.f1319a.add(this.f28161a);
            }
        }
    }

    public class h extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NetworkUtils.f1319a.iterator();
                while (it.hasNext()) {
                    ((Utils.Consumer) it.next()).accept(NetworkUtils.f1318a);
                }
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
        public void run() {
            NetworkUtils.X();
            j jVarX = NetworkUtils.x();
            if (NetworkUtils.P(NetworkUtils.f1318a.f28164a, jVarX.f28164a)) {
                return;
            }
            NetworkUtils.f1318a = jVarX;
            com.blankj.utilcode.util.i.T0(new a());
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Utils.Consumer f28163a;

        public i(Utils.Consumer consumer) {
            this.f28163a = consumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkUtils.f1319a.remove(this.f28163a);
            if (NetworkUtils.f1319a.isEmpty()) {
                NetworkUtils.Y();
            }
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<ScanResult> f28164a = new ArrayList();
        public List<ScanResult> b = new ArrayList();

        public static List<ScanResult> b(List<ScanResult> list) {
            ScanResult scanResult;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (ScanResult scanResult2 : list) {
                if (!TextUtils.isEmpty(scanResult2.SSID) && ((scanResult = (ScanResult) linkedHashMap.get(scanResult2.SSID)) == null || scanResult.level < scanResult2.level)) {
                    linkedHashMap.put(scanResult2.SSID, scanResult2);
                }
            }
            return new ArrayList(linkedHashMap.values());
        }

        public List<ScanResult> c() {
            return this.f28164a;
        }

        public List<ScanResult> d() {
            return this.b;
        }

        public void e(List<ScanResult> list) {
            this.f28164a = list;
            this.b = b(list);
        }
    }

    public NetworkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static boolean A() {
        return C() || H(null);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static Utils.Task<Boolean> B(@NonNull Utils.Consumer<Boolean> consumer) {
        return com.blankj.utilcode.util.i.u(new a(consumer));
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static boolean C() {
        return D("");
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static boolean D(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.baidu.com";
        }
        try {
            return InetAddress.getByName(str) != null;
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static Utils.Task E(String str, @NonNull Utils.Consumer<Boolean> consumer) {
        return com.blankj.utilcode.util.i.u(new c(consumer, str));
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void F(Utils.Consumer<Boolean> consumer) {
        E("", consumer);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static boolean G() {
        return H("");
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static boolean H(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "223.5.5.5";
        }
        return com.blankj.utilcode.util.g.c(String.format("ping -c 1 %s", str), false).f28230a == 0;
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static Utils.Task<Boolean> I(String str, @NonNull Utils.Consumer<Boolean> consumer) {
        return com.blankj.utilcode.util.i.u(new b(consumer, str));
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static void J(Utils.Consumer<Boolean> consumer) {
        I("", consumer);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean K() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isConnected();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean L() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean M() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isAvailable() && networkInfoI.getType() == 0;
    }

    public static boolean N(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        return NetworkChangedReceiver.e().f(onNetworkStatusChangedListener);
    }

    public static boolean O(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult != null && scanResult2 != null && com.blankj.utilcode.util.i.z(scanResult.BSSID, scanResult2.BSSID) && com.blankj.utilcode.util.i.z(scanResult.SSID, scanResult2.SSID) && com.blankj.utilcode.util.i.z(scanResult.capabilities, scanResult2.capabilities) && scanResult.level == scanResult2.level;
    }

    public static boolean P(List<ScanResult> list, List<ScanResult> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!O(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f40125a})
    public static boolean Q() {
        return w() && A();
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f40125a})
    public static Utils.Task<Boolean> R(@NonNull Utils.Consumer<Boolean> consumer) {
        return com.blankj.utilcode.util.i.u(new d(consumer));
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean S() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true;
    }

    public static void T() {
        Utils.a().startActivity(new Intent("android.settings.WIRELESS_SETTINGS").setFlags(268435456));
    }

    public static void U(Utils.Consumer<j> consumer) {
        if (consumer == null) {
            return;
        }
        com.blankj.utilcode.util.i.T0(new i(consumer));
    }

    @RequiresPermission("android.permission.CHANGE_WIFI_STATE")
    public static void V(boolean z) {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        if (wifiManager == null || z == wifiManager.isWifiEnabled()) {
            return;
        }
        wifiManager.setWifiEnabled(z);
    }

    public static void W() {
        f1318a = new j();
        Timer timer = new Timer();
        f1320a = timer;
        timer.schedule(new h(), 0L, 3000L);
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, "android.permission.CHANGE_WIFI_STATE"})
    public static void X() {
        if (w()) {
            ((WifiManager) Utils.a().getSystemService("wifi")).startScan();
        }
    }

    public static void Y() {
        Timer timer = f1320a;
        if (timer != null) {
            timer.cancel();
            f1320a = null;
        }
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, "android.permission.CHANGE_WIFI_STATE", "android.permission.ACCESS_COARSE_LOCATION"})
    public static void h(Utils.Consumer<j> consumer) {
        if (consumer == null) {
            return;
        }
        com.blankj.utilcode.util.i.T0(new g(consumer));
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkInfo i() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static String j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    List<InterfaceAddress> interfaceAddresses = networkInterfaceNextElement.getInterfaceAddresses();
                    int size = interfaceAddresses.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        InetAddress broadcast = interfaceAddresses.get(i2).getBroadcast();
                        if (broadcast != null) {
                            return broadcast.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static String k(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static Utils.Task<String> l(String str, @NonNull Utils.Consumer<String> consumer) {
        return com.blankj.utilcode.util.i.u(new f(consumer, str));
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static String m() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().gateway);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f40125a)
    public static String n(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            LinkedList<InetAddress> linkedList = new LinkedList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        linkedList.addFirst(inetAddresses.nextElement());
                    }
                }
            }
            for (InetAddress inetAddress : linkedList) {
                if (!inetAddress.isLoopbackAddress()) {
                    String hostAddress = inetAddress.getHostAddress();
                    boolean z2 = hostAddress.indexOf(58) < 0;
                    if (z) {
                        if (z2) {
                            return hostAddress;
                        }
                    } else if (!z2) {
                        int iIndexOf = hostAddress.indexOf(37);
                        return iIndexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, iIndexOf).toUpperCase();
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Utils.Task<String> o(boolean z, @NonNull Utils.Consumer<String> consumer) {
        return com.blankj.utilcode.util.i.u(new e(consumer, z));
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static String p() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().ipAddress);
    }

    public static boolean q() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.a().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.isDataEnabled();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static String r() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().netmask);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static void registerNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        NetworkChangedReceiver.e().registerListener(onNetworkStatusChangedListener);
    }

    public static String s() {
        TelephonyManager telephonyManager = (TelephonyManager) Utils.a().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        return telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkType t() {
        if (L()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoI = i();
        if (networkInfoI == null || !networkInfoI.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (networkInfoI.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (networkInfoI.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (networkInfoI.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = networkInfoI.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static String u() {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) Utils.a().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String ssid = connectionInfo.getSSID();
        if (TextUtils.isEmpty(ssid)) {
            return "";
        }
        return (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') ? ssid.substring(1, ssid.length() - 1) : ssid;
    }

    public static void unregisterNetworkStatusChangedListener(OnNetworkStatusChangedListener onNetworkStatusChangedListener) {
        NetworkChangedReceiver.e().unregisterListener(onNetworkStatusChangedListener);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static String v() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        return wifiManager == null ? "" : Formatter.formatIpAddress(wifiManager.getDhcpInfo().serverAddress);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static boolean w() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, "android.permission.ACCESS_COARSE_LOCATION"})
    public static j x() {
        List<ScanResult> scanResults;
        j jVar = new j();
        if (w() && (scanResults = ((WifiManager) Utils.a().getSystemService("wifi")).getScanResults()) != null) {
            jVar.e(scanResults);
        }
        return jVar;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean y() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isAvailable() && networkInfoI.getSubtype() == 13;
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean z() {
        NetworkInfo networkInfoI = i();
        return networkInfoI != null && networkInfoI.isAvailable() && networkInfoI.getSubtype() == 20;
    }
}
