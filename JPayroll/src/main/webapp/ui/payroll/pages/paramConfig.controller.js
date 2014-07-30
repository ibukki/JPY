sap.ui.controller("ui.payroll.pages.paramConfig", {
	
	serviceUrl: "rest/params/",
	confServiceUrl: "rest/schema/",
	
/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.payroll.pages.paramConfig
*/
	onInit: function() {
		this.loadConfigList();
	},
	
	loadConfigList : function(){
		var url = this.confServiceUrl + "list";
		var that = this;
		$.get(url, function(data){
			if(data){
				var itemData = [];
				for(var i = 0 ; i< data.length; i++){
					itemData[itemData.length] = {text:data[i]};
				}
				var oListItemTemplate = new sap.ui.core.ListItem({
					key:"{text}",
					text:"{text}"
				});
				var listDp = sap.ui.getCore().byId("dp_schema_id");
				var oJsonModel = new sap.ui.model.json.JSONModel();
				oJsonModel.setData({data:itemData});
				listDp.setModel(oJsonModel);
				listDp.bindItems("/data", oListItemTemplate);
				
				that.loadInputConfParams(data[0]);
				that.loadoutputConfParams(data[0]);
			}
		});
	},
	loadConfiguredParams : function(){
		var schemaId = sap.ui.getCore().byId("dp_schema_id").getSelectedKey();
		if(schemaId == ""){
			alert("Please input schemaId");
		}
		//loadInputParams;
		this.loadInputConfParams(schemaId);
		this.loadoutputConfParams(schemaId);
	},
	
	changeSchemaId : function(){
		this.loadConfiguredParams();
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
		//save input parameter
		var inputTable = sap.ui.getCore().byId("tb_paramconf_input");
		var oJsonModel = inputTable.getModel();
		var oJson = oJsonModel.getData().data;
		var oArrToSave = [];
		for(var i = 0 ; i < oJson.length; i++){
			if(!oJson[i].name){
				oArrToSave[oArrToSave.length] = oJson[i];
			}
		}
		
		
		callback();
	},
	
	createNewConfig: function(){
		
	},
	
	addInputParam : function(){
		var inputTable = sap.ui.getCore().byId("tb_paramconf_input");
		var oJsonModel = inputTable.getModel();
		var oJson = oJsonModel.getData().data;
		oJson.push({});
		oJsonModel.setData({data:oJson});
		inputTable.setModel(oJsonModel);
	},
	
	addOutputParam :function(){
		var outputTable = sap.ui.getCore().byId("tb_paramconf_output");
		var oJsonModel = outputTable.getModel();
		var oJson = oJsonModel.getData().data;
		oJson.push({});
		oJsonModel.setData({data:oJson});
		outputTable.setModel(oJsonModel);
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