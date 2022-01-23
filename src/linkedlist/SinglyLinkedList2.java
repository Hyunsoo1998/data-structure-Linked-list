package linkedlist;

public class SinglyLinkedList2 {
private Node head;

SinglyLinkedList2() {
	this.head =null;
}
SinglyLinkedList2(int value) {
	this.head = new Node(value,null);
}
class Node {
	private int value; //값
	private Node next; //포인터
	
Node(int value , Node next) {
	this.value = value;
	this.next=next;
}
	
	
public int getValue() {
	return this.value;
}
}
public Node getHead() {
	return this.head;
}
/* 단일 연결 리스트 끝에 노드를 추가 
 * @param value */
public void append(int value) {
	if(this.head== null) {
		this.head = new Node(value,null);
		return;
	}
	Node pointer = this.head;
	while(pointer.next != null) {
		pointer = pointer.next;
	}
	pointer.next = new Node(value,null);
}
/* 인지 값으로 같은 노드 삭제
 * @param value
 */

/*pointer 변수를 생성함과 동시에 head 로 초기화 한다. 노드 검색을 하기 전 head와 같은곳을 가리키고 있는
 * pointer의 데이터 값이 인자와 같은지 확인한다. 만약 첫 노드와 값이 같으면 현재 head를 removeNode 변수에 담고
 * head 는 head.next로 재할당 받아 다음 노드가 연결 리스트의 head가 된다. 그런 다음 removeNode 는 null로 초기화하여
 * 노드를 제거한다.
 * 삭제 대상 노드가 head가 아닌 경우 반복문을 호출한다. 여기서 반복문을 호출하기전 temp변수 를 pointer 값으로 할당해 주었는데
 * 삭제될 노드의 앞 노드를 저장할 변수이다. 반복문이 끝나면 pointer 변수에는 삭제될 노드가,
 * temp변수는 pointer의 앞 노드가 된다. 만약에 pointer가 마지막 노드이면 if(pointer.next==null)을 타고 temp변수의 포인터가
 * null을 가리켜 마지막 노드가 temp가 된다. pointer 노드가 중간 노드일 경우는 pointer가 가리키고 있는 다음 노드를 temp 노드가 가리켜
 * pointer의 연결을 끊고 null로 초기화 해 준다.

*/
public void delete(int value) {
	Node pointer = this.head;
	//첫 노드의 값이 인자 값과 같으면
	if(pointer.getValue() == value) {
	Node removeNode = this.head;
	this.head = this.head.next;
	
	removeNode = null;
	return;
	}
	Node temp = pointer;
	//포인터 변수가 null이 아니면서 인자 값과 달라질 때 까지 반복
	while(pointer != null && pointer.getValue() != value) {
		temp = pointer;
		pointer = pointer.next;
	}
	//마지막 노드를 삭제하는 경우
	
	if(pointer.next == null) {
		temp.next = null;
	}else {
		temp.next = pointer.next;		
	}
	pointer = null;
}
// 모든 노드 출력
public void printAll() {
	Node pointer = this.head;
	
	StringBuilder builder = new StringBuilder();
	while(pointer.next!= null) {
		builder.append(pointer.getValue());
		builder.append("->");
		pointer = pointer.next;		
	}
	builder.append(pointer.getValue());
	System.out.println(builder.toString());
}
/*노드를 삭제하는 메서드가 추가 되었다. 삭제할 데이터를 연결 리스트에서 검색하여 찾아 노드를 삭제한 후
연결 리스트의 조건을 만족할 수 있도록 포인터들의 조정이 필요하다.
첫 노드를 지웠을 때, 중간 노드를 지웠을때, 마지막 노드를 지웠을 때 총 3가지의 케이스가 고려되어야 한다.
*/




}
