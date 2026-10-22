package com.byazt.ete;

import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.struct.AliyunLogKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 42})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f28494a;
    public final int[] c;
    public final boolean d;
    public final long da;
    public int gr;
    public final String gt;
    public int gu;
    public int h;
    public final long i;
    public final float m;
    public byte md;
    public final String my;
    public final float n;
    public final int nu;
    public byte p;
    public SparseArray<com.byazt.hkv.uj.c> qy;
    public final String rh;
    public final String rl;
    public final int sl;
    public final float sp;
    public final int t;
    public final int[] tt;
    public final int u;
    public final int[] uj;
    public final int[] ve;
    public final float x;
    public final float yp;
    public int yv;
    public final int z;
    public String zm;

    @com.byazt.zqa.c(c = {0, 1, 8, 64})
    public static class c {
        public float c;
        public int[] da;
        public String gt;
        public String my;
        public SparseArray<com.byazt.hkv.uj.c> nu;
        public String qy;
        public int rh;
        public String rl;
        public int[] sl;
        public int[] t;
        public int tt;
        public int[] u;
        public float ve;
        public String zm;
        public long uj = -1;
        public long n = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f28495a = -1.0f;
        public float sp = -1.0f;
        public float x = -1.0f;
        public float i = -1.0f;
        public int yp = -1;
        public int z = -1;
        public int m = -1024;
        public int gu = -1;
        public int gr = -1;
        public int yv = -1;
        public boolean p = false;
        public byte md = 0;
        public byte h = -1;
        public int d = Integer.MIN_VALUE;

        public c a(float f) {
            this.i = f;
            return this;
        }

        public c c(int i) {
            this.d = i;
            return this;
        }

        public c i(int i) {
            this.yv = i;
            return this;
        }

        public c n(float f) {
            this.x = f;
            return this;
        }

        public c sp(int i) {
            this.gu = i;
            return this;
        }

        public c tt(byte b) {
            this.md = b;
            return this;
        }

        public c uj(float f) {
            this.sp = f;
            return this;
        }

        public c ve(int i) {
            this.rh = i;
            return this;
        }

        public c x(int i) {
            this.gr = i;
            return this;
        }

        public c a(int i) {
            this.m = i;
            return this;
        }

        public c c(byte b) {
            this.h = b;
            return this;
        }

        public c n(int i) {
            this.z = i;
            return this;
        }

        public c tt(int i) {
            this.tt = i;
            return this;
        }

        public c uj(int[] iArr) {
            this.u = iArr;
            return this;
        }

        public c ve(float f) {
            this.f28495a = f;
            return this;
        }

        public c c(float f) {
            this.c = f;
            return this;
        }

        public c n(String str) {
            this.zm = str;
            return this;
        }

        public c tt(float f) {
            this.ve = f;
            return this;
        }

        public c uj(int i) {
            this.yp = i;
            return this;
        }

        public c ve(int[] iArr) {
            this.t = iArr;
            return this;
        }

        public c c(SparseArray<com.byazt.hkv.uj.c> sparseArray) {
            this.nu = sparseArray;
            return this;
        }

        public c tt(long j) {
            this.n = j;
            return this;
        }

        public c uj(String str) {
            this.qy = str;
            return this;
        }

        public c ve(String str) {
            this.rl = str;
            return this;
        }

        public c c(long j) {
            this.uj = j;
            return this;
        }

        public c tt(int[] iArr) {
            this.sl = iArr;
            return this;
        }

        public c c(int[] iArr) {
            this.da = iArr;
            return this;
        }

        public c tt(String str) {
            this.gt = str;
            return this;
        }

        public c c(String str) {
            this.my = str;
            return this;
        }

        public c c(boolean z) {
            this.p = z;
            return this;
        }

        public i c() {
            return new i(this);
        }
    }

    public JSONObject c(ic icVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.c;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.c[1]));
            }
            int[] iArr2 = this.tt;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.tt[1]));
            }
            int[] iArr3 = this.ve;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.ve[1]));
            }
            int[] iArr4 = this.uj;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.uj[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.qy != null) {
                for (int i = 0; i < this.qy.size(); i++) {
                    com.byazt.hkv.uj.c cVarValueAt = this.qy.valueAt(i);
                    if (cVarValueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(cVarValueAt.ve)).putOpt("mr", Double.valueOf(cVarValueAt.tt)).putOpt(TypedValues.CycleType.S_WAVE_PHASE, Integer.valueOf(cVarValueAt.c)).putOpt("ts", Long.valueOf(cVarValueAt.uj));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.nu)).putOpt(AliyunLogCommon.LogLevel.INFO, jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.n)).putOpt("down_y", Float.toString(this.f28494a)).putOpt("up_x", Float.toString(this.sp)).putOpt("up_y", Float.toString(this.x)).putOpt("down_time", Long.valueOf(this.i)).putOpt("up_time", Long.valueOf(this.da)).putOpt("toolType", Integer.valueOf(this.sl)).putOpt("deviceId", Integer.valueOf(this.t)).putOpt("source", Integer.valueOf(this.u)).putOpt("density", Float.valueOf(this.yp)).putOpt("densityDpi", Integer.valueOf(this.z)).putOpt("scaleDensity", Float.valueOf(this.m)).putOpt(AliyunLogKey.KEY_FILE_TYPE, jSONObject2).putOpt("click_area_type", this.rh).putOpt("areaType", this.my).putOpt("rectInfo", this.rl).putOpt("click_area_id", this.gt);
            int i2 = this.gu;
            if (i2 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i2));
            }
            int i3 = this.gr;
            if (i3 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i3));
            }
            int i4 = this.yv;
            if (i4 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i4)).putOpt("dpa_pid", this.zm);
            }
            if (this.d) {
                jSONObject.put(RequestParameters.SUBRESOURCE_REFERER, "directDownload");
            }
            jSONObject.putOpt("convert_type", Byte.valueOf(this.p));
            byte b = this.md;
            if (b != -1) {
                jSONObject.putOpt("biz_type", Byte.valueOf(b));
            }
            int i5 = this.h;
            if (i5 != Integer.MIN_VALUE) {
                jSONObject.putOpt("fail_status", Integer.valueOf(i5));
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private i(c cVar) {
        this.gr = -1;
        this.yv = -1;
        this.md = (byte) -1;
        this.h = Integer.MIN_VALUE;
        this.c = cVar.sl;
        this.tt = cVar.t;
        this.uj = cVar.u;
        this.ve = cVar.da;
        this.n = cVar.i;
        this.f28494a = cVar.x;
        this.sp = cVar.sp;
        this.x = cVar.f28495a;
        this.i = cVar.n;
        this.da = cVar.uj;
        this.sl = cVar.yp;
        this.t = cVar.z;
        this.u = cVar.m;
        this.yp = cVar.c;
        this.rh = cVar.my;
        this.my = cVar.gt;
        this.rl = cVar.qy;
        this.gt = cVar.rl;
        this.z = cVar.tt;
        this.m = cVar.ve;
        this.nu = cVar.rh;
        this.qy = cVar.nu;
        this.gu = cVar.gu;
        this.gr = cVar.gr;
        this.zm = cVar.zm;
        this.yv = cVar.yv;
        this.d = cVar.p;
        this.p = cVar.md;
        this.md = cVar.h;
        this.h = cVar.d;
    }
}
