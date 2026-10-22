package cj.mobile.wm.okhttp.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import cj.mobile.wm.okhttp.request.base.Request;
import cj.mobile.wm.okhttp.utils.IOUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
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
    public static final String TAG = dexc.dexa("ubh");
    public static final String URL = dexc.dexa("vsm");
    public static final String FOLDER = dexc.dexa("gpmefs");
    public static final String FILE_PATH = dexc.dexa("gjmfQbui");
    public static final String FILE_NAME = dexc.dexa("gjmfObnf");
    public static final String FRACTION = dexc.dexa("gsbdujpo");
    public static final String TOTAL_SIZE = dexc.dexa("upubmTj{f");
    public static final String CURRENT_SIZE = dexc.dexa("dvssfouTj{f");
    public static final String STATUS = dexc.dexa("tubuvt");
    public static final String PRIORITY = dexc.dexa("qsjpsjuz");
    public static final String DATE = dexc.dexa("ebuf");
    public static final String REQUEST = dexc.dexa("sfrvftu");
    public static final String EXTRA1 = dexc.dexa("fyusb2");
    public static final String EXTRA2 = dexc.dexa("fyusb3");
    public static final String EXTRA3 = dexc.dexa("fyusb4");
    public transient long lastRefreshTime = SystemClock.elapsedRealtime();
    public long totalSize = -1;
    public int priority = 0;
    public long date = System.currentTimeMillis();
    public transient List<Long> speedBuffer = new ArrayList();

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

    public static ContentValues buildContentValues(Progress progress) throws Throwable {
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
        if ((jElapsedRealtime - j3 >= OkHttp.REFRESH_TIME) || progress.currentSize == j2) {
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
        return dexc.dexa("Qsphsftt|gsbdujpo>") + this.fraction + dexc.dexa("-!upubmTj{f>") + this.totalSize + dexc.dexa("-!dvssfouTj{f>") + this.currentSize + dexc.dexa("-!tqffe>") + this.speed + dexc.dexa("-!tubuvt>") + this.status + dexc.dexa("-!qsjpsjuz>") + this.priority + dexc.dexa("-!gpmefs>") + this.folder + dexc.dexa("-!gjmfQbui>") + this.filePath + dexc.dexa("-!gjmfObnf>") + this.fileName + dexc.dexa("-!ubh>") + this.tag + dexc.dexa("-!vsm>") + this.url + '}';
    }
}
