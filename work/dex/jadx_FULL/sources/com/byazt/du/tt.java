package com.byazt.du;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nr.m;
import com.byazt.xl.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 441, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28436a;
    public u i;
    public double n;
    public double sp;
    public String x;
    public Map<String, ve> c = new HashMap();
    public Map<String, ve> tt = new HashMap();
    public Map<String, ve> ve = new HashMap();
    public double uj = Math.random();

    @com.byazt.zqa.c(c = {0, 1, 441, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c implements Cloneable {
        public float c;
        public boolean tt;
        public float ve;

        public Object clone() {
            try {
                return (c) super.clone();
            } catch (CloneNotSupportedException e) {
                m.c(e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.du.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 441, 240})
    public static class C0390tt {
        public float c;
        public float n;
        public int tt;
        public double uj;
        public int ve;

        public static JSONObject c(C0390tt c0390tt) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0390tt.c);
                jSONObject.put("letterSpacing", c0390tt.tt);
                jSONObject.put("lineHeight", c0390tt.uj);
                jSONObject.put("maxWidth", c0390tt.n);
                jSONObject.put("fontWeight", c0390tt.ve);
            } catch (JSONException e) {
                m.c(e);
            }
            return jSONObject;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 441, 519})
    public static class ve {
        public float c;
        public float tt;

        public ve() {
        }

        public String toString() {
            return "UnitSize{width=" + this.c + ", height=" + this.tt + '}';
        }

        public ve(float f, float f2) {
            this.c = f;
            this.tt = f2;
        }
    }

    public tt(double d, int i, double d2, String str, u uVar) {
        this.n = d;
        this.f28436a = i;
        this.sp = d2;
        this.x = str;
        this.i = uVar;
    }

    private ve a(com.byazt.aq.x xVar, float f, float f2) {
        com.byazt.aq.a aVarN = xVar.da().n();
        float fRh = aVarN.rh();
        int iLt = aVarN.lt();
        double dPu = aVarN.pu();
        int iTk = aVarN.tk();
        boolean zIc = aVarN.ic();
        boolean zKp = aVarN.kp();
        int iHd = aVarN.hd();
        C0390tt c0390tt = new C0390tt();
        c0390tt.c = fRh;
        c0390tt.tt = iLt;
        c0390tt.ve = iTk;
        c0390tt.uj = dPu;
        c0390tt.n = f;
        return c(xVar.da().tt(), c0390tt, zIc, zKp, iHd, xVar);
    }

    private ve n(com.byazt.aq.x xVar, float f, float f2) {
        String str = xVar.ve() + LoginConstants.UNDER_LINE + f + LoginConstants.UNDER_LINE + f2;
        if (this.ve.containsKey(str)) {
            return this.ve.get(str);
        }
        ve veVarA = a(xVar, f, f2);
        this.ve.put(str, veVarA);
        return veVarA;
    }

    public ve c(com.byazt.aq.x xVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(xVar.da().tt()) && xVar.da().n().oz() == null) {
            return new ve(0.0f, 0.0f);
        }
        if (TextUtils.equals(xVar.da().getType(), "creative-playable-bait")) {
            return new ve(0.0f, 0.0f);
        }
        float fX = xVar.x();
        float fI = xVar.i();
        com.byazt.aq.a aVarN = xVar.da().n();
        String strMd = aVarN.md();
        String strP = aVarN.p();
        float fU = xVar.u();
        float fYp = xVar.yp();
        float fZ = xVar.z();
        float fM = xVar.m();
        if (TextUtils.equals(strMd, "fixed")) {
            f = Math.min(fX, f);
            if (TextUtils.equals(strP, "auto")) {
                f3 = tt(xVar, f - fZ, f2 - fM).tt;
                fI = f3 + fM;
            }
        } else if (TextUtils.equals(strMd, "auto")) {
            ve veVarTt = tt(xVar, f - fZ, f2 - fM);
            f = veVarTt.c + fZ;
            if (TextUtils.equals(strP, "auto")) {
                f3 = veVarTt.tt;
                fI = f3 + fM;
            }
        } else if (!TextUtils.equals(strMd, "flex")) {
            f = fX;
        } else if (TextUtils.equals(strP, "auto")) {
            f3 = tt(xVar, f - fZ, f2 - fM).tt;
            fI = f3 + fM;
        }
        if (TextUtils.equals(strP, "scale")) {
            float fRound = Math.round((f - fU) / fI) + fYp;
            if (fRound > f2) {
                f = Math.round((f2 - fYp) * fI) + fU;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strP, "fixed")) {
            f2 = Math.min(fI + fYp, f2);
        } else if (!TextUtils.equals(strP, "flex")) {
            f2 = fI;
        }
        ve veVar = new ve();
        veVar.c = f;
        veVar.tt = f2;
        return veVar;
    }

    public ve tt(com.byazt.aq.x xVar, float f, float f2) {
        ve veVar = new ve();
        if (xVar.da().n() == null) {
            return veVar;
        }
        ve veVarN = n(xVar, f, f2);
        float f3 = veVarN.c;
        float f4 = veVarN.tt;
        veVar.c = Math.min(f3, f);
        veVar.tt = Math.min(f4, f2);
        return veVar;
    }

    public ve uj(com.byazt.aq.x xVar, float f, float f2) {
        float fMin;
        ve veVar = new ve();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            veVar.c = 0.0f;
            veVar.tt = 0.0f;
            return veVar;
        }
        if (xVar.rh()) {
            return c(xVar, f, f2);
        }
        float fX = xVar.x();
        float fI = xVar.i();
        float fZ = xVar.z();
        float fM = xVar.m();
        com.byazt.aq.a aVarN = xVar.da().n();
        String strMd = aVarN.md();
        String strP = aVarN.p();
        float fMin2 = ((TextUtils.equals(strMd, "flex") || TextUtils.equals(strMd, "auto")) ? f : Math.min(fX, f)) - fZ;
        if (TextUtils.equals(strP, "scale")) {
            fMin = Math.round(fMin2 / fI) + fM;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fM) * fI);
            }
        } else {
            fMin = (TextUtils.equals(strP, "auto") || TextUtils.equals(strP, "flex")) ? f2 : Math.min(fI, f2);
        }
        float f4 = fMin - fM;
        List<List<com.byazt.aq.x>> listNu = xVar.nu();
        Iterator<List<com.byazt.aq.x>> it = listNu.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.byazt.aq.x>> it2 = it;
            List<com.byazt.aq.x> next = it.next();
            ve veVar2 = veVar;
            ve veVarTt = tt(next, fMin2, f4);
            if (tt(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, veVarTt.c);
            }
            float f5 = f3;
            fMax2 = xVar.da().getType().equals("carousel") ? Math.max(xVar.i(), veVarTt.tt) : fMax2 + veVarTt.tt;
            veVar = veVar2;
            it = it2;
            f3 = f5;
        }
        ve veVar3 = veVar;
        if (TextUtils.equals(strMd, "auto")) {
            if (f3 == listNu.size()) {
                fMin2 = f;
            } else {
                for (List<com.byazt.aq.x> list : listNu) {
                    ve(list);
                    tt(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strP, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                c(listNu, fMin2, f4);
            }
        } else if ((TextUtils.equals(strP, "fixed") || TextUtils.equals(strP, "flex")) && f4 < fMax2) {
            c(listNu, fMin2, f4);
        }
        veVar3.c = Math.min(fMin2 + fZ, f);
        veVar3.tt = Math.min(f4 + fM, f2);
        return veVar3;
    }

    public ve ve(com.byazt.aq.x xVar, float f, float f2) {
        if (xVar == null) {
            return null;
        }
        ve veVarC = c(xVar);
        if (veVarC != null && (veVarC.c != 0.0f || veVarC.tt != 0.0f)) {
            return veVarC;
        }
        ve veVarUj = uj(xVar, f, f2);
        c(xVar, veVarUj);
        return veVarUj;
    }

    private ve ve(List<com.byazt.aq.x> list, float f, float f2) {
        float fMax;
        uj(list);
        ve veVar = new ve();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.byazt.aq.x xVar : list) {
            com.byazt.aq.a aVarN = xVar.da().n();
            if (aVarN.b() == 1 || aVarN.b() == 2) {
                arrayList.add(xVar);
            }
            if (aVarN.b() != 1 && aVarN.b() != 2) {
                arrayList2.add(xVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ve((com.byazt.aq.x) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return veVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.byazt.aq.x> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(ve(it2.next(), f, f2).c));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            fMax = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            com.byazt.aq.x xVar2 = arrayList2.get(i);
            String strMd = xVar2.da().n().md();
            float fX = xVar2.x();
            boolean zEquals = TextUtils.equals(strMd, "flex");
            if (TextUtils.equals(strMd, "auto")) {
                List<List<com.byazt.aq.x>> listNu = xVar2.nu();
                if (listNu == null || listNu.size() <= 0) {
                    zEquals = false;
                    break;
                }
                Iterator<List<com.byazt.aq.x>> it3 = listNu.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        zEquals = false;
                        break;
                    }
                    if (tt(it3.next())) {
                        zEquals = true;
                        break;
                    }
                }
            }
            c cVar = new c();
            if (!zEquals) {
                fX = ((Float) arrayList3.get(i)).floatValue();
            }
            cVar.c = fX;
            cVar.tt = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            cVar.ve = fMax;
            arrayList4.add(cVar);
            i++;
        }
        c(arrayList4, f, arrayList2);
        List<c> listC = da.c(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listC.get(i2).c;
            if (((Float) arrayList3.get(i2)).floatValue() != listC.get(i2).c) {
                uj(arrayList2.get(i2));
            }
        }
        Iterator<com.byazt.aq.x> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (it4.hasNext()) {
            i3++;
            if (!tt(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.byazt.aq.x xVar3 = arrayList2.get(i4);
            ve veVarVe = ve(xVar3, listC.get(i4).c, f2);
            if (!tt(xVar3)) {
                fMax = Math.max(fMax, veVarVe.tt);
            }
            arrayList5.add(veVarVe);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((ve) it5.next()).tt));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.byazt.aq.x xVar4 = arrayList2.get(i5);
                if (tt(xVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    uj(xVar4);
                    ve(xVar4, listC.get(i5).c, fMax);
                }
            }
        }
        veVar.c = f3;
        veVar.tt = fMax;
        return veVar;
    }

    private boolean tt(List<com.byazt.aq.x> list) {
        boolean z;
        List<List<com.byazt.aq.x>> listNu;
        Iterator<com.byazt.aq.x> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().da().n().md(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (com.byazt.aq.x xVar : list) {
                if (TextUtils.equals(xVar.da().n().md(), "auto") && (listNu = xVar.nu()) != null) {
                    Iterator<List<com.byazt.aq.x>> it2 = listNu.iterator();
                    int i = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            List<com.byazt.aq.x> next = it2.next();
                            i++;
                            if (tt(next)) {
                                if (i == next.size()) {
                                    z2 = true;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return z2;
        }
    }

    private String n(com.byazt.aq.x xVar) {
        return xVar.ve();
    }

    private ve tt(List<com.byazt.aq.x> list, float f, float f2) {
        ve veVarC = c(list);
        if (veVarC != null && (veVarC.c != 0.0f || veVarC.tt != 0.0f)) {
            return veVarC;
        }
        ve veVarVe = ve(list, f, f2);
        c(list, veVarVe);
        return veVarVe;
    }

    private boolean tt(com.byazt.aq.x xVar) {
        if (xVar == null) {
            return false;
        }
        if (TextUtils.equals(xVar.da().n().p(), "flex")) {
            return true;
        }
        return ve(xVar);
    }

    private ve c(String str, C0390tt c0390tt, boolean z, boolean z2, int i, com.byazt.aq.x xVar) {
        return sl.c(str, xVar.da().getType(), C0390tt.c(c0390tt).toString(), z, z2, i, xVar, this.n, this.f28436a, this.sp, this.x, this.i);
    }

    private void c(List<List<com.byazt.aq.x>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.byazt.aq.x>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (c(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.byazt.aq.x> list2 : list) {
            c cVar = new c();
            boolean zC = c(list2, !z);
            cVar.c = zC ? 1.0f : tt(list2, f, f2).tt;
            cVar.tt = !zC;
            arrayList.add(cVar);
        }
        List<c> listC = da.c(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((c) arrayList.get(i)).c != listC.get(i).c) {
                List<com.byazt.aq.x> list3 = list.get(i);
                ve(list3);
                tt(list3, f, listC.get(i).c);
            }
        }
    }

    private void uj(com.byazt.aq.x xVar) {
        this.c.remove(n(xVar));
        List<List<com.byazt.aq.x>> listNu = xVar.nu();
        if (listNu == null || listNu.size() <= 0) {
            return;
        }
        Iterator<List<com.byazt.aq.x>> it = listNu.iterator();
        while (it.hasNext()) {
            ve(it.next());
        }
    }

    private String uj(List<com.byazt.aq.x> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strVe = list.get(i).ve();
            if (i < list.size() - 1) {
                sb.append(strVe);
                sb.append(c49.f40900a);
            } else {
                sb.append(strVe);
            }
        }
        return sb.toString();
    }

    private boolean c(List<com.byazt.aq.x> list, boolean z) {
        boolean z2;
        Iterator<com.byazt.aq.x> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            com.byazt.aq.x next = it.next();
            com.byazt.aq.a aVarN = next.da().n();
            String strP = aVarN.p();
            if (TextUtils.equals(strP, "flex") || (z && ((TextUtils.equals(aVarN.md(), "flex") && TextUtils.equals(aVarN.p(), "scale") && com.byazt.aq.n.c.get(next.da().getType()).intValue() == 7) || TextUtils.equals(strP, "flex")))) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        Iterator<com.byazt.aq.x> it2 = list.iterator();
        while (it2.hasNext()) {
            if (ve(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean ve(com.byazt.aq.x xVar) {
        List<List<com.byazt.aq.x>> listNu;
        if (!xVar.rh() && TextUtils.equals(xVar.da().n().p(), "auto") && (listNu = xVar.nu()) != null && listNu.size() > 0) {
            if (listNu.size() == 1) {
                Iterator<com.byazt.aq.x> it = listNu.get(0).iterator();
                while (it.hasNext()) {
                    if (!tt(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.byazt.aq.x>> it2 = listNu.iterator();
            while (it2.hasNext()) {
                if (c(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void c(List<c> list, float f, List<com.byazt.aq.x> list2) {
        float f2 = 0.0f;
        for (c cVar : list) {
            if (cVar.tt) {
                f2 += cVar.c;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).tt && list2.get(i2).qy()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    c cVar2 = list.get(i3);
                    if (cVar2.tt && list2.get(i3).qy()) {
                        cVar2.c -= fCeil;
                    }
                }
            }
        }
    }

    private void ve(List<com.byazt.aq.x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.tt.remove(uj(list));
        Iterator<com.byazt.aq.x> it = list.iterator();
        while (it.hasNext()) {
            uj(it.next());
        }
    }

    public void c() {
        this.ve.clear();
        this.c.clear();
        this.tt.clear();
    }

    public ve c(com.byazt.aq.x xVar) {
        return this.c.get(n(xVar));
    }

    public ve c(List<com.byazt.aq.x> list) {
        return this.tt.get(uj(list));
    }

    private void c(com.byazt.aq.x xVar, ve veVar) {
        this.c.put(n(xVar), veVar);
    }

    private void c(List<com.byazt.aq.x> list, ve veVar) {
        this.tt.put(uj(list), veVar);
    }
}
