package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends d {
    public static int Pj = 1;
    private static volatile a bfm;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, Pj));
    }

    public static a cx(Context context) {
        if (bfm == null) {
            synchronized (a.class) {
                if (bfm == null) {
                    bfm = new a(context);
                }
            }
        }
        return bfm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public synchronized BlockReportAction f(@NonNull Cursor cursor) {
        try {
        } catch (JSONException e) {
            c.printStackTrace(e);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }

    @Override // com.kwad.sdk.core.report.d
    public final String MW() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String[] MX() {
        return new String[]{"aLog"};
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }
}
