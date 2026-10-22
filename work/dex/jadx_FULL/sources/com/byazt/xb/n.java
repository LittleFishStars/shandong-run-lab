package com.byazt.xb;

import com.byazt.eg.gr;
import com.byazt.eg.gu;
import com.byazt.nr.m;
import com.byazt.wt.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 46})
public class n {
    public static final n c = c();
    public static final Logger tt = Logger.getLogger(gu.class.getName());

    public static n tt() {
        return c;
    }

    public String c(SSLSocket sSLSocket) {
        return null;
    }

    public void c(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void c(SSLSocket sSLSocket, String str, List<gr> list) {
    }

    public void tt(SSLSocket sSLSocket) {
    }

    public boolean tt(String str) {
        return true;
    }

    public String ve() {
        return "OkHttp";
    }

    public static byte[] tt(List<gr> list) {
        com.byazt.mk.ve veVar = new com.byazt.mk.ve();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            gr grVar = list.get(i);
            if (grVar != gr.HTTP_1_0) {
                veVar.i(grVar.toString().length());
                veVar.tt(grVar.toString());
            }
        }
        try {
            return veVar.nu();
        } catch (IOException e) {
            m.c(e);
            return null;
        }
    }

    public void c(int i, String str, Throwable th) {
        tt.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object c(String str) {
        if (tt.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void c(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        c(5, str, (Throwable) obj);
    }

    public static List<String> c(List<gr> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            gr grVar = list.get(i);
            if (grVar != gr.HTTP_1_0) {
                arrayList.add(grVar.toString());
            }
        }
        return arrayList;
    }

    public a tt(X509TrustManager x509TrustManager) {
        return new com.byazt.wt.tt(x509TrustManager.getAcceptedIssuers());
    }

    public com.byazt.wt.ve c(X509TrustManager x509TrustManager) {
        return new com.byazt.wt.c(tt(x509TrustManager));
    }

    private static n c() {
        n nVarC = c.c();
        if (nVarC != null) {
            return nVarC;
        }
        tt ttVarC = tt.c();
        if (ttVarC != null) {
            return ttVarC;
        }
        n nVarC2 = ve.c();
        return nVarC2 != null ? nVarC2 : new n();
    }
}
