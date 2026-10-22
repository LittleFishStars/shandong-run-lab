package android.taobao.windvane.jsbridge;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.d.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class WVPluginEntryManager {
    private Map<String, Object> entryMap = new HashMap();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private Context mContext;
    private b mWebView;

    public WVPluginEntryManager(Context context, b bVar) {
        this.mContext = null;
        this.mWebView = null;
        this.mContext = context;
        this.mWebView = bVar;
    }

    public void addEntry(String str, Object obj) {
        this.lock.writeLock().lock();
        try {
            this.entryMap.put(str, obj);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public Object getEntry(String str) {
        if (this.mContext == null) {
            return "null";
        }
        this.lock.readLock().lock();
        try {
            Object obj = this.entryMap.get(str);
            this.lock.readLock().unlock();
            if (obj == null) {
                this.lock.writeLock().lock();
                try {
                    if (this.entryMap.get(str) == null) {
                        WVApiPlugin wVApiPluginCreatePlugin = WVPluginManager.createPlugin(str, this.mContext, this.mWebView);
                        if (wVApiPluginCreatePlugin != null) {
                            this.entryMap.put(str, wVApiPluginCreatePlugin);
                            obj = wVApiPluginCreatePlugin;
                        }
                    } else {
                        obj = this.entryMap.get(str);
                    }
                } finally {
                    this.lock.writeLock().unlock();
                }
            }
            return obj;
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public b getWebView() {
        return this.mWebView;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onActivityResult(i, i2, intent);
                }
            }
            this.lock.readLock().unlock();
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public void onDestroy() {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onDestroy();
                }
            }
            this.lock.readLock().unlock();
            this.lock.writeLock().lock();
            try {
                this.entryMap.clear();
                this.mContext = null;
            } finally {
                this.lock.writeLock().unlock();
            }
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public void onPause() {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onPause();
                }
            }
            this.lock.readLock().unlock();
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public void onResume() {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onResume();
                }
            }
            this.lock.readLock().unlock();
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.lock.readLock().lock();
        try {
            for (Object obj : this.entryMap.values()) {
                if (obj instanceof WVApiPlugin) {
                    ((WVApiPlugin) obj).onScrollChanged(i, i2, i3, i4);
                }
            }
            this.lock.readLock().unlock();
        } catch (Throwable th) {
            this.lock.readLock().unlock();
            throw th;
        }
    }
}
