package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.core.util.Predicate;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@SuppressLint({"UnknownNullness"})
public interface Predicate<T> {
    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> isEqual(@SuppressLint({"MissingNullability"}) final Object obj) {
        return obj == null ? new Predicate() { // from class: com.zj.adlib.fx6
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                return Objects.isNull(obj2);
            }
        } : new Predicate(obj) { // from class: com.zj.adlib.hx6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f42227a;

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default boolean lambda$and$0(Predicate predicate, Object obj) {
        return test(obj) && predicate.test(obj);
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

    @SuppressLint({"MissingNullability"})
    static <T> Predicate<T> not(@SuppressLint({"MissingNullability"}) Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> and(@SuppressLint({"MissingNullability"}) final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate(this, predicate) { // from class: com.zj.adlib.jx6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Predicate f42696a;
            public final /* synthetic */ Predicate b;

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> negate() {
        return new Predicate(this) { // from class: com.zj.adlib.lx6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Predicate f43180a;

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
            }
        };
    }

    @SuppressLint({"MissingNullability"})
    default Predicate<T> or(@SuppressLint({"MissingNullability"}) final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate(this, predicate) { // from class: com.zj.adlib.dx6

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Predicate f41300a;
            public final /* synthetic */ Predicate b;

            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
            }
        };
    }

    boolean test(T t);
}
