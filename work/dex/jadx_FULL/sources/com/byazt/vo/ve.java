package com.byazt.vo;

import android.text.TextUtils;
import com.byazt.nc.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, 54})
public class ve extends a {
    public String c;
    public boolean n;
    public String tt;
    public List<a> uj;
    public boolean ve;

    public ve(String str, String str2) {
        super(null);
        this.c = str;
        this.tt = str2;
    }

    public static ve parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ve veVar = new ve();
            veVar.setId(jSONObject.optString("id"));
            veVar.setName(jSONObject.optString("name"));
            veVar.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    ve fromJson = parseFromJson(jSONArrayOptJSONArray.optJSONObject(i));
                    if (fromJson != null && fromJson.isValid()) {
                        veVar.addOption(fromJson);
                    }
                }
            }
            return veVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.byazt.nc.a
    public void addOption(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.uj == null) {
            this.uj = new ArrayList();
        }
        this.uj.add(aVar);
    }

    @Override // com.byazt.nc.a
    public String getId() {
        return this.c;
    }

    @Override // com.byazt.nc.a
    public boolean getIsSelected() {
        return this.ve;
    }

    @Override // com.byazt.nc.a
    public String getName() {
        return this.tt;
    }

    @Override // com.byazt.nc.a
    public List<a> getOptions() {
        return this.uj;
    }

    @Override // com.byazt.nc.a
    public boolean hasSecondOptions() {
        List<a> list = this.uj;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isNewUi() {
        return this.n;
    }

    @Override // com.byazt.nc.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.tt)) ? false : true;
    }

    public void setId(String str) {
        this.c = str;
    }

    @Override // com.byazt.nc.a
    public void setIsSelected(boolean z) {
        this.ve = z;
    }

    public void setName(String str) {
        this.tt = str;
    }

    public void setNewUi(boolean z) {
        this.n = z;
    }

    public JSONObject toJson() {
        try {
            if (!isValid()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", getId());
            jSONObject.put("name", getName());
            jSONObject.put("is_selected", getIsSelected());
            jSONObject.put("new_ui", this.n);
            if (hasSecondOptions()) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : getOptions()) {
                    if (aVar instanceof ve) {
                        jSONArray.put(((ve) aVar).toJson());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("options", jSONArray);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public ve() {
        super(null);
    }
}
