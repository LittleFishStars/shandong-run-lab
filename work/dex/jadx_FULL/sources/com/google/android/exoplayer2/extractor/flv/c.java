package com.google.android.exoplayer2.extractor.flv;

import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.zj.adlib.om6;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c extends TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30647a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f2762a = "onMetaData";
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f2763b = "duration";
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f2764c = "keyframes";
    public static final int d = 3;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f2765d = "filepositions";
    public static final int e = 8;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f2766e = "times";
    public static final int f = 9;
    public static final int g = 10;
    public static final int h = 11;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f2768a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long[] f2769b;

    public c() {
        super(new com.google.android.exoplayer2.extractor.d());
        this.f2767a = -9223372036854775807L;
        this.f2768a = new long[0];
        this.f2769b = new long[0];
    }

    public static Boolean f(om6 om6Var) {
        return Boolean.valueOf(om6Var.G() == 1);
    }

    @Nullable
    public static Object g(om6 om6Var, int i) {
        if (i == 0) {
            return i(om6Var);
        }
        if (i == 1) {
            return f(om6Var);
        }
        if (i == 2) {
            return m(om6Var);
        }
        if (i == 3) {
            return k(om6Var);
        }
        if (i == 8) {
            return j(om6Var);
        }
        if (i == 10) {
            return l(om6Var);
        }
        if (i != 11) {
            return null;
        }
        return h(om6Var);
    }

    public static Date h(om6 om6Var) {
        Date date = new Date((long) i(om6Var).doubleValue());
        om6Var.T(2);
        return date;
    }

    public static Double i(om6 om6Var) {
        return Double.valueOf(Double.longBitsToDouble(om6Var.z()));
    }

    public static HashMap<String, Object> j(om6 om6Var) {
        int iK = om6Var.K();
        HashMap<String, Object> map = new HashMap<>(iK);
        for (int i = 0; i < iK; i++) {
            String strM = m(om6Var);
            Object objG = g(om6Var, n(om6Var));
            if (objG != null) {
                map.put(strM, objG);
            }
        }
        return map;
    }

    public static HashMap<String, Object> k(om6 om6Var) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strM = m(om6Var);
            int iN = n(om6Var);
            if (iN == 9) {
                return map;
            }
            Object objG = g(om6Var, iN);
            if (objG != null) {
                map.put(strM, objG);
            }
        }
    }

    public static ArrayList<Object> l(om6 om6Var) {
        int iK = om6Var.K();
        ArrayList<Object> arrayList = new ArrayList<>(iK);
        for (int i = 0; i < iK; i++) {
            Object objG = g(om6Var, n(om6Var));
            if (objG != null) {
                arrayList.add(objG);
            }
        }
        return arrayList;
    }

    public static String m(om6 om6Var) {
        int iM = om6Var.M();
        int iE = om6Var.e();
        om6Var.T(iM);
        return new String(om6Var.d(), iE, iM);
    }

    public static int n(om6 om6Var) {
        return om6Var.G();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void b() {
    }

    public long c() {
        return this.f2767a;
    }

    public long[] d() {
        return this.f2769b;
    }

    public long[] e() {
        return this.f2768a;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(om6 om6Var) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parsePayload(om6 om6Var, long j) {
        if (n(om6Var) != 2 || !f2762a.equals(m(om6Var)) || om6Var.a() == 0 || n(om6Var) != 8) {
            return false;
        }
        HashMap<String, Object> mapJ = j(om6Var);
        Object obj = mapJ.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.f2767a = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapJ.get(f2764c);
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(f2765d);
            Object obj4 = map.get(f2766e);
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f2768a = new long[size];
                this.f2769b = new long[size];
                for (int i = 0; i < size; i++) {
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f2768a = new long[0];
                        this.f2769b = new long[0];
                        break;
                    }
                    this.f2768a[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f2769b[i] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }
}
