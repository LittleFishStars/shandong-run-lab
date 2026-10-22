package com.byazt.sd;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byazt.c.u;
import com.byazt.gq.t;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.fl.saas.base.cache.DatabaseHelper;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 20})
public class c implements u {
    private boolean ve(DownloadInfo downloadInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb.append(str);
        sb.append(downloadInfo.getName());
        String string = sb.toString();
        File file = new File(string);
        String strC = com.byazt.o.n.c(t.getContext(), com.byazt.z.ve.c(downloadInfo, file), string);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strC)) {
            String str2 = strC + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (zRenameTo) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        return zRenameTo;
    }

    @Override // com.byazt.c.u
    public void c(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !ve(downloadInfo)) {
            return;
        }
        c(t.getContext(), downloadInfo);
    }

    @Override // com.byazt.c.u
    public boolean tt(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.byazt.hu.n.tt(com.byazt.k.c.c(downloadInfo.getId()));
        }
        return false;
    }

    private void c(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{DatabaseHelper.COLUMN_ID}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex(DatabaseHelper.COLUMN_ID))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.byazt.sd.c.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.byazt.zz.ve.zm().c(downloadInfo);
                    }
                }
            });
        }
        com.byazt.w.a.c(cursorQuery);
    }
}
