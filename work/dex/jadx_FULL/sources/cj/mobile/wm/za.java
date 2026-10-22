package cj.mobile.wm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class za {
    public Context dexa;

    public za(Context context) {
        this.dexa = context;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0058 A[Catch: all -> 0x0076, Exception -> 0x0078, TryCatch #1 {Exception -> 0x0078, blocks: (B:25:0x0048, B:27:0x0058, B:29:0x005e, B:32:0x0072, B:30:0x006b), top: B:40:0x0048, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x005e A[Catch: all -> 0x0076, Exception -> 0x0078, TryCatch #1 {Exception -> 0x0078, blocks: (B:25:0x0048, B:27:0x0058, B:29:0x005e, B:32:0x0072, B:30:0x006b), top: B:40:0x0048, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x006b A[Catch: all -> 0x0076, Exception -> 0x0078, TryCatch #1 {Exception -> 0x0078, blocks: (B:25:0x0048, B:27:0x0058, B:29:0x005e, B:32:0x0072, B:30:0x006b), top: B:40:0x0048, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0072 A[Catch: all -> 0x0076, Exception -> 0x0078, TRY_LEAVE, TryCatch #1 {Exception -> 0x0078, blocks: (B:25:0x0048, B:27:0x0058, B:29:0x005e, B:32:0x0072, B:30:0x006b), top: B:40:0x0048, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String dexa(int i, String str) {
        String string;
        Uri uri;
        Cursor cursorQuery;
        StringBuilder sb;
        String str2;
        String string2 = null;
        if (i != 0) {
            if (i == 1) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i == 2) {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            } else {
                if (i != 3) {
                    if (i == 4) {
                        sb = new StringBuilder();
                        str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_";
                    } else if (i != 5) {
                        uri = null;
                    } else {
                        string = "content://com.vivo.abe.exidentifier/guid";
                    }
                    if (uri == null) {
                        return null;
                    }
                    try {
                        cursorQuery = this.dexa.getContentResolver().query(uri, null, null, null, null);
                        if (cursorQuery != null) {
                            Log.d("VMS_SDK_DB", "return cursor is null,return");
                        } else if (cursorQuery.moveToNext()) {
                            string2 = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (Exception unused) {
                        Log.e("VMS_SDK_DB", "return cursor is error");
                    }
                    return string2;
                }
                string = "content://com.vivo.vms.IdProvider/IdentifierId/UDID";
            }
            sb.append(str2);
            sb.append(str);
            string = sb.toString();
        } else {
            string = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        uri = Uri.parse(string);
        if (uri == null) {
            return null;
        }
        cursorQuery = this.dexa.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            Log.d("VMS_SDK_DB", "return cursor is null,return");
        } else if (cursorQuery.moveToNext()) {
            string2 = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x004d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean dexa(int i, String str, ContentValues[] contentValuesArr) {
        StringBuilder sb;
        String str2;
        Uri uri;
        int iBulkInsert;
        if (i != 6) {
            if (i != 7) {
                uri = null;
            } else {
                sb = new StringBuilder();
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_";
            }
            if (uri == null) {
                return false;
            }
            try {
                iBulkInsert = this.dexa.getContentResolver().bulkInsert(uri, contentValuesArr);
                Log.d("VMS_SDK_DB", "insert:" + iBulkInsert);
                if (iBulkInsert != 0) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                Log.e("VMS_SDK_DB", "return insert is error");
                return false;
            }
        }
        sb = new StringBuilder();
        str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_";
        sb.append(str2);
        sb.append(str);
        uri = Uri.parse(sb.toString());
        if (uri == null) {
            return false;
        }
        iBulkInsert = this.dexa.getContentResolver().bulkInsert(uri, contentValuesArr);
        Log.d("VMS_SDK_DB", "insert:" + iBulkInsert);
        if (iBulkInsert != 0) {
            return true;
        }
        return false;
    }
}
