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
		return new sap.ui.commons.Label({
			text:"Sometime shit happens"
		});
	}

});
