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
		oRm.write("<div class='rule_editor_row' ");
		oRm.writeControlData(oCtrl);
		oRm.addStyle("width",oCtrl.getWidth());
		oRm.addStyle("height",oCtrl.getHeight());
		oRm.writeStyles();
		oRm.write(">");
		
		oRm.write("<div class='rule_row_seq' style='width:30%;min-width:30px;height:100%;float:left;text-align:center;'>");
		oRm.writeEscaped(oCtrl.getSequence());
		oRm.write("</div>");
		
		oRm.write("<div class='rule_row_content' style='width:69%;height:100%;float:left'>");
		this._formulaInput.setId(oCtrl.getId() + "_formula");
		this._formulaInput.setValue(oCtrl.getFormula());
		oRm.renderControl(this._formulaInput);
		oRm.write("</div>");
		
		oRm.write("</div>");
	}
});