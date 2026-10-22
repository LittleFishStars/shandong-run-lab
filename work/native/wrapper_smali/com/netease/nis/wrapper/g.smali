.class public final Lcom/netease/nis/wrapper/g;
.super Landroid/app/AppComponentFactory;


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x1c
.end annotation


# instance fields
.field private a:Landroid/app/AppComponentFactory;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;

.field private e:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Landroid/app/AppComponentFactory;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/netease/nis/wrapper/g;->a:Landroid/app/AppComponentFactory;

    const-string v0, ""

    iput-object v0, p0, Lcom/netease/nis/wrapper/g;->b:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/netease/nis/wrapper/g;->c:Ljava/lang/String;

    const-string v0, "LQoZSwkGBC0NEQsLGgBgFhwEDxcKIAIrFgIbCiEJ"

    invoke-static/range {v0 .. v0}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/netease/nis/wrapper/g;->d:Ljava/lang/String;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/netease/nis/wrapper/g;->e:Z

    return-void
.end method

.method private declared-synchronized a(Ljava/lang/ClassLoader;)Landroid/app/AppComponentFactory;
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/netease/nis/wrapper/g;->a:Landroid/app/AppComponentFactory;

    if-nez v0, :cond_21

    iget-object v0, p0, Lcom/netease/nis/wrapper/g;->c:Ljava/lang/String;

    if-eqz v0, :cond_21

    const-string v0, ""

    iget-object v1, p0, Lcom/netease/nis/wrapper/g;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_25

    move-result v0

    if-nez v0, :cond_21

    :try_start_13
    iget-object v0, p0, Lcom/netease/nis/wrapper/g;->c:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AppComponentFactory;

    iput-object v0, p0, Lcom/netease/nis/wrapper/g;->a:Landroid/app/AppComponentFactory;
    :try_end_21
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_21} :catch_28
    .catchall {:try_start_13 .. :try_end_21} :catchall_25

    :cond_21
    :goto_21
    :try_start_21
    iget-object v0, p0, Lcom/netease/nis/wrapper/g;->a:Landroid/app/AppComponentFactory;
    :try_end_23
    .catchall {:try_start_21 .. :try_end_23} :catchall_25

    monitor-exit p0

    return-object v0

    :catchall_25
    move-exception v0

    monitor-exit p0

    throw v0

    :catch_28
    move-exception v0

    goto :goto_21
.end method

.method private a(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)V
    .registers 6

    iget-boolean v0, p0, Lcom/netease/nis/wrapper/g;->e:Z

    if-nez v0, :cond_24

    invoke-static {p1, p2}, Lcom/netease/nis/wrapper/f;->a(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Z

    iget-object v0, p0, Lcom/netease/nis/wrapper/g;->d:Ljava/lang/String;

    invoke-static {p1, p2, v0}, Lcom/netease/nis/wrapper/MyJni;->cl(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;Ljava/lang/String;)Ljava/lang/ClassLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/netease/nis/wrapper/g;->b:Ljava/lang/String;

    iput-object v1, p2, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/netease/nis/wrapper/g;->e:Z

    sget-object v1, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "HhcbHRgwCiMVGwsEHREIBBcRDgEcbgwaDBVfRS0JFRYSPwovAREXQU5F"

    invoke-static/range {v2 .. v2}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    :cond_24
    return-void
.end method


# virtual methods
.method public final instantiateActivity(Ljava/lang/ClassLoader;Ljava/lang/String;Landroid/content/Intent;)Landroid/app/Activity;
    .registers 5

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/netease/nis/wrapper/g;->a(Ljava/lang/ClassLoader;)Landroid/app/AppComponentFactory;

    move-result-object v0

    if-eqz v0, :cond_d

    invoke-virtual {v0, p1, p2, p3}, Landroid/app/AppComponentFactory;->instantiateActivity(Ljava/lang/ClassLoader;Ljava/lang/String;Landroid/content/Intent;)Landroid/app/Activity;

    move-result-object v0

    :goto_c
    return-object v0

    :cond_d
    invoke-super {p0, p1, p2, p3}, Landroid/app/AppComponentFactory;->instantiateActivity(Ljava/lang/ClassLoader;Ljava/lang/String;Landroid/content/Intent;)Landroid/app/Activity;

    move-result-object v0

    goto :goto_c
.end method

.method public final instantiateApplication(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroid/app/Application;
    .registers 4

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-static {}, Lcom/netease/nis/wrapper/f;->a()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/netease/nis/wrapper/g;->a(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)V

    const-class v0, Lcom/netease/nis/wrapper/MyApplication;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_17

    iget-object p2, p0, Lcom/netease/nis/wrapper/g;->b:Ljava/lang/String;

    :cond_17
    invoke-direct {p0, p1}, Lcom/netease/nis/wrapper/g;->a(Ljava/lang/ClassLoader;)Landroid/app/AppComponentFactory;

    move-result-object v0

    if-eqz v0, :cond_22

    invoke-virtual {v0, p1, p2}, Landroid/app/AppComponentFactory;->instantiateApplication(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroid/app/Application;

    move-result-object v0

    :goto_21
    return-object v0

    :cond_22
    invoke-super {p0, p1, p2}, Landroid/app/AppComponentFactory;->instantiateApplication(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroid/app/Application;

    move-result-object v0

    goto :goto_21
.end method

.method public final instantiateClassLoader(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Ljava/lang/ClassLoader;
    .registers 5
    .annotation build Landroid/annotation/TargetApi;
        value = 0x1d
    .end annotation

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "JwsHEQAdEScEAAAiHwQ9FjgKABcAPF8="

    invoke-static/range {v1 .. v1}, La/auu/a;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-direct {p0, p1, p2}, Lcom/netease/nis/wrapper/g;->a(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)V

    invoke-direct {p0, p1}, Lcom/netease/nis/wrapper/g;->a(Ljava/lang/ClassLoader;)Landroid/app/AppComponentFactory;

    move-result-object v0

    if-eqz v0, :cond_22

    invoke-virtual {v0, p1, p2}, Landroid/app/AppComponentFactory;->instantiateClassLoader(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Ljava/lang/ClassLoader;

    move-result-object v0

    :goto_21
    return-object v0

    :cond_22
    invoke-super {p0, p1, p2}, Landroid/app/AppComponentFactory;->instantiateClassLoader(Ljava/lang/ClassLoader;Landroid/content/pm/ApplicationInfo;)Ljava/lang/ClassLoader;

    move-result-object v0

    goto :goto_21
.end method

.method public final instantiateProvider(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroid/content/ContentProvider;
    .registers 4

    sget-object v0, Lcom/netease/nis/wrapper/MyApplication;->TAG:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/netease/nis/wrapper/g;->a(Ljava/lang/ClassLoader;)Landroid/app/AppComponentFactory;

    move-result-object v0

    if-eqz v0, :cond_d

    invoke-virtual {v0, p1, p2}, Landroid/app/AppComponentFactory;->instantiateProvider(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroid/content/ContentProvider;

    move-result-object v0

    :goto_c
    return-object v0

    :cond_d
    invoke-super {p0, p1, p2}, Landroid/app/AppComponentFactory;->instantiateProvider(Ljava/lang/ClassLoader;Ljava/lang/String;)Landroid/content/ContentProvider;

    move-result-object v0

    goto :goto_c
.end method
