package org.example.mediator;

import javafx.scene.control.Label;

public class CustomLabel extends Label implements UIControl {

	private UIMediator mediator;
	
	public CustomLabel(UIMediator mediator) {
		this.mediator = mediator;
		this.setText("Label");
		this.mediator.register(this);
	}
	
	@Override
	public void controlChanged(UIControl control) {
		this.setText(control.getControlValue());
	}

	@Override
	public String getControlValue() {
		return getText();
	}

	@Override
	public String getControlName() {
		return "Label";
	}

	
}
