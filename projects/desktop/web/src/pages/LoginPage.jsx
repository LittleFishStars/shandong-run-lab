import React from 'react';
import { Card, Input, Button } from 'antd';

export default function LoginPage({ phone, password, busy, actions }) {
  return (
    <div className="login-page">
      <div className="login-layout">
        <div className="login-brand">
          <img className="app-icon" src="assets/app-icon.png" alt="闪动校园" />
          <div className="login-brand-name">闪动校园</div>
          <div className="login-brand-sub">破解版</div>
        </div>
        <div className="ant-card login-card">
          <div className="ant-card-body">
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
              <Button loading={busy} onClick={actions.openSavedAccounts}>已保存的账号</Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
