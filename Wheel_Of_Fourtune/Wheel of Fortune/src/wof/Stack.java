package wof;
//making the Stack class using the method taught in the course
class Stack implements Stackinter {
	private int top;
	private Object[] value;
	Stack (int capacity){
		value = new Object[capacity];
		top=-1;
	}
		
	
	public void push(Object data) {
		if(isFull())
			System.out.println("Stack overflow");
		else {
			top++;
			value[top]=data;
		}
	}
	public Object pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
			Object retData = value[top];
			top--;
			return retData;
		}
		
	}
	
	public Object peek() {
		
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return null;
		}
		else {
			return value[top];
		}
	}
	public boolean isEmpty() {
		
		return (top==-1);
	}
	public boolean isFull() {
		
		return (top + 1 == value.length);
	}
	public int size() {
		
		return top+1;
	}
	

}
