import React from 'react';
import {
  Button, Card, Checkbox, Descriptions, Input, InputNumber, List, Select, Space, Tag, Typography,
} from 'antd';
import { fmtDateTime, fmtDur, fmtPaceShort } from '../format';

const { Text } = Typography;

function KV({ rows }) {
  return (
    <Descriptions column={1} size="small" colon={false}>
      {rows.map(([k, v]) => <Descriptions.Item key={k} label={k}>{v}</Descriptions.Item>)}
    </Descriptions>
  );
}

export default function MorePage({
  status, params, distanceOptions, ruleRows, userRows, runRows, runCode,
  log, runs, detail, busy, actions,
}) {
  const logged = !!(status && status.logged_in);
  return (
    <div className="more-page">
      <div className="more-head">
        <h1>更多</h1>
        <Button onClick={actions.back}>返回</Button>
      </div>
      <div className="more-grid">
        <Card title="跑步参数" size="small">
          <div className="field">
            <span>运行模式</span>
            <Select
              value={params.mode}
              onChange={actions.setMode}
              options={[
                { value: 'real', label: '真实服务端' },
                { value: 'mock', label: '本地 Mock' },
              ]}
            />
          </div>
          <div className="field">
            <span>围栏</span>
            <Select
              value={params.fence}
              onChange={actions.setFence}
              options={(status?.fences || []).map((f, i) => ({
                value: i, label: f.fenceName || f.fenceCode || `围栏 ${i + 1}`,
              }))}
            />
          </div>
          <div className="row2">
            <div className="field">
              <span>平均步频（步/分）</span>
              <InputNumber min={120} max={240} value={params.cadAvg}
                onChange={(v) => actions.setParam('cadAvg', v || 177)} style={{ width: '100%' }} />
            </div>
            <div className="field">
              <span>波动（± 步/分）</span>
              <InputNumber min={0} max={30} value={params.cadVar}
                onChange={(v) => actions.setParam('cadVar', v || 0)} style={{ width: '100%' }} />
            </div>
          </div>
          <div className="row2">
            <div className="field">
              <span>步幅（米）</span>
              <InputNumber min={0.1} step={0.01} value={params.stride}
                onChange={(v) => actions.setParam('stride', v || 0.85)} style={{ width: '100%' }} />
            </div>
            <div className="field">
              <span>配速（分'秒"/公里）</span>
              <Input value={params.pace} onChange={(e) => actions.setParam('pace', e.target.value)} />
            </div>
          </div>
          <Checkbox checked={params.autoSettle} onChange={(e) => actions.setParam('autoSettle', e.target.checked)}>
            到达目标自动结算
          </Checkbox>
          <div className="row">
            <Button type="primary" size="small" onClick={actions.saveParams}>保存参数</Button>
            <Button size="small" onClick={actions.resetDevice}>换 deviceId</Button>
          </div>
        </Card>

        <Card title="学校规则" size="small"
          extra={<Button type="link" size="small" onClick={actions.reloadRule}>刷新</Button>}>
          {ruleRows.length ? <KV rows={ruleRows} /> : <Text type="secondary">尚未加载</Text>}
        </Card>

        <Card title="账号" size="small">
          {logged ? <KV rows={userRows} /> : <Text type="secondary">未登录</Text>}
          <div className="row">
            <Button size="small" onClick={actions.openDataDir}>数据目录</Button>
            <Button size="small" onClick={actions.logout}>退出登录</Button>
          </div>
        </Card>

        <Card title="本次跑步" size="small"
          extra={<Text type="secondary">{runCode || '--'}</Text>}>
          {runRows.length ? <KV rows={runRows} /> : <Text type="secondary">尚未开始</Text>}
        </Card>

        <Card title="地图与起点" size="small">
          <div className="row">
            <Button size="small" onClick={actions.toPick}>选择起始点</Button>
            <Button size="small" onClick={actions.clearStart}>清除起点</Button>
            <Button size="small" onClick={actions.fitHome}>适应</Button>
          </div>
          <div className="row">
            <Select size="small" value={params.tiles} onChange={actions.setTiles}
              options={[
                { value: 'amap', label: '高德路网' },
                { value: 'amap-sat', label: '高德卫星' },
                { value: 'osm', label: 'OpenStreetMap' },
                { value: 'none', label: '无底图' },
              ]} />
            <Checkbox checked={params.showState} onChange={(e) => actions.setParam('showState', e.target.checked)}>
              按上传状态着色
            </Checkbox>
          </div>
        </Card>

        <Card title="高级 / 调试" size="small">
          <div className="row">
            <Button size="small" onClick={actions.dryRun}>干跑调试</Button>
            <Button size="small" onClick={actions.stopWalk}>停止</Button>
            <Button size="small" onClick={actions.pauseWalk}>暂停</Button>
            <Button size="small" onClick={actions.uploadWalk}>上传结算</Button>
            <Button size="small" onClick={actions.saveDraft}>存草稿</Button>
          </div>
          <div className="row">
            <Button size="small" onClick={actions.planRoute}>只规划路径</Button>
            <Button size="small" onClick={actions.clearWaypoints}>清路点</Button>
          </div>
          <div className="row">
            <Button size="small" onClick={actions.runAuto}>一键跑完整链路</Button>
            <Button size="small" onClick={actions.resumeRun}>断点续传</Button>
            <Button size="small" onClick={actions.toggleAuto}>
              {params.auto ? '自动跑中（点此转手动）' : '手动（摇杆）'}
            </Button>
          </div>
        </Card>

        <Card
          title="服务器记录"
          size="small"
          className="records-card"
          extra={(
            <Space size={4}>
              <Text type="secondary">第 {runs.page} 页</Text>
              <Button type="link" size="small" disabled={runs.page <= 1}
                onClick={() => actions.loadRuns(runs.page - 1)}>上一页</Button>
              <Button type="link" size="small" disabled={!runs.hasNext}
                onClick={() => actions.loadRuns(runs.page + 1)}>下一页</Button>
              <Button type="link" size="small" onClick={() => actions.loadRuns(1)}>刷新</Button>
            </Space>
          )}
        >
          {runs.error ? (
            <Text type="secondary">{runs.error}</Text>
          ) : runs.items.length ? (
            <List
              dataSource={runs.items}
              renderItem={(item) => (
                <List.Item
                  className={`run-item${detail && detail.record && detail.record.run_code === item.run_code ? ' active' : ''}`}
                  onClick={() => actions.pickRun(item)}
                >
                  <div style={{ width: '100%' }}>
                    <div className="rc">{item.run_code}</div>
                    <div className="meta">
                      <span>{item.distance_m ? `${Number(item.distance_m).toFixed(0)} 米` : '--'}</span>
                      <span>{item.duration_s ? `${Math.round(item.duration_s / 60)} 分` : '--'}</span>
                      <span>{item.start_ms ? fmtDateTime(item.start_ms) : ''}</span>
                      <Tag color={item.state_kind === 'ok' ? 'green' : item.state_kind === 'err' ? 'red' : 'gold'}>
                        {item.state || '--'}
                      </Tag>
                    </div>
                  </div>
                </List.Item>
              )}
            />
          ) : (
            <Text type="secondary">
              {logged ? '服务器上暂无记录（完成一次跑步后会出现在这里）' : '未登录：登录后才会显示账号下的记录'}
            </Text>
          )}
        </Card>

        <Card
          title="事件流"
          size="small"
          className="log-card"
          extra={<Button type="link" size="small" onClick={actions.clearLog}>清屏</Button>}
        >
          <div className="log">
            {log.map((e) => (
              <div className={`line k-${e.kind || 'log'} lv-${e.level || 'info'}`} key={e.key}>
                <span className="t">{e.time}</span>
                <span className="m">{e.message}</span>
              </div>
            ))}
          </div>
        </Card>
      </div>
    </div>
  );
}
