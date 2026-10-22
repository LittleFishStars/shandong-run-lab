package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f32054a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f6262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public final List<NodeConnection<N>> f6263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<N, Object> f6264a;
    public int b;

    public static abstract class NodeConnection<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final N f32055a;

        public static final class a<N> extends NodeConnection<N> {
            public a(N n) {
                super(n);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof a) {
                    return this.f32055a.equals(((a) obj).f32055a);
                }
                return false;
            }

            public int hashCode() {
                return a.class.hashCode() + this.f32055a.hashCode();
            }
        }

        public static final class b<N> extends NodeConnection<N> {
            public b(N n) {
                super(n);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof b) {
                    return this.f32055a.equals(((b) obj).f32055a);
                }
                return false;
            }

            public int hashCode() {
                return b.class.hashCode() + this.f32055a.hashCode();
            }
        }

        public NodeConnection(N n) {
            this.f32055a = (N) com.google.common.base.i.E(n);
        }
    }

    public class a extends AbstractSet<N> {

        /* JADX INFO: renamed from: com.google.common.graph.DirectedGraphConnections$a$a, reason: collision with other inner class name */
        public class C0744a extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f32057a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Set f6265a;

            public C0744a(a aVar, Iterator it, Set set) {
                this.f32057a = it;
                this.f6265a = set;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N computeNext() {
                while (this.f32057a.hasNext()) {
                    NodeConnection nodeConnection = (NodeConnection) this.f32057a.next();
                    if (this.f6265a.add(nodeConnection.f32055a)) {
                        return nodeConnection.f32055a;
                    }
                }
                return endOfData();
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<N> iterator() {
            return new C0744a(this, DirectedGraphConnections.this.f6263a.iterator(), new HashSet());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return DirectedGraphConnections.this.f6264a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DirectedGraphConnections.this.f6264a.size();
        }
    }

    public class b extends AbstractSet<N> {

        public class a extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f32059a;

            public a(b bVar, Iterator it) {
                this.f32059a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N computeNext() {
                while (this.f32059a.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f32059a.next();
                    if (DirectedGraphConnections.p(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.DirectedGraphConnections$b$b, reason: collision with other inner class name */
        public class C0745b extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f32060a;

            public C0745b(b bVar, Iterator it) {
                this.f32060a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N computeNext() {
                while (this.f32060a.hasNext()) {
                    NodeConnection nodeConnection = (NodeConnection) this.f32060a.next();
                    if (nodeConnection instanceof NodeConnection.a) {
                        return nodeConnection.f32055a;
                    }
                }
                return endOfData();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<N> iterator() {
            return DirectedGraphConnections.this.f6263a == null ? new a(this, DirectedGraphConnections.this.f6264a.entrySet().iterator()) : new C0745b(this, DirectedGraphConnections.this.f6263a.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return DirectedGraphConnections.p(DirectedGraphConnections.this.f6264a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DirectedGraphConnections.this.f6262a;
        }
    }

    public class c extends AbstractSet<N> {

        public class a extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f32062a;

            public a(c cVar, Iterator it) {
                this.f32062a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N computeNext() {
                while (this.f32062a.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f32062a.next();
                    if (DirectedGraphConnections.q(entry.getValue())) {
                        return (N) entry.getKey();
                    }
                }
                return endOfData();
            }
        }

        public class b extends AbstractIterator<N> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f32063a;

            public b(c cVar, Iterator it) {
                this.f32063a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public N computeNext() {
                while (this.f32063a.hasNext()) {
                    NodeConnection nodeConnection = (NodeConnection) this.f32063a.next();
                    if (nodeConnection instanceof NodeConnection.b) {
                        return nodeConnection.f32055a;
                    }
                }
                return endOfData();
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<N> iterator() {
            return DirectedGraphConnections.this.f6263a == null ? new a(this, DirectedGraphConnections.this.f6264a.entrySet().iterator()) : new b(this, DirectedGraphConnections.this.f6263a.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return DirectedGraphConnections.q(DirectedGraphConnections.this.f6264a.get(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return DirectedGraphConnections.this.b;
        }
    }

    public class d implements Function<N, EndpointPair<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f32064a;

        public d(DirectedGraphConnections directedGraphConnections, Object obj) {
            this.f32064a = obj;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EndpointPair<N> apply(N n) {
            return EndpointPair.h(n, this.f32064a);
        }
    }

    public class e implements Function<N, EndpointPair<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f32065a;

        public e(DirectedGraphConnections directedGraphConnections, Object obj) {
            this.f32065a = obj;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EndpointPair<N> apply(N n) {
            return EndpointPair.h(this.f32065a, n);
        }
    }

    public class f implements Function<NodeConnection<N>, EndpointPair<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f32066a;

        public f(DirectedGraphConnections directedGraphConnections, Object obj) {
            this.f32066a = obj;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EndpointPair<N> apply(NodeConnection<N> nodeConnection) {
            return nodeConnection instanceof NodeConnection.b ? EndpointPair.h(this.f32066a, nodeConnection.f32055a) : EndpointPair.h(nodeConnection.f32055a, this.f32066a);
        }
    }

    public class g extends AbstractIterator<EndpointPair<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f32067a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicBoolean f6266a;

        public g(DirectedGraphConnections directedGraphConnections, Iterator it, AtomicBoolean atomicBoolean) {
            this.f32067a = it;
            this.f6266a = atomicBoolean;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public EndpointPair<N> computeNext() {
            while (this.f32067a.hasNext()) {
                EndpointPair<N> endpointPair = (EndpointPair) this.f32067a.next();
                if (!endpointPair.d().equals(endpointPair.e()) || !this.f6266a.getAndSet(true)) {
                    return endpointPair;
                }
            }
            return endOfData();
        }
    }

    public static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32068a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f32068a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32068a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f32069a;

        public i(Object obj) {
            this.f32069a = obj;
        }
    }

    public DirectedGraphConnections(Map<N, Object> map, @CheckForNull List<NodeConnection<N>> list, int i2, int i3) {
        this.f6264a = (Map) com.google.common.base.i.E(map);
        this.f6263a = list;
        this.f6262a = Graphs.b(i2);
        this.b = Graphs.b(i3);
        com.google.common.base.i.g0(i2 <= map.size() && i3 <= map.size());
    }

    public static boolean p(@CheckForNull Object obj) {
        return obj == f32054a || (obj instanceof i);
    }

    public static boolean q(@CheckForNull Object obj) {
        return (obj == f32054a || obj == null) ? false : true;
    }

    public static <N, V> DirectedGraphConnections<N, V> r(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i2 = h.f32068a[elementOrder.h().ordinal()];
        if (i2 == 1) {
            arrayList = null;
        } else {
            if (i2 != 2) {
                throw new AssertionError(elementOrder.h());
            }
            arrayList = new ArrayList();
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> DirectedGraphConnections<N, V> s(N n, Iterable<EndpointPair<N>> iterable, Function<N, V> function) {
        com.google.common.base.i.E(n);
        com.google.common.base.i.E(function);
        HashMap map = new HashMap();
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        int i2 = 0;
        int i3 = 0;
        for (EndpointPair<N> endpointPair : iterable) {
            if (endpointPair.d().equals(n) && endpointPair.e().equals(n)) {
                map.put(n, new i(function.apply(n)));
                aVarBuilder.a(new NodeConnection.a(n));
                aVarBuilder.a(new NodeConnection.b(n));
                i2++;
            } else if (endpointPair.e().equals(n)) {
                N nD = endpointPair.d();
                Object objPut = map.put(nD, f32054a);
                if (objPut != null) {
                    map.put(nD, new i(objPut));
                }
                aVarBuilder.a(new NodeConnection.a(nD));
                i2++;
            } else {
                com.google.common.base.i.d(endpointPair.d().equals(n));
                N nE = endpointPair.e();
                V vApply = function.apply(nE);
                Object objPut2 = map.put(nE, vApply);
                if (objPut2 != null) {
                    com.google.common.base.i.d(objPut2 == f32054a);
                    map.put(nE, new i(vApply));
                }
                aVarBuilder.a(new NodeConnection.b(nE));
            }
            i3++;
        }
        return new DirectedGraphConnections<>(map, aVarBuilder.e(), i2, i3);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> a() {
        return new b();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> b() {
        return this.f6263a == null ? Collections.unmodifiableSet(this.f6264a.keySet()) : new a();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> c() {
        return new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V d(N n) {
        com.google.common.base.i.E(n);
        V v = (V) this.f6264a.get(n);
        if (v == f32054a) {
            return null;
        }
        return v instanceof i ? (V) ((i) v).f32069a : v;
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> e(N n) {
        com.google.common.base.i.E(n);
        List<NodeConnection<N>> list = this.f6263a;
        return new g(this, list == null ? Iterators.j(Iterators.c0(a().iterator(), new d(this, n)), Iterators.c0(c().iterator(), new e(this, n))) : Iterators.c0(list.iterator(), new f(this, n)), new AtomicBoolean(false));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.graph.GraphConnections
    public void f(N n) {
        boolean z;
        List<NodeConnection<N>> list;
        com.google.common.base.i.E(n);
        Object obj = this.f6264a.get(n);
        if (obj != f32054a) {
            if (obj instanceof i) {
                this.f6264a.put(n, ((i) obj).f32069a);
            } else {
                z = false;
            }
            if (z) {
                int i2 = this.f6262a - 1;
                this.f6262a = i2;
                Graphs.b(i2);
                list = this.f6263a;
                if (list != null) {
                    list.remove(new NodeConnection.a(n));
                }
            }
        }
        this.f6264a.remove(n);
        z = true;
        if (z) {
            int i3 = this.f6262a - 1;
            this.f6262a = i3;
            Graphs.b(i3);
            list = this.f6263a;
            if (list != null) {
                list.remove(new NodeConnection.a(n));
            }
        }
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V g(Object obj) {
        Object obj2;
        com.google.common.base.i.E(obj);
        Object obj3 = this.f6264a.get(obj);
        if (obj3 == null || obj3 == (obj2 = f32054a)) {
            obj3 = null;
        } else if (obj3 instanceof i) {
            this.f6264a.put(obj, obj2);
            obj3 = ((i) obj3).f32069a;
        } else {
            this.f6264a.remove(obj);
        }
        if (obj3 != null) {
            int i2 = this.b - 1;
            this.b = i2;
            Graphs.b(i2);
            List<NodeConnection<N>> list = this.f6263a;
            if (list != null) {
                list.remove(new NodeConnection.b(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return (V) obj3;
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V h(N n, V v) {
        Object objPut = this.f6264a.put(n, v);
        if (objPut == null) {
            objPut = null;
        } else if (objPut instanceof i) {
            this.f6264a.put(n, new i(v));
            objPut = ((i) objPut).f32069a;
        } else if (objPut == f32054a) {
            this.f6264a.put(n, new i(v));
            objPut = null;
        }
        if (objPut == null) {
            int i2 = this.b + 1;
            this.b = i2;
            Graphs.d(i2);
            List<NodeConnection<N>> list = this.f6263a;
            if (list != null) {
                list.add(new NodeConnection.b(n));
            }
        }
        if (objPut == null) {
            return null;
        }
        return (V) objPut;
    }

    @Override // com.google.common.graph.GraphConnections
    public void i(N n, V v) {
        boolean z;
        Map<N, Object> map = this.f6264a;
        Object obj = f32054a;
        Object objPut = map.put(n, obj);
        if (objPut == null) {
            z = true;
        } else {
            z = false;
            if (objPut instanceof i) {
                this.f6264a.put(n, objPut);
            } else if (objPut != obj) {
                this.f6264a.put(n, new i(objPut));
                z = true;
            }
        }
        if (z) {
            int i2 = this.f6262a + 1;
            this.f6262a = i2;
            Graphs.d(i2);
            List<NodeConnection<N>> list = this.f6263a;
            if (list != null) {
                list.add(new NodeConnection.a(n));
            }
        }
    }
}
