package cj.mobile.wm;

import com.easyjson.JSON;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends dex15 {
    public d(a aVar, Class<?> cls) {
        super(aVar, cls, cls);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code duplicated, block: B:100:0x0180  */
    /* JADX WARN: Code duplicated, block: B:112:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:120:0x00d2 A[EDGE_INSN: B:120:0x00d2->B:57:0x00d2 BREAK  A[LOOP:0: B:20:0x0039->B:27:0x004f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x0034  */
    /* JADX WARN: Code duplicated, block: B:89:0x015e A[Catch: Exception -> 0x01ac, TRY_LEAVE, TryCatch #0 {Exception -> 0x01ac, blocks: (B:60:0x00de, B:63:0x00ea, B:79:0x012c, B:66:0x00f8, B:69:0x0103, B:72:0x0110, B:74:0x0118, B:76:0x0121, B:81:0x0134, B:86:0x0158, B:89:0x015e, B:83:0x0144, B:85:0x0151), top: B:115:0x00de }] */
    @Override // cj.mobile.wm.dex15, cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        Class<?> clsDexa;
        Constructor<?> constructor;
        String strDext;
        Object obj2;
        Object objNewInstance;
        Constructor<?>[] constructorArr;
        dex15 dex15Var;
        dex13 dex13Var = dex11Var.dexe;
        int i = dex13Var.dexa;
        if (i == 8) {
            dex13Var.dexk();
            return null;
        }
        if (dex11Var.dexj == 2) {
            dex11Var.dexj = 0;
        } else if (i != 12) {
            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsDexa = null;
        } else {
            clsDexa = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsDexa)) {
                clsDexa = null;
            }
        }
        HashMap map = null;
        Throwable th = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strDexa = dex13Var.dexa(dex11Var.dexa);
            if (strDexa == null) {
                int i2 = dex13Var.dexa;
                if (i2 == 13) {
                    constructor = null;
                    break;
                }
                if (i2 == 16) {
                }
            }
            dex13Var.dexa(com.google.common.net.c.b);
            if (!JSON.DEFAULT_TYPE_KEY.equals(strDexa)) {
                if ("message".equals(strDexa)) {
                    int i3 = dex13Var.dexa;
                    if (i3 == 8) {
                        strDext = null;
                    } else {
                        if (i3 != 4) {
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                        }
                        strDext = dex13Var.dext();
                    }
                    dex13Var.dexk();
                    str = strDext;
                } else if ("cause".equals(strDexa)) {
                    constructor = null;
                    th = (Throwable) dexa(dex11Var, (Type) null, "cause");
                } else {
                    constructor = null;
                    if ("stackTrace".equals(strDexa)) {
                        stackTraceElementArr = (StackTraceElement[]) dex11Var.dexa((Class) StackTraceElement[].class);
                    } else {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(strDexa, dex11Var.dexe());
                    }
                }
                if (dex13Var.dexa == 13) {
                    break;
                }
            } else {
                if (dex13Var.dexa != 4) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                }
                clsDexa = q0.dexa(dex13Var.dext(), dex11Var.dexb.dexc, false);
                dex13Var.dexb(16);
            }
            constructor = null;
            if (dex13Var.dexa == 13) {
                break;
                break;
            }
        }
        dex13Var.dexb(16);
        if (clsDexa == null) {
            obj2 = (T) new Exception(str, th);
        } else {
            try {
                Constructor<?>[] constructors = clsDexa.getConstructors();
                int length = constructors.length;
                int i4 = 0;
                Constructor<?> constructor2 = constructor;
                Constructor<?> constructor3 = constructor2;
                Constructor<?> constructor4 = constructor3;
                while (i4 < length) {
                    Constructor<?> constructor5 = constructors[i4];
                    if (constructor5.getParameterTypes().length == 0) {
                        constructorArr = constructors;
                        constructor4 = constructor5;
                    } else {
                        constructorArr = constructors;
                        if (constructor5.getParameterTypes().length == 1 && constructor5.getParameterTypes()[0] == String.class) {
                            constructor3 = constructor5;
                        } else if (constructor5.getParameterTypes().length == 2 && constructor5.getParameterTypes()[0] == String.class && constructor5.getParameterTypes()[1] == Throwable.class) {
                            constructor2 = constructor5;
                        }
                    }
                    i4++;
                    constructors = constructorArr;
                }
                if (constructor2 != null) {
                    objNewInstance = constructor2.newInstance(str, th);
                } else if (constructor3 != null) {
                    objNewInstance = constructor3.newInstance(str);
                } else {
                    if (constructor4 != null) {
                        objNewInstance = constructor4.newInstance(new Object[0]);
                    } else {
                        obj2 = null;
                    }
                    if (obj2 == null) {
                        obj2 = (T) new Exception(str, th);
                    }
                }
                obj2 = (T) ((Throwable) objNewInstance);
                if (obj2 == null) {
                    obj2 = (T) new Exception(str, th);
                }
            } catch (Exception e) {
                throw new com.wangmai.insightvision.openadsdk.d.d("create instance error", e);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        }
        if (map != null) {
            if (clsDexa == null) {
                dex15Var = null;
            } else if (clsDexa == this.dexd) {
                dex15Var = this;
            } else {
                j jVarDexa = dex11Var.dexb.dexa((Type) clsDexa);
                if (jVarDexa instanceof dex15) {
                    dex15Var = (dex15) jVarDexa;
                } else {
                    dex15Var = null;
                }
            }
            if (dex15Var != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value = entry.getValue();
                    h hVarDexa = dex15Var.dexa(str2);
                    if (hVarDexa != null) {
                        hVarDexa.dexa(obj2, value);
                    }
                }
            }
        }
        return (T) obj2;
    }
}
