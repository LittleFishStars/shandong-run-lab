package com.heytap.mcssdk.e;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32620a = "a";

    @Override // com.heytap.mcssdk.e.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return a(intent, i);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00f9: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:23:0x00f9 */
    @Override // com.heytap.mcssdk.e.c
    public BaseMode a(Intent intent, int i) {
        com.heytap.mcssdk.c.b bVar;
        Exception e;
        String str;
        com.heytap.mcssdk.c.b bVar2;
        com.heytap.mcssdk.c.b bVar3 = null;
        try {
            try {
                bVar = new com.heytap.mcssdk.c.b();
                try {
                    bVar.a(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.y))));
                    bVar.b(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("code"))));
                    bVar.e(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
                    bVar.a(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("appKey")));
                    bVar.b(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.A)));
                    bVar.g(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.e)));
                    String str2 = f32620a;
                    com.heytap.mcssdk.utils.d.b(str2, "parseMessageByIntent() finally will get miniProgramPkg");
                    try {
                        com.heytap.mcssdk.utils.d.b(str2, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        bVar.f(intent.getStringExtra("miniProgramPkg"));
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
                    } catch (Exception e2) {
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e2.getMessage() + " ");
                    }
                    return bVar;
                } catch (Exception e3) {
                    e = e3;
                    com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e.getMessage());
                    String str3 = f32620a;
                    com.heytap.mcssdk.utils.d.b(str3, "parseMessageByIntent() finally will get miniProgramPkg");
                    if (bVar != null) {
                        try {
                            com.heytap.mcssdk.utils.d.b(str3, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                            bVar.f(intent.getStringExtra("miniProgramPkg"));
                            com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
                        } catch (Exception e4) {
                            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e4.getMessage() + " ");
                        }
                    }
                    return bVar;
                }
            } catch (Throwable unused) {
                bVar3 = bVar2;
                str = f32620a;
                com.heytap.mcssdk.utils.d.b(str, "parseMessageByIntent() finally will get miniProgramPkg");
                if (bVar3 != null) {
                    try {
                        com.heytap.mcssdk.utils.d.b(str, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        bVar3.f(intent.getStringExtra("miniProgramPkg"));
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar3.toString());
                    } catch (Exception e5) {
                        com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e5.getMessage() + " ");
                    }
                }
                return bVar3;
            }
        } catch (Exception e6) {
            bVar = null;
            e = e6;
        } catch (Throwable unused2) {
            str = f32620a;
            com.heytap.mcssdk.utils.d.b(str, "parseMessageByIntent() finally will get miniProgramPkg");
            if (bVar3 != null) {
                com.heytap.mcssdk.utils.d.b(str, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                bVar3.f(intent.getStringExtra("miniProgramPkg"));
                com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar3.toString());
            }
            return bVar3;
        }
    }
}
