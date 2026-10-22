package com.byazt.yx;

import com.byazt.eg.my;
import com.byazt.eg.yv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.Proxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 42})
public final class i {
    public static String c(yv yvVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yvVar.tt());
        sb.append(' ');
        if (tt(yvVar, type)) {
            sb.append(yvVar.c());
        } else {
            sb.append(c(yvVar.c()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean tt(yv yvVar, Proxy.Type type) {
        return !yvVar.x() && type == Proxy.Type.HTTP;
    }

    public static String c(my myVar) {
        String strI = myVar.i();
        try {
            String strSl = myVar.sl();
            if (strSl != null) {
                return strI + '?' + strSl;
            }
        } catch (OutOfMemoryError unused) {
        }
        return strI;
    }
}
