package cj.mobile.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class OAIDOldHelper implements IIdentifierListener {
    public a _listener;

    public interface a {
        void a(@NonNull String str);

        void b(@NonNull String str);
    }

    public OAIDOldHelper(a aVar) {
    }

    private int CallFromReflect(Context context) {
    }

    @Override // com.bun.miitmdid.interfaces.IIdentifierListener
    public void OnSupport(boolean z, IdSupplier idSupplier) {
    }

    public void getDeviceIds(Context context) {
    }
}
