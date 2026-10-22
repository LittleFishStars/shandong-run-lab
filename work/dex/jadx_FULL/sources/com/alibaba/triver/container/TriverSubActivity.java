package com.alibaba.triver.container;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.triver.TriverActivity;
import com.alibaba.triver.ipc.client.IpcMsgClientService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverSubActivity extends TriverActivity {
    private static final String c = "AriverTriver:MultiProcess";
    private static Map<Class<? extends Activity>, Class<? extends Activity>> d;

    public static class TriverSubActivity1 extends TriverSubActivityX {
        @Override // com.alibaba.triver.container.TriverSubActivity, com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            Intent intent = new Intent();
            intent.setClass(this, IpcMsgClientService.IpcMsgClientService1.class);
            startService(intent);
        }
    }

    public static class TriverSubActivity1Trans extends TriverSubActivity1 {
    }

    public static class TriverSubActivity2 extends TriverSubActivityX {
        @Override // com.alibaba.triver.container.TriverSubActivity, com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            Intent intent = new Intent();
            intent.setClass(this, IpcMsgClientService.IpcMsgClientService2.class);
            startService(intent);
        }
    }

    public static class TriverSubActivity2Trans extends TriverSubActivity2 {
    }

    public static class TriverSubActivity3 extends TriverSubActivityX {
        @Override // com.alibaba.triver.container.TriverSubActivity, com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            Intent intent = new Intent();
            intent.setClass(this, IpcMsgClientService.IpcMsgClientService3.class);
            startService(intent);
        }
    }

    public static class TriverSubActivity3Trans extends TriverSubActivity3 {
    }

    public static class TriverSubActivity4 extends TriverSubActivityX {
        @Override // com.alibaba.triver.container.TriverSubActivity, com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            Intent intent = new Intent();
            intent.setClass(this, IpcMsgClientService.IpcMsgClientService4.class);
            startService(intent);
        }
    }

    public static class TriverSubActivity4Trans extends TriverSubActivity4 {
    }

    public static class TriverSubActivity5 extends TriverSubActivityX {
        @Override // com.alibaba.triver.container.TriverSubActivity, com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(@Nullable Bundle bundle) {
            super.onCreate(bundle);
            Intent intent = new Intent();
            intent.setClass(this, IpcMsgClientService.IpcMsgClientService5.class);
            startService(intent);
        }
    }

    public static class TriverSubActivity5Trans extends TriverSubActivity5 {
    }

    public static class TriverSubActivityX extends TriverSubActivity {
        @Override // android.app.Activity
        public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
            if (isTaskRoot()) {
                super.setTaskDescription(taskDescription);
            }
        }
    }

    static {
        HashMap map = new HashMap();
        d = map;
        map.put(TriverSubActivity1.class, TriverSubActivity1Trans.class);
        d.put(TriverSubActivity2.class, TriverSubActivity2Trans.class);
        d.put(TriverSubActivity3.class, TriverSubActivity3Trans.class);
        d.put(TriverSubActivity4.class, TriverSubActivity4Trans.class);
        d.put(TriverSubActivity5.class, TriverSubActivity5Trans.class);
        d.put(TriverMainActivity.class, TriverMainActivity.TriverMainActivityTrans.class);
    }

    public static Class<? extends Activity> a(Class<? extends Activity> cls) {
        return d.get(cls);
    }

    @Override // com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.alibaba.triver.TriverActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
