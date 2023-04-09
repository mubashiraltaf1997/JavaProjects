package cus1126;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------Task-1----------");
        // Creating a sample linked list
        StudentList.addStudent("Alice", "001", 90);
        StudentList.addStudent("Bob", "002", 80);
        StudentList.addStudent("Charlie", "003", 70);
        StudentList.addStudent("Dave", "004", 60);
        StudentList.addStudent("Eve", "005", 50);
        StudentList.addStudent("Frank", "006", 40);
        StudentList.addStudent("Grace", "007", 30);
        StudentList.addStudent("Anna", "008", 20);
        StudentList.displayList();
        // Checking if the linked list is sorted in descending order
        boolean isDescending = StudentList.isDescending(StudentList.head);
        System.out.println("Is linked list sorted in descending order: " + isDescending);


        System.out.println("\n----------Task-2----------");
        // Setting the data in the 6th node of the linked list to 8
        StudentList.setDataIn6thNode(8);
        StudentList.displayList();


        System.out.println("\n----------Task-3----------");
        // Converting an array to a linked list
        int[] arr = {10, 20, 30, 40, 50};
        CUS1126_Student head = StudentList.arrayToList(arr);
        // Printing the resulting linked list
        System.out.println("Converted array to linked list:");
        CUS1126_Student current = head;
        while (current != null) {
            System.out.print(current.exam1score + " -> ");
            current = current.link;
        }
        System.out.println("null");


        System.out.println("\n----------Task-4----------");

        emailMessage emailMessageList = new emailMessage();
        // creating a sample email message linked list
        emailMessageList.addEmail("1", "John", "Question About Project", "Hi Jack, I had a quick question about the project. Can we chat for a few minutes when you have time?", "2022-03-23");
        emailMessageList.addEmail("2", "Jane", "Meeting", "Meeting at 2pm", "2022-03-22");
        emailMessageList.addEmail("3", "Alex", "Reminder", "Don't forget to submit the report", "2022-03-25");
        emailMessageList.addEmail("4", "John", "Feedback", "Here's your performance review", "2022-03-21");
        emailMessageList.addEmail("5", "Alice", "Vacation", "Out of office reply", "2022-03-24");
        emailMessageList.addEmail("6", "Bob", "Invoice", "Payment due for services rendered", "2022-03-26");

        // display the current email message list
        System.out.println("Current email message list:");
        emailMessageList.displayList();

        // search for a message by message ID
        String searchID = "2";
        System.out.println("\nSearching for message with ID " + searchID + ":");
        emailMessageList.searchByID(searchID);

        // search for a message by subject
        String searchSubject = "Reminder";
        System.out.println("\nSearching for messages with subject " + searchSubject + ":");
        emailMessageList.searchBySubject(searchSubject);

        // search for messages by recipient
        String searchRecipient = "John";
        System.out.println("\nSearching for messages with recipient " + searchRecipient + ":");
        emailMessageList.searchByRecipient(searchRecipient);

        // delete a message by message ID
        String deleteID = "4";
        System.out.println("\nDeleting message with ID " + deleteID + ":");
        emailMessageList.deleteByEmailID(deleteID);

        // display the updated email message list
        System.out.println("\nUpdated email message list:");
        emailMessageList.displayList();
    }
}
