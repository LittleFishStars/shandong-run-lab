package com.aliyun.credentials.provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class RefreshResult<T> {
    private final long staleTime;
    private final T value;

    public static final class Builder<T> {
        private long staleTime;
        private final T value;

        public RefreshResult<T> build() {
            return new RefreshResult<>(this);
        }

        public Builder<T> staleTime(long j) {
            this.staleTime = j;
            return this;
        }

        private Builder(T t) {
            this.value = t;
        }
    }

    public static <T> Builder<T> builder(T t) {
        return new Builder<>(t);
    }

    public long staleTime() {
        return this.staleTime;
    }

    public T value() {
        return this.value;
    }

    private RefreshResult(Builder<T> builder) {
        this.value = (T) ((Builder) builder).value;
        this.staleTime = ((Builder) builder).staleTime;
    }
}
