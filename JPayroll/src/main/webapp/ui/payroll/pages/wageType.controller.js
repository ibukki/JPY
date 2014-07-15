sap.ui.controller("ui.payroll.pages.wageType", {
	
	serviceUrl :"rest/wagetypes/",

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.payroll.pages.wageType
*/
	onInit: function() {
		$.get(this.serviceUrl + "list", function(data){
			var jsonData = {data:data};
			var jsonModel = new sap.ui.model.json.JSONModel();
			jsonModel.setData(jsonData);
			
			var oTable = sap.ui.getCore().byId("tb_wagetype");
			oTable.setModel(jsonModel);
			oTable.bindRows("/data");
		});
	},
	
	addWagetype :function(){
		var oTable = sap.ui.getCore().byId("tb_wagetype");
		var oJson = oTable.getModel().getData().data;
		oJson.push({});
		oTable.getModel().setData({data:oJson});
	},
		
	DeleteWageType:function(){
		
	},
	
	saveContent : function(callback){
		var oTable = sap.ui.getCore().byId("tb_wagetype");
		var oJson = oTable.getModel().getData().data;
		$.ajax({
          type: 'post',
          url: this.serviceUrl + "save",
          data: JSON.stringify(oJson),
          contentType: "application/json; charset=utf-8",
          traditional: true,
          success: function (data) {
              callback();
          }
    });
	}
/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf ui.payroll.pages.wageType
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf ui.payroll.pages.wageType
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf ui.payroll.pages.wageType
*/
//	onExit: function() {
//
//	}

});