package com.alibaba.ariver.kernel.common.log;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Node;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AppLogUtils {
    public static void generatePageTag(Node node, String str) {
        AppLogContext appLogContext;
        String str2;
        if (node == null || !(node instanceof DataNode) || (appLogContext = (AppLogContext) ((DataNode) node).getData(AppLogContext.class)) == null || appLogContext.isAlreadyRecordTagLog()) {
            return;
        }
        appLogContext.setAlreadyRecordTagLog(true);
        PageLog.Builder builder = new PageLog.Builder();
        builder.setState(PageLog.PAGE_LOG_TAGS).setParentId(appLogContext.getPageLogToken());
        String str3 = "";
        if (appLogContext.hasJSAPIError()) {
            str2 = " API";
        } else {
            str2 = "";
        }
        if (appLogContext.hasJSError()) {
            str2 = str2 + " JS";
        }
        if (appLogContext.hasResourceError()) {
            str2 = str2 + " Res";
        }
        builder.setErrMsg(str2);
        if (appLogContext.hasWhiteScreen()) {
            str3 = " 白屏";
        }
        if (AppLogger.getQosLevel() == 4) {
            str3 = str3 + " 弱网";
        }
        if (appLogContext.hasScreenShot()) {
            str3 = str3 + " 用户截屏";
        }
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            return;
        }
        builder.setWarningMsg(str3);
        builder.setTitle(str);
        AppLogger.log(builder.build());
    }

    public static String getParentId(Node node) {
        AppLogContext appLogContext;
        if (node == null) {
            return "";
        }
        if ((node instanceof DataNode) && (appLogContext = (AppLogContext) ((DataNode) node).getData(AppLogContext.class)) != null) {
            String pageLogToken = appLogContext.getPageLogToken();
            if (!TextUtils.isEmpty(pageLogToken)) {
                return pageLogToken;
            }
        }
        return "" + node.getNodeId();
    }
}
