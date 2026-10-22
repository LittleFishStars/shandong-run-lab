package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b extends AndroidClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f30410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1892a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    /* JADX INFO: renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    public static final class C0665b extends AndroidClientInfo.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f30411a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1893a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo a() {
            return new b(this.f30411a, this.f1893a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder b(@Nullable String str) {
            this.k = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder c(@Nullable String str) {
            this.i = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder d(@Nullable String str) {
            this.c = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder e(@Nullable String str) {
            this.g = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder f(@Nullable String str) {
            this.b = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder g(@Nullable String str) {
            this.h = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder h(@Nullable String str) {
            this.f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder i(@Nullable String str) {
            this.j = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder j(@Nullable String str) {
            this.f1893a = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder k(@Nullable String str) {
            this.e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder l(@Nullable String str) {
            this.d = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder m(@Nullable Integer num) {
            this.f30411a = num;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String b() {
        return this.k;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String c() {
        return this.i;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String d() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.f30410a;
        if (num != null ? num.equals(androidClientInfo.m()) : androidClientInfo.m() == null) {
            String str = this.f1892a;
            if (str != null ? str.equals(androidClientInfo.j()) : androidClientInfo.j() == null) {
                String str2 = this.b;
                if (str2 != null ? str2.equals(androidClientInfo.f()) : androidClientInfo.f() == null) {
                    String str3 = this.c;
                    if (str3 != null ? str3.equals(androidClientInfo.d()) : androidClientInfo.d() == null) {
                        String str4 = this.d;
                        if (str4 != null ? str4.equals(androidClientInfo.l()) : androidClientInfo.l() == null) {
                            String str5 = this.e;
                            if (str5 != null ? str5.equals(androidClientInfo.k()) : androidClientInfo.k() == null) {
                                String str6 = this.f;
                                if (str6 != null ? str6.equals(androidClientInfo.h()) : androidClientInfo.h() == null) {
                                    String str7 = this.g;
                                    if (str7 != null ? str7.equals(androidClientInfo.e()) : androidClientInfo.e() == null) {
                                        String str8 = this.h;
                                        if (str8 != null ? str8.equals(androidClientInfo.g()) : androidClientInfo.g() == null) {
                                            String str9 = this.i;
                                            if (str9 != null ? str9.equals(androidClientInfo.c()) : androidClientInfo.c() == null) {
                                                String str10 = this.j;
                                                if (str10 != null ? str10.equals(androidClientInfo.i()) : androidClientInfo.i() == null) {
                                                    String str11 = this.k;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.b() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.b())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String f() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String g() {
        return this.h;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String h() {
        return this.f;
    }

    public int hashCode() {
        Integer num = this.f30410a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f1892a;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.b;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.d;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.e;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.g;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.h;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.i;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.j;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.k;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String i() {
        return this.j;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String j() {
        return this.f1892a;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String k() {
        return this.e;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public String l() {
        return this.d;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    @Nullable
    public Integer m() {
        return this.f30410a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f30410a + ", model=" + this.f1892a + ", hardware=" + this.b + ", device=" + this.c + ", product=" + this.d + ", osBuild=" + this.e + ", manufacturer=" + this.f + ", fingerprint=" + this.g + ", locale=" + this.h + ", country=" + this.i + ", mccMnc=" + this.j + ", applicationBuild=" + this.k + "}";
    }

    public b(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.f30410a = num;
        this.f1892a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
    }
}
