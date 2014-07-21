jQuery.sap.includeStyleSheet("ui/payroll/css/ruleEditor.css");
sap.ui.core.Control.extend("jpy.ui.RuleEditorRow",{
	
	_formulaInput: null,
	
	metadata:{
		properties:{
			"enabled":{type:"boolean", defaultValue:true},
			"sequence":"int",
			"formula":"string",
			"width":{
				type:"string",
				defaultValue: "100%"
			},
			"height":{
						type:"string",
						defaultValue:"30px"
			}
		}
	},
	
	init: function(){
		this._formulaInput = new sap.ui.commons.TextField({
			width:"100%",
			height:"100%",
			editable :false
		});
	},
	renderer: function(oRm,oCtrl){ 
		oRm.write("<div class='rule_editor_row' style='background:#ccc'");
		oRm.writeControlData(oCtrl);
		oRm.addStyle("width",oCtrl.getWidth());
		oRm.addStyle("height",oCtrl.getHeight());
		oRm.writeStyles();
		oRm.write(">");
		
		oRm.write("<div class='rule_row_seq' style='width:10%;min-width:30px;height:100%;float:left;text-align:left;'>");
		oRm.write("<span>");
		oRm.write(oCtrl.getSequence());
		oRm.write("</span>");
		oRm.write("</div>");
		
		oRm.write("<div class='rule_row_content' style='width:69%;height:100%;float:left'>");
		oCtrl._formulaInput.setValue(oCtrl.getFormula());
		oRm.renderControl(oCtrl._formulaInput);
		oRm.write("</div>");
		
		oRm.write("<div class='rule_row_btn' style='width:20%,height:100%;float:left;text-align:left'>");
		oRm.write("<a href='#'>Edit</a>");
		oRm.write("<a href='#'>Remove</a>");
		oRm.write("</div>");
		
		oRm.write("</div>");
	}
});