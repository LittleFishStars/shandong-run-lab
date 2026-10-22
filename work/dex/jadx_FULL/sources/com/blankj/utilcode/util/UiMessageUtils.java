package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class UiMessageUtils implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f28211a = i.p0();
    public static final String f = "UiMessageUtils";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f1418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<List<UiMessageCallback>> f1419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f1420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<UiMessageCallback> f1421a;
    public final List<UiMessageCallback> c;

    public interface UiMessageCallback {
        void a(@NonNull b bVar);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UiMessageUtils f28212a = new UiMessageUtils();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Message f28213a;

        public b(Message message) {
            this.f28213a = message;
        }

        public int b() {
            return this.f28213a.what;
        }

        public Object c() {
            return this.f28213a.obj;
        }

        public final void d(Message message) {
            this.f28213a = message;
        }

        public String toString() {
            return "{ id=" + b() + ", obj=" + c() + " }";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiMessageUtils() {
        this.f1418a = new Handler(Looper.getMainLooper(), this);
        this.f1420a = new b(null);
        this.f1419a = new SparseArray<>();
        this.f1421a = new ArrayList();
        this.c = new ArrayList();
    }

    public static UiMessageUtils c() {
        return a.f28212a;
    }

    public void a(int i, @NonNull UiMessageCallback uiMessageCallback) {
        synchronized (this.f1419a) {
            List<UiMessageCallback> arrayList = this.f1419a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f1419a.put(i, arrayList);
            }
            if (!arrayList.contains(uiMessageCallback)) {
                arrayList.add(uiMessageCallback);
            }
        }
    }

    public void b(@NonNull UiMessageCallback uiMessageCallback) {
        synchronized (this.f1421a) {
            if (!this.f1421a.contains(uiMessageCallback)) {
                this.f1421a.add(uiMessageCallback);
            } else if (f28211a) {
                Log.w(f, "Listener is already added. " + uiMessageCallback.toString());
            }
        }
    }

    public final void d(@NonNull b bVar) {
        List<UiMessageCallback> list = this.f1419a.get(bVar.b());
        if ((list == null || list.size() == 0) && this.f1421a.size() == 0) {
            Log.w(f, "Delivering FAILED for message ID " + bVar.b() + ". No listeners. " + bVar.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Delivering message ID ");
        sb.append(bVar.b());
        sb.append(", Specific listeners: ");
        if (list == null || list.size() == 0) {
            sb.append(0);
        } else {
            sb.append(list.size());
            sb.append(" [");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).getClass().getSimpleName());
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        sb.append(", Universal listeners: ");
        synchronized (this.f1421a) {
            if (this.f1421a.size() == 0) {
                sb.append(0);
            } else {
                sb.append(this.f1421a.size());
                sb.append(" [");
                for (int i2 = 0; i2 < this.f1421a.size(); i2++) {
                    sb.append(this.f1421a.get(i2).getClass().getSimpleName());
                    if (i2 < this.f1421a.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("], Message: ");
            }
        }
        sb.append(bVar.toString());
        Log.v(f, sb.toString());
    }

    public void e(int i, @NonNull UiMessageCallback uiMessageCallback) {
        synchronized (this.f1419a) {
            List<UiMessageCallback> list = this.f1419a.get(i);
            if (list == null || list.isEmpty()) {
                if (f28211a) {
                    Log.w(f, "Trying to remove specific listener that is not registered. ID " + i + ", " + uiMessageCallback);
                }
            } else {
                if (f28211a && !list.contains(uiMessageCallback)) {
                    Log.w(f, "Trying to remove specific listener that is not registered. ID " + i + ", " + uiMessageCallback);
                    return;
                }
                list.remove(uiMessageCallback);
            }
        }
    }

    public void f(@NonNull UiMessageCallback uiMessageCallback) {
        synchronized (this.f1421a) {
            if (f28211a && !this.f1421a.contains(uiMessageCallback)) {
                Log.w(f, "Trying to remove a listener that is not registered. " + uiMessageCallback.toString());
            }
            this.f1421a.remove(uiMessageCallback);
        }
    }

    public void g(int i) {
        List<UiMessageCallback> list;
        if (f28211a && ((list = this.f1419a.get(i)) == null || list.size() == 0)) {
            Log.w(f, "Trying to remove specific listeners that are not registered. ID " + i);
        }
        synchronized (this.f1419a) {
            this.f1419a.delete(i);
        }
    }

    public final void h(int i) {
        this.f1418a.sendEmptyMessage(i);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.f1420a.d(message);
        if (f28211a) {
            d(this.f1420a);
        }
        synchronized (this.f1419a) {
            List<UiMessageCallback> list = this.f1419a.get(message.what);
            if (list != null) {
                if (list.size() == 0) {
                    this.f1419a.remove(message.what);
                } else {
                    this.c.addAll(list);
                    Iterator<UiMessageCallback> it = this.c.iterator();
                    while (it.hasNext()) {
                        it.next().a(this.f1420a);
                    }
                    this.c.clear();
                }
            }
        }
        synchronized (this.f1421a) {
            if (this.f1421a.size() > 0) {
                this.c.addAll(this.f1421a);
                Iterator<UiMessageCallback> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.f1420a);
                }
                this.c.clear();
            }
        }
        this.f1420a.d(null);
        return true;
    }

    public final void i(int i, @NonNull Object obj) {
        Handler handler = this.f1418a;
        handler.sendMessage(handler.obtainMessage(i, obj));
    }
}
