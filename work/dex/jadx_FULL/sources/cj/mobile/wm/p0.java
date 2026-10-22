package cj.mobile.wm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p0 implements ParameterizedType {
    public final Type[] dexa;
    public final Type dexb;
    public final Type dexc;

    public p0(Type[] typeArr, Type type, Type type2) {
        this.dexa = typeArr;
        this.dexb = type;
        this.dexc = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p0.class != obj.getClass()) {
            return false;
        }
        p0 p0Var = (p0) obj;
        if (!Arrays.equals(this.dexa, p0Var.dexa)) {
            return false;
        }
        Type type = this.dexb;
        if (type == null ? p0Var.dexb != null : !type.equals(p0Var.dexb)) {
            return false;
        }
        Type type2 = this.dexc;
        Type type3 = p0Var.dexc;
        if (type2 != null) {
            return type2.equals(type3);
        }
        return type3 == null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.dexa;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.dexb;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.dexc;
    }

    public int hashCode() {
        Type[] typeArr = this.dexa;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.dexb;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.dexc;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
