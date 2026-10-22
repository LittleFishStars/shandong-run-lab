package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class q extends d {
    private static volatile q aWE;
    private o aWF;

    private q(Context context) {
        super(new p(context, p.Pj));
        this.aWF = new i();
    }

    public static q bY(Context context) {
        if (aWE == null) {
            synchronized (q.class) {
                if (aWE == null) {
                    aWE = new q(context);
                }
            }
        }
        return aWE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized n f(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FY()) {
            return this.aWF.ac(string2, string);
        }
        return this.aWF.ac(string2, string);
    }

    @Override // com.kwad.sdk.core.report.d
    public final String MW() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String[] MX() {
        return new String[]{"aLog", "actionId"};
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "ReportActionDBManager";
    }
}
