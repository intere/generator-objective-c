/**
 * ${filename}
 *
 * Generated by JSON Model Generator v${version} on ${date?date}
 * https://github.com/intere/generator-json-models
 *
 * The generator tool is licensed under the LGPL: http://www.gnu.org/licenses/lgpl-3.0.html#content
 */

#import <XCTest/XCTest.h>
#import "Serializer.h"
#import "${model.className}.h"

@interface ${model.testClassName} : XCTestCase
	// TODO: Any properties your tests might need
@end

@implementation ${model.testClassName}

    - (void)setUp {
    	[super setUp];
    	// Put setup code here. This method is called before the invocation of each test method in the class.
    }

    - (void)tearDown {
    	// Put teardown code here. This method is called after the invocation of each test method in the class.
    	[super tearDown];
    }

    <#list properties as property>
        <#switch property.dataType>
        <#case "CLASS">
        /**
         * Tests the "Happy Path" Serialization / Deserialization of the ${model.className} property
         */
        -(void) test${property.methodName}HappyPath {
            NSString *json = [NSString stringWithFormat:@"{\"${property.name}\": {}}"];
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertNotNil(model.${property.alias});
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${model.className} property
         */
        -(void) test${property.methodName}WithNil {
            NSString *json=@"{}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertNil(model.${property.alias});
        }

        /**
         * Tests Serialization / Deserialization (with empty string) of the ${model.className} property
         */
        -(void) test${property.methodName}WithEmptyString {
            NSString *json=@"{\"${model.className}\":\"\"}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertNil(model.${property.alias});
        }
        <#break>
        <#case "DATE">
        /**
         * Tests the "Happy Path" Serialization / Deserialization of the ${property.name} property
         */
        -(void) test${property.methodName}HappyPath {
            NSDate *date = [[NSDate alloc]init];
            NSString *json = [NSString stringWithFormat:@"{\"${property.name}\":\"%@\"}", [Serializer formatDateToIsoString:date]];
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertEqualWithAccuracy([Serializer dateToStandardTimeInterval:model.${property.alias}], [Serializer dateToStandardTimeInterval:date], 1);
        }

        /**
         * Tests Serialization / Deserialization (with a Zulu Date String) of the ${property.name} property
         */
        -(void) test${property.methodName}WithZuluDate {
            NSDate *date = [[NSDate alloc]init];
            NSString *json = [NSString stringWithFormat:@"{\"${property.name}\":\"%@\"}", [Serializer formatDateToZuluString:date]];
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertEqualWithAccuracy([Serializer dateToStandardTimeInterval:model.${property.alias}], [Serializer dateToStandardTimeInterval:date], 1);
        }

        /**
         * Tests Serialization / Deserialization (Seconds Since the Epoch) of the ${property.name} property
         */
        -(void) test${property.methodName}WithLongDate {
            NSDate *date = [[NSDate alloc]init];
            NSString *json = [NSString stringWithFormat:@"{\"${property.name}\":%f}", [Serializer dateToStandardTimeInterval:date]];
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertEqualWithAccuracy([Serializer dateToStandardTimeInterval:model.${property.alias}], [Serializer dateToStandardTimeInterval:date], 1);
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${property.name} property
         */
        -(void) test${property.methodName}WithNil {
            NSString *json=@"{}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertNil(model.${property.alias});
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${property.name} property
         */
        -(void) test${property.methodName}WithEmptyString {
        	NSString *json=@"{\"${property.name}\":\"\"}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertNil(model.${property.alias});
        }
        <#break>
        <#case "STRING">
        <#case "TEXT">
        <#case "IMAGE">
        <#assign data=generator.data(property)>
        /**
         * Tests the "Happy Path" Serialization / Deserialization of the ${property.name} property
         */
        -(void) test${property.methodName}HappyPath {
            NSString *expected = @${data};
        	NSString *json=[NSString stringWithFormat:@"{\"${property.name}\":\"%@\"}", expected];
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertEqualObjects(model.${property.alias}, expected);
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${property.name} property
         */
        -(void) test${property.methodName}WithNil {
        	// Test with nil
        	NSString *json=@"{}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertNil(model.${property.alias});
        }

        /**
         * Tests Serialization / Deserialization (with empty string) of the ${property.name} property
         */
        -(void) test${property.methodName}WithEmptyString {
        	NSString *json=@"{\"${property.name}\":\"\"}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertEqualObjects(model.${property.alias}, @"");
        }
        <#break>
        <#case "LONG">
        <#assign data=generator.data(property)>
        /**
         * Tests the "Happy Path" Serialization / Deserialization of the ${model.className} property
         */
        -(void) test${property.methodName}HappyPath {
        	NSInteger value = ${data};
        	NSString *json = [NSString stringWithFormat:@"{\"${property.name}\":\"%ld\"}", (long)value];
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertEqual(model.${property.alias}, value);
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${model.className} property
         */
        -(void) test${property.methodName}WithNil {
        	NSString *json=@"{}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertEqual(model.${property.alias}, 0);
        }

        /**
         * Tests Serialization / Deserialization (with empty string) of the ${model.className} property
         */
        -(void) test${property.methodName}WithEmptyString {
        	NSString *json=@"{\"${model.className}\":\"\"}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertEqual(model.${property.alias}, 0);
        }
        <#break>
        <#case "BOOL">
        /**
         * Tests the "true" Serialization / Deserialization of the ${model.className} property
         */
        -(void) test${property.methodName}True {
        	NSString *json=@"{\"${model.className}\":true}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertTrue(model.${property.alias});
        }

        /**
         * Tests the "false" Serialization / Deserialization of the ${model.className} property
         */
        -(void) test${property.methodName}False {
        	NSString *json=@"{\"${model.className}\":false}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertFalse(model.${property.alias});
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${model.className} property
         */
        -(void) test${property.methodName}WithNil {
        	NSString *json=@"{}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertFalse(model.${property.alias});
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${model.className} property
         */
        -(void) test${property.methodName}WithEmptyString {
        	NSString *json=@"{\"${model.className}\":\"\"}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertFalse(model.${property.alias});
        }
        <#break>
        <#case "ARRAY">
          <#switch property.arraySubTypeProperty.dataType>
          <#case "CLASS">
          <#assign data1=generator.data(property.arraySubTypeProperty, true)>
          <#assign data2=generator.data(property.arraySubTypeProperty, true)>
          <#assign data3=generator.data(property.arraySubTypeProperty, true)>

          /**
           * Tests the "Happy Path" Serialization / Deserialization of the ${property.name} property
           */
          -(void) test${property.methodName}ArrayHappyPath {
          	NSString *json = @"{\"${property.name}\":[ {}, {}, {} ]}";
          	${model.className} *model = [${model.className} fromJsonString:json];
          	XCTAssertNotNil(model.${property.alias});
          	XCTAssertEqual(model.${property.alias}.count, 3);
          }

          /**
           * Tests Serialization / Deserialization (with nil) of the ${property.name} property
           */
          -(void) test${property.methodName}WithNil {
          	NSString *json=@"{}";
          	${model.className} *model = [${model.className} fromJsonString:json];
          	XCTAssertNotNil(model.${property.alias});
          }
          <#break>
          <#case "ARRAY">
          /**
           * Tests the "Happy Path" Serialization / Deserialization of the ${property.name} property
           */
          -(void) test${property.methodName}ArrayHappyPath {
            NSString *json = @"{\"${property.name}\":[ [{}], [{}], [{}] ]}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertNotNil(model.${property.alias});
            XCTAssertEqual(model.${property.alias}.count, 3);
          }

          /**
           * Tests Serialization / Deserialization (with nil) of the ${property.name} property
           */
          -(void) test${property.methodName}ArrayWithNil {
            NSString *json=@"{}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertNotNil(model.${property.alias});
          }
          <#break>
          <#default>
          <#assign data1=generator.data(property.arraySubTypeProperty, true) >
          <#assign data2=generator.data(property.arraySubTypeProperty, true) >
          <#assign data3=generator.data(property.arraySubTypeProperty, true) >
        /**
         * Tests the "Happy Path" Serialization / Deserialization of the ${property.name} property
         */
        -(void) test${property.methodName}HappyPath {
        	NSString *json = @"{\"${property.name}\":[${data1}, ${data2}, ${data3}]}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertNotNil(model.${property.alias});
        	XCTAssertEqual(model.${property.alias}.count, 3);
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${property.name} property
         */
        -(void) test${property.methodName}WithNil {
        	NSString *json=@"{}";
        	${model.className} *model = [${model.className} fromJsonString:json];
        	XCTAssertNotNil(model.${property.alias});
        }
          <#break>
          </#switch>
        <#break>
        <#default>
        <#assign data=generator.data(property)>
        /**
         * Tests the "Happy Path" Serialization / Deserialization of the ${property.name} property
         */
        -(void) test${property.methodName}HappyPath {
            double value = ${data};
            NSString *json = [NSString stringWithFormat:@"{\"${property.name}\":\"%f\"}", value];
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertEqualWithAccuracy(model.${property.alias}, value, 0.00001);
        }

        /**
         * Tests Serialization / Deserialization (with nil) of the ${property.name} property
         */
        -(void) test${property.methodName}WithNil {
            NSString *json=@"{}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertEqualWithAccuracy(model.${property.alias}, 0.0, 0.00001);
        }

        /**
         * Tests Serialization / Deserialization (with empty string) of the ${property.name} property
         */
        -(void) test${property.methodName}WithEmptyString {
            NSString *json=@"{\"${property.name}\":\"\"}";
            ${model.className} *model = [${model.className} fromJsonString:json];
            XCTAssertEqualWithAccuracy(model.${property.alias}, 0.0, 0.00001);
        }
        <#break>
        </#switch>
    </#list>

@end