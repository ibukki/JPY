sap.ui.controller("ui.payroll.pages.payrollProcess", {
	
  stepConfigs : [
                {id:"step_wageType", label:"step_wageType", enabled:true, viewName:"ui.payroll.pages.wageType"},
                {id:"step_paramConfig", label:"Parameters Config", enabled:false,viewName:"ui.payroll.pages.paramConfig"},
                {id:"step_ruleConfig", label:"Rule Config", enabled:false ,viewName:"ui.payroll.pages.ruleConfig"}
               ],
               
   oViews : {},
/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.payroll.pages.payrollProcess
*/
	onInit: function() {
		if(this.stepConfigs){
			for(var i = 0 ; i < this.stepConfigs.length; i++){
				var stepConf = this.stepConfigs[i];
				this.registerStep(stepConf.id,{id:"view-"+stepConf.id, viewName:stepConf.viewName, type:sap.ui.core.mvc.ViewType.JS});
			}
			this.setStepView(this.stepConfigs[0].id);
		}
	},
	
	setStepView : function(stepId){
		var oProcContent = sap.ui.getCore().byId("py_proc_content");
		oProcContent.removeAllContent();
		oProcContent.addContent(this.getStepView(stepId));
		
		this.currentStepId = stepId;
	},
	
	steps : {},
	
	currentStepId: null,
	
	contentView: {},
	
	getStepView : function(stepId){
		if(this.oViews[stepId]){
			return this.oViews[stepId];
		}else{
			
			var view = sap.ui.view(this.steps[stepId]);
			this.oViews[stepId] = view;
			return view;
		}
	},
	
	registerStep : function(stepId, viewConfig){
		if(!this.steps[stepId]){
			this.steps[stepId] = viewConfig;
		}
	},
	saveAndNext : function(){
		var selMap = sap.ui.getCore().byId("py_process_rmap");
		//save content first
		var that = this;
		this.getStepView(this.currentStepId).getController().saveContent(function(){
			var newSel = that.naviToNextStep();
		});
	},
	
	naviToNextStep : function( ){
		var selMap = sap.ui.getCore().byId("py_process_rmap");
		//select the next step
		var selStepId = selMap.getSelectedStep();
		var newStepId = selStepId;
		var steps = selMap.getSteps();
		for(var i = 0 ; i < steps.length; i++){
			var step = steps[i];
			step.setEnabled(true);
			if(step.getId() == selStepId){
				if(i < steps.length - 1){
					newStepId = steps[i+1].getId();
				}
			}
		}
		
		//disable all the rest
		steps = selMap.getSteps();
		for(var i = 0; i < steps.length; i++){
			var step = steps[i];
			if(step.getId() != newStepId){
				step.setEnabled(false);
			}
		}
		selMap.setSelectedStep(newStepId);
		
		this.setStepView(newStepId);
		return selStepId; 
	},
	
	naviToPreviousStep : function(){
		var selMap = sap.ui.getCore().byId("py_process_rmap");
		//select the next step
		var selStepId = selMap.getSelectedStep();
		var newStepId = selStepId;
		var steps = selMap.getSteps();
		for(var i = 0 ; i < steps.length; i++){
			var step = steps[i];
			step.setEnabled(true);
			if(step.getId() == selStepId){
				if(i > 0){
					newStepId = steps[i-1].getId();
				}
			}
		}
		
		//disable all the rest
		steps = selMap.getSteps();
		for(var i = 0; i < steps.length; i++){
			var step = steps[i];
			if(step.getId() != newStepId){
				step.setEnabled(false);
			}
		}
		selMap.setSelectedStep(newStepId);
		
		this.setStepView(newStepId);
		return selStepId; 
	},

	nextWithoutSave : function(){
		
	}
/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf ui.payroll.pages.payrollProcess
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf ui.payroll.pages.payrollProcess
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf ui.payroll.pages.payrollProcess
*/
//	onExit: function() {
//
//	}

});