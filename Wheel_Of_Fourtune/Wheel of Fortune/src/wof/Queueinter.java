package wof;
//making the Queue interface using the method taught in the course
interface Queueinter {
	void enqueue (Object value);
	Object dequeue();
	Object peek();
	boolean isEmpty();
	boolean isFull();
	int size();

}
