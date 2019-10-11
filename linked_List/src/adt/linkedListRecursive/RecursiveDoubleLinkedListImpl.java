package adt.linkedListRecursive;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				RecursiveDoubleLinkedListImpl<T> nil = new RecursiveDoubleLinkedListImpl<>();
				;
				this.next = nil;
				nil.previous = this;
				if (this.previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<>();
				}
			} else {
				this.next.insert(element);
			}

		}
	}

	@Override
	public void remove(T element) {
		if (this.isEmpty()) {

		} else {
			if (this.data.equals(element)) {
				if (this.next.isEmpty() && this.previous.isEmpty()) {
					this.data = null;
					this.previous = null;
					this.next = null;
				} else {
					this.data = this.next.getData();
					this.next = this.next.getNext();

					if (this.next != null) {
						((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
					}
				}
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (this.isEmpty()) {
			this.data = element;
			RecursiveDoubleLinkedListImpl<T> nil = new RecursiveDoubleLinkedListImpl<>();
			this.next = nil;
			nil.previous = this;
		} else {
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<T>(this.data, this.next, this);
			this.data = element;
			this.next = aux;
			this.previous = new RecursiveDoubleLinkedListImpl<T>();

		}
	}

	@Override
	public void removeFirst() {
		if (this.isEmpty()) {

		} else {
			this.data = this.next.data;
			((RecursiveDoubleLinkedListImpl<T>) this.next).removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if (this.isEmpty()) {
			this.previous.previous.next = new RecursiveDoubleLinkedListImpl<T>();

		} else {
			((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}