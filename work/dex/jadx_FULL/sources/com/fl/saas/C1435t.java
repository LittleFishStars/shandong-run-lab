package com.fl.saas;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.fl.saas.adx.base.download.DownloadService;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.s2s.sdk.util.CommConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.fl.saas.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1435t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static C1435t f30192a;

    /* JADX INFO: renamed from: com.fl.saas.t$a */
    public class a implements T {
        public a() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
        }
    }

    public void a(Context context, C1415j c1415j, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        a(context, str, c1415j);
    }

    public static C1435t a() {
        if (f30192a == null) {
            synchronized (C1435t.class) {
                f30192a = new C1435t();
            }
        }
        return f30192a;
    }

    private void a(Context context, String str, C1415j c1415j) {
        if (AbstractC1437u.f30196a) {
            Toast.makeText(context, "等待当前任务下载完成", 0).show();
            return;
        }
        Toast.makeText(context, "开始下载...", 0).show();
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) DownloadService.class);
        intent.putExtra("url", str);
        intent.putExtra(CommConstant.DownloadConstants.REPORT_POJO, c1415j);
        context.startService(intent);
    }

    private String a(String str, int i, String str2) {
        return str.replaceAll("__ACTION_ID__", String.valueOf(i));
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return str.replaceAll("__CLICK_ID__", str2).replaceAll("__TS__", String.valueOf(System.currentTimeMillis()));
    }

    public void a(C1415j c1415j, int i) {
        LogcatUtil.d("FLSDK-Download", "what:" + i);
        a(c1415j, i, "");
    }

    public void a(C1415j c1415j, int i, String str) {
        List list;
        if (c1415j == null) {
            return;
        }
        LogcatUtil.i("上报" + i);
        if (i == 4) {
            List list2 = c1415j.U0;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    list2.set(i2, a((String) list2.get(i2), 5, str));
                }
                c1415j.U0 = (ArrayList) list2;
            }
            list = c1415j.U0;
        } else if (i == 5) {
            List list3 = c1415j.V0;
            if (list3 != null) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    list3.set(i3, a((String) list3.get(i3), 7, str));
                }
                c1415j.V0 = (ArrayList) list3;
            }
            list = c1415j.V0;
        } else if (i == 6) {
            List list4 = c1415j.W0;
            if (list4 != null) {
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    list4.set(i4, a((String) list4.get(i4), 6, str));
                }
                c1415j.W0 = (ArrayList) list4;
            }
            list = c1415j.W0;
        } else if (i != 7) {
            list = null;
        } else {
            List list5 = c1415j.X0;
            if (list5 != null) {
                for (int i5 = 0; i5 < list5.size(); i5++) {
                    list5.set(i5, a((String) list5.get(i5), 7, str));
                }
                c1415j.X0 = (ArrayList) list5;
            }
            list = c1415j.X0;
        }
        if (list == null) {
            return;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            C1401c.c().a(a((String) list.get(i6), c1415j.z1), new a());
        }
    }
}
