package cj.mobile.wm.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.cache.CacheEntity;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CacheManager extends BaseDao<CacheEntity<?>> {

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
        List<CacheEntity<?>> listQuery = query(dexc.dexa("lfz>@"), new String[]{str});
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

    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public ContentValues getContentValues(CacheEntity<?> cacheEntity) {
        return CacheEntity.getContentValues(cacheEntity);
    }

    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public String getTableName() {
        return dexc.dexa("dbdif");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public CacheEntity<?> parseCursorToBean(Cursor cursor) {
        return CacheEntity.parseCursorToBean(cursor);
    }

    public boolean remove(String str) {
        if (str == null) {
            return false;
        }
        return delete(dexc.dexa("lfz>@"), new String[]{str});
    }

    public <T> CacheEntity<T> replace(String str, CacheEntity<T> cacheEntity) {
        cacheEntity.setKey(str);
        replace(cacheEntity);
        return cacheEntity;
    }

    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public void unInit() {
    }
}
