package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.task.AbsAsyncTask;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.ui.context.a;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QrLoginConfirmTask extends AbsAsyncTask<String, Void, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f23490a;

    public QrLoginConfirmTask(a aVar) {
        this.f23490a = aVar;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void asyncExecute(String... strArr) {
        int iIntValue;
        Activity activityA;
        ResultCode resultCode;
        if (TextUtils.isEmpty(strArr[0])) {
            activityA = this.f23490a.a();
            resultCode = ResultCode.SUCCESS;
            activityA.setResult(resultCode.code);
        } else {
            try {
                Map map = (Map) JSONUtils.toMap(new JSONObject(strArr[0]).optJSONObject("params")).get("qrConfirmInfo");
                if (map == null || (iIntValue = ((Integer) map.get("action")).intValue()) == 0) {
                    activityA = this.f23490a.a();
                    resultCode = ResultCode.SUCCESS;
                } else if (-1 == iIntValue) {
                    activityA = this.f23490a.a();
                    resultCode = ResultCode.USER_CANCEL;
                }
                activityA.setResult(resultCode.code);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        this.f23490a.a().finish();
        return null;
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doFinally() {
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        Message messageCreateMessage = MessageUtils.createMessage(10010, th.getMessage());
        SDKLogger.log("login", messageCreateMessage, th);
        this.f23490a.a(messageCreateMessage.code, messageCreateMessage.message);
    }
}
