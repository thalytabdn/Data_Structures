package adt.stack;

import adt.linkedList.SingleLinkedListNode;

/**
 * Classe que representa um apilha implementada usando-se um noh de uma lista
 * simplesmente ligada, como estrutura sobrejacente.
 * 
 * Restricoes: - voce DEVE obedecer a politica de acesso e complexidade dos
 * metodos de pilha, ou seja, todos em O(1). - voce NÃO pode usar memoria extra
 * (estrutura auxiliar) - qualquer metodo auxiliar que voce necessite DEVE ser
 * implementado nesta classe - voce NÃO pode modificar a classe
 * SingleLinkedListNode
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class StackLinkedListNodeImpl<T> implements Stack<T> {

	private SingleLinkedListNode<T> top;
	private int size;

	/**
	 * A pilha para ser criada precisa ter um tamanho maximo
	 * 
	 * @param tamanhoMaximo
	 */
	public StackLinkedListNodeImpl(int tamanhoMaximo) {
		this.top = new SingleLinkedListNode<T>();
		this.size = tamanhoMaximo;

	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull()) {
			if (element != null) {
				SingleLinkedListNode<T> newElem = new SingleLinkedListNode<T>(element, top);
				this.top = newElem;
			}
		} else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T removed = this.top();
		if (!isEmpty()) {
			this.top = top.getNext();
		} else {
			throw new StackUnderflowException();
		}

		return removed;

	}

	@Override
	public T top() {
		return this.top.getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.getData() == null;
	}

	@Override
	public boolean isFull() {
		boolean result = false;

		if (this.top == null) {
			result = true;
		} else {
			SingleLinkedListNode<T> aux = this.top;
			int cont = 0;

			while (!aux.isNIL()) {
				cont++;
				if (cont >= this.size) {
					return true;
				}
				aux = aux.getNext();
			}
		}

		return result;

	}

}