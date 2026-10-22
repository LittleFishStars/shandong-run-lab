package cj.mobile.wm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class me {
    public static boolean dexa() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) InsightProxy.getApplication().getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) ? false : true;
    }

    public static boolean dexb() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) InsightProxy.getApplication().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
