package org.example.mediator;


public class Slider extends javafx.scene.control.Slider implements UIControl {

	private UIMediator mediator;
	private boolean mediatedUpdate;
	
	public Slider(UIMediator mediator) {
		this.mediator = mediator;
		this.setMin(0);
		this.setMax(100);
		this.setValue(50);
		this.mediator.register(this);
		
		this.valueProperty().addListener((v, o, n) -> {
			if (!mediatedUpdate) {
				this.mediator.valueChanged(this);
			}
		});
	}
	
	@Override
	public void controlChanged(UIControl control) {
		mediatedUpdate = true;
		this.setValue(Double.parseDouble(control.getControlValue()));
		mediatedUpdate = false;
	}

	@Override
	public String getControlName() {
		return "Slider";
	}

	@Override
	public String getControlValue() {
		return Double.toString(getValue());
	}
	

}
