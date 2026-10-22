package com.byazt.cda;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.uk.sl;
import com.byazt.uq.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f28351a;
    public String c;
    public File n;
    public String sp;
    public String tt;
    public List<File> uj;
    public JSONObject ve;

    public static c c(JSONObject jSONObject, File file, List<File> list) {
        c cVar = new c();
        cVar.c = jSONObject.optString("version");
        cVar.tt = jSONObject.optString("package_name");
        cVar.ve = jSONObject.optJSONObject("adn_adapter_md5");
        cVar.sp = jSONObject.optString("alias_package_name");
        cVar.uj = list;
        cVar.n = file;
        cVar.f28351a = jSONObject;
        return cVar;
    }

    private boolean i() {
        JSONObject jSONObject;
        List<File> list = this.uj;
        boolean z = false;
        if (list == null || list.size() == 0 || (jSONObject = this.ve) == null || jSONObject.length() == 0) {
            StringBuilder sb = new StringBuilder("DexPluginConfig check md5 fail, packageName=");
            sb.append(this.tt);
            sb.append(" dexlist is ");
            sb.append(this.uj);
            sb.append(" dexlist size is ");
            List<File> list2 = this.uj;
            sb.append(list2 == null ? -1 : list2.size());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        int size = this.uj.size();
        int length = this.ve.length();
        for (File file : this.uj) {
            String strC = a.c(file);
            if (strC != null) {
                strC = strC.toLowerCase();
            }
            String strC2 = c(file.getName());
            if (TextUtils.equals(strC2, strC)) {
                size--;
                length--;
            } else {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.tt + "downloadFileMd5=" + strC + " configMd5=" + strC2);
            }
        }
        if (size == 0 && length == 0) {
            z = true;
        }
        StringBuilder sb2 = new StringBuilder("DexPluginConfig check md5 ");
        sb2.append(z ? "success" : "fail");
        sb2.append(", packageName=");
        sb2.append(this.tt);
        sb2.append(" fileSize=");
        sb2.append(size);
        sb2.append(" configFileSize=");
        sb2.append(length);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, sb2.toString());
        return z;
    }

    private boolean x() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapN = sl.c().n();
        if (mapN != null && mapN.size() > 0 && (jSONObject = mapN.get(this.tt)) != null && jSONObject.has(ALPParamConstant.PACKAGENAME) && TextUtils.equals(jSONObject.optString(ALPParamConstant.PACKAGENAME), this.tt)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.tt);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.tt + ", packageManager=" + mapN);
        return false;
    }

    public JSONObject a() {
        return this.f28351a;
    }

    public File n() {
        return this.n;
    }

    public String sp() {
        return this.sp;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.c + "', mPackageName='" + this.tt + "'}";
    }

    public String tt() {
        return this.tt;
    }

    public List<File> uj() {
        return this.uj;
    }

    public int ve() {
        if (TextUtils.isEmpty(this.c)) {
            return -1;
        }
        String strReplace = this.c.replace(Consts.DOT, "");
        if (TextUtils.isEmpty(strReplace)) {
            return -1;
        }
        try {
            return Integer.valueOf(strReplace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public boolean c() {
        return x() && i();
    }

    public String c(String str) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.ve) == null || !jSONObject.has(str)) ? "" : this.ve.optString(str);
    }
}
