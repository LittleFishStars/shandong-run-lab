package com.bwt.top.ad.loader.ddksa;

import com.bwt.top.AdPlatforms;
import com.bwt.top.ad.adapter.AdapterAdLoader;
import com.bwt.top.api.bean.PosInfoBean;
import com.zj.adlib.ygb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ddksa<T extends ygb, Y extends AdapterAdLoader> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f28243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<PosInfoBean> f1471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<PosInfoBean, akdsd> f1472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1473a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1474b;

    public ddksa(String str, T t) {
        AdPlatforms.gdt.name();
        AdPlatforms.channel.name();
        AdPlatforms.bwt.name();
        this.b = str;
        this.f28243a = t;
        this.f1472a = new HashMap();
        this.f1470a = getClass().getSimpleName();
    }

    public abstract void a();

    public void b() {
        Map<PosInfoBean, akdsd> map = this.f1472a;
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator<PosInfoBean> it = this.f1472a.keySet().iterator();
        while (it.hasNext()) {
            this.f1472a.get(it.next()).c().onResumed();
        }
    }

    public boolean c() {
        return this.f1474b;
    }

    public abstract void d();

    public boolean dkkd() {
        return this.f1473a;
    }

    public void e() {
        this.f1474b = true;
        Map<PosInfoBean, akdsd> map = this.f1472a;
        if (map != null) {
            Iterator<PosInfoBean> it = map.keySet().iterator();
            while (it.hasNext()) {
                this.f1472a.get(it.next()).c().release();
            }
            this.f1472a.clear();
        }
        this.b = null;
        this.f28243a = null;
    }

    public List<PosInfoBean> f() {
        return this.f1471a;
    }

    public void g(List<PosInfoBean> list) {
        this.f1471a = list;
    }

    public void h(boolean z) {
        this.f1473a = z;
    }

    public void i() {
        Map<PosInfoBean, akdsd> map = this.f1472a;
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator<PosInfoBean> it = this.f1472a.keySet().iterator();
        while (it.hasNext()) {
            this.f1472a.get(it.next()).c().onPaused();
        }
    }
}
