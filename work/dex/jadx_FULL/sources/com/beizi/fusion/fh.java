package com.beizi.fusion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.pangle.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class fh {
    private static final Object f = new Object();
    private static fh g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27296a;
    private final HashMap b = new HashMap();
    private final HashMap c = new HashMap();
    private final ArrayList d = new ArrayList();
    private final Handler e;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                fh.this.a();
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f27298a;
        final ArrayList b;

        public b(Intent intent, ArrayList arrayList) {
            this.f27298a = intent;
            this.b = arrayList;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f27299a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f27299a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f27299a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private fh(Context context) {
        this.f27296a = context;
        this.e = new a(context.getMainLooper());
    }

    public static fh a(Context context) {
        fh fhVar;
        synchronized (f) {
            if (g == null) {
                g = new fh(context.getApplicationContext());
            }
            fhVar = g;
        }
        return fhVar;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            try {
                ArrayList arrayList = (ArrayList) this.b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    c cVar = (c) arrayList.get(size);
                    cVar.d = true;
                    for (int i = 0; i < cVar.f27299a.countActions(); i++) {
                        String action = cVar.f27299a.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = (c) arrayList2.get(size2);
                                if (cVar2.b == broadcastReceiver) {
                                    cVar2.d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.c.remove(action);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        String str3;
        synchronized (this.b) {
            try {
                try {
                    String action = intent.getAction();
                    String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f27296a.getContentResolver());
                    Uri data = intent.getData();
                    String scheme = intent.getScheme();
                    Set<String> categories = intent.getCategories();
                    boolean z = (intent.getFlags() & 8) != 0;
                    if (z) {
                        Log.v(LocalBroadcastManager.TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                    }
                    ArrayList arrayList3 = (ArrayList) this.c.get(intent.getAction());
                    if (arrayList3 != null) {
                        if (z) {
                            Log.v(LocalBroadcastManager.TAG, "Action list: " + arrayList3);
                        }
                        ArrayList arrayList4 = null;
                        int i2 = 0;
                        while (i2 < arrayList3.size()) {
                            c cVar = (c) arrayList3.get(i2);
                            if (z) {
                                Log.v(LocalBroadcastManager.TAG, "Matching against filter " + cVar.f27299a);
                            }
                            if (cVar.c) {
                                if (z) {
                                    Log.v(LocalBroadcastManager.TAG, "  Filter's target already added");
                                }
                                i = i2;
                                arrayList2 = arrayList3;
                                str = action;
                                str2 = strResolveTypeIfNeeded;
                                arrayList = arrayList4;
                            } else {
                                i = i2;
                                str = action;
                                arrayList = arrayList4;
                                arrayList2 = arrayList3;
                                str2 = strResolveTypeIfNeeded;
                                int iMatch = cVar.f27299a.match(action, strResolveTypeIfNeeded, scheme, data, categories, LocalBroadcastManager.TAG);
                                if (iMatch >= 0) {
                                    if (z) {
                                        Log.v(LocalBroadcastManager.TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                    }
                                    arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList4.add(cVar);
                                    cVar.c = true;
                                } else if (z) {
                                    if (iMatch == -4) {
                                        str3 = "category";
                                    } else if (iMatch == -3) {
                                        str3 = "action";
                                    } else if (iMatch != -2) {
                                        str3 = iMatch != -1 ? "unknown reason" : "type";
                                    } else {
                                        str3 = "data";
                                    }
                                    Log.v(LocalBroadcastManager.TAG, "  Filter did not match: " + str3);
                                }
                                i2 = i + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                strResolveTypeIfNeeded = str2;
                            }
                            arrayList4 = arrayList;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        }
                        ArrayList arrayList5 = arrayList4;
                        if (arrayList5 != null) {
                            for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                                ((c) arrayList5.get(i3)).c = false;
                            }
                            this.d.add(new b(intent, arrayList5));
                            if (!this.e.hasMessages(1)) {
                                this.e.sendEmptyMessage(1);
                            }
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.b) {
                size = this.d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.d.toArray(bVarArr);
                this.d.clear();
            }
            for (int i = 0; i < size; i++) {
                b bVar = bVarArr[i];
                int size2 = bVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = (c) bVar.b.get(i2);
                    if (!cVar.d) {
                        cVar.b.onReceive(this.f27296a, bVar.f27298a);
                    }
                }
            }
        }
    }
}
