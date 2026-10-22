package com.byazt.xf;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.byazt.eu.a;
import com.byazt.omf.gt;
import com.byazt.yf.yp;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 804, 20})
public class c implements com.byazt.ly.uj {
    private void c() {
        tt();
    }

    private void tt() {
        tt.tt(tt.c(tt.c(), "personal_ads_type", com.byazt.bp.c.t().tt().sp() ? "0" : "1"));
    }

    @Override // com.byazt.ly.uj
    public void checkVersion() {
    }

    @Override // com.byazt.ly.uj
    public void clearInitStatus() {
    }

    @Override // com.byazt.ly.uj
    public String getAdapterVersion() {
        return getNetworkSdkVersion() + ".0";
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    @Override // com.byazt.ly.uj
    public String getBiddingToken(Context context, Map<String, Object> map) {
        if (!com.byazt.tjo.tt.n()) {
            return "";
        }
        if (map != null) {
            Object obj = map.get(com.byazt.ly.c.c);
            Object obj2 = map.get(com.byazt.ly.c.uj);
            String str = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = map.get(com.byazt.ly.c.f28783a);
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            Object obj4 = map.get(com.byazt.ly.c.ve);
            int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
            if (obj instanceof com.byazt.ll.tt) {
                com.byazt.ll.tt ttVar = (com.byazt.ll.tt) obj;
                int iMy = ttVar.my();
                if (iMy == 10) {
                    if (iIntValue == 1) {
                        iMy = 2;
                    } else if (iIntValue == 2) {
                        iMy = 8;
                    }
                } else if (iMy == 1) {
                    if (iIntValue == 3) {
                        iMy = 1;
                    } else if (iIntValue == 4) {
                        iMy = 5;
                    }
                } else if (iMy == 7) {
                    if (iIntValue == 6) {
                        iMy = 7;
                    } else if (iIntValue == 7 || iIntValue == 8) {
                        iMy = 8;
                    }
                } else if (iMy == 5) {
                    if (iIntValue == 4) {
                        iMy = 5;
                    } else if (iIntValue == 5) {
                        iMy = 9;
                    } else if (iIntValue == 3) {
                        iMy = 1;
                    }
                }
                com.byazt.dj.tt.c cVarC = tt.c(ttVar, ttVar.gt(), str, str2, null, true);
                cVarC.sp(iMy).uj(ttVar.d()).a(ttVar.h()).n(ttVar.md());
                Integer num = (Integer) map.get(com.byazt.ly.c.tt);
                int iIntValue2 = num == null ? 0 : num.intValue();
                if (iMy == 3 || iMy == 7 || iMy == 8) {
                    if (ttVar.u() <= 0.0f || ttVar.yp() <= 0.0f) {
                        cVarC.c(a.c(context, 1080.0f)).tt(a.c(context, 1920.0f));
                    } else {
                        cVarC.c(ttVar.u()).tt(ttVar.yp());
                    }
                    if (ttVar.qy() <= 0 || ttVar.gu() <= 0) {
                        cVarC.c(1080).tt(1920);
                    } else {
                        cVarC.c(ttVar.qy()).tt(ttVar.gu());
                    }
                } else if (iMy == 1 || iMy == 2) {
                    if (ttVar.u() > 0.0f && ttVar.yp() <= 0.0f) {
                        cVarC.c(ttVar.u()).tt(0.0f);
                    } else if (ttVar.u() <= 0.0f || ttVar.yp() <= 0.0f) {
                        cVarC.c(a.c(context, 1080.0f)).tt(a.c(context, 600.0f));
                    } else {
                        cVarC.c(ttVar.u()).tt(ttVar.yp());
                    }
                    if (ttVar.qy() <= 0 || ttVar.gu() <= 0) {
                        cVarC.c(640).tt(340);
                    } else {
                        cVarC.c(ttVar.qy()).tt(ttVar.gu());
                    }
                } else if (iMy == 5 || iMy == 9) {
                    cVarC.ve(ttVar.gr());
                    if (ttVar.u() > 0.0f && ttVar.yp() <= 0.0f) {
                        cVarC.c(ttVar.u()).tt(0.0f);
                    } else if (ttVar.u() <= 0.0f || ttVar.yp() <= 0.0f) {
                        cVarC.c(a.c(context, 1080.0f)).tt(a.c(context, 750.0f));
                    } else {
                        cVarC.c(ttVar.u()).tt(ttVar.yp());
                    }
                    if (ttVar.gu() <= 0 || ttVar.qy() <= 0) {
                        cVarC.c(640).tt(340);
                    } else {
                        cVarC.c(ttVar.qy()).tt(ttVar.gu());
                    }
                } else {
                    cVarC.c(340).tt(640);
                    cVarC.c(340.0f).tt(640.0f);
                }
                if (iIntValue2 != 0 && iIntValue2 == 1 && iMy == 5) {
                    cVarC.n(iMy);
                }
                if (iMy == 1 || iMy == 2) {
                    cVarC.n(iMy);
                }
                return gt.c().c(cVarC.c(), false, -1);
            }
        }
        return null;
    }

    @Override // com.byazt.ly.uj
    public Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.byazt.ly.uj
    public String getNetworkSdkPluginVersion() {
        return com.byazt.tjo.tt.uj();
    }

    @Override // com.byazt.ly.uj
    public String getNetworkSdkVersion() {
        return com.byazt.tjo.tt.ve();
    }

    @Override // com.byazt.ly.tt
    public void initAdn(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull com.byazt.ly.ve veVar) {
        tt();
        veVar.c();
    }

    @Override // com.byazt.ly.uj
    public long initDuration() {
        return 0L;
    }

    @Override // com.byazt.ly.uj
    public int initStatus() {
        return 0;
    }

    @Override // com.byazt.ly.uj
    public void setPrivacyConfig(yp ypVar, SparseArray<Object> sparseArray) {
        com.byazt.bp.c.t().tt().tt(sparseArray);
        c();
    }

    @Override // com.byazt.ly.uj
    public void setThemeStatus(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(com.byazt.ly.c.n);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (iIntValue == 0 || iIntValue == 1) {
            com.byazt.tjo.tt.c(iIntValue);
        }
    }

    @Override // com.byazt.ly.uj
    public int showOpenOrInstallAppDialog(com.byazt.yf.ve veVar) {
        return 0;
    }
}
