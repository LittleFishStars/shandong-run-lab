package com.byazt.ete;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.triver.basic.api.RequestPermission;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.zj.adlib.ha0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME})
public class ic implements com.byazt.eia.da, com.byazt.eia.i, com.byazt.eia.sl, com.byazt.eia.sp, com.byazt.eia.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28496a;
    public sv ab;
    public long an;
    public String az;
    public Map<String, Object> b;
    public int bj;
    public int bp;
    public int br;
    public String bw;
    public boolean bx;
    public hq c;
    public l ca;
    public String cf;
    public String cg;
    public lr ck;
    public to cl;
    public int cu;
    public int cx;
    public JSONObject d;
    public q dh;
    public int dn;
    public int dr;
    public hd ef;
    public String ej;
    public boolean em;
    public z en;
    public String eo;
    public md ey;
    public JSONObject f;
    public int fe;
    public r fk;
    public String fq;
    public p fr;
    public a ft;
    public int fv;
    public JSONObject g;
    public int ge;
    public pf gk;
    public String gl;
    public n gr;
    public String gt;
    public int gx;
    public int gy;
    public String h;
    public yp hc;
    public String hg;
    public int hj;
    public oz hs;
    public boolean hz;
    public String i;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public com.byazt.seg.c f1484if;
    public String ij;
    public JSONObject il;
    public long is;
    public int iw;
    public lo ix;
    public String j;
    public kk jc;
    public JSONObject jf;
    public int jl;
    public int jm;
    public String jt;
    public boolean jy;
    public JSONObject ka;
    public lt kk;
    public volatile String kn;
    public gt kp;
    public boolean ku;
    public String kz;
    public volatile String la;
    public h ls;
    public my lz;
    public String md;
    public String mf;
    public s mm;
    public boolean mq;
    public long my;
    public int n;
    public xd nb;
    public pu ne;
    public String nl;
    public boolean nq;
    public iu nx;
    public String o;
    public int op;
    public j oq;
    public long or;
    public int ox;
    public int p;
    public String pa;
    public String pb;
    public int pf;
    public int ph;
    public int pl;
    public int pr;
    public kp q;
    public int qp;
    public rh qt;
    public com.byazt.dj.tt r;
    public String ra;
    public String rh;
    public cu ri;
    public String rl;
    public yv rp;
    public int s;
    public volatile JSONObject sf;
    public String sl;
    public tx sp;
    public int st;
    public boolean sv;
    public boolean sy;
    public JSONObject t;
    public qp te;
    public sl tj;
    public boolean tk;
    public int tp;
    public qy ts;
    public String tt;
    public JSONObject u;
    public com.byazt.vo.tt uj;
    public String ul;
    public String up;
    public String uv;
    public bx v;
    public String ve;
    public String vi;
    public int vl;
    public long vp;
    public JSONObject vr;
    public boolean w;
    public or wq;
    public zb x;
    public boolean xg;
    public com.byazt.lo.c xl;
    public int xr;
    public zm xv;
    public JSONObject xw;
    public int xx;
    public int y;
    public JSONObject ym;
    public String ys;
    public int yt;
    public nu yv;
    public String z;
    public long zb;
    public rl zm;
    public int da = -1;
    public List<zb> yp = new ArrayList();
    public List<String> m = new ArrayList();
    public List<String> nu = new ArrayList();
    public String qy = "0";
    public String gu = "0";
    public int aw = 100;
    public long ic = -1;
    public long hd = -1;
    public long bm = -1;
    public int lr = -1;
    public int l = 1;
    public long lo = System.currentTimeMillis();
    public String pu = UUID.randomUUID().toString();
    public int lt = 1;
    public String to = "";
    public boolean tx = false;
    public int os = IOfflineCompo.Priority.HIGHEST;
    public int oz = 0;
    public int iu = 1;
    public int dz = 0;
    public int ma = 0;
    public int yf = 0;
    public int ir = 1;
    public int xd = 0;
    public int hq = 0;
    public int ny = 0;
    public int nt = 0;
    public int pn = 1;
    public boolean yo = false;
    public int di = 1;
    public float jg = 100.0f;
    public int sd = 0;
    public int k = 2;
    public int iy = 0;
    public int nc = 100;
    public int e = 2;
    public int pe = 2;
    public float ly = 0.07f;
    public float px = 0.0f;
    public long ru = 0;
    public boolean nm = true;
    public int id = -1;
    public int tu = 0;
    public int fb = 0;
    public long mk = 0;
    public int by = 0;
    public List<eo> cs = new ArrayList();
    public int po = -1;
    public int mc = 1;
    public int qe = -1001;
    public int yg = 0;

    private float hm() {
        s sVar = this.mm;
        if (sVar == null) {
            return 5.0f;
        }
        return sVar.z();
    }

    private int vz() {
        return this.aw;
    }

    @Override // com.byazt.eia.da
    public hq A_() {
        return this.c;
    }

    @Override // com.byazt.eia.sp
    public boolean B_() {
        return this.sy;
    }

    @Override // com.byazt.eia.i
    public q C_() {
        return this.dh;
    }

    @Override // com.byazt.eia.i
    public kk D_() {
        return this.jc;
    }

    public void a(int i) {
        if (this.xx == 0) {
            this.xx = i;
        }
    }

    public int ab() {
        int i = this.lr;
        if (i != -1) {
            return i;
        }
        if (com.byazt.aas.nb.sl(this) == 7) {
            return 0;
        }
        return (com.byazt.aas.nb.sl(this) == 8 && fr() == 100.0f) ? 0 : 1;
    }

    public String an() {
        return this.md;
    }

    public String aw() {
        return this.pb;
    }

    public int az() {
        return this.s;
    }

    public long b() {
        return this.vp;
    }

    public s.c bj() {
        s sVar = this.mm;
        if (sVar != null) {
            return sVar.yp();
        }
        return null;
    }

    public boolean bm() {
        return this.nq;
    }

    public hd bn() {
        if (this.ef == null) {
            this.ef = new hd(this);
        }
        return this.ef;
    }

    public int bp() {
        iu iuVar = this.nx;
        if (iuVar == null) {
            return 2;
        }
        return iuVar.c();
    }

    public int br() {
        return this.bj;
    }

    public boolean bw() {
        return this.tk;
    }

    public int bx() {
        return this.ox;
    }

    public int by() {
        if (this.di != 2) {
            this.di = 1;
        }
        return this.di;
    }

    public boolean bz() {
        return this.tx;
    }

    public String c() {
        return this.kn;
    }

    public String ca() {
        s sVar = this.mm;
        return sVar == null ? "#008DEA" : sVar.da();
    }

    public int cf() {
        if (fr() != 100.0f || pu.c(this) == 2) {
            return 0;
        }
        return this.oz;
    }

    public iu cg() {
        return this.nx;
    }

    public int cj() {
        return this.tu;
    }

    public String ck() {
        return this.gl;
    }

    public String cl() {
        s sVar = this.mm;
        return sVar == null ? "点击查看" : sVar.sl();
    }

    public int cs() {
        return this.nc;
    }

    public int cu() {
        return this.ge;
    }

    public JSONObject cx() {
        return this.il;
    }

    public JSONObject cy() {
        return this.jf;
    }

    public boolean d() {
        return this.jy && pf();
    }

    public void da(int i) {
        this.xr = i;
    }

    public boolean dh() {
        return this.l == 1;
    }

    public String di() {
        s sVar = this.mm;
        return sVar == null ? "" : sVar.tt();
    }

    public String dn() {
        if (!TextUtils.isEmpty(this.hg)) {
            this.hg = this.hg.trim();
        }
        return this.hg;
    }

    public cu dp() {
        return this.ri;
    }

    public int dr() {
        iu iuVar = this.nx;
        if (iuVar == null) {
            return 30;
        }
        return iuVar.ve();
    }

    public long dz() {
        return this.is;
    }

    public int e() {
        return this.ph;
    }

    public l ef() {
        return this.ca;
    }

    public int ej() {
        return this.pn;
    }

    public j ek() {
        return this.oq;
    }

    public String em() {
        return this.ej;
    }

    public int en() {
        return this.pr;
    }

    public int eo() {
        return this.xx;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ic icVar = (ic) obj;
            if (this.qy.equals(icVar.qy) && this.h.equals(icVar.h)) {
                return true;
            }
        }
        return false;
    }

    public long ey() {
        return this.ru;
    }

    public int f() {
        return this.e;
    }

    public qp fb() {
        return this.te;
    }

    public boolean fe() {
        if (wq() != null) {
            return wq().a();
        }
        return false;
    }

    public int fk() {
        r rVar = this.fk;
        if (rVar == null) {
            return 90;
        }
        return rVar.ve();
    }

    public int fq() {
        return this.lt;
    }

    public float fr() {
        if (this.jg <= 0.0f) {
            this.jg = 100.0f;
        }
        return (this.jg * 1000.0f) / 1000.0f;
    }

    public JSONObject ft() {
        return this.u;
    }

    public String fv() {
        return this.pa;
    }

    public int g() {
        return this.nt;
    }

    public int ge() {
        return this.iw;
    }

    public int gk() {
        s sVar = this.mm;
        if (sVar == null) {
            return 0;
        }
        return sVar.x();
    }

    public List<String> gl() {
        return this.nu;
    }

    public void gr(int i) {
        this.y = i;
    }

    public void gt(int i) {
        this.ma = i;
    }

    public void gu(int i) {
        this.s = i;
    }

    public lo gx() {
        return this.ix;
    }

    public pu gy() {
        return this.ne;
    }

    public int h() {
        return this.yg;
    }

    public int hashCode() {
        return (this.qy.hashCode() * 31) + this.h.hashCode();
    }

    public int hc() {
        return this.pf;
    }

    public boolean hd() {
        return this.em;
    }

    public int hg() {
        s sVar = this.mm;
        if (sVar == null) {
            return 50;
        }
        return sVar.uj();
    }

    public int hj() {
        return this.ny;
    }

    public String hl() {
        return this.cg;
    }

    public or hq() {
        return this.wq;
    }

    public boolean hs() {
        boolean z = ix() != null && ix().c();
        if (z && ne() == 4) {
            return lz() >= 0;
        }
        return z;
    }

    public int hz() {
        return this.sd;
    }

    public rh ic() {
        return this.qt;
    }

    public int id() {
        return this.p;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public int m172if() {
        return this.cx;
    }

    public com.byazt.dj.tt ij() {
        return this.r;
    }

    public int il() {
        return this.gx;
    }

    public int ir() {
        return this.qp;
    }

    public int is() {
        return this.y;
    }

    public boolean iu() {
        return this.w;
    }

    public s.tt iw() {
        s sVar = this.mm;
        if (sVar != null) {
            return sVar.u();
        }
        return null;
    }

    public tx ix() {
        return this.sp;
    }

    public int iy() {
        s sVar = this.mm;
        if (sVar == null) {
            return 56;
        }
        return sVar.sp();
    }

    public String j() {
        return this.az;
    }

    public to jc() {
        return this.cl;
    }

    public int jf() {
        return this.xd;
    }

    public boolean jg() {
        s sVar = this.mm;
        return sVar == null || sVar.ve();
    }

    public String jl() {
        return TextUtils.isEmpty(this.ve) ? com.byazt.vxy.c.ve() : this.ve;
    }

    public JSONObject jm() {
        return this.f;
    }

    public bx js() {
        return this.v;
    }

    public int jt() {
        return this.os;
    }

    public float jy() {
        float f = this.px;
        if (f < 0.0f || f > 50.0f) {
            this.px = 0.0f;
        }
        return this.px;
    }

    public int k() {
        s sVar = this.mm;
        if (sVar == null) {
            return 82;
        }
        return sVar.a();
    }

    public int ka() {
        return my.da(this);
    }

    public long kk() {
        return this.an;
    }

    public yv kn() {
        return this.rp;
    }

    public JSONObject kp() {
        return this.sf;
    }

    public int ku() {
        return this.pl;
    }

    public int kz() {
        return this.id;
    }

    public String l() {
        return this.fq;
    }

    public JSONObject la() {
        return this.xw;
    }

    public String lo() {
        return this.ul;
    }

    public boolean lr() {
        return this.ku;
    }

    public String ls() {
        return this.tt;
    }

    public String lt() {
        return this.ys;
    }

    public JSONObject lv() {
        return this.ym;
    }

    public String lw() {
        return hashCode() + qy() + kk();
    }

    public boolean lx() {
        return this.yo;
    }

    public int ly() {
        r rVar = this.fk;
        if (rVar == null) {
            return 0;
        }
        return rVar.c();
    }

    public int lz() {
        if (ix() != null) {
            return ix().tt();
        }
        return -1;
    }

    public void m(int i) {
        this.dz = i;
    }

    public int ma() {
        return this.op;
    }

    public int mc() {
        JSONObject jSONObject = this.t;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public int md() {
        return this.dn;
    }

    public s mf() {
        return this.mm;
    }

    public String mk() {
        return this.nl;
    }

    public int mm() {
        return this.yt;
    }

    public sl mn() {
        return this.tj;
    }

    public int mq() {
        return this.iu;
    }

    public int mu() {
        return this.qe;
    }

    public void my(int i) {
        this.id = i;
    }

    public void n(int i) {
        this.fe = i;
    }

    public int nb() {
        return this.br;
    }

    public int nc() {
        s sVar = this.mm;
        if (sVar == null) {
            return 0;
        }
        return sVar.i();
    }

    public int ne() {
        return this.f28496a;
    }

    public int nl() {
        return this.hj;
    }

    public rl nm() {
        return this.zm;
    }

    public boolean nq() {
        return ku() != 1;
    }

    public boolean nt() {
        return this.dz == 1;
    }

    public void nu(int i) {
        this.yt = i;
    }

    public s.tt nx() {
        s sVar = this.mm;
        if (sVar != null) {
            return sVar.t();
        }
        return null;
    }

    public int ny() {
        return this.dz;
    }

    public xd o() {
        return this.nb;
    }

    public String op() {
        return this.gt;
    }

    public int oq() {
        return this.l;
    }

    public boolean or() {
        return zb() == 1;
    }

    public com.byazt.lo.c os() {
        return this.xl;
    }

    public boolean ox() {
        int iNu = com.byazt.aas.nb.nu(this);
        return iNu == 3 || iNu == 6;
    }

    public String oz() {
        return this.vi;
    }

    public int p() {
        return this.po;
    }

    public List<zb> pa() {
        return this.yp;
    }

    public int pb() {
        return this.gy;
    }

    public int pe() {
        return this.dr;
    }

    public boolean pf() {
        return nb() == 1;
    }

    public int ph() {
        iu iuVar = this.nx;
        if (iuVar == null) {
            return 16;
        }
        return iuVar.tt();
    }

    public int pl() {
        s sVar = this.mm;
        if (sVar == null) {
            return 1;
        }
        return sVar.c();
    }

    public my pn() {
        return this.lz;
    }

    public zm po() {
        return this.xv;
    }

    public List<String> pr() {
        return this.m;
    }

    public int pu() {
        return this.xr;
    }

    public int px() {
        r rVar = this.fk;
        if (rVar == null) {
            return 90;
        }
        return rVar.tt();
    }

    public String q() {
        return this.kz;
    }

    @Override // com.byazt.eia.i
    public JSONObject q_() {
        if (this.d == null) {
            try {
                if (!TextUtils.isEmpty(this.h)) {
                    this.d = new JSONObject(this.h);
                }
            } catch (JSONException unused) {
            }
        }
        return this.d;
    }

    public float qe() {
        float f = this.ly;
        if (f < 0.07f || f > 0.175f) {
            this.ly = 0.07f;
        }
        return this.ly;
    }

    public z qi() {
        return this.en;
    }

    public boolean qp() {
        return this.ge == 1;
    }

    public boolean qt() {
        if (com.byazt.ex.c.c(this)) {
            return true;
        }
        if (this.yp.isEmpty()) {
            return false;
        }
        if (this.p == 4 && this.yp.size() < 3) {
            return false;
        }
        Iterator<zb> it = this.yp.iterator();
        while (it.hasNext()) {
            if (!it.next().n()) {
                return false;
            }
        }
        return true;
    }

    public void qy(int i) {
        this.oz = i;
    }

    public boolean r() {
        return this.mq;
    }

    public long ra() {
        return this.bm;
    }

    public void rh(int i) {
        this.yf = i;
    }

    public int ri() {
        return this.da;
    }

    public void rl(int i) {
        this.iu = i;
    }

    public int rm() {
        return this.mc;
    }

    public boolean rp() {
        return (TextUtils.isEmpty(com.byazt.aas.nb.u(this)) || TextUtils.isEmpty(this.to) || com.byazt.aas.nb.u(this).contains(this.to)) ? false : true;
    }

    public long ru() {
        return this.my;
    }

    public String s() {
        return this.cf;
    }

    @Override // com.byazt.eia.sl
    public boolean s_() {
        return this.hz;
    }

    public int sd() {
        s sVar = this.mm;
        if (sVar == null) {
            return 236;
        }
        return sVar.n();
    }

    public String sf() {
        return this.pu;
    }

    public void sl(int i) {
        this.vl = i;
    }

    @Override // com.byazt.eia.x
    public int sp() {
        return this.jl;
    }

    public int st() {
        return this.tp;
    }

    public boolean sv() {
        return bx() == 1;
    }

    public String sy() {
        try {
            return q_().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void t(String str) {
        this.az = str;
    }

    @Override // com.byazt.eia.i
    public String t_() {
        return this.bw;
    }

    public zb te() {
        return this.x;
    }

    public String tj() {
        return this.rl;
    }

    public boolean tk() {
        return this.xg;
    }

    public String to() {
        return this.up;
    }

    public String tp() {
        return this.z;
    }

    public JSONObject ts() {
        return this.t;
    }

    public eo tt(String str) {
        List<eo> list = this.cs;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.cs.size(); i++) {
                eo eoVar = this.cs.get(i);
                if (eoVar != null) {
                    String strC = eoVar.c();
                    if (!TextUtils.isEmpty(strC) && strC.equals(str)) {
                        return eoVar;
                    }
                }
            }
        }
        return null;
    }

    public long tu() {
        return this.hd;
    }

    public int tw() {
        if (this.n == 4 && TextUtils.isEmpty(this.j)) {
            return this.bp;
        }
        return 0;
    }

    public int tx() {
        if (my.uj(this)) {
            return 0;
        }
        return this.vl;
    }

    public void u(String str) {
        this.ij = str;
    }

    @Override // com.byazt.eia.sp
    public gt u_() {
        return this.kp;
    }

    public void uj(int i) {
        this.jl = i;
    }

    public long ul() {
        return this.or;
    }

    public boolean up() {
        return this.sv;
    }

    public JSONObject ur() {
        return this.ka;
    }

    public long uv() {
        return this.zb;
    }

    public com.byazt.seg.c v() {
        return this.f1484if;
    }

    @Override // com.byazt.eia.x
    public String v_() {
        return this.rh;
    }

    public void ve(int i) {
        this.yg = i;
    }

    public int vi() {
        return this.ma;
    }

    public r vl() {
        return this.fk;
    }

    public int vp() {
        return this.yf;
    }

    public int vr() {
        return this.hq;
    }

    public p vt() {
        return this.fr;
    }

    public int w() {
        return this.ir;
    }

    @Override // com.byazt.eia.da
    public String w_() {
        return this.h;
    }

    public boolean wj() {
        return this.nm;
    }

    public int wn() {
        return this.k;
    }

    public String wo() {
        return this.ra;
    }

    public com.byazt.vo.tt wq() {
        com.byazt.tl.tt.c();
        return this.uj;
    }

    public lr wy() {
        return this.ck;
    }

    @Override // com.byazt.eia.sp
    public boolean x_() {
        return jf() == 1;
    }

    public kp xd() {
        return this.q;
    }

    public long xg() {
        return this.lo;
    }

    public int xl() {
        return this.fv;
    }

    public lt xo() {
        return this.kk;
    }

    public int xr() {
        return this.cu;
    }

    public String xv() {
        return this.to;
    }

    public long xw() {
        return this.ic;
    }

    public int xx() {
        return this.iy;
    }

    public String y() {
        return this.jt;
    }

    @Override // com.byazt.eia.i
    public boolean y_() {
        return jc() != null;
    }

    public int yf() {
        return this.pe;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x04c6 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:102:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:105:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:106:0x04fe A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:109:0x050b  */
    /* JADX WARN: Code duplicated, block: B:110:0x050d A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:113:0x054d A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:120:0x056c A[Catch: Exception -> 0x088d, LOOP:5: B:118:0x0566->B:120:0x056c, LOOP_END, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:124:0x05b4 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:127:0x05e6 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0655 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0676 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:136:0x06ed A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0718 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:143:0x073c  */
    /* JADX WARN: Code duplicated, block: B:144:0x073e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0835 A[Catch: Exception -> 0x0892, TryCatch #6 {Exception -> 0x0892, blocks: (B:145:0x073f, B:147:0x0835, B:148:0x083e, B:150:0x0842, B:151:0x0847, B:153:0x084d, B:154:0x0874, B:156:0x0883), top: B:283:0x073f }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0842 A[Catch: Exception -> 0x0892, TryCatch #6 {Exception -> 0x0892, blocks: (B:145:0x073f, B:147:0x0835, B:148:0x083e, B:150:0x0842, B:151:0x0847, B:153:0x084d, B:154:0x0874, B:156:0x0883), top: B:283:0x073f }] */
    /* JADX WARN: Code duplicated, block: B:153:0x084d A[Catch: Exception -> 0x0892, TryCatch #6 {Exception -> 0x0892, blocks: (B:145:0x073f, B:147:0x0835, B:148:0x083e, B:150:0x0842, B:151:0x0847, B:153:0x084d, B:154:0x0874, B:156:0x0883), top: B:283:0x073f }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0883 A[Catch: Exception -> 0x0892, TRY_LEAVE, TryCatch #6 {Exception -> 0x0892, blocks: (B:145:0x073f, B:147:0x0835, B:148:0x083e, B:150:0x0842, B:151:0x0847, B:153:0x084d, B:154:0x0874, B:156:0x0883), top: B:283:0x073f }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0898  */
    /* JADX WARN: Code duplicated, block: B:166:0x08a7  */
    /* JADX WARN: Code duplicated, block: B:167:0x08a8  */
    /* JADX WARN: Code duplicated, block: B:178:0x08e9  */
    /* JADX WARN: Code duplicated, block: B:181:0x08f2  */
    /* JADX WARN: Code duplicated, block: B:216:0x0a1c A[Catch: JSONException -> 0x0a2b, TRY_LEAVE, TryCatch #21 {JSONException -> 0x0a2b, blocks: (B:214:0x0a09, B:216:0x0a1c), top: B:313:0x0a09 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x0a53 A[Catch: all -> 0x0a56, TRY_LEAVE, TryCatch #15 {all -> 0x0a56, blocks: (B:224:0x0a4f, B:226:0x0a53), top: B:301:0x0a4f }] */
    /* JADX WARN: Code duplicated, block: B:229:0x0a5a A[Catch: all -> 0x0a5d, TRY_LEAVE, TryCatch #22 {all -> 0x0a5d, blocks: (B:227:0x0a56, B:229:0x0a5a), top: B:315:0x0a56 }] */
    /* JADX WARN: Code duplicated, block: B:234:0x0a7c A[Catch: JSONException -> 0x0b20, TryCatch #9 {JSONException -> 0x0b20, blocks: (B:232:0x0a63, B:234:0x0a7c, B:235:0x0a80, B:237:0x0a86, B:239:0x0a8e, B:242:0x0ab3, B:244:0x0abe, B:245:0x0ac2, B:247:0x0ac8, B:249:0x0ad0, B:250:0x0afd), top: B:289:0x0a63 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0a86 A[Catch: JSONException -> 0x0b20, TryCatch #9 {JSONException -> 0x0b20, blocks: (B:232:0x0a63, B:234:0x0a7c, B:235:0x0a80, B:237:0x0a86, B:239:0x0a8e, B:242:0x0ab3, B:244:0x0abe, B:245:0x0ac2, B:247:0x0ac8, B:249:0x0ad0, B:250:0x0afd), top: B:289:0x0a63 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x0a8e A[Catch: JSONException -> 0x0b20, TryCatch #9 {JSONException -> 0x0b20, blocks: (B:232:0x0a63, B:234:0x0a7c, B:235:0x0a80, B:237:0x0a86, B:239:0x0a8e, B:242:0x0ab3, B:244:0x0abe, B:245:0x0ac2, B:247:0x0ac8, B:249:0x0ad0, B:250:0x0afd), top: B:289:0x0a63 }] */
    /* JADX WARN: Code duplicated, block: B:240:0x0aae  */
    /* JADX WARN: Code duplicated, block: B:244:0x0abe A[Catch: JSONException -> 0x0b20, TryCatch #9 {JSONException -> 0x0b20, blocks: (B:232:0x0a63, B:234:0x0a7c, B:235:0x0a80, B:237:0x0a86, B:239:0x0a8e, B:242:0x0ab3, B:244:0x0abe, B:245:0x0ac2, B:247:0x0ac8, B:249:0x0ad0, B:250:0x0afd), top: B:289:0x0a63 }] */
    /* JADX WARN: Code duplicated, block: B:247:0x0ac8 A[Catch: JSONException -> 0x0b20, TryCatch #9 {JSONException -> 0x0b20, blocks: (B:232:0x0a63, B:234:0x0a7c, B:235:0x0a80, B:237:0x0a86, B:239:0x0a8e, B:242:0x0ab3, B:244:0x0abe, B:245:0x0ac2, B:247:0x0ac8, B:249:0x0ad0, B:250:0x0afd), top: B:289:0x0a63 }] */
    /* JADX WARN: Code duplicated, block: B:279:0x09be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x01b6 A[Catch: Exception -> 0x088b, TryCatch #3 {Exception -> 0x088b, blocks: (B:23:0x0196, B:24:0x01ab, B:25:0x01b0, B:27:0x01b6, B:28:0x01bf, B:30:0x01c5, B:31:0x01cf, B:32:0x01d4, B:34:0x01da, B:35:0x01e3, B:37:0x01e9, B:38:0x01f3, B:39:0x01f8, B:42:0x02a7), top: B:277:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:289:0x0a63 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x09df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x098e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:0x08fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x09d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x09af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x09a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x0941 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x01c5 A[Catch: Exception -> 0x088b, LOOP:3: B:28:0x01bf->B:30:0x01c5, LOOP_END, TryCatch #3 {Exception -> 0x088b, blocks: (B:23:0x0196, B:24:0x01ab, B:25:0x01b0, B:27:0x01b6, B:28:0x01bf, B:30:0x01c5, B:31:0x01cf, B:32:0x01d4, B:34:0x01da, B:35:0x01e3, B:37:0x01e9, B:38:0x01f3, B:39:0x01f8, B:42:0x02a7), top: B:277:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:324:0x0ad0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:326:0x0ac2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x01da A[Catch: Exception -> 0x088b, TryCatch #3 {Exception -> 0x088b, blocks: (B:23:0x0196, B:24:0x01ab, B:25:0x01b0, B:27:0x01b6, B:28:0x01bf, B:30:0x01c5, B:31:0x01cf, B:32:0x01d4, B:34:0x01da, B:35:0x01e3, B:37:0x01e9, B:38:0x01f3, B:39:0x01f8, B:42:0x02a7), top: B:277:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x01e9 A[Catch: Exception -> 0x088b, LOOP:4: B:35:0x01e3->B:37:0x01e9, LOOP_END, TryCatch #3 {Exception -> 0x088b, blocks: (B:23:0x0196, B:24:0x01ab, B:25:0x01b0, B:27:0x01b6, B:28:0x01bf, B:30:0x01c5, B:31:0x01cf, B:32:0x01d4, B:34:0x01da, B:35:0x01e3, B:37:0x01e9, B:38:0x01f3, B:39:0x01f8, B:42:0x02a7), top: B:277:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x02a7 A[Catch: Exception -> 0x088b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x088b, blocks: (B:23:0x0196, B:24:0x01ab, B:25:0x01b0, B:27:0x01b6, B:28:0x01bf, B:30:0x01c5, B:31:0x01cf, B:32:0x01d4, B:34:0x01da, B:35:0x01e3, B:37:0x01e9, B:38:0x01f3, B:39:0x01f8, B:42:0x02a7), top: B:277:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:48:0x02f3 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0302 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:54:0x030f A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:57:0x031c A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0329 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0336 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0343 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0350 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:72:0x035d A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:75:0x036a A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0377 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0384 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0391 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0405 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0412 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0492 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:94:0x049b  */
    /* JADX WARN: Code duplicated, block: B:97:0x04a7 A[Catch: Exception -> 0x088d, TryCatch #1 {Exception -> 0x088d, blocks: (B:44:0x02cc, B:46:0x02ed, B:48:0x02f3, B:49:0x02fc, B:51:0x0302, B:52:0x0309, B:54:0x030f, B:55:0x0316, B:57:0x031c, B:58:0x0323, B:60:0x0329, B:61:0x0330, B:63:0x0336, B:64:0x033d, B:66:0x0343, B:67:0x034a, B:69:0x0350, B:70:0x0357, B:72:0x035d, B:73:0x0364, B:75:0x036a, B:76:0x0371, B:78:0x0377, B:79:0x037e, B:81:0x0384, B:82:0x038b, B:84:0x0391, B:85:0x0398, B:87:0x0405, B:88:0x040c, B:90:0x0412, B:91:0x0419, B:93:0x0492, B:95:0x049c, B:97:0x04a7, B:99:0x04b1, B:101:0x04c6, B:103:0x04d0, B:107:0x0502, B:111:0x0511, B:113:0x054d, B:115:0x055c, B:117:0x0562, B:118:0x0566, B:120:0x056c, B:121:0x0580, B:122:0x0585, B:124:0x05b4, B:125:0x05e0, B:127:0x05e6, B:128:0x061b, B:130:0x0655, B:131:0x065e, B:133:0x0676, B:134:0x06e7, B:136:0x06ed, B:137:0x0712, B:139:0x0718, B:140:0x0721, B:110:0x050d, B:106:0x04fe), top: B:273:0x02cc }] */
    /* JADX WARN: Code duplicated, block: B:98:0x04b0  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject yg() {
        String str;
        int i;
        cu cuVarDp;
        qy qyVarU;
        pf pfVarGt;
        z zVarQi;
        yp ypVarMy;
        sv svVarSl;
        q qVarC_;
        kk kkVarD_;
        Object objCx;
        j jVarEk;
        rh rhVarIc;
        JSONArray jSONArray;
        List<zb> listC;
        JSONArray jSONArray2;
        List<com.byazt.jzl.uj> listTt;
        String str2;
        or orVar;
        h hVar;
        String strWo;
        List<String> listPr;
        List<String> listGl;
        n nVarZ;
        rl rlVarNm;
        JSONObject jSONObjectC;
        JSONObject jSONObjectC2;
        JSONObject jSONObjectN;
        iu iuVar;
        int iUj;
        iu iuVar2;
        int iN;
        com.byazt.seg.c cVarV;
        com.byazt.lo.c cVarOs;
        a aVarRh;
        zm zmVarPo;
        int i2;
        hq hqVar;
        Object obj;
        sl slVarMn;
        JSONObject jSONObject;
        Set<Map.Entry<String, Object>> setEntrySet;
        JSONArray jSONArray3;
        Iterator<String> it;
        JSONArray jSONArray4;
        Iterator<String> it2;
        JSONObject jSONObject2 = new JSONObject();
        int i3 = 1;
        try {
            jSONObject2.put("s_sig_ts", ck());
            jSONObject2.put("ad_rec_stamp", ey());
            jSONObject2.put("interaction_type", i());
            jSONObject2.put(ha0.c, x());
            jSONObject2.put("use_sdk_player", hj());
            jSONObject2.put("use_media_video_player", g());
            jSONObject2.put("landing_scroll_percentage", ri());
            jSONObject2.put("gecko_id", ve());
            jSONObject2.put("extension", ts());
            jSONObject2.put("overlay", ft());
            jSONObject2.put(MediationConstant.EXTRA_ADID, uj());
            jSONObject2.put("source", an());
            jSONObject2.put("package_name", ls());
            jSONObject2.put("screenshot", ys());
            jSONObject2.put("play_bar_style", cf());
            jSONObject2.put("play_bar_show_time", jt());
            jSONObject2.put("if_block_lp", ny());
            jSONObject2.put("cache_sort", w());
            jSONObject2.put("if_sp_cache", nl());
            jSONObject2.put("splash_timeout_stage", ej());
            jSONObject2.put("is_cache", up());
            jSONObject2.put("cache_type", vz());
            com.byazt.dbo.ve.c(this, jSONObject2, true);
            jSONObject2.putOpt("applist_info", ur());
            jSONObject2.put("meta_hashcode", eo());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cta", f());
            jSONObject3.put("other", yf());
            jSONObject2.put("set_click_type", jSONObject3);
            zb zbVarTe = te();
            if (zbVarTe != null && !TextUtils.isEmpty(zbVarTe.c())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", zbVarTe.c());
                jSONObject4.put("height", zbVarTe.ve());
                jSONObject4.put("width", zbVarTe.tt());
                jSONObject2.put(RemoteMessageConst.Notification.ICON, jSONObject4);
            }
            Object objJm = jm();
            if (objJm != null) {
                jSONObject2.put("session_params", objJm);
            }
            Object objYm = ym();
            if (objYm != null) {
                jSONObject2.put("cache_control", objYm);
            }
            com.byazt.dj.tt ttVarIj = ij();
            if (ttVarIj != null) {
                jSONObject2.put("adslot", com.byazt.aas.md.c(ttVarIj));
            }
            List<zb> listPa = pa();
            if (listPa != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (zb zbVar : listPa) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", zbVar.c());
                    jSONObject5.put("height", zbVar.ve());
                    jSONObject5.put("width", zbVar.tt());
                    try {
                        jSONObject5.put("image_preview", zbVar.a());
                        jSONObject5.put("image_key", zbVar.sp());
                        jSONArray5.put(jSONObject5);
                        i3 = 1;
                    } catch (Exception unused) {
                        str = "height";
                        i = 1;
                        if (js() != null) {
                            js().c(jSONObject2);
                        }
                        if (bz()) {
                            i = 0;
                        }
                        jSONObject2.put("is_ec_mall", i);
                        jSONObject2.put("live_room_id", da());
                        jSONObject2.put("ad_type", xl());
                        jSONObject2.put("live_interaction_type", n());
                        jSONObject2.put("ec_schema", t_());
                        jSONObject2.put("ecom_live_params", t());
                        cuVarDp = dp();
                        if (cuVarDp != null) {
                            cuVarDp.c(jSONObject2);
                        }
                        qyVarU = u();
                        if (qyVarU != null) {
                            qyVarU.c(jSONObject2);
                        }
                        pfVarGt = gt();
                        if (pfVarGt != null) {
                            try {
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("reward_live_deep_link_user_id", pfVarGt.c());
                                jSONObject6.put("reward_live_deep_link_request_id", pfVarGt.a());
                                jSONObject6.put("reward_live_deep_link_room_id", pfVarGt.tt());
                                jSONObject6.put("reward_live_last_time", pfVarGt.n());
                                jSONObject6.put("reawrd_live_short_touch_params", pfVarGt.ve());
                                jSONObject6.put("reawrd_live_extra_pangle_scheme_params", pfVarGt.uj());
                                jSONObject2.put("reward_live_deep_link_params", jSONObject6);
                            } catch (Exception unused2) {
                            }
                        }
                        zVarQi = qi();
                        if (zVarQi != null) {
                            try {
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("style_type", zVarQi.c());
                                jSONObject7.put("image_url", zVarQi.tt());
                                jSONObject7.put("position", zVarQi.ve());
                                jSONObject7.put("image_height", zVarQi.uj());
                                jSONObject7.put("image_scale_rate", zVarQi.a());
                                jSONObject7.put("image_gif_url", zVarQi.n());
                                jSONObject7.put("image_gif_aspect_ratio", zVarQi.sp());
                                jSONObject2.put("dynamic_join_coupon_style", jSONObject7);
                            } catch (Exception unused3) {
                            }
                        }
                        ypVarMy = my();
                        if (ypVarMy != null) {
                            try {
                                jSONObject2.put("coupon", ypVarMy.c());
                            } catch (JSONException e) {
                                com.byazt.nr.m.c(e);
                            }
                        }
                        svVarSl = sl();
                        if (svVarSl != null) {
                            try {
                                jSONObject2.put("live_info", svVarSl.c());
                            } catch (JSONException unused4) {
                            }
                        }
                        qVarC_ = C_();
                        if (qVarC_ != null) {
                            try {
                                jSONObject2.put("saas_info", qVarC_.c());
                            } catch (JSONException unused5) {
                            }
                        }
                        kkVarD_ = D_();
                        if (kkVarD_ != null) {
                            try {
                                jSONObject2.put("saas_on_click_material", kkVarD_.c());
                            } catch (JSONException unused6) {
                            }
                        }
                        jSONObject2.put("live_sdk_status_while_first_click", this.qe);
                        objCx = cx();
                        if (objCx != null) {
                            try {
                                jSONObject2.put("group_info", objCx);
                            } catch (Exception unused7) {
                            }
                        }
                        jVarEk = ek();
                        if (jVarEk != null) {
                            try {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("video_adapter_type", jVarEk.c());
                                jSONObject8.put("video_mute_type", jVarEk.tt());
                                jSONObject2.put("video_config", jSONObject8);
                            } catch (Exception unused8) {
                            }
                        }
                        jSONObject2.put("not_valid_download_url", B_());
                        jSONObject2.put("dynamic_configs", m());
                        strWo = wo();
                        if (!TextUtils.isEmpty(strWo)) {
                            jSONObject2.put("gnd_prefetch_cache_key", strWo);
                            jSONObject2.put("gnd_prefetch_timing", cj());
                        }
                        jSONObject2.put("twist_config", lv());
                        jSONObject2.put("shake_interact_conf", cy());
                        jSONObject2.put("twist_interact_conf", yx());
                        hVar = this.ls;
                        if (hVar != null) {
                            hVar.tt(jSONObject2);
                        }
                        orVar = this.wq;
                        if (orVar != null) {
                            orVar.tt(jSONObject2);
                        }
                        rhVarIc = ic();
                        if (rhVarIc != null) {
                            try {
                                JSONObject jSONObject9 = new JSONObject();
                                jSONObject9.put("lottie_tmp_url", rhVarIc.ve());
                                jSONArray = new JSONArray();
                                listC = rhVarIc.c();
                                if (listC != null) {
                                    for (zb zbVar2 : listC) {
                                        if (zbVar2 != null) {
                                            JSONObject jSONObject10 = new JSONObject();
                                            jSONObject10.put("width", zbVar2.tt());
                                            str2 = str;
                                            jSONObject10.put(str2, zbVar2.ve());
                                            jSONObject10.put("url", zbVar2.c());
                                            jSONArray.put(jSONObject10);
                                        } else {
                                            str2 = str;
                                        }
                                        str = str2;
                                    }
                                }
                                jSONArray2 = new JSONArray();
                                listTt = rhVarIc.tt();
                                if (listTt != null) {
                                    for (com.byazt.jzl.uj ujVar : listTt) {
                                        if (ujVar != null) {
                                            JSONObject jSONObject11 = new JSONObject();
                                            jSONObject11.put("file_hash", ujVar.getFileHash());
                                            jSONObject11.put(CommonCode.MapKey.HAS_RESOLUTION, ujVar.getResolution());
                                            jSONObject11.put(CropKey.VIDEO_DURATION, ujVar.getVideo_duration());
                                            jSONObject11.put("video_url", ujVar.getVideo_url());
                                            jSONArray2.put(jSONObject11);
                                        }
                                    }
                                }
                                JSONObject jSONObject12 = new JSONObject();
                                jSONObject12.put("bg_anim_img_android", jSONArray);
                                jSONObject12.put("bg_videos", jSONArray2);
                                JSONObject jSONObject13 = new JSONObject();
                                jSONObject13.put("sdk_template_info", jSONObject9);
                                jSONObject13.put("aigc", jSONObject12);
                                jSONObject2.put("sdk_derive_info", jSONObject13);
                            } catch (JSONException unused9) {
                            }
                        }
                        jSONObject2.put("disable_video_join", zb());
                        jSONObject2.put("disable_top_bar", nb());
                        jSONObject2.put("disable_rtn_button", bx());
                        jSONObject2.put("disable_safe_area", d());
                        jSONObject2.put("disable_slide_return", cu());
                        jSONObject2.put("_ad_index", fq());
                        jSONObject2.put("is_height_resize", rm());
                        return jSONObject2;
                    }
                }
                jSONObject2.put("image", jSONArray5);
                listPr = pr();
                if (listPr != null) {
                    jSONArray4 = new JSONArray();
                    it2 = listPr.iterator();
                    while (it2.hasNext()) {
                        jSONArray4.put(it2.next());
                    }
                    jSONObject2.put("show_url", jSONArray4);
                }
                listGl = gl();
                if (listGl != null) {
                    jSONArray3 = new JSONArray();
                    it = listGl.iterator();
                    while (it.hasNext()) {
                        jSONArray3.put(it.next());
                    }
                    jSONObject2.put("click_url", jSONArray3);
                }
                jSONObject2.put("phone_num", tp());
                jSONObject2.put("title", v_());
                jSONObject2.put("download_num", ru());
                jSONObject2.put("description", op());
                jSONObject2.put(LoginConstants.EXT, w_());
                jSONObject2.put("req_id", qy());
                jSONObject2.put("image_mode", id());
                jSONObject2.put("intercept_flag", az());
                jSONObject2.put("web_inspector", is());
                jSONObject2.put("button_text", tj());
                jSONObject2.put("ad_logo", mq());
                jSONObject2.put("video_adaptation", vi());
                jSONObject2.put("feed_video_opentype", vp());
                jSONObject2.put("feed_reward_type", kz());
                jSONObject2.put("orientation", by());
                jSONObject2.put("aspect_ratio", fr());
                jSONObject2.put("aspect_margin", qe());
                jSONObject2.put("corner_radius", jy());
                nVarZ = z();
                if (nVarZ != null) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("app_name", nVarZ.ve());
                    jSONObject14.put("package_name", nVarZ.uj());
                    jSONObject14.put("download_url", nVarZ.tt());
                    jSONObject14.put("score", nVarZ.n());
                    str = "height";
                    try {
                        jSONObject14.put("comment_num", nVarZ.a());
                        jSONObject14.put("quick_app_url", nVarZ.c());
                        jSONObject14.put("app_size", nVarZ.sp());
                        jSONObject2.put(NativeCallContext.DOMAIN_APP, jSONObject14);
                    } catch (Exception unused10) {
                        i = 1;
                    }
                } else {
                    str = "height";
                }
                rlVarNm = nm();
                if (rlVarNm != null) {
                    jSONObject2.put("download_sdk_conf", rlVarNm.ve());
                }
                if (xd() != null) {
                    xd().tt(jSONObject2);
                }
                if (xo() != null) {
                    xo().c(jSONObject2);
                }
                if (yp() != null) {
                    yp().c(jSONObject2);
                }
                if (wq() != null) {
                    wq().c(jSONObject2);
                }
                if (gy() != null) {
                    gy().tt(jSONObject2);
                }
                if (gx() != null) {
                    gx().c(jSONObject2);
                }
                if (pn() != null) {
                    pn().c(jSONObject2);
                }
                if (ef() != null) {
                    ef().c(jSONObject2);
                }
                if (yo() != null) {
                    yo().c(jSONObject2);
                }
                if (fb() != null) {
                    fb().c(jSONObject2);
                }
                if (jc() != null) {
                    jc().c(jSONObject2);
                }
                if (hq() != null) {
                    hq().tt(jSONObject2);
                }
                jSONObject2.put("count_down", xr());
                jSONObject2.put("expiration_time", uv());
                jSONObject2.put("client_expiration_time", uv());
                jSONObject2.put("_child_metas", hl());
                jSONObject2.put("_meta_life_record", bn().c());
                jSONObject2.put("src_req_id", xv());
                jSONObject2.put("player_type", xx());
                jSONObject2.put("video_encode_type", hc());
                jSONObject2.put("feed_video_finish_type", ir());
                jSONObject2.put("video_voice_control", ab());
                jSONObject2.put("if_show_win", oq());
                if (o() != null) {
                    o().c(jSONObject2);
                }
                if (u_() != null) {
                    u_().c(jSONObject2);
                }
                jSONObject2.put("if_both_open", jf());
                jSONObject2.put("if_double_deeplink", vr());
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("splash_clickarea", pl());
                jSONObject15.put("splash_clicktext", di());
                jSONObject15.put("area_height", hg());
                jSONObject15.put("area_width", sd());
                jSONObject15.put("area_blank_height", k());
                jSONObject15.put("half_blank_height", iy());
                jSONObject15.put("splash_style_id", nc());
                jSONObject15.put("btn_background_dest_color", ca());
                jSONObject15.put("top_splash_clicktext", cl());
                jSONObject15.put("splash_load_time_optimization", gk());
                if (nx() != null) {
                    jSONObjectC = nx().c();
                } else {
                    jSONObjectC = null;
                }
                jSONObject15.put("text_config", jSONObjectC);
                if (iw() != null) {
                    jSONObjectC2 = iw().c();
                } else {
                    jSONObjectC2 = null;
                }
                jSONObject15.put("top_text_config", jSONObjectC2);
                jSONObject15.put("sliding_distance", hm());
                if (bj() != null) {
                    jSONObjectN = bj().n();
                } else {
                    jSONObjectN = null;
                }
                jSONObject15.put("slide_area", jSONObjectN);
                jSONObject2.put("splash_control", jSONObject15);
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("position", bp());
                jSONObject16.put("left_or_right_margin", ph());
                jSONObject16.put("top_or_bottom_margin", dr());
                iuVar = this.nx;
                if (iuVar == null) {
                    iUj = 1;
                } else {
                    iUj = iuVar.uj();
                }
                jSONObject16.put("skip_style", iUj);
                iuVar2 = this.nx;
                if (iuVar2 == null) {
                    iN = 0;
                } else {
                    iN = iuVar2.n();
                }
                jSONObject16.put("hide_native_skip_logo", iN);
                jSONObject2.put("skip_control", jSONObject16);
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("show_type", ly());
                jSONObject17.put("blank", px());
                jSONObject17.put("half_blank", fk());
                jSONObject2.put("splash_compliance_bar", jSONObject17);
                jSONObject2.put("fix_click_sequence", h());
                if (yt() != null) {
                    jSONObject = new JSONObject();
                    setEntrySet = yt().entrySet();
                    if (setEntrySet != null && !setEntrySet.isEmpty()) {
                        for (Map.Entry<String, Object> entry : setEntrySet) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject2.put("media_ext", jSONObject);
                }
                jSONObject2.put("isDirectDownload", hd());
                jSONObject2.put("page_render_type", tx());
                jSONObject2.put("promotion_type", ma());
                jSONObject2.put("if_lpua_package", this.jm);
                jSONObject2.put("click_freq", this.fb);
                cVarV = v();
                if (cVarV != null) {
                    JSONObject jSONObject18 = new JSONObject();
                    jSONObject18.put("id", cVarV.c());
                    jSONObject18.put(TKDownloadReason.KSAD_TK_MD5, cVarV.tt());
                    jSONObject18.put("url", cVarV.ve());
                    jSONObject18.put("scene", cVarV.uj());
                    jSONObject2.put("ugeno", jSONObject18);
                }
                cVarOs = os();
                if (cVarOs != null) {
                    JSONObject jSONObject19 = new JSONObject();
                    jSONObject19.put("product_infos", cVarOs.c());
                    jSONObject19.put("coupon", cVarOs.tt());
                    jSONObject19.put("render_config", cVarOs.ve());
                    jSONObject19.put("live_room_data", cVarOs.uj());
                    jSONObject19.putOpt("ec_mall_conf", cVarOs.n());
                    jSONObject2.put("dylite_info", jSONObject19);
                }
                jSONObject2.put("native_lp_data", lo());
                jSONObject2.put("native_lp_tpl_id", pu());
                jSONObject2.put("native_lp_ugen_url", lt());
                jSONObject2.put("native_lp_ugen_md5", to());
                jSONObject2.put("download_url", l());
                jSONObject2.put("native_lp_is_preload", tk());
                if (tk()) {
                    jSONObject2.put("native_lp_content", kp());
                }
                jSONObject2.put("market_url", gr());
                jSONObject2.put("close_on_dislike", lx());
                aVarRh = rh();
                if (aVarRh != null) {
                    JSONObject jSONObject20 = new JSONObject();
                    jSONObject20.put("developer_name", aVarRh.sp());
                    jSONObject20.put(AlibcCommonConstant.APP_VERSION, aVarRh.n());
                    jSONObject20.put(RequestPermission.PERMISSIONS, aVarRh.t());
                    jSONObject20.put("privacy_policy_url", aVarRh.x());
                    jSONObject20.put("package_name", aVarRh.u());
                    jSONObject20.put("app_name", aVarRh.yp());
                    jSONObject20.put("score", aVarRh.ve());
                    jSONObject20.put("creative_tags", aVarRh.uj());
                    jSONObject20.put("permissions_url", aVarRh.tt());
                    jSONObject20.put("desc_url", aVarRh.i());
                    jSONObject20.put("reg_number", aVarRh.da());
                    jSONObject20.put("reg_url", aVarRh.sl());
                    jSONObject2.put("app_manage", jSONObject20);
                }
                zmVarPo = po();
                if (zmVarPo != null) {
                    JSONObject jSONObject21 = new JSONObject();
                    jSONObject21.put("ugen_dialog_url", zmVarPo.tt());
                    jSONObject21.put("ugen_dialog_md5", zmVarPo.ve());
                    jSONObject21.put("dialog_style", zmVarPo.c());
                    jSONObject2.put("easy_dl_dialog", jSONObject21);
                }
                if (la() != null) {
                    jSONObject2.put("easy_pl_material", la());
                }
                jSONObject2.put("micro_app_type", p());
                jSONObject2.put("app_manage_type", st());
                i = 1;
                if (en() == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                try {
                    jSONObject2.put("lp_down_rule", i2);
                    jSONObject2.put("auction_price", em());
                    jSONObject2.put("price", j());
                    jSONObject2.put("ad_info", mk());
                    jSONObject2.put("adx_name", dn());
                    jSONObject2.put("no_default_ttdsp_price", ku());
                    jSONObject2.put("endcard_close_time", hz());
                    jSONObject2.put("proportion_watching", cs());
                    jSONObject2.put("video_skip_result", wn());
                    jSONObject2.put("shake_value", ge());
                    jSONObject2.put("deep_shake_value", tw());
                    jSONObject2.put("rotation_angle", br());
                    jSONObject2.put("calculation_method", e());
                    jSONObject2.put("calculation_method_twist", pe());
                    jSONObject2.put("show_poll_time", m172if());
                    jSONObject2.put("dynamic_join_type", il());
                    jSONObject2.put("dynamic_join_duration", pb());
                    jSONObject2.put("is_web_meta", s_());
                    jSONObject2.put("union_session_key", rl());
                    jSONObject2.put("cache_ext", q());
                    jSONObject2.put("cache_time", b());
                    jSONObject2.put("req_id", oz());
                    jSONObject2.put("is_cache", r());
                    jSONObject2.put("log_ext", s());
                    jSONObject2.put("material_key", y());
                    jSONObject2.put("need_get_materials", iu());
                    jSONObject2.put("s_send_ts", dz());
                    jSONObject2.put("parse_material_ts", kk());
                    hqVar = this.c;
                    if (hqVar != null) {
                        jSONObject2.put("wc_miniapp_info", hqVar.i());
                    }
                    obj = this.ve;
                    if (obj != null) {
                        jSONObject2.put("app_id", obj);
                    }
                    slVarMn = mn();
                    if (slVarMn != null) {
                        JSONObject jSONObject22 = new JSONObject();
                        jSONObject22.put("click_trigger_type", slVarMn.c());
                        jSONObject22.put("shake_start_time", slVarMn.tt());
                        jSONObject22.put("shake_end_time", slVarMn.ve());
                        jSONObject2.put("click_trigger_config", jSONObject22);
                    }
                    jSONObject2.put("web_monitor_rate", md());
                    if (ix() != null) {
                        ix().c(jSONObject2);
                    }
                } catch (Exception unused11) {
                }
            } else {
                listPr = pr();
                if (listPr != null) {
                    jSONArray4 = new JSONArray();
                    it2 = listPr.iterator();
                    while (it2.hasNext()) {
                        jSONArray4.put(it2.next());
                    }
                    jSONObject2.put("show_url", jSONArray4);
                }
                listGl = gl();
                if (listGl != null) {
                    jSONArray3 = new JSONArray();
                    it = listGl.iterator();
                    while (it.hasNext()) {
                        jSONArray3.put(it.next());
                    }
                    jSONObject2.put("click_url", jSONArray3);
                }
                jSONObject2.put("phone_num", tp());
                jSONObject2.put("title", v_());
                jSONObject2.put("download_num", ru());
                jSONObject2.put("description", op());
                jSONObject2.put(LoginConstants.EXT, w_());
                jSONObject2.put("req_id", qy());
                jSONObject2.put("image_mode", id());
                jSONObject2.put("intercept_flag", az());
                jSONObject2.put("web_inspector", is());
                jSONObject2.put("button_text", tj());
                jSONObject2.put("ad_logo", mq());
                jSONObject2.put("video_adaptation", vi());
                jSONObject2.put("feed_video_opentype", vp());
                jSONObject2.put("feed_reward_type", kz());
                jSONObject2.put("orientation", by());
                jSONObject2.put("aspect_ratio", fr());
                jSONObject2.put("aspect_margin", qe());
                jSONObject2.put("corner_radius", jy());
                nVarZ = z();
                if (nVarZ != null) {
                    JSONObject jSONObject110 = new JSONObject();
                    jSONObject110.put("app_name", nVarZ.ve());
                    jSONObject110.put("package_name", nVarZ.uj());
                    jSONObject110.put("download_url", nVarZ.tt());
                    jSONObject110.put("score", nVarZ.n());
                    str = "height";
                    jSONObject110.put("comment_num", nVarZ.a());
                    jSONObject110.put("quick_app_url", nVarZ.c());
                    jSONObject110.put("app_size", nVarZ.sp());
                    jSONObject2.put(NativeCallContext.DOMAIN_APP, jSONObject110);
                } else {
                    str = "height";
                }
                rlVarNm = nm();
                if (rlVarNm != null) {
                    jSONObject2.put("download_sdk_conf", rlVarNm.ve());
                }
                if (xd() != null) {
                    xd().tt(jSONObject2);
                }
                if (xo() != null) {
                    xo().c(jSONObject2);
                }
                if (yp() != null) {
                    yp().c(jSONObject2);
                }
                if (wq() != null) {
                    wq().c(jSONObject2);
                }
                if (gy() != null) {
                    gy().tt(jSONObject2);
                }
                if (gx() != null) {
                    gx().c(jSONObject2);
                }
                if (pn() != null) {
                    pn().c(jSONObject2);
                }
                if (ef() != null) {
                    ef().c(jSONObject2);
                }
                if (yo() != null) {
                    yo().c(jSONObject2);
                }
                if (fb() != null) {
                    fb().c(jSONObject2);
                }
                if (jc() != null) {
                    jc().c(jSONObject2);
                }
                if (hq() != null) {
                    hq().tt(jSONObject2);
                }
                jSONObject2.put("count_down", xr());
                jSONObject2.put("expiration_time", uv());
                jSONObject2.put("client_expiration_time", uv());
                jSONObject2.put("_child_metas", hl());
                jSONObject2.put("_meta_life_record", bn().c());
                jSONObject2.put("src_req_id", xv());
                jSONObject2.put("player_type", xx());
                jSONObject2.put("video_encode_type", hc());
                jSONObject2.put("feed_video_finish_type", ir());
                jSONObject2.put("video_voice_control", ab());
                jSONObject2.put("if_show_win", oq());
                if (o() != null) {
                    o().c(jSONObject2);
                }
                if (u_() != null) {
                    u_().c(jSONObject2);
                }
                jSONObject2.put("if_both_open", jf());
                jSONObject2.put("if_double_deeplink", vr());
                JSONObject jSONObject111 = new JSONObject();
                jSONObject111.put("splash_clickarea", pl());
                jSONObject111.put("splash_clicktext", di());
                jSONObject111.put("area_height", hg());
                jSONObject111.put("area_width", sd());
                jSONObject111.put("area_blank_height", k());
                jSONObject111.put("half_blank_height", iy());
                jSONObject111.put("splash_style_id", nc());
                jSONObject111.put("btn_background_dest_color", ca());
                jSONObject111.put("top_splash_clicktext", cl());
                jSONObject111.put("splash_load_time_optimization", gk());
                if (nx() != null) {
                    jSONObjectC = nx().c();
                } else {
                    jSONObjectC = null;
                }
                jSONObject111.put("text_config", jSONObjectC);
                if (iw() != null) {
                    jSONObjectC2 = iw().c();
                } else {
                    jSONObjectC2 = null;
                }
                jSONObject111.put("top_text_config", jSONObjectC2);
                jSONObject111.put("sliding_distance", hm());
                if (bj() != null) {
                    jSONObjectN = bj().n();
                } else {
                    jSONObjectN = null;
                }
                jSONObject111.put("slide_area", jSONObjectN);
                jSONObject2.put("splash_control", jSONObject111);
                JSONObject jSONObject112 = new JSONObject();
                jSONObject112.put("position", bp());
                jSONObject112.put("left_or_right_margin", ph());
                jSONObject112.put("top_or_bottom_margin", dr());
                iuVar = this.nx;
                if (iuVar == null) {
                    iUj = 1;
                } else {
                    iUj = iuVar.uj();
                }
                jSONObject112.put("skip_style", iUj);
                iuVar2 = this.nx;
                if (iuVar2 == null) {
                    iN = 0;
                } else {
                    iN = iuVar2.n();
                }
                jSONObject112.put("hide_native_skip_logo", iN);
                jSONObject2.put("skip_control", jSONObject112);
                JSONObject jSONObject113 = new JSONObject();
                jSONObject113.put("show_type", ly());
                jSONObject113.put("blank", px());
                jSONObject113.put("half_blank", fk());
                jSONObject2.put("splash_compliance_bar", jSONObject113);
                jSONObject2.put("fix_click_sequence", h());
                if (yt() != null) {
                    jSONObject = new JSONObject();
                    setEntrySet = yt().entrySet();
                    if (setEntrySet != null) {
                        while (r10.hasNext()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject2.put("media_ext", jSONObject);
                }
                jSONObject2.put("isDirectDownload", hd());
                jSONObject2.put("page_render_type", tx());
                jSONObject2.put("promotion_type", ma());
                jSONObject2.put("if_lpua_package", this.jm);
                jSONObject2.put("click_freq", this.fb);
                cVarV = v();
                if (cVarV != null) {
                    JSONObject jSONObject114 = new JSONObject();
                    jSONObject114.put("id", cVarV.c());
                    jSONObject114.put(TKDownloadReason.KSAD_TK_MD5, cVarV.tt());
                    jSONObject114.put("url", cVarV.ve());
                    jSONObject114.put("scene", cVarV.uj());
                    jSONObject2.put("ugeno", jSONObject114);
                }
                cVarOs = os();
                if (cVarOs != null) {
                    JSONObject jSONObject115 = new JSONObject();
                    jSONObject115.put("product_infos", cVarOs.c());
                    jSONObject115.put("coupon", cVarOs.tt());
                    jSONObject115.put("render_config", cVarOs.ve());
                    jSONObject115.put("live_room_data", cVarOs.uj());
                    jSONObject115.putOpt("ec_mall_conf", cVarOs.n());
                    jSONObject2.put("dylite_info", jSONObject115);
                }
                jSONObject2.put("native_lp_data", lo());
                jSONObject2.put("native_lp_tpl_id", pu());
                jSONObject2.put("native_lp_ugen_url", lt());
                jSONObject2.put("native_lp_ugen_md5", to());
                jSONObject2.put("download_url", l());
                jSONObject2.put("native_lp_is_preload", tk());
                if (tk()) {
                    jSONObject2.put("native_lp_content", kp());
                }
                jSONObject2.put("market_url", gr());
                jSONObject2.put("close_on_dislike", lx());
                aVarRh = rh();
                if (aVarRh != null) {
                    JSONObject jSONObject23 = new JSONObject();
                    jSONObject23.put("developer_name", aVarRh.sp());
                    jSONObject23.put(AlibcCommonConstant.APP_VERSION, aVarRh.n());
                    jSONObject23.put(RequestPermission.PERMISSIONS, aVarRh.t());
                    jSONObject23.put("privacy_policy_url", aVarRh.x());
                    jSONObject23.put("package_name", aVarRh.u());
                    jSONObject23.put("app_name", aVarRh.yp());
                    jSONObject23.put("score", aVarRh.ve());
                    jSONObject23.put("creative_tags", aVarRh.uj());
                    jSONObject23.put("permissions_url", aVarRh.tt());
                    jSONObject23.put("desc_url", aVarRh.i());
                    jSONObject23.put("reg_number", aVarRh.da());
                    jSONObject23.put("reg_url", aVarRh.sl());
                    jSONObject2.put("app_manage", jSONObject23);
                }
                zmVarPo = po();
                if (zmVarPo != null) {
                    JSONObject jSONObject24 = new JSONObject();
                    jSONObject24.put("ugen_dialog_url", zmVarPo.tt());
                    jSONObject24.put("ugen_dialog_md5", zmVarPo.ve());
                    jSONObject24.put("dialog_style", zmVarPo.c());
                    jSONObject2.put("easy_dl_dialog", jSONObject24);
                }
                if (la() != null) {
                    jSONObject2.put("easy_pl_material", la());
                }
                jSONObject2.put("micro_app_type", p());
                jSONObject2.put("app_manage_type", st());
                i = 1;
                if (en() == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject2.put("lp_down_rule", i2);
                jSONObject2.put("auction_price", em());
                jSONObject2.put("price", j());
                jSONObject2.put("ad_info", mk());
                jSONObject2.put("adx_name", dn());
                jSONObject2.put("no_default_ttdsp_price", ku());
                jSONObject2.put("endcard_close_time", hz());
                jSONObject2.put("proportion_watching", cs());
                jSONObject2.put("video_skip_result", wn());
                jSONObject2.put("shake_value", ge());
                jSONObject2.put("deep_shake_value", tw());
                jSONObject2.put("rotation_angle", br());
                jSONObject2.put("calculation_method", e());
                jSONObject2.put("calculation_method_twist", pe());
                jSONObject2.put("show_poll_time", m172if());
                jSONObject2.put("dynamic_join_type", il());
                jSONObject2.put("dynamic_join_duration", pb());
                jSONObject2.put("is_web_meta", s_());
                jSONObject2.put("union_session_key", rl());
                jSONObject2.put("cache_ext", q());
                jSONObject2.put("cache_time", b());
                jSONObject2.put("req_id", oz());
                jSONObject2.put("is_cache", r());
                jSONObject2.put("log_ext", s());
                jSONObject2.put("material_key", y());
                jSONObject2.put("need_get_materials", iu());
                jSONObject2.put("s_send_ts", dz());
                jSONObject2.put("parse_material_ts", kk());
                hqVar = this.c;
                if (hqVar != null) {
                    jSONObject2.put("wc_miniapp_info", hqVar.i());
                }
                obj = this.ve;
                if (obj != null) {
                    jSONObject2.put("app_id", obj);
                }
                slVarMn = mn();
                if (slVarMn != null) {
                    JSONObject jSONObject25 = new JSONObject();
                    jSONObject25.put("click_trigger_type", slVarMn.c());
                    jSONObject25.put("shake_start_time", slVarMn.tt());
                    jSONObject25.put("shake_end_time", slVarMn.ve());
                    jSONObject2.put("click_trigger_config", jSONObject25);
                }
                jSONObject2.put("web_monitor_rate", md());
                if (ix() != null) {
                    ix().c(jSONObject2);
                }
            }
        } catch (Exception unused12) {
            str = "height";
            i = i3;
        }
        if (js() != null) {
            js().c(jSONObject2);
        }
        try {
            if (bz()) {
                i = 0;
            }
            jSONObject2.put("is_ec_mall", i);
            jSONObject2.put("live_room_id", da());
            jSONObject2.put("ad_type", xl());
            jSONObject2.put("live_interaction_type", n());
            jSONObject2.put("ec_schema", t_());
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
        try {
            jSONObject2.put("ecom_live_params", t());
        } catch (JSONException e3) {
            com.byazt.nr.m.c(e3);
        }
        cuVarDp = dp();
        if (cuVarDp != null) {
            cuVarDp.c(jSONObject2);
        }
        qyVarU = u();
        if (qyVarU != null) {
            qyVarU.c(jSONObject2);
        }
        pfVarGt = gt();
        if (pfVarGt != null) {
            JSONObject jSONObject26 = new JSONObject();
            jSONObject26.put("reward_live_deep_link_user_id", pfVarGt.c());
            jSONObject26.put("reward_live_deep_link_request_id", pfVarGt.a());
            jSONObject26.put("reward_live_deep_link_room_id", pfVarGt.tt());
            jSONObject26.put("reward_live_last_time", pfVarGt.n());
            jSONObject26.put("reawrd_live_short_touch_params", pfVarGt.ve());
            jSONObject26.put("reawrd_live_extra_pangle_scheme_params", pfVarGt.uj());
            jSONObject2.put("reward_live_deep_link_params", jSONObject26);
        }
        zVarQi = qi();
        if (zVarQi != null) {
            JSONObject jSONObject27 = new JSONObject();
            jSONObject27.put("style_type", zVarQi.c());
            jSONObject27.put("image_url", zVarQi.tt());
            jSONObject27.put("position", zVarQi.ve());
            jSONObject27.put("image_height", zVarQi.uj());
            jSONObject27.put("image_scale_rate", zVarQi.a());
            jSONObject27.put("image_gif_url", zVarQi.n());
            jSONObject27.put("image_gif_aspect_ratio", zVarQi.sp());
            jSONObject2.put("dynamic_join_coupon_style", jSONObject27);
        }
        ypVarMy = my();
        if (ypVarMy != null) {
            jSONObject2.put("coupon", ypVarMy.c());
        }
        svVarSl = sl();
        if (svVarSl != null) {
            jSONObject2.put("live_info", svVarSl.c());
        }
        qVarC_ = C_();
        if (qVarC_ != null) {
            jSONObject2.put("saas_info", qVarC_.c());
        }
        kkVarD_ = D_();
        if (kkVarD_ != null) {
            jSONObject2.put("saas_on_click_material", kkVarD_.c());
        }
        try {
            jSONObject2.put("live_sdk_status_while_first_click", this.qe);
        } catch (JSONException unused13) {
        }
        objCx = cx();
        if (objCx != null) {
            jSONObject2.put("group_info", objCx);
        }
        jVarEk = ek();
        if (jVarEk != null) {
            JSONObject jSONObject28 = new JSONObject();
            jSONObject28.put("video_adapter_type", jVarEk.c());
            jSONObject28.put("video_mute_type", jVarEk.tt());
            jSONObject2.put("video_config", jSONObject28);
        }
        try {
            jSONObject2.put("not_valid_download_url", B_());
        } catch (JSONException e4) {
            com.byazt.nr.m.c(e4);
        }
        try {
            jSONObject2.put("dynamic_configs", m());
            strWo = wo();
            if (!TextUtils.isEmpty(strWo)) {
                jSONObject2.put("gnd_prefetch_cache_key", strWo);
                jSONObject2.put("gnd_prefetch_timing", cj());
            }
        } catch (JSONException e5) {
            com.byazt.nr.m.c(e5);
        }
        try {
            jSONObject2.put("twist_config", lv());
            jSONObject2.put("shake_interact_conf", cy());
            jSONObject2.put("twist_interact_conf", yx());
        } catch (JSONException e6) {
            com.byazt.nr.m.c(e6);
        }
        try {
            hVar = this.ls;
            if (hVar != null) {
                hVar.tt(jSONObject2);
            }
        } catch (Throwable unused14) {
        }
        try {
            orVar = this.wq;
            if (orVar != null) {
                orVar.tt(jSONObject2);
            }
        } catch (Throwable unused15) {
        }
        rhVarIc = ic();
        if (rhVarIc != null) {
            JSONObject jSONObject29 = new JSONObject();
            jSONObject29.put("lottie_tmp_url", rhVarIc.ve());
            jSONArray = new JSONArray();
            listC = rhVarIc.c();
            if (listC != null) {
                while (r4.hasNext()) {
                    if (zbVar2 != null) {
                        JSONObject jSONObject116 = new JSONObject();
                        jSONObject116.put("width", zbVar2.tt());
                        str2 = str;
                        jSONObject116.put(str2, zbVar2.ve());
                        jSONObject116.put("url", zbVar2.c());
                        jSONArray.put(jSONObject116);
                    } else {
                        str2 = str;
                    }
                    str = str2;
                }
            }
            jSONArray2 = new JSONArray();
            listTt = rhVarIc.tt();
            if (listTt != null) {
                while (r0.hasNext()) {
                    if (ujVar != null) {
                        JSONObject jSONObject117 = new JSONObject();
                        jSONObject117.put("file_hash", ujVar.getFileHash());
                        jSONObject117.put(CommonCode.MapKey.HAS_RESOLUTION, ujVar.getResolution());
                        jSONObject117.put(CropKey.VIDEO_DURATION, ujVar.getVideo_duration());
                        jSONObject117.put("video_url", ujVar.getVideo_url());
                        jSONArray2.put(jSONObject117);
                    }
                }
            }
            JSONObject jSONObject118 = new JSONObject();
            jSONObject118.put("bg_anim_img_android", jSONArray);
            jSONObject118.put("bg_videos", jSONArray2);
            JSONObject jSONObject119 = new JSONObject();
            jSONObject119.put("sdk_template_info", jSONObject29);
            jSONObject119.put("aigc", jSONObject118);
            jSONObject2.put("sdk_derive_info", jSONObject119);
        }
        try {
            jSONObject2.put("disable_video_join", zb());
            jSONObject2.put("disable_top_bar", nb());
            jSONObject2.put("disable_rtn_button", bx());
            jSONObject2.put("disable_safe_area", d());
            jSONObject2.put("disable_slide_return", cu());
        } catch (Throwable unused16) {
        }
        try {
            jSONObject2.put("_ad_index", fq());
        } catch (JSONException unused17) {
        }
        try {
            jSONObject2.put("is_height_resize", rm());
        } catch (JSONException unused18) {
        }
        return jSONObject2;
    }

    public JSONObject ym() {
        return this.g;
    }

    public oz yo() {
        return this.hs;
    }

    public void yp(int i) {
        this.nt = i;
    }

    public boolean ys() {
        return this.bx;
    }

    public Map<String, Object> yt() {
        return this.b;
    }

    public boolean yv() {
        return this.po == 3;
    }

    public JSONObject yx() {
        return this.vr;
    }

    public void z(int i) {
        this.ny = i;
    }

    @Override // com.byazt.eia.sl
    public boolean z_() {
        to toVar = this.cl;
        return toVar != null && toVar.c();
    }

    public int zb() {
        return this.fe;
    }

    public synchronized String zm() {
        if (TextUtils.isEmpty(this.la)) {
            String strU = com.byazt.aas.nb.u(this);
            String strGu = gu();
            String strUj = uj();
            if (TextUtils.isEmpty(strU)) {
                strU = "0";
            }
            if (TextUtils.isEmpty(strUj)) {
                strUj = "0";
            }
            if (TextUtils.isEmpty(strGu)) {
                strGu = "0";
            }
            this.la = strU + LoginConstants.UNDER_LINE + strGu + LoginConstants.UNDER_LINE + strUj;
        }
        return this.la;
    }

    public h zo() {
        return this.ls;
    }

    public md zr() {
        return this.ey;
    }

    public void aw(int i) {
        this.gy = Math.max(0, i);
    }

    public void b(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.nc = i;
    }

    public void bm(int i) {
        this.lt = i;
    }

    public void bx(int i) {
        this.da = i;
    }

    public void c(String str) {
        this.kn = str;
    }

    public void cu(int i) {
        this.lr = i;
    }

    public void d(int i) {
        this.dr = i;
    }

    public void da(String str) {
        this.cf = str;
    }

    public void eo(int i) {
        this.tp = i;
    }

    public void gr(String str) {
        this.h = str;
    }

    public void gt(String str) {
        this.rh = str;
    }

    public void gu(String str) {
        this.qy = str;
    }

    public void h(int i) {
        this.ph = i;
    }

    public void hd(int i) {
        this.cu = i;
    }

    public void i(int i) {
        this.ox = i;
    }

    public void ic(int i) {
        this.p = i;
    }

    public void iu(int i) {
        this.qe = i;
    }

    public void j(int i) {
        this.mc = i;
    }

    public void kk(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            i = com.byazt.aas.nb.sl(this) == 3 ? 500 : 1000;
        }
        if (i >= 500) {
            i2 = 3000;
            if (i <= 3000) {
                i2 = i;
            }
        }
        this.cx = i2;
    }

    public void kp(int i) {
        this.sd = i;
    }

    public void l(int i) {
        this.xd = i;
    }

    public void lo(int i) {
        this.hq = i;
    }

    public void lr(int i) {
        int i2 = this.aw;
        if (i2 == 100 || i2 == 102) {
            this.aw = i;
        }
    }

    public void lt(int i) {
        this.di = i;
    }

    public void m(String str) {
        this.md = str;
    }

    public void md(int i) {
        this.pn = i;
    }

    public void my(String str) {
        this.z = str;
    }

    public void n(boolean z) {
        this.ku = z;
    }

    public void nb(int i) {
        this.n = i;
    }

    public void nu(String str) {
        this.i = str;
    }

    public void or(int i) {
        this.pf = i;
    }

    public void os(int i) {
        if (i <= 0 || i > 9) {
            this.k = 3;
        } else {
            this.k = i;
        }
    }

    public void oz(int i) {
        this.bp = i;
    }

    public void p(int i) {
        this.hj = i;
    }

    public void pf(int i) {
        this.f28496a = i;
    }

    public void pu(int i) {
        this.pl = i;
    }

    public void q(int i) {
        this.iy = i;
    }

    public void qp(int i) {
        this.l = i;
    }

    public void qy(String str) {
        this.rl = str;
    }

    public void r(int i) {
        this.tu = i;
    }

    @Override // com.byazt.eia.sp
    public a rh() {
        return this.ft;
    }

    public void rl(String str) {
        this.gt = str;
    }

    public void s(int i) {
        this.fb = i;
    }

    public void sl(String str) {
        this.jt = str;
    }

    public void sp(int i) {
        this.ge = i;
    }

    public void sv(int i) {
        this.gx = i;
    }

    public void t(int i) {
        this.op = i;
    }

    public void tk(int i) {
        if (i < 0 || i > 180) {
            this.bj = 50;
        } else {
            this.bj = i;
        }
    }

    public void to(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.iw = i;
    }

    public void u(int i) {
        this.qp = i;
    }

    public void uj(boolean z) {
        this.nq = z;
    }

    public void v(int i) {
        this.st = i;
    }

    public void ve(String str) {
        this.pb = str;
    }

    public void x(int i) {
        this.br = i;
    }

    public void y(int i) {
        this.jm = i;
    }

    public void yp(String str) {
        this.bw = str;
    }

    public void yv(int i) {
        this.ir = i;
    }

    public void z(String str) {
        this.pa = str;
    }

    public void zb(int i) {
        if (i != 1) {
            i = 0;
        }
        this.pr = i;
    }

    public void a(String str) {
        this.ys = str;
    }

    public void aw(String str) {
        this.ra = str;
    }

    public void bx(String str) {
        this.o = str;
    }

    public void c(eo eoVar) {
        if (eoVar == null) {
            return;
        }
        if (this.cs == null) {
            this.cs = new ArrayList();
        }
        this.cs.add(eoVar);
    }

    public void cu(String str) {
        this.hg = str;
    }

    public void d(String str) {
        this.tt = str;
    }

    public void da(boolean z) {
        this.sv = z;
    }

    public void eo(String str) {
        this.ej = str;
    }

    @Override // com.byazt.eia.sp
    public String gr() {
        return this.j;
    }

    @Override // com.byazt.eia.sl
    public pf gt() {
        return this.gk;
    }

    @Override // com.byazt.eia.sp
    public String gu() {
        return this.gu;
    }

    public void h(String str) {
        this.j = str;
    }

    public void i(String str) {
        this.vi = str;
    }

    @Override // com.byazt.eia.i
    public String m() {
        return this.uv;
    }

    public void md(String str) {
        this.to = str;
    }

    @Override // com.byazt.eia.i
    public yp my() {
        return this.hc;
    }

    public void n(String str) {
        this.ul = str;
    }

    public void nb(String str) {
        this.uv = str;
    }

    @Override // com.byazt.eia.sl
    public boolean nu() {
        return vr() == 1;
    }

    public void or(String str) {
        this.gl = str;
    }

    public void p(String str) {
        this.pu = str;
    }

    public void pf(String str) {
        this.mf = str;
    }

    public void qp(String str) {
        this.ve = str;
    }

    @Override // com.byazt.eia.i
    public String qy() {
        return this.eo;
    }

    public void rh(String str) {
        this.sl = str;
    }

    @Override // com.byazt.eia.i
    public String rl() {
        JSONObject jSONObject = this.f;
        String strOptString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(strOptString) ? lw() : strOptString;
    }

    public int sl(boolean z) {
        if (this.sv || z) {
            return vz();
        }
        return 102;
    }

    public void sp(String str) {
        this.up = str;
    }

    public void sv(String str) {
        this.cg = str;
    }

    public void t(boolean z) {
        this.tk = z;
    }

    public void tx(int i) {
        this.fv = i;
    }

    public void u(boolean z) {
        this.sy = z;
    }

    public void uj(String str) {
        this.fq = str;
    }

    public void ve(boolean z) {
        this.em = z;
    }

    public void x(String str) {
        this.kz = str;
    }

    @Override // com.byazt.eia.i
    public nu yp() {
        return this.yv;
    }

    public void yv(String str) {
        this.gu = str;
    }

    @Override // com.byazt.eia.sl
    public n z() {
        return this.gr;
    }

    public void zb(String str) {
        this.nl = str;
    }

    public static boolean uj(ic icVar) {
        try {
            return icVar.jm() != null && icVar.jm().optInt("parent_type") == 1;
        } catch (Exception unused) {
        }
    }

    public static boolean ve(ic icVar) {
        if (icVar == null) {
            return false;
        }
        return icVar.id() == 5 || icVar.id() == 15 || icVar.id() == 166;
    }

    public void a(boolean z) {
        this.xg = z;
    }

    public void da(long j) {
        this.bm = j;
    }

    @Override // com.byazt.eia.x
    public int i() {
        return this.n;
    }

    public void m(boolean z) {
        this.nm = z;
    }

    public void n(JSONObject jSONObject) {
        this.u = jSONObject;
    }

    public void sp(boolean z) {
        this.mq = z;
    }

    @Override // com.byazt.eia.i
    public String t() {
        return this.o;
    }

    @Override // com.byazt.eia.i
    public qy u() {
        return this.ts;
    }

    public void x(boolean z) {
        this.w = z;
    }

    public void yp(boolean z) {
        this.yo = z;
    }

    public void z(boolean z) {
        this.tx = z;
    }

    public void a(long j) {
        this.or = j;
    }

    @Override // com.byazt.eia.i
    public String da() {
        return this.mf;
    }

    public void i(boolean z) {
        this.bx = z;
    }

    public void n(long j) {
        this.zb = j;
    }

    public void sl(long j) {
        if (j != 0) {
            this.ru = j;
        } else {
            this.ru = System.currentTimeMillis() / 1000;
        }
    }

    public void sp(long j) {
        this.lo = j;
    }

    public void t(JSONObject jSONObject) {
        this.ef = new hd(this, jSONObject);
    }

    public void u(JSONObject jSONObject) {
        this.ka = jSONObject;
    }

    public void uj(JSONObject jSONObject) {
        this.t = jSONObject;
    }

    @Override // com.byazt.eia.da
    public String x() {
        return this.i;
    }

    public void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public void c(boolean z) {
        this.hz = z;
    }

    public void da(JSONObject jSONObject) {
        this.jf = jSONObject;
    }

    public void i(long j) {
        this.hd = j;
    }

    @Override // com.byazt.eia.i
    public int n() {
        return this.st;
    }

    public void sp(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public void tt(int i) {
        this.dn = i;
    }

    public void uj(long j) {
        this.my = j;
    }

    public void x(long j) {
        this.ic = j;
    }

    public static boolean n(ic icVar) {
        return icVar != null && icVar.jm == 1;
    }

    public static void sp(ic icVar) {
        if (icVar == null) {
            return;
        }
        icVar.mk = System.currentTimeMillis();
    }

    @Override // com.byazt.eia.sl
    public int a() {
        if (u_() != null) {
            return u_().uj();
        }
        return -1;
    }

    public void c(int i) {
        this.po = i;
    }

    public void i(JSONObject jSONObject) {
        this.ym = jSONObject;
    }

    @Override // com.byazt.eia.i
    public sv sl() {
        return this.ab;
    }

    public void tt(boolean z) {
        this.jy = z;
    }

    @Override // com.byazt.eia.i
    public String uj() {
        return this.qy;
    }

    public void ve(long j) {
        this.is = j;
    }

    public void x(JSONObject jSONObject) {
        this.xw = jSONObject;
    }

    public static boolean a(ic icVar) {
        if (icVar == null || icVar.mk <= 0 || icVar.fb <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - icVar.mk < ((long) icVar.fb);
        if (z) {
            icVar.by++;
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.ete.ic.1
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("count", ic.this.by);
                    jSONObject.put("click_freq", ic.this.fb);
                    return com.byazt.qal.tt.tt().c("click_intercept").x(ic.this.w_()).tt(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.qt = new rh();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (jSONObjectOptJSONObject != null) {
                this.qt.c(jSONObjectOptJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("aigc");
            if (jSONObjectOptJSONObject2 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("bg_anim_img_android");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.qt.c(arrayList);
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            zb zbVar = new zb();
                            zbVar.c(jSONObjectOptJSONObject3.optInt("width"));
                            zbVar.tt(jSONObjectOptJSONObject3.optInt("height"));
                            zbVar.c(jSONObjectOptJSONObject3.optString("url"));
                            arrayList.add(zbVar);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("bg_videos");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.qt.tt(arrayList2);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject4 != null) {
                            com.byazt.jzl.uj ujVar = new com.byazt.jzl.uj();
                            ujVar.setFileHash(jSONObjectOptJSONObject4.optString("file_hash"));
                            ujVar.setResolution(jSONObjectOptJSONObject4.optString(CommonCode.MapKey.HAS_RESOLUTION));
                            ujVar.setVideo_duration(jSONObjectOptJSONObject4.optDouble(CropKey.VIDEO_DURATION));
                            ujVar.setVideo_url(jSONObjectOptJSONObject4.optString("video_url"));
                            arrayList2.add(ujVar);
                        }
                    }
                }
            }
        }
    }

    public void sl(JSONObject jSONObject) {
        this.vr = jSONObject;
    }

    public void tt(JSONObject jSONObject) {
        this.sf = jSONObject;
    }

    public void ve(JSONObject jSONObject) {
        this.il = jSONObject;
    }

    public static boolean tt(ic icVar) {
        return icVar != null && icVar.hj() == 1;
    }

    @Override // com.byazt.eia.x
    public String ve() {
        return this.sl;
    }

    public void tt(long j) {
        this.an = j;
    }

    public void ve(float f) {
        this.px = f;
    }

    public void zm(int i) {
        this.os = i;
    }

    public void tt(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.e = 2;
        } else {
            this.e = (int) d;
        }
    }

    public void zm(String str) {
        this.eo = str;
    }

    @Override // com.byazt.eia.x
    public String tt() {
        return te() != null ? te().c() : "";
    }

    public void tt(zb zbVar) {
        this.yp.add(zbVar);
    }

    public void tt(float f) {
        this.ly = f;
    }

    public static boolean c(ic icVar) {
        return icVar != null && icVar.g() == 1;
    }

    public void c(long j) {
        this.vp = j;
    }

    public void c(com.byazt.seg.c cVar) {
        this.f1484if = cVar;
    }

    public void c(com.byazt.lo.c cVar) {
        this.xl = cVar;
    }

    public void c(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.pe = 2;
        } else {
            this.pe = (int) d;
        }
    }

    public void c(kp kpVar) {
        this.q = kpVar;
    }

    public void c(or orVar) {
        this.wq = orVar;
    }

    public void c(lo loVar) {
        this.ix = loVar;
    }

    public void c(pu puVar) {
        this.ne = puVar;
    }

    public void c(my myVar) {
        this.lz = myVar;
    }

    public void c(oz ozVar) {
        this.hs = ozVar;
    }

    public void c(com.byazt.dj.tt ttVar) {
        if (ttVar == null) {
            com.byazt.dj.tt ttVar2 = this.r;
            if (ttVar2 != null) {
                this.r = new ve(ttVar2);
                return;
            }
            return;
        }
        this.r = ttVar;
    }

    public void c(gt gtVar) {
        this.kp = gtVar;
    }

    public void c(s sVar) {
        this.mm = sVar;
    }

    public void c(a aVar) {
        this.ft = aVar;
    }

    public void c(xd xdVar) {
        this.nb = xdVar;
    }

    public void c(tx txVar) {
        this.sp = txVar;
    }

    public void c(zb zbVar) {
        this.x = zbVar;
    }

    public void c(n nVar) {
        this.gr = nVar;
    }

    public void c(rl rlVar) {
        this.zm = rlVar;
    }

    public void c(nu nuVar) {
        this.yv = nuVar;
    }

    public void c(Map<String, Object> map) {
        this.b = map;
    }

    public void c(com.byazt.vo.tt ttVar) {
        this.uj = ttVar;
    }

    public void c(l lVar) {
        this.ca = lVar;
    }

    public void c(qp qpVar) {
        this.te = qpVar;
    }

    public void c(float f) {
        this.jg = f;
    }

    public void c(zm zmVar) {
        this.xv = zmVar;
        if (zmVar != null) {
            String strTt = zmVar.tt();
            String strVe = this.xv.ve();
            if (TextUtils.isEmpty(strTt)) {
                return;
            }
            com.byazt.xs.da.c(strTt, strVe, (com.byazt.xs.ve) null);
        }
    }

    public void c(yv yvVar) {
        this.rp = yvVar;
    }

    public void c(to toVar) {
        this.cl = toVar;
    }

    public void c(pf pfVar) {
        this.gk = pfVar;
    }

    public void c(hq hqVar) {
        this.c = hqVar;
    }

    public void c(iu iuVar) {
        this.nx = iuVar;
    }

    public void c(r rVar) {
        this.fk = rVar;
    }

    public void c(lt ltVar) {
        this.kk = ltVar;
    }

    public void c(yp ypVar) {
        this.hc = ypVar;
    }

    public void c(sv svVar) {
        this.ab = svVar;
    }

    public void c(q qVar) {
        this.dh = qVar;
    }

    public void c(z zVar) {
        this.en = zVar;
    }

    public void c(j jVar) {
        this.oq = jVar;
    }

    public void c(sl slVar) {
        this.tj = slVar;
    }

    public void c(bx bxVar) {
        this.v = bxVar;
    }

    public void c(com.byazt.jzl.uj ujVar) {
        if (this.nb == null) {
            this.nb = new xd();
        }
        this.nb.c(ujVar);
    }

    public void c(cu cuVar) {
        this.ri = cuVar;
    }

    public void c(qy qyVar) {
        this.ts = qyVar;
    }

    public void c(h hVar) {
        this.ls = hVar;
    }

    public void c(p pVar) {
        this.fr = pVar;
    }

    public void c(lr lrVar) {
        this.ck = lrVar;
    }

    public void c(md mdVar) {
        this.ey = mdVar;
    }

    public void c(kk kkVar) {
        this.jc = kkVar;
    }
}
