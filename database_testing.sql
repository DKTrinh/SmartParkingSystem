-- ============================================================================
-- Smart Parking System - Comprehensive Test Data
-- Database: SmartParking (SQL Server)
-- ============================================================================
-- This script provides comprehensive test data covering:
-- - Multiple user roles (ADMIN, PARKING_STAFF, USER, VISITOR)
-- - Multiple parking lots with various slot capacities
-- - Realistic parking sessions (active, finished, various durations)
-- - Payment transactions with different statuses
-- - Flexible pricing configurations
-- - Parking tickets/subscriptions
-- - IoT device monitoring
-- - Edge cases and scenario coverage
-- ============================================================================

-- Drop and recreate database (uncomment if needed)
-- DROP DATABASE SmartParking
-- CREATE DATABASE SmartParking
-- USE SmartParking

-- ============================================================================
-- SECTION 1: USERS
-- ============================================================================
-- Scenario coverage: Admin, Staff, Regular Users, Visitors
-- INSERT users data: 12 users with different roles
INSERT INTO users (name, role, created_at, card_id, email) VALUES
-- Admins (2)
(N'Nguyễn Văn A (Admin)', 'ADMIN', DATEADD(DAY, -365, GETDATE()), 'CARD-ADMIN-001', 'admin1@smartparking.com'),
(N'Trần Thị B (Admin)', 'ADMIN', DATEADD(DAY, -300, GETDATE()), 'CARD-ADMIN-002', 'admin2@smartparking.com'),

-- Parking Staff (3)
(N'Hoàng Minh C (Staff)', 'PARKING_STAFF', DATEADD(DAY, -200, GETDATE()), 'CARD-STAFF-001', 'staff1@smartparking.com'),
(N'Phạm Công D (Staff)', 'PARKING_STAFF', DATEADD(DAY, -180, GETDATE()), 'CARD-STAFF-002', 'staff2@smartparking.com'),
(N'Lý Hòa E (Staff)', 'PARKING_STAFF', DATEADD(DAY, -150, GETDATE()), 'CARD-STAFF-003', 'staff3@smartparking.com'),

-- Regular Users (5)
(N'Lê Văn F (User)', 'USER', DATEADD(DAY, -120, GETDATE()), 'CARD-USER-001', 'user1@example.com'),
(N'Đỗ Thị G (User)', 'USER', DATEADD(DAY, -100, GETDATE()), 'CARD-USER-002', 'user2@example.com'),
(N'Võ Văn H (User)', 'USER', DATEADD(DAY, -90, GETDATE()), 'CARD-USER-003', 'user3@example.com'),
(N'Mạc Thị I (User)', 'USER', DATEADD(DAY, -60, GETDATE()), 'CARD-USER-004', 'user4@example.com'),
(N'Nông Văn J (User)', 'USER', DATEADD(DAY, -30, GETDATE()), 'CARD-USER-005', 'user5@example.com'),

-- Visitors (2)
(N'Khách K (Visitor)', 'VISITOR', DATEADD(DAY, -15, GETDATE()), 'CARD-VISITOR-001', 'visitor1@example.com'),
(N'Khách L (Visitor)', 'VISITOR', DATEADD(DAY, -5, GETDATE()), 'CARD-VISITOR-002', 'visitor2@example.com');

-- ============================================================================
-- SECTION 2: ACCOUNTS
-- ============================================================================
-- Login credentials for users
INSERT INTO account (username, password, user_id) VALUES
('admin1', 'admin@123', 1),
('admin2', 'admin@456', 2),
('staff1', 'staff@123', 3),
('staff2', 'staff@456', 4),
('staff3', 'staff@789', 5),
('user1', 'pass@123', 6),
('user2', 'pass@456', 7),
('user3', 'pass@789', 8),
('user4', 'pass@321', 9),
('user5', 'pass@654', 10),
('visitor1', 'visitor@123', 11),
('visitor2', 'visitor@456', 12);

-- ============================================================================
-- SECTION 3: PARKING LOTS
-- ============================================================================
-- Multiple parking facilities with different capacities
INSERT INTO parking_lot (name, location) VALUES
(N'Bãi Xe Tòa Nhà A - Downtown', N'Quận 1, TP.HCM'),
(N'Bãi Xe Tòa Nhà B - District 7', N'Quận 7, TP.HCM'),
(N'Bãi Xe Sân Bay Tân Sơn Nhất', N'Tân Bình, TP.HCM'),
(N'Bãi Xe Trung Tâm Thương Mại', N'Quận 3, TP.HCM'),
(N'Bãi Xe Bệnh Viện Đại Học', N'Quận 5, TP.HCM');

-- ============================================================================
-- SECTION 4: PARKING SLOTS
-- ============================================================================
-- Comprehensive parking slot coverage across multiple lots
-- Lot 1: 10 slots
INSERT INTO parking_slot (name, status, parkinglot_id) VALUES
('A-01', 'AVAILABLE', 1),
('A-02', 'OCCUPIED', 1),
('A-03', 'AVAILABLE', 1),
('A-04', 'OCCUPIED', 1),
('A-05', 'AVAILABLE', 1),
('A-06', 'ERROR', 1),
('A-07', 'AVAILABLE', 1),
('A-08', 'OCCUPIED', 1),
('A-09', 'AVAILABLE', 1),
('A-10', 'AVAILABLE', 1);

-- Lot 2: 8 slots
INSERT INTO parking_slot (name, status, parkinglot_id) VALUES
('B-01', 'AVAILABLE', 2),
('B-02', 'AVAILABLE', 2),
('B-03', 'OCCUPIED', 2),
('B-04', 'AVAILABLE', 2),
('B-05', 'AVAILABLE', 2),
('B-06', 'OCCUPIED', 2),
('B-07', 'AVAILABLE', 2),
('B-08', 'AVAILABLE', 2);

-- Lot 3: 15 slots (Airport)
INSERT INTO parking_slot (name, status, parkinglot_id) VALUES
('T-01', 'AVAILABLE', 3),
('T-02', 'AVAILABLE', 3),
('T-03', 'OCCUPIED', 3),
('T-04', 'AVAILABLE', 3),
('T-05', 'AVAILABLE', 3),
('T-06', 'AVAILABLE', 3),
('T-07', 'OCCUPIED', 3),
('T-08', 'AVAILABLE', 3),
('T-09', 'AVAILABLE', 3),
('T-10', 'OCCUPIED', 3),
('T-11', 'AVAILABLE', 3),
('T-12', 'AVAILABLE', 3),
('T-13', 'OCCUPIED', 3),
('T-14', 'AVAILABLE', 3),
('T-15', 'AVAILABLE', 3);

-- Lot 4: 12 slots (Shopping Center)
INSERT INTO parking_slot (name, status, parkinglot_id) VALUES
('SC-01', 'AVAILABLE', 4),
('SC-02', 'OCCUPIED', 4),
('SC-03', 'AVAILABLE', 4),
('SC-04', 'AVAILABLE', 4),
('SC-05', 'OCCUPIED', 4),
('SC-06', 'AVAILABLE', 4),
('SC-07', 'AVAILABLE', 4),
('SC-08', 'OCCUPIED', 4),
('SC-09', 'AVAILABLE', 4),
('SC-10', 'AVAILABLE', 4),
('SC-11', 'ERROR', 4),
('SC-12', 'AVAILABLE', 4);

-- Lot 5: 6 slots (Hospital)
INSERT INTO parking_slot (name, status, parkinglot_id) VALUES
('H-01', 'AVAILABLE', 5),
('H-02', 'OCCUPIED', 5),
('H-03', 'AVAILABLE', 5),
('H-04', 'OCCUPIED', 5),
('H-05', 'AVAILABLE', 5),
('H-06', 'AVAILABLE', 5);

-- ============================================================================
-- SECTION 5: VEHICLES
-- ============================================================================
-- Multiple vehicles per user with varied types
INSERT INTO vehicle (platenumber, type, user_id) VALUES
-- User 1: 2 vehicles
('59A-12345', 'CAR', 6),
('29A-98765', 'CAR', 6),

-- User 2: 1 vehicle
('60A-67890', 'BIKE', 7),

-- User 3: 2 vehicles
('61A-11111', 'CAR', 8),
('30B-22222', 'BIKE', 8),

-- User 4: 1 vehicle
('62A-33333', 'CAR', 9),

-- User 5: 2 vehicles
('63A-44444', 'BIKE', 10),
('31C-55555', 'CAR', 10),

-- Visitor 1: 1 vehicle
('64A-66666', 'CAR', 11),

-- Visitor 2: 1 vehicle
('32D-77777', 'BIKE', 12);

-- ============================================================================
-- SECTION 6: CONFIGURATION PRICES (Hourly rates)
-- ============================================================================
-- Simple hourly pricing by vehicle type
INSERT INTO config_price (vehicle_type, hourly_rate) VALUES
('CAR', 10000),   -- 10,000 VND/hour for cars
('BIKE', 5000);   -- 5,000 VND/hour for bikes

-- ============================================================================
-- SECTION 7: PRICING FLEXIBILITY TABLE
-- ============================================================================
-- Multiple pricing tiers (HOURLY, DAILY, MONTHLY)
INSERT INTO pricing (type, price_per_hour, price_per_day, price_per_month, vehicle_type, created_at) VALUES
-- CAR Pricing
('HOURLY', 10000, NULL, NULL, 'CAR', GETDATE()),
('DAILY', NULL, 80000, NULL, 'CAR', GETDATE()),
('MONTHLY', NULL, NULL, 2000000, 'CAR', GETDATE()),

-- BIKE Pricing
('HOURLY', 5000, NULL, NULL, 'BIKE', GETDATE()),
('DAILY', NULL, 30000, NULL, 'BIKE', GETDATE()),
('MONTHLY', NULL, NULL, 600000, 'BIKE', GETDATE());

-- ============================================================================
-- SECTION 8: PARKING SESSIONS
-- ============================================================================
-- Diverse scenarios: Active sessions, finished sessions, various durations
INSERT INTO parking_session (entry_time, exit_time, status, user_id, slot_id, vehicle_id) VALUES
-- ACTIVE SESSIONS
-- User 1, Car, Slot A-02 (2 hours ago - ongoing)
(DATEADD(HOUR, -2, GETDATE()), NULL, 'ACTIVE', 6, 2, 1),

-- User 2, Bike, Slot B-03 (30 minutes ago - ongoing)
(DATEADD(MINUTE, -30, GETDATE()), NULL, 'ACTIVE', 7, 3, 3),

-- User 3, Bike, Slot T-03 (1 hour ago - ongoing)
(DATEADD(HOUR, -1, GETDATE()), NULL, 'ACTIVE', 8, 23, 4),

-- User 4, Car, Slot SC-02 (45 minutes ago - ongoing)
(DATEADD(MINUTE, -45, GETDATE()), NULL, 'ACTIVE', 9, 41, 6),

-- Visitor 1, Car, Slot H-02 (3 hours ago - ongoing)
(DATEADD(HOUR, -3, GETDATE()), NULL, 'ACTIVE', 11, 50, 7),

-- FINISHED SESSIONS - Various durations
-- User 1, 3-hour session (ended 1 hour ago)
(DATEADD(HOUR, -4, GETDATE()), DATEADD(HOUR, -1, GETDATE()), 'FINISHED', 6, 1, 1),

-- User 2, 5-hour session (ended yesterday)
(DATEADD(HOUR, -29, GETDATE()), DATEADD(HOUR, -24, GETDATE()), 'FINISHED', 7, 7, 3),

-- User 3, 2-hour session (ended 2 hours ago)
(DATEADD(HOUR, -4, GETDATE()), DATEADD(HOUR, -2, GETDATE()), 'FINISHED', 8, 15, 5),

-- User 5, 1-hour session (ended 3 hours ago)
(DATEADD(HOUR, -4, GETDATE()), DATEADD(HOUR, -3, GETDATE()), 'FINISHED', 10, 30, 9),

-- Visitor 2, 6-hour session (ended yesterday)
(DATEADD(HOUR, -30, GETDATE()), DATEADD(HOUR, -24, GETDATE()), 'FINISHED', 12, 35, 8),

-- Staff test session (2 days ago)
(DATEADD(DAY, -2, DATEADD(HOUR, -3, GETDATE())), DATEADD(DAY, -2, GETDATE()), 'FINISHED', 3, 10, 1);

-- ============================================================================
-- SECTION 9: PAYMENTS
-- ============================================================================
-- Various payment statuses, methods, and types
INSERT INTO payment (amount, status, payment_type, payment_method, created_at, user_id) VALUES
-- PENDING Payments
(20000, 'PENDING', 'DIRECT', 'CASH', GETDATE(), 6),
(15000, 'PENDING', 'DIRECT', 'CASH', DATEADD(HOUR, -1, GETDATE()), 7),
(25000, 'PENDING', 'DIRECT', 'BKPAY', DATEADD(HOUR, -2, GETDATE()), 8),

-- PAID Payments
(40000, 'PAID', 'DIRECT', 'CASH', DATEADD(DAY, -1, GETDATE()), 2),
(80000, 'PAID', 'DIRECT', 'BKPAY', DATEADD(DAY, -2, GETDATE()), 9),
(100000, 'PAID', 'PERIODIC', 'BKPAY', DATEADD(DAY, -3, GETDATE()), 10),
(2000000, 'PAID', 'PERIODIC', 'BKPAY', DATEADD(DAY, -30, GETDATE()), 6),
(600000, 'PAID', 'PERIODIC', 'CASH', DATEADD(DAY, -30, GETDATE()), 7),

-- FAILED Payments
(50000, 'FAILED', 'DIRECT', 'BKPAY', DATEADD(HOUR, -4, GETDATE()), 9),
(30000, 'FAILED', 'DIRECT', 'CASH', DATEADD(HOUR, -5, GETDATE()), 11);

-- ============================================================================
-- SECTION 10: PAYMENT-SESSION MAPPING
-- ============================================================================
-- Link payments to parking sessions
INSERT INTO payment_session (payment_id, session_id) VALUES
(1, 1),  -- Pending payment for User 1's active session
(2, 2),  -- Pending payment for User 2's active session
(3, 3),  -- Pending payment for User 3's active session
(4, 7),  -- Paid payment for User 1's finished session
(5, 8),  -- Paid payment for User 2's finished session
(6, 9),  -- Paid payment for User 3's finished session
(7, 10), -- Monthly payment User 5
(8, 11), -- Monthly payment for Visitor 2
(9, 12), -- Failed payment User 4
(10, 6); -- Failed payment for Visitor 1

-- ============================================================================
-- SECTION 11: PARKING TICKETS (Subscriptions/Passes)
-- ============================================================================
-- Subscription tickets with various validity periods
INSERT INTO ticket (start_date, end_date, user_id) VALUES
-- Active monthly tickets
(GETDATE(), DATEADD(DAY, 30, GETDATE()), 6),           -- User 1: 30-day monthly pass
(DATEADD(DAY, -5, GETDATE()), DATEADD(DAY, 25, GETDATE()), 7),  -- User 2: 30-day pass (started 5 days ago)

-- Active short-term tickets
(GETDATE(), DATEADD(DAY, 7, GETDATE()), 8),            -- User 3: 7-day pass
(GETDATE(), DATEADD(DAY, 14, GETDATE()), 9),           -- User 4: 14-day pass

-- Expired tickets (Edge case: expired)
(DATEADD(DAY, -30, GETDATE()), DATEADD(DAY, -10, GETDATE()), 10), -- User 5: expired (ended 10 days ago)
(DATEADD(DAY, -60, GETDATE()), DATEADD(DAY, -40, GETDATE()), 11), -- Visitor 1: expired long ago

-- Recently activated ticket
(DATEADD(DAY, -1, GETDATE()), DATEADD(DAY, 29, GETDATE()), 12);   -- Visitor 2: activated yesterday, 30-day pass

-- ============================================================================
-- SECTION 12: DEVICES (IoT Sensors/Cameras)
-- ============================================================================
-- Smart devices monitoring parking slots
INSERT INTO device (type, last_seen, slot_id) VALUES
-- Lot 1 Devices
('SENSOR', DATEADD(MINUTE, -5, GETDATE()), 1),
('SENSOR', DATEADD(MINUTE, -3, GETDATE()), 2),
('CAMERA', DATEADD(MINUTE, -2, GETDATE()), 3),
('GATEWAY', DATEADD(MINUTE, -1, GETDATE()), 4),
('DISPLAY', DATEADD(MINUTE, -10, GETDATE()), 5),

-- Lot 2 Devices
('SENSOR', DATEADD(MINUTE, -4, GETDATE()), 14),
('CAMERA', DATEADD(MINUTE, -6, GETDATE()), 15),
('GATEWAY', DATEADD(MINUTE, 0, GETDATE()), 16),

-- Lot 3 Devices
('SENSOR', DATEADD(MINUTE, -8, GETDATE()), 23),
('SENSOR', DATEADD(MINUTE, -7, GETDATE()), 25),
('CAMERA', DATEADD(MINUTE, -12, GETDATE()), 27),

-- Lot 4 Devices
('SENSOR', DATEADD(MINUTE, -9, GETDATE()), 41),
('DISPLAY', DATEADD(MINUTE, -15, GETDATE()), 43),

-- Lot 5 Devices
('SENSOR', DATEADD(MINUTE, -2, GETDATE()), 50);

-- ============================================================================
-- SECTION 13: RESET OPERATIONS & DATA VALIDATION
-- ============================================================================
-- Reset parking slots to available (for fresh test cycles)
-- UPDATE parking_slot SET status = 'AVAILABLE' WHERE status != 'ERROR';

-- Reset pending payments (for testing payment processing)
-- UPDATE payment SET status = 'PENDING' WHERE id IN (1, 2, 3);

-- ============================================================================
-- VERIFICATION QUERIES (Run these to validate data)
-- ============================================================================
/*
-- Check total users by role
SELECT role, COUNT(*) as total FROM users GROUP BY role;

-- Check parking slot availability
SELECT p.name as ParkingLot, 
       COUNT(*) as TotalSlots,
       SUM(CASE WHEN s.status = 'AVAILABLE' THEN 1 ELSE 0 END) as Available,
       SUM(CASE WHEN s.status = 'OCCUPIED' THEN 1 ELSE 0 END) as Occupied,
       SUM(CASE WHEN s.status = 'ERROR' THEN 1 ELSE 0 END) as Error
FROM parking_lot p
LEFT JOIN parking_slot s ON p.id = s.parkinglot_id
GROUP BY p.name;

-- Check active vs finished parking sessions
SELECT status, COUNT(*) as total FROM parking_session GROUP BY status;

-- Check payment status distribution
SELECT status, COUNT(*) as total, SUM(amount) as total_amount 
FROM payment GROUP BY status;

-- Check valid vs expired tickets
SELECT 
  CASE WHEN end_date >= GETDATE() THEN 'ACTIVE' ELSE 'EXPIRED' END as status,
  COUNT(*) as total
FROM ticket
GROUP BY CASE WHEN end_date >= GETDATE() THEN 'ACTIVE' ELSE 'EXPIRED' END;
*/

-- ============================================================================
-- END OF TEST DATA SCRIPT
-- ============================================================================