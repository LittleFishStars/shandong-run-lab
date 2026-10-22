package com.zj.adlib;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.util.Constants;
import java.io.IOException;
import org.apache.http.HttpRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rv3 extends AccountHandle implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Account f44540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AccountManager f19426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f19427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Account[] f19428a;
    public String f;
    public String g;
    public String h;

    public class b extends AsyncTask<String, String, Bundle> {
        public b() {
        }

        @Override // android.os.AsyncTask
        public Bundle doInBackground(String... strArr) {
            try {
                return rv3.this.f19426a.getAuthToken(rv3.this.f44540a, rv3.this.f, (Bundle) null, rv3.this.f19427a, (AccountManagerCallback<Bundle>) null, (Handler) null).getResult();
            } catch (AuthenticatorException e) {
                gq.k(e);
                return null;
            } catch (OperationCanceledException unused) {
                return null;
            } catch (IOException e2) {
                gq.k(e2);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("authtoken")) {
                rv3 rv3Var = rv3.this;
                rv3Var.failure(rv3Var.f19427a, c30.i, "rejected");
            } else {
                rv3.this.h = bundle.getString("authtoken");
                rv3 rv3Var2 = rv3.this;
                rv3Var2.success(rv3Var2.f19427a);
            }
        }
    }

    public rv3(Activity activity, String str, String str2) {
        str2 = Constants.f1191b.equals(str2) ? q(activity) : str2;
        this.f19427a = activity;
        this.f = str.substring(2);
        this.g = str2;
        this.f19426a = AccountManager.get(activity);
    }

    public static String q(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.f1191b, null);
    }

    public static void r(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Constants.f1191b, str).commit();
    }

    @Override // com.androidquery.auth.AccountHandle
    public void auth() {
        if (this.g == null) {
            o();
            return;
        }
        for (Account account : this.f19426a.getAccountsByType(ys.f46104a)) {
            if (this.g.equals(account.name)) {
                p(account);
                return;
            }
        }
    }

    @Override // com.androidquery.auth.AccountHandle
    public void b(AbstractAjaxCallback<?, ?> abstractAjaxCallback, HttpRequest httpRequest) {
        httpRequest.addHeader("Authorization", "GoogleLogin auth=" + this.h);
    }

    @Override // com.androidquery.auth.AccountHandle
    public boolean d() {
        return this.h != null;
    }

    @Override // com.androidquery.auth.AccountHandle
    public boolean e(AbstractAjaxCallback<?, ?> abstractAjaxCallback, c30 c30Var) {
        int iF = c30Var.f();
        return iF == 401 || iF == 403;
    }

    @Override // com.androidquery.auth.AccountHandle
    public String f(String str) {
        return str + "#" + this.h;
    }

    public String getType() {
        return this.f;
    }

    @Override // com.androidquery.auth.AccountHandle
    public boolean h(AbstractAjaxCallback<?, ?> abstractAjaxCallback) {
        this.f19426a.invalidateAuthToken(this.f44540a.type, this.h);
        try {
            String strBlockingGetAuthToken = this.f19426a.blockingGetAuthToken(this.f44540a, this.f, true);
            this.h = strBlockingGetAuthToken;
            gq.j("re token", strBlockingGetAuthToken);
        } catch (Exception e) {
            gq.k(e);
            this.h = null;
        }
        return this.h != null;
    }

    public final void o() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f19427a);
        Account[] accountsByType = this.f19426a.getAccountsByType(ys.f46104a);
        this.f19428a = accountsByType;
        int length = accountsByType.length;
        if (length == 1) {
            p(accountsByType[0]);
            return;
        }
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = this.f19428a[i].name;
        }
        builder.setItems(strArr, this);
        builder.setOnCancelListener(this);
        new hq(this.f19427a).q1(builder.create());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        failure(this.f19427a, c30.i, "cancel");
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Account account = this.f19428a[i];
        gq.j("acc", account.name);
        r(this.f19427a, account.name);
        p(account);
    }

    public final void p(Account account) {
        this.f44540a = account;
        new b().execute(new String[0]);
    }
}
