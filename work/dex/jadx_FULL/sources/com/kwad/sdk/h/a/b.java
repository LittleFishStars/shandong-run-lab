package com.kwad.sdk.h.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.br;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class b extends com.kwad.sdk.core.response.a.a {
    public String aEX;
    public String bgG;
    public String bgH;
    public String bgI;
    public long bgJ;
    public boolean bgK;
    public int loadType;
    public int packageType;
    public String packageUrl;
    public String version;

    public final long Re() {
        return this.bgJ;
    }

    public final void aV(long j) {
        this.bgJ = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (br.isEquals(this.bgG, bVar.bgG) && br.isEquals(this.aEX, bVar.aEX) && br.isEquals(this.version, bVar.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bgG);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(this.aEX);
        sb.append(LoginConstants.UNDER_LINE);
        sb.append(this.version);
        return TextUtils.isEmpty(sb.toString()) ? super.hashCode() : sb.toString().hashCode();
    }

    public final boolean isValid() {
        return (TextUtils.isEmpty(this.bgG) || TextUtils.isEmpty(this.packageUrl) || TextUtils.isEmpty(this.version) || TextUtils.isEmpty(this.bgH)) ? false : true;
    }

    @Override // com.kwad.sdk.core.response.a.a
    @NonNull
    public String toString() {
        return "PackageInfoBean{packageId='" + this.bgG + "', zipFileName='" + this.bgH + "', zipPath='" + this.bgI + "', startDownloadTime=" + this.bgJ + ", packageUrl='" + this.packageUrl + "', version='" + this.version + "', checksum='" + this.aEX + "', loadType=" + this.loadType + ", packageType=" + this.packageType + ", isPublic=" + this.bgK + '}';
    }
}
