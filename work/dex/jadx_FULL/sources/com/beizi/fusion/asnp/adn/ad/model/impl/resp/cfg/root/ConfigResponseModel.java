package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root;

import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.asnp.adn.ad.model.IUpdateNotNullModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.beta.BetaPlanModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ext.ExtraConfigModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.log2.Analyse2ConfigModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.requrl.RequestUrlModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.statistics.StatisticsModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.update.UpdateModel;
import com.beizi.fusion.k5;
import com.beizi.fusion.kg;
import com.beizi.fusion.mg;
import com.beizi.fusion.om;
import com.beizi.fusion.pb;
import com.beizi.fusion.pl;
import com.beizi.fusion.tb;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ConfigResponseModel extends ASNPJsonResponseModel implements tb, IUpdateNotNullModel<ConfigResponseModel> {

    @kg(key = "logStrategy")
    private Analyse2ConfigModel analyse2ConfigModel;

    @kg(key = "betaPlan")
    private BetaPlanModel betaPlanModel;
    private ConfigResponseModel copyModel;

    @kg(key = LoginConstants.EXT)
    private ExtraConfigModel extraConfigModel;

    @kg(key = "requestUrl")
    private RequestUrlModel requestUrl;
    private boolean selfUpdate;

    @kg(key = "statistics")
    private StatisticsModel statistics;

    @kg(key = "spaceStrategy")
    private List<StrategyModel> strategyList;

    @kg(key = "update")
    private UpdateModel update;

    public ConfigResponseModel(JSONObject jSONObject) {
        super(jSONObject);
        this.selfUpdate = false;
    }

    public Analyse2ConfigModel getAnalyse2ConfigModel() {
        return this.analyse2ConfigModel;
    }

    public BetaPlanModel getBetaPlanModel() {
        return this.betaPlanModel;
    }

    public ExtraConfigModel getExtraConfigModel() {
        return this.extraConfigModel;
    }

    public RequestUrlModel getRequestUrl() {
        return this.requestUrl;
    }

    public String getRequestUrlMD5() {
        RequestUrlModel requestUrlModel = this.requestUrl;
        return requestUrlModel != null ? requestUrlModel.getVersion() : "";
    }

    public StatisticsModel getStatistics() {
        return this.statistics;
    }

    public String getStatisticsMD5() {
        StatisticsModel statisticsModel = this.statistics;
        return statisticsModel != null ? statisticsModel.getVersion() : "";
    }

    public List<StrategyModel> getStrategyList() {
        return this.strategyList;
    }

    public String getStrategyMD5(String str) {
        StrategyModel strategyModel;
        List<StrategyModel> list = this.strategyList;
        return (list == null || list.isEmpty() || (strategyModel = (StrategyModel) k5.a(this.strategyList, str, new pb() { // from class: com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel.1
            @Override // com.beizi.fusion.pb
            public boolean fetch(StrategyModel strategyModel2, String str2) {
                return strategyModel2 != null && str2.equals(strategyModel2.getSpaceID());
            }
        })) == null) ? "" : strategyModel.getVersion();
    }

    public UpdateModel getUpdate() {
        return this.update;
    }

    public String getUpdateMD5() {
        UpdateModel updateModel = this.update;
        return updateModel != null ? updateModel.getVersion() : "";
    }

    /* JADX INFO: renamed from: deepCopy, reason: merged with bridge method [inline-methods] */
    public synchronized ConfigResponseModel m164deepCopy() {
        if (this.copyModel == null || this.selfUpdate) {
            this.selfUpdate = false;
            this.copyModel = new ConfigResponseModel(this.mJsonObject);
        }
        return this.copyModel;
    }

    @Override // com.beizi.fusion.asnp.adn.ad.model.IUpdateNotNullModel
    public synchronized ConfigResponseModel partUpdate(ConfigResponseModel configResponseModel) {
        JSONObject jSONObjectB = mg.b();
        List<Field> listB = pl.b(getClass());
        if (listB.isEmpty()) {
            return this;
        }
        try {
            for (Field field : listB) {
                kg kgVar = (kg) field.getAnnotation(kg.class);
                if (kgVar != null) {
                    String strKey = kgVar.key();
                    mg.a(jSONObjectB, strKey, mg.c(this.mJsonObject, strKey));
                    Object objA = pl.a(configResponseModel, field);
                    if (objA != null) {
                        pl.a(this, field, objA);
                        mg.a(jSONObjectB, strKey, mg.c(configResponseModel.mJsonObject, strKey));
                    }
                }
            }
            this.mJsonObject = jSONObjectB;
            this.selfUpdate = true;
            return this;
        } catch (Throwable th) {
            om.a(th);
            return this;
        }
    }
}
