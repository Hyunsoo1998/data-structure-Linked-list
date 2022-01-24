package linkedlist;

public class CLLInsertionMain {
public static void main(String[]args) {
	CircularLinkedList circularLinkedList = new CircularLinkedList();
	circularLinkedList.append(11);
	circularLinkedList.append(9);
	circularLinkedList.append(27);
	circularLinkedList.append(41);
	circularLinkedList.append(3);

	System.out.println("원형 단일 연결 리스트: ");
	circularLinkedList.printAll();
}
}
