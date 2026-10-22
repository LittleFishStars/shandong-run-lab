package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f31595a;

    public class a extends d {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, String str) {
            super(dVar, null);
            this.b = str;
        }

        @Override // com.google.common.base.d
        public d q() {
            throw new UnsupportedOperationException("already specified useForNull");
        }

        @Override // com.google.common.base.d
        public CharSequence r(@CheckForNull Object obj) {
            return obj == null ? this.b : d.this.r(obj);
        }

        @Override // com.google.common.base.d
        public d s(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public class b extends d {
        public b(d dVar) {
            super(dVar, null);
        }

        @Override // com.google.common.base.d
        public <A extends Appendable> A d(A a2, Iterator<? extends Object> it) throws IOException {
            i.F(a2, "appendable");
            i.F(it, "parts");
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    a2.append(d.this.r(next));
                    break;
                }
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                if (next2 != null) {
                    a2.append(d.this.f31595a);
                    a2.append(d.this.r(next2));
                }
            }
            return a2;
        }

        @Override // com.google.common.base.d
        public d s(String str) {
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        @Override // com.google.common.base.d
        public C0712d u(String str) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    public class c extends AbstractList<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f31598a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object[] f5943a;
        public final /* synthetic */ Object b;

        public c(Object[] objArr, Object obj, Object obj2) {
            this.f5943a = objArr;
            this.f31598a = obj;
            this.b = obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        @CheckForNull
        public Object get(int i) {
            if (i != 0) {
                return i != 1 ? this.f5943a[i - 2] : this.b;
            }
            return this.f31598a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f5943a.length + 2;
        }
    }

    /* JADX INFO: renamed from: com.google.common.base.d$d, reason: collision with other inner class name */
    public static final class C0712d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f31599a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f5944a;

        public /* synthetic */ C0712d(d dVar, String str, a aVar) {
            this(dVar, str);
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A a(A a2, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) b(a2, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A b(A a2, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            i.E(a2);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a2.append(this.f31599a.r(next.getKey()));
                a2.append(this.f5944a);
                a2.append(this.f31599a.r(next.getValue()));
                while (it.hasNext()) {
                    a2.append(this.f31599a.f31595a);
                    Map.Entry<?, ?> next2 = it.next();
                    a2.append(this.f31599a.r(next2.getKey()));
                    a2.append(this.f5944a);
                    a2.append(this.f31599a.r(next2.getValue()));
                }
            }
            return a2;
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A c(A a2, Map<?, ?> map) throws IOException {
            return (A) a(a2, map.entrySet());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder d(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return e(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder e(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                b(sb, it);
                return sb;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        @CanIgnoreReturnValue
        public StringBuilder f(StringBuilder sb, Map<?, ?> map) {
            return d(sb, map.entrySet());
        }

        @Beta
        public String g(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return h(iterable.iterator());
        }

        @Beta
        public String h(Iterator<? extends Map.Entry<?, ?>> it) {
            return e(new StringBuilder(), it).toString();
        }

        public String i(Map<?, ?> map) {
            return g(map.entrySet());
        }

        public C0712d j(String str) {
            return new C0712d(this.f31599a.s(str), this.f5944a);
        }

        public C0712d(d dVar, String str) {
            this.f31599a = dVar;
            this.f5944a = (String) i.E(str);
        }
    }

    public /* synthetic */ d(d dVar, a aVar) {
        this(dVar);
    }

    public static Iterable<Object> j(@CheckForNull Object obj, @CheckForNull Object obj2, Object[] objArr) {
        i.E(objArr);
        return new c(objArr, obj, obj2);
    }

    public static d o(char c2) {
        return new d(String.valueOf(c2));
    }

    public static d p(String str) {
        return new d(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A b(A a2, Iterable<? extends Object> iterable) throws IOException {
        return (A) d(a2, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A c(A a2, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) throws IOException {
        return (A) b(a2, j(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A d(A a2, Iterator<? extends Object> it) throws IOException {
        i.E(a2);
        if (it.hasNext()) {
            a2.append(r(it.next()));
            while (it.hasNext()) {
                a2.append(this.f31595a);
                a2.append(r(it.next()));
            }
        }
        return a2;
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A e(A a2, Object[] objArr) throws IOException {
        return (A) b(a2, Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder f(StringBuilder sb, Iterable<? extends Object> iterable) {
        return h(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder g(StringBuilder sb, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return f(sb, j(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder h(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            d(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder i(StringBuilder sb, Object[] objArr) {
        return f(sb, Arrays.asList(objArr));
    }

    public final String k(Iterable<? extends Object> iterable) {
        return m(iterable.iterator());
    }

    public final String l(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return k(j(obj, obj2, objArr));
    }

    public final String m(Iterator<? extends Object> it) {
        return h(new StringBuilder(), it).toString();
    }

    public final String n(Object[] objArr) {
        return k(Arrays.asList(objArr));
    }

    public d q() {
        return new b(this);
    }

    public CharSequence r(@CheckForNull Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public d s(String str) {
        i.E(str);
        return new a(this, str);
    }

    public C0712d t(char c2) {
        return u(String.valueOf(c2));
    }

    public C0712d u(String str) {
        return new C0712d(this, str, null);
    }

    public d(String str) {
        this.f31595a = (String) i.E(str);
    }

    public d(d dVar) {
        this.f31595a = dVar.f31595a;
    }
}
