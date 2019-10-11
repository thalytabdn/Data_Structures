package adt.linkedListInterative;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.last = new DoubleLinkedListNode<T>();
		this.head = getLast();
	}

	@Override
	public T search(T element) {
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxLast = getLast();
		T toReturn = null;
		if (element != null && !this.isEmpty()) {
			while (!auxHead.equals(auxLast) && !auxHead.getNext().equals((SingleLinkedListNode<T>)auxLast)
					&& !auxHead.getData().equals(element) && !auxLast.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if (auxHead.getData().equals(element)){
				toReturn = auxHead.getData();
			}
			if (auxLast.getData().equals(element)) {
				toReturn = auxLast.getData();
			}
		}
		return toReturn;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), getLast());
			((DoubleLinkedListNode<T>) node.getNext()).setPrevious(node);
			getLast().setNext(node);
			if (getLast().isNIL()) {
				setHead(node);
			}
			setLast(node);
		}

	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			if(getHead().getData().equals(element)) {
				removeFirst();
			}else if (getLast().getData().equals(element)){
				removeLast();
			} else {
				DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
				DoubleLinkedListNode<T> auxLast = getLast();
				DoubleLinkedListNode<T> node = null;
				while (!auxHead.equals(auxLast) && !auxHead.getNext().equals((SingleLinkedListNode<T>)auxLast)
						&& !auxHead.getData().equals(element) && !auxLast.getData().equals(element)) {
					auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
					auxLast = auxLast.getPrevious();
				}
				if (auxHead.getData().equals(element)){
					node = auxHead;
				}
				if (auxLast.getData().equals(element)) {
					node = auxLast;
				}
				node.getPrevious().setNext(node.getNext());
				((DoubleLinkedListNode<T>) node.getNext()).setPrevious(node.getPrevious());
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.insert(element);
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, null, null);
				newNode.setNext(getHead());
				newNode.setPrevious(((DoubleLinkedListNode<T>) getHead()).getPrevious());
				((DoubleLinkedListNode<T>) getHead()).getPrevious().setNext(newNode);
				((DoubleLinkedListNode<T>) getHead()).setPrevious(newNode);
				setHead(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			((DoubleLinkedListNode<T>) getHead()).getPrevious().setNext(getHead().getNext());
			((DoubleLinkedListNode<T>) getHead().getNext()).setPrevious(((DoubleLinkedListNode<T>) getHead()).getPrevious());
			setHead(getHead().getNext());
			if (getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			getLast().getPrevious().setNext(getLast().getNext());
			((DoubleLinkedListNode<T>) getLast().getNext()).setPrevious(getLast().getPrevious());
			setLast(getLast().getPrevious());
			if (getLast().isNIL()) {
				setHead(getLast());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}