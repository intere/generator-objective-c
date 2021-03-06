package com.intere.generator.builder.orchestration.language.utility;

import com.intere.generator.builder.orchestration.OrchestrationTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service(value="ObjectiveCLanguage")
public class ObjectiveCLanguageUtility extends AbstractLanguageUtility {
	@Autowired @Qualifier("ObjectiveCViewBuilder")
	ViewBuilder viewBuilder;
	
	@Autowired @Qualifier("ObjectiveCServiceBuilder")
	ServiceBuilder serviceBuilder;
	
	@Autowired @Qualifier("ObjectiveCSingleViewControllerBuilder")
	SingleViewControllerBuilder singleViewControlerBuilder;
	
	@Autowired @Qualifier("ObjectiveCListViewControllerGenerator")
	ListViewControllerBuilder listViewControllerBuilder;

	@Override
	public ViewBuilder getViewBuilder() {
		return viewBuilder;
	}
	
	@Override
	public ServiceBuilder getServiceBuilder() {
		return serviceBuilder;
	}
	
	@Override
	public SingleViewControllerBuilder getSingleViewControllerBuilder() {
		return singleViewControlerBuilder;
	}
	
	@Override
	public ListViewControllerBuilder getListViewControllerBuilder() {
		return listViewControllerBuilder;
	}
	
	@Override
	public Map<File, String> copyModelResources(File sourcePath, OrchestrationTree tree) throws IOException {
		Map<File, String> resources = new HashMap<>();
		resources.put(new File(sourcePath, "Serializer.h"), readResource("/Serializer.h"));
		resources.put(new File(sourcePath, "Serializer.m"), readResourceAndReplaceHeaders("/Serializer.m"));
//		resources.put(new File(sourcePath, "Log.h"), readResourceAndReplaceHeaders("/Log.h"));
		return resources;
	}

	@Override
	public Map<File, String> copyViewResources(File viewPath, OrchestrationTree tree) throws IOException {
		Map<File, String> resources = new HashMap<>();
		resources.put(new File(viewPath, "UIHelper.h"), readResource("/UIHelper.h"));
		resources.put(new File(viewPath, "UIHelper.m"), readResourceAndReplaceHeaders("/UIHelper.m"));
		resources.put(new File(viewPath, "UITheme.h"), readResource("/UITheme.h"));
		resources.put(new File(viewPath, "UITheme.m"), readResourceAndReplaceHeaders("/UITheme.m"));
		return resources;
	}
	
	@Override
	public void enforceFilenames(OrchestrationTree tree) {
		// No-Op for Objective C		
	}
	
	@Override
	public Map<String, String> getPropertyMappings() {
		Map<String, String> mappings = new HashMap<>();
		mappings.put("id", "theId");
		mappings.put("description", "theDescription");
		return mappings;
	}
}

