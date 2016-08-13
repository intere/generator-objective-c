/**
 * TrackPoints.swift
 *
 * Generated by JSON Model Generator v0.0.4 on Aug 13, 2016
 * https://github.com/intere/generator-json-models
 *
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
 */

import XCTest
@testable import Generated

class TrackPointsTest: XCTestCase {

    override func setUp() {
        super.setUp()
    }

    override func tearDown() {
        super.tearDown()
    }
}

// MARK: - alt Tests

extension TrackPointsTest {

    func testAltFromMap() {
        guard let model = TrackPoints.fromMap(["alt": 1.6522870259998385E308]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(1.6522870259998385E308, model.alt, "The alt is incorrect")
    }

    func testAltFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.alt, "The alt is not nil")
    }
}

// MARK: - dist Tests

extension TrackPointsTest {

    func testDistFromMap() {
        guard let model = TrackPoints.fromMap(["dist": 3009642563073851392]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(3009642563073851392, model.dist, "The dist is incorrect")
    }

    func testDistFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.dist, "The dist is not nil")
    }
}

// MARK: - h_acc Tests

extension TrackPointsTest {

    func testHAccFromMap() {
        guard let model = TrackPoints.fromMap(["h_acc": 5.849030769768015E307]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(5.849030769768015E307, model.hAcc, "The hAcc is incorrect")
    }

    func testHAccFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.hAcc, "The hAcc is not nil")
    }
}

// MARK: - lat Tests

extension TrackPointsTest {

    func testLatFromMap() {
        guard let model = TrackPoints.fromMap(["lat": 8.847848649960108E307]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(8.847848649960108E307, model.lat, "The lat is incorrect")
    }

    func testLatFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.lat, "The lat is not nil")
    }
}

// MARK: - lon Tests

extension TrackPointsTest {

    func testLonFromMap() {
        guard let model = TrackPoints.fromMap(["lon": 1.2747823909977887E308]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(1.2747823909977887E308, model.lon, "The lon is incorrect")
    }

    func testLonFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.lon, "The lon is not nil")
    }
}

// MARK: - speed Tests

extension TrackPointsTest {

    func testSpeedFromMap() {
        guard let model = TrackPoints.fromMap(["speed": 4.2892172074922253E307]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(4.2892172074922253E307, model.speed, "The speed is incorrect")
    }

    func testSpeedFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.speed, "The speed is not nil")
    }
}

// MARK: - time Tests

extension TrackPointsTest {

    func testTimeFromMap() {
        let date = NSDate()
        let dateInt = Int(date.timeIntervalSince1970 * 1000) // SSE (double) to MSSE (Int)
        guard let model = TrackPoints.fromMap(["time": dateInt]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        guard let result = model.time else {
            XCTFail("The time date is nil")
            return
        }

        XCTAssertEqualWithAccuracy(date.timeIntervalSince1970, result.timeIntervalSince1970, accuracy: 0.01, "The time date is incorrect")
    }

    func testTimeFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.time, "The time is not nil")
    }
}

// MARK: - v_acc Tests

extension TrackPointsTest {

    func testVAccFromMap() {
        guard let model = TrackPoints.fromMap(["v_acc": 9.44969709972419E307]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertEqual(9.44969709972419E307, model.vAcc, "The vAcc is incorrect")
    }

    func testVAccFromEmptyMap() {
        guard let model = TrackPoints.fromMap([:]) else {
            XCTFail("The TrackPoints was nil")
            return
        }

        XCTAssertNil(model.vAcc, "The vAcc is not nil")
    }
}

