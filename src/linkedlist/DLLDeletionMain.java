package linkedlist;

public class DLLDeletionMain {
public static void main(String[]args) {
	DoubleLinkedList2 doubleLinkedList = new DoubleLinkedList2();
	doubleLinkedList.append(1);
	doubleLinkedList.append(3);
	doubleLinkedList.append(2);
	doubleLinkedList.append(20);
	doubleLinkedList.append(19);

System.out.println("원본 이중 연결 리스트: ");
doubleLinkedList.printAll();

doubleLinkedList.delete(1);
System.out.println("노드 1을 삭제한 이중 연결 리스트: ");
doubleLinkedList.printAll();

doubleLinkedList.delete(2);
System.out.println("노드 2를 삭제한 이중 연결 리스트: ");
doubleLinkedList.printAll();

doubleLinkedList.delete(19);
System.out.println("노드 19를 삭제한 이중 연결 리스트: ");
doubleLinkedList.printAll();
}
}
