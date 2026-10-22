package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26366a;
    private long b;
    private Context c;
    private com.baidu.a.a d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f26367a = new l();
    }

    public static class b implements Dns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f26368a;
        private com.baidu.a.a b;

        private b(com.baidu.a.a aVar) {
            this.b = aVar;
        }

        public static b a(com.baidu.a.a aVar) {
            if (f26368a == null) {
                f26368a = new b(aVar);
            }
            return f26368a;
        }

        public List<InetAddress> lookup(String str) throws UnknownHostException {
            String str2;
            if (!com.baidu.location.e.d.f26461a.equals(str)) {
                return Dns.SYSTEM.lookup(str);
            }
            com.baidu.a.b bVarA = this.b.a(str, true);
            ArrayList<String> arrayListD = bVarA.d();
            ArrayList<String> arrayListC = bVarA.c();
            if (arrayListD == null || arrayListD.isEmpty()) {
                str2 = (arrayListC == null || arrayListC.isEmpty()) ? null : arrayListC.get(0);
            } else {
                str2 = "[" + arrayListD.get(0) + "]";
            }
            return str2 != null ? Arrays.asList(InetAddress.getAllByName(str2)) : Dns.SYSTEM.lookup(str);
        }
    }

    private l() {
        this.f26366a = true;
        this.b = 0L;
    }

    public static l a() {
        return a.f26367a;
    }

    private void a(BDLocation bDLocation, Context context) {
        double longitude;
        double latitude;
        String str;
        double[] dArrCoorEncrypt = new double[2];
        String coorType = bDLocation.getCoorType();
        if ("wgs84".equals(coorType)) {
            dArrCoorEncrypt[0] = bDLocation.getLongitude();
            dArrCoorEncrypt[1] = bDLocation.getLatitude();
        } else {
            double[] dArrCoorEncrypt2 = new double[2];
            if ("bd09ll".equals(coorType)) {
                longitude = bDLocation.getLongitude();
                latitude = bDLocation.getLatitude();
                str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
            } else {
                if ("bd09".equals(coorType)) {
                    longitude = bDLocation.getLongitude();
                    latitude = bDLocation.getLatitude();
                    str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                } else {
                    dArrCoorEncrypt2[0] = bDLocation.getLongitude();
                    dArrCoorEncrypt2[1] = bDLocation.getLatitude();
                }
                dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
            }
            dArrCoorEncrypt2 = Jni.coorEncrypt(longitude, latitude, str);
            dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
        }
        boolean zA = com.baidu.location.e.e.a().a(dArrCoorEncrypt[0], dArrCoorEncrypt[1]);
        try {
            this.b = System.currentTimeMillis();
            SharedPreferences sharedPreferencesA = s.a(context);
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                editorEdit.putBoolean("IsDomestic", zA);
                editorEdit.putLong("update_result_time", this.b);
                editorEdit.apply();
            }
        } catch (Exception unused) {
        }
    }

    public void a(Context context) {
        if (c.b().eb == 0) {
            return;
        }
        this.c = context;
        this.f26366a = s.a(context).getBoolean("IsDomestic", true);
        this.b = s.a(context).getLong("update_result_time", 0L);
        if (this.f26366a) {
            com.baidu.location.e.d.a();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("loc.map.baidu.com"));
        com.baidu.a.a aVarA = com.baidu.a.a.a(context);
        this.d = aVarA;
        try {
            aVarA.a("110001");
            this.d.b("nHpsFU98hcqhzFWY17Ht");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.d.a(true);
        this.d.a(true, true);
        this.d.a(com.baidu.a.a.EnumC0254a.POLICY_TOLERANT);
        this.d.a(arrayList);
    }

    public void a(BDLocation bDLocation) {
        if (c.b().eb != 1 || bDLocation.getLongitude() == Double.MIN_VALUE || bDLocation.getLatitude() == Double.MIN_VALUE || System.currentTimeMillis() - this.b <= c.b().ec) {
            return;
        }
        a(bDLocation, this.c);
    }

    public boolean a(String str) {
        try {
            return !this.f26366a && com.baidu.location.e.d.f26461a.equals(new URL(str).getHost());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int b() {
        return this.f26366a ? 1 : 0;
    }

    public String b(String str) {
        String str2;
        if (this.f26366a) {
            return str;
        }
        try {
            String host = new URL(str).getHost();
            if (host != null && !host.isEmpty()) {
                com.baidu.a.b bVarA = this.d.a(host, true);
                ArrayList<String> arrayListD = bVarA.d();
                ArrayList<String> arrayListC = bVarA.c();
                if (arrayListD == null || arrayListD.isEmpty()) {
                    str2 = (arrayListC == null || arrayListC.isEmpty()) ? null : arrayListC.get(0);
                } else {
                    str2 = "[" + arrayListD.get(0) + "]";
                }
                return str2 != null ? str.replaceFirst(host, str2) : str;
            }
            return str;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return str;
        }
    }

    public Dns c() {
        return this.f26366a ? Dns.SYSTEM : b.a(this.d);
    }
}
