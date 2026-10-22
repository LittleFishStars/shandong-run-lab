package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;
import com.zj.adlib.j1b;
import com.zj.adlib.k1b;
import com.zj.adlib.q1b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f26138a;
    private a b;
    private j1b c;
    private j1b[] d = new j1b[32];
    private int e = -1;
    private k1b f;

    private void a(j1b j1bVar) {
        try {
            a aVar = this.b;
            if (aVar != null) {
                aVar.h();
                this.b = null;
            }
            a aVarC = c(j1bVar);
            this.b = aVarC;
            if (aVarC != null) {
                this.c = j1bVar;
                aVarC.d(this);
                this.b.b();
                this.b.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(j1b j1bVar) {
        try {
            f26138a++;
            a(j1bVar);
            int i = (this.e + 1) % 32;
            this.e = i;
            this.d[i] = j1bVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(j1b j1bVar) {
        try {
            if (j1bVar.f42488a != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new k1b();
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a aVar = this.b;
            if (aVar != null) {
                aVar.c(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            q1b.f(getApplicationContext());
            this.e = -1;
            f26138a = 0;
            b(new j1b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.b;
            if (aVar != null) {
                aVar.h();
                this.b = null;
            }
            this.c = null;
            this.d = null;
            k1b k1bVar = this.f;
            if (k1bVar != null) {
                k1bVar.h();
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                a aVar = this.b;
                if (aVar != null && !aVar.f()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f26138a == 1) {
                        finish();
                    }
                    return false;
                }
                this.e = -1;
                f26138a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.g());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            a aVar = this.b;
            if (aVar != null) {
                aVar.h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i = f26138a;
            if ((i != 1 || this.b == null) && i > 1) {
                f26138a = i - 1;
                int i2 = ((this.e - 1) + 32) % 32;
                this.e = i2;
                j1b j1bVar = this.d[i2];
                j1bVar.f17312a = bundle;
                a(j1bVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
