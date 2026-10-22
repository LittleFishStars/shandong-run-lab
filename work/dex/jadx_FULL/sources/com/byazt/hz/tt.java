package com.byazt.hz;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.byazt.vx.my;
import com.byazt.vx.nu;
import com.byazt.vx.p;
import com.byazt.vx.qy;
import com.byazt.vx.z;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 13})
public abstract class tt implements com.byazt.ul.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ll.tt f28639a;
    public com.byazt.zq.a i;
    public String n;
    public com.byazt.nbs.tt sp;
    public com.byazt.zh.tt u;
    public com.byazt.yl.ve uj;
    public com.byazt.iz.tt ve;
    public SoftReference<Context> x;
    public com.byazt.ocd.tt yp;
    public boolean da = false;
    public int sl = 0;
    public volatile boolean t = false;
    public final Comparator<com.byazt.nbs.da> c = new Comparator<com.byazt.nbs.da>() { // from class: com.byazt.hz.tt.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.nbs.da daVar, com.byazt.nbs.da daVar2) {
            int iYv;
            int iYv2;
            if (daVar.yv() == daVar2.yv()) {
                iYv = daVar.p();
                iYv2 = daVar2.p();
            } else {
                iYv = daVar.yv();
                iYv2 = daVar2.yv();
            }
            return iYv - iYv2;
        }
    };
    public final Comparator<com.byazt.nbs.da> z = new Comparator<com.byazt.nbs.da>() { // from class: com.byazt.hz.tt.2
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.nbs.da daVar, com.byazt.nbs.da daVar2) {
            if (daVar.gr() > daVar2.gr()) {
                return -1;
            }
            return daVar.gr() < daVar2.gr() ? 1 : 0;
        }
    };
    public final Comparator<com.byazt.nbs.da> tt = new Comparator<com.byazt.nbs.da>() { // from class: com.byazt.hz.tt.3
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compare(com.byazt.nbs.da daVar, com.byazt.nbs.da daVar2) {
            if (daVar.zm() > daVar2.zm()) {
                return -1;
            }
            return daVar.zm() < daVar2.zm() ? 1 : 0;
        }
    };

    public tt(Context context) {
        this.x = new SoftReference<>(context);
    }

    private List<com.byazt.nbs.da> n(List<com.byazt.nbs.da> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.byazt.nbs.da> it = list.iterator();
        while (it.hasNext()) {
            com.byazt.nbs.da next = it.next();
            if (next.cu()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.zb() || next.qp() || next.or()) {
                it.remove();
                com.byazt.nbs.da daVar = new com.byazt.nbs.da();
                daVar.n(next.rh());
                daVar.da(next.my());
                daVar.ve(next.z());
                daVar.uj(next.x());
                daVar.c(next.sp());
                daVar.sl(next.yv());
                daVar.t(next.p());
                daVar.i(next.u());
                StringBuilder sb = new StringBuilder();
                sb.append(next.gr());
                daVar.sp(sb.toString());
                daVar.tt(next.yp());
                daVar.x(next.md());
                daVar.i(next.h());
                daVar.c(next.d());
                daVar.a(next.gu());
                com.byazt.yl.ve veVarC = c(daVar);
                if (veVarC != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(veVarC.getBiddingCpmWithOutExchangeRate());
                    daVar.sp(sb2.toString());
                }
                arrayList.add(daVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.tt);
        Collections.sort(arrayList2, this.c);
        list.addAll(0, arrayList2);
        return list;
    }

    public static int tt(String str) {
        if (!com.byazt.hr.u.c().x(str)) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==--: 命中展示频次");
            return 840041;
        }
        if (com.byazt.hr.u.c().ve(str)) {
            return 0;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "--==--: 命中展示间隔");
        return 840042;
    }

    @DungeonFlag
    private void uj(com.byazt.yl.ve veVar) {
        HashMap map;
        if (veVar == null || this.f28639a == null) {
            return;
        }
        if (TextUtils.equals(veVar.getAdnName(), "xiaomi")) {
            HashMap map2 = new HashMap();
            map2.put("ecpm", Long.valueOf((long) veVar.getCpm()));
            veVar.bidWinNotify(map2);
            return;
        }
        if (this.f28639a.or()) {
            if (veVar.isMultiBiddingAd() || veVar.isClientBiddingAd() || veVar.isServerBiddingAd()) {
                if (TextUtils.equals(veVar.getAdnName(), "baidu")) {
                    map = new HashMap();
                    if (com.byazt.bp.tt.tt().iu()) {
                        com.byazt.yl.ve veVarVe = ve(veVar);
                        map.put("ecpm", Integer.valueOf(veVarVe != null ? (int) veVarVe.getCpm() : 0));
                        map.put("adn", 10);
                        map.put("ad_t", 7);
                        map.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map.put("bid_t", 3);
                    } else if (com.byazt.bp.tt.tt().j()) {
                        com.byazt.yl.ve veVarVe2 = ve(veVar);
                        int cpm = veVarVe2 != null ? (int) veVarVe2.getCpm() : 0;
                        int cpm2 = (int) veVar.getCpm();
                        int iNextInt = new SecureRandom().nextInt(21) + 10;
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "-------baidu_bid_win firstAdEcpm = " + cpm2 + " secondAdEcpm =" + cpm + " randomNumber = " + iNextInt);
                        map.put("ecpm", Integer.valueOf(Math.max(cpm2 - iNextInt, cpm)));
                        map.put("adn", 10);
                        map.put("ad_t", 7);
                        map.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map.put("bid_t", 4);
                    } else {
                        map.put("ecpm", 0);
                        map.put("adn", 10);
                        map.put("ad_t", 7);
                        map.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map.put("bid_t", 4);
                    }
                } else if (TextUtils.equals(veVar.getAdnName(), MediationConstant.ADN_KS)) {
                    map = new HashMap();
                    if (com.byazt.bp.tt.tt().dz()) {
                        com.byazt.yl.ve veVarVe3 = ve(veVar);
                        map.put("bidEcpm", Double.valueOf(veVar.getCpm()));
                        map.put("lossBidEcpm", Double.valueOf(veVarVe3 != null ? veVarVe3.getCpm() : AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else {
                        map.put("bidEcpm", 0);
                        map.put("lossBidEcpm", 0);
                    }
                } else {
                    map = null;
                }
                veVar.bidWinNotify(map);
            }
        }
    }

    public void c(com.byazt.ll.tt ttVar) {
        com.byazt.iz.tt ttVarC = com.byazt.iz.tt.c(this.x, ttVar, this);
        this.ve = ttVarC;
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        this.f28639a = ttVarGu;
        this.n = ttVarGu.gt();
        this.ve.zb().put("allow_show_close_btn", Boolean.valueOf(ttVar.nu()));
        this.sp = this.ve.m();
    }

    @Override // com.byazt.ul.c
    public void c(@Nullable String str) {
    }

    @Override // com.byazt.ul.c
    public void c(@Nullable List<com.byazt.yl.ve> list, @Nullable com.byazt.pp.c cVar) {
    }

    public List<com.byazt.pp.tt> da() {
        return this.ve.md();
    }

    public com.byazt.pp.ve f_() {
        if (this.uj == null || z.c()) {
            return null;
        }
        return com.byazt.vx.t.c(this.f28639a, this.uj, true);
    }

    public int gt() {
        com.byazt.yl.ve veVar = this.uj;
        if (veVar == null || this.ve == null) {
            return 0;
        }
        return TextUtils.equals(veVar.getAdNetworkSlotId(), this.ve.tt()) ? 1 : 0;
    }

    public com.byazt.om.sp i() {
        com.byazt.eu.tt.tt(MediationConstant.TAG, "ad load start.....");
        if (com.byazt.bp.tt.tt().aw()) {
            com.byazt.ng.a.c((com.byazt.yl.ve) null, this.ve.gu(), nu.c(), 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.om.sl());
        arrayList.add(new com.byazt.om.t());
        arrayList.add(new com.byazt.om.n());
        arrayList.add(new com.byazt.om.ve());
        arrayList.add(new com.byazt.om.u());
        arrayList.add(new com.byazt.om.a());
        arrayList.add(new com.byazt.om.x());
        arrayList.add(new com.byazt.om.tt());
        arrayList.add(new com.byazt.om.uj());
        com.byazt.om.sp spVar = new com.byazt.om.sp(arrayList);
        spVar.c(this.ve);
        return spVar;
    }

    public int m() {
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null) {
            return veVar.getInteractionType();
        }
        return -1;
    }

    public com.byazt.ll.tt my() {
        return this.f28639a;
    }

    public Map<String, Object> nu() {
        com.byazt.yl.ve veVar = this.uj;
        Map<String, Object> mediaExtraInfo = veVar != null ? veVar.getMediaExtraInfo() : null;
        if (mediaExtraInfo == null) {
            mediaExtraInfo = ve(this.n);
        }
        com.byazt.yl.ve veVar2 = this.uj;
        if (veVar2 != null && veVar2.getExtraMsg() != null) {
            mediaExtraInfo.putAll(this.uj.getExtraMsg());
        }
        if (this.f28639a.cu() != null) {
            mediaExtraInfo.putAll(this.f28639a.cu());
        }
        if (z.c()) {
            String strC = z.c(com.byazt.vx.t.c(this.f28639a, this.uj, true));
            if (!TextUtils.isEmpty(strC)) {
                mediaExtraInfo.put("get_show_ecpm_info", strC);
            }
        }
        return mediaExtraInfo;
    }

    public int rh() {
        com.byazt.ll.tt ttVar = this.f28639a;
        if (ttVar != null) {
            return ttVar.n();
        }
        return 0;
    }

    public List<com.byazt.pp.ve> sl() {
        if (!com.byazt.bp.tt.tt().or()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.yl.ve veVar : this.ve.yp()) {
            if (veVar != null) {
                arrayList.add(com.byazt.vx.t.c(this.f28639a, veVar, false));
            }
        }
        return arrayList;
    }

    @Override // com.byazt.ul.c
    public void sp() {
    }

    public List<com.byazt.pp.ve> t() {
        if (!com.byazt.bp.tt.tt().or()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.yl.ve veVar : this.ve.c(false)) {
            if (veVar != null) {
                arrayList.add(com.byazt.vx.t.c(this.f28639a, veVar, false));
            }
        }
        return arrayList;
    }

    @Override // com.byazt.ul.c
    public void tt(@NonNull com.byazt.pp.c cVar) {
    }

    public boolean u() {
        boolean zVe = qy.ve(com.byazt.bp.tt.getContext());
        boolean zTt = qy.tt(com.byazt.bp.tt.getContext());
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(this.n) + "setting 下发是否为弱网执行：" + com.byazt.bp.tt.tt().m() + "，当前网络环境：2G-type=" + zVe + ",3G-type=" + zTt);
        if (com.byazt.bp.tt.tt().m()) {
            return zVe || zTt;
        }
        return false;
    }

    public void ve() {
        com.byazt.yl.ve veVar = this.uj;
        if (veVar != null) {
            veVar.onDestroy();
        }
        this.ve.sv();
        this.i = null;
    }

    @Override // com.byazt.ul.c
    public void x() {
    }

    public List<com.byazt.nbs.da> yp() {
        com.byazt.nbs.tt ttVar = this.sp;
        if (ttVar == null || ttVar.l() == null || this.sp.l().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.nbs.da daVar : this.sp.l()) {
            if (daVar != null && daVar.my() == 100) {
                arrayList.add(daVar);
            }
        }
        return arrayList;
    }

    public com.byazt.pp.ve z() {
        List<com.byazt.yl.ve> listC;
        com.byazt.ll.tt ttVar = this.f28639a;
        if ((ttVar != null && !ttVar.tk() && !com.byazt.bp.tt.tt().or()) || (listC = this.ve.c(true)) == null || listC.size() == 0) {
            return null;
        }
        return com.byazt.vx.t.c(this.f28639a, listC.get(0), false);
    }

    private com.byazt.yl.ve ve(com.byazt.yl.ve veVar) {
        LinkedList<com.byazt.yl.ve> linkedList = new LinkedList();
        com.byazt.iz.tt ttVar = this.ve;
        if (ttVar != null) {
            if (ttVar.yp() != null && this.ve.yp().size() != 0) {
                linkedList.addAll(this.ve.yp());
            }
            if (this.ve.t() != null && this.ve.t().size() != 0) {
                linkedList.addAll(this.ve.t());
            }
            if (this.ve.sl() != null && this.ve.sl().size() != 0) {
                linkedList.addAll(this.ve.sl());
            }
        }
        com.byazt.yl.ve veVar2 = null;
        if (linkedList.size() != 0 && veVar != null) {
            double cpm = Double.MIN_NORMAL;
            for (com.byazt.yl.ve veVar3 : linkedList) {
                if (veVar3.getCpm() < veVar.getCpm() && veVar3.getCpm() > cpm) {
                    cpm = veVar3.getCpm();
                    veVar2 = veVar3;
                }
            }
        }
        return veVar2;
    }

    public HashMap<String, com.byazt.yl.ve> tt(List<com.byazt.yl.ve> list) {
        HashMap<String, com.byazt.yl.ve> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.byazt.yl.ve veVar : list) {
                if (veVar != null) {
                    map.put(veVar.getAdNetworkSlotId(), veVar);
                }
            }
        }
        return map;
    }

    public void c(com.byazt.yl.ve veVar) {
        if (com.byazt.bp.tt.tt().aw()) {
            com.byazt.ng.a.c(veVar, this.f28639a, nu.c(), 2);
        }
    }

    @DungeonFlag
    public void c(List<com.byazt.yl.ve> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        com.byazt.pl.c.c(this.f28639a, this.sp, list, this.ve.yp());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            uj((com.byazt.yl.ve) it.next());
        }
        if (this.ve.yp().size() == 0) {
            return;
        }
        ArrayList<com.byazt.yl.ve> arrayList2 = new ArrayList();
        arrayList2.addAll(this.ve.yp());
        com.byazt.yl.ve veVarVe = ve(list);
        for (com.byazt.yl.ve veVar : arrayList2) {
            Iterator<com.byazt.yl.ve> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                com.byazt.yl.ve next = it2.next();
                if (next != null && veVar != null && next == veVar) {
                    z = false;
                    break;
                }
            }
            if (z) {
                c(veVarVe, veVar, 1);
            }
        }
    }

    public void tt(com.byazt.yl.ve veVar) {
        com.byazt.ll.tt ttVar = this.f28639a;
        int mediationRitReqType = veVar.getMediationRitReqType(ttVar != null ? ttVar.c() : null);
        veVar.setMediationRitReqType(3);
        veVar.setMediationRitReqTypeSrc(mediationRitReqType);
    }

    public List<com.byazt.nbs.da> tt() {
        boolean z;
        List<com.byazt.nbs.da> arrayList = new ArrayList<>();
        com.byazt.iz.tt ttVar = this.ve;
        if (ttVar == null || this.sp == null || ttVar.da()) {
            return arrayList;
        }
        Map<Integer, List<com.byazt.nbs.da>> mapMd = this.sp.md();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : mapMd.keySet()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        com.byazt.oi.tt.c(arrayList2);
        int i = 0;
        if (arrayList2.size() > 0) {
            int i2 = 0;
            z = false;
            while (i < arrayList2.size()) {
                Integer num2 = (Integer) arrayList2.get(i);
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    if (iIntValue == -100) {
                        i2 = 1;
                    }
                    if (iIntValue < -100) {
                        z = true;
                    }
                    if (mapMd.get(Integer.valueOf(iIntValue)) != null) {
                        arrayList.addAll(mapMd.get(Integer.valueOf(iIntValue)));
                    }
                }
                i++;
            }
            i = i2;
        } else {
            z = false;
        }
        if (i == 0 && this.sp.or() && !p.tt(this.ve.yp())) {
            for (com.byazt.yl.ve veVar : this.ve.yp()) {
                if (this.sp != null && (veVar.isMultiBiddingAd() || veVar.isClientBiddingAd())) {
                    com.byazt.nbs.da daVarA = this.sp.a(veVar.getAdNetworkSlotId());
                    if (daVarA != null) {
                        arrayList.add(daVarA);
                    }
                }
            }
        }
        if (!z) {
            List<com.byazt.nbs.da> listYp = yp();
            if (!p.c(listYp)) {
                arrayList.addAll(listYp);
            }
        }
        Iterator<com.byazt.nbs.da> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (!this.sp.zb() && !this.sp.or()) {
            if (uj(arrayList)) {
                Collections.sort(arrayList, this.tt);
                return arrayList;
            }
            Collections.sort(arrayList, this.c);
            return arrayList;
        }
        return n(arrayList);
    }

    private com.byazt.yl.ve ve(List<com.byazt.yl.ve> list) {
        com.byazt.yl.ve veVar = null;
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            double cpm = Double.MIN_NORMAL;
            for (com.byazt.yl.ve veVar2 : list) {
                if (veVar2.getCpm() > cpm) {
                    cpm = veVar2.getCpm();
                    veVar = veVar2;
                }
            }
        }
        return veVar;
    }

    @DungeonFlag
    public void c(com.byazt.yl.ve veVar, com.byazt.yl.ve veVar2, int i) {
        if (veVar2 == null || this.f28639a == null || i <= 0) {
            return;
        }
        if (TextUtils.equals(veVar2.getAdnName(), "xiaomi")) {
            HashMap map = new HashMap();
            map.put("ecpm", Long.valueOf(veVar != null ? (long) veVar.getCpm() : 0L));
            map.put(MediationConstant.KEY_REASON, "其他");
            map.put("adn_id", 1);
            veVar2.bidLoseNotify(map);
            return;
        }
        if (this.f28639a.or()) {
            HashMap map2 = new HashMap();
            map2.put(MediationConstant.BIDDING_LOSE_REASON, com.byazt.sq.tt.c(i));
            map2.put("bidding_lose_reason_NUM", Integer.valueOf(i));
            if (TextUtils.equals(veVar2.getAdnName(), "baidu")) {
                if (com.byazt.bp.tt.tt().iu()) {
                    map2.put("ecpm", Integer.valueOf(veVar != null ? (int) veVar.getCpm() : 0));
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 3);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                } else if (com.byazt.bp.tt.tt().j()) {
                    map2.put("ecpm", Integer.valueOf(veVar != null ? (int) veVar.getCpm() : 0));
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                } else {
                    map2.put("ecpm", 0);
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                }
            } else if (TextUtils.equals(veVar2.getAdnName(), MediationConstant.ADN_KS)) {
                if (com.byazt.bp.tt.tt().dz()) {
                    map2.put("failureCode", 2);
                    map2.put("bidEcpm", Double.valueOf(veVar != null ? veVar.getCpm() : AudioStats.AUDIO_AMPLITUDE_NONE));
                    map2.put("adType", 2);
                    map2.put(MediationConstant.KEY_ADN_NAME, "other");
                } else {
                    map2.put("failureCode", 0);
                    map2.put("bidEcpm", 0);
                    map2.put("adType", 2);
                    map2.put(MediationConstant.KEY_ADN_NAME, "other");
                }
            }
            veVar2.bidLoseNotify(map2);
        }
    }

    public static Map<String, Object> ve(String str) {
        my myVar = new my();
        myVar.put(MediationConstant.KEY_GM_PRIME_RIT, str);
        return myVar;
    }

    private boolean uj(List<com.byazt.nbs.da> list) {
        Iterator<com.byazt.nbs.da> it = list.iterator();
        while (it.hasNext()) {
            if (!TextUtils.isEmpty(it.next().gu())) {
                return true;
            }
        }
        return false;
    }

    private com.byazt.yl.ve c(com.byazt.nbs.da daVar) {
        if (daVar == null) {
            return null;
        }
        String strRh = daVar.rh();
        String strVe = daVar.d() != null ? daVar.d().ve() : null;
        if (TextUtils.isEmpty(strRh)) {
            return null;
        }
        for (com.byazt.yl.ve veVar : this.ve.sl()) {
            if (veVar != null && strRh.equals(veVar.getAdNetworkSlotId())) {
                return veVar;
            }
        }
        for (com.byazt.yl.ve veVar2 : this.ve.t()) {
            if (veVar2 != null && strRh.equals(veVar2.getAdNetworkSlotId())) {
                return veVar2;
            }
        }
        for (com.byazt.yl.ve veVar3 : this.ve.yp()) {
            if (veVar3 != null) {
                if (veVar3.isServerBiddingAd() && !TextUtils.isEmpty(strVe) && !TextUtils.isEmpty(veVar3.getAid())) {
                    if (strRh.equals(veVar3.getAdNetworkSlotId()) && strVe.equals(veVar3.getAid())) {
                        return veVar3;
                    }
                } else if (strRh.equals(veVar3.getAdNetworkSlotId())) {
                    return veVar3;
                }
            }
        }
        return null;
    }

    public void c(com.byazt.zh.tt ttVar) {
        this.u = ttVar;
    }

    public void c(com.byazt.ocd.tt ttVar) {
        this.yp = ttVar;
    }
}
