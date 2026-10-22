package com.getui.gtc.dim.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.y.k;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.crypt.SecureCryptTools;
import com.getui.gtc.base.db.AbstractTable;
import com.getui.gtc.dim.b.h;
import com.getui.gtc.dim.e.c;
import com.zj.adlib.c49;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b extends AbstractTable {
    public final h a(String str) {
        h hVar;
        Cursor cursor = null;
        hVar = null;
        h hVar2 = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("d", new String[]{"t", "b"}, "a=?", new String[]{String.valueOf(str)}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("b"));
                        hVar = new h(null, cursorQuery.getLong(cursorQuery.getColumnIndex("t")));
                        try {
                            if (!TextUtils.isEmpty(string)) {
                                if (string.equals("-1")) {
                                    File file = new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", (str + ".db").getBytes()));
                                    if (file.exists()) {
                                        string = new String(c.a(file));
                                    }
                                }
                                hVar.f30314a = c.a(SecureCryptTools.getInstance().decrypt(Base64.decode(string, 0)));
                            }
                            hVar2 = hVar;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            try {
                                com.getui.gtc.dim.e.b.a(th);
                                return hVar;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    hVar = null;
                }
            }
            if (cursorQuery == null) {
                return hVar2;
            }
            cursorQuery.close();
            return hVar2;
        } catch (Throwable th3) {
            th = th3;
            hVar = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0059  */
    public final void a() {
        String string;
        String str = Build.BRAND + "#" + Build.VERSION.SDK_INT + c49.f40900a + Build.VERSION.RELEASE;
        Cursor cursor = null;
        try {
            Cursor cursorQuery = query(new String[]{"a", "t", "b"}, "a=?", new String[]{"dim-key-android-rom-version"});
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("b"));
                        com.getui.gtc.dim.e.b.a("dim storage query dbRomVersion = ".concat(String.valueOf(string)));
                    } else {
                        string = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    try {
                        com.getui.gtc.dim.e.b.a(new Exception("dim storage delete parcelable data failed: currentRomVersion = ".concat(String.valueOf(str)), th));
                        if (cursor != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            } else {
                string = null;
            }
            if (str.equals(string)) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            com.getui.gtc.dim.e.b.a("dim storage will delete parcelable data");
            String[] strArr = {"dim-2-1-18-1", "dim-2-1-18-2", "dim-2-1-17-1", "dim-2-1-17-2", "dim-2-1-21-2", "dim-2-1-21-3", "dim-2-1-21-5", "dim-2-1-21-1"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append("a=?");
                if (i != 7) {
                    sb.append(" or ");
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", "");
            update(contentValues, sb.toString(), strArr);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("a", "dim-key-android-rom-version");
            contentValues2.put("t", Long.valueOf(System.currentTimeMillis()));
            contentValues2.put("b", str);
            long jReplace = replace(null, contentValues2);
            StringBuilder sb2 = new StringBuilder("dim storage update dbRomVersion ");
            sb2.append(jReplace != -1 ? "success" : k.j);
            sb2.append(",currentRomVersion = ");
            sb2.append(str);
            com.getui.gtc.dim.e.b.a(sb2.toString());
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean a(String str, Object obj) {
        String strEncodeToString;
        try {
            try {
                strEncodeToString = Base64.encodeToString(SecureCryptTools.getInstance().encrypt(c.b(obj)), 0);
                if (strEncodeToString.length() > 5120) {
                    c.a(strEncodeToString.getBytes(), new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", (str + ".db").getBytes())));
                    strEncodeToString = "-1";
                }
            } catch (Throwable unused) {
                strEncodeToString = "";
                com.getui.gtc.dim.e.b.b("dim storage save failed: ".concat(String.valueOf(obj)));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", str);
            contentValues.put("t", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("b", strEncodeToString);
            com.getui.gtc.dim.e.b.a(str + " update dim storage cache = " + strEncodeToString);
            return replace(null, contentValues) != -1;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
            return false;
        }
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String createSql() {
        return "CREATE TABLE IF NOT EXISTS d (a TEXT PRIMARY KEY, t TEXT, b TEXT)";
    }

    @Override // com.getui.gtc.base.db.AbstractTable
    public String getTableName() {
        return "d";
    }
}
