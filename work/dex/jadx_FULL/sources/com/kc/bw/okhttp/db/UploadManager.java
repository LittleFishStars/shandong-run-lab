package com.kc.bw.okhttp.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.model.Progress;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class UploadManager extends BaseDao<Progress> {

    @Keep
    public static class UploadManagerHolder {
        public static final UploadManager instance = new UploadManager();
    }

    public UploadManager() {
        super(new DBHelper());
    }

    public static UploadManager getInstance() {
        return UploadManagerHolder.instance;
    }

    public boolean clear() {
        return deleteAll();
    }

    public void delete(String str) {
        delete(dexg.dexa("ubh>@"), new String[]{str});
    }

    public Progress get(String str) {
        return queryOne(dexg.dexa("ubh>@"), new String[]{str});
    }

    public List<Progress> getAll() {
        return query(null, null, null, null, null, dexg.dexa("ebuf!BTD"), null);
    }

    @Override // com.kc.bw.okhttp.db.BaseDao
    public ContentValues getContentValues(Progress progress) {
        return Progress.buildContentValues(progress);
    }

    public List<Progress> getFinished() {
        return query(null, dexg.dexa("tubuvt>@"), new String[]{dexg.dexa("6")}, null, null, dexg.dexa("ebuf!BTD"), null);
    }

    @Override // com.kc.bw.okhttp.db.BaseDao
    public String getTableName() {
        return dexg.dexa("vqmpbe");
    }

    public List<Progress> getUploading() {
        return query(null, dexg.dexa("tubuvt!opu!jo)@*"), new String[]{dexg.dexa("6")}, null, null, dexg.dexa("ebuf!BTD"), null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kc.bw.okhttp.db.BaseDao
    public Progress parseCursorToBean(Cursor cursor) {
        return Progress.parseCursorToBean(cursor);
    }

    @Override // com.kc.bw.okhttp.db.BaseDao
    public void unInit() {
    }

    public boolean update(ContentValues contentValues, String str) {
        return update(contentValues, dexg.dexa("ubh>@"), new String[]{str});
    }

    public boolean update(Progress progress) {
        return update(progress, dexg.dexa("ubh>@"), new String[]{progress.tag});
    }
}
