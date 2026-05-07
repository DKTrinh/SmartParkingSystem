import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import "../css/login.css";
import Header from "../components/header";
import Footer from "../components/footer";
import img1 from "/public/images/logo-sps.png";
import img2 from "/public/images/logobk.png";

const api_url = process.env.API_URL;
const Login = () => {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (event) => {
        event.preventDefault();

        try {
            const response = await axios.post(`${api_url}/auth/login`, {
                username,
                password
            });

            const { token, name, role } = response.data;

            localStorage.setItem("user", JSON.stringify({
                name,
                role
            }));

            localStorage.setItem("userToken", token);


            if (role === "ADMIN") {
                navigate("/");
            } else if (role === "PARKING_STAFF") {
                navigate("/");
            } else {
                navigate("/");
            }

        } catch (err) {
            console.error(err);
            alert("Sai tài khoản hoặc mật khẩu");
        }
    };

    const clearInput = () => {
        setUsername("");
        setPassword("");
    };
    
    return (
        <div className="login-page">

            <div className="login-split">

                {/* LEFT - LOGIN */}
                <div className="login-left">
                    <div className="login-box">

                        <div className="avatar"></div>

                        <form onSubmit={handleLogin} className="form">
                            <input
                                placeholder="Username"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                            />

                            <input
                                type="password"
                                placeholder="Password"
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                            />

                            <div className="btn-group">
                                <button type="submit">LOG IN</button>
                                <span>or</span>
                                <button type="button" className="signup">SIGN UP</button>
                            </div>
                        </form>
                    </div>
                </div>

                {/* RIGHT - CONTENT */}
                <div className="login-right">
                    <h1>Smart Parking System</h1>
                    <p>
                        Hệ thống quản lý bãi đỗ xe thông minh giúp theo dõi, kiểm soát và tối ưu hóa
                        việc sử dụng chỗ đỗ xe theo thời gian thực. 
                        Hỗ trợ nhân viên và quản trị viên vận hành hiệu quả, giảm ùn tắc và nâng cao trải nghiệm người dùng.
                    </p>

                    <ul className="features">
                        <li>Quản lý xe ra/vào tự động</li>
                        <li>Thống kê & báo cáo theo thời gian thực</li>
                        <li>Phân quyền người dùng rõ ràng</li>
                        <li>Tích hợp thanh toán nhanh chóng</li>
                    </ul>

                    <button className="more-btn">KHÁM PHÁ THÊM</button>
                </div>

            </div>

        </div>
    );
};

export default Login;