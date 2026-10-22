package cj.mobile.wm;

import com.easyjson.JSON;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class u implements g0, j {
    public static final u dexa = new u();

    @Override // cj.mobile.wm.j
    public <T> T dexa(dex11 dex11Var, Type type, Object obj) {
        return (T) dexa(dex11Var, type, obj, (String) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, java.util.Calendar] */
    public <T> T dexa(dex11 dex11Var, Type type, Object obj, Object obj2, String str) throws com.wangmai.insightvision.openadsdk.d.d {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof BigDecimal) {
            return (T) new Date(((BigDecimal) obj2).longValueExact());
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (!(obj2 instanceof String)) {
            throw new com.wangmai.insightvision.openadsdk.d.d("parse error");
        }
        String str2 = (String) obj2;
        if (str2.length() == 0) {
            return null;
        }
        dex13 dex13Var = new dex13(str2);
        try {
            if (dex13Var.dexb(false)) {
                ?? r3 = (T) dex13Var.dexo;
                if (type == Calendar.class) {
                    dex13Var.dexb();
                    return r3;
                }
                T t = (T) r3.getTime();
                dex13Var.dexb();
                return t;
            }
            dex13Var.dexb();
            if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                return null;
            }
            try {
                return (T) (str != null ? new SimpleDateFormat(str) : dex11Var.dexa()).parse(str2);
            } catch (ParseException unused) {
                return (T) new Date(Long.parseLong(str2));
            }
        } catch (Throwable th) {
            dex13Var.dexb();
            throw th;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, java.util.Calendar] */
    public <T> T dexa(dex11 dex11Var, Type type, Object obj, String str) throws com.wangmai.insightvision.openadsdk.d.d {
        Object objDexe;
        Object obj2;
        String strDext;
        Object time;
        T t;
        Object objDexe2;
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu == 2) {
            Object objValueOf = Long.valueOf(dex13Var.dexh());
            dex13Var.dexb(16);
            objDexe2 = objValueOf;
        } else {
            if (iDexu != 4) {
                if (iDexu == 8) {
                    dex13Var.dexk();
                    obj2 = null;
                } else {
                    if (iDexu == 12) {
                        dex13Var.dexk();
                        if (dex13Var.dexu() != 4) {
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error");
                        }
                        if (JSON.DEFAULT_TYPE_KEY.equals(dex13Var.dext())) {
                            dex13Var.dexk();
                            dex11Var.dexa(17);
                            Type typeDexa = dex11Var.dexb.dexa(dex13Var.dext(), (Class<?>) null, dex13Var.dexc);
                            if (typeDexa != null) {
                                type = typeDexa;
                            }
                            dex11Var.dexa(4);
                            dex11Var.dexa(16);
                        }
                        dex13Var.dexa(com.google.common.net.c.b);
                        int iDexu2 = dex13Var.dexu();
                        if (iDexu2 != 2) {
                            throw new com.wangmai.insightvision.openadsdk.d.d("syntax error : " + dex14.dexa(iDexu2));
                        }
                        long jDexh = dex13Var.dexh();
                        dex13Var.dexk();
                        objDexe = Long.valueOf(jDexh);
                    } else if (dex11Var.dexj == 2) {
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
                    } else {
                        objDexe2 = dex11Var.dexe();
                    }
                    dex11Var.dexa(13);
                    objDexe2 = objDexe;
                }
                t = (T) dexa(dex11Var, type, obj, obj2, str);
                if (type != Calendar.class && !(t instanceof Calendar)) {
                    Date date = (Date) t;
                    if (date == null) {
                        return null;
                    }
                    ?? r13 = (T) Calendar.getInstance(dex13Var.dexm, dex13Var.dexn);
                    r13.setTime(date);
                    return r13;
                }
            }
            strDext = dex13Var.dext();
            dex13Var.dexb(16);
            if ((dex13Var.dexc & com.wangmai.insightvision.openadsdk.d.i.d.f.t) != 0) {
                dex13 dex13Var2 = new dex13(strDext);
                if (dex13Var2.dexb(true)) {
                    ?? r1 = (T) dex13Var2.dexo;
                    if (type == Calendar.class) {
                        objDexe2 = strDext;
                        time = strDext;
                        dex13Var2.dexb();
                        return r1;
                    }
                    objDexe2 = strDext;
                    time = strDext;
                    time = r1.getTime();
                }
                objDexe2 = strDext;
                time = strDext;
                dex13Var2.dexb();
                objDexe2 = time;
            }
        }
        objDexe2 = strDext;
        obj2 = objDexe2;
        t = (T) dexa(dex11Var, type, obj, obj2, str);
        return type != Calendar.class ? t : t;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.g0
    public void dexa(z zVar, Object obj, Object obj2, Type type) throws com.wangmai.insightvision.openadsdk.d.d, IOException {
        char[] charArray;
        int i;
        m0 m0Var = zVar.dexb;
        if (obj == null) {
            m0Var.dexa();
            return;
        }
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.n.y) != 0 && obj.getClass() != type) {
            if (obj.getClass() == Date.class) {
                m0Var.write("new Date(");
                m0Var.dexa(((Date) obj).getTime());
                i = 41;
            } else {
                m0Var.write(123);
                m0Var.dexa(JSON.DEFAULT_TYPE_KEY, false);
                zVar.dexb(obj.getClass().getName());
                m0Var.write(44);
                m0Var.dexa("val", false);
                m0Var.dexa(((Date) obj).getTime());
                i = 125;
            }
            m0Var.write(i);
            return;
        }
        Date time = obj instanceof Calendar ? ((Calendar) obj).getTime() : (Date) obj;
        if ((m0Var.dexc & com.wangmai.insightvision.openadsdk.d.j.a0.q.y) != 0) {
            DateFormat dateFormatDexd = zVar.dexd();
            if (dateFormatDexd == null) {
                dateFormatDexd = new SimpleDateFormat(dex04.d, zVar.dexo);
                dateFormatDexd.setTimeZone(zVar.dexn);
            }
            m0Var.dexa(dateFormatDexd.format(time));
            return;
        }
        long time2 = time.getTime();
        int i2 = m0Var.dexc;
        if ((com.wangmai.insightvision.openadsdk.d.j.a0.e.y & i2) == 0) {
            m0Var.dexa(time2);
            return;
        }
        com.wangmai.insightvision.openadsdk.d.j.a0 a0Var = com.wangmai.insightvision.openadsdk.d.j.a0.b;
        if ((i2 & a0Var.y) != 0) {
            m0Var.write(39);
        } else {
            m0Var.write(34);
        }
        Calendar calendar = Calendar.getInstance(zVar.dexn, zVar.dexo);
        calendar.setTimeInMillis(time2);
        int i3 = calendar.get(1);
        int i4 = calendar.get(2) + 1;
        int i5 = calendar.get(5);
        int i6 = calendar.get(11);
        int i7 = calendar.get(12);
        int i8 = calendar.get(13);
        int i9 = calendar.get(14);
        if (i9 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            m0.dexa(i9, 23, charArray);
            m0.dexa(i8, 19, charArray);
            m0.dexa(i7, 16, charArray);
            m0.dexa(i6, 13, charArray);
            m0.dexa(i5, 10, charArray);
            m0.dexa(i4, 7, charArray);
            m0.dexa(i3, 4, charArray);
        } else if (i8 == 0 && i7 == 0 && i6 == 0) {
            charArray = "0000-00-00".toCharArray();
            m0.dexa(i5, 10, charArray);
            m0.dexa(i4, 7, charArray);
            m0.dexa(i3, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            m0.dexa(i8, 19, charArray);
            m0.dexa(i7, 16, charArray);
            m0.dexa(i6, 13, charArray);
            m0.dexa(i5, 10, charArray);
            m0.dexa(i4, 7, charArray);
            m0.dexa(i3, 4, charArray);
        }
        m0Var.write(charArray);
        m0Var.write((m0Var.dexc & a0Var.y) != 0 ? 39 : 34);
    }
}
