package com.fl.saas.common.util.feature;

import com.fl.saas.common.util.feature.Predicate;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@FunctionalInterface
public interface Predicate<T> {
    static <T> Predicate<T> isEqual(final Object obj) {
        return obj == null ? new Predicate() { // from class: com.zj.adlib.cx6
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj2) {
                return Predicate.lambda$isEqual$3(obj2);
            }
        } : new Predicate() { // from class: com.zj.adlib.ex6
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj2) {
                return obj.equals(obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$0(Predicate predicate, Object obj) {
        return test(obj) && predicate.test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$isEqual$3(Object obj) {
        return obj == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$negate$1(Object obj) {
        return !test(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$or$2(Predicate predicate, Object obj) {
        return test(obj) || predicate.test(obj);
    }

    default Predicate<T> and(final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: com.zj.adlib.ix6
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return this.f42462a.lambda$and$0(predicate, obj);
            }
        };
    }

    default Predicate<T> negate() {
        return new Predicate() { // from class: com.zj.adlib.kx6
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return this.f42939a.lambda$negate$1(obj);
            }
        };
    }

    default Predicate<T> or(final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: com.zj.adlib.gx6
            @Override // com.fl.saas.common.util.feature.Predicate
            public final boolean test(Object obj) {
                return this.f42006a.lambda$or$2(predicate, obj);
            }
        };
    }

    boolean test(T t);
}
