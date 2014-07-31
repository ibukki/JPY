sap.ui.controller("ui.payroll.pages.paramConfig", {
	
	serviceUrl: "rest/params/",
	confServiceUrl: "rest/schemaconf/",
	
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
		//input parameters
		var inputTable = sap.ui.getCore().byId("tb_paramconf_input");
		var oJsonModel = inputTable.getModel();
		var oJson = oJsonModel.getData().data;
		var oinputArrToSave = [];
		for(var i = 0 ; i < oJson.length; i++){
			if(oJson[i].name){
				oinputArrToSave[oinputArrToSave.length] = oJson[i];
			}
		}
		
		//output parameters
		var outputTable = sap.ui.getCore().byId("tb_paramconf_output");
		var outJson = outputTable.getModel().getData().data;
		var ooutArrToSave = [];
		for(var i = 0; i < outJson.length; i++){
			if(outJson[i].name){
				ooutArrToSave[ooutArrToSave.length] = outJson[i];
			}
		}
		
		var schemaId = sap.ui.getCore().byId("dp_schema_id").getSelectedKey();
		var ocomJson = {input: oinputArrToSave, output: ooutArrToSave};
		var saveUrl = this.serviceUrl + "save?schemaId=" + schemaId;
		$.ajax({
	          type: 'post',
	          url: saveUrl,
	          data: JSON.stringify(ocomJson),
	          contentType: "application/json; charset=utf-8",
	          traditional: true,
	          success: function (data) {
	              callback();
	          }
	    });
		
	},
	
	createNewConfig: function(){
		var that = this;
		if(sap.ui.getCore().byId("dialog_new_schemaconf") != null){
			sap.ui.getCore().byId("dialog_new_schemaconf").destroy();
		}
		var oDialog = new sap.ui.commons.Dialog("dialog_new_schemaconf", {
			title:"Create a new schema",
			width:"500px",
			height:"200px",
			close:function(){
				this.destroy();
			},
			buttons:[new sap.ui.commons.Button({
				text:"Close",
				press:function(){
					oDialog.destroy();
				}
			}), new sap.ui.commons.Button({
				text:"Save",
				style:sap.ui.commons.ButtonStyle.Accept,
				press:function(){
					that.saveNewSchema();
					oDialog.destroy();
				}
			})]
		});
		var oMatrix = new sap.ui.commons.layout.MatrixLayout({
			width:"100%",
			widths:["30%","70%"]
		});
		var oLabel = new sap.ui.commons.Label({
			width:"100px",
			text:"Schema Name"
		});
		var oInput = new sap.ui.commons.TextField("new_schema_id",{enabled:true,
			width:"100%"});
		oMatrix.createRow(oLabel, oInput);
		oLabel = new sap.ui.commons.Label({
			width:"100px",
			text:"Description"
		});
		oInput = new sap.ui.commons.TextField("new_schema_descr",{enabled:true,
			width:"100%"});
		oMatrix.createRow(oLabel, oInput);
		oDialog.addContent(oMatrix);
		oDialog.open();
	},
	
	saveNewSchema : function(xargs){
		var schemaId = sap.ui.getCore().byId("new_schema_id").getValue();
		var description = sap.ui.getCore().byId("new_schema_descr").getValue();
		alert("to be supplied");
		
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