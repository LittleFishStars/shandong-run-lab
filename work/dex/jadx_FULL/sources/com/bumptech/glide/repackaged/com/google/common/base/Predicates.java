package com.bumptech.glide.repackaged.com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class Predicates {
    private static final Joiner COMMA_JOINER = Joiner.on(',');

    public static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private final T target;

        @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        private IsEqualToPredicate(T t) {
            this.target = t;
        }
    }

    public enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE { // from class: com.bumptech.glide.repackaged.com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.bumptech.glide.repackaged.com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.bumptech.glide.repackaged.com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.bumptech.glide.repackaged.com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.bumptech.glide.repackaged.com.google.common.base.Predicate
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        public <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    public static <T> Predicate<T> equalTo(T t) {
        return t == null ? isNull() : new IsEqualToPredicate(t);
    }

    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }
}
