package cj.mobile;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import cj.mobile.a.i;
import cj.mobile.listener.CJVideoContentListener;
import cj.mobile.p.d;
import java.io.IOException;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJVideoContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f21778a;
    public CJVideoContentListener b;
    public String c;
    public JSONArray d;
    public String e;
    public String f;
    public String g;
    public i h;
    public Handler i;

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJVideoContent f21780a;

        public b(CJVideoContent cJVideoContent) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public void loadVideoContent(Activity activity, String str, CJVideoContentListener cJVideoContentListener) {
    }

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21779a;
        public final /* synthetic */ CJVideoContent b;

        public a(CJVideoContent cJVideoContent, Activity activity) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public final void a(String str, String str2) {
    }

    public final void a(JSONArray jSONArray) {
    }

    public final void a(String str) {
    }
}
