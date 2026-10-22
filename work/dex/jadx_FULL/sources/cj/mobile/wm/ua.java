package cj.mobile.wm;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ua {

    public static class dexa implements ma.dexa {
        public File dexa = null;
        public final /* synthetic */ Context dexb;

        public dexa(Context context) {
            this.dexb = context;
        }
    }

    public static ea dexa(Context context) {
        return dexa(context, (ja) null);
    }

    public static ea dexa(Context context, ba baVar) {
        ea eaVar = new ea(new ma(new dexa(context.getApplicationContext())), baVar);
        eaVar.dexb();
        return eaVar;
    }

    public static ea dexa(Context context, ja jaVar) {
        return dexa(context, jaVar == null ? new ka(new pa()) : new ka(jaVar));
    }
}
