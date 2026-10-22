package com.igexin.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.MessageBean;
import com.igexin.assist.action.MessageManger;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.AssistUtils;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.zj.adlib.u15;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class FlymePushReceiver extends MzPushMessageReceiver {
    public static final String CONTENT = "content";
    public static final String MSG_KEY_PAYLOAD = "gt_payload";
    public static final String MZ_STATUS_BAR_SMALL_ICON = "mz_push_notification_small_icon";
    public static final String TAG = "Assist_MZ";
    private Context context;
    private int statusBarIconId;

    public void onMessage(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            Log.d("Assist_MZ", "onMessage intent msg...");
            Log.d("Assist_MZ", "onMessage intent msg :" + intent.toUri(0));
            String stringExtra = intent.getStringExtra("content");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            MessageBean messageBean = new MessageBean(context, AssistPushConsts.MSG_TYPE_PAYLOAD, stringExtra);
            messageBean.setMessageSource(AssistPushConsts.MZ_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    public void onMessage(Context context, String str) {
        try {
            Log.d("Assist_MZ", "onMessage receive msg ...");
            Log.d("Assist_MZ", "onMessage receive msg:".concat(String.valueOf(str)));
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            MessageBean messageBean = new MessageBean(context, AssistPushConsts.MSG_TYPE_PAYLOAD, str);
            messageBean.setMessageSource(AssistPushConsts.MZ_PREFIX);
            MessageManger.getInstance().addMessage(messageBean);
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
        Log.d("Assist_MZ", "onNotificationArrived receive msg ...");
        Log.d("Assist_MZ", "onNotificationArrived receive msg:".concat(String.valueOf(mzPushMessage)));
    }

    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        try {
            Log.d("Assist_MZ", "onNotificationClicked receive msg ...");
            Log.d("Assist_MZ", "onNotificationClicked receive msg:" + mzPushMessage.getTitle() + u15.f19942b + mzPushMessage.getContent() + u15.f19942b + mzPushMessage.getSelfDefineContentString());
            String selfDefineContentString = mzPushMessage.getSelfDefineContentString();
            if (context != null && !TextUtils.isEmpty(selfDefineContentString)) {
                try {
                    JSONObject jSONObject = new JSONObject(selfDefineContentString);
                    if (jSONObject.has(MSG_KEY_PAYLOAD)) {
                        selfDefineContentString = jSONObject.getString(MSG_KEY_PAYLOAD);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (!TextUtils.isEmpty(selfDefineContentString)) {
                    MessageBean messageBean = new MessageBean(context, AssistPushConsts.MSG_TYPE_PAYLOAD, selfDefineContentString);
                    messageBean.setMessageSource(AssistPushConsts.MZ_PREFIX);
                    MessageManger.getInstance().addMessage(messageBean);
                }
            }
            AssistUtils.startGetuiService(context);
        } catch (Throwable th2) {
            Log.d("Assist_MZ", th2.getMessage());
        }
    }

    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
        Log.d("Assist_MZ", "onPushStatus:".concat(String.valueOf(pushSwitchStatus)));
    }

    public void onReceive(Context context, Intent intent) {
        this.context = context.getApplicationContext();
        super.onReceive(context, intent);
    }

    public void onRegister(Context context, String str) {
        try {
            Log.d("Assist_MZ", "onRegister :".concat(String.valueOf(str)));
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.MZ_PREFIX.concat(String.valueOf(str))));
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        try {
            Log.d("Assist_MZ", "onRegisterStatus :".concat(String.valueOf(registerStatus)));
            String pushId = registerStatus.getPushId();
            if (context == null || TextUtils.isEmpty(pushId)) {
                return;
            }
            MessageManger.getInstance().addMessage(new MessageBean(context, "token", AssistPushConsts.MZ_PREFIX.concat(String.valueOf(pushId))));
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }

    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    public void onUnRegister(Context context, boolean z) {
        Log.d("Assist_MZ", "onUnRegister:".concat(String.valueOf(z)));
    }

    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
        Log.d("Assist_MZ", "onUnRegisterStatus:".concat(String.valueOf(unRegisterStatus)));
    }

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        try {
            int i = this.statusBarIconId;
            if (i != 0) {
                pushNotificationBuilder.setStatusBarIcon(i);
                return;
            }
            Context context = this.context;
            if (context != null) {
                int identifier = context.getResources().getIdentifier(MZ_STATUS_BAR_SMALL_ICON, "drawable", this.context.getPackageName());
                this.statusBarIconId = identifier;
                if (identifier != 0) {
                    pushNotificationBuilder.setStatusBarIcon(identifier);
                }
            }
        } catch (Throwable th) {
            Log.d("Assist_MZ", th.getMessage());
        }
    }
}
