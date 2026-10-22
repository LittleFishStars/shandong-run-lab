package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Keep;
import com.byazt.bog.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public final class LocalBroadcastManager {
    public static final boolean DEBUG = false;
    public static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    public static final String TAG = "LocalBroadcastManager";
    public static LocalBroadcastManager mInstance;
    public static final Object mLock = new Object();
    public final Context mAppContext;
    public final Handler mHandler;
    public final HashMap<PluginBroadcastReceiver, ArrayList<tt>> mReceivers = new HashMap<>();
    public final HashMap<String, ArrayList<tt>> mActions = new HashMap<>();
    public final ArrayList<c> mPendingBroadcasts = new ArrayList<>();

    @com.byazt.zqa.c(c = {0, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 1543})
    public static final class c {
        public final Intent c;
        public final ArrayList<tt> tt;

        public c(Intent intent, ArrayList<tt> arrayList) {
            this.c = intent;
            this.tt = arrayList;
        }
    }

    @com.byazt.zqa.c(c = {0, 80, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 800})
    public static final class tt {
        public final IntentFilter c;
        public final PluginBroadcastReceiver tt;
        public boolean uj;
        public boolean ve;

        public tt(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.c = intentFilter;
            this.tt = pluginBroadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.tt);
            sb.append(" filter=");
            sb.append(this.c);
            if (this.uj) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public void executePendingBroadcasts() {
        int size;
        c[] cVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                cVarArr = new c[size];
                this.mPendingBroadcasts.toArray(cVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                c cVar = cVarArr[i];
                int size2 = cVar.tt.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    tt ttVar = cVar.tt.get(i2);
                    if (!ttVar.uj) {
                        ttVar.tt.onReceive(this.mAppContext, cVar.c);
                    }
                }
            }
        }
    }

    public void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            tt ttVar = new tt(intentFilter, pluginBroadcastReceiver);
            ArrayList<tt> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(ttVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<tt> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(ttVar);
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<tt> arrayList2;
        String str2;
        String str3;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                a.c(TAG, "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<tt> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    a.c(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    tt ttVar = arrayList3.get(i2);
                    if (z) {
                        a.c(TAG, "Matching against filter " + ttVar.c);
                    }
                    if (ttVar.ve) {
                        if (z) {
                            a.c(TAG, "  Filter's target already added");
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
                        int iMatch = ttVar.c.match(action, strResolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (iMatch >= 0) {
                            if (z) {
                                a.c(TAG, "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(ttVar);
                            ttVar.ve = true;
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
                            a.c(TAG, "  Filter did not match: ".concat(str3));
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
                        ((tt) arrayList5.get(i3)).ve = false;
                    }
                    this.mPendingBroadcasts.add(new c(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<tt> arrayListRemove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                tt ttVar = arrayListRemove.get(size);
                ttVar.uj = true;
                for (int i = 0; i < ttVar.c.countActions(); i++) {
                    String action = ttVar.c.getAction(i);
                    ArrayList<tt> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            tt ttVar2 = arrayList.get(size2);
                            if (ttVar2.tt == pluginBroadcastReceiver) {
                                ttVar2.uj = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
