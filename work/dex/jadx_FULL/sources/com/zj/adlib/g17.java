package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.ProgressBar;
import com.androidquery.util.Constants;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g17 implements Runnable {
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f41799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressDialog f16675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f16676a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressBar f16677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16678a;
    public String f;

    public g17(Object obj) {
        if (obj instanceof ProgressBar) {
            this.f16677a = (ProgressBar) obj;
            return;
        }
        if (obj instanceof ProgressDialog) {
            this.f16675a = (ProgressDialog) obj;
        } else if (obj instanceof Activity) {
            this.f41799a = (Activity) obj;
        } else if (obj instanceof View) {
            this.f16676a = (View) obj;
        }
    }

    public final void a(String str) {
        if (this.f16675a != null) {
            new hq(this.f16675a.getContext()).z(this.f16675a);
        }
        Activity activity = this.f41799a;
        if (activity != null) {
            activity.setProgressBarIndeterminateVisibility(false);
            this.f41799a.setProgressBarVisibility(false);
        }
        ProgressBar progressBar = this.f16677a;
        if (progressBar != null) {
            progressBar.setTag(Constants.u, str);
            this.f16677a.setVisibility(0);
        }
        View view = this.f16677a;
        if (view == null) {
            view = this.f16676a;
        }
        if (view != null) {
            Object tag = view.getTag(Constants.u);
            if (tag == null || tag.equals(str)) {
                view.setTag(Constants.u, null);
                ProgressBar progressBar2 = this.f16677a;
                if (progressBar2 == null || !progressBar2.isIndeterminate()) {
                    return;
                }
                view.setVisibility(8);
            }
        }
    }

    public void b() {
        ProgressBar progressBar = this.f16677a;
        if (progressBar != null) {
            progressBar.setProgress(progressBar.getMax());
        }
        ProgressDialog progressDialog = this.f16675a;
        if (progressDialog != null) {
            progressDialog.setProgress(progressDialog.getMax());
        }
        Activity activity = this.f41799a;
        if (activity != null) {
            activity.setProgress(AVMDLDataLoader.KeyIsEnableEventInfo);
        }
    }

    public void c(String str) {
        if (gq.E()) {
            a(str);
        } else {
            this.f = str;
            gq.K(this);
        }
    }

    public void d(int i) {
        int i2;
        ProgressBar progressBar = this.f16677a;
        if (progressBar != null) {
            progressBar.incrementProgressBy(this.f16678a ? 1 : i);
        }
        ProgressDialog progressDialog = this.f16675a;
        if (progressDialog != null) {
            progressDialog.incrementProgressBy(this.f16678a ? 1 : i);
        }
        Activity activity = this.f41799a;
        if (activity != null) {
            if (this.f16678a) {
                i2 = this.L;
                this.L = i2 + 1;
            } else {
                int i3 = this.L + i;
                this.L = i3;
                i2 = (i3 * 10000) / this.K;
            }
            if (i2 > 9999) {
                i2 = 9999;
            }
            activity.setProgress(i2);
        }
    }

    public void e() {
        ProgressBar progressBar = this.f16677a;
        if (progressBar != null) {
            progressBar.setProgress(0);
            this.f16677a.setMax(10000);
        }
        ProgressDialog progressDialog = this.f16675a;
        if (progressDialog != null) {
            progressDialog.setProgress(0);
            this.f16675a.setMax(10000);
        }
        Activity activity = this.f41799a;
        if (activity != null) {
            activity.setProgress(0);
        }
        this.f16678a = false;
        this.L = 0;
        this.K = 10000;
    }

    public void f(int i) {
        if (i <= 0) {
            this.f16678a = true;
            i = 10000;
        }
        this.K = i;
        ProgressBar progressBar = this.f16677a;
        if (progressBar != null) {
            progressBar.setProgress(0);
            this.f16677a.setMax(i);
        }
        ProgressDialog progressDialog = this.f16675a;
        if (progressDialog != null) {
            progressDialog.setProgress(0);
            this.f16675a.setMax(i);
        }
    }

    public void g(String str) {
        e();
        if (this.f16675a != null) {
            new hq(this.f16675a.getContext()).q1(this.f16675a);
        }
        Activity activity = this.f41799a;
        if (activity != null) {
            activity.setProgressBarIndeterminateVisibility(true);
            this.f41799a.setProgressBarVisibility(true);
        }
        ProgressBar progressBar = this.f16677a;
        if (progressBar != null) {
            progressBar.setTag(Constants.u, str);
            this.f16677a.setVisibility(0);
        }
        View view = this.f16676a;
        if (view != null) {
            view.setTag(Constants.u, str);
            this.f16676a.setVisibility(0);
        }
    }

    public final void h(Object obj, String str, boolean z) {
        if (obj != null) {
            if (!(obj instanceof View)) {
                if (obj instanceof Dialog) {
                    Dialog dialog = (Dialog) obj;
                    hq hqVar = new hq(dialog.getContext());
                    if (z) {
                        hqVar.q1(dialog);
                        return;
                    } else {
                        hqVar.z(dialog);
                        return;
                    }
                }
                if (obj instanceof Activity) {
                    Activity activity = (Activity) obj;
                    activity.setProgressBarIndeterminateVisibility(z);
                    activity.setProgressBarVisibility(z);
                    if (z) {
                        activity.setProgress(0);
                        return;
                    }
                    return;
                }
                return;
            }
            View view = (View) obj;
            ProgressBar progressBar = obj instanceof ProgressBar ? (ProgressBar) obj : null;
            if (z) {
                view.setTag(Constants.u, str);
                view.setVisibility(0);
                if (progressBar != null) {
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    return;
                }
                return;
            }
            Object tag = view.getTag(Constants.u);
            if (tag == null || tag.equals(str)) {
                view.setTag(Constants.u, null);
                if (progressBar == null || !progressBar.isIndeterminate()) {
                    return;
                }
                view.setVisibility(8);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.f);
    }
}
