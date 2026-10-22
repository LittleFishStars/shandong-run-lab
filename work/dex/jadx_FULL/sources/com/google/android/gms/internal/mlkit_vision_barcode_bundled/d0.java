package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.hlc;
import com.zj.adlib.ivc;
import com.zj.adlib.rmc;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f31373a;

    static {
        char[] cArr = new char[80];
        f31373a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String a(zzfo zzfoVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(zzfoVar, sb, 0);
        return sb.toString();
    }

    public static void b(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        c(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append(LoginConstants.UNDER_LINE);
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(ivc.a(new zzcy(((String) obj).getBytes(rmc.b))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdb) {
            sb.append(": \"");
            sb.append(ivc.a((zzdb) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzed) {
            sb.append(" {");
            d((zzed) obj, sb, i + 2);
            sb.append("\n");
            c(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i3 = i + 2;
        b(sb, i3, CachedContentIndex.a.e, entry.getKey());
        b(sb, i3, "value", entry.getValue());
        sb.append("\n");
        c(i, sb);
        sb.append("}");
    }

    public static void c(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(f31373a, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01fb  */
    public static void d(zzfo zzfoVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzfoVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith(p3.h)) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith(p3.f)) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                b(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzed.n(method2, zzfoVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                b(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzed.n(method, zzfoVar, new Object[0]));
            } else if (hashSet.contains(p3.h.concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey(p3.f.concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objN = zzed.n(method4, zzfoVar, new Object[0]);
                    if (method5 == null) {
                        if (objN instanceof Boolean) {
                            if (((Boolean) objN).booleanValue()) {
                                b(sb, i, strSubstring, objN);
                            }
                        } else if (objN instanceof Integer) {
                            if (((Integer) objN).intValue() != 0) {
                                b(sb, i, strSubstring, objN);
                            }
                        } else if (objN instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objN).floatValue()) != 0) {
                                b(sb, i, strSubstring, objN);
                            }
                        } else if (!(objN instanceof Double)) {
                            if (objN instanceof String) {
                                zEquals = objN.equals("");
                            } else if (objN instanceof zzdb) {
                                zEquals = objN.equals(zzdb.zzb);
                            } else if (objN instanceof zzfo) {
                                if (objN != ((zzfo) objN).a()) {
                                    b(sb, i, strSubstring, objN);
                                }
                            } else if (!(objN instanceof Enum) || ((Enum) objN).ordinal() != 0) {
                                b(sb, i, strSubstring, objN);
                            }
                            if (!zEquals) {
                                b(sb, i, strSubstring, objN);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objN).doubleValue()) != 0) {
                            b(sb, i, strSubstring, objN);
                        }
                    } else if (((Boolean) zzed.n(method5, zzfoVar, new Object[0])).booleanValue()) {
                        b(sb, i, strSubstring, objN);
                    }
                }
            }
            i2 = 3;
        }
        if (zzfoVar instanceof zzdz) {
            Iterator itF = ((zzdz) zzfoVar).zza.f();
            while (itF.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itF.next();
                b(sb, i, "[" + ((hlc) entry2.getKey()).K + "]", entry2.getValue());
            }
        }
        o0 o0Var = ((zzed) zzfoVar).zzc;
        if (o0Var != null) {
            o0Var.i(sb, i);
        }
    }
}
