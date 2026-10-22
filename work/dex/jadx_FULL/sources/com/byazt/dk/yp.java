package com.byazt.dk;

import android.text.TextUtils;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.common.net.b;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 215})
public class yp {

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE})
    public static class c {
        public InputStream c;
        public Map<String, String> tt;
        public HttpURLConnection uj;
        public int ve;

        public c(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.c = inputStream;
            this.tt = map;
            this.ve = i;
            this.uj = httpURLConnection;
        }
    }

    public static HttpURLConnection c(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty(SubscribeResouceItemModel.ACCEPT, "*/*");
                httpURLConnection2.setRequestProperty("connection", b.t0);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? c(httpURLConnection2.getHeaderField("Location"), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> c(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static c c(String str, List<com.byazt.t.ve> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.byazt.t.ve veVar : list) {
                map.put(veVar.c(), veVar.tt());
            }
        }
        HttpURLConnection httpURLConnectionC = c(str, map);
        if (httpURLConnectionC == null || (responseCode = httpURLConnectionC.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapC = c(httpURLConnectionC);
        InputStream inputStream = httpURLConnectionC.getInputStream();
        String contentEncoding = httpURLConnectionC.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new c(inputStream, mapC, responseCode, httpURLConnectionC);
    }
}
