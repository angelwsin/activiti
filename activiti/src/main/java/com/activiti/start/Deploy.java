package com.activiti.start;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

public class Deploy {
    
    
    public static void main(String[] args) {
          ProcessEngine processEngine  = ProcessEngines.getProcessEngine("startProcess");
          
          //流程配置文件的 服务 RepositoryService
          RepositoryService repositoryService = processEngine.getRepositoryService();
          
          
          repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
          //流程运行时 的服务
          RuntimeService runtimeService = processEngine.getRuntimeService();
          
          Map<String, Object> variableMap = new HashMap<String, Object>();
          variableMap.put("name", "Activiti");
          // RuntimeService 启动流程实例
          ProcessInstance processInstance =  runtimeService.startProcessInstanceByKey("myProcess", variableMap);
          
        
          //user 信息的服务
          IdentityService identityService =  processEngine.getIdentityService();
          
         
          
    }

}
