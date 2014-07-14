sap.ui.jsview("ui.payroll.pages.wageType", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf ui.payroll.pages.wageType
	*/ 
	getControllerName : function() {
		return "ui.payroll.pages.wageType";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf ui.payroll.pages.wageType
	*/ 
	createContent : function(oController) {
		var oPanel = new sap.ui.commons.Panel({
			text:"Maintain Wage Types",
			width:"700px",
			height:"500px"
		});
		var oWageTable = tableAssist.createTable({
			id:"tb_wagetype",
			visibleRowCount:10,
			columns:[
			         {label:"Wage Type ID", path:"{wageTypeId}", type:"input"},
			         {label:"Sequence", path:"{sequence}", type:"input"},
			         {label:"Begin Date", path:"{begdaString}", type:"date",width:"130px"},
			         {label:"End Date", path:"{enddaString}", type:"date", width: "130px"},
			         {label:"Amount", path:"{amount}" , type:"input"},
			         {label:"Count", path:"{count}",  type:"input"},
			         {label:"Currency", path:"{currency}" ,  type:"input"}
			        ],
			buttons:[new sap.ui.commons.Button({
				text:"Add",
				press:function(){oController.addWagetype();}
			}), new sap.ui.commons.Button({
				text:"Delete",
				press:function(){oController.DeleteWageType();}
			})]
		});
		oPanel.addContent(oWageTable);
		return oPanel;
	}

});
