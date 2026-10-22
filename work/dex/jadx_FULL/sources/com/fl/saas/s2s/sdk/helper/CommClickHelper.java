package com.fl.saas.s2s.sdk.helper;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.helper.download.DownloadService;
import com.fl.saas.s2s.sdk.util.CommConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommClickHelper {
    private static CommClickHelper sInstance;

    public static CommClickHelper getInstance() {
        if (sInstance == null) {
            synchronized (CommClickHelper.class) {
                sInstance = new CommClickHelper();
            }
        }
        return sInstance;
    }

    private void goToDownload(Context context, String str, AdInfoPoJo adInfoPoJo) {
        if (DownloadService.isIntentServiceRunning) {
            Toast.makeText(context, "等待当前任务下载完成", 0).show();
            return;
        }
        Toast.makeText(context, "开始下载...", 0).show();
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) DownloadService.class);
        intent.putExtra("url", str);
        intent.putExtra(CommConstant.DownloadConstants.REPORT_POJO, adInfoPoJo);
        context.startService(intent);
    }

    private String interactionMacroReplace(String str, int i, String str2) {
        return str.replaceAll("__ACTION_ID__", String.valueOf(i));
    }

    private String interactionMacroReplace(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return str.replaceAll("__CLICK_ID__", str2).replaceAll("__TS__", String.valueOf(System.currentTimeMillis()));
    }

    public void downloadAPK(Context context, AdInfoPoJo adInfoPoJo, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        goToDownload(context, str, adInfoPoJo);
    }

    public void report(Context context, AdInfoPoJo adInfoPoJo, int i) {
        LogcatUtil.d("YdSDK-Download", "what:" + i);
        report(context, adInfoPoJo, i, "");
    }

    public void report(Context context, AdInfoPoJo adInfoPoJo, int i, String str) {
        List<String> list;
        if (adInfoPoJo == null || context == null) {
            return;
        }
        LogcatUtil.i("上报" + i);
        if (i == 4) {
            List<String> list2 = adInfoPoJo.download_start_notice_urls;
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    list2.set(i2, interactionMacroReplace(list2.get(i2), 5, str));
                }
                adInfoPoJo.download_start_notice_urls = (ArrayList) list2;
            }
            list = adInfoPoJo.download_start_notice_urls;
        } else if (i == 5) {
            List<String> list3 = adInfoPoJo.download_notice_urls;
            if (list3 != null) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    list3.set(i3, interactionMacroReplace(list3.get(i3), 7, str));
                }
                adInfoPoJo.download_notice_urls = (ArrayList) list3;
            }
            list = adInfoPoJo.download_notice_urls;
        } else if (i == 6) {
            List<String> list4 = adInfoPoJo.install_start_notice_urls;
            if (list4 != null) {
                for (int i4 = 0; i4 < list4.size(); i4++) {
                    list4.set(i4, interactionMacroReplace(list4.get(i4), 6, str));
                }
                adInfoPoJo.install_start_notice_urls = (ArrayList) list4;
            }
            list = adInfoPoJo.install_start_notice_urls;
        } else if (i != 7) {
            list = null;
        } else {
            List<String> list5 = adInfoPoJo.install_end_notice_urls;
            if (list5 != null) {
                for (int i5 = 0; i5 < list5.size(); i5++) {
                    list5.set(i5, interactionMacroReplace(list5.get(i5), 7, str));
                }
                adInfoPoJo.install_end_notice_urls = (ArrayList) list5;
            }
            list = adInfoPoJo.install_end_notice_urls;
        }
        if (list == null) {
            return;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            AdHttpUtils.getInstance().doGet(interactionMacroReplace(list.get(i6), adInfoPoJo.clickId), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommClickHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str2) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str2) {
                }
            });
        }
    }
}
