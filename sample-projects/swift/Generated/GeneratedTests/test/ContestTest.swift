/**
 * Contest.swift
 *
 * Generated by JSON Model Generator v0.0.4 on Aug 12, 2016
 * https://github.com/intere/generator-json-models
 *
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
 */

import XCTest
@testable import Generated

class ContestTest: XCTestCase {

    override func setUp() {
        super.setUp()
    }

    override func tearDown() {
        super.tearDown()
    }
}

// MARK: - id Tests

extension ContestTest {

    func testTheIdFromMap() {
        guard let model = Contest.fromMap(["id": "At the time, my life just seemed too complete, and maybe we have to break everything to make something better out of ourselves."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("At the time, my life just seemed too complete, and maybe we have to break everything to make something better out of ourselves.", model.theId, "The theId is incorrect")
    }

    func testTheIdFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.theId, "The theId is not nil")
    }
}

// MARK: - title Tests

extension ContestTest {

    func testTitleFromMap() {
        guard let model = Contest.fromMap(["title": "I don't want to die without any scars."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("I don't want to die without any scars.", model.title, "The title is incorrect")
    }

    func testTitleFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.title, "The title is not nil")
    }
}

// MARK: - typeName Tests

extension ContestTest {

    func testTypeNameFromMap() {
        guard let model = Contest.fromMap(["typeName": "We've all been raised on television to believe that one day we'd all be millionaires, and movie gods, and rock stars. But we won't. And we're slowly learning that fact. And we're very, very pissed off."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("We've all been raised on television to believe that one day we'd all be millionaires, and movie gods, and rock stars. But we won't. And we're slowly learning that fact. And we're very, very pissed off.", model.typeName, "The typeName is incorrect")
    }

    func testTypeNameFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.typeName, "The typeName is not nil")
    }
}

// MARK: - stateName Tests

extension ContestTest {

    func testStateNameFromMap() {
        guard let model = Contest.fromMap(["stateName": "Yeah. Well. Whatever. You can’t teach God anything."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("Yeah. Well. Whatever. You can’t teach God anything.", model.stateName, "The stateName is incorrect")
    }

    func testStateNameFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.stateName, "The stateName is not nil")
    }
}

// MARK: - imageUrl Tests

extension ContestTest {

    func testImageUrlFromMap() {
        guard let model = Contest.fromMap(["imageUrl": "https://unsplash.it/200/200"]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("https://unsplash.it/200/200", model.imageUrl, "The imageUrl is incorrect")
    }

    func testImageUrlFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.imageUrl, "The imageUrl is not nil")
    }
}

// MARK: - description Tests

extension ContestTest {

    func testTheDescriptionFromMap() {
        guard let model = Contest.fromMap(["description": "I let go. Lost in oblivion. Dark and silent and complete. I found freedom. Losing all hope was freedom."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("I let go. Lost in oblivion. Dark and silent and complete. I found freedom. Losing all hope was freedom.", model.theDescription, "The theDescription is incorrect")
    }

    func testTheDescriptionFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.theDescription, "The theDescription is not nil")
    }
}

// MARK: - startDate Tests

extension ContestTest {

    func testStartDateFromMap() {
        let date = NSDate()
        let dateInt = Int(date.timeIntervalSince1970 * 1000) // SSE (double) to MSSE (Int)
        guard let model = Contest.fromMap(["startDate": dateInt]) else {
            XCTFail("The Contest was nil")
            return
        }

        guard let startDate = model.startDate else {
            XCTFail("The startDate date is nil")
            return
        }

        XCTAssertEqualWithAccuracy(date.timeIntervalSince1970, startDate.timeIntervalSince1970, accuracy: 0.01, "The startDate date is incorrect")
    }

    func testStartDateFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.startDate, "The startDate is not nil")
    }
}

// MARK: - endDate Tests

extension ContestTest {

    func testEndDateFromMap() {
        let date = NSDate()
        let dateInt = Int(date.timeIntervalSince1970 * 1000) // SSE (double) to MSSE (Int)
        guard let model = Contest.fromMap(["endDate": dateInt]) else {
            XCTFail("The Contest was nil")
            return
        }

        guard let endDate = model.endDate else {
            XCTFail("The endDate date is nil")
            return
        }

        XCTAssertEqualWithAccuracy(date.timeIntervalSince1970, endDate.timeIntervalSince1970, accuracy: 0.01, "The endDate date is incorrect")
    }

    func testEndDateFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.endDate, "The endDate is not nil")
    }
}

// MARK: - userIDs Tests

extension ContestTest {

    func testUserIDsFromMap() {
        let arrayData = ["I don't want to die without any scars.", "I don't want to die without any scars."]  // Array of 2 empty objects
        guard let model = Contest.fromMap(["userIDs": arrayData ]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNotNil(model.userIDs, "The userIDs was nil")
        XCTAssertEqual(2, model.userIDs?.count, "The userIDs has the wrong number of objects")
    }

    func testUserIDsFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.userIDs, "The userIDs is not nil")
    }
}

// MARK: - results Tests

extension ContestTest {

    func testResultsFromMap() {
        let arrayData = [[:], [:]]  // Array of 2 empty objects
        guard let model = Contest.fromMap(["results": arrayData ]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNotNil(model.results, "The results was nil")
        XCTAssertEqual(2, model.results?.count, "The results has the wrong number of objects")
    }

    func testResultsFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.results, "The results is not nil")
    }
}

// MARK: - createdDate Tests

extension ContestTest {

    func testCreatedDateFromMap() {
        let date = NSDate()
        let dateInt = Int(date.timeIntervalSince1970 * 1000) // SSE (double) to MSSE (Int)
        guard let model = Contest.fromMap(["createdDate": dateInt]) else {
            XCTFail("The Contest was nil")
            return
        }

        guard let createdDate = model.createdDate else {
            XCTFail("The createdDate date is nil")
            return
        }

        XCTAssertEqualWithAccuracy(date.timeIntervalSince1970, createdDate.timeIntervalSince1970, accuracy: 0.01, "The createdDate date is incorrect")
    }

    func testCreatedDateFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.createdDate, "The createdDate is not nil")
    }
}

// MARK: - latitude Tests

extension ContestTest {

    func testLatitudeFromMap() {
        guard let model = Contest.fromMap(["latitude": 4.614463697604645E307]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual(4.614463697604645E307, model.latitude, "The latitude is incorrect")
    }

    func testLatitudeFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.latitude, "The latitude is not nil")
    }
}

// MARK: - longitude Tests

extension ContestTest {

    func testLongitudeFromMap() {
        guard let model = Contest.fromMap(["longitude": 3.232617865246082E307]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual(3.232617865246082E307, model.longitude, "The longitude is incorrect")
    }

    func testLongitudeFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.longitude, "The longitude is not nil")
    }
}

// MARK: - purseDescription Tests

extension ContestTest {

    func testPurseDescriptionFromMap() {
        guard let model = Contest.fromMap(["purseDescription": "We've all been raised on television to believe that one day we'd all be millionaires, and movie gods, and rock stars. But we won't. And we're slowly learning that fact. And we're very, very pissed off."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("We've all been raised on television to believe that one day we'd all be millionaires, and movie gods, and rock stars. But we won't. And we're slowly learning that fact. And we're very, very pissed off.", model.purseDescription, "The purseDescription is incorrect")
    }

    func testPurseDescriptionFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.purseDescription, "The purseDescription is not nil")
    }
}

// MARK: - purseImageUrl Tests

extension ContestTest {

    func testPurseImageUrlFromMap() {
        guard let model = Contest.fromMap(["purseImageUrl": "https://unsplash.it/200/200"]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("https://unsplash.it/200/200", model.purseImageUrl, "The purseImageUrl is incorrect")
    }

    func testPurseImageUrlFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.purseImageUrl, "The purseImageUrl is not nil")
    }
}

// MARK: - pursePrizeValue Tests

extension ContestTest {

    func testPursePrizeValueFromMap() {
        guard let model = Contest.fromMap(["pursePrizeValue": "Yeah. Well. Whatever. You can’t teach God anything."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("Yeah. Well. Whatever. You can’t teach God anything.", model.pursePrizeValue, "The pursePrizeValue is incorrect")
    }

    func testPursePrizeValueFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.pursePrizeValue, "The pursePrizeValue is not nil")
    }
}

// MARK: - purseTitle Tests

extension ContestTest {

    func testPurseTitleFromMap() {
        guard let model = Contest.fromMap(["purseTitle": "You know how they say you only hurt the ones you love? Well, it works both ways."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("You know how they say you only hurt the ones you love? Well, it works both ways.", model.purseTitle, "The purseTitle is incorrect")
    }

    func testPurseTitleFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.purseTitle, "The purseTitle is not nil")
    }
}

// MARK: - purseType Tests

extension ContestTest {

    func testPurseTypeFromMap() {
        guard let model = Contest.fromMap(["purseType": "Yeah. Well. Whatever. You can’t teach God anything."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("Yeah. Well. Whatever. You can’t teach God anything.", model.purseType, "The purseType is incorrect")
    }

    func testPurseTypeFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.purseType, "The purseType is not nil")
    }
}

// MARK: - runnerUpDescription Tests

extension ContestTest {

    func testRunnerUpDescriptionFromMap() {
        guard let model = Contest.fromMap(["runnerUpDescription": "Yeah. Well. Whatever. You can’t teach God anything."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("Yeah. Well. Whatever. You can’t teach God anything.", model.runnerUpDescription, "The runnerUpDescription is incorrect")
    }

    func testRunnerUpDescriptionFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.runnerUpDescription, "The runnerUpDescription is not nil")
    }
}

// MARK: - runnerUpPrizeValue Tests

extension ContestTest {

    func testRunnerUpPrizeValueFromMap() {
        guard let model = Contest.fromMap(["runnerUpPrizeValue": "The things you used to own, now they own you."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("The things you used to own, now they own you.", model.runnerUpPrizeValue, "The runnerUpPrizeValue is incorrect")
    }

    func testRunnerUpPrizeValueFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.runnerUpPrizeValue, "The runnerUpPrizeValue is not nil")
    }
}

// MARK: - runnerUpPurseImageUrl Tests

extension ContestTest {

    func testRunnerUpPurseImageUrlFromMap() {
        guard let model = Contest.fromMap(["runnerUpPurseImageUrl": "http://lorempixel.com/200/200/"]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("http://lorempixel.com/200/200/", model.runnerUpPurseImageUrl, "The runnerUpPurseImageUrl is incorrect")
    }

    func testRunnerUpPurseImageUrlFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.runnerUpPurseImageUrl, "The runnerUpPurseImageUrl is not nil")
    }
}

// MARK: - runnerUpTitle Tests

extension ContestTest {

    func testRunnerUpTitleFromMap() {
        guard let model = Contest.fromMap(["runnerUpTitle": "I look at God behind his desk, taking notes on a pad, but God’s got this all wrong."]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual("I look at God behind his desk, taking notes on a pad, but God’s got this all wrong.", model.runnerUpTitle, "The runnerUpTitle is incorrect")
    }

    func testRunnerUpTitleFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.runnerUpTitle, "The runnerUpTitle is not nil")
    }
}

// MARK: - scored Tests

extension ContestTest {

    func testScoredFromMap() {
        guard let model = Contest.fromMap(["scored": false]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual(false, model.scored, "The scored is incorrect")
    }

    func testScoredFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.scored, "The scored is not nil")
    }
}

// MARK: - size Tests

extension ContestTest {

    func testSizeFromMap() {
        guard let model = Contest.fromMap(["size": 2689747247312407552]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual(2689747247312407552, model.size, "The size is incorrect")
    }

    func testSizeFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.size, "The size is not nil")
    }
}

// MARK: - sponsor Tests

extension ContestTest {

    func testSponsorFromMap() {
        guard let model = Contest.fromMap(["sponsor":[:]]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNotNil(model.sponsor, "The sponsor is nil")
    }

    func testSponsorFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.sponsor, "The sponsor is not nil")
    }
}

// MARK: - state Tests

extension ContestTest {

    func testStateFromMap() {
        guard let model = Contest.fromMap(["state": 2654906046318837760]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual(2654906046318837760, model.state, "The state is incorrect")
    }

    func testStateFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.state, "The state is not nil")
    }
}

// MARK: - trackIDs Tests

extension ContestTest {

    func testTrackIDsFromMap() {
        let arrayData = ["I let go. Lost in oblivion. Dark and silent and complete. I found freedom. Losing all hope was freedom.", "I wanted to destroy everything beautiful I'd never have."]  // Array of 2 empty objects
        guard let model = Contest.fromMap(["trackIDs": arrayData ]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNotNil(model.trackIDs, "The trackIDs was nil")
        XCTAssertEqual(2, model.trackIDs?.count, "The trackIDs has the wrong number of objects")
    }

    func testTrackIDsFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.trackIDs, "The trackIDs is not nil")
    }
}

// MARK: - type Tests

extension ContestTest {

    func testTypeFromMap() {
        guard let model = Contest.fromMap(["type": 1976676078989469696]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertEqual(1976676078989469696, model.theType, "The theType is incorrect")
    }

    func testTypeFromEmptyMap() {
        guard let model = Contest.fromMap([:]) else {
            XCTFail("The Contest was nil")
            return
        }

        XCTAssertNil(model.theType, "The theType is not nil")
    }
}

