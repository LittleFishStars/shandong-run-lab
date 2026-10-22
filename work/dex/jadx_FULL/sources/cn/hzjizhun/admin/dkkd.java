package cn.hzjizhun.admin;

import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.exception.JZAdError;
import com.zj.adlib.ghb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ghb f22715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f294a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f295b;
    public String e;
    public String b = AdPlatforms.gdt.name();
    public String c = AdPlatforms.channel.name();
    public String d = AdPlatforms.jz.name();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f293a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f291a = getClass().getSimpleName();

    public dkkd(String str, ghb ghbVar) {
        this.e = str;
        this.f22715a = ghbVar;
    }

    public abstract void a();

    public void b() {
        Map map = this.f293a;
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator it = this.f293a.keySet().iterator();
        while (it.hasNext()) {
            ((assa) this.f293a.get((PosInfoBean) it.next())).b().onResumed();
        }
    }

    public boolean c() {
        return this.f295b;
    }

    public abstract void d();

    public boolean dkkd() {
        return this.f294a;
    }

    public abstract void e();

    public void f() {
        this.f295b = true;
        Map map = this.f293a;
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                ((assa) this.f293a.get((PosInfoBean) it.next())).b().release();
            }
            this.f293a.clear();
        }
        this.e = null;
        this.f22715a = null;
    }

    public List g() {
        return this.f292a;
    }

    public void h(List list) {
        this.f292a = list;
    }

    public void i(boolean z) {
        this.f294a = z;
    }

    public void j() {
        Map map = this.f293a;
        if (map == null || map.size() <= 0) {
            return;
        }
        Iterator it = this.f293a.keySet().iterator();
        while (it.hasNext()) {
            ((assa) this.f293a.get((PosInfoBean) it.next())).b().onPaused();
        }
    }

    public void kdsksdda(String str) {
        JZAdError jZAdError = new JZAdError(10, str);
        jZAdError.log();
        this.f22715a.getAd().getAdListener().onAdFailed(jZAdError);
    }
}
