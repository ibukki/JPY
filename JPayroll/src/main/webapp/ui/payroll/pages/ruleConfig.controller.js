sap.ui.controller("ui.payroll.pages.ruleConfig", {

/**
* Called when a controller is instantiated and its View controls (if available) are already created.
* Can be used to modify the View before it is displayed, to bind event handlers and do other one-time initialization.
* @memberOf ui.payroll.pages.ruleConfig
*/
//	onInit: function() {
//
//	},
	
	saveContent : function(callback){
		callback();
	},
	
	addFormulaLine : function(){
		var oRR = sap.ui.getCore().byId("rule_editor");
		this.showAddFormulaDialog();
	},
	
	showAddFormulaDialog : function(){
		var oDialog = new sap.ui.commons.Dialog("dialog_edit_formula", {
			title:"Add formula",
			width:"500px",
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
					
					oDialog.destroy();
				}
			})]
		});
		var oMatrix = new sap.ui.commons.layout.MatrixLayout({
			width:"100%"
		});
		oMatrix.createRow(new sap.ui.commons.TextField({enabled:true,
														width:"100%"}));
		oDialog.addContent(oMatrix);
		oDialog.open();
	}
/**
* Similar to onAfterRendering, but this hook is invoked before the controller's View is re-rendered
* (NOT before the first rendering! onInit() is used for that one!).
* @memberOf ui.payroll.pages.ruleConfig
*/
//	onBeforeRendering: function() {
//
//	},

/**
* Called when the View has been rendered (so its HTML is part of the document). Post-rendering manipulations of the HTML could be done here.
* This hook is the same one that SAPUI5 controls get after being rendered.
* @memberOf ui.payroll.pages.ruleConfig
*/
//	onAfterRendering: function() {
//
//	},

/**
* Called when the Controller is destroyed. Use this one to free resources and finalize activities.
* @memberOf ui.payroll.pages.ruleConfig
*/
//	onExit: function() {
//
//	}

});