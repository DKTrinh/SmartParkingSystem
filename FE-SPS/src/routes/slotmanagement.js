/* Duc Huy */

import React, { useState, useEffect } from 'react';
import Header from "../components/header";
import Footer from "../components/footer";
import "../css/usermanagement.css"; 

const SlotManagement = () => {
    const [user, setUser] = useState(null);
    const [slots, setSlots] = useState([]); 
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [message, setMessage] = useState("");

    // Thông số từ file tài liệu nhóm
    const BACKEND_URL = "http://localhost:5000/api/slots";

    useEffect(() => {
        // Lấy thông tin user từ localStorage để phân quyền
        const storedUser = localStorage.getItem("user");
        if (storedUser) {
            setUser(JSON.parse(storedUser));
        }
        fetchSlots();
    }, []);

    // 1. Lấy danh sách ô đỗ xe (GET /api/slots)
    const fetchSlots = async () => {
        try {
            setLoading(true);
            const response = await fetch(BACKEND_URL);
            if (!response.ok) throw new Error("Không thể tải dữ liệu từ Backend Port 5000.");
            const data = await response.json();
            setSlots(data); // Dữ liệu mẫu từ doc: [{id: 1, name: "A1", status: "OCCUPIED", ...}]
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    };

    // 2. Cập nhật trạng thái ô đỗ (Giả định dùng PUT cho CRUD)
    const handleUpdateStatus = async (id, currentStatus) => {
        const nextStatus = currentStatus === 'AVAILABLE' ? 'OCCUPIED' : 'AVAILABLE';
        
        try {
            const response = await fetch(`${BACKEND_URL}/${id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ status: nextStatus })
            });

            if (!response.ok) throw new Error("Cập nhật thất bại.");

            // Cập nhật giao diện sau khi Backend phản hồi thành công
            setSlots(prev => prev.map(s => s.id === id ? { ...s, status: nextStatus } : s));
            setMessage(`Đã cập nhật ô đỗ thành ${nextStatus}`);
            setTimeout(() => setMessage(""), 3000);
        } catch (err) {
            alert("Lỗi: " + err.message);
        }
    };

    // 3. Xóa ô đỗ (Chức năng DELETE trong CRUD)
    const handleDeleteSlot = async (id) => {
        if (!window.confirm("Bạn có chắc chắn muốn xóa ô đỗ này khỏi hệ thống?")) return;

        try {
            const response = await fetch(`${BACKEND_URL}/${id}`, {
                method: 'DELETE'
            });

            if (!response.ok) throw new Error("Xóa ô đỗ thất bại.");

            setSlots(prev => prev.filter(s => s.id !== id));
            setMessage("Đã xóa ô đỗ thành công.");
            setTimeout(() => setMessage(""), 3000);
        } catch (err) {
            alert(err.message);
        }
    };

    // Phân quyền theo tài liệu (Parking Staff và Admin mới được sửa)
    const canEdit = user && (user.role === "ADMIN" || user.role === "PARKING_STAFF");

    return (
        <div className="um-page">
            <Header />
            <div className="um-container">
                <div className="um-header">
                    <h2>{canEdit ? "Quản lý ô đỗ xe (CRUD)" : "Trạng thái bãi xe thời gian thực"}</h2>
                    <p style={{ color: '#666' }}>Hệ thống quản lý Port 5000 | Phân quyền: {user?.role || "Khách"}</p>
                </div>

                {error && <div style={{ color: 'red', marginBottom: '15px' }}>⚠️ {error}</div>}
                {message && <div className="parkinglot-message" style={{ marginBottom: '15px' }}>{message}</div>}

                {loading ? (
                    <div style={{ textAlign: 'center', padding: '50px' }}>Đang kết nối API...</div>
                ) : (
                    <div style={{ 
                        display: 'grid', 
                        gridTemplateColumns: 'repeat(auto-fill, minmax(150px, 1fr))', 
                        gap: '20px' 
                    }}>
                        {slots.map(slot => (
                            <div key={slot.id} className="card" style={{ 
                                textAlign: 'center', 
                                padding: '20px',
                                borderTop: `5px solid ${slot.status === 'AVAILABLE' ? '#4caf50' : '#f44336'}`,
                                position: 'relative'
                            }}>
                                <h3 style={{ margin: '0 0 10px 0', fontSize: '1.5rem' }}>{slot.name}</h3>
                                <span className={`role-badge ${slot.status === 'AVAILABLE' ? 'staff' : 'visitor'}`}>
                                    {slot.status === 'AVAILABLE' ? 'TRỐNG' : 'ĐÃ CHIẾM'}
                                </span>
                                
                                {canEdit && (
                                    <div style={{ marginTop: '15px', display: 'flex', gap: '5px', flexDirection: 'column' }}>
                                        <button 
                                            onClick={() => handleUpdateStatus(slot.id, slot.status)}
                                            style={{ padding: '5px', cursor: 'pointer', fontSize: '12px' }}
                                        >
                                            Đổi trạng thái
                                        </button>
                                        <button 
                                            onClick={() => handleDeleteSlot(slot.id)}
                                            style={{ padding: '5px', cursor: 'pointer', fontSize: '12px', color: 'red' }}
                                        >
                                            Xóa ô
                                        </button>
                                    </div>
                                )}
                            </div>
                        ))}
                    </div>
                )}
            </div>
            <Footer />
        </div>
    );
};

export default SlotManagement;