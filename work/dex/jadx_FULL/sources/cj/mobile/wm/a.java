package cj.mobile.wm;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static long[] dexf = {-9164606388214699518L, -8720046426850100497L, -8649961213709896794L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1650485814983027158L, -1589194880214235129L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3794316665763266033L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4241163808635564644L, 4254584350247334433L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5944107969236155580L, 6007332606592876737L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8838294710098435315L, 9140390920032557669L, 9140416208800006522L};
    public static a dexg = new a();
    public final o0<j> dexa;
    public final c dexb;
    public ClassLoader dexc;
    public com.wangmai.insightvision.openadsdk.d.g dexd;
    public boolean dexe;

    public a() {
        o0<j> o0Var = new o0<>(1024);
        this.dexa = o0Var;
        this.dexb = new c(16384);
        d0 d0Var = d0.dexa;
        o0Var.dexa(SimpleDateFormat.class, d0Var);
        u uVar = u.dexa;
        o0Var.dexa(Date.class, uVar);
        o0Var.dexa(Calendar.class, uVar);
        o0Var.dexa(Map.class, dex19.dexa);
        o0Var.dexa(HashMap.class, dex19.dexa);
        o0Var.dexa(LinkedHashMap.class, dex19.dexa);
        o0Var.dexa(TreeMap.class, dex19.dexa);
        o0Var.dexa(ConcurrentMap.class, dex19.dexa);
        o0Var.dexa(ConcurrentHashMap.class, dex19.dexa);
        t tVar = t.dexa;
        o0Var.dexa(Collection.class, tVar);
        o0Var.dexa(List.class, tVar);
        o0Var.dexa(ArrayList.class, tVar);
        dex17 dex17Var = dex17.dexa;
        o0Var.dexa(Object.class, dex17Var);
        o0Var.dexa(String.class, m.dexa);
        o0Var.dexa(Character.TYPE, d0Var);
        o0Var.dexa(Character.class, d0Var);
        Class cls = Byte.TYPE;
        f0 f0Var = f0.dexb;
        o0Var.dexa(cls, f0Var);
        o0Var.dexa(Byte.class, f0Var);
        o0Var.dexa(Short.TYPE, f0Var);
        o0Var.dexa(Short.class, f0Var);
        o0Var.dexa(Integer.TYPE, x.dexa);
        o0Var.dexa(Integer.class, x.dexa);
        o0Var.dexa(Long.TYPE, x.dexa);
        o0Var.dexa(Long.class, x.dexa);
        r rVar = r.dexa;
        o0Var.dexa(BigInteger.class, rVar);
        o0Var.dexa(BigDecimal.class, rVar);
        o0Var.dexa(Float.TYPE, f0Var);
        o0Var.dexa(Float.class, f0Var);
        o0Var.dexa(Double.TYPE, f0Var);
        o0Var.dexa(Double.class, f0Var);
        Class cls2 = Boolean.TYPE;
        s sVar = s.dexa;
        o0Var.dexa(cls2, sVar);
        o0Var.dexa(Boolean.class, sVar);
        o0Var.dexa(Class.class, d0Var);
        n nVar = n.dexa;
        o0Var.dexa(char[].class, nVar);
        o0Var.dexa(Object[].class, nVar);
        o0Var.dexa(UUID.class, d0Var);
        o0Var.dexa(TimeZone.class, d0Var);
        o0Var.dexa(Locale.class, d0Var);
        o0Var.dexa(Currency.class, d0Var);
        o0Var.dexa(URI.class, d0Var);
        o0Var.dexa(URL.class, d0Var);
        o0Var.dexa(Pattern.class, d0Var);
        o0Var.dexa(Charset.class, d0Var);
        o0Var.dexa(Number.class, f0Var);
        o0Var.dexa(StackTraceElement.class, d0Var);
        o0Var.dexa(Serializable.class, dex17Var);
        o0Var.dexa(Cloneable.class, dex17Var);
        o0Var.dexa(Comparable.class, dex17Var);
        o0Var.dexa(Closeable.class, dex17Var);
    }

    public static a dexa() {
        return dexg;
    }

    public static boolean dexa(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public h dexa(a aVar, Class<?> cls, n0 n0Var) {
        Class<?> cls2 = n0Var.dexg;
        return (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) ? new dex18(aVar, cls, n0Var) : new dex10(aVar, cls, n0Var);
    }

    public j dexa(Class<?> cls, Type type) {
        j dex15Var;
        dex09 dex09Var;
        Class<?> clsMappingTo;
        j jVarDexa = this.dexa.dexa(type);
        if (jVarDexa != null) {
            return jVarDexa;
        }
        if (type == null) {
            type = cls;
        }
        j jVarDexa2 = this.dexa.dexa(type);
        if (jVarDexa2 != null) {
            return jVarDexa2;
        }
        if (!dexa(cls) && (dex09Var = (dex09) cls.getAnnotation(dex09.class)) != null && (clsMappingTo = dex09Var.mappingTo()) != Void.class) {
            return dexa(clsMappingTo, clsMappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            jVarDexa2 = this.dexa.dexa(cls);
        }
        if (jVarDexa2 != null) {
            return jVarDexa2;
        }
        j jVarDexa3 = this.dexa.dexa(type);
        if (jVarDexa3 != null) {
            return jVarDexa3;
        }
        if (cls.isEnum()) {
            dex15Var = new dex12(cls);
        } else if (cls.isArray()) {
            dex15Var = n.dexa;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            dex15Var = t.dexa;
        } else if (Map.class.isAssignableFrom(cls)) {
            dex15Var = dex19.dexa;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            dex15Var = new d(this, cls);
        } else {
            dex15Var = cls.getName().equals("android.net.Uri") ? d0.dexa : new dex15(this, cls, type);
        }
        dexa(type, dex15Var);
        return dex15Var;
    }

    public j dexa(Type type) {
        j jVarDexa = this.dexa.dexa(type);
        if (jVarDexa != null) {
            return jVarDexa;
        }
        if (type instanceof Class) {
            return dexa((Class<?>) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType instanceof Class ? dexa((Class<?>) rawType, type) : dexa(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return dexa(upperBounds[0]);
            }
        }
        return dex17.dexa;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    public Class<?> dexa(String str, Class<?> cls, int i) throws com.wangmai.insightvision.openadsdk.d.d {
        if (str == null) {
            return null;
        }
        if (str.length() < 128) {
            if (str.length() >= 3) {
                long jCharAt = (((long) str.charAt(0)) ^ TypeUtils.fnv1a_64_magic_hashcode) * TypeUtils.fnv1a_64_magic_prime;
                if (jCharAt == -5808493101479473382L) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("autoType is not support. " + str);
                }
                if ((jCharAt ^ ((long) str.charAt(str.length() - 1))) * TypeUtils.fnv1a_64_magic_prime == 655701488918567152L) {
                    throw new com.wangmai.insightvision.openadsdk.d.d("autoType is not support. " + str);
                }
                long jCharAt2 = (((((((long) str.charAt(0)) ^ TypeUtils.fnv1a_64_magic_hashcode) * TypeUtils.fnv1a_64_magic_prime) ^ ((long) str.charAt(1))) * TypeUtils.fnv1a_64_magic_prime) ^ ((long) str.charAt(2))) * TypeUtils.fnv1a_64_magic_prime;
                for (int i2 = 3; i2 < str.length(); i2++) {
                    jCharAt2 = (jCharAt2 ^ ((long) str.charAt(i2))) * TypeUtils.fnv1a_64_magic_prime;
                    if (Arrays.binarySearch(dexf, jCharAt2) >= 0 && q0.dexc(str) == null) {
                        throw new com.wangmai.insightvision.openadsdk.d.d("autoType is not support. " + str);
                    }
                }
                Class<?> clsDexc = q0.dexc(str);
                if (clsDexc != null) {
                    return clsDexc;
                }
                Class<?> clsDexa = this.dexa.dexa(str);
                if (clsDexa != null) {
                    return clsDexa;
                }
                Class<?> clsDexa2 = q0.dexa(str, this.dexc, false);
                if (clsDexa2 != null && cls != null && clsDexa2 != HashMap.class) {
                    if (cls.isAssignableFrom(clsDexa2)) {
                        q0.dexa(str, clsDexa2);
                        return clsDexa2;
                    }
                    throw new com.wangmai.insightvision.openadsdk.d.d("type not match. " + str + " -> " + cls.getName());
                }
                if (clsDexa2.isAnnotationPresent(dex09.class)) {
                    q0.dexa(str, clsDexa2);
                    return clsDexa2;
                }
                int i3 = com.wangmai.insightvision.openadsdk.d.i.d.r.t;
                if ((i & i3) != 0 || (i3 & dex04.c) != 0 || this.dexe) {
                    q0.dexa(str, clsDexa2);
                    return clsDexa2;
                }
                throw new com.wangmai.insightvision.openadsdk.d.d("autoType is not support : " + str);
            }
        }
        throw new com.wangmai.insightvision.openadsdk.d.d("autoType is not support. " + str);
    }

    public void dexa(Type type, j jVar) {
        this.dexa.dexa(type, jVar);
    }
}
