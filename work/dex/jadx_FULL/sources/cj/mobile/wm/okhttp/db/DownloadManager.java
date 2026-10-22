package cj.mobile.wm.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.model.Progress;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DownloadManager extends BaseDao<Progress> {

    public static class DownloadManagerHolder {
        public static final DownloadManager instance = new DownloadManager();
    }

    public DownloadManager() {
        super(new DBHelper());
    }

    public static DownloadManager getInstance() {
        return DownloadManagerHolder.instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public void delete(String str) {
        delete(dexc.dexa("ubh>@"), new String[]{str});
    }

    public Progress get(String str) {
        return queryOne(dexc.dexa("ubh>@"), new String[]{str});
    }

    public List<Progress> getAll() {
        return query(null, null, null, null, null, dexc.dexa("ebuf!BTD"), null);
    }

    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public ContentValues getContentValues(Progress progress) {
        return Progress.buildContentValues(progress);
    }

    public List<Progress> getDownloading() {
        return query(null, dexc.dexa("tubuvt!opu!jo)@*"), new String[]{dexc.dexa("6")}, null, null, dexc.dexa("ebuf!BTD"), null);
    }

    public List<Progress> getFinished() {
        return query(null, dexc.dexa("tubuvt>@"), new String[]{dexc.dexa("6")}, null, null, dexc.dexa("ebuf!BTD"), null);
    }

    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public String getTableName() {
        return dexc.dexa("epxompbe");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public Progress parseCursorToBean(Cursor cursor) {
        return Progress.parseCursorToBean(cursor);
    }

    @Override // cj.mobile.wm.okhttp.db.BaseDao
    public void unInit() {
    }

    public boolean update(ContentValues contentValues, String str) {
        return update(contentValues, dexc.dexa("ubh>@"), new String[]{str});
    }

    public boolean update(Progress progress) {
        return update(progress, dexc.dexa("ubh>@"), new String[]{progress.tag});
    }
}
