package com.byazt.gh;

import android.text.TextUtils;
import com.byazt.ut.i;
import com.byazt.ut.sl;
import com.byazt.ut.uj;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1238, 20})
public class c {
    public final com.byazt.ut.c c;
    public List<String> tt;
    public i ve;

    public c(com.byazt.ut.c cVar) {
        this.c = cVar;
    }

    public void c(i iVar) {
        this.ve = iVar;
    }

    public void c(List<String> list) {
        this.tt = list;
    }

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
    public void c(Function function, boolean z) {
        String name;
        Object objApply = function.apply(null);
        if (objApply instanceof Map) {
            int iC = com.byazt.ut.c.c(function);
            for (Map.Entry entry : new ArrayList(((Map) objApply).entrySet())) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                sl slVarC = this.c.sp().c(str);
                if (slVarC != null) {
                    if (!TextUtils.equals(str, slVarC.f29108a)) {
                        if (this.ve != null) {
                            JSONObject jSONObject = new JSONObject();
                            if (value != null) {
                                try {
                                    name = value.getClass().getName();
                                } catch (JSONException unused) {
                                }
                            } else {
                                name = "null";
                            }
                            uj ujVar = uj.getInstance();
                            jSONObject.put("model_key", slVarC.f29108a);
                            jSONObject.put("origin_key", str);
                            jSONObject.put("origin", name);
                            jSONObject.put("newRegAts", function);
                            jSONObject.put("old_sdk_version", iC);
                            jSONObject.put("current_sdk_version", ujVar.getVersion());
                            jSONObject.put("currentAts", ujVar);
                            jSONObject.put("msg", "key not equals model_key");
                            this.ve.c(slVarC, value, null, true, jSONObject, null);
                        }
                    } else if (value != null && slVarC.c((com.byazt.dna.c) null) == null) {
                        if (iC < 7500) {
                            c(str, slVarC, value, function, iC);
                        } else if (z) {
                            c(str, slVarC, value, function, iC, false);
                        }
                    }
                }
            }
        }
    }

    private boolean c() {
        return getClass().getName().contains("byaztp");
    }

    @Deprecated
    private void c(String str, sl slVar, Object obj, Function function, int i) {
        if (slVar.n) {
            List<String> list = this.tt;
            if ((list == null || !list.contains(slVar.f29108a)) && slVar.uj <= 0) {
                c(str, slVar, obj, function, i, true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0134  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.byazt.ut.i] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void c(String str, sl slVar, Object obj, Function function, int i, boolean z) {
        Object obj2;
        boolean z2;
        Object obj3;
        Object obj4;
        JSONObject jSONObject;
        boolean z3;
        ?? r2;
        Object objC;
        JSONObject jSONObject2 = null;
        int i2 = 0;
        try {
            String name = obj.getClass().getName();
            boolean z4 = true;
            boolean z5 = obj.getClass().getClassLoader() == getClass().getClassLoader();
            if (c()) {
                z2 = z5 || name.contains("byaztp");
            } else {
                z2 = false;
            }
            if (z2) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        Field[] declaredFields = obj.getClass().getDeclaredFields();
                        JSONObject jSONObject4 = new JSONObject();
                        int length = declaredFields.length;
                        while (i2 < length) {
                            Field field = declaredFields[i2];
                            field.setAccessible(z4);
                            obj2 = obj;
                            Object obj5 = field.get(obj2);
                            jSONObject4.put(field.getName(), field.getType().getName());
                            jSONObject4.put(field.getName() + "_v", obj5);
                            i2++;
                            z4 = true;
                        }
                        obj2 = obj;
                        jSONObject3.put("fieldInfo", jSONObject4);
                    } catch (Throwable unused) {
                        obj2 = obj;
                    }
                    try {
                        uj ujVar = uj.getInstance();
                        jSONObject3.put("model_key", slVar.f29108a);
                        jSONObject3.put("origin_key", str);
                        jSONObject3.put("sameClassLoader", z5);
                        jSONObject3.put("origin", name);
                        jSONObject3.put("newRegAts", function);
                        jSONObject3.put("old_sdk_version", i);
                        jSONObject3.put("current_sdk_version", ujVar.getVersion());
                        jSONObject3.put("currentAts", ujVar);
                        jSONObject3.put("msg", name + " is not plugin Clazz");
                        jSONObject = jSONObject3;
                        z3 = z2;
                        obj4 = obj2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject2 = jSONObject3;
                        obj3 = obj2;
                        obj4 = obj3;
                        jSONObject = jSONObject2;
                        z3 = z2;
                        jSONObject2 = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = obj;
                }
            } else {
                obj2 = obj;
                try {
                    if (z) {
                        objC = this.c.uj().tt(slVar, null, obj, function, true);
                    } else {
                        objC = this.c.uj().c(slVar, null, obj, function, true);
                    }
                    obj3 = objC;
                    try {
                        String str2 = slVar.f29108a;
                        Objects.toString(obj3);
                        Objects.toString(function);
                        obj4 = obj3;
                        jSONObject = null;
                        z3 = z2;
                    } catch (Throwable th3) {
                        th = th3;
                        obj4 = obj3;
                        jSONObject = jSONObject2;
                        z3 = z2;
                        jSONObject2 = th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj3 = obj2;
                    obj4 = obj3;
                    jSONObject = jSONObject2;
                    z3 = z2;
                    jSONObject2 = th;
                    r2 = this.ve;
                    if (r2 != 0) {
                        r2.c(slVar, obj, obj4, z3, jSONObject, jSONObject2);
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            obj2 = obj;
            z2 = false;
        }
        r2 = this.ve;
        if (r2 != 0) {
            r2.c(slVar, obj, obj4, z3, jSONObject, jSONObject2);
        }
    }
}
