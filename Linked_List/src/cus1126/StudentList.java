package cus1126;

public class StudentList {
    public static CUS1126_Student head = null;
    public static CUS1126_Student tail = null;

    public static void addStudent(String n, String x, double p) {
        CUS1126_Student newStudent = new CUS1126_Student(n, x, p);
        //if list is empty
        if (head == null) {
            head = newStudent;
            tail = newStudent;
        } else {
            tail.link = newStudent;
            tail = newStudent;
        }
    }

    public static void displayList() {
        CUS1126_Student current = head;
        while (current != null) {
            System.out.print("" + current.name + "->");
            current = current.link;
        }
        System.out.println("");
    }

    /*public static void displayList() {
        CUS1126_Student current = head;
        while (current != null) {
            System.out.println("Name: " + current.name + ", Xnumber: " + current.Xnumber + ", Exam1 score: " + current.exam1score);
            current = current.link;
        }
    }*/


    public static void Search(String Xnum) {
        CUS1126_Student current = head;
        while (current != null) {
            if (current.Xnumber.equalsIgnoreCase(Xnum)) {
                System.out.print("Found Student: " + current.name + " pts:" + current.exam1score);
            }
            current = current.link;
        }

    }

    public static void rewriteTail() {
        CUS1126_Student current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase("Christopher")) {
                current.name = "Nikhil";
            }
            current = current.link;
        }
    }


    public static void deleteStudent(String target) {
        CUS1126_Student current = head;
        CUS1126_Student previous = null;

        //if list is empty
        if (head == null) {
            System.out.println("CAN'T DELETE FROM EMPTY LIST");
            return;
        }

        //item to delete is at head
        if (current != null && current.Xnumber.equals(target)) {
            head = current.link;
            return;
        }

        //item is anywhere else in the list

        while (current != null && !current.Xnumber.equals(target)) {
            previous = current; //maintains a one-step distance behind the current reference
            current = current.link;
        }

        if (current == null) {
            return;
        }

        previous.link = current.link;

    }

    public static boolean isDescending(CUS1126_Student current) {
        // base cases
        if (current == null || current.link == null) {
            return true;
        }

        // recursive case
        if (current.exam1score < current.link.exam1score) {
            return false;
        } else {
            return isDescending(current.link);
        }
    }

    public static void setDataIn6thNode(int data) {
        CUS1126_Student current = head;
        int count = 1;
        int numNodes = 0;

        while (current != null) {
            numNodes++;
            current = current.link;
        }

        if (numNodes < 6) {
            System.out.println("List does not have a 6th node");
        } else {
            current = head;
            count = 1;
            while (count < 6) {
                current = current.link;
                count++;
            }
            current.exam1score = data;
            System.out.println("Data in 6th node set to " + data);
        }
    }


    public static CUS1126_Student arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Create a new linked list with the first element of the array
        CUS1126_Student head = new CUS1126_Student(Integer.toString(arr[0]), "", arr[0]);
        CUS1126_Student current = head;

        // Traverse the array and add each element to the linked list
        for (int i = 1; i < arr.length; i++) {
            CUS1126_Student newStudent = new CUS1126_Student(Integer.toString(arr[i]), "", arr[i]);
            current.link = newStudent;
            current = newStudent;
        }

        return head;
    }

}


