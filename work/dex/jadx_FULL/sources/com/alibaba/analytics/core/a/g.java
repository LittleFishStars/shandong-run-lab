package com.alibaba.analytics.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.alibaba.analytics.a.x;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f23757a;
    private boolean p = false;
    private Map<String, String> k = Collections.synchronizedMap(new HashMap());
    private Map<String, List<b>> h = Collections.synchronizedMap(new HashMap());

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            x.a().submit(new Runnable() { // from class: com.alibaba.analytics.core.a.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = context.getPackageName();
                        if (TextUtils.isEmpty(packageName)) {
                            return;
                        }
                        String str = intent.getPackage();
                        if (!TextUtils.isEmpty(str) && packageName.equalsIgnoreCase(str)) {
                            g.this.e(intent.getStringExtra(CachedContentIndex.a.e), intent.getStringExtra("value"));
                        }
                    } catch (Throwable th) {
                        com.alibaba.analytics.a.j.e("UTClientConfigMgr", th, new Object[0]);
                    }
                }
            });
        }
    }

    public interface b {
        String getKey();

        void p(String str);
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(String str, String str2) {
        com.alibaba.analytics.a.j.d("UTClientConfigMgr", "dispatchConfig key", str, "value", str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.k.put(str, str2);
        List<b> list = this.h.get(str);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).p(str2);
            }
        }
    }

    public synchronized String get(String str) {
        return this.k.get(str);
    }

    public synchronized void init() {
        try {
            if (this.p) {
                return;
            }
            try {
                com.alibaba.analytics.core.a.a().getContext().registerReceiver(new a(), new IntentFilter("com.alibaba.analytics.config.change"));
                this.p = true;
                com.alibaba.analytics.a.j.d("UTClientConfigMgr", "registerReceiver");
            } catch (Throwable th) {
                com.alibaba.analytics.a.j.w("UTClientConfigMgr", th, new Object[0]);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static g a() {
        if (f23757a == null) {
            synchronized (g.class) {
                if (f23757a == null) {
                    f23757a = new g();
                }
            }
        }
        return f23757a;
    }

    public synchronized void a(b bVar) {
        List<b> arrayList;
        if (bVar != null) {
            if (!TextUtils.isEmpty(bVar.getKey())) {
                String key = bVar.getKey();
                if (this.k.containsKey(key)) {
                    bVar.p(this.k.get(key));
                }
                if (this.h.get(key) == null) {
                    arrayList = new ArrayList<>();
                } else {
                    arrayList = this.h.get(key);
                }
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
                this.h.put(key, arrayList);
            }
        }
    }
}
