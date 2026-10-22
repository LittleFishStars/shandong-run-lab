package com.getui.gtc.dim;

import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.dim.b.c;
import com.getui.gtc.dim.b.d;
import com.getui.gtc.dim.b.e;
import com.getui.gtc.dim.b.g;
import com.getui.gtc.dim.b.h;
import com.getui.gtc.dim.e.b;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.u15;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f30299a;
    private final d b;
    private final g c;
    private final Map<String, Object> d;
    private final Map<String, List<String>> e;
    private final Map<String, Boolean> f;
    private final Map<String, Boolean> g;

    /* JADX INFO: renamed from: com.getui.gtc.dim.a$a, reason: collision with other inner class name */
    public static class C0649a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f30300a = new a(0);
    }

    private a() {
        this.d = new ConcurrentHashMap();
        HashMap map = new HashMap();
        this.e = map;
        this.f = new HashMap();
        this.g = new HashMap();
        this.f30299a = c.a();
        this.b = d.a.f30307a;
        this.c = g.d();
        map.put("dim-2-1-21-4", Arrays.asList("dim-2-1-21-5", "dim-2-1-21-3", "dim-2-1-21-1", "dim-2-1-21-2"));
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private void a(String str, int i) {
        this.f.put(str, Boolean.valueOf(i != 0));
        b.a("dim use expired enable set: " + str + " : " + i);
    }

    private boolean a(String str) {
        Boolean bool = this.f.get(str);
        if (bool == null) {
            bool = this.f.get("dim-2-2-0-1");
        }
        boolean zB = b(str);
        boolean zBooleanValue = bool != null ? bool.booleanValue() : zB;
        b.a("dim use expired enable check for " + str + ", dycValue = " + bool + ", localValue = " + zB + ", use " + zBooleanValue);
        return zBooleanValue;
    }

    private void b(String str, int i) {
        this.g.put(str, Boolean.valueOf(i != 0));
        b.a("dim skip cache enable set: " + str + " : " + i);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean b(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 1672919129:
                if (str.equals("dim-2-1-1-1")) {
                    b = 0;
                }
                break;
            case 1672919131:
                if (str.equals("dim-2-1-1-3")) {
                    b = 1;
                }
                break;
            case 1672919132:
                if (str.equals("dim-2-1-1-4")) {
                    b = 2;
                }
                break;
            case 1672920090:
                if (str.equals("dim-2-1-2-1")) {
                    b = 3;
                }
                break;
            case 1672920092:
                if (str.equals("dim-2-1-2-3")) {
                    b = 4;
                }
                break;
            case 1672920093:
                if (str.equals("dim-2-1-2-4")) {
                    b = 5;
                }
                break;
            case 1672921051:
                if (str.equals("dim-2-1-3-1")) {
                    b = 6;
                }
                break;
            case 1672921052:
                if (str.equals("dim-2-1-3-2")) {
                    b = 7;
                }
                break;
            case 1672922012:
                if (str.equals("dim-2-1-4-1")) {
                    b = 8;
                }
                break;
            case 1672922973:
                if (str.equals("dim-2-1-5-1")) {
                    b = 9;
                }
                break;
            case 1672923934:
                if (str.equals("dim-2-1-6-1")) {
                    b = 10;
                }
                break;
            case 1672923936:
                if (str.equals("dim-2-1-6-3")) {
                    b = 11;
                }
                break;
            case 1672923937:
                if (str.equals("dim-2-1-6-4")) {
                    b = 12;
                }
                break;
            case 1672924895:
                if (str.equals("dim-2-1-7-1")) {
                    b = 13;
                }
                break;
            case 1672925856:
                if (str.equals("dim-2-1-8-1")) {
                    b = com.google.common.base.a.p;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        byte b = 2;
        String strEncodeToString = Base64.encodeToString(str.getBytes(), 2);
        strEncodeToString.hashCode();
        switch (strEncodeToString.hashCode()) {
            case -2095750756:
                b = !strEncodeToString.equals("Y2VsbF9pbmZvX25ldw==") ? (byte) -1 : (byte) 0;
                break;
            case -2048226647:
                b = !strEncodeToString.equals("bmV0d29yaw==") ? (byte) -1 : (byte) 1;
                break;
            case -1779042063:
                if (!strEncodeToString.equals("b2FpZF9ob25vcg==")) {
                    b = -1;
                }
                break;
            case -1767879989:
                b = !strEncodeToString.equals("bWFudWZhY3R1cmVy") ? (byte) -1 : (byte) 3;
                break;
            case -1762514687:
                b = !strEncodeToString.equals("b2FpZA==") ? (byte) -1 : (byte) 4;
                break;
            case -1659575288:
                b = !strEncodeToString.equals("d2lmaV9pbmZvX2d0") ? (byte) -1 : (byte) 5;
                break;
            case -1559644363:
                b = !strEncodeToString.equals("Z2V0dWlfZGV2aWNlX2lk") ? (byte) -1 : (byte) 6;
                break;
            case -1464199328:
                b = !strEncodeToString.equals("aWNjaWRfbWFpbg==") ? (byte) -1 : (byte) 7;
                break;
            case -1400038172:
                b = !strEncodeToString.equals("bWFjX3dsYW4w") ? (byte) -1 : (byte) 8;
                break;
            case -1337142239:
                b = !strEncodeToString.equals("aW1laQ==") ? (byte) -1 : (byte) 9;
                break;
            case -1337139108:
                b = !strEncodeToString.equals("aW1laTE=") ? (byte) -1 : (byte) 10;
                break;
            case -1337138984:
                b = !strEncodeToString.equals("aW1laTI=") ? (byte) -1 : (byte) 11;
                break;
            case -1324212945:
                b = !strEncodeToString.equals("aW1zaQ==") ? (byte) -1 : (byte) 12;
                break;
            case -1324209814:
                b = !strEncodeToString.equals("aW1zaTE=") ? (byte) -1 : (byte) 13;
                break;
            case -1324209690:
                b = !strEncodeToString.equals("aW1zaTI=") ? (byte) -1 : com.google.common.base.a.p;
                break;
            case -1218674678:
                b = !strEncodeToString.equals("YWR2ZXJ0aXNpbmdfaWQ=") ? (byte) -1 : com.google.common.base.a.q;
                break;
            case -1217318981:
                b = !strEncodeToString.equals("d2lmaV9zY2FuX2xpc3Q=") ? (byte) -1 : com.google.common.base.a.r;
                break;
            case -1033769178:
                b = !strEncodeToString.equals("c2VyaWFsX251bWJlcg==") ? (byte) -1 : (byte) 17;
                break;
            case -997367387:
                b = !strEncodeToString.equals("bG9jYXRpb25fZ3Bz") ? (byte) -1 : com.google.common.base.a.u;
                break;
            case -814408606:
                b = !strEncodeToString.equals("d2lmaV9pbmZv") ? (byte) -1 : (byte) 19;
                break;
            case -811004243:
                b = !strEncodeToString.equals("d2lmaV9tYWM=") ? (byte) -1 : com.google.common.base.a.x;
                break;
            case -508737516:
                b = !strEncodeToString.equals("aWNjaWQ=") ? (byte) -1 : com.google.common.base.a.y;
                break;
            case -508737457:
                b = !strEncodeToString.equals("aWNjaWQx") ? (byte) -1 : com.google.common.base.a.z;
                break;
            case -508737456:
                b = !strEncodeToString.equals("aWNjaWQy") ? (byte) -1 : com.google.common.base.a.A;
                break;
            case -367876355:
                b = !strEncodeToString.equals("bG9jYXRpb25fbmV0d29yaw==") ? (byte) -1 : com.google.common.base.a.B;
                break;
            case -17088614:
                b = !strEncodeToString.equals("aXB2NA==") ? (byte) -1 : com.google.common.base.a.C;
                break;
            case -17052096:
                b = !strEncodeToString.equals("aXB2Ng==") ? (byte) -1 : com.google.common.base.a.D;
                break;
            case 2976371:
                b = !strEncodeToString.equals("aXA=") ? (byte) -1 : com.google.common.base.a.E;
                break;
            case 3001790:
                b = !strEncodeToString.equals("c3lz") ? (byte) -1 : com.google.common.base.a.F;
                break;
            case 3005401:
                b = !strEncodeToString.equals("bWFj") ? (byte) -1 : com.google.common.base.a.G;
                break;
            case 3055941:
                b = !strEncodeToString.equals("cm9t") ? (byte) -1 : com.google.common.base.a.H;
                break;
            case 79802473:
                b = !strEncodeToString.equals("YXBwX2xpc3RfYnlfbG9jYWxfZGlycw==") ? (byte) -1 : (byte) 31;
                break;
            case 142694456:
                b = !strEncodeToString.equals("YXBwX2xpc3RfYnlfY29tcGxleF9wb2xpY3k=") ? (byte) -1 : (byte) 32;
                break;
            case 193136789:
                b = !strEncodeToString.equals("Y2VsbA==") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.e;
                break;
            case 261839736:
                b = !strEncodeToString.equals("Y2VsbF9pbmZv") ? (byte) -1 : (byte) 34;
                break;
            case 308427546:
                b = !strEncodeToString.equals("Y2Fycmllcg==") ? (byte) -1 : (byte) 35;
                break;
            case 372428747:
                b = !strEncodeToString.equals("bG9jYXRpb25fZ3BzX2d0") ? (byte) -1 : (byte) 36;
                break;
            case 633576810:
                b = !strEncodeToString.equals("bW9kZWw=") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.g;
                break;
            case 1148798111:
                b = !strEncodeToString.equals("bWFjX2FsbA==") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.h;
                break;
            case 1196833449:
                b = !strEncodeToString.equals("bG9jYXRpb25fbmV0d29ya19ndA==") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.i;
                break;
            case 1321129970:
                b = !strEncodeToString.equals("YXBwX2xpc3RfYnlfcXVlcnlfaW50ZW50") ? (byte) -1 : MaterialProgressDrawable.c;
                break;
            case 1396586978:
                b = !strEncodeToString.equals("YXBwX2xpc3RfYnlfcG1fbGlzdA==") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.j;
                break;
            case 1444607276:
                b = !strEncodeToString.equals("YXBwX2xpc3RfYnlfaW5zdGFsbGVkX3BhY2thZ2U=") ? (byte) -1 : (byte) 42;
                break;
            case 1550084458:
                b = !strEncodeToString.equals("YnJhbmQ=") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.l;
                break;
            case 1550874440:
                b = !strEncodeToString.equals("aW1laV9tYWlu") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.m;
                break;
            case 1846142911:
                b = !strEncodeToString.equals("YW5kcm9pZF9pZA==") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.n;
                break;
            case 2016315734:
                b = !strEncodeToString.equals("aW1zaV9tYWlu") ? (byte) -1 : com.google.android.exoplayer2.text.cea.a.o;
                break;
            default:
                b = -1;
                break;
        }
        String str2 = "dim-2-1-19-2";
        switch (b) {
            case 0:
                arrayList.add(str2);
                return arrayList;
            case 1:
                str2 = "dim-2-1-15-1";
                arrayList.add(str2);
                return arrayList;
            case 2:
                str2 = "dim-2-1-5-2";
                arrayList.add(str2);
                return arrayList;
            case 3:
                str2 = "dim-2-1-12-1";
                arrayList.add(str2);
                return arrayList;
            case 4:
                str2 = "dim-2-1-5-1";
                arrayList.add(str2);
                return arrayList;
            case 5:
                str2 = "dim-2-1-18-4";
                arrayList.add(str2);
                return arrayList;
            case 6:
                str2 = "dim-2-1-22-1";
                arrayList.add(str2);
                return arrayList;
            case 7:
                arrayList.add("dim-2-1-6-1");
                return arrayList;
            case 8:
                arrayList.add("dim-2-1-3-1");
                return arrayList;
            case 9:
                arrayList.add("dim-2-1-1-1");
                arrayList.add("dim-2-1-1-3");
                arrayList.add("dim-2-1-1-4");
                return arrayList;
            case 10:
                str2 = "dim-2-1-1-3";
                arrayList.add(str2);
                return arrayList;
            case 11:
                arrayList.add("dim-2-1-1-4");
                return arrayList;
            case 12:
                arrayList.add("dim-2-1-2-1");
                arrayList.add("dim-2-1-2-3");
                arrayList.add("dim-2-1-2-4");
                return arrayList;
            case 13:
                arrayList.add("dim-2-1-2-3");
                return arrayList;
            case 14:
                arrayList.add("dim-2-1-2-4");
                return arrayList;
            case 15:
                str2 = "dim-2-1-8-1";
                arrayList.add(str2);
                return arrayList;
            case 16:
                str2 = "dim-2-1-18-2";
                arrayList.add(str2);
                return arrayList;
            case 17:
                str2 = "dim-2-1-4-1";
                arrayList.add(str2);
                return arrayList;
            case 18:
                str2 = "dim-2-1-17-1";
                arrayList.add(str2);
                return arrayList;
            case 19:
                str2 = "dim-2-1-18-1";
                arrayList.add(str2);
                return arrayList;
            case 20:
                str2 = "dim-2-1-18-3";
                arrayList.add(str2);
                return arrayList;
            case 21:
                arrayList.add("dim-2-1-6-1");
                arrayList.add("dim-2-1-6-3");
                arrayList.add("dim-2-1-6-4");
                return arrayList;
            case 22:
                arrayList.add("dim-2-1-6-3");
                return arrayList;
            case 23:
                arrayList.add("dim-2-1-6-4");
                return arrayList;
            case 24:
                str2 = "dim-2-1-17-2";
                arrayList.add(str2);
                return arrayList;
            case 25:
                arrayList.add("dim-2-1-16-1");
                return arrayList;
            case 26:
                arrayList.add("dim-2-1-16-2");
                return arrayList;
            case 27:
                arrayList.add("dim-2-1-16-1");
                arrayList.add("dim-2-1-16-2");
                return arrayList;
            case 28:
                str2 = "dim-2-1-13-1";
                arrayList.add(str2);
                return arrayList;
            case 29:
                arrayList.add("dim-2-1-3-1");
                arrayList.add("dim-2-1-3-2");
                return arrayList;
            case 30:
                str2 = "dim-2-1-11-1";
                arrayList.add(str2);
                return arrayList;
            case 31:
                str2 = "dim-2-1-21-3";
                arrayList.add(str2);
                return arrayList;
            case 32:
                str2 = "dim-2-1-21-4";
                arrayList.add(str2);
                return arrayList;
            case 33:
                arrayList.add("dim-2-1-19-1");
                arrayList.add(str2);
                return arrayList;
            case 34:
                arrayList.add("dim-2-1-19-1");
                return arrayList;
            case 35:
                str2 = "dim-2-1-14-1";
                arrayList.add(str2);
                return arrayList;
            case 36:
                str2 = "dim-2-1-17-3";
                arrayList.add(str2);
                return arrayList;
            case 37:
                str2 = "dim-2-1-10-1";
                arrayList.add(str2);
                return arrayList;
            case 38:
                arrayList.add("dim-2-1-3-2");
                return arrayList;
            case 39:
                str2 = "dim-2-1-17-4";
                arrayList.add(str2);
                return arrayList;
            case 40:
                str2 = "dim-2-1-21-1";
                arrayList.add(str2);
                return arrayList;
            case 41:
                str2 = "dim-2-1-21-5";
                arrayList.add(str2);
                return arrayList;
            case 42:
                str2 = "dim-2-1-21-2";
                arrayList.add(str2);
                return arrayList;
            case 43:
                str2 = "dim-2-1-9-1";
                arrayList.add(str2);
                return arrayList;
            case 44:
                arrayList.add("dim-2-1-1-1");
                return arrayList;
            case 45:
                str2 = "dim-2-1-7-1";
                arrayList.add(str2);
                return arrayList;
            case 46:
                arrayList.add("dim-2-1-2-1");
                return arrayList;
            default:
                return arrayList;
        }
    }

    private void c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.e.put(str, arrayList);
        for (String str3 : str2.split(",")) {
            arrayList.add(str3.trim().toLowerCase());
        }
        b.a("dim complex policy set: " + str + " : " + str2);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00dc  */
    public final Object a(DimRequest dimRequest, boolean z) {
        boolean z2;
        if (dimRequest == null || TextUtils.isEmpty(dimRequest.getKey())) {
            return null;
        }
        b.a(dimRequest.toString());
        String key = dimRequest.getKey();
        boolean z3 = false;
        if (z && this.e.containsKey(key)) {
            List<String> list = this.e.get(dimRequest.getKey());
            if (list == null || list.size() <= 0) {
                b.b("dim not found subKeys for " + dimRequest.getKey());
            } else {
                for (String str : list) {
                    DimRequest dimRequestBuild = new DimRequest.Builder(dimRequest).build();
                    dimRequestBuild.setKey(str);
                    Object objA = a(dimRequestBuild, false);
                    if (com.getui.gtc.dim.e.c.a(objA)) {
                        return objA;
                    }
                }
            }
            return null;
        }
        synchronized (this.d) {
            if (this.d.get(key) == null) {
                this.d.put(key, new Object());
            }
        }
        synchronized (this.d.get(key)) {
            if (dimRequest.isSkipCache()) {
                Boolean bool = this.g.get(key);
                if (bool == null) {
                    bool = this.g.get("dim-2-2-0-1");
                }
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                b.a("dim skip cache enable check for " + key + ", dycValue = " + bool + ", localValue = false, use " + zBooleanValue);
                if (zBooleanValue) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (z2) {
                e eVarA = this.c.a(dimRequest);
                b.a(key + " skip cache call dim from " + eVarA.f30308a);
                if (!com.getui.gtc.dim.e.c.a(eVarA.b)) {
                    h hVarA = this.f30299a.a(key);
                    if (hVarA == null) {
                        hVarA = d.a(key);
                    }
                    if (hVarA != null && com.getui.gtc.dim.e.c.a(hVarA.f30314a) && (a(key) || !this.b.a(hVarA, key))) {
                        this.f30299a.a(key, hVarA.f30314a, -1L);
                        d.a(key, hVarA.f30314a);
                        b.a(key + " update dim ram and storage result = " + hVarA.f30314a);
                        z3 = true;
                    }
                }
                String str2 = eVarA.f30308a;
                if (!"none".equals(str2)) {
                    if (!z3) {
                        this.f30299a.a(key, eVarA.b, -1L);
                        d.a(key, eVarA.b);
                    }
                    b.a(key + " use dim " + str2 + " result = " + eVarA.b);
                }
                return eVarA.b;
            }
            h hVarA2 = this.f30299a.a(key);
            if (hVarA2 != null && !this.b.a(hVarA2, key)) {
                b.a(key + " use dim ram result = " + hVarA2.f30314a);
                return hVarA2.f30314a;
            }
            h hVarA3 = d.a(key);
            if (hVarA3 != null && !this.b.a(hVarA3, key)) {
                this.f30299a.a(key, hVarA3.f30314a, hVarA3.b);
                b.a(key + " use dim storage result = " + hVarA3.f30314a);
                return hVarA3.f30314a;
            }
            e eVarA2 = this.c.a(dimRequest);
            b.a(key + " call dim from " + eVarA2.f30308a);
            if (!com.getui.gtc.dim.e.c.a(eVarA2.b) && a(key)) {
                if (hVarA2 != null && com.getui.gtc.dim.e.c.a(hVarA2.f30314a)) {
                    this.f30299a.a(key, hVarA2.f30314a, -1L);
                    d.a(key, hVarA2.f30314a);
                    b.a(key + " use dim ram result for reserve = " + hVarA2.f30314a);
                    return hVarA2.f30314a;
                }
                if (hVarA3 != null && com.getui.gtc.dim.e.c.a(hVarA3.f30314a)) {
                    this.f30299a.a(key, hVarA3.f30314a, -1L);
                    d.a(key, hVarA3.f30314a);
                    b.a(key + " use dim storage result for reserve = " + hVarA3.f30314a);
                    return hVarA3.f30314a;
                }
            }
            String str3 = eVarA2.f30308a;
            if (!"none".equals(str3)) {
                this.f30299a.a(key, eVarA2.b, -1L);
                d.a(key, eVarA2.b);
                b.a(key + " use dim " + str3 + " result = " + eVarA2.b);
            }
            return eVarA2.b;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(String str, String str2) {
        byte b;
        try {
            char c = 0;
            char c2 = 1;
            switch (str.hashCode()) {
                case 1673842650:
                    if (str.equals("dim-2-2-1-1")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    break;
                case 1673843611:
                    if (str.equals("dim-2-2-2-1")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    break;
                case 1673844572:
                    if (str.equals("dim-2-2-3-1")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                    break;
                case 1673845533:
                    if (str.equals("dim-2-2-4-1")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0) {
                if (b == 1) {
                    this.c.f(str2);
                    return;
                } else if (b == 2) {
                    this.c.a(Caller.valueOf(str2));
                    return;
                } else {
                    if (b != 3) {
                        return;
                    }
                    com.getui.gtc.dim.b.b.a().a(Long.parseLong(str2));
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                this.c.c(str2);
                try {
                    String strOptString = jSONObject.optString("sdk.gtc.dim.pm.use_uid.policy");
                    if (!TextUtils.isEmpty(strOptString) && !"none".equals(strOptString)) {
                        for (String str3 : strOptString.split(",")) {
                            if (str3.contains(u15.f19942b)) {
                                String[] strArrSplit = str3.split(u15.f19942b);
                                int i = Integer.parseInt(strArrSplit[1]);
                                if ("*".equals(strArrSplit[0])) {
                                    this.c.a("dim-2-2-0-1", i);
                                } else {
                                    this.c.a(strArrSplit[0], i);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    b.a(th);
                }
                try {
                    String strOptString2 = jSONObject.optString("sdk.gtc.dim.storage.valid.time");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        String[] strArrSplit2 = strOptString2.split(",");
                        int length = strArrSplit2.length;
                        int i2 = 0;
                        while (i2 < length) {
                            String str4 = strArrSplit2[i2];
                            if (str4.contains(u15.f19942b)) {
                                String[] strArrSplit3 = str4.split(u15.f19942b);
                                List<String> listC = c(strArrSplit3[c]);
                                long j = Long.parseLong(strArrSplit3[c2]) * 1000;
                                Iterator<String> it = listC.iterator();
                                while (it.hasNext()) {
                                    this.b.a(it.next(), j);
                                }
                            } else {
                                this.b.a("dim-2-2-0-1", Long.parseLong(str4) * 1000);
                            }
                            i2++;
                            c = 0;
                            c2 = 1;
                        }
                    }
                } catch (Throwable th2) {
                    b.a(th2);
                }
                try {
                    String strOptString3 = jSONObject.optString("sdk.gtc.dim.rom.map.extension");
                    if (!TextUtils.isEmpty(strOptString3) && !strOptString3.equals("none")) {
                        for (String str5 : strOptString3.toLowerCase().split(",")) {
                            String[] strArrSplit4 = str5.trim().split(u15.f19942b);
                            if (strArrSplit4.length >= 2) {
                                com.getui.gtc.dim.c.a.f30315a.put(strArrSplit4[0].trim(), strArrSplit4[1].trim());
                                b.a("dim sys rom map set: " + strArrSplit4[0].trim() + u15.f19942b + strArrSplit4[1].trim());
                            }
                        }
                    }
                } catch (Throwable th3) {
                    b.a(th3);
                }
                try {
                    String strOptString4 = jSONObject.optString("sdk.gtc.dim.sys.call.black.version");
                    if (!TextUtils.isEmpty(strOptString4) && !"none".equals(strOptString4)) {
                        for (String str6 : strOptString4.split(",")) {
                            if (str6.contains(u15.f19942b)) {
                                String[] strArrSplit5 = str6.split(u15.f19942b);
                                if ("*".equals(strArrSplit5[0])) {
                                    this.c.e("dim-2-2-0-1", strArrSplit5[1]);
                                } else {
                                    Iterator<String> it2 = c(strArrSplit5[0]).iterator();
                                    while (it2.hasNext()) {
                                        this.c.e(it2.next(), strArrSplit5[1]);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th4) {
                    b.a(th4);
                }
                try {
                    String strOptString5 = jSONObject.optString("sdk.gtc.dim.sys.call.black.model");
                    if (!TextUtils.isEmpty(strOptString5) && !"none".equals(strOptString5)) {
                        for (String str7 : strOptString5.split(",")) {
                            if (str7.contains(u15.f19942b)) {
                                String[] strArrSplit6 = str7.split(u15.f19942b);
                                Iterator<String> it3 = c(strArrSplit6[0]).iterator();
                                while (it3.hasNext()) {
                                    this.c.g(it3.next(), strArrSplit6[1]);
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    b.a(th5);
                }
                try {
                    String strOptString6 = jSONObject.optString("sdk.gtc.dim.sys.call.black.rom");
                    if (!TextUtils.isEmpty(strOptString6) && !"none".equals(strOptString6)) {
                        String[] strArrSplit7 = strOptString6.split(",");
                        int length2 = strArrSplit7.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            String str8 = strArrSplit7[i3];
                            if (str8.contains(u15.f19942b)) {
                                String[] strArrSplit8 = str8.split(u15.f19942b);
                                List<String> listC2 = c(strArrSplit8[0]);
                                for (int i4 = 1; i4 < strArrSplit8.length; i4++) {
                                    Iterator<String> it4 = listC2.iterator();
                                    while (it4.hasNext()) {
                                        String[] strArr = strArrSplit7;
                                        int i5 = length2;
                                        this.c.f(it4.next(), strArrSplit8[i4]);
                                        strArrSplit7 = strArr;
                                        length2 = i5;
                                    }
                                }
                            }
                            i3++;
                            strArrSplit7 = strArrSplit7;
                            length2 = length2;
                        }
                    }
                } catch (Throwable th6) {
                    b.a(th6);
                }
                try {
                    String strOptString7 = jSONObject.optString("sdk.gtc.dim.sys.call.enable");
                    if (!TextUtils.isEmpty(strOptString7)) {
                        for (String str9 : strOptString7.split(",")) {
                            if (str9.contains(u15.f19942b)) {
                                String[] strArrSplit9 = str9.split(u15.f19942b);
                                List<String> listC3 = c(strArrSplit9[0]);
                                int i6 = Integer.parseInt(strArrSplit9[1]);
                                Iterator<String> it5 = listC3.iterator();
                                while (it5.hasNext()) {
                                    this.c.b(it5.next(), i6);
                                }
                            } else {
                                this.c.b("dim-2-2-0-1", Integer.parseInt(str9));
                            }
                        }
                    }
                } catch (Throwable th7) {
                    b.a(th7);
                }
                try {
                    String strOptString8 = jSONObject.optString("sdk.gtc.dim.sys.hw.oaid.enable");
                    if (!TextUtils.isEmpty(strOptString8) && !"none".equals(strOptString8)) {
                        this.c.c(Integer.parseInt(strOptString8));
                    }
                } catch (Throwable th8) {
                    b.a(th8);
                }
                try {
                    String strOptString9 = jSONObject.optString("sdk.gtc.dim.halfclosed.policy");
                    if (!TextUtils.isEmpty(strOptString9) && !"none".equals(strOptString9)) {
                        com.getui.gtc.dim.b.b.a().a(strOptString9);
                    }
                } catch (Throwable th9) {
                    b.a(th9);
                }
                try {
                    String strOptString10 = jSONObject.optString("sdk.gtc.dim.halfclosed.enable");
                    if (!TextUtils.isEmpty(strOptString10) && !"none".equals(strOptString10)) {
                        for (com.getui.gtc.dim.b.b.a aVar : com.getui.gtc.dim.b.b.d(strOptString10)) {
                            if ("all".equals(aVar.f30303a)) {
                                com.getui.gtc.dim.b.b.a().a("dim-2-2-0-1", aVar);
                            } else {
                                Iterator<String> it6 = c(aVar.f30303a).iterator();
                                while (it6.hasNext()) {
                                    com.getui.gtc.dim.b.b.a().a(it6.next(), aVar);
                                }
                            }
                        }
                    }
                } catch (Throwable th10) {
                    b.a(th10);
                }
                try {
                    String strOptString11 = jSONObject.optString("sdk.gtc.dim.sys.call.policy");
                    if (!TextUtils.isEmpty(strOptString11)) {
                        for (String str10 : strOptString11.split(",")) {
                            if (str10.contains(u15.f19942b)) {
                                String[] strArrSplit10 = str10.split(u15.f19942b);
                                List<String> listC4 = c(strArrSplit10[0]);
                                int i7 = Integer.parseInt(strArrSplit10[1]);
                                Iterator<String> it7 = listC4.iterator();
                                while (it7.hasNext()) {
                                    this.c.c(it7.next(), i7);
                                }
                            } else {
                                this.c.c("dim-2-2-0-1", Integer.parseInt(str10));
                            }
                        }
                    }
                } catch (Throwable th11) {
                    b.a(th11);
                }
                try {
                    String strOptString12 = jSONObject.optString("sdk.gtc.dim.use.expired.enable");
                    if (!TextUtils.isEmpty(strOptString12)) {
                        for (String str11 : strOptString12.split(",")) {
                            if (str11.contains(u15.f19942b)) {
                                String[] strArrSplit11 = str11.split(u15.f19942b);
                                List<String> listC5 = c(strArrSplit11[0]);
                                int i8 = Integer.parseInt(strArrSplit11[1]);
                                Iterator<String> it8 = listC5.iterator();
                                while (it8.hasNext()) {
                                    a(it8.next(), i8);
                                }
                            } else {
                                a("dim-2-2-0-1", Integer.parseInt(str11));
                            }
                        }
                    }
                } catch (Throwable th12) {
                    b.a(th12);
                }
                try {
                    String strOptString13 = jSONObject.optString("sdk.gtc.dim.skip.cache.enable");
                    if (!TextUtils.isEmpty(strOptString13)) {
                        for (String str12 : strOptString13.split(",")) {
                            if (str12.contains(u15.f19942b)) {
                                String[] strArrSplit12 = str12.split(u15.f19942b);
                                List<String> listC6 = c(strArrSplit12[0]);
                                int i9 = Integer.parseInt(strArrSplit12[1]);
                                Iterator<String> it9 = listC6.iterator();
                                while (it9.hasNext()) {
                                    b(it9.next(), i9);
                                }
                            } else {
                                b("dim-2-2-0-1", Integer.parseInt(str12));
                            }
                        }
                    }
                } catch (Throwable th13) {
                    b.a(th13);
                }
                try {
                    String strOptString14 = jSONObject.optString("sdk.gtc.dim.sys.call.disallow");
                    if (!TextUtils.isEmpty(strOptString14) && !"*".equals(strOptString14)) {
                        for (String str13 : strOptString14.split(",")) {
                            if (str13.contains(u15.f19942b)) {
                                String[] strArrSplit13 = str13.split(u15.f19942b);
                                Iterator<String> it10 = c(strArrSplit13[0]).iterator();
                                while (it10.hasNext()) {
                                    this.c.c(it10.next(), strArrSplit13[1]);
                                }
                            }
                        }
                    }
                } catch (Throwable th14) {
                    b.a(th14);
                }
                try {
                    String strOptString15 = jSONObject.optString("sdk.gtc.dim.sys.trace.enable");
                    if (!TextUtils.isEmpty(strOptString15) && !"none".equals(strOptString15)) {
                        this.c.b(Integer.parseInt(strOptString15));
                    }
                } catch (Throwable th15) {
                    b.a(th15);
                }
                try {
                    String strOptString16 = jSONObject.optString("sdk.gtc.dim.sys.trace.order");
                    if (!TextUtils.isEmpty(strOptString16)) {
                        for (String str14 : strOptString16.split(",")) {
                            if (str14.contains(u15.f19942b)) {
                                String[] strArrSplit14 = str14.split(u15.f19942b);
                                Iterator<String> it11 = c(strArrSplit14[0]).iterator();
                                while (it11.hasNext()) {
                                    this.c.d(it11.next(), strArrSplit14[1]);
                                }
                            } else {
                                this.c.d("dim-2-2-0-1", str14);
                            }
                        }
                    }
                } catch (Throwable th16) {
                    b.a(th16);
                }
                try {
                    String strOptString17 = jSONObject.optString("sdk.gtc.dim.busi.enable");
                    if (!TextUtils.isEmpty(strOptString17) && !"none".equals(strOptString17)) {
                        this.c.a(Integer.parseInt(strOptString17));
                    }
                } catch (Throwable th17) {
                    b.a(th17);
                }
                try {
                    String strOptString18 = jSONObject.optString("sdk.gtc.dim.al.tech_policy");
                    if (!TextUtils.isEmpty(strOptString18)) {
                        for (String str15 : strOptString18.split(",")) {
                            String[] strArrSplit15 = str15.trim().split("#");
                            if (strArrSplit15.length >= 2) {
                                com.getui.gtc.dim.c.a.b.put(strArrSplit15[0].trim().toLowerCase(), strArrSplit15[1].trim());
                                b.a("dim sys permission map set: " + strArrSplit15[0].trim() + "#" + strArrSplit15[1].trim());
                            }
                        }
                    }
                } catch (Throwable th18) {
                    b.a(th18);
                }
                try {
                    String strOptString19 = jSONObject.optString("sdk.gtc.dim.complex.policy");
                    if (TextUtils.isEmpty(strOptString19) || strOptString19.equals("none")) {
                        return;
                    }
                    for (String str16 : strOptString19.split(",")) {
                        String[] strArrSplit16 = str16.split("#");
                        List<String> listC7 = c(strArrSplit16[0]);
                        String[] strArrSplit17 = strArrSplit16[1].split(u15.f19942b);
                        StringBuilder sb = new StringBuilder();
                        for (String str17 : strArrSplit17) {
                            Iterator<String> it12 = c(str17).iterator();
                            while (it12.hasNext()) {
                                sb.append(it12.next());
                                sb.append(",");
                            }
                        }
                        Iterator<String> it13 = listC7.iterator();
                        while (it13.hasNext()) {
                            c(it13.next(), sb.toString());
                        }
                    }
                } catch (Throwable th19) {
                    b.a(th19);
                }
            } catch (Throwable th20) {
                b.a(th20);
            }
        } catch (Throwable th21) {
            b.b(th21);
        }
    }

    /* JADX WARN: Code duplicated, block: B:99:0x0172  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final boolean a(String str, String str2, String str3) {
        byte b;
        try {
            switch (str.hashCode()) {
                case 378146557:
                    if (!str.equals("dim-2-3-10-1")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 378146558:
                    if (!str.equals("dim-2-3-10-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.B;
                    }
                    break;
                case 378147518:
                    if (!str.equals("dim-2-3-11-1")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 378147519:
                    if (!str.equals("dim-2-3-11-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.C;
                    }
                    break;
                case 378148479:
                    if (!str.equals("dim-2-3-12-1")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.H;
                    }
                    break;
                case 378149440:
                    if (!str.equals("dim-2-3-13-1")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 378149441:
                    if (!str.equals("dim-2-3-13-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.D;
                    }
                    break;
                case 378150401:
                    if (!str.equals("dim-2-3-14-1")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 378150402:
                    if (!str.equals("dim-2-3-14-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.E;
                    }
                    break;
                case 378151362:
                    if (!str.equals("dim-2-3-15-1")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 378151363:
                    if (!str.equals("dim-2-3-15-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.F;
                    }
                    break;
                case 378152323:
                    if (!str.equals("dim-2-3-16-1")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.p;
                    }
                    break;
                case 378152324:
                    if (!str.equals("dim-2-3-16-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.G;
                    }
                    break;
                case 1674766171:
                    if (!str.equals("dim-2-3-1-1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1674766172:
                    if (!str.equals("dim-2-3-1-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.q;
                    }
                    break;
                case 1674767132:
                    if (!str.equals("dim-2-3-2-1")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1674767133:
                    if (!str.equals("dim-2-3-2-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.r;
                    }
                    break;
                case 1674768093:
                    if (!str.equals("dim-2-3-3-1")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 1674768094:
                    if (!str.equals("dim-2-3-3-2")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 1674769054:
                    if (!str.equals("dim-2-3-4-1")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 1674769055:
                    if (!str.equals("dim-2-3-4-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.u;
                    }
                    break;
                case 1674770015:
                    if (!str.equals("dim-2-3-5-1")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 1674770016:
                    if (!str.equals("dim-2-3-5-2")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 1674770976:
                    if (!str.equals("dim-2-3-6-1")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1674770977:
                    if (!str.equals("dim-2-3-6-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.x;
                    }
                    break;
                case 1674771937:
                    if (!str.equals("dim-2-3-7-1")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 1674771938:
                    if (!str.equals("dim-2-3-7-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.y;
                    }
                    break;
                case 1674772898:
                    if (!str.equals("dim-2-3-8-1")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 1674772899:
                    if (!str.equals("dim-2-3-8-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.z;
                    }
                    break;
                case 1674773859:
                    if (!str.equals("dim-2-3-9-1")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 1674773860:
                    if (!str.equals("dim-2-3-9-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.A;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return this.c.a(str, Caller.valueOf(str2), Boolean.parseBoolean(str3));
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    d dVar = this.b;
                    Caller callerValueOf = Caller.valueOf(str2);
                    long j = Long.parseLong(str3);
                    b.a("dim storage caller interval set: " + str + " : " + callerValueOf + " : " + j);
                    com.getui.gtc.dim.b.a aVarA = com.getui.gtc.dim.b.a.a(str);
                    if (aVarA == null || j < aVarA.c || j > aVarA.d) {
                        return false;
                    }
                    dVar.f30306a.put(str + u15.f19942b + callerValueOf.name(), Long.valueOf(j));
                    d.a(str + u15.f19942b + callerValueOf.name(), Long.valueOf(j));
                    return true;
                case 30:
                    return this.c.b(str, Caller.valueOf(str2), Boolean.parseBoolean(str3));
                default:
                    return false;
            }
        } catch (Throwable th) {
            b.b(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:98:0x016c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Serializable b(String str, String str2) {
        byte b;
        try {
            switch (str.hashCode()) {
                case 378146557:
                    if (!str.equals("dim-2-3-10-1")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 378146558:
                    if (!str.equals("dim-2-3-10-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.B;
                    }
                    break;
                case 378147518:
                    if (!str.equals("dim-2-3-11-1")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 378147519:
                    if (!str.equals("dim-2-3-11-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.C;
                    }
                    break;
                case 378148479:
                    if (!str.equals("dim-2-3-12-1")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.H;
                    }
                    break;
                case 378149440:
                    if (!str.equals("dim-2-3-13-1")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 378149441:
                    if (!str.equals("dim-2-3-13-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.D;
                    }
                    break;
                case 378150401:
                    if (!str.equals("dim-2-3-14-1")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case 378150402:
                    if (!str.equals("dim-2-3-14-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.E;
                    }
                    break;
                case 378151362:
                    if (!str.equals("dim-2-3-15-1")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case 378151363:
                    if (!str.equals("dim-2-3-15-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.F;
                    }
                    break;
                case 378152323:
                    if (!str.equals("dim-2-3-16-1")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.p;
                    }
                    break;
                case 378152324:
                    if (!str.equals("dim-2-3-16-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.G;
                    }
                    break;
                case 1674766171:
                    if (!str.equals("dim-2-3-1-1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1674766172:
                    if (!str.equals("dim-2-3-1-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.q;
                    }
                    break;
                case 1674767132:
                    if (!str.equals("dim-2-3-2-1")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1674767133:
                    if (!str.equals("dim-2-3-2-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.r;
                    }
                    break;
                case 1674768093:
                    if (!str.equals("dim-2-3-3-1")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 1674768094:
                    if (!str.equals("dim-2-3-3-2")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 1674769054:
                    if (!str.equals("dim-2-3-4-1")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 1674769055:
                    if (!str.equals("dim-2-3-4-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.u;
                    }
                    break;
                case 1674770015:
                    if (!str.equals("dim-2-3-5-1")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 1674770016:
                    if (!str.equals("dim-2-3-5-2")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 1674770976:
                    if (!str.equals("dim-2-3-6-1")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 1674770977:
                    if (!str.equals("dim-2-3-6-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.x;
                    }
                    break;
                case 1674771937:
                    if (!str.equals("dim-2-3-7-1")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 1674771938:
                    if (!str.equals("dim-2-3-7-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.y;
                    }
                    break;
                case 1674772898:
                    if (!str.equals("dim-2-3-8-1")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 1674772899:
                    if (!str.equals("dim-2-3-8-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.z;
                    }
                    break;
                case 1674773859:
                    if (!str.equals("dim-2-3-9-1")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 1674773860:
                    if (!str.equals("dim-2-3-9-2")) {
                        b = -1;
                    } else {
                        b = com.google.common.base.a.A;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return this.c.b(str, str2);
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    return this.b.a(str, str2);
                case 30:
                    return Boolean.valueOf(this.c.a(str, str2));
                default:
                    return null;
            }
        } catch (Throwable th) {
            b.b(th);
            return null;
        }
    }
}
