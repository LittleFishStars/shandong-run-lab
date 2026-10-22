package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.i;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class b implements AnnotatedElement {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<Annotation> f32271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Invokable<?, ?> f6452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TypeToken<?> f6453a;

    public b(Invokable<?, ?> invokable, int i, TypeToken<?> typeToken, Annotation[] annotationArr) {
        this.f6452a = invokable;
        this.K = i;
        this.f6453a = typeToken;
        this.f32271a = ImmutableList.copyOf(annotationArr);
    }

    public Invokable<?, ?> b() {
        return this.f6452a;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.K == bVar.K && this.f6452a.equals(bVar.f6452a);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        i.E(cls);
        UnmodifiableIterator<Annotation> it = this.f32271a.iterator();
        while (it.hasNext()) {
            Annotation next = it.next();
            if (cls.isInstance(next)) {
                return cls.cast(next);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        i.E(cls);
        return (A) FluentIterable.x(this.f32271a).q(cls).t().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f32271a.toArray(new Annotation[0]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) FluentIterable.x(this.f32271a).q(cls).K(cls));
    }

    public TypeToken<?> getType() {
        return this.f6453a;
    }

    public int hashCode() {
        return this.K;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return getAnnotation(cls) != null;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f6453a);
        int i = this.K;
        StringBuilder sb = new StringBuilder(strValueOf.length() + 15);
        sb.append(strValueOf);
        sb.append(" arg");
        sb.append(i);
        return sb.toString();
    }
}
