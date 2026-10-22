package com.byazt.ip;

import android.text.TextUtils;
import com.byazt.ip.tt;
import com.byazt.nr.da;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1363, 15})
public abstract class uj<T, F extends tt> {
    public final Map<String, ve<T, F>> c = new ConcurrentHashMap();
    public final List<Object> tt = new CopyOnWriteArrayList();
    public Map<String, String> ve = new ConcurrentHashMap();

    public interface c {
        void c(tt ttVar);
    }

    public tt getContext(String str) {
        ve<T, F> veVar;
        if (str == null || (veVar = this.c.get(str)) == null) {
            return null;
        }
        return veVar.getContext();
    }

    public String tt(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<String> it = this.ve.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            String next = it.next();
            if (!TextUtils.isEmpty(next) && str.contains(next)) {
                str2 = this.ve.get(next);
                str3 = next;
                break;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            this.ve.remove(str3);
        }
        return str2;
    }

    public void c(String str, c cVar) {
        ve<T, F> veVar;
        if (cVar == null || str == null || (veVar = this.c.get(str)) == null) {
            return;
        }
        cVar.c(veVar.getContext());
    }

    public final void c(String str, a<? extends tt> aVar) {
        ve<T, F> veVar;
        if (str == null || (veVar = this.c.get(str)) == null) {
            return;
        }
        veVar.c(aVar);
    }

    private void c(final ve<?, ?> veVar) {
        if (veVar == null) {
            return;
        }
        da.ve().post(new Runnable() { // from class: com.byazt.ip.uj.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = uj.this.tt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    public void c(String str, ve<T, F> veVar) {
        if (str != null && veVar != null) {
            this.c.put(str, veVar);
        }
        c((ve<?, ?>) veVar);
    }

    public ve<T, F> c(String str) {
        if (str != null) {
            return this.c.get(str);
        }
        return null;
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.ve.put(str, str2);
    }
}
