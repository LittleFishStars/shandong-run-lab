package huachenjie.sdk.push;

import android.content.Context;
import android.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lhuachenjie/sdk/push/HcjIntentService;", "Lcom/igexin/sdk/GTIntentService;", "Landroid/content/Context;", "context", "", "pid", "", "onReceiveServicePid", "Lcom/igexin/sdk/message/GTTransmitMessage;", "msg", "onReceiveMessageData", "", PushConsts.KEY_CLIENT_ID, "onReceiveClientId", "", "online", "onReceiveOnlineState", "Lcom/igexin/sdk/message/GTCmdMessage;", "cmdMessage", "onReceiveCommandResult", "Lcom/igexin/sdk/message/GTNotificationMessage;", "onNotificationMessageArrived", "onNotificationMessageClicked", "f", "Ljava/lang/String;", "TAG", "<init>", "()V", "push_release"}, k = 1, mv = {1, 8, 0})
public final class HcjIntentService extends GTIntentService {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String TAG = "hcj_push";

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageArrived(@Nullable Context context, @Nullable GTNotificationMessage msg) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onNotificationMessageArrived -> msg = ");
        sb.append(msg != null ? msg.getContent() : null);
        Log.d(str, sb.toString());
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageClicked(@Nullable Context context, @Nullable GTNotificationMessage msg) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onNotificationMessageClicked -> msg = ");
        sb.append(msg != null ? msg.getContent() : null);
        Log.d(str, sb.toString());
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveClientId(@Nullable Context context, @NotNull String clientid) {
        Intrinsics.checkNotNullParameter(clientid, PushConsts.KEY_CLIENT_ID);
        Log.d(this.TAG, "onReceiveClientId -> clientid = " + clientid);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveCommandResult(@Nullable Context context, @Nullable GTCmdMessage cmdMessage) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onReceiveCommandResult -> cmdMessage = ");
        sb.append(cmdMessage != null ? Integer.valueOf(cmdMessage.getAction()) : null);
        Log.d(str, sb.toString());
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveMessageData(@Nullable Context context, @NotNull GTTransmitMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        byte[] payload = msg.getPayload();
        Intrinsics.checkNotNullExpressionValue(payload, AssistPushConsts.MSG_TYPE_PAYLOAD);
        String str = new String(payload, Charsets.UTF_8);
        Log.d(this.TAG, "receiver payload = " + str);
        msg.getTaskId();
        msg.getMessageId();
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveOnlineState(@Nullable Context context, boolean online) {
        Log.d(this.TAG, "onReceiveOnlineState -> online = " + online);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveServicePid(@Nullable Context context, int pid) {
        Log.d(this.TAG, "receiver Pid = " + pid);
    }
}
