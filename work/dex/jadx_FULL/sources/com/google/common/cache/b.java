package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.i;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class b {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class a<K, V> implements RemovalListener<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RemovalListener f31647a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f6028a;

        /* JADX INFO: renamed from: com.google.common.cache.b$a$a, reason: collision with other inner class name */
        public class RunnableC0715a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RemovalNotification f31648a;

            public RunnableC0715a(RemovalNotification removalNotification) {
                this.f31648a = removalNotification;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f31647a.onRemoval(this.f31648a);
            }
        }

        public a(Executor executor, RemovalListener removalListener) {
            this.f6028a = executor;
            this.f31647a = removalListener;
        }

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<K, V> removalNotification) {
            this.f6028a.execute(new RunnableC0715a(removalNotification));
        }
    }

    public static <K, V> RemovalListener<K, V> a(RemovalListener<K, V> removalListener, Executor executor) {
        i.E(removalListener);
        i.E(executor);
        return new a(executor, removalListener);
    }
}
