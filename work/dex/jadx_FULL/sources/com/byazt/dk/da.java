package com.byazt.dk;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 72})
public class da {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.byazt.va.ve] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.byazt.va.uj] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.byazt.va.n] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void c(int i, String str, Map<String, Object> map, n nVar) {
        ?? Ve;
        if (i == 0) {
            Ve = com.byazt.hy.n.c().tt().ve();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Ve.c(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i != 1) {
            Ve = 0;
        } else {
            Ve = com.byazt.hy.n.c().tt().tt();
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue().toString());
            }
            Ve.c(map2);
        }
        if (Ve != 0) {
            Ve.c(str);
            c(Ve.c(), nVar);
        }
    }

    public static void c(String str, byte[] bArr, String str2, int i, n nVar) {
        if (bArr == null) {
            if (nVar != null) {
                nVar.c(new Exception("request data is null"));
            }
        } else {
            com.byazt.va.n nVarTt = com.byazt.hy.n.c().tt().tt();
            nVarTt.c(str);
            nVarTt.c(str2, bArr);
            c(nVarTt.c(), nVar);
        }
    }

    private static void c(com.byazt.hm.tt ttVar, n nVar) {
        String strValueOf;
        if (ttVar != null && ttVar.i()) {
            if (nVar != null) {
                nVar.c(ttVar.n());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(ttVar != null && ttVar.ve() != null ? ttVar.ve() : null);
        if (nVar != null) {
            if (zIsEmpty) {
                strValueOf = ttVar.ve();
            } else {
                strValueOf = ttVar != null ? String.valueOf(ttVar.tt()) : "";
            }
            nVar.c(new Exception(strValueOf));
        }
    }
}
