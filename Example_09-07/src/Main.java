import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Node<Integer>> list = new LinkedList<>();

        Node<Integer> node1 = new Node<>(1,null);
        Node<Integer> node2 = new Node<>(2,null);
        Node<Integer> node3 = new Node<>(3,null);
        Node<Integer> node4 = new Node<>(4,null);
        Node<Integer> node5 = new Node<>(5,null);
        Node<Integer> node6 = new Node<>(6,null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        Node<Integer> head =node1;
        list.addLast(node1);
        list.addLast(node2);
        list.addLast(node3);
        list.addLast(node4);
        list.addLast(node5);
        list.addLast(node6);
        int n = list.size();

        int i=0;
            while(true){
                head = head.getNext();
                i++;
                if(i == n/2){
                    System.out.println(head.getData());
                    break;
                }
            }
    }
}