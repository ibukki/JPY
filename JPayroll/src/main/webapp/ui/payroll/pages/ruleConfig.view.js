sap.ui.jsview("ui.payroll.pages.ruleConfig", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf ui.payroll.pages.ruleConfig
	*/ 
	getControllerName : function() {
		return "ui.payroll.pages.ruleConfig";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf ui.payroll.pages.ruleConfig
	*/ 
	createContent : function(oController) {
		var oPanel = new sap.ui.commons.Panel({
			text:"Maintain Rule Configs",
			width:"960px",
			height:"500px"
		});
		
		var oMatrix = new sap.ui.commons.layout.MatrixLayout();
		var oLabel = new sap.ui.commons.Label({
			text:"Rule Name"
		});
		var oInput = new sap.ui.commons.TextField("i_rule_name", {});
		var oButton = new sap.ui.commons.Button("btn_rule_name",{
			text:"Import Rule Name"
		});
		oMatrix.createRow(oLabel, oInput, oButton);
		
		oPanel.addContent(oMatrix);
		
		
		var oRowRepeater = new sap.ui.commons.RowRepeater("rule_editor",{
			numberOfRows:9999,
			title: new sap.ui.core.Title({text:"Rule Editor", tooltip:"Rule editor"}),
			fixedRowHeight:"30px"
		});
		
		var row1 = new jpy.ui.RuleEditorRow({
			sequence:1,
			formula: "a = b + c"
		});
		oRowRepeater.addRow(row1);
		var row2 = new jpy.ui.RuleEditorRow({
			sequence:2,
			formula: "d = a + 5 * 10"
		});
		oRowRepeater.addRow(row2);
		oPanel.addContent(oRowRepeater);
		
		oButton = new sap.ui.commons.Button({
			text:"Add",
			press:function(){
				oController.addFormulaLine();
			}
		});
		oPanel.addContent(oButton);
		return oPanel;
	}

});
