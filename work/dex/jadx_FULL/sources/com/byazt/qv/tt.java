package com.byazt.qv;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 13})
public class tt {
    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.nh.a aVar, boolean z) {
        com.byazt.ch.tt ttVarMd;
        if (cVar != null && (ttVarMd = cVar.md()) != null && ttVarMd.da() == null) {
            com.byazt.eu.tt.uj("TMe", "使用聚合信息流广告自渲染模版混用场景时，需设置MediationNativeToBannerListener监听回调否则会影响相关功能使用，具体可以参考接入文档，若不能及时设置，建议修改瀑布流配置为模版信息流广告暂不进行混用。");
        }
        new com.byazt.zu.n(context, cVar, aVar, z).c();
    }

    public static void tt(Context context, com.byazt.ch.c cVar, com.byazt.nh.uj ujVar) {
        new com.byazt.ra.sp(context, cVar, ujVar).c();
    }

    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.nh.ve veVar, boolean z) {
        new com.byazt.zu.a(context, cVar, veVar, z).c();
    }

    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.nh.tt ttVar) {
        new com.byazt.da.ve(context, cVar, ttVar).c();
    }

    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.nh.sp spVar) {
        new com.byazt.zwg.ve(context, cVar, spVar).c();
    }

    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.xw.c cVar2, boolean z) {
        new com.byazt.eo.ve(context, cVar, cVar2, z).c();
    }

    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.nx.c cVar2, com.byazt.nh.c cVar3, boolean z) {
        com.byazt.ud.ve veVar = new com.byazt.ud.ve(context, cVar, cVar3, z);
        if (cVar2 != null && cVar2.i() != 0) {
            veVar.c(cVar2.i());
        } else {
            veVar.c();
        }
    }

    public static void c(Context context, com.byazt.ch.c cVar, com.byazt.nh.uj ujVar) {
        new com.byazt.ra.ve(context, cVar, ujVar).c();
    }
}
