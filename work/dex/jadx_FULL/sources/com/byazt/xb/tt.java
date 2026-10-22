package com.byazt.xb;

import com.byazt.eg.gr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 13})
public final class tt extends n {
    public final Method c;
    public final Method tt;

    public tt(Method method, Method method2) {
        this.c = method;
        this.tt = method2;
    }

    @Override // com.byazt.xb.n
    public void c(SSLSocket sSLSocket, String str, List<gr> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listC = n.c(list);
            this.c.invoke(sSLParameters, listC.toArray(new String[listC.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.kh.ve.c("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.byazt.xb.n
    public String c(SSLSocket sSLSocket) {
        try {
            String str = (String) this.tt.invoke(sSLSocket, new Object[0]);
            if (str == null || str.isEmpty()) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.kh.ve.c("unable to get selected protocols", (Exception) e);
        }
    }

    public static tt c() {
        try {
            return new tt(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
