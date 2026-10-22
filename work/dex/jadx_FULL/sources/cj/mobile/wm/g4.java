package cj.mobile.wm;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g4 {
    public final int dexa;
    public final int dexb;
    public final Context dexc;

    public static class dexa implements dexb {
        public final DisplayMetrics dexa;

        public dexa(DisplayMetrics displayMetrics) {
            this.dexa = displayMetrics;
        }

        @Override // cj.mobile.wm.g4.dexb
        public int a() {
            return this.dexa.heightPixels;
        }

        @Override // cj.mobile.wm.g4.dexb
        public int b() {
            return this.dexa.widthPixels;
        }
    }

    public interface dexb {
        int a();

        int b();
    }

    public g4(Context context) {
        this(context, (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY), new dexa(context.getResources().getDisplayMetrics()));
    }

    public g4(Context context, ActivityManager activityManager, dexb dexbVar) {
        this.dexc = context;
        int iDexa = dexa(activityManager);
        int iB = dexbVar.b() * dexbVar.a() * 4;
        int i = iB * 4;
        int i2 = iB * 2;
        int i3 = i2 + i;
        if (i3 <= iDexa) {
            this.dexb = i2;
        } else {
            int iRound = Math.round(iDexa / 6.0f);
            this.dexb = iRound * 2;
            i = iRound * 4;
        }
        this.dexa = i;
        if (Log.isLoggable(com.ipd.dsp.internal.k.l.e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(dexa(this.dexb));
            sb.append(" pool size: ");
            sb.append(dexa(this.dexa));
            sb.append(" memory class limited? ");
            sb.append(i3 > iDexa);
            sb.append(" max size: ");
            sb.append(dexa(iDexa));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(dexb(activityManager));
            f1.dexa(com.ipd.dsp.internal.k.l.e, sb.toString());
        }
    }

    public static int dexa(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (dexb(activityManager) ? 0.33f : 0.4f));
    }

    private String dexa(int i) {
        return Formatter.formatFileSize(this.dexc, i);
    }

    public static boolean dexb(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int dexa() {
        return this.dexa;
    }

    public int dexb() {
        return this.dexb;
    }
}
