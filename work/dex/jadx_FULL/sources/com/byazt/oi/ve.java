package com.byazt.oi;

import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.dc.n;
import com.byazt.nbs.da;
import com.byazt.vif.uj;
import com.byazt.vx.h;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1933, 54})
public class ve {
    public static Comparator<com.byazt.yl.ve> c = null;
    public static Comparator<com.byazt.yl.ve> tt = null;
    public static String uj = "KEY_LOAD_SEQ_TIME";
    public static String ve = "KEY_LOAD_SEQ";

    public static int a() {
        com.byazt.it.ve veVarC = uj.c(com.byazt.bp.c.t().u(), "gm_tt_ad_mediation_sdk_sp");
        long j = veVarC.getLong(uj, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zC = c(new Date(j), new Date(jCurrentTimeMillis));
        veVarC.put(uj, jCurrentTimeMillis);
        int i = (zC ? veVarC.getInt(ve, 0) : 0) + 1;
        veVarC.put(ve, i);
        return i;
    }

    public static Comparator<com.byazt.yl.ve> c() {
        Comparator<com.byazt.yl.ve> comparator = c;
        return comparator != null ? comparator : ve();
    }

    public static String n() {
        return UUID.randomUUID().toString();
    }

    public static Comparator<com.byazt.yl.ve> tt() {
        Comparator<com.byazt.yl.ve> comparator = tt;
        return comparator != null ? comparator : uj();
    }

    public static boolean tt(String str) {
        return true;
    }

    public static Comparator<com.byazt.yl.ve> uj() {
        Comparator<com.byazt.yl.ve> comparator = new Comparator<com.byazt.yl.ve>() { // from class: com.byazt.oi.ve.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.yl.ve veVar, com.byazt.yl.ve veVar2) {
                if (veVar.getStrategyCpm() > veVar2.getStrategyCpm()) {
                    return -1;
                }
                if (veVar.getStrategyCpm() < veVar2.getStrategyCpm()) {
                    return 1;
                }
                return (veVar.getStrategyCpm() == veVar2.getStrategyCpm() && veVar.getAdNetworkPlatformId() == 1) ? -1 : 0;
            }
        };
        tt = comparator;
        return comparator;
    }

    public static Comparator<com.byazt.yl.ve> ve() {
        Comparator<com.byazt.yl.ve> comparator = new Comparator<com.byazt.yl.ve>() { // from class: com.byazt.oi.ve.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.yl.ve veVar, com.byazt.yl.ve veVar2) {
                if (veVar.getCpm() > veVar2.getCpm()) {
                    return -1;
                }
                if (veVar.getCpm() < veVar2.getCpm()) {
                    return 1;
                }
                return (veVar.getCpm() == veVar2.getCpm() && veVar.getAdNetworkPlatformId() == 1) ? -1 : 0;
            }
        };
        c = comparator;
        return comparator;
    }

    public static void c(List<com.byazt.yl.ve> list, Comparator<com.byazt.yl.ve> comparator) {
        if (comparator == null) {
            h.c(list);
        } else {
            h.c(list, comparator);
        }
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    private static String tt(da daVar) {
        String str;
        String str2 = "";
        if (daVar == null) {
            return "";
        }
        String strZ = daVar.z();
        strZ.hashCode();
        switch (strZ) {
            case "klevin":
                str = "com.bytedance.msdk.adapter.klevin.Klevin";
                break;
            case "pangle":
                str = "com.bytedance.msdk.adapter.pangle_csjm.Pangle";
                break;
            case "sigmob":
                str = "com.bytedance.msdk.adapter.sigmob.Sigmob";
                break;
            case "xiaomi":
                str = "com.bytedance.msdk.adapter.xiaomi.Xiaomi";
                break;
            case "ks":
                str = "com.bytedance.msdk.adapter.ks.Ks";
                break;
            case "gdt":
                str = "com.bytedance.msdk.adapter.gdt.Gdt";
                break;
            case "baidu":
                str = "com.bytedance.msdk.adapter.baidu.Baidu";
                break;
            case "unity":
                str = "com.bytedance.msdk.adapter.unity.Unity";
                break;
            case "mintegral":
                str = "com.bytedance.msdk.adapter.mintegral.Mintegral";
                break;
            default:
                str = "";
                break;
        }
        int iA = daVar.a();
        switch (daVar.u()) {
            case 1:
                str2 = "BannerLoader";
                break;
            case 2:
                str2 = "InterstitialLoader";
                break;
            case 3:
                str2 = "SplashLoader";
                break;
            case 5:
                str2 = "NativeLoader";
                if (iA != 4) {
                    if (iA == 5) {
                        str2 = "DrawLoader";
                    } else if (iA == 3) {
                        str2 = "BannerLoader";
                    }
                }
                break;
            case 7:
                str2 = "RewardLoader";
                if (iA != 6) {
                    if (iA == 7) {
                        str2 = "FullVideoLoader";
                    } else if (iA == 8) {
                        str2 = "InterstitialLoader";
                    }
                }
                break;
            case 8:
                str2 = "FullVideoLoader";
                break;
            case 9:
                str2 = "DrawLoader";
                break;
            case 10:
                if (iA == 1) {
                    str2 = "InterstitialLoader";
                } else if (iA == 2) {
                    str2 = "FullVideoLoader";
                }
                break;
        }
        return str + str2;
    }

    public static String c(String str, String str2, String str3) {
        return "com.bytedance.msdk.adapter." + com.byazt.yl.c.c(str2) + Consts.DOT + String.format(str, str2, str3);
    }

    public static boolean c(da daVar) {
        if (daVar != null && TextUtils.equals(daVar.z(), MediationConstant.ADN_PANGLE)) {
            return true;
        }
        if (daVar != null && n.c(daVar.z())) {
            return true;
        }
        if (daVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> functionA = com.byazt.vq.c.c().a();
        if (functionA != null) {
            String strTt = tt(daVar);
            String adaperManagerName = com.byazt.px.uj.getAdaperManagerName(daVar.z());
            if (TextUtils.isEmpty(strTt)) {
                return false;
            }
            com.byazt.rl.c cVarC = com.byazt.rl.c.c();
            cVarC.c(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, strTt);
            cVarC.c(8560, adaperManagerName);
            cVarC.c(-99999987, 8229);
            cVarC.c(-99999985, Boolean.class);
            return ((Boolean) functionA.apply(cVarC.tt().sparseArray())).booleanValue();
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, "load ad check class loader is null ");
        return false;
    }

    private static boolean tt(String str, com.byazt.yl.ve veVar) {
        if (veVar == null) {
            return false;
        }
        com.byazt.nbs.tt ttVarC = com.byazt.bp.tt.tt().c(str, veVar.getAdType(), 101);
        return com.byazt.bp.tt.tt().tt(str, veVar.getAdType()) && ttVarC != null && ttVarC.qp() != null && ttVarC.qp().size() > 0 && ttVarC.md() != null && ttVarC.md().size() > 0;
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static da c(String str, String str2, int i, int i2) {
        da daVar = new da();
        daVar.ve(str2);
        daVar.n(str);
        daVar.da(0);
        daVar.sp("0");
        daVar.tt("1");
        daVar.sl(i);
        daVar.t(i2);
        daVar.i(3);
        daVar.c("%1$s%2$sAdapter");
        return daVar;
    }

    private static boolean c(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    public static void c(com.byazt.pp.c cVar, da daVar) {
        if (!com.byazt.bp.tt.tt().to() || cVar == null || daVar == null) {
            return;
        }
        if (820001 == cVar.c) {
            com.byazt.pp.uj.c(com.byazt.bp.tt.getContext(), String.format("error_adn:%1$s no ads，please check ad network", daVar.nu()));
        } else {
            com.byazt.pp.uj.c(com.byazt.bp.tt.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", daVar.nu(), daVar.rh(), Integer.valueOf(cVar.ve), cVar.uj));
        }
    }

    public static void c(String str, da daVar, com.byazt.yl.ve veVar) {
        if (com.byazt.bp.tt.tt().to() && daVar != null && tt(str, veVar)) {
            com.byazt.pp.uj.c(com.byazt.bp.tt.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", daVar.z(), Integer.valueOf(daVar.my())));
        }
    }

    public static void c(String str, com.byazt.yl.ve veVar) {
        if (com.byazt.bp.tt.tt().to() && veVar != null && tt(str, veVar)) {
            com.byazt.pp.uj.c(com.byazt.bp.tt.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.byazt.yl.c.c(veVar.getAdNetworkPlatformId()), veVar.getAdNetworkSlotId()));
        }
    }
}
