package com.byazt.qv;

import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 34})
public class a {
    public static void c(com.byazt.yl.ve veVar, String str, String str2) {
        da daVarN = com.byazt.hk.c.c().n(str, str2);
        if (veVar == null || daVarN == null) {
            return;
        }
        veVar.setLoadSort(daVarN.yv());
        veVar.setShowSort(daVarN.p());
        veVar.setExchangeRate(daVarN.yp());
        veVar.setDiscount(daVarN.gu());
        veVar.setAdNetworkSlotType(daVarN.my());
        veVar.setCpm(daVarN.gr());
        veVar.setSubAdType(daVarN.a());
    }
}
