package com.huachenjie.social_contact.page.suit;

import androidx.p002lifecycle.LiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.ModelListBean;
import com.huachenjie.social_contact.bean.UserAssetsBean;
import com.huachenjie.social_contact.bean.UserCultivateInfo;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\f\u0010\u000fR\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\n8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "mWearType", "", t.d, "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "userMainModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "userCultivateInfo", "Lcom/huachenjie/social_contact/page/suit/UserWearTypeAdapter;", "kotlin.jvm.PlatformType", "k", "userWearTypeAdapter", "Lcom/huachenjie/social_contact/bean/UserAssetsBean;", "userAssetsBean", "Lcom/huachenjie/social_contact/bean/ModelListBean;", y6b.g, "initModel", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public UniverseModel userMainModel = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserCultivateInfo> userCultivateInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserWearTypeAdapter> userWearTypeAdapter = new MutableLiveData<>(new UserWearTypeAdapter());

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserAssetsBean> userAssetsBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ModelListBean> initModel = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/social_contact/bean/UserCultivateInfo;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nUserWearVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserWearVM.kt\ncom/huachenjie/social_contact/page/suit/UserWearVM$loadUserCultivateInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n350#2,7:80\n350#2,7:87\n1#3:94\n*S KotlinDebug\n*F\n+ 1 UserWearVM.kt\ncom/huachenjie/social_contact/page/suit/UserWearVM$loadUserCultivateInfo$1\n*L\n49#1:80,7\n56#1:87,7\n*E\n"})
    public static final class a extends BizSubscriber<UserCultivateInfo> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserWearVM f36324a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, UserWearVM userWearVM) {
            super(true);
            this.K = i;
            this.f36324a = userWearVM;
        }

        /* JADX WARN: Code duplicated, block: B:151:0x00bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:152:0x00c2 A[EDGE_INSN: B:152:0x00c2->B:67:0x00c2 BREAK  A[LOOP:4: B:56:0x00a4->B:64:0x00bc], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:53:0x0099  */
        /* JADX WARN: Code duplicated, block: B:55:0x009f  */
        /* JADX WARN: Code duplicated, block: B:58:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
        /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:64:0x00bc A[LOOP:4: B:56:0x00a4->B:64:0x00bc, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:68:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:70:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
        /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:76:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:78:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:82:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:86:0x00fa A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:88:0x00fd  */
        public void onCCSuccess(@Nullable UserCultivateInfo data) {
            ModelListBean modelListBean;
            ArrayList<ModelListBean> modelList;
            int i;
            boolean z;
            UserWearTypeAdapter value;
            ArrayList<ModelListBean> modelList2;
            ModelListBean modelListBean2;
            ArrayList<ModelListBean> modelList3;
            int size;
            Iterator<ModelListBean> it;
            boolean z2;
            Integer intOrNull;
            int i2;
            Object next;
            if (data == null) {
                return;
            }
            ArrayList<ModelListBean> modelList4 = data.getModelList();
            Object obj = null;
            if (modelList4 != null) {
                Iterator<T> it2 = modelList4.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!(((ModelListBean) next).getType() == 3));
                modelListBean = (ModelListBean) next;
            } else {
                modelListBean = null;
            }
            if (modelListBean != null) {
                modelListBean.setWearStatus(0);
            }
            int i3 = this.K;
            if (i3 > -1) {
                data.setWearType(i3);
            }
            this.f36324a.j().setValue(data);
            if (this.K > -1) {
                modelList = data.getModelList();
                if (modelList != null) {
                    it = modelList.iterator();
                    i = 0;
                    while (true) {
                        if (it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (it.next().getType() == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            break;
                        } else {
                            i++;
                        }
                    }
                } else {
                    i = 0;
                }
                if (i < 0) {
                    z = false;
                } else {
                    modelList3 = data.getModelList();
                    if (modelList3 != null) {
                        size = modelList3.size();
                    } else {
                        size = 0;
                    }
                    if (i < size) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    modelList2 = data.getModelList();
                    if (modelList2 != null) {
                        modelListBean2 = modelList2.get(i);
                    } else {
                        modelListBean2 = null;
                    }
                    if (modelListBean2 != null) {
                        modelListBean2.setWearStatus(1);
                    }
                }
                value = this.f36324a.k().getValue();
                if (value != null) {
                    if (i <= -1) {
                        i = 0;
                    }
                    value.h(i);
                }
            } else if (data.getPersonType() == 2) {
                modelList = data.getModelList();
                if (modelList != null) {
                    it = modelList.iterator();
                    i = 0;
                    while (true) {
                        if (it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (it.next().getType() == 3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            break;
                            break;
                        }
                        i++;
                    }
                } else {
                    i = 0;
                }
                if (i < 0) {
                    z = false;
                } else {
                    modelList3 = data.getModelList();
                    if (modelList3 != null) {
                        size = modelList3.size();
                    } else {
                        size = 0;
                    }
                    if (i < size) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    modelList2 = data.getModelList();
                    if (modelList2 != null) {
                        modelListBean2 = modelList2.get(i);
                    } else {
                        modelListBean2 = null;
                    }
                    if (modelListBean2 != null) {
                        modelListBean2.setWearStatus(1);
                    }
                }
                value = this.f36324a.k().getValue();
                if (value != null) {
                    if (i <= -1) {
                        i = 0;
                    }
                    value.h(i);
                }
            } else {
                ArrayList<ModelListBean> modelList5 = data.getModelList();
                if (modelList5 != null) {
                    Iterator<ModelListBean> it3 = modelList5.iterator();
                    i2 = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            i2 = -1;
                            break;
                        } else if (it3.next().getWearStatus() == 1) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                } else {
                    i2 = 0;
                }
                UserWearTypeAdapter value2 = this.f36324a.k().getValue();
                if (value2 != null) {
                    if (i2 <= -1) {
                        i2 = 0;
                    }
                    value2.h(i2);
                }
            }
            UserWearTypeAdapter value3 = this.f36324a.k().getValue();
            if (value3 != null) {
                value3.setList(data.getModelList());
            }
            MutableLiveData<UserAssetsBean> mutableLiveDataI = this.f36324a.i();
            int crystalValue = data.getCrystalValue();
            String inspirationValue = data.getInspirationValue();
            mutableLiveDataI.setValue(new UserAssetsBean(crystalValue, (inspirationValue == null || (intOrNull = StringsKt.toIntOrNull(inspirationValue)) == null) ? 0 : intOrNull.intValue(), data.getStarDrill(), data.getSkinVoucher()));
            if (this.K <= -1) {
                if (!(data.getPersonType() == 2)) {
                    LiveData liveDataH = this.f36324a.h();
                    ArrayList<ModelListBean> modelList6 = data.getModelList();
                    if (modelList6 != null) {
                        for (Object obj2 : modelList6) {
                            if (((ModelListBean) obj2).getWearStatus() == 1) {
                                obj = obj2;
                                break;
                            }
                        }
                        obj = (ModelListBean) obj;
                    }
                    liveDataH.setValue(obj);
                    return;
                }
            }
            LiveData liveDataH2 = this.f36324a.h();
            ArrayList<ModelListBean> modelList7 = data.getModelList();
            if (modelList7 != null) {
                for (Object obj3 : modelList7) {
                    if (((ModelListBean) obj3).getType() == 3) {
                        obj = obj3;
                        break;
                    }
                }
                obj = (ModelListBean) obj;
            }
            liveDataH2.setValue(obj);
        }
    }

    @NotNull
    public final MutableLiveData<ModelListBean> h() {
        return this.initModel;
    }

    @NotNull
    public final MutableLiveData<UserAssetsBean> i() {
        return this.userAssetsBean;
    }

    @NotNull
    public final MutableLiveData<UserCultivateInfo> j() {
        return this.userCultivateInfo;
    }

    @NotNull
    public final MutableLiveData<UserWearTypeAdapter> k() {
        return this.userWearTypeAdapter;
    }

    public final void l(int mWearType) {
        n76.e(this, this.userMainModel.q()).p5(new a(mWearType, this));
    }
}
