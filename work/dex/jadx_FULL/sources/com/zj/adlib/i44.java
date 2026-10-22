package com.zj.adlib;

import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.huachenjie.base.module_bridge.interfaces.IMMethodLoader;
import com.huachenjie.common.callback.ValueCallback;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.im.bean.IMTokenBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/zj/adlib/i44;", "Lcom/huachenjie/base/module_bridge/interfaces/IMMethodLoader;", "Lcom/huachenjie/common/callback/ValueCallback;", "Lorg/json/JSONArray;", RenderCallContext.TYPE_CALLBACK, "", "a", "", "b", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class i44 implements IMMethodLoader {

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/i44$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", c.f25231a, "", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback<Boolean> f42273a;

        public a(ValueCallback<Boolean> valueCallback) {
            this.f42273a = valueCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            this.f42273a.onCallback(Boolean.valueOf(code == 200));
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/zj/adlib/i44$b", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "", "code", "result", "", c.f25231a, "", "onResult", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nIMMethodLoaderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IMMethodLoaderImpl.kt\ncom/huachenjie/shandong_school/module_bridge/IMMethodLoaderImpl$queryFriendList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1855#2,2:46\n*S KotlinDebug\n*F\n+ 1 IMMethodLoaderImpl.kt\ncom/huachenjie/shandong_school/module_bridge/IMMethodLoaderImpl$queryFriendList$1\n*L\n21#1:46,2\n*E\n"})
    public static final class b extends DefaultCallback<List<? extends FriendUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback<JSONArray> f42274a;

        public b(ValueCallback<JSONArray> valueCallback) {
            this.f42274a = valueCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) throws JSONException {
            onResult2(i, (List<FriendUserInfo>) list, th);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<FriendUserInfo> result, @Nullable Throwable exception) throws JSONException {
            JSONArray jSONArray = new JSONArray();
            if (code == 200 && result != null) {
                for (FriendUserInfo friendUserInfo : result) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("accid", friendUserInfo.getAccId());
                    jSONObject.put("avatar", friendUserInfo.getAvatar());
                    jSONObject.put(UserConstants.USER_PARAMS.b, friendUserInfo.getName());
                    jSONObject.put("alias", friendUserInfo.getAlias());
                    jSONObject.put("appUserCode", friendUserInfo.getAppUserCode());
                    jSONArray.put(jSONObject);
                }
            }
            i4a.a(jSONArray.toString());
            this.f42274a.onCallback(jSONArray);
        }
    }

    @Override // com.huachenjie.base.module_bridge.interfaces.IMMethodLoader
    public void a(@NotNull ValueCallback<JSONArray> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        dj1.B(new b(callback));
    }

    @Override // com.huachenjie.base.module_bridge.interfaces.IMMethodLoader
    public void b(@NotNull ValueCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        p44.x(new a(callback));
    }
}
