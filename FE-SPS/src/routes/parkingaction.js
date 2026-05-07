import React, { useMemo, useState } from 'react';
import Header from '../components/header';
import Footer from '../components/footer';
import '../css/parkingaction.css';

const parkingAreas = [
  {
    id: 'motor-1',
    name: 'Bãi giữ xe 1',
    shortName: 'BX1',
    type: 'Xe máy',
    location: 'Phía trên khu H1, H2, H3',
    capacity: 280,
    available: 81,
    openTime: '06:00 - 22:00',
    price: '3.000đ/lượt',
    color: '#2f80ed',
    note: 'Bãi chính, phù hợp sinh viên đi học tại các khu H1, H2, H3.',
    directions: [
      'Đi vào từ cổng xe máy phía trên bên phải.',
      'Di chuyển dọc theo đường trên cùng.',
      'Bãi giữ xe 1 nằm phía trên cụm H1, H2, H3.'
    ]
  },
  {
    id: 'car',
    name: 'Bãi ô tô',
    shortName: 'ÔT',
    type: 'Ô tô',
    location: 'Bên trái H6',
    capacity: 42,
    available: 11,
    openTime: '06:00 - 21:30',
    price: '3.000đ/lượt',
    color: '#bb6bd9',
    note: 'Bãi ô tô gần H6.',
    directions: [
      'Đi theo đường ngang giữa bản đồ.',
      'Bãi ô tô nằm bên trái H6.'
    ]
  },
  {
    id: 'motor-2',
    name: 'Bãi giữ xe 2',
    shortName: 'BX2',
    type: 'Xe máy',
    location: 'Phía dưới bên phải, gần đường Tạ Quang Bửu',
    capacity: 190,
    available: 34,
    openTime: '06:00 - 22:00',
    price: '3.000đ/lượt',
    color: '#27ae60',
    note: 'Thuận tiện cho người đi từ phía Tạ Quang Bửu.',
    directions: [
      'Đi vào từ đường Tạ Quang Bửu phía dưới.',
      'Di chuyển lên khu bên phải bản đồ.',
      'Bãi giữ xe 2 nằm ở phía dưới bên phải.'
    ]
  }
];

const ParkingAction = () => {
  const [selectedId, setSelectedId] = useState('motor-1');

  const selectedArea = useMemo(
    () => parkingAreas.find((area) => area.id === selectedId) || parkingAreas[0],
    [selectedId]
  );

  const occupancyPercent = Math.round(
    ((selectedArea.capacity - selectedArea.available) / selectedArea.capacity) * 100
  );

  const getParkingClass = (id, baseClass) =>
    `parking ${baseClass} ${selectedId === id ? 'active' : ''}`;

  return (
    <div className="parkinglot-main-wrapper">
      <Header />

      <main className="parkinglot-page">
        <section className="parkinglot-content parkinglot-content-nohero">
          <div className="parkinglot-layout">
            <div className="parkinglot-map-card">
                <div className="parkinglot-legend">
                  {parkingAreas.map((area) => (
                    <button
                      key={area.id}
                      type="button"
                      className={`legend-chip ${selectedId === area.id ? 'active' : ''}`}
                      onClick={() => setSelectedId(area.id)}
                      style={{ '--chip-color': area.color }}
                    >
                      <span className="legend-dot" />
                      {area.name}
                    </button>
                  ))}
                </div>

              <div className="campus-map-shell">
                <div className="map-scale-frame">
                  <div className="map">
                    <div className="road r-top"></div>
                    <div className="road r-bottom"></div>
                    <div className="road r-h-mid"></div>
                    <div className="road r-v-main"></div>
                    <div className="road r-v-left"></div>
                    <div className="road r-v-right"></div>

                    <div className="forest">
                      <div className="tree-slot"></div>
                      <div className="tree-slot"></div>
                    </div>

                    <div className="map-text map-text-top">Thomas Edison</div>
                    <div className="map-text map-text-bottom">Tạ Quang Bửu</div>
                    <div className="map-text gate-motor">Cổng xe máy</div>

                    <div className="b h1">
                      <div className="core"></div>
                      <span className="label">H1</span>
                    </div>

                    <div className="b h2">
                      <div className="core"></div>
                      <span className="label">H2</span>
                    </div>

                    <div className="b h3">
                      <div className="core"></div>
                      <span className="label">H3</span>
                    </div>

                    <div className="b tdtt">
                      <span className="label">TDTT</span>
                    </div>

                    <div className="b h6">
                      <span className="label">H6</span>
                    </div>

                    <button
                      type="button"
                      className={getParkingClass('motor-1', 'parking-1')}
                      onClick={() => setSelectedId('motor-1')}
                      aria-label="Xem chi tiết bãi giữ xe 1"
                    >
                      <span className="parking-badge">BX1</span>
                      <span className="parking-text">Bãi giữ xe 1</span>
                    </button>

                    <button
                      type="button"
                      className={getParkingClass('motor-2', 'parking-2')}
                      onClick={() => setSelectedId('motor-2')}
                      aria-label="Xem chi tiết bãi giữ xe 2"
                    >
                      <span className="parking-badge">BX2</span>
                      <span className="parking-text">Bãi giữ xe 2</span>
                    </button>

                    <button
                      type="button"
                      className={getParkingClass('car', 'parking-car')}
                      onClick={() => setSelectedId('car')}
                      aria-label="Xem chi tiết bãi ô tô"
                    >
                      <span className="parking-badge">ÔT</span>
                      <span className="parking-text">Bãi ô tô</span>
                    </button>
                  </div>
                </div>
              </div>
            </div>

            <aside className="parkinglot-detail-card">
              <p className="parkinglot-kicker">Đang chọn</p>
              <h2>{selectedArea.name}</h2>

              <div className="detail-stat-grid">
                <div className="detail-stat-box">
                  <span>Loại xe</span>
                  <strong>{selectedArea.type}</strong>
                </div>
                <div className="detail-stat-box">
                  <span>Vị trí</span>
                  <strong>{selectedArea.location}</strong>
                </div>
                <div className="detail-stat-box">
                  <span>Sức chứa</span>
                  <strong>{selectedArea.capacity} chỗ</strong>
                </div>
                <div className="detail-stat-box">
                  <span>Chỗ trống</span>
                  <strong>{selectedArea.available} chỗ</strong>
                </div>
              </div>

              <div className="detail-section">
                <div className="progress-title-row">
                  <h3>Mức độ sử dụng</h3>
                  <span>{occupancyPercent}%</span>
                </div>
                <div className="occupancy-track">
                  <div
                    className="occupancy-fill"
                    style={{ width: `${occupancyPercent}%`, background: selectedArea.color }}
                  />
                </div>
              </div>

              <div className="detail-section">
                <h3>Thông tin</h3>
                <ul className="detail-list">
                  <li><strong>Giờ hoạt động:</strong> {selectedArea.openTime}</li>
                  <li><strong>Giá gửi:</strong> {selectedArea.price}</li>
                  <li><strong>Ghi chú:</strong> {selectedArea.note}</li>
                </ul>
              </div>

              <div className="detail-section">
                <h3>Điều hướng</h3>
                <ol className="direction-list">
                  {selectedArea.directions.map((step, index) => (
                    <li key={`${selectedArea.id}-${index}`}>{step}</li>
                  ))}
                </ol>
              </div>
            </aside>
          </div>
        </section>
      </main>

      <Footer />
    </div>
  );
};

export default ParkingAction;