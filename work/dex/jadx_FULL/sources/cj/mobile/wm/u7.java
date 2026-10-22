package cj.mobile.wm;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u7 implements Handler.Callback {
    public static final u7 dexd = new u7();
    public volatile f2 dexa;
    public final Map<FragmentManager, t7> dexb = new HashMap();
    public final Handler dexc = new Handler(Looper.getMainLooper(), this);

    public static u7 dexa() {
        return dexd;
    }

    private f2 dexb(Context context) {
        if (this.dexa == null) {
            synchronized (this) {
                if (this.dexa == null) {
                    this.dexa = new f2(context.getApplicationContext(), new l7(), new p7());
                }
            }
        }
        return this.dexa;
    }

    @TargetApi(17)
    public static void dexb(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(11)
    public f2 dexa(Activity activity) {
        if (e9.dexb()) {
            return dexa(activity.getApplicationContext());
        }
        dexb(activity);
        return dexa(activity, activity.getFragmentManager());
    }

    public f2 dexa(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (e9.dexc() && !(context instanceof Application)) {
            if (context instanceof Activity) {
                return dexa((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return dexa(((ContextWrapper) context).getBaseContext());
            }
        }
        return dexb(context);
    }

    @TargetApi(11)
    public f2 dexa(Context context, FragmentManager fragmentManager) {
        t7 t7VarDexa = dexa(fragmentManager);
        f2 f2VarDexb = t7VarDexa.dexb();
        if (f2VarDexb != null) {
            return f2VarDexb;
        }
        f2 f2Var = new f2(context, t7VarDexa.dexa(), t7VarDexa.dexc());
        t7VarDexa.dexa(f2Var);
        return f2Var;
    }

    @TargetApi(17)
    public t7 dexa(FragmentManager fragmentManager) {
        t7 t7Var = (t7) fragmentManager.findFragmentByTag("com.youku.insightvision.sdk.openadsdk.image.glide.manager");
        if (t7Var != null) {
            return t7Var;
        }
        t7 t7Var2 = this.dexb.get(fragmentManager);
        if (t7Var2 != null) {
            return t7Var2;
        }
        t7 t7Var3 = new t7();
        this.dexb.put(fragmentManager, t7Var3);
        fragmentManager.beginTransaction().add(t7Var3, "com.youku.insightvision.sdk.openadsdk.image.glide.manager").commitAllowingStateLoss();
        this.dexc.obtainMessage(1, fragmentManager).sendToTarget();
        return t7Var3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        t7 t7VarRemove;
        FragmentManager fragmentManager;
        int i = message.what;
        boolean z = true;
        if (i != 1) {
            t7VarRemove = null;
            z = i == 2;
            fragmentManager = null;
        } else {
            FragmentManager fragmentManager2 = (FragmentManager) message.obj;
            t7VarRemove = this.dexb.remove(fragmentManager2);
            fragmentManager = fragmentManager2;
        }
        if (z && t7VarRemove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + fragmentManager);
        }
        return z;
    }
}
