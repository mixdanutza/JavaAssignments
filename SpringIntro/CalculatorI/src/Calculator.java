
public class Calculator  {
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double result;
	
	public Calculator(double operandOne, String operation, double operandTwo ) {
		setOperandOne(operandOne);
		setOperation(operation);
		setOperandTwo(operandTwo);
		System.out.println("Everything was set.");
	}
	
	
	private double getOperandOne() {
		return operandOne;
	}
	private void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	private String getOperation() {
		return operation;
	}
	private void setOperation(String operation) {
		this.operation = operation;
	}
	private double getOperandTwo() {
		return operandTwo;
	}
	private void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public void performOperation(Calculator obj) {
		 if(obj.getOperation()=="+") {
			 result=obj.getOperandOne()+obj.getOperandTwo();
		 }
		 else if(obj.getOperation()=="-") {
			 result=obj.getOperandOne()-obj.getOperandTwo();
		 }
		 else{
			 System.out.println("Incorrect Operration");
		 }	 
		 System.out.println("Operation performed");
	}
	
	public double getResults(Calculator obj){
		performOperation(obj);
		System.out.println("result is: "+result);
		return result;
	}
	
	
}
