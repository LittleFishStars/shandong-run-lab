package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final LottieNetworkCacheProvider f46176a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LottieNetworkFetcher f20962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20963a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public LottieNetworkCacheProvider f46177a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public LottieNetworkFetcher f20964a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f20965a = false;

        public class a implements LottieNetworkCacheProvider {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ File f20966a;

            public a(File file) {
                this.f20966a = file;
            }

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            @NonNull
            public File getCacheDir() {
                if (this.f20966a.isDirectory()) {
                    return this.f20966a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* JADX INFO: renamed from: com.zj.adlib.z35$b$b, reason: collision with other inner class name */
        public class C1339b implements LottieNetworkCacheProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LottieNetworkCacheProvider f46179a;

            public C1339b(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
                this.f46179a = lottieNetworkCacheProvider;
            }

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            @NonNull
            public File getCacheDir() {
                File cacheDir = this.f46179a.getCacheDir();
                if (cacheDir.isDirectory()) {
                    return cacheDir;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public z35 a() {
            return new z35(this.f20964a, this.f46177a, this.f20965a);
        }

        @NonNull
        public b b(boolean z) {
            this.f20965a = z;
            return this;
        }

        @NonNull
        public b c(@NonNull File file) {
            if (this.f46177a != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f46177a = new a(file);
            return this;
        }

        @NonNull
        public b d(@NonNull LottieNetworkCacheProvider lottieNetworkCacheProvider) {
            if (this.f46177a != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f46177a = new C1339b(lottieNetworkCacheProvider);
            return this;
        }

        @NonNull
        public b e(@NonNull LottieNetworkFetcher lottieNetworkFetcher) {
            this.f20964a = lottieNetworkFetcher;
            return this;
        }
    }

    public z35(@Nullable LottieNetworkFetcher lottieNetworkFetcher, @Nullable LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean z) {
        this.f20962a = lottieNetworkFetcher;
        this.f46176a = lottieNetworkCacheProvider;
        this.f20963a = z;
    }
}
