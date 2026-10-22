package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.i;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public abstract class TypeParameter<T> extends TypeCapture<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeVariable<?> f32254a;

    public TypeParameter() {
        Type typeCapture = capture();
        i.u(typeCapture instanceof TypeVariable, "%s should be a type variable.", typeCapture);
        this.f32254a = (TypeVariable) typeCapture;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeParameter) {
            return this.f32254a.equals(((TypeParameter) obj).f32254a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f32254a.hashCode();
    }

    public String toString() {
        return this.f32254a.toString();
    }
}
