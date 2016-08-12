/**
 * EnumerationUserTypes.swift
 *
 * Generated by JSON Model Generator v0.0.4 on Aug 12, 2016
 * https://github.com/intere/generator-json-models
 *
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
 */

import XCTest
@testable import Generated

class EnumerationUserTypesTest: XCTestCase {

    override func setUp() {
        super.setUp()
    }

    override func tearDown() {
        super.tearDown()
    }
}

// MARK: - name Tests

extension EnumerationUserTypesTest {

    func testNameFromMap() {
        guard let model = EnumerationUserTypes.fromMap(["name": "I look at God behind his desk, taking notes on a pad, but God’s got this all wrong."]) else {
            XCTFail("The EnumerationUserTypes was nil")
            return
        }

        XCTAssertEqual("I look at God behind his desk, taking notes on a pad, but God’s got this all wrong.", model.name, "The name is incorrect")
    }

    func testNameFromEmptyMap() {
        guard let model = EnumerationUserTypes.fromMap([:]) else {
            XCTFail("The EnumerationUserTypes was nil")
            return
        }

        XCTAssertNil(model.name, "The name is not nil")
    }
}

// MARK: - value Tests

extension EnumerationUserTypesTest {

    func testValueFromMap() {
        guard let model = EnumerationUserTypes.fromMap(["value": 4136129598255192064]) else {
            XCTFail("The EnumerationUserTypes was nil")
            return
        }

        XCTAssertEqual(4136129598255192064, model.value, "The value is incorrect")
    }

    func testValueFromEmptyMap() {
        guard let model = EnumerationUserTypes.fromMap([:]) else {
            XCTFail("The EnumerationUserTypes was nil")
            return
        }

        XCTAssertNil(model.value, "The value is not nil")
    }
}
