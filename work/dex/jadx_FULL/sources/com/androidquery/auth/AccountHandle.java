package com.androidquery.auth;

import android.content.Context;
import com.androidquery.callback.AbstractAjaxCallback;
import com.zj.adlib.c30;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.http.HttpRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AccountHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashSet<AbstractAjaxCallback<?, ?>> f26162a;

    public void a(AbstractAjaxCallback<?, ?> abstractAjaxCallback, HttpURLConnection httpURLConnection) {
    }

    public abstract void auth();

    public void b(AbstractAjaxCallback<?, ?> abstractAjaxCallback, HttpRequest httpRequest) {
    }

    public synchronized void c(AbstractAjaxCallback<?, ?> abstractAjaxCallback) {
        LinkedHashSet<AbstractAjaxCallback<?, ?>> linkedHashSet = this.f26162a;
        if (linkedHashSet == null) {
            LinkedHashSet<AbstractAjaxCallback<?, ?>> linkedHashSet2 = new LinkedHashSet<>();
            this.f26162a = linkedHashSet2;
            linkedHashSet2.add(abstractAjaxCallback);
            auth();
        } else {
            linkedHashSet.add(abstractAjaxCallback);
        }
    }

    public abstract boolean d();

    public abstract boolean e(AbstractAjaxCallback<?, ?> abstractAjaxCallback, c30 c30Var);

    public String f(String str) {
        return str;
    }

    public synchronized void failure(Context context, int i, String str) {
        LinkedHashSet<AbstractAjaxCallback<?, ?>> linkedHashSet = this.f26162a;
        if (linkedHashSet != null) {
            Iterator<AbstractAjaxCallback<?, ?>> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                it.next().y(i, str);
            }
            this.f26162a = null;
        }
    }

    public String g(String str) {
        return str;
    }

    public abstract boolean h(AbstractAjaxCallback<?, ?> abstractAjaxCallback);

    public void i() {
    }

    public synchronized void success(Context context) {
        LinkedHashSet<AbstractAjaxCallback<?, ?>> linkedHashSet = this.f26162a;
        if (linkedHashSet != null) {
            Iterator<AbstractAjaxCallback<?, ?>> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                it.next().f(context);
            }
            this.f26162a = null;
        }
    }
}
