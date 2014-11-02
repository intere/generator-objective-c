package com.intere.generator.builder.generation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;

import com.intere.generator.builder.interpreter.JsonLanguageInterpreter;
import com.intere.generator.builder.interpreter.ObjectiveCInterpreter;
import com.intere.generator.deserializer.JsonDeserializer;
import com.intere.generator.deserializer.JsonNodeUtils;

public class ObjectiveCGeneration extends CodeGeneration {
	private static final JsonLanguageInterpreter INTERPRETER = new ObjectiveCInterpreter();

	public JsonLanguageInterpreter getInterpreter() {
		return INTERPRETER;
	}
	
	/**
	 * Generates the Header file using the JSON String.
	 * @return a String.
	 * @throws IOException 
	 * @throws JsonParseException 
	 */
	public String generateHeaderFile(JsonDeserializer deserializer) {
		String className = deserializer.getName();
		NavigableMap<String, List<JsonDeserializer>> subClasses = deserializer.getSubClasses();
		JsonNode node = deserializer.getNode();
		StringBuilder builder = new StringBuilder();
		builder.append("//\n" + 
				"//  " + className + ".h\n" + 
				"//\n" + 
				"//  Generated by objection-c generator on " + getDate() + ".\n" + 
				"//\n" + 
				"//\n\n" +
				"#import <Foundation/Foundation.h>\n\n");
		
		if(subClasses.containsKey(className)) {
			for(JsonDeserializer des : subClasses.get(className)) {
				builder.append("#import \"" + des.getName() + ".h\"\n");
			}
		}
		
		builder.append("@interface " + className + " : NSObject\n\n" +
				"//\n" +
				"// Properties\n" + 
				"//\n\n");
		
		// Now - go generate all of the properties:
		Iterator<String> iter = node.getFieldNames();
		
		while(iter.hasNext()) {
			String name = iter.next();
			builder.append(buildPropertyDeclaration(node.get(name), className, name));
		}
		
		//
		// Now generate the serialize / deserialize declarations:
		//
		builder.append("\n\n" +
			"/**\n" + 
			" * Converts this " + className + " to a NSDictionary object (as a serialization mechanism).\n" + 
			" */\n" + 
			"-(NSDictionary *)toDictionary;\n" + 
			"\n" + 
			"/**\n" + 
			" * Converts this " + className + " to a JSON String (as a serializaton mechanism).\n" + 
			" */\n" + 
			"-(NSString *)toJson;\n" +
			"/**\n" +
			" * Converts this " + className + " to a JSON String (as a serialization mechanism) with optional pretty print.\n" +
			" */\n" + 
			"-(NSString *)toJson:(BOOL)pretty;\n" + 
			"\n" + 
			"/**\n" + 
			" * \"Deserializes\" the provided dictionary into a " + className + ".\n" + 
			" */\n" + 
			"+(" + className + " *)fromDictionary:(NSDictionary *)dict;\n" + 
			"\n" + 
			"/**\n" + 
			" * Deserializes the provided JSON String into a " + className + ".\n" + 
			" */\n" + 
			"+(" + className + " *)fromJsonString:(NSString *)json;\n" + 
			"/**\n" + 
			" * \"Deserializes\" the provided array of dictionaries into an array of " + className + ".\n" + 
			" */\n" + 
			"+(NSMutableArray *)fromArrayOfDictionaries:(NSArray *)array;\n" + 
			"\n" + 
			"/**\n" + 
			" * \"Serializes\" the provided Array of " + className + " to an Array of Dictionaries.\n" + 
			" */\n" + 
			"+(NSMutableArray *)toArrayOfDictionaries:(NSArray *)array;" +
			"\n\n");
		
		builder.append("@end\n\n");
		
		return builder.toString();
	}
	
	public String buildPoundDefineSerializerDeclarations(String name) {
		String defName = getInterpreter().createSerializeConstantSymbolName(name);
		return "#define " + defName + " @\"" + name + "\"\n";
	}
	
	/**
	 * Builds the ".m" (Implementation) file.
	 * @return The file contents.
	 */
	public String generateImplementationFile(JsonDeserializer deserializer) {
		String className = deserializer.getName();
		JsonNode node = deserializer.getNode();
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("//\n" + 
				"//  " + className + ".m\n" + 
				"//\n" + 
				"//  Generated by objection-c generator on " + getDate() + ".\n" + 
				"//\n" + 
				"//\n\n" +
				"#import \"" + className + ".h\"\n" + 
				"#import \"Serializer.h\"\n\n");
		
		//
		// Create the serialization precompiler definitions:
		//
		Iterator<String> iter = node.getFieldNames();
		while(iter.hasNext()) {			
			String name = iter.next();
			builder.append(buildPoundDefineSerializerDeclarations(name));
		}
		
		//
		// Class Definition:
		//
		builder.append("\n\n@implementation " + className + "\n\n" +
			"#pragma mark Serialization Methods\n\n");
		
		//
		// toDictionary Method
		//
		builder.append("-(NSDictionary *)toDictionary {\n" + 
			"\tNSMutableDictionary *dict = [[NSMutableDictionary alloc]init];\n\n");
		iter = node.getFieldNames();
		
		while(iter.hasNext()) {
			String name = iter.next();
			builder.append("\t" + buildGeneratedSerializePropertyString(node.get(name), className, name));
		}
		builder.append("\n\treturn dict;\n}\n\n");
		
		//
		// To JSON methods:
		//
		builder.append("-(NSString *)toJson {\n" + 
				"\treturn [self toJson:NO];\n" + 
				"}\n" + 
				"\n" + 
				"-(NSString *)toJson:(BOOL)pretty {\n" + 
				"\tNSDictionary *dict = [self toDictionary];\n\n" + 
				"\treturn [Serializer jsonStringFromDictionary:dict withPrettyPrint:pretty];\n" + 
				"\n}");
		
		//
		// fromDictionary Method
		//
		builder.append("\n\n+ (" + className + " *)fromDictionary:(NSDictionary *)dict {\n" + 
				"\t" + className + " *object = [[" + className + " alloc]init];\n");
		iter = node.getFieldNames();
		while(iter.hasNext()) {
			String name = iter.next();
			builder.append("\t" + buildGenerateDeserializePropertyString(node.get(name), className, name));
		}
		
		builder.append("\treturn object;\n}\n\n");
		
		//
		// fromJSON Method:
		//
		builder.append("+(" + className + " *)fromJsonString:(NSString *)json {\n" + 
				"\tNSDictionary *dict = [Serializer fromJsonString:json];\n" + 
				"\treturn [" + className + " fromDictionary:dict];\n" + 
				"}\n\n");
		//
		// fromArrayOfDictionaries Method:
		//
		builder.append("+(NSMutableArray *)fromArrayOfDictionaries:(NSArray *)array {\n" + 
				"    NSMutableArray *result = [[NSMutableArray alloc]init];\n" + 
				"    \n" + 
				"    for (NSDictionary *dict in array) {\n" + 
				"        [result addObject:[" + className + " fromDictionary:dict]];\n" + 
				"    }\n" + 
				"    \n" + 
				"    return result;\n" + 
				"}\n\n");
		
		//
		// toArrayOfDictionaries Method:
		//
		builder.append("+(NSMutableArray *)toArrayOfDictionaries:(NSArray *)array {\n" + 
				"    NSMutableArray *result = [[NSMutableArray alloc]init];\n" + 
				"    \n" + 
				"    for(" + className + " *object in array) {\n" + 
				"        [result addObject:[object toDictionary]];\n" + 
				"    }\n" + 
				"    \n" + 
				"    return result;\n" + 
				"}\n\n");
		
		builder.append("@end\n\n");		
		return builder.toString();
	}
	

	
	/**
	 * Builds the Serialization snippet per property.  
	 * Think: Serializing properties into the dictionary prior to serializing to JSON.
	 * @param node The node to be serialized.
	 * @param nodeName The name of the node that is going to be serialized.
	 * @return
	 */
	public String buildGeneratedSerializePropertyString(JsonNode node, String className, String nodeName) {
		String variableName = getInterpreter().cleanVariableName(nodeName);
		String defName = getInterpreter().createSerializeConstantSymbolName(nodeName);
		String subClassName = getInterpreter().buildSubClassName(className, nodeName);
		
		if(node.isTextual()) {
			return "[Serializer setDict:dict object:self." + variableName + " forKey:" + defName + "];\n";
		} else if(node.isInt()) {
			return "[Serializer setDict:dict intValue:self." + variableName + " forKey:" + defName + "];\n";	
		} else if(node.isFloatingPointNumber()) {
			return "[Serializer setDict:dict doubleValue:self." + variableName + " forKey:" + defName + "];\n";
		} else if(node.isBoolean()) {
			return "[Serializer setDict:dict boolValue:self." + variableName + " forKey:" + defName + "];\n";
		} else if(node.isArray()) {
			if(JsonNodeUtils.isArrayOfObjects(node)) {
				return "[Serializer setDict:dict object:[" + subClassName + " toArrayOfDictionaries:self."+ variableName + "] forKey:" + defName + "];\n"; 
			} else if(JsonNodeUtils.isArrayofArrays(node)) {
				// TODO: how do we handle an array of arrays?
			} else {
				return "[Serializer setDict:dict object:self." + variableName + " forKey:" + defName + "];\n";
			}
		} else if(node.isObject()) {
			return "[Serializer setDict:dict object:[self." + variableName + " toDictionary] forKey:" + defName + "];\n";
		}
		return "";
	}
	
	/**
	 * Generates the <code>@property</code> definitions.
	 * @param node
	 * @param className
	 * @param name
	 * @return
	 */
	public String buildPropertyDeclaration(JsonNode node, String className, String name) {
		String variableName = getInterpreter().cleanVariableName(name);
		String subClassName = getInterpreter().buildSubClassName(className, name);
		
		if(node.isTextual()) {
			return "@property (nonatomic, strong) NSString *" + variableName + ";\n";
		} else if(node.isInt()) {
			return "@property (nonatomic) NSInteger " + variableName + ";\n";
		} else if(node.isFloatingPointNumber()) {
			return "@property (nonatomic) double " + variableName + ";\n";
		} else if(node.isObject()) {
			return "@property (nonatomic, strong) " + subClassName + " *" + variableName + ";\n";
		} else if(node.isBoolean()) {
			return "@property (nonatomic) BOOL " + variableName + ";\n";
		} else if(node.isArray()) {
			return "@property (nonatomic, strong) NSMutableArray *" + variableName + ";\n";
		} else {
			System.out.println(name + " is some other type of node...");
		}
		return "";
	}
	
	/**
	 * Builds the Deserialization snippet per property.
	 * @param node
	 * @param parentClassName
	 * @param name
	 * @return
	 */
	public String buildGenerateDeserializePropertyString(JsonNode node, String parentClassName, String name) {
		String defName = getInterpreter().createSerializeConstantSymbolName(name);
		String variableName = getInterpreter().cleanVariableName(name);
		String className = getInterpreter().buildSubClassName(parentClassName, name);
		
		if(node.isTextual()) {
			return "object." + variableName + " = [Serializer safeGetDictString:dict withKey:" + defName + "];\n";
		} else if(node.isInt()) {
			return "object." + variableName + " = [Serializer getIntegerFromDict:dict forKey:" + defName + " orDefaultTo:0];\n";
		} else if(node.isFloatingPointNumber()) {
			return "object." + variableName + " = [Serializer getDoubleFromDict:dict forKey:" + defName + " orDefaultTo:0.0];\n";
		} else if(node.isBoolean()) {
			return "object." + variableName + " = [Serializer getBoolFromDict:dict forKey:" + defName + " orDefaultTo:NO];\n";
		} else if(node.isArray()) {
			if(JsonNodeUtils.isArrayOfObjects(node)) {
				return "object." + variableName + " = [" + className + " fromArrayOfDictionaries:[Serializer getArrayFromDict:dict forKey:" + defName + "]];\n";
			} else if(JsonNodeUtils.isArrayofArrays(node)) {
				// TODO ??
			} else {
				return "object." + variableName + " = [[NSMutableArray alloc]initWithArray:[Serializer getArrayFromDict:dict forKey:" + defName + "]];\n";
			}
		} else if(node.isObject()) {
			return "object." + variableName + " = [" + className + " fromDictionary:[dict objectForKey:" + defName + "]];\n";
		}
		return "";
	}
}
