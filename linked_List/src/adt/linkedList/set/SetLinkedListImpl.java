package adt.linkedList.set;

import adt.linkedListInterative.SingleLinkedListImpl;
import adt.linkedListInterative.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

   @Override
   public void removeDuplicates() {
      SingleLinkedListNode<T> aux1 = this.head;

      while (!aux1.isNIL()) {

         SingleLinkedListNode<T> aux2 = aux1.getNext();

         while (!aux2.isNIL()) {
            if (aux1.getData().equals(aux2.getData())) {
               this.remove(aux2.getData());
            }
            aux2 = aux2.getNext();
         }

         aux1 = aux1.getNext();

      }
   }

   @Override
   public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
      SetLinkedList<T> setUnion = otherSet;

      SingleLinkedListNode<T> aux = this.head;

      while (!aux.isNIL()) {
         if (setUnion.search(aux.getData()) == null) {
            setUnion.insert(aux.getData());
         }
         aux = aux.getNext();
      }

      setUnion.removeDuplicates();

      return setUnion;
   }

   @Override
   public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
      SetLinkedList<T> setInter = new SetLinkedListImpl<>();

      SingleLinkedListNode<T> aux = this.head;

      while (!aux.isNIL()) {
         if (otherSet.search(aux.getData()) != null) {
            setInter.insert(aux.getData());
         }
         aux = aux.getNext();
      }

      setInter.removeDuplicates();

      return setInter;
   }

   @Override
   public void concatenate(SetLinkedList<T> otherSet) {
      SingleLinkedListImpl<T> newList = new SingleLinkedListImpl<T>();

      T[] other = otherSet.toArray();

      for (int i = 0; i < other.length; i++) {
         newList.insert(other[i]);

      }

      SingleLinkedListNode<T> last = this.head;

      while (!last.getNext().isNIL()) {
         last = last.getNext();
      }

      last.setNext(newList.getHead());
   }

}
