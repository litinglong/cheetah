package com.silva.chetax.demo.design.patterns.structural.decorator;

/**
 * 具体装饰角色
 * @author Administrator
 *
 */
public class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component component) {
		super(component);
	}

	public void operation() {
		super.operation();
		addedFunction();
	}

	public void addedFunction() {
		System.out.println("为具体构件角色增加额外的功能addedFunction()");
	}
}
