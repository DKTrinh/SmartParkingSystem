/* Duc Huy - Chức năng: Ticket Validation */

import React, { useState, useEffect } from 'react';
import Header from "../components/header";
import Footer from "../components/footer";
import "../css/usermanagement.css"; 

const TicketValidation = () => {
    const [user, setUser] = useState(null);
    const [ticketId, setTicketId] = useState("");
    const [isValid, setIsValid] = useState(null); 
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");

    // Cấu hình theo tài liệu nhóm
    const BACKEND_PORT = 5000; 
    const API_URL = `http://localhost:${BACKEND_PORT}/api/tickets/validate`;

    useEffect(() => {
        // Lấy thông tin user sau khi login để phân quyền
        const storedUser = localStorage.getItem("user");
        if (storedUser) {
            setUser(JSON.parse(storedUser));
        }
    }, []);

    // Kiểm tra quyền: Chỉ Parking Staff và Admin mới được sử dụng
    const canAccess = user && (user.role === "ADMIN" || user.role === "PARKING_STAFF");

    const handleSearch = async (e) => {
        e.preventDefault();
        
        if (!ticketId.trim()) {
            setError("Vui lòng nhập mã vé.");
            setIsValid(null);
            return;
        }

        setLoading(true);
        setError("");
        setIsValid(null);

        try {
            // Thực hiện POST request theo đúng bảng API 
            const response = await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ ticketId: ticketId }) // Input: {ticketId: id} 
            });

            if (!response.ok) {
                throw new Error("Không thể kết nối với server Backend.");
            }

            const result = await response.json(); // Output: true/false 
            setIsValid(result); 
        } catch (err) {
            setError("Lỗi: Server Backend (Port 5000) chưa phản hồi.");
        } finally {
            setLoading(false);
        }
    };

    // Giao diện chặn người dùng không có quyền
    if (!canAccess) {
        return (
            <div className="um-page">
                <Header />
                <div className="um-container" style={{ textAlign: 'center', padding: '100px 0' }}>
                    <h2 style={{ color: '#d32f2f' }}>🚫 Truy cập bị từ chối</h2>
                    <p>Bạn cần đăng nhập với quyền <strong>Staff</strong> hoặc <strong>Admin</strong> để sử dụng tính năng này.</p>
                </div>
                <Footer />
            </div>
        );
    }

    return (
        <div className="um-page">
            <Header />
            <div className="um-container">
                <div className="um-header" style={{ textAlign: 'center', display: 'block' }}>
                    <h2 style={{ fontSize: '2.2rem', color: '#032b5f' }}>Ticket Validation</h2>
                    <p style={{ color: '#666' }}>Nhập mã vé để kiểm tra tính hợp lệ trên hệ thống</p>
                </div>

                <div className="card" style={{ padding: '30px', background: '#fff', borderRadius: '16px', boxShadow: '0 8px 20px rgba(0,0,0,0.1)', marginBottom: '30px' }}>
                    <form onSubmit={handleSearch} style={{ display: 'flex', gap: '15px' }}>
                        <input 
                            type="text" 
                            placeholder="Ví dụ: 2021001..."
                            value={ticketId}
                            onChange={(e) => setTicketId(e.target.value)}
                            style={{ flex: 1, padding: '15px', borderRadius: '10px', border: '1px solid #ddd', fontSize: '16px' }}
                        />
                        <button className="btn-add" type="submit" disabled={loading} style={{ padding: '0 40px' }}>
                            {loading ? "Đang check..." : "Kiểm tra"}
                        </button>
                    </form>
                    {error && <p style={{ color: '#d32f2f', marginTop: '15px', fontWeight: 'bold' }}>{error}</p>}
                </div>

                {/* Hiển thị kết quả đúng/sai theo API Output  */}
                {isValid !== null && (
                    <div style={{ 
                        textAlign: 'center', padding: '50px', borderRadius: '16px', 
                        background: isValid ? '#e8f5e9' : '#ffebee',
                        border: `2px solid ${isValid ? '#4caf50' : '#f44336'}`,
                        transition: 'all 0.3s ease'
                    }}>
                        <div style={{ fontSize: '70px', marginBottom: '10px' }}>{isValid ? "✅" : "❌"}</div>
                        <h2 style={{ color: isValid ? '#2e7d32' : '#c62828', margin: 0 }}>
                            {isValid ? "VÉ HỢP LỆ" : "VÉ KHÔNG TỒN TẠI"}
                        </h2>
                        <p style={{ marginTop: '10px', color: '#555' }}>
                            {isValid ? `Hệ thống xác nhận vé ${ticketId} có trong cơ sở dữ liệu.` : `Không tìm thấy thông tin cho mã vé ${ticketId}.`}
                        </p>
                    </div>
                )}
            </div>
            <Footer />
        </div>
    );
};

export default TicketValidation;