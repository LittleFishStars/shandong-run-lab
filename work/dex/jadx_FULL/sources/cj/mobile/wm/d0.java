package cj.mobile.wm;

import com.ali.auth.third.login.LoginConstants;
import com.easyjson.JSON;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class d0 implements g0, j {
    public static final d0 dexa = new d0();

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public <T> T dexa(dex11 dex11Var) throws com.wangmai.insightvision.openadsdk.d.d {
        dex13 dex13Var = dex11Var.dexe;
        if (dex13Var.dexu() == 8) {
            dex13Var.dexk();
            return null;
        }
        if (dex13Var.dexu() != 12 && dex13Var.dexu() != 16) {
            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error: " + dex14.dexa(dex13Var.dexu()));
        }
        int iDexe = 0;
        String strDext = null;
        String strDext2 = null;
        String strDext3 = null;
        while (true) {
            String strDexa = dex13Var.dexa(dex11Var.dexa);
            if (strDexa == null) {
                if (dex13Var.dexu() == 13) {
                    break;
                }
                if (dex13Var.dexu() == 16) {
                    continue;
                }
            }
            dex13Var.dexa(com.google.common.net.c.b);
            if ("className".equals(strDexa)) {
                if (dex13Var.dexu() == 8) {
                    strDext = null;
                } else {
                    if (dex13Var.dexu() != 4) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                    }
                    strDext = dex13Var.dext();
                }
            } else if ("methodName".equals(strDexa)) {
                if (dex13Var.dexu() == 8) {
                    strDext2 = null;
                } else {
                    if (dex13Var.dexu() != 4) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                    }
                    strDext2 = dex13Var.dext();
                }
            } else if ("fileName".equals(strDexa)) {
                if (dex13Var.dexu() == 8) {
                    strDext3 = null;
                } else {
                    if (dex13Var.dexu() != 4) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                    }
                    strDext3 = dex13Var.dext();
                }
            } else if ("lineNumber".equals(strDexa)) {
                if (dex13Var.dexu() == 8) {
                    iDexe = 0;
                } else {
                    if (dex13Var.dexu() != 2) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                    }
                    iDexe = dex13Var.dexe();
                }
            } else if ("nativeMethod".equals(strDexa)) {
                if (dex13Var.dexu() != 8 && dex13Var.dexu() != 6 && dex13Var.dexu() != 7) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                }
                dex13Var.dexb(16);
            } else {
                if (strDexa != JSON.DEFAULT_TYPE_KEY) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("syntax error : " + strDexa);
                }
                if (dex13Var.dexu() == 4) {
                    String strDext4 = dex13Var.dext();
                    if (!strDext4.equals("java.lang.StackTraceElement")) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("syntax error : " + strDext4);
                    }
                } else if (dex13Var.dexu() != 8) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                }
            }
            if (dex13Var.dexu() == 13) {
                break;
            }
        }
        dex13Var.dexb(16);
        return (T) new StackTraceElement(strDext, strDext2, strDext3, iDexe);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) throws com.wangmai.insightvision.openadsdk.d.d {
        Object objDexe;
        if (type == StackTraceElement.class) {
            return (T) dexa(dex11Var);
        }
        dex13 dex13Var = dex11Var.dexe;
        if (dex11Var.dexj == 2) {
            dex11Var.dexj = 0;
            dex11Var.dexa(16);
            if (dex13Var.dexu() != 4) {
                throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
            }
            if (!"val".equals(dex13Var.dext())) {
                throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
            }
            dex13Var.dexk();
            dex11Var.dexa(17);
            objDexe = dex11Var.dexe();
            dex11Var.dexa(13);
        } else {
            objDexe = dex11Var.dexe();
        }
        if (objDexe == null) {
            return null;
        }
        if (!(objDexe instanceof String)) {
            if (objDexe instanceof com.wangmai.insightvision.openadsdk.d.e) {
                com.wangmai.insightvision.openadsdk.d.e eVar = (com.wangmai.insightvision.openadsdk.d.e) objDexe;
                if (type == Currency.class) {
                    String strC = eVar.c("currency");
                    if (strC != null) {
                        return (T) Currency.getInstance(strC);
                    }
                    String strC2 = eVar.c("currencyCode");
                    if (strC2 != null) {
                        return (T) Currency.getInstance(strC2);
                    }
                }
                if (type == Map.Entry.class) {
                    return (T) eVar.entrySet().iterator().next();
                }
            }
            throw new com.wangmai.insightvision.openadsdk.d.d("except string value");
        }
        String str = (String) objDexe;
        if (str.length() == 0) {
            return null;
        }
        if (type == UUID.class) {
            return (T) UUID.fromString(str);
        }
        if (type == Class.class) {
            return (T) q0.dexa(str, dex11Var.dexb.dexc, false);
        }
        if (type == Locale.class) {
            String[] strArrSplit = str.split(LoginConstants.UNDER_LINE);
            if (strArrSplit.length == 1) {
                return (T) new Locale(strArrSplit[0]);
            }
            return strArrSplit.length == 2 ? (T) new Locale(strArrSplit[0], strArrSplit[1]) : (T) new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        if (type == URI.class) {
            return (T) URI.create(str);
        }
        if (type == URL.class) {
            try {
                return (T) new URL(str);
            } catch (MalformedURLException e) {
                throw new com.wangmai.insightvision.openadsdk.d.d("create url error", e);
            }
        }
        if (type == Pattern.class) {
            return (T) Pattern.compile(str);
        }
        if (type == Charset.class) {
            return (T) Charset.forName(str);
        }
        if (type == Currency.class) {
            return (T) Currency.getInstance(str);
        }
        if (type == SimpleDateFormat.class) {
            ?? r8 = (T) new SimpleDateFormat(str, dex11Var.dexe.dexn);
            r8.setTimeZone(dex11Var.dexe.dexm);
            return r8;
        }
        if (type == Character.TYPE || type == Character.class) {
            return (T) q0.dexf(str);
        }
        if (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName())) {
            return (T) TimeZone.getTimeZone(str);
        }
        try {
            return (T) Class.forName("android.net.Uri").getMethod("parse", String.class).invoke(null, str);
        } catch (Exception e2) {
            throw new com.wangmai.insightvision.openadsdk.d.d("parse android.net.Uri error.", e2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d {
        String string;
        m0 m0Var = zVar.dexb;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                zVar.dexb("");
                return;
            } else if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.f.y) == 0 || !Enumeration.class.isAssignableFrom(q0.dexa(type))) {
                m0Var.dexa();
                return;
            } else {
                m0Var.write("[]");
                return;
            }
        }
        if (obj instanceof Pattern) {
            string = ((Pattern) obj).pattern();
        } else if (obj instanceof TimeZone) {
            string = ((TimeZone) obj).getID();
        } else if (obj instanceof Currency) {
            string = ((Currency) obj).getCurrencyCode();
        } else if (obj instanceof Class) {
            string = ((Class) obj).getName();
        } else if (obj instanceof Character) {
            Character ch = (Character) obj;
            string = ch.charValue() == 0 ? "\u0000" : ch.toString();
        } else {
            int i = 0;
            if (obj instanceof SimpleDateFormat) {
                String pattern = ((SimpleDateFormat) obj).toPattern();
                if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) == 0 || obj.getClass() == type) {
                    m0Var.dexa(pattern);
                    return;
                }
                m0Var.write(123);
                m0Var.dexa(JSON.DEFAULT_TYPE_KEY, false);
                zVar.dexb(obj.getClass().getName());
                m0Var.write(44);
                m0Var.dexa("val", false);
                m0Var.dexa(pattern);
                m0Var.write(125);
                return;
            }
            if (obj instanceof dex06) {
                ((dex06) obj).a(m0Var);
                return;
            }
            if (obj instanceof dex05) {
                m0Var.write(((dex05) obj).a());
                return;
            }
            if (obj instanceof y) {
                ((y) obj).dexa(zVar, obj2, type);
                return;
            }
            if (obj instanceof Enumeration) {
                Type type2 = ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
                Enumeration enumeration = (Enumeration) obj;
                j0 j0Var = zVar.dexm;
                zVar.dexa(j0Var, obj, obj2, 0);
                try {
                    m0Var.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object objNextElement = enumeration.nextElement();
                        int i2 = i + 1;
                        if (i != 0) {
                            m0Var.write(44);
                        }
                        if (objNextElement == null) {
                            m0Var.dexa();
                        } else {
                            zVar.dexa.dexa(objNextElement.getClass()).dexa(zVar, objNextElement, Integer.valueOf(i2 - 1), type2);
                        }
                        i = i2;
                    }
                    m0Var.write(93);
                    return;
                } finally {
                    zVar.dexm = j0Var;
                }
            }
            string = obj.toString();
        }
        zVar.dexb(string);
    }
}
