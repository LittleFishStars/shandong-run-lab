package com.beizi.fusion;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class s1 {
    public static SparseArray d = new SparseArray();
    public static SparseArray e = new SparseArray();
    public static SparseArray f = new SparseArray();
    public static SparseArray g = new SparseArray();
    public static SparseArray h = new SparseArray();
    public static SparseArray i = new SparseArray();
    public static SparseArray j = new SparseArray();
    public static SparseArray k = new SparseArray();
    public static SparseArray l = new SparseArray();
    public static SparseArray m = new SparseArray();
    public static SparseArray n = new SparseArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap f27738a = new HashMap();
    private HashMap b = new HashMap();
    private EventBean c;

    public class a extends l {
        public a() {
            super();
        }
    }

    public class b extends l {
        public b() {
            super();
        }
    }

    public class c extends l {
        public c() {
            super();
        }
    }

    public class d extends l {
        public d() {
            super();
        }
    }

    public class e extends l {
        public e() {
            super();
        }
    }

    public class f extends l {
        public f() {
            super();
        }
    }

    public class g extends l {
        public g() {
            super();
        }
    }

    public class h extends l {
        public h() {
            super();
        }
    }

    public class i extends l {
        public i() {
            super();
        }
    }

    public class j extends l {
        public j() {
            super();
        }
    }

    public class k extends l {
        public k() {
            super();
        }
    }

    static {
        d.put(1, "100.000");
        d.put(2, "100.200");
        e.put(-1, "210.400");
        e.put(-2, "210.999");
        e.put(1, "200.001");
        e.put(2, "210.100");
        e.put(3, "210.200");
        e.put(4, "210.401");
        e.put(5, "210.402");
        e.put(6, "210.403");
        e.put(7, "210.404");
        f.put(-1, "220.400");
        f.put(-2, "220.999");
        f.put(1, "220.000");
        f.put(2, "200.000");
        f.put(3, "220.401");
        f.put(4, "220.402");
        f.put(5, "220.403");
        f.put(6, "220.404");
        g.put(-1, "230.400");
        g.put(-2, "230.999");
        g.put(1, "230.000");
        g.put(2, "230.200");
        g.put(3, "230.401");
        g.put(4, "230.402");
        h.put(-1, "245.400");
        h.put(-2, "245.999");
        h.put(1, "240.000");
        h.put(2, "245.000");
        h.put(3, "245.200");
        h.put(4, "245.401");
        h.put(5, "245.402");
        h.put(6, "245.403");
        h.put(7, "245.404");
        h.put(8, "245.300");
        h.put(9, "240.100");
        h.put(10, "245.405");
        i.put(-1, "249.400");
        i.put(-2, "249.999");
        i.put(1, "248.000");
        i.put(2, "249.000");
        i.put(3, "248.401");
        i.put(4, "248.402");
        i.put(5, "249.401");
        i.put(6, "249.402");
        j.put(-1, "280.600");
        j.put(1, "250.100");
        j.put(2, "250.200");
        j.put(16, "250.401");
        j.put(3, "255.200");
        j.put(4, "280.200");
        j.put(5, "280.280");
        j.put(6, "280.300");
        j.put(12, "280.350");
        j.put(7, "290.300");
        j.put(17, "290.301");
        j.put(8, "280.400");
        j.put(9, "280.450");
        j.put(11, "280.500");
        j.put(13, "280.301");
        j.put(14, "280.302");
        j.put(15, "280.303");
        j.put(18, "250.000");
        j.put(19, "250.400");
        j.put(20, "280.000");
        j.put(21, "250.500");
        j.put(22, "290.500");
        k.put(1, "280.210");
        k.put(-2, "280.249");
        k.put(2, "280.220");
        k.put(3, "280.250");
        k.put(4, "280.241");
        k.put(5, "280.240");
        k.put(6, "280.242");
        k.put(7, "280.243");
        k.put(8, "280.260");
        k.put(9, "280.270");
        l.put(1, "280.261");
        l.put(2, "280.262");
        l.put(3, "280.263");
        l.put(4, "280.264");
        n.put(1, "212.000");
        n.put(2, "212.400");
        n.put(3, "212.401");
        n.put(4, "212.999");
        n.put(5, "214.000");
        n.put(6, "214.200");
        n.put(7, "216.200");
        n.put(8, "216.401");
    }

    public static String a(l lVar) {
        if (lVar instanceof i) {
            return (String) d.get(lVar.a());
        }
        if (lVar instanceof h) {
            return (String) e.get(lVar.a());
        }
        if (lVar instanceof k) {
            return (String) f.get(lVar.a());
        }
        if (lVar instanceof g) {
            return (String) g.get(lVar.a());
        }
        return lVar instanceof j ? (String) m.get(lVar.a()) : "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventBean c(String str) {
        EventBean eventBean = this.c;
        if (eventBean == null || str == null) {
            return null;
        }
        try {
            EventBean eventBeanM167clone = eventBean.m167clone();
            eventBeanM167clone.setEventCode(str);
            eventBeanM167clone.setEventTime(String.valueOf(System.currentTimeMillis()));
            return eventBeanM167clone;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public EventBean b(String str) {
        try {
            if (this.b.containsKey(str)) {
                EventBean eventBean = (EventBean) this.b.get(str);
                if (eventBean != null) {
                    EventBean eventBeanM167clone = eventBean.m167clone();
                    this.b.put(str, eventBeanM167clone);
                    return eventBeanM167clone;
                }
            } else {
                EventBean eventBean2 = this.c;
                if (eventBean2 != null) {
                    EventBean eventBeanM167clone2 = eventBean2.m167clone();
                    this.b.put(str, eventBeanM167clone2);
                    return eventBeanM167clone2;
                }
            }
        } catch (CloneNotSupportedException unused) {
        }
        EventBean eventBean3 = new EventBean(q1.u, "", "", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), "");
        this.b.put(str, eventBean3);
        return eventBean3;
    }

    public class l extends Observable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27739a = 0;
        private Map b = new HashMap();

        public l() {
        }

        public void a(int i) {
            if (this.f27739a != i) {
                this.f27739a = i;
                EventBean eventBeanC = s1.this.c(s1.a(this));
                setChanged();
                notifyObservers(eventBeanC);
            }
        }

        public int a() {
            return this.f27739a;
        }

        public void a(String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Map map = this.b;
            if (((map == null || !map.containsKey(str)) ? 0 : ((Integer) this.b.get(str)).intValue()) != i || i == 17) {
                this.b.put(str, Integer.valueOf(i));
                String strA = s1.a(str, this);
                jh.c("BeiZis", "changeStatus channel = " + str + ",eventCode = " + strA);
                EventBean eventBeanA = s1.this.a(str, strA);
                if ("290.300".equalsIgnoreCase(strA)) {
                    jh.c("BeiZis", "eventBean = " + eventBeanA);
                }
                setChanged();
                notifyObservers(eventBeanA);
            }
        }

        public int a(String str) {
            Map map;
            if (TextUtils.isEmpty(str) || (map = this.b) == null || !map.containsKey(str)) {
                return 0;
            }
            return ((Integer) this.b.get(str)).intValue();
        }
    }

    public static String a(String str, l lVar) {
        if (lVar instanceof d) {
            return (String) h.get(lVar.a(str));
        }
        if (lVar instanceof e) {
            return (String) i.get(lVar.a(str));
        }
        if (lVar instanceof f) {
            return (String) j.get(lVar.a(str));
        }
        if (lVar instanceof c) {
            return (String) k.get(lVar.a(str));
        }
        if (lVar instanceof b) {
            return (String) l.get(lVar.a(str));
        }
        return lVar instanceof a ? (String) n.get(lVar.a(str)) : "0";
    }

    public void a(EventBean eventBean) {
        this.c = eventBean;
    }

    public void a(String str, EventBean eventBean) {
        if (TextUtils.isEmpty(str) || eventBean == null) {
            return;
        }
        this.b.put(str, eventBean);
    }

    public void a(AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        Pair pair = new Pair(buyerBean, forwardBean);
        if (buyerBean == null || TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId())) {
            return;
        }
        this.f27738a.put(buyerBean.getBuyerSpaceUuId(), pair);
    }

    private Pair a(String str) {
        if (this.f27738a.containsKey(str)) {
            return (Pair) this.f27738a.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventBean a(String str, String str2) {
        Pair pairA = a(str);
        StringBuilder sb = new StringBuilder();
        sb.append("getChannelEventBean eventCode = ");
        sb.append(str2);
        sb.append(",channelData == null ");
        sb.append(pairA == null);
        jh.c("BeiZis", sb.toString());
        if (pairA != null) {
            AdSpacesBean.BuyerBean buyerBean = (AdSpacesBean.BuyerBean) pairA.first;
            AdSpacesBean.ForwardBean forwardBean = (AdSpacesBean.ForwardBean) pairA.second;
            EventBean eventBeanB = b(str);
            if (eventBeanB != null && buyerBean != null && forwardBean != null) {
                eventBeanB.setEventCode(str2);
                eventBeanB.setEventTime(String.valueOf(System.currentTimeMillis()));
                a(eventBeanB, str, buyerBean, forwardBean);
                this.b.put(str, eventBeanB);
            }
            return eventBeanB;
        }
        jh.b("BeiZis", "getChannelEventBean eventCode = " + str2 + ",but channelData is null !!!");
        return null;
    }

    private static void a(EventBean eventBean, String str, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        if (eventBean == null) {
            return;
        }
        eventBean.setBuyerId(String.valueOf(c2.c(buyerBean.getId())));
        eventBean.setBuyerAppId(buyerBean.getAppId());
        eventBean.setBuyerSpaceId(buyerBean.getSpaceId());
        eventBean.setChannelFilterSsid(buyerBean.getFilterSsid());
        eventBean.setRenderViewSsid(buyerBean.getRenderViewSsid());
        eventBean.setBeiZiPrice(String.valueOf(buyerBean.getAvgPrice()));
        eventBean.setBeiZiBaseId(c2.b(forwardBean.getBaseId()));
        if (!"BPDI".equalsIgnoreCase(buyerBean.getBidType()) && !"C2S".equalsIgnoreCase(buyerBean.getBidType()) && !"S2S".equalsIgnoreCase(buyerBean.getBidType())) {
            eventBean.setBeiZiSrcType(0);
        } else {
            eventBean.setBeiZiSrcType(1);
            if (buyerBean.getBidPrice() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                eventBean.setBidPrice(String.valueOf(buyerBean.getBidPrice()));
            } else {
                eventBean.setBidPrice("0");
            }
        }
        eventBean.setForwardId(forwardBean.getForwardId());
        eventBean.setParentId(forwardBean.getParentForwardId());
        eventBean.setLevel(forwardBean.getLevel());
        eventBean.setBuyerSpaceUuId(forwardBean.getBuyerSpaceUuId());
    }
}
