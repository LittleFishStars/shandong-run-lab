package com.byazt.qv;

import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.byazt.nbs.da;
import com.byazt.vx.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 91})
public class sp {
    public static boolean c(int i) {
        return i >= -299 && i < -100;
    }

    public static boolean c(int i, List<Integer> list) {
        if (p.c(list) || i >= list.size() || list.get(i).intValue() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2).intValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static List<da> tt(List<da> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (da daVar : list) {
            if (daVar != null && daVar.my() == 0) {
                arrayList.add(daVar);
            }
        }
        return arrayList;
    }

    public static boolean tt(int i) {
        return i == 0;
    }

    public static List<da> ve(List<da> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (da daVar : list) {
            if (daVar != null && (daVar.my() == 1 || daVar.my() == 3)) {
                arrayList.add(daVar);
            }
        }
        return arrayList;
    }

    public static boolean ve(int i) {
        return i == -100;
    }

    public static int c(com.byazt.nbs.tt ttVar, da daVar) {
        if (ttVar == null || daVar == null) {
            return AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        }
        if (ttVar.yp() && daVar.pf()) {
            return daVar.p();
        }
        return daVar.yv();
    }

    public static int c(com.byazt.nbs.tt ttVar, com.byazt.yl.ve veVar) {
        if (ttVar == null || veVar == null) {
            return AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        }
        if (ttVar.yp() && veVar.isNormalAd()) {
            return veVar.getShowSort();
        }
        return veVar.getLoadSort();
    }

    public static Map<Integer, List<da>> c(List<da> list, boolean z) {
        int iYv;
        HashMap map = new HashMap();
        if (p.c(list)) {
            return map;
        }
        for (int i = 0; i < list.size(); i++) {
            da daVar = list.get(i);
            if (daVar != null) {
                if (z && daVar.pf()) {
                    iYv = daVar.p();
                } else {
                    iYv = daVar.yv();
                }
                List arrayList = (List) map.get(Integer.valueOf(iYv));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(daVar);
                map.put(Integer.valueOf(iYv), arrayList);
            }
        }
        return map;
    }

    public static List<da> c(List<da> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (da daVar : list) {
            if (daVar != null && daVar.my() == 100) {
                arrayList.add(daVar);
            }
        }
        return arrayList;
    }
}
