package com.ali.auth.third.login.task;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.auth.third.core.broadcast.LoginAction;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.history.AccountHistoryManager;
import com.ali.auth.third.core.model.ResultCode;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.task.TaskWithDialog;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.login.LoginComponent;
import com.ali.auth.third.login.callback.LogoutCallback;
import com.ali.auth.third.login.util.LoginStatus;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LogoutTask extends TaskWithDialog<Void, Void, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LogoutCallback f23488a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoutTask.this.f23488a.onSuccess();
        }
    }

    public LogoutTask(Activity activity, LogoutCallback logoutCallback) {
        super(activity);
        this.f23488a = logoutCallback;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:602)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:628)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
     */
    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void asyncExecute(Void... voidArr) {
        ResultCode resultCodeLogout;
        MemberExecutorService memberExecutorService;
        a aVar;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("into logout ");
                CredentialManager credentialManager = CredentialManager.INSTANCE;
                sb.append(credentialManager.getInternalSession().toString());
                SDKLogger.e("logout task", sb.toString());
                String str = credentialManager.getInternalSession().user.userId;
                if (!TextUtils.isEmpty(str)) {
                    AccountHistoryManager.getInstance().clearAutologinTokenFromFile(str);
                    LoginComponent loginComponent = LoginComponent.INSTANCE;
                    LoginComponent.logout();
                }
                LoginStatus.resetLoginFlag();
                resultCodeLogout = com.ali.auth.third.login.a.a.f23464a.logout();
                if (ResultCode.SUCCESS.equals(resultCodeLogout)) {
                    com.ali.auth.third.login.a.a.c.logout();
                    CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGOUT);
                    memberExecutorService = KernelContext.executorService;
                    aVar = new a();
                    memberExecutorService.postUITask(aVar);
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                LoginStatus.resetLoginFlag();
                resultCodeLogout = com.ali.auth.third.login.a.a.f23464a.logout();
                if (ResultCode.SUCCESS.equals(resultCodeLogout)) {
                    com.ali.auth.third.login.a.a.c.logout();
                    CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGOUT);
                    memberExecutorService = KernelContext.executorService;
                    aVar = new a();
                }
                CommonUtils.onFailure(this.f23488a, resultCodeLogout);
                return null;
            }
            CommonUtils.onFailure(this.f23488a, resultCodeLogout);
            return null;
        } catch (Throwable th) {
            LoginStatus.resetLoginFlag();
            ResultCode resultCodeLogout2 = com.ali.auth.third.login.a.a.f23464a.logout();
            if (ResultCode.SUCCESS.equals(resultCodeLogout2)) {
                com.ali.auth.third.login.a.a.c.logout();
                CommonUtils.sendBroadcast(LoginAction.NOTIFY_LOGOUT);
                KernelContext.executorService.postUITask(new a());
            } else {
                CommonUtils.onFailure(this.f23488a, resultCodeLogout2);
            }
            throw th;
        }
    }

    @Override // com.ali.auth.third.core.task.AbsAsyncTask
    public void doWhenException(Throwable th) {
        CommonUtils.onFailure(this.f23488a, ResultCode.create(10010, th.getMessage()));
    }
}
