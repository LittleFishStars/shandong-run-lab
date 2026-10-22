package com.byazt.nys;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.ali.auth.third.login.LoginConstants;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 20})
public class c extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f28855a;
    public final Object c;
    public File n;
    public File sp;
    public File tt;
    public File uj;
    public File ve;
    public File x;

    public c(Context context) {
        super(context);
        this.c = new Object();
    }

    private String c(String str) {
        return c() + LoginConstants.UNDER_LINE + str;
    }

    public String c() {
        return "pangle_com.byted.pangle";
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (c() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(c())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = strArrDatabaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        return c() == null ? super.deleteDatabase(str) : super.deleteDatabase(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return c(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return c() == null ? super.deleteSharedPreferences(str) : super.deleteSharedPreferences(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileC;
        if (c() == null) {
            return super.getCacheDir();
        }
        synchronized (this.c) {
            if (this.f28855a == null) {
                this.f28855a = new File(super.getCacheDir(), c());
            }
            fileC = c(this.f28855a);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileC;
        if (c() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.c) {
            if (this.sp == null) {
                this.sp = new File(super.getCodeCacheDir(), c());
            }
            fileC = c(this.sp);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileC;
        if (c() == null) {
            return super.getDataDir();
        }
        synchronized (this.c) {
            if (this.tt == null) {
                this.tt = new File(tt(), c());
            }
            fileC = c(this.tt);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        return c() == null ? super.getDatabasePath(str) : super.getDatabasePath(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        return (i != 0 || c() == null) ? super.getDir(str, i) : c(new File(super.getDir(str, i), c()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileC;
        if (c() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.c) {
            if (this.x == null) {
                this.x = new File(super.getExternalCacheDir(), c());
            }
            fileC = c(this.x);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (c() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = c(new File(externalCacheDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return c() == null ? super.getExternalFilesDir(str) : c(new File(super.getExternalFilesDir(str), c()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (c() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = c(new File(externalFilesDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (c() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = c(new File(externalMediaDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileC;
        if (c() == null) {
            return super.getFilesDir();
        }
        synchronized (this.c) {
            if (this.ve == null) {
                this.ve = new File(super.getFilesDir(), c());
            }
            fileC = c(this.ve);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileC;
        if (c() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.c) {
            if (this.uj == null) {
                this.uj = new File(super.getNoBackupFilesDir(), c());
            }
            fileC = c(this.uj);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileC;
        if (c() == null) {
            return super.getObbDir();
        }
        synchronized (this.c) {
            if (this.n == null) {
                this.n = new File(super.getObbDir(), c());
            }
            fileC = c(this.n);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (c() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = c(new File(obbDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return (i != 0 || c() == null) ? super.getSharedPreferences(str, i) : super.getSharedPreferences(c(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (c() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return c() == null ? super.openFileInput(str) : new FileInputStream(c(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        return (i != 0 || c() == null) ? super.openFileOutput(str, i) : new FileOutputStream(c(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i != 0 || c() == null) ? super.openOrCreateDatabase(str, i, cursorFactory) : super.openOrCreateDatabase(c(str), i, cursorFactory);
    }

    public File tt() {
        return super.getFilesDir().getParentFile();
    }

    private static File c(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File c(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i == 0 && c() != null) {
            return super.openOrCreateDatabase(c(str), i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
    }
}
