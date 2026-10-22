package cj.mobile.wm;

import androidx.camera.video.AudioStats;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex15 implements j {
    public final h[] dexa;
    public final h[] dexb;
    public final Map<String, h> dexc;
    public final Class<?> dexd;
    public final dex16 dexe;
    public ConcurrentMap<String, Object> dexf;
    public transient long[] dexg;
    public transient int[] dexh;

    public dex15(a aVar, Class<?> cls, Type type) {
        this(aVar, cls, type, dex16.dexa(cls, cls.getModifiers(), type, false, true, true, true, aVar.dexd));
    }

    public dex15(a aVar, Class<?> cls, Type type, dex16 dex16Var) {
        this.dexd = cls;
        this.dexe = dex16Var;
        n0[] n0VarArr = dex16Var.dexf;
        this.dexb = new h[n0VarArr.length];
        int length = n0VarArr.length;
        HashMap map = null;
        for (int i = 0; i < length; i++) {
            n0 n0Var = dex16Var.dexf[i];
            h hVarDexa = aVar.dexa(aVar, cls, n0Var);
            this.dexb[i] = hVarDexa;
            for (String str : n0Var.dexp) {
                if (map == null) {
                    map = new HashMap();
                }
                map.put(str, hVarDexa);
            }
        }
        this.dexc = map;
        n0[] n0VarArr2 = dex16Var.dexe;
        this.dexa = new h[n0VarArr2.length];
        int length2 = n0VarArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.dexa[i2] = dexa(dex16Var.dexe[i2].dexa);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 19301. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <T> T dexa(cj.mobile.wm.dex11 r41, java.lang.reflect.Type r42, java.lang.Object r43, java.lang.Object r44) {
        /*
            Method dump skipped, instruction units count: 1930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cj.mobile.wm.dex15.dexa(cj.mobile.wm.dex11, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    private boolean dexa(dex11 dex11Var, String str, Object obj, Type type, Map<String, Object> map) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        h hVarDexa = dexa(str);
        if (hVarDexa == null) {
            hVarDexa = dexb(str);
        }
        int i = com.wangmai.insightvision.openadsdk.d.i.d.q.t;
        if (hVarDexa == null && ((dex11Var.dexe.dexc & i) != 0 || (i & this.dexe.dexm) != 0)) {
            if (this.dexf == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> superclass = this.dexd; superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    for (Field field : superclass.getDeclaredFields()) {
                        String name = field.getName();
                        if (dexa(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.dexf = concurrentHashMap;
            }
            Object obj2 = this.dexf.get(str);
            if (obj2 != null) {
                if (obj2 instanceof h) {
                    hVarDexa = (h) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    hVarDexa = new dex10(dex11Var.dexb, this.dexd, new n0(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.dexf.put(str, hVarDexa);
                }
            }
        }
        if (hVarDexa == null) {
            dexa(dex11Var, obj, str);
            return false;
        }
        dex13Var.dexa(com.google.common.net.c.b);
        hVarDexa.dexa(dex11Var, obj, type, map);
        return true;
    }

    private h dexb(String str) {
        boolean zStartsWith;
        long jDexb = q0.dexb(str);
        int i = 0;
        if (this.dexg == null) {
            long[] jArr = new long[this.dexb.length];
            int i2 = 0;
            while (true) {
                h[] hVarArr = this.dexb;
                if (i2 >= hVarArr.length) {
                    break;
                }
                jArr[i2] = q0.dexb(hVarArr[i2].dexa.dexa);
                i2++;
            }
            Arrays.sort(jArr);
            this.dexg = jArr;
        }
        int iBinarySearch = Arrays.binarySearch(this.dexg, jDexb);
        if (iBinarySearch < 0) {
            zStartsWith = str.startsWith(com.acse.ottn.p3.g);
            if (zStartsWith) {
                iBinarySearch = Arrays.binarySearch(this.dexg, q0.dexb(str.substring(2)));
            }
        } else {
            zStartsWith = false;
        }
        if (iBinarySearch < 0) {
            return null;
        }
        if (this.dexh == null) {
            int[] iArr = new int[this.dexg.length];
            Arrays.fill(iArr, -1);
            while (true) {
                h[] hVarArr2 = this.dexb;
                if (i >= hVarArr2.length) {
                    break;
                }
                int iBinarySearch2 = Arrays.binarySearch(this.dexg, q0.dexb(hVarArr2[i].dexa.dexa));
                if (iBinarySearch2 >= 0) {
                    iArr[iBinarySearch2] = i;
                }
                i++;
            }
            this.dexh = iArr;
        }
        int i3 = this.dexh[iBinarySearch];
        if (i3 == -1) {
            return null;
        }
        h hVar = this.dexb[i3];
        Class<?> cls = hVar.dexa.dexg;
        if (!zStartsWith || cls == Boolean.TYPE || cls == Boolean.class) {
            return hVar;
        }
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:145:0x0241 A[Catch: IllegalAccessException -> 0x02af, TryCatch #0 {IllegalAccessException -> 0x02af, blocks: (B:10:0x0025, B:12:0x0029, B:14:0x0032, B:16:0x0040, B:18:0x0044, B:137:0x0224, B:138:0x0226, B:22:0x0054, B:23:0x0056, B:25:0x0060, B:144:0x023c, B:29:0x0070, B:30:0x0072, B:145:0x0241, B:15:0x0038, B:34:0x0084, B:36:0x0088, B:48:0x00b3, B:50:0x00b7, B:52:0x00c0, B:54:0x00c4, B:57:0x00d0, B:59:0x00d5, B:62:0x00e0, B:51:0x00bd, B:39:0x0091, B:41:0x0095, B:43:0x009d, B:47:0x00b0, B:46:0x00aa, B:63:0x00e3, B:64:0x00fb, B:65:0x00fc, B:67:0x0102, B:69:0x010a, B:71:0x0118, B:73:0x011c, B:76:0x0128, B:77:0x012a, B:79:0x0132, B:82:0x013e, B:83:0x0140, B:70:0x0110, B:84:0x0146, B:86:0x014a, B:88:0x0152, B:90:0x015f, B:92:0x0163, B:95:0x016e, B:97:0x0173, B:100:0x017e, B:89:0x0158, B:101:0x0181, B:103:0x0187, B:105:0x018b, B:114:0x01b6, B:116:0x01bd, B:119:0x01c9, B:121:0x01cf, B:124:0x01db, B:108:0x0195, B:113:0x01a2, B:125:0x01df, B:126:0x01f9, B:129:0x01fe, B:131:0x0204, B:133:0x0214, B:136:0x0220, B:140:0x022c, B:143:0x0238, B:146:0x0245, B:148:0x024b, B:152:0x025e, B:161:0x0286, B:164:0x0291, B:167:0x0298, B:168:0x029d, B:170:0x02a0, B:173:0x02a5, B:174:0x02aa, B:151:0x0258, B:155:0x0269, B:159:0x027c, B:158:0x0276, B:160:0x0283), top: B:188:0x0025 }] */
    private <T> T dexb(dex11 dex11Var, Type type, Object obj, Object obj2) throws com.wangmai.insightvision.openadsdk.d.d {
        int i;
        String str;
        int i2;
        String str2;
        Enum enumValueOf;
        char cCharAt;
        char cCharAt2;
        String strDexb;
        int i3;
        String str3;
        int i4;
        String str4;
        dex13 dex13Var = dex11Var.dexe;
        T t = (T) dexa(dex11Var, type);
        int length = this.dexb.length;
        int i5 = 0;
        while (true) {
            int i6 = 16;
            if (i5 >= length) {
                if (dex13Var.dexd == ',') {
                    int i7 = dex13Var.dexe + 1;
                    dex13Var.dexe = i7;
                    dex13Var.dexd = i7 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i7);
                    dex13Var.dexa = 16;
                } else {
                    dex13Var.dexk();
                }
                return t;
            }
            char c = i5 == length + (-1) ? ']' : ',';
            h hVar = this.dexb[i5];
            n0 n0Var = hVar.dexa;
            Class<?> cls = n0Var.dexg;
            try {
                if (cls == Integer.TYPE) {
                    int iDexn = (int) dex13Var.dexn();
                    if (n0Var.dexd) {
                        n0Var.dexc.setInt(t, iDexn);
                    } else {
                        hVar.dexa(t, new Integer(iDexn));
                    }
                    char c2 = dex13Var.dexd;
                    if (c2 == ',') {
                        i4 = dex13Var.dexe + 1;
                        dex13Var.dexe = i4;
                        if (i4 < dex13Var.dexr) {
                            str4 = dex13Var.dexq;
                            cCharAt2 = str4.charAt(i4);
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        }
                        cCharAt2 = 26;
                        dex13Var.dexd = cCharAt2;
                        dex13Var.dexa = i6;
                    } else {
                        if (c2 == ']') {
                            i3 = dex13Var.dexe + 1;
                            dex13Var.dexe = i3;
                            if (i3 < dex13Var.dexr) {
                                str3 = dex13Var.dexq;
                                cCharAt = str3.charAt(i3);
                                dex13Var.dexd = cCharAt;
                                i6 = 15;
                                dex13Var.dexa = i6;
                            }
                            cCharAt = 26;
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        }
                        dex13Var.dexk();
                    }
                } else if (cls == String.class) {
                    char c3 = dex13Var.dexd;
                    if (c3 != '\"') {
                        if (c3 == 'n') {
                            if (dex13Var.dexq.startsWith("null", dex13Var.dexe)) {
                                int i8 = dex13Var.dexe + 4;
                                dex13Var.dexe = i8;
                                dex13Var.dexd = i8 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i8);
                                strDexb = null;
                            }
                        }
                        throw new com.wangmai.insightvision.openadsdk.d.d("not match string. feild : " + obj);
                    }
                    strDexb = dex13Var.dexb('\"');
                    if (n0Var.dexd) {
                        n0Var.dexc.set(t, strDexb);
                    } else {
                        hVar.dexa(t, strDexb);
                    }
                    char c4 = dex13Var.dexd;
                    if (c4 == ',') {
                        i4 = dex13Var.dexe + 1;
                        dex13Var.dexe = i4;
                        if (i4 >= dex13Var.dexr) {
                            cCharAt2 = 26;
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        } else {
                            str4 = dex13Var.dexq;
                            cCharAt2 = str4.charAt(i4);
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        }
                    } else {
                        if (c4 == ']') {
                            i3 = dex13Var.dexe + 1;
                            dex13Var.dexe = i3;
                            if (i3 >= dex13Var.dexr) {
                                cCharAt = 26;
                                dex13Var.dexd = cCharAt;
                                i6 = 15;
                                dex13Var.dexa = i6;
                            } else {
                                str3 = dex13Var.dexq;
                                cCharAt = str3.charAt(i3);
                                dex13Var.dexd = cCharAt;
                                i6 = 15;
                                dex13Var.dexa = i6;
                            }
                        }
                        dex13Var.dexk();
                    }
                } else if (cls == Long.TYPE) {
                    long jDexn = dex13Var.dexn();
                    if (n0Var.dexd) {
                        n0Var.dexc.setLong(t, jDexn);
                    } else {
                        hVar.dexa(t, new Long(jDexn));
                    }
                    char c5 = dex13Var.dexd;
                    if (c5 == ',') {
                        i2 = dex13Var.dexe + 1;
                        dex13Var.dexe = i2;
                        if (i2 < dex13Var.dexr) {
                            str2 = dex13Var.dexq;
                            cCharAt2 = str2.charAt(i2);
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        }
                        cCharAt2 = 26;
                        dex13Var.dexd = cCharAt2;
                        dex13Var.dexa = i6;
                    } else if (c5 == ']') {
                        i = dex13Var.dexe + 1;
                        dex13Var.dexe = i;
                        if (i < dex13Var.dexr) {
                            str = dex13Var.dexq;
                            cCharAt = str.charAt(i);
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        }
                        cCharAt = 26;
                        dex13Var.dexd = cCharAt;
                        i6 = 15;
                        dex13Var.dexa = i6;
                    } else {
                        dex13Var.dexk();
                    }
                } else if (cls == Boolean.TYPE) {
                    boolean zDexm = dex13Var.dexm();
                    if (n0Var.dexd) {
                        n0Var.dexc.setBoolean(t, zDexm);
                    } else {
                        hVar.dexa(t, Boolean.valueOf(zDexm));
                    }
                    char c6 = dex13Var.dexd;
                    if (c6 == ',') {
                        i2 = dex13Var.dexe + 1;
                        dex13Var.dexe = i2;
                        if (i2 >= dex13Var.dexr) {
                            cCharAt2 = 26;
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        } else {
                            str2 = dex13Var.dexq;
                            cCharAt2 = str2.charAt(i2);
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        }
                    } else if (c6 == ']') {
                        i = dex13Var.dexe + 1;
                        dex13Var.dexe = i;
                        if (i >= dex13Var.dexr) {
                            cCharAt = 26;
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        } else {
                            str = dex13Var.dexq;
                            cCharAt = str.charAt(i);
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        }
                    } else {
                        dex13Var.dexk();
                    }
                } else if (cls.isEnum()) {
                    char c7 = dex13Var.dexd;
                    if (c7 == '\"') {
                        String strDexa = dex13Var.dexa(dex11Var.dexa);
                        enumValueOf = strDexa == null ? null : Enum.valueOf(cls, strDexa);
                    } else {
                        if (c7 < '0' || c7 > '9') {
                            throw new com.wangmai.insightvision.openadsdk.d.d("illegal enum." + dex13Var.dexd());
                        }
                        enumValueOf = ((dex12) ((dex10) hVar).dexa(dex11Var.dexb)).dexc[(int) dex13Var.dexn()];
                    }
                    hVar.dexa(t, enumValueOf);
                    char c8 = dex13Var.dexd;
                    if (c8 == ',') {
                        i2 = dex13Var.dexe + 1;
                        dex13Var.dexe = i2;
                        if (i2 >= dex13Var.dexr) {
                            cCharAt2 = 26;
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        } else {
                            str2 = dex13Var.dexq;
                            cCharAt2 = str2.charAt(i2);
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        }
                    } else if (c8 == ']') {
                        i = dex13Var.dexe + 1;
                        dex13Var.dexe = i;
                        if (i >= dex13Var.dexr) {
                            cCharAt = 26;
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        } else {
                            str = dex13Var.dexq;
                            cCharAt = str.charAt(i);
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        }
                    } else {
                        dex13Var.dexk();
                    }
                } else if (cls == Date.class && dex13Var.dexd == '1') {
                    hVar.dexa(t, new Date(dex13Var.dexn()));
                    char c9 = dex13Var.dexd;
                    if (c9 == ',') {
                        i2 = dex13Var.dexe + 1;
                        dex13Var.dexe = i2;
                        if (i2 >= dex13Var.dexr) {
                            cCharAt2 = 26;
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        } else {
                            str2 = dex13Var.dexq;
                            cCharAt2 = str2.charAt(i2);
                            dex13Var.dexd = cCharAt2;
                            dex13Var.dexa = i6;
                        }
                    } else if (c9 == ']') {
                        i = dex13Var.dexe + 1;
                        dex13Var.dexe = i;
                        if (i >= dex13Var.dexr) {
                            cCharAt = 26;
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        } else {
                            str = dex13Var.dexq;
                            cCharAt = str.charAt(i);
                            dex13Var.dexd = cCharAt;
                            i6 = 15;
                            dex13Var.dexa = i6;
                        }
                    } else {
                        dex13Var.dexk();
                    }
                } else {
                    char c10 = dex13Var.dexd;
                    if (c10 == '[') {
                        int i9 = dex13Var.dexe + 1;
                        dex13Var.dexe = i9;
                        dex13Var.dexd = i9 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i9);
                        dex13Var.dexa = 14;
                    } else if (c10 == '{') {
                        int i10 = dex13Var.dexe + 1;
                        dex13Var.dexe = i10;
                        dex13Var.dexd = i10 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i10);
                        dex13Var.dexa = 12;
                    } else {
                        dex13Var.dexk();
                    }
                    hVar.dexa(dex11Var, t, n0Var.dexh, null);
                    if (c == ']') {
                        if (dex13Var.dexa != 15) {
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                        }
                    } else if (c == ',' && dex13Var.dexa != 16) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                    }
                }
                i5++;
            } catch (IllegalAccessException e) {
                throw new com.wangmai.insightvision.openadsdk.d.d("set " + n0Var.dexa + "error", e);
            }
        }
    }

    public dex15 dexa(a aVar, dex16 dex16Var, String str) {
        dex09 dex09Var = dex16Var.dexg;
        if (dex09Var == null) {
            return null;
        }
        for (Class<?> cls : dex09Var.seeAlso()) {
            j jVarDexa = aVar.dexa((Type) cls);
            if (jVarDexa instanceof dex15) {
                dex15 dex15Var = (dex15) jVarDexa;
                dex16 dex16Var2 = dex15Var.dexe;
                if (dex16Var2.dexj.equals(str)) {
                    return dex15Var;
                }
                dex15 dex15VarDexa = dexa(aVar, dex16Var2, str);
                if (dex15VarDexa != null) {
                    return dex15VarDexa;
                }
            }
        }
        return null;
    }

    public h dexa(long j) {
        int i = 0;
        while (true) {
            h[] hVarArr = this.dexb;
            if (i >= hVarArr.length) {
                return null;
            }
            h hVar = hVarArr[i];
            if (hVar.dexa.dexo == j) {
                return hVar;
            }
            i++;
        }
    }

    public h dexa(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        if (!this.dexe.dexh) {
            int length = this.dexb.length - 1;
            int i2 = 0;
            while (i2 <= length) {
                int i3 = (i2 + length) >>> 1;
                int iCompareTo = this.dexb[i3].dexa.dexa.compareTo(str);
                if (iCompareTo < 0) {
                    i2 = i3 + 1;
                } else {
                    if (iCompareTo <= 0) {
                        return this.dexb[i3];
                    }
                    length = i3 - 1;
                }
            }
            Map<String, h> map = this.dexc;
            if (map != null) {
                return map.get(str);
            }
            if (this.dexg == null) {
                long[] jArr = new long[this.dexb.length];
                int i4 = 0;
                while (true) {
                    h[] hVarArr = this.dexb;
                    if (i4 >= hVarArr.length) {
                        break;
                    }
                    jArr[i4] = q0.dexb(hVarArr[i4].dexa.dexa);
                    i4++;
                }
                Arrays.sort(jArr);
                this.dexg = jArr;
            }
            int iBinarySearch = Arrays.binarySearch(this.dexg, q0.dexb(str));
            if (iBinarySearch >= 0) {
                if (this.dexh == null) {
                    int[] iArr = new int[this.dexg.length];
                    Arrays.fill(iArr, -1);
                    while (true) {
                        h[] hVarArr2 = this.dexb;
                        if (i >= hVarArr2.length) {
                            break;
                        }
                        int iBinarySearch2 = Arrays.binarySearch(this.dexg, q0.dexb(hVarArr2[i].dexa.dexa));
                        if (iBinarySearch2 >= 0) {
                            iArr[iBinarySearch2] = i;
                        }
                        i++;
                    }
                    this.dexh = iArr;
                }
                int i5 = this.dexh[iBinarySearch];
                if (i5 != -1) {
                    return this.dexb[i5];
                }
            }
            return dexb(str);
        }
        while (true) {
            h[] hVarArr3 = this.dexb;
            if (i >= hVarArr3.length) {
                return null;
            }
            h hVar = hVarArr3[i];
            if (hVar.dexa.dexa.equalsIgnoreCase(str)) {
                return hVar;
            }
            i++;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public Object dexa(dex11 dex11Var, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        if ((type instanceof Class) && this.dexd.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new com.wangmai.insightvision.openadsdk.d.e((dex11Var.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.o.t) != 0));
        }
        dex16 dex16Var = this.dexe;
        Constructor<?> constructor = dex16Var.dexa;
        if (constructor == null && dex16Var.dexd == null) {
            return null;
        }
        Method method = dex16Var.dexd;
        if (method != null && dex16Var.dexb > 0) {
            return null;
        }
        try {
            Object objNewInstance = dex16Var.dexb == 0 ? constructor != null ? constructor.newInstance(new Object[0]) : method.invoke(null, new Object[0]) : constructor.newInstance(dex11Var.dexf.dexa);
            if (dex11Var != null && (dex11Var.dexe.dexc & com.wangmai.insightvision.openadsdk.d.i.d.m.t) != 0) {
                for (n0 n0Var : this.dexe.dexe) {
                    if (n0Var.dexg == String.class) {
                        n0Var.dexa(objNewInstance, "");
                    }
                }
            }
            return objNewInstance;
        } catch (Exception e) {
            throw new com.wangmai.insightvision.openadsdk.d.d("create instance error, class " + this.dexd.getName(), e);
        }
    }

    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) {
        return (T) dexa(dex11Var, type, obj, null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:87:0x0142  */
    /* JADX WARN: Code duplicated, block: B:94:0x0158  */
    /* JADX WARN: Code duplicated, block: B:96:0x015c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0163  */
    public Object dexa(Map<String, Object> map, a aVar) throws IllegalAccessException, com.wangmai.insightvision.openadsdk.d.d, InvocationTargetException {
        String str;
        float fFloatValue;
        double dDoubleValue;
        dex16 dex16Var = this.dexe;
        if (dex16Var.dexc != null) {
            n0[] n0VarArr = dex16Var.dexe;
            int length = n0VarArr.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                n0 n0Var = n0VarArr[i];
                Object objDexa = map.get(n0Var.dexa);
                if (objDexa == null) {
                    objDexa = q0.dexa(n0Var.dexg);
                }
                objArr[i] = objDexa;
            }
            Constructor<?> constructor = this.dexe.dexc;
            if (constructor == null) {
                return null;
            }
            try {
                return constructor.newInstance(objArr);
            } catch (Exception e) {
                throw new com.wangmai.insightvision.openadsdk.d.d("create instance error, " + this.dexe.dexc.toGenericString(), e);
            }
        }
        Object objDexa2 = dexa((dex11) null, this.dexd);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            h hVarDexa = dexa(entry.getKey());
            if (hVarDexa != null) {
                Object value = entry.getValue();
                if (value == null) {
                    Class<?> cls = hVarDexa.dexa.dexg;
                    if (cls == Integer.TYPE) {
                        value = 0;
                    } else if (cls == Long.TYPE) {
                        value = 0L;
                    } else if (cls == Short.TYPE) {
                        value = (short) 0;
                    } else if (cls == Byte.TYPE) {
                        value = (byte) 0;
                    } else if (cls == Float.TYPE) {
                        value = Float.valueOf(0.0f);
                    } else if (cls == Double.TYPE) {
                        value = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                    } else if (cls == Character.TYPE) {
                        value = '0';
                    } else if (cls == Boolean.TYPE) {
                        value = Boolean.FALSE;
                    }
                }
                n0 n0Var2 = hVarDexa.dexa;
                Method method = n0Var2.dexb;
                if (method != null) {
                    method.invoke(objDexa2, q0.dexa(value, method.getGenericParameterTypes()[0], aVar));
                } else {
                    Field field = n0Var2.dexc;
                    Type type = n0Var2.dexh;
                    if (type == Boolean.TYPE) {
                        if (value == Boolean.FALSE) {
                            field.setBoolean(objDexa2, false);
                        } else if (value == Boolean.TRUE) {
                            field.setBoolean(objDexa2, true);
                        } else {
                            str = hVarDexa.dexa.dexn;
                            if (str == null && type == Date.class && (value instanceof String)) {
                                try {
                                    value = new SimpleDateFormat(str).parse((String) value);
                                } catch (ParseException unused) {
                                    value = null;
                                }
                            } else if (type instanceof ParameterizedType) {
                                value = q0.dexa(value, (ParameterizedType) type, aVar);
                            } else {
                                value = q0.dexa(value, type, aVar);
                            }
                            field.set(objDexa2, value);
                        }
                    } else if (type == Integer.TYPE) {
                        if (value instanceof Number) {
                            field.setInt(objDexa2, ((Number) value).intValue());
                        } else {
                            str = hVarDexa.dexa.dexn;
                            if (str == null) {
                                if (type instanceof ParameterizedType) {
                                    value = q0.dexa(value, (ParameterizedType) type, aVar);
                                } else {
                                    value = q0.dexa(value, type, aVar);
                                }
                            } else if (type instanceof ParameterizedType) {
                                value = q0.dexa(value, (ParameterizedType) type, aVar);
                            } else {
                                value = q0.dexa(value, type, aVar);
                            }
                            field.set(objDexa2, value);
                        }
                    } else if (type == Long.TYPE) {
                        if (value instanceof Number) {
                            field.setLong(objDexa2, ((Number) value).longValue());
                        } else {
                            str = hVarDexa.dexa.dexn;
                            if (str == null) {
                                if (type instanceof ParameterizedType) {
                                    value = q0.dexa(value, (ParameterizedType) type, aVar);
                                } else {
                                    value = q0.dexa(value, type, aVar);
                                }
                            } else if (type instanceof ParameterizedType) {
                                value = q0.dexa(value, (ParameterizedType) type, aVar);
                            } else {
                                value = q0.dexa(value, type, aVar);
                            }
                            field.set(objDexa2, value);
                        }
                    } else if (type == Float.TYPE) {
                        if (value instanceof Number) {
                            fFloatValue = ((Number) value).floatValue();
                        } else if (value instanceof String) {
                            String str2 = (String) value;
                            fFloatValue = str2.length() <= 10 ? q0.dexe(str2) : Float.parseFloat(str2);
                        } else {
                            str = hVarDexa.dexa.dexn;
                            if (str == null) {
                                if (type instanceof ParameterizedType) {
                                    value = q0.dexa(value, (ParameterizedType) type, aVar);
                                } else {
                                    value = q0.dexa(value, type, aVar);
                                }
                            } else if (type instanceof ParameterizedType) {
                                value = q0.dexa(value, (ParameterizedType) type, aVar);
                            } else {
                                value = q0.dexa(value, type, aVar);
                            }
                            field.set(objDexa2, value);
                        }
                        field.setFloat(objDexa2, fFloatValue);
                    } else {
                        if (type == Double.TYPE) {
                            if (value instanceof Number) {
                                dDoubleValue = ((Number) value).doubleValue();
                            } else if (value instanceof String) {
                                String str3 = (String) value;
                                dDoubleValue = str3.length() <= 10 ? q0.dexd(str3) : Double.parseDouble(str3);
                            }
                            field.setDouble(objDexa2, dDoubleValue);
                        } else {
                            if (value == null || type != value.getClass()) {
                            }
                            field.set(objDexa2, value);
                        }
                        str = hVarDexa.dexa.dexn;
                        if (str == null) {
                            if (type instanceof ParameterizedType) {
                                value = q0.dexa(value, (ParameterizedType) type, aVar);
                            } else {
                                value = q0.dexa(value, type, aVar);
                            }
                        } else if (type instanceof ParameterizedType) {
                            value = q0.dexa(value, (ParameterizedType) type, aVar);
                        } else {
                            value = q0.dexa(value, type, aVar);
                        }
                        field.set(objDexa2, value);
                    }
                }
            }
        }
        return objDexa2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public void dexa(dex11 dex11Var, Object obj, String str) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        if ((dex13Var.dexc & com.wangmai.insightvision.openadsdk.d.i.d.i.t) == 0) {
            throw new com.wangmai.insightvision.openadsdk.d.d("setter not found, class " + this.dexd.getName() + ", property " + str);
        }
        dex13Var.dexa(com.google.common.net.c.b);
        List<g> list = dex11Var.dexk;
        Type typeDexa = null;
        if (list != null) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                typeDexa = it.next().dexa(obj, str);
            }
        }
        Object objDexe = typeDexa == null ? dex11Var.dexe() : dex11Var.dexa(typeDexa);
        if (obj instanceof e) {
            ((e) obj).a(str, objDexe);
            return;
        }
        List<f> list2 = dex11Var.dexl;
        if (list2 != null) {
            Iterator<f> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().dexa(obj, str, objDexe);
            }
        }
    }
}
