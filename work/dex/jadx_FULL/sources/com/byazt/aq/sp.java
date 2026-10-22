package com.byazt.aq;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.alibaba.ariver.kernel.RVStartParams;
import com.byazt.du.sl;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.zj.adlib.un1;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 91})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f28295a;
    public int c;
    public a n;
    public String sp;
    public String tt;
    public JSONObject uj;
    public String ve;

    public sp(n nVar) {
        this.f28295a = nVar;
        this.c = nVar.c();
        this.tt = nVar.tt();
        this.ve = nVar.ve();
        this.uj = nVar.n().r();
        this.sp = nVar.uj();
        if (com.byazt.sr.uj.tt() == 1) {
            this.n = nVar.sp();
        } else {
            this.n = nVar.n();
        }
        if (com.byazt.sr.uj.c()) {
            this.n = nVar.n();
        }
    }

    private boolean hj() {
        return (com.byazt.sr.uj.c() && (this.f28295a.getType().contains("logo-union") || this.f28295a.getType().contains("logounion") || this.f28295a.getType().contains("logoad"))) || "logo-union".equals(this.f28295a.getType()) || "logounion".equals(this.f28295a.getType()) || "logoad".equals(this.f28295a.getType());
    }

    private boolean xd() {
        if (com.byazt.sr.uj.c()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.tt) && this.tt.contains("adx:")) || sl.tt();
    }

    public String a() {
        if (this.c == 0) {
            return !TextUtils.isEmpty(this.tt) ? this.tt : this.uj.optString(com.byazt.or.x.uj(com.byazt.sr.uj.getContext()));
        }
        return "";
    }

    public String aw() {
        return this.n.nb();
    }

    public boolean b() {
        return this.n.eo();
    }

    public int bm() {
        return this.n.ij();
    }

    public int bx() {
        return this.n.j();
    }

    public int c() {
        return (int) this.n.yp();
    }

    public int cu() {
        return this.n.i();
    }

    public int d() {
        return this.n.ve();
    }

    public String da() {
        int i = this.c;
        return (i == 2 || i == 13) ? this.tt : "";
    }

    public int dz() {
        return this.n.nt();
    }

    public int eo() {
        return this.n.tt();
    }

    public String f() {
        return this.c == 29 ? this.ve : "";
    }

    public boolean g() {
        return this.n.gk();
    }

    public String gr() {
        return this.n.pf();
    }

    public boolean gt() {
        return this.n.is();
    }

    public int gu() {
        return this.n.hd();
    }

    public double h() {
        return this.n.x();
    }

    public int hd() {
        return this.n.sp();
    }

    public int i() {
        int iX = x();
        if (iX == 4) {
            return 17;
        }
        return iX == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public boolean ic() {
        return this.n.mm();
    }

    public List<String> ir() {
        return this.n.cl();
    }

    public int iu() {
        return this.n.gy();
    }

    public int j() {
        return this.n.gx();
    }

    public int kk() {
        return this.n.zb();
    }

    public boolean kp() {
        return this.n.u();
    }

    public int l() {
        return this.n.pn();
    }

    public int lo() {
        return this.n.xd();
    }

    public int lr() {
        return this.n.ej();
    }

    public String lt() {
        return this.n.h();
    }

    public int m() {
        return c(this.n.yv());
    }

    public boolean ma() {
        return this.n.yo();
    }

    public int md() {
        return c(this.n.gu());
    }

    public int my() {
        return this.n.jt();
    }

    public float n() {
        return this.n.rh();
    }

    public String nb() {
        return this.n.bx();
    }

    public float nu() {
        return this.n.t();
    }

    public int or() {
        return this.n.uj();
    }

    public double os() {
        return this.n.qp();
    }

    public int oz() {
        return this.n.kz();
    }

    public int p() {
        String strPf = this.n.pf();
        if ("skip-with-time-skip-btn".equals(this.f28295a.getType()) || FreeSpaceBox.TYPE.equals(this.f28295a.getType()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.f28295a.getType())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.f28295a.getType()) && !"skip-with-time".equals(this.f28295a.getType())) {
            if (this.c == 10 && TextUtils.equals(this.n.bx(), "click")) {
                return 5;
            }
            if (hj() && xd()) {
                return 0;
            }
            if (hj()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.f28295a.getType())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strPf) && !strPf.equals("none")) {
                if (strPf.equals("video") || (this.f28295a.c() == 7 && TextUtils.equals(strPf, "normal"))) {
                    return (com.byazt.sr.uj.c() && this.f28295a.n() != null && this.f28295a.n().nl()) ? 11 : 4;
                }
                if (strPf.equals("normal")) {
                    return 1;
                }
                return (strPf.equals("creative") || "slide".equals(this.n.bx())) ? 2 : 0;
            }
        }
        return 0;
    }

    public boolean pf() {
        return this.n.y();
    }

    public boolean pu() {
        return this.n.yo();
    }

    public String q() {
        return this.n.d();
    }

    public String qp() {
        return this.n.da();
    }

    public boolean qy() {
        return this.n.ic();
    }

    public String r() {
        return this.n.hg();
    }

    public int rh() {
        return this.n.az();
    }

    public String rl() {
        return this.n.gr();
    }

    public String s() {
        return this.n.hq();
    }

    public String sl() {
        int i = this.c;
        return (i == 1 || i == 29) ? this.tt : "";
    }

    public int sp() {
        return c(this.n.qy());
    }

    public int sv() {
        return this.n.iu();
    }

    public String t() {
        return this.sp;
    }

    public String tk() {
        return this.n.pl();
    }

    public String to() {
        return this.n.vp();
    }

    public int tt() {
        return (int) this.n.nu();
    }

    public int tx() {
        return this.n.or();
    }

    public double u() {
        if (this.c == 11) {
            try {
                double d = Double.parseDouble(this.tt);
                return !com.byazt.sr.uj.c() ? (int) d : d;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public int uj() {
        return (int) this.n.m();
    }

    public double v() {
        return this.n.cu();
    }

    public int ve() {
        return (int) this.n.z();
    }

    public int x() {
        String strRl = this.n.rl();
        if ("left".equals(strRl)) {
            return 17;
        }
        if ("center".equals(strRl)) {
            return 4;
        }
        return "right".equals(strRl) ? 3 : 2;
    }

    public boolean y() {
        return this.n.ny();
    }

    public String yf() {
        return this.n.zm();
    }

    public double yp() {
        return this.n.my();
    }

    public long yv() {
        return this.n.nc();
    }

    public float z() {
        return this.n.sl();
    }

    public int zb() {
        return this.n.n();
    }

    public String zm() {
        return this.n.iy();
    }

    public static float[] tt(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        return (strArrSplit == null || strArrSplit.length != 4) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
    }

    public void c(float f) {
        this.n.c(f);
    }

    public static int c(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals(RVStartParams.KEY_TRANSPARENT)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith(un1.b) && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2])) | 0;
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public boolean c(int i) {
        n nVar = this.f28295a;
        if (nVar == null) {
            return false;
        }
        if (i == 1) {
            this.n = nVar.sp();
        } else {
            this.n = nVar.n();
        }
        return this.n != null;
    }
}
