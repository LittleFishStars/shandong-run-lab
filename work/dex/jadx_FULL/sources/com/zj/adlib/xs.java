package com.zj.adlib;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.huawei.hms.common.AccountPicker;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xs {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45890a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Account f20719a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Bundle f20720a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public j7c f20721a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f20722a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public ArrayList f20723a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f20724a;

        @Nullable
        public String b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public ArrayList f20725b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f20726b;

        @Nullable
        public String c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f20727c;
        public boolean d;
        public boolean e;
        public boolean f;

        /* JADX INFO: renamed from: com.zj.adlib.xs$a$a, reason: collision with other inner class name */
        public static class C1336a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public Account f45891a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public Bundle f20728a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public String f20729a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            @Nullable
            public ArrayList f20730a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f20731a = false;

            @Nullable
            public ArrayList b;

            @NonNull
            public a a() {
                yw6.b(true, "We only support hostedDomain filter for account chip styled account picker");
                yw6.b(true, "Consent is only valid for account chip styled account picker");
                a aVar = new a();
                aVar.f20725b = this.b;
                aVar.f20723a = this.f20730a;
                aVar.f20726b = this.f20731a;
                aVar.f20721a = null;
                aVar.b = null;
                aVar.f20720a = this.f20728a;
                aVar.f20719a = this.f45891a;
                aVar.f20724a = false;
                aVar.f20727c = false;
                aVar.c = null;
                aVar.f45890a = 0;
                aVar.f20722a = this.f20729a;
                aVar.d = false;
                aVar.e = false;
                aVar.f = false;
                return aVar;
            }

            @NonNull
            @CanIgnoreReturnValue
            public C1336a b(@Nullable List<Account> list) {
                this.f20730a = list == null ? null : new ArrayList(list);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public C1336a c(@Nullable List<String> list) {
                this.b = list == null ? null : new ArrayList(list);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public C1336a d(boolean z) {
                this.f20731a = z;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public C1336a e(@Nullable Bundle bundle) {
                this.f20728a = bundle;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public C1336a f(@Nullable Account account) {
                this.f45891a = account;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public C1336a g(@Nullable String str) {
                this.f20729a = str;
                return this;
            }
        }

        public static /* bridge */ /* synthetic */ boolean D(a aVar) {
            boolean z = aVar.e;
            return false;
        }

        public static /* bridge */ /* synthetic */ boolean a(a aVar) {
            boolean z = aVar.f;
            return false;
        }

        public static /* bridge */ /* synthetic */ boolean b(a aVar) {
            boolean z = aVar.f20724a;
            return false;
        }

        public static /* bridge */ /* synthetic */ boolean c(a aVar) {
            boolean z = aVar.f20727c;
            return false;
        }

        public static /* bridge */ /* synthetic */ boolean d(a aVar) {
            boolean z = aVar.d;
            return false;
        }

        public static /* bridge */ /* synthetic */ int e(a aVar) {
            int i = aVar.f45890a;
            return 0;
        }

        public static /* bridge */ /* synthetic */ j7c h(a aVar) {
            j7c j7cVar = aVar.f20721a;
            return null;
        }

        public static /* bridge */ /* synthetic */ String i(a aVar) {
            String str = aVar.b;
            return null;
        }

        public static /* bridge */ /* synthetic */ String j(a aVar) {
            String str = aVar.c;
            return null;
        }
    }

    @NonNull
    @Deprecated
    public static Intent a(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        yw6.b(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, arrayList);
        intent.putExtra(AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, strArr);
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, bundle);
        intent.putExtra(AccountPicker.EXTRA_SELECTED_ACCOUNT, account);
        intent.putExtra(AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, z);
        intent.putExtra(AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, str);
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, str2);
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra(AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        intent.putExtra(AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        intent.putExtra(AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        return intent;
    }

    @NonNull
    public static Intent b(@NonNull a aVar) {
        Intent intent = new Intent();
        a.d(aVar);
        a.i(aVar);
        yw6.b(true, "We only support hostedDomain filter for account chip styled account picker");
        a.h(aVar);
        yw6.b(true, "Consent is only valid for account chip styled account picker");
        a.b(aVar);
        yw6.b(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        a.d(aVar);
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra(AccountPicker.EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, aVar.f20723a);
        if (aVar.f20725b != null) {
            intent.putExtra(AccountPicker.EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, (String[]) aVar.f20725b.toArray(new String[0]));
        }
        intent.putExtra(AccountPicker.EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, aVar.f20720a);
        intent.putExtra(AccountPicker.EXTRA_SELECTED_ACCOUNT, aVar.f20719a);
        a.b(aVar);
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra(AccountPicker.EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, aVar.f20726b);
        intent.putExtra(AccountPicker.EXTRA_DESCRIPTION_TEXT_OVERRIDE, aVar.f20722a);
        a.c(aVar);
        intent.putExtra("setGmsCoreAccount", false);
        a.j(aVar);
        intent.putExtra(AccountPicker.EXTRA_REAL_CLIENT_PACKAGE, (String) null);
        a.e(aVar);
        intent.putExtra(AccountPicker.EXTRA_OVERRIDE_THEME, 0);
        a.d(aVar);
        intent.putExtra(AccountPicker.EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        a.i(aVar);
        intent.putExtra(AccountPicker.EXTRA_HOSTED_DOMAIN_FILTER, (String) null);
        Bundle bundle = new Bundle();
        a.d(aVar);
        a.h(aVar);
        a.D(aVar);
        a.a(aVar);
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
