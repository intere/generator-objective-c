/**
 * EnumerationTournamentStates.swift
 *
 * Generated by JSON Model Generator v0.0.5 on Aug 28, 2016
 * https://github.com/intere/generator-json-models
 *
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
 */

import Foundation

class EnumerationTournamentStates {
    var name: String?
    var value: Int?

}

// MARK: - Serialization

extension EnumerationTournamentStates {

    /**
    Serializes this EnumerationTournamentStates to a Dictionary.
    - Returns: A Map which represents this object as a serialized object
    */
    func toMap() -> [String: AnyObject] {
        var dict = [String: AnyObject]()

        dict["name"] = name
        dict["value"] = value

        return dict
    }

    /**
    Converts the provided array of EnumerationTournamentStates Objects to an array of dictionaries.
    - Parameter models: An array of EnumerationTournamentStates Objects to be converted to an array of dictionaries.
    - Returns: An array of Dictionaries
    */
    class func toMapArray(models: [EnumerationTournamentStates]?) -> [[String: AnyObject]]? {
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
	- Parameter array: Array of EnumerationTournamentStates objects to be serialized.
	- Returns: NSData that contains the serialized objects, or nil if there's a problem serializing them.
	*/
	class func toJsonData(array: [EnumerationTournamentStates]) -> NSData? {
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
    - Parameter array: Array of EnumerationTournamentStates objects to be serialized
    - Returns: Optional String (nil if there's a problem serializing to NSData or converting to a UTF-8 String).
    */
    class func toJsonString(array: [EnumerationTournamentStates]) -> String? {
        guard let data = toJsonData(array) else {
            return nil
        }

        return NSString(data: data, encoding: NSUTF8StringEncoding) as? String
    }

}

// MARK: - Deserialization

extension EnumerationTournamentStates {

    /**
    Gets you a EnumerationTournamentStates object from the provided map
    - Parameter map: The Map to read the data from.
    - Returns: A EnumerationTournamentStates object (assuming the map you provided is non-nil)
    */
    class func fromMap(map: [String:AnyObject]?) -> EnumerationTournamentStates? {
        guard let map = map else {
            return nil
        }

        let model = EnumerationTournamentStates()
        model.name = map["name"] as? String
        model.value = map["value"] as? Int
        return model
    }

    /**
    Creates an Array of EnumerationTournamentStates objects for the provided Array of Maps.
    - Parameter mapArray: An array of Maps, assumes that each map is a serialized EnumerationTournamentStates.
    - Returns: An array of EnumerationTournamentStates objects (should be 1 to 1).
    */
    class func fromArrayOfMaps(mapArray: [[String:AnyObject]]?) -> [EnumerationTournamentStates]? {
        guard let mapArray = mapArray else {
            return nil
        }

        var modelArray = [EnumerationTournamentStates]()

        for map in mapArray {
            guard let model = fromMap(map) else {
                continue
            }
            modelArray.append(model)
        }

        return modelArray
    }

    /**
    Gives you back a collection of EnumerationTournamentStates objects for the provided JSON Serialized Data.  This method handles both a single object (map) and an array of objects (array of maps).
    - Parameter data: The NSData (optional) to pull the objects from.
    - Returns: An array of EnumerationTournamentStates objects that were deserialized from the provided data.
    */
    class func fromData(data: NSData?) -> [EnumerationTournamentStates]? {
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
	 Gives you back a collection of EnumerationTournamentStates objects after deserializing them from a String to Data, Data to a Dictionary and then finally to a Model Object.
	 - Parameter json: The (UTF-8) JSON String to deserialize into EnumerationTournamentStates objects.
	 - Returns: An Array of EnumerationTournamentStates objects.
	*/
	class func fromJson(json: String) -> [EnumerationTournamentStates]? {
		let data = (json as NSString).dataUsingEncoding(NSUTF8StringEncoding)
		return fromData(data)
	}

}

