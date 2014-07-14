var tableAssist = window.tableAssist || {};

tableAssist = {
	load: false,
	createTable : function(xargs){
		var oTable = new sap.ui.table.Table({
			id: xargs.id,
			visibleRowCount:xargs.visibleRowCount || 10,
			selectionMode: xargs.selectionMode || sap.ui.table.SelectionMode.Single,
			selectionBehavior: sap.ui.table.SelectionBehavior.Row
		});
		if(xargs.columns){
			var columnSize = xargs.columns.length;
			for(var i in xargs.columns){
				var oColumn = new sap.ui.table.Column({
					label: new sap.ui.commons.Label({ text: xargs.columns[i].label }),
					template: this.getColumnTemplate(xargs.columns[i]),
					width: xargs.columns[i].width || 1/columnSize * 100 + "%",
				});
				if(xargs.columns[i].sort){
					oColumn.setSortProperty(xargs.columns[i].label);
				}
				oTable.addColumn(oColumn);
			}
		};
		
		if(xargs.buttons){
			var oToolbar = new sap.ui.commons.Toolbar();
			for(var index in xargs.buttons){
				oToolbar.addItem(xargs.buttons[index]);
			}
			oTable.setToolbar(oToolbar);
		}
		
		if(xargs.model){
			var oModel = {};
			oModel.data = xargs.model;
			var oJsonModel = new sap.ui.model.json.JSONModel();
			oJsonModel.setData(oModel);
			oTable.setModel(oJsonModel);
			oTable.bindRows("/data");
		}
		//oTable.setModel(xargs.model);
		return oTable;
	},
	getColumnTemplate : function(column){
		switch (column.type) {
		case "text":
			return new sap.ui.commons.TextView({ text: column.path });
			break;
		case "link":
			return new sap.ui.commons.Link({
				text: column.path,
				press:function(){
					window.open(this.getText());
				}
			});
			break;
		case 'input':
			return new sap.ui.commons.TextField({
				value: column.path,
				editable: column.editable || true
			});
			break;
		case 'button':
			return  new sap.ui.commons.Button({
				text:column.text
			});
			break;
		case 'date':
			return new sap.ui.commons.DatePicker({
				yyyymmdd:column.path
			});
		default:
			return new sap.ui.commons.TextView({ text: column.path });
			break;
		}
	},
	loading:function(){
		this.load = true;
		jQuery("#loading_status_bar").fadeIn();
	},
	loaded : function(){
		var  that = this;
		if(document.getElementById("loading_status_bar") == null){
			setTimeout(function(){
				that.load = false;
				jQuery("#loading_status_bar").fadeOut();
			},500);
		}else{
			this.load = false;
			jQuery("#loading_status_bar").fadeOut();
		}
	}
};