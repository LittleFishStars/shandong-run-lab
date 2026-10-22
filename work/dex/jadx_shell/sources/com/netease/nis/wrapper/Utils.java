package com.netease.nis.wrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public class Utils {
    private static String a(Class cls, String str, String str2) {
        String strC;
        int i = 0;
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            Field.setAccessible(declaredFields, true);
            while (true) {
                int i2 = i;
                if (i2 >= declaredFields.length) {
                    return "";
                }
                Field field = declaredFields[i2];
                if (field != null && field.getName().equals(str) && Modifier.isStatic(field.getModifiers())) {
                    String strReplace = field.getType().toString().replace(a.auu.a.c("LQkVFhJT"), "").replace(a.auu.a.c("JwsAABMVBC0AVA=="), "");
                    if (strReplace.startsWith(a.auu.a.c("FQ=="))) {
                        strC = strReplace.replace('.', '/');
                    } else if (strReplace.equals(a.auu.a.c("JwsA"))) {
                        strC = a.auu.a.c("Bw==");
                    } else if (strReplace.equals(a.auu.a.c("KAkbBBU="))) {
                        strC = a.auu.a.c("CA==");
                    } else if (strReplace.equals(a.auu.a.c("IgoaAg=="))) {
                        strC = a.auu.a.c("BA==");
                    } else if (strReplace.equals(a.auu.a.c("KgoBBw0W"))) {
                        strC = a.auu.a.c("Cg==");
                    } else if (strReplace.equals(a.auu.a.c("PQ0bFxU="))) {
                        strC = a.auu.a.c("HQ==");
                    } else if (strReplace.equals(a.auu.a.c("LQ0VFw=="))) {
                        strC = a.auu.a.c("DQ==");
                    } else if (strReplace.equals(a.auu.a.c("LAobCQQSCw=="))) {
                        strC = a.auu.a.c("FA==");
                    } else {
                        strC = strReplace.equals(a.auu.a.c("LBwAAA==")) ? a.auu.a.c("DA==") : (a.auu.a.c("Ag==") + strReplace + a.auu.a.c("dQ==")).replace('.', '/');
                    }
                    if (str2.equals(strC)) {
                        String.format(a.auu.a.c("KAwRCQVTCy8IEV9EAEU6HAQAW1YW"), field.getName(), strReplace);
                        return field.getDeclaringClass().getName().replace('.', '/');
                    }
                }
                i = i2 + 1;
            }
        } catch (NoClassDefFoundError e) {
            return a.auu.a.c("AAo3CQAAFgoAEiMOBgsqIAYXDgE=");
        }
    }

    private static String a(String str) {
        if (str.startsWith(a.auu.a.c("FQ=="))) {
            return str.replace('.', '/');
        }
        if (str.equals(a.auu.a.c("JwsA"))) {
            return a.auu.a.c("Bw==");
        }
        if (str.equals(a.auu.a.c("KAkbBBU="))) {
            return a.auu.a.c("CA==");
        }
        if (str.equals(a.auu.a.c("IgoaAg=="))) {
            return a.auu.a.c("BA==");
        }
        if (str.equals(a.auu.a.c("KgoBBw0W"))) {
            return a.auu.a.c("Cg==");
        }
        if (str.equals(a.auu.a.c("PQ0bFxU="))) {
            return a.auu.a.c("HQ==");
        }
        if (str.equals(a.auu.a.c("LQ0VFw=="))) {
            return a.auu.a.c("DQ==");
        }
        if (str.equals(a.auu.a.c("LAobCQQSCw=="))) {
            return a.auu.a.c("FA==");
        }
        return str.equals(a.auu.a.c("LBwAAA==")) ? a.auu.a.c("DA==") : (a.auu.a.c("Ag==") + str + a.auu.a.c("dQ==")).replace('.', '/');
    }

    public static String getFieldSCDesc(Class cls, String str, String str2) {
        String.format(a.auu.a.c("KQAAIwgWCSo2NyEEAAZuFxEUFBoXK0UaBAwWX2sWVBEYAwB0QAc="), str, str2);
        while (cls != null) {
            String strA = a(cls, str, str2);
            if (strA != null && strA.length() > 0) {
                String.format(a.auu.a.c("KQAAIwgWCSo2NyEEAAZuCxUIBElAPQ=="), strA);
                return strA;
            }
            cls = cls.getSuperclass();
        }
        return "";
    }

    public static Method getMethod(String str, String str2, boolean z) {
        Method method = null;
        try {
            String[] strArrSplit = str2.split(a.auu.a.c("Yw=="));
            Method[] declaredMethods = Utils.class.getClassLoader().loadClass(str).getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (i < length) {
                Method method2 = declaredMethods[i];
                int length2 = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String str3 = strArrSplit[i2];
                        if (!(z && method2.getName().equals(str3)) && (z || !method2.getName().contains(str3))) {
                            i2++;
                        } else {
                            try {
                                new StringBuilder(a.auu.a.c("KQAARQwWESYKEF8=")).append(str3).append(a.auu.a.c("bgwaRQ==")).append(str);
                                method2.setAccessible(true);
                            } catch (Exception e) {
                                method = method2;
                                e = e;
                                e.toString();
                                return method;
                            }
                        }
                    } else {
                        method2 = method;
                    }
                    i++;
                    method = method2;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return method;
    }

    public static Object getStaticFO(String str, String str2) {
        Object objValueOf = null;
        try {
            Field field = Class.forName(str.replace('/', '.')).getField(str2);
            Class<?> type = field.getType();
            if (type == Integer.TYPE) {
                objValueOf = Integer.valueOf(field.getInt(null));
            } else if (type == Float.TYPE) {
                objValueOf = Float.valueOf(field.getFloat(null));
            } else if (type == Long.TYPE) {
                objValueOf = Long.valueOf(field.getLong(null));
            } else if (type == Double.TYPE) {
                objValueOf = Double.valueOf(field.getDouble(null));
            } else if (type == Short.TYPE) {
                objValueOf = Short.valueOf(field.getShort(null));
            } else if (type == Character.TYPE) {
                objValueOf = Character.valueOf(field.getChar(null));
            } else if (type == Boolean.TYPE) {
                objValueOf = Boolean.valueOf(field.getBoolean(null));
            } else {
                objValueOf = type == Byte.TYPE ? Byte.valueOf(field.getByte(null)) : field.get(null);
            }
        } catch (Exception e) {
            e.toString();
        }
        return objValueOf;
    }
}
