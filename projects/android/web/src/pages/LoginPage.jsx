import React from 'react';
import { Input, Button } from '../ui';

/* 移动端登录页：居中 logo + 「闪动校园」，下方卡片「手机号 / 密码 / 登录」 */
export default function LoginPage({ phone, password, busy, actions }) {
  return (
    <div className="login-page">
      <div className="login-layout">
        <div className="login-brand">
          <img className="app-icon" src="assets/app-icon.png" alt="闪动校园" />
          <div className="login-brand-name">闪动校园</div>
          <div className="login-brand-sub">破解版</div>
        </div>
        <div className="login-card">
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
            <Button type="primary" className="mb-btn-block" loading={busy} onClick={actions.login}>登录</Button>
            <Button loading={busy} onClick={actions.openSavedAccounts}>已保存的账号</Button>
          </div>
        </div>
      </div>
    </div>
  );
}