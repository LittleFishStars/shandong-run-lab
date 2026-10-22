import React from 'react';
import { Card, Input, Button, Select } from 'antd';

export default function LoginPage({ accountMode, accounts, account, phone, password, busy, actions }) {
  return (
    <div className="login-page">
    <div className="login-layout">
      <div className="login-brand">
        <img className="app-icon" src="assets/app-icon.png" alt="闪动校园" />
        <div className="login-brand-name">闪动校园</div>
      </div>
      <Card className="login-card" bordered={false}>
        {!accountMode ? (
          <>
            <div className="field">
              <span>手机号</span>
              <Input
                value={phone}
                placeholder="手机号 / 学号"
                onChange={(e) => actions.setPhone(e.target.value)}
              />
            </div>
            <div className="field">
              <span>密码</span>
              <Input.Password
                value={password}
                placeholder="账号密码"
                onChange={(e) => actions.setPassword(e.target.value)}
              />
            </div>
            <div className="login-actions">
              <Button type="primary" loading={busy} onClick={actions.login}>登录</Button>
              <Button type="link" onClick={actions.toAccount}>选择已有账号</Button>
            </div>
          </>
        ) : (
          <>
            <div className="field">
              <span>选择账号</span>
              <Select
                style={{ width: '100%' }}
                value={account || undefined}
                placeholder="请选择"
                onChange={actions.setAccount}
                options={accounts.map((a) => ({
                  value: a.userId,
                  label: `${a._account_name || a.loginName || a.userId}${a.current ? '（当前）' : ''}`,
                }))}
              />
            </div>
            <div className="login-actions">
              <Button type="primary" loading={busy} disabled={!account} onClick={actions.loginAccount}>登录</Button>
              <Button type="link" onClick={actions.toNew}>登录新账号</Button>
            </div>
            {account ? (
              <Button type="link" className="login-remove" onClick={actions.removeAccount}>移除该账号</Button>
            ) : null}
          </>
        )}
      </Card>
    </div>
    </div>
  );
}
