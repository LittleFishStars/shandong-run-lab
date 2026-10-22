package com.byazt.b;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 34})
public class a implements com.byazt.hs.x {
    @Override // com.byazt.hs.x
    public com.byazt.hs.sp c(String str, List<com.byazt.t.ve> list) throws IOException {
        OkHttpClient okHttpClientMy = com.byazt.zz.ve.my();
        if (okHttpClientMy == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.byazt.t.ve veVar : list) {
                builderHead.addHeader(veVar.c(), com.byazt.w.a.sp(veVar.tt()));
            }
        }
        final Call callNewCall = okHttpClientMy.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.byazt.w.c.c(2097152)) {
            responseExecute.close();
        }
        return new com.byazt.hs.sp() { // from class: com.byazt.b.a.1
            @Override // com.byazt.hs.sp
            public String c(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.byazt.hs.sp
            public int tt() throws IOException {
                return responseExecute.code();
            }

            @Override // com.byazt.hs.sp
            public void ve() {
                Call call = callNewCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }
        };
    }
}
