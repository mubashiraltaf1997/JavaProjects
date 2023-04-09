package cus1126;

public class emailMessage {
    String messageID, to, subject, body, Date;
    emailMessage Next;

    public static emailMessage head = null;
    public static emailMessage tail = null;

    public static void addEmail(String mID, String t, String s, String b, String d) {
        emailMessage newEmail = new emailMessage();
        newEmail.messageID = mID;
        newEmail.to = t;
        newEmail.subject = s;
        newEmail.body = b;
        newEmail.Date = d;
        if (head == null) {
            head = newEmail;
            tail = newEmail;
        } else {
            tail.Next = newEmail;
            tail = newEmail;
        }
    }

    public static void displayList() {
        emailMessage current = head;
        while (current != null) {
            System.out.println("Message ID: " + current.messageID + "\nTo: " + current.to + "\nSubject: " +
                    current.subject + "\nDate: " + current.Date + "\nBody: " + current.body + "\n");
            current = current.Next;
        }
    }

    public static void searchByID(String mID) {
        emailMessage current = head;
        boolean found = false;
        while (current != null) {
            if (current.messageID.equalsIgnoreCase(mID)) {
                System.out.println("Message ID: " + current.messageID + "\nTo: " + current.to + "\nSubject: " +
                        current.subject + "\nDate: " + current.Date + "\nBody: " + current.body + "\n");
                found = true;
            }
            current = current.Next;
        }
        if (!found) {
            System.out.println("No email found with Message ID: " + mID);
        }
    }

    public static void searchBySubject(String s) {
        emailMessage current = head;
        boolean found = false;
        while (current != null) {
            if (current.subject.equalsIgnoreCase(s)) {
                System.out.println("Message ID: " + current.messageID + "\nTo: " + current.to + "\nSubject: " +
                        current.subject + "\nDate: " + current.Date + "\nBody: " + current.body + "\n");
                found = true;
            }
            current = current.Next;
        }
        if (!found) {
            System.out.println("No email found with Subject: " + s);
        }
    }

    public static void searchByRecipient(String r) {
        emailMessage current = head;
        boolean found = false;
        while (current != null) {
            if (current.to.equalsIgnoreCase(r)) {
                System.out.println("Message ID: " + current.messageID + "\nTo: " + current.to + "\nSubject: " +
                        current.subject + "\nDate: " + current.Date + "\nBody: " + current.body + "\n");
                found = true;
            }
            current = current.Next;
        }
        if (!found) {
            System.out.println("No email found with recipient: " + r);
        }
    }

    public static void deleteByEmailID(String id) {
        emailMessage current = head;
        emailMessage prev = null;

        if (head == null) {
            System.out.println("Can't delete from an empty list.");
            return;
        }

        if (current != null && current.messageID.equalsIgnoreCase(id)) {
            head = current.Next;
            System.out.println("Email message with ID " + id + " has been deleted.");
            return;
        }

        while (current != null && !current.messageID.equalsIgnoreCase(id)) {
            prev = current;
            current = current.Next;
        }

        if (current == null) {
            System.out.println("Email message with ID " + id + " not found.");
            return;
        }

        prev.Next = current.Next;
        System.out.println("Email message with ID " + id + " has been deleted.");
    }
}