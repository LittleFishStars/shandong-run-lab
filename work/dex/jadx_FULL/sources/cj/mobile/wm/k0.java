package cj.mobile.wm;

import com.easyjson.JSON;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.AbstractSequentialList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k0 {
    public static final k0 dexd = new k0();
    public final o0<g0> dexa;
    public String dexb = JSON.DEFAULT_TYPE_KEY;
    public com.wangmai.insightvision.openadsdk.d.g dexc;

    public k0() {
        o0<g0> o0Var = new o0<>(1024);
        this.dexa = o0Var;
        o0Var.dexa(Boolean.class, s.dexa);
        d0 d0Var = d0.dexa;
        o0Var.dexa(Character.class, d0Var);
        o0Var.dexa(Byte.class, x.dexa);
        o0Var.dexa(Short.class, x.dexa);
        o0Var.dexa(Integer.class, x.dexa);
        o0Var.dexa(Long.class, x.dexa);
        f0 f0Var = f0.dexb;
        o0Var.dexa(Float.class, f0Var);
        o0Var.dexa(Double.class, f0Var);
        o0Var.dexa(Number.class, f0Var);
        r rVar = r.dexa;
        o0Var.dexa(BigDecimal.class, rVar);
        o0Var.dexa(BigInteger.class, rVar);
        o0Var.dexa(String.class, m.dexa);
        o0Var.dexa(Object[].class, n.dexa);
        o0Var.dexa(Class.class, d0Var);
        o0Var.dexa(SimpleDateFormat.class, d0Var);
        o0Var.dexa(Locale.class, d0Var);
        o0Var.dexa(Currency.class, d0Var);
        o0Var.dexa(TimeZone.class, d0Var);
        o0Var.dexa(UUID.class, d0Var);
        o0Var.dexa(URI.class, d0Var);
        o0Var.dexa(URL.class, d0Var);
        o0Var.dexa(Pattern.class, d0Var);
        o0Var.dexa(Charset.class, d0Var);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0040  */
    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    /* JADX WARN: Code duplicated, block: B:81:0x0158  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public g0 dexa(Class<?> cls) {
        o0<g0> o0Var;
        g0 vVar;
        Class<? super Object> superclass;
        boolean z;
        g0 a0Var;
        g0 g0Var;
        g0 g0VarDexa = this.dexa.dexa(cls);
        if (g0VarDexa != null) {
            return g0VarDexa;
        }
        if (!Map.class.isAssignableFrom(cls)) {
            if (AbstractSequentialList.class.isAssignableFrom(cls)) {
                o0Var = this.dexa;
                vVar = t.dexa;
            } else if (List.class.isAssignableFrom(cls)) {
                o0Var = this.dexa;
                vVar = new b0();
            } else if (Collection.class.isAssignableFrom(cls)) {
                o0Var = this.dexa;
                vVar = t.dexa;
            } else if (Date.class.isAssignableFrom(cls)) {
                o0Var = this.dexa;
                vVar = u.dexa;
            } else if (dex05.class.isAssignableFrom(cls) || y.class.isAssignableFrom(cls) || dex06.class.isAssignableFrom(cls)) {
                o0Var = this.dexa;
                vVar = d0.dexa;
            } else if (cls.isEnum() || !((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
                o0Var = this.dexa;
                vVar = new v();
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                g0 g0VarDexa2 = dexa(componentType);
                o0<g0> o0Var2 = this.dexa;
                p pVar = new p(componentType, g0VarDexa2);
                o0Var2.dexa(cls, pVar);
                g0Var = pVar;
            } else {
                if (Throwable.class.isAssignableFrom(cls)) {
                    a0 a0Var2 = new a0(cls, this.dexc);
                    a0Var2.dexc |= com.wangmai.insightvision.openadsdk.d.j.a0.n.y;
                    a0Var = a0Var2;
                } else if (TimeZone.class.isAssignableFrom(cls) || Charset.class.isAssignableFrom(cls) || Enumeration.class.isAssignableFrom(cls)) {
                    o0Var = this.dexa;
                    vVar = d0.dexa;
                } else {
                    if (!Calendar.class.isAssignableFrom(cls)) {
                        Class<?>[] interfaces = cls.getInterfaces();
                        int length = interfaces.length;
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                z = false;
                                break;
                            }
                            Class<?> cls2 = interfaces[i];
                            z = true;
                            if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                                z = false;
                                z2 = true;
                                break;
                            }
                            if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                                break;
                            }
                            i++;
                        }
                        if (z2 || z) {
                            g0 g0VarDexa3 = dexa(cls.getSuperclass());
                            this.dexa.dexa(cls, g0VarDexa3);
                            return g0VarDexa3;
                        }
                        a0Var = cls.getName().startsWith("android.net.Uri$") ? d0.dexa : new a0(cls, this.dexc);
                    }
                    o0Var = this.dexa;
                    vVar = u.dexa;
                }
                this.dexa.dexa(cls, a0Var);
                g0Var = a0Var;
            }
            if (g0Var == null) {
                return this.dexa.dexa(cls);
            }
            return g0Var;
        }
        o0Var = this.dexa;
        vVar = new c0();
        o0Var.dexa(cls, vVar);
        g0Var = vVar;
        if (g0Var == null) {
            return this.dexa.dexa(cls);
        }
        return g0Var;
    }
}
