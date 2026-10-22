package com.kc.bw.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.cache.CacheEntity;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CacheManager extends BaseDao<CacheEntity<?>> {

    @Keep
    public static class CacheManagerHolder {
        public static final CacheManager instance = new CacheManager();
    }

    public CacheManager() {
        super(new DBHelper());
    }

    public static CacheManager getInstance() {
        return CacheManagerHolder.instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public CacheEntity<?> get(String str) {
        if (str == null) {
            return null;
        }
        List<CacheEntity<?>> listQuery = query(dexg.dexa("lfz>@"), new String[]{str});
        if (listQuery.size() > 0) {
            return listQuery.get(0);
        }
        return null;
    }

    public <T> CacheEntity<T> get(String str, Class<T> cls) {
        return (CacheEntity<T>) get(str);
    }

    public List<CacheEntity<?>> getAll() {
        return queryAll();
    }

    @Override // com.kc.bw.okhttp.db.BaseDao
    public ContentValues getContentValues(CacheEntity<?> cacheEntity) {
        return CacheEntity.getContentValues(cacheEntity);
    }

    @Override // com.kc.bw.okhttp.db.BaseDao
    public String getTableName() {
        return dexg.dexa("dbdif");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.okhttp.db.BaseDao
    public CacheEntity<?> parseCursorToBean(Cursor cursor) {
        return CacheEntity.parseCursorToBean(cursor);
    }

    public boolean remove(String str) {
        if (str == null) {
            return false;
        }
        return delete(dexg.dexa("lfz>@"), new String[]{str});
    }

    public <T> CacheEntity<T> replace(String str, CacheEntity<T> cacheEntity) {
        cacheEntity.setKey(str);
        replace(cacheEntity);
        return cacheEntity;
    }

    @Override // com.kc.bw.okhttp.db.BaseDao
    public void unInit() {
    }
}
