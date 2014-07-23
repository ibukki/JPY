sap.ui.jsview("ui.payroll.pages.paramConfig", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf ui.payroll.pages.paramConfig
	*/ 
	getControllerName : function() {
		return "ui.payroll.pages.paramConfig";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf ui.payroll.pages.paramConfig
	*/ 
	createContent : function(oController) {
		
		var oPanel = new sap.ui.commons.Panel({
			text:"Parameters Config"
		});
		
		var oMatrix = new sap.ui.commons.layout.MatrixLayout({	
		});
		var oLabel = new sap.ui.commons.Label({
			text:"Schema ID"
		});
		var oInput = new sap.ui.commons.TextField("i_schema_id",{
			value:""
		});
		oMatrix.createRow(oLabel, oInput);
		oPanel.addContent(oMatrix);
		
		oMatrix = new sap.ui.commons.layout.MatrixLayout({
			columns:2
		});
		
		var oInputTable = tableAssist.createTable({
			id:"tb_input",
			visibleRowCount:10,
			columns:[
			         {label:"Name", path:"{name}", type:"input"},
			         {label:"Category", path:"{category}", type:"input"},
			         {label:"Type", path:"{type}",width:"130px"}
			        ],
			buttons:[new sap.ui.commons.Button({
				text:"Add",
				press:function(){oController.addInputParam();}
			}), new sap.ui.commons.Button({
				text:"Delete",
				press:function(){oController.deleteInputParam();}
			}),new sap.ui.commons.Button({
				text:"Import",
				press:function(){oController.importInputParam();}
			}),new sap.ui.commons.Button({
				text:"Export",
				press:function(){oController.exportInputParam();}
			})]
		});
		
		
		var oOutputTable = tableAssist.createTable({
			id:"tb_output",
			visibleRowCount:10,
			columns:[
			         {label:"Name", path:"{name}", type:"input"},
			         {label:"Category", path:"{category}", type:"input"},
			         {label:"Type", path:"{type}",width:"130px"}
			        ],
			buttons:[new sap.ui.commons.Button({
				text:"Add",
				press:function(){oController.addOutputParam();}
			}), new sap.ui.commons.Button({
				text:"Delete",
				press:function(){oController.deleteOutputParam();}
			}),new sap.ui.commons.Button({
				text:"Import",
				press:function(){oController.importOutputParam();}
			}),new sap.ui.commons.Button({
				text:"Export",
				press:function(){oController.ExportOutputParam();}
			})]
		});
		
		oMatrix.createRow(oInputTable, oOutputTable);
		oPanel.addContent(oMatrix);
		return oPanel;
	}

});
