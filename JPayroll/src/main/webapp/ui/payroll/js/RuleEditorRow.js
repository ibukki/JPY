jQuery.sap.includeStyleSheet("ui/payroll/css/ruleEditor.css");
sap.ui.core.Control.extend("jpy.ui.RuleEditorRow",{
	
	_formulaInput: null,
	
	metadata:{
		properties:{
			"enabled":{type:"boolean", defaultValue:true},
			"sequence":"int",
			"formula":"string",
			"editMode":{type:"boolean", defaultValue:false},
			"width":{
				type:"string",
				defaultValue: "100%"
			},
			"height":{
				type:"string",
				defaultValue:"30px"
			}
		},
		events:{
			edit:{}
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
		oRm.write("<div class='rule_editor_row'");
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
		oRm.write("<a href='javascript:void(0)' onclick='sap.ui.getCore().byId(\""+oCtrl.getId()+"\").editFormula()'>Edit</a>");
		oRm.write("<a href='javascript:void(0)' onclick='sap.ui.getCore().byId(\""+oCtrl.getId()+"\").removeFormula()'>Remove</a>");
		oRm.write("</div>");
		
		oRm.write("</div>");
	},
	
	editFormula: function(){
		if(this.editMode){
			this.editMode = false;
		}else{
			this.editMode = true;
		}
		if(sap.ui.getCore().byId("dialog_edit_formula") != null){
			sap.ui.getCore().byId("dialog_edit_formula").destroy();
		}
		var oDialog = new sap.ui.commons.Dialog("dialog_edit_formula", {
			title:"Edit formula",
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
														value:this.getFormula(),
														width:"100%"}));
		oDialog.addContent(oMatrix);
		oDialog.open();
	},
	
	removeFormula:function(){
		
	},
	
	onAfterRendering:function(){
		
	}
});