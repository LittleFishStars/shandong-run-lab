package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f32082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<E, ?> f6276a;

    public class a extends AbstractIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Iterator f6277a;

        public a(Iterator it) {
            this.f6277a = it;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public E computeNext() {
            while (this.f6277a.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f6277a.next();
                if (MultiEdgesConnecting.this.f32082a.equals(entry.getValue())) {
                    return (E) entry.getKey();
                }
            }
            return endOfData();
        }
    }

    public MultiEdgesConnecting(Map<E, ?> map, Object obj) {
        this.f6276a = (Map) com.google.common.base.i.E(map);
        this.f32082a = com.google.common.base.i.E(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator<E> iterator() {
        return new a(this.f6276a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return this.f32082a.equals(this.f6276a.get(obj));
    }
}
