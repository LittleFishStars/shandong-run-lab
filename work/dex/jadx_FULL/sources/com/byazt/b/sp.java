package com.byazt.b;

import android.net.Uri;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.hs.IDownloadHttpService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 91})
public class sp implements IDownloadHttpService {
    public final com.byazt.w.x<String, OkHttpClient> c = new com.byazt.w.x<>(4, 8);

    private OkHttpClient c(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + LoginConstants.UNDER_LINE + str2;
                synchronized (this.c) {
                    OkHttpClient okHttpClient = this.c.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderRl = com.byazt.zz.ve.rl();
                    builderRl.dns(new Dns() { // from class: com.byazt.b.sp.2
                    });
                    OkHttpClient okHttpClientBuild = builderRl.build();
                    synchronized (this.c) {
                        this.c.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        return com.byazt.zz.ve.my();
    }

    @Override // com.byazt.hs.IDownloadHttpService
    public com.byazt.hs.i downloadWithConnection(int i, String str, List<com.byazt.t.ve> list) throws IOException {
        String strTt;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strTt = null;
        } else {
            strTt = null;
            for (com.byazt.t.ve veVar : list) {
                String strC = veVar.c();
                if (strTt == null && "ss_d_request_host_ip_114".equals(strC)) {
                    strTt = veVar.tt();
                } else {
                    builderUrl.addHeader(strC, com.byazt.w.a.sp(veVar.tt()));
                }
            }
        }
        OkHttpClient okHttpClientC = !TextUtils.isEmpty(strTt) ? c(str, strTt) : com.byazt.zz.ve.my();
        if (okHttpClientC == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientC.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header("Content-Encoding");
        final InputStream gZIPInputStream = (strHeader == null || !"gzip".equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.byazt.hs.n() { // from class: com.byazt.b.sp.1
            @Override // com.byazt.hs.i
            public InputStream c() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.byazt.hs.c
            public String n() {
                return "";
            }

            @Override // com.byazt.hs.sp
            public int tt() throws IOException {
                return responseExecute.code();
            }

            @Override // com.byazt.hs.i
            public void uj() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.byazt.hs.sp
            public void ve() {
                Call call = callNewCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.byazt.hs.sp
            public String c(String str2) {
                return responseExecute.header(str2);
            }
        };
    }
}
