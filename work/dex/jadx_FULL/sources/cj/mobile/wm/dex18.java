package cj.mobile.wm;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex18 extends h {
    public final Type dexe;
    public j dexf;
    public final boolean dexg;

    public dex18(a aVar, Class<?> cls, n0 n0Var) {
        boolean z;
        super(cls, n0Var, 14);
        Type type = n0Var.dexh;
        Class<?> cls2 = n0Var.dexg;
        if (cls2.isArray()) {
            this.dexe = cls2.getComponentType();
            z = true;
        } else {
            this.dexe = q0.dexb(type);
            z = false;
        }
        this.dexg = z;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    @Override // cj.mobile.wm.h
    public void dexa(dex11 dex11Var, Object obj, Type type, Map<String, Object> map) throws com.wangmai.insightvision.openadsdk.d.d {
        List arrayList;
        List list;
        Object array;
        dex13 dex13Var = dex11Var.dexe;
        int iDexu = dex13Var.dexu();
        if (iDexu == 8 || (iDexu == 4 && dex13Var.dext().length() == 0)) {
            dexa(obj, (Object) null);
            dex11Var.dexe.dexk();
            return;
        }
        if (this.dexg) {
            List bVar = new com.wangmai.insightvision.openadsdk.d.b();
            bVar.a(this.dexe);
            list = bVar;
            arrayList = bVar;
        } else {
            arrayList = new ArrayList();
            list = null;
        }
        dex20 dex20Var = dex11Var.dexf;
        dex11Var.dexa(dex20Var, obj, this.dexa.dexa);
        dexa(dex11Var, type, arrayList);
        dex11Var.dexa(dex20Var);
        Object obj2 = arrayList;
        if (this.dexg) {
            array = arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.dexe, arrayList.size()));
            list.c(array);
        }
        if (obj == null) {
            obj2 = array;
            map.put(this.dexa.dexa, obj2);
        } else {
            obj2 = array;
            dexa(obj, obj2);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.d.d */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01bd, code lost:
    
        r6.dexk();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void dexa(dex11 dex11Var, Type type, Collection collection) throws com.wangmai.insightvision.openadsdk.d.d {
        Class cls;
        int i;
        int i2;
        Type p0Var = this.dexe;
        j jVarDexa = this.dexf;
        if (type instanceof ParameterizedType) {
            if (p0Var instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) p0Var;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls == null) {
                    i2 = -1;
                    break;
                }
                int length = cls.getTypeParameters().length;
                i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (cls.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    p0Var = parameterizedType.getActualTypeArguments()[i2];
                    if (!p0Var.equals(this.dexe)) {
                        jVarDexa = dex11Var.dexb.dexa(p0Var);
                    }
                }
            } else if (p0Var instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) p0Var;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type2 = actualTypeArguments[0];
                    if (type2 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type2;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls == null) {
                            i = -1;
                            break;
                        }
                        int length2 = cls.getTypeParameters().length;
                        i = 0;
                        while (true) {
                            if (i >= length2) {
                                i = -1;
                                break;
                            } else if (cls.getTypeParameters()[i].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i];
                            p0Var = new p0(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                        }
                    }
                }
            }
        } else if ((p0Var instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) p0Var;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            for (int i3 = 0; i3 < length3; i3++) {
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i3];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length != 1) {
                        break;
                    }
                    p0Var = bounds[0];
                    break;
                }
            }
        }
        dex13 dex13Var = dex11Var.dexe;
        if (jVarDexa == null) {
            jVarDexa = dex11Var.dexb.dexa(p0Var);
            this.dexf = jVarDexa;
        }
        int i4 = dex13Var.dexa;
        if (i4 != 14) {
            if (i4 == 12) {
                collection.add(jVarDexa.dexa(dex11Var, p0Var, 0));
                return;
            }
            String str = "exepct '[', but " + dex14.dexa(dex13Var.dexa);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new com.wangmai.insightvision.openadsdk.d.d(str);
        }
        int i5 = 0;
        char c = dex13Var.dexd;
        int i6 = 15;
        if (c == '[') {
            int i7 = dex13Var.dexe + 1;
            dex13Var.dexe = i7;
            dex13Var.dexd = i7 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i7);
            dex13Var.dexa = 14;
        } else if (c == '{') {
            int i8 = dex13Var.dexe + 1;
            dex13Var.dexe = i8;
            dex13Var.dexd = i8 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i8);
            dex13Var.dexa = 12;
        } else if (c == '\"') {
            dex13Var.dexq();
        } else if (c == ']') {
            int i9 = dex13Var.dexe + 1;
            dex13Var.dexe = i9;
            dex13Var.dexd = i9 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i9);
            dex13Var.dexa = 15;
        } else {
            dex13Var.dexk();
        }
        while (true) {
            int i10 = dex13Var.dexa;
            if (i10 == 16) {
                dex13Var.dexk();
            } else {
                if (i10 == i6) {
                    break;
                }
                collection.add(jVarDexa.dexa(dex11Var, p0Var, Integer.valueOf(i5)));
                if (dex11Var.dexj == 1) {
                    dex11Var.dexa(collection);
                }
                if (dex13Var.dexa == 16) {
                    char c2 = dex13Var.dexd;
                    if (c2 == '[') {
                        int i11 = dex13Var.dexe + 1;
                        dex13Var.dexe = i11;
                        dex13Var.dexd = i11 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i11);
                        dex13Var.dexa = 14;
                    } else if (c2 == '{') {
                        int i12 = dex13Var.dexe + 1;
                        dex13Var.dexe = i12;
                        dex13Var.dexd = i12 >= dex13Var.dexr ? (char) 26 : dex13Var.dexq.charAt(i12);
                        dex13Var.dexa = 12;
                    } else if (c2 == '\"') {
                        dex13Var.dexq();
                    } else {
                        dex13Var.dexk();
                    }
                }
                i5++;
                i6 = 15;
            }
        }
        if (dex13Var.dexd != ',') {
            dex13Var.dexk();
            return;
        }
        int i13 = dex13Var.dexe + 1;
        dex13Var.dexe = i13;
        dex13Var.dexd = i13 < dex13Var.dexr ? dex13Var.dexq.charAt(i13) : (char) 26;
        dex13Var.dexa = 16;
    }
}
