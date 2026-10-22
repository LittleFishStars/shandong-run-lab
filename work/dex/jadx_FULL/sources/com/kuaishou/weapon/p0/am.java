package com.kuaishou.weapon.p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f40038a = "tun";
    private static final String b = "ppp";
    private static int c;

    public static boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasTransport(4)) ? false : true;
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context) {
        try {
            JSONArray jSONArrayA = a();
            if (jSONArrayA != null) {
                return jSONArrayA.toString();
            }
            return a(context) ? "[\"con\"]" : "";
        } catch (Throwable unused) {
        }
    }

    public static int c() {
        return c;
    }

    public static String d() {
        StringBuilder sb = new StringBuilder();
        try {
            c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> enumerationAliases = keyStore.aliases();
                while (enumerationAliases.hasMoreElements()) {
                    c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains("proxy") || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb.append(x509Certificate.getIssuerDN().getName());
                        sb.append("|");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String b() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    public static JSONArray a() {
        BufferedReader bufferedReader;
        JSONArray jSONArray = new JSONArray();
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/net/route").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                try {
                    HashSet hashSet = new HashSet();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String strA = bm.a(line);
                        if (strA.contains(f40038a) || strA.contains(b)) {
                            hashSet.add(strA.split("\t")[0]);
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    try {
                        dataInputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Throwable unused2) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (bufferedReader != null) {
                    }
                    return jSONArray;
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused6) {
        }
        return jSONArray;
    }
}
