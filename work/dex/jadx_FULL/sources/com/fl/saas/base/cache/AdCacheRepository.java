package com.fl.saas.base.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.RandomUtils;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.DeviceUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdCacheRepository {
    private static final String TAG = "YdSDK-AdCacheRepository";
    private static AdCacheRepository mInstance;
    private final DatabaseHelper dbHelper = DatabaseHelper.getInstance(DeviceUtil.getContext());

    private AdCacheRepository() {
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
    private void deleteExpireAdCache() throws Throwable {
        SQLiteDatabase readableDatabase;
        if (this.dbHelper == null) {
            return;
        }
        ArrayList<AdCacheBean> arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            readableDatabase = this.dbHelper.getReadableDatabase();
            try {
                try {
                    cursorQuery = readableDatabase.query(DatabaseHelper.TABLE_AD_CACHE, new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_PRICE, DatabaseHelper.COLUMN_VALUE}, "_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) (ConfigHelper.getInstance().getCacheAdTime() * 60)) * 1000))}, null, null, "_id DESC");
                    while (cursorQuery.moveToNext()) {
                        AdCacheBean adCacheBean = new AdCacheBean();
                        adCacheBean.setId(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                        adCacheBean.setPrice(cursorQuery.getDouble(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRICE)));
                        adCacheBean.setValue(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_VALUE)));
                        arrayList.add(adCacheBean);
                    }
                    for (AdCacheBean adCacheBean2 : arrayList) {
                        deleteAdCache(adCacheBean2.getId());
                        uploadBidFail(adCacheBean2);
                    }
                    cursorQuery.close();
                } catch (Exception e) {
                    e = e;
                    Log.e(TAG, "删除广告缓存失败", e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            readableDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            readableDatabase = null;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            throw th;
        }
        readableDatabase.close();
    }

    public static AdCacheRepository getInstance() {
        if (mInstance == null) {
            synchronized (AdCacheRepository.class) {
                mInstance = new AdCacheRepository();
            }
        }
        return mInstance;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d7  */
    private List<AdCacheBean> searchAdCaches(String str) throws Throwable {
        SQLiteDatabase readableDatabase;
        Cursor cursorQuery = null;
        if (this.dbHelper == null) {
            return null;
        }
        deleteExpireAdCache();
        ArrayList arrayList = new ArrayList();
        try {
            readableDatabase = this.dbHelper.getReadableDatabase();
            try {
                try {
                    cursorQuery = readableDatabase.query(DatabaseHelper.TABLE_AD_CACHE, new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_KEY, DatabaseHelper.COLUMN_TIME, DatabaseHelper.COLUMN_PRICE, DatabaseHelper.COLUMN_VALUE}, "_key = ?", new String[]{str}, null, null, "_price DESC");
                    while (cursorQuery.moveToNext()) {
                        AdCacheBean adCacheBean = new AdCacheBean();
                        adCacheBean.setId(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID)));
                        adCacheBean.setKey(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_KEY)));
                        adCacheBean.setTime(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TIME)));
                        adCacheBean.setPrice(cursorQuery.getDouble(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRICE)));
                        adCacheBean.setValue(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(DatabaseHelper.COLUMN_VALUE)));
                        arrayList.add(adCacheBean);
                    }
                    if (arrayList.size() > ConfigHelper.getInstance().getQueueNum()) {
                        for (int queueNum = ConfigHelper.getInstance().getQueueNum(); queueNum < arrayList.size(); queueNum++) {
                            deleteAdCache(((AdCacheBean) arrayList.get(queueNum)).getId());
                            uploadBidFail((AdCacheBean) arrayList.get(queueNum));
                        }
                    }
                    cursorQuery.close();
                } catch (Exception e) {
                    e = e;
                    Log.e(TAG, "获取广告缓存失败", e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (readableDatabase != null) {
                    }
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            readableDatabase = null;
        } catch (Throwable th2) {
            th = th2;
            readableDatabase = null;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (readableDatabase != null) {
                readableDatabase.close();
            }
            throw th;
        }
        readableDatabase.close();
        return arrayList;
    }

    private void uploadBidFail(AdCacheBean adCacheBean) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject responseNew = NetDataUtils.parseResponseNew(adCacheBean.getValue());
            if (responseNew.optInt("code", -1) == -1 || (jSONArrayOptJSONArray = responseNew.optJSONArray("ads")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONObject(0).optJSONArray("notice_failed_urls");
            if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray2.optString(i));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                AdHttpUtils.getInstance().doGet(((String) arrayList.get(i2)).replaceAll("__PRICE__", (adCacheBean.getPrice() + ((double) RandomUtils.getRandomInt(100))) + ""), new HttpCallbackStringListener() { // from class: com.fl.saas.base.cache.AdCacheRepository.1
                    @Override // com.fl.saas.config.http.HttpCallbackStringListener
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.config.http.HttpCallbackStringListener
                    public void onJump(String str) {
                    }

                    @Override // com.fl.saas.config.http.HttpCallbackStringListener
                    public void onSuccess(String str) {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long addAdCache(AdCacheBean adCacheBean) {
        if (this.dbHelper == null) {
            return 0L;
        }
        deleteExpireAdCache();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DatabaseHelper.COLUMN_KEY, adCacheBean.getKey());
                    contentValues.put(DatabaseHelper.COLUMN_TIME, Long.valueOf(adCacheBean.getTime()));
                    contentValues.put(DatabaseHelper.COLUMN_PRICE, Double.valueOf(adCacheBean.getPrice()));
                    contentValues.put(DatabaseHelper.COLUMN_VALUE, adCacheBean.getValue());
                    writableDatabase.beginTransaction();
                    try {
                        long jInsertOrThrow = writableDatabase.insertOrThrow(DatabaseHelper.TABLE_AD_CACHE, null, contentValues);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        writableDatabase.close();
                        return jInsertOrThrow;
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e) {
                    e = e;
                    sQLiteDatabase = writableDatabase;
                    Log.e(TAG, "添加广告缓存失败", e);
                    if (sQLiteDatabase == null) {
                        return -1L;
                    }
                    sQLiteDatabase.close();
                    return -1L;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLException e2) {
            e = e2;
        }
    }

    public void deleteAdCache(long j) {
        DatabaseHelper databaseHelper = this.dbHelper;
        if (databaseHelper == null) {
            return;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = databaseHelper.getWritableDatabase();
                writableDatabase.delete(DatabaseHelper.TABLE_AD_CACHE, "_id = ?", new String[]{String.valueOf(j)});
            } catch (SQLException e) {
                Log.e(TAG, "删除广告缓存失败", e);
                if (writableDatabase == null) {
                    return;
                }
            }
            writableDatabase.close();
        } catch (Throwable th) {
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw th;
        }
    }

    public AdCacheBean getCacheAdContent(String str) throws Throwable {
        List<AdCacheBean> listSearchAdCaches = searchAdCaches(str);
        if (listSearchAdCaches == null || listSearchAdCaches.isEmpty()) {
            return null;
        }
        return listSearchAdCaches.get(0);
    }
}
