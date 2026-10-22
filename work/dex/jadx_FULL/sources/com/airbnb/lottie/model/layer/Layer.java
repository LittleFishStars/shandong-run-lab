package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.h;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.zj.adlib.c25;
import com.zj.adlib.hs2;
import com.zj.adlib.k35;
import com.zj.adlib.k60;
import com.zj.adlib.m60;
import com.zj.adlib.ps4;
import com.zj.adlib.sy0;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Layer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final h f558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LayerType f559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MatteType f560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final hs2 f561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k35 f562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final k60 f563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final m60 f564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final sy0 f565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<ContentModel> f567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f568a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f569b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f570b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final String f571b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<Mask> f572b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<ps4<Float>> f573c;
    public final int d;
    public final int e;

    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, k35 k35Var, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, m60 m60Var, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable h hVar, @Nullable k60 k60Var, List<ps4<Float>> list3, MatteType matteType, @Nullable b bVar, boolean z, @Nullable sy0 sy0Var, @Nullable hs2 hs2Var) {
        this.f567a = list;
        this.f562a = k35Var;
        this.f566a = str;
        this.f556a = j;
        this.f559a = layerType;
        this.f570b = j2;
        this.f571b = str2;
        this.f572b = list2;
        this.f564a = m60Var;
        this.f555a = i;
        this.f569b = i2;
        this.c = i3;
        this.f23378a = f;
        this.b = f2;
        this.d = i4;
        this.e = i5;
        this.f558a = hVar;
        this.f563a = k60Var;
        this.f573c = list3;
        this.f560a = matteType;
        this.f557a = bVar;
        this.f568a = z;
        this.f565a = sy0Var;
        this.f561a = hs2Var;
    }

    @Nullable
    public sy0 a() {
        return this.f565a;
    }

    public k35 b() {
        return this.f562a;
    }

    @Nullable
    public hs2 c() {
        return this.f561a;
    }

    public long d() {
        return this.f556a;
    }

    public List<ps4<Float>> e() {
        return this.f573c;
    }

    public LayerType f() {
        return this.f559a;
    }

    public List<Mask> g() {
        return this.f572b;
    }

    public MatteType h() {
        return this.f560a;
    }

    public String i() {
        return this.f566a;
    }

    public long j() {
        return this.f570b;
    }

    public int k() {
        return this.e;
    }

    public int l() {
        return this.d;
    }

    @Nullable
    public String m() {
        return this.f571b;
    }

    public List<ContentModel> n() {
        return this.f567a;
    }

    public int o() {
        return this.c;
    }

    public int p() {
        return this.f569b;
    }

    public int q() {
        return this.f555a;
    }

    public float r() {
        return this.b / this.f562a.e();
    }

    @Nullable
    public h s() {
        return this.f558a;
    }

    @Nullable
    public k60 t() {
        return this.f563a;
    }

    public String toString() {
        return y("");
    }

    @Nullable
    public b u() {
        return this.f557a;
    }

    public float v() {
        return this.f23378a;
    }

    public m60 w() {
        return this.f564a;
    }

    public boolean x() {
        return this.f568a;
    }

    public String y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        sb.append("\n");
        Layer layerX = this.f562a.x(j());
        if (layerX != null) {
            sb.append("\t\tParents: ");
            sb.append(layerX.i());
            Layer layerX2 = this.f562a.x(layerX.j());
            while (layerX2 != null) {
                sb.append(c25.j);
                sb.append(layerX2.i());
                layerX2 = this.f562a.x(layerX2.j());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!g().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(g().size());
            sb.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f567a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.f567a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
