package com.byazt.psp;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 54})
public class ve {
    public static List<da> c(com.byazt.nbs.tt ttVar, String str) {
        return c(ttVar, str, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    private static void tt(double d, double d2, double d3, com.byazt.nbs.tt ttVar, List<da> list) {
        if (d2 < d3 || d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || d < ttVar.p()) {
            return;
        }
        if (d > ttVar.yv() && d3 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            list.addAll(ttVar.l());
            return;
        }
        double dDoubleValue = BigDecimal.valueOf(d * d2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double dDoubleValue2 = BigDecimal.valueOf(d * d3).setScale(2, RoundingMode.HALF_UP).doubleValue();
        List<da> listL = ttVar.l();
        double dGr = -1.0d;
        double dGr2 = -1.0d;
        for (int i = 0; i < listL.size(); i++) {
            da daVar = listL.get(i);
            if (daVar.my() == 0) {
                double dDoubleValue3 = BigDecimal.valueOf(daVar.gr()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (dDoubleValue3 <= dDoubleValue && dDoubleValue3 >= dDoubleValue2) {
                    if (dGr == -1.0d || dGr < daVar.gr()) {
                        dGr = daVar.gr();
                    }
                    if (dGr2 == -1.0d || dGr2 > daVar.gr()) {
                        dGr2 = daVar.gr();
                    }
                    list.add(daVar);
                }
            } else {
                list.add(daVar);
            }
        }
        ttVar.x().put("max_ecpm", Double.valueOf(dGr));
        ttVar.x().put("min_ecpm", Double.valueOf(dGr2));
        ttVar.x().put("upper_cpm_x", Double.valueOf(dDoubleValue));
    }

    public static List<da> c(com.byazt.nbs.tt ttVar, String str, double d, double d2) {
        int i;
        double dC;
        if (ttVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.byazt.nbs.uj ujVarN = com.byazt.bp.tt.tt().n(str);
        if (ujVarN != null) {
            double dC2 = ujVarN.c();
            double dTt = ujVarN.tt();
            int iVe = ujVarN.ve();
            if (ttVar.i() == 3 || ttVar.i() == 4) {
                i = 1;
                double[] dArrC = tt.uj().c(ttVar.i(), d, d2, ttVar.cu(), str);
                double d3 = dArrC[0];
                ttVar.x().put("price_from", Integer.valueOf((int) dArrC[1]));
                dC = d3;
            } else if (ttVar.i() == 2) {
                dC = tt.uj().c(3, str, iVe);
                i = 1;
            } else {
                i = 1;
                dC = 0.0d;
            }
            if (!ujVarN.n() && dC > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (ujVarN.getType() == i) {
                    tt(dC, dC2, dTt, ttVar, copyOnWriteArrayList);
                } else if (ujVarN.getType() == 2) {
                    c(dC, dC2, dTt, ttVar, copyOnWriteArrayList);
                }
                List<com.byazt.nbs.ve> listA = com.byazt.bp.tt.tt().a(String.valueOf(ttVar.pf()));
                if (listA != null) {
                    for (com.byazt.nbs.ve veVar : listA) {
                        if (dC > veVar.a() && dC <= veVar.n()) {
                            ttVar.x().put("user_label_value", veVar);
                            break;
                        }
                    }
                }
            }
            ttVar.x().put("rule_id", ujVarN.uj());
            ttVar.x().put("ecpm", Double.valueOf(dC));
            ttVar.x().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : i));
            ttVar.x().put("group_type", Integer.valueOf(ttVar.i()));
        }
        if (com.byazt.eu.tt.tt()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i2 = 0; i2 < copyOnWriteArrayList.size(); i2++) {
                    com.byazt.eu.tt.c("DynamicRuleCalculate", "rit：" + ((da) copyOnWriteArrayList.get(i2)).rh() + ",level：" + ((da) copyOnWriteArrayList.get(i2)).yv());
                }
            } else {
                com.byazt.eu.tt.c("DynamicRuleCalculate", "走原waterfall，inUse ： 不生效");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : ttVar.l();
    }

    private static void c(double d, double d2, double d3, com.byazt.nbs.tt ttVar, List<da> list) {
        if (ttVar == null || d2 == AudioStats.AUDIO_AMPLITUDE_NONE || d < ttVar.p()) {
            return;
        }
        if (d > ttVar.yv() && d3 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            list.addAll(ttVar.l());
        } else {
            c(ttVar, d, d2, d3, list);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a3 A[PHI: r5
      0x00a3: PHI (r5v10 int) = (r5v7 int), (r5v11 int) binds: [B:36:0x00a1, B:45:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    public static void c(com.byazt.nbs.tt ttVar, double d, double d2, double d3, List<da> list) {
        Map<Integer, List<da>> mapLr = ttVar.lr();
        if (mapLr != null) {
            ArrayList arrayList = new ArrayList(mapLr.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Integer) arrayList.get(i2)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i2));
                } else {
                    List<da> list2 = mapLr.get(arrayList.get(i2));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.byazt.oi.tt.c(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int iMax = -1;
            int iMin = size;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                double d4 = i3;
                List<da> list3 = mapLr.get(arrayList2.get(i3));
                if (list3 != null) {
                    for (int i4 = 0; i4 < list3.size(); i4++) {
                        da daVar = list3.get(i4);
                        if (daVar != null && daVar.my() == 0) {
                            double dDoubleValue = BigDecimal.valueOf(daVar.gr()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d == dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) (d4 - d2), 0);
                                }
                                if (iMin != size && d != dDoubleValue) {
                                    break;
                                }
                                if (d3 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                    iMin = size - 1;
                                    break;
                                } else {
                                    iMin = Math.min((int) (d4 + d3), size - 1);
                                    break;
                                }
                            }
                            if (d > dDoubleValue) {
                                if (iMax < 0) {
                                    iMax = Math.max((int) Math.ceil(((d4 + (d4 - 1.0d)) / 2.0d) - d2), 0);
                                }
                                if (iMin == size) {
                                    if (d3 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                        iMin = size - 1;
                                        break;
                                        break;
                                    } else {
                                        iMin = Math.min((int) Math.floor(((d4 + (d4 - 1.0d)) / 2.0d) + d3), size - 1);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }
            if (iMax < 0) {
                iMax = 0;
            }
            if (iMin >= size) {
                iMin = size - 1;
            }
            int i5 = iMax;
            double d5 = -1.0d;
            double dGr = -1.0d;
            double dGr2 = -1.0d;
            while (i5 <= iMin) {
                List<da> list4 = mapLr.get(arrayList2.get(i5));
                if (list4 != null && list4.size() != 0) {
                    while (i < list4.size()) {
                        da daVar2 = list4.get(i);
                        if (daVar2 != null) {
                            if (dGr < daVar2.gr() || dGr == -1.0d) {
                                dGr = daVar2.gr();
                            }
                            if (dGr2 > daVar2.gr() || dGr2 == -1.0d) {
                                dGr2 = daVar2.gr();
                            }
                            list.add(daVar2);
                            if (i5 == iMax) {
                                d5 = dGr;
                            }
                        }
                        i++;
                    }
                }
                i5++;
                i = 0;
            }
            ttVar.x().put("upper_cpm_x", Double.valueOf(d5));
            ttVar.x().put("max_ecpm", Double.valueOf(dGr));
            ttVar.x().put("min_ecpm", Double.valueOf(dGr2));
        }
    }
}
