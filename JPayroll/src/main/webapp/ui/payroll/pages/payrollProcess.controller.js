sap.ui.controller("ui.payroll.pages.payrollProcess", {
	
/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.payroll.pages.payrollProcess
*/
	onInit: function() {
		
	},
	
	contentView: null,
	
	setContentView: function(view){
		this.contentView = view;
	},
	
	saveAndNext : function(){
		var selMap = sap.ui.getCore().byId("py_process_rmap");
		var selStepId = selMap.getSelectedStep();
		var eventBus = sap.ui.getCore().getEventBus();
		//save content first
		var that = this;
		this.contentView.getController().saveContent(function(){
			var nextStep = that.getNextStep();
			console.debug(nextStep);
			if(nextStep != "LAST_ONE"){
				selMap.setSelectedStep(nextStep.getId());
			}
		});
	},
	
	getNextStep : function(currentStep){
		var selMap = sap.ui.getCore().byId("py_process_rmap");
		var selStepId = selMap.getSelectedStep();
		var steps = selMap.getSteps();
		for(var i = 0 ; i < steps.length; i++){
			var step = steps[i];
			var stepId = step.getId();
			if(stepId == selStepId){
				if(i < steps.length - 1){
					return steps[i+1];
				}
			}
		}
		return "LAST_ONE"; 
	},
	
	getContentView : function(stepId){
	
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