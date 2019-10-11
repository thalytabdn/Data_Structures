package adt.linkedListRecursive;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		if(this.data == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		int size;
		
		if(this.data == null) {
			return 0;
		} else {
			size = 1 + this.next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		if(this.isEmpty()) {
			return null;
		} else {
			if(this.data.equals(element)) {
				return element;
			} else {
				return this.next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<T>();
			} else {
				this.next.insert(element);
			}
			
		}
	}

	@Override
	public void remove(T element) {
		if(this.isEmpty()) {
			
		}else {
			if(this.data.equals(element)) {
				this.data = this.next.getData();
				this.next = this.getNext().getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		this.toArray(result, this, 0);

		return result;
	}
	
private void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {
		
		if(!node.isEmpty()) {
			array[i] = node.data;
			toArray(array, node.next, i+1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}