package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException();

		if (isEmpty()) {
			this.tail = 0;
			this.head = 0;
		} else {
			this.tail = (tail + 1) % this.array.length;
		}

		this.elements++;
		this.array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();

		T aux = this.array[head];
		this.head = (head + 1) % this.array.length;
		this.elements--;
		return aux;
	}

	@Override
	public T head() {
		if (isEmpty())
			return null;
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == array.length;
	}
}

