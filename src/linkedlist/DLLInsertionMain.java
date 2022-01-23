package linkedlist;
/*이중 연결 리스트는 단일 연결 리스트와 다르게 두 개의 포인터를 사용한다.
 * 추가적으로 자신의 이전 노드를 가리키는 prev변수가 추가되었다.
 * getValue()는 단일 연결 리스트와 동일한 노드의 값을 가져오기 위한 메서드이다.
 * printAll 메서드도 단일 연결 리스트와 출력될 화살표가 다를뿐 로직은 동일하다.
 * 이중 연결리스트의 장점은 검색을 통해서 노드를 가져오고 해당 노드의 앞 노드를 출력하는 메서드이다. 
 */


public class DLLInsertionMain {
public static void main(String[]args) {
	DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
	doubleLinkedList.append(1);
	doubleLinkedList.append(3);
	doubleLinkedList.append(2);
	doubleLinkedList.append(20);
	doubleLinkedList.append(19);
	System.out.println("이중 연결 리스트: ");
	doubleLinkedList.printAll();
	doubleLinkedList.printPrevNode(2);
	doubleLinkedList.printPrevNode(1);
	doubleLinkedList.printPrevNode(19);
}
}
