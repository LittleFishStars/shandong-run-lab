package cn.hzjizhun.admin.util;

import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SRUtils {
    private static volatile boolean isInit = false;
    private static volatile boolean isStart = false;
    private static final Consumer<Integer> screenRecordingCallback = new a();

    public class a implements Consumer {
        @Override // java.util.function.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == 0) {
                ALog.innerD("ScreenRecording", "屏幕录制已停止。");
                boolean unused = SRUtils.isStart = false;
            } else {
                if (iIntValue != 1) {
                    return;
                }
                ALog.innerD("ScreenRecording", "屏幕正在被录制！");
                boolean unused2 = SRUtils.isStart = true;
            }
        }
    }

    public static boolean isStart() {
        return isStart;
    }

    public static void startCheck(Context context) {
        try {
            if (!isInit && Build.VERSION.SDK_INT >= 35) {
                isInit = true;
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Executor mainExecutor = ContextCompat.getMainExecutor(context);
                Consumer<Integer> consumer = screenRecordingCallback;
                consumer.accept(Integer.valueOf(windowManager.addScreenRecordingCallback(mainExecutor, consumer)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void stopCheck(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 35) {
                ((WindowManager) context.getSystemService("window")).removeScreenRecordingCallback(screenRecordingCallback);
            }
        } catch (Throwable unused) {
        }
    }
}
