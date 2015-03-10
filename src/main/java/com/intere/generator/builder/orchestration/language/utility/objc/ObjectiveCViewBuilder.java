package com.intere.generator.builder.orchestration.language.utility.objc;

import static com.intere.generator.deserializer.JsonNodeUtils.isBoolean;
import static com.intere.generator.deserializer.JsonNodeUtils.isDate;
import static com.intere.generator.deserializer.JsonNodeUtils.isFloat;
import static com.intere.generator.deserializer.JsonNodeUtils.isImage;
import static com.intere.generator.deserializer.JsonNodeUtils.isInteger;
import static com.intere.generator.deserializer.JsonNodeUtils.isLong;
import static com.intere.generator.deserializer.JsonNodeUtils.isText;

import com.intere.generator.builder.interpreter.JsonLanguageInterpreter;
import com.intere.generator.builder.interpreter.models.ObjectiveCModelInterpreter;
import com.intere.generator.builder.orchestration.OrchestrationDataType;
import com.intere.generator.builder.orchestration.language.utility.LanguageUtility.CommentBuilder;
import com.intere.generator.builder.orchestration.language.utility.base.BaseViewBuilder;
import com.intere.generator.builder.orchestration.language.utility.comments.CStyleCommentBuilder;
import com.intere.generator.metadata.ModelClass;
import com.intere.generator.metadata.ModelClassProperty;


public class ObjectiveCViewBuilder extends BaseViewBuilder {
	protected CommentBuilder commentBuilder = new CStyleCommentBuilder();
	protected JsonLanguageInterpreter interpreter = new ObjectiveCModelInterpreter();

	@Override
	public String buildNamespace(ModelClass modelClass) {
		return "";
	}

	@Override
	public String buildHeaderFileComment(ModelClass modelClass) {
		return buildFileComment(modelClass.getViewClassName() + ".h");
	}

	@Override
	public String buildImplementationFileComment(ModelClass modelClass) {
		return buildFileComment(modelClass.getViewClassName() + ".m");
	}

	@Override
	public String buildImports(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		builder.append("#import <UIKit/UIKit.h>\n");
		builder.append("#import \"" + modelClass.getClassName() + ".h\"\n");
		
		builder.append("\n");
		return builder.toString();
	}

	@Override
	public String buildSerializationConstants(ModelClass modelClass) {
		return null;
	}

	@Override
	public String buildClassImplementation(ModelClass modelClass) {
		String instanceName = getInterpreter().cleanVariableName(modelClass.getClassName());
		StringBuilder builder = new StringBuilder();
		builder.append("#import \"" + modelClass.getViewClassName() + ".h\"\n\n");
		builder.append("#import \"UITheme.h\"\n");
		builder.append("#import \"UIHelper.h\"\n\n");
		
		// "Private" Interface Methods
		builder.append(buildPrivateInterface(modelClass));
		
		builder.append("@implementation " + modelClass.getViewClassName() + "\n");
		builder.append("-(void)set" + modelClass.getClassName() + ":(" + modelClass.getClassName() + " *)model {\n");
		builder.append(tabs(1) + "self." + instanceName + " = model;\n");
		builder.append(tabs(1) + "[self updateValues];\n");
		builder.append("}\n\n");
		
		builder.append(updateView(modelClass));
		builder.append(buildView(modelClass));
		builder.append("#warning: Still more todo for the implementation\n");
		return builder.toString();
	}

	@Override
	public String buildModelUtilityDeclarationMethods(ModelClass modelClass) {
		// TODO
		return "";
	}

	@Override
	public String buildModelUtilityDefinitionMethods(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		builder.append("#pragma mark Private Methods\n");
		builder.append("-(void)configureAndAddPropertyLabel:(UILabel *)propertyLabel {\n");
		builder.append("[UITheme configurePropertyLabel:propertyLabel];\n");
		builder.append("\t[self addSubview:propertyLabel];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)configureAndAddDatePicker:(UIDatePicker *)datePicker {\n");
		builder.append("[UITheme configureDatePicker:datePicker];\n");
		builder.append("\t[self addSubview:datePicker];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)configureAndAddTextView:(UITextView *)textView {\n");
		builder.append("\t[UITheme configureTextView:textView];\n");
		builder.append("\t[self addSubview:textView];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)configureAndAddTextField:(UITextField *)textField {\n");
		builder.append("\t[UITheme configureTextField:textField];\n");
		builder.append("\t[self addSubview:textField];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)configureAndAddButton:(UIButton *)button {\n");
		builder.append("\t[UITheme configureButton:button];\n");
		builder.append("\t[self addSubview:button];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)configureAndAddSwitch:(UISwitch *)toggleSwitch {\n");
		builder.append("\t[UITheme configureSwitch:toggleSwitch];\n");
		builder.append("\t[self addSubview:toggleSwitch];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)configureAndAddImageView:(UIImageView *)imageView {\n");
		builder.append("\t[UITheme configureImageView:imageView];\n");
		builder.append("\t[self addSubview:imageView];\n");
		builder.append("}\n\n");
		
		builder.append("-(void)buttonPressed:(UIButton *)button {\n");
		builder.append("#warning NOT YET IMPLEMENTED\n");
		builder.append("}\n\n");
		
		return builder.toString();
	}

	@Override
	public String buildClassDeclaration(ModelClass modelClass) {
		String instanceName = getInterpreter().cleanVariableName(modelClass.getClassName());
		StringBuilder builder = new StringBuilder();
		builder.append("@interface " + modelClass.getViewClassName() + " : UIView\n");
		builder.append("@property (nonatomic, setter=set" + modelClass.getClassName() + ":) " + modelClass.getClassName() + " *" + instanceName + ";\n\n");
		
		builder.append(multiLineComment("Sets the " + modelClass.getClassName() + " object for this view to render") + "\n");
		builder.append("-(void)set" + modelClass.getClassName() + ":(" + modelClass.getClassName() + " *)model;\n\n");
		return builder.toString();
	}

	@Override
	public String finishClass(ModelClass modelClass) {
		return "@end" + singleLineComment("End of " + modelClass.getViewClassName() + " Class", 3);
	}

	@Override
	public String buildSinglePropertyDeclaration(ModelClassProperty property) {
		return null;
	}

	@Override
	public String buildGetterAndSetter(ModelClassProperty prop) {
		// TODO
		return "";
	}

	@Override
	public String getPropertyType(ModelClassProperty property) {
		return null;
	}

	@Override
	public CommentBuilder getCommentBuilder() {
		return commentBuilder;
	}

	@Override
	public JsonLanguageInterpreter getInterpreter() {
		return interpreter;
	}
	
	private String updateView(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		String modelInstanceName = "self." + getInterpreter().cleanVariableName(modelClass.getClassName());
		builder.append("-(void)updateValues {\n");
		for(ModelClassProperty prop : modelClass.getProperty()) {
			String propertyName = interpreter.cleanVariableName(prop.getName());
			switch(prop.getDataType()) {
			case IMAGE:
				builder.append("\t[UIHelper loadImageInBackground:" + propertyName + " fromUrl:" + modelInstanceName + "." + propertyName + "];\n");
				break;
			case DATE:
				builder.append("\t[self->" + propertyName + " setDate:" + modelInstanceName + "." + propertyName + "];\n");
				break;
			case STRING:
			case TEXT:
				builder.append("\t[self->" + propertyName + " setText:" + modelInstanceName + "." + propertyName + "];\n");
				break;
			case LONG:
				builder.append("\t[self->" + propertyName + " setText:[NSString stringWithFormat:@\"%li\", (NSInteger)" + modelInstanceName + "." + propertyName + "]];\n");
				break;
			case BOOLEAN:
				builder.append("\t[self->" + propertyName + " setSelected:" + modelInstanceName + "." + propertyName + "];\n");
				break;
			case DOUBLE:
				builder.append("\t[self->" + propertyName + " setText:[NSString stringWithFormat:@\"%1.2f\", " + modelInstanceName + "." + propertyName + "]];\n");
				break;
			default:
				// Do Nothing
				break;
			}
		}
		builder.append("}\n\n");
		
		return builder.toString();
	}
	
	private String buildView(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		builder.append("-(void)buildView {\n");
		if(hasDate(modelClass)) {
			builder.append(tabs(1) + "dateFormatter = [[NSDateFormatter alloc] init];\n");
			builder.append(tabs(1) + "[dateFormatter setDateStyle:NSDateFormatterMediumStyle];\n");
		}
		
		builder.append(buildViewControls(modelClass));
		
		builder.append(tabs(1) + "frame = CGRectMake(0.0, 0.0, self.frame.size.width, y + height + 40.0);\n"); 
		builder.append(tabs(1) + "[self setFrame:frame];\n");
		builder.append("}\n\n");

		return builder.toString();
	}
	
	private String buildViewControls(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for(ModelClassProperty prop : modelClass.getProperty()) {
			String propertyName = getInterpreter().cleanVariableName(prop.getName());
			String controlType = prop.getDataType().getObjectiveCViewClass();
			String controlHeight = getHeightForControl(controlType, prop.getValue());
			String humanReadableName = getInterpreter().humanReadableName(prop.getName());
			
			builder.append(singleLineComment(humanReadableName + " info", 1) + "\n");
			if(first) {
				first = false;
				builder.append(tabs(1) + "double x=10.0, y=5.0, width=self.frame.size.width - 20.0, height = 30.0;\n");
				builder.append(tabs(1) + "CGRect frame = CGRectMake(x, y, width, height);\n");
				builder.append(tabs(1) + "UILabel *propertyLabel = [[UILabel alloc]initWithFrame:frame];\n");
			} else {
				builder.append(tabs(1) + "x=10.0, y += height + 20.0, height = 30.0;\n");
				builder.append(tabs(1) + "frame = CGRectMake(x, y, width, height);\n");
				builder.append(tabs(1) + "propertyLabel = [[UILabel alloc]initWithFrame:frame];\n");
			}
			
			builder.append(tabs(1) + "[propertyLabel setText:@\"" + humanReadableName + "\"];\n");
			builder.append(tabs(1) + "[self configureAndAddPropertyLabel:propertyLabel];\n");
			int x = 10;
			if("UIDatePicker".equals(controlType)) {
				x = 0;
			}
			builder.append(tabs(1) + "x = " + x + ".0,y += height + 10.0, height = " + controlHeight + ";\n");
			builder.append(tabs(1) + "frame = CGRectMake(x, y, width, height);\n");
			
			if("UIButton".equals(controlType)) {
				builder.append(tabs(1) + "" + propertyName + " = [UITheme createUIButtonWithFrame:frame andText:@\"Manage " + humanReadableName + "\"];\n");
				builder.append(tabs(1) + "[" + propertyName + " addTarget:self action:@selector(buttonPressed:) " + 
						"forControlEvents:UIControlEventTouchUpInside];\n");
			} else {
				builder.append(tabs(1) + "" + propertyName + " = [[" + controlType + " alloc]initWithFrame:frame];\n");
			}
			builder.append(tabs(1) + "[self configureAndAdd" + controlType.replace("UI", "") + ":" + propertyName + "];\n\n");
		}
		
		return builder.toString();
	}
	
	private String getHeightForControl(String control, String value) {
		if(null != control) {
			switch(control) {
			case "UITextView":
				return "130.0";
			case "UITextField":
				return "30.0";
			case "UISwitch":
				return "32.0";
			case "UIDatePicker":
				return "200.0";
			case "UIButton":
				return "30.0";
			case "UIImageView":
				return getImageHeight(value);
			}
		}
		return "20";
	}
	
	private String getImageHeight(String value) {
		if(null != value) {
			if(value.startsWith("image16x9")) {
				return "(width * 9.0 / 16.0)";
			} else if(value.startsWith("image4x3")) {
				return "(width * 3.0 / 4.0)";
			}
		}
		return "100";
	}

	private String buildPrivateInterface(ModelClass modelClass) {
		StringBuilder builder = new StringBuilder();
		builder.append("@interface " + modelClass.getViewClassName() + "() {\n");
		if(hasDate(modelClass)) {
			builder.append(tabs(1) + "NSDateFormatter *dateFormatter;\n");
		}
		for(ModelClassProperty prop : modelClass.getProperty()) {
			if(!prop.getIsTransient()) {
				builder.append(tabs(1) + prop.getDataType().getObjectiveCViewClass() + " *" + interpreter.cleanVariableName(prop.getName()) + ";\n"); 
			}
		}
		
		builder.append("}\n\n");
		builder.append("-(void)buildView;\n");
		builder.append("-(void)updateValues;\n");
		builder.append("-(void)configureAndAddPropertyLabel:(UILabel *)propertyLabel;\n");
		builder.append("-(void)configureAndAddDatePicker:(UIDatePicker *)datePicker;\n");
		builder.append("-(void)configureAndAddTextView:(UITextView *)textView;\n");
		builder.append("-(void)configureAndAddTextField:(UITextField *)textField;\n");
		builder.append("-(void)configureAndAddButton:(UIButton *)button;\n");
		builder.append("-(void)configureAndAddSwitch:(UISwitch *)toggleSwitch;\n");
		builder.append("-(void)configureAndAddImageView:(UIImageView *)imageView;\n");
		builder.append("-(void)buttonPressed:(UIButton *)button;\n");
		builder.append("@end" + singleLineComment("End of Interface Extension", 3) + "\n\n");
		
		return builder.toString();
	}	
	
	private boolean hasDate(ModelClass modelClass) {
		for(ModelClassProperty prop : modelClass.getProperty()) {
			if(prop.getDataType()==OrchestrationDataType.DATE) {
				return true;
			}
		}
		return false;
	}
}
