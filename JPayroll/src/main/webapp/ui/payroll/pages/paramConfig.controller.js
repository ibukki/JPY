sap.ui.controller("ui.payroll.pages.paramConfig", {
	
	serviceUrl: "rest/params/",
	
/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.payroll.pages.paramConfig
*/
	onInit: function() {
		
	},
	
	loadConfiguredParams : function(){
		var schemaId = sap.ui.getCore().byId("i_schema_id").getValue();
		if(schemaId == ""){
			alert("Please input schemaId");
		}
		//loadInputParams;
		this.loadInputConfParams(schemaId);
		this.loadoutputConfParams(schemaId);
	},
	
	loadInputConfParams:function(schemaId){
		var url = this.serviceUrl + "input?schemaId=" + schemaId;
		$.get(url,function(data){
			if(data){
				var oJson = {data:data};
				var oJsonModel = new sap.ui.model.json.JSONModel();
				oJsonModel.setData(oJson);
				var inputTable = sap.ui.getCore().byId("tb_paramconf_input");
				inputTable.setModel(oJsonModel);
				inputTable.bindRows("/data");
			}
			
		});
		
	},
	loadoutputConfParams:function(schemaId){
		var url = this.serviceUrl + "output?schemaId=" + schemaId;
		$.get(url,function(data){
			if(data){
				var oJson = {data:data};
				var oJsonModel = new sap.ui.model.json.JSONModel();
				oJsonModel.setData(oJson);
				var inputTable = sap.ui.getCore().byId("tb_paramconf_output");
				inputTable.setModel(oJsonModel);
				inputTable.bindRows("/data");
			}
		});
	},
	saveContent : function(callback){
		callback();
	},
	
	addInputParam : function(){
		var inputTable = sap.ui.getCore().byId("tb_paramconf_input");
		var oJsonModel = inputTable.getModel();
		var oJson = oJsonModel().getData().data;
		
	}
/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf ui.payroll.pages.paramConfig
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf ui.payroll.pages.paramConfig
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf ui.payroll.pages.paramConfig
*/
//	onExit: function() {
//
//	}

});