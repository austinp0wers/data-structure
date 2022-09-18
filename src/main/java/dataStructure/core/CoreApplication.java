package dataStructure.core;

import dataStructure.core.binarytree.BinarySearchTree;

import dataStructure.core.binarytree.Tree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);

		Tree <Integer> bst = new BinarySearchTree<>();
		bst.insert(10).insert(20).insert(30).insert(40).insert(50).insert(60);
		bst.traverse();

		System.out.println("Max is: " + bst.getMax());
		System.out.println("Min is: " + bst.getMin());

		System.out.println("Deleting 60 from Tree");
		bst.delete(60);
		System.out.println("New Max is: " + bst.getMax());
		bst.traverse();
	}
}
