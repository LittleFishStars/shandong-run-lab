package com.czhj.sdk.common.mta;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BuriedPointManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29397a = 500000;
    private static volatile BuriedPointManager f;
    private volatile boolean e;
    private volatile SQLiteDatabase h;
    private int i;
    private volatile RepeatingHandlerRunnable j;
    private final ReadWriteLock b = new ReentrantReadWriteLock();
    private HashMap<Integer, String> c = null;
    private List<String> d = null;
    private final Set<Integer> g = new HashSet();

    private BuriedPointManager() {
    }

    private synchronized HashMap<Integer, String> a(int i) {
        HashMap<Integer, String> map;
        map = new HashMap<>();
        try {
            Cursor cursorRawQuery = this.h.rawQuery("select * from point where item not null order by point_id", null);
            if (cursorRawQuery != null) {
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        int columnIndex = cursorRawQuery.getColumnIndex("item");
                        int columnIndex2 = cursorRawQuery.getColumnIndex("point_id");
                        int columnIndex3 = cursorRawQuery.getColumnIndex("encryption");
                        for (int i2 = 0; i2 < i; i2++) {
                            String string = cursorRawQuery.getString(columnIndex);
                            Integer numValueOf = Integer.valueOf(cursorRawQuery.getInt(columnIndex2));
                            int i3 = cursorRawQuery.getInt(columnIndex3);
                            if (!TextUtils.isEmpty(string)) {
                                if (i3 != 1) {
                                    map.put(numValueOf, string);
                                } else if (!TextUtils.isEmpty(AESUtil.DecryptString(string, Constants.AESKEY))) {
                                    string = AESUtil.DecryptString(string, Constants.AESKEY);
                                    map.put(numValueOf, string);
                                }
                            }
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th3) {
            SigmobLog.e("getlogs fail", th3);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            long jQueryNumEntries = DatabaseUtils.queryNumEntries(this.h, SQLiteMTAHelper.TABLE_POINT);
            if (jQueryNumEntries <= 500000) {
                return;
            }
            a(jQueryNumEntries - 500000);
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    private void a(long j) {
        try {
            this.h.execSQL("delete from point where point_id in (  select point_id from point order by point_id  limit " + j + " )");
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    private void a(String str, final boolean z) {
        this.e = true;
        BuriedPointRequest.BuriedPointSend(str, new BuriedPointRequest.RequestListener() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3
            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onErrorResponse(VolleyError volleyError) {
                BuriedPointManager.this.e = false;
                BuriedPointManager.this.c = null;
                SigmobLog.e(volleyError.getMessage());
            }

            @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
            public void onSuccess() {
                if (z) {
                    ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BuriedPointManager.this.d();
                        }
                    });
                }
            }
        });
    }

    private void a(Set<Integer> set) {
        try {
            Iterator<Integer> it = set.iterator();
            if (!it.hasNext()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("delete from ");
            sb.append(SQLiteMTAHelper.TABLE_POINT);
            sb.append(" where point_id in ( ");
            while (true) {
                sb.append(it.next());
                if (!it.hasNext()) {
                    sb.append(" )");
                    this.h.execSQL(sb.toString());
                    return;
                } else {
                    sb.append(',');
                    sb.append(' ');
                }
            }
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.h.execSQL("delete from point where item is null");
        } catch (Throwable th) {
            SigmobLog.e("clearLogDB fail", th);
        }
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        List<String> list = this.d;
        if (list != null && !list.isEmpty()) {
            this.i = this.d.size();
            Iterator<String> it = this.d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b.writeLock().lock();
        HashMap<Integer, String> map = this.c;
        if (map != null && !map.isEmpty()) {
            a(this.c.keySet());
            this.e = false;
            this.c = null;
        }
        this.b.writeLock().unlock();
    }

    public static String deflateAndBase64(String str) throws IOException {
        if (str == null || str.isEmpty()) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
        deflaterOutputStream.flush();
        deflaterOutputStream.close();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private void e() {
        List<String> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.d.size();
        int i = this.i;
        if (size > i) {
            List<String> list2 = this.d;
            this.d = list2.subList(i, list2.size() - 1);
        } else {
            this.d.clear();
        }
        this.i = 0;
    }

    public static BuriedPointManager getInstance() {
        if (f == null) {
            synchronized (BuriedPointManager.class) {
                if (f == null) {
                    f = new BuriedPointManager();
                }
            }
        }
        return f;
    }

    public void addWaitSend(String str) {
        if (this.d == null) {
            this.d = new LinkedList();
        }
        this.d.add(str);
    }

    public void clearLogDB() {
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.czhj.sdk.common.mta.BuriedPointManager.2
            @Override // java.lang.Runnable
            public void run() {
                BuriedPointManager.this.b();
                BuriedPointManager.this.a();
            }
        });
    }

    public Set<Integer> getLogBlackList() {
        return this.g;
    }

    public String sendPoint() {
        HashMap<Integer, String> map;
        String uRLEncoded = null;
        try {
            this.b.readLock().lock();
            if (!this.e && ((map = this.c) == null || map.isEmpty())) {
                StringBuilder sb = new StringBuilder();
                HashMap<Integer, String> mapA = a(Config.sharedInstance().getMax_send_log_records());
                this.c = mapA;
                if (!mapA.isEmpty()) {
                    sb.append("[");
                    Iterator<String> it = this.c.values().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next());
                        if (it.hasNext()) {
                            sb.append(",");
                        }
                    }
                    sb.append("]");
                    String string = sb.toString();
                    String str = "_batch_value=" + string;
                    try {
                        SigmobLog.d("_batch_value: " + string);
                        SigmobLog.d("BPLog_Count: " + this.c.size());
                        uRLEncoded = PointEntitySuper.toURLEncoded(deflateAndBase64(str));
                        a(uRLEncoded, true);
                    } catch (IOException e) {
                        SigmobLog.e(e.getMessage());
                    }
                    return uRLEncoded;
                }
            }
            this.b.readLock().unlock();
            return null;
        } catch (Throwable th) {
            try {
                SigmobLog.e("sendPoint fail ", th);
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public synchronized void start() {
        if (this.h == null || this.j == null) {
            this.h = SQLiteMTAHelper.getInstance().getWritableDatabase();
            clearLogDB();
            HandlerThread handlerThread = new HandlerThread("sendLog");
            handlerThread.start();
            this.j = new RepeatingHandlerRunnable(new Handler(handlerThread.getLooper())) { // from class: com.czhj.sdk.common.mta.BuriedPointManager.1
                @Override // com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable
                public void doWork() {
                    try {
                        BuriedPointManager.this.sendPoint();
                        BuriedPointManager.this.j.startRepeating(((long) Config.sharedInstance().getSend_log_interval()) * 1000);
                    } catch (Throwable th) {
                        SigmobLog.e("retryFaildTracking error " + th.getMessage());
                    }
                }
            };
            this.j.startRepeating(((long) Config.sharedInstance().getSend_log_interval()) * 1000);
        }
    }
}
