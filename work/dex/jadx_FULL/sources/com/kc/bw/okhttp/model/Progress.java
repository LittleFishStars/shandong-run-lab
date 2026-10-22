package com.kc.bw.okhttp.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.kc.bw.okhttp.request.base.Request;
import com.kc.bw.okhttp.utils.IOUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class Progress implements Serializable {
    public static final int ERROR = 4;
    public static final int FINISH = 5;
    public static final int LOADING = 2;
    public static final int NONE = 0;
    public static final int PAUSE = 3;
    public static final int WAITING = 1;
    public static final long serialVersionUID = 6353658567594109891L;
    public long currentSize;
    public Throwable exception;
    public Serializable extra1;
    public Serializable extra2;
    public Serializable extra3;
    public String fileName;
    public String filePath;
    public String folder;
    public float fraction;
    public Request<?, ? extends Request> request;
    public transient long speed;
    public int status;
    public String tag;
    public transient long tempSize;
    public String url;
    public static final String TAG = dexg.dexa("ubh");
    public static final String URL = dexg.dexa("vsm");
    public static final String FOLDER = dexg.dexa("gpmefs");
    public static final String FILE_PATH = dexg.dexa("gjmfQbui");
    public static final String FILE_NAME = dexg.dexa("gjmfObnf");
    public static final String FRACTION = dexg.dexa("gsbdujpo");
    public static final String TOTAL_SIZE = dexg.dexa("upubmTj{f");
    public static final String CURRENT_SIZE = dexg.dexa("dvssfouTj{f");
    public static final String STATUS = dexg.dexa("tubuvt");
    public static final String PRIORITY = dexg.dexa("qsjpsjuz");
    public static final String DATE = dexg.dexa("ebuf");
    public static final String REQUEST = dexg.dexa("sfrvftu");
    public static final String EXTRA1 = dexg.dexa("fyusb2");
    public static final String EXTRA2 = dexg.dexa("fyusb3");
    public static final String EXTRA3 = dexg.dexa("fyusb4");
    public transient long lastRefreshTime = SystemClock.elapsedRealtime();
    public long totalSize = -1;
    public int priority = 0;
    public long date = System.currentTimeMillis();
    public transient List<Long> speedBuffer = new ArrayList();

    @Keep
    public interface Action {
        void call(Progress progress);
    }

    private long bufferSpeed(long j) {
        this.speedBuffer.add(Long.valueOf(j));
        if (this.speedBuffer.size() > 10) {
            this.speedBuffer.remove(0);
        }
        Iterator<Long> it = this.speedBuffer.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue = (long) (jLongValue + it.next().longValue());
        }
        return jLongValue / ((long) this.speedBuffer.size());
    }

    public static ContentValues buildContentValues(Progress progress) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAG, progress.tag);
        contentValues.put(URL, progress.url);
        contentValues.put(FOLDER, progress.folder);
        contentValues.put(FILE_PATH, progress.filePath);
        contentValues.put(FILE_NAME, progress.fileName);
        contentValues.put(FRACTION, Float.valueOf(progress.fraction));
        contentValues.put(TOTAL_SIZE, Long.valueOf(progress.totalSize));
        contentValues.put(CURRENT_SIZE, Long.valueOf(progress.currentSize));
        contentValues.put(STATUS, Integer.valueOf(progress.status));
        contentValues.put(PRIORITY, Integer.valueOf(progress.priority));
        contentValues.put(DATE, Long.valueOf(progress.date));
        contentValues.put(REQUEST, IOUtils.toByteArray(progress.request));
        contentValues.put(EXTRA1, IOUtils.toByteArray(progress.extra1));
        contentValues.put(EXTRA2, IOUtils.toByteArray(progress.extra2));
        contentValues.put(EXTRA3, IOUtils.toByteArray(progress.extra3));
        return contentValues;
    }

    public static ContentValues buildUpdateContentValues(Progress progress) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FRACTION, Float.valueOf(progress.fraction));
        contentValues.put(TOTAL_SIZE, Long.valueOf(progress.totalSize));
        contentValues.put(CURRENT_SIZE, Long.valueOf(progress.currentSize));
        contentValues.put(STATUS, Integer.valueOf(progress.status));
        contentValues.put(PRIORITY, Integer.valueOf(progress.priority));
        contentValues.put(DATE, Long.valueOf(progress.date));
        return contentValues;
    }

    public static Progress changeProgress(Progress progress, long j, long j2, Action action) {
        progress.totalSize = j2;
        progress.currentSize += j;
        progress.tempSize += j;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = progress.lastRefreshTime;
        if (jElapsedRealtime - j3 >= OkHttp.REFRESH_TIME || progress.currentSize == j2) {
            long j4 = jElapsedRealtime - j3;
            if (j4 == 0) {
                j4 = 1;
            }
            progress.fraction = (progress.currentSize * 1.0f) / j2;
            progress.speed = progress.bufferSpeed((progress.tempSize * 1000) / j4);
            progress.lastRefreshTime = jElapsedRealtime;
            progress.tempSize = 0L;
            if (action != null) {
                action.call(progress);
            }
        }
        return progress;
    }

    public static Progress changeProgress(Progress progress, long j, Action action) {
        return changeProgress(progress, j, progress.totalSize, action);
    }

    public static Progress parseCursorToBean(Cursor cursor) {
        Progress progress = new Progress();
        progress.tag = cursor.getString(cursor.getColumnIndex(TAG));
        progress.url = cursor.getString(cursor.getColumnIndex(URL));
        progress.folder = cursor.getString(cursor.getColumnIndex(FOLDER));
        progress.filePath = cursor.getString(cursor.getColumnIndex(FILE_PATH));
        progress.fileName = cursor.getString(cursor.getColumnIndex(FILE_NAME));
        progress.fraction = cursor.getFloat(cursor.getColumnIndex(FRACTION));
        progress.totalSize = cursor.getLong(cursor.getColumnIndex(TOTAL_SIZE));
        progress.currentSize = cursor.getLong(cursor.getColumnIndex(CURRENT_SIZE));
        progress.status = cursor.getInt(cursor.getColumnIndex(STATUS));
        progress.priority = cursor.getInt(cursor.getColumnIndex(PRIORITY));
        progress.date = cursor.getLong(cursor.getColumnIndex(DATE));
        progress.request = (Request) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(REQUEST)));
        progress.extra1 = (Serializable) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(EXTRA1)));
        progress.extra2 = (Serializable) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(EXTRA2)));
        progress.extra3 = (Serializable) IOUtils.toObject(cursor.getBlob(cursor.getColumnIndex(EXTRA3)));
        return progress;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Progress.class != obj.getClass()) {
            return false;
        }
        String str = this.tag;
        String str2 = ((Progress) obj).tag;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public void from(Progress progress) {
        this.totalSize = progress.totalSize;
        this.currentSize = progress.currentSize;
        this.fraction = progress.fraction;
        this.speed = progress.speed;
        this.lastRefreshTime = progress.lastRefreshTime;
        this.tempSize = progress.tempSize;
    }

    public int hashCode() {
        String str = this.tag;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return dexg.dexa("Qsphsftt|gsbdujpo>") + this.fraction + dexg.dexa("-!upubmTj{f>") + this.totalSize + dexg.dexa("-!dvssfouTj{f>") + this.currentSize + dexg.dexa("-!tqffe>") + this.speed + dexg.dexa("-!tubuvt>") + this.status + dexg.dexa("-!qsjpsjuz>") + this.priority + dexg.dexa("-!gpmefs>") + this.folder + dexg.dexa("-!gjmfQbui>") + this.filePath + dexg.dexa("-!gjmfObnf>") + this.fileName + dexg.dexa("-!ubh>") + this.tag + dexg.dexa("-!vsm>") + this.url + '}';
    }
}
