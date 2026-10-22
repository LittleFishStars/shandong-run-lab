package com.alibaba.triver.utils;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f25271a;

    public static class a extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<Runnable> f25272a;

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            List<Runnable> list = this.f25272a;
            if (list == null || list.isEmpty()) {
                return null;
            }
            for (Runnable runnable : this.f25272a) {
                if (runnable != null) {
                    runnable.run();
                }
            }
            return null;
        }

        private a(List<Runnable> list) {
            this.f25272a = list;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<Runnable> f25273a = new ArrayList();

        public b a(Runnable runnable) {
            this.f25273a.add(runnable);
            return this;
        }

        public e a() {
            return new e(this.f25273a);
        }
    }

    public void a() {
        this.f25271a.executeOnExecutor(h.a().b(), new Void[0]);
    }

    public void b() {
        this.f25271a.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    private e(List<Runnable> list) {
        this.f25271a = new a(list);
    }

    public static void a(Runnable... runnableArr) {
        new a(Arrays.asList(runnableArr)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void b(Runnable... runnableArr) {
        new a(Arrays.asList(runnableArr)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }
}
