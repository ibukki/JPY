sap.ui.jsview("ui.payroll.pages.payrollProcess", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf ui.payroll.pages.payrollProcess
	*/ 
	getControllerName : function() {
		return "ui.payroll.pages.payrollProcess";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf ui.payroll.pages.payrollProcess
	*/ 
	createContent : function(oController) {
		
		var oMatrix = new sap.ui.commons.layout.MatrixLayout("mx_py_process",{
			columns: 1
		});
		
		var oRMap = new sap.ui.commons.RoadMap("py_process",{
			width:"800px",
			height: "200px"
		});
		
		//create the RoadMap steps
		var oStep1 = new sap.ui.commons.RoadMapStep("step1", {label: "Define Wage Types"});
		var oStep2 = new sap.ui.commons.RoadMapStep("step2", {label: "Step 2", enabled: false});
		var oStep3 = new sap.ui.commons.RoadMapStep("step3", {label: "Step 3", enabled: false});
		var oStep4 = new sap.ui.commons.RoadMapStep("step4", {label: "Step 4", enabled: false});
		
		//add steps to the RoadMap
		oRMap.addStep(oStep1);
		oRMap.addStep(oStep2);
		oRMap.addStep(oStep3);
		oRMap.addStep(oStep4);
		
		//Set the first step as selected
		oRMap.setSelectedStep("step1");

		//Set the number of visible steps
		oRMap.setNumberOfVisibleSteps(5);
		
		oMatrix.createRow(oRMap);
		
		var oStepContentMatrix = new sap.ui.commons.layout.MatrixLayout("mx_py_pro_content",{
			height: "500px"
		});
		
		var oStep1view = sap.ui.view({id:"wageType1", viewName:"ui.payroll.pages.wageType", type:sap.ui.core.mvc.ViewType.JS});
		oStepContentMatrix.createRow(oStep1view);
		
		oMatrix.createRow(oStepContentMatrix);
		return oMatrix;
		
		
	}

});
