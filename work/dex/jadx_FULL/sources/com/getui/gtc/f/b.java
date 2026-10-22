package com.getui.gtc.f;

import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.api.OnDycEnableChangedListener;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b {
    private static final b c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<OnDycEnableChangedListener> f30356a = new ArrayList();
    public final AtomicBoolean b = new AtomicBoolean(false);

    private b() {
    }

    public static b a() {
        return c;
    }

    public static String a(Map<String, Boolean> map) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = {"dim-2-1-21-5", "dim-2-1-21-3", "dim-2-1-21-1", "dim-2-1-21-2"};
        for (int i = 0; i < 4; i++) {
            Boolean bool = map.get(strArr[i]);
            sb.append((bool == null || !bool.booleanValue()) ? "0" : "1");
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:153:0x0269  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Map<String, Boolean> b(Map<String, String> map) {
        HashMap map2;
        HashMap map3;
        String str = u15.f19942b;
        HashMap map4 = new HashMap();
        try {
            String str2 = map.get("sdk.gtc.dim.sys.call.enable");
            if (!TextUtils.isEmpty(str2)) {
                String[] strArrSplit = str2.split(",");
                int length = strArrSplit.length;
                char c2 = 0;
                int i = 0;
                while (i < length) {
                    String str3 = strArrSplit[i];
                    if (str3.contains(str)) {
                        String[] strArrSplit2 = str3.split(str);
                        String str4 = strArrSplit2[c2];
                        ArrayList arrayList = new ArrayList();
                        byte b = 2;
                        String strEncodeToString = Base64.encodeToString(str4.getBytes(), 2);
                        switch (strEncodeToString.hashCode()) {
                            case -2095750756:
                                if (!strEncodeToString.equals("Y2VsbF9pbmZvX25ldw==")) {
                                    b = -1;
                                } else {
                                    b = MaterialProgressDrawable.c;
                                }
                                break;
                            case -2048226647:
                                if (!strEncodeToString.equals("bmV0d29yaw==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.D;
                                }
                                break;
                            case -1779042063:
                                if (!strEncodeToString.equals("b2FpZF9ob25vcg==")) {
                                    b = -1;
                                } else {
                                    b = 17;
                                }
                                break;
                            case -1767879989:
                                if (!strEncodeToString.equals("bWFudWZhY3R1cmVy")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.A;
                                }
                                break;
                            case -1762514687:
                                if (!strEncodeToString.equals("b2FpZA==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.r;
                                }
                                break;
                            case -1659575288:
                                if (!strEncodeToString.equals("d2lmaV9pbmZvX2d0")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.g;
                                }
                                break;
                            case -1559644363:
                                if (!strEncodeToString.equals("Z2V0dWlfZGV2aWNlX2lk")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.o;
                                }
                                break;
                            case -1464199328:
                                if (!strEncodeToString.equals("aWNjaWRfbWFpbg==")) {
                                    b = -1;
                                } else {
                                    b = 9;
                                }
                                break;
                            case -1400038172:
                                if (!strEncodeToString.equals("bWFjX3dsYW4w")) {
                                    b = -1;
                                } else {
                                    b = 13;
                                }
                                break;
                            case -1337142239:
                                if (!strEncodeToString.equals("aW1laQ==")) {
                                    b = -1;
                                } else {
                                    b = c2;
                                }
                                break;
                            case -1337139108:
                                if (!strEncodeToString.equals("aW1laTE=")) {
                                    b = -1;
                                }
                                break;
                            case -1337138984:
                                if (!strEncodeToString.equals("aW1laTI=")) {
                                    b = -1;
                                } else {
                                    b = 3;
                                }
                                break;
                            case -1324212945:
                                if (!strEncodeToString.equals("aW1zaQ==")) {
                                    b = -1;
                                } else {
                                    b = 4;
                                }
                                break;
                            case -1324209814:
                                if (!strEncodeToString.equals("aW1zaTE=")) {
                                    b = -1;
                                } else {
                                    b = 6;
                                }
                                break;
                            case -1324209690:
                                if (!strEncodeToString.equals("aW1zaTI=")) {
                                    b = -1;
                                } else {
                                    b = 7;
                                }
                                break;
                            case -1218674678:
                                if (!strEncodeToString.equals("YWR2ZXJ0aXNpbmdfaWQ=")) {
                                    b = -1;
                                } else {
                                    b = 19;
                                }
                                break;
                            case -1217318981:
                                if (!strEncodeToString.equals("d2lmaV9zY2FuX2xpc3Q=")) {
                                    b = -1;
                                } else {
                                    b = 35;
                                }
                                break;
                            case -1033769178:
                                if (!strEncodeToString.equals("c2VyaWFsX251bWJlcg==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.q;
                                }
                                break;
                            case -997367387:
                                if (!strEncodeToString.equals("bG9jYXRpb25fZ3Bz")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.H;
                                }
                                break;
                            case -814408606:
                                if (!strEncodeToString.equals("d2lmaV9pbmZv")) {
                                    b = -1;
                                } else {
                                    b = 34;
                                }
                                break;
                            case -811004243:
                                if (!strEncodeToString.equals("d2lmaV9tYWM=")) {
                                    b = -1;
                                } else {
                                    b = 36;
                                }
                                break;
                            case -508737516:
                                if (!strEncodeToString.equals("aWNjaWQ=")) {
                                    b = -1;
                                } else {
                                    b = 8;
                                }
                                break;
                            case -508737457:
                                if (!strEncodeToString.equals("aWNjaWQx")) {
                                    b = -1;
                                } else {
                                    b = 10;
                                }
                                break;
                            case -508737456:
                                if (!strEncodeToString.equals("aWNjaWQy")) {
                                    b = -1;
                                } else {
                                    b = 11;
                                }
                                break;
                            case -367876355:
                                if (!strEncodeToString.equals("bG9jYXRpb25fbmV0d29yaw==")) {
                                    b = -1;
                                } else {
                                    b = 31;
                                }
                                break;
                            case -17088614:
                                if (!strEncodeToString.equals("aXB2NA==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.F;
                                }
                                break;
                            case -17052096:
                                if (!strEncodeToString.equals("aXB2Ng==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.G;
                                }
                                break;
                            case 2976371:
                                if (!strEncodeToString.equals("aXA=")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.E;
                                }
                                break;
                            case 3001790:
                                if (!strEncodeToString.equals("c3lz")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.B;
                                }
                                break;
                            case 3005401:
                                if (!strEncodeToString.equals("bWFj")) {
                                    b = -1;
                                } else {
                                    b = 12;
                                }
                                break;
                            case 3055941:
                                if (!strEncodeToString.equals("cm9t")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.z;
                                }
                                break;
                            case 79802473:
                                if (!strEncodeToString.equals("YXBwX2xpc3RfYnlfbG9jYWxfZGlycw==")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.l;
                                }
                                break;
                            case 142694456:
                                if (!strEncodeToString.equals("YXBwX2xpc3RfYnlfY29tcGxleF9wb2xpY3k=")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.n;
                                }
                                break;
                            case 193136789:
                                if (!strEncodeToString.equals("Y2VsbA==")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.h;
                                }
                                break;
                            case 261839736:
                                if (!strEncodeToString.equals("Y2VsbF9pbmZv")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.i;
                                }
                                break;
                            case 308427546:
                                if (!strEncodeToString.equals("Y2Fycmllcg==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.C;
                                }
                                break;
                            case 372428747:
                                if (!strEncodeToString.equals("bG9jYXRpb25fZ3BzX2d0")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.e;
                                }
                                break;
                            case 633576810:
                                if (!strEncodeToString.equals("bW9kZWw=")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.y;
                                }
                                break;
                            case 1148798111:
                                if (!strEncodeToString.equals("bWFjX2FsbA==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.p;
                                }
                                break;
                            case 1196833449:
                                if (!strEncodeToString.equals("bG9jYXRpb25fbmV0d29ya19ndA==")) {
                                    b = -1;
                                } else {
                                    b = 32;
                                }
                                break;
                            case 1321129970:
                                if (!strEncodeToString.equals("YXBwX2xpc3RfYnlfcXVlcnlfaW50ZW50")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.j;
                                }
                                break;
                            case 1396586978:
                                if (!strEncodeToString.equals("YXBwX2xpc3RfYnlfcG1fbGlzdA==")) {
                                    b = -1;
                                } else {
                                    b = com.google.android.exoplayer2.text.cea.a.m;
                                }
                                break;
                            case 1444607276:
                                if (!strEncodeToString.equals("YXBwX2xpc3RfYnlfaW5zdGFsbGVkX3BhY2thZ2U=")) {
                                    b = -1;
                                } else {
                                    b = 42;
                                }
                                break;
                            case 1550084458:
                                if (!strEncodeToString.equals("YnJhbmQ=")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.x;
                                }
                                break;
                            case 1550874440:
                                if (!strEncodeToString.equals("aW1laV9tYWlu")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            case 1846142911:
                                if (!strEncodeToString.equals("YW5kcm9pZF9pZA==")) {
                                    b = -1;
                                } else {
                                    b = com.google.common.base.a.u;
                                }
                                break;
                            case 2016315734:
                                if (!strEncodeToString.equals("aW1zaV9tYWlu")) {
                                    b = -1;
                                } else {
                                    b = 5;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        String str5 = "dim-2-1-6-1";
                        HashMap map5 = map4;
                        switch (b) {
                            case 0:
                                arrayList.add("dim-2-1-1-1");
                                arrayList.add("dim-2-1-1-3");
                                arrayList.add("dim-2-1-1-4");
                                break;
                            case 1:
                                arrayList.add("dim-2-1-1-1");
                                break;
                            case 2:
                                str5 = "dim-2-1-1-3";
                                arrayList.add(str5);
                                break;
                            case 3:
                                arrayList.add("dim-2-1-1-4");
                                break;
                            case 4:
                                arrayList.add("dim-2-1-2-1");
                                arrayList.add("dim-2-1-2-3");
                                arrayList.add("dim-2-1-2-4");
                                break;
                            case 5:
                                arrayList.add("dim-2-1-2-1");
                                break;
                            case 6:
                                arrayList.add("dim-2-1-2-3");
                                break;
                            case 7:
                                arrayList.add("dim-2-1-2-4");
                                break;
                            case 8:
                                arrayList.add("dim-2-1-6-1");
                                arrayList.add("dim-2-1-6-3");
                                arrayList.add("dim-2-1-6-4");
                                break;
                            case 9:
                                arrayList.add(str5);
                                break;
                            case 10:
                                arrayList.add("dim-2-1-6-3");
                                break;
                            case 11:
                                arrayList.add("dim-2-1-6-4");
                                break;
                            case 12:
                                arrayList.add("dim-2-1-3-1");
                                arrayList.add("dim-2-1-3-2");
                                break;
                            case 13:
                                arrayList.add("dim-2-1-3-1");
                                break;
                            case 14:
                                arrayList.add("dim-2-1-3-2");
                                break;
                            case 15:
                                str5 = "dim-2-1-4-1";
                                arrayList.add(str5);
                                break;
                            case 16:
                                str5 = "dim-2-1-5-1";
                                arrayList.add(str5);
                                break;
                            case 17:
                                str5 = "dim-2-1-5-2";
                                arrayList.add(str5);
                                break;
                            case 18:
                                str5 = "dim-2-1-7-1";
                                arrayList.add(str5);
                                break;
                            case 19:
                                str5 = "dim-2-1-8-1";
                                arrayList.add(str5);
                                break;
                            case 20:
                                str5 = "dim-2-1-9-1";
                                arrayList.add(str5);
                                break;
                            case 21:
                                str5 = "dim-2-1-10-1";
                                arrayList.add(str5);
                                break;
                            case 22:
                                str5 = "dim-2-1-11-1";
                                arrayList.add(str5);
                                break;
                            case 23:
                                str5 = "dim-2-1-12-1";
                                arrayList.add(str5);
                                break;
                            case 24:
                                str5 = "dim-2-1-13-1";
                                arrayList.add(str5);
                                break;
                            case 25:
                                str5 = "dim-2-1-14-1";
                                arrayList.add(str5);
                                break;
                            case 26:
                                str5 = "dim-2-1-15-1";
                                arrayList.add(str5);
                                break;
                            case 27:
                                arrayList.add("dim-2-1-16-1");
                                arrayList.add("dim-2-1-16-2");
                                break;
                            case 28:
                                arrayList.add("dim-2-1-16-1");
                                break;
                            case 29:
                                arrayList.add("dim-2-1-16-2");
                                break;
                            case 30:
                                str5 = "dim-2-1-17-1";
                                arrayList.add(str5);
                                break;
                            case 31:
                                str5 = "dim-2-1-17-2";
                                arrayList.add(str5);
                                break;
                            case 32:
                                str5 = "dim-2-1-17-4";
                                arrayList.add(str5);
                                break;
                            case 33:
                                str5 = "dim-2-1-17-3";
                                arrayList.add(str5);
                                break;
                            case 34:
                                str5 = "dim-2-1-18-1";
                                arrayList.add(str5);
                                break;
                            case 35:
                                str5 = "dim-2-1-18-2";
                                arrayList.add(str5);
                                break;
                            case 36:
                                str5 = "dim-2-1-18-3";
                                arrayList.add(str5);
                                break;
                            case 37:
                                str5 = "dim-2-1-18-4";
                                arrayList.add(str5);
                                break;
                            case 38:
                                arrayList.add("dim-2-1-19-1");
                                arrayList.add("dim-2-1-19-2");
                                break;
                            case 39:
                                arrayList.add("dim-2-1-19-1");
                                break;
                            case 40:
                                arrayList.add("dim-2-1-19-2");
                                break;
                            case 41:
                                str5 = "dim-2-1-21-1";
                                arrayList.add(str5);
                                break;
                            case 42:
                                str5 = "dim-2-1-21-2";
                                arrayList.add(str5);
                                break;
                            case 43:
                                str5 = "dim-2-1-21-3";
                                arrayList.add(str5);
                                break;
                            case 44:
                                str5 = "dim-2-1-21-5";
                                arrayList.add(str5);
                                break;
                            case 45:
                                str5 = "dim-2-1-21-4";
                                arrayList.add(str5);
                                break;
                            case 46:
                                str5 = "dim-2-1-22-1";
                                arrayList.add(str5);
                                break;
                        }
                        try {
                            int i2 = Integer.parseInt(strArrSplit2[1]);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                map2 = map5;
                                try {
                                    map2.put((String) it.next(), Boolean.valueOf(i2 != 0));
                                    map5 = map2;
                                } catch (Throwable th) {
                                    th = th;
                                    com.getui.gtc.i.c.a.b(th);
                                    return map2;
                                }
                            }
                            map3 = map5;
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = map5;
                        }
                    } else {
                        map3 = map4;
                        map3.put("dim-2-2-0-1", Boolean.valueOf(Integer.parseInt(str3) != 0));
                    }
                    map4 = map3;
                    strArrSplit = strArrSplit;
                    length = length;
                    c2 = 0;
                    i++;
                    str = str;
                }
            }
            return map4;
        } catch (Throwable th3) {
            th = th3;
            map2 = map4;
        }
    }

    public final void a(OnDycEnableChangedListener onDycEnableChangedListener) {
        if (this.b.get() || onDycEnableChangedListener == null) {
            return;
        }
        synchronized (this.f30356a) {
            this.f30356a.add(onDycEnableChangedListener);
        }
    }
}
