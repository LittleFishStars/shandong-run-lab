package com.byazt.dv;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.byazt.eu.n;
import com.byazt.nbs.da;
import com.byazt.nbs.x;
import com.byazt.yl.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1643, 13})
public class tt implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28437a;
    public da c;
    public int i;
    public int n;
    public boolean sp;
    public com.byazt.pq.c tt;
    public String uj;
    public String ve;
    public long x = -1;
    public boolean da = false;

    private tt() {
    }

    public int a() {
        return this.f28437a;
    }

    public String cu() {
        da daVar = this.c;
        return daVar != null ? daVar.bx() : "";
    }

    public double d() {
        da daVar = this.c;
        return daVar != null ? daVar.qy() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public boolean da() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.sv();
        }
        return false;
    }

    public x eo() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.d();
        }
        return null;
    }

    public boolean gr() {
        da daVar = this.c;
        return daVar != null && daVar.my() == 3;
    }

    public int gt() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.yv();
        }
        return 0;
    }

    public boolean gu() {
        da daVar = this.c;
        return daVar != null && daVar.my() == 2;
    }

    public double h() {
        da daVar = this.c;
        return daVar != null ? daVar.rl() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void i() {
        n.c(new Runnable() { // from class: com.byazt.dv.tt.3
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.tt != null) {
                    tt.this.tt.c();
                }
            }
        });
    }

    public String m() {
        da daVar = this.c;
        return daVar != null ? daVar.md() : "";
    }

    public double md() {
        da daVar;
        return (gu() || c() || gr() || (daVar = this.c) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : daVar.gr();
    }

    public int my() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.my();
        }
        return 0;
    }

    public boolean n() {
        return this.sp;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:40:0x004a A[RETURN] */
    public int nb() {
        da daVar = this.c;
        if (daVar == null) {
            return 0;
        }
        int iA = daVar.a();
        switch (this.c.u()) {
            case 1:
                return 20001;
            case 2:
                return 20004;
            case 3:
                return 20007;
            case 4:
            case 6:
            default:
                return 0;
            case 5:
                if (iA == 4) {
                    return 20005;
                }
                if (iA == 5) {
                    return 20002;
                }
                return iA == 3 ? 20001 : 20005;
            case 7:
                if (iA == 6) {
                    return 20006;
                }
                if (iA == 7) {
                    return 20003;
                }
                return iA == 8 ? 20004 : 20006;
            case 8:
                return 20003;
            case 9:
                return 20002;
            case 10:
                if (iA == 1) {
                    return 20004;
                }
                if (iA == 2) {
                    return 20003;
                }
                return 0;
        }
    }

    public String nu() {
        return this.ve;
    }

    public int or() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.i();
        }
        return 0;
    }

    public int p() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.c();
        }
        return 0;
    }

    public boolean pf() {
        return this.da;
    }

    public Object qp() {
        if (gu() && eo() != null) {
            return eo().tt();
        }
        return null;
    }

    public String qy() {
        da daVar = this.c;
        return daVar != null ? daVar.z() : "";
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    public String rh() {
        String str;
        da daVar = this.c;
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
        int iA = this.c.a();
        switch (this.c.u()) {
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

    public int rl() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.p();
        }
        return 0;
    }

    public boolean sl() {
        da daVar = this.c;
        if (daVar != null) {
            return TextUtils.equals(daVar.z(), MediationConstant.ADN_PANGLE);
        }
        return false;
    }

    public int sp() {
        return this.n;
    }

    public String t() {
        da daVar = this.c;
        return daVar != null ? daVar.rh() : "";
    }

    public void tt(int i) {
        this.f28437a = i;
    }

    public String u() {
        da daVar = this.c;
        return daVar != null ? daVar.z() : "";
    }

    public long uj() {
        return this.x;
    }

    public int ve() {
        return this.i;
    }

    public da x() {
        return this.c;
    }

    public int yp() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.da();
        }
        return 0;
    }

    public int yv() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.u();
        }
        return 0;
    }

    public int z() {
        da daVar = this.c;
        if (daVar != null) {
            return daVar.a();
        }
        return 0;
    }

    public String zb() {
        da daVar = this.c;
        return daVar != null ? daVar.yp() : "";
    }

    public String zm() {
        return (gu() && eo() != null) ? eo().da() : "";
    }

    public static tt c(da daVar, com.byazt.pq.c cVar) {
        tt ttVar = new tt();
        ttVar.c = daVar;
        ttVar.tt = cVar;
        return ttVar;
    }

    public void tt(String str) {
        this.uj = str;
    }

    public void ve(int i) {
        this.n = i;
    }

    @Override // com.byazt.dv.c
    public String tt() {
        return this.uj;
    }

    public void tt(boolean z) {
        this.da = z;
    }

    public void c(int i) {
        this.i = i;
    }

    public void c(long j) {
        this.x = j;
    }

    public void c(boolean z) {
        this.sp = z;
    }

    public void c(final List<ve> list, final da daVar) {
        n.c(new Runnable() { // from class: com.byazt.dv.tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.tt != null) {
                    tt.this.tt.c(list, daVar);
                }
            }
        });
    }

    public void c(final com.byazt.pp.c cVar, final da daVar) {
        n.c(new Runnable() { // from class: com.byazt.dv.tt.2
            @Override // java.lang.Runnable
            public void run() {
                if (tt.this.tt != null) {
                    tt.this.tt.c(cVar, daVar);
                }
            }
        });
    }

    public void c(String str) {
        this.ve = str;
    }

    @Override // com.byazt.dv.c
    public boolean c() {
        da daVar = this.c;
        return daVar != null && daVar.my() == 1;
    }
}
