/**
 * ContestSponsor.swift
 *
 * Generated by JSON Model Generator v0.0.4 on Aug 12, 2016
 * https://github.com/intere/generator-json-models
 *
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
 */

import Foundation

class ContestSponsor {
    var address1: String?
    var address2: String?
    var category: String?
    var city: String?
    var contactEmail: String?
    var contactName: String?
    var contactTitle: String?
    var theId: String?
    var logo: String?
    var name: String?
    var phoneNumber: String?
    var siteUrl: String?
    var state: String?
    var zip: String?

}

// MARK: - Serialization

extension ContestSponsor {

    /**
    Serializes this ContestSponsor to a Dictionary.
    - Returns: A Map which represents this object as a serialized object
    */
    func toMap() -> [String: AnyObject] {
        var dict = [String: AnyObject]()

        dict["address1"] = address1
        dict["address2"] = address2
        dict["category"] = category
        dict["city"] = city
        dict["contactEmail"] = contactEmail
        dict["contactName"] = contactName
        dict["contactTitle"] = contactTitle
        dict["id"] = theId
        dict["logo"] = logo
        dict["name"] = name
        dict["phoneNumber"] = phoneNumber
        dict["siteUrl"] = siteUrl
        dict["state"] = state
        dict["zip"] = zip

        return dict
    }

    /**
    Converts the provided array of ContestSponsor Objects to an array of dictionaries.
    - Parameter models: An array of ContestSponsor Objects to be converted to an array of dictionaries.
    - Returns: An array of Dictionaries
    */
    class func toMapArray(models: [ContestSponsor]?) -> [[String: AnyObject]]? {
        guard let models = models else {
            return nil
        }
        var maps = [[String: AnyObject]]()

        for model in models {
            maps.append(model.toMap())
        }

        return maps
    }

    /**
    Converts this model to JSON Data.
    - Returns: Optional JSON Data (returns nil if there's a problem serializing the map).
    */
    func toJsonData() -> NSData? {
        let dict = toMap()
        do {
            return try NSJSONSerialization.dataWithJSONObject(dict, options: .PrettyPrinted)
        } catch {
            print("Error serializing this model to JSON: \(dict)")
        }

        return nil
    }

	/**
	Converts the provided array of models to JSON Data.
	- Parameter array: Array of ContestSponsor objects to be serialized.
	- Returns: NSData that contains the serialized objects, or nil if there's a problem serializing them.
	*/
	class func toJsonData(array: [ContestSponsor]) -> NSData? {
		let mapArray = toMapArray(array) as! AnyObject
		do {
			return try NSJSONSerialization.dataWithJSONObject(mapArray, options: .PrettyPrinted)
		} catch {
			print("Error serializing array of models to JSON: \(mapArray)")
		}
		return nil
	}

	/**
	Converts this model to a JSON String.
	- Returns: Optional String (nil if there's a problem serializing the map to Data or converting it to a UTF-8 String).
	*/
	func toJsonString() -> String? {
	    guard let data = toJsonData() else {
	        return nil
        }

        return NSString(data: data, encoding: NSUTF8StringEncoding) as? String
	}

    /**
    Converts the provided array of models to a JSON String.
    - Parameter array: Array of ContestSponsor objects to be serialized
    - Returns: Optional String (nil if there's a problem serializing to NSData or converting to a UTF-8 String).
    */
    class func toJsonString(array: [ContestSponsor]) -> String? {
        guard let data = toJsonData(array) else {
            return nil
        }

        return NSString(data: data, encoding: NSUTF8StringEncoding) as? String
    }

}

// MARK: - Deserialization

extension ContestSponsor {

    /**
    Gets you a ContestSponsor object from the provided map
    - Parameter map: The Map to read the data from.
    - Returns: A ContestSponsor object (assuming the map you provided is non-nil)
    */
    class func fromMap(map: [String:AnyObject]?) -> ContestSponsor? {
        guard let map = map else {
            return nil
        }

        let model = ContestSponsor()
        model.address1 = map["address1"] as? String
        model.address2 = map["address2"] as? String
        model.category = map["category"] as? String
        model.city = map["city"] as? String
        model.contactEmail = map["contactEmail"] as? String
        model.contactName = map["contactName"] as? String
        model.contactTitle = map["contactTitle"] as? String
        model.theId = map["id"] as? String
        model.logo = map["logo"] as? String
        model.name = map["name"] as? String
        model.phoneNumber = map["phoneNumber"] as? String
        model.siteUrl = map["siteUrl"] as? String
        model.state = map["state"] as? String
        model.zip = map["zip"] as? String
        return model
    }

    /**
    Creates an Array of ContestSponsor objects for the provided Array of Maps.
    - Parameter mapArray: An array of Maps, assumes that each map is a serialized ContestSponsor.
    - Returns: An array of ContestSponsor objects (should be 1 to 1).
    */
    class func fromArrayOfMaps(mapArray: [[String:AnyObject]]?) -> [ContestSponsor]? {
        guard let mapArray = mapArray else {
            return nil
        }

        var modelArray = [ContestSponsor]()

        for map in mapArray {
            guard let model = fromMap(map) else {
                continue
            }
            modelArray.append(model)
        }

        return modelArray
    }

    /**
    Gives you back a collection of ContestSponsor objects for the provided JSON Serialized Data.  This method handles both a single object (map) and an array of objects (array of maps).
    - Parameter data: The NSData (optional) to pull the objects from.
    - Returns: An array of ContestSponsor objects that were deserialized from the provided data.
    */
    class func fromData(data: NSData?) -> [ContestSponsor]? {
        guard let data = data else {
            return []
        }

        do {
            let jsonData = try NSJSONSerialization.JSONObjectWithData(data, options: .AllowFragments)

            // If we have an array of dictionaries:
            if let jsonArray = jsonData as? [[String:AnyObject]] {
                return fromArrayOfMaps(jsonArray)
            } else if let jsonMap = jsonData as? [String:AnyObject] {
                if let model = fromMap(jsonMap) {
                    return [model]
                }
            } else {
                print("Unknown JSON Data type: \(jsonData)")
            }
        } catch {
            print("Error deserializing json data")
        }

        return []
    }

	/**
	 Gives you back a collection of ContestSponsor objects after deserializing them from a String to Data, Data to a Dictionary and then finally to a Model Object.
	 - Parameter json: The (UTF-8) JSON String to deserialize into ContestSponsor objects.
	 - Returns: An Array of ContestSponsor objects.
	*/
	class func fromJson(json: String) -> [ContestSponsor]? {
		let data = (json as NSString).dataUsingEncoding(NSUTF8StringEncoding)
		return fromData(data)
	}

}

