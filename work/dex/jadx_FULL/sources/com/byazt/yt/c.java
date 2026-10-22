package com.byazt.yt;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.ix.sp;
import com.byazt.ll.tt;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 777, 20})
public class c {
    public static final List<String> ve;
    public final Map<String, Integer> c = new HashMap();
    public final Map<String, Integer> tt = new HashMap();

    static {
        ArrayList arrayList = new ArrayList();
        ve = arrayList;
        arrayList.add("gdt");
        arrayList.add("baidu");
        arrayList.add(MediationConstant.ADN_KS);
        arrayList.add(MediationConstant.ADN_PANGLE);
        arrayList.add("sigmob");
        arrayList.add("gromoreExtra");
    }

    public void c(String str, String str2, int i) {
        this.c.put(str + LoginConstants.UNDER_LINE + str2, Integer.valueOf(i));
    }

    public void tt(String str, String str2, int i) {
        this.tt.put(str + LoginConstants.UNDER_LINE + str2, Integer.valueOf(i));
    }

    public int c(String str, String str2) {
        Integer num = this.c.get(str + LoginConstants.UNDER_LINE + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1800000;
    }

    public int tt(String str, String str2) {
        Integer num = this.tt.get(str + LoginConstants.UNDER_LINE + str2);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    public int c(sp spVar, tt ttVar, tt ttVar2, String str) {
        if (spVar == null || spVar.c == null) {
            return 4;
        }
        String strGt = ttVar2 != null ? ttVar2.gt() : "";
        String adNetWorkName = spVar.c.getAdNetWorkName();
        String adNetworkSlotId = spVar.c.getAdNetworkSlotId();
        Integer numIsReadyStatus = spVar.c.isReadyStatus();
        if (numIsReadyStatus.intValue() == 1) {
            if (spVar.c.isHasShown()) {
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":广告已show过 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 7;
            }
            if (c(strGt, spVar.c)) {
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":广告过期了(M配置) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 2;
            }
            if (!c(ttVar, ttVar2, spVar.c)) {
                com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":AdSlot不符合 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
                return 6;
            }
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":复用成功：---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return -1;
        }
        if (spVar.c.isHasShown()) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":广告已show过 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 7;
        }
        if (numIsReadyStatus.intValue() == 3) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":广告过期了(adn api) ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 1;
        }
        if (numIsReadyStatus.intValue() == 4) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":isReady是false ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 5;
        }
        if (!c(ttVar, ttVar2, spVar.c)) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":AdSlot不符合 ---: " + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
            return 6;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- " + str + ":复用成功：---" + adNetWorkName + ", adSlotId: " + adNetworkSlotId);
        return -1;
    }

    public final boolean c(String str, ve veVar) {
        if (veVar != null && !veVar.hasDestroyed()) {
            boolean z = SystemClock.elapsedRealtime() > veVar.getFillTime() + ((long) c(str, veVar.getAdNetworkSlotId()));
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 使用了配置的过期时间进行判断 ------");
            return z;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- 广告已经destroy了，视为过期 ------");
        return true;
    }

    public static boolean c(tt ttVar, tt ttVar2, ve veVar) {
        if (ttVar != null && ttVar2 != null) {
            if (ttVar.d() != ttVar2.d()) {
                com.byazt.eu.tt.c("TMe", "--==-- orientation, a1: " + ttVar.d() + ", a2: " + ttVar2.d());
                return false;
            }
            if (ttVar.eo() != ttVar2.eo()) {
                com.byazt.eu.tt.c("TMe", "--==-- isMuted, a1: " + ttVar.eo() + ", a2: " + ttVar2.eo());
                return false;
            }
            if (ttVar.qy() != ttVar2.qy()) {
                com.byazt.eu.tt.c("TMe", "--==-- ImgWidth, a1: " + ttVar.qy() + ", a2: " + ttVar2.qy());
                return false;
            }
            if (ttVar.gu() != ttVar2.gu()) {
                com.byazt.eu.tt.c("TMe", "--==-- ImgHeight, a1: " + ttVar.gu() + ", a2: " + ttVar2.gu());
                return false;
            }
            if (ttVar.yv() != null && ttVar2.yv() != null) {
                if (!ttVar.yv().equals(ttVar2.yv())) {
                    com.byazt.eu.tt.c("TMe", "--==-- rewardName, a1: " + ttVar.yv() + ", a2: " + ttVar2.yv());
                    return false;
                }
            } else if (ttVar.yv() != null || ttVar2.yv() != null) {
                com.byazt.eu.tt.c("TMe", "--==-- rewardName=null, a1: " + ttVar.yv() + ", a2: " + ttVar2.yv());
                return false;
            }
            if (ttVar.p() != ttVar2.p()) {
                com.byazt.eu.tt.c("TMe", "--==-- rewardAmount, a1: " + ttVar.p() + ", a2: " + ttVar2.p());
                return false;
            }
            if (ttVar.h() != null && ttVar2.h() != null) {
                if (!ttVar.h().equals(ttVar2.h())) {
                    com.byazt.eu.tt.c("TMe", "--==-- reward, userId, a1: " + ttVar.h() + ", a2: " + ttVar2.h());
                    return false;
                }
            } else if (ttVar.h() != null || ttVar2.h() != null) {
                com.byazt.eu.tt.c("TMe", "--==-- reward, userId=null, a1: " + ttVar.h() + ", a2: " + ttVar2.h());
                return false;
            }
            if (ttVar.cu() != null && ttVar2.cu() != null) {
                if (c(ttVar.cu(), ttVar2.cu())) {
                    return true;
                }
                com.byazt.eu.tt.c("TMe", "--==-- customData, a1: " + ttVar.cu().toString() + ", a2: " + ttVar2.cu().toString());
                return false;
            }
            if (ttVar.cu() == null && ttVar2.cu() == null) {
                return true;
            }
            com.byazt.eu.tt.c("TMe", "--==-- customData=null, a1: " + ttVar.cu() + ", a2: " + ttVar2.cu());
            return false;
        }
        com.byazt.eu.tt.c("TMe", "--==-- adSlot = null, a1: " + ttVar + ", a2: " + ttVar2);
        return false;
    }

    public static boolean c(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map == null || map2 == null) {
            return false;
        }
        for (String str : ve) {
            if (!TextUtils.isEmpty(str)) {
                Object obj = map.get(str);
                String str2 = obj instanceof String ? (String) obj : null;
                Object obj2 = map2.get(str);
                String str3 = obj2 instanceof String ? (String) obj2 : null;
                if (str2 != null || str3 != null) {
                    if (!TextUtils.equals(str2, str3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
