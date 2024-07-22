public class LinkedList<Integer> {
    private Node<Integer> head;

    public Node<Integer> getHead() {
        return head;
    }

    public void setHead(Node<Integer> head) {
        this.head = head;
    }

    public LinkedList(Node<Integer> head) {
        this.head = head;
    }

    public LinkedList() {
    }
    public void addLast(Integer data){
        if(head == null){
            head = new Node<>(data,null);
        }else {
            Node<Integer> newNode = new Node<>(data,null);
            Node<Integer> tmp = head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
        }
    }

    public int size(){
        int count = 0;

        while(head != null){
            head = head.getNext();
            count++;
        }
        return count;
    }


}
