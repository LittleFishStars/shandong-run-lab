package com.beizi.fusion;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class y5 {
    public static HttpURLConnection a(ke keVar) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(keVar.a()).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        String strB = keVar.b().b();
        if (strB.equalsIgnoreCase(cm.DOWNLOAD.b()) || strB.equalsIgnoreCase(cm.CACHE_IMAGE.b())) {
            strB = cm.GET.b();
        }
        if (strB.equalsIgnoreCase(cm.STREAM.b())) {
            strB = cm.POST.b();
        }
        httpURLConnection.setRequestMethod(strB);
        httpURLConnection.setInstanceFollowRedirects(false);
        m5 m5VarE = keVar.e();
        if (!m5VarE.isEmpty()) {
            Iterator it = m5VarE.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return httpURLConnection;
    }
}
