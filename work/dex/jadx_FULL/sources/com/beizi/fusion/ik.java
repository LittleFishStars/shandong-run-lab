package com.beizi.fusion;

import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.s1.a;
import com.beizi.fusion.s1.b;
import com.beizi.fusion.s1.c;
import com.beizi.fusion.s1.d;
import com.beizi.fusion.s1.e;
import com.beizi.fusion.s1.f;
import com.beizi.fusion.s1.g;
import com.beizi.fusion.s1.h;
import com.beizi.fusion.s1.i;
import com.beizi.fusion.s1.j;
import com.beizi.fusion.s1.k;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ik implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s1 f27411a;
    public s1.i b;
    public s1.h c;
    public s1.k d;
    public s1.g e;
    public s1.d f;
    public s1.e g;
    public s1.f h;
    public s1.c i;
    public s1.b j;
    public s1.j k;
    public s1.a l;
    private EventBean m;
    private boolean n = false;

    public ik(EventBean eventBean) {
        this.m = eventBean;
        s1 s1Var = new s1();
        this.f27411a = s1Var;
        this.b = s1Var.new i();
        this.c = s1Var.new h();
        this.d = s1Var.new k();
        this.e = s1Var.new g();
        this.f = s1Var.new d();
        this.g = s1Var.new e();
        this.h = s1Var.new f();
        this.i = s1Var.new c();
        this.j = s1Var.new b();
        this.k = s1Var.new j();
        this.l = s1Var.new a();
    }

    public s1 a() {
        return this.f27411a;
    }

    public EventBean b() {
        return this.m;
    }

    public boolean c() {
        return this.n;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof s1.l) && (obj instanceof EventBean)) {
            EventBean eventBean = (EventBean) obj;
            jh.a("BeiZis", "channel == " + eventBean.getBuyerId() + ",eventCode = " + eventBean.getEventCode() + ";buyerSpaceId:" + eventBean.getBuyerSpaceUuId() + ",srcType = " + eventBean.getBeiZiSrcType() + ",price = " + eventBean.getBeiZiPrice() + ",bidPrice = " + eventBean.getBidPrice() + ",eventId = " + eventBean.getReqId() + ",buyerSpaceId = " + eventBean.getBuyerSpaceId());
            EventCar.getInstance(q1.h().m()).goRoad(eventBean);
        }
    }

    public void a(boolean z) {
        this.n = z;
    }
}
