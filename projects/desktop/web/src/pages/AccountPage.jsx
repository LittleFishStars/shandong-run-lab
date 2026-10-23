import React from 'react';
import { Button, List, Tag, Typography } from 'antd';
import { fmtDateTime, fmtDur, fmtPaceShort } from '../format';

const { Text } = Typography;

export default function AccountPage({ status, runs, actions }) {
  const user = (status && status.user) || {};
  return (
    <div className="account-page">
      <div className="account-head">
        <span className="account-title">账户</span>
        <Button onClick={actions.back}>返回</Button>
      </div>
      <div className="account-body">
        <aside className="account-side">
          <img className="account-avatar" src="assets/app-icon.png" alt="头像" />
          <div className="account-name">{user.userName || '未登录'}</div>
          <Button danger type="primary" className="account-logout" onClick={actions.logout}>退出登录</Button>
        </aside>
        <section className="account-main">
          <h2>跑步记录</h2>
          {runs.error ? (
            <Text type="secondary">{runs.error}</Text>
          ) : runs.items.length ? (
            <List
              className="account-runs"
              dataSource={runs.items}
              renderItem={(item) => (
                <List.Item>
                  <div className="account-run">
                    <div className="account-run-main">
                      <span className="rc">{item.run_code}</span>
                      <span className="meta">{item.start_ms ? fmtDateTime(item.start_ms) : ''}</span>
                    </div>
                    <div className="account-run-stats">
                      <span>{item.distance_m ? `${Number(item.distance_m).toFixed(0)} 米` : '--'}</span>
                      <span>{item.duration_s ? fmtDur(item.duration_s) : '--'}</span>
                      <Tag color={item.state_kind === 'ok' ? 'green' : item.state_kind === 'err' ? 'red' : 'gold'}>
                        {item.state || '--'}
                      </Tag>
                    </div>
                  </div>
                </List.Item>
              )}
            />
          ) : (
            <div className="account-empty">
              <Text type="secondary">
                {status && status.logged_in ? '服务器上暂无跑步记录' : '登录后才会显示跑步记录'}
              </Text>
            </div>
          )}
        </section>
      </div>
    </div>
  );
}
