package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.dx7;
import com.zj.adlib.g2c;
import com.zj.adlib.lu7;
import com.zj.adlib.t3c;
import com.zj.adlib.wy3;
import com.zj.adlib.ys;
import com.zj.adlib.yw6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    @NonNull
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;

    @NonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;

    @NonNull
    @VisibleForTesting
    public static final Scope zaa = new Scope(dx7.f41301a);

    @NonNull
    @VisibleForTesting
    public static final Scope zab = new Scope("email");

    @NonNull
    @VisibleForTesting
    public static final Scope zac = new Scope(dx7.c);

    @NonNull
    @VisibleForTesting
    public static final Scope zad;

    @NonNull
    @VisibleForTesting
    public static final Scope zae;
    private static Comparator zag;

    @SafeParcelable.VersionField(id = 1)
    final int zaf;

    @SafeParcelable.Field(getter = "getScopes", id = 2)
    private final ArrayList zah;

    @Nullable
    @SafeParcelable.Field(getter = "getAccount", id = 3)
    private Account zai;

    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    private boolean zaj;

    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean zak;

    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean zal;

    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    private String zam;

    @Nullable
    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    private String zan;

    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    private ArrayList zao;

    @Nullable
    @SafeParcelable.Field(getter = "getLogSessionId", id = 10)
    private String zap;
    private Map zaq;

    static {
        Scope scope = new Scope(dx7.i);
        zad = scope;
        zae = new Scope(dx7.h);
        a aVar = new a();
        aVar.d();
        aVar.f();
        DEFAULT_SIGN_IN = aVar.b();
        a aVar2 = new a();
        aVar2.g(scope, new Scope[0]);
        DEFAULT_GAMES_SIGN_IN = aVar2.b();
        CREATOR = new t3c();
        zag = new g2c();
    }

    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList arrayList, @Nullable @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @Nullable @SafeParcelable.Param(id = 7) String str, @Nullable @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList arrayList2, @Nullable @SafeParcelable.Param(id = 10) String str3) {
        this(i, arrayList, account, z, z2, z3, str, str2, zam(arrayList2), str3);
    }

    @Nullable
    public static GoogleSignInOptions zab(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, ys.f46104a) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map zam(@Nullable List list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0052 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x005d A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0069  */
    /* JADX WARN: Code duplicated, block: B:30:0x006a A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0072 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zao.size() <= 0 && googleSignInOptions.zao.size() <= 0 && this.zah.size() == googleSignInOptions.getScopes().size() && this.zah.containsAll(googleSignInOptions.getScopes())) {
                Account account = this.zai;
                if (account == null) {
                    if (googleSignInOptions.getAccount() == null) {
                        if (TextUtils.isEmpty(this.zam)) {
                            if (TextUtils.isEmpty(googleSignInOptions.getServerClientId())) {
                                if (this.zal != googleSignInOptions.isForceCodeForRefreshToken() && this.zaj == googleSignInOptions.isIdTokenRequested() && this.zak == googleSignInOptions.isServerAuthCodeRequested() && TextUtils.equals(this.zap, googleSignInOptions.getLogSessionId())) {
                                    return true;
                                }
                            }
                        } else if (!this.zam.equals(googleSignInOptions.getServerClientId())) {
                            if (this.zal != googleSignInOptions.isForceCodeForRefreshToken()) {
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.getAccount())) {
                    if (TextUtils.isEmpty(this.zam)) {
                        if (TextUtils.isEmpty(googleSignInOptions.getServerClientId())) {
                            if (this.zal != googleSignInOptions.isForceCodeForRefreshToken()) {
                            }
                        }
                    } else if (!this.zam.equals(googleSignInOptions.getServerClientId())) {
                        if (this.zal != googleSignInOptions.isForceCodeForRefreshToken()) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    @Nullable
    @KeepForSdk
    public Account getAccount() {
        return this.zai;
    }

    @NonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zao;
    }

    @Nullable
    @KeepForSdk
    public String getLogSessionId() {
        return this.zap;
    }

    @NonNull
    public Scope[] getScopeArray() {
        ArrayList arrayList = this.zah;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @NonNull
    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zah);
    }

    @Nullable
    @KeepForSdk
    public String getServerClientId() {
        return this.zam;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.zah;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).getScopeUri());
        }
        Collections.sort(arrayList);
        wy3 wy3Var = new wy3();
        wy3Var.a(arrayList);
        wy3Var.a(this.zai);
        wy3Var.a(this.zam);
        wy3Var.c(this.zal);
        wy3Var.c(this.zaj);
        wy3Var.c(this.zak);
        wy3Var.a(this.zap);
        return wy3Var.b();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.zal;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.zaj;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.zak;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int iA = lu7.a(parcel);
        lu7.F(parcel, 1, this.zaf);
        lu7.d0(parcel, 2, getScopes(), false);
        lu7.S(parcel, 3, getAccount(), i, false);
        lu7.g(parcel, 4, isIdTokenRequested());
        lu7.g(parcel, 5, isServerAuthCodeRequested());
        lu7.g(parcel, 6, isForceCodeForRefreshToken());
        lu7.Y(parcel, 7, getServerClientId(), false);
        lu7.Y(parcel, 8, this.zan, false);
        lu7.d0(parcel, 9, getExtensions(), false);
        lu7.Y(parcel, 10, getLogSessionId(), false);
        lu7.b(parcel, iA);
    }

    @NonNull
    public final String zaf() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zah, zag);
            Iterator it = this.zah.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.zai;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.zaj);
            jSONObject.put("forceCodeForRefreshToken", this.zal);
            jSONObject.put("serverAuthRequested", this.zak);
            if (!TextUtils.isEmpty(this.zam)) {
                jSONObject.put("serverClientId", this.zam);
            }
            if (!TextUtils.isEmpty(this.zan)) {
                jSONObject.put("hostedDomain", this.zan);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Account f31204a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f5444a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map f5445a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Set f5446a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5447a;

        @Nullable
        public String b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5448b;

        @Nullable
        public String c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f5449c;

        public a() {
            this.f5446a = new HashSet();
            this.f5445a = new HashMap();
        }

        @NonNull
        @CanIgnoreReturnValue
        public a a(@NonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (this.f5445a.containsKey(Integer.valueOf(googleSignInOptionsExtension.b()))) {
                throw new IllegalStateException("Only one extension per type may be added");
            }
            List<Scope> listA = googleSignInOptionsExtension.a();
            if (listA != null) {
                this.f5446a.addAll(listA);
            }
            this.f5445a.put(Integer.valueOf(googleSignInOptionsExtension.b()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
            return this;
        }

        @NonNull
        public GoogleSignInOptions b() {
            if (this.f5446a.contains(GoogleSignInOptions.zae)) {
                Set set = this.f5446a;
                Scope scope = GoogleSignInOptions.zad;
                if (set.contains(scope)) {
                    this.f5446a.remove(scope);
                }
            }
            if (this.f5449c && (this.f31204a == null || !this.f5446a.isEmpty())) {
                d();
            }
            return new GoogleSignInOptions(new ArrayList(this.f5446a), this.f31204a, this.f5449c, this.f5447a, this.f5448b, this.f5444a, this.b, this.f5445a, this.c);
        }

        @NonNull
        @CanIgnoreReturnValue
        public a c() {
            this.f5446a.add(GoogleSignInOptions.zab);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a d() {
            this.f5446a.add(GoogleSignInOptions.zac);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a e(@NonNull String str) {
            this.f5449c = true;
            m(str);
            this.f5444a = str;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a f() {
            this.f5446a.add(GoogleSignInOptions.zaa);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a g(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            this.f5446a.add(scope);
            this.f5446a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @NonNull
        public a h(@NonNull String str) {
            i(str, false);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a i(@NonNull String str, boolean z) {
            this.f5447a = true;
            m(str);
            this.f5444a = str;
            this.f5448b = z;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a j(@NonNull String str) {
            this.f31204a = new Account(yw6.h(str), ys.f46104a);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public a k(@NonNull String str) {
            this.b = yw6.h(str);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a l(@NonNull String str) {
            this.c = str;
            return this;
        }

        public final String m(String str) {
            yw6.h(str);
            String str2 = this.f5444a;
            boolean z = true;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            yw6.b(z, "two different server client ids provided");
            return str;
        }

        public a(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f5446a = new HashSet();
            this.f5445a = new HashMap();
            yw6.l(googleSignInOptions);
            this.f5446a = new HashSet(googleSignInOptions.zah);
            this.f5447a = googleSignInOptions.zak;
            this.f5448b = googleSignInOptions.zal;
            this.f5449c = googleSignInOptions.zaj;
            this.f5444a = googleSignInOptions.zam;
            this.f31204a = googleSignInOptions.zai;
            this.b = googleSignInOptions.zan;
            this.f5445a = GoogleSignInOptions.zam(googleSignInOptions.zao);
            this.c = googleSignInOptions.zap;
        }
    }

    private GoogleSignInOptions(int i, ArrayList arrayList, @Nullable Account account, boolean z, boolean z2, boolean z3, @Nullable String str, @Nullable String str2, Map map, @Nullable String str3) {
        this.zaf = i;
        this.zah = arrayList;
        this.zai = account;
        this.zaj = z;
        this.zak = z2;
        this.zal = z3;
        this.zam = str;
        this.zan = str2;
        this.zao = new ArrayList(map.values());
        this.zaq = map;
        this.zap = str3;
    }
}
