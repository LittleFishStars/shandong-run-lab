package huachenjie.sdk.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.PushManager;
import com.zj.adlib.c49;
import com.zj.adlib.t47;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lhuachenjie/sdk/push/PushActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/content/Intent;", "intent", "onNewIntent", "", "a", "", "f", "Ljava/lang/String;", "TAG", "<init>", "()V", "push_release"}, k = 1, mv = {1, 8, 0})
public final class PushActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String TAG = "hcj_push";

    public final boolean a(@Nullable Intent intent) {
        try {
            Intrinsics.checkNotNull(intent);
            String stringExtra = intent.getStringExtra("gttask");
            String stringExtra2 = intent.getStringExtra("gtaction");
            String clientid = PushManager.getInstance().getClientid(this);
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            String str = stringExtra + clientid + new Regex(c49.f40900a).replace(string, "");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String string2 = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
            if (stringExtra2 != null) {
                return PushManager.getInstance().sendFeedbackMessage(this, stringExtra, string2, Integer.parseInt(stringExtra2));
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AssistPushConsts.MSG_TYPE_PAYLOAD);
            Log.d(this.TAG, "payload = " + stringExtra);
            if (stringExtra == null) {
                stringExtra = "";
            }
            t47.g(this, stringExtra);
        }
        a(intent);
        finish();
    }

    @Override // android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AssistPushConsts.MSG_TYPE_PAYLOAD);
            Log.d(this.TAG, "payload = " + stringExtra);
            if (stringExtra == null) {
                stringExtra = "";
            }
            t47.g(this, stringExtra);
        }
        finish();
    }
}
